package nl.wur.alterra.cgi.ace.model.constants;

/**
 * Scenarios of AceItems.
 *
 * @author hugo de groot
 */
public enum AceItemScenario {
    /**
     * Present conditions.
     */
    PRESENT,
    /**
     * IPCC-SRES A1B.
     */
    IPCCSRES_A1B,    
    /**
     * IPCC-SRES A2.
     */
    IPCCSRES_A2,    
    /**
     * IPCC-SRES A1B2.
     */
    IPCCSRES_A1B2,    
    /**
     * IPCC-SRES B1.
     */
    IPCCSRES_B1,
    /**
     * SCENES EcF (Economy First).
     */
    SCENES_ECF,
    /**
     * SCENES SuE (Sustainability Eventually).
     */
    SCENES_SUE,
    /**
     * Combination of two or more scenarios.
     */
    COMBINATION
}
