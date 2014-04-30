package nl.wur.alterra.cgi.ace.portlet;

import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;

import nl.wur.alterra.cgi.ace.model.AceItem;
import nl.wur.alterra.cgi.ace.model.Project;
import nl.wur.alterra.cgi.ace.model.constants.AceItemType;
import nl.wur.alterra.cgi.ace.model.impl.ProjectImpl;
import nl.wur.alterra.cgi.ace.search.lucene.ACEIndexSynchronizer;
import nl.wur.alterra.cgi.ace.search.lucene.ACEIndexUtil;
import nl.wur.alterra.cgi.ace.service.AceItemLocalServiceUtil;
import nl.wur.alterra.cgi.ace.service.ProjectLocalServiceUtil;

import org.apache.commons.lang.StringUtils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;

/**
 * Portlet implementation class ProjectPortlet
 */
public class ProjectPortlet extends ProjectUpdateHelper {

    /** */
    public static final String SUBMITTED_PROJECT_ID_PREFIX = "project_";

    /**
     *
     * @param request
     * @param response
     */
    public void addProject(ActionRequest request, ActionResponse response) {

        try {
            doAddProject(request, response);
        } catch (Exception e) {
            e.printStackTrace();

            SessionErrors.add(request, "project-add-tech-error");
            PortalUtil.copyRequestParameters(request, response);
            response.setRenderParameter("jspPage", "/html/project/edit_project.jsp");
        }
    }

    /**
     * Adds an aceitem to the database for the project
     *
     */
    private AceItem createAceItemInsideDB(Project project) throws Exception {
    	AceItem aceitem = AceItemLocalServiceUtil.createAceItem();
        //aceitem.setAceItemId(ParamUtil.getLong(request, "aceItemId"));
        aceitem.setCompanyId(project.getCompanyId());
        aceitem.setGroupId(project.getGroupId());
        aceitem.setDatatype(AceItemType.RESEARCHPROJECT.toString());
        aceitem.setStoredAt("ace_project_id=" + project.getProjectId());
        aceitem.setStoragetype("PROJECT");
        AceItemLocalServiceUtil.addAceItem(aceitem);
    	return aceitem;
    }


    /**
     * Adds a new project to the database
     *
     */
    private void doAddProject(ActionRequest request, ActionResponse response) throws Exception {

        Project project = new ProjectImpl();

        project.setProjectId(ParamUtil.getLong(request, "projectId"));
        projectFromRequest(request, project);

        ArrayList<String> errors = new ArrayList<String>();

        if (ProjectValidator.validateProject(project, errors)) {
            ProjectLocalServiceUtil.addProject(project);

            // create an AceItem for this project
            AceItem aceitem = createAceItemInsideDB(project);
            updateAceItem(project, aceitem);

            SessionMessages.add(request, "project-added");

            String notify = ParamUtil.getString(request, "notify_status");
            if ((notify != null) && (notify.length() > 0) && (project.getControlstatus() == ACEIndexUtil.Status_SUBMITTED)) {
                sendSubmitNotification(project);
            }

            sendRedirect(request, response);
        } else {
            for (String error : errors) {
                SessionErrors.add(request, error);
            }

            PortalUtil.copyRequestParameters(request, response);

            response.setRenderParameter("jspPage", "/html/project/edit_project.jsp");
        }
    }

    /**
     *
     * @param request
     * @param response
     */
    public void updateProject(ActionRequest request, ActionResponse response) {
        try {
            doUpdateProject(request, response);
        } catch (Exception e) {
            e.printStackTrace();

            SessionErrors.add(request, "project-save-tech-error");
            PortalUtil.copyRequestParameters(request, response);
            response.setRenderParameter("jspPage", "/html/project/edit_project.jsp");
        }
    }

    /**
     * Updates the database record of an existing project.
     *
     */
    private void doUpdateProject(ActionRequest request, ActionResponse response) throws Exception {

        AceItem aceitem = null;

        Project project = null;

        try {
            project = ProjectLocalServiceUtil.getProject(ParamUtil.getLong(request, "projectId"));
        } catch (Exception e) {
            project = null;
        }

        if (project != null) {
            // retain old and new status
            Short oldapproved = project.getControlstatus();
            Short newapproved = 0;
            String approved = ParamUtil.getString(request, "chk_controlstatus");
            if ((approved != null) && (approved.length() > 0)) {

                newapproved = Short.parseShort(approved);
            }
            if ((oldapproved == ACEIndexUtil.Status_APPROVED) && (newapproved != ACEIndexUtil.Status_APPROVED)) {
                // The old record stays untouched, only replacesId gets filled
                // (from now no edit or delete possible anymore)
                project.setReplacesId(project.getProjectId());
                // Must be done BEFORE projectFromRequest();
                ProjectLocalServiceUtil.updateProject(project);
            }

            projectFromRequest(request, project);

            ArrayList<String> errors = new ArrayList<String>();

            if (ProjectValidator.validateProject(project, errors)) {

                if ((oldapproved == ACEIndexUtil.Status_APPROVED) && (newapproved != ACEIndexUtil.Status_APPROVED)) {
                    // The changed item gets added as a copy with replacesId
                    // filled (is already done above)
                    // save the new copy: simple addProject
                    ProjectLocalServiceUtil.addProject(project);
                    // automatically gets a new projectid;
                } else {

                    if ((newapproved == ACEIndexUtil.Status_APPROVED) && project.getReplacesId() != 0) {
                        // delete the old project which gets replaced, update
                        // the corresponding aceitem
                        aceitem = AceItemLocalServiceUtil.getAceItemByStoredAt("ace_project_id=" + project.getReplacesId());
                        if (aceitem == null){
                            aceitem = createAceItemInsideDB(project);
                        }
                        aceitem.setStoredAt("ace_project_id=" + project.getProjectId());
                        ProjectLocalServiceUtil.deleteProject(project.getReplacesId());
                        project.setReplacesId((long) 0);
                    } else {
                        aceitem = AceItemLocalServiceUtil.getAceItemByStoredAt("ace_project_id=" + project.getProjectId());
                        if (aceitem == null){
                            aceitem = createAceItemInsideDB(project);
                        }
                    }

                    if (oldapproved == ACEIndexUtil.Status_SUBMITTED && newapproved == ACEIndexUtil.Status_APPROVED){
                        project.setApprovaldate( new Date() );
                    }

                    ProjectLocalServiceUtil.updateProject(project);
                    if (aceitem != null) {
                        updateAceItem(project, aceitem);
                    }
                }

                if (oldapproved == ACEIndexUtil.Status_SUBMITTED && newapproved == ACEIndexUtil.Status_APPROVED){
                    sendApprovalNotification(project);
                }

                SessionMessages.add(request, "project-updated");

                String notify = ParamUtil.getString(request, "notify_status");
                if ((notify != null) && (notify.length() > 0) && (newapproved == ACEIndexUtil.Status_SUBMITTED)) {
                    sendSubmitNotification(project);
                }

                sendRedirect(request, response);
            } else {
                for (String error : errors) {
                    SessionErrors.add(request, error);
                }

                PortalUtil.copyRequestParameters(request, response);

                response.setRenderParameter("jspPage", "/html/project/edit_project.jsp");
            }
        }
    }

