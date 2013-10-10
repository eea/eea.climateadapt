package nl.wur.alterra.cgi.ace.portlet;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import nl.wur.alterra.cgi.ace.model.Measure;
import nl.wur.alterra.cgi.ace.service.MeasureLocalServiceUtil;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Validator;

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

		if( measure.getMeasureId() > 0 )  {

			Measure dbmeasure = null;

			try {
			    dbmeasure = MeasureLocalServiceUtil.getMeasure( measure.getMeasureId() );
			}
			catch (Exception e) {

				dbmeasure = null ;
			}

			// hack optimistic locking!!!  check Approvaldate and then always set to null
			/*if(dbmeasure != null){
                long creationDate = dbmeasure.getCreationdate() == null ? 0 : dbmeasure.getCreationdate().getTime();
                long approvalDate = measure.getApprovaldate() == null ? 0 : measure.getApprovaldate().getTime();
                if (creationDate != approvalDate)  {
                    errors.add("measure-changed");
                    valid = false;
                }
            }
			measure.setApprovaldate(null);*/
		}

		if (valid) {
			//System.out.println("Validator is valid");
			if (Validator.isNull(measure.getName())) {
				//System.out.println("measure name required");
				errors.add("measurename-required");
				valid = false;
			}

			if (Validator.isNull(measure.getMao_type())) {
				errors.add("type-required");
				valid = false;
			}
			
			if (Validator.isNull(measure.getObjectives()) && measure.getMao_type().equalsIgnoreCase("A")) {
				errors.add("objectives-required");
				valid = false;
			}
			
			if (Validator.isNull(measure.getDescription())) {
				//System.out.println("description required");
				errors.add("description-required");
				valid = false;
			}
			

			if (Validator.isNull(measure.getClimateimpacts_()))
			{
				errors.add("climateImpacts-required");
				valid = false;
			}
			
			if (Validator.isNull(measure.getAdaptationoptions()) && measure.getMao_type().equalsIgnoreCase("A") )
			{
				errors.add("adaptationOptions-required");
				valid = false;
			}

			if (Validator.isNull(measure.getChallenges()) && measure.getMao_type().equalsIgnoreCase("A"))
			{
				errors.add("challenges-required");
				valid = false;
			}
			
			if (Validator.isNull(measure.getSolutions()) && measure.getMao_type().equalsIgnoreCase("A") )
			{
				errors.add("solutions-required");
				valid = false;
			}
			
			if (Validator.isNull(measure.getRelevance()) && measure.getMao_type().equalsIgnoreCase("A"))
			{
				errors.add("adaptationRelevance-required");
				valid = false;
			}
			
			if (Validator.isNull(measure.getKeywords()))
			{
				errors.add("keywords-required");
				valid = false;
			}
			
			if (Validator.isNull(measure.getSectors_()))
			{
				errors.add("adaptationSector-required");
				valid = false;
			}
			
			/*if (Validator.isNull(measure.getStakeholderparticipation()))
			{
				errors.add("stake-required");
				valid = false;
			}
			
			System.out.println("success limitations is " + measure.getSucceslimitations());

			if (Validator.isNull(measure.getSucceslimitations()))
			{
				errors.add("success-required");
				valid = false;
			}
			
			if (Validator.isNull(measure.getCostbenefit()))
			{
				errors.add("cost-required");
				valid = false;
			}
			
			if (Validator.isNull(measure.getLegalaspects()))
			{
				errors.add("legal-required");
				valid = false;
			}

			if (Validator.isNull(measure.getImplementationtime()))
			{
				errors.add("impltime-required");
				valid = false;
			}
			

			if (Validator.isNull(measure.getLifetime()))
			{
				errors.add("lifetime-required");
				valid = false;
			}*/
			
			if (Validator.isNull(measure.getContact()) && measure.getMao_type().equalsIgnoreCase("A") )
			{
				errors.add("contact-required");
				valid = false;
			}
			
			if (Validator.isNull(measure.getWebsite()))
			{
				errors.add("website-required");
				valid = false;
			}
			
			/*if (Validator.isNull(measure.getSource()))
			{
				errors.add("source-required");
				valid = false;
			}*/
			
			if (Validator.isNull(measure.getPrimephoto()) && measure.getMao_type().equalsIgnoreCase("A"))
			{
				errors.add("photo-required");
				valid = false;
			}
			
			if (Validator.isNull(measure.getYear()) && measure.getMao_type().equalsIgnoreCase("A") )
			{
					errors.add("year-required");
					valid = false;
			}
			else if (measure.getMao_type().equalsIgnoreCase("A"))
			{
			      /* Pattern p = Pattern.compile("[2][0]\\d\\d");
			       Matcher m = p.matcher(measure.getYear());
			       if (! m.matches())
			       {
			    	   errors.add("year-required");
					   valid = false;
			       }*/
				try {
					int year = Integer.parseInt(measure.getYear());
					if (year < 1900 || year > 2100)
					{
						throw new Exception("Invalid Year");
					}
				}
				catch(Exception e)
				{
					errors.add("year-required");
					valid = false;
				}
			}
			
		
			if (Validator.isNull(measure.getGeochars()) && measure.getMao_type().equalsIgnoreCase("A") )
			{
					errors.add("geo-characterization-required");
					valid = false;
			}
			else if (Validator.isNotNull(measure.getGeochars()))
			{
				Object obj=JSONValue.parse(measure.getGeochars());
				JSONObject jsonObject = (JSONObject) obj;
				JSONObject geoElements = (JSONObject) jsonObject.get("geoElements");
				String element = (String) geoElements.get("element");
				
				if (element.length() == 0 && measure.getMao_type().equalsIgnoreCase("A"))
				{
					errors.add("geo-characterization-required"); 
	    		    valid = false;
				}
				else if (element.equalsIgnoreCase("EUROPE"))
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
			
			if (errors.size() > 0)
			{
				valid = false;
			}
			
		}
	

		return valid;
	}

}
