package nl.wur.alterra.cgi.ace.harvester;

import nl.wur.alterra.cgi.ace.model.CSWHarvester;
import nl.wur.alterra.cgi.ace.model.WxsHarvester;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

/**
 * Map relating CSWHarvesters to their execution threads. It is used to be able to retrieve a execution thread related to
 * a CSWHarvester when it is deleted or updated, to cancel and remove the thread.
 *
 * @author heikki doeleman
 */
public class CSWHarvesterThreadMap {

    private Map<CSWHarvester, ScheduledFuture> harvesterScheduledFutureMap = new ConcurrentHashMap<CSWHarvester, ScheduledFuture>();

    public void add(CSWHarvester cswHarvester, ScheduledFuture scheduledFuture) {
        harvesterScheduledFutureMap.put(cswHarvester, scheduledFuture);
    }

    public boolean containsKey(Object key) {
        return harvesterScheduledFutureMap.containsKey(key);
    }

    public ScheduledFuture get(Object key) {
        return harvesterScheduledFutureMap.get(key);
    }

    public void remove(CSWHarvester cswHarvester) {
        harvesterScheduledFutureMap.remove(cswHarvester);
    }
    public int size() {
        return harvesterScheduledFutureMap.size();
    }

    //
    // singleton-ness
    //
    private CSWHarvesterThreadMap(){}
    private static CSWHarvesterThreadMap instance;
    public static synchronized CSWHarvesterThreadMap getInstance() {
        if(instance == null) {
            instance = new CSWHarvesterThreadMap();
        }
        return instance;
    }
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

}