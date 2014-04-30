package nl.wur.alterra.cgi.ace.portlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import nl.wur.alterra.cgi.ace.model.Project;
import nl.wur.alterra.cgi.ace.service.ProjectLocalServiceUtil;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ProjectDetailPortlet
 */
public class ProjectDetailPortlet extends MVCPortlet {
   
    public void doView(
            RenderRequest renderRequest, RenderResponse renderResponse)
        throws IOException, PortletException {
    	
    	HttpServletRequest httpRequest = 
    		PortalUtil.getOriginalServletRequest(
    		PortalUtil.getHttpServletRequest(renderRequest) ) ;
   	
    	renderRequest.setAttribute(Constants.PROJECTID, httpRequest.getParameter("ace_project_id"));
    	
        super.doView(renderRequest, renderResponse);
    }
    
	/**
	 * Increases rating for project.
	 *
	 */
	public void rateUpProject(ActionRequest request, ActionResponse response)
		throws Exception {

		long projectId = ParamUtil.getLong(request, "projectId");

		ArrayList<String> errors = new ArrayList<String>();

		if (Validator.isNotNull(projectId)) {
			Project project = ProjectLocalServiceUtil.getProject(projectId);
			
			project.setRating( project.getRating() + 1 );
			
			ProjectLocalServiceUtil.updateProject(project); 
			
			request.getPortletSession().setAttribute("lastRatedProjectId", "" + projectId);
			
			sendRedirect(request, response);
		}
		else {
			SessionErrors.add(request, "error-rating");
		}
	}  

	/**
	 * Decreases rating for project.
	 *
	 */
	public void rateDownProject(ActionRequest request, ActionResponse response)
		throws Exception {

		long projectId = ParamUtil.getLong(request, "projectId");

		ArrayList<String> errors = new ArrayList<String>();

		if (Validator.isNotNull(projectId)) {
			Project project = ProjectLocalServiceUtil.getProject(projectId);
			
			project.setRating( project.getRating() - 1 );
			
			ProjectLocalServiceUtil.updateProject(project); 
			
			request.getPortletSession().setAttribute("lastRatedProjectId", "" + projectId);
			
			sendRedirect(request, response);
		}
		else {
			SessionErrors.add(request, "error-rating");
		}
	}	
	
	// override
	protected void addSuccessMessage(
        ActionRequest actionRequest, ActionResponse actionResponse) {

        SessionMessages.add(actionRequest, "request_processed", "Thank you for your feedback");
    }
}
