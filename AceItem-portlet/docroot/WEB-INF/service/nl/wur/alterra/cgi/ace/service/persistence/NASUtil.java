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

import nl.wur.alterra.cgi.ace.model.NAS;

import java.util.List;

/**
 * The persistence utility for the n a s service. This utility wraps {@link NASPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
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
 * @see NASPersistence
 * @see NASPersistenceImpl
 * @generated
 */
public class NASUtil {
	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(NAS nas) {
		getPersistence().clearCache(nas);
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
	public static List<NAS> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<NAS> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<NAS> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static NAS remove(NAS nas) throws SystemException {
		return getPersistence().remove(nas);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static NAS update(NAS nas, boolean merge) throws SystemException {
		return getPersistence().update(nas, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static NAS update(NAS nas, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(nas, merge, serviceContext);
	}

	/**
	* Caches the n a s in the entity cache if it is enabled.
	*
	* @param nas the n a s to cache
	*/
	public static void cacheResult(nl.wur.alterra.cgi.ace.model.NAS nas) {
		getPersistence().cacheResult(nas);
	}

	/**
	* Caches the n a ses in the entity cache if it is enabled.
	*
	* @param nases the n a ses to cache
	*/
	public static void cacheResult(
		java.util.List<nl.wur.alterra.cgi.ace.model.NAS> nases) {
		getPersistence().cacheResult(nases);
	}

	/**
	* Creates a new n a s with the primary key. Does not add the n a s to the database.
	*
	* @param nasId the primary key for the new n a s
	* @return the new n a s
	*/
	public static nl.wur.alterra.cgi.ace.model.NAS create(long nasId) {
		return getPersistence().create(nasId);
	}

	/**
	* Removes the n a s with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param nasId the primary key of the n a s to remove
	* @return the n a s that was removed
	* @throws nl.wur.alterra.cgi.ace.NoSuchNASException if a n a s with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static nl.wur.alterra.cgi.ace.model.NAS remove(long nasId)
		throws com.liferay.portal.kernel.exception.SystemException,
			nl.wur.alterra.cgi.ace.NoSuchNASException {
		return getPersistence().remove(nasId);
	}

	public static nl.wur.alterra.cgi.ace.model.NAS updateImpl(
		nl.wur.alterra.cgi.ace.model.NAS nas, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(nas, merge);
	}

	/**
	* Finds the n a s with the primary key or throws a {@link nl.wur.alterra.cgi.ace.NoSuchNASException} if it could not be found.
	*
	* @param nasId the primary key of the n a s to find
	* @return the n a s
	* @throws nl.wur.alterra.cgi.ace.NoSuchNASException if a n a s with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static nl.wur.alterra.cgi.ace.model.NAS findByPrimaryKey(long nasId)
		throws com.liferay.portal.kernel.exception.SystemException,
			nl.wur.alterra.cgi.ace.NoSuchNASException {
		return getPersistence().findByPrimaryKey(nasId);
	}

	/**
	* Finds the n a s with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param nasId the primary key of the n a s to find
	* @return the n a s, or <code>null</code> if a n a s with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static nl.wur.alterra.cgi.ace.model.NAS fetchByPrimaryKey(long nasId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(nasId);
	}

	/**
	* Finds all the n a ses where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the matching n a ses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<nl.wur.alterra.cgi.ace.model.NAS> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

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
	public static java.util.List<nl.wur.alterra.cgi.ace.model.NAS> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

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
	public static java.util.List<nl.wur.alterra.cgi.ace.model.NAS> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

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
	public static nl.wur.alterra.cgi.ace.model.NAS findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			nl.wur.alterra.cgi.ace.NoSuchNASException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

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
	public static nl.wur.alterra.cgi.ace.model.NAS findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			nl.wur.alterra.cgi.ace.NoSuchNASException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

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
	public static nl.wur.alterra.cgi.ace.model.NAS[] findByGroupId_PrevAndNext(
		long nasId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			nl.wur.alterra.cgi.ace.NoSuchNASException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(nasId, groupId, orderByComparator);
	}

	/**
	* Finds all the n a ses.
	*
	* @return the n a ses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<nl.wur.alterra.cgi.ace.model.NAS> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<nl.wur.alterra.cgi.ace.model.NAS> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<nl.wur.alterra.cgi.ace.model.NAS> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the n a ses where groupId = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Removes all the n a ses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the n a ses where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the number of matching n a ses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Counts all the n a ses.
	*
	* @return the number of n a ses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	/**
	* Gets all the ace items associated with the n a s.
	*
	* @param pk the primary key of the n a s to get the associated ace items for
	* @return the ace items associated with the n a s
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<nl.wur.alterra.cgi.ace.model.AceItem> getAceItems(
		long pk) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getAceItems(pk);
	}

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
	public static java.util.List<nl.wur.alterra.cgi.ace.model.AceItem> getAceItems(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getAceItems(pk, start, end);
	}

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
	public static java.util.List<nl.wur.alterra.cgi.ace.model.AceItem> getAceItems(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getAceItems(pk, start, end, orderByComparator);
	}

	/**
	* Gets the number of ace items associated with the n a s.
	*
	* @param pk the primary key of the n a s to get the number of associated ace items for
	* @return the number of ace items associated with the n a s
	* @throws SystemException if a system exception occurred
	*/
	public static int getAceItemsSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getAceItemsSize(pk);
	}

	/**
	* Determines whether the ace item is associated with the n a s.
	*
	* @param pk the primary key of the n a s
	* @param aceItemPK the primary key of the ace item
	* @return whether the ace item is associated with the n a s
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsAceItem(long pk, long aceItemPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsAceItem(pk, aceItemPK);
	}

	/**
	* Determines whether the n a s has any ace items associated with it.
	*
	* @param pk the primary key of the n a s to check for associations with ace items
	* @return whether the n a s has any ace items associated with it
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsAceItems(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsAceItems(pk);
	}

	public static NASPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (NASPersistence)PortletBeanLocatorUtil.locate(nl.wur.alterra.cgi.ace.service.ClpSerializer.SERVLET_CONTEXT_NAME,
					NASPersistence.class.getName());
		}

		return _persistence;
	}

	public void setPersistence(NASPersistence persistence) {
		_persistence = persistence;
	}

	private static NASPersistence _persistence;
}