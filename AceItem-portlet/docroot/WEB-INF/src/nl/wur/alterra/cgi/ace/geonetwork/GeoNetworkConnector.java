package nl.wur.alterra.cgi.ace.geonetwork;

import com.liferay.portal.kernel.exception.SystemException;
import nl.wur.alterra.cgi.ace.model.CSWHarvester;
import nl.wur.alterra.cgi.ace.model.WxsHarvester;
import nl.wur.alterra.cgi.ace.model.constants.HarvesterStatus;
import nl.wur.alterra.cgi.ace.portlet.CustomProperties;
import nl.wur.alterra.cgi.ace.portlet.CustomPropertiesNotInitializedException;
import nl.wur.alterra.cgi.ace.util.HTTPUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Interface to GeoNetwork.
 *
 * @author heikki doeleman
 */
public class GeoNetworkConnector {

    /**
     * Constructor using configurable values for GN base url and credentials.
     */
    public GeoNetworkConnector() throws ExceptionInInitializerError {
        try {
            // configurable properties
            this.geoNetworkBaseURL = CustomProperties.getProperty(CustomProperties.GEONETWORK_BASE_URL);
            this.username = CustomProperties.getProperty(CustomProperties.GEONETWORK_ADMIN_USERNAME);
            this.password = CustomProperties.getProperty(CustomProperties.GEONETWORK_ADMIN_PASSWORD);
            // hardcoded properties
            this.GeoNetworkLoginURL  = geoNetworkBaseURL + "/srv/en/xml.user.login";
            this.GeoNetworkAddHarvesterURL  = geoNetworkBaseURL + "/srv/en/xml.harvesting.add";
            this.GeoNetworkRemoveHarvesterURL  = geoNetworkBaseURL + "/srv/en/xml.harvesting.remove";
            this.GeoNetworkUpdateHarvesterURL  = geoNetworkBaseURL + "/srv/en/xml.harvesting.update";
            this.GeoNetworkStartHarvesterURL  = geoNetworkBaseURL + "/srv/en/xml.harvesting.start";
            this.GeoNetworkStopHarvesterURL  = geoNetworkBaseURL + "/srv/en/xml.harvesting.stop";
            this.GeoNetworkRunHarvesterURL  = geoNetworkBaseURL + "/srv/en/xml.harvesting.run";
            this.GeoNetworkGetHarvesterURL  = geoNetworkBaseURL + "/srv/en/xml.harvesting.get";
            this.GeoNetworkXMLSearchURL  = geoNetworkBaseURL + "/srv/en/xml.search";
        }
        catch(CustomPropertiesNotInitializedException x) {
            System.out.println("ERROR initializing GeoNetworkConnector: configuration unavailable.");
            throw new ExceptionInInitializerError(x);
        }
    }

    private String username ;
    private String password ;
    private String geoNetworkBaseURL ;

    private String GeoNetworkLoginURL;
    private String GeoNetworkAddHarvesterURL;
    private String GeoNetworkRemoveHarvesterURL;
    private String GeoNetworkUpdateHarvesterURL;
    private String GeoNetworkStartHarvesterURL ;
    private String GeoNetworkStopHarvesterURL ;
    private String GeoNetworkRunHarvesterURL;
    private String GeoNetworkGetHarvesterURL;
    private String GeoNetworkXMLSearchURL;

    private HTTPUtils httpUtils = new HTTPUtils();


    /**
     * Creates a LOGIN request for GeoNetwork.
     *
     * @return login request
     */
    private String createLoginRequest() {
        return "<request><username>" + this.username + "</username><password>" + this.password + "</password></request>";
    }

    //
    // CSWHarvester methods
    //

    /**
     * Logs in to GeoNetwork.
     *
     * @throws SystemException hmm
     */
    private GeoNetworkCSWHarvesterResponse loginForCSWHarvester(CSWHarvester cswHarvester) throws SystemException {
        //System.out.println("GeoNetworkConnector loginForCSWHarvester for harvester " + cswHarvester.toShortString());
        String loginRequest = createLoginRequest();
        String response = httpUtils.post(loginRequest, GeoNetworkLoginURL);
        //System.out.println("loginForCSWHarvester response: '" + response + "'");
        // verify success
        if(!response.contains("<ok />")) {
            System.out.println("ERROR loginForCSWHarvester for harvester " + cswHarvester.toShortString());
            cswHarvester.setStatus(HarvesterStatus.GEONETWORK_LOGIN_FAILURE.name());
        }
        else {
            //cswHarvester.setStatus(HarvesterStatus.GEONETWORK_LOGIN_SUCCESS.name());
        }
        return new GeoNetworkCSWHarvesterResponse(cswHarvester, response);
    }

    /**
     * Adds an ACE CSWHarvester to GeoNetwork.
     *
     * @param cswHarvester cswharvester to publish
     * @throws com.liferay.portal.kernel.exception.SystemException hmm
     */
    public GeoNetworkCSWHarvesterResponse addCSWHarvester(CSWHarvester cswHarvester) throws SystemException {
        System.out.println("GeoNetworkConnector adding harvester " + cswHarvester.toShortString());
        GeoNetworkCSWHarvesterResponse loginResponse = loginForCSWHarvester(cswHarvester);
        // loginForCSWHarvester successful
        if(!loginResponse.getCSWHarvester().getStatus().equals(HarvesterStatus.GEONETWORK_LOGIN_FAILURE.name())) {
            String xml = createCSWHarvesterAddOrUpdateRequest(cswHarvester, null);
            System.out.println("add request:\n" + xml);
            String response = httpUtils.post(xml, GeoNetworkAddHarvesterURL);
            // TODO logout?
            // ad-hoc succes verification
            if(response.contains("BadParameterEx")) {
                cswHarvester.setSavedToGeoNetwork(false);
                cswHarvester.setStatus(HarvesterStatus.GEONETWORK_INSERT_FAILURE.name());
            }
            else {
                cswHarvester = setCSWHarvesterGeoNetworkIDs(cswHarvester, response);
                cswHarvester.setSavedToGeoNetwork(true);
                //cswHarvester.setStatus(HarvesterStatus.GEONETWORK_INSERT_SUCCESS.name());
            }
            return new GeoNetworkCSWHarvesterResponse(cswHarvester, response);
        }
        // loginForCSWHarvester failed
        else {
            System.out.println("ERROR: failed to loginForCSWHarvester to geonetwork when adding harvester " + cswHarvester.toShortString());
            loginResponse.getCSWHarvester().setStatus(HarvesterStatus.GEONETWORK_INSERT_FAILURE.name());
            return loginResponse;
        }
    }

