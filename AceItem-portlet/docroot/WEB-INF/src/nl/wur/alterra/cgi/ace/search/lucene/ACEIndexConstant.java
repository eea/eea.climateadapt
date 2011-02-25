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
         * To sort by AceItem sector.
         */
        public static final String SECTOR_SORT = "sectorsort";
        /**
         * To sort by relevance. This is not an actual sort field in the index, by default Lucene uses relevance.
         */
        public static final String RELEVANCE_SORT = "relevancesort";

        // TODO not implemented yet
        public static final String COUNTRY_SORT = "countrysort";

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
         *
         */
        public static final String NAME = "name";
        /**
         * Nuts ID.
         */
        public static final String NUTS_ID = "nutsid";
        /**
         * Nuts level.
         */
        public static final String NUTS_LEVEL = "nutslevel";
        /**
         * Pillar.
         */
        public static final String PILLAR = "pillar";
        /**
         * Sector.
         */
        public static final String SECTOR = "sector";
        /**
         * Start date.
         */
        public static final String START_DATE = "startdate";
        /**
         * Location where it is stored.
         */
        public static final String STOREDAT = "storedat";
        /**
         *
         */
        public static final String TYPE = "type";
    }
}