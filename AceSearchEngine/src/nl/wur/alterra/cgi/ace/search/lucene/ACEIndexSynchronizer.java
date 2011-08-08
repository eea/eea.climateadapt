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

    public void synchronize() {

        try {

            ACEIndexWriter aceIndexWriter = ACEIndexWriter.getACEIndexWriter();
            aceIndexWriter.deleteAll();

            List<AceItem> aceItems = AceItemLocalServiceUtil.getAceItems(0, AceItemLocalServiceUtil.getAceItemsCount());
            System.out.println("\n\n\nACEIndexSynchronizer # aceitems retrieved: " + aceItems.size());

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
