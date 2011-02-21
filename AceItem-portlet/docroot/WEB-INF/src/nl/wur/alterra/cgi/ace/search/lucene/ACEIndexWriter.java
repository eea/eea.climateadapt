package nl.wur.alterra.cgi.ace.search.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.FSDirectory;

import java.io.File;
import java.io.IOException;

/**
 * Singleton IndexWriter for ACE Lucene index.
 *
 * @author heikki doeleman
 */
public class ACEIndexWriter {

    /**
     * Private constructor for singleton.
     */
    private ACEIndexWriter() {
        try {
            Analyzer analyzer = ACEAnalyzer.getAnalyzer();
            indexWriter = new IndexWriter(FSDirectory.open(new File(ACEIndexConstant.INDEX_NAME)), analyzer, IndexWriter.MaxFieldLength.UNLIMITED);
        }
        catch (IOException x) {
            System.out.println(x.getMessage());
            x.printStackTrace();
            throw new ExceptionInInitializerError(x);
        }
    }

    /**
     * This singleton instance.
     */
    private static ACEIndexWriter aceIndexWriter;

    /**
     * The actual Lucene IndexWriter instance.
     */
    private IndexWriter indexWriter;


    /**
     * Returns Lucene IndexWriter for ACE index, creating it if necessary.
     *
     * @return ACEIndexWriter
     */
    public synchronized static ACEIndexWriter getACEIndexWriter() {
        if(aceIndexWriter == null) {
            aceIndexWriter = new ACEIndexWriter();
        }
        return aceIndexWriter;
    }

    /**
     * Adds a document to the Lucene index.
     *
     * @param document document to add
     * @throws ACELuceneException hmm
     */
    public void add(Document document) throws ACELuceneException {
        try {
            indexWriter.addDocument(document);
            indexWriter.commit();
            ACEIndexSearcher.getACEIndexSearcher().setStale(true);
        }
        catch(CorruptIndexException x) {
            System.out.println(x.getMessage());
            x.printStackTrace();
            throw new ACELuceneException(x.getMessage(), x);
        }
        catch(IOException x) {
            System.out.println(x.getMessage());
            x.printStackTrace();
            throw new ACELuceneException(x.getMessage(), x);
        }
    }

    /**
     * Deletes an AceItem from the index by its aceItemId.
     *
     * @param aceItemId id of aceitem to delete
     * @throws ACELuceneException hmm
     */
    public void delete(String aceItemId) throws ACELuceneException {
        try {
            indexWriter.deleteDocuments(new Term(ACEIndexConstant.IndexField.ACEITEM_ID, aceItemId));
            indexWriter.commit();
            ACEIndexSearcher.getACEIndexSearcher().setStale(true);
        }
        catch(CorruptIndexException x) {
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


    /**
     * Prevents cloning of singleton.
     *
     * @return nothing
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

}