    /**
     * Updates an ACE CSWHarvester in GeoNetwork.
     *
     * @param cswHarvester
     * @return
     * @throws SystemException
     */
    public GeoNetworkCSWHarvesterResponse updateCSWHarvester(CSWHarvester cswHarvester) throws SystemException {
        System.out.println("GeoNetworkConnector updating harvester " + cswHarvester.toShortString());
        GeoNetworkCSWHarvesterResponse loginResponse = loginForCSWHarvester(cswHarvester);
        // loginForCSWHarvester successful
        if(!loginResponse.getCSWHarvester().getStatus().equals(HarvesterStatus.GEONETWORK_LOGIN_FAILURE.name())) {
            String xml = createCSWHarvesterAddOrUpdateRequest(cswHarvester, Long.toString(cswHarvester.getGeonetworkId()));
            String response;
            if(cswHarvester.getSavedToGeoNetwork() == true) {
                response = httpUtils.post(xml, GeoNetworkUpdateHarvesterURL);
            }
            else {
                response = httpUtils.post(xml, GeoNetworkAddHarvesterURL);
            }
            // TODO logout?
            // ad-hoc succes verification
            if(response.contains("BadParameterEx")) {
                cswHarvester.setSavedToGeoNetwork(false);
                cswHarvester.setStatus(HarvesterStatus.GEONETWORK_INSERT_FAILURE.name());
            }
            else {
                cswHarvester = setCSWHarvesterGeoNetworkIDs(cswHarvester, response);
                //cswHarvester.setStatus(HarvesterStatus.GEONETWORK_UPDATE_SUCCESS.name());
            }
            return new GeoNetworkCSWHarvesterResponse(cswHarvester, response);
        }
        // loginForCSWHarvester failed
        else {
            System.out.println("ERROR: failed to loginForCSWHarvester to geonetwork when updating harvester " + cswHarvester.toShortString());
            loginResponse.getCSWHarvester().setStatus(HarvesterStatus.GEONETWORK_UPDATE_FAILURE.name());
            return loginResponse;
        }
    }

    /**
     * Deletes an ACE CSWHarvester in GeoNetwork.
     *
     * @param cswHarvester
     * @return
     * @throws SystemException
     */
    public GeoNetworkCSWHarvesterResponse deleteCSWHarvester(CSWHarvester cswHarvester) throws SystemException {
        //System.out.println("GeoNetworkConnector deleting harvester " + cswHarvester.toShortString());
        GeoNetworkCSWHarvesterResponse loginResponse = loginForCSWHarvester(cswHarvester);
        // loginForCSWHarvester successful
        if(!loginResponse.getCSWHarvester().getStatus().equals(HarvesterStatus.GEONETWORK_LOGIN_FAILURE.name())) {
            String xml = createCSWHarvesterDeleteRequest(cswHarvester);
            String response = httpUtils.post(xml, GeoNetworkRemoveHarvesterURL);
            // TODO logout?

            //System.out.println("deleteCSWHarvester GeoNetwork response:\n" + response);
            // TODO verify success -- when GeoNetwork supports that in future
            //if(!response.contains("status=\"ok\"")) {
            //    cswHarvester.setStatus(HarvesterStatus.GEONETWORK_DELETE_FAILURE.name());
            //}
            //cswHarvester.setStatus(HarvesterStatus.GEONETWORK_DELETE_SUCCESS.name());
            return new GeoNetworkCSWHarvesterResponse(cswHarvester, response);
            }
        // loginForCSWHarvester failed
        else {
            System.out.println("ERROR: failed to loginForCSWHarvester to geonetwork when deleting harvester " + cswHarvester.toShortString());
            loginResponse.getCSWHarvester().setStatus(HarvesterStatus.GEONETWORK_DELETE_FAILURE.name());
            return loginResponse;
        }
    }


    /**
     * Activates a harvester in GeoNetwork.
     *
     * @param cswHarvester
     * @throws SystemException
     */
    public GeoNetworkCSWHarvesterResponse activateCSWHarvester(CSWHarvester cswHarvester) throws SystemException {
        //System.out.println("GeoNetworkConnector activating harvester " + cswHarvester.toShortString());
        GeoNetworkCSWHarvesterResponse loginResponse = loginForCSWHarvester(cswHarvester);
        // loginForCSWHarvester successful
        if(!loginResponse.getCSWHarvester().getStatus().equals(HarvesterStatus.GEONETWORK_LOGIN_FAILURE.name())) {
            String xml = createCSWHarvesterActivateRequest(cswHarvester);
            String response = httpUtils.post(xml, GeoNetworkStartHarvesterURL);
            // TODO logout?
            // TODO verify success -- when GeoNetwork supports that in future
            //if(!response.contains("status=\"ok\"")) {
            //    cswHarvester.setStatus(HarvesterStatus.GEONETWORK_ACTIVATE_FAILURE.name());
            //}
            //cswHarvester.setStatus(HarvesterStatus.GEONETWORK_ACTIVATE_SUCCESS.name());
            return new GeoNetworkCSWHarvesterResponse(cswHarvester, response);
            }
        // loginForCSWHarvester failed
        else {
            System.out.println("ERROR: failed to loginForCSWHarvester to geonetwork when activating harvester " + cswHarvester.toShortString());
            loginResponse.getCSWHarvester().setStatus(HarvesterStatus.GEONETWORK_ACTIVATE_FAILURE.name());
            return loginResponse;
        }
    }

