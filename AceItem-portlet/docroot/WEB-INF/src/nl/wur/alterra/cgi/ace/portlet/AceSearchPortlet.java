package nl.wur.alterra.cgi.ace.portlet;

import com.google.gson.Gson;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import nl.wur.alterra.cgi.ace.model.AceItem;
import nl.wur.alterra.cgi.ace.model.impl.AceItemType;
import nl.wur.alterra.cgi.ace.search.ACESearchEngine;
import nl.wur.alterra.cgi.ace.search.lucene.ACEIndexSearcher;
import nl.wur.alterra.cgi.ace.search.lucene.ACEIndexSynchronizer;
import nl.wur.alterra.cgi.ace.search.lucene.ACEIndexWriter;
import nl.wur.alterra.cgi.ace.search.lucene.ACELuceneException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ClientDataRequest;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

/**
 * Search interface for AceItems.
 *
 * @author jose garcía
 * @author heikki doeleman
 */
public class AceSearchPortlet extends MVCPortlet {

    private static final String ANY = "anyOfThese";
    private static final String INITIAL_DATE = "initial_date";
    private static final String FINAL_DATE = "final_date";
    private static final String SIMPLE_DATE = "simple_date";
    private static final String ACEITEM_TYPE = "aceitemtype";
    private static final String SORTBY = "sortBy";
    private static final String SECTOR = "sector";
    private static final String COUNTRIES = "countries";
    private static final String ELEMENT = "element";

    private static final String SEARCH_PARAMS = "searchParams";
    private static final String SEARCH_RESULTS = "searchResults";

     private static final String TOTAL_RESULTS = "total_results";

