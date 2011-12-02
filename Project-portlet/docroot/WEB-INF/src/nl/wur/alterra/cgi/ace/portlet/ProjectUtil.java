package nl.wur.alterra.cgi.ace.portlet;

import com.liferay.portal.kernel.util.OrderByComparator;

public class ProjectUtil {
/**
*
* @param orderByCol
* @param orderByType
* @return
*/

	public static OrderByComparator getProjectOrderByComparator(
	String orderByCol, String orderByType) {
	
		boolean orderByAsc = false;
		
		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}
		
		OrderByComparator orderByComparator = null;
		
		if (orderByCol.equals("projectId")) {
			
			orderByComparator = new ProjectIdComparator(orderByAsc);
		} 
	    else if (orderByCol.equals("acronym")) {
			// depends on project.getAcronym()
			orderByComparator = new ProjectAcronymComparator(orderByAsc);
		}
	    else if (orderByCol.equals("source")) {
			// depends on project.getSource()
			orderByComparator = new ProjectSourceComparator(orderByAsc);
		}
	    else if (orderByCol.equals("controlstatus")) {
			// depends on measure.getControlstatus()
			orderByComparator = new ProjectControlstatusComparator(orderByAsc);
		}
		
		return orderByComparator;
	}
}
