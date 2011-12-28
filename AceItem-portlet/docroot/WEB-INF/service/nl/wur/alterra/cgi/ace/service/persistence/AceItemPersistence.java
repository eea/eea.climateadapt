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

import com.liferay.portal.service.persistence.BasePersistence;

import nl.wur.alterra.cgi.ace.model.AceItem;

/**
 * The persistence interface for the ace item service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link AceItemUtil} to access the ace item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author groot052
 * @see AceItemPersistenceImpl
 * @see AceItemUtil
 * @generated
 */
public interface AceItemPersistence extends BasePersistence<AceItem> {
	/**
	* Caches the ace item in the entity cache if it is enabled.
	*
	* @param aceItem the ace item to cache
	*/
	public void cacheResult(nl.wur.alterra.cgi.ace.model.AceItem aceItem);

	/**
	* Caches the ace items in the entity cache if it is enabled.
	*
	* @param aceItems the ace items to cache
	*/
	public void cacheResult(
		java.util.List<nl.wur.alterra.cgi.ace.model.AceItem> aceItems);

	/**
	* Creates a new ace item with the primary key. Does not add the ace item to the database.
	*
	* @param aceItemId the primary key for the new ace item
	* @return the new ace item
	*/
	public nl.wur.alterra.cgi.ace.model.AceItem create(long aceItemId);

