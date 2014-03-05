package nl.wur.alterra.cgi.ace.portlet;


import java.util.List;

import nl.wur.alterra.cgi.ace.model.Project;
import nl.wur.alterra.cgi.ace.service.ProjectLocalServiceUtil;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

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
			
			// hack optimistic locking!!!  check Lockdate and then always set to null
			if(dbproject != null  && ( dbproject.getCreationdate().getTime() != project.getLockdate().getTime() )){
			        errors.add("project-change");
			        valid = false;
			}
			project.setLockdate(null);
		}

		if (valid) {
			if (Validator.isNull(project.getAcronym())) {
				errors.add("project-acronym-required");
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
			
			if (Validator.isNull(project.getAbstracts())) {
				errors.add("project-acronym-required");
				valid = false;
			}
			
			if (Validator.isNull(project.getKeywords())) {
				errors.add("project-keywords-required");
				valid = false;
			}
			
			if (Validator.isNull(project.getSectors())) {
				errors.add("project-sectors-required");
				valid = false;
			}
			
			if (Validator.isNull(project.getClimateimpacts())) {
				errors.add("project-climate-impacts-required");
				valid = false;
			}
			
			if (Validator.isNotNull(project.getGeochars()))
			{
				Object obj=JSONValue.parse(project.getGeochars());
				JSONObject jsonObject = (JSONObject) obj;
				JSONObject geoElements = (JSONObject) jsonObject.get("geoElements");
				String element = (String) geoElements.get("element");
				
				if (element.equalsIgnoreCase("EUROPE"))
				{
					JSONArray macroTrans = (JSONArray) geoElements.get("macrotrans");
					JSONArray bioTrans = (JSONArray) geoElements.get("biotrans");
					JSONArray countries = (JSONArray) geoElements.get("countries");
					JSONArray subnationals = (JSONArray) geoElements.get("subnational");
					String city = (String) geoElements.get("city");
					
					if (macroTrans.size() == 0 && bioTrans.size() == 0 && countries.size() == 0 && subnationals.size() == 0 && city.trim().length() == 0 )
					{
						errors.add("geo-characterization-required"); 
		    		    valid = false;
					}
					
				}
			}
		}
		
		if (errors.size() > 0)
		{
			valid = false;
		}
		

		return valid;
	}

}
