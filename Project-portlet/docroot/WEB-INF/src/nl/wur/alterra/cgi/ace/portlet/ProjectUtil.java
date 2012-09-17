package nl.wur.alterra.cgi.ace.portlet;

import org.apache.commons.lang.StringUtils;
import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * The portlet's utility methods.
 */
public class ProjectUtil {

    /** */
    public static final String DOTS = " ...";

    /**
     * Returns a projects comparator given the order-by column and the order-by type (i.e. asc or desc).
     *
     * @param orderByCol
     * @param orderByType
     * @return
     */
	public static OrderByComparator getProjectOrderByComparator(String orderByCol, String orderByType) {

		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equalsIgnoreCase("projectId")) {

			orderByComparator = new ProjectIdComparator(orderByAsc);
		}
	    else if (orderByCol.equalsIgnoreCase("acronym")) {
			// depends on project.getAcronym()
			orderByComparator = new ProjectAcronymComparator(orderByAsc);
		}
	    else if (orderByCol.equalsIgnoreCase("source")) {
			// depends on project.getSource()
			orderByComparator = new ProjectSourceComparator(orderByAsc);
		}
	    else if (orderByCol.equalsIgnoreCase("controlstatus")) {
			// depends on measure.getControlstatus()
			orderByComparator = new ProjectControlstatusComparator(orderByAsc);
		}

		return orderByComparator;
	}

	/**
	 *
	 * @param spatialLayer
	 * @param transRegionUrl
	 * @return
	 */
	public static boolean spatialLayerMatchesTransRegionUrl(String spatialLayer, String transRegionUrl){

	    if (StringUtils.isBlank(transRegionUrl) || StringUtils.isBlank(spatialLayer)){
	        return false;
	    }

	    transRegionUrl = StringUtils.substringBefore(transRegionUrl, "?");
	    String urlTrailer = StringUtils.substringAfterLast(transRegionUrl, "/");
	    String region = urlTrailer.replace('-', ' ').replace('_', ' ').toLowerCase();
	    region = StringUtils.deleteWhitespace(region);

	    spatialLayer = spatialLayer.replace('-', ' ').replace('_', ' ').toLowerCase();
	    spatialLayer = StringUtils.deleteWhitespace(spatialLayer);

	    return spatialLayer.contains(region);
    }

	/**
	 *
	 * @param str
	 * @param length
	 * @return
	 */
	public static String truncateWithDots(String str, int length){

	    if (str != null && str.length() > length){
	        return str.substring(0, length) + DOTS;
	    }
	    else{
	        return str;
	    }
	}
}
