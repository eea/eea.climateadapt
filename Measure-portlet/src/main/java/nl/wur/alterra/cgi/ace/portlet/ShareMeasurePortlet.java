package nl.wur.alterra.cgi.ace.portlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import nl.wur.alterra.cgi.ace.model.AceItem;
import nl.wur.alterra.cgi.ace.model.Measure;
import nl.wur.alterra.cgi.ace.model.impl.MeasureImpl;
import nl.wur.alterra.cgi.ace.search.ACESearchPortalInterface;
import nl.wur.alterra.cgi.ace.service.AceItemLocalServiceUtil;
import nl.wur.alterra.cgi.ace.service.MeasureLocalServiceUtil;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;

/**
 * Portlet implementation class ShareMeasurePortlet
 */
public class ShareMeasurePortlet extends MeasureUpdateHelperForSharedMeasure {

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        try {
            HttpServletRequest httpRequest =
                PortalUtil.getOriginalServletRequest(
                PortalUtil.getHttpServletRequest(renderRequest) ) ;

            try {
                int measureid = Integer.parseInt( httpRequest.getParameter("submissionid") ) ;
                renderRequest.getPortletSession().setAttribute("lastAddedMeasureId", "" +  measureid );

            } catch (NumberFormatException e) {
                // do nothing
            }



        } catch (Exception x) {
            x.printStackTrace();
            throw new PortletException(x);
        }