    /**
     * De-activates a harvester in GeoNetwork.
     *
     * @param cswHarvester
     * @throws SystemException
     */
    public GeoNetworkCSWHarvesterResponse deActivateCSWHarvester(CSWHarvester cswHarvester) throws SystemException {
        //System.out.println("GeoNetworkConnector de-activating harvester " + cswHarvester.toShortString());
        GeoNetworkCSWHarvesterResponse loginResponse = loginForCSWHarvester(cswHarvester);
        // loginForCSWHarvester successful
        if(!loginResponse.getCSWHarvester().getStatus().equals(HarvesterStatus.GEONETWORK_LOGIN_FAILURE.name())) {
            String xml = createCSWHarvesterDeActivateRequest(cswHarvester);
            String response = httpUtils.post(xml, GeoNetworkStopHarvesterURL);
            // TODO logout?
            // TODO verify success -- when GeoNetwork supports that in future
            //if(!response.contains("status=\"ok\"")) {
            //    cswHarvester.setStatus(HarvesterStatus.GEONETWORK_DEACTIVATE_FAILURE.name());
            //}
            //cswHarvester.setStatus(HarvesterStatus.GEONETWORK_DEACTIVATE_SUCCESS.name());
            return new GeoNetworkCSWHarvesterResponse(cswHarvester, response);
        }
        else {
            System.out.println("ERROR: failed to loginForCSWHarvester to geonetwork when de-activating harvester " + cswHarvester.toShortString());
            loginResponse.getCSWHarvester().setStatus(HarvesterStatus.GEONETWORK_DEACTIVATE_FAILURE.name());
            return loginResponse;
        }
    }

    /**
     * Requests GeoNetwork to run a harvester.
     *
     * @param cswHarvester
     * @throws SystemException
     */
    public GeoNetworkCSWHarvesterResponse runCSWHarvester(CSWHarvester cswHarvester) throws SystemException {
        //System.out.println("GeoNetworkConnector running harvester " + cswHarvester.toShortString());
        GeoNetworkCSWHarvesterResponse loginResponse = loginForCSWHarvester(cswHarvester);
        // loginForCSWHarvester successful
        if(!loginResponse.getCSWHarvester().getStatus().equals(HarvesterStatus.GEONETWORK_LOGIN_FAILURE.name())) {
            String xml = createCSWHarvesterRunRequest(cswHarvester);
            String response = httpUtils.post(xml, GeoNetworkRunHarvesterURL);
            // TODO logout?
            // TODO verify success -- when GeoNetwork supports that in future
            //if(!response.contains("status=\"ok\"")) {
            //    cswHarvester.setStatus(HarvesterStatus.GEONETWORK_RUN_FAILURE.name());
            //}
            //cswHarvester.setStatus(HarvesterStatus.GEONETWORK_RUN_SUCCESS.name());
            return new GeoNetworkCSWHarvesterResponse(cswHarvester, response);
        }
        // loginForCSWHarvester failed
        else {
            System.out.println("ERROR: failed to loginForCSWHarvester to geonetwork when running harvester " + cswHarvester.toShortString());
            loginResponse.getCSWHarvester().setStatus(HarvesterStatus.GEONETWORK_RUN_FAILURE.name());
            return loginResponse;
        }
    }

    /**
     * Gets a harvester's info from GeoNetwork -- this includes whether it is running right now.
     *
     * @param cswHarvester
     * @throws SystemException
     */
    public GeoNetworkCSWHarvesterResponse getCSWHarvester(CSWHarvester cswHarvester) throws SystemException {
        //System.out.println("GeoNetworkConnector getting harvester " + cswHarvester.toShortString());
        GeoNetworkCSWHarvesterResponse loginResponse = loginForCSWHarvester(cswHarvester);
        // loginForCSWHarvester successful
        if(!loginResponse.getCSWHarvester().getStatus().equals(HarvesterStatus.GEONETWORK_LOGIN_FAILURE.name())) {
            String xml = createCSWHarvesterGetRequest(cswHarvester);
            //System.out.println("getting harvester:\n"+ xml);
            String response = httpUtils.post(xml, GeoNetworkGetHarvesterURL);
            //System.out.println("response to getting harvester:\n"+ response);

            // TODO logout?
            // ad hoc verification
            if(response.contains("Object Not Found")) {
                cswHarvester.setStatus(HarvesterStatus.GEONETWORK_GET_FAILURE.name());
                cswHarvester.setSavedToGeoNetwork(false);
            }
            else {
                if(response.contains("<lastRun>")) {
                    cswHarvester.setStatus(HarvesterStatus.SUCCESS.name());
                }
                else {
                    cswHarvester.setStatus(HarvesterStatus.NEVER_RUN.name());
                }
            }
            return new GeoNetworkCSWHarvesterResponse(cswHarvester, response);
        }
        // loginForCSWHarvester failed
        else {
            System.out.println("ERROR: failed to loginForCSWHarvester to geonetwork when running harvester " + cswHarvester.toShortString());
            loginResponse.getCSWHarvester().setStatus(HarvesterStatus.GEONETWORK_GET_FAILURE.name());
            return loginResponse;
        }
    }

    /**
     * Retrieves all metadata resulting from a particular harvester in GeoNetwork.
     *
     * @param cswHarvester
     * @return
     * @throws SystemException
     */
    public GeoNetworkCSWHarvesterResponse getCSWHarvesterResults(CSWHarvester cswHarvester) throws SystemException {
        //System.out.println("GeoNetworkConnector getting harvester results" + cswHarvester.toShortString());
        GeoNetworkCSWHarvesterResponse loginResponse = loginForCSWHarvester(cswHarvester);
        // loginForCSWHarvester successful
        if(!loginResponse.getCSWHarvester().getStatus().equals(HarvesterStatus.GEONETWORK_LOGIN_FAILURE.name())) {
            String xml = createCSWHarvesterResultRequest(cswHarvester);
            String response = httpUtils.post(xml, GeoNetworkXMLSearchURL);
            //System.out.println("@@ get harvester result:\n"+response);
            // TODO logout?
            // verify success
            //if(!response.contains("status=\"ok\"")) {
            //    cswHarvester.setStatus(HarvesterStatus.GEONETWORK_GETRESULTS_FAILURE.name());
            //}
            //cswHarvester.setStatus(HarvesterStatus.GEONETWORK_GETRESULTS_SUCCESS.name());
            return new GeoNetworkCSWHarvesterResponse(cswHarvester, response);
        }
        // loginForCSWHarvester failed
        else {
            System.out.println("ERROR: failed to loginForCSWHarvester to geonetwork when running harvester " + cswHarvester.toShortString());
            loginResponse.getCSWHarvester().setStatus(HarvesterStatus.GEONETWORK_GETRESULTS_FAILURE.name());
            return loginResponse;
        }
    }



