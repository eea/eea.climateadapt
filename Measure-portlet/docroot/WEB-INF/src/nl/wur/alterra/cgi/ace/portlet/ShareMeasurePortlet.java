package nl.wur.alterra.cgi.ace.portlet;

import java.util.ArrayList;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;

import nl.wur.alterra.cgi.ace.model.AceItem;
import nl.wur.alterra.cgi.ace.model.Measure;
import nl.wur.alterra.cgi.ace.model.impl.AceItemImpl;
import nl.wur.alterra.cgi.ace.model.impl.MeasureImpl;
import nl.wur.alterra.cgi.ace.service.AceItemLocalServiceUtil;
import nl.wur.alterra.cgi.ace.service.MeasureLocalServiceUtil;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;

/**
 * Portlet implementation class ShareMeasurePortlet
 */
public class ShareMeasurePortlet extends MeasureUpdateHelper {


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

            sendSubmitNotification(measure);
			request.getPortletSession().setAttribute("lastAddedMeasureId", "" + measure.getMeasureId() );

			SessionMessages.add(request, "contribution-success");
			sendRedirect(request, response);
		}
		else {
			for (String error : errors) {
				SessionErrors.add(request, error);
			}

			PortalUtil.copyRequestParameters(request, response);

			response.setRenderParameter("jspPage", "/html/shareinfo/add_measure.jsp");
		}
	}

	/**
	 * Updates the database record of an existing measure.
	 *
	 */
	public void updateMeasure(ActionRequest request, ActionResponse response)
		throws Exception {

		AceItem aceitem = null;

		Measure measure = null;

		try {
			measure = MeasureLocalServiceUtil.getMeasure(ParamUtil.getLong(request, "measureId"));
		}
		catch (Exception e) {
			measure = null;
		}

		if(measure != null) {

			measureFromRequest(request, measure);

			ArrayList<String> errors = new ArrayList<String>();

			if (MeasureValidator.validateMeasure(measure, errors)) {

				aceitem = AceItemLocalServiceUtil.getAceItemByStoredAt("ace_measure_id=" + measure.getMeasureId());

				MeasureLocalServiceUtil.updateMeasure(measure);

				updateAceItem(measure, aceitem);

	            sendSubmitNotification(measure);
				request.getPortletSession().setAttribute("lastAddedMeasureId", "" + measure.getMeasureId() );

				SessionMessages.add(request, "contribution-success");
				sendRedirect(request, response);
			}
			else {
				for (String error : errors) {
					SessionErrors.add(request, error);
				}

				PortalUtil.copyRequestParameters(request, response);

				response.setRenderParameter("jspPage", "/html/shareinfo/add_measure.jsp");
			}
		}
	}

	/**
	 * Sets the preferences for how measures can be ordered
	 *
	 */
	public void setAddMeasurePref(ActionRequest request, ActionResponse response)
		throws Exception {

		PortletPreferences prefs = request.getPreferences();

		String mao_type = ParamUtil.getString(request, Constants.mao_typePreferenceName);

		prefs.setValue(Constants.mao_typePreferenceName, mao_type);

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

		String featurenamespace = ParamUtil.getString(request, Constants.featureNamespacePreferenceName);

		prefs.setValue(Constants.featureNamespacePreferenceName, featurenamespace);

	    String areasFeatureType = ParamUtil.getString(request, Constants.areasFeatureTypePreferenceName);

		prefs.setValue(Constants.areasFeatureTypePreferenceName, areasFeatureType);

	    String areasLayer = ParamUtil.getString(request, Constants.areasLayerPreferenceName);

		prefs.setValue(Constants.areasLayerPreferenceName, areasLayer);

	    String caseStudiesFeatureType = ParamUtil.getString(request, Constants.caseStudiesFeatureTypePreferenceName);

		prefs.setValue(Constants.caseStudiesFeatureTypePreferenceName, caseStudiesFeatureType);

	    String geometryColumn = ParamUtil.getString(request, Constants.geometryColumnPreferenceName);

		prefs.setValue(Constants.geometryColumnPreferenceName, geometryColumn);

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
