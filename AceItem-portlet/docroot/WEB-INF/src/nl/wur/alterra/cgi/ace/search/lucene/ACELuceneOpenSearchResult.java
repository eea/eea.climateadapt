package nl.wur.alterra.cgi.ace.search.lucene;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.SearchException;
import nl.wur.alterra.cgi.ace.search.opensearch.BaseOpenSearchResult;
import nl.wur.alterra.cgi.ace.search.opensearch.ConvertableToBaseOpenSearchResult;

/**
 * Converter for CSW GetRecords response to BaseOpenSearchResult.
 *
 * @author heikki doeleman
 */
public class ACELuceneOpenSearchResult implements ConvertableToBaseOpenSearchResult {

    private static Log log = LogFactoryUtil.getLog(ACELuceneOpenSearchResult.class);

    /**
     * Converts a search response into a BaseOpenSearchResult. Implement as you like to retrieve e.g. CSW GetRecords
     * information into your Liferay search results.
     *
     * @param response response to convert
     * @return BaseOpenSearchResult
     * @throws com.liferay.portal.kernel.search.SearchException
     *          hmm
     */
    public BaseOpenSearchResult convert(String response) throws SearchException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}