    /**
     * Creates a request to retrieve metadata from a particular harvester.
     * @param cswHarvester
     * @return
     */
    private String createCSWHarvesterResultRequest(CSWHarvester cswHarvester) {
        String xml = "<request>";
        xml += "<harvestUuid>" + cswHarvester.getGeonetworkUUID() + "</harvestUuid>";
        // if not sent, GeoNetwork only returns short summaries (2.6.x, seems a bug)
        xml += "<fast>false</fast>";
        xml += "</request>";
        return xml;
    }


    /**
     * Updates ACE cswHarvester with ID and UUID provided by GeoNetwork.
     *
     * A typical GeoNetwork response to adding a harvester is:
     *
     * &lt;?xml version="1.0" encoding="UTF-8"?>
     *     <node id="818" type="ogcwxs">
     *         <site>
     *             <name>kjhkhhj</name>
     *             <uuid>a648108f-809f-4321-9aba-5780443fb14b</uuid>
     *             <account>
     *                 <use>true</use>
     *                 <username />
     *                 <password />
     *             </account>
     *             <url>http://wewewew.ww</url>
     *             <ogctype />
     *             <icon>default.gif</icon>
     *         </site>
     *         <content>
     *             <validate>false</validate>
     *             <importxslt>none</importxslt>
     *         </content>
     *         <options>
     *             <every>43534</every>
     *             <oneRunOnly>true</oneRunOnly>
     *             <status>inactive</status>
     *             <lang>eng</lang>
     *             <topic />
     *             <createThumbnails>true</createThumbnails>
     *             <useLayer>true</useLayer>
     *             <useLayerMd>true</useLayerMd>
     *             <datasetCategory>2</datasetCategory>
     *         </options>
     *         <privileges>
     *             <group id="1">
     *                 <operation name="view" />
     *                 <operation name="dynamic" />
     *                 <operation name="featured" />
     *             </group>
     *         </privileges>
     *         <categories>
     *             <category id="3" />
     *         </categories>
     *         <info>
     *             <lastRun />
     *             <running>false</running>
     *         </info>
     *     </node>
     *
     * @param cswHarvester
     * @param geonetworkInfo
     */
    private CSWHarvester setCSWHarvesterGeoNetworkIDs(CSWHarvester cswHarvester, String geonetworkInfo) {
        System.out.println("setCSWHarvesterGeoNetworkIDs:\n" + geonetworkInfo);
        // strip up to id
        String id = geonetworkInfo.substring(geonetworkInfo.indexOf("id=\"") + "id=\"".length());
        // strip from first "
        id = id.substring(0, id.indexOf("\""));

        //System.out.println("processing harvester with id: " + id);

        // strip up to uuid
        String uuid = geonetworkInfo.substring(geonetworkInfo.indexOf("<uuid>") + "<uuid>".length());
        // strip from first <
        uuid = uuid.substring(0, uuid.indexOf("<"));

        //System.out.println("processing harvester with uuid: " + uuid);

        cswHarvester.setGeonetworkId(Long.parseLong(id));
        cswHarvester.setGeonetworkUUID(uuid);

        return cswHarvester;
    }

    /**
     * Creates a request to get a harvester in GeoNetwork.
     * @param cswHarvester
     * @return
     */
    private String createCSWHarvesterGetRequest(CSWHarvester cswHarvester) {
        String xml = "<request>";
            xml += "<id>" + cswHarvester.getGeonetworkId() + "</id>";
        xml += "</request>";
        return xml;
    }

    /**
     * Creates a request to activate a harvester in GeoNetwork.
     * @param cswHarvester
     * @return
     */
    private String createCSWHarvesterActivateRequest(CSWHarvester cswHarvester) {
        String xml = "<request>";
            xml += "<id>" + cswHarvester.getGeonetworkId() + "</id>";
        xml += "</request>";
        return xml;
    }

    /**
     * Creates a request to de-activate a harvester in GeoNetwork.
     * @param cswHarvester
     * @return
     */
    private String createCSWHarvesterDeActivateRequest(CSWHarvester cswHarvester) {
        String xml = "<request>";
            xml += "<id>" + cswHarvester.getGeonetworkId() + "</id>";
        xml += "</request>";
        return xml;
    }

    /**
     * Creates a request to delete a harvester in GeoNetwork.
     * @param cswHarvester
     * @return
     */
    private String createCSWHarvesterDeleteRequest(CSWHarvester cswHarvester) {
        String xml = "<request>";
            xml += "<id>" + cswHarvester.getGeonetworkId() + "</id>";
        xml += "</request>";
        return xml;
    }

    /**
     * Creates a request to run a harvester in GeoNetwork.
     * @param cswHarvester
     * @return
     */
    private String createCSWHarvesterRunRequest(CSWHarvester cswHarvester) {
        String xml = "<request>";
            xml += "<id>" + cswHarvester.getGeonetworkId() + "</id>";
        xml += "</request>";
        return xml;
    }

