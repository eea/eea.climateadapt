package nl.wur.alterra.cgi.ace.search;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.HitsOpenSearchImpl;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import nl.wur.alterra.cgi.ace.model.AceItem;
import nl.wur.alterra.cgi.ace.model.impl.AceItemImpl;
import nl.wur.alterra.cgi.ace.portlet.AceSearchFormBean;
import nl.wur.alterra.cgi.ace.search.lucene.ACEAnalyzer;
import nl.wur.alterra.cgi.ace.search.lucene.ACEIndexConstant;
import nl.wur.alterra.cgi.ace.search.lucene.ACEIndexSearcher;
import nl.wur.alterra.cgi.ace.search.lucene.ACELuceneException;
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
import java.util.ArrayList;
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
     * Searches a ACEItem index. Note: this method is only in case we'd want to include AceItem search to the default
     * Liferay search portlet.
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
            TopDocs topDocs = searcher.search(query, null, itemsPerPage);
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

    /**
     * Searches Lucene, restricted to specified search parameters.
     *
     * @param aceItemType
     * @return results
     * @throws ACELuceneException hmm
     */

    public List<AceItem> searchLuceneByType(AceSearchFormBean formBean, String aceItemType) throws ACELuceneException {
    //public List<AceItem> searchLuceneByType(String[] anyOfThese, String aceItemType, String[] sectors, String[] elements, String sortBy) throws ACELuceneException {
        try {
            //
            // handle free text input
            //

            //String rawQuery = createRawQuery(allOfThese, anyOfThese, exactlyThese, excludingThese);
            String rawQuery = "";
            if(formBean.getAnyOfThese() != null) {
                rawQuery = rawQuery + " " + formBean.getAnyOfThese();
            }

            // user entered no searchterms; do wildcard query
            else {
                // TODO create a better, real wildcard-only query
                rawQuery = "a*|e*|i*|o*|u*";
            }
            rawQuery = rawQuery.trim();

            //
            // handle aceItemType
            //
            if(rawQuery.length() > 0) {
                rawQuery += " AND " + ACEIndexConstant.IndexField.DATATYPE + ":" + aceItemType;
            }
            else {
                rawQuery = ACEIndexConstant.IndexField.DATATYPE + ":" + aceItemType;
            }

            //
            // handle sectors
            //
            String[] sectors = formBean.getSector();
            if ((formBean.getSector() != null) && (sectors.length > 0)) {
                rawQuery += " AND (";
                for(String sector: sectors) {
                    rawQuery += " (" + ACEIndexConstant.IndexField.SECTOR + ":" + sector + ") OR";
                }
                rawQuery =  rawQuery.substring(0, rawQuery.lastIndexOf("OR")) + " )";
            }

            //
            // handle elements
            //
            String[] elements = formBean.getElement();
            if ((elements != null) && (elements.length > 0)) {
                rawQuery += " AND (";
                for(String element: elements) {
                    rawQuery += " (" + ACEIndexConstant.IndexField.ELEMENT + ":" + element + ") OR";
                }
                rawQuery =  rawQuery.substring(0, rawQuery.lastIndexOf("OR")) + " )";
            }

            //
            // handle countries
            //
            String[] countries = formBean.getCountries();
            if ((countries != null) && (countries.length > 0)) {
                rawQuery += " AND (";
                for(String country: countries) {
                    rawQuery += " (" + ACEIndexConstant.IndexField.SPATIAL_VALUE + ":" + country + " AND " + ACEIndexConstant.IndexField.SPATIAL_LAYER + ":NUTS0) OR";
                }
                rawQuery =  rawQuery.substring(0, rawQuery.lastIndexOf("OR")) + " )";
            }

            ACEIndexSearcher searcher = ACEIndexSearcher.getACEIndexSearcher();
            QueryParser queryParser = new QueryParser(ACEIndexConstant.IndexField.ANY, ACEAnalyzer.getAnalyzer());
            Query query = queryParser.parse(rawQuery);
            System.out.println("Lucene raw query: " + rawQuery);
            System.out.println("Lucene query: " + query.toString());
            //System.out.println("Lucene query (rewritten): " + query.rewrite(((IndexSearcher)searcher).getIndexReader()).toString());
            long start = System.currentTimeMillis();
            TopDocs topDocs = searcher.search(query, formBean.getSortBy(), 10);
            long end = System.currentTimeMillis();
            System.out.println("Lucene searcher # total hits: " + topDocs.totalHits + " in " + (end - start) + " ms");
            ScoreDoc[] hits = topDocs.scoreDocs;
            List<AceItem> results = new ArrayList<AceItem>();
            for (ScoreDoc hit : hits) {
                Document document = searcher.doc(hit.doc);
                AceItem aceItem = new AceItemImpl();
                String aceItemId = document.get(ACEIndexConstant.IndexField.ACEITEM_ID);
                if(aceItemId != null) {
                    aceItem.setAceItemId(Long.parseLong(aceItemId));
                }
                String companyId = document.get(ACEIndexConstant.IndexField.COMPANY_ID);
                if(companyId != null) {
                    aceItem.setCompanyId(Long.parseLong(companyId));
                }
                aceItem.setDescription(document.get(ACEIndexConstant.IndexField.DESCRIPTION));
                String endDate = document.get(ACEIndexConstant.IndexField.END_DATE);
                if(endDate != null) {
                    aceItem.setEndDate(new Date(Long.parseLong(endDate)));
                }
                String groupId = document.get(ACEIndexConstant.IndexField.GROUP_ID);
                if(groupId != null) {
                    aceItem.setGroupId(Long.parseLong(groupId));
                }
                aceItem.setKeyword(document.get(ACEIndexConstant.IndexField.KEYWORD));
                aceItem.setName(document.get(ACEIndexConstant.IndexField.NAME));
                aceItem.setSpatialValues(document.get(ACEIndexConstant.IndexField.SPATIAL_VALUE));
                aceItem.setSpatialLayer(document.get(ACEIndexConstant.IndexField.SPATIAL_LAYER));
                aceItem.setElements_(document.get(ACEIndexConstant.IndexField.ELEMENT));
                aceItem.setSectors_(document.get(ACEIndexConstant.IndexField.SECTOR));
                String startDate = document.get(ACEIndexConstant.IndexField.START_DATE);
                if(startDate != null) {
                    aceItem.setStartDate(new Date(Long.parseLong(startDate)));
                }
                aceItem.setStoredAt(document.get(ACEIndexConstant.IndexField.STOREDAT));
                aceItem.setStoragetype(document.get(ACEIndexConstant.IndexField.STORAGETYPE)) ;
                aceItem.setTextSearch(document.get(ACEIndexConstant.IndexField.ANY));
                aceItem.setDatatype(document.get(ACEIndexConstant.IndexField.DATATYPE));

                System.out.println(document.get(ACEIndexConstant.IndexField.NAME));
                results.add(aceItem);
            }
            return results;
        }
        catch(ParseException x) {
            System.out.println(x.getMessage());
            x.printStackTrace();
            throw new ACELuceneException(x.getMessage(), x);
        }
    }

    /**
     * Creates a raw lucene text query for input to Lucene's QueryBuilder. This is only necessary if we keep different
     * free text search fields for the various advanced search types; if not, user query can go straight into QueryBuilder.
     *
     * @param allOfThese
     * @param anyOfThese
     * @param exactlyThese
     * @param excludingThese
     * @return
     */
    private String createRawQuery(String[] allOfThese, String[] anyOfThese, String[] exactlyThese, String[] excludingThese) {
        String any = "";
        if(anyOfThese != null && anyOfThese.length > 0) {
            for(String anyTerm : anyOfThese) {
                if(anyTerm.trim().length() > 0) {
                    any += anyTerm + " ";
                }
            }
        }
        String all = "";
        if(allOfThese != null && allOfThese.length > 0) {
            for(String allTerm : allOfThese) {
                if(allTerm.trim().length() > 0) {
                    all += "+" + allTerm + " ";
                }
            }
        }
        String exact = "";
        if(exactlyThese != null && exactlyThese.length > 0) {
            for(String exactTerm : exactlyThese) {
                if(exactTerm.trim().length() > 0) {
                    exact += exactTerm + " ";
                }

            }
            exact = "\"" + exact.trim() + "\"";
        }
        String without = "";
        if(excludingThese != null && excludingThese.length > 0) {
            for(String withoutTerm : excludingThese) {
                if(withoutTerm.trim().length() > 0) {
                    without += "-" + withoutTerm + " ";
                }
            }
        }

        String rawQuery = any + " " + all + " " + exact + " " + without;
        System.out.println("raw query: " + rawQuery);
        return rawQuery;
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