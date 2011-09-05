package nl.wur.alterra.cgi.ace.harvester;

import com.liferay.portal.kernel.exception.SystemException;
import nl.wur.alterra.cgi.ace.model.WxsHarvester;
import nl.wur.alterra.cgi.ace.service.WxsHarvesterLocalServiceUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Utility to schedule and to run harvesters.
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
        System.out.println("scheduling harvester " + wxsHarvester.getName());
        ScheduledExecutorService executionService = HarvesterExecutionService.getExecutionService();
        ScheduledFuture<?> scheduledFuture = executionService.scheduleWithFixedDelay(new HarvesterThread(wxsHarvester),
                initialDelay, wxsHarvester.getEvery(), timeUnit);
        System.out.println("finished scheduling harvester " + wxsHarvester.getName());
        HarvesterThreads.getInstance().add(wxsHarvester, scheduledFuture);
        System.out.println("added harvester " + wxsHarvester.getName() + "to threads map");
    }

    /**
     * Retrieves existing harvesters from the database and schedules them.
     */
    public static synchronized void scheduleHarvesters() {
        System.out.println("scheduling harvesters");
        try {
            List<WxsHarvester> wxsHarvesters = new ArrayList<WxsHarvester>();
            wxsHarvesters.addAll(WxsHarvesterLocalServiceUtil.getWxsHarvesters(0, WxsHarvesterLocalServiceUtil.getWxsHarvestersCount()));
            System.out.println("scheduleHarvesters retrieved " + wxsHarvesters.size() + " harvesters to be scheduled");
            for(WxsHarvester wxsHarvester : wxsHarvesters) {
                HarvesterUtil.scheduleWxsHarvester(wxsHarvester);
            }
        }
        // do not block application startup if something goes wrong retrieving harvesters
        catch (SystemException x) {
            System.out.println("Error: failed to retrieve harvesters: "+ x.getMessage());
            x.printStackTrace();
        }
        catch(Throwable x) {
            System.out.println("Error: failed to retrieve harvesters: "+ x.getMessage());
            x.printStackTrace();
        }
        System.out.println("finished scheduling havesters");
    }

    /**
     * Executes a WxsHarvester.
     *
     * @param wxsHarvester
     */
    public static synchronized void executeWxsHarvester(WxsHarvester wxsHarvester) {
        System.out.println("executing harvester " + wxsHarvester.getName());
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

        System.out.println("finished executing harvester " + wxsHarvester.getName());


    }
}