package nl.wur.alterra.cgi.ace.portlet;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.util.bridges.mvc.MVCPortlet;
import nl.wur.alterra.cgi.ace.model.AceItem;
import nl.wur.alterra.cgi.ace.search.ACESearchEngine;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

/**
 *
 * Search AceItems.
 */
public class AceSearchPortlet extends MVCPortlet {

    private static final String ALL = "all_words";
    private static final String ANY = "any_words";
    private static final String EXACT = "exact_words";
    private static final String WITHOUT = "excluded_words";
    private static final String INITIAL_DATE = "initial_date";
    private static final String FINAL_DATE = "final_date";
    private static final String ACEITEM_TYPE = "aceitemtype";

    private static final String SEARCH_RESULTS = "searchResults";

    /**
     * Searches AceItem Lucene index.
     *
     * @param request request
     * @param response response
     * @throws Exception hmm
     */
    public void searchAceitem(ActionRequest request, ActionResponse response) throws Exception {
        try {



            Map<String, String[]> requestParams = request.getParameterMap();
            Enumeration<String> parameterNames = request.getParameterNames();
            while(parameterNames.hasMoreElements()) {
                String name = parameterNames.nextElement();
                String[] values = requestParams.get(name);
                System.out.println("* param: " + name);
                for(int i = 0; i < values.length; i++) {
                    System.out.println(values[i]);
                }
            }

            String[] allOfThese = requestParams.get(ALL);
            String[] anyOfThese = requestParams.get(ANY);
            String[] exactlyThese = requestParams.get(EXACT);
            String[] excludingThese = requestParams.get(WITHOUT);

            String[] aceItemTypes = requestParams.get(ACEITEM_TYPE);

            ACESearchEngine aceSearchEngine = new ACESearchEngine();
            List<AceItem> results = aceSearchEngine.search(allOfThese, anyOfThese, exactlyThese, excludingThese, aceItemTypes);

            System.out.println("searchAceitem found #" + results.size() + " results");

            request.setAttribute(SEARCH_RESULTS, results);
            request.setAttribute(ACEITEM_TYPE, aceItemTypes);

            SessionMessages.add(request, "acesearch-execution-success");
        }
        catch(Exception x) {
            SessionErrors.add(request, "acesearch-execution-failure");
            throw x;
        }
    }


}
