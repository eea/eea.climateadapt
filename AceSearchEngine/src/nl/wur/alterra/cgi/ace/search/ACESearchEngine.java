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
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * Search engine for AceItems.
 *
 * @author heikki doeleman
 */
public class ACESearchEngine {

    private static final String defaultFuzziness = "0.7";

    /**
     * Prepares ACESearchFormBean from values in a map, using defaults where necessary.
     *
     * @param searchParams
     * @return formbean
     */
    protected AceSearchFormBean prepareACESearchFormBean(Map<String, String[]> searchParams) {

        String[] aceItemTypes ;
        String[] anyOfThese ;
        String[] conditionAdaptationElement ;
        String[] conditionAdaptationSector ;
        String[] conditionClimateImpact ;
        String[] countries ;
        String[] elements ;
        String[] freetextMode ;
        String[] impacts ;
        String[] sectors ;
        String[] sortBys ;

        aceItemTypes = searchParams.get(SearchRequestParams.ACEITEM_TYPE);
        anyOfThese = searchParams.get(SearchRequestParams.ANY);
        conditionAdaptationElement = searchParams.get(SearchRequestParams.CONDITION_ADAPTATION_ELEMENT);
        conditionAdaptationSector = searchParams.get(SearchRequestParams.CONDITION_ADAPTATION_SECTOR);
        conditionClimateImpact = searchParams.get(SearchRequestParams.CONDITION_CLIMATE_IMPACT);
        countries = searchParams.get(SearchRequestParams.COUNTRIES);
        elements = searchParams.get(SearchRequestParams.ELEMENT);
        freetextMode = searchParams.get(SearchRequestParams.FREETEXT_MODE);
        impacts = searchParams.get(SearchRequestParams.IMPACT);
        sectors = searchParams.get(SearchRequestParams.SECTOR);
        sortBys = searchParams.get(SearchRequestParams.SORTBY);

        if(isEmpty(conditionAdaptationSector)) {
            conditionAdaptationSector = new String[1];
            conditionAdaptationSector[0] = SearchRequestParams.AND_CONDITION;
        }
        if(isEmpty(conditionAdaptationElement)) {
            conditionAdaptationElement = new String[1];
            conditionAdaptationElement[0] = SearchRequestParams.AND_CONDITION;
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

        AceSearchFormBean formBean = new AceSearchFormBean();

        formBean.setAceitemtype(aceItemTypes);
        formBean.setCountries(countries);
        formBean.setElement(elements);
        formBean.setFreetextMode(freetextMode[0]);
        formBean.setImpact(impacts);
        formBean.setSector(sectors);
        formBean.setSortBy(sortBy);

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
                        if(searchterm.trim().length() < 4) {
                            result += searchterm.trim() + ") ";
                        }
                        else {
                            result += searchterm.trim() + "~" + fuzziness + ") ";
                        }
                        break;
                    case ALL :
                        if(searchterm.trim().length() < 4) {
                            result += searchterm.trim() + ") AND ";
                        }
                        else {
                            result += searchterm.trim() + "~" + fuzziness + ") AND ";
                        }
                        break;
                    default:
                        if(searchterm.trim().length() < 4) {
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
        System.out.println("*** ACESearchEngine search: searchterms with fuzziness: " + result);
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
    protected List<AceItem> searchLuceneByType(AceSearchFormBean formBean, String aceItemType) throws ACELuceneException {
        try {
            //
            // handle free text input
            //

            //String rawQuery = createRawQuery(allOfThese, anyOfThese, exactlyThese, excludingThese);
            String rawQuery = "";
            if(formBean.getAnyOfThese() != null) {
                rawQuery = rawQuery + " " + formBean.getAnyOfThese();

                rawQuery = prepareFreetext(rawQuery, defaultFuzziness, formBean.getFreeTextMode());
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
                    rawQuery += " (" + ACEIndexConstant.IndexField.SPATIAL_VALUE + ":" + country + ") OR";
                }
                rawQuery =  rawQuery.substring(0, rawQuery.lastIndexOf("OR")) + " )";
            }

            ACEIndexSearcher searcher = ACEIndexSearcher.getACEIndexSearcher();
            QueryParser queryParser = new QueryParser(ACEIndexConstant.IndexField.ANY, ACEAnalyzer.getAnalyzer());
            Query query = queryParser.parse(rawQuery);
            System.out.println("Lucene raw query: " + rawQuery);
            System.out.println("Lucene query: " + query.toString());
            // rewritten query is better for logging/debugging but potentially throws runtime exceptions
            //System.out.println("Lucene query (rewritten): " + query.rewrite(((IndexSearcher)searcher).getIndexReader()).toString());
            long start = System.currentTimeMillis();
            TopDocs topDocs = searcher.search(query, formBean.getSortBy(), 10);
            long end = System.currentTimeMillis();
            System.out.println("Lucene searcher # total hits: " + topDocs.totalHits + " in " + (end - start) + " ms");
            ScoreDoc[] hits = topDocs.scoreDocs;
            List<AceItem> results = new ArrayList<AceItem>();
            for (ScoreDoc hit : hits) {
                Document document = searcher.doc(hit.doc);
                AceItem aceItem = AceItemLocalServiceUtil.getService().createAceItem();
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
                aceItem.setClimateimpacts_(document.get(ACEIndexConstant.IndexField.IMPACT));
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
        catch (IOException x) {
            System.out.println(x.getMessage());
            x.printStackTrace();
            throw new ACELuceneException(x.getMessage(), x);
        }
    }

}