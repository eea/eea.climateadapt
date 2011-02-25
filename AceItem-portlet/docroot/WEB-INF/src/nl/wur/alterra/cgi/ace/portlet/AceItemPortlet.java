package nl.wur.alterra.cgi.ace.portlet;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import nl.wur.alterra.cgi.ace.model.AceItem;
import nl.wur.alterra.cgi.ace.model.impl.AceItemImpl;
import nl.wur.alterra.cgi.ace.search.lucene.ACEIndexSynchronizer;
import nl.wur.alterra.cgi.ace.service.AceItemLocalServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import java.util.ArrayList;
import java.util.Date;

/**
 * Portlet implementation class AceItemPortlet
 */
public class AceItemPortlet extends MVCPortlet {

    /**
     * Rebuilds index based on contents of database.
     *
     * @param request
     * @param response
     * @throws Exception
     */
    public void synchronizeIndex(ActionRequest request, ActionResponse response) throws Exception {
        ACEIndexSynchronizer aceIndexSynchronizer = new ACEIndexSynchronizer();
        aceIndexSynchronizer.synchronize();
    }
 
	/**
	 * Adds a new aceitem to the database
	 * 
	 */
	public void addAceItem(ActionRequest request, ActionResponse response)
		throws Exception {

		AceItem aceitem = aceitemFromRequest(request);

		ArrayList<String> errors = new ArrayList<String>();

		if (AceItemValidator.validateAceItem(aceitem, errors)) {
			AceItemLocalServiceUtil.addAceItem(aceitem);

			SessionMessages.add(request, "aceitem-added");

			sendRedirect(request, response);
		}
		else {
			for (String error : errors) {
				SessionErrors.add(request, error);
			}

			PortalUtil.copyRequestParameters(request, response);

			response.setRenderParameter("jspPage", "/html/aceitem/edit_aceitem.jsp");
		}
	}

	/**
	 * Convenience method to create a AceItem object out of the request. Used
	 * by the Add / Edit methods.
	 *
	 */
	private AceItem aceitemFromRequest(PortletRequest request) {
		ThemeDisplay themeDisplay =
			(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);

		AceItemImpl aceitem = new AceItemImpl();
		aceitem.setAceItemId(ParamUtil.getLong(request, "aceItemId"));
		aceitem.setName(ParamUtil.getString(request, "name"));
		aceitem.setDescription(ParamUtil.getString(request, "description"));

		aceitem.setType(ParamUtil.getString(request, "type"));
		aceitem.setStoredAt(ParamUtil.getString(request, "storedAt"));
		aceitem.setSector(ParamUtil.getString(request, "sector"));
		aceitem.setPilar(ParamUtil.getString(request, "pilar"));
		aceitem.setTextSearch(ParamUtil.getString(request, "textSearch"));
		aceitem.setKeyword(ParamUtil.getString(request, "keyword"));
		aceitem.setNutsId(ParamUtil.getString(request, "nutsId"));	
		aceitem.setNutsLevel(ParamUtil.getString(request, "nutsLevel"));		
		aceitem.setCompanyId(themeDisplay.getCompanyId());
		aceitem.setGroupId(themeDisplay.getScopeGroupId());
		
		int dateMonth = ParamUtil.getInteger(request, "startDateMonth");
		int dateDay = ParamUtil.getInteger(request, "startDateDay");
		int dateYear = ParamUtil.getInteger(request, "startDateYear");
		Date startdate = PortalUtil.getDate(dateMonth, dateDay, dateYear);
		aceitem.setStartDate(startdate);
		
		dateMonth = ParamUtil.getInteger(request, "endDateMonth");
		dateDay = ParamUtil.getInteger(request, "endDateDay");
		dateYear = ParamUtil.getInteger(request, "endDateYear");
		Date enddate = PortalUtil.getDate(dateMonth, dateDay, dateYear);
		aceitem.setEndDate(enddate);
		
		return aceitem;
	}

	/**
	 * Updates the database record of an existing aceitem.
	 *
	 */
	public void updateAceItem(ActionRequest request, ActionResponse response)
		throws Exception {

		AceItem aceitem = aceitemFromRequest(request);

		ArrayList<String> errors = new ArrayList<String>();

		if (AceItemValidator.validateAceItem(aceitem, errors)) {
			AceItemLocalServiceUtil.updateAceItem(aceitem);

			SessionMessages.add(request, "aceitem-updated");

			sendRedirect(request, response);
		}
		else {
			for (String error : errors) {
				SessionErrors.add(request, error);
			}

			PortalUtil.copyRequestParameters(request, response);

			response.setRenderParameter("jspPage", "/html/aceitem/edit_aceitem.jsp");
		}
	}


	/**
	 * Deletes a aceitem from the database.
	 *
	 */
	public void deleteAceItem(ActionRequest request, ActionResponse response)
		throws Exception {

		long aceitemId = ParamUtil.getLong(request, "aceItemId");

		ArrayList<String> errors = new ArrayList<String>();

		if (Validator.isNotNull(aceitemId)) {
			AceItemLocalServiceUtil.deleteAceItem(aceitemId);

			SessionMessages.add(request, "aceitem-deleted");

			sendRedirect(request, response);
		}
		else {
			SessionErrors.add(request, "error-deleting");
		}
	}
		

	/**
	 * Sets the preferences for how many aceitems can be viewed
	 * per page and the format for the phone number
	 *
	 */
	public void setAceItemPref(ActionRequest request, ActionResponse response)
		throws Exception {

		String rowsPerPage = ParamUtil.getString(request, "rowsPerPage");

		PortletPreferences prefs = request.getPreferences();

		prefs.setValue("rowsPerPage", rowsPerPage);

		prefs.store();
	}
}
