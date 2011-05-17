package nl.wur.alterra.cgi.ace.portlet;

import nl.wur.alterra.cgi.ace.search.FreetextMode;

/**
 * Bean for AceItem search form parameters.
 *
 * @author heikki doeleman
 */
public class AceSearchFormBean {

    private String[] aceitemtype;
    private String[] sector;
    private String[] element;
    private String[] countries;
    private String sortBy;
    private String anyOfThese;

    public FreetextMode getFreeTextMode() {
        return freeTextMode;
    }

    private FreetextMode freeTextMode;

    private String conditionAdaptationSector;
    private String conditionAdaptationElement;

    public String[] getAceitemtype() {
        return aceitemtype;
    }

    public void setAceitemtype(String[] aceitemtype) {
        this.aceitemtype = aceitemtype;
    }

    public String[] getSector() {
        return sector;
    }

    public String[] getElement() {
        return element;
    }

    public String[] getCountries() {
        return countries;
    }

    public void setSector(String[] sector) {
        this.sector = sector;
    }

    public void setElement(String[] element) {
        this.element = element;
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

    public String getAnyOfThese() {
        return anyOfThese;
    }

    public void setAnyOfThese(String anyOfThese) {
        this.anyOfThese = anyOfThese;
    }

    public String getConditionAdaptationSector() {
        return conditionAdaptationSector;
    }

    public void setConditionAdaptationSector(String conditionAdaptationSector) {
        this.conditionAdaptationSector = conditionAdaptationSector;
    }

    public String getConditionAdaptationElement() {
        return conditionAdaptationElement;
    }

    public void setConditionAdaptationElement(String conditionAdaptationElement) {
        this.conditionAdaptationElement = conditionAdaptationElement;
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

}
