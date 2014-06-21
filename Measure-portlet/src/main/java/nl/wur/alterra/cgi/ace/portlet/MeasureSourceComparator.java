package nl.wur.alterra.cgi.ace.portlet;

import nl.wur.alterra.cgi.ace.model.Measure;

import com.liferay.portal.kernel.util.OrderByComparator;

public class MeasureSourceComparator extends OrderByComparator {

    /**
     *
     */
    private static final long serialVersionUID = 5605553901794957485L;

    public static String ORDER_BY_ASC = "source ASC";

    public static String ORDER_BY_DESC = "source DESC";

    private boolean _asc ;

    public MeasureSourceComparator(boolean orderBy) {
        _asc = orderBy;

    }


    public MeasureSourceComparator() {
        this(false);
    }

    public int compare(Object obj1, Object obj2) {
        Measure measure1 = (Measure) obj1;
        Measure measure2 = (Measure) obj2;

        int value = measure1.getSource().toLowerCase().compareTo(
        measure2.getSource().toLowerCase());

        if (_asc) {

            return value;
        } else {

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
        return "MeasureSourceComparator " + _asc;
    }
}
