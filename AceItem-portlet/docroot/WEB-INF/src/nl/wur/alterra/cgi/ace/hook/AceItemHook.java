package nl.wur.alterra.cgi.ace.hook;

import com.liferay.portal.kernel.events.ActionException;
import nl.wur.alterra.cgi.ace.harvester.HarvesterUtil;
import nl.wur.alterra.cgi.ace.portlet.CustomProperties;
import nl.wur.alterra.cgi.ace.portlet.CustomPropertiesNotInitializedException;

/**
 * Liferay hook for application startup.
 *
 * @author heikki doeleman
 */
public class AceItemHook extends com.liferay.portal.kernel.events.SimpleAction {

    /**
     * Schedules existing harvesters at application startup.
     *
     * @param ids
     * @throws ActionException
     */
    @Override
    public void run(String[] ids) throws ActionException {
        System.out.println("AceItemHook start");
        // makes custom properties globally available
        try {
            CustomProperties.init();
        }
        catch (CustomPropertiesNotInitializedException x) {
            throw new ActionException(x);
        }
        // schedules existing wxsharvesters
        HarvesterUtil.scheduleHarvesters();
        System.out.println("AceItemHook end");
    }

}