    /**
     * Called by the portlet container to indicate to a portlet that the portlet is being placed into service.
     *
     * Rebuilds the Lucene index.
     *
     * @throws PortletException hmm
     */
    public void init() throws PortletException {
        super.init();
        ACEIndexSynchronizer aceIndexSynchronizer = new ACEIndexSynchronizer();
        aceIndexSynchronizer.synchronize();
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
            logParams(request);
            searchByType(request);
            PortalUtil.copyRequestParameters(request, response);
            SessionMessages.add(request, "acesearch-execution-success");
        }
        catch(Exception x) {
            SessionErrors.add(request, "acesearch-execution-failure");
            x.printStackTrace();
            throw x;
        }
    }

    private List<String> searchByType(ClientDataRequest request) throws ACELuceneException {
        Map<String, String[]> requestParams = request.getParameterMap();

        if(requestParams == null || requestParams.get(ANY) == null) {
            System.out.println("Search cannot be executed, it seems your portlet container failed to send the search form in this request.");
            return null;
        }

        String[] anyOfThese = requestParams.get(ANY);
        String[] aceItemTypes = requestParams.get(ACEITEM_TYPE);
        String[] sectors = requestParams.get(SECTOR);
        String[] countries = requestParams.get(COUNTRIES);
        String[] elements = requestParams.get(ELEMENT);
        String[] sortBys = requestParams.get(SORTBY);
        String sortBy = null;
        if(sortBys != null && sortBys.length > 0) {
            sortBy = sortBys[0];
        }

        AceSearchFormBean formBean = new AceSearchFormBean();
        formBean.setAnyOfThese(anyOfThese[0]);
        formBean.setAceitemtype(aceItemTypes);
        formBean.setSector(sectors);
        formBean.setElement(elements);
        formBean.setCountries(countries);
        formBean.setSortBy(sortBy);

        request.setAttribute(SEARCH_PARAMS, formBean);


        ACESearchEngine aceSearchEngine = new ACESearchEngine();

        List<String> keysAdded = new ArrayList<String>();
        List<String> jsonKeysAdded = new ArrayList<String>();

        long totalResults = 0;

        // no aceItemTypes requested: search for all of them
        if(aceItemTypes == null || aceItemTypes.length == 0) {
             for(AceItemType aceItemType : AceItemType.values()) {
                 List<AceItem> results = aceSearchEngine.searchLuceneByType(formBean, aceItemType.name());
                 totalResults += results.size();

                 System.out.println("searchAceitem found #" + results.size() + " results of type " + aceItemType.name());
                 request.setAttribute(aceItemType.name() + "_" + SEARCH_RESULTS, results);

                 for(AceItem result : results) {
                     result.setDescription(result.getDescription().replaceAll("'", "\'"));
                     result.setKeyword(result.getKeyword().replaceAll("'", "\'"));
                     result.setName(result.getName().replaceAll("'", "\'"));
                     result.setSpatialValues(result.getSpatialValues().replaceAll("'", "\'"));
                     result.setSpatialLayer(result.getSpatialLayer().replaceAll("'", "\'"));
                     result.setElements_(result.getElements_().replaceAll("'", "\'"));
                     result.setSectors_(result.getSectors_().replaceAll("'", "\'"));
                     result.setStoredAt(result.getStoredAt().replaceAll("'", "\'"));
                     result.setTextSearch(result.getTextSearch().replaceAll("'", "\'"));
                     result.setDatatype(result.getDatatype().replaceAll("'", "\'"));

                     result.setDescription(result.getDescription().replaceAll("\"", "\"\""));
                     result.setKeyword(result.getKeyword().replaceAll("\"", "\"\""));
                     result.setName(result.getName().replaceAll("\"", "\"\""));
                     result.setSpatialValues(result.getSpatialValues().replaceAll("\"", "\"\""));
                     result.setSpatialLayer(result.getSpatialLayer().replaceAll("\"", "\"\""));
                     result.setElements_(result.getElements_().replaceAll("\"", "\"\""));
                     result.setSectors_(result.getSectors_().replaceAll("\"", "\"\""));
                     result.setStoredAt(result.getStoredAt().replaceAll("\"", "\"\""));
                     result.setTextSearch(result.getTextSearch().replaceAll("\"", "\"\""));
                     result.setDatatype(result.getDatatype().replaceAll("\"", "\"\""));
                 }

                 keysAdded.add(aceItemType.name() + "_" + SEARCH_RESULTS);
                 Gson gson = new Gson();
                 String json = gson.toJson(results);

                 // escape double quotes


                 System.out.println("\n\njson LIST is: " + json);
                 request.setAttribute(aceItemType.name() + "_" + "JSON" + SEARCH_RESULTS, json);
                 jsonKeysAdded.add(aceItemType.name() + "_" + "JSON" + SEARCH_RESULTS);
             }
        }
        // search only requested aceItemTypes
        else {
            for(String aceItemType : aceItemTypes) {
                List<AceItem> results = aceSearchEngine.searchLuceneByType(formBean, aceItemType);
                totalResults += results.size();

                System.out.println("searchAceitem found #" + results.size() + " results of type " + aceItemType);
                request.setAttribute(aceItemType + "_" + SEARCH_RESULTS, results);
                keysAdded.add(aceItemType + "_" + SEARCH_RESULTS);
                Gson gson = new Gson();
                String json = gson.toJson(results);
                System.out.println("\n\njson LIST is: " + json);
                request.setAttribute(aceItemType + "_" + "JSON" + SEARCH_RESULTS, json);
                jsonKeysAdded.add(aceItemType + "_" + "JSON" + SEARCH_RESULTS);
            }
        }

        request.setAttribute(TOTAL_RESULTS, totalResults);

        return keysAdded;
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
            System.out.println("In serveResource code");
            logParams(request);
            List<String> resultKeys = searchByType(request);
            List<AceItem> results = (List<AceItem>)request.getAttribute(resultKeys.get(0));
            Gson gson = new Gson();
            String json = gson.toJson(results);
            System.out.println("\n\njson LIST is: " + json);
            response.setContentType("text/html");
            // the page that was calling...
            String resourceID = request.getResourceID();
            System.out.println("resourceId was : " + resourceID);
            PrintWriter writer = response.getWriter();
            writer.print(json);
        }
        catch(ACELuceneException x) {
            throw new PortletException(x.getMessage(), x);
        }
	}

    /**
     * For debugging, logs request params.
     *
     * @param request request
     */
    private void logParams(ClientDataRequest request) {
        Map<String, String[]> requestParams = request.getParameterMap();
        Enumeration<String> parameterNames = request.getParameterNames();
        while(parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            String[] values = requestParams.get(name);
            System.out.println("* param: " + name);
            for(String value : values) {
                System.out.println("'" + value + "'");
            }
        }
    }

    @Override
    public void destroy() {
        try {
            System.out.println("destroying AceSearchPortlet");
            ACEIndexWriter.getACEIndexWriter().close();
            ACEIndexSearcher.getACEIndexSearcher().close();
        }
        catch (ACELuceneException x) {
            System.out.println(x.getMessage());
            x.printStackTrace();
        }
        super.destroy();
    }


}