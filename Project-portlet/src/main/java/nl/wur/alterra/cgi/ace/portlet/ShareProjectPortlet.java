package nl.wur.alterra.cgi.ace.portlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import nl.wur.alterra.cgi.ace.model.AceItem;
import nl.wur.alterra.cgi.ace.model.Project;
import nl.wur.alterra.cgi.ace.model.constants.AceItemType;
import nl.wur.alterra.cgi.ace.model.impl.ProjectImpl;
import nl.wur.alterra.cgi.ace.service.AceItemLocalServiceUtil;
import nl.wur.alterra.cgi.ace.service.ProjectLocalServiceUtil;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;

/**
 * Portlet implementation class ShareProjectPortlet
 */
public class ShareProjectPortlet extends ProjectUpdateHelperRevised {

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        try {
            HttpServletRequest httpRequest =
                PortalUtil.getOriginalServletRequest(
                PortalUtil.getHttpServletRequest(renderRequest) ) ;

            try {
                int projectid = Integer.parseInt( httpRequest.getParameter("submissionid") ) ;
                renderRequest.getPortletSession().setAttribute("lastAddedProjectId", "" +  projectid );
            } catch (NumberFormatException e) {
                // do nothing
            }

        } catch (Exception x) {
            x.printStackTrace();
            throw new PortletException(x);
        }
        super.doView(renderRequest, renderResponse);
    }

    /**
     * Adds a new project to the database
     *
     */
    public void addProject(ActionRequest request, ActionResponse response)
        throws Exception {
        Project project = new ProjectImpl();
        UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
        String project_id = uploadRequest.getParameter("projectId");

        if (Validator.isNull(project_id))
        {
            project.setProjectId(0);
        } else {
            project.setProjectId(ParamUtil.getLong(request, "projectId"));
        }

        ArrayList<String> errors = new ArrayList<String>();
        projectFromRequest(request, project, uploadRequest, errors);

        if (ProjectValidator.validateProject(project, errors)) {
            ProjectLocalServiceUtil.addProject(project);

            // create an AceItem for this project
            AceItem aceitem = AceItemLocalServiceUtil.createAceItem();
            aceitem.setAceItemId(ParamUtil.getLong(request, "aceItemId"));
            aceitem.setCompanyId(project.getCompanyId());
            aceitem.setGroupId(project.getGroupId());
            aceitem.setDatatype(AceItemType.RESEARCHPROJECT.toString());
            aceitem.setStoredAt("ace_project_id=" + project.getProjectId());
            aceitem.setStoragetype("PROJECT");
            AceItemLocalServiceUtil.addAceItem(aceitem);
            updateAceItem(project, aceitem);

            /*sendSubmitNotification(project);
            request.getPortletSession().setAttribute("lastAddedProjectId", "" + project.getProjectId() ); */

            request.setAttribute("justsaved", "true");
            request.setAttribute("projectId", project.getProjectId());
            SessionMessages.add(request, "contribution-success");
            response.setRenderParameter("jspPage", "/html/shareinfo/add_projectRevised.jsp");
            //sendRedirect(request, response);
        } else {
            for (String error : errors) {
                SessionErrors.add(request, error);
            }

            SessionErrors.add(request, "invalid-form-data");
            PortalUtil.copyRequestParameters(request, response);
            request.setAttribute("project", project);
            response.setRenderParameter("jspPage", "/html/shareinfo/add_projectRevised.jsp");
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
        UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);

        try {
            project = ProjectLocalServiceUtil.getProject(ParamUtil.getLong(uploadRequest, "projectId"));
        } catch (Exception e) {
            e.printStackTrace();
            project = null;
        }

        if(project != null) {
            ArrayList<String> errors = new ArrayList<String>();
            projectFromRequest(request, project, uploadRequest, errors);

            if (ProjectValidator.validateProject(project, errors)) {

                aceitem = AceItemLocalServiceUtil.getAceItemByStoredAt("ace_project_id=" + project.getProjectId());
                ProjectLocalServiceUtil.updateProject(project);

                updateAceItem(project, aceitem);

                // send the mail only when it is a submit
                if (project.getControlstatus() == -1)
                {
                    request.setAttribute("justsaved", "true" );
                    request.setAttribute("projectId", project.getProjectId());
                    response.setRenderParameter("jspPage", "/html/shareinfo/add_projectRevised.jsp");

                } else {
                   sendSubmitNotification(project);
                   SessionMessages.add(request, "contribution-success");
                   sendRedirect(request, response);
                }
            } else {
                for (String error : errors) {
                    SessionErrors.add(request, error);
                }

                SessionErrors.add(request, "invalid-form-data");
                PortalUtil.copyRequestParameters(request, response);
                request.setAttribute("projectId", project.getProjectId());
                response.setRenderParameter("jspPage", "/html/shareinfo/add_projectRevised.jsp");
            }
        }
    }
}
