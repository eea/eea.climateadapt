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
import nl.wur.alterra.cgi.ace.harvester.HarvesterUtil;
import nl.wur.alterra.cgi.ace.model.WxsHarvester;
import nl.wur.alterra.cgi.ace.model.impl.WxsHarvesterImpl;
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
	 * Adds the WxsHarvester to the database incrementing the primary key, adds the harvester to GeoNetwork, and
     * schedules a periodic run.
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
        try {
            System.out.println("adding harvester to GeoNetwork");
            GeoNetworkConnector geoNetworkConnector = new GeoNetworkConnector();
            wxsHarvester = geoNetworkConnector.addHarvester(wxsHarvester);
            wxsHarvester.setSavedToGeoNetwork(true);

        }
        // if it fails, still add it in ACE for later retry
        catch(Exception x) {
            wxsHarvester.setSavedToGeoNetwork(false);
            System.out.println("Error: failed to add harvester to GeoNetwork " + x.getMessage());
            x.printStackTrace();
        }

        //
        // add harvester in ACE
        //
        System.out.println("adding harvester to ACE");
		long wxsHarvesterId = CounterLocalServiceUtil.increment(WxsHarvester.class.getName());
		wxsHarvester.setWxsharvesterid(wxsHarvesterId);
        wxsHarvester = super.addWxsHarvester(wxsHarvester);
        System.out.println("finished adding harvester to ACE");

        //
        // schedule harvester for periodic runs
        //
        System.out.println("scheduling harvester thread");
        HarvesterUtil.scheduleWxsHarvester(wxsHarvester);
        System.out.println("finished scheduling harvester thread");

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