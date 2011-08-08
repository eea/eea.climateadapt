package nl.wur.alterra.cgi.ace.portlet;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import nl.wur.alterra.cgi.ace.search.ACESearchPortalInterface;
import nl.wur.alterra.cgi.ace.search.lucene.ACELuceneException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.IOException;

/**
 * Search interface for AceItems.
 *
 * @author jose garcía
 * @author heikki doeleman
 */
public class AceSearchPortlet extends MVCPortlet {

    /**
     * Searches AceItem Lucene index.
     *
     * @param request request
     * @param response response
     * @throws Exception hmm
     */
    public void searchAceitem(ActionRequest request, ActionResponse response) throws Exception {
        try {
            PortletUtils.logParams(request);
            ACESearchPortalInterface searchEngine = new ACESearchPortalInterface();
            searchEngine.handleSearchRequest(request);
            PortalUtil.copyRequestParameters(request, response);
            SessionMessages.add(request, "acesearch-execution-success");
        }
        catch(Exception x) {
            SessionErrors.add(request, "acesearch-execution-failure");
            x.printStackTrace();
            throw x;
        }
    }

	/**
	 * Executes 'sorting' search requests issued by Ajax calls from search results.
	 *
	 * @param request request
	 * @param response response
	 * @throws PortletException hmm
	 * @throws IOException hmm
	 */
	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response) throws PortletException, IOException {
        try {
            ACESearchPortalInterface searchEngine = new ACESearchPortalInterface();
            searchEngine.handleAjaxSearchRequest(request, response);
        }
        catch (ACELuceneException x) {
            x.printStackTrace();
            throw new PortletException(x);
        }
    }

}