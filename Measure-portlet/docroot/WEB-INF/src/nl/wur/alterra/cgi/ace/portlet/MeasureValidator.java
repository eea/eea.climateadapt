package nl.wur.alterra.cgi.ace.portlet;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import nl.wur.alterra.cgi.ace.model.Measure;

public class MeasureValidator {
	/**
	 * Verify measure
	 * 
	 * @param measure
	 *            to be validated
	 * @param errors
	 *            to populate with any errors
	 */
	public static boolean validateMeasure(Measure measure, List errors) {
		boolean valid = true;

		if (Validator.isNull(measure.getName())) {
			errors.add("measurename-required");
			valid = false;
		}

		if (Validator.isNull(measure.getMao_type())) {
			errors.add("type-required");
			valid = false;
		}
		
		return valid;
	}
	
}
