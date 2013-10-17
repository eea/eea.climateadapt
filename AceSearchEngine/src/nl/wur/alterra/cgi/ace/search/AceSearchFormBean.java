package nl.wur.alterra.cgi.ace.search;

/**
 * Bean for AceItem search form parameters.
 *
 * @author heikki doeleman / hugo de groot
 */
public class AceSearchFormBean {

    private String sortitemtype;
    private String[] aceitemtype;
    private String[] sector;
    private String[] scenario ;
    private String[] timeperiod ;
    private String[] element;
    private String[] impact;
    private String[] countries;
    private String datainfo_type;
    private String sortBy;
    private String fuzziness;
    private String anyOfThese;
    private String[] startyear;
    private String[] endyear;

    

	public String[] getStartyear() {
		return startyear;
	}

	public void setStartyear(String[] startyear) {
		this.startyear = startyear;
	}

	public String[] getEndyear() {
		return endyear;
	}

	public void setEndyear(String[] endyear) {
		this.endyear = endyear;
	}

	public FreetextMode getFreeTextMode() {
        return freeTextMode;
    }

    private FreetextMode freeTextMode;

    private String conditionAdaptationSector;
    private String conditionAdaptationCountry;

	private String conditionAdaptationElement;
    private String conditionScenario;
    private String conditionTimePeriod;
    private String conditionClimateImpact;


    public String getSortitemtype() {
        return sortitemtype;
    }

    public void setSortitemtype(String sortItemType) {
        this.sortitemtype = sortItemType;
    }
    
    public String[] getAceitemtype() {
        return aceitemtype;
    }

    public void setAceitemtype(String[] aceitemtype) {
        this.aceitemtype = aceitemtype;
    }

    public String[] getSector() {
        return sector;
    }

    public String[] getScenario() {
        return scenario;
    }

    public String[] getTimePeriod() {
        return timeperiod;
    }

    public String[] getElement() {
        return element;
    }

    public String[] getImpact() {
        return impact;
    }

    public String[] getCountries() {
        return countries;
    }

    public void setSector(String[] sector) {
        this.sector = sector;
    }

    public void setScenario(String[] scenario) {
        this.scenario = scenario;
    }

    public void setTimePeriod(String[] timeperiod) {
        this.timeperiod = timeperiod;
    }

    public void setElement(String[] element) {
        this.element = element;
    }

    public void setImpact(String[] impact) {
        this.impact = impact;
    }

    public void setCountries(String[] countries) {
        this.countries = countries;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getFuzziness() {
        return fuzziness;
    }

    public void setFuzziness(String fuzziness) {
        this.fuzziness = fuzziness;
    }

    public String getAnyOfThese() {
        return anyOfThese;
    }

    public void setAnyOfThese(String anyOfThese) {
        this.anyOfThese = anyOfThese;
    }

    public String getDatainfo_type() {
        return datainfo_type;
    }

    public void setDatainfo_type(String datainfo_type) {
        this.datainfo_type = datainfo_type;
    }

    public String getConditionAdaptationElement() {
        return conditionAdaptationElement;
    }

    public void setConditionAdaptationElement(String conditionAdaptationElement) {
        this.conditionAdaptationElement = conditionAdaptationElement;
    }

    public String getConditionAdaptationSector() {
        return conditionAdaptationSector;
    }

    public void setConditionAdaptationSector(String conditionAdaptationSector) {
        this.conditionAdaptationSector = conditionAdaptationSector;
    }

    public String getConditionScenario() {
        return conditionScenario;
    }

    public void setConditionScenario(String conditionScenario) {
        this.conditionScenario = conditionScenario;
    }

    public String getConditionTimePeriod() {
        return conditionTimePeriod;
    }

    public void setConditionTimePeriod(String conditionTimePeriod) {
        this.conditionTimePeriod = conditionTimePeriod;
    }

    public void setConditionClimateImpact(String conditionClimateImpact) {
        this.conditionClimateImpact = conditionClimateImpact;
    }

    public String getConditionClimateImpact() {
        return conditionClimateImpact;
    }

    public void setFreetextMode(String freetextMode$) {
        // if undefined search for any
        if(freetextMode$ == null) {
            this.freeTextMode = FreetextMode.ANY;
        }
        if(freetextMode$.equals("1")) {
            this.freeTextMode = FreetextMode.ANY;
        }
        else if(freetextMode$.equals("2")) {
            this.freeTextMode = FreetextMode.ALL;
        }
        // if value unknown search for any
        else {
            this.freeTextMode = FreetextMode.ANY;
        }
    }
    
    public String getConditionAdaptationCountry() {
  		return conditionAdaptationCountry;
  	}

  	public void setConditionAdaptationCountry(String conditionAdaptationCountry) {
  		this.conditionAdaptationCountry = conditionAdaptationCountry;
  	}

}
