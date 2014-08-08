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
import nl.wur.alterra.cgi.ace.geonetwork.GeoNetworkConnector;
import nl.wur.alterra.cgi.ace.geonetwork.GeoNetworkWxSHarvesterResponse;
import nl.wur.alterra.cgi.ace.harvester.HarvesterUtil;
import nl.wur.alterra.cgi.ace.model.AceItem;
import nl.wur.alterra.cgi.ace.model.WxsHarvester;
import nl.wur.alterra.cgi.ace.model.constants.HarvesterStatus;
import nl.wur.alterra.cgi.ace.model.impl.WxsHarvesterImpl;
import nl.wur.alterra.cgi.ace.search.lucene.ACEIndexSynchronizer;
import nl.wur.alterra.cgi.ace.service.AceItemLocalServiceUtil;
import nl.wur.alterra.cgi.ace.service.base.WxsHarvesterLocalServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the wxs harvester local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link nl.wur.alterra.cgi.ace.service.WxsHarvesterLocalService} interface.
 * </p>
 *
 * <p>
 * Never reference this interface directly. Always use {@link nl.wur.alterra.cgi.ace.service.WxsHarvesterLocalServiceUtil} to access the wxs harvester local service.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @see nl.wur.alterra.cgi.ace.service.base.WxsHarvesterLocalServiceBaseImpl
 * @see nl.wur.alterra.cgi.ace.service.WxsHarvesterLocalServiceUtil
 *
 * @author heikki doeleman
 *
 */
public class WxsHarvesterLocalServiceImpl extends WxsHarvesterLocalServiceBaseImpl {

    /**
     * Creates empty WxsHarvester.
     *
     * @return wxsharvester
     */
    public WxsHarvester createWxsHarvester() {
        return new WxsHarvesterImpl();
    }

    /**
     * Updates a WxsHarvester. Also tries to update in GeoNetwork if asked to do so. Sets status to GEONETWORK_UPDATE_FAILURE
     * if GeoNetwork update fails; sets it to NEVER_RUN if status was not already SUCCESS. Removes existing scheduler and
     * creates a new one if asked to do so.
     *
     * @param wxsHarvester
     * @param propagateToGeoNetwork
     * @param reschedule
     * @return
     * @throws SystemException
     */
    public WxsHarvester updateWxsHarvester(WxsHarvester wxsHarvester, Boolean propagateToGeoNetwork, Boolean reschedule) throws SystemException {
        //System.out.println("updating harvester");
        //
        // update harvester in geonetwork
        //
        if(propagateToGeoNetwork) {
            //System.out.println("updating harvester to GeoNetwork");
            GeoNetworkConnector geoNetworkConnector = new GeoNetworkConnector();
            GeoNetworkWxSHarvesterResponse geoNetworkHarvesterResponse = geoNetworkConnector.updateWxSHarvester(wxsHarvester);
            wxsHarvester = geoNetworkHarvesterResponse.getWxsHarvester();
            if(wxsHarvester.getStatus().equals(HarvesterStatus.GEONETWORK_UPDATE_FAILURE.name())) {
                System.out.println("ERROR: failed to update harvester " + wxsHarvester.toShortString() + " to GeoNetwork");
            }
            else {
                //System.out.println("succesfully updated harvester " + wxsHarvester.toShortString() + " to GeoNetwork");
                wxsHarvester.setSavedToGeoNetwork(true);
            }
        }

        //
        // update harvester in ACE
        //
        //System.out.println("updating harvester " + wxsHarvester.toShortString() + " to ACE, status is: " + wxsHarvester.getStatus());
        // if status is SUCCESS (earlier run was succesful) leave it as is; otherwise set to NEVER_RUN
        //if(!(wxsHarvester.getStatus().equals(HarvesterStatus.SUCCESS.name()) ||  wxsHarvester.getStatus().equals(HarvesterStatus.RUNNING.name()))) {
        //    System.out.println("setting status to NEVER_RUN, was " + wxsHarvester.getStatus());
        //    wxsHarvester.setStatus(HarvesterStatus.NEVER_RUN.name());
        //}
        wxsHarvester = super.updateWxsHarvester(wxsHarvester);
        //System.out.println("finished updating harvester " + wxsHarvester.toShortString() + " to ACE");

        if(reschedule) {
            //
            // schedule harvester for periodic runs
            //
            //System.out.println("scheduling harvester thread");
            HarvesterUtil.scheduleWxsHarvester(wxsHarvester);
            //System.out.println("finished scheduling harvester thread");
        }
        return wxsHarvester;
    }

