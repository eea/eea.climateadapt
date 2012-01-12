package nl.wur.alterra.cgi.ace.search;

import com.google.gson.Gson;
import nl.wur.alterra.cgi.ace.model.AceItem;
import nl.wur.alterra.cgi.ace.model.constants.AceItemType;
import nl.wur.alterra.cgi.ace.search.lucene.ACELuceneException;

import javax.portlet.ClientDataRequest;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Provides access to search engine methods, for portlets. This class is the only class in the SearchEngine library that
 * has dependencies on javax.portlet.* classes.
 *
 * @author heikki doeleman
 *
 */
public class ACESearchPortalInterface {

    private boolean isEmpty(String[] array) {
        return array == null || array.length == 0;
    }
    /**
     *
     * @param request request
     * @return keys to lists of results grouped by aceitemtype
     * @throws ACELuceneException hmm
     */
    public List<String> handleSearchRequest(PortletRequest request, AceSearchFormBean formBean) throws Exception {

		List<String> keysAdded = new ArrayList<String>();
		List<String> jsonKeysAdded = new ArrayList<String>();
        long totalResults = 0;

        ACESearchEngine searchEngine = new ACESearchEngine();


		// no aceItemTypes requested or "All" choosen: search for all of them
		if ( isEmpty(formBean.getAceitemtype()) || 
			 (formBean.getDatainfo_type().equals("1") && formBean.getSortBy()==null) ) {
			for (AceItemType aceItemType : AceItemType.values()) {
	            
				List<AceItemSearchResult> results = searchEngine.searchLuceneByType(formBean, aceItemType.name());
				totalResults += results.size();

				//System.out.println("From all searchAceitem found #" + results.size() + " results of type " + aceItemType.name());
				request.setAttribute(aceItemType.name() + "_" + SearchRequestParams.SEARCH_RESULTS, results);

                 keysAdded.add(aceItemType.name() + "_" + SearchRequestParams.SEARCH_RESULTS);
                 Gson gson = new Gson();
                 String json = gson.toJson(results);

                 request.setAttribute(aceItemType.name() + "_" + "JSON" + SearchRequestParams.SEARCH_RESULTS, json);
                 jsonKeysAdded.add(aceItemType.name() + "_" + "JSON" + SearchRequestParams.SEARCH_RESULTS);
			}
		}
		// search only requested aceItemTypes
		else {
			for (String aceItemType : formBean.getAceitemtype()) {
	            
				List<AceItemSearchResult> results = searchEngine.searchLuceneByType(formBean, aceItemType);
                
				totalResults += results.size();

				//System.out.println("Limited set seacrhAceitem found #" + results.size() + " results of type " + aceItemType);
				request.setAttribute(aceItemType + "_" + SearchRequestParams.SEARCH_RESULTS, results);
				keysAdded.add(aceItemType + "_" + SearchRequestParams.SEARCH_RESULTS);
				Gson gson = new Gson();
				String json = gson.toJson(results);

				request.setAttribute(aceItemType + "_" + "JSON" + SearchRequestParams.SEARCH_RESULTS, json);
				jsonKeysAdded.add(aceItemType + "_" + "JSON" + SearchRequestParams.SEARCH_RESULTS);
			}
		}

		request.setAttribute(SearchRequestParams.TOTAL_RESULTS, totalResults);

		return keysAdded;
    }
    
    public List<String> handleSearchRequest(PortletRequest request) throws Exception {

    	AceSearchFormBean formBean = prepareACESearchFormBean(request);
    	request.setAttribute(SearchRequestParams.SEARCH_PARAMS, formBean);    	
    	return handleSearchRequest(request, formBean) ;
    }

    /**
     * Executes 'sorting' search requests issued by Ajax calls from search results.
     *
     * @param request request
     * @param response response
     * @throws nl.wur.alterra.cgi.ace.search.lucene.ACELuceneException hmm
     */
    public void handleAjaxSearchRequest(ResourceRequest request, ResourceResponse response) throws Exception {
        // System.out.println("handleAjaxSearchRequest start");
        //PortletUtils.logParams(request);
        List<String> resultKeys = handleSearchRequest(request);
        List<AceItemSearchResult> results = (List<AceItemSearchResult>) request.getAttribute(resultKeys.get(0));

        Gson gson = new Gson();
        String json = gson.toJson(results);
        response.setContentType("text/html");
        // the page that was calling...
        String resourceID = request.getResourceID();
        // System.out.println("resourceId was : " + resourceID);
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
        }
        catch (IOException x) {
            x.printStackTrace();
            throw new ACELuceneException(x);
        }
        writer.print(json);
    }

    /**
     * Prepares ACESearchFormBean from search parameter values in the request.
     *
     * @param request
     * @return formbean
     */
    public AceSearchFormBean prepareACESearchFormBean(PortletRequest request) {
        Map<String, String[]> requestParams;
		String fuzziness = null;

        //
        // TODO: do this by checking actual pagename rather than request type ?
        //

        // request from search portlet
        if(request instanceof ClientDataRequest) {
            requestParams = request.getParameterMap();

			// Retrieve fuzziness from preferences
            PortletPreferences preferences = request.getPreferences();
            
			fuzziness = preferences.getValue(SearchRequestParams.FUZZINESS, "");            
        }
        // request from adaptationtooljsp portlet or filteraceitemportlet
        else { //if(request instanceof RenderRequest) {
            PortletPreferences preferences = request.getPreferences();
            requestParams = preferences.getMap();

			fuzziness = preferences.getValue(SearchRequestParams.FUZZINESS, "");

        }
        ACESearchEngine searchEngine = new ACESearchEngine();
        return searchEngine.prepareACESearchFormBean(requestParams, fuzziness);
    }
}
