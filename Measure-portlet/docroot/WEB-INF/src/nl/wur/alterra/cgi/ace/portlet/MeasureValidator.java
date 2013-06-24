package nl.wur.alterra.cgi.ace.portlet;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
			if(dbmeasure != null){
                long creationDate = dbmeasure.getCreationdate() == null ? 0 : dbmeasure.getCreationdate().getTime();
                long approvalDate = measure.getApprovaldate() == null ? 0 : measure.getApprovaldate().getTime();
                if (creationDate != approvalDate)  {
                    errors.add("measure-changed");
                    valid = false;
                }
            }
			measure.setApprovaldate(null);
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
			
			if (Validator.isNull(measure.getObjectives())) {
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
			
			if (Validator.isNull(measure.getAdaptationoptions()))
			{
				errors.add("adaptationOptions-required");
				valid = false;
			}

			if (Validator.isNull(measure.getChallenges()))
			{
				errors.add("challenges-required");
				valid = false;
			}
			
			if (Validator.isNull(measure.getSolutions()))
			{
				errors.add("solutions-required");
				valid = false;
			}
			
			if (Validator.isNull(measure.getRelevance()))
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
			
			if (Validator.isNull(measure.getContact()))
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
			
			if (Validator.isNull(measure.getPrimephoto()))
			{
				errors.add("photo-required");
				valid = false;
			}
			
			if (Validator.isNull(measure.getYear()))
			{
					errors.add("year-required");
					valid = false;
			}
			else
			{
			       Pattern p = Pattern.compile("[2][0]\\d\\d");
			       Matcher m = p.matcher(measure.getYear());
			       if (! m.matches())
			       {
			    	   errors.add("year-required");
					   valid = false;
			       }
			}
			
			if (Validator.isNull(measure.getGeochars()))
			{
					errors.add("geo-characterization-required");
					valid = false;
			}
			else
			{
				 String choosenGeoChars = measure.getGeochars();
				 if (choosenGeoChars.contains("SUBNATIONAL") || choosenGeoChars.contains("CITY"))
			     {
			        	if (choosenGeoChars.split("\\^").length <= 1)
			        	{
			        		// add error message
			    		    errors.add("geo-characterization-required");
			    		    valid = false;
			        	}
			     }
				 else if (choosenGeoChars.contains("TRANSNATIONAL"))
				 {
					 if (choosenGeoChars.split("\\^").length <= 2)
			         {
			        		// add error message
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
		
		//System.out.println("returning from VALIDATOR");

		return valid;
	}

}
