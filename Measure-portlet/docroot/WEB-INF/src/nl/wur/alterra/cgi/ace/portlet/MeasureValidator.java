package nl.wur.alterra.cgi.ace.portlet;

import java.util.List;

import nl.wur.alterra.cgi.ace.model.Measure;
import nl.wur.alterra.cgi.ace.service.MeasureLocalServiceUtil;

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
			if (Validator.isNull(measure.getName())) {
				errors.add("measurename-required");
				valid = false;
			}

			if (Validator.isNull(measure.getMao_type())) {
				errors.add("type-required");
				valid = false;
			}
		}

		return valid;
	}

}
