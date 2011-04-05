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

import nl.wur.alterra.cgi.ace.model.NAS;

/**
 * The persistence interface for the n a s service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link NASUtil} to access the n a s persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author groot052
 * @see NASPersistenceImpl
 * @see NASUtil
 * @generated
 */
public interface NASPersistence extends BasePersistence<NAS> {
	/**
	* Caches the n a s in the entity cache if it is enabled.
	*
	* @param nas the n a s to cache
	*/
	public void cacheResult(nl.wur.alterra.cgi.ace.model.NAS nas);

	/**
	* Caches the n a ses in the entity cache if it is enabled.
	*
	* @param nases the n a ses to cache
	*/
	public void cacheResult(
		java.util.List<nl.wur.alterra.cgi.ace.model.NAS> nases);

	/**
	* Creates a new n a s with the primary key. Does not add the n a s to the database.
	*
	* @param nasId the primary key for the new n a s
	* @return the new n a s
	*/
	public nl.wur.alterra.cgi.ace.model.NAS create(long nasId);

	/**
	* Removes the n a s with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param nasId the primary key of the n a s to remove
	* @return the n a s that was removed
	* @throws nl.wur.alterra.cgi.ace.NoSuchNASException if a n a s with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public nl.wur.alterra.cgi.ace.model.NAS remove(long nasId)
		throws com.liferay.portal.kernel.exception.SystemException,
			nl.wur.alterra.cgi.ace.NoSuchNASException;

	public nl.wur.alterra.cgi.ace.model.NAS updateImpl(
		nl.wur.alterra.cgi.ace.model.NAS nas, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the n a s with the primary key or throws a {@link nl.wur.alterra.cgi.ace.NoSuchNASException} if it could not be found.
	*
	* @param nasId the primary key of the n a s to find
	* @return the n a s
	* @throws nl.wur.alterra.cgi.ace.NoSuchNASException if a n a s with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public nl.wur.alterra.cgi.ace.model.NAS findByPrimaryKey(long nasId)
		throws com.liferay.portal.kernel.exception.SystemException,
			nl.wur.alterra.cgi.ace.NoSuchNASException;

	/**
	* Finds the n a s with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param nasId the primary key of the n a s to find
	* @return the n a s, or <code>null</code> if a n a s with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public nl.wur.alterra.cgi.ace.model.NAS fetchByPrimaryKey(long nasId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the n a ses where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the matching n a ses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<nl.wur.alterra.cgi.ace.model.NAS> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the n a ses where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of n a ses to return
	* @param end the upper bound of the range of n a ses to return (not inclusive)
	* @return the range of matching n a ses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<nl.wur.alterra.cgi.ace.model.NAS> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the n a ses where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of n a ses to return
	* @param end the upper bound of the range of n a ses to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching n a ses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<nl.wur.alterra.cgi.ace.model.NAS> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first n a s in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching n a s
	* @throws nl.wur.alterra.cgi.ace.NoSuchNASException if a matching n a s could not be found
	* @throws SystemException if a system exception occurred
	*/
	public nl.wur.alterra.cgi.ace.model.NAS findByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			nl.wur.alterra.cgi.ace.NoSuchNASException;

	/**
	* Finds the last n a s in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching n a s
	* @throws nl.wur.alterra.cgi.ace.NoSuchNASException if a matching n a s could not be found
	* @throws SystemException if a system exception occurred
	*/
	public nl.wur.alterra.cgi.ace.model.NAS findByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			nl.wur.alterra.cgi.ace.NoSuchNASException;

	/**
	* Finds the n a ses before and after the current n a s in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nasId the primary key of the current n a s
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next n a s
	* @throws nl.wur.alterra.cgi.ace.NoSuchNASException if a n a s with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public nl.wur.alterra.cgi.ace.model.NAS[] findByGroupId_PrevAndNext(
		long nasId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			nl.wur.alterra.cgi.ace.NoSuchNASException;

	/**
	* Finds all the n a ses.
	*
	* @return the n a ses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<nl.wur.alterra.cgi.ace.model.NAS> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the n a ses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of n a ses to return
	* @param end the upper bound of the range of n a ses to return (not inclusive)
	* @return the range of n a ses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<nl.wur.alterra.cgi.ace.model.NAS> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the n a ses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of n a ses to return
	* @param end the upper bound of the range of n a ses to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of n a ses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<nl.wur.alterra.cgi.ace.model.NAS> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the n a ses where groupId = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the n a ses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the n a ses where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the number of matching n a ses
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the n a ses.
	*
	* @return the number of n a ses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets all the ace items associated with the n a s.
	*
	* @param pk the primary key of the n a s to get the associated ace items for
	* @return the ace items associated with the n a s
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<nl.wur.alterra.cgi.ace.model.AceItem> getAceItems(
		long pk) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets a range of all the ace items associated with the n a s.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the n a s to get the associated ace items for
	* @param start the lower bound of the range of n a ses to return
	* @param end the upper bound of the range of n a ses to return (not inclusive)
	* @return the range of ace items associated with the n a s
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<nl.wur.alterra.cgi.ace.model.AceItem> getAceItems(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets an ordered range of all the ace items associated with the n a s.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the n a s to get the associated ace items for
	* @param start the lower bound of the range of n a ses to return
	* @param end the upper bound of the range of n a ses to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of ace items associated with the n a s
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<nl.wur.alterra.cgi.ace.model.AceItem> getAceItems(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the number of ace items associated with the n a s.
	*
	* @param pk the primary key of the n a s to get the number of associated ace items for
	* @return the number of ace items associated with the n a s
	* @throws SystemException if a system exception occurred
	*/
	public int getAceItemsSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Determines whether the ace item is associated with the n a s.
	*
	* @param pk the primary key of the n a s
	* @param aceItemPK the primary key of the ace item
	* @return whether the ace item is associated with the n a s
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsAceItem(long pk, long aceItemPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Determines whether the n a s has any ace items associated with it.
	*
	* @param pk the primary key of the n a s to check for associations with ace items
	* @return whether the n a s has any ace items associated with it
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsAceItems(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;
}