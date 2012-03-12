package nl.wur.alterra.cgi.ace.portlet;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import nl.wur.alterra.cgi.ace.model.AceItem;
import nl.wur.alterra.cgi.ace.model.impl.AceItemImpl;
import nl.wur.alterra.cgi.ace.search.lucene.ACEIndexSynchronizer;
import nl.wur.alterra.cgi.ace.service.AceItemLocalServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import java.util.ArrayList;
import java.util.List;

/**
 * Portlet implementation class AceItemPortlet.
 *
 */
public class AceItemPortlet extends LuceneIndexUpdatePortlet {
 
	/**
	 * Adds a new aceitem to the database.
	 * 
	 */
	public void addAceItem(ActionRequest request, ActionResponse response) throws Exception {
		AceItem aceitem = new AceItemImpl();
		aceitem.setAceItemId(ParamUtil.getLong(request, "aceItemId"));
		aceitemFromRequest(request, aceitem);
	    List<String> errors = new ArrayList<String>();
		if (AceItemValidator.validateAceItem(aceitem, errors)) {
			AceItemLocalServiceUtil.addAceItem(aceitem);
			SessionMessages.add(request, "aceitem-added");
            synchronizeIndexSingleAceItem(aceitem);
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
	 * Updates the database record of an existing aceitem.
	 *
	 */
	public void updateAceItem(ActionRequest request, ActionResponse response) throws Exception {
		AceItem aceitem = AceItemLocalServiceUtil.getAceItem(ParamUtil.getLong(request, "aceItemId"));
		//System.out.println("ReplacesId: " + aceitem.getReplacesId());
		// retain old and new status
		Short oldapproved = aceitem.getControlstatus();
		Short newapproved = 0;
		String approved = ParamUtil.getString(request, "chk_controlstatus");
		if( (approved != null ) && (approved.length()>0) ) {
			
			newapproved = Short.parseShort(approved);
		}
		if ( (oldapproved == Constants.Status_APPROVED) &&  (newapproved != Constants.Status_APPROVED) ) { 
		// The old record stays untouched, only replacesId gets filled (from now no edit or delete possible anymore)
			aceitem.setReplacesId( aceitem.getAceItemId() ) ;
			// Must be done BEFORE aceitemFromRequest();
			AceItemLocalServiceUtil.updateAceItem(aceitem);
		}
		
		aceitemFromRequest(request, aceitem);
		
		List<String> errors = new ArrayList<String>();
		if (AceItemValidator.validateAceItem(aceitem, errors)) {
			if ( (oldapproved == Constants.Status_APPROVED) &&  (newapproved != Constants.Status_APPROVED) ) { 
     			// The changed item gets added as a copy with replacesId filled (is already done above)
				// save the new copy: simple addAceItem
				AceItemLocalServiceUtil.addAceItem(aceitem);
				// automatically gets a new aceitemid;
			}
			else {
				
				if ( (newapproved == Constants.Status_APPROVED)  && aceitem.getReplacesId() != 0) {
					// delete the old aceitem which gets replaced
					AceItem oldaceitem = AceItemLocalServiceUtil.getAceItem(aceitem.getReplacesId());
					new ACEIndexSynchronizer().delete(oldaceitem);	
					AceItemLocalServiceUtil.deleteAceItem(aceitem.getReplacesId());
					aceitem.setReplacesId( (long) 0);	
				}
				
				AceItemLocalServiceUtil.updateAceItem(aceitem);
			}
			SessionMessages.add(request, "aceitem-updated");
            synchronizeIndexSingleAceItem(aceitem);
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
	public void deleteAceItem(ActionRequest request, ActionResponse response) throws Exception {
		long aceitemId = ParamUtil.getLong(request, "aceItemId");
		List<String> errors = new ArrayList<String>();
		if (Validator.isNotNull(aceitemId)) {

			// delete the index entry
			AceItem aceitem = AceItemLocalServiceUtil.getAceItem(aceitemId);
			
			new ACEIndexSynchronizer().delete(aceitem);			
			
			if(aceitem.getReplacesId() != 0) {
			// Reset the already approved aceitem from the item that should be replaced
				aceitem = AceItemLocalServiceUtil.getAceItem( aceitem.getReplacesId() );
				aceitem.setReplacesId( (long) 0);
				AceItemLocalServiceUtil.updateAceItem(aceitem);
			}
			
			// delete the aceitem by saved Id (aceitem itself may be the old one here)
			AceItemLocalServiceUtil.deleteAceItem(aceitemId);

			SessionMessages.add(request, "aceitem-deleted");

			sendRedirect(request, response);
		}
		else {
			SessionErrors.add(request, "error-deleting");
		}
	}
		
	/**
	 * Sets the preferences for how many aceitems can be viewed per page and the format for the phone number.
	 *
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
}
