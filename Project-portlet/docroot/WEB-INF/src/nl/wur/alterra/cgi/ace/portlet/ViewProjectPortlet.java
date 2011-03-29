package nl.wur.alterra.cgi.ace.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.util.PortalUtil;

import java.io.IOException;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Portlet implementation class ViewProjectPortlet
 */
public class ViewProjectPortlet extends GenericPortlet {

    private static final String ID = "project_id";
    
    public void init() {
        viewJSP = getInitParameter("view-jsp");
    }
 
   
    public void doView(
            RenderRequest renderRequest, RenderResponse renderResponse)
        throws IOException, PortletException {
    	
    	HttpServletRequest httpRequest = 
    		PortalUtil.getOriginalServletRequest(
    		PortalUtil.getHttpServletRequest(renderRequest) ) ;
   	
    	renderRequest.setAttribute(ID, httpRequest.getParameter("ace_project_id"));
    	//renderRequest.setAttribute(ID, 3l);  // works
    	
        include(viewJSP, renderRequest, renderResponse);
    }

    protected void include(
            String path, RenderRequest renderRequest,
            RenderResponse renderResponse)
        throws IOException, PortletException {

        PortletRequestDispatcher portletRequestDispatcher =
            getPortletContext().getRequestDispatcher(path);

        if (portletRequestDispatcher == null) {
            _log.error(path + " is not a valid include");
        }
        else {
            portletRequestDispatcher.include(renderRequest, renderResponse);
        }
    }
 
    protected String viewJSP;

    private static Log _log = LogFactoryUtil.getLog(ViewProjectPortlet.class);

}


    
