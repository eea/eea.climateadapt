package nl.wur.alterra.cgi.ace.harvester;

import nl.wur.alterra.cgi.ace.model.WxsHarvester;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

/**
 *
 * Map relating WxsHarvesters to their execution threads.
 *
 * @author heikki doeleman
 */
public class HarvesterThreads {

    private Map<WxsHarvester, ScheduledFuture> harvesterScheduledFutureMap = new ConcurrentHashMap<WxsHarvester, ScheduledFuture>();

    public void add(WxsHarvester wxsHarvester, ScheduledFuture scheduledFuture) {
        harvesterScheduledFutureMap.put(wxsHarvester, scheduledFuture);
    }
    public void remove(WxsHarvester wxsHarvester) {
        harvesterScheduledFutureMap.remove(wxsHarvester);
    }

    //
    // singleton-ness
    //
    private HarvesterThreads(){}
    private static HarvesterThreads instance;
    public static synchronized HarvesterThreads getInstance() {
        if(instance == null) {
            instance = new HarvesterThreads();
        }
        return instance;
    }
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

}
