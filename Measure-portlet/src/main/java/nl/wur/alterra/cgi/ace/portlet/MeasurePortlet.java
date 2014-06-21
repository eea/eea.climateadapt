package nl.wur.alterra.cgi.ace.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;

import nl.wur.alterra.cgi.ace.model.AceItem;
import nl.wur.alterra.cgi.ace.model.Measure;
import nl.wur.alterra.cgi.ace.model.impl.MeasureImpl;
import nl.wur.alterra.cgi.ace.search.lucene.ACEIndexSynchronizer;
import nl.wur.alterra.cgi.ace.search.lucene.ACEIndexUtil;
import nl.wur.alterra.cgi.ace.service.AceItemLocalServiceUtil;
import nl.wur.alterra.cgi.ace.service.MeasureLocalServiceUtil;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.BooleanUtils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;

/**
 * Portlet implementation class MeasurePortlet
 */
public class MeasurePortlet extends MeasureUpdateHelper {

    /** */
    public static final String SUBMITTED_MEASURE_ID_PREFIX = "measure_";

    /**
     * @param request
     * @param response
     */
    public void addMeasure(ActionRequest request, ActionResponse response){
        try {
            doAddMeasure(request, response);
        } catch (Exception e) {
            e.printStackTrace();

            SessionErrors.add(request, "measure-add-tech-error");
            PortalUtil.copyRequestParameters(request, response);
            response.setRenderParameter("jspPage", "/html/measure/edit_measure.jsp");
        }
    }

    /**
     * Adds an aceitem to the database for the measure
     *
     */
    private AceItem createAceItemInsideDB (Measure measure) throws Exception {
        AceItem aceitem = AceItemLocalServiceUtil.createAceItem();
        //aceitem.setAceItemId(ParamUtil.getLong(request, "aceItemId"));
        aceitem.setCompanyId(measure.getCompanyId());
        aceitem.setGroupId(measure.getGroupId());
        aceitem.setStoredAt("ace_measure_id=" + measure.getMeasureId());
        aceitem.setStoragetype("MEASURE");
        AceItemLocalServiceUtil.addAceItem(aceitem);
        return aceitem;
    }

    /**
     * Adds a new measure to the database
     *
     */
    private void doAddMeasure(ActionRequest request, ActionResponse response) throws Exception {

        Measure measure = new MeasureImpl();

        measure.setMeasureId(ParamUtil.getLong(request, "measureId"));
        measureFromRequest(request, measure);

        ArrayList<String> errors = new ArrayList<String>();

        if (MeasureValidator.validateMeasure(measure, errors)) {
            MeasureLocalServiceUtil.addMeasure(measure);

            // create an AceItem for this measure
            AceItem aceitem = createAceItemInsideDB(measure);
            updateAceItem(measure, aceitem);

            SessionMessages.add(request, "measure-added");

            String notify = ParamUtil.getString(request, "notify_status");
            if ((notify != null) && (notify.length() > 0) && (measure.getControlstatus() == ACEIndexUtil.Status_SUBMITTED)) {
                sendSubmitNotification(measure);
            }

            sendRedirect(request, response);
        } else {
            for (String error : errors) {
                SessionErrors.add(request, error);
            }
            PortalUtil.copyRequestParameters(request, response);
            response.setRenderParameter("jspPage", "/html/measure/edit_measure.jsp");
        }
    }

    /**
     *
     * @param request
     * @param response
     */
    public void updateMeasure(ActionRequest request, ActionResponse response){
        try {
            doUpdateMeasure(request, response);
        } catch (Exception e) {
            e.printStackTrace();

            SessionErrors.add(request, "measure-save-tech-error");
            PortalUtil.copyRequestParameters(request, response);
            response.setRenderParameter("jspPage", "/html/measure/edit_measure.jsp");
        }
    }

