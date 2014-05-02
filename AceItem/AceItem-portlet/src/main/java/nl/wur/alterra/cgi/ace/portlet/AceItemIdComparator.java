package nl.wur.alterra.cgi.ace.portlet;

import nl.wur.alterra.cgi.ace.model.AceItem;

import com.liferay.portal.kernel.util.OrderByComparator;

public class AceItemIdComparator extends OrderByComparator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2201413584659074770L;

	public static String ORDER_BY_ASC = "aceItemId ASC";

	public static String ORDER_BY_DESC = "aceItemId DESC";
	
	private boolean _asc ;
	
	public AceItemIdComparator(boolean orderBy) {
		_asc = orderBy;
		
	}

	
	public AceItemIdComparator() {

		this(false);
	}

	public int compare(Object obj1, Object obj2) {
		AceItem aceitem1 = (AceItem) obj1;
		AceItem aceitem2 = (AceItem) obj2;

		int value = Integer.parseInt( "" + (aceitem2.getAceItemId() - aceitem1.getAceItemId()) );

		
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
		return "AceItemIdComparator " +_asc;
	}

}
