package nl.wur.alterra.cgi.ace.model.constants;

/**
 * Types of AceItems.
 *
 * Must be kept in sync with the i18n section about this in Language.properties.
 *
 * @author heikki doeleman
 */
public enum AceItemType {
    /**
     * Publications and reports.
     */
    DOCUMENT,
    /**
     * Datasets.
     */
    DATASET,
    /**
     * Maps and graphs.
     */
    MAP,
    /**
     * Indicators.
     */
    INDICATOR,
    /**
     * Guidance.
     */
    TOOLGUIDANCE,
    /**
     * Research projects.
     */
    RESEARCHPROJECT,
    /**
     * Measures.
     */
    MEASURE, 
    /**
     * Good practices.
     */
    ACTION,
    /**
     * Organisations.
     */
    ORGANISATION
}