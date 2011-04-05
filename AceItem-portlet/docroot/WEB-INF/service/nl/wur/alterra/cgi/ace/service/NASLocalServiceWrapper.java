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
 * This class is a wrapper for {@link NASLocalService}.
 * </p>
 *
 * @author    groot052
 * @see       NASLocalService
 * @generated
 */
public class NASLocalServiceWrapper implements NASLocalService {
	public NASLocalServiceWrapper(NASLocalService nasLocalService) {
		_nasLocalService = nasLocalService;
	}

	/**
	* Adds the n a s to the database. Also notifies the appropriate model listeners.
	*
	* @param nas the n a s to add
	* @return the n a s that was added
	* @throws SystemException if a system exception occurred
	*/
	public nl.wur.alterra.cgi.ace.model.NAS addNAS(
		nl.wur.alterra.cgi.ace.model.NAS nas)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nasLocalService.addNAS(nas);
	}

	/**
	* Creates a new n a s with the primary key. Does not add the n a s to the database.
	*
	* @param nasId the primary key for the new n a s
	* @return the new n a s
	*/
	public nl.wur.alterra.cgi.ace.model.NAS createNAS(long nasId) {
		return _nasLocalService.createNAS(nasId);
	}

	/**
	* Deletes the n a s with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param nasId the primary key of the n a s to delete
	* @throws PortalException if a n a s with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteNAS(long nasId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_nasLocalService.deleteNAS(nasId);
	}

	/**
	* Deletes the n a s from the database. Also notifies the appropriate model listeners.
	*
	* @param nas the n a s to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteNAS(nl.wur.alterra.cgi.ace.model.NAS nas)
		throws com.liferay.portal.kernel.exception.SystemException {
		_nasLocalService.deleteNAS(nas);
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
		return _nasLocalService.dynamicQuery(dynamicQuery);
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
		return _nasLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _nasLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _nasLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the n a s with the primary key.
	*
	* @param nasId the primary key of the n a s to get
	* @return the n a s
	* @throws PortalException if a n a s with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public nl.wur.alterra.cgi.ace.model.NAS getNAS(long nasId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _nasLocalService.getNAS(nasId);
	}

	/**
	* Gets a range of all the n a ses.
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
	public java.util.List<nl.wur.alterra.cgi.ace.model.NAS> getNASs(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _nasLocalService.getNASs(start, end);
	}

	/**
	* Gets the number of n a ses.
	*
	* @return the number of n a ses
	* @throws SystemException if a system exception occurred
	*/
	public int getNASsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nasLocalService.getNASsCount();
	}

	/**
	* Updates the n a s in the database. Also notifies the appropriate model listeners.
	*
	* @param nas the n a s to update
	* @return the n a s that was updated
	* @throws SystemException if a system exception occurred
	*/
	public nl.wur.alterra.cgi.ace.model.NAS updateNAS(
		nl.wur.alterra.cgi.ace.model.NAS nas)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nasLocalService.updateNAS(nas);
	}

	/**
	* Updates the n a s in the database. Also notifies the appropriate model listeners.
	*
	* @param nas the n a s to update
	* @param merge whether to merge the n a s with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the n a s that was updated
	* @throws SystemException if a system exception occurred
	*/
	public nl.wur.alterra.cgi.ace.model.NAS updateNAS(
		nl.wur.alterra.cgi.ace.model.NAS nas, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nasLocalService.updateNAS(nas, merge);
	}

	public NASLocalService getWrappedNASLocalService() {
		return _nasLocalService;
	}

	private NASLocalService _nasLocalService;
}