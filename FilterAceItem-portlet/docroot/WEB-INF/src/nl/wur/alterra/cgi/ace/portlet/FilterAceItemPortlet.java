package nl.wur.alterra.cgi.ace.portlet;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import nl.wur.alterra.cgi.ace.search.ACESearchPortalInterface;
import nl.wur.alterra.cgi.ace.search.AceSearchFormBean;
import nl.wur.alterra.cgi.ace.search.SearchRequestParams;
import nl.wur.alterra.cgi.ace.search.lucene.ACELuceneException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Portlet implementation class FilterAceItemPortlet.
 */
public class FilterAceItemPortlet extends MVCPortlet {

	/*
	 *  param: datainfo_type '2' param: sector 'WATERMANAGEMENT' param: element
	 *  'OBSERVATIONS' param: anyOfThese 'Water' param: countries 'AT' param:
	 *  aceitemtype 'DOCUMENT' param: javax.portlet.action 'searchAceitem'
	 */

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		try {
            ACESearchPortalInterface searchEngine = new ACESearchPortalInterface();
			searchEngine.handleSearchRequest(renderRequest);
		}
        catch (ACELuceneException x) {
			x.printStackTrace();
            throw new PortletException(x);
		}
		super.doView(renderRequest, renderResponse);
	}

	public void setFilterAceItemPref(ActionRequest request, ActionResponse response) throws Exception {
        Map<String, String[]> requestParams = request.getParameterMap();

        if(requestParams == null || requestParams.get(SearchRequestParams.ANY) == null) {
            System.out.println("Search cannot be executed, it seems your portlet container failed to send the search form in this request.");
        }
        
        String[] anyOfThese = requestParams.get(SearchRequestParams.ANY);
        String[] aceItemTypes = requestParams.get(SearchRequestParams.ACEITEM_TYPE);
        String[] sectors = requestParams.get(SearchRequestParams.SECTOR);
        String[] countries = requestParams.get(SearchRequestParams.COUNTRIES);
        String[] elements = requestParams.get(SearchRequestParams.ELEMENT);
        String[] impacts = requestParams.get(SearchRequestParams.IMPACT);
        String[] sortBys = requestParams.get(SearchRequestParams.SORTBY);
        
		PortletPreferences prefs = request.getPreferences();
		
		prefs.setValue(Constants.PAGING, ParamUtil.getString(request, Constants.PAGING) );
		prefs.setValue(Constants.NRITEMSPAGE, ParamUtil.getString(request, Constants.NRITEMSPAGE) );
		prefs.setValue(Constants.FUZZINESS, ParamUtil.getString(request, Constants.FUZZINESS) );

		prefs.store();
		prefs.setValues(SearchRequestParams.ANY, anyOfThese);
		prefs.setValues(SearchRequestParams.ACEITEM_TYPE, aceItemTypes);
		prefs.setValues(SearchRequestParams.SECTOR, sectors);
		prefs.setValues(SearchRequestParams.COUNTRIES, countries);
        prefs.setValues(SearchRequestParams.ELEMENT, elements);
        prefs.setValues(SearchRequestParams.IMPACT, impacts);
		prefs.setValues(SearchRequestParams.SORTBY, sortBys);
		
		prefs.store();
	}

	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        ACESearchPortalInterface searchEngine = new ACESearchPortalInterface();
		AceSearchFormBean formBean = searchEngine.prepareACESearchFormBean(renderRequest);
		renderRequest.setAttribute(SearchRequestParams.SEARCH_PARAMS, formBean);
		super.doEdit(renderRequest, renderResponse);
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