package nl.wur.alterra.cgi.ace.portlet;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;

import nl.wur.alterra.cgi.ace.model.AceItem;
import nl.wur.alterra.cgi.ace.model.impl.AceItemImpl;
import nl.wur.alterra.cgi.ace.service.AceItemLocalServiceUtil;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;

/**
 * Portlet implementation class ShareAceItemPortlet
 */
public class ShareAceItemPortlet extends LuceneIndexUpdatePortlet {

	 
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

			request.getPortletSession().setAttribute("lastAddedAceItemId", "" + aceitem.getAceItemId() );
            
			sendRedirect(request, response);
		}
		else {
			for (String error : errors) {
				SessionErrors.add(request, error);
			}
			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("jspPage", "/html/shareinfo/add_aceitem.jsp");
		}
	}

	/**
	 * Updates the database record of an existing aceitem.
	 *
	 */
	public void updateAceItem(ActionRequest request, ActionResponse response) throws Exception {
		AceItem aceitem = AceItemLocalServiceUtil.getAceItem(ParamUtil.getLong(request, "aceItemId"));

		aceitemFromRequest(request, aceitem);
		
		List<String> errors = new ArrayList<String>();
		if (AceItemValidator.validateAceItem(aceitem, errors)) {
				
			AceItemLocalServiceUtil.updateAceItem(aceitem);
			SessionMessages.add(request, "aceitem-updated");
            synchronizeIndexSingleAceItem(aceitem);
            
			request.getPortletSession().setAttribute("lastAddedAceItemId", "" + aceitem.getAceItemId() );
            
			sendRedirect(request, response);
		}
		else {
			for (String error : errors) {
				SessionErrors.add(request, error);
			}
			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("jspPage", "/html/shareinfo/add_aceitem.jsp");
		}
	}
	
	/**
	 * Sets the preferences for which datatype is being entered at Share Your Info page.
	 *
	 */
	public void setAddAceItemPref(ActionRequest request, ActionResponse response) throws Exception {

		PortletPreferences prefs = request.getPreferences();
		
		String sharetype = ParamUtil.getString(request, Constants.SHARETYPE);

		prefs.setValue(Constants.SHARETYPE, sharetype);
		
		prefs.store();
	}

}