    /**
     * Updates the database record of an existing measure.
     *
     */
    private void doUpdateMeasure(ActionRequest request, ActionResponse response) throws Exception {

        AceItem aceitem = null;

        Measure measure = null;

        try {
            measure = MeasureLocalServiceUtil.getMeasure(ParamUtil.getLong(request, "measureId"));
        } catch (Exception e) {
            measure = null;
        }

        if (measure != null) {
            // retain old and new status
            Short oldapproved = measure.getControlstatus();
            Short newapproved = 0;
            String approved = ParamUtil.getString(request, "chk_controlstatus");
            if ((approved != null) && (approved.length() > 0)) {

                newapproved = Short.parseShort(approved);
            }
            if ((oldapproved == ACEIndexUtil.Status_APPROVED) && (newapproved != ACEIndexUtil.Status_APPROVED)) {
                // The old record stays untouched, only replacesId gets filled (from now no edit or delete possible anymore)
                measure.setReplacesId(measure.getMeasureId());
                // Must be done BEFORE measureFromRequest();
                MeasureLocalServiceUtil.updateMeasure(measure);
            }

            measureFromRequest(request, measure);

            ArrayList<String> errors = new ArrayList<String>();

            if (MeasureValidator.validateMeasure(measure, errors)) {

                if ((oldapproved == ACEIndexUtil.Status_APPROVED) && (newapproved != ACEIndexUtil.Status_APPROVED)) {
                    // The changed item gets added as a copy with replacesId filled (is already done above)
                    // save the new copy: simple addMeasure
                    MeasureLocalServiceUtil.addMeasure(measure);
                    // automatically gets a new measureid;
                } else {

                    if ((newapproved == ACEIndexUtil.Status_APPROVED) && measure.getReplacesId() != 0) {
                        // delete the old measure which gets replaced, update the corresponding aceitem
                        aceitem = AceItemLocalServiceUtil.getAceItemByStoredAt("ace_measure_id=" + measure.getReplacesId());
                        if (aceitem == null){
                            aceitem = createAceItemInsideDB(measure);
                        }
                        aceitem.setStoredAt("ace_measure_id=" + measure.getMeasureId());
                        MeasureLocalServiceUtil.deleteMeasure(measure.getReplacesId());
                        measure.setReplacesId((long) 0);
                    } else {
                        aceitem = AceItemLocalServiceUtil.getAceItemByStoredAt("ace_measure_id=" + measure.getMeasureId());
                        if (aceitem == null){
                            aceitem = createAceItemInsideDB(measure);
                        }
                    }

                    if (oldapproved == ACEIndexUtil.Status_SUBMITTED && newapproved == ACEIndexUtil.Status_APPROVED){
                        measure.setApprovaldate( new Date() );
                    }

                    MeasureLocalServiceUtil.updateMeasure(measure);
                    if (aceitem != null){
                        updateAceItem(measure, aceitem);
                    }
                }

                if (oldapproved == ACEIndexUtil.Status_SUBMITTED && newapproved == ACEIndexUtil.Status_APPROVED){
                    sendApprovalNotification(measure);
                }

                SessionMessages.add(request, "measure-updated");

                String notify = ParamUtil.getString(request, "notify_status");
                if ((notify != null) && (notify.length() > 0) && (newapproved == ACEIndexUtil.Status_SUBMITTED)) {
                    sendSubmitNotification(measure);
                }

                sendRedirect(request, response);
            } else {
                for (String error : errors) {
                    SessionErrors.add(request, error);
                }
                PortalUtil.copyRequestParameters(request, response);
                response.setRenderParameter("jspPage", "/html/measure/edit_measure.jsp");
            }
        }
    }

    /**
     * Sets the preferences for how measures can be ordered
     *
     */
    public void setMeasurePref(ActionRequest request, ActionResponse response) throws Exception {
        String rowsPerPage = ParamUtil.getString(request, "rowsPerPage");
        PortletPreferences prefs = request.getPreferences();
        prefs.setValue("rowsPerPage", rowsPerPage);

        String orderByCol = ParamUtil.getString(request, Constants.ORDERBYCOL);

        prefs.setValue(Constants.ORDERBYCOL, orderByCol);

        String orderByType = ParamUtil.getString(request, Constants.ORDERBYTYPE);

        prefs.setValue(Constants.ORDERBYTYPE, orderByType);

        String proxyUrl = ParamUtil.getString(request, Constants.proxyUrlPreferenceName);

        prefs.setValue(Constants.proxyUrlPreferenceName, proxyUrl);

        String geoserverUrl = ParamUtil.getString(request, Constants.geoserverUrlPreferenceName);

        if (!geoserverUrl.endsWith("/")) {
            geoserverUrl += "/";
        }

        prefs.setValue(Constants.geoserverUrlPreferenceName, geoserverUrl);

        String wfs = ParamUtil.getString(request, Constants.wfsPreferenceName);

        prefs.setValue(Constants.wfsPreferenceName, wfs);

        String wms = ParamUtil.getString(request, Constants.wmsPreferenceName);

        prefs.setValue(Constants.wmsPreferenceName, wms);

        String featurenamespace = ParamUtil.getString(request, Constants.featureNamespacePreferenceName);

        prefs.setValue(Constants.featureNamespacePreferenceName, featurenamespace);

        String areasFeatureType = ParamUtil.getString(request, Constants.areasFeatureTypePreferenceName);

        prefs.setValue(Constants.areasFeatureTypePreferenceName, areasFeatureType);

        String areasLayer = ParamUtil.getString(request, Constants.areasLayerPreferenceName);

        prefs.setValue(Constants.areasLayerPreferenceName, areasLayer);

        String caseStudiesFeatureType = ParamUtil.getString(request, Constants.caseStudiesFeatureTypePreferenceName);

        prefs.setValue(Constants.caseStudiesFeatureTypePreferenceName, caseStudiesFeatureType);

        String geometryColumn = ParamUtil.getString(request, Constants.geometryColumnPreferenceName);

        prefs.setValue(Constants.geometryColumnPreferenceName, geometryColumn);

        // Microsoft Virtual Earth locator REST API URL
        String locatorUrl = ParamUtil.getString(request, Constants.locatorUrlPreferenceName);

        if (!locatorUrl.endsWith("/")) {
            locatorUrl += "/";
        }
        prefs.setValue(Constants.locatorUrlPreferenceName, locatorUrl);

        // Microsoft VE API key
        String locatorkey = ParamUtil.getString(request, Constants.locatorKeyPreferenceName);

        prefs.setValue(Constants.locatorKeyPreferenceName, locatorkey);

        // Microsoft Bing time out
        String bingtimeout = ParamUtil.getString(request, Constants.bingTimeOutPreferenceName);

        prefs.setValue(Constants.bingTimeOutPreferenceName, bingtimeout);

        // ZoomLevel
        String zoomlevel = ParamUtil.getString(request, Constants.zoomLevelPreferenceName);

        prefs.setValue(Constants.zoomLevelPreferenceName, zoomlevel);

        prefs.store();
    }