    /**
     * Creates a ADD-CSWHARVESTER or UPDATE-CSWHARVESTER request for GeoNetwork. Some of the parameters are hard-coded,
     * if desired they could be made variable by adding them as properties to CSWHarvester.
     *
     * @param cswHarvester cswharvester
     * @param id GeoNetwork id (if updating, otherwise null)
     * @return add harvester request
     */
    private String createCSWHarvesterAddOrUpdateRequest(CSWHarvester cswHarvester, String id) {

        String xml;

        // add
        if(id == null) {
            xml = "<node type=\"csw\">";
        }
        // update
        else {
            xml = "<node id=\"" + id + "\" type=\"csw\">";
        }

            xml += "<site>";
                xml += "<name>" + cswHarvester.getName() + "</name>";
                xml += "<useAccount><use>false</use><username /><password /></useAccount>";

                // CSW URLs often contain parameters separated by &. Turn these into XML ampersand entities:
                String url = cswHarvester.getUrl();
                try {
                    url = URLEncoder.encode(url, "UTF-8");
                }
                catch (UnsupportedEncodingException x) {
                    System.err.println(x.getMessage());
                    x.printStackTrace();
                    // TODO should not swallow this. But not likely it'll happen
                }
                xml += "<capabilitiesUrl>" + url + "</capabilitiesUrl>";
                xml += "<icon>default.gif</icon>";
            xml += "</site>";

            xml += "<content>";
                xml += "<validate>false</validate>";
                xml += "<importxslt>none</importxslt>";
            xml += "</content>";

            xml += "<searches>";
                // if any of the search fields is not empty, create a search element
                if( (cswHarvester.getFreetext() != null && cswHarvester.getFreetext().length() > 0) ||
                            (cswHarvester.getTitle() != null && cswHarvester.getTitle().length() > 0 ) ||
                            (cswHarvester.getAbstrakt() != null && cswHarvester.getAbstrakt().length() > 0 ) ||
                            (cswHarvester.getSubject() != null && cswHarvester.getSubject().length() > 0 ) ) {
                    xml += "<search>";
                    if(cswHarvester.getFreetext() != null && cswHarvester.getFreetext().length() > 0 ){
                        xml += "<freeText>" + cswHarvester.getFreetext() + "</freeText>";
                    }
                    if(cswHarvester.getTitle() != null && cswHarvester.getTitle().length() > 0 ){
                        xml += "<title>" + cswHarvester.getTitle() + "</title>";
                    }
                    if(cswHarvester.getAbstrakt() != null && cswHarvester.getAbstrakt().length() > 0 ){
                        xml += "<abstract>" + cswHarvester.getAbstrakt() + "</abstract>";
                    }
                    if(cswHarvester.getSubject() != null && cswHarvester.getSubject().length() > 0 ){
                        xml += "<subject>" + cswHarvester.getSubject() + "</subject>";
                    }
                    xml += "</search>";
                }
            xml += "</searches>";

            xml += "<options>";
                // GeoNetwork cannot handle period of 0
                if(cswHarvester.getEvery() != 0) {
                    xml += "<every>" + cswHarvester.getEvery() + "</every>";
                }
                xml += "<oneRunOnly>true</oneRunOnly>";
                xml += "<lang>eng</lang>";
                xml += "<topic>" + cswHarvester.getTopic() + "</topic>";
                xml += "<createThumbnails>true</createThumbnails>";
                xml += "<useLayer>true</useLayer>";
                xml += "<useLayerMd>true</useLayerMd>";
                xml += "<datasetCategory>2</datasetCategory>";
            xml += "</options>";

            xml += "<privileges>";
                xml += "<group id=\"1\">";
                xml += "<operation name=\"view\" />";
                xml += "<operation name=\"dynamic\" />";
                xml += "<operation name=\"featured\" />";
                xml += "</group>";
            xml += "</privileges>";

            xml += "<categories>";
                xml += "<category id=\"3\" />";
            xml += "</categories>";

        xml += "</node>";

        return xml;
    }



    //
    // WxSHarvester methods
    //

    /**
     * Logs in to GeoNetwork.
     *
     * @throws SystemException hmm
     */
    private GeoNetworkWxSHarvesterResponse loginForWxSHarvester(WxsHarvester wxsHarvester) throws SystemException {
        //System.out.println("GeoNetworkConnector loginForWxSHarvester for harvester " + wxsHarvester.toShortString());
        String loginRequest = createLoginRequest();
        String response = httpUtils.post(loginRequest, GeoNetworkLoginURL);
        //System.out.println("loginForWxSHarvester response: '" + response + "'");
        // verify success
        if(!response.contains("<ok />")) {
            System.out.println("ERROR loginForWxSHarvester for harvester " + wxsHarvester.toShortString());
            wxsHarvester.setStatus(HarvesterStatus.GEONETWORK_LOGIN_FAILURE.name());
        }
        else {
            //wxsHarvester.setStatus(HarvesterStatus.GEONETWORK_LOGIN_SUCCESS.name());
        }
        return new GeoNetworkWxSHarvesterResponse(wxsHarvester, response);
    }

    /**
     * Adds an ACE WxsHarvester to GeoNetwork.
     *
     * @param wxsHarvester wxsharvester to publish
     * @throws com.liferay.portal.kernel.exception.SystemException hmm
     */
    public GeoNetworkWxSHarvesterResponse addWxSHarvester(WxsHarvester wxsHarvester) throws SystemException {
        //System.out.println("GeoNetworkConnector adding harvester " + wxsHarvester.toShortString());
        GeoNetworkWxSHarvesterResponse loginResponse = loginForWxSHarvester(wxsHarvester);
        // loginForWxSHarvester successful
        if(!loginResponse.getWxsHarvester().getStatus().equals(HarvesterStatus.GEONETWORK_LOGIN_FAILURE.name())) {
            String xml = createWxSHarvesterAddOrUpdateRequest(wxsHarvester, null);
            //System.out.println("add request:\n" + xml);
            String response = httpUtils.post(xml, GeoNetworkAddHarvesterURL);
            // TODO logout?
            // ad-hoc succes verification
            if(response.contains("BadParameterEx")) {
                wxsHarvester.setSavedToGeoNetwork(false);
                wxsHarvester.setStatus(HarvesterStatus.GEONETWORK_INSERT_FAILURE.name());
            }
            else {
                wxsHarvester = setWxSHarvesterGeoNetworkIDs(wxsHarvester, response);
                wxsHarvester.setSavedToGeoNetwork(true);
                //wxsHarvester.setStatus(HarvesterStatus.GEONETWORK_INSERT_SUCCESS.name());
            }
            return new GeoNetworkWxSHarvesterResponse(wxsHarvester, response);
        }
        // loginForWxSHarvester failed
        else {
            System.out.println("ERROR: failed to loginForWxSHarvester to geonetwork when adding harvester " + wxsHarvester.toShortString());
            loginResponse.getWxsHarvester().setStatus(HarvesterStatus.GEONETWORK_INSERT_FAILURE.name());
            return loginResponse;
        }
    }

