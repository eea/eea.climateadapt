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

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;

import nl.wur.alterra.cgi.ace.model.AceItem;
import nl.wur.alterra.cgi.ace.model.Project;
import nl.wur.alterra.cgi.ace.model.constants.AceItemElement;
import nl.wur.alterra.cgi.ace.model.constants.AceItemSector;
import nl.wur.alterra.cgi.ace.model.constants.AceItemType;
import nl.wur.alterra.cgi.ace.model.impl.AceItemImpl;
import nl.wur.alterra.cgi.ace.model.impl.ProjectImpl;
import nl.wur.alterra.cgi.ace.search.lucene.ACEIndexSynchronizer;
import nl.wur.alterra.cgi.ace.service.AceItemLocalServiceUtil;
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
	 * Convenience method to  F I L L  a Project object out of the request. Used
	 * by the Add / Edit methods.
	 *
	 */
	private void projectFromRequest(PortletRequest request, Project project) {
		ThemeDisplay themeDisplay =
			(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		
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
		
		String choosensectors = "";
		for(AceItemSector aceitemsector : AceItemSector.values() ) {
			
			if( ParamUtil.getString(request, "chk_sectors_" + aceitemsector.toString()) != null )  {
				String s =  ParamUtil.getString(request, "chk_sectors_" + aceitemsector.toString());
				if(s.equalsIgnoreCase(aceitemsector.toString())) {				
					choosensectors +=  aceitemsector.toString() + ";";
				}
			}
		}
		project.setSectors(choosensectors);
			
		project.setSpatiallevel(ParamUtil.getString(request, "spatiallevel"));
		project.setAbstracts(ParamUtil.getString(request, "abstracts"));
		
		String choosenelements = "";
		for(AceItemElement aceitemelement : AceItemElement.values() ) {
			if( ParamUtil.getString(request, "chk_elements_" + aceitemelement) != null )  {
				String e =  ParamUtil.getString(request, "chk_elements_" + aceitemelement);
				if(e.equalsIgnoreCase(aceitemelement.toString())) {
					choosenelements +=  aceitemelement.toString() + ";";
				}
			}
		}		
		project.setElement(choosenelements);
		
		project.setKeywords(ParamUtil.getString(request, "keywords"));
		project.setWebsite(ParamUtil.getString(request, "website"));	
		project.setDuration(ParamUtil.getString(request, "duration"));
		project.setSpecialtagging(ParamUtil.getString(request, "specialtagging"));
		
		String importance = ParamUtil.getString(request, "chk_importance");
		if(project.getImportance() == 1) {
			project.setImportance( project.getImportance()-1 );
			project.setRating( project.getRating() - 100);

		}
		if( importance != null && importance.equalsIgnoreCase("1")) {
			project.setImportance(project.getImportance()+1);
			project.setRating( project.getRating() + 100);
		}
		
		project.setCompanyId(themeDisplay.getCompanyId());
		project.setGroupId(themeDisplay.getScopeGroupId());
	}

	/**
	 * Updates the database record of an existing project.
	 *
	 */
	public void updateProject(ActionRequest request, ActionResponse response)
		throws Exception {

		Project project = ProjectLocalServiceUtil.getProject(ParamUtil.getLong(request, "projectId"));			
		projectFromRequest(request, project);

		ArrayList<String> errors = new ArrayList<String>();

		if (ProjectValidator.validateProject(project, errors)) {
			ProjectLocalServiceUtil.updateProject(project);
			
			AceItem aceitem = AceItemLocalServiceUtil.getAceItemByStoredAt("ace_project_id=" + project.getProjectId());
			
			updateAceItem(project, aceitem);
			
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

		if (Validator.isNotNull(projectId)) {

			AceItem aceitem = AceItemLocalServiceUtil.getAceItemByStoredAt("ace_project_id=" + projectId);
			// delete the aceitem index entry
			new ACEIndexSynchronizer().delete(aceitem);			
			// delete the aceitem
			AceItemLocalServiceUtil.deleteAceItem(aceitem.getAceItemId());
			
			ProjectLocalServiceUtil.deleteProject(projectId);

			SessionMessages.add(request, "project-deleted");

			sendRedirect(request, response);
		}
		else {
			SessionErrors.add(request, "error-deleting");
		}
	}

	private String coalesce(String aString) {
		String result = "";
		
		if(aString != null) {
			
			result = aString.trim();
		}
		
		return result;
	}
	
	/**
	 * Update the corresponding AceItem when updating a Project.
	 *
	 */
	private void updateAceItem(Project project, AceItem aceitem) throws Exception {

		aceitem.setName(project.getAcronym().trim() + " project");
		
		aceitem.setDescription(project.getTitle());
		
		aceitem.setKeyword(project.getKeywords());
		
		aceitem.setSpatialLayer(project.getSpatiallevel());
		
		aceitem.setSectors_(project.getSectors());
		
		aceitem.setElements_(project.getElement());
		
		aceitem.setRating(project.getRating());
		
		aceitem.setImportance(project.getImportance());
		
		aceitem.setSpecialtagging(project.getSpecialtagging());
		
		aceitem.setDeeplink(project.getWebsite());
		
		aceitem.setControlstatus(project.getControlstatus());
		
		aceitem.setCreator(project.getCreator());
		
		aceitem.setCreationdate(project.getCreationdate());
		
		aceitem.setModerator(project.getModerator());
		
		aceitem.setApprovaldate(project.getApprovaldate());
		
		aceitem.setTextSearch( coalesce( project.getSpecialtagging()) + ' ' +
	               			   aceitem.getName() + ' ' +
				               coalesce( project.getTitle()) + ' ' +
				               coalesce( project.getLead()) + ' ' +
				               coalesce( project.getPartners()) + ' ' +
				               coalesce( project.getFunding()) + ' ' +
				               coalesce( project.getSpatiallevel()) + ' ' +
				               coalesce( project.getAbstracts()) + ' ' +
				               coalesce( project.getKeywords()) + ' ' +
				               coalesce( project.getSpatiallevel()) 
				              );
		
		String sctrs = project.getSectors();
		
		if( ( coalesce(sctrs).length() > 0 ) && ( sctrs.indexOf(";")  ==  sctrs.lastIndexOf(";") ) ) { // one sector
			
			aceitem.setTextSearch( aceitem.getTextSearch() + ' ' + coalesce( sctrs.substring(0, sctrs.indexOf(";") ) ) );
		}
		
		AceItemLocalServiceUtil.updateAceItem(aceitem);

        new ACEIndexSynchronizer().reIndex(aceitem);
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
	
}


