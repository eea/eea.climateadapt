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

import java.util.List;

import nl.wur.alterra.cgi.ace.model.AceItem;
import nl.wur.alterra.cgi.ace.model.AceItem;
import nl.wur.alterra.cgi.ace.service.base.AceItemLocalServiceBaseImpl;

/**
 * The implementation of the ace item local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link nl.wur.alterra.cgi.ace.service.AceItemLocalService} interface.
 * </p>
 *
 * <p>
 * Never reference this interface directly. Always use {@link nl.wur.alterra.cgi.ace.service.AceItemLocalServiceUtil} to access the ace item local service.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author groot052
 * @see nl.wur.alterra.cgi.ace.service.base.AceItemLocalServiceBaseImpl
 * @see nl.wur.alterra.cgi.ace.service.AceItemLocalServiceUtil
 */
public class AceItemLocalServiceImpl extends AceItemLocalServiceBaseImpl {
	/**
	 * Adds the AceItem to the database incrementing the primary key
	 *
	 */
	public AceItem addAceItem(AceItem aceitem) throws SystemException {
		long aceitemId = CounterLocalServiceUtil.increment(AceItem.class.getName());

		aceitem.setAceItemId(aceitemId);

		return super.addAceItem(aceitem);
	}
	
	/**
	 * 	
	 * Hugo de Groot: add these methods by hand to <portlet>LocalServiceImpl
	 * and rerun ServiceBuilder if auto generation fails 
	 * 
	 * Gets a list with all the AceItems in a group
	 *
	 */
	public List<AceItem> getAceItemsByGroupId(long groupId) throws SystemException {
		return aceItemPersistence.findByGroupId(groupId);
	}

	/**
	 * 	
	 * Hugo de Groot: add these methods by hand to <portlet>LocalServiceImpl
	 * and rerun ServiceBuilder if auto generation fails 
	 * 
	 * Gets a list with a range of AceItems from a group
	 *
	 */
	public List<AceItem> getAceItemsByGroupId(long groupId, int start, int end) throws SystemException {
		return aceItemPersistence.findByGroupId(groupId, start, end);
	}

	/**
	 * 	
	 * Hugo de Groot: add these methods by hand to <portlet>LocalServiceImpl
	 * and rerun ServiceBuilder if auto generation fails 
	 * 
	 * Gets the number of AceItems in a group
	 *
	 */
	public int getAceItemsCountByGroupId(long groupId) throws SystemException {
		return aceItemPersistence.countByGroupId(groupId);
	}
}