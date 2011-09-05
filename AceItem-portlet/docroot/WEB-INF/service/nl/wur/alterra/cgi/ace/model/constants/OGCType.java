package nl.wur.alterra.cgi.ace.model.constants;

/**
 * ISO topic categories.
 *
 * Must be kept in sync with the i18n section about this in Language.properties.
 *
 * @author heikki doeleman
 */
public enum OGCType {
    /**
     * WMS 1.0.0
     */
    WMS100,
    /**
     * WMS 1.1.1
     */
    WMS111,
    /**
     * WMS 1.3.0
     */
    WMS130;
    
    public String getString() {
        return this.name();
    }

}