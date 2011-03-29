package nl.wur.alterra.cgi.ace.portlet;


import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import nl.wur.alterra.cgi.ace.model.Project;

public class ProjectValidator {
	/**
	 * Verify project
	 * 
	 * @param project
	 *            to be validated
	 * @param errors
	 *            to populate with any errors
	 */
	public static boolean validateProject(Project project, List errors) {
		boolean valid = true;

		if (Validator.isNull(project.getAcronym())) {
			errors.add("projectacronym-required");
			valid = false;
		}

		if (Validator.isNull(project.getTitle())) {
			errors.add("projecttitle-required");
			valid = false;
		}

		if (Validator.isNull(project.getLead())) {
			errors.add("projectlead-required");
			valid = false;
		}
		
		
		return valid;
	}

}
