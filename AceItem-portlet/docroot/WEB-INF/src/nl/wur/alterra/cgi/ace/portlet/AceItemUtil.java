package nl.wur.alterra.cgi.ace.portlet;

import com.liferay.portal.kernel.util.OrderByComparator;

public class AceItemUtil {
	/**
	*
	* @param orderByCol
	* @param orderByType
	* @return
	*/

		public static OrderByComparator getAceItemOrderByComparator(
		String orderByCol, String orderByType) {
		
			boolean orderByAsc = false;
			
			if (orderByType.equals("asc")) {
				orderByAsc = true;
			}
			
			OrderByComparator orderByComparator = null;
			
			if (orderByCol.equals("aceItemId")) {
				
				orderByComparator = new AceItemIdComparator(orderByAsc);
			} 
		    else if (orderByCol.equals("name")) {
				// depends on aceitem.getName()
				orderByComparator = new AceItemNameComparator(orderByAsc);
			}
		    else if (orderByCol.equals("source")) {
				// depends on aceitem.getSource()
				orderByComparator = new AceItemSourceComparator(orderByAsc);
			}
		    else if (orderByCol.equals("datatype")) {
				// depends on aceitem.getDatatype()
				orderByComparator = new AceItemTypeComparator(orderByAsc);
			}
		    else if (orderByCol.equals("controlstatus")) {
				// depends on measure.getControlstatus()
				orderByComparator = new AceItemControlstatusComparator(orderByAsc);
			}
			
			return orderByComparator;
		}
}
