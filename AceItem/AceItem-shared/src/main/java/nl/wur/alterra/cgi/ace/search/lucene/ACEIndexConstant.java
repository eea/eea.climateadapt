package nl.wur.alterra.cgi.ace.search.lucene;

/**
 * Constants related to Lucene index in ACE.
 *
 * @author heikki doeleman
 */
public class ACEIndexConstant {

    /**
     * Name of physical directory where index resides.
     */
    public static final String INDEX_NAME = "aceindex";

    /**
     * Separator for elements within a string.
     */
    public static final String SEPARATOR = ":;:";

    /**
     * Lucene index field names.
     *
     */
    public class IndexField {

        //
        // sort fields
        //

        /**
         * To sort by AceItem startDate.
         */
        public static final String DATE_SORT = "datesort";
        /**
         * To sort by AceItem name.
         */
        public static final String NAME_SORT = "namesort";
        /**
         * To sort by AceItem rating.
         */
        public static final String YEAR_SORT = "yearsort";
        /**
         * To sort by AceItem rating.
         */
        public static final String RATING_SORT = "ratingsort";
        /**
         * To sort by relevance. This is not an actual sort field in the index, by default Lucene uses relevance.
         */
        public static final String RELEVANCE_SORT = "relevancesort";

        //
        // regular fields
        //

        /**
         * Field containing all text content of an AceItem ('textSearch').
         */
        public static final String ANY = "any";
        /**
         * The ID of an AceItem.
         */
        public static final String ACEITEM_ID = "aceitemid";
        /**
         * The Liferay Company ID.
         */
        public static final String COMPANY_ID = "companyid";
        /**
         * Description.
         */
        public static final String DESCRIPTION = "description";
        /**
         * End date.
         */
        public static final String END_DATE = "enddate";

        /**
         * Liferay group id.
         */
        public static final String GROUP_ID = "groupid";
        /**
         * Keyword. TODO keyword(s) ?
         */
        public static final String KEYWORD = "keyword";
        /**
         * Name
         */
        public static final String NAME = "name";
        /**
        * Year
        */
       public static final String YEAR = "year";
        /**
         * Rating.
         */
        public static final String RATING = "rating";
        /**
         * Controlstatus.
         */
        public static final String CONTROLSTATUS = "controlstatus";
        /**
         * Spatial Values. Holds all the Countries.
         */
        public static final String SPATIAL_VALUES = "spatialvalues";
        /**
         * Spatial Layer.
         */
        public static final String SPATIAL_LAYER = "spatiallayer";
        /**
         * Sector.
         */
        public static final String SECTOR = "sector";
        /**
         * Element.
         */
        public static final String ELEMENT = "element";
        /**
         * Scenario.
         */
        public static final String SCENARIO = "scenario";
        /**
         * Time Period.
         */
        public static final String TIMEPERIOD = "timeperiod";
        /**
         * Impact.
         */
        public static final String IMPACT = "impact";
        /**
         * Start date.
         */
        public static final String START_DATE = "startdate";
        /**
         * Location where it is stored.
         */
        public static final String STOREDAT = "storedat";

        /**
         * Storage type
         */
        public static final String STORAGETYPE = "storagetype";

        /**
         * Datatype.
         */
        public static final String DATATYPE = "datatype";

        /**
         * Feature.
         */
        public static final String IS_FEATURED_ITEM = "isfeatured";

    }
}
