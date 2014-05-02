package nl.wur.alterra.cgi.ace.geonetwork;

import nl.wur.alterra.cgi.ace.model.CSWHarvester;

/**
 * Response object for public interface of GeoNetworkConnector, containing GeoNetwork's response and the CSWHarvester
 * object with updated status.
 *
 * @author heikki doeleman
 */
public class GeoNetworkCSWHarvesterResponse {
    private CSWHarvester cswHarvester;
    private String geonetworkResponse;

    public GeoNetworkCSWHarvesterResponse(CSWHarvester cswHarvester, String geonetworkResponse) {
        this.cswHarvester = cswHarvester;
        this.geonetworkResponse = geonetworkResponse;
    }

    public CSWHarvester getCSWHarvester() {
        return cswHarvester;
    }

    public String getGeonetworkResponse() {
        return geonetworkResponse;
    }
}