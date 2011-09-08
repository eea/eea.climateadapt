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

package nl.wur.alterra.cgi.ace.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

import nl.wur.alterra.cgi.ace.model.AceItem;

import java.util.List;

/**
 * The persistence utility for the ace item service. This utility wraps {@link AceItemPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author groot052
 * @see AceItemPersistence
 * @see AceItemPersistenceImpl
 * @generated
 */
public class AceItemUtil {
	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(AceItem aceItem) {
		getPersistence().clearCache(aceItem);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AceItem> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AceItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AceItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static AceItem remove(AceItem aceItem) throws SystemException {
		return getPersistence().remove(aceItem);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static AceItem update(AceItem aceItem, boolean merge)
		throws SystemException {
		return getPersistence().update(aceItem, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static AceItem update(AceItem aceItem, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(aceItem, merge, serviceContext);
	}

	/**
	* Caches the ace item in the entity cache if it is enabled.
	*
	* @param aceItem the ace item to cache
	*/
	public static void cacheResult(nl.wur.alterra.cgi.ace.model.AceItem aceItem) {
		getPersistence().cacheResult(aceItem);
	}

	/**
	* Caches the ace items in the entity cache if it is enabled.
	*
	* @param aceItems the ace items to cache
	*/
	public static void cacheResult(
		java.util.List<nl.wur.alterra.cgi.ace.model.AceItem> aceItems) {
		getPersistence().cacheResult(aceItems);
	}

	/**
	* Creates a new ace item with the primary key. Does not add the ace item to the database.
	*
	* @param aceItemId the primary key for the new ace item
	* @return the new ace item
	*/
	public static nl.wur.alterra.cgi.ace.model.AceItem create(long aceItemId) {
		return getPersistence().create(aceItemId);
	}

	/**
	* Removes the ace item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param aceItemId the primary key of the ace item to remove
	* @return the ace item that was removed
	* @throws nl.wur.alterra.cgi.ace.NoSuchItemException if a ace item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static nl.wur.alterra.cgi.ace.model.AceItem remove(long aceItemId)
		throws com.liferay.portal.kernel.exception.SystemException,
			nl.wur.alterra.cgi.ace.NoSuchItemException {
		return getPersistence().remove(aceItemId);
	}

	public static nl.wur.alterra.cgi.ace.model.AceItem updateImpl(
		nl.wur.alterra.cgi.ace.model.AceItem aceItem, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(aceItem, merge);
	}

	/**
	* Finds the ace item with the primary key or throws a {@link nl.wur.alterra.cgi.ace.NoSuchItemException} if it could not be found.
	*
	* @param aceItemId the primary key of the ace item to find
	* @return the ace item
	* @throws nl.wur.alterra.cgi.ace.NoSuchItemException if a ace item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static nl.wur.alterra.cgi.ace.model.AceItem findByPrimaryKey(
		long aceItemId)
		throws com.liferay.portal.kernel.exception.SystemException,
			nl.wur.alterra.cgi.ace.NoSuchItemException {
		return getPersistence().findByPrimaryKey(aceItemId);
	}

	/**
	* Finds the ace item with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param aceItemId the primary key of the ace item to find
	* @return the ace item, or <code>null</code> if a ace item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static nl.wur.alterra.cgi.ace.model.AceItem fetchByPrimaryKey(
		long aceItemId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(aceItemId);
	}

	/**
	* Finds all the ace items where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the matching ace items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<nl.wur.alterra.cgi.ace.model.AceItem> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Finds a range of all the ace items where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of ace items to return
	* @param end the upper bound of the range of ace items to return (not inclusive)
	* @return the range of matching ace items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<nl.wur.alterra.cgi.ace.model.AceItem> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Finds an ordered range of all the ace items where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of ace items to return
	* @param end the upper bound of the range of ace items to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching ace items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<nl.wur.alterra.cgi.ace.model.AceItem> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Finds the first ace item in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching ace item
	* @throws nl.wur.alterra.cgi.ace.NoSuchItemException if a matching ace item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static nl.wur.alterra.cgi.ace.model.AceItem findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			nl.wur.alterra.cgi.ace.NoSuchItemException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Finds the last ace item in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching ace item
	* @throws nl.wur.alterra.cgi.ace.NoSuchItemException if a matching ace item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static nl.wur.alterra.cgi.ace.model.AceItem findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			nl.wur.alterra.cgi.ace.NoSuchItemException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Finds the ace items before and after the current ace item in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param aceItemId the primary key of the current ace item
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next ace item
	* @throws nl.wur.alterra.cgi.ace.NoSuchItemException if a ace item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static nl.wur.alterra.cgi.ace.model.AceItem[] findByGroupId_PrevAndNext(
		long aceItemId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			nl.wur.alterra.cgi.ace.NoSuchItemException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(aceItemId, groupId,
			orderByComparator);
	}

	/**
	* Finds the ace item where storedAt = &#63; or throws a {@link nl.wur.alterra.cgi.ace.NoSuchItemException} if it could not be found.
	*
	* @param storedAt the stored at to search with
	* @return the matching ace item
	* @throws nl.wur.alterra.cgi.ace.NoSuchItemException if a matching ace item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static nl.wur.alterra.cgi.ace.model.AceItem findByStoredAt(
		java.lang.String storedAt)
		throws com.liferay.portal.kernel.exception.SystemException,
			nl.wur.alterra.cgi.ace.NoSuchItemException {
		return getPersistence().findByStoredAt(storedAt);
	}

	/**
	* Finds the ace item where storedAt = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param storedAt the stored at to search with
	* @return the matching ace item, or <code>null</code> if a matching ace item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static nl.wur.alterra.cgi.ace.model.AceItem fetchByStoredAt(
		java.lang.String storedAt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStoredAt(storedAt);
	}

	/**
	* Finds the ace item where storedAt = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param storedAt the stored at to search with
	* @return the matching ace item, or <code>null</code> if a matching ace item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static nl.wur.alterra.cgi.ace.model.AceItem fetchByStoredAt(
		java.lang.String storedAt, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStoredAt(storedAt, retrieveFromCache);
	}

	/**
	* Finds all the ace items.
	*
	* @return the ace items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<nl.wur.alterra.cgi.ace.model.AceItem> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Finds a range of all the ace items.
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
	public static java.util.List<nl.wur.alterra.cgi.ace.model.AceItem> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Finds an ordered range of all the ace items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ace items to return
	* @param end the upper bound of the range of ace items to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of ace items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<nl.wur.alterra.cgi.ace.model.AceItem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the ace items where groupId = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Removes the ace item where storedAt = &#63; from the database.
	*
	* @param storedAt the stored at to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStoredAt(java.lang.String storedAt)
		throws com.liferay.portal.kernel.exception.SystemException,
			nl.wur.alterra.cgi.ace.NoSuchItemException {
		getPersistence().removeByStoredAt(storedAt);
	}

	/**
	* Removes all the ace items from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the ace items where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the number of matching ace items
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Counts all the ace items where storedAt = &#63;.
	*
	* @param storedAt the stored at to search with
	* @return the number of matching ace items
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStoredAt(java.lang.String storedAt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStoredAt(storedAt);
	}

	/**
	* Counts all the ace items.
	*
	* @return the number of ace items
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static AceItemPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (AceItemPersistence)PortletBeanLocatorUtil.locate(nl.wur.alterra.cgi.ace.service.ClpSerializer.SERVLET_CONTEXT_NAME,
					AceItemPersistence.class.getName());
		}

		return _persistence;
	}

	public void setPersistence(AceItemPersistence persistence) {
		_persistence = persistence;
	}

	private static AceItemPersistence _persistence;
}