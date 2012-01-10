package nl.wur.alterra.cgi.ace.harvester;

import nl.wur.alterra.cgi.ace.model.WxsHarvester;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

/**
 * Map relating WxsHarvesters to their execution threads. It is used to be able to retrieve a execution thread related to
 * a WxsHarvester when it is deleted or updated, to cancel and remove the thread.
 *
 * @author heikki doeleman
 */
public class WxSHarvesterThreadMap {

    private Map<WxsHarvester, ScheduledFuture> harvesterScheduledFutureMap = new ConcurrentHashMap<WxsHarvester, ScheduledFuture>();

    public void add(WxsHarvester wxsHarvester, ScheduledFuture scheduledFuture) {
        harvesterScheduledFutureMap.put(wxsHarvester, scheduledFuture);
    }

    public boolean containsKey(Object key) {
        return harvesterScheduledFutureMap.containsKey(key);
    }

    public ScheduledFuture get(Object key) {
        return harvesterScheduledFutureMap.get(key);
    }

    public void remove(WxsHarvester wxsHarvester) {
        harvesterScheduledFutureMap.remove(wxsHarvester);
    }
    public int size() {
        return harvesterScheduledFutureMap.size();
    }

    //
    // singleton-ness
    //
    private WxSHarvesterThreadMap(){}
    private static WxSHarvesterThreadMap instance;
    public static synchronized WxSHarvesterThreadMap getInstance() {
        if(instance == null) {
            instance = new WxSHarvesterThreadMap();
        }
        return instance;
    }
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

}
