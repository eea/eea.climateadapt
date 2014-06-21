package nl.wur.alterra.cgi.ace.portlet;

import nl.wur.alterra.cgi.ace.model.Measure;

import com.liferay.portal.kernel.util.OrderByComparator;

public class MeasureControlstatusComparator extends OrderByComparator {

    /**
     *
     */
    private static final long serialVersionUID = 1101413681239074550L;

    public static String ORDER_BY_ASC = "controlstatus ASC";

    public static String ORDER_BY_DESC = "controlstatus DESC";

    private boolean _asc ;

    public MeasureControlstatusComparator(boolean orderBy) {
        _asc = orderBy;

    }


    public MeasureControlstatusComparator() {

        this(false);
    }

    public int compare(Object obj1, Object obj2) {
        Measure measure1 = (Measure) obj1;
        Measure measure2 = (Measure) obj2;

        int value = Integer.parseInt( "" + (measure2.getControlstatus() - measure1.getControlstatus()) );


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
        return "MeasureControlstatusComparator " +_asc;
    }
}
