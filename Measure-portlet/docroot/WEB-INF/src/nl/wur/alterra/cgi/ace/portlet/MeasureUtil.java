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
		
		if (orderByCol.equalsIgnoreCase("measureId")) {
			
			orderByComparator = new MeasureIdComparator(orderByAsc);
		} 
	    else if (orderByCol.equalsIgnoreCase("name")) {
			// depends on measure.getName()
			orderByComparator = new MeasureNameComparator(orderByAsc);
		}
	    else if (orderByCol.equalsIgnoreCase("source")) {
			// depends on measure.getSource()
			orderByComparator = new MeasureSourceComparator(orderByAsc);
		}
	    else if (orderByCol.equalsIgnoreCase("type")) {
			// depends on measure.getMao_type()
			orderByComparator = new MeasureTypeComparator(orderByAsc);
		}
	    else if (orderByCol.equalsIgnoreCase("controlstatus")) {
			// depends on measure.getControlstatus()
			orderByComparator = new MeasureControlstatusComparator(orderByAsc);
		}
		
		return orderByComparator;
	}
}
