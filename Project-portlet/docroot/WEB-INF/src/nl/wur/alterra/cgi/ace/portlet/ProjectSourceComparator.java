package nl.wur.alterra.cgi.ace.portlet;

import nl.wur.alterra.cgi.ace.model.Project;

import com.liferay.portal.kernel.util.OrderByComparator;

public class ProjectSourceComparator extends OrderByComparator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1234567901794957485L;

	public static String ORDER_BY_ASC = "source ASC";

	public static String ORDER_BY_DESC = "source DESC";
	
	private boolean _asc ;
	
	public ProjectSourceComparator(boolean orderBy) {
		_asc = orderBy;
			   
	}

	
	public ProjectSourceComparator() {
		this(false);
	}

	public int compare(Object obj1, Object obj2) {
		Project project1 = (Project) obj1;
		Project project2 = (Project) obj2;

		int value = project1.getSource().toLowerCase().compareTo(
		project2.getSource().toLowerCase());
			
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
		return "ProjectSourceComparator " + _asc;
	}
}
