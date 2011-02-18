package nl.wur.alterra.cgi.ace.search;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.HitsOpenSearchImpl;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import nl.wur.alterra.cgi.ace.search.lucene.ACEAnalyzer;
import nl.wur.alterra.cgi.ace.search.lucene.ACEIndexSearcher;
import nl.wur.alterra.cgi.ace.search.lucene.ACELuceneOpenSearchResult;
import nl.wur.alterra.cgi.ace.search.opensearch.BaseOpenSearchResult;
import nl.wur.alterra.cgi.ace.search.opensearch.BaseOpenSearchResultEntry;
import nl.wur.alterra.cgi.ace.search.opensearch.ConvertableToBaseOpenSearchResult;
import org.apache.lucene.document.Document;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 *
 * @author heikki doeleman
 */
public class ACESearchEngine extends HitsOpenSearchImpl {

    /**
     * Used for what ?! TODO check
     */
    public static final String SEARCH_PATH = "/c/projects/open_search";

    public static final String TITLE = "ACE Search ";


    /**
     * Searches a ACEItem index.
     *
     * @param request httpServletRequest
     * @param groupId group id
     * @param userId  user id
     * @param keywords keywords
     * @param startPage startPage
     * @param itemsPerPage items per page
     * @param format format
     * @return XML representation of search result
     * @throws com.liferay.portal.kernel.search.SearchException hmm
     */
    @Override
    public String search(HttpServletRequest request, long groupId, long userId, String keywords, int startPage, int itemsPerPage, String format) throws SearchException {

        System.out.println("## startpage: " + startPage);
        System.out.println("## itemsPerPage: " + itemsPerPage);
        System.out.println("## keywords: " + keywords);

        int start = (startPage * itemsPerPage) - itemsPerPage;

        int total = 4;

        String[] queryTerms = {};
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

        //
        // search Lucene index
        //
        try {
            ACEIndexSearcher searcher = ACEIndexSearcher.getACEIndexSearcher();
            QueryParser queryParser = new QueryParser("any", ACEAnalyzer.getAnalyzer());
            Query query = queryParser.parse(keywords);
            System.out.println("Lucene query: " + query.toString());
            //System.out.println("Lucene query (rewritten): " + query.rewrite(((IndexSearcher)searcher).getIndexReader()).toString());
            TopDocs topDocs = searcher.search(query, itemsPerPage);
            System.out.println("Lucene searcher # total hits: " + topDocs.totalHits);
            ScoreDoc[] hits = topDocs.scoreDocs;
            for (ScoreDoc hit : hits) {
                Document document = searcher.doc(hit.doc);
                System.out.printf("%5.3f %sn", hit.score, document.get("any"));
            }
        }
        catch(ParseException x) {
            System.out.println(x.getMessage());
            x.printStackTrace();
        }

        String luceneResponse = null;

        ConvertableToBaseOpenSearchResult convertableToBaseOpenSearchResult = new ACELuceneOpenSearchResult();
        BaseOpenSearchResult baseOpenSearchResult = convertableToBaseOpenSearchResult.convert(luceneResponse);

        Object[] values = addSearchResults(queryTerms, keywords, startPage, itemsPerPage, total, start, getTitle(keywords), getSearchPath(), format, themeDisplay);

        // Document: it's not Lucene or DOM or JDOM here
        com.liferay.portal.kernel.xml.Document doc = (com.liferay.portal.kernel.xml.Document) values[0];
        com.liferay.portal.kernel.xml.Element root = (com.liferay.portal.kernel.xml.Element) values[1];

        List<BaseOpenSearchResultEntry> searchResults = baseOpenSearchResult.getEntries();

        for (BaseOpenSearchResultEntry entry : searchResults) {
            Date modifedDate = entry.getModifedDate();
            long resultGroupId = entry.getResultGroupId();
            String title = entry.getTitle();
            String url = entry.getUrl();
            String content = entry.getContent();
            String[] tags = entry.getTags();
            double ratings = entry.getRatings();
            String entryClassName = entry.getEntryClassName();
            long entryClassPK = entry.getEntryClassPK();
            double score = entry.getScore();
            addSearchResult(root, resultGroupId, entryClassName, entryClassPK, title, url, modifedDate, content, tags, ratings, score, format);
        }

        String result = doc.asXML();
        if (log.isDebugEnabled()) {
            log.debug("ACE search engine returns\n" + result);
        }

        return result;


    }

    @Override
    public String getPortletId() {
        return "666";
    }

    @Override
    public String getSearchPath() {
        return SEARCH_PATH;
    }

    @Override
    public String getTitle(String s) {
        return TITLE + s;
    }

    private static Log log = LogFactoryUtil.getLog(ACESearchEngine.class);

}