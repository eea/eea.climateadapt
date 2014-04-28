package nl.wur.alterra.cgi.ace.search.opensearch;

import com.liferay.portal.kernel.search.SearchException;

/**
 * Converter for search responses to BaseOpenSearchResult.
 *
 * @author heikki doeleman
 */
public interface ConvertableToBaseOpenSearchResult {

    /**
     * Converts a search response into a BaseOpenSearchResult. Implement as you like to retrieve e.g. CSW GetRecords
     * information into your Liferay search results.
     *
     * @param response response to convert
     * @return BaseOpenSearchResult
     * @throws com.liferay.portal.kernel.search.SearchException hmm
     */
    public BaseOpenSearchResult convert(String response) throws SearchException;
}