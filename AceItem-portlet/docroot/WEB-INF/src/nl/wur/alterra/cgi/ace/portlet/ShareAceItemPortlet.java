package nl.wur.alterra.cgi.ace.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import nl.wur.alterra.cgi.ace.model.AceItem;
import nl.wur.alterra.cgi.ace.model.impl.AceItemImpl;
import nl.wur.alterra.cgi.ace.service.AceItemLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;

/**
 * Portlet implementation class ShareAceItemPortlet
 */
public class ShareAceItemPortlet extends LuceneIndexUpdatePortletForShareAceItem {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		try {
	    	HttpServletRequest httpRequest = 
	    		PortalUtil.getOriginalServletRequest(
	    		PortalUtil.getHttpServletRequest(renderRequest) ) ;

	    	try {
	    		int aceitemid = Integer.parseInt( httpRequest.getParameter("submissionid") ) ;
				renderRequest.getPortletSession().setAttribute("lastAddedAceItemId", "" +  aceitemid );
	    	}
	    	catch (NumberFormatException e) {
	    		// do nothing
	    	}
		}
        catch (Exception x) {
			x.printStackTrace();
            throw new PortletException(x);
		}
		
		
		super.doView(renderRequest, renderResponse);
	}

	/**
	 * Adds a new aceitem to the database.
	 *
	 */
	public void addAceItem(ActionRequest request, ActionResponse response) throws Exception {
		AceItem aceitem = new AceItemImpl();
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
	    String aceitem_id = uploadRequest.getParameter("aceItemId");
		
		if (Validator.isNull(aceitem_id))
		{
			aceitem.setAceItemId(0);
		}
		else
		{
			aceitem.setAceItemId(ParamUtil.getLong(request, "aceItemId"));
		}
		
		aceitem.setAceItemId(ParamUtil.getLong(request, "aceItemId"));
		ArrayList<String> errors = new ArrayList<String>();
		aceitemFromRequest(request, aceitem, uploadRequest, errors);
		
		if (AceItemValidator.validateAceItem(aceitem, errors)) {
			AceItemLocalServiceUtil.addAceItem(aceitem);
            synchronizeIndexSingleAceItem(aceitem);
            
            // don't want to send email and save the session when it is a save
            /*sendSubmitNotification(aceitem);
			request.getPortletSession().setAttribute("lastAddedAceItemId", "" + aceitem.getAceItemId() ); */

			request.setAttribute("justsaved", "true");
			request.setAttribute("aceitemId", aceitem.getAceItemId());
			SessionMessages.add(request, "contribution-success");
			// let the save takes to the form so that the user can review the page on the review tab
			response.setRenderParameter("jspPage", "/html/shareinfo/add_aceitem.jsp");
			//sendRedirect(request, response);
		}
		else {
			for (String error : errors) {
				SessionErrors.add(request, error);
			}
			SessionErrors.add(request, "invalid-form-data");
			PortalUtil.copyRequestParameters(request, response);
			request.setAttribute("aceitem", aceitem);
			response.setRenderParameter("jspPage", "/html/shareinfo/add_aceitem.jsp");
		}
	}

	/**
	 * Updates the database record of an existing aceitem.
	 *
	 */
	public void updateAceItem(ActionRequest request, ActionResponse response) throws Exception {
		AceItem aceitem = null;
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
		
		try {
			aceitem = AceItemLocalServiceUtil.getAceItem(Long.parseLong(uploadRequest.getParameter("aceItemId")));
		}
		catch (Exception e) {
			aceitem = null;
		}
		
		if(aceitem != null) {
			ArrayList<String> errors = new ArrayList<String>();
			aceitemFromRequest(request, aceitem, uploadRequest, errors);

			if (AceItemValidator.validateAceItem(aceitem, errors)) {

				AceItemLocalServiceUtil.updateAceItem(aceitem);
	            synchronizeIndexSingleAceItem(aceitem);
	            
	            // send the mail only when it is a submit 
	        	if (aceitem.getControlstatus() == -1)
				{
					request.setAttribute("justsaved", "true" );
					request.setAttribute("aceitemId", aceitem.getAceItemId());
					response.setRenderParameter("jspPage", "/html/shareinfo/add_aceitem.jsp");
					
				}
				else
				{
	               sendSubmitNotification(aceitem);
	              // request.getPortletSession().setAttribute("lastAddedAceItemId", "" + aceitem.getAceItemId() );
	               SessionMessages.add(request, "contribution-success");
				   sendRedirect(request, response);
				}
			}
			else {
				for (String error : errors) {
					SessionErrors.add(request, error);
				}
				SessionErrors.add(request, "invalid-form-data");
				PortalUtil.copyRequestParameters(request, response);
				request.setAttribute("aceitemId", aceitem.getAceItemId());
				response.setRenderParameter("jspPage", "/html/shareinfo/add_aceitem.jsp");
			}
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
