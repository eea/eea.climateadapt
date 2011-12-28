package nl.wur.alterra.cgi.ace.harvester;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import nl.wur.alterra.cgi.ace.geonetwork.GeoNetworkConnector;
import nl.wur.alterra.cgi.ace.geonetwork.GeoNetworkHarvesterResponse;
import nl.wur.alterra.cgi.ace.model.AceItem;
import nl.wur.alterra.cgi.ace.model.WxsHarvester;
import nl.wur.alterra.cgi.ace.model.constants.AceItemType;
import nl.wur.alterra.cgi.ace.model.constants.WxSHarvesterStatus;
import nl.wur.alterra.cgi.ace.portlet.CustomProperties;
import nl.wur.alterra.cgi.ace.portlet.CustomPropertiesNotInitializedException;
import nl.wur.alterra.cgi.ace.search.lucene.ACEIndexSynchronizer;
import nl.wur.alterra.cgi.ace.service.AceItemLocalServiceUtil;
import nl.wur.alterra.cgi.ace.service.WxsHarvesterLocalServiceUtil;
import nl.wur.alterra.cgi.ace.service.persistence.WxsHarvesterUtil;

import java.util.*;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Utility to schedule and to run harvesters.
 *
 * @author heikki doeleman
 */
public class HarvesterUtil {

    /**
     * Initial delay when harvester thread is scheduled.
     * NO LONGER USED - initial delay is now set to equal subsequent delays.
     */
    private static final long initialDelay = 0;
    /**
     * Timeunit for harvester thread scheduling.
     */
    private static final TimeUnit timeUnit = TimeUnit.MINUTES;

    /**
     * Timeout to process harvest execution in ms. TODO what is a good value ?
     */
    private static final long timeOut = 20 * 60 * 1000;

    /**
     * Connector to GeoNetwork.
     */
    private static final GeoNetworkConnector geoNetworkConnector = new GeoNetworkConnector();

    /**
     * Max lenghth of AceItem name, must be in sync with value in tables_adapted.sql. TODO move to utility class
     */
    private static final int aceItemNameLength = 255;
    /**
     * Max lenghth of AceItem keyword, must be in sync with value in tables_adapted.sql. TODO move to utility class
     */
    private static final int aceItemKeywordLength = 2048;

    /**
     * Schedules a thread to periodically execute a harvester.
     * @param wxsHarvester
     */
    public static synchronized void scheduleWxsHarvester(WxsHarvester wxsHarvester) throws SystemException {
        //System.out.println("scheduling harvester " + wxsHarvester.toShortString());
        if(wxsHarvester.getEvery() == 0) {
            //System.out.println("did not schedule harvester " + wxsHarvester.toShortString() + " because it has interval 0. You can still execute it manually.");
            return;
        }

        // check if harvester was saved to GeoNetwork
        if(! isInGeoNetwork(wxsHarvester)) {
            //System.out.println("harvester " + wxsHarvester.toShortString() + " is not saved to GeoNetwork, scheduling canceled.");
            return;
        }

        // remove old scheduledfuture, if it exists
        unScheduleWxsHarvester(wxsHarvester);

        // create new scheduledfuture
        //System.out.println("scheduling harvester " + wxsHarvester.toShortString() + " to run every " + wxsHarvester.getEvery() + " " + timeUnit.toString());
        ScheduledExecutorService executionService = HarvesterExecutionService.getExecutionService();
        ScheduledFuture<?> scheduledFuture = executionService.scheduleWithFixedDelay(new HarvesterThread(wxsHarvester), wxsHarvester.getEvery(), wxsHarvester.getEvery(), timeUnit);
        //System.out.println("finished scheduling harvester " + wxsHarvester.toShortString());
        HarvesterThreadMap.getInstance().add(wxsHarvester, scheduledFuture);
        //System.out.println("added harvester " + wxsHarvester.toShortString() + " to threads map which now contains " + HarvesterThreadMap.getInstance().size());
    }

    /**
     * Cancels and removes a harvester thread.
     * @param wxsHarvester
     */
    public static synchronized void unScheduleWxsHarvester(WxsHarvester wxsHarvester){
        //System.out.println("canceling existing ScheduledFuture for harvester " + wxsHarvester.toShortString());
        if(HarvesterThreadMap.getInstance().containsKey(wxsHarvester)) {
           ScheduledFuture<?> oldScheduledFuture = HarvesterThreadMap.getInstance().get(wxsHarvester);
            oldScheduledFuture.cancel(true);
            HarvesterThreadMap.getInstance().remove(wxsHarvester);
            //System.out.println("canceled existing ScheduledFuture for harvester " + wxsHarvester.toShortString());
        }
        else {
            //System.out.println("could not find existing ScheduledFuture for harvester " + wxsHarvester.toShortString());
        }
    }

