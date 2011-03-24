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
 * This class is a wrapper for {@link MeasureLocalService}.
 * </p>
 *
 * @author    groot052
 * @see       MeasureLocalService
 * @generated
 */
public class MeasureLocalServiceWrapper implements MeasureLocalService {
	public MeasureLocalServiceWrapper(MeasureLocalService measureLocalService) {
		_measureLocalService = measureLocalService;
	}

	/**
	* Adds the measure to the database. Also notifies the appropriate model listeners.
	*
	* @param measure the measure to add
	* @return the measure that was added
	* @throws SystemException if a system exception occurred
	*/
	public nl.wur.alterra.cgi.ace.model.Measure addMeasure(
		nl.wur.alterra.cgi.ace.model.Measure measure)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _measureLocalService.addMeasure(measure);
	}

	/**
	* Creates a new measure with the primary key. Does not add the measure to the database.
	*
	* @param measureId the primary key for the new measure
	* @return the new measure
	*/
	public nl.wur.alterra.cgi.ace.model.Measure createMeasure(long measureId) {
		return _measureLocalService.createMeasure(measureId);
	}

	/**
	* Deletes the measure with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param measureId the primary key of the measure to delete
	* @throws PortalException if a measure with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteMeasure(long measureId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_measureLocalService.deleteMeasure(measureId);
	}

	/**
	* Deletes the measure from the database. Also notifies the appropriate model listeners.
	*
	* @param measure the measure to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteMeasure(nl.wur.alterra.cgi.ace.model.Measure measure)
		throws com.liferay.portal.kernel.exception.SystemException {
		_measureLocalService.deleteMeasure(measure);
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
		return _measureLocalService.dynamicQuery(dynamicQuery);
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
		return _measureLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _measureLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _measureLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the measure with the primary key.
	*
	* @param measureId the primary key of the measure to get
	* @return the measure
	* @throws PortalException if a measure with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public nl.wur.alterra.cgi.ace.model.Measure getMeasure(long measureId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _measureLocalService.getMeasure(measureId);
	}

	/**
	* Gets a range of all the measures.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of measures to return
	* @param end the upper bound of the range of measures to return (not inclusive)
	* @return the range of measures
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<nl.wur.alterra.cgi.ace.model.Measure> getMeasures(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _measureLocalService.getMeasures(start, end);
	}

	/**
	* Gets the number of measures.
	*
	* @return the number of measures
	* @throws SystemException if a system exception occurred
	*/
	public int getMeasuresCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _measureLocalService.getMeasuresCount();
	}

	/**
	* Updates the measure in the database. Also notifies the appropriate model listeners.
	*
	* @param measure the measure to update
	* @return the measure that was updated
	* @throws SystemException if a system exception occurred
	*/
	public nl.wur.alterra.cgi.ace.model.Measure updateMeasure(
		nl.wur.alterra.cgi.ace.model.Measure measure)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _measureLocalService.updateMeasure(measure);
	}

	/**
	* Updates the measure in the database. Also notifies the appropriate model listeners.
	*
	* @param measure the measure to update
	* @param merge whether to merge the measure with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the measure that was updated
	* @throws SystemException if a system exception occurred
	*/
	public nl.wur.alterra.cgi.ace.model.Measure updateMeasure(
		nl.wur.alterra.cgi.ace.model.Measure measure, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _measureLocalService.updateMeasure(measure, merge);
	}

	/**
	* Hugo de Groot: add these methods by hand to <portlet>LocalServiceImpl
	* and rerun ServiceBuilder if auto generation fails
	*
	* Gets a list with all the Measures in a group
	*/
	public java.util.List<nl.wur.alterra.cgi.ace.model.Measure> getMeasuresByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _measureLocalService.getMeasuresByGroupId(groupId);
	}

	/**
	* Hugo de Groot: add these methods by hand to <portlet>LocalServiceImpl
	* and rerun ServiceBuilder if auto generation fails
	*
	* Gets a list with a range of Measures from a group
	*/
	public java.util.List<nl.wur.alterra.cgi.ace.model.Measure> getMeasuresByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _measureLocalService.getMeasuresByGroupId(groupId, start, end);
	}

	/**
	* Hugo de Groot: add these methods by hand to <portlet>LocalServiceImpl
	* and rerun ServiceBuilder if auto generation fails
	*
	* Gets the number of Measures in a group
	*/
	public int getMeasuresCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _measureLocalService.getMeasuresCountByGroupId(groupId);
	}

	public MeasureLocalService getWrappedMeasureLocalService() {
		return _measureLocalService;
	}

	private MeasureLocalService _measureLocalService;
}