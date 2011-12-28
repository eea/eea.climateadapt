package nl.wur.alterra.cgi.ace.geonetwork;

import nl.wur.alterra.cgi.ace.model.WxsHarvester;

/**
 * Response object for public interface of GeoNetworkConnector, containing GeoNetwork's response and the WxsHarvester
 * object with updated status.
 *
 * @author heikki doeleman
 */
public class GeoNetworkHarvesterResponse {
    private WxsHarvester wxsHarvester;
    private String geonetworkResponse;

    public GeoNetworkHarvesterResponse(WxsHarvester wxsHarvester, String geonetworkResponse) {
        this.wxsHarvester = wxsHarvester;
        this.geonetworkResponse = geonetworkResponse;
    }

    public WxsHarvester getWxsHarvester() {
        return wxsHarvester;
    }

    public String getGeonetworkResponse() {
        return geonetworkResponse;
    }
}
