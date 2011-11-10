package nl.wur.alterra.cgi.ace.portlet;

import java.util.ArrayList;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;

import nl.wur.alterra.cgi.ace.model.AceItem;
import nl.wur.alterra.cgi.ace.model.Measure;
import nl.wur.alterra.cgi.ace.model.constants.AceItemClimateImpact;
import nl.wur.alterra.cgi.ace.model.constants.AceItemElement;
import nl.wur.alterra.cgi.ace.model.constants.AceItemSector;
import nl.wur.alterra.cgi.ace.model.impl.MeasureImpl;
import nl.wur.alterra.cgi.ace.service.AceItemLocalServiceUtil;
import nl.wur.alterra.cgi.ace.service.MeasureLocalServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class MeasurePortlet
 */
public class MeasurePortlet extends MVCPortlet {
	 
	/**
	 * Adds a new measure to the database
	 * 
	 */
	public void addMeasure(ActionRequest request, ActionResponse response)
		throws Exception {
		
		Measure measure = new MeasureImpl();
		
		measure.setMeasureId(ParamUtil.getLong(request, "measureId"));		
		measureFromRequest(request, measure);

		ArrayList<String> errors = new ArrayList<String>();

		if (MeasureValidator.validateMeasure(measure, errors)) {
			MeasureLocalServiceUtil.addMeasure(measure);

			//com.liferay.portal.kernel.dao.orm.EntityCacheUtil.clearCache();
			
			SessionMessages.add(request, "measure-added");

			sendRedirect(request, response);
		}
		else {
			for (String error : errors) {
				SessionErrors.add(request, error);
			}

			PortalUtil.copyRequestParameters(request, response);

			response.setRenderParameter("jspPage", "/html/measure/edit_measure.jsp");
		}
	}

