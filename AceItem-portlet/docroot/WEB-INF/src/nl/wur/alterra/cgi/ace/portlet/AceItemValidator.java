package nl.wur.alterra.cgi.ace.portlet;

import com.liferay.portal.kernel.util.Validator;
import nl.wur.alterra.cgi.ace.model.AceItem;

import java.util.List;

public class AceItemValidator {
	/**
	 * Verify aceitem
	 * 
	 * @param aceitem
	 *            to be validated
	 * @param errors
	 *            to populate with any errors
	 */
	public static boolean validateAceItem(AceItem aceitem, List errors) {
		boolean valid = true;

		if (Validator.isNull(aceitem.getDatatype())) {
			errors.add("aceitemdatatype-required");
			valid = false;
		}

		if (Validator.isNull(aceitem.getStoredAt())) {
			errors.add("aceitemstoredat-required");
			valid = false;
		}
		
		
		return valid;
	}

}
