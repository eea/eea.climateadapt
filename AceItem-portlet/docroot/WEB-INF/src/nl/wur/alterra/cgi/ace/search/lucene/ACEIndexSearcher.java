package nl.wur.alterra.cgi.ace.search.lucene;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;

import java.io.File;
import java.io.IOException;

/**
 * Singleton read-only IndexReader for ACE Lucene index.
 *
 * @author heikki doeleman
 */
public class ACEIndexSearcher {

    /**
     * Private constructor for singleton.
     */
    private ACEIndexSearcher() {
        try {
            searcher = new IndexSearcher(FSDirectory.open(new File(ACEIndexConstant.INDEX_NAME)), true);
        }
        catch (IOException x) {
            throw new ExceptionInInitializerError(x);
        }
    }

    /**
     * This singleton instance.
     */
    private static ACEIndexSearcher aceIndexSearcher;

    /**
     * ACEIndexWriter sets this to true after writing, to signal indexReader needs to reopen.
     */
    private boolean stale;

    /**
     * The actual IndexSearcher instance.
     */
    private IndexSearcher searcher;

    /**
     * Returns Lucene searcher for ACE index, creating it if necessary.
     *
     * @return searcher
     */
    public synchronized static ACEIndexSearcher getACEIndexSearcher() {
        if(aceIndexSearcher == null) {
            aceIndexSearcher = new ACEIndexSearcher();
        }
        return aceIndexSearcher;
    }

    public boolean isStale() {
        return stale;
    }

    public void setStale(boolean stale) {
        this.stale = stale;
    }

    public TopDocs search(Query query, int itemsPerPage) throws ACELuceneException {
        try {
            if(this.isStale()) {
                System.out.println("ACEIndexSearcher is stale, reopening indexreader");
                IndexReader currentReader = searcher.getIndexReader();
                IndexReader newReader = searcher.getIndexReader().reopen();
                // reader was reopened
                if (newReader != currentReader) {
                    System.out.println("Reopened indexreader is new, closing old one");
                    currentReader.close();
                }
            }
            return searcher.search(query, itemsPerPage);
        }
        catch (IOException x) {
            System.out.println(x.getMessage());
            x.printStackTrace();
            throw new ACELuceneException(x.getMessage(), x);
        }
    }

    public Document doc(int idx) throws ACELuceneException {
        try {
            return searcher.doc(idx);
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
     * @return nada
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

}
