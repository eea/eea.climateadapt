package nl.wur.alterra.cgi.ace.portlet;

import java.util.ArrayList;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;

import nl.wur.alterra.cgi.ace.model.AceItem;
import nl.wur.alterra.cgi.ace.model.Measure;
import nl.wur.alterra.cgi.ace.model.impl.AceItemImpl;
import nl.wur.alterra.cgi.ace.model.impl.MeasureImpl;
import nl.wur.alterra.cgi.ace.search.lucene.ACEIndexSynchronizer;
import nl.wur.alterra.cgi.ace.service.AceItemLocalServiceUtil;
import nl.wur.alterra.cgi.ace.service.MeasureLocalServiceUtil;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;

/**
 * Portlet implementation class MeasurePortlet
 */
public class MeasurePortlet extends MeasureUpdateHelper {
	 
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

			// create an AceItem for this measure
			AceItem aceitem = new AceItemImpl();
			aceitem.setAceItemId(ParamUtil.getLong(request, "aceItemId"));
			aceitem.setCompanyId(measure.getCompanyId());
			aceitem.setGroupId(measure.getGroupId());
			aceitem.setStoredAt("ace_measure_id=" + measure.getMeasureId());
			aceitem.setStoragetype("MEASURE");
			AceItemLocalServiceUtil.addAceItem(aceitem);
			updateAceItem(measure, aceitem);
			
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
	 * Deletes a measure from the database.
	 *
	 */
	public void deleteMeasure(ActionRequest request, ActionResponse response)
		throws Exception {

		long measureId = ParamUtil.getLong(request, "measureId");

		if (Validator.isNotNull(measureId)) {
			
			Measure measure = MeasureLocalServiceUtil.getMeasure(measureId);
 
			if(measure.getReplacesId() != 0) {
				// Candidate gets deleted: the already approved measure gets editable again
					measure = MeasureLocalServiceUtil.getMeasure( measure.getReplacesId() );
					measure.setReplacesId( (long) 0);
					MeasureLocalServiceUtil.updateMeasure(measure);
			}
			else {
				// get the associated aceitem
				AceItem aceitem = AceItemLocalServiceUtil.getAceItemByStoredAt("ace_measure_id=" + measureId);
				// delete the aceitem index entry
				new ACEIndexSynchronizer().delete(aceitem);			
				// delete the aceitem
				AceItemLocalServiceUtil.deleteAceItem(aceitem.getAceItemId());					
			}
			
			// delete the measure by saved Id (measure itself may be the old one here)				
			MeasureLocalServiceUtil.deleteMeasure(measureId);

			SessionMessages.add(request, "measure-deleted");

			sendRedirect(request, response);
		}
		else {
			SessionErrors.add(request, "error-deleting");
		}
	}

	/**
	 * Sets the preferences for how measures can be ordered
	 *
	 */
	public void setMeasurePref(ActionRequest request, ActionResponse response)
		throws Exception {
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
		
		// ZoomLevel
		String zoomlevel = ParamUtil.getString(request, Constants.zoomLevelPreferenceName);

		prefs.setValue(Constants.zoomLevelPreferenceName, zoomlevel);

		prefs.store();
	} 

}
