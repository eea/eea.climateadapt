package nl.wur.alterra.cgi.ace.search.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.KeywordAnalyzer;
import org.apache.lucene.analysis.PerFieldAnalyzerWrapper;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.util.Version;

/**
 * Analyzer definitions for ACE.
 *
 * @author heikki doeleman
 */
public class ACEAnalyzer {

    /**
     * Creates an analyzer that uses StandardAnalyzer by default, and KeywordAnalyzer for fields that are not to be
     * tokenized.
     *
     * Note that this can easily be changed to define other analyzers for different fields, if applicable (e.g.
     * analyzers using stopwords for different languages if we create multilingual search).
     *
     * @return lucene analyzer
     */
    public static Analyzer getAnalyzer() {
        PerFieldAnalyzerWrapper analyzer = new PerFieldAnalyzerWrapper(new StandardAnalyzer(Version.LUCENE_CURRENT));
        KeywordAnalyzer keywordAnalyzer = new KeywordAnalyzer();
        analyzer.addAnalyzer(ACEIndexConstant.IndexField.END_DATE, keywordAnalyzer);
        analyzer.addAnalyzer(ACEIndexConstant.IndexField.KEYWORD, keywordAnalyzer);
        analyzer.addAnalyzer(ACEIndexConstant.IndexField.DATATYPE, keywordAnalyzer);
        analyzer.addAnalyzer(ACEIndexConstant.IndexField.SECTOR, keywordAnalyzer);
        analyzer.addAnalyzer(ACEIndexConstant.IndexField.ELEMENT, keywordAnalyzer);
        analyzer.addAnalyzer(ACEIndexConstant.IndexField.SPATIAL_LAYER, keywordAnalyzer);
        analyzer.addAnalyzer(ACEIndexConstant.IndexField.SPATIAL_VALUE, keywordAnalyzer);
        analyzer.addAnalyzer(ACEIndexConstant.IndexField.START_DATE, keywordAnalyzer);
        analyzer.addAnalyzer(ACEIndexConstant.IndexField.STOREDAT, keywordAnalyzer);
        return analyzer;
    }

}