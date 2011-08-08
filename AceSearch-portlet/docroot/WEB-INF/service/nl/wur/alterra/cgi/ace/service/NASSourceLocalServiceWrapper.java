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

/**
 * <p>
 * This class is a wrapper for {@link NASSourceLocalService}.
 * </p>
 *
 * @author    groot052
 * @see       NASSourceLocalService
 * @generated
 */
public class NASSourceLocalServiceWrapper implements NASSourceLocalService {
	public NASSourceLocalServiceWrapper(
		NASSourceLocalService nasSourceLocalService) {
		_nasSourceLocalService = nasSourceLocalService;
	}

	/**
	* Adds the n a s source to the database. Also notifies the appropriate model listeners.
	*
	* @param nasSource the n a s source to add
	* @return the n a s source that was added
	* @throws SystemException if a system exception occurred
	*/
	public nl.wur.alterra.cgi.ace.model.NASSource addNASSource(
		nl.wur.alterra.cgi.ace.model.NASSource nasSource)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nasSourceLocalService.addNASSource(nasSource);
	}

	/**
	* Creates a new n a s source with the primary key. Does not add the n a s source to the database.
	*
	* @param nassourceid the primary key for the new n a s source
	* @return the new n a s source
	*/
	public nl.wur.alterra.cgi.ace.model.NASSource createNASSource(
		long nassourceid) {
		return _nasSourceLocalService.createNASSource(nassourceid);
	}

	/**
	* Deletes the n a s source with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param nassourceid the primary key of the n a s source to delete
	* @throws PortalException if a n a s source with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteNASSource(long nassourceid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_nasSourceLocalService.deleteNASSource(nassourceid);
	}

	/**
	* Deletes the n a s source from the database. Also notifies the appropriate model listeners.
	*
	* @param nasSource the n a s source to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteNASSource(
		nl.wur.alterra.cgi.ace.model.NASSource nasSource)
		throws com.liferay.portal.kernel.exception.SystemException {
		_nasSourceLocalService.deleteNASSource(nasSource);
	}

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
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nasSourceLocalService.dynamicQuery(dynamicQuery);
	}

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
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _nasSourceLocalService.dynamicQuery(dynamicQuery, start, end);
	}

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
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nasSourceLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nasSourceLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the n a s source with the primary key.
	*
	* @param nassourceid the primary key of the n a s source to get
	* @return the n a s source
	* @throws PortalException if a n a s source with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public nl.wur.alterra.cgi.ace.model.NASSource getNASSource(long nassourceid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _nasSourceLocalService.getNASSource(nassourceid);
	}

	/**
	* Gets a range of all the n a s sources.
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
	public java.util.List<nl.wur.alterra.cgi.ace.model.NASSource> getNASSources(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nasSourceLocalService.getNASSources(start, end);
	}

	/**
	* Gets the number of n a s sources.
	*
	* @return the number of n a s sources
	* @throws SystemException if a system exception occurred
	*/
	public int getNASSourcesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nasSourceLocalService.getNASSourcesCount();
	}

	/**
	* Updates the n a s source in the database. Also notifies the appropriate model listeners.
	*
	* @param nasSource the n a s source to update
	* @return the n a s source that was updated
	* @throws SystemException if a system exception occurred
	*/
	public nl.wur.alterra.cgi.ace.model.NASSource updateNASSource(
		nl.wur.alterra.cgi.ace.model.NASSource nasSource)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nasSourceLocalService.updateNASSource(nasSource);
	}

	/**
	* Updates the n a s source in the database. Also notifies the appropriate model listeners.
	*
	* @param nasSource the n a s source to update
	* @param merge whether to merge the n a s source with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the n a s source that was updated
	* @throws SystemException if a system exception occurred
	*/
	public nl.wur.alterra.cgi.ace.model.NASSource updateNASSource(
		nl.wur.alterra.cgi.ace.model.NASSource nasSource, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nasSourceLocalService.updateNASSource(nasSource, merge);
	}

	public NASSourceLocalService getWrappedNASSourceLocalService() {
		return _nasSourceLocalService;
	}

	private NASSourceLocalService _nasSourceLocalService;
}