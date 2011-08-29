package nl.wur.alterra.cgi.ace.portlet;

import com.liferay.portal.kernel.util.Validator;
import nl.wur.alterra.cgi.ace.model.WxsHarvester;

import java.util.List;

/**
 * @author heikki doeleman
 */
public class WxsHarvesterValidator {
	/**
	 * Verifies wxsHarvester.
	 * 
	 * @param wxsHarvester to be validated
	 * @param errors to populate with any errors
	 */
	public static boolean validateWxsHarvester(WxsHarvester wxsHarvester, List errors) {
		boolean valid = true;
		if (Validator.isNull(wxsHarvester.getName())) {
			errors.add("wxsHarvestername-required");
			valid = false;
		}
		return valid;
	}

}