    /**
     *
     * @param measureId
     * @param actionRequest
     * @throws PortalException
     * @throws SystemException
     */
    private void deleteMeasure(long measureId, ActionRequest actionRequest) throws PortalException, SystemException {

        // Get measure object from the service.
        Measure measure = null;
        try {
            measure = MeasureLocalServiceUtil.getMeasure(measureId);
        } catch (Exception e) {
            measure = null;
        }

        // If measure object found.
        if (measure != null) {

            // Candidate gets deleted: the already approved measure becomes editable again.
            if (measure.getReplacesId() != 0) {
                measure = MeasureLocalServiceUtil.getMeasure(measure.getReplacesId());
                if (measure != null){
                    measure.setReplacesId((long) 0);
                    MeasureLocalServiceUtil.updateMeasure(measure);
                }
            } else {
                // Get the associated ace-item
                AceItem aceItem = AceItemLocalServiceUtil.getAceItemByStoredAt("ace_measure_id=" + measureId);

                if (aceItem != null){
                    // Delete the ace-item index entry.
                    new ACEIndexSynchronizer().delete(aceItem);

                    // Delete the ace-item.
                    AceItemLocalServiceUtil.deleteAceItem(aceItem.getAceItemId());
                }
            }

            // Delete the measure by saved Id (measure itself may be the old one here).
            MeasureLocalServiceUtil.deleteMeasure(measureId);
            SessionMessages.add(actionRequest, "measure-deleted");
        }
    }

    /**
     *
     * @param actionRequest
     * @param actionResponse
     * @throws PortalException
     * @throws SystemException
     */
    private void deleteMeasures(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException,
            SystemException {

        HashSet<Long> measureIds = getSubmittedMeasureIds(actionRequest);
        if (measureIds.isEmpty()) {
            SessionErrors.add(actionRequest, "none-selected");
            return;
        }

        for (Long measureId : measureIds) {
            deleteMeasure(measureId, actionRequest);
        }
    }

    /**
     *
     * @param actionRequest
     * @return
     */
    private HashSet<Long> getSubmittedMeasureIds(ActionRequest actionRequest) {

        HashSet<Long> itemIds = new HashSet<Long>();
        Enumeration<String> paramNames = actionRequest.getParameterNames();
        if (paramNames != null) {
            while (paramNames.hasMoreElements()) {
                String paramName = paramNames.nextElement();
                if (paramName.startsWith(SUBMITTED_MEASURE_ID_PREFIX ) && ! paramName.contains(  "Checkbox" ) ) {
                    String paramValue = actionRequest.getParameter(paramName);
                    if (BooleanUtils.toBooleanObject(paramValue)) {
                        itemIds.add(Long.valueOf(paramName.substring(SUBMITTED_MEASURE_ID_PREFIX.length())));
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
     * @throws IOException
     */
    public void measuresFormSubmitted(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException {

        String submitAction = actionRequest.getParameter("submitAction");
        if (StringUtils.isBlank(submitAction)) {
            return;
        }

        if (submitAction.equals("delete")) {
            try {
                deleteMeasures(actionRequest, actionResponse);
            } catch (Exception e) {
                e.printStackTrace();
                SessionErrors.add(actionRequest, "measure-delete-tech-error");
            }
        }

        sendRedirect(actionRequest, actionResponse);
    }
}
