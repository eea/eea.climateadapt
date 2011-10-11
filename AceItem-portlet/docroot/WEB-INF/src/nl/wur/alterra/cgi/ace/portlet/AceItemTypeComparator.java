package nl.wur.alterra.cgi.ace.portlet;

import nl.wur.alterra.cgi.ace.model.AceItem;

import com.liferay.portal.kernel.util.OrderByComparator;

public class AceItemTypeComparator   extends OrderByComparator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7661770948227654660L;

	public static String ORDER_BY_ASC = "datatype ASC";

	public static String ORDER_BY_DESC = "datatype DESC";
	
	private boolean _asc ;
	
	public AceItemTypeComparator(boolean orderBy) {
		_asc = orderBy;
		
	}

	
	public AceItemTypeComparator() {

		this(false);
	}

	public int compare(Object obj1, Object obj2) {
		AceItem aceitem1 = (AceItem) obj1;
		AceItem aceitem2 = (AceItem) obj2;

		int value = aceitem1.getDatatype().toLowerCase().compareTo(
				aceitem2.getDatatype().toLowerCase());
		
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
		return "AceItemTypeComparator " +_asc;
	}

}
