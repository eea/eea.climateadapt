package nl.wur.alterra.cgi.ace.portlet;

import com.liferay.portal.kernel.util.Validator;
import nl.wur.alterra.cgi.ace.model.CSWHarvester;
import nl.wur.alterra.cgi.ace.model.WxsHarvester;

import java.util.List;

/**
 * @author heikki doeleman
 */
public class CSWHarvesterValidator {
    /**
     * Verifies CSWHarvester.
     *
     * @param cswHarvester to be validated
     * @param errors to populate with any errors
     */
    public static boolean validateCSWHarvester(CSWHarvester cswHarvester, List errors) {
        boolean valid = true;
        if (Validator.isNull(cswHarvester.getName())) {
            errors.add("aceharvestername-required");
            valid = false;
        }
        if (Validator.isNull(cswHarvester.getUrl())) {
            errors.add("aceharvesterurl-required");
            valid = false;
        }
        return valid;
    }

}
