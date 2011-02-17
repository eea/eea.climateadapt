package nl.wur.alterra.cgi.ace.portlet;

import com.liferay.portal.kernel.util.Validator;

import java.util.List;

import nl.wur.alterra.cgi.ace.model.AceItem;

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

		if (Validator.isNull(aceitem.getType())) {
			errors.add("aceitemtype-required");
			valid = false;
		}

		if (Validator.isNull(aceitem.getStoredAt())) {
			errors.add("aceitemstoredat-required");
			valid = false;
		}
		
		
		return valid;
	}

}
