package nl.wur.alterra.cgi.ace.portlet;

import com.liferay.portal.kernel.util.Validator;
import nl.wur.alterra.cgi.ace.model.AceItem;
import nl.wur.alterra.cgi.ace.service.AceItemLocalServiceUtil;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

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
		
		if( aceitem.getAceItemId() > 0 )  {
			
			AceItem dbaceitem = null;
			
			try {
			    dbaceitem = AceItemLocalServiceUtil.getAceItem( aceitem.getAceItemId() );
			}
			catch (Exception e) {
				
				dbaceitem = null ;
			}
			
			// hack optimistic locking!!!  check Lockdate and then always set to null
			if( (dbaceitem != null) && ( dbaceitem.getCreationdate().getTime() != aceitem.getLockdate().getTime() ) )  {
			    //System.out.println("aceitem-changed: " + dbaceitem.getCreationdate().getTime() + " - " + aceitem.getLockdate().getTime());				
				errors.add("aceitem-changed");
				valid = false;
			}
			aceitem.setLockdate(null);
		}

		if (valid) {
			if (Validator.isNull(aceitem.getName())) {
				errors.add("aceitemname-required");
				valid = false;
			}
			
			if (Validator.isNull(aceitem.getDatatype())) {
				errors.add("aceitemdatatype-required");
				valid = false;
			}
	
			if (Validator.isNull(aceitem.getStoredAt())) {
				errors.add("aceitemstoredat-required");
				valid = false;
			}
			
			if (Validator.isNull(aceitem.getDescription())) {
				errors.add("aceitemdescription-required");
				valid = false;
			}
			
			if (Validator.isNull(aceitem.getKeyword())) {
				errors.add("aceitemkeywords-required");
				valid = false;
			}
			
			if (Validator.isNull(aceitem.getSectors_())) {
				errors.add("aceitem_sectors-required");
				valid = false;
			}
			
			if (Validator.isNull(aceitem.getClimateimpacts_())) {
				errors.add("aceitem_climate_impacts-required");
				valid = false;
			}
			
			if (Validator.isNotNull(aceitem.getYear()))
			{
				try {
					int year = Integer.parseInt(aceitem.getYear());
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
			
			if (Validator.isNotNull(aceitem.getGeochars()))
			{
				Object obj=JSONValue.parse(aceitem.getGeochars());
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
		
		return valid;
	}

}
