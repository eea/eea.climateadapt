package nl.wur.alterra.cgi.ace.search.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.Directory;
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
            //System.out.println("creating ACEIndexWriter");

            Directory luceneDirectory = FSDirectory.open(new File(ACEIndexUtil.retrieveIndexFolder() + ACEIndexConstant.INDEX_NAME));
            if(IndexWriter.isLocked(luceneDirectory)) {
                //System.out.println("Lucene directory is locked, forcing unlock");
                IndexWriter.unlock(luceneDirectory);
            }
            Analyzer analyzer = ACEAnalyzer.getAnalyzer();
            indexWriter = new IndexWriter(luceneDirectory, analyzer, IndexWriter.MaxFieldLength.UNLIMITED);
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
     * Closes indexWriter.
     *
     * @throws Throwable
     */
    @Override
    protected void finalize() throws Throwable {
        //System.out.println("finalizing ACEIndexWriter");
        indexWriter.close();
    }

    /**
     *
     * @throws ACELuceneException
     */
    public void close() throws ACELuceneException {
        try {
        //System.out.println("closing indexWriter");
        indexWriter.close();
        }
        catch (CorruptIndexException x) {
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
        //System.out.println("ACEIndexWriter: adding aceitem ");
        try {
            indexWriter.addDocument(document);
            indexWriter.commit();
            ACEIndexSearcher.getACEIndexSearcher().setStale(true);
            //System.out.println("ACEIndexWriter: finished adding aceitem ");
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
        //System.out.println("ACEIndexWriter: deleting aceitem " + aceItemId);
        try {
            indexWriter.deleteDocuments(new Term(ACEIndexConstant.IndexField.ACEITEM_ID, aceItemId));
            indexWriter.commit();
            ACEIndexSearcher.getACEIndexSearcher().setStale(true);
            //System.out.println("ACEIndexWriter: finished deleting aceitem " + aceItemId);
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
     * Deletes all documents from the Lucene index.
     *
     * @throws ACELuceneException
     */
    public void deleteAll() throws ACELuceneException {
        try {
            indexWriter.deleteAll();
            indexWriter.commit();
            ACEIndexSearcher.getACEIndexSearcher().setStale(true);
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
