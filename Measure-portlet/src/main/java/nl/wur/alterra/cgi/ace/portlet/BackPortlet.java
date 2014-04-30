package nl.wur.alterra.cgi.ace.portlet;

import com.liferay.portal.util.PortalUtil;

import java.io.IOException;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Portlet implementation class BackPortlet
 */
public class BackPortlet extends GenericPortlet {

    public void init() {
        viewJSP = getInitParameter("view-jsp");
    }
    
    public void doView(
            RenderRequest renderRequest, RenderResponse renderResponse)
        throws IOException, PortletException {
    	        
        include(viewJSP, renderRequest, renderResponse);
    }

    protected void include(
            String path, RenderRequest renderRequest,
            RenderResponse renderResponse)
        throws IOException, PortletException {

        PortletRequestDispatcher portletRequestDispatcher =
            getPortletContext().getRequestDispatcher(path);

        portletRequestDispatcher.include(renderRequest, renderResponse);
    }
 
    protected String viewJSP;

}
