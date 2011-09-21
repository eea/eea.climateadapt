package nl.wur.alterra.cgi.ace;

import javax.portlet.PortletRequest;
import java.util.Enumeration;
import java.util.Map;

/**
 * Utilities for use in portlet implementations.
 *
 * @author heikki doeleman
 */
public class PortletUtils {

    /**
     * For debugging, logs request params.
     *
     * @param request request
     */
    public static void logParams(PortletRequest request) {
        Map<String, String[]> requestParams = request.getParameterMap();
        Enumeration<String> parameterNames = request.getParameterNames();
        while(parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            String[] values = requestParams.get(name);
            System.out.println("logging request parameter: " + name);
            for(String value : values) {
                System.out.println("'" + value + "'");
            }
        }
    }

}
