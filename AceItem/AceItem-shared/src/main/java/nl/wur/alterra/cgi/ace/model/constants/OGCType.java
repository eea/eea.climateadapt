package nl.wur.alterra.cgi.ace.model.constants;

import java.util.ArrayList;
import java.util.List;

/**
 * OGC Types.
 *
 * Must be kept in sync with the i18n section about this in Language.properties.
 *
 * @author heikki doeleman
 */
public enum OGCType {
    /**
     * WMS 1.0.0
     */
    WMS100,
    /**
     * WMS 1.1.1
     */
    WMS111,
    /**
     * WMS 1.3.0
     */
    WMS130;

    /**
     * Converts enum name to string value as used in GeoNetwork.
     *
     * @return
     */
    public String getString() {
        String value;
        switch(this) {
            case WMS100:
                value = "WMS1.0.0";
                break;
            case WMS111:
                value = "WMS1.1.1";
                break;
            case WMS130:
                value = "WMS1.3.0";
                break;
            default:
                value = "WMS1.1.1";
        }
        return value;
    }

    public static List<String> stringvalues() {
        List<String> strings = new ArrayList<String>();
        for (OGCType o : OGCType.values()) {
            strings.add(o.getString());
        }
        return strings;
    }

    /**
     * Converts to OGCType name() from its getString() representation.
     *
     * @param s
     * @return
     */
    public static String fromString(String s) {
        if(s.equals(OGCType.WMS100.getString())) {
            return OGCType.WMS100.name();
        } else if(s.equals(OGCType.WMS111.getString())) {
            return OGCType.WMS111.name();
        } else if(s.equals(OGCType.WMS130.getString())){
            return OGCType.WMS130.name();
        } else {
            return OGCType.WMS111.name();
        }
    }


}