    /**
     * Retrieves existing harvesters from the database and schedules them.
     */
    public static synchronized void scheduleHarvesters() {
        //System.out.println("scheduling harvesters");
        try {
            List<WxsHarvester> wxsHarvesters = new ArrayList<WxsHarvester>();
            wxsHarvesters.addAll(WxsHarvesterLocalServiceUtil.getWxsHarvesters(0, WxsHarvesterLocalServiceUtil.getWxsHarvestersCount()));
            //System.out.println("scheduleHarvesters retrieved " + wxsHarvesters.size() + " harvesters to be scheduled");
            for(WxsHarvester wxsHarvester : wxsHarvesters) {
                HarvesterUtil.scheduleWxsHarvester(wxsHarvester);
            }
        }
        // do not block application startup if something goes wrong retrieving harvesters
        catch (SystemException x) {
            System.out.println("ERROR: failed to retrieve harvesters: "+ x.getMessage());
            x.printStackTrace();
        }
        catch(Throwable x) {
            System.out.println("ERROR: failed to retrieve harvesters: "+ x.getMessage());
            x.printStackTrace();
        }
        //System.out.println("finished scheduling havesters");
    }

    /**
     * Requests GeoNetwork to execute a wxsharvester. This is done by first activating the Harvester in GeoNetwork, then
     * requesting the actual execution, and finally de-activating the harvester in GeoNetwork after it has finished.
     *
     * This is intended to keep control of when they are run exclusively in ACE, avoiding the harvesters running in
     * GeoNetwork without request from ACE (even though they should have been saved with OneRunOnly=true so even if
     * activated they should not run periodically without explicit request).
     *
     * For three of the GeoNetwork services requested in this method (xml.harvesting.start, xml.harvesting.run, and
     * xml.havesting.stop) the interface is the same. Requests look like
     *
     * <request>
     *     <id>754</id>
     * </request>
     *
     * and responses look like
     *
     * <response>
     *     <id status="ok">754</id>
     * </response>
     *
     * For the polling requests, used to find out when the harvesting run in GeoNetwork has finished, the requests are
     * like
     *
     * <request>
     *     <id>754</id>
     * </request>
     *
     * and responses are like
     *
     * <node id="754" type="ogcwxs">
     *     <site>
     *         <name>Some Name</name>
     *         <uuid>c7208ddf-54f5-4681-ae59-9bb1c9e83262</uuid>
     *         <account>
     *             <use>true</use>
     *             <username />
     *             <password />
     *         </account>
     *         <url>http://test.com/tst</url>
     *         <ogctype>WMS1.1.1</ogctype>
     *         <icon>default.gif</icon>
     *     </site>
     *     <content>
     *         <validate>false</validate>
     *         <importxslt>none</importxslt>
     *     </content>
     *     <options>
     *         <every>90</every>
     *         <oneRunOnly>true</oneRunOnly>
     *         <status>active</status>
     *         <lang>eng</lang>
     *         <topic>climatologyMeteorologyAtmosphere</topic>
     *         <createThumbnails>true</createThumbnails>
     *         <useLayer>true</useLayer>
     *         <useLayerMd>true</useLayerMd>
     *         <datasetCategory>2</datasetCategory>
     *     </options>
     *     <privileges>
     *         <group id="1">
     *             <operation name="view" />
     *             <operation name="dynamic" />
     *             <operation name="featured" />
     *         </group>
     *     </privileges>
     *     <categories>
     *         <category id="3" />
     *     </categories>
     *     <info>
     *         <lastRun />
     *         <running>false</running>
     *     </info>
     * </node>
     *
     *
     * @param wxsHarvester harvester to run
     */
    public static synchronized void executeWxsHarvester(WxsHarvester wxsHarvester) throws SystemException, PortalException, CustomPropertiesNotInitializedException {
        //System.out.println("executing harvester: " + wxsHarvester.toShortString());

        // your first time ?
        boolean firstRun = wxsHarvester.getStatus().equals(WxSHarvesterStatus.NEVER_RUN.name());
        // check if harvester is in geonetwork
        if(! isInGeoNetwork(wxsHarvester)) {
            System.out.println("ERROR: harvester " + wxsHarvester.toShortString() + " is not saved to GeoNetwork, execution canceled.");
            return;
        }

        //
        // mark wxsharvester as RUNNING
        //
        wxsHarvester.setStatus(WxSHarvesterStatus.RUNNING.name());
        WxsHarvesterLocalServiceUtil.updateWxsHarvester(wxsHarvester, Boolean.FALSE, Boolean.FALSE);

        //
        // retrieve results of this harvester from GeoNetwork before running it (previous state)
        //
        GeoNetworkHarvesterResponse getLastResultsResponse = geoNetworkConnector.getHarvesterResults(wxsHarvester);
        if(!firstRun && getLastResultsResponse.getWxsHarvester().getStatus().equals(WxSHarvesterStatus.GEONETWORK_GETRESULTS_FAILURE.name())) {
            WxsHarvesterLocalServiceUtil.updateWxsHarvester(wxsHarvester, Boolean.FALSE, Boolean.FALSE);
            System.out.println("ERROR: failed to retrieve earlier harvesting results for harvester " + wxsHarvester.toShortString() + ", execution canceled.");
            return;
        }
        String harvesterResultsBefore = getLastResultsResponse.getGeonetworkResponse();

        //
        // request WxSHarvester activation in GeoNetwork
        //
        GeoNetworkHarvesterResponse activationResponse = geoNetworkConnector.activateHarvester(wxsHarvester);
        if(activationResponse.getWxsHarvester().getStatus().equals(WxSHarvesterStatus.GEONETWORK_ACTIVATE_FAILURE.name())) {
            WxsHarvesterLocalServiceUtil.updateWxsHarvester(wxsHarvester, Boolean.FALSE, Boolean.FALSE);
            System.out.println("ERROR: failed to activate harvester " + wxsHarvester.toShortString() + ", execution canceled.");
            return;
        }

        long start = System.currentTimeMillis();

        //
        // request WxSHarvester run in GeoNetwork
        //
        GeoNetworkHarvesterResponse runResponse = geoNetworkConnector.runHarvester(wxsHarvester);
        if(runResponse.getWxsHarvester().getStatus().equals(WxSHarvesterStatus.GEONETWORK_RUN_FAILURE.name())) {
            WxsHarvesterLocalServiceUtil.updateWxsHarvester(wxsHarvester, Boolean.FALSE, Boolean.FALSE);
            System.out.println("ERROR: failed to run harvester " + wxsHarvester.toShortString() + ", execution canceled.");
            return;
        }
        //
        // keep polling GeoNetwork to know when GeoNetwork harvester has finished
        //
        boolean geoNetworkHarvestingRunFinished = false;
        while(geoNetworkHarvestingRunFinished == false) {
            // poll every 30 seconds
            try {
                Thread.sleep(30000);
            }
            catch (InterruptedException x) {
                wxsHarvester.setStatus(WxSHarvesterStatus.ACE_ERROR.name());
                WxsHarvesterLocalServiceUtil.updateWxsHarvester(wxsHarvester, Boolean.FALSE, Boolean.FALSE);
                System.out.println("ERROR: failed to poll status of harvester " + wxsHarvester.toShortString() + " - " + x.getMessage() + ", execution canceled.");
                return;
            }
            long elapsed = System.currentTimeMillis() - start;
            if(elapsed > timeOut) {
                System.out.println("ERROR: harvester poll timeout for harvester " + wxsHarvester.toShortString() + ", execution canceled.");
                wxsHarvester.setStatus(WxSHarvesterStatus.GEONETWORK_POLL_TIMEOUT.name());
                WxsHarvesterLocalServiceUtil.updateWxsHarvester(wxsHarvester, Boolean.FALSE, Boolean.FALSE);
                return;
            }

            GeoNetworkHarvesterResponse statusResponse = geoNetworkConnector.getHarvester(wxsHarvester);
            if(statusResponse.getWxsHarvester().getStatus().equals(WxSHarvesterStatus.GEONETWORK_GET_FAILURE.name())) {
                System.out.println("ERROR: failed to poll execution status for harvester " + wxsHarvester.toShortString() + ", execution canceled.");
                WxsHarvesterLocalServiceUtil.updateWxsHarvester(wxsHarvester, Boolean.FALSE, Boolean.FALSE);
                return;
            }
            String pollResult = statusResponse.getGeonetworkResponse();
            geoNetworkHarvestingRunFinished = isRunFinished(pollResult) ;
        }

        //
        // de-activate GeoNetwork harvester
        //
        GeoNetworkHarvesterResponse deActivateResponse = geoNetworkConnector.deActivateHarvester(wxsHarvester);
        // if failed, store the error status but do continue processing (don't return)
        if(deActivateResponse.getWxsHarvester().getStatus().equals(WxSHarvesterStatus.GEONETWORK_DEACTIVATE_FAILURE.name())) {
            System.out.println("ERROR: failed to deactivate harvester " + wxsHarvester.toShortString());
            WxsHarvesterLocalServiceUtil.updateWxsHarvester(wxsHarvester, Boolean.FALSE, Boolean.FALSE);
        }

        //
        // retrieve results of this harvester from GeoNetwork after running it (new state)
        //
        GeoNetworkHarvesterResponse resultsResponse = geoNetworkConnector.getHarvesterResults(wxsHarvester);
        if(resultsResponse.getWxsHarvester().getStatus().equals(WxSHarvesterStatus.GEONETWORK_GETRESULTS_FAILURE.name())) {
            System.out.println("ERROR: failed to retrieve results for harvester " + wxsHarvester.toShortString() + ", execution canceled.");
            WxsHarvesterLocalServiceUtil.updateWxsHarvester(wxsHarvester, Boolean.FALSE, Boolean.FALSE);
            return;
        }
        String harvesterResultsAfter = resultsResponse.getGeonetworkResponse();

        //
        // convert to AceItems, save in DBMS and update Lucene index
        //
        storeAsAceItems(wxsHarvester, harvesterResultsBefore, harvesterResultsAfter);

        wxsHarvester.setStatus(WxSHarvesterStatus.SUCCESS.name());
        WxsHarvesterLocalServiceUtil.updateWxsHarvester(wxsHarvester, Boolean.FALSE, Boolean.FALSE);
        //System.out.println("successfully finished executing harvester: " + wxsHarvester.toShortString());
    }

