/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package nl.wur.alterra.cgi.ace.service.impl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import nl.wur.alterra.cgi.ace.geonetwork.GeoNetworkCSWHarvesterResponse;
import nl.wur.alterra.cgi.ace.geonetwork.GeoNetworkConnector;
import nl.wur.alterra.cgi.ace.harvester.HarvesterUtil;
import nl.wur.alterra.cgi.ace.model.AceItem;
import nl.wur.alterra.cgi.ace.model.CSWHarvester;
import nl.wur.alterra.cgi.ace.model.constants.HarvesterStatus;
import nl.wur.alterra.cgi.ace.model.impl.CSWHarvesterImpl;
import nl.wur.alterra.cgi.ace.search.lucene.ACEIndexSynchronizer;
import nl.wur.alterra.cgi.ace.service.AceItemLocalServiceUtil;
import nl.wur.alterra.cgi.ace.service.base.CSWHarvesterLocalServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the c s w harvester local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link nl.wur.alterra.cgi.ace.service.CSWHarvesterLocalService} interface.
 * </p>
 *
 * <p>
 * Never reference this interface directly. Always use {@link nl.wur.alterra.cgi.ace.service.CSWHarvesterLocalServiceUtil} to access the c s w harvester local service.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author groot052
 * @see nl.wur.alterra.cgi.ace.service.base.CSWHarvesterLocalServiceBaseImpl
 * @see nl.wur.alterra.cgi.ace.service.CSWHarvesterLocalServiceUtil
 */
public class CSWHarvesterLocalServiceImpl extends CSWHarvesterLocalServiceBaseImpl {

    /**
     * Creates empty CSWHarvester.
     *
     * @return cswharvester
     */
    public CSWHarvester createCSWHarvester() {
        return new CSWHarvesterImpl();
    }

    /**
     * Updates a CSWHarvester. Also tries to update in GeoNetwork if asked to do so. Sets status to GEONETWORK_UPDATE_FAILURE
     * if GeoNetwork update fails; sets it to NEVER_RUN if status was not already SUCCESS. Removes existing scheduler and
     * creates a new one if asked to do so.
     *
     * @param cswHarvester
     * @param propagateToGeoNetwork
     * @param reschedule
     * @return
     * @throws com.liferay.portal.kernel.exception.SystemException
     */
    public CSWHarvester updateCSWHarvester(CSWHarvester cswHarvester, Boolean propagateToGeoNetwork, Boolean reschedule) throws SystemException {
        //System.out.println("updating harvester");
        //
        // update harvester in geonetwork
        //
        if(propagateToGeoNetwork) {
            //System.out.println("updating harvester to GeoNetwork");
            GeoNetworkConnector geoNetworkConnector = new GeoNetworkConnector();
            GeoNetworkCSWHarvesterResponse geoNetworkHarvesterResponse = geoNetworkConnector.updateCSWHarvester(cswHarvester);
            cswHarvester = geoNetworkHarvesterResponse.getCSWHarvester();
            if(cswHarvester.getStatus().equals(HarvesterStatus.GEONETWORK_UPDATE_FAILURE.name())) {
                System.out.println("ERROR: failed to update harvester " + cswHarvester.toShortString() + " to GeoNetwork");
            }
            else {
                //System.out.println("succesfully updated harvester " + cswHarvester.toShortString() + " to GeoNetwork");
                cswHarvester.setSavedToGeoNetwork(true);
            }
        }

        //
        // update harvester in ACE
        //
        //System.out.println("updating harvester " + cswHarvester.toShortString() + " to ACE, status is: " + cswHarvester.getStatus());
        // if status is SUCCESS (earlier run was succesful) leave it as is; otherwise set to NEVER_RUN
        //if(!(cswHarvester.getStatus().equals(HarvesterStatus.SUCCESS.name()) ||  cswHarvester.getStatus().equals(HarvesterStatus.RUNNING.name()))) {
        //    System.out.println("setting status to NEVER_RUN, was " + cswHarvester.getStatus());
        //    cswHarvester.setStatus(HarvesterStatus.NEVER_RUN.name());
        //}
        cswHarvester = super.updateCSWHarvester(cswHarvester);
        //System.out.println("finished updating harvester " + cswHarvester.toShortString() + " to ACE");

        if(reschedule) {
            //
            // schedule harvester for periodic runs
            //
            //System.out.println("scheduling harvester thread");
            HarvesterUtil.scheduleCSWHarvester(cswHarvester);
            //System.out.println("finished scheduling harvester thread");
        }
        return cswHarvester;
    }

