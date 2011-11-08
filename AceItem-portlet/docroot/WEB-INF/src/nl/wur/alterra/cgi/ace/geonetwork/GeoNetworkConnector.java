package nl.wur.alterra.cgi.ace.geonetwork;

import com.liferay.portal.kernel.exception.SystemException;
import nl.wur.alterra.cgi.ace.model.WxsHarvester;
import nl.wur.alterra.cgi.ace.portlet.CustomProperties;
import nl.wur.alterra.cgi.ace.portlet.CustomPropertiesNotInitializedException;
import nl.wur.alterra.cgi.ace.util.HTTPUtils;

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
     * Adds an ACE WxsHarvester to GeoNetwork.
     *
     * @param wxsHarvester wxsharvester to publish
     * @throws com.liferay.portal.kernel.exception.SystemException hmm
     */
    public WxsHarvester addHarvester(WxsHarvester wxsHarvester) throws SystemException {
        login();
        String xml = createAddOrUpdateRequest(wxsHarvester, null);
        String response = httpUtils.post(xml, GeoNetworkAddHarvesterURL);
        // TODO verify success?
        // TODO logout?
        return setGeoNetworkIDs(wxsHarvester, response);
    }

    /**
     * Updates an ACE WxsHarvester in GeoNetwork.
     *
     * @param wxsHarvester
     * @return
     * @throws SystemException
     */
    public WxsHarvester updateHarvester(WxsHarvester wxsHarvester) throws SystemException {
        login();
        String xml = createAddOrUpdateRequest(wxsHarvester, Long.toString(wxsHarvester.getGeonetworkId()));
        String response = httpUtils.post(xml, GeoNetworkUpdateHarvesterURL);
        // TODO verify success?
        // TODO logout?
        return setGeoNetworkIDs(wxsHarvester, response);
    }

    /**
     * Deletes an ACE WxsHarvester in GeoNetwork.
     *
     * @param wxsHarvester
     * @return
     * @throws SystemException
     */
    public void deleteHarvester(WxsHarvester wxsHarvester) throws SystemException {
        login();
        String xml = createDeleteRequest(wxsHarvester);
        String response = httpUtils.post(xml, GeoNetworkRemoveHarvesterURL);

        System.out.println("deleteHarvester GeoNetwork response:\n" + response);
        if(!response.contains("status=\"ok\"")) {
            throw new SystemException("Failed to delete harvester from GeoNetwork");
        }

        // TODO logout?
    }


    /**
     * Activates a harvester in GeoNetwork.
     *
     * @param wxsHarvester
     * @throws SystemException
     */
    public void activateHarvester(WxsHarvester wxsHarvester) throws SystemException {
        login();
        String xml = createActivateRequest(wxsHarvester);
        String response = httpUtils.post(xml, GeoNetworkStartHarvesterURL);
        // TODO verify success?
        // TODO logout?
    }

    /**
     * De-activates a harvester in GeoNetwork.
     *
     * @param wxsHarvester
     * @throws SystemException
     */
    public String deActivateHarvester(WxsHarvester wxsHarvester) throws SystemException {
        login();
        String xml = createDeActivateRequest(wxsHarvester);
        String response = httpUtils.post(xml, GeoNetworkStopHarvesterURL);
        // TODO verify success?
        // TODO logout?
        return response;
    }

    /**
     * Runs a harvester in GeoNetwork.
     *
     * @param wxsHarvester
     * @throws SystemException
     */
    public String runHarvester(WxsHarvester wxsHarvester) throws SystemException {
        login();
        String xml = createRunRequest(wxsHarvester);
        String response = httpUtils.post(xml, GeoNetworkRunHarvesterURL);
        // TODO verify success?
        // TODO logout?
        return response;
    }

    /**
     * Gets a harvester's info from GeoNetwork -- this includes whether it is running right now.
     *
     * @param wxsHarvester
     * @throws SystemException
     */
    public String getHarvester(WxsHarvester wxsHarvester) throws SystemException {
        login();
        String xml = createGetRequest(wxsHarvester);
        String response = httpUtils.post(xml, GeoNetworkGetHarvesterURL);
        // TODO logout?
        return response;
    }

    /**
     * Retrieves all metadata resulting from a particular harvester in GeoNetwork.
     *
     * @param wxsHarvester
     * @return
     * @throws SystemException
     */
    public String getHarvesterResults(WxsHarvester wxsHarvester) throws SystemException {
        login();
        String xml = createHarvesterResultRequest(wxsHarvester);
        String response = httpUtils.post(xml, GeoNetworkXMLSearchURL);
        // TODO logout?
        return response;
    }

    /**
     * Creates a request to retrieve metadata from a particular harvester.
     * @param wxsHarvester
     * @return
     */
    private String createHarvesterResultRequest(WxsHarvester wxsHarvester) {
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
    private WxsHarvester setGeoNetworkIDs(WxsHarvester wxsHarvester, String geonetworkInfo) {
        // strip up to id
        String id = geonetworkInfo.substring(geonetworkInfo.indexOf("id=\"") + "id=\"".length());
        // strip from first "
        id = id.substring(0, id.indexOf("\""));

        System.out.println("processing harvester with id: " + id);

        // strip up to uuid
        String uuid = geonetworkInfo.substring(geonetworkInfo.indexOf("<uuid>") + "<uuid>".length());
        // strip from first <
        uuid = uuid.substring(0, uuid.indexOf("<"));

        System.out.println("processing harvester with uuid: " + uuid);

        wxsHarvester.setGeonetworkId(Long.parseLong(id));
        wxsHarvester.setGeonetworkUUID(uuid);

        return wxsHarvester;
    }

    /**
     * Creates a request to get a harvester in GeoNetwork.
     * @param wxsHarvester
     * @return
     */
    private String createGetRequest(WxsHarvester wxsHarvester) {
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
    private String createActivateRequest(WxsHarvester wxsHarvester) {
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
    private String createDeActivateRequest(WxsHarvester wxsHarvester) {
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
    private String createDeleteRequest(WxsHarvester wxsHarvester) {
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
    private String createRunRequest(WxsHarvester wxsHarvester) {
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
    private String createAddOrUpdateRequest(WxsHarvester wxsHarvester, String id) {

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
                xml += "<every>" + wxsHarvester.getEvery() + "</every>";
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

    /**
     * Logs in to GeoNetwork.
     *
     * @throws SystemException hmm
     */
    public void login() throws SystemException {
        String loginRequest = createLoginRequest();
        String response = httpUtils.post(loginRequest, GeoNetworkLoginURL);
        // TODO verify success
    }

    /**
     * Creates a LOGIN request for GeoNetwork.
     *
     * @return login request
     */
    private String createLoginRequest() {
        return "<request><username>" + this.username + "</username><password>" + this.password + "</password></request>";
    }

}