package nl.wur.alterra.cgi.ace.portlet;


import java.util.List;

import nl.wur.alterra.cgi.ace.model.Project;
import nl.wur.alterra.cgi.ace.service.ProjectLocalServiceUtil;

import com.liferay.portal.kernel.util.Validator;

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

		if( project.getProjectId() > 0 )  {

			Project dbproject = null;

			try {
			    dbproject = ProjectLocalServiceUtil.getProject( project.getProjectId() );
			}
			catch (Exception e) {

				dbproject = null ;
			}

			// hack optimistic locking!!!  check Approvaldate and then always set to null
			if(dbproject != null){
			    long creationDate = dbproject.getCreationdate() == null ? 0 : dbproject.getCreationdate().getTime();
			    long approvalDate = project.getApprovaldate() == null ? 0 : project.getApprovaldate().getTime();
			    if (creationDate != approvalDate)  {
			        errors.add("project-change");
			        valid = false;
			    }
			}
			project.setApprovaldate(null);
		}

		if (valid) {
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
		}

		return valid;
	}

}