    /**
     * Deletes a CSWHarvester. Also tries to delete it in GeoNetwork, but if that fails it is deleted from ACE anyway. Its
     * scheduled harvester thread is canceled and removed and any aceitems produced by this harvester are deleted from ACE.
     *
     * @param cswHarvester the csw harvester to delete
     * @throws SystemException
     */
    @Override
    public nl.wur.alterra.cgi.ace.model.CSWHarvester deleteCSWHarvester(CSWHarvester cswHarvester) throws SystemException {
        //
        // delete harvester in geonetwork
        //
        //System.out.println("deleting harvester from GeoNetwork");
        GeoNetworkConnector geoNetworkConnector = new GeoNetworkConnector();
        GeoNetworkCSWHarvesterResponse geoNetworkHarvesterResponse = geoNetworkConnector.deleteCSWHarvester(cswHarvester);
        if(geoNetworkHarvesterResponse.getCSWHarvester().getStatus().equals(HarvesterStatus.GEONETWORK_DELETE_FAILURE.name())) {
            cswHarvester.setSavedToGeoNetwork(true);
            cswHarvester.setStatus(HarvesterStatus.GEONETWORK_DELETE_FAILURE.name());
            System.out.println("ERROR: failed to delete harvester " + cswHarvester.toShortString() + " from GeoNetwork");
        }
        else {
            //System.out.println("succesfully deleted harvester " + cswHarvester.toShortString() + " from GeoNetwork");
        }

        //
        // cancel harvester thread
        //
        //System.out.println("canceling thread for harvester " + cswHarvester.toShortString());
        HarvesterUtil.unScheduleCSWHarvester(cswHarvester);

        //
        // delete harvester in ACE
        //
        //System.out.println("deleting harvester " + cswHarvester.toShortString() + " from ACE");
        nl.wur.alterra.cgi.ace.model.CSWHarvester harvester = super.deleteCSWHarvester(cswHarvester);

        //
        // delete AceItems created from metadata from this harvester
        //
        List<AceItem> aceItemsToDelete = AceItemLocalServiceUtil.getAceItemsByCSWharvesterId(cswHarvester.getCswharvesterid());
        //System.out.println("found # " + aceItemsToDelete.size() + " aceitems to delete");
        for(AceItem aceItem : aceItemsToDelete) {
            new ACEIndexSynchronizer().delete(aceItem);
            AceItemLocalServiceUtil.deleteAceItem(aceItem);
        }
        //System.out.println("succesfully deleted aceitems for harvester " + cswHarvester.toShortString());
        return harvester;
    }

    /**
     * Adds a cswharvester, also trying to add it to GeoNetwork, and schedules a periodic run. Sets status to
     * GEONETWORK_INSERT_FAILURE if it failed to add it to GeoNetwork, otherwise to NEVER_RUN.
     *
     * @param cswHarvester CSWHarvester to add
     * @return added CSWHarvester
     * @throws com.liferay.portal.kernel.exception.SystemException hmm
     */
    @Override
    public CSWHarvester addCSWHarvester(CSWHarvester cswHarvester) throws SystemException {

        //
        // add harvester in geonetwork
        //
        //System.out.println("adding harvester to GeoNetwork");
        GeoNetworkConnector geoNetworkConnector = new GeoNetworkConnector();
        GeoNetworkCSWHarvesterResponse geoNetworkHarvesterResponse = geoNetworkConnector.addCSWHarvester(cswHarvester);
        cswHarvester = geoNetworkHarvesterResponse.getCSWHarvester();
        if(cswHarvester.getStatus().equals(HarvesterStatus.GEONETWORK_INSERT_FAILURE.name())) {
            System.out.println("ERROR adding harvester " + cswHarvester.toShortString() + " to GeoNetwork, status: " + cswHarvester.getStatus());
            cswHarvester.setSavedToGeoNetwork(false);
        }
        else {
            //System.out.println("succesfully added harvester " + cswHarvester.toShortString() + " to GeoNetwork");
            cswHarvester.setSavedToGeoNetwork(true);
            cswHarvester.setStatus(HarvesterStatus.NEVER_RUN.name());
        }

        //
        // add harvester in ACE
        //
        //System.out.println("adding harvester " + cswHarvester.toShortString() + " to ACE");
        long cswHarvesterId = CounterLocalServiceUtil.increment(CSWHarvester.class.getName());
        cswHarvester.setCswharvesterid(cswHarvesterId);
        cswHarvester = super.addCSWHarvester(cswHarvester);
        //System.out.println("finished adding harvester " + cswHarvester.toShortString() + " to ACE");

        //
        // schedule harvester for periodic runs
        //
        //System.out.println("scheduling harvester thread");
        HarvesterUtil.scheduleCSWHarvester(cswHarvester);
        //System.out.println("finished scheduling harvester thread");

        return cswHarvester;
    }


    /**
     *
     * Gets a list with all the CSWHarvesters in a group.
     *
     */
    public List<CSWHarvester> getCSWHarvesterByGroupId(long groupId) throws SystemException {
        return cswHarvesterPersistence.findByGroupId(groupId);
    }

    /**
     *
     * Gets a list with a range of CSWHarvesters from a group.
     *
     */
    public List<CSWHarvester> getCSWHarvestersByGroupId(long groupId, int start, int end) throws SystemException {
        return cswHarvesterPersistence.findByGroupId(groupId, start, end);
    }

    /**
     *
     * Gets the number of CSWHarvesters in a group.
     *
     */
    public int getCSWHarvestersCountByGroupId(long groupId) throws SystemException {
        return cswHarvesterPersistence.countByGroupId(groupId);
    }

}