	/**
	* Removes the ace item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param aceItemId the primary key of the ace item to remove
	* @return the ace item that was removed
	* @throws nl.wur.alterra.cgi.ace.NoSuchItemException if a ace item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public nl.wur.alterra.cgi.ace.model.AceItem remove(long aceItemId)
		throws com.liferay.portal.kernel.exception.SystemException,
			nl.wur.alterra.cgi.ace.NoSuchItemException;

	public nl.wur.alterra.cgi.ace.model.AceItem updateImpl(
		nl.wur.alterra.cgi.ace.model.AceItem aceItem, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the ace item with the primary key or throws a {@link nl.wur.alterra.cgi.ace.NoSuchItemException} if it could not be found.
	*
	* @param aceItemId the primary key of the ace item to find
	* @return the ace item
	* @throws nl.wur.alterra.cgi.ace.NoSuchItemException if a ace item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public nl.wur.alterra.cgi.ace.model.AceItem findByPrimaryKey(long aceItemId)
		throws com.liferay.portal.kernel.exception.SystemException,
			nl.wur.alterra.cgi.ace.NoSuchItemException;

	/**
	* Finds the ace item with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param aceItemId the primary key of the ace item to find
	* @return the ace item, or <code>null</code> if a ace item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public nl.wur.alterra.cgi.ace.model.AceItem fetchByPrimaryKey(
		long aceItemId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the ace items where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the matching ace items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<nl.wur.alterra.cgi.ace.model.AceItem> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<nl.wur.alterra.cgi.ace.model.AceItem> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<nl.wur.alterra.cgi.ace.model.AceItem> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public nl.wur.alterra.cgi.ace.model.AceItem findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			nl.wur.alterra.cgi.ace.NoSuchItemException;

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
	public nl.wur.alterra.cgi.ace.model.AceItem findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			nl.wur.alterra.cgi.ace.NoSuchItemException;

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
	public nl.wur.alterra.cgi.ace.model.AceItem[] findByGroupId_PrevAndNext(
		long aceItemId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			nl.wur.alterra.cgi.ace.NoSuchItemException;

	/**
	* Finds the ace item where storedAt = &#63; or throws a {@link nl.wur.alterra.cgi.ace.NoSuchItemException} if it could not be found.
	*
	* @param storedAt the stored at to search with
	* @return the matching ace item
	* @throws nl.wur.alterra.cgi.ace.NoSuchItemException if a matching ace item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public nl.wur.alterra.cgi.ace.model.AceItem findByStoredAt(
		java.lang.String storedAt)
		throws com.liferay.portal.kernel.exception.SystemException,
			nl.wur.alterra.cgi.ace.NoSuchItemException;

	/**
	* Finds the ace item where storedAt = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param storedAt the stored at to search with
	* @return the matching ace item, or <code>null</code> if a matching ace item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public nl.wur.alterra.cgi.ace.model.AceItem fetchByStoredAt(
		java.lang.String storedAt)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the ace item where storedAt = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param storedAt the stored at to search with
	* @return the matching ace item, or <code>null</code> if a matching ace item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public nl.wur.alterra.cgi.ace.model.AceItem fetchByStoredAt(
		java.lang.String storedAt, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the ace items where wxsharvesterId = &#63;.
	*
	* @param wxsharvesterId the wxsharvester id to search with
	* @return the matching ace items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<nl.wur.alterra.cgi.ace.model.AceItem> findByWxsharvesterId(
		long wxsharvesterId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the ace items where wxsharvesterId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param wxsharvesterId the wxsharvester id to search with
	* @param start the lower bound of the range of ace items to return
	* @param end the upper bound of the range of ace items to return (not inclusive)
	* @return the range of matching ace items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<nl.wur.alterra.cgi.ace.model.AceItem> findByWxsharvesterId(
		long wxsharvesterId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the ace items where wxsharvesterId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param wxsharvesterId the wxsharvester id to search with
	* @param start the lower bound of the range of ace items to return
	* @param end the upper bound of the range of ace items to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching ace items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<nl.wur.alterra.cgi.ace.model.AceItem> findByWxsharvesterId(
		long wxsharvesterId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first ace item in the ordered set where wxsharvesterId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param wxsharvesterId the wxsharvester id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching ace item
	* @throws nl.wur.alterra.cgi.ace.NoSuchItemException if a matching ace item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public nl.wur.alterra.cgi.ace.model.AceItem findByWxsharvesterId_First(
		long wxsharvesterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			nl.wur.alterra.cgi.ace.NoSuchItemException;

	/**
	* Finds the last ace item in the ordered set where wxsharvesterId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param wxsharvesterId the wxsharvester id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching ace item
	* @throws nl.wur.alterra.cgi.ace.NoSuchItemException if a matching ace item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public nl.wur.alterra.cgi.ace.model.AceItem findByWxsharvesterId_Last(
		long wxsharvesterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			nl.wur.alterra.cgi.ace.NoSuchItemException;

	/**
	* Finds the ace items before and after the current ace item in the ordered set where wxsharvesterId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param aceItemId the primary key of the current ace item
	* @param wxsharvesterId the wxsharvester id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next ace item
	* @throws nl.wur.alterra.cgi.ace.NoSuchItemException if a ace item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public nl.wur.alterra.cgi.ace.model.AceItem[] findByWxsharvesterId_PrevAndNext(
		long aceItemId, long wxsharvesterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			nl.wur.alterra.cgi.ace.NoSuchItemException;

	/**
	* Finds all the ace items.
	*
	* @return the ace items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<nl.wur.alterra.cgi.ace.model.AceItem> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<nl.wur.alterra.cgi.ace.model.AceItem> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<nl.wur.alterra.cgi.ace.model.AceItem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the ace items where groupId = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the ace item where storedAt = &#63; from the database.
	*
	* @param storedAt the stored at to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStoredAt(java.lang.String storedAt)
		throws com.liferay.portal.kernel.exception.SystemException,
			nl.wur.alterra.cgi.ace.NoSuchItemException;

	/**
	* Removes all the ace items where wxsharvesterId = &#63; from the database.
	*
	* @param wxsharvesterId the wxsharvester id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByWxsharvesterId(long wxsharvesterId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the ace items from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the ace items where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the number of matching ace items
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the ace items where storedAt = &#63;.
	*
	* @param storedAt the stored at to search with
	* @return the number of matching ace items
	* @throws SystemException if a system exception occurred
	*/
	public int countByStoredAt(java.lang.String storedAt)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the ace items where wxsharvesterId = &#63;.
	*
	* @param wxsharvesterId the wxsharvester id to search with
	* @return the number of matching ace items
	* @throws SystemException if a system exception occurred
	*/
	public int countByWxsharvesterId(long wxsharvesterId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the ace items.
	*
	* @return the number of ace items
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
