package nl.wur.alterra.cgi.ace.portlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class MapViewerPortlet
 */
public class MapViewerPortlet extends MVCPortlet {

    public void setPreferences(ActionRequest request, ActionResponse response) throws Exception {
        PortletPreferences prefs = request.getPreferences();

        // Proxy
        String proxyUrl = ParamUtil.getString(request, Constants.proxyUrlPreferenceName);

        prefs.setValue(Constants.proxyUrlPreferenceName, proxyUrl);

        // Catalogue Server URL
        String cswUrl = ParamUtil.getString(request, Constants.cswURLPreferenceName);

        if (! cswUrl.endsWith("/")) {
            cswUrl += "/";
        }

        prefs.setValue(Constants.cswURLPreferenceName, cswUrl);

        // Catalogue Server csw path
        String cswCsw = ParamUtil.getString(request, Constants.cswCswPreferenceName);

        if (! cswUrl.endsWith("?")) {
            cswUrl += "?";
        }

        prefs.setValue(Constants.cswCswPreferenceName, cswCsw);

        // Catalogue Server show metadata path
        String cswShowMetadata = ParamUtil.getString(request, Constants.cswShowMetadataPreferenceName);

        prefs.setValue(Constants.cswShowMetadataPreferenceName, cswShowMetadata);

        // Catalogue Server username
        String cswUserName = ParamUtil.getString(request, Constants.cswUserNamePreferenceName);

        prefs.setValue(Constants.cswUserNamePreferenceName, cswUserName);

        // Catalogue Server password
        String cswPassWord = ParamUtil.getString(request, Constants.cswPassWordPreferenceName);

        prefs.setValue(Constants.cswPassWordPreferenceName, cswPassWord);

        // CSW Servlet URL
        String cswServletUrl = ParamUtil.getString(request, Constants.cswServletURLPreferenceName);

        prefs.setValue(Constants.cswServletURLPreferenceName, cswServletUrl);

        // MapViewer Servlet URL
        String mapViewerServletUrl = ParamUtil.getString(request, Constants.mapViewerServletURLPreferenceName);

        prefs.setValue(Constants.mapViewerServletURLPreferenceName, mapViewerServletUrl);

        // MapViewer app ID
        String mapViewerAppId = ParamUtil.getString(request, Constants.mapViewerAppIdPreferenceName);

        prefs.setValue(Constants.mapViewerWmcDirectoryPreferenceName, mapViewerAppId);

        // MapViewer WMC Directory name
        String mapViewerWmcDirectoryName = ParamUtil.getString(request, Constants.mapViewerWmcDirectoryPreferenceName);

        prefs.setValue(Constants.mapViewerWmcDirectoryPreferenceName, mapViewerWmcDirectoryName);

        // Store
        prefs.store();
    }
}
