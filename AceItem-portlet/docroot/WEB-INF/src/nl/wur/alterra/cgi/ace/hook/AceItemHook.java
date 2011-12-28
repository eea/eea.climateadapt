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
        synchronized (this) {
            //System.out.println("AceItemHook start " + this.toString());
            if(CustomProperties.isInitialized()) {
                //System.out.println("AceItemHook already ran before, not doing it again. You probably have more than one company in your Liferay database.");
            }
            else {
                // makes custom properties globally available
                try {
                    CustomProperties.init();
                }
                catch (CustomPropertiesNotInitializedException x) {
                    throw new ActionException(x);
                }
                // schedules existing wxsharvesters
                HarvesterUtil.scheduleHarvesters();
                //System.out.println("AceItemHook end");
            }
        }
    }

}
