package nl.wur.alterra.cgi.ace.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class AceItemGoEditPortlet
 */
public class AceItemGoEditPortlet extends MVCPortlet {
    
    public void doView(
            RenderRequest renderRequest, RenderResponse renderResponse)
        throws IOException, PortletException {
    	
    	HttpServletRequest httpRequest = 
    		PortalUtil.getOriginalServletRequest(
    		PortalUtil.getHttpServletRequest(renderRequest) ) ;

		renderRequest.setAttribute(Constants.ACEITEMID, httpRequest.getParameter(Constants.ACEITEMID));
    		
        include(viewJSP, renderRequest, renderResponse);
    }
    
	/**
	 * Sets the preferences: base url for editing
	 *
	 */
	public void setAceItemGoEditPref(ActionRequest request, ActionResponse response) throws Exception {
		String editUrl = ParamUtil.getString(request, Constants.EDITURL);
		PortletPreferences prefs = request.getPreferences();
		prefs.setValue(Constants.EDITURL, editUrl);
		
		prefs.store();
	}
}