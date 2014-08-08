package nl.wur.alterra.cgi.ace.portlet;

import nl.wur.alterra.cgi.ace.model.AceItem;

import com.liferay.portal.kernel.util.OrderByComparator;

public class AceItemSourceComparator  extends OrderByComparator {

    /**
     *
     */
    private static final long serialVersionUID = 5501413581329074660L;

    public static String ORDER_BY_ASC = "source ASC";

    public static String ORDER_BY_DESC = "source DESC";

    private boolean _asc ;

    public AceItemSourceComparator(boolean orderBy) {
        _asc = orderBy;

    }


    public AceItemSourceComparator() {

        this(false);
    }

    public int compare(Object obj1, Object obj2) {
        AceItem aceitem1 = (AceItem) obj1;
        AceItem aceitem2 = (AceItem) obj2;

        int value = aceitem1.getSource().toLowerCase().compareTo(
                aceitem2.getSource().toLowerCase());

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
        return "AceItemSourceComparator " +_asc;
    }
}
