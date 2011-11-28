package nl.wur.alterra.cgi.ace.portlet;

import nl.wur.alterra.cgi.ace.model.Project;

import com.liferay.portal.kernel.util.OrderByComparator;

public class ProjectControlstatusComparator extends OrderByComparator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1101412281239072250L;

	public static String ORDER_BY_ASC = "controlstatus ASC";

	public static String ORDER_BY_DESC = "controlstatus DESC";
	
	private boolean _asc ;
	
	public ProjectControlstatusComparator(boolean orderBy) {
		_asc = orderBy;
		
	}

	
	public ProjectControlstatusComparator() {

		this(false);
	}

	public int compare(Object obj1, Object obj2) {
		Project project1 = (Project) obj1;
		Project project2 = (Project) obj2;

		int value = Integer.parseInt( "" + (project2.getControlstatus() - project1.getControlstatus()) );

		
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
		return "ProjectControlstatusComparator " +_asc;
	}
}
