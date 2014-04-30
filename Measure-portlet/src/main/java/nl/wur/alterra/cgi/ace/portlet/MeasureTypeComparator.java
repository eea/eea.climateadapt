package nl.wur.alterra.cgi.ace.portlet;

import nl.wur.alterra.cgi.ace.model.Measure;

import com.liferay.portal.kernel.util.OrderByComparator;

public class MeasureTypeComparator extends OrderByComparator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1778625443566249409L;

	public static String ORDER_BY_ASC = "mao_type ASC"; // "mao_type, name ASC";

	public static String ORDER_BY_DESC = "mao_type DESC"; //  "mao_type, name DESC";
	
	private boolean _asc ;
	
	public MeasureTypeComparator(boolean orderBy) {
		_asc = orderBy;
			   
	}

	
	public MeasureTypeComparator() {
		this(false);
	}

	public int compare(Object obj1, Object obj2) {
		Measure measure1 = (Measure) obj1;
		Measure measure2 = (Measure) obj2;

		//int value = measure1.getMao_type().concat(measure1.getName()).toLowerCase().compareTo(
		//		measure2.getMao_type().concat(measure2.getName()).toLowerCase() );
		
		int value = measure1.getMao_type().toLowerCase().compareTo(
		measure2.getMao_type().toLowerCase());
			
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
		return "MeasureTypeComparator " + _asc;
	}
}