    /**
     * Updates an ACE WxsHarvester in GeoNetwork.
     *
     * @param wxsHarvester
     * @return
     * @throws SystemException
     */
    public GeoNetworkWxSHarvesterResponse updateWxSHarvester(WxsHarvester wxsHarvester) throws SystemException {
        System.out.println("GeoNetworkConnector updating harvester " + wxsHarvester.toShortString());
        GeoNetworkWxSHarvesterResponse loginResponse = loginForWxSHarvester(wxsHarvester);
        // loginForWxSHarvester successful
        if(!loginResponse.getWxsHarvester().getStatus().equals(HarvesterStatus.GEONETWORK_LOGIN_FAILURE.name())) {
            String xml = createWxSHarvesterAddOrUpdateRequest(wxsHarvester, Long.toString(wxsHarvester.getGeonetworkId()));
            String response;
            if(wxsHarvester.getSavedToGeoNetwork() == true) {
                response = httpUtils.post(xml, GeoNetworkUpdateHarvesterURL);
            }
            else {
                response = httpUtils.post(xml, GeoNetworkAddHarvesterURL);
            }
            // TODO logout?
            // ad-hoc succes verification
            if(response.contains("BadParameterEx")) {
                wxsHarvester.setSavedToGeoNetwork(false);
                wxsHarvester.setStatus(HarvesterStatus.GEONETWORK_INSERT_FAILURE.name());
            }
            else {
                wxsHarvester = setWxSHarvesterGeoNetworkIDs(wxsHarvester, response);
                //wxsHarvester.setStatus(HarvesterStatus.GEONETWORK_UPDATE_SUCCESS.name());
            }
            return new GeoNetworkWxSHarvesterResponse(wxsHarvester, response);
        }
        // loginForWxSHarvester failed
        else {
            System.out.println("ERROR: failed to loginForWxSHarvester to geonetwork when updating harvester " + wxsHarvester.toShortString());
            loginResponse.getWxsHarvester().setStatus(HarvesterStatus.GEONETWORK_UPDATE_FAILURE.name());
            return loginResponse;
        }
    }

    /**
     * Deletes an ACE WxsHarvester in GeoNetwork.
     *
     * @param wxsHarvester
     * @return
     * @throws SystemException
     */
    public GeoNetworkWxSHarvesterResponse deleteWxSHarvester(WxsHarvester wxsHarvester) throws SystemException {
        //System.out.println("GeoNetworkConnector deleting harvester " + wxsHarvester.toShortString());
        GeoNetworkWxSHarvesterResponse loginResponse = loginForWxSHarvester(wxsHarvester);
        // loginForWxSHarvester successful
        if(!loginResponse.getWxsHarvester().getStatus().equals(HarvesterStatus.GEONETWORK_LOGIN_FAILURE.name())) {
            String xml = createWxSHarvesterDeleteRequest(wxsHarvester);
            String response = httpUtils.post(xml, GeoNetworkRemoveHarvesterURL);
            // TODO logout?

            //System.out.println("deleteWxSHarvester GeoNetwork response:\n" + response);
            // TODO verify success -- when GeoNetwork supports that in future
            //if(!response.contains("status=\"ok\"")) {
            //    wxsHarvester.setStatus(HarvesterStatus.GEONETWORK_DELETE_FAILURE.name());
            //}
            //wxsHarvester.setStatus(HarvesterStatus.GEONETWORK_DELETE_SUCCESS.name());
            return new GeoNetworkWxSHarvesterResponse(wxsHarvester, response);
            }
        // loginForWxSHarvester failed
        else {
            System.out.println("ERROR: failed to loginForWxSHarvester to geonetwork when deleting harvester " + wxsHarvester.toShortString());
            loginResponse.getWxsHarvester().setStatus(HarvesterStatus.GEONETWORK_DELETE_FAILURE.name());
            return loginResponse;
        }
    }


    /**
     * Activates a harvester in GeoNetwork.
     *
     * @param wxsHarvester
     * @throws SystemException
     */
    public GeoNetworkWxSHarvesterResponse activateWxSHarvester(WxsHarvester wxsHarvester) throws SystemException {
        //System.out.println("GeoNetworkConnector activating harvester " + wxsHarvester.toShortString());
        GeoNetworkWxSHarvesterResponse loginResponse = loginForWxSHarvester(wxsHarvester);
        // loginForWxSHarvester successful
        if(!loginResponse.getWxsHarvester().getStatus().equals(HarvesterStatus.GEONETWORK_LOGIN_FAILURE.name())) {
            String xml = createWxSHarvesterActivateRequest(wxsHarvester);
            String response = httpUtils.post(xml, GeoNetworkStartHarvesterURL);
            // TODO logout?
            // TODO verify success -- when GeoNetwork supports that in future
            //if(!response.contains("status=\"ok\"")) {
            //    wxsHarvester.setStatus(HarvesterStatus.GEONETWORK_ACTIVATE_FAILURE.name());
            //}
            //wxsHarvester.setStatus(HarvesterStatus.GEONETWORK_ACTIVATE_SUCCESS.name());
            return new GeoNetworkWxSHarvesterResponse(wxsHarvester, response);
            }
        // loginForWxSHarvester failed
        else {
            System.out.println("ERROR: failed to loginForWxSHarvester to geonetwork when activating harvester " + wxsHarvester.toShortString());
            loginResponse.getWxsHarvester().setStatus(HarvesterStatus.GEONETWORK_ACTIVATE_FAILURE.name());
            return loginResponse;
        }
    }

    /**
     * De-activates a harvester in GeoNetwork.
     *
     * @param wxsHarvester
     * @throws SystemException
     */
    public GeoNetworkWxSHarvesterResponse deActivateWxSHarvester(WxsHarvester wxsHarvester) throws SystemException {
        //System.out.println("GeoNetworkConnector de-activating harvester " + wxsHarvester.toShortString());
        GeoNetworkWxSHarvesterResponse loginResponse = loginForWxSHarvester(wxsHarvester);
        // loginForWxSHarvester successful
        if(!loginResponse.getWxsHarvester().getStatus().equals(HarvesterStatus.GEONETWORK_LOGIN_FAILURE.name())) {
            String xml = createWxSHarvesterDeActivateRequest(wxsHarvester);
            String response = httpUtils.post(xml, GeoNetworkStopHarvesterURL);
            // TODO logout?
            // TODO verify success -- when GeoNetwork supports that in future
            //if(!response.contains("status=\"ok\"")) {
            //    wxsHarvester.setStatus(HarvesterStatus.GEONETWORK_DEACTIVATE_FAILURE.name());
            //}
            //wxsHarvester.setStatus(HarvesterStatus.GEONETWORK_DEACTIVATE_SUCCESS.name());
            return new GeoNetworkWxSHarvesterResponse(wxsHarvester, response);
        }
        else {
            System.out.println("ERROR: failed to loginForWxSHarvester to geonetwork when de-activating harvester " + wxsHarvester.toShortString());
            loginResponse.getWxsHarvester().setStatus(HarvesterStatus.GEONETWORK_DEACTIVATE_FAILURE.name());
            return loginResponse;
        }
    }

