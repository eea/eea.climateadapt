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
 * @author heikki doeleman
 * @see nl.wur.alterra.cgi.ace.service.base.WxsHarvesterLocalServiceBaseImpl
 * @see nl.wur.alterra.cgi.ace.service.WxsHarvesterLocalServiceUtil
 */
public class WxsHarvesterLocalServiceImpl extends WxsHarvesterLocalServiceBaseImpl {

    public WxsHarvester createWxsHarvester() {
        return new WxsHarvesterImpl();
    }

	/**
	 * Adds the WxsHarvester to the database incrementing the primary key, and adds it to the Lucene index.
	 *
     * @param wxsHarvester WxsHarvester to add
     * @return added WxsHarvester
     * @throws com.liferay.portal.kernel.exception.SystemException hmm
	 */
	public WxsHarvester addWxsHarvester(WxsHarvester wxsHarvester) throws SystemException {
		long wxsHarvesterId = CounterLocalServiceUtil.increment(WxsHarvester.class.getName());
		wxsHarvester.setWxsharvesterid(wxsHarvesterId);
        wxsHarvester = super.addWxsHarvester(wxsHarvester);
       // try {
       //     AceItemIndexer indexer = new AceItemIndexer();
       //     indexer.add(aceitem);
       // }
       // catch (ACELuceneException x) {
       //     System.out.println(x.getMessage());
       //     x.printStackTrace();
       //     throw new SystemException(x.getMessage(), x);
       // }
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