package nl.wur.alterra.cgi.ace.portlet;

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
    private String initialDate;
    private String finalDate;
    private String simpleDate;
    private String sortBy;
    private String anyOfThese;

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

    public String getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(String initialDate) {
        this.initialDate = initialDate;
    }

    public String getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(String finalDate) {
        this.finalDate = finalDate;
    }

    public String getSimpleDate() {
        return simpleDate;
    }

    public void setSimpleDate(String simpleDate) {
        this.simpleDate = simpleDate;
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
}