    /**
     * Returns whether a wxsharvester is saved by GeoNetwork, by asking GeoNetwork to return it. Sets savedToGeoNetwork
     * according to result.
     *
     * @param wxsHarvester
     * @return
     * @throws SystemException
     */
    private static synchronized boolean isInGeoNetwork(WxsHarvester wxsHarvester) throws SystemException {
        // check if harvester was saved to GeoNetwork
        GeoNetworkHarvesterResponse getHarvesterResponse = geoNetworkConnector.getHarvester(wxsHarvester);
        if(getHarvesterResponse.getWxsHarvester().getStatus().equals(WxSHarvesterStatus.GEONETWORK_GET_FAILURE.name())) {
            //System.out.println("failed to find harvester " + wxsHarvester.toShortString() + " in GeoNetwork");
            wxsHarvester.setSavedToGeoNetwork(false);
            WxsHarvesterLocalServiceUtil.updateWxsHarvester(wxsHarvester, Boolean.FALSE, Boolean.FALSE);
            // TODO this does not seem to work:
            WxsHarvesterUtil.clearCache(wxsHarvester);
            return false;
        }
        else {
            wxsHarvester.setSavedToGeoNetwork(true);
            WxsHarvesterLocalServiceUtil.updateWxsHarvester(wxsHarvester, Boolean.FALSE, Boolean.FALSE);
            return true;
        }

    }

