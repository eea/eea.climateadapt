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

		// Catalogue Server Servlet URL
		String cswServletUrl = ParamUtil.getString(request, Constants.cswServletURLPreferenceName);
		
		if (! cswServletUrl.endsWith("?")) {
			cswServletUrl += "?";
		}

		prefs.setValue(Constants.cswServletURLPreferenceName, cswServletUrl);

		// Catalogue Server URL
		String cswUrl = ParamUtil.getString(request, Constants.cswURLPreferenceName);
		
		if (! cswUrl.endsWith("?")) {
			cswUrl += "?";
		}

		prefs.setValue(Constants.cswURLPreferenceName, cswUrl);

		// Catalogue Server username
		String cswUserName = ParamUtil.getString(request, Constants.cswUserNamePreferenceName);
		
		prefs.setValue(Constants.cswUserNamePreferenceName, cswUserName);

		// Catalogue Server password
		String cswPassWord = ParamUtil.getString(request, Constants.cswPassWordPreferenceName);
		
		prefs.setValue(Constants.cswPassWordPreferenceName, cswPassWord);

		// Catalogue Server file identifiers
		String cswRecordFileidentifiers = ParamUtil.getString(request, Constants.cswRecordFileIdentifiersPreferenceName);
		
		prefs.setValue(Constants.cswRecordFileIdentifiersPreferenceName, cswRecordFileidentifiers);

		// MapViewer Servlet URL
		String mapViewerServletUrl = ParamUtil.getString(request, Constants.mapViewerServletURLPreferenceName);
		
		prefs.setValue(Constants.mapViewerServletURLPreferenceName, mapViewerServletUrl);
		
		// Zoomlevel
		String zoomlevel = ParamUtil.getString(request, Constants.zoomLevelPreferenceName);
		
		prefs.setValue(Constants.zoomLevelPreferenceName, zoomlevel);
		
		// Store
		prefs.store();
	}
}
