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

package nl.wur.alterra.cgi.ace.service;

import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The interface for the wxs harvester local service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link WxsHarvesterLocalServiceUtil} to access the wxs harvester local service. Add custom service methods to {@link nl.wur.alterra.cgi.ace.service.impl.WxsHarvesterLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author groot052
 * @see WxsHarvesterLocalServiceUtil
 * @see nl.wur.alterra.cgi.ace.service.base.WxsHarvesterLocalServiceBaseImpl
 * @see nl.wur.alterra.cgi.ace.service.impl.WxsHarvesterLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface WxsHarvesterLocalService {
	/**
	* Adds the wxs harvester to the database. Also notifies the appropriate model listeners.
	*
	* @param wxsHarvester the wxs harvester to add
	* @return the wxs harvester that was added
	* @throws SystemException if a system exception occurred
	*/
	public nl.wur.alterra.cgi.ace.model.WxsHarvester addWxsHarvester(
		nl.wur.alterra.cgi.ace.model.WxsHarvester wxsHarvester)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new wxs harvester with the primary key. Does not add the wxs harvester to the database.
	*
	* @param wxsharvesterid the primary key for the new wxs harvester
	* @return the new wxs harvester
	*/
	public nl.wur.alterra.cgi.ace.model.WxsHarvester createWxsHarvester(
		long wxsharvesterid);

	/**
	* Deletes the wxs harvester with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param wxsharvesterid the primary key of the wxs harvester to delete
	* @throws PortalException if a wxs harvester with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteWxsHarvester(long wxsharvesterid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the wxs harvester from the database. Also notifies the appropriate model listeners.
	*
	* @param wxsHarvester the wxs harvester to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteWxsHarvester(
		nl.wur.alterra.cgi.ace.model.WxsHarvester wxsHarvester)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the wxs harvester with the primary key.
	*
	* @param wxsharvesterid the primary key of the wxs harvester to get
	* @return the wxs harvester
	* @throws PortalException if a wxs harvester with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public nl.wur.alterra.cgi.ace.model.WxsHarvester getWxsHarvester(
		long wxsharvesterid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets a range of all the wxs harvesters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of wxs harvesters to return
	* @param end the upper bound of the range of wxs harvesters to return (not inclusive)
	* @return the range of wxs harvesters
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<nl.wur.alterra.cgi.ace.model.WxsHarvester> getWxsHarvesters(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the number of wxs harvesters.
	*
	* @return the number of wxs harvesters
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getWxsHarvestersCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the wxs harvester in the database. Also notifies the appropriate model listeners.
	*
	* @param wxsHarvester the wxs harvester to update
	* @return the wxs harvester that was updated
	* @throws SystemException if a system exception occurred
	*/
	public nl.wur.alterra.cgi.ace.model.WxsHarvester updateWxsHarvester(
		nl.wur.alterra.cgi.ace.model.WxsHarvester wxsHarvester)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the wxs harvester in the database. Also notifies the appropriate model listeners.
	*
	* @param wxsHarvester the wxs harvester to update
	* @param merge whether to merge the wxs harvester with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the wxs harvester that was updated
	* @throws SystemException if a system exception occurred
	*/
	public nl.wur.alterra.cgi.ace.model.WxsHarvester updateWxsHarvester(
		nl.wur.alterra.cgi.ace.model.WxsHarvester wxsHarvester, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	public nl.wur.alterra.cgi.ace.model.WxsHarvester createWxsHarvester();

	/**
	* Gets a list with all the WxsHarvesters in a group.
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<nl.wur.alterra.cgi.ace.model.WxsHarvester> getWxsHarvesterByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets a list with a range of WxsHarvesters from a group.
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<nl.wur.alterra.cgi.ace.model.WxsHarvester> getWxsHarvestersByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the number of WxsHarvesters in a group.
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getWxsHarvestersCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;
}