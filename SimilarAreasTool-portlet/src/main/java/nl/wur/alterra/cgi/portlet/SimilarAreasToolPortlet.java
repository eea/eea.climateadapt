package nl.wur.alterra.cgi.portlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class SimilarAreasToolPortlet
 */
public class SimilarAreasToolPortlet extends MVCPortlet {

    public void setPreferences(ActionRequest request, ActionResponse response) throws Exception {
        PortletPreferences prefs = request.getPreferences();

        // Proxy
        String proxyUrl = ParamUtil.getString(request, Constants.proxyUrlPreferenceName);

        prefs.setValue(Constants.proxyUrlPreferenceName, proxyUrl);

        // GeoServer URL
        String geoserverUrl = ParamUtil.getString(request, Constants.geoserverUrlPreferenceName);

        if (! geoserverUrl.endsWith("/")) {
            geoserverUrl += "/";
        }

        prefs.setValue(Constants.geoserverUrlPreferenceName, geoserverUrl);

        // GeoServer wfs path
        String wfs = ParamUtil.getString(request, Constants.wfsPreferenceName);

        prefs.setValue(Constants.wfsPreferenceName, wfs);

        // GeoServer wms path
        String wms = ParamUtil.getString(request, Constants.wmsPreferenceName);

        prefs.setValue(Constants.wmsPreferenceName, wms);

        // GeoServer feature namespace
        String featurenamespace = ParamUtil.getString(request, Constants.featureNamespacePreferenceName);

        prefs.setValue(Constants.featureNamespacePreferenceName, featurenamespace);

        // Name of featuretype of similar areas
        String areasfeaturetype = ParamUtil.getString(request, Constants.areasFeatureTypePreferenceName);

        prefs.setValue(Constants.areasFeatureTypePreferenceName, areasfeaturetype);

        // Name of layer of similar areas
        String areaslayer = ParamUtil.getString(request, Constants.areasLayerPreferenceName);

        prefs.setValue(Constants.areasLayerPreferenceName, areaslayer);

        // Name of featuretype of case studies
        String casestudiesfeaturetype = ParamUtil.getString(request, Constants.caseStudiesFeatureTypePreferenceName);

        prefs.setValue(Constants.caseStudiesFeatureTypePreferenceName, casestudiesfeaturetype);

        String geometrycolumn = ParamUtil.getString(request, Constants.geometryColumnPreferenceName);

        prefs.setValue(Constants.geometryColumnPreferenceName, geometrycolumn);

        // Microsoft Virtual Earth locator REST API URL
        String locatorUrl = ParamUtil.getString(request, Constants.locatorUrlPreferenceName);

        if (! locatorUrl.endsWith("/")) {
            locatorUrl += "/";
        }

        prefs.setValue(Constants.locatorUrlPreferenceName, locatorUrl);

        // Microsoft VE API key
        String locatorkey = ParamUtil.getString(request, Constants.locatorKeyPreferenceName);

        prefs.setValue(Constants.locatorKeyPreferenceName, locatorkey);

        // Microsoft Bing time out
        String bingtimeout = ParamUtil.getString(request, Constants.bingTimeOutPreferenceName);

        prefs.setValue(Constants.bingTimeOutPreferenceName, bingtimeout);

        // Zoomlevel
        String zoomlevel = ParamUtil.getString(request, Constants.zoomLevelPreferenceName);

        prefs.setValue(Constants.zoomLevelPreferenceName, zoomlevel);

        prefs.store();
    }
}
