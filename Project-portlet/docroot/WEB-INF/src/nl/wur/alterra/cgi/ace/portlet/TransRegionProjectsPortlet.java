package nl.wur.alterra.cgi.ace.portlet;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 *
 * @author jaanus
 *
 */
public class TransRegionProjectsPortlet extends MVCPortlet{

	/**
	 * @see com.liferay.util.bridges.mvc.MVCPortlet#doView(javax.portlet.RenderRequest, javax.portlet.RenderResponse)
	 */
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

    	HttpServletRequest httpRequest =  PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest)) ;
    	renderRequest.setAttribute("testAttr", "testAttrValue");
        include(viewJSP, renderRequest, renderResponse);
    }
}
