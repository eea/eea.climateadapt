package nl.wur.alterra.cgi.ace.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.util.ArrayList;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;

import nl.wur.alterra.cgi.ace.model.Project;
import nl.wur.alterra.cgi.ace.model.impl.ProjectImpl;
import nl.wur.alterra.cgi.ace.service.ProjectLocalServiceUtil;

/**
 * Portlet implementation class ProjectPortlet
 */
public class ProjectPortlet extends MVCPortlet {
 
	/**
	 * Adds a new project to the database
	 * 
	 */
	public void addProject(ActionRequest request, ActionResponse response)
		throws Exception {

		Project project = projectFromRequest(request);

		ArrayList<String> errors = new ArrayList<String>();

		if (ProjectValidator.validateProject(project, errors)) {
			ProjectLocalServiceUtil.addProject(project);

			SessionMessages.add(request, "project-added");

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
	 * Convenience method to create a Project object out of the request. Used
	 * by the Add / Edit methods.
	 *
	 */
	private Project projectFromRequest(PortletRequest request) {
		ThemeDisplay themeDisplay =
			(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);

		ProjectImpl project = new ProjectImpl();
		project.setProjectId(ParamUtil.getLong(request, "projectId"));
		project.setAcronym(ParamUtil.getString(request, "acronym"));
		project.setTitle(ParamUtil.getString(request, "title"));
/*		
		int dateMonth = ParamUtil.getInteger(request, "startdateMonth");
		int dateDay = ParamUtil.getInteger(request, "startdateDay");
		int dateYear = ParamUtil.getInteger(request, "startdateYear");
		Date startdate = PortalUtil.getDate(dateMonth, dateDay, dateYear);
		project.setStartdate(startdate);
		
		dateMonth = ParamUtil.getInteger(request, "enddateMonth");
		dateDay = ParamUtil.getInteger(request, "enddateDay");
		dateYear = ParamUtil.getInteger(request, "enddateYear");
		Date enddate = PortalUtil.getDate(dateMonth, dateDay, dateYear);
		project.setEnddate(enddate);
*/		
		project.setLead(ParamUtil.getString(request, "lead"));
		project.setPartners(ParamUtil.getString(request, "partners"));
		project.setFunding(ParamUtil.getString(request, "funding"));
		String sectors = ParamUtil.getString(request, "sectors");
			
		if( sectors.equalsIgnoreCase("All")) {
			sectors = "A;B;C;D;F;H;I;M;W;";
		}
			
		project.setSectors(sectors);
		project.setSpatiallevel(ParamUtil.getString(request, "spatiallevel"));
		project.setAbstracts(ParamUtil.getString(request, "abstracts"));
		project.setElement(ParamUtil.getString(request, "element"));
		project.setKeywords(ParamUtil.getString(request, "keywords"));
		project.setWebsite(ParamUtil.getString(request, "website"));	
		project.setDuration(ParamUtil.getString(request, "duration"));		
		project.setCompanyId(themeDisplay.getCompanyId());
		project.setGroupId(themeDisplay.getScopeGroupId());

		return project;
	}

	/**
	 * Updates the database record of an existing project.
	 *
	 */
	public void updateProject(ActionRequest request, ActionResponse response)
		throws Exception {

		Project project = projectFromRequest(request);

		ArrayList<String> errors = new ArrayList<String>();

		if (ProjectValidator.validateProject(project, errors)) {
			ProjectLocalServiceUtil.updateProject(project);

			SessionMessages.add(request, "project-updated");

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

		ArrayList<String> errors = new ArrayList<String>();

		if (Validator.isNotNull(projectId)) {
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

		PortletPreferences prefs = request.getPreferences();

		prefs.setValue("rowsPerPage", rowsPerPage);

		prefs.store();
	}
	
	private static Log _log = LogFactoryUtil.getLog(ProjectPortlet.class);

}


