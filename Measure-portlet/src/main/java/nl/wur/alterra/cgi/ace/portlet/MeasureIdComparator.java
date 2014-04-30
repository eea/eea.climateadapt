package nl.wur.alterra.cgi.ace.portlet;

import nl.wur.alterra.cgi.ace.model.Measure;

import com.liferay.portal.kernel.util.OrderByComparator;

public class MeasureIdComparator extends OrderByComparator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6601413680009074550L;

	public static String ORDER_BY_ASC = "measureId ASC";

	public static String ORDER_BY_DESC = "measureId DESC";
	
	private boolean _asc ;
	
	public MeasureIdComparator(boolean orderBy) {
		_asc = orderBy;
		
	}

	
	public MeasureIdComparator() {

		this(false);
	}

	public int compare(Object obj1, Object obj2) {
		Measure measure1 = (Measure) obj1;
		Measure measure2 = (Measure) obj2;

		int value = Integer.parseInt( "" + (measure2.getMeasureId() - measure1.getMeasureId()) );

		
		if (_asc) {
			
			return value;
		} 
		else {
			
			return -value;
		}
	}
	
	public String getOrderBy() {
		if (_asc) {
			return ORDER_BY_ASC;
		} else {
			return ORDER_BY_DESC;
		}
	}
	
	public String toString() {
		return "MeasureIdComparator " +_asc;
	}
}