    /**
     * Requests GeoNetwork to run a harvester.
     *
     * @param wxsHarvester
     * @throws SystemException
     */
    public GeoNetworkWxSHarvesterResponse runWxSHarvester(WxsHarvester wxsHarvester) throws SystemException {
        //System.out.println("GeoNetworkConnector running harvester " + wxsHarvester.toShortString());
        GeoNetworkWxSHarvesterResponse loginResponse = loginForWxSHarvester(wxsHarvester);
        // loginForWxSHarvester successful
        if(!loginResponse.getWxsHarvester().getStatus().equals(HarvesterStatus.GEONETWORK_LOGIN_FAILURE.name())) {
            String xml = createWxSHarvesterRunRequest(wxsHarvester);
            String response = httpUtils.post(xml, GeoNetworkRunHarvesterURL);
            // TODO logout?
            // TODO verify success -- when GeoNetwork supports that in future
            //if(!response.contains("status=\"ok\"")) {
            //    wxsHarvester.setStatus(HarvesterStatus.GEONETWORK_RUN_FAILURE.name());
            //}
            //wxsHarvester.setStatus(HarvesterStatus.GEONETWORK_RUN_SUCCESS.name());
            return new GeoNetworkWxSHarvesterResponse(wxsHarvester, response);
        }
        // loginForWxSHarvester failed
        else {
            System.out.println("ERROR: failed to loginForWxSHarvester to geonetwork when running harvester " + wxsHarvester.toShortString());
            loginResponse.getWxsHarvester().setStatus(HarvesterStatus.GEONETWORK_RUN_FAILURE.name());
            return loginResponse;
        }
    }

    /**
     * Gets a harvester's info from GeoNetwork -- this includes whether it is running right now.
     *
     * @param wxsHarvester
     * @throws SystemException
     */
    public GeoNetworkWxSHarvesterResponse getWxSHarvester(WxsHarvester wxsHarvester) throws SystemException {
        //System.out.println("GeoNetworkConnector getting harvester " + wxsHarvester.toShortString());
        GeoNetworkWxSHarvesterResponse loginResponse = loginForWxSHarvester(wxsHarvester);
        // loginForWxSHarvester successful
        if(!loginResponse.getWxsHarvester().getStatus().equals(HarvesterStatus.GEONETWORK_LOGIN_FAILURE.name())) {
            String xml = createWxSHarvesterGetRequest(wxsHarvester);
            //System.out.println("getting harvester:\n"+ xml);
            String response = httpUtils.post(xml, GeoNetworkGetHarvesterURL);
            //System.out.println("response to getting harvester:\n"+ response);

            // TODO logout?
            // ad hoc verification
            if(response.contains("Object Not Found")) {
                wxsHarvester.setStatus(HarvesterStatus.GEONETWORK_GET_FAILURE.name());
                wxsHarvester.setSavedToGeoNetwork(false);
            }
            else {
                if(response.contains("<lastRun>")) {
                    wxsHarvester.setStatus(HarvesterStatus.SUCCESS.name());
                }
                else {
                    wxsHarvester.setStatus(HarvesterStatus.NEVER_RUN.name());
                }
            }
            return new GeoNetworkWxSHarvesterResponse(wxsHarvester, response);
        }
        // loginForWxSHarvester failed
        else {
            System.out.println("ERROR: failed to loginForWxSHarvester to geonetwork when running harvester " + wxsHarvester.toShortString());
            loginResponse.getWxsHarvester().setStatus(HarvesterStatus.GEONETWORK_GET_FAILURE.name());
            return loginResponse;
        }
    }

    /**
     * Retrieves all metadata resulting from a particular harvester in GeoNetwork.
     *
     * @param wxsHarvester
     * @return
     * @throws SystemException
     */
    public GeoNetworkWxSHarvesterResponse getWxSHarvesterResults(WxsHarvester wxsHarvester) throws SystemException {
        //System.out.println("GeoNetworkConnector getting harvester results" + wxsHarvester.toShortString());
        GeoNetworkWxSHarvesterResponse loginResponse = loginForWxSHarvester(wxsHarvester);
        // loginForWxSHarvester successful
        if(!loginResponse.getWxsHarvester().getStatus().equals(HarvesterStatus.GEONETWORK_LOGIN_FAILURE.name())) {
            String xml = createWxSHarvesterResultRequest(wxsHarvester);
            String response = httpUtils.post(xml, GeoNetworkXMLSearchURL);
            //System.out.println("@@ get harvester result:\n"+response);
            // TODO logout?
            // verify success
            //if(!response.contains("status=\"ok\"")) {
            //    wxsHarvester.setStatus(HarvesterStatus.GEONETWORK_GETRESULTS_FAILURE.name());
            //}
            //wxsHarvester.setStatus(HarvesterStatus.GEONETWORK_GETRESULTS_SUCCESS.name());
            return new GeoNetworkWxSHarvesterResponse(wxsHarvester, response);
        }
        // loginForWxSHarvester failed
        else {
            System.out.println("ERROR: failed to loginForWxSHarvester to geonetwork when running harvester " + wxsHarvester.toShortString());
            loginResponse.getWxsHarvester().setStatus(HarvesterStatus.GEONETWORK_GETRESULTS_FAILURE.name());
            return loginResponse;
        }
    }



    /**
     * Creates a request to retrieve metadata from a particular harvester.
     * @param wxsHarvester
     * @return
     */
    private String createWxSHarvesterResultRequest(WxsHarvester wxsHarvester) {
        String xml = "<request>";
        xml += "<harvestUuid>" + wxsHarvester.getGeonetworkUUID() + "</harvestUuid>";
        // if not sent, GeoNetwork only returns short summaries (2.6.x, seems a bug)
        xml += "<fast>false</fast>";
        xml += "</request>";
        return xml;
    }


