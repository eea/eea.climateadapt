package nl.wur.alterra.cgi.ace.portlet;

import java.util.ArrayList;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import nl.wur.alterra.cgi.ace.model.AceItem;
import nl.wur.alterra.cgi.ace.model.Project;
import nl.wur.alterra.cgi.ace.model.constants.AceItemType;
import nl.wur.alterra.cgi.ace.model.impl.AceItemImpl;
import nl.wur.alterra.cgi.ace.model.impl.ProjectImpl;
import nl.wur.alterra.cgi.ace.service.AceItemLocalServiceUtil;
import nl.wur.alterra.cgi.ace.service.ProjectLocalServiceUtil;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;

/**
 * Portlet implementation class ShareProjectPortlet
 */
public class ShareProjectPortlet extends ProjectUpdateHelper {

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

            sendSubmitNotification(project);
			request.getPortletSession().setAttribute("lastAddedProjectId", "" + project.getProjectId() );

			SessionMessages.add(request, "contribution-success");
			sendRedirect(request, response);
		}
		else {
			for (String error : errors) {
				SessionErrors.add(request, error);
			}

			PortalUtil.copyRequestParameters(request, response);

			response.setRenderParameter("jspPage", "/html/shareinfo/add_project.jsp");
		}
	}


	/**
	 * Updates the database record of an existing project.
	 *
	 */
	public void updateProject(ActionRequest request, ActionResponse response)
		throws Exception {

		AceItem aceitem = null;

		Project project = null;

		try {
			project = ProjectLocalServiceUtil.getProject(ParamUtil.getLong(request, "projectId"));
		}
		catch (Exception e) {
			project = null;
		}

		if(project != null) {
			projectFromRequest(request, project);

			ArrayList<String> errors = new ArrayList<String>();

			if (ProjectValidator.validateProject(project, errors)) {

				aceitem = AceItemLocalServiceUtil.getAceItemByStoredAt("ace_project_id=" + project.getProjectId());

				ProjectLocalServiceUtil.updateProject(project);

				updateAceItem(project, aceitem);

	            sendSubmitNotification(project);
				request.getPortletSession().setAttribute("lastAddedProjectId", "" + project.getProjectId() );

				SessionMessages.add(request, "contribution-success");
				sendRedirect(request, response);
			}
			else {
				for (String error : errors) {
					SessionErrors.add(request, error);
				}

				PortalUtil.copyRequestParameters(request, response);

				response.setRenderParameter("jspPage", "/html/shareinfo/add_project.jsp");
			}
		}
	}
}
