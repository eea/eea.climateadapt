package nl.wur.alterra.cgi.ace;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class FreeHTMLportlet
 * 
 * Purpose: add some text which may only be seen by authorised users
 * Authorisation check is done by setting view permissions for portlet
 * 
 */
public class FreeHTMLportlet extends MVCPortlet {
	
	/**
	 * Sets the preferences for htmltext
	 *
	 */
	public void setHTMLTextPref(ActionRequest request, ActionResponse response)
		throws Exception {

		String htmltext = ParamUtil.getString(request, "htmltext");

		PortletPreferences prefs = request.getPreferences();

		prefs.setValue("htmltext", htmltext);

		prefs.store();
	} 

}
