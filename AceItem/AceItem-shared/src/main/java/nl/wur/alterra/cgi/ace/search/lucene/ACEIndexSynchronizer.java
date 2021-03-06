package nl.wur.alterra.cgi.ace.search.lucene;

import com.liferay.portal.kernel.exception.SystemException;
import nl.wur.alterra.cgi.ace.model.AceItem;
import nl.wur.alterra.cgi.ace.service.AceItemLocalServiceUtil;

import java.util.List;

/**
 * Synchronization if the AceItem Lucene index with the AceItem table in the DBMS.
 *
 * @author heikki doeleman
 *
 */
public class ACEIndexSynchronizer {

    /**
     * Re-indexes a single entry in the Lucene index based on AceItem.
     * @param aceItem to be indexed
     */
    public synchronized void update(AceItem aceItem) {
        AceItemIndexer indexer = new AceItemIndexer();
        try {
            indexer.delete(aceItem);
            indexer.add(aceItem);
        }
        catch (ACELuceneException x) {
            System.out.println(x.getMessage());
            x.printStackTrace();
        }
    }

    /**
     * Adds single entry in the Lucene index based on AceItem.
     * @param aceItem to be indexed
     */
    public synchronized void add(AceItem aceItem) {
        AceItemIndexer indexer = new AceItemIndexer();
        try {
            indexer.add(aceItem);
        }
        catch (ACELuceneException x) {
            System.out.println(x.getMessage());
            x.printStackTrace();
        }
    }

    /**
     * Deletes single entry in the Lucene index based on AceItem.
     * @param aceItem to be deleted
     */
    public synchronized void delete(AceItem aceItem) {
        AceItemIndexer indexer = new AceItemIndexer();
        try {
            indexer.delete(aceItem);
        }
        catch (ACELuceneException x) {
            System.out.println(x.getMessage());
            x.printStackTrace();
        }
    }

    /**
     * Re-indexes entry in the Lucene index based on AceItem.
     * @param aceItem to be re-indexed
     */
    public synchronized void reIndex(AceItem aceItem) {
        //System.out.println("AceItemSynchronizer: reIndexing aceitem " + aceItem.getAceItemId());
        AceItemIndexer indexer = new AceItemIndexer();
        try {
            indexer.reIndex(aceItem);
        }
        catch (ACELuceneException x) {
            System.out.println(x.getMessage());
            x.printStackTrace();
        }
        //System.out.println("AceItemSynchronizer: finished reIndexing aceitem " + aceItem.getAceItemId());
    }

    /**
     * Re-indexes the complete Lucene index based on current content of AceItem table in DBMS.
     */
    public synchronized void synchronize() {
        try {

            ACEIndexWriter aceIndexWriter = ACEIndexWriter.getACEIndexWriter();
            aceIndexWriter.deleteAll();

            List<AceItem> aceItems = AceItemLocalServiceUtil.getAceItems(0, AceItemLocalServiceUtil.getAceItemsCount());
            //System.out.println("\n\n\nACEIndexSynchronizer # aceitems retrieved: " + aceItems.size());

            AceItemIndexer indexer = new AceItemIndexer();
            for(AceItem aceItem : aceItems) {
                indexer.add(aceItem);
            }

        }
        catch (SystemException x) {
            System.out.println(x.getMessage());
            x.printStackTrace();
        }
        catch (ACELuceneException x) {
            System.out.println(x.getMessage());
            x.printStackTrace();
        }
    }
}