    /**
     * Deletes a WxsHarvester. Also tries to delete it in GeoNetwork, but if that fails it is deleted from ACE anyway. Its
     * scheduled harvester thread is canceled and removed and any aceitems produced by this harvester are deleted from ACE.
     *
     * @param wxsHarvester the wxs harvester to delete
     * @throws SystemException
     */
    @Override
    public nl.wur.alterra.cgi.ace.model.WxsHarvester deleteWxsHarvester(WxsHarvester wxsHarvester) throws SystemException {
        //
        // delete harvester in geonetwork
        //
        //System.out.println("deleting harvester from GeoNetwork");
        GeoNetworkConnector geoNetworkConnector = new GeoNetworkConnector();
        GeoNetworkWxSHarvesterResponse geoNetworkHarvesterResponse = geoNetworkConnector.deleteWxSHarvester(wxsHarvester);
        if(geoNetworkHarvesterResponse.getWxsHarvester().getStatus().equals(HarvesterStatus.GEONETWORK_DELETE_FAILURE.name())) {
            wxsHarvester.setSavedToGeoNetwork(true);
            wxsHarvester.setStatus(HarvesterStatus.GEONETWORK_DELETE_FAILURE.name());
            System.out.println("ERROR: failed to delete harvester " + wxsHarvester.toShortString() + " from GeoNetwork");
        }
        else {
            //System.out.println("succesfully deleted harvester " + wxsHarvester.toShortString() + " from GeoNetwork");
        }

        //
        // cancel harvester thread
        //
        //System.out.println("canceling thread for harvester " + wxsHarvester.toShortString());
        HarvesterUtil.unScheduleWxsHarvester(wxsHarvester);

        //
        // delete harvester in ACE
        //
        //System.out.println("deleting harvester " + wxsHarvester.toShortString() + " from ACE");
        nl.wur.alterra.cgi.ace.model.WxsHarvester harvester = super.deleteWxsHarvester(wxsHarvester);

        //
        // delete AceItems created from metadata from this harvester
        //
        List<AceItem> aceItemsToDelete = AceItemLocalServiceUtil.getAceItemsByWxsharvesterId(wxsHarvester.getWxsharvesterid());
        //System.out.println("found # " + aceItemsToDelete.size() + " aceitems to delete");
        for(AceItem aceItem : aceItemsToDelete) {
            new ACEIndexSynchronizer().delete(aceItem);
            AceItemLocalServiceUtil.deleteAceItem(aceItem);
        }
        //System.out.println("succesfully deleted aceitems for harvester " + wxsHarvester.toShortString());
        return harvester;
    }


    /**
     * Adds a wxsharvester, also trying to add it to GeoNetwork, and schedules a periodic run. Sets status to
     * GEONETWORK_INSERT_FAILURE if it failed to add it to GeoNetwork, otherwise to NEVER_RUN.
     *
     * @param wxsHarvester WxsHarvester to add
     * @return added WxsHarvester
     * @throws com.liferay.portal.kernel.exception.SystemException hmm
     */
    @Override
    public WxsHarvester addWxsHarvester(WxsHarvester wxsHarvester) throws SystemException {

        //
        // add harvester in geonetwork
        //
        //System.out.println("adding harvester to GeoNetwork");
        GeoNetworkConnector geoNetworkConnector = new GeoNetworkConnector();
        GeoNetworkWxSHarvesterResponse geoNetworkHarvesterResponse = geoNetworkConnector.addWxSHarvester(wxsHarvester);
        wxsHarvester = geoNetworkHarvesterResponse.getWxsHarvester();
        if(wxsHarvester.getStatus().equals(HarvesterStatus.GEONETWORK_INSERT_FAILURE.name())) {
            System.out.println("ERROR adding harvester " + wxsHarvester.toShortString() + " to GeoNetwork, status: " + wxsHarvester.getStatus());
            wxsHarvester.setSavedToGeoNetwork(false);
        }
        else {
            //System.out.println("succesfully added harvester " + wxsHarvester.toShortString() + " to GeoNetwork");
            wxsHarvester.setSavedToGeoNetwork(true);
            wxsHarvester.setStatus(HarvesterStatus.NEVER_RUN.name());
        }

        //
        // add harvester in ACE
        //
        //System.out.println("adding harvester " + wxsHarvester.toShortString() + " to ACE");
        long wxsHarvesterId = CounterLocalServiceUtil.increment(WxsHarvester.class.getName());
        wxsHarvester.setWxsharvesterid(wxsHarvesterId);
        wxsHarvester = super.addWxsHarvester(wxsHarvester);
        //System.out.println("finished adding harvester " + wxsHarvester.toShortString() + " to ACE");

        //
        // schedule harvester for periodic runs
        //
        //System.out.println("scheduling harvester thread");
        HarvesterUtil.scheduleWxsHarvester(wxsHarvester);
        //System.out.println("finished scheduling harvester thread");

        return wxsHarvester;
    }


    /**
     *
     * Gets a list with all the WxsHarvesters in a group.
     *
     */
    public List<WxsHarvester> getWxsHarvesterByGroupId(long groupId) throws SystemException {
        return wxsHarvesterPersistence.findByGroupId(groupId);
    }

    /**
     *
     * Gets a list with a range of WxsHarvesters from a group.
     *
     */
    public List<WxsHarvester> getWxsHarvestersByGroupId(long groupId, int start, int end) throws SystemException {
        return wxsHarvesterPersistence.findByGroupId(groupId, start, end);
    }

    /**
     *
     * Gets the number of WxsHarvesters in a group.
     *
     */
    public int getWxsHarvestersCountByGroupId(long groupId) throws SystemException {
        return wxsHarvesterPersistence.countByGroupId(groupId);
    }

}
