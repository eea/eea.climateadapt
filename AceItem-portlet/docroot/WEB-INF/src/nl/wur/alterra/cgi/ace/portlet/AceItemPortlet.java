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
import nl.wur.alterra.cgi.ace.model.constants.AceItemClimateImpact;
import nl.wur.alterra.cgi.ace.model.constants.AceItemElement;
import nl.wur.alterra.cgi.ace.model.constants.AceItemSector;
import nl.wur.alterra.cgi.ace.model.impl.AceItemImpl;
import nl.wur.alterra.cgi.ace.search.lucene.ACEIndexSynchronizer;
import nl.wur.alterra.cgi.ace.service.AceItemLocalServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import java.util.ArrayList;

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

		AceItem aceitem = new AceItemImpl(); 

		aceitem.setAceItemId(ParamUtil.getLong(request, "aceItemId"));
		aceitemFromRequest(request, aceitem);

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
	private AceItem aceitemFromRequest(PortletRequest request, AceItem aceitem) {
		ThemeDisplay themeDisplay =
			(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		
		aceitem.setCompanyId(themeDisplay.getCompanyId());
		aceitem.setGroupId(themeDisplay.getScopeGroupId());

		aceitem.setNasId(ParamUtil.getLong(request, "nasId"));
		aceitem.setName(ParamUtil.getString(request, "name"));
		aceitem.setDescription(ParamUtil.getString(request, "description"));

		aceitem.setDatatype(ParamUtil.getString(request, "datatype"));
		aceitem.setStoredAt(ParamUtil.getString(request, "storedAt"));
		aceitem.setStoragetype(ParamUtil.getString(request, "storagetype"));
		
		String choosensectors = "";
		for(AceItemSector aceitemsector : AceItemSector.values() ) {
			
			if( ParamUtil.getString(request, "chk_sectors_" + aceitemsector.toString()) != null )  {
				String s =  ParamUtil.getString(request, "chk_sectors_" + aceitemsector.toString());
				if(s.equalsIgnoreCase(aceitemsector.toString())) {				
					choosensectors +=  aceitemsector.toString() + ";";
				}
			}
		}
		aceitem.setSectors_(choosensectors);
		
		String choosenelements = "";
		for(AceItemElement aceitemelement : AceItemElement.values() ) {
			if( ParamUtil.getString(request, "chk_elements_" + aceitemelement) != null )  {
				String e =  ParamUtil.getString(request, "chk_elements_" + aceitemelement);
				if(e.equalsIgnoreCase(aceitemelement.toString())) {
					choosenelements +=  aceitemelement.toString() + ";";
				}
			}
		}		
		aceitem.setElements_(choosenelements);
		
		String choosenclimateimpacts = "";
		for(AceItemClimateImpact aceitemclimateimpact : AceItemClimateImpact.values() ) {
			if( ParamUtil.getString(request, "chk_climateimpacts_" + aceitemclimateimpact) != null )  {
				String e =  ParamUtil.getString(request, "chk_climateimpacts_" + aceitemclimateimpact);
				if(e.equalsIgnoreCase(aceitemclimateimpact.toString())) {
					choosenclimateimpacts +=  aceitemclimateimpact.toString() + ";";
				}
			}
		}		
		aceitem.setClimateimpacts_(choosenclimateimpacts);
		
		aceitem.setTextSearch(ParamUtil.getString(request, "textSearch"));
		aceitem.setKeyword(ParamUtil.getString(request, "keyword"));
		aceitem.setSpatialLayer(ParamUtil.getString(request, "spatialLayer"));
		aceitem.setSpatialValues(ParamUtil.getString(request, "spatialValues"));			
		aceitem.setCompanyId(themeDisplay.getCompanyId());
		aceitem.setGroupId(themeDisplay.getScopeGroupId());
/*		
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
		
		dateMonth = ParamUtil.getInteger(request, "publicationDateMonth");
		dateDay = ParamUtil.getInteger(request, "publicationDateDay");
		dateYear = ParamUtil.getInteger(request, "publicationDateYear");
		Date publicationdate = PortalUtil.getDate(dateMonth, dateDay, dateYear);
		aceitem.setEndDate(publicationdate);
*/
		String importance = ParamUtil.getString(request, "chk_importance");

		if(aceitem.getImportance() == 1) {
			  aceitem.setImportance( aceitem.getImportance()-1 );
			  aceitem.setRating( aceitem.getRating() - 100);
		}

		if( importance != null && importance.equalsIgnoreCase("1")) {
			  aceitem.setImportance(aceitem.getImportance()+1);
			  aceitem.setRating( aceitem.getRating() + 100);
		}
		
		return aceitem;
	}

	/**
	 * Updates the database record of an existing aceitem.
	 *
	 */
	public void updateAceItem(ActionRequest request, ActionResponse response)
		throws Exception {

		AceItem aceitem = AceItemLocalServiceUtil.getAceItem(ParamUtil.getLong(request, "aceItemId"));
		
		aceitemFromRequest(request, aceitem);

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
