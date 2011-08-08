package nl.wur.alterra.cgi.ace.portlet;

import nl.wur.alterra.cgi.ace.search.ACESearchPortalInterface;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;

/**
 * TODO javadoc.
 *
 * This portlet should have AceItemType.MEASURE.toString(), AceItemType.ACTION.toString() in its preferences.
 *
 */
public class AdaptationToolJSPPortlet extends GenericPortlet {

    /**
     * TODO javadoc.
     *
     * @throws PortletException
     */
    @Override
	public void init() throws PortletException {
		editJSP = getInitParameter("edit-jsp");
		helpJSP = getInitParameter("help-jsp");
		viewJSP = getInitParameter("view-jsp");
	}

    /**
     * TODO javadoc.
     *
     * @param renderRequest renderRequest
     * @param renderResponse renderResponse
     * @throws IOException hmm
     * @throws PortletException hmm
     */
    @Override
	public void doDispatch(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		String jspPage = renderRequest.getParameter("jspPage");
		if (jspPage != null) {
			include(jspPage, renderRequest, renderResponse);
		}
		else {
			super.doDispatch(renderRequest, renderResponse);
		}
	}

    /**
     * TODO javadoc.
     *
     * @param renderRequest renderRequest
     * @param renderResponse renderResponse
     * @throws IOException hmm
     * @throws PortletException hmm
     */
    @Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		if (renderRequest.getPreferences() == null) {
			super.doEdit(renderRequest, renderResponse);
		}
		else {
			include(editJSP, renderRequest, renderResponse);
		}
	}

    /**
     * TODO javadoc.
     *
     * @param renderRequest renderRequest
     * @param renderResponse renderResponse
     * @throws IOException hmm
     * @throws PortletException hmm
     */
    @Override
	public void doHelp(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		include(helpJSP, renderRequest, renderResponse);
	}

    /**
     * TODO javadoc.
     *
     * @param renderRequest renderRequest
     * @param renderResponse renderResponse
     * @throws IOException hmm
     * @throws PortletException hmm
     */
    @Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        try {
            ACESearchPortalInterface searchEngine = new ACESearchPortalInterface();
            searchEngine.handleSearchRequest(renderRequest);
            include(viewJSP, renderRequest, renderResponse);
        }
        catch (Exception x)  {
            x.printStackTrace();
            throw new PortletException(x.getMessage());
        }
	}

    /**
     * TODO javadoc.
     *
     * @param actionRequest actionRequest
     * @param actionResponse actionResponse
     * @throws IOException hmm
     * @throws PortletException hmm
     */
    @Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
	}

    /**
     * TODO javadoc.
     *
     * @param path path
     * @param renderRequest renderRequest
     * @param renderResponse renderResponse
     * @throws IOException hmm
     * @throws PortletException hmm
     */
	protected void include(String path, RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		PortletRequestDispatcher portletRequestDispatcher = getPortletContext().getRequestDispatcher(path);
		if (portletRequestDispatcher == null) {
			_log.error(path + " is not a valid include");
		}
		else {
			portletRequestDispatcher.include(renderRequest, renderResponse);
		}
	}

	protected String editJSP;
	protected String helpJSP;
	protected String viewJSP;

	private static Log _log = LogFactory.getLog(nl.wur.alterra.cgi.ace.portlet.AdaptationToolJSPPortlet.class);

}