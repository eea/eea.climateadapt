package nl.wur.alterra.cgi.ace.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import nl.wur.alterra.cgi.ace.model.Project;
import nl.wur.alterra.cgi.ace.service.ProjectLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ProjectGoEditPortlet
 */
public class ProjectGoEditPortlet extends MVCPortlet {
    
    public void doView(
            RenderRequest renderRequest, RenderResponse renderResponse)
        throws IOException, PortletException {
    	
    	HttpServletRequest httpRequest = 
    		PortalUtil.getOriginalServletRequest(
    		PortalUtil.getHttpServletRequest(renderRequest) ) ;
    	
    	if( httpRequest.getParameter("ace_project_id") != null ) {
    		try {
    			Project project = ProjectLocalServiceUtil.getProject( Long.parseLong(httpRequest.getParameter("ace_project_id") ) ) ;
    			
    			if(project.getReplacesId() != project.getProjectId()) { 
    			// there is no candidate item for this item: edit is permitted
        	    	renderRequest.setAttribute(Constants.PROJECTID, httpRequest.getParameter("ace_project_id"));
        	    }
    		}
    		catch (Exception e) {
    			System.out.println(e.getMessage()) ;
    			e.printStackTrace(System.out) ;
    		}
    	}
    	
    		
        include(viewJSP, renderRequest, renderResponse);
    }
    
	/**
	 * Sets the preferences: base url for editing
	 *
	 */
	public void setProjectGoEditPref(ActionRequest request, ActionResponse response) throws Exception {
		String editUrl = ParamUtil.getString(request, Constants.EDITURL);
		PortletPreferences prefs = request.getPreferences();
		prefs.setValue(Constants.EDITURL, editUrl);

		String shareInfoEditUrl = ParamUtil.getString(request, Constants.SHAREINFOEDITURL);
		prefs.setValue(Constants.SHAREINFOEDITURL, shareInfoEditUrl);
		
		prefs.store();
	} 

}
