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
import nl.wur.alterra.cgi.ace.model.WxsHarvester;
import nl.wur.alterra.cgi.ace.model.constants.HarvesterStatus;
import nl.wur.alterra.cgi.ace.model.impl.WxsHarvesterImpl;
import nl.wur.alterra.cgi.ace.service.WxsHarvesterLocalServiceUtil;

import org.apache.commons.lang.StringUtils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

/**
 * Portlet implementation class WxsHarvesterPortlet.
 *
 * @author heikki doeleman
 */
public class WxsHarvesterPortlet extends LuceneIndexUpdatePortlet {

    /** */
    public static final String SUBMITTED_WXS_HARVESTER_ID_PREFIX = "wxsHarvester_";

    /**
     * Adds a new wxsharvester to the database
     *
     */
    public void addWxsHarvester(ActionRequest request, ActionResponse response) throws Exception {

        WxsHarvester wxsHarvester = new WxsHarvesterImpl();
        wxsHarvester.setWxsharvesterid(ParamUtil.getLong(request, "WxsHarvesterId"));
        populateWxsHarvester(request, wxsHarvester);

        List<String> errors = new ArrayList<String>();
        if (WxsHarvesterValidator.validateWxsHarvester(wxsHarvester, errors)) {

            wxsHarvester = WxsHarvesterLocalServiceUtil.addWxsHarvester(wxsHarvester);

            // See if also needs to be added into GeoNetwork.
            if (isSaveToGeoNetwork(request)) {
                WxsHarvesterLocalServiceUtil.updateWxsHarvester(wxsHarvester, Boolean.TRUE, Boolean.TRUE);
            }

            SessionMessages.add(request, "harvester-added");
            sendRedirect(request, response);
        } else {
            for (String error : errors) {
                SessionErrors.add(request, error);
            }
            PortalUtil.copyRequestParameters(request, response);
            response.setRenderParameter("jspPage", "/html/wxsharvester/edit_wxsharvester.jsp");
        }
    }

    /**
     * Updates the database record of an existing WxsHarvester.
     *
     */
    public void updateWxsHarvester(ActionRequest request, ActionResponse response) throws Exception {

        WxsHarvester wxsHarvester = WxsHarvesterLocalServiceUtil.getWxsHarvester(ParamUtil.getLong(request, "wxsharvesterid"));
        populateWxsHarvester(request, wxsHarvester);

        List<String> errors = new ArrayList<String>();
        if (WxsHarvesterValidator.validateWxsHarvester(wxsHarvester, errors)) {

            boolean saveInGeo = isSaveToGeoNetwork(request);
            WxsHarvesterLocalServiceUtil.updateWxsHarvester(wxsHarvester, Boolean.valueOf(saveInGeo), Boolean.TRUE);

            SessionMessages.add(request, "harvester-updated");
            sendRedirect(request, response);
        } else {
            for (String error : errors) {
                SessionErrors.add(request, error);
            }

            PortalUtil.copyRequestParameters(request, response);
            response.setRenderParameter("jspPage", "/html/wxsharvester/edit_wxsharvester.jsp");
        }
    }

    /**
     * Sets the preferences for how many WxsHarvesters can be viewed per page.
     *
     */
    public void setAceItemPref(ActionRequest request, ActionResponse response) throws Exception {
        String rowsPerPage = ParamUtil.getString(request, "rowsPerPage");
        PortletPreferences prefs = request.getPreferences();
        prefs.setValue("rowsPerPage", rowsPerPage);
        prefs.store();
    }

    /**
     * Convenience method to create a WxsHarvester object out of the request. Used by the Add / Edit methods.
     *
     */
    private WxsHarvester populateWxsHarvester(PortletRequest request, WxsHarvester wxsHarvester) {
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

        wxsHarvester.setCompanyId(themeDisplay.getCompanyId());
        wxsHarvester.setGroupId(themeDisplay.getScopeGroupId());

        wxsHarvester.setEvery(ParamUtil.getInteger(request, "every"));
        wxsHarvester.setGeonetworkId(ParamUtil.getLong(request, "geonetworkId"));
        wxsHarvester.setGeonetworkUUID(ParamUtil.getString(request, "geonetworkUUID"));
        wxsHarvester.setName(ParamUtil.getString(request, "name"));
        wxsHarvester.setOgctype(ParamUtil.getString(request, "ogctype"));
        // wxsHarvester.setSavedToGeoNetwork(ParamUtil.getBoolean(request, "savedToGeoNetwork"));
        wxsHarvester.setUrl(ParamUtil.getString(request, "url"));
        wxsHarvester.setTopic(ParamUtil.getString(request, "topic"));

        return wxsHarvester;
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
                if (paramName.startsWith(SUBMITTED_WXS_HARVESTER_ID_PREFIX)) {
                    String paramValue = actionRequest.getParameter(paramName);
                    if (StringUtils.equals(paramValue, String.valueOf(true))) {
                        itemIds.add(Long.valueOf(paramName.substring(SUBMITTED_WXS_HARVESTER_ID_PREFIX.length())));
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

        WxsHarvester wxsHarvester = WxsHarvesterLocalServiceUtil.getWxsHarvester(harvesterId);
        WxsHarvesterLocalServiceUtil.deleteWxsHarvester(wxsHarvester);
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

        WxsHarvester wxsHarvester = WxsHarvesterLocalServiceUtil.getWxsHarvester(harvesterId);
        if (wxsHarvester.getSavedToGeoNetwork()) {

            wxsHarvester.setStatus(HarvesterStatus.RUNNING.name());
            WxsHarvesterLocalServiceUtil.updateWxsHarvester(wxsHarvester, Boolean.FALSE, Boolean.FALSE);

            // Schedule in separate thread for immediate execution.
            ScheduledExecutorService executionService = HarvesterExecutionService.getExecutionService();
            executionService.schedule(new HarvesterThread(wxsHarvester), 1, TimeUnit.SECONDS);

            // Add feedback message.
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
