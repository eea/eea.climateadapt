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

package nl.wur.alterra.cgi.ace.service.impl;
import java.util.List;

import nl.wur.alterra.cgi.ace.model.Measure;
import nl.wur.alterra.cgi.ace.service.base.MeasureLocalServiceBaseImpl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * The implementation of the measure local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link nl.wur.alterra.cgi.ace.service.MeasureLocalService} interface.
 * </p>
 *
 * <p>
 * Never reference this interface directly. Always use {@link nl.wur.alterra.cgi.ace.service.MeasureLocalServiceUtil} to access the measure local service.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author groot052
 * @see nl.wur.alterra.cgi.ace.service.base.MeasureLocalServiceBaseImpl
 * @see nl.wur.alterra.cgi.ace.service.MeasureLocalServiceUtil
 */
public class MeasureLocalServiceImpl extends MeasureLocalServiceBaseImpl {


	/**
	 * Adds the Measure to the database incrementing the primary key
	 *
	 */
	public Measure addMeasure(Measure measure) throws SystemException {
		long measureId = CounterLocalServiceUtil.increment(Measure.class.getName());

		measure.setMeasureId(measureId);

		return super.addMeasure(measure);
	}
	
	/**
	 * 	
	 * Hugo de Groot: add these methods by hand to <portlet>LocalServiceImpl
	 * and rerun ServiceBuilder if auto generation fails 
	 * 
	 * Gets a list with all the Measures in a group
	 *
	 */
	public List<Measure> getMeasuresByGroupId(long groupId) throws SystemException {
		return measurePersistence.findByGroupId(groupId);
	}

	/**
	 * 	
	 * Hugo de Groot: add these methods by hand to <portlet>LocalServiceImpl
	 * and rerun ServiceBuilder if auto generation fails 
	 * 
	 * Gets a list with a range of Measures from a group
	 *
	 */
	public List<Measure> getMeasuresByGroupId(long groupId, int start, int end) throws SystemException {
		return measurePersistence.findByGroupId(groupId, start, end);
	}

	/**
	 * 	
	 * Hugo de Groot: add these methods by hand to <portlet>LocalServiceImpl
	 * and rerun ServiceBuilder if auto generation fails 
	 * 
	 * Gets a list with a range of Measures from a group
	 *
	 */
	public List<Measure> getMeasuresByGroupId(long groupId, int start, int end, OrderByComparator orderByComparator) throws SystemException {
		return measurePersistence.findByGroupId(groupId, start, end, orderByComparator);
	}
	
	/**
	 * 	
	 * Hugo de Groot: add these methods by hand to <portlet>LocalServiceImpl
	 * and rerun ServiceBuilder if auto generation fails 
	 * 
	 * Gets the number of Measures in a group
	 *
	 */
	public int getMeasuresCountByGroupId(long groupId) throws SystemException {
		return measurePersistence.countByGroupId(groupId);
	}
}