package nl.wur.alterra.cgi.ace.search.lucene;

import nl.wur.alterra.cgi.ace.model.AceItem;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.NumericField;

import java.util.Date;

/**
 * Lucene indexer for AceItems.
 *
 * @author heikki doeleman
 */
public class AceItemIndexer {

    /**
     * To write to index.
     */
    private ACEIndexWriter aceIndexWriter = ACEIndexWriter.getACEIndexWriter();

    /**
     * Adds an AceItem to the index.
     *
     * @param aceItem aceitem to add
     * @throws ACELuceneException hmm
     */
    public void add(AceItem aceItem) throws ACELuceneException {
        Document document = convertToLuceneDocument(aceItem);
        aceIndexWriter.add(document);
    }

    /**
     * Deletes an AceItem from the index.
     *
     * @param aceItem aceitem to delete
     */
    public void delete(AceItem aceItem) throws ACELuceneException {
        aceIndexWriter.delete(Long.toString(aceItem.getAceItemId()));
    }

    /**
     * Creates a Lucene Document from an AceItem.
     *
     *
     * @param aceItem aceitem
     * @return document
     */
    private Document convertToLuceneDocument(AceItem aceItem) {

        long aceItemId = aceItem.getAceItemId();
        long companyId = aceItem.getCompanyId();
        String description = aceItem.getDescription();
        Date endDate = aceItem.getEndDate();
        long groupId = aceItem.getGroupId();
        // TODO this is how BookmarkIndexer does it. Why do this like this ?
		// long groupId = getParentGroupId(entry.getGroupId());
		// long scopeGroupId = entry.getGroupId();
        String keyword = aceItem.getKeyword();
        String name = aceItem.getName();
        String nutsId = aceItem.getNutsId();
        String nutsLevel = aceItem.getNutsLevel();
        String pillar = aceItem.getPilar();
        String sector = aceItem.getSector();
        Date startDate = aceItem.getStartDate();
        String storedAt = aceItem.getStoredAt();
        String textSearch = aceItem.getTextSearch();
        String type = aceItem.getType();

        Document document = new Document();

        document.add(new Field(ACEIndexConstant.IndexField.ACEITEM_ID, Long.toString(aceItemId), Field.Store.YES,Field.Index.NOT_ANALYZED));
        document.add(new Field(ACEIndexConstant.IndexField.COMPANY_ID, Long.toString(companyId), Field.Store.YES,Field.Index.NOT_ANALYZED));

        if(description != null) {
            /*
             * Description is indexed using whatever is the default analyzer we're using (see ACEAnalyzer).
             */
            document.add(new Field(ACEIndexConstant.IndexField.DESCRIPTION, description, Field.Store.YES,Field.Index.ANALYZED));
        }

        if(endDate != null) {
            /*
             * Date fields are indexed using Keywordanalyzer.
             */
            document.add(new NumericField(ACEIndexConstant.IndexField.END_DATE, Field.Store.YES, true).setLongValue(endDate.getTime()));
        }

        document.add(new Field(ACEIndexConstant.IndexField.GROUP_ID, Long.toString(groupId), Field.Store.YES,Field.Index.NOT_ANALYZED));

        if(keyword != null) {
            /*
             * Keyword field is analyzed using KeywordAnalyzer.
             */
            document.add(new Field(ACEIndexConstant.IndexField.KEYWORD, keyword, Field.Store.YES,Field.Index.ANALYZED));
        }

        if(name != null) {
            document.add(new Field(ACEIndexConstant.IndexField.NAME, name, Field.Store.YES,Field.Index.ANALYZED));
        }

        if(nutsId != null) {
            document.add(new Field(ACEIndexConstant.IndexField.NUTS_ID, nutsId, Field.Store.YES,Field.Index.NOT_ANALYZED));
        }

        if(nutsLevel != null) {
            document.add(new Field(ACEIndexConstant.IndexField.NUTS_LEVEL, nutsLevel, Field.Store.YES,Field.Index.NOT_ANALYZED));
        }

        if(pillar != null) {
            document.add(new Field(ACEIndexConstant.IndexField.PILLAR, pillar, Field.Store.YES,Field.Index.NOT_ANALYZED));
        }

        if(sector != null) {
            document.add(new Field(ACEIndexConstant.IndexField.SECTOR, sector, Field.Store.YES,Field.Index.NOT_ANALYZED));
        }

        if(startDate != null) {
            /*
             * Date fields are indexed using Keywordanalyzer.
             */
            document.add(new NumericField(ACEIndexConstant.IndexField.START_DATE, Field.Store.YES, true).setLongValue(startDate.getTime()));
        }

        if(storedAt != null) {
            document.add(new Field(ACEIndexConstant.IndexField.STOREDAT, storedAt, Field.Store.YES,Field.Index.NOT_ANALYZED));
        }

        if(textSearch != null) {
            /*
             * TextSearch is indexed using whatever is the default analyzer we're using (see ACEAnalyzer).
             */
            document.add(new Field(ACEIndexConstant.IndexField.ANY, textSearch, Field.Store.YES,Field.Index.ANALYZED));
        }

        if(type != null) {
            document.add(new Field(ACEIndexConstant.IndexField.TYPE, type, Field.Store.YES,Field.Index.NOT_ANALYZED));
        }

		return document;
    }

}