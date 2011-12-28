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
 * The interface for the ace item local service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link AceItemLocalServiceUtil} to access the ace item local service. Add custom service methods to {@link nl.wur.alterra.cgi.ace.service.impl.AceItemLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author groot052
 * @see AceItemLocalServiceUtil
 * @see nl.wur.alterra.cgi.ace.service.base.AceItemLocalServiceBaseImpl
 * @see nl.wur.alterra.cgi.ace.service.impl.AceItemLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface AceItemLocalService {
	/**
	* Adds the ace item to the database. Also notifies the appropriate model listeners.
	*
	* @param aceItem the ace item to add
	* @return the ace item that was added
	* @throws SystemException if a system exception occurred
	*/
	public nl.wur.alterra.cgi.ace.model.AceItem addAceItem(
		nl.wur.alterra.cgi.ace.model.AceItem aceItem)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new ace item with the primary key. Does not add the ace item to the database.
	*
	* @param aceItemId the primary key for the new ace item
	* @return the new ace item
	*/
	public nl.wur.alterra.cgi.ace.model.AceItem createAceItem(long aceItemId);

	/**
	* Deletes the ace item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param aceItemId the primary key of the ace item to delete
	* @throws PortalException if a ace item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteAceItem(long aceItemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the ace item from the database. Also notifies the appropriate model listeners.
	*
	* @param aceItem the ace item to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteAceItem(nl.wur.alterra.cgi.ace.model.AceItem aceItem)
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
	* Gets the ace item with the primary key.
	*
	* @param aceItemId the primary key of the ace item to get
	* @return the ace item
	* @throws PortalException if a ace item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public nl.wur.alterra.cgi.ace.model.AceItem getAceItem(long aceItemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets a range of all the ace items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ace items to return
	* @param end the upper bound of the range of ace items to return (not inclusive)
	* @return the range of ace items
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<nl.wur.alterra.cgi.ace.model.AceItem> getAceItems(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the number of ace items.
	*
	* @return the number of ace items
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAceItemsCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the ace item in the database. Also notifies the appropriate model listeners.
	*
	* @param aceItem the ace item to update
	* @return the ace item that was updated
	* @throws SystemException if a system exception occurred
	*/
	public nl.wur.alterra.cgi.ace.model.AceItem updateAceItem(
		nl.wur.alterra.cgi.ace.model.AceItem aceItem)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the ace item in the database. Also notifies the appropriate model listeners.
	*
	* @param aceItem the ace item to update
	* @param merge whether to merge the ace item with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the ace item that was updated
	* @throws SystemException if a system exception occurred
	*/
	public nl.wur.alterra.cgi.ace.model.AceItem updateAceItem(
		nl.wur.alterra.cgi.ace.model.AceItem aceItem, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates new empty aceitem.
	*
	* @return
	*/
	public nl.wur.alterra.cgi.ace.model.AceItem createAceItem();

	/**
	* Retrieves an AceItem by its storedAt value.
	*
	* @param s requested storedAt value
	* @return aceitem, or null if not found
	* @throws SystemException hmm
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public nl.wur.alterra.cgi.ace.model.AceItem getAceItemByStoredAt(
		java.lang.String s)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Hugo de Groot: add these methods by hand to <portlet>LocalServiceImpl
	* and rerun ServiceBuilder if auto generation fails
	*
	* Gets a list with all the AceItems in a group
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<nl.wur.alterra.cgi.ace.model.AceItem> getAceItemsByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Hugo de Groot: add these methods by hand to <portlet>LocalServiceImpl
	* and rerun ServiceBuilder if auto generation fails
	*
	* Gets a list with a range of AceItems from a group
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<nl.wur.alterra.cgi.ace.model.AceItem> getAceItemsByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Hugo de Groot: add these methods by hand to <portlet>LocalServiceImpl
	* and rerun ServiceBuilder if auto generation fails
	*
	* Gets a list with a range of AceItems from a group
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<nl.wur.alterra.cgi.ace.model.AceItem> getAceItemsByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Hugo de Groot: add these methods by hand to <portlet>LocalServiceImpl
	* and rerun ServiceBuilder if auto generation fails
	*
	* Gets the number of AceItems in a group
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAceItemsCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Retrieves aceitems by nas id, which contains the ids of the wxsharvester that created the aceitems.
	*
	* @author heikki doeleman
	* @param wxsHarvesterId
	* @return
	* @throws SystemException
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<nl.wur.alterra.cgi.ace.model.AceItem> getAceItemsByWxsharvesterId(
		long wxsHarvesterId)
		throws com.liferay.portal.kernel.exception.SystemException;
}