	/**
	 * Convenience method to   F I L L   a Measure object out of the request. Used
	 * by the Add / Edit methods.
	 *
	 */
	private void measureFromRequest(PortletRequest request, Measure measure) {
		ThemeDisplay themeDisplay =
			(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		
		measure.setCompanyId(themeDisplay.getCompanyId());
		measure.setGroupId(themeDisplay.getScopeGroupId());
		
		measure.setName(ParamUtil.getString(request, "name"));
		measure.setDescription(ParamUtil.getString(request, "description"));
		measure.setImplementationtype(ParamUtil.getString(request, "implementationtype"));
		measure.setImplementationtime(ParamUtil.getString(request, "implementationtime"));
		measure.setLifetime(ParamUtil.getString(request, "lifetime"));
		measure.setSpatiallayer(ParamUtil.getString(request, "spatiallayer"));
		measure.setSpatialvalues(ParamUtil.getString(request, "spatialvalues"));		
		measure.setLegalaspects(ParamUtil.getString(request, "legalaspects"));
		measure.setStakeholderparticipation(ParamUtil.getString(request, "stakeholderparticipation"));
		measure.setContact(ParamUtil.getString(request, "contact"));
		measure.setSucceslimitations(ParamUtil.getString(request, "succeslimitations"));
		measure.setWebsite(ParamUtil.getString(request, "website"));
		measure.setCostbenefit(ParamUtil.getString(request, "costbenefit"));	
		measure.setKeywords(ParamUtil.getString(request, "keywords"));			
		/*		
		int dateMonth = ParamUtil.getInteger(request, "startdateMonth");
		int dateDay = ParamUtil.getInteger(request, "startdateDay");
		int dateYear = ParamUtil.getInteger(request, "startdateYear");
		Date startdate = PortalUtil.getDate(dateMonth, dateDay, dateYear);
		measure.setStartdate(startdate);
		
		dateMonth = ParamUtil.getInteger(request, "enddateMonth");
		dateDay = ParamUtil.getInteger(request, "enddateDay");
		dateYear = ParamUtil.getInteger(request, "enddateYear");
		Date enddate = PortalUtil.getDate(dateMonth, dateDay, dateYear);
		measure.setEnddate(enddate);
		
		dateMonth = ParamUtil.getInteger(request, "publicationdateMonth");
		dateDay = ParamUtil.getInteger(request, "publicationdateDay");
		dateYear = ParamUtil.getInteger(request, "publicationdateYear");
		Date publicationdate = PortalUtil.getDate(dateMonth, dateDay, dateYear);
		measure.setEndDate(publicationdate);
*/	
		measure.setLanguage(ParamUtil.getString(request, "language"));

		//String sectors = ParamUtil.getString(request, "sectors_");
		
		//if( sectors.equalsIgnoreCase("All")) {
		//	sectors = "A;B;C;D;F;H;I;M;W;";
		//}
		
		//measure.setSectors_(sectors);
		//measure.setElements_(ParamUtil.getString(request, "elements_"));
		//measure.setClimateimpacts_(ParamUtil.getString(request, "climateimpacts_"));
		
		String choosensectors = "";
		for(AceItemSector aceitemsector : AceItemSector.values() ) {
			
			if( ParamUtil.getString(request, "chk_sectors_" + aceitemsector.toString()) != null )  {
				String s =  ParamUtil.getString(request, "chk_sectors_" + aceitemsector.toString());
				if(s.equalsIgnoreCase(aceitemsector.toString())) {				
					choosensectors +=  aceitemsector.toString() + ";";
				}
			}
		}
		measure.setSectors_(choosensectors);
		
		String choosenelements = "";
		for(AceItemElement aceitemelement : AceItemElement.values() ) {
			if( ParamUtil.getString(request, "chk_elements_" + aceitemelement) != null )  {
				String e =  ParamUtil.getString(request, "chk_elements_" + aceitemelement);
				if(e.equalsIgnoreCase(aceitemelement.toString())) {
					choosenelements +=  aceitemelement.toString() + ";";
				}
			}
		}		
		measure.setElements_(choosenelements);
		
		String choosenclimateimpacts = "";
		for(AceItemClimateImpact aceitemclimateimpact : AceItemClimateImpact.values() ) {
			if( ParamUtil.getString(request, "chk_climateimpacts_" + aceitemclimateimpact) != null )  {
				String e =  ParamUtil.getString(request, "chk_climateimpacts_" + aceitemclimateimpact);
				if(e.equalsIgnoreCase(aceitemclimateimpact.toString())) {
					choosenclimateimpacts +=  aceitemclimateimpact.toString() + ";";
				}
			}
		}		
		measure.setClimateimpacts_(choosenclimateimpacts);
		
		measure.setMao_type(ParamUtil.getString(request, "mao_type"));
		measure.setSource(ParamUtil.getString(request, "source"));

		String importance = ParamUtil.getString(request, "chk_importance");
		if(measure.getImportance() == 1) {
			measure.setImportance( measure.getImportance()-1 );
			measure.setRating( measure.getRating() - 100);

		}
		if( importance != null && importance.equalsIgnoreCase("1")) {
			measure.setImportance(measure.getImportance()+1);
			measure.setRating( measure.getRating() + 100);
		}
		
		measure.setLat(Double.parseDouble(ParamUtil.getString(request, "lat")));
		measure.setLon(Double.parseDouble(ParamUtil.getString(request, "lon")));
		measure.setSatarea(ParamUtil.getString(request, "satarea"));
	}

	/**
	 * Updates the database record of an existing measure.
	 *
	 */
	public void updateMeasure(ActionRequest request, ActionResponse response)
		throws Exception {

		Measure measure = MeasureLocalServiceUtil.getMeasure(ParamUtil.getLong(request, "measureId"));
		
		measureFromRequest(request, measure);

		ArrayList<String> errors = new ArrayList<String>();

		if (MeasureValidator.validateMeasure(measure, errors)) {
			MeasureLocalServiceUtil.updateMeasure(measure);

			//com.liferay.portal.kernel.dao.orm.EntityCacheUtil.clearCache();
			
			updateAceItem(measure);
			
			SessionMessages.add(request, "measure-updated");
			
			sendRedirect(request, response);
		}
		else {
			for (String error : errors) {
				SessionErrors.add(request, error);
			}

			PortalUtil.copyRequestParameters(request, response);

			response.setRenderParameter("jspPage", "/html/measure/edit_measure.jsp");
		}
	}


	/**
	 * Deletes a measure from the database.
	 *
	 */
	public void deleteMeasure(ActionRequest request, ActionResponse response)
		throws Exception {

		long measureId = ParamUtil.getLong(request, "measureId");

		ArrayList<String> errors = new ArrayList<String>();

		if (Validator.isNotNull(measureId)) {
			MeasureLocalServiceUtil.deleteMeasure(measureId);

			SessionMessages.add(request, "measure-deleted");

			sendRedirect(request, response);
		}
		else {
			SessionErrors.add(request, "error-deleting");
		}
	}
	
	/**
	 * Update the corresponding AceItem when updating a Project.
	 *
	 */
	private void updateAceItem(Measure measure) throws Exception {
		AceItem aceitem = AceItemLocalServiceUtil.getAceItemByStoredAt("ace_measure_id=" + measure.getMeasureId());
		
		aceitem.setRating(measure.getRating());
		
		AceItemLocalServiceUtil.updateAceItem(aceitem);
	}
	
	/**
	 * Sets the preferences for how measures can be ordered
	 *
	 */
	public void setMeasurePref(ActionRequest request, ActionResponse response)
		throws Exception {

		String orderByCol = ParamUtil.getString(request, Constants.ORDERBYCOL);

		PortletPreferences prefs = request.getPreferences();

		prefs.setValue(Constants.ORDERBYCOL, orderByCol);

		String orderByType = ParamUtil.getString(request, Constants.ORDERBYTYPE);

		prefs.setValue(Constants.ORDERBYTYPE, orderByType);

		String proxyUrl = ParamUtil.getString(request, Constants.proxyUrlPreferenceName);

		prefs.setValue(Constants.proxyUrlPreferenceName, proxyUrl);
		
		String geoserverUrl = ParamUtil.getString(request, Constants.geoserverUrlPreferenceName);
		
		if (! geoserverUrl.endsWith("/")) {
			geoserverUrl += "/";
		}

		prefs.setValue(Constants.geoserverUrlPreferenceName, geoserverUrl);
		
		String wfs = ParamUtil.getString(request, Constants.wfsPreferenceName);

		prefs.setValue(Constants.wfsPreferenceName, wfs);
		
		String wms = ParamUtil.getString(request, Constants.wmsPreferenceName);

		prefs.setValue(Constants.wmsPreferenceName, wms);

		// Microsoft Virtual Earth locator REST API URL
		String locatorUrl = ParamUtil.getString(request, Constants.locatorUrlPreferenceName);
		
		if (! locatorUrl.endsWith("/")) {
			locatorUrl += "/";
		}

		prefs.setValue(Constants.locatorUrlPreferenceName, locatorUrl);
		
		// Microsoft VE API key
		String locatorkey = ParamUtil.getString(request, Constants.locatorKeyPreferenceName);

		prefs.setValue(Constants.locatorKeyPreferenceName, locatorkey);
		
		// Microsoft Bing time out
		String bingtimeout = ParamUtil.getString(request, Constants.bingTimeOutPreferenceName);

		prefs.setValue(Constants.bingTimeOutPreferenceName, bingtimeout);

		prefs.store();
	}
	
	private static Log _log = LogFactoryUtil.getLog(MeasurePortlet.class);
 

}
