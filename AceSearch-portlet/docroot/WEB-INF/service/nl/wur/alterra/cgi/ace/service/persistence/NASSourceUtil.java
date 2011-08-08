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

import nl.wur.alterra.cgi.ace.model.NASSource;

import java.util.List;

/**
 * The persistence utility for the n a s source service. This utility wraps {@link NASSourcePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
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
 * @see NASSourcePersistence
 * @see NASSourcePersistenceImpl
 * @generated
 */
public class NASSourceUtil {
	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(NASSource nasSource) {
		getPersistence().clearCache(nasSource);
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
	public static List<NASSource> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<NASSource> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<NASSource> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static NASSource remove(NASSource nasSource)
		throws SystemException {
		return getPersistence().remove(nasSource);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static NASSource update(NASSource nasSource, boolean merge)
		throws SystemException {
		return getPersistence().update(nasSource, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static NASSource update(NASSource nasSource, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(nasSource, merge, serviceContext);
	}

	/**
	* Caches the n a s source in the entity cache if it is enabled.
	*
	* @param nasSource the n a s source to cache
	*/
	public static void cacheResult(
		nl.wur.alterra.cgi.ace.model.NASSource nasSource) {
		getPersistence().cacheResult(nasSource);
	}

	/**
	* Caches the n a s sources in the entity cache if it is enabled.
	*
	* @param nasSources the n a s sources to cache
	*/
	public static void cacheResult(
		java.util.List<nl.wur.alterra.cgi.ace.model.NASSource> nasSources) {
		getPersistence().cacheResult(nasSources);
	}

	/**
	* Creates a new n a s source with the primary key. Does not add the n a s source to the database.
	*
	* @param nassourceid the primary key for the new n a s source
	* @return the new n a s source
	*/
	public static nl.wur.alterra.cgi.ace.model.NASSource create(
		long nassourceid) {
		return getPersistence().create(nassourceid);
	}

	/**
	* Removes the n a s source with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param nassourceid the primary key of the n a s source to remove
	* @return the n a s source that was removed
	* @throws nl.wur.alterra.cgi.ace.NoSuchNASSourceException if a n a s source with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static nl.wur.alterra.cgi.ace.model.NASSource remove(
		long nassourceid)
		throws com.liferay.portal.kernel.exception.SystemException,
			nl.wur.alterra.cgi.ace.NoSuchNASSourceException {
		return getPersistence().remove(nassourceid);
	}

	public static nl.wur.alterra.cgi.ace.model.NASSource updateImpl(
		nl.wur.alterra.cgi.ace.model.NASSource nasSource, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(nasSource, merge);
	}

	/**
	* Finds the n a s source with the primary key or throws a {@link nl.wur.alterra.cgi.ace.NoSuchNASSourceException} if it could not be found.
	*
	* @param nassourceid the primary key of the n a s source to find
	* @return the n a s source
	* @throws nl.wur.alterra.cgi.ace.NoSuchNASSourceException if a n a s source with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static nl.wur.alterra.cgi.ace.model.NASSource findByPrimaryKey(
		long nassourceid)
		throws com.liferay.portal.kernel.exception.SystemException,
			nl.wur.alterra.cgi.ace.NoSuchNASSourceException {
		return getPersistence().findByPrimaryKey(nassourceid);
	}

	/**
	* Finds the n a s source with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param nassourceid the primary key of the n a s source to find
	* @return the n a s source, or <code>null</code> if a n a s source with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static nl.wur.alterra.cgi.ace.model.NASSource fetchByPrimaryKey(
		long nassourceid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(nassourceid);
	}

	/**
	* Finds all the n a s sources where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the matching n a s sources
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<nl.wur.alterra.cgi.ace.model.NASSource> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Finds a range of all the n a s sources where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of n a s sources to return
	* @param end the upper bound of the range of n a s sources to return (not inclusive)
	* @return the range of matching n a s sources
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<nl.wur.alterra.cgi.ace.model.NASSource> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Finds an ordered range of all the n a s sources where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of n a s sources to return
	* @param end the upper bound of the range of n a s sources to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching n a s sources
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<nl.wur.alterra.cgi.ace.model.NASSource> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Finds the first n a s source in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching n a s source
	* @throws nl.wur.alterra.cgi.ace.NoSuchNASSourceException if a matching n a s source could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static nl.wur.alterra.cgi.ace.model.NASSource findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			nl.wur.alterra.cgi.ace.NoSuchNASSourceException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Finds the last n a s source in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching n a s source
	* @throws nl.wur.alterra.cgi.ace.NoSuchNASSourceException if a matching n a s source could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static nl.wur.alterra.cgi.ace.model.NASSource findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			nl.wur.alterra.cgi.ace.NoSuchNASSourceException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Finds the n a s sources before and after the current n a s source in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nassourceid the primary key of the current n a s source
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next n a s source
	* @throws nl.wur.alterra.cgi.ace.NoSuchNASSourceException if a n a s source with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static nl.wur.alterra.cgi.ace.model.NASSource[] findByGroupId_PrevAndNext(
		long nassourceid, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			nl.wur.alterra.cgi.ace.NoSuchNASSourceException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(nassourceid, groupId,
			orderByComparator);
	}

	/**
	* Finds all the n a s sources.
	*
	* @return the n a s sources
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<nl.wur.alterra.cgi.ace.model.NASSource> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Finds a range of all the n a s sources.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of n a s sources to return
	* @param end the upper bound of the range of n a s sources to return (not inclusive)
	* @return the range of n a s sources
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<nl.wur.alterra.cgi.ace.model.NASSource> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Finds an ordered range of all the n a s sources.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of n a s sources to return
	* @param end the upper bound of the range of n a s sources to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of n a s sources
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<nl.wur.alterra.cgi.ace.model.NASSource> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the n a s sources where groupId = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Removes all the n a s sources from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the n a s sources where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the number of matching n a s sources
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Counts all the n a s sources.
	*
	* @return the number of n a s sources
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static NASSourcePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (NASSourcePersistence)PortletBeanLocatorUtil.locate(nl.wur.alterra.cgi.ace.service.ClpSerializer.SERVLET_CONTEXT_NAME,
					NASSourcePersistence.class.getName());
		}

		return _persistence;
	}

	public void setPersistence(NASSourcePersistence persistence) {
		_persistence = persistence;
	}

	private static NASSourcePersistence _persistence;
}