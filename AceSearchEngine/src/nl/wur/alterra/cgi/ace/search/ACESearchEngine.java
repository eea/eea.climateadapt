package nl.wur.alterra.cgi.ace.search;

import nl.wur.alterra.cgi.ace.model.AceItem;
import nl.wur.alterra.cgi.ace.search.lucene.ACEAnalyzer;
import nl.wur.alterra.cgi.ace.search.lucene.ACEIndexConstant;
import nl.wur.alterra.cgi.ace.search.lucene.ACEIndexSearcher;
import nl.wur.alterra.cgi.ace.search.lucene.ACELuceneException;
import nl.wur.alterra.cgi.ace.service.AceItemLocalServiceUtil;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.TermAttribute;
import org.apache.lucene.document.Document;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * Search engine for AceItems.
 *
 * @author heikki doeleman
 */
public class ACESearchEngine {

    private static final String defaultFuzziness = "";

    /**
     * Prepares ACESearchFormBean from values in a map, using defaults where necessary.
     *
     * @param searchParams
     * @return formbean
     */
    public AceSearchFormBean prepareACESearchFormBean(Map<String, String[]> searchParams, String fuzziness) {

        String[] aceItemTypes ;
        String[] anyOfThese ;
        String[] conditionAdaptationElement ;
        String[] conditionAdaptationSector ;
        String[] conditionScenario ;
        String[] conditionTimePeriod ;
        String[] conditionClimateImpact ;
        String[] countries ;
        String[] elements ;
        String[] freetextMode ;
        String[] impacts ;
        String[] sectors ;
        String[] scenarios ;
        String[] timeperiods ;
        String[] sortBys ;
        String[] datainfo_type;

        // is sortitemtype exist use that one !!
        aceItemTypes = searchParams.get(SearchRequestParams.SORTITEM_TYPE);

        if(aceItemTypes==null || aceItemTypes.length==0) {

            aceItemTypes = searchParams.get(SearchRequestParams.ACEITEM_TYPE);
        }

        datainfo_type = searchParams.get(SearchRequestParams.DATAINFO_TYPE);
        if(datainfo_type==null || datainfo_type.length==0) {

        	datainfo_type = new String[1];
        	datainfo_type[0] = "2";
        }
        anyOfThese = searchParams.get(SearchRequestParams.ANY);
        conditionAdaptationElement = searchParams.get(SearchRequestParams.CONDITION_ADAPTATION_ELEMENT);
        conditionAdaptationSector = searchParams.get(SearchRequestParams.CONDITION_ADAPTATION_SECTOR);
        conditionScenario = searchParams.get(SearchRequestParams.CONDITION_SCENARIO);
        conditionTimePeriod = searchParams.get(SearchRequestParams.CONDITION_TIME_PERIOD);
        conditionClimateImpact = searchParams.get(SearchRequestParams.CONDITION_CLIMATE_IMPACT);
        countries = searchParams.get(SearchRequestParams.COUNTRIES);
        elements = searchParams.get(SearchRequestParams.ELEMENT);
        freetextMode = searchParams.get(SearchRequestParams.FREETEXT_MODE);
        impacts = searchParams.get(SearchRequestParams.IMPACT);
        sectors = searchParams.get(SearchRequestParams.SECTOR);
        scenarios = searchParams.get(SearchRequestParams.SCENARIO);
        timeperiods = searchParams.get(SearchRequestParams.TIMEPERIOD);
        sortBys = searchParams.get(SearchRequestParams.SORTBY);

        if(isEmpty(conditionAdaptationSector)) {
            conditionAdaptationSector = new String[1];
            conditionAdaptationSector[0] = SearchRequestParams.AND_CONDITION;
        }
        if(isEmpty(conditionAdaptationElement)) {
            conditionAdaptationElement = new String[1];
            conditionAdaptationElement[0] = SearchRequestParams.AND_CONDITION;
        }
        if(isEmpty(conditionScenario)) {
        	conditionScenario = new String[1];
        	conditionScenario[0] = SearchRequestParams.AND_CONDITION;
        }
        if(isEmpty(conditionTimePeriod)) {
        	conditionTimePeriod = new String[1];
        	conditionTimePeriod[0] = SearchRequestParams.AND_CONDITION;
        }        
        if(isEmpty(conditionClimateImpact)) {
            conditionClimateImpact = new String[1];
            conditionClimateImpact[0] = SearchRequestParams.AND_CONDITION;
        }
        if(isEmpty(freetextMode)) {
            freetextMode = new String[1];
            freetextMode[0] = FreetextMode.ANY.name();
        }

        String sortBy = null;
        if(sortBys != null && sortBys.length > 0) {
            sortBy = sortBys[0];
        }

        String fuzzinessVal = defaultFuzziness;
        if(fuzziness != null) {
            fuzzinessVal = fuzziness;
        }

        AceSearchFormBean formBean = new AceSearchFormBean();

        formBean.setAceitemtype(aceItemTypes);
        formBean.setDatainfo_type(datainfo_type[0]);
        formBean.setCountries(countries);
        formBean.setElement(elements);
        formBean.setFreetextMode(freetextMode[0]);
        formBean.setImpact(impacts);
        formBean.setSector(sectors);
        formBean.setScenario(scenarios);
        formBean.setTimePeriod(timeperiods);
        formBean.setSortBy(sortBy);

        formBean.setFuzziness(fuzzinessVal);

		if(isEmpty(anyOfThese)) {
            formBean.setAnyOfThese("");
		}
        else {
            formBean.setAnyOfThese(anyOfThese[0]);
		}

        if (conditionAdaptationSector != null && conditionAdaptationSector[0].equalsIgnoreCase(SearchRequestParams.OR_CONDITION)) {
            formBean.setConditionAdaptationSector(SearchRequestParams.OR_CONDITION);
        }
        else {
            formBean.setConditionAdaptationSector(SearchRequestParams.AND_CONDITION);
        }

        if (conditionAdaptationElement != null && conditionAdaptationElement[0].equalsIgnoreCase(SearchRequestParams.OR_CONDITION)) {
            formBean.setConditionAdaptationElement(SearchRequestParams.OR_CONDITION);
        }
        else {
            formBean.setConditionAdaptationElement(SearchRequestParams.AND_CONDITION);
        }

        if (conditionScenario != null && conditionScenario[0].equalsIgnoreCase(SearchRequestParams.OR_CONDITION)) {
            formBean.setConditionScenario(SearchRequestParams.OR_CONDITION);
        }
        else {
            formBean.setConditionScenario(SearchRequestParams.AND_CONDITION);
        }

        if (conditionTimePeriod != null && conditionTimePeriod[0].equalsIgnoreCase(SearchRequestParams.OR_CONDITION)) {
            formBean.setConditionTimePeriod(SearchRequestParams.OR_CONDITION);
        }
        else {
            formBean.setConditionTimePeriod(SearchRequestParams.AND_CONDITION);
        }

        if (conditionClimateImpact != null && conditionClimateImpact[0].equalsIgnoreCase(SearchRequestParams.OR_CONDITION)) {
            formBean.setConditionClimateImpact(SearchRequestParams.OR_CONDITION);
        }
        else {
            formBean.setConditionClimateImpact(SearchRequestParams.AND_CONDITION);
        }

        return formBean;

    }

