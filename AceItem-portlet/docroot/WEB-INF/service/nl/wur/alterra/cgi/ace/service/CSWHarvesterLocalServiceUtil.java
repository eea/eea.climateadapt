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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;

/**
 * The utility for the c s w harvester local service. This utility wraps {@link nl.wur.alterra.cgi.ace.service.impl.CSWHarvesterLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * Never modify this class directly. Add custom service methods to {@link nl.wur.alterra.cgi.ace.service.impl.CSWHarvesterLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author groot052
 * @see CSWHarvesterLocalService
 * @see nl.wur.alterra.cgi.ace.service.base.CSWHarvesterLocalServiceBaseImpl
 * @see nl.wur.alterra.cgi.ace.service.impl.CSWHarvesterLocalServiceImpl
 * @generated
 */
public class CSWHarvesterLocalServiceUtil {
	/**
	* Adds the c s w harvester to the database. Also notifies the appropriate model listeners.
	*
	* @param cswHarvester the c s w harvester to add
	* @return the c s w harvester that was added
	* @throws SystemException if a system exception occurred
	*/
	public static nl.wur.alterra.cgi.ace.model.CSWHarvester addCSWHarvester(
		nl.wur.alterra.cgi.ace.model.CSWHarvester cswHarvester)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addCSWHarvester(cswHarvester);
	}

	/**
	* Creates a new c s w harvester with the primary key. Does not add the c s w harvester to the database.
	*
	* @param cswharvesterid the primary key for the new c s w harvester
	* @return the new c s w harvester
	*/
	public static nl.wur.alterra.cgi.ace.model.CSWHarvester createCSWHarvester(
		long cswharvesterid) {
		return getService().createCSWHarvester(cswharvesterid);
	}

	/**
	* Deletes the c s w harvester with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cswharvesterid the primary key of the c s w harvester to delete
	* @throws PortalException if a c s w harvester with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteCSWHarvester(long cswharvesterid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteCSWHarvester(cswharvesterid);
	}

	/**
	* Deletes the c s w harvester from the database. Also notifies the appropriate model listeners.
	*
	* @param cswHarvester the c s w harvester to delete
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteCSWHarvester(
		nl.wur.alterra.cgi.ace.model.CSWHarvester cswHarvester)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteCSWHarvester(cswHarvester);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the c s w harvester with the primary key.
	*
	* @param cswharvesterid the primary key of the c s w harvester to get
	* @return the c s w harvester
	* @throws PortalException if a c s w harvester with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static nl.wur.alterra.cgi.ace.model.CSWHarvester getCSWHarvester(
		long cswharvesterid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCSWHarvester(cswharvesterid);
	}

	/**
	* Gets a range of all the c s w harvesters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of c s w harvesters to return
	* @param end the upper bound of the range of c s w harvesters to return (not inclusive)
	* @return the range of c s w harvesters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<nl.wur.alterra.cgi.ace.model.CSWHarvester> getCSWHarvesters(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCSWHarvesters(start, end);
	}

	/**
	* Gets the number of c s w harvesters.
	*
	* @return the number of c s w harvesters
	* @throws SystemException if a system exception occurred
	*/
	public static int getCSWHarvestersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCSWHarvestersCount();
	}

	/**
	* Updates the c s w harvester in the database. Also notifies the appropriate model listeners.
	*
	* @param cswHarvester the c s w harvester to update
	* @return the c s w harvester that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static nl.wur.alterra.cgi.ace.model.CSWHarvester updateCSWHarvester(
		nl.wur.alterra.cgi.ace.model.CSWHarvester cswHarvester)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCSWHarvester(cswHarvester);
	}

	/**
	* Updates the c s w harvester in the database. Also notifies the appropriate model listeners.
	*
	* @param cswHarvester the c s w harvester to update
	* @param merge whether to merge the c s w harvester with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the c s w harvester that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static nl.wur.alterra.cgi.ace.model.CSWHarvester updateCSWHarvester(
		nl.wur.alterra.cgi.ace.model.CSWHarvester cswHarvester, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCSWHarvester(cswHarvester, merge);
	}

	/**
	* Creates empty CSWHarvester.
	*
	* @return cswharvester
	*/
	public static nl.wur.alterra.cgi.ace.model.CSWHarvester createCSWHarvester() {
		return getService().createCSWHarvester();
	}

	/**
	* Updates a CSWHarvester. Also tries to update in GeoNetwork if asked to do so. Sets status to GEONETWORK_UPDATE_FAILURE
	* if GeoNetwork update fails; sets it to NEVER_RUN if status was not already SUCCESS. Removes existing scheduler and
	* creates a new one if asked to do so.
	*
	* @param cswHarvester
	* @param propagateToGeoNetwork
	* @param reschedule
	* @return
	* @throws com.liferay.portal.kernel.exception.SystemException
	*/
	public static nl.wur.alterra.cgi.ace.model.CSWHarvester updateCSWHarvester(
		nl.wur.alterra.cgi.ace.model.CSWHarvester cswHarvester,
		java.lang.Boolean propagateToGeoNetwork, java.lang.Boolean reschedule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateCSWHarvester(cswHarvester, propagateToGeoNetwork,
			reschedule);
	}

	/**
	* Gets a list with all the CSWHarvesters in a group.
	*/
	public static java.util.List<nl.wur.alterra.cgi.ace.model.CSWHarvester> getCSWHarvesterByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCSWHarvesterByGroupId(groupId);
	}

	/**
	* Gets a list with a range of CSWHarvesters from a group.
	*/
	public static java.util.List<nl.wur.alterra.cgi.ace.model.CSWHarvester> getCSWHarvestersByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCSWHarvestersByGroupId(groupId, start, end);
	}

	/**
	* Gets the number of CSWHarvesters in a group.
	*/
	public static int getCSWHarvestersCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCSWHarvestersCountByGroupId(groupId);
	}

	public static void clearService() {
		_service = null;
	}

	public static CSWHarvesterLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					CSWHarvesterLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new CSWHarvesterLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(CSWHarvesterLocalService service) {
		_service = service;
	}

	private static CSWHarvesterLocalService _service;
}