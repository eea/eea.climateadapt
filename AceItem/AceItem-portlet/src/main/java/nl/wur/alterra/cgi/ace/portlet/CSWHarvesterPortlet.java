package nl.wur.alterra.cgi.ace.portlet;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;

import nl.wur.alterra.cgi.ace.harvester.HarvesterExecutionService;
import nl.wur.alterra.cgi.ace.harvester.HarvesterThread;
import nl.wur.alterra.cgi.ace.model.CSWHarvester;
import nl.wur.alterra.cgi.ace.model.constants.HarvesterStatus;
import nl.wur.alterra.cgi.ace.model.impl.CSWHarvesterImpl;
import nl.wur.alterra.cgi.ace.service.CSWHarvesterLocalServiceUtil;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.BooleanUtils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

/**
 * Portlet implementation class CSWHarvesterPortlet.
 *
 * @author heikki doeleman
 */
public class CSWHarvesterPortlet extends LuceneIndexUpdatePortlet {

    /** */
    public static final String SUBMITTED_CSW_HARVESTER_ID_PREFIX = "cswHarvester_";

    /**
     * Adds a new cswharvester to the database
     *
     */
    public void addCSWHarvester(ActionRequest request, ActionResponse response) throws Exception {

        CSWHarvester cswHarvester = new CSWHarvesterImpl();
        cswHarvester.setCswharvesterid(ParamUtil.getLong(request, "cswharvesterid"));
        populateCswHarvester(request, cswHarvester);

        List<String> errors = new ArrayList<String>();
        if (CSWHarvesterValidator.validateCSWHarvester(cswHarvester, errors)) {

            cswHarvester = CSWHarvesterLocalServiceUtil.addCSWHarvester(cswHarvester);

            // See if also needs to be added into GeoNetwork.
            if (isSaveToGeoNetwork(request)) {
                CSWHarvesterLocalServiceUtil.updateCSWHarvester(cswHarvester, Boolean.TRUE, Boolean.TRUE);
            }

            SessionMessages.add(request, "harvester-added");
            sendRedirect(request, response);
        } else {
            for (String error : errors) {
                SessionErrors.add(request, error);
            }
            PortalUtil.copyRequestParameters(request, response);
            response.setRenderParameter("jspPage", "/html/cswharvester/edit_cswharvester.jsp");
        }
    }

    /**
     * Updates the database record of an existing CSWHarvester.
     *
     */
    public void updateCSWHarvester(ActionRequest request, ActionResponse response) throws Exception {

        CSWHarvester cswHarvester = CSWHarvesterLocalServiceUtil.getCSWHarvester(ParamUtil.getLong(request, "cswharvesterid"));
        populateCswHarvester(request, cswHarvester);
        List<String> errors = new ArrayList<String>();
        if (CSWHarvesterValidator.validateCSWHarvester(cswHarvester, errors)) {

            boolean saveInGeo = isSaveToGeoNetwork(request);
            CSWHarvesterLocalServiceUtil.updateCSWHarvester(cswHarvester, Boolean.valueOf(saveInGeo), Boolean.TRUE);
            SessionMessages.add(request, "harvester-updated");
            sendRedirect(request, response);
        } else {
            for (String error : errors) {
                SessionErrors.add(request, error);
            }

            PortalUtil.copyRequestParameters(request, response);
            response.setRenderParameter("jspPage", "/html/cswharvester/edit_cswharvester.jsp");
        }
    }

    /**
     * Sets the preferences for how many CSWHarvesters can be viewed per page.
     *
     */
    public void setAceItemPref(ActionRequest request, ActionResponse response) throws Exception {
        String rowsPerPage = ParamUtil.getString(request, "rowsPerPage");
        PortletPreferences prefs = request.getPreferences();
        prefs.setValue("rowsPerPage", rowsPerPage);
        prefs.store();
    }

    /**
     * Convenience method to create a CSWHarvester object out of the request. Used by the Add / Edit methods.
     *
     */
    private CSWHarvester populateCswHarvester(PortletRequest request, CSWHarvester cswHarvester) {

        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

        cswHarvester.setCompanyId(themeDisplay.getCompanyId());
        cswHarvester.setGroupId(themeDisplay.getScopeGroupId());

        cswHarvester.setEvery(ParamUtil.getInteger(request, "every"));
        cswHarvester.setGeonetworkId(ParamUtil.getLong(request, "geonetworkId"));
        cswHarvester.setGeonetworkUUID(ParamUtil.getString(request, "geonetworkUUID"));
        cswHarvester.setName(ParamUtil.getString(request, "name"));
        cswHarvester.setFreetext(ParamUtil.getString(request, "freeText"));
        cswHarvester.setTitle(ParamUtil.getString(request, "title"));
        cswHarvester.setAbstrakt(ParamUtil.getString(request, "abstrakt"));
        cswHarvester.setSubject(ParamUtil.getString(request, "subject"));
        // cswHarvester.setSavedToGeoNetwork(ParamUtil.getBoolean(request, "savedToGeoNetwork"));
        cswHarvester.setUrl(ParamUtil.getString(request, "url"));
        cswHarvester.setTopic(ParamUtil.getString(request, "topic"));

        cswHarvester.setType(ParamUtil.getString(request, "type"));
        cswHarvester.setUsername(ParamUtil.getString(request, "username"));
        cswHarvester.setPassword(ParamUtil.getString(request, "password"));

        return cswHarvester;
    }

