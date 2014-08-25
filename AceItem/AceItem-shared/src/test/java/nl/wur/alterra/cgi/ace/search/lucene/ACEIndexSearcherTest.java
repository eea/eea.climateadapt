package nl.wur.alterra.cgi.ace.search.lucene;

import java.io.File;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.TermQuery;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class ACEIndexSearcherTest {

    /**
     * By opening a write instance, we force the Lucence index to be created.
     * Using the default location.
     */
    @BeforeClass
    public static void createLuceneDirectory() throws ACELuceneException {
        String folderPath = ACEIndexUtil.retrieveIndexFolder();
        Assert.assertEquals("", folderPath);
        File indexPath = new File(folderPath + ACEIndexConstant.INDEX_NAME);
        if (!indexPath.exists()) {
            indexPath.mkdir();
        }
        // Add a document we can search
        Document doc = new Document();
        doc.add(new Field(ACEIndexConstant.IndexField.ACEITEM_ID, "123", Field.Store.YES, Field.Index.NOT_ANALYZED));
        doc.add(new Field(ACEIndexConstant.IndexField.COMPANY_ID, "1", Field.Store.YES, Field.Index.NOT_ANALYZED));
        doc.add(new Field(ACEIndexConstant.IndexField.DATATYPE, "measure", Field.Store.YES, Field.Index.NOT_ANALYZED));

        ACEIndexWriter aceInxWriter = ACEIndexWriter.getACEIndexWriter();
        aceInxWriter.add(doc);
    }


    /**
     * Clean up Lucene files.
     */
    @AfterClass
    public static void removeLuceneIndex() throws ACELuceneException {
        ACEIndexWriter aceInxWriter = ACEIndexWriter.getACEIndexWriter();
        aceInxWriter.deleteAll();
        aceInxWriter.close();
        aceInxWriter = null;

        String folderPath = ACEIndexUtil.retrieveIndexFolder();
        Assert.assertEquals("", folderPath);
        File indexPath = new File(folderPath + ACEIndexConstant.INDEX_NAME);
        // Delete the directory and content.
        for (File member : indexPath.listFiles()) {
            member.delete();
        }
        indexPath.delete();
    }

    @Test
    public void makeOneSearch() throws ACELuceneException {
        searchAndClose();
    }

    /*
     * To cause a failure, remove the @Ignore from this test.
     */
    @Ignore
    @Test
    public void makeSecondSearch() throws ACELuceneException {
        searchAndClose();
    }

    /**
     * Get searcher singleton, search, then close the searcher.
     * Alternatively, let the searcher variable go out of scope and then someday finalize will be called.
     * But we're in a hurry.
     */
    private void searchAndClose() throws ACELuceneException {
        ACEIndexSearcher searcher = ACEIndexSearcher.getACEIndexSearcher();
        Query query = new TermQuery(new Term(ACEIndexConstant.IndexField.DATATYPE, "measure"));
        TopDocs hits = searcher.search(query, null, 10);
        Assert.assertEquals(1, hits.totalHits);
        for (int i = 0; i < hits.scoreDocs.length; i++) {
            Document hitDoc = searcher.doc(hits.scoreDocs[i].doc);
            Assert.assertEquals("measure", hitDoc.get(ACEIndexConstant.IndexField.DATATYPE));
        }
        searcher.close();
    }
}
