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
		String geoserverUrl = ParamUtil.getString(request, Constants.geoserverUrlPreferenceName);
		
		if (! geoserverUrl.endsWith("/")) {
			geoserverUrl += "/";
		}

		PortletPreferences prefs = request.getPreferences();

		prefs.setValue(Constants.geoserverUrlPreferenceName, geoserverUrl);

		prefs.store();
	}
}
