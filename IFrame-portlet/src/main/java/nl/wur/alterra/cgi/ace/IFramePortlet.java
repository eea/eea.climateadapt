package nl.wur.alterra.cgi.ace;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class IFramePortlet
 */
public class IFramePortlet extends MVCPortlet {
 

	 
	/**
	 * Sets the preferences for iframe-tag inline and url 
	 *
	 */
	public void setIFramePref(ActionRequest request, ActionResponse response)
		throws Exception {

		String url = ParamUtil.getString(request, "url");
		
		String inline = ParamUtil.getString(request, "inline");

		PortletPreferences prefs = request.getPreferences();

		prefs.setValue("url", url);

		prefs.setValue("inline-attributes", inline);

		prefs.store();
	}
}
