package nl.wur.alterra.cgi.ace.portlet;

import nl.wur.alterra.cgi.ace.model.Measure;

import com.liferay.portal.kernel.util.OrderByComparator;

public class MeasureNameComparator extends OrderByComparator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5605553901794957485L;

	public static String ORDER_BY_ASC = "name ASC";

	public static String ORDER_BY_DESC = "name DESC";
	
	private boolean _asc ;
	
	public MeasureNameComparator(boolean orderBy) {
		_asc = orderBy;
			   
	}

	
	public MeasureNameComparator() {
		this(false);
	}

	public int compare(Object obj1, Object obj2) {
		Measure measure1 = (Measure) obj1;
		Measure measure2 = (Measure) obj2;

		int value = measure1.getName().toLowerCase().compareTo(
		measure2.getName().toLowerCase());
			
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
		return "MeasureNameComparator " + _asc;
	}
}
