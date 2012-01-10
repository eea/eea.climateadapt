package nl.wur.alterra.cgi.ace.model.constants;

/**
 * States of Harvesters.
 *
 * Must be kept in sync with the i18n section about this in Language.properties.
 *
 * @author heikki doeleman
 */
public enum HarvesterStatus {
    //

    // these states are used to display on the page what is the status of the harvester
    //

    /**
     * Harvester has been created but has not yet run.
     */
    NEVER_RUN,
    /**
     * Harvester is currently running.
     */
    RUNNING,
    /**
     * Harvester has run at least once, and the last time GeoNetwork produced no errors.
     */
    SUCCESS,
    /**
     * Harvester has run at least once, and the last time GeoNetwork produced an error.
     */
    ERROR,

    /**
     * An internal error in ACE has occurred related to this Harvester.
     */
    ACE_ERROR,

    //
    // these states are used internally to monitor the state of all actions related to GeoNetwork for this harvester
    //

    /**
     * Request to run was sent to GeoNetwork unsuccessfully.
     *
     */
    GEONETWORK_RUN_FAILURE,
    /**
     * Request to run was sent to GeoNetwork successfully. Note that this does not imply that the run also succesfully finished.
     *
     */
    GEONETWORK_RUN_SUCCESS,
    /**
     * Harvester has not been succesfully saved in GeoNetwork.
     *
     */
    GEONETWORK_INSERT_FAILURE,
    /**
     * Harvester has been succesfully saved in GeoNetwork.
     *
     */
    GEONETWORK_INSERT_SUCCESS,
    /**
     * Harvester has not been succesfully updated in GeoNetwork.
     *
     */
    GEONETWORK_UPDATE_FAILURE,
    /**
     * Harvester has been succesfully updated in GeoNetwork.
     *
     */
    GEONETWORK_UPDATE_SUCCESS,
    /**
     * Harvester has not been succesfully deleted in GeoNetwork.
     *
     */
    GEONETWORK_DELETE_FAILURE,
    /**
     * Harvester has been succesfully deleted in GeoNetwork.
     *
     */
    GEONETWORK_DELETE_SUCCESS,
    /**
     * Harvester has not been succesfully activated in GeoNetwork.
     *
     */
    GEONETWORK_ACTIVATE_FAILURE,
    /**
     * Harvester has been succesfully activated in GeoNetwork.
     *
     */
    GEONETWORK_ACTIVATE_SUCCESS,
    /**
     * Harvester has not been succesfully de-activated in GeoNetwork.
     *
     */
    GEONETWORK_DEACTIVATE_FAILURE,
    /**
     * Harvester has been succesfully de-activated in GeoNetwork.
     *
     */
    GEONETWORK_DEACTIVATE_SUCCESS,
    /**
     * Harvester has not been succesfully gotten from GeoNetwork.
     *
     */
    GEONETWORK_GET_FAILURE,
    /**
     * Harvester has not been succesfully gotten from GeoNetwork.
     *
     */
    GEONETWORK_GET_SUCCESS,
    /**
     * GeoNetwork did not successfully return results of requested harvesting run.
     *
     */
    GEONETWORK_GETRESULTS_FAILURE,
    /**
     * GeoNetwork successfully returned results of requested harvesting run.
     *
     */
    GEONETWORK_GETRESULTS_SUCCESS,
    /**
     * Failed to login to GeoNetwork.
     *
     */
    GEONETWORK_LOGIN_FAILURE,
    /**
     * Succeeded login to GeoNetwork.
     *
     */
    GEONETWORK_LOGIN_SUCCESS,
    /**
     * GeoNetwork did not report this harvester run was finished before the poll timeout.
     *
     */
    GEONETWORK_POLL_TIMEOUT
}