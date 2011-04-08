package nl.wur.alterra.cgi.ace.portlet;

import java.util.ArrayList;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;

import nl.wur.alterra.cgi.ace.model.Measure;
import nl.wur.alterra.cgi.ace.model.impl.MeasureImpl;
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

		Measure measure = measureFromRequest(request);

		ArrayList<String> errors = new ArrayList<String>();

		if (MeasureValidator.validateMeasure(measure, errors)) {
			MeasureLocalServiceUtil.addMeasure(measure);

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
	 * Convenience method to create a Measure object out of the request. Used
	 * by the Add / Edit methods.
	 *
	 */
	private Measure measureFromRequest(PortletRequest request) {
		ThemeDisplay themeDisplay =
			(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		MeasureImpl measure = new MeasureImpl();

		measure.setCompanyId(themeDisplay.getCompanyId());
		measure.setGroupId(themeDisplay.getScopeGroupId());
		
		measure.setMeasureId(ParamUtil.getLong(request, "measureId"));
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

		String sectors = ParamUtil.getString(request, "sectors_");
		
		if( sectors.equalsIgnoreCase("All")) {
			sectors = "A;B;C;D;F;H;I;M;W;";
		}
		
		measure.setSectors_(sectors);
		measure.setElements_(ParamUtil.getString(request, "elements_"));
		measure.setClimateimpacts_(ParamUtil.getString(request, "climateimpacts_"));
		measure.setMao_type(ParamUtil.getString(request, "mao_type"));

		return measure;
	}

	/**
	 * Updates the database record of an existing measure.
	 *
	 */
	public void updateMeasure(ActionRequest request, ActionResponse response)
		throws Exception {

		Measure measure = measureFromRequest(request);

		ArrayList<String> errors = new ArrayList<String>();

		if (MeasureValidator.validateMeasure(measure, errors)) {
			MeasureLocalServiceUtil.updateMeasure(measure);

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
	
	private static Log _log = LogFactoryUtil.getLog(MeasurePortlet.class);
 

}
