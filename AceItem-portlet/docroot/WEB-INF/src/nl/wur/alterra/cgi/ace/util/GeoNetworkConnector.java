package nl.wur.alterra.cgi.ace.util;

import com.liferay.portal.kernel.exception.SystemException;
import nl.wur.alterra.cgi.ace.model.WxsHarvester;

/**
 * Interface to GeoNetwork.
 *
 * @author heikki doeleman
 */
public class GeoNetworkConnector {

    /**
     * Constructor relying on hard-coded values for GN base url and credentials.
     * @deprecated use GeoNetworkConnector(String geoNetworkBaseUrl, String username, String password)
     */
    public GeoNetworkConnector() {
        this.geoNetworkBaseURL = "http://localhost:8081/geonetwork";
        this.GeoNetworkLoginURL  = geoNetworkBaseURL + "/srv/en/xml.user.login";
        this.GeoNetworkAddHarvesterURL  = geoNetworkBaseURL + "/srv/en/xml.harvesting.add";
        this.GeoNetworkStartHarvesterURL  = geoNetworkBaseURL + "/srv/en/xml.harvesting.start";
        this.GeoNetworkRunHarvesterURL  = geoNetworkBaseURL + "/srv/en/xml.harvesting.run";
        this.GeoNetworkXMLSearchURL  = geoNetworkBaseURL + "/srv/en/xml.search";
        this.username = "admin";
        this.password = "admin";
    }

    /**
     * Constructor with configurable base url, relying on hard-coded credentials.
     *
     * @param geoNetworkBaseUrl base url to GeoNetwork
     *
     * @deprecated use GeoNetworkConnector(String geoNetworkBaseUrl, String username, String password)
     */
    public GeoNetworkConnector(String geoNetworkBaseUrl) {
        this.geoNetworkBaseURL = geoNetworkBaseUrl;
        this.GeoNetworkLoginURL  = geoNetworkBaseURL + "/srv/en/xml.user.login";
        this.GeoNetworkAddHarvesterURL  = geoNetworkBaseURL + "/srv/en/xml.harvesting.add";
        this.GeoNetworkStartHarvesterURL  = geoNetworkBaseURL + "/srv/en/xml.harvesting.start";
        this.GeoNetworkRunHarvesterURL  = geoNetworkBaseURL + "/srv/en/xml.harvesting.run";
        this.GeoNetworkXMLSearchURL  = geoNetworkBaseURL + "/srv/en/xml.search";
        this.username = "admin";
        this.password = "admin";
    }

    /**
     * Constructor with configurable base url, username and password.
     *
     * @param geoNetworkBaseUrl base url to GeoNetwork
     * @param username username to log in to GeoNetwork
     * @param password password to log in to GeoNetwork
     */
    public GeoNetworkConnector(String geoNetworkBaseUrl, String username, String password) {
        this.geoNetworkBaseURL = geoNetworkBaseUrl;
        this.username = username;
        this.password = password;
    }

    private String username ;
    private String password ;
    private String geoNetworkBaseURL ;

    private String GeoNetworkLoginURL;
    private String GeoNetworkAddHarvesterURL;
    private String GeoNetworkStartHarvesterURL ;
    private String GeoNetworkRunHarvesterURL;
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
        String xml = convertHarvester2GeoNetworkServiceXML(wxsHarvester);
        String response = httpUtils.post(xml, GeoNetworkAddHarvesterURL);
        // TODO logout?
        System.out.println("**************\n"+response+"\n****************");
        return setGeoNetworkIDs(wxsHarvester, response);
    }

    /**
     * Updates wxsHarvester with ID and UUID provided by GeoNetwork.
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

        System.out.println("@#@#@ id: " + id);

        // strip up to uuid
        String uuid = geonetworkInfo.substring(geonetworkInfo.indexOf("<uuid>") + "<uuid>".length());
        // strip from first <
        uuid = uuid.substring(0, uuid.indexOf("<"));

        System.out.println("@#@#@ uuid: " + uuid);

        wxsHarvester.setGeonetworkId(Long.parseLong(id));
        wxsHarvester.setGeonetworkUUID(uuid);

        return wxsHarvester;
    }

    /**
     * Creates a ADD-WXSHARVESTER request for GeoNetwork. Some of the parameters are hard-coded, if desired they could
     * be made variable by adding them as properties to WxsHarvester.
     *
     * @param wxsHarvester wxsharvester
     * @return add harvester request
     */
    private String convertHarvester2GeoNetworkServiceXML(WxsHarvester wxsHarvester) {
        String xml = "<node type=\"ogcwxs\">";

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