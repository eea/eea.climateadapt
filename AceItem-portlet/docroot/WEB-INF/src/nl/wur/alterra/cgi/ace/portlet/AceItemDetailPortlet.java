package nl.wur.alterra.cgi.ace.portlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import nl.wur.alterra.cgi.ace.model.AceItem;
import nl.wur.alterra.cgi.ace.service.AceItemLocalServiceUtil;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class AceItemDetailPortlet
 */
public class AceItemDetailPortlet extends MVCPortlet {
 
    private static final String ID = "aceitem_id";

    public void doView(
            RenderRequest renderRequest, RenderResponse renderResponse)
        throws IOException, PortletException {
    	
    	HttpServletRequest httpRequest = 
    		PortalUtil.getOriginalServletRequest(
    		PortalUtil.getHttpServletRequest(renderRequest) ) ;
        	
    		renderRequest.setAttribute(ID, httpRequest.getParameter("aceitem_id"));
    		
        include(viewJSP, renderRequest, renderResponse);
    }    

	/**
	 * Increases rating for aceitem.
	 *
	 */
	public void rateUpAceItem(ActionRequest request, ActionResponse response)
		throws Exception {

		long aceitemId = ParamUtil.getLong(request, "aceitemId");

		ArrayList<String> errors = new ArrayList<String>();

		if (Validator.isNotNull(aceitemId)) {
			AceItem aceitem = AceItemLocalServiceUtil.getAceItem(aceitemId);
			
			aceitem.setRating( aceitem.getRating() + 1 );
			
			AceItemLocalServiceUtil.updateAceItem(aceitem); 
			
			request.getPortletSession().setAttribute("lastRatedAceItemId", "" + aceitemId);
			
			sendRedirect(request, response);
		}
		else {
			SessionErrors.add(request, "error-rating");
		}
	}  

	/**
	 * Decreases rating for aceitem.
	 *
	 */
	public void rateDownAceItem(ActionRequest request, ActionResponse response)
		throws Exception {

		long aceitemId = ParamUtil.getLong(request, "aceitemId");

		ArrayList<String> errors = new ArrayList<String>();

		if (Validator.isNotNull(aceitemId)) {
			AceItem aceitem = AceItemLocalServiceUtil.getAceItem(aceitemId);
			
			aceitem.setRating( aceitem.getRating() - 1 );
			
			AceItemLocalServiceUtil.updateAceItem(aceitem); 
			
			request.getPortletSession().setAttribute("lastRatedAceItemId", "" + aceitemId);
			
			sendRedirect(request, response);
		}
		else {
			SessionErrors.add(request, "error-rating");
		}
	}
}
