package nl.wur.alterra.cgi.ace.model.constants;

/**
 * ISO topic categories.
 *
 * Must be kept in sync with the i18n section about this in Language.properties.
 *
 * @author heikki doeleman
 */
public enum ISOTopicCategory {
    /**
     * farming
     */
    farming,
    /**
     * biota
     */
    biota,
    /**
     * boundaries
     */
    boundaries,
    /**
     * climatologyMeteorologyAtmosphere
     */
    climatologyMeteorologyAtmosphere,
    /**
     * economy
     */
    economy,
    /**
     * elevation
     */
    elevation,
    /**
     * environment
     */
    environment,
    /**
     * geoscientificInformation
     */
    geoscientificInformation,
    /**
     * health
     */
    health,
    /**
     * imagerybasemapsearthcover
     */
    imageryBaseMapsEarthCover,
    /**
     * intelligencemilitary
     */
    intelligenceMilitary,
    /**
     * location
     */
    location,
    /**
     * inlandwaters
     */
    inlandWaters,
    /**
     * oceans
     */
    oceans,
    /**
     * planningcadastre
     */
    planningCadastre,
    /**
     * society
     */
    society,
    /**
     * structure
     */
    structure,
    /**
     * wms 1.0.0
     */
    transportation,
    /**
     * utilitiescommunication
     */
    utilitiesCommunication;
    
    public String getString() {
        return this.name();
    }
}