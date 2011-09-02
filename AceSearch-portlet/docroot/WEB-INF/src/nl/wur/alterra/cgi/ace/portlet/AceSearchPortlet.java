package nl.wur.alterra.cgi.ace.portlet;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import nl.wur.alterra.cgi.ace.search.ACESearchPortalInterface;
import nl.wur.alterra.cgi.ace.search.AceSearchFormBean;
import nl.wur.alterra.cgi.ace.search.SearchRequestParams;
import nl.wur.alterra.cgi.ace.search.lucene.ACELuceneException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.Map;

import com.liferay.portal.kernel.util.ParamUtil;

/**
 * Search interface for AceItems.
 *
 * @author jose garcía
 * @author heikki doeleman
 */
public class AceSearchPortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		try {
	    	HttpServletRequest httpRequest = 
	    		PortalUtil.getOriginalServletRequest(
	    		PortalUtil.getHttpServletRequest(renderRequest) ) ;
	    	
	    		String searchtext = httpRequest.getParameter("searchtext") ;
	    		
	    		if(searchtext != null && searchtext.trim().length() > 0) {
	
		        	ACESearchPortalInterface searchEngine = new ACESearchPortalInterface();		    			
	    			AceSearchFormBean formBean = searchEngine.prepareACESearchFormBean(renderRequest);
	    			formBean.setAnyOfThese( searchtext );
	    			renderRequest.setAttribute(SearchRequestParams.SEARCH_PARAMS, formBean);
	    			
	    			searchEngine.handleSearchRequest(renderRequest, formBean);
	    		}
	    		else {

	    			renderRequest.setAttribute(SearchRequestParams.SEARCH_PARAMS, null);
	    		}
		}
        catch (ACELuceneException x) {
			x.printStackTrace();
            throw new PortletException(x);
		}
		super.doView(renderRequest, renderResponse);
	}
	
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
    
    /**
     * Stores fuzziness preference
     *
     * @param request request
	 * @param response response
     */
    public void setAceSearchPref(ActionRequest request, ActionResponse response) throws Exception {
		PortletPreferences prefs = request.getPreferences();
		
		prefs.setValue(Constants.fuzzinessPreferenceName, ParamUtil.getString(request, Constants.fuzzinessPreferenceName) );
	
		prefs.store();	
	}
}