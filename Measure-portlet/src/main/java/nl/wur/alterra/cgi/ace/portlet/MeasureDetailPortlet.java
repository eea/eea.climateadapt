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

import nl.wur.alterra.cgi.ace.model.Measure;
import nl.wur.alterra.cgi.ace.service.MeasureLocalServiceUtil;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class MeasureDetailPortlet
 */
public class MeasureDetailPortlet extends MVCPortlet {

    public void doView(
            RenderRequest renderRequest, RenderResponse renderResponse)
        throws IOException, PortletException {

        HttpServletRequest httpRequest =
            PortalUtil.getOriginalServletRequest(
            PortalUtil.getHttpServletRequest(renderRequest) ) ;

            renderRequest.setAttribute(Constants.MEASUREID, httpRequest.getParameter("ace_measure_id"));

            super.doView(renderRequest, renderResponse);
    }

    /**
     * Increases rating for measure.
     *
     */
    public void rateUpMeasure(ActionRequest request, ActionResponse response)
        throws Exception {

        long measureId = ParamUtil.getLong(request, "measureId");

        ArrayList<String> errors = new ArrayList<String>();

        if (Validator.isNotNull(measureId)) {
            Measure measure = MeasureLocalServiceUtil.getMeasure(measureId);

            measure.setRating( measure.getRating() + 1 );

            MeasureLocalServiceUtil.updateMeasure(measure);

            request.getPortletSession().setAttribute("lastRatedMeasureId", "" + measureId);

            sendRedirect(request, response);
        } else {
            SessionErrors.add(request, "error-rating");
        }
    }

    /**
     * Decreases rating for measure.
     *
     */
    public void rateDownMeasure(ActionRequest request, ActionResponse response)
        throws Exception {

        long measureId = ParamUtil.getLong(request, "measureId");

        ArrayList<String> errors = new ArrayList<String>();

        if (Validator.isNotNull(measureId)) {
            Measure measure = MeasureLocalServiceUtil.getMeasure(measureId);

            measure.setRating( measure.getRating() - 1 );

            MeasureLocalServiceUtil.updateMeasure(measure);

            request.getPortletSession().setAttribute("lastRatedMeasureId", "" + measureId);

            sendRedirect(request, response);
        } else {
            SessionErrors.add(request, "error-rating");
        }
    }

    // override
    protected void addSuccessMessage(
        ActionRequest actionRequest, ActionResponse actionResponse) {

        SessionMessages.add(actionRequest, "request_processed", "Thank you for your feedback");
    }

}