    /**
     * Returns metadata content (title, abstract, and keywords) mapped to metadata ids, as returned from a GeoNetwork
     * search request.
     *
     * @param searchResponse response to search in
     * @return List containing content maps
     */
    private static synchronized List getMetadataContents(String searchResponse, boolean idsOnly) {

        //System.out.println("creating content maps. Ids only? " + idsOnly);

        List theMaps = new ArrayList();
        List<String> idList = new ArrayList<String>();
        Map<String, String> metadataTitleMap = new HashMap<String, String>();
        Map<String, String> metadataAbstractMap = new HashMap<String, String>();
        Map<String, List<String>> metadataKeywordMap = new HashMap<String, List<String>>();

        boolean done = false;
        while(! done) {
            int nextMetadataStartPosition = searchResponse.indexOf("<metadata>");
            if(nextMetadataStartPosition < 0) {
                done = true;
            }
            else {
                // obtain next metadata
                String metadata = searchResponse.substring(searchResponse.indexOf("<metadata>"), searchResponse.indexOf("</metadata>"));
                String id =  null;
                // get this metadata id
                if(metadata.indexOf("<id") >= 0) {
                    int closingIdBracket = metadata.indexOf(">", metadata.indexOf("<id"));
                    int openingCloseIdBracket = metadata.indexOf("<", closingIdBracket);
                    id = metadata.substring(closingIdBracket+1, openingCloseIdBracket);
                    idList.add(id);
                    //System.out.println("metadata id: " + id);
                }
                // metadata has no id
                if(id == null || id.length() == 0) {
                    System.out.println("WARNING: found metadata without id, skipping it");
                    continue;
                }
                if(!idsOnly) {
                    // this metadata has a title
                    if(metadata.indexOf("<title>") >= 0) {
                        int startContent = metadata.indexOf("<title>") + "<title>".length();
                        int endContent = metadata.indexOf("</title>");
                        String title = metadata.substring(startContent, endContent);
                        metadataTitleMap.put(id, title);
                        //System.out.println("metadata title: " + title);

                    }

                    // this metadata has an abstract
                    if(metadata.indexOf("<abstract>") >= 0) {
                        int startContent = metadata.indexOf("<abstract>") + "<abstract>".length();
                        int endContent = metadata.indexOf("</abstract>");
                        String abstrakt = metadata.substring(startContent, endContent);
                        //System.out.println("metadata abstract: " + abstrakt);
                        metadataAbstractMap.put(id, abstrakt);
                    }

                    // this metadata has at least one keyword
                    if(metadata.indexOf("<keyword>") >= 0) {
                        List<String> keywords = new ArrayList<String>();
                        boolean hasMoreKeywords = true;
                        while(hasMoreKeywords) {
                            int nextKeywordStartPosition = metadata.indexOf("<keyword>");
                            if(nextKeywordStartPosition < 0) {
                                hasMoreKeywords = false;
                                //System.out.println("metadata has no (more) keywords");
                            }
                            else {
                                // strip up to keyword
                                metadata = metadata.substring(metadata.indexOf("<keyword>") + "<keyword>".length());
                                // strip from first <
                                String keyword = metadata.substring(0, metadata.indexOf("<"));
                                //System.out.println("metadata keyword: " + keyword);
                                keywords.add(keyword);
                            }
                        }
                        if(keywords.size() > 0) {
                            metadataKeywordMap.put(id, keywords);
                        }
                        //System.out.println("metadata # keywords: " + keywords.size());
                    }
                }

                // strip searchresponse to continue searching for next metadata
                int endOfMetadataSPosition = searchResponse.indexOf("</metadata>");
                searchResponse = searchResponse.substring(endOfMetadataSPosition + 6);
                //System.out.println("processed metadata with GN id " + id + " remaining size of searchresult: " + searchResponse.length());
            }
        }

        theMaps.add(idList);
        if(!idsOnly) {
            theMaps.add(metadataTitleMap);
            theMaps.add(metadataAbstractMap);
            theMaps.add(metadataKeywordMap);
        }
        //System.out.println("finished creating content maps. Ids only? " + idsOnly);
        return theMaps;
    }

