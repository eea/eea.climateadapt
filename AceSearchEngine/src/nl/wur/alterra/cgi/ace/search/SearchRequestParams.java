package nl.wur.alterra.cgi.ace.search;

/**
 * Constants used as search request parameters.
 *
 * @author heikki doeleman
 *
 */
public class SearchRequestParams {


	public static final String ANY = "anyOfThese";

    /**
     * Either 1 (search any of the words) or 2 (search all words).
     */
    public static final String FREETEXT_MODE = "freetextAny";
    public static final String INITIAL_DATE = "initial_date";
	public static final String FINAL_DATE = "final_date";
	public static final String SIMPLE_DATE = "simple_date";
	public static final String DATAINFO_TYPE = "datainfo_type";
	public static final String ACEITEM_TYPE = "aceitemtype";
	public static final String SORTITEM_TYPE = "sortitemtype";
	public static final String SORTBY = "sortBy";
	public static final String SECTOR = "sector";
	public static final String COUNTRIES = "countries";
    public static final String ELEMENT = "element";
    public static final String SCENARIO = "scenario";
    public static final String TIMEPERIOD = "timeperiod";
    public static final String IMPACT = "impact";
    public static final String YEAR = "year";

	public static final String SEARCH_PARAMS = "searchParams";
	public static final String SEARCH_RESULTS = "searchResults";

    public static final String AND_CONDITION = "AND";
    public static final String OR_CONDITION = "OR";

	public static final String TOTAL_RESULTS = "total_results";

    public static final String CONDITION_ADAPTATION_SECTOR = "conditionAdaptationSector";
    public static final String CONDITION_ADAPTATION_ELEMENT = "conditionAdaptationElement";
    public static final String CONDITION_SCENARIO = "conditionScenario";
    public static final String CONDITION_TIME_PERIOD = "conditionTimePeriod";
    public static final String CONDITION_CLIMATE_IMPACT = "conditionClimateImpact";
    
    public static final String FUZZINESS = "fuzziness";

}