        super.doView(renderRequest, renderResponse);
    }

    /**
     * Adds a new measure to the database
     *
     */
    public void addMeasure(ActionRequest request, ActionResponse response)
        throws Exception {

        Measure measure = new MeasureImpl();
        UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
        String measure_id = uploadRequest.getParameter("measureId");

        if (Validator.isNull(measure_id)) {
            measure.setMeasureId(0);
        } else {
           measure.setMeasureId(ParamUtil.getLong(request, "measureId"));
        }

        ArrayList<String> errors = new ArrayList<String>();
        measureFromRequest(request, measure, uploadRequest, errors);

        if (MeasureValidator.validateMeasure(measure, errors)) {

            MeasureLocalServiceUtil.addMeasure(measure);

            // create an AceItem for this measure
            AceItem aceitem = AceItemLocalServiceUtil.createAceItem();
            aceitem.setAceItemId(ParamUtil.getLong(request, "aceItemId"));
            aceitem.setCompanyId(measure.getCompanyId());
            aceitem.setGroupId(measure.getGroupId());
            aceitem.setStoredAt("ace_measure_id=" + measure.getMeasureId());
            aceitem.setStoragetype("MEASURE");
            AceItemLocalServiceUtil.addAceItem(aceitem);
            updateAceItem(measure, aceitem);

            sendSubmitNotification(measure);
            request.setAttribute("justsaved", "true" );

            SessionMessages.add(request, "contribution-success");
            request.setAttribute("measureId", measure.getMeasureId());

            response.setRenderParameter("jspPage", "/html/shareinfo/add_measureRevised.jsp");
            //sendRedirect(request, response);
        } else {
            for (String error : errors) {
                SessionErrors.add(request, error);
            }
            SessionErrors.add(request, "invalid-form-data");

            PortalUtil.copyRequestParameters(request, response);
            request.setAttribute("measure", measure);
            response.setRenderParameter("jspPage", "/html/shareinfo/add_measureRevised.jsp");
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

        UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);

        try {
            measure = MeasureLocalServiceUtil.getMeasure(Long.parseLong(uploadRequest.getParameter("measureId")));
        } catch (Exception e) {
            measure = null;
        }

        if(measure != null) {
            //System.out.println("MEASURE ID IS " + uploadRequest.getParameter("measureId"));
            //System.out.println("REDIRECT IS " + uploadRequest.getParameter("redirect"));
            //String redirect = ParamUtil.getString(request, "redirect");
            //System.out.println("redirect using ParamUtil is " + redirect);

            ArrayList<String> errors = new ArrayList<String>();
            measureFromRequest(request, measure, uploadRequest, errors);

            if (MeasureValidator.validateMeasure(measure, errors)) {

                aceitem = AceItemLocalServiceUtil.getAceItemByStoredAt("ace_measure_id=" + measure.getMeasureId());

                MeasureLocalServiceUtil.updateMeasure(measure);

                updateAceItem(measure, aceitem);
                if (measure.getControlstatus() == -1)
                {
                    request.setAttribute("justsaved", "true" );

                    //SessionMessages.add(request, "contribution-success");
                    request.setAttribute("measureId", measure.getMeasureId());
                    response.setRenderParameter("jspPage", "/html/shareinfo/add_measureRevised.jsp");
                } else {
                   sendSubmitNotification(measure);
                   request.getPortletSession().setAttribute("lastAddedMeasureId", "" + measure.getMeasureId() );
                   SessionMessages.add(request, "contribution-success");
                   sendRedirect(request, response);
                }

            } else {
                for (String error : errors) {
                    SessionErrors.add(request, error);
                }

                SessionErrors.add(request, "invalid-form-data");
                //PortalUtil.copyRequestParameters(request, response);
                request.setAttribute("measureId", measure.getMeasureId());
                request.setAttribute("measure", measure);
                response.setRenderParameter("jspPage", "/html/shareinfo/add_measureRevised.jsp");
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
        UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);

        String mao_type = uploadRequest.getParameter( Constants.mao_typePreferenceName);

        prefs.setValue(Constants.mao_typePreferenceName, mao_type);

        String proxyUrl = uploadRequest.getParameter( Constants.proxyUrlPreferenceName);

        prefs.setValue(Constants.proxyUrlPreferenceName, proxyUrl);

        String geoserverUrl = uploadRequest.getParameter( Constants.geoserverUrlPreferenceName);

        if (! geoserverUrl.endsWith("/")) {
            geoserverUrl += "/";
        }

        prefs.setValue(Constants.geoserverUrlPreferenceName, geoserverUrl);

        String wfs = uploadRequest.getParameter( Constants.wfsPreferenceName);

        prefs.setValue(Constants.wfsPreferenceName, wfs);

        String wms = uploadRequest.getParameter( Constants.wmsPreferenceName);

        prefs.setValue(Constants.wmsPreferenceName, wms);

        String featurenamespace = uploadRequest.getParameter( Constants.featureNamespacePreferenceName);

        prefs.setValue(Constants.featureNamespacePreferenceName, featurenamespace);

        String areasFeatureType = uploadRequest.getParameter( Constants.areasFeatureTypePreferenceName);

        prefs.setValue(Constants.areasFeatureTypePreferenceName, areasFeatureType);

        String areasLayer = uploadRequest.getParameter( Constants.areasLayerPreferenceName);

        prefs.setValue(Constants.areasLayerPreferenceName, areasLayer);

        String caseStudiesFeatureType = uploadRequest.getParameter( Constants.caseStudiesFeatureTypePreferenceName);

        prefs.setValue(Constants.caseStudiesFeatureTypePreferenceName, caseStudiesFeatureType);

        String geometryColumn = uploadRequest.getParameter( Constants.geometryColumnPreferenceName);

        prefs.setValue(Constants.geometryColumnPreferenceName, geometryColumn);

        // Microsoft Virtual Earth locator REST API URL
        String locatorUrl = uploadRequest.getParameter( Constants.locatorUrlPreferenceName);

        if (! locatorUrl.endsWith("/")) {
            locatorUrl += "/";
        }
        prefs.setValue(Constants.locatorUrlPreferenceName, locatorUrl);

        // Microsoft VE API key
        String locatorkey = uploadRequest.getParameter( Constants.locatorKeyPreferenceName);

        prefs.setValue(Constants.locatorKeyPreferenceName, locatorkey);

        // Microsoft Bing time out
        String bingtimeout = uploadRequest.getParameter( Constants.bingTimeOutPreferenceName);

        prefs.setValue(Constants.bingTimeOutPreferenceName, bingtimeout);

        // ZoomLevel
        String zoomlevel = uploadRequest.getParameter( Constants.zoomLevelPreferenceName);

        prefs.setValue(Constants.zoomLevelPreferenceName, zoomlevel);

        prefs.store();
    }

}
