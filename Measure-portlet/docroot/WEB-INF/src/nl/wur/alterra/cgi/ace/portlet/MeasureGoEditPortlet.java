package nl.wur.alterra.cgi.ace.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import nl.wur.alterra.cgi.ace.model.Measure;
import nl.wur.alterra.cgi.ace.search.lucene.ACEIndexUtil;
import nl.wur.alterra.cgi.ace.service.MeasureLocalServiceUtil;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class MeasureGoEditPortlet
 */
public class MeasureGoEditPortlet extends MVCPortlet {
    
    public void doView(
            RenderRequest renderRequest, RenderResponse renderResponse)
        throws IOException, PortletException {
    	
    	HttpServletRequest httpRequest = 
    		PortalUtil.getOriginalServletRequest(
    		PortalUtil.getHttpServletRequest(renderRequest) ) ;
 
    	if( httpRequest.getParameter("ace_measure_id") != null ) {
    		try {
    			Measure measure = null;
    			try {
    				measure = MeasureLocalServiceUtil.getMeasure( Long.parseLong(httpRequest.getParameter("ace_measure_id") ) ) ;
    			}
    			catch(Exception e) {
    				measure = null;
    			}
    			
    			// if there is no candidate item for this item: edit is permitted
    			if((measure != null) && (measure.getReplacesId() != measure.getMeasureId())
        			    && ( 
       			    		 renderRequest.isUserInRole("Portal Content Reviewer") || 
       						 renderRequest.isUserInRole("administrator") ||
       						 renderRequest.isUserInRole("Power User") || 
       					     renderRequest.isUserInRole("User")
           					)
           			   ) { 
    				renderRequest.setAttribute(Constants.MEASUREID, httpRequest.getParameter("ace_measure_id"));
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
	public void setMeasureGoEditPref(ActionRequest request, ActionResponse response) throws Exception {
		String editUrl = ParamUtil.getString(request, Constants.EDITURL);
		PortletPreferences prefs = request.getPreferences();
		prefs.setValue(Constants.EDITURL, editUrl);

		String adaptationoptionShareEditUrl = ParamUtil.getString(request, Constants.ADAPATIONOPTIONSHAREEDITURL);
		prefs.setValue(Constants.ADAPATIONOPTIONSHAREEDITURL, adaptationoptionShareEditUrl);

		String casestudyShareEditUrl = ParamUtil.getString(request, Constants.CASESTUDYSHAREEDITURL);
		prefs.setValue(Constants.CASESTUDYSHAREEDITURL, casestudyShareEditUrl);
		
		prefs.store();
	}
}
