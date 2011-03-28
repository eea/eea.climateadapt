package nl.wur.alterra.cgi.ace.search.lucene;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
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

    public TopDocs search(Query query, String sortBy, int itemsPerPage) throws ACELuceneException {

        // TODO remove this hack
        itemsPerPage = 1000;

        try {

            if(this.isStale()) {
                System.out.println("ACEIndexSearcher is stale, reopening indexreader");
                IndexReader newReader, oldReader;
                oldReader = this.searcher.getIndexReader();
                newReader = oldReader.reopen();
                if (newReader != oldReader) {
                    System.out.println("index changed");
                    this.searcher.close();
                    oldReader.close();
                    this.searcher = new IndexSearcher(newReader);
                }
                this.setStale(false);
            }

            if(sortBy == null) {
                return searcher.search(query, itemsPerPage);
            }
            else {
                Sort sort = null;
                // TODO support Date and Country sorting
                if(sortBy.equals("SECTOR")) {
                    sort = new Sort(new SortField( ACEIndexConstant.IndexField.SECTOR_SORT, SortField.STRING));
                    return searcher.search(query, null, itemsPerPage, sort);

                }
                else if(sortBy.equals("NAME")) {
                    sort = new Sort(new SortField( ACEIndexConstant.IndexField.NAME_SORT, SortField.STRING));
                    return searcher.search(query, null, itemsPerPage, sort);

                }
                // undefined sort, just ignore it
                else {
                    return searcher.search(query, itemsPerPage);
                }
            }
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

    public int maxDoc() throws ACELuceneException {
        try {
            return searcher.maxDoc();
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

    /**
     * Closes indexSearcher.
     *
     * @throws Throwable
     */
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalizing ACEIndexsearcher");
        searcher.getIndexReader().close();
        searcher.close();
    }

    /**
     *
     * @throws ACELuceneException
     */
    public void close() throws ACELuceneException {
        try {
        System.out.println("closing indexWriter");
        searcher.getIndexReader().close();
        searcher.close();
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

}