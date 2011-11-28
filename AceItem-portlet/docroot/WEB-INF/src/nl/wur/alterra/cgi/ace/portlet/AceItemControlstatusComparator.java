package nl.wur.alterra.cgi.ace.portlet;

import nl.wur.alterra.cgi.ace.model.AceItem;

import com.liferay.portal.kernel.util.OrderByComparator;

public class AceItemControlstatusComparator extends OrderByComparator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7901410004659074770L;

	public static String ORDER_BY_ASC = "controlstatus ASC";

	public static String ORDER_BY_DESC = "controlstatus DESC";
	
	private boolean _asc ;
	
	public AceItemControlstatusComparator(boolean orderBy) {
		_asc = orderBy;
		
	}

	
	public AceItemControlstatusComparator() {

		this(false);
	}

	public int compare(Object obj1, Object obj2) {
		AceItem aceitem1 = (AceItem) obj1;
		AceItem aceitem2 = (AceItem) obj2;

		int value = Integer.parseInt( "" + (aceitem2.getControlstatus() - aceitem1.getControlstatus()) );

		
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
		return "AceItemControlstatusComparator " +_asc;
	}

}