    /**
     * Converts GeoNetwork response about a harvester's results (a list of metadata) to AceItems and stores them in ACE.
     *
     * A GeoNetwork response when there were no metadata retrieved looks typically like
     *
     * &lt?xml version="1.0" encoding="UTF-8"?>
     *     <response from="0" to="0" selected="0">
     *         <summary count="0" type="local" hitsusedforsummary="0">
     *             <keywords/>
     *         </summary>
     *     </response>
     *
     * When there are metadata retrieved, results look like this
     *
     * <response from="1" to="101" selected="0">
     *     <summary count="101" type="local" hitsusedforsummary="101">
     *         <keywords>
     *             <keyword count="1" name="framework"/>
     *             <keyword count="1" name="hydrographic"/>
     *             <keyword count="1" name="road"/>
     *             <keyword count="1" name="hydrography"/>
     *             <keyword count="1" name="topographic"/>
     *             <keyword count="1" name="base"/>
     *             <keyword count="1" name="rail"/>
     *         </keywords>
     *     </summary>
     *     <metadata>
     *         <geonet:info xmlns:geonet="http://www.fao.org/geonetwork">
     *             <id>1</id>
     *             <uuid>8f21eba71df03b2450cf37c3221d465228c6396d</uuid>
     *             <schema>iso19139</schema>
     *             <createDate>2011-08-29T13:29:21</createDate>
     *             <changeDate>2011-08-29T13:29:36</changeDate>
     *             <source>25a283df-ad82-4b3d-98fe-e4e105a7fddf</source>
     *             <category>datasets</category>
     *             <score>NaN</score>
     *             <selected>false</selected>
     *             <category internal="true">dataset</category>
     *         </geonet:info>
     *     </metadata>
     *
     * or, if you asked for <fast>false</fast>, like this
     *
     * <response from="1" to="101" selected="0">
	 *     <summary count="101" type="local" hitsusedforsummary="101">
     *         <keywords>
     *             <keyword count="1" name="framework"/>
     *             <keyword count="1" name="hydrographic"/>
     *             <keyword count="1" name="road"/>
     *             <keyword count="1" name="hydrography"/>
     *             <keyword count="1" name="topographic"/>
     *             <keyword count="1" name="base"/>
     *             <keyword count="1" name="rail"/>
     *         </keywords>
     *     </summary>
     *     <metadata>
     *         <title>Ocean Background</title>
     *         <abstract>Background for the world's oceans.</abstract>
     *         <geoBox>
     *             <westBL>-180</westBL>
     *             <eastBL>180</eastBL>
     *             <southBL>-90</southBL>
     *             <northBL>90</northBL>
     *         </geoBox>
     *         <image type="thumbnail">/geonetwork/srv/en/resources.get?id=1&amp;fname=8f21eba71df03b2450cf37c3221d465228c6396d_s.png&amp;access=public</image>
     *         <image type="overview">/geonetwork/srv/en/graphover.show?id=1&amp;fname=8f21eba71df03b2450cf37c3221d465228c6396d.png&amp;access=public</image>
     *         <link title="Ocean Background" href="http://132.156.10.87/cgi-bin/atlaswms_en?" name="wld_ocean" type="application/vnd.ogc.wms_xml"/>
     *         <link title="Ocean Background" href="http://localhost:8080/geonetwork/srv/en/google.kml?uuid=8f21eba71df03b2450cf37c3221d465228c6396d&amp;layers=wld_ocean" name="wld_ocean" type="application/vnd.google-earth.kml+xml"/>
     *         <link type="wms">javascript:addWMSLayer([["wld_ocean","http://132.156.10.87/cgi-bin/atlaswms_en?", "wld_ocean","1"]])</link>
     *         <link type="googleearth">/geonetwork/srv/en/google.kml?uuid=8f21eba71df03b2450cf37c3221d465228c6396d&amp;layers=wld_ocean</link>
     *         <geonet:info xmlns:geonet="http://www.fao.org/geonetwork">
     *             <id xmlns:gmd="http://www.isotc211.org/2005/gmd" xmlns:gts="http://www.isotc211.org/2005/gts" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:gml="http://www.opengis.net/gml" xmlns:gco="http://www.isotc211.org/2005/gco" xmlns:xlink="http://www.w3.org/1999/xlink">1</id>
     *             <schema xmlns:gmd="http://www.isotc211.org/2005/gmd" xmlns:gts="http://www.isotc211.org/2005/gts" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:gml="http://www.opengis.net/gml" xmlns:gco="http://www.isotc211.org/2005/gco" xmlns:xlink="http://www.w3.org/1999/xlink">iso19139</schema>
     *             <createDate xmlns:gmd="http://www.isotc211.org/2005/gmd" xmlns:gts="http://www.isotc211.org/2005/gts" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:gml="http://www.opengis.net/gml" xmlns:gco="http://www.isotc211.org/2005/gco" xmlns:xlink="http://www.w3.org/1999/xlink">2011-08-29T13:29:21</createDate>
     *             <changeDate xmlns:gmd="http://www.isotc211.org/2005/gmd" xmlns:gts="http://www.isotc211.org/2005/gts" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:gml="http://www.opengis.net/gml" xmlns:gco="http://www.isotc211.org/2005/gco" xmlns:xlink="http://www.w3.org/1999/xlink">2011-08-29T13:29:36</changeDate>
     *             <isTemplate xmlns:gmd="http://www.isotc211.org/2005/gmd" xmlns:gts="http://www.isotc211.org/2005/gts" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:gml="http://www.opengis.net/gml" xmlns:gco="http://www.isotc211.org/2005/gco" xmlns:xlink="http://www.w3.org/1999/xlink">n</isTemplate>
     *             <source xmlns:gmd="http://www.isotc211.org/2005/gmd" xmlns:gts="http://www.isotc211.org/2005/gts" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:gml="http://www.opengis.net/gml" xmlns:gco="http://www.isotc211.org/2005/gco" xmlns:xlink="http://www.w3.org/1999/xlink">25a283df-ad82-4b3d-98fe-e4e105a7fddf</source>
     *             <uuid xmlns:gmd="http://www.isotc211.org/2005/gmd" xmlns:gts="http://www.isotc211.org/2005/gts" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:gml="http://www.opengis.net/gml" xmlns:gco="http://www.isotc211.org/2005/gco" xmlns:xlink="http://www.w3.org/1999/xlink">8f21eba71df03b2450cf37c3221d465228c6396d</uuid>
     *             <isHarvested xmlns:gmd="http://www.isotc211.org/2005/gmd" xmlns:gts="http://www.isotc211.org/2005/gts" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:gml="http://www.opengis.net/gml" xmlns:gco="http://www.isotc211.org/2005/gco" xmlns:xlink="http://www.w3.org/1999/xlink">y</isHarvested>
     *             <popularity xmlns:gmd="http://www.isotc211.org/2005/gmd" xmlns:gts="http://www.isotc211.org/2005/gts" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:gml="http://www.opengis.net/gml" xmlns:gco="http://www.isotc211.org/2005/gco" xmlns:xlink="http://www.w3.org/1999/xlink">0</popularity>
     *             <rating xmlns:gmd="http://www.isotc211.org/2005/gmd" xmlns:gts="http://www.isotc211.org/2005/gts" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:gml="http://www.opengis.net/gml" xmlns:gco="http://www.isotc211.org/2005/gco" xmlns:xlink="http://www.w3.org/1999/xlink">0</rating>
     *             <displayOrder xmlns:gmd="http://www.isotc211.org/2005/gmd" xmlns:gts="http://www.isotc211.org/2005/gts" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:gml="http://www.opengis.net/gml" xmlns:gco="http://www.isotc211.org/2005/gco" xmlns:xlink="http://www.w3.org/1999/xlink"/>
     *             <harvestInfo xmlns:gmd="http://www.isotc211.org/2005/gmd" xmlns:gts="http://www.isotc211.org/2005/gts" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:gml="http://www.opengis.net/gml" xmlns:gco="http://www.isotc211.org/2005/gco" xmlns:xlink="http://www.w3.org/1999/xlink">
     *                 <type>ogcwxs</type>
     *             </harvestInfo>
     *             <view xmlns:gmd="http://www.isotc211.org/2005/gmd" xmlns:gts="http://www.isotc211.org/2005/gts" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:gml="http://www.opengis.net/gml" xmlns:gco="http://www.isotc211.org/2005/gco" xmlns:xlink="http://www.w3.org/1999/xlink">true</view>
     *             <notify xmlns:gmd="http://www.isotc211.org/2005/gmd" xmlns:gts="http://www.isotc211.org/2005/gts" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:gml="http://www.opengis.net/gml" xmlns:gco="http://www.isotc211.org/2005/gco" xmlns:xlink="http://www.w3.org/1999/xlink">true</notify>
     *             <download xmlns:gmd="http://www.isotc211.org/2005/gmd" xmlns:gts="http://www.isotc211.org/2005/gts" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:gml="http://www.opengis.net/gml" xmlns:gco="http://www.isotc211.org/2005/gco" xmlns:xlink="http://www.w3.org/1999/xlink">true</download>
     *             <dynamic xmlns:gmd="http://www.isotc211.org/2005/gmd" xmlns:gts="http://www.isotc211.org/2005/gts" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:gml="http://www.opengis.net/gml" xmlns:gco="http://www.isotc211.org/2005/gco" xmlns:xlink="http://www.w3.org/1999/xlink">true</dynamic>
     *             <featured xmlns:gmd="http://www.isotc211.org/2005/gmd" xmlns:gts="http://www.isotc211.org/2005/gts" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:gml="http://www.opengis.net/gml" xmlns:gco="http://www.isotc211.org/2005/gco" xmlns:xlink="http://www.w3.org/1999/xlink">true</featured>
     *             <edit xmlns:gmd="http://www.isotc211.org/2005/gmd" xmlns:gts="http://www.isotc211.org/2005/gts" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:gml="http://www.opengis.net/gml" xmlns:gco="http://www.isotc211.org/2005/gco" xmlns:xlink="http://www.w3.org/1999/xlink">true</edit>
     *             <owner xmlns:gmd="http://www.isotc211.org/2005/gmd" xmlns:gts="http://www.isotc211.org/2005/gts" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:gml="http://www.opengis.net/gml" xmlns:gco="http://www.isotc211.org/2005/gco" xmlns:xlink="http://www.w3.org/1999/xlink">true</owner>
     *             <isPublishedToAll xmlns:gmd="http://www.isotc211.org/2005/gmd" xmlns:gts="http://www.isotc211.org/2005/gts" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:gml="http://www.opengis.net/gml" xmlns:gco="http://www.isotc211.org/2005/gco" xmlns:xlink="http://www.w3.org/1999/xlink">true</isPublishedToAll>
     *             <ownername xmlns:gmd="http://www.isotc211.org/2005/gmd" xmlns:gts="http://www.isotc211.org/2005/gts" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:gml="http://www.opengis.net/gml" xmlns:gco="http://www.isotc211.org/2005/gco" xmlns:xlink="http://www.w3.org/1999/xlink">admin</ownername>
     *             <category xmlns:gmd="http://www.isotc211.org/2005/gmd" xmlns:gts="http://www.isotc211.org/2005/gts" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:gml="http://www.opengis.net/gml" xmlns:gco="http://www.isotc211.org/2005/gco" xmlns:xlink="http://www.w3.org/1999/xlink">datasets</category>
     *             <baseUrl xmlns:gmd="http://www.isotc211.org/2005/gmd" xmlns:gts="http://www.isotc211.org/2005/gts" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:gml="http://www.opengis.net/gml" xmlns:gco="http://www.isotc211.org/2005/gco" xmlns:xlink="http://www.w3.org/1999/xlink">http://localhost:8080/geonetwork</baseUrl>
     *             <score xmlns:gmd="http://www.isotc211.org/2005/gmd" xmlns:gts="http://www.isotc211.org/2005/gts" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:gml="http://www.opengis.net/gml" xmlns:gco="http://www.isotc211.org/2005/gco" xmlns:xlink="http://www.w3.org/1999/xlink">NaN</score>
     *             <selected xmlns:gmd="http://www.isotc211.org/2005/gmd" xmlns:gts="http://www.isotc211.org/2005/gts" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:gml="http://www.opengis.net/gml" xmlns:gco="http://www.isotc211.org/2005/gco" xmlns:xlink="http://www.w3.org/1999/xlink">false</selected>
     *             <category internal="true">dataset</category>
     *         </geonet:info>
     *     </metadata>
     * </response>
     *
     * @param wxsHarvester
     * @param harvesterResultBefore
     * @param harvesterResultAfter
     */
    private static synchronized void storeAsAceItems(WxsHarvester wxsHarvester, String harvesterResultBefore, String harvesterResultAfter) throws SystemException, PortalException, CustomPropertiesNotInitializedException {
        try {
        //System.out.println("applying harvesting result to AceItem table");

        //System.out.println("looking for metadata ids in search response before harvesting:");
        List contentMapBefore = getMetadataContents(harvesterResultBefore, true);

        List<String> idsBeforeList = (List<String>)contentMapBefore.get(0);
        //System.out.println("# ids from before: " + idsBeforeList.size());

        //System.out.println("looking for metadata ids, titles, abstracts and keywords in search response after harvesting:");
        List contentMapAfter = getMetadataContents(harvesterResultAfter, false);

        List<String> idsAfterList = (List<String>)contentMapAfter.get(0);
        //System.out.println("# ids from after: " + idsAfterList.size());
        Map<String, String> titleMap = (Map<String, String>)contentMapAfter.get(1);
        Map<String, String> abstractMap = (Map<String, String>)contentMapAfter.get(2);
        Map<String, List<String>> keywordMap = (Map<String, List<String>>)contentMapAfter.get(3);

        ACEIndexSynchronizer aceIndexSynchronizer = new ACEIndexSynchronizer();

        int created = 0, updated = 0, deleted = 0;

        // ids in before, and not in after: delete them
        for(String id : idsBeforeList) {
            if(!idsAfterList.contains(id)) {
                //System.out.println("deleting AceItem with geonetwork id: " + id);
                // delete it
                AceItem toDelete = AceItemLocalServiceUtil.getAceItemByStoredAt(id);
                if(toDelete != null) {
                    AceItemLocalServiceUtil.deleteAceItem(toDelete);
                    //System.out.println("finished deleting AceItem with geonetwork id: " + id);
                    deleted++;
                }
                else {
                    System.out.println("WARNING: failed to delete AceItem with geonetwork id: " + id + ", it seems it does not exist");
                }
                //
                // re-index Lucene
                //
                aceIndexSynchronizer.delete(toDelete);
            }
        }

        // ids in before and in after: update them
        for(String id : idsBeforeList) {
            if(idsAfterList.contains(id)) {
                //System.out.println("updating AceItem with geonetwork id: " + id);
                // update it
                AceItem toUpdate = AceItemLocalServiceUtil.getAceItemByStoredAt(id);
                if(toUpdate != null) {
                    toUpdate = fillAceItem(toUpdate, id, titleMap, abstractMap, keywordMap);
                    AceItemLocalServiceUtil.updateAceItem(toUpdate);
                    //System.out.println("finished updating AceItem with geonetwork id: " + id);
                    updated++;
                }
                else {
                    System.out.println("WARNING: failed to update AceItem with geonetwork id: " + id + ", it seems it does not exist. It will be created now.");
                    AceItem aceItem = AceItemLocalServiceUtil.createAceItem();
                    //System.out.println("a");
                    aceItem = fillAceItem(aceItem, id, titleMap, abstractMap, keywordMap);
                    //System.out.println("b");
                    aceItem.setPublicationDate(new Date());

                    aceItem.setWxsharvesterId(wxsHarvester.getWxsharvesterid());

                    aceItem.setCompanyId(wxsHarvester.getCompanyId());
                    aceItem.setGroupId(wxsHarvester.getGroupId());
                    //System.out.println("c");
                    AceItemLocalServiceUtil.addAceItem(aceItem);
                    //System.out.println("d");
                    //System.out.println("finished creating AceItem with geonetwork id: " + id);
                    created++;
                }
                //
                // re-index Lucene
                //
                aceIndexSynchronizer.update(toUpdate);
            }
        }


        // ids in after and not in before: create them
        for(String id : idsAfterList) {
            if(!idsBeforeList.contains(id)) {
                //System.out.println("creating AceItem with geonetwork id: " + id);
                // create it
                AceItem aceItem = AceItemLocalServiceUtil.createAceItem();
                aceItem = fillAceItem(aceItem, id, titleMap, abstractMap, keywordMap);
                aceItem.setPublicationDate(new Date());
                // the id of this harvester is stored in column NAS
                aceItem.setWxsharvesterId(wxsHarvester.getWxsharvesterid());

                aceItem.setCompanyId(wxsHarvester.getCompanyId());
                aceItem.setGroupId(wxsHarvester.getGroupId());

                // companyid and groupid are available in PortletRequest, but it's readily available here. For now
                // they are set in custom properties to have them easy avaiable thoughout.
                //String companyId = CustomProperties.getProperty("companyid");
                //String groupId = CustomProperties.getProperty("groupid");
                //aceItem.setCompanyId(Long.parseLong(companyId));
                //aceItem.setGroupId(Long.parseLong(groupId));

                AceItemLocalServiceUtil.addAceItem(aceItem);
                //System.out.println("finished creating AceItem with geonetwork id: " + id);
                created++;

                //
                // re-index Lucene
                //
                aceIndexSynchronizer.add(aceItem);
            }
        }
        //System.out.println("finished applying harvesting result to AceItem table. Created " + created + ", updated " + updated + ", deleted " + deleted + " aceitems.");
        }
        catch(Throwable x) {
            System.out.println("ERROR: " + x.getMessage() + " of type " + x.getClass().getName());
            x.printStackTrace();
        }
    }

