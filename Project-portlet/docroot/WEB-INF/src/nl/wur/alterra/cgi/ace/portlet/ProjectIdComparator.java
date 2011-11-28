package nl.wur.alterra.cgi.ace.portlet;

import nl.wur.alterra.cgi.ace.model.Project;

import com.liferay.portal.kernel.util.OrderByComparator;

public class ProjectIdComparator extends OrderByComparator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7654321680009074550L;

	public static String ORDER_BY_ASC = "projectId ASC";

	public static String ORDER_BY_DESC = "projectId DESC";
	
	private boolean _asc ;
	
	public ProjectIdComparator(boolean orderBy) {
		_asc = orderBy;
		
	}

	
	public ProjectIdComparator() {

		this(false);
	}

	public int compare(Object obj1, Object obj2) {
		Project project1 = (Project) obj1;
		Project project2 = (Project) obj2;

		int value = Integer.parseInt( "" + (project2.getProjectId() - project1.getProjectId()) );

		
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
		return "ProjectIdComparator " +_asc;
	}
}
