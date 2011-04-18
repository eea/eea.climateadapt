package nl.wur.alterra.cgi.ace.portlet;

import com.liferay.portal.kernel.util.OrderByComparator;

public class MeasureUtil {
/**
*
* @param orderByCol
* @param orderByType
* @return
*/

	public static OrderByComparator getMeasureOrderByComparator(
	String orderByCol, String orderByType) {
	
		boolean orderByAsc = false;
		
		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}
		
		OrderByComparator orderByComparator = null;
		
		if (orderByCol.equals("measureId")) {
			
			orderByComparator = new MeasureIdComparator(orderByAsc);
			System.out.println(orderByComparator.toString());
		} 
	    else if (orderByCol.equals("name")) {
			// depends on measure.getName()
			orderByComparator = new MeasureNameComparator(orderByAsc);
			
			System.out.println(orderByComparator.toString());
		}
		
		return orderByComparator;
	}
}
