package nl.wur.alterra.cgi.ace.harvester;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 *
 * Executionservice for WxsHarvesters.
 *
 * @author heikki doeleman
 */
public class HarvesterExecutionService {

    private static ScheduledExecutorService executionService = Executors.newScheduledThreadPool(1);

    public static ScheduledExecutorService getExecutionService() {
        return executionService;
    }

}
