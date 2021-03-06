package nl.wur.alterra.cgi.ace.search.lucene;

import nl.wur.alterra.cgi.ace.model.AceItem;

import org.apache.commons.lang.StringUtils;
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
     * Re-indexes an AceItem by trying first to delete it, and regardless of the result, then add it.
     *
     * @param aceItem
     * @throws ACELuceneException
     */
    public void reIndex(AceItem aceItem) throws ACELuceneException {
        //System.out.println("AceItemIndexer: reindexing AceItem " + aceItem.getAceItemId());
        try {
            aceIndexWriter.delete(Long.toString(aceItem.getAceItemId()));
        }
        // if this fails (maybe it did not exist?) just try to add it
        catch(ACELuceneException x) {
            System.out.println("AceItemIndexer: error deleting AceItem from index, id: " + aceItem.getAceItemId() + " message is: " + x.getMessage());
        }
        Document document = convertToLuceneDocument(aceItem);
        aceIndexWriter.add(document);
        //System.out.println("AceItemIndexer: successfully indexed AceItem " + aceItem.getAceItemId());
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
        String controlstatus$ = "" + aceItem.getControlstatus();
        // TODO this is how BookmarkIndexer does it. Why do this like this ?
        // long groupId = getParentGroupId(entry.getGroupId());
        // long scopeGroupId = entry.getGroupId();
        String keyword = aceItem.getKeyword();
        String name = aceItem.getName();
        String rating$ = "" + aceItem.getRating();
        Long rating = 0l;
        if(rating$ == null || rating$.equalsIgnoreCase("NaN")) {
            rating = 0l;
        }
        else {
            rating = Long.parseLong(rating$) ;
        }
        rating = 555555555l - rating; // to get right order with String comparison - descending rating order
        rating$ = "" + rating;
        String spatialValues = aceItem.getSpatialValues();
        String spatialLayers = aceItem.getSpatialLayer();
        String elements = aceItem.getElements_();
        String impacts = aceItem.getClimateimpacts_();
        String sectors = aceItem.getSectors_();
        String scenarios = aceItem.getScenario();
        String timeperiods = aceItem.getTimeperiod();
        Date startDate = aceItem.getStartDate();
        String storedAt = aceItem.getStoredAt();
        String storageType = aceItem.getStoragetype();
        String textSearch = aceItem.getTextSearch();
        String datatype = aceItem.getDatatype();
        String year = aceItem.getYear();
        String feature = aceItem.getFeature();
        
        Document document = new Document();

        document.add(new Field(ACEIndexConstant.IndexField.ACEITEM_ID, Long.toString(aceItemId), Field.Store.YES,Field.Index.NOT_ANALYZED));
        document.add(new Field(ACEIndexConstant.IndexField.COMPANY_ID, Long.toString(companyId), Field.Store.YES,Field.Index.NOT_ANALYZED));

        if(description != null) {
            /*
             * Description is indexed using whatever is the default analyzer we're using (see ACEAnalyzer).
             */
            document.add(new Field(ACEIndexConstant.IndexField.DESCRIPTION, description, Field.Store.YES,Field.Index.ANALYZED));
        }

        if (year != null && year.length() > 0)
        {
             /*
             * year fields are indexed using Keywordanalyzer.
             */
            document.add(new NumericField(ACEIndexConstant.IndexField.YEAR, Field.Store.YES, true).setIntValue(Integer.parseInt(year)));
            document.add(new NumericField(ACEIndexConstant.IndexField.YEAR_SORT, Field.Store.NO, true).setIntValue(Integer.parseInt(year)));
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
            // for sorting
            document.add(new Field(ACEIndexConstant.IndexField.NAME_SORT, name.toUpperCase(), Field.Store.NO,Field.Index.NOT_ANALYZED));
        }

        if(rating$ != null) {
            document.add(new Field(ACEIndexConstant.IndexField.RATING, rating$, Field.Store.YES,Field.Index.ANALYZED));
            // for sorting
            document.add(new Field(ACEIndexConstant.IndexField.RATING_SORT, rating$, Field.Store.NO,Field.Index.NOT_ANALYZED));
        }

        if(controlstatus$ != null) {
            document.add(new Field(ACEIndexConstant.IndexField.CONTROLSTATUS, controlstatus$, Field.Store.YES,Field.Index.NOT_ANALYZED));
       }
        if(spatialLayers != null) {
            document.add(new Field(ACEIndexConstant.IndexField.SPATIAL_LAYER, spatialLayers, Field.Store.YES,Field.Index.NOT_ANALYZED));
        }

        if(feature != null) {
            // for filtering
            if ( feature == null || feature.equals("") ) {
                document.add(new Field(ACEIndexConstant.IndexField.IS_FEATURED_ITEM, String.valueOf(0), Field.Store.NO,Field.Index.NOT_ANALYZED));	
            }
            else {
                document.add(new Field(ACEIndexConstant.IndexField.IS_FEATURED_ITEM, String.valueOf(1), Field.Store.NO,Field.Index.NOT_ANALYZED));
            }
        }

        
        //if(spatialValues != null) {
        //    document.add(new Field(ACEIndexConstant.IndexField.SPATIAL_VALUES, spatialValues, Field.Store.YES,Field.Index.NOT_ANALYZED));
        //}

        if (spatialValues != null)   {
            String[] spatialvalues = spatialValues.split(";");

            for(int i = 0; i < spatialvalues.length; i++) {
                document.add(new Field(ACEIndexConstant.IndexField.SPATIAL_VALUES, spatialvalues[i].trim(), Field.Store.YES,Field.Index.NOT_ANALYZED));
            }
        }

        if(elements != null) {
            String[] elementValues = elements.split(";");

            for(int i = 0; i < elementValues.length; i++) {
                document.add(new Field(ACEIndexConstant.IndexField.ELEMENT, elementValues[i].trim(), Field.Store.YES,Field.Index.NOT_ANALYZED));
            }
        }

        if(impacts != null) {
            String[] impactValues = impacts.split(";");

            for(int i = 0; i < impactValues.length; i++) {
                document.add(new Field(ACEIndexConstant.IndexField.IMPACT, impactValues[i].trim(), Field.Store.YES,Field.Index.NOT_ANALYZED));
            }
        }

        if(sectors != null) {
            String[] sectorValues = sectors.split(";");

            for(int i = 0; i < sectorValues.length; i++) {
                // for searching
                document.add(new Field(ACEIndexConstant.IndexField.SECTOR, sectorValues[i].trim(), Field.Store.YES,Field.Index.NOT_ANALYZED));
            }
        }

        if(scenarios != null) {
            String[] scenarioValues = scenarios.split(";");

            for(int i = 0; i < scenarioValues.length; i++) {
                // for searching
                document.add(new Field(ACEIndexConstant.IndexField.SCENARIO, scenarioValues[i].trim(), Field.Store.YES,Field.Index.NOT_ANALYZED));
            }
        }

        if(timeperiods != null) {
            String[] timeperiodValues = timeperiods.split(";");

            for(int i = 0; i < timeperiodValues.length; i++) {
                // for searching
                document.add(new Field(ACEIndexConstant.IndexField.TIMEPERIOD, timeperiodValues[i].trim(), Field.Store.YES,Field.Index.NOT_ANALYZED));
            }
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

        if(storageType != null) {
            document.add(new Field(ACEIndexConstant.IndexField.STORAGETYPE, storageType, Field.Store.YES,Field.Index.NOT_ANALYZED));
        }

        if(textSearch != null) {
            /*
             * TextSearch is indexed using whatever is the default analyzer we're using (see ACEAnalyzer).
             */
            document.add(new Field(ACEIndexConstant.IndexField.ANY, textSearch, Field.Store.YES,Field.Index.ANALYZED));
        }

        if(datatype != null) {
            document.add(new Field(ACEIndexConstant.IndexField.DATATYPE, datatype, Field.Store.YES,Field.Index.NOT_ANALYZED));
        }


        return document;
    }

}