    /**
     *
     * @param request
     * @return
     */
    private boolean isSaveToGeoNetwork(ActionRequest request) {

        String str = ParamUtil.getString(request, "saveInGeoNw");
        return str != null && str.trim().length() > 0;
    }

    /**
     *
     * @param actionRequest
     * @return
     */
    private HashSet<Long> getSubmittedHarvesterIds(ActionRequest actionRequest) {

        HashSet<Long> itemIds = new HashSet<Long>();
        Enumeration<String> paramNames = actionRequest.getParameterNames();
        if (paramNames != null) {
            while (paramNames.hasMoreElements()) {
                String paramName = paramNames.nextElement();
                if (paramName.startsWith(SUBMITTED_CSW_HARVESTER_ID_PREFIX) && ! paramName.contains(  "Checkbox" ) ) {
                    String paramValue = actionRequest.getParameter(paramName);
                    if ( BooleanUtils.toBooleanObject(paramValue) ) {
                        itemIds.add(Long.valueOf(paramName.substring(SUBMITTED_CSW_HARVESTER_ID_PREFIX.length())));
                    }
                }
            }
        }

        return itemIds;
    }

    /**
     *
     * @param harvesterId
     * @param actionRequest
     * @throws PortalException
     * @throws SystemException
     */
    private void deleteHarvester(long harvesterId, ActionRequest actionRequest) throws PortalException, SystemException {

        CSWHarvester cswHarvester = CSWHarvesterLocalServiceUtil.getCSWHarvester(harvesterId);
        CSWHarvesterLocalServiceUtil.deleteCSWHarvester(cswHarvester);
        SessionMessages.add(actionRequest, "harvester-deleted");
    }

    /**
     *
     * @param actionRequest
     * @param actionResponse
     * @throws PortalException
     * @throws SystemException
     */
    private void deleteHarvesters(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException,
            SystemException {

        HashSet<Long> harvesterIds = getSubmittedHarvesterIds(actionRequest);
        if (harvesterIds.isEmpty()) {
            SessionErrors.add(actionRequest, "none-selected");
            return;
        }

        for (Long harvesterId : harvesterIds) {
            deleteHarvester(harvesterId, actionRequest);
        }
    }

    /**
     *
     * @param harvesterId
     * @param actionRequest
     * @throws PortalException
     * @throws SystemException
     */
    private void executeHarvester(long harvesterId, ActionRequest actionRequest) throws PortalException, SystemException {

        CSWHarvester cswHarvester = CSWHarvesterLocalServiceUtil.getCSWHarvester(harvesterId);
        if (cswHarvester.getSavedToGeoNetwork()) {

            cswHarvester.setStatus(HarvesterStatus.RUNNING.name());
            CSWHarvesterLocalServiceUtil.updateCSWHarvester(cswHarvester, Boolean.FALSE, Boolean.FALSE);

            // Schedule in separate thread for immediate execution.
            ScheduledExecutorService executionService = HarvesterExecutionService.getExecutionService();
            executionService.schedule(new HarvesterThread(cswHarvester), 1, TimeUnit.SECONDS);

            SessionMessages.add(actionRequest, "harvester-updated");
        } else {
            SessionErrors.add(actionRequest, "cannot-execute-nongeo-harvester");
        }
    }

    /**
     *
     * @param actionRequest
     * @param actionResponse
     * @throws PortalException
     * @throws SystemException
     */
    private void executeHarvesters(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException,
            SystemException {

        HashSet<Long> harvesterIds = getSubmittedHarvesterIds(actionRequest);
        if (harvesterIds.isEmpty()) {
            SessionErrors.add(actionRequest, "none-selected");
            return;
        }

        for (Long harvesterId : harvesterIds) {
            executeHarvester(harvesterId, actionRequest);
        }
    }

    /**
     *
     * @param actionRequest
     * @param actionResponse
     * @throws Exception
     */
    public void harvestersFormSubmitted(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        String submitAction = actionRequest.getParameter("submitAction");
        if (StringUtils.isBlank(submitAction)) {
            return;
        }

        if (submitAction.equals("delete")) {
            deleteHarvesters(actionRequest, actionResponse);
        } else if (submitAction.equals("execute")) {
            executeHarvesters(actionRequest, actionResponse);
        }

        sendRedirect(actionRequest, actionResponse);
    }
}