    /**
     * Sets the preferences for how many projects can be viewed per page and
     * other preferences
     *
     */
    public void setProjectPref(ActionRequest request, ActionResponse response) throws Exception {

        String rowsPerPage = ParamUtil.getString(request, "rowsPerPage");

        String orderByCol = ParamUtil.getString(request, Constants.ORDERBYCOL);

        PortletPreferences prefs = request.getPreferences();

        prefs.setValue(Constants.ORDERBYCOL, orderByCol);

        String orderByType = ParamUtil.getString(request, Constants.ORDERBYTYPE);

        prefs.setValue(Constants.ORDERBYTYPE, orderByType);

        prefs.setValue("rowsPerPage", rowsPerPage);

        prefs.store();
    }

    /**
     *
     * @param projectId
     * @param actionRequest
     * @throws PortalException
     * @throws SystemException
     */
    private void deleteProject(long projectId, ActionRequest actionRequest) throws PortalException, SystemException {

        // Get project object from the service.
        Project project = null;
        try {
            project = ProjectLocalServiceUtil.getProject(projectId);
        } catch (Exception e) {
            project = null;
        }

        // If project object found.
        if (project != null) {

            // Candidate gets deleted: the already approved project gets
            // editable again.
            if (project.getReplacesId() != 0) {

                project = ProjectLocalServiceUtil.getProject(project.getReplacesId());
                if (project != null){
                    project.setReplacesId((long) 0);
                    ProjectLocalServiceUtil.updateProject(project);
                }
            } else {
                // Get the associated ace-item.
                AceItem aceitem = AceItemLocalServiceUtil.getAceItemByStoredAt("ace_project_id=" + projectId);

                if (aceitem != null){
                    // Delete the ace-item index entry.
                    new ACEIndexSynchronizer().delete(aceitem);
                    // Delete the ace-item.
                    AceItemLocalServiceUtil.deleteAceItem(aceitem.getAceItemId());
                }
            }

            // Delete the project by saved Id (project itself may be the old one
            // here).
            ProjectLocalServiceUtil.deleteProject(projectId);

            SessionMessages.add(actionRequest, "project-deleted");
        }
    }

    /**
     *
     * @param actionRequest
     * @param actionResponse
     * @throws PortalException
     * @throws SystemException
     */
    private void deleteProjects(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException {

        HashSet<Long> projectIds = getSubmittedProjectIds(actionRequest);
        if (projectIds.isEmpty()) {
            SessionErrors.add(actionRequest, "none-selected");
            return;
        }

        for (Long projectId : projectIds) {
            deleteProject(projectId, actionRequest);
        }
    }

    /**
     *
     * @param actionRequest
     * @return
     */
    private HashSet<Long> getSubmittedProjectIds(ActionRequest actionRequest) {

        HashSet<Long> itemIds = new HashSet<Long>();
        Enumeration<String> paramNames = actionRequest.getParameterNames();
        if (paramNames != null) {
            while (paramNames.hasMoreElements()) {
                String paramName = paramNames.nextElement();
                if (paramName.startsWith(SUBMITTED_PROJECT_ID_PREFIX)) {
                    String paramValue = actionRequest.getParameter(paramName);
                    if (StringUtils.equals(paramValue, String.valueOf(true))) {
                        itemIds.add(Long.valueOf(paramName.substring(SUBMITTED_PROJECT_ID_PREFIX.length())));
                    }
                }
            }
        }

        return itemIds;
    }

    /**
     *
     * @param actionRequest
     * @param actionResponse
     * @throws Exception
     */
    public void projectsFormSubmitted(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        String submitAction = actionRequest.getParameter("submitAction");
        if (StringUtils.isBlank(submitAction)) {
            return;
        }

        if (submitAction.equals("delete")) {
            try {
                deleteProjects(actionRequest, actionResponse);
            } catch (Exception e) {
                e.printStackTrace();
                SessionErrors.add(actionRequest, "project-delete-tech-error");
            }
        }

        sendRedirect(actionRequest, actionResponse);
    }

}