    /**
     * Updates ACE wxsHarvester with ID and UUID provided by GeoNetwork.
     *
     * A typical GeoNetwork response to adding a harvester is:
     *
     * &lt;?xml version="1.0" encoding="UTF-8"?>
     *     <node id="818" type="ogcwxs">
     *         <site>
     *             <name>kjhkhhj</name>
     *             <uuid>a648108f-809f-4321-9aba-5780443fb14b</uuid>
     *             <account>
     *                 <use>true</use>
     *                 <username />
     *                 <password />
     *             </account>
     *             <url>http://wewewew.ww</url>
     *             <ogctype />
     *             <icon>default.gif</icon>
     *         </site>
     *         <content>
     *             <validate>false</validate>
     *             <importxslt>none</importxslt>
     *         </content>
     *         <options>
     *             <every>43534</every>
     *             <oneRunOnly>true</oneRunOnly>
     *             <status>inactive</status>
     *             <lang>eng</lang>
     *             <topic />
     *             <createThumbnails>true</createThumbnails>
     *             <useLayer>true</useLayer>
     *             <useLayerMd>true</useLayerMd>
     *             <datasetCategory>2</datasetCategory>
     *         </options>
     *         <privileges>
     *             <group id="1">
     *                 <operation name="view" />
     *                 <operation name="dynamic" />
     *                 <operation name="featured" />
     *             </group>
     *         </privileges>
     *         <categories>
     *             <category id="3" />
     *         </categories>
     *         <info>
     *             <lastRun />
     *             <running>false</running>
     *         </info>
     *     </node>
     *
     * @param wxsHarvester
     * @param geonetworkInfo
     */
    private WxsHarvester setWxSHarvesterGeoNetworkIDs(WxsHarvester wxsHarvester, String geonetworkInfo) {
        // strip up to id
        String id = geonetworkInfo.substring(geonetworkInfo.indexOf("id=\"") + "id=\"".length());
        // strip from first "
        id = id.substring(0, id.indexOf("\""));

        //System.out.println("processing harvester with id: " + id);

        // strip up to uuid
        String uuid = geonetworkInfo.substring(geonetworkInfo.indexOf("<uuid>") + "<uuid>".length());
        // strip from first <
        uuid = uuid.substring(0, uuid.indexOf("<"));

        //System.out.println("processing harvester with uuid: " + uuid);

        wxsHarvester.setGeonetworkId(Long.parseLong(id));
        wxsHarvester.setGeonetworkUUID(uuid);

        return wxsHarvester;
    }

    /**
     * Creates a request to get a harvester in GeoNetwork.
     * @param wxsHarvester
     * @return
     */
    private String createWxSHarvesterGetRequest(WxsHarvester wxsHarvester) {
        String xml = "<request>";
            xml += "<id>" + wxsHarvester.getGeonetworkId() + "</id>";
        xml += "</request>";
        return xml;
    }

    /**
     * Creates a request to activate a harvester in GeoNetwork.
     * @param wxsHarvester
     * @return
     */
    private String createWxSHarvesterActivateRequest(WxsHarvester wxsHarvester) {
        String xml = "<request>";
            xml += "<id>" + wxsHarvester.getGeonetworkId() + "</id>";
        xml += "</request>";
        return xml;
    }

    /**
     * Creates a request to de-activate a harvester in GeoNetwork.
     * @param wxsHarvester
     * @return
     */
    private String createWxSHarvesterDeActivateRequest(WxsHarvester wxsHarvester) {
        String xml = "<request>";
            xml += "<id>" + wxsHarvester.getGeonetworkId() + "</id>";
        xml += "</request>";
        return xml;
    }

    /**
     * Creates a request to delete a harvester in GeoNetwork.
     * @param wxsHarvester
     * @return
     */
    private String createWxSHarvesterDeleteRequest(WxsHarvester wxsHarvester) {
        String xml = "<request>";
            xml += "<id>" + wxsHarvester.getGeonetworkId() + "</id>";
        xml += "</request>";
        return xml;
    }

    /**
     * Creates a request to run a harvester in GeoNetwork.
     * @param wxsHarvester
     * @return
     */
    private String createWxSHarvesterRunRequest(WxsHarvester wxsHarvester) {
        String xml = "<request>";
            xml += "<id>" + wxsHarvester.getGeonetworkId() + "</id>";
        xml += "</request>";
        return xml;
    }

    /**
     * Creates a ADD-WXSHARVESTER or UPDATE-WXSHARVESTER request for GeoNetwork. Some of the parameters are hard-coded,
     * if desired they could be made variable by adding them as properties to WxsHarvester.
     *
     * @param wxsHarvester wxsharvester
     * @param id GeoNetwork id (if updating, otherwise null)
     * @return add harvester request
     */
    private String createWxSHarvesterAddOrUpdateRequest(WxsHarvester wxsHarvester, String id) {

        String xml;

        // add
        if(id == null) {
            xml = "<node type=\"ogcwxs\">";
        }
        // update
        else {
            xml = "<node id=\"" + id + "\" type=\"ogcwxs\">";
        }

            xml += "<site>";
                xml += "<name>" + wxsHarvester.getName() + "</name>";
                xml += "<account><use>true</use><username /><password /></account>";
                xml += "<url>" + wxsHarvester.getUrl() + "</url>";
                xml += "<ogctype>" + wxsHarvester.getOgctype() + "</ogctype>";
                xml += "<icon>default.gif</icon>";
            xml += "</site>";

            xml += "<content>";
                xml += "<validate>false</validate>";
                xml += "<importxslt>none</importxslt>";
            xml += "</content>";

            xml += "<options>";
                // GeoNetwork cannot handle period of 0
                if(wxsHarvester.getEvery() != 0) {
                    xml += "<every>" + wxsHarvester.getEvery() + "</every>";
                }
                xml += "<oneRunOnly>true</oneRunOnly>";
                xml += "<lang>eng</lang>";
                xml += "<topic>" + wxsHarvester.getTopic() + "</topic>";
                xml += "<createThumbnails>true</createThumbnails>";
                xml += "<useLayer>true</useLayer>";
                xml += "<useLayerMd>true</useLayerMd>";
                xml += "<datasetCategory>2</datasetCategory>";
            xml += "</options>";

            xml += "<privileges>";
                xml += "<group id=\"1\">";
                xml += "<operation name=\"view\" />";
                xml += "<operation name=\"dynamic\" />";
                xml += "<operation name=\"featured\" />";
                xml += "</group>";
            xml += "</privileges>";

            xml += "<categories>";
                xml += "<category id=\"3\" />";
            xml += "</categories>";

        xml += "</node>";

        return xml;
    }

}