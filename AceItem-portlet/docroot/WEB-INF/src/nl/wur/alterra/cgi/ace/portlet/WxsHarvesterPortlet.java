package nl.wur.alterra.cgi.ace.portlet;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import nl.wur.alterra.cgi.ace.model.WxsHarvester;
import nl.wur.alterra.cgi.ace.model.impl.WxsHarvesterImpl;
import nl.wur.alterra.cgi.ace.service.WxsHarvesterLocalServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Portlet implementation class WxsHarvesterPortlet.
 *
 * @author heikki doeleman
 */
public class WxsHarvesterPortlet extends LuceneIndexUpdatePortlet {

	/**
	 * Adds a new wxsharvester to the database
	 * 
	 */
	public void addWxsHarvester(ActionRequest request, ActionResponse response) throws Exception {

		WxsHarvester wxsHarvester = new WxsHarvesterImpl();
		wxsHarvester.setWxsharvesterid(ParamUtil.getLong(request, "WxsHarvesterId"));
		wxsHarvesterFromRequest(request, wxsHarvester);

		List<String> errors = new ArrayList<String>();
		if (WxsHarvesterValidator.validateWxsHarvester(wxsHarvester, errors)) {
			WxsHarvesterLocalServiceUtil.addWxsHarvester(wxsHarvester);
			SessionMessages.add(request, "wxsHarvester-added");
			sendRedirect(request, response);
		}
		else {
			for (String error : errors) {
				SessionErrors.add(request, error);
			}
			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("jspPage", "/html/wxsharvester/edit_wxsharvester.jsp");
		}
	}

	/**
	 * Convenience method to create a WxsHarvester object out of the request. Used by the Add / Edit methods.
	 *
	 */
	private WxsHarvester wxsHarvesterFromRequest(PortletRequest request, WxsHarvester wxsHarvester) {
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		
		wxsHarvester.setCompanyId(themeDisplay.getCompanyId());
		wxsHarvester.setGroupId(themeDisplay.getScopeGroupId());

        wxsHarvester.setEvery(ParamUtil.getInteger(request, "every"));
        wxsHarvester.setGeonetworkId(ParamUtil.getLong(request, "geonetworkId"));
        wxsHarvester.setGeonetworkUUID(ParamUtil.getString(request, "geonetworkUUID"));
        wxsHarvester.setName(ParamUtil.getString(request, "name"));
        wxsHarvester.setOgctype(ParamUtil.getString(request, "ogctype"));
        //wxsHarvester.setSavedToGeoNetwork(ParamUtil.getBoolean(request, "savedToGeoNetwork"));
        wxsHarvester.setUrl(ParamUtil.getString(request, "url"));
        wxsHarvester.setTopic(ParamUtil.getString(request, "topic"));

		return wxsHarvester;
	}

	/**
	 * Updates the database record of an existing WxsHarvester.
	 *
	 */
	public void updateWxsHarvester(ActionRequest request, ActionResponse response) throws Exception {
		WxsHarvester wxsHarvester = WxsHarvesterLocalServiceUtil.getWxsHarvester(ParamUtil.getLong(request, "wxsharvesterid"));
		wxsHarvesterFromRequest(request, wxsHarvester);
		List<String> errors = new ArrayList<String>();
		if (WxsHarvesterValidator.validateWxsHarvester(wxsHarvester, errors)) {
			WxsHarvesterLocalServiceUtil.updateWxsHarvester(wxsHarvester);
			SessionMessages.add(request, "wxsHarvester-updated");
			sendRedirect(request, response);
		}
		else {
			for (String error : errors) {
				SessionErrors.add(request, error);
			}

			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("jspPage", "/html/wxsharvester/edit_wxsharvester.jsp");
		}
	}

	/**
	 * Deletes a WxsHarvester from the database.
	 *
	 */
	public void deleteWxsHarvester(ActionRequest request, ActionResponse response) throws Exception {
        System.out.println("WxsHarvesterPortlet deleting harvester");
		long wxsHarvesterId = ParamUtil.getLong(request, "wxsharvesterid");
		List<String> errors = new ArrayList<String>();
		if (Validator.isNotNull(wxsHarvesterId)) {
            System.out.println("wxsHarvesterId is not null, continuing");
            WxsHarvester wxsHarvester = WxsHarvesterLocalServiceUtil.getWxsHarvester(wxsHarvesterId);
            try {
                WxsHarvesterLocalServiceUtil.deleteWxsHarvester(wxsHarvester);
                SessionMessages.add(request, "wxsHarvester-deleted");
                sendRedirect(request, response);
            } catch (Exception ex) {
                SessionMessages.add(request, "error-deleting");
                sendRedirect(request, response);
            }
		}
		else {
            System.out.println("wxsHarvesterId is null, aborting delete");
			SessionErrors.add(request, "error-deleting");
		}
	}


	/**
	 * Adds a WxsHarvester to GeoNetwork.
	 *
	 */
	public void saveWxsHarvesterToGeoNetwork(ActionRequest request, ActionResponse response) throws Exception {	
		WxsHarvester wxsHarvester = WxsHarvesterLocalServiceUtil.getWxsHarvester(ParamUtil.getLong(request, "wxsharvesterid"));
		
		if (!wxsHarvester.getSavedToGeoNetwork()) {
			// TODO: Implement to create the harvester in GeoNetwork
			
			wxsHarvester.setSavedToGeoNetwork(true);
			WxsHarvesterLocalServiceUtil.updateWxsHarvester(wxsHarvester);
			SessionMessages.add(request, "wxsHarvester-updated");
			sendRedirect(request, response);
				
		} else {
			SessionErrors.add(request, "aceharvestergeonetwork-exist");
			
			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("jspPage", "/html/wxsharvester/edit_wxsharvester.jsp");
		}
	}
	
	/**
	 * Executes a WxsHarvester .
	 *
	 */
	public void executeWxsHarvester(ActionRequest request, ActionResponse response) throws Exception {	
		WxsHarvester wxsHarvester = WxsHarvesterLocalServiceUtil.getWxsHarvester(ParamUtil.getLong(request, "wxsharvesterid"));
		
		if (wxsHarvester.getSavedToGeoNetwork()) {
			// TODO: Implement to create the harvester in GeoNetwork
			
			SessionMessages.add(request, "wxsHarvester-updated");
			sendRedirect(request, response);
				
		} else {
			SessionErrors.add(request, "aceharvestergeonetwork-notexist");
			
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
}