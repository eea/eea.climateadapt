package nl.wur.alterra.cgi.ace.search;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Ignore;

/**
 * Test the search engine.
 * This class extends the ACESearchEngine so we can potentially override protected
 * methods. This could help work around external dependencies.
 */
public class ACESearchEngineTest extends ACESearchEngine {

    @Test
    public void simpleInit() {
        //ACESearchEngine se = new ACESearchEngine();

        Map<String, String[]> searchParams = new HashMap<String, String[]>();

        String[] datainfo_type = new String[1];

        datainfo_type[0] = "2";
        searchParams.put(SearchRequestParams.DATAINFO_TYPE, datainfo_type);

        String fuzziness = "";  // Same as default fuzziness.
        AceSearchFormBean formBean = prepareACESearchFormBean(searchParams, fuzziness);

        Assert.assertEquals("", formBean.getFuzziness());
    }

    /**
     * searchLuceneByType is untestable because it creates a Lucene search engine
     * via a static method in line 418. We could move that call to an overridable
     * method, but that won't help much. The searchLuceneByType need to be split
     * up into several methods that can be tested individually. The ACESearchEngine
     * is riddled with System.out.println, which indicates the original author
     * didn't design with unit testing in mind.
     */
    @Ignore("Make method testable first")
    @Test
    public void simpleSearch() throws Exception {
        //ACESearchEngine se = new ACESearchEngine();
        AceSearchFormBean formBean = createFormbean(this);

        String aceItemType = "measure"; // TODO, set this to something sane
        List<AceItemSearchResult> searchResult = searchLuceneByType(formBean, aceItemType);
        Assert.assertTrue(true);
    }

    private AceSearchFormBean createFormbean(ACESearchEngine se) {
        Map<String, String[]> searchParams = new HashMap<String, String[]>();
        String[] datainfo_type = new String[1];

        datainfo_type[0] = "2";
        searchParams.put(SearchRequestParams.DATAINFO_TYPE, datainfo_type);

        String fuzziness = "";  // Same as default fuzziness.
        return se.prepareACESearchFormBean(searchParams, fuzziness);
    }

}
