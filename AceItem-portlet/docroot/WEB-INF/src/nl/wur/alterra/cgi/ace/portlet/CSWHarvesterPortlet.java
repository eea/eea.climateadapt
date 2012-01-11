package nl.wur.alterra.cgi.ace.portlet;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import nl.wur.alterra.cgi.ace.harvester.HarvesterExecutionService;
import nl.wur.alterra.cgi.ace.harvester.HarvesterThread;
import nl.wur.alterra.cgi.ace.model.CSWHarvester;
import nl.wur.alterra.cgi.ace.model.constants.HarvesterStatus;
import nl.wur.alterra.cgi.ace.model.impl.CSWHarvesterImpl;
import nl.wur.alterra.cgi.ace.service.CSWHarvesterLocalServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Portlet implementation class CSWHarvesterPortlet.
 *
 * @author heikki doeleman
 */
public class CSWHarvesterPortlet extends LuceneIndexUpdatePortlet {

	/**
	 * Adds a new cswharvester to the database
	 * 
	 */
	public void addCSWHarvester(ActionRequest request, ActionResponse response) throws Exception {

        System.out.println("CSWHARVESTERPORTLET addCSWHarvester ");
        CSWHarvester cswHarvester = new CSWHarvesterImpl();
		cswHarvester.setCswharvesterid(ParamUtil.getLong(request, "cswharvesterid"));
		cswHarvesterFromRequest(request, cswHarvester);

		List<String> errors = new ArrayList<String>();
		if (CSWHarvesterValidator.validateCSWHarvester(cswHarvester, errors)) {
			CSWHarvesterLocalServiceUtil.addCSWHarvester(cswHarvester);
			SessionMessages.add(request, "cswHarvester-added");
			sendRedirect(request, response);
		}
		else {
			for (String error : errors) {
				SessionErrors.add(request, error);
			}
			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("jspPage", "/html/cswharvester/edit_cswharvester.jsp");
		}
	}

	/**
	 * Convenience method to create a CSWHarvester object out of the request. Used by the Add / Edit methods.
	 *
	 */
	private CSWHarvester cswHarvesterFromRequest(PortletRequest request, CSWHarvester cswHarvester) {
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		
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
        //cswHarvester.setSavedToGeoNetwork(ParamUtil.getBoolean(request, "savedToGeoNetwork"));
        cswHarvester.setUrl(ParamUtil.getString(request, "url"));
        cswHarvester.setTopic(ParamUtil.getString(request, "topic"));

		return cswHarvester;
	}

	/**
	 * Updates the database record of an existing CSWHarvester.
	 *
	 */
	public void updateCSWHarvester(ActionRequest request, ActionResponse response) throws Exception {
        //System.out.println("CSWHARVESTERPORTLET updateCSWHarvester");
		CSWHarvester cswHarvester = CSWHarvesterLocalServiceUtil.getCSWHarvester(ParamUtil.getLong(request, "cswharvesterid"));
		cswHarvesterFromRequest(request, cswHarvester);
		List<String> errors = new ArrayList<String>();
		if (CSWHarvesterValidator.validateCSWHarvester(cswHarvester, errors)) {
			CSWHarvesterLocalServiceUtil.updateCSWHarvester(cswHarvester, Boolean.TRUE, Boolean.TRUE);
			SessionMessages.add(request, "cswHarvester-updated");
			sendRedirect(request, response);
		}
		else {
			for (String error : errors) {
				SessionErrors.add(request, error);
			}

			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("jspPage", "/html/cswharvester/edit_cswharvester.jsp");
		}
	}

	/**
	 * Deletes a CSWHarvester from the database.
	 *
	 */
	public void deleteCSWHarvester(ActionRequest request, ActionResponse response) throws Exception {
        //System.out.println("CSWHARVESTERPORTLET deleteCSWHarvester");
		long cswHarvesterId = ParamUtil.getLong(request, "cswharvesterid");
		List<String> errors = new ArrayList<String>();
		if (Validator.isNotNull(cswHarvesterId)) {
            //System.out.println("cswHarvesterId is not null, continuing");
            CSWHarvester cswHarvester = CSWHarvesterLocalServiceUtil.getCSWHarvester(cswHarvesterId);
			CSWHarvesterLocalServiceUtil.deleteCSWHarvester(cswHarvester);
			SessionMessages.add(request, "cswHarvester-deleted");
			sendRedirect(request, response);
		}
		else {
            //System.out.println("cswHarvesterId is null, aborting delete");
			SessionErrors.add(request, "error-deleting");
		}
	}


	/**
	 * Adds a cswHarvester to GeoNetwork.
     *
	 */
	public void saveCSWHarvesterToGeoNetwork(ActionRequest request, ActionResponse response) throws Exception {
        //System.out.println("CSWHARVESTERPORTLET saveCSWHarvesterToGeoNetwork");
		CSWHarvester cswHarvester = CSWHarvesterLocalServiceUtil.getCSWHarvester(ParamUtil.getLong(request, "cswharvesterid"));
		if (!cswHarvester.getSavedToGeoNetwork()) {
			CSWHarvesterLocalServiceUtil.updateCSWHarvester(cswHarvester, Boolean.TRUE, Boolean.TRUE);
			SessionMessages.add(request, "cswHarvester-updated");
			sendRedirect(request, response);
				
		} else {
			SessionErrors.add(request, "aceharvestergeonetwork-exist");
			
			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("jspPage", "/html/cswharvester/edit_cswharvester.jsp");
		}
	}
	
	/**
	 * Executes a CswHarvester .
	 *
	 */
	public void executeCswHarvester(ActionRequest request, ActionResponse response) throws Exception {
        //System.out.println("CSWHARVESTERPORTLET executeCswHarvester ");
		CSWHarvester cswHarvester = CSWHarvesterLocalServiceUtil.getCSWHarvester(ParamUtil.getLong(request, "cswharvesterid"));
		if (cswHarvester.getSavedToGeoNetwork()) {
            cswHarvester.setStatus(HarvesterStatus.RUNNING.name());
            CSWHarvesterLocalServiceUtil.updateCSWHarvester(cswHarvester, Boolean.FALSE, Boolean.FALSE);
            // schedule in separate thread for immediate execution
            ScheduledExecutorService executionService = HarvesterExecutionService.getExecutionService();
            executionService.schedule(new HarvesterThread(cswHarvester), 1, TimeUnit.SECONDS);
            SessionMessages.add(request, "cswHarvester-updated");
			sendRedirect(request, response);
				
		} else {
			SessionErrors.add(request, "aceharvestergeonetwork-notexist");
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
}