    private boolean isEmpty(String[] array) {
        return array == null || array.length == 0;
    }

    /**
     * Prepares free text query by adding fuzziness to each term in a whitespace-separated string, adding AND if the
     * user requested to search for all words, and wraps it up.
     *
     * @param keywords keywords in whitespace-separated string
     * @param fuzziness fuzziness factor
     * @param freetextMode any or all
     * @return prepared query for free text
     * @throws java.io.IOException hmm
     */
    private String prepareFreetext(String keywords, String fuzziness, FreetextMode freetextMode) throws IOException {
        if(freetextMode == null) {
            freetextMode = FreetextMode.ANY;
        }
        String result = "";
        TokenStream tokenStream = ACEAnalyzer.getAnalyzer().tokenStream(ACEIndexConstant.IndexField.ANY, new StringReader(keywords));
        TermAttribute termAttribute = (TermAttribute) tokenStream.getAttribute(TermAttribute.class);
        while (tokenStream.incrementToken()) {
            String searchterm = termAttribute.term();
            if(searchterm != null && searchterm.trim().length() > 0) {
                result += "(";
                switch (freetextMode) {
                    case ANY :
                        if((searchterm.trim().length() < 4) || (fuzziness.equals(""))){
                            result += searchterm.trim() + ") ";
                        }
                        else {
                            result += searchterm.trim() + "~" + fuzziness + ") ";
                        }
                        break;
                    case ALL :
                        if((searchterm.trim().length() < 4) || (fuzziness.equals(""))){
                            result += searchterm.trim() + ") AND ";
                        }
                        else {
                            result += searchterm.trim() + "~" + fuzziness + ") AND ";
                        }
                        break;
                    default:
                        if((searchterm.trim().length() < 4) || (fuzziness.equals(""))){
                            result += searchterm.trim() + ") ";
                        }
                        else {
                            result += searchterm.trim() + "~" + fuzziness + ") ";
                        }
                }
            }
        }
        // strip last " AND "
        if(result != null && result.length() > 0 && result.contains(" AND ")) {
            result = result.substring(0, result.lastIndexOf(" AND "));
        }
        // wrap query in brackets
        if(result != null && result.trim().length() > 0) {
            result = "(" + result + ")";
        }
        // // System.out.println("*** ACESearchEngine search: searchterms with fuzziness: " + result);
        return result;
    }

    /**
     * Searches Lucene, restricted to specified search parameters.
     *
     * @param formBean bean containing search parameters
     * @param aceItemType type of aceitem to search for
     * @return results results
     * @throws ACELuceneException hmm
     */
    public List<AceItemSearchResult> searchLuceneByType(AceSearchFormBean formBean, String aceItemType) throws Exception {
        try {
            //
            // handle free text input
            //

            //String rawQuery = createRawQuery(allOfThese, anyOfThese, exactlyThese, excludingThese);
            String rawQuery = "";
            if(formBean.getAnyOfThese() != null) {
                rawQuery = rawQuery + " " + formBean.getAnyOfThese();

                rawQuery = prepareFreetext(rawQuery, formBean.getFuzziness(), formBean.getFreeTextMode());
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

            rawQuery += " AND ( (" + ACEIndexConstant.IndexField.CONTROLSTATUS + ":1) OR ("
            + ACEIndexConstant.IndexField.CONTROLSTATUS + ":2) )";

            //
            // handle sectors
            //
            String[] sectors = formBean.getSector();
            if ((sectors != null) && (sectors.length > 0)) {
                rawQuery += " AND (";
                for(String sector: sectors) {
                    rawQuery += " (" + ACEIndexConstant.IndexField.SECTOR + ":" + sector + ") " + formBean.getConditionAdaptationSector();
                }
                rawQuery =  rawQuery.substring(0, rawQuery.lastIndexOf(formBean.getConditionAdaptationSector())) + " )";
            }

            //
            // handle elements
            //
            String[] elements = formBean.getElement();
            if ((elements != null) && (elements.length > 0)) {
                rawQuery += " AND (";
                for(String element: elements) {
                    rawQuery += " (" + ACEIndexConstant.IndexField.ELEMENT + ":" + element + ") " + formBean.getConditionAdaptationElement();
                }
                rawQuery =  rawQuery.substring(0, rawQuery.lastIndexOf(formBean.getConditionAdaptationElement())) + " )";
            }

            //
            // handle scenarios
            //
            String[] scenarios = formBean.getScenario();
            if ((scenarios != null) && (scenarios.length > 0)) {
                rawQuery += " AND (";
                for(String scenario: scenarios) {
                    rawQuery += " (" + ACEIndexConstant.IndexField.SCENARIO + ":" + scenario + ") " + formBean.getConditionScenario();
                }
                rawQuery =  rawQuery.substring(0, rawQuery.lastIndexOf(formBean.getConditionScenario())) + " )";
            }  

            //
            // handle time periods
            //
            String[] timeperiods = formBean.getTimePeriod();
            if ((timeperiods != null) && (timeperiods.length > 0)) {
                rawQuery += " AND (";
                for(String timeperiod: timeperiods) {
                    rawQuery += " (" + ACEIndexConstant.IndexField.TIMEPERIOD + ":" + timeperiod + ") " + formBean.getConditionTimePeriod();
                }
                rawQuery =  rawQuery.substring(0, rawQuery.lastIndexOf(formBean.getConditionTimePeriod())) + " )";
            }
            
            //
            // handle impacts
            //
            String[] impacts = formBean.getImpact();
            if ((impacts != null) && (impacts.length > 0)) {
                rawQuery += " AND (";
                for(String impact: impacts) {
                    rawQuery += " (" + ACEIndexConstant.IndexField.IMPACT + ":" + impact + ") " + formBean.getConditionClimateImpact();
                }
                rawQuery =  rawQuery.substring(0, rawQuery.lastIndexOf(formBean.getConditionClimateImpact())) + " )";
            }

            //
            // handle countries
            //
            String[] countries = formBean.getCountries();
            if ((countries != null) && (countries.length > 0)) {
                rawQuery += " AND (";
                for(String country: countries) {
                    rawQuery += " (" + ACEIndexConstant.IndexField.SPATIAL_VALUES + ":" + country + ") OR";
                }
                rawQuery =  rawQuery.substring(0, rawQuery.lastIndexOf("OR")) + " )";
            }

            ACEIndexSearcher searcher = ACEIndexSearcher.getACEIndexSearcher();
            QueryParser queryParser = new QueryParser(ACEIndexConstant.IndexField.ANY, ACEAnalyzer.getAnalyzer());
            Query query = queryParser.parse(rawQuery);
            //System.out.println("Lucene raw query: " + rawQuery);
            //System.out.println("Lucene query: " + query.toString());
            // rewritten query is better for logging/debugging but potentially throws runtime exceptions
            //// System.out.println("Lucene query (rewritten): " + query.rewrite(((IndexSearcher)searcher).getIndexReader()).toString());
            long start = System.currentTimeMillis();

            TopDocs topDocs = searcher.search(query, formBean.getSortBy(), 10);
            long end = System.currentTimeMillis();
            // System.out.println("Lucene searcher # total hits: " + topDocs.totalHits + " in " + (end - start) + " ms");
            ScoreDoc[] hits = topDocs.scoreDocs;

            List<AceItemSearchResult> results = new ArrayList<AceItemSearchResult>();

            //
            // calculate factor to normalize relevance scores
            float topScore = 0f;
            for(ScoreDoc hit : hits) {
                float score = hit.score;
                // System.out.println("score: " + score);
                if(score != Float.NaN) {
                    if(score > topScore) {
                        topScore = score;
                    }
                }
            }
            // System.out.println("topscore is: " + topScore);
            if(topScore == Float.NaN || !(topScore > 0f)) {
                topScore = 1f;
            }
            float normalizeScoreFactor = 1 / topScore ;
            // System.out.println("normalizeScoreFactor is: " + normalizeScoreFactor);


            for (ScoreDoc hit : hits) {
                Document document = searcher.doc(hit.doc);

                //AceItemLocalService aceItemLocalService = AceItemLocalServiceUtil.getService();
                AceItem aceItem ;

                String aceItemId = document.get(ACEIndexConstant.IndexField.ACEITEM_ID);
                if(aceItemId != null) {

                    aceItem = AceItemLocalServiceUtil.getAceItem(Long.parseLong(aceItemId));
                    aceItem.setAceItemId(Long.parseLong(aceItemId));

	                // relevance expressed as a percentage
	                float relevance = hit.score * normalizeScoreFactor * 100;

	                // System.out.println("hit.score is: " + hit.score);
	                // System.out.println("relevance (0.0) is: " + relevance);


	                AceItemSearchResult aceItemSearchResult = new AceItemSearchResult(aceItem);
	                aceItemSearchResult.setRelevance(relevance);

	                results.add(aceItemSearchResult);
                }
            }
            return results;
        }
        catch(ParseException x) {
            System.out.println(x.getMessage());
            x.printStackTrace();
            throw new ACELuceneException(x.getMessage(), x);
        }
        catch (IOException x) {
            System.out.println(x.getMessage());
            x.printStackTrace();
            throw new ACELuceneException(x.getMessage(), x);
        }
    }

}
