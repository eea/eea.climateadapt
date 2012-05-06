package nl.wur.alterra.cgi.ace.portlet;

import com.liferay.portal.kernel.util.Validator;
import nl.wur.alterra.cgi.ace.model.AceItem;
import nl.wur.alterra.cgi.ace.service.AceItemLocalServiceUtil;

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
		
		if( aceitem.getAceItemId() > 0 )  {
			
			AceItem dbaceitem = null;
			
			try {
			    dbaceitem = AceItemLocalServiceUtil.getAceItem( aceitem.getAceItemId() );
			}
			catch (Exception e) {
				
				dbaceitem = null ;
			}
			
			// hack optimistic locking!!!  check Approvaldate and then always set to null
			if( (dbaceitem != null) && ( dbaceitem.getCreationdate().getTime() != aceitem.getApprovaldate().getTime() ) )  {
			    //System.out.println("aceitem-change: " + dbaceitem.getCreationdate().getTime() + " - " + aceitem.getApprovaldate().getTime());				
				errors.add("aceitem-change");
				valid = false;
			}
			aceitem.setApprovaldate(null);
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
		}
		
		return valid;
	}

}
