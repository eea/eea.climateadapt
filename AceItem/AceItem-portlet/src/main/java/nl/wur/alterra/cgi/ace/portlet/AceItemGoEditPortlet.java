package nl.wur.alterra.cgi.ace.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import nl.wur.alterra.cgi.ace.model.AceItem;
import nl.wur.alterra.cgi.ace.search.lucene.ACEIndexUtil;
import nl.wur.alterra.cgi.ace.service.AceItemLocalServiceUtil;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class AceItemGoEditPortlet
 */
public class AceItemGoEditPortlet extends MVCPortlet {
    
    public void doView(
            RenderRequest renderRequest, RenderResponse renderResponse)
        throws IOException, PortletException {
    	
    	HttpServletRequest httpRequest = 
    		PortalUtil.getOriginalServletRequest(
    		PortalUtil.getHttpServletRequest(renderRequest) ) ;
    	
    	if( httpRequest.getParameter(Constants.ACEITEMID) != null ) {		
			try {
				AceItem aceitem = null;
    			try {
    				aceitem =AceItemLocalServiceUtil.getAceItem( Long.parseLong(httpRequest.getParameter(Constants.ACEITEMID) ) ) ;
    			}
    			catch(Exception e) {
    				aceitem = null;
    			}
    			
    			// if there is no candidate item for this item: edit is permitted
    			if((aceitem != null) && (aceitem.getReplacesId() != aceitem.getAceItemId())
						&&
						! aceitem.getStoragetype().equalsIgnoreCase("PROJECT") 
						&&
						! aceitem.getStoragetype().equalsIgnoreCase("MEASURE") 
        			    && ( 
    			    		 renderRequest.isUserInRole("Portal Content Reviewer") || 
    						 renderRequest.isUserInRole("administrator") ||
    						 renderRequest.isUserInRole("Power User") || 
    					     renderRequest.isUserInRole("User")
        					)
        			   ) {  
					renderRequest.setAttribute(Constants.ACEITEMID, httpRequest.getParameter(Constants.ACEITEMID));
				}
			}
			catch (Exception e) {
				System.out.println(e.getMessage()) ;
				e.printStackTrace(System.out) ;
			} 
    	}
    		
        super.doView(renderRequest, renderResponse);
    }
    
	/**
	 * Sets the preferences: base url for editing
	 *
	 */
	public void setAceItemGoEditPref(ActionRequest request, ActionResponse response) throws Exception {
		String editUrl = ParamUtil.getString(request, Constants.EDITURL);
		PortletPreferences prefs = request.getPreferences();
		prefs.setValue(Constants.EDITURL, editUrl);

		String publicationShareEditUrl = ParamUtil.getString(request, Constants.PUBLICATIONSHAREEDITURL);
		prefs.setValue(Constants.PUBLICATIONSHAREEDITURL, publicationShareEditUrl);

		String infoportalShareEditUrl = ParamUtil.getString(request, Constants.INFOPORTALSHAREEDITURL);
		prefs.setValue(Constants.INFOPORTALSHAREEDITURL, infoportalShareEditUrl);

		String guidanceShareEditUrl = ParamUtil.getString(request, Constants.GUIDANCESHAREEDITURL);
		prefs.setValue(Constants.GUIDANCESHAREEDITURL, guidanceShareEditUrl);

		String toolShareEditUrl = ParamUtil.getString(request, Constants.TOOLSHAREEDITURL);
		prefs.setValue(Constants.TOOLSHAREEDITURL, toolShareEditUrl);

		String organisationShareEditUrl = ParamUtil.getString(request, Constants.ORGANISATIONSHAREEDITURL);
		prefs.setValue(Constants.ORGANISATIONSHAREEDITURL, organisationShareEditUrl);
		
		prefs.store();
	}
}