    /**
     * Fills aceItem properties with values.
     *
     * @param aceItem
     * @param id
     * @param titleMap
     * @param abstractMap
     * @param keywordMap
     * @return
     */
    private static synchronized AceItem fillAceItem(AceItem aceItem, String id, Map<String, String> titleMap, Map<String, String> abstractMap, Map<String, List<String>> keywordMap) {
        aceItem.setStoredAt(id);
        aceItem.setDatatype(AceItemType.MAPGRAPHDATASET.name());
        aceItem.setStoragetype("GEONETWORK");
        String title = titleMap.get(id);
        if(title.length() > aceItemNameLength) {
            System.out.println("WARNING: Metadata title too long for AceItem, cut off. Original metadata title:\n" + title + "\n");
            title = title.substring(0, aceItemNameLength);
        }
        aceItem.setName(title);
        String abstrakt = abstractMap.get(id);
        aceItem.setDescription(abstrakt);
        List<String> keywords = keywordMap.get(id);
        String keyword$ = "";
        if(keywords != null && keywords.size() > 0) {
            for(String k : keywords) {
                keyword$ = k + ";" + keyword$;
            }
        }
        if(keyword$.length() > aceItemKeywordLength) {
            System.out.println("WARNING: Metadata keywords too long for AceItem, cut off. Original metadata keywords:\n" + keyword$ + "\n");
            keyword$ = keyword$.substring(0, aceItemKeywordLength);
        }
        aceItem.setKeyword(keyword$);

        aceItem.setTextSearch(keyword$ + " " + title + " " + abstrakt);

        /*
        System.out.println("\naceItem filled with:\n" +
                "storedAt: " + aceItem.getStoredAt() +
                "datatype: " + aceItem.getDatatype() +
                "storageType: " + aceItem.getStoragetype() +
                "name: " + aceItem.getName() +
                "keyword: " + aceItem.getKeyword() +
                "description: " + aceItem.getDescription() +
                "textsearch: " + aceItem.getTextSearch() + "\n\n"
        );
        */

        return aceItem;
    }

    /**
     * If the result contains
     *
     * <running>false</running>
     *
     * the run in GeoNetwork has finished.
     *
     * @param result
     * @return
     */
    private static boolean isRunFinished(String result) {
       return result.contains("<running>false</running>");
    }
}