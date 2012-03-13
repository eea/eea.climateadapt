package nl.wur.alterra.cgi.ace.portlet;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;

import java.util.ArrayList;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;

import nl.wur.alterra.cgi.ace.model.AceItem;
import nl.wur.alterra.cgi.ace.model.Project;
import nl.wur.alterra.cgi.ace.model.constants.AceItemType;
import nl.wur.alterra.cgi.ace.model.impl.AceItemImpl;
import nl.wur.alterra.cgi.ace.model.impl.ProjectImpl;
import nl.wur.alterra.cgi.ace.search.lucene.ACEIndexSynchronizer;
import nl.wur.alterra.cgi.ace.search.lucene.ACEIndexUtil;
import nl.wur.alterra.cgi.ace.service.AceItemLocalServiceUtil;
import nl.wur.alterra.cgi.ace.service.ProjectLocalServiceUtil;

/**
 * Portlet implementation class ProjectPortlet
 */
public class ProjectPortlet extends ProjectUpdateHelper {
 
	/**
	 * Adds a new project to the database
	 * 
	 */
	public void addProject(ActionRequest request, ActionResponse response)
		throws Exception {

		Project project = new ProjectImpl(); 
		
		project.setProjectId(ParamUtil.getLong(request, "projectId"));
		projectFromRequest(request, project);

		ArrayList<String> errors = new ArrayList<String>();

		if (ProjectValidator.validateProject(project, errors)) {
			ProjectLocalServiceUtil.addProject(project);
			
			// create an AceItem for this project
			AceItem aceitem = new AceItemImpl();
			aceitem.setAceItemId(ParamUtil.getLong(request, "aceItemId"));
			aceitem.setCompanyId(project.getCompanyId());
			aceitem.setGroupId(project.getGroupId());
			aceitem.setDatatype(AceItemType.RESEARCHPROJECT.toString());
			aceitem.setStoredAt("ace_project_id=" + project.getProjectId());
			aceitem.setStoragetype("PROJECT");
			AceItemLocalServiceUtil.addAceItem(aceitem);
			updateAceItem(project, aceitem);
			
			SessionMessages.add(request, "project-added");

			String notify = ParamUtil.getString(request, "notify_status");
			if( (notify != null ) && (notify.length()>0) && (project.getControlstatus() == ACEIndexUtil.Status_SUBMITTED)) {
				sendSubmitNotification(project);
			}			
			
			sendRedirect(request, response);
		}
		else {
			for (String error : errors) {
				SessionErrors.add(request, error);
			}

			PortalUtil.copyRequestParameters(request, response);

			response.setRenderParameter("jspPage", "/html/project/edit_project.jsp");
		}
	}

	/**
	 * Updates the database record of an existing project.
	 *
	 */
	public void updateProject(ActionRequest request, ActionResponse response)
		throws Exception {
		
		AceItem aceitem = null;
		
		Project project = ProjectLocalServiceUtil.getProject(ParamUtil.getLong(request, "projectId"));	
		
		// retain old and new status
		Short oldapproved = project.getControlstatus();
		Short newapproved = 0;
		String approved = ParamUtil.getString(request, "chk_controlstatus");
		if( (approved != null ) && (approved.length()>0) ) {
			
			newapproved = Short.parseShort(approved);
		}
		if ( (oldapproved == ACEIndexUtil.Status_APPROVED) &&  (newapproved != ACEIndexUtil.Status_APPROVED) ) { 
		// The old record stays untouched, only replacesId gets filled (from now no edit or delete possible anymore)
			project.setReplacesId( project.getProjectId() ) ;
			// Must be done BEFORE projectFromRequest();
			ProjectLocalServiceUtil.updateProject(project);
		}
		
		projectFromRequest(request, project);

		ArrayList<String> errors = new ArrayList<String>();

		if (ProjectValidator.validateProject(project, errors)) {
			
			if ( (oldapproved == ACEIndexUtil.Status_APPROVED) &&  (newapproved != ACEIndexUtil.Status_APPROVED) ) { 
     			// The changed item gets added as a copy with replacesId filled (is already done above)
				// save the new copy: simple addProject
				ProjectLocalServiceUtil.addProject(project);
				// automatically gets a new projectid;
			}
			else {
				
				if ( (newapproved == ACEIndexUtil.Status_APPROVED)  && project.getReplacesId() != 0) {
					// delete the old project which gets replaced, update the corresponding aceitem
					aceitem = AceItemLocalServiceUtil.getAceItemByStoredAt("ace_project_id=" + project.getReplacesId() );
					aceitem.setStoredAt("ace_project_id=" + project.getProjectId());
					ProjectLocalServiceUtil.deleteProject(project.getReplacesId());
					project.setReplacesId( (long) 0);	
				}
				else {
					aceitem = AceItemLocalServiceUtil.getAceItemByStoredAt("ace_project_id=" + project.getProjectId());
				}
				
				ProjectLocalServiceUtil.updateProject(project);
				updateAceItem(project, aceitem);
			}
			
			SessionMessages.add(request, "project-updated");
			
			String notify = ParamUtil.getString(request, "notify_status");
			if( (notify != null ) && (notify.length()>0) && (newapproved == ACEIndexUtil.Status_SUBMITTED)) {
				sendSubmitNotification(project);
			}
			
			sendRedirect(request, response);
		}
		else {
			for (String error : errors) {
				SessionErrors.add(request, error);
			}

			PortalUtil.copyRequestParameters(request, response);

			response.setRenderParameter("jspPage", "/html/project/edit_project.jsp");
		}
	}

	/**
	 * Deletes a project from the database.
	 *
	 */
	public void deleteProject(ActionRequest request, ActionResponse response)
		throws Exception {

		long projectId = ParamUtil.getLong(request, "projectId");

		if (Validator.isNotNull(projectId)) {

			Project project = ProjectLocalServiceUtil.getProject(projectId);
			
			if(project.getReplacesId() != 0) {
				// Candidate gets deleted: the already approved project gets editable again
					project = ProjectLocalServiceUtil.getProject( project.getReplacesId() );
					project.setReplacesId( (long) 0);
					ProjectLocalServiceUtil.updateProject(project);
			}
			else {
				// get the associated aceitem
				AceItem aceitem = AceItemLocalServiceUtil.getAceItemByStoredAt("ace_project_id=" + projectId);
				// delete the aceitem index entry
				new ACEIndexSynchronizer().delete(aceitem);			
				// delete the aceitem
				AceItemLocalServiceUtil.deleteAceItem(aceitem.getAceItemId());				
			}
			
			// delete the project by saved Id (project itself may be the old one here)			
			ProjectLocalServiceUtil.deleteProject(projectId);

			SessionMessages.add(request, "project-deleted");

			sendRedirect(request, response);
		}
		else {
			SessionErrors.add(request, "error-deleting");
		}
	}
	
	/**
	 * Sets the preferences for how many projects can be viewed
	 * per page and the format for the phone number
	 *
	 */
	public void setProjectPref(ActionRequest request, ActionResponse response)
		throws Exception {

		String rowsPerPage = ParamUtil.getString(request, "rowsPerPage");

		String orderByCol = ParamUtil.getString(request, Constants.ORDERBYCOL);

		PortletPreferences prefs = request.getPreferences();

		prefs.setValue(Constants.ORDERBYCOL, orderByCol);

		String orderByType = ParamUtil.getString(request, Constants.ORDERBYTYPE);

		prefs.setValue(Constants.ORDERBYTYPE, orderByType);

		prefs.setValue("rowsPerPage", rowsPerPage);

		prefs.store();
	}
	
}


