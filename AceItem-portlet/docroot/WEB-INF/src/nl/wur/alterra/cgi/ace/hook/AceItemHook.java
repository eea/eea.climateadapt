package nl.wur.alterra.cgi.ace.hook;

import com.liferay.portal.kernel.events.ActionException;
import nl.wur.alterra.cgi.ace.harvester.HarvesterUtil;

/**
 * Liferay hook for application startup.
 *
 * @author heikki doeleman
 */
public class AceItemHook extends com.liferay.portal.kernel.events.SimpleAction {

    /**
     * Schedules existing harvesters at application startup.
     *
     * @param strings
     * @throws ActionException
     */
    @Override
    public void run(String[] strings) throws ActionException {
        System.out.println("AceItemHook start");
        HarvesterUtil.scheduleHarvesters();
        System.out.println("AceItemHook end");
    }

}
