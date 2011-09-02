package nl.wur.alterra.cgi.ace.harvester;

import com.liferay.portal.kernel.exception.SystemException;
import nl.wur.alterra.cgi.ace.model.WxsHarvester;
import nl.wur.alterra.cgi.ace.service.persistence.WxsHarvesterUtil;

import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author heikki doeleman
 */
public class HarvesterUtil {

    private static long initialDelay = 0;
    private static TimeUnit timeUnit = TimeUnit.MINUTES;


    /**
     * Schedules a thread to periodically execute a harvester.
     * @param wxsHarvester
     */
    public static synchronized void scheduleWxsHarvester(WxsHarvester wxsHarvester) {
        System.out.println("HarvesterUtil scheduling harvester " + wxsHarvester.getName());
        ScheduledExecutorService executionService = HarvesterExecutionService.getExecutionService();
        ScheduledFuture<?> scheduledFuture = executionService.scheduleWithFixedDelay(new HarvesterThread(wxsHarvester),
                initialDelay, wxsHarvester.getEvery(), timeUnit);
        System.out.println("HarvesterUtil finished scheduling harvester " + wxsHarvester.getName());
        HarvesterThreads.getInstance().add(wxsHarvester, scheduledFuture);
        System.out.println("HarvesterUtil added harvester " + wxsHarvester.getName() + "to threads map");
    }

    /**
     * Retrieves existing harvesters from the database and schedules them.
     */
    public static synchronized void scheduleHarvesters() {
        System.out.println("scheduling harvesters");
        try {
            List<WxsHarvester> wxsHarvesters = WxsHarvesterUtil.findAll();
            for(WxsHarvester wxsHarvester : wxsHarvesters) {
                System.out.println("scheduling harvester " + wxsHarvester.getName());
                HarvesterUtil.scheduleWxsHarvester(wxsHarvester);
            }
        }
        // do not block application startup if something goes wrong retrieving harvesters
        catch (SystemException x) {
            System.out.println("Error: failed to retrieve harvesters"+x.getMessage());
            x.printStackTrace();
        }
        catch(Throwable x) {
            System.out.println("Error: failed to retrieve harvesters"+x.getMessage());
            x.printStackTrace();
        }
        System.out.println("finished scheduling havesters");
    }

    public static synchronized void executeWxsHarvester(WxsHarvester wxsHarvester) {
        System.out.println("HarvesterUtil executing harvester " + wxsHarvester.getName());
        //
        // invoke WxSHarvester run in GeoNetwork
        //

        // harvester was not saved to GeoNetwork
        if(! wxsHarvester.isSavedToGeoNetwork()) {
            System.out.println("harvester " + wxsHarvester.getName() + " was not saved to GeoNetwork");
            // TODO what to do? attempt to add it to GeoNetwork?
        }

        //
        // keep polling GeoNetwork to know when GeoNetwork harvester has finished
        //

        boolean geoNetworkHarvestingRunFinished = false;


        //
        // retrieve results of this harvester from GeoNetwork
        //



        //
        // convert to AceItems and save
        //

        System.out.println("HarvesterUtil finished executing harvester " + wxsHarvester.getName());


    }
}