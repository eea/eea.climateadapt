package nl.wur.alterra.cgi.ace.portlet;

import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;

import nl.wur.alterra.cgi.ace.model.AceItem;
import nl.wur.alterra.cgi.ace.model.impl.AceItemImpl;
import nl.wur.alterra.cgi.ace.search.lucene.ACEIndexSynchronizer;
import nl.wur.alterra.cgi.ace.search.lucene.ACEIndexUtil;
import nl.wur.alterra.cgi.ace.service.AceItemLocalServiceUtil;

import org.apache.commons.lang.StringUtils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;

/**
 * Portlet implementation class AceItemPortlet.
 *
 */
public class AceItemPortlet extends LuceneIndexUpdatePortlet {

    /** */
    public static final String SUBMITTED_ACE_ITEM_ID_PREFIX = "aceitem_";

    /**
     *
     * @param request
     * @param response
     */
    public void addAceItem(ActionRequest request, ActionResponse response) {
        try {
            doAddAceItem(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            SessionErrors.add(request, "aceitem-add-tech-error");
            PortalUtil.copyRequestParameters(request, response);
            response.setRenderParameter("jspPage", "/html/aceitem/edit_aceitem.jsp");
        }
    }

    /**
     * Adds a new aceitem to the database.
     *
     * @param request
     * @param response
     * @throws Exception
     */
    private void doAddAceItem(ActionRequest request, ActionResponse response) throws Exception {
        AceItem aceitem = new AceItemImpl();
        aceitem.setAceItemId(ParamUtil.getLong(request, "aceItemId"));
        aceitemFromRequest(request, aceitem);
        List<String> errors = new ArrayList<String>();
        if (AceItemValidator.validateAceItem(aceitem, errors)) {
            AceItemLocalServiceUtil.addAceItem(aceitem);
            SessionMessages.add(request, "aceitem-added");
            synchronizeIndexSingleAceItem(aceitem);

            String notify = ParamUtil.getString(request, "notify_status");
            if ((notify != null) && (notify.length() > 0) && (aceitem.getControlstatus() == ACEIndexUtil.Status_SUBMITTED)) {
                sendSubmitNotification(aceitem);
            }

            sendRedirect(request, response);
        } else {
            for (String error : errors) {
                SessionErrors.add(request, error);
            }
            PortalUtil.copyRequestParameters(request, response);
            response.setRenderParameter("jspPage", "/html/aceitem/edit_aceitem.jsp");
        }
    }

    /**
     *
     * @param request
     * @param response
     */
    public void updateAceItem(ActionRequest request, ActionResponse response) {
        try {
            doUpdateAceItem(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            SessionErrors.add(request, "aceitem-save-tech-error");
            PortalUtil.copyRequestParameters(request, response);
            response.setRenderParameter("jspPage", "/html/aceitem/edit_aceitem.jsp");
        }
    }

    /**
     * Updates the database record of an existing aceitem..
     *
     * @param request
     * @param response
     * @throws Exception
     */
    private void doUpdateAceItem(ActionRequest request, ActionResponse response) throws Exception {
        AceItem aceitem = null;

        try {
            aceitem = AceItemLocalServiceUtil.getAceItem(ParamUtil.getLong(request, "aceItemId"));
        } catch (Exception e) {
            aceitem = null;
        }

        if (aceitem != null) {
            // System.out.println("ReplacesId: " + aceitem.getReplacesId());
            // retain old and new status
            Short oldapproved = aceitem.getControlstatus();
            Short newapproved = 0;
            String approved = ParamUtil.getString(request, "chk_controlstatus");
            if ((approved != null) && (approved.length() > 0)) {

                newapproved = Short.parseShort(approved);
            }
            if ((oldapproved == ACEIndexUtil.Status_APPROVED) && (newapproved != ACEIndexUtil.Status_APPROVED)) {
                // The old record stays untouched, only replacesId gets filled (from now no edit or delete possible anymore)
                aceitem.setReplacesId(aceitem.getAceItemId());
                // Must be done BEFORE aceitemFromRequest();
                AceItemLocalServiceUtil.updateAceItem(aceitem);
            }

            aceitemFromRequest(request, aceitem);

            List<String> errors = new ArrayList<String>();
            if (AceItemValidator.validateAceItem(aceitem, errors)) {
                if ((oldapproved == ACEIndexUtil.Status_APPROVED) && (newapproved != ACEIndexUtil.Status_APPROVED)) {
                    // The changed item gets added as a copy with replacesId filled (is already done above)
                    // save the new copy: simple addAceItem
                    AceItemLocalServiceUtil.addAceItem(aceitem);
                    // automatically gets a new aceitemid;
                } else {

                    if ((newapproved == ACEIndexUtil.Status_APPROVED) && aceitem.getReplacesId() != 0) {
                        // delete the old aceitem which gets replaced
                        AceItem oldaceitem = AceItemLocalServiceUtil.getAceItem(aceitem.getReplacesId());
                        if (oldaceitem != null){
                            new ACEIndexSynchronizer().delete(oldaceitem);
                        }
                        AceItemLocalServiceUtil.deleteAceItem(aceitem.getReplacesId());
                        aceitem.setReplacesId((long) 0);
                    }

                    if (oldapproved == ACEIndexUtil.Status_SUBMITTED && newapproved == ACEIndexUtil.Status_APPROVED){
                        aceitem.setApprovaldate( new Date() );
                    }

                    AceItemLocalServiceUtil.updateAceItem(aceitem);
                }

                if (oldapproved == ACEIndexUtil.Status_SUBMITTED && newapproved == ACEIndexUtil.Status_APPROVED){
                    sendApprovalNotification(aceitem);
                }

                SessionMessages.add(request, "aceitem-updated");
                synchronizeIndexSingleAceItem(aceitem);

                String notify = ParamUtil.getString(request, "notify_status");
                if ((notify != null) && (notify.length() > 0) && (newapproved == ACEIndexUtil.Status_SUBMITTED)) {
                    sendSubmitNotification(aceitem);
                }

                sendRedirect(request, response);
            } else {
                for (String error : errors) {
                    SessionErrors.add(request, error);
                }
                PortalUtil.copyRequestParameters(request, response);
                response.setRenderParameter("jspPage", "/html/aceitem/edit_aceitem.jsp");
            }
        }
    }

    /**
     * Sets the preferences for how many aceitems can be viewed per page and the format for the phone number.
     *
     * @param request
     * @param response
     * @throws Exception
     */
    public void setAceItemPref(ActionRequest request, ActionResponse response) throws Exception {
        String rowsPerPage = ParamUtil.getString(request, "rowsPerPage");
        PortletPreferences prefs = request.getPreferences();
        prefs.setValue("rowsPerPage", rowsPerPage);

        String orderByCol = ParamUtil.getString(request, Constants.ORDERBYCOL);

        prefs.setValue(Constants.ORDERBYCOL, orderByCol);

        String orderByType = ParamUtil.getString(request, Constants.ORDERBYTYPE);

        prefs.setValue(Constants.ORDERBYTYPE, orderByType);

        prefs.store();
    }

    /**
     *
     * @param actionRequest
     * @param actionResponse
     * @throws SystemException
     * @throws PortalException
     */
    private void deleteAceItems(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException {

        HashSet<Long> itemIds = getSubmittedAceItemIds(actionRequest);
        if (itemIds.isEmpty()) {
            SessionErrors.add(actionRequest, "none-selected");
            return;
        }

        for (Long itemId : itemIds) {
            deleteAceItem(itemId, actionRequest);
        }
    }

    /**
     *
     * @param actionRequest
     * @param actionResponse
     * @throws SystemException
     * @throws PortalException
     */
    private void deleteAceItem(long aceItemId, ActionRequest actionRequest) throws PortalException, SystemException {

        // Get ace-item object from the service.
        AceItem aceitem = null;
        try {
            aceitem = AceItemLocalServiceUtil.getAceItem(aceItemId);
        } catch (Exception e) {
            aceitem = null;
        }

        // If ace-item object found.
        if (aceitem != null) {

            // Do the deletion.
            new ACEIndexSynchronizer().delete(aceitem);

            // If the deleted ace-item was replacing another one.
            if (aceitem.getReplacesId() != 0) {

                // Reset the already approved ace-item from the item that should be replaced.
                aceitem = AceItemLocalServiceUtil.getAceItem(aceitem.getReplacesId());
                if (aceitem != null){
                    aceitem.setReplacesId((long) 0);
                    AceItemLocalServiceUtil.updateAceItem(aceitem);
                }
            }

            // Delete the ace-item by saved id (ace-item itself may be the old one here).
            AceItemLocalServiceUtil.deleteAceItem(aceItemId);
            SessionMessages.add(actionRequest, "aceitem-deleted");
        }
    }

    /**
     *
     * @param actionRequest
     * @return
     */
    private HashSet<Long> getSubmittedAceItemIds(ActionRequest actionRequest) {

        HashSet<Long> itemIds = new HashSet<Long>();
        Enumeration<String> paramNames = actionRequest.getParameterNames();
        if (paramNames != null) {
            while (paramNames.hasMoreElements()) {
                String paramName = paramNames.nextElement();
                if (paramName.startsWith(SUBMITTED_ACE_ITEM_ID_PREFIX)) {
                    String paramValue = actionRequest.getParameter(paramName);
                    if (StringUtils.equals(paramValue, String.valueOf(true))){
                        itemIds.add(Long.valueOf(paramName.substring(SUBMITTED_ACE_ITEM_ID_PREFIX.length())));
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
    public void aceItemsFormSubmitted(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        String submitAction = actionRequest.getParameter("submitAction");
        if (StringUtils.isBlank(submitAction)) {
            return;
        }

        if (submitAction.equals("delete")) {
            try {
                deleteAceItems(actionRequest, actionResponse);
            } catch (Exception e) {
                e.printStackTrace();
                SessionErrors.add(actionRequest, "aceitem-delete-tech-error");
            }
        }

        sendRedirect(actionRequest, actionResponse);
    }
}
