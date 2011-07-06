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

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.BaseModel;

import nl.wur.alterra.cgi.ace.model.MeasureClp;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static final String SERVLET_CONTEXT_NAME = "Measure-portlet";

	public static void setClassLoader(ClassLoader classLoader) {
		_classLoader = classLoader;
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(MeasureClp.class.getName())) {
			MeasureClp oldCplModel = (MeasureClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("nl.wur.alterra.cgi.ace.model.impl.MeasureImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setMeasureId",
							new Class[] { Long.TYPE });

					Long value0 = new Long(oldCplModel.getMeasureId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setCompanyId",
							new Class[] { Long.TYPE });

					Long value1 = new Long(oldCplModel.getCompanyId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setGroupId",
							new Class[] { Long.TYPE });

					Long value2 = new Long(oldCplModel.getGroupId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setName",
							new Class[] { String.class });

					String value3 = oldCplModel.getName();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setDescription",
							new Class[] { String.class });

					String value4 = oldCplModel.getDescription();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setImplementationtype",
							new Class[] { String.class });

					String value5 = oldCplModel.getImplementationtype();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setImplementationtime",
							new Class[] { String.class });

					String value6 = oldCplModel.getImplementationtime();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setLifetime",
							new Class[] { String.class });

					String value7 = oldCplModel.getLifetime();

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setSpatiallayer",
							new Class[] { String.class });

					String value8 = oldCplModel.getSpatiallayer();

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setSpatialvalues",
							new Class[] { String.class });

					String value9 = oldCplModel.getSpatialvalues();

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setLegalaspects",
							new Class[] { String.class });

					String value10 = oldCplModel.getLegalaspects();

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setStakeholderparticipation",
							new Class[] { String.class });

					String value11 = oldCplModel.getStakeholderparticipation();

					method11.invoke(newModel, value11);

					Method method12 = newModelClass.getMethod("setContact",
							new Class[] { String.class });

					String value12 = oldCplModel.getContact();

					method12.invoke(newModel, value12);

					Method method13 = newModelClass.getMethod("setSucceslimitations",
							new Class[] { String.class });

					String value13 = oldCplModel.getSucceslimitations();

					method13.invoke(newModel, value13);

					Method method14 = newModelClass.getMethod("setWebsite",
							new Class[] { String.class });

					String value14 = oldCplModel.getWebsite();

					method14.invoke(newModel, value14);

					Method method15 = newModelClass.getMethod("setCostbenefit",
							new Class[] { String.class });

					String value15 = oldCplModel.getCostbenefit();

					method15.invoke(newModel, value15);

					Method method16 = newModelClass.getMethod("setKeywords",
							new Class[] { String.class });

					String value16 = oldCplModel.getKeywords();

					method16.invoke(newModel, value16);

					Method method17 = newModelClass.getMethod("setStartdate",
							new Class[] { Date.class });

					Date value17 = oldCplModel.getStartdate();

					method17.invoke(newModel, value17);

					Method method18 = newModelClass.getMethod("setEnddate",
							new Class[] { Date.class });

					Date value18 = oldCplModel.getEnddate();

					method18.invoke(newModel, value18);

					Method method19 = newModelClass.getMethod("setPublicationdate",
							new Class[] { Date.class });

					Date value19 = oldCplModel.getPublicationdate();

					method19.invoke(newModel, value19);

					Method method20 = newModelClass.getMethod("setLanguage",
							new Class[] { String.class });

					String value20 = oldCplModel.getLanguage();

					method20.invoke(newModel, value20);

					Method method21 = newModelClass.getMethod("setSectors_",
							new Class[] { String.class });

					String value21 = oldCplModel.getSectors_();

					method21.invoke(newModel, value21);

					Method method22 = newModelClass.getMethod("setElements_",
							new Class[] { String.class });

					String value22 = oldCplModel.getElements_();

					method22.invoke(newModel, value22);

					Method method23 = newModelClass.getMethod("setClimateimpacts_",
							new Class[] { String.class });

					String value23 = oldCplModel.getClimateimpacts_();

					method23.invoke(newModel, value23);

					Method method24 = newModelClass.getMethod("setMao_type",
							new Class[] { String.class });

					String value24 = oldCplModel.getMao_type();

					method24.invoke(newModel, value24);

					Method method25 = newModelClass.getMethod("setSource",
							new Class[] { String.class });

					String value25 = oldCplModel.getSource();

					method25.invoke(newModel, value25);

					Method method26 = newModelClass.getMethod("setRating",
							new Class[] { Long.TYPE });

					Long value26 = new Long(oldCplModel.getRating());

					method26.invoke(newModel, value26);

					Method method27 = newModelClass.getMethod("setImportance",
							new Class[] { Long.TYPE });

					Long value27 = new Long(oldCplModel.getImportance());

					method27.invoke(newModel, value27);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"nl.wur.alterra.cgi.ace.model.impl.MeasureImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					MeasureClp newModel = new MeasureClp();

					Method method0 = oldModelClass.getMethod("getMeasureId");

					Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

					newModel.setMeasureId(value0);

					Method method1 = oldModelClass.getMethod("getCompanyId");

					Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

					newModel.setCompanyId(value1);

					Method method2 = oldModelClass.getMethod("getGroupId");

					Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

					newModel.setGroupId(value2);

					Method method3 = oldModelClass.getMethod("getName");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setName(value3);

					Method method4 = oldModelClass.getMethod("getDescription");

					String value4 = (String)method4.invoke(oldModel,
							(Object[])null);

					newModel.setDescription(value4);

					Method method5 = oldModelClass.getMethod(
							"getImplementationtype");

					String value5 = (String)method5.invoke(oldModel,
							(Object[])null);

					newModel.setImplementationtype(value5);

					Method method6 = oldModelClass.getMethod(
							"getImplementationtime");

					String value6 = (String)method6.invoke(oldModel,
							(Object[])null);

					newModel.setImplementationtime(value6);

					Method method7 = oldModelClass.getMethod("getLifetime");

					String value7 = (String)method7.invoke(oldModel,
							(Object[])null);

					newModel.setLifetime(value7);

					Method method8 = oldModelClass.getMethod("getSpatiallayer");

					String value8 = (String)method8.invoke(oldModel,
							(Object[])null);

					newModel.setSpatiallayer(value8);

					Method method9 = oldModelClass.getMethod("getSpatialvalues");

					String value9 = (String)method9.invoke(oldModel,
							(Object[])null);

					newModel.setSpatialvalues(value9);

					Method method10 = oldModelClass.getMethod("getLegalaspects");

					String value10 = (String)method10.invoke(oldModel,
							(Object[])null);

					newModel.setLegalaspects(value10);

					Method method11 = oldModelClass.getMethod(
							"getStakeholderparticipation");

					String value11 = (String)method11.invoke(oldModel,
							(Object[])null);

					newModel.setStakeholderparticipation(value11);

					Method method12 = oldModelClass.getMethod("getContact");

					String value12 = (String)method12.invoke(oldModel,
							(Object[])null);

					newModel.setContact(value12);

					Method method13 = oldModelClass.getMethod(
							"getSucceslimitations");

					String value13 = (String)method13.invoke(oldModel,
							(Object[])null);

					newModel.setSucceslimitations(value13);

					Method method14 = oldModelClass.getMethod("getWebsite");

					String value14 = (String)method14.invoke(oldModel,
							(Object[])null);

					newModel.setWebsite(value14);

					Method method15 = oldModelClass.getMethod("getCostbenefit");

					String value15 = (String)method15.invoke(oldModel,
							(Object[])null);

					newModel.setCostbenefit(value15);

					Method method16 = oldModelClass.getMethod("getKeywords");

					String value16 = (String)method16.invoke(oldModel,
							(Object[])null);

					newModel.setKeywords(value16);

					Method method17 = oldModelClass.getMethod("getStartdate");

					Date value17 = (Date)method17.invoke(oldModel,
							(Object[])null);

					newModel.setStartdate(value17);

					Method method18 = oldModelClass.getMethod("getEnddate");

					Date value18 = (Date)method18.invoke(oldModel,
							(Object[])null);

					newModel.setEnddate(value18);

					Method method19 = oldModelClass.getMethod(
							"getPublicationdate");

					Date value19 = (Date)method19.invoke(oldModel,
							(Object[])null);

					newModel.setPublicationdate(value19);

					Method method20 = oldModelClass.getMethod("getLanguage");

					String value20 = (String)method20.invoke(oldModel,
							(Object[])null);

					newModel.setLanguage(value20);

					Method method21 = oldModelClass.getMethod("getSectors_");

					String value21 = (String)method21.invoke(oldModel,
							(Object[])null);

					newModel.setSectors_(value21);

					Method method22 = oldModelClass.getMethod("getElements_");

					String value22 = (String)method22.invoke(oldModel,
							(Object[])null);

					newModel.setElements_(value22);

					Method method23 = oldModelClass.getMethod(
							"getClimateimpacts_");

					String value23 = (String)method23.invoke(oldModel,
							(Object[])null);

					newModel.setClimateimpacts_(value23);

					Method method24 = oldModelClass.getMethod("getMao_type");

					String value24 = (String)method24.invoke(oldModel,
							(Object[])null);

					newModel.setMao_type(value24);

					Method method25 = oldModelClass.getMethod("getSource");

					String value25 = (String)method25.invoke(oldModel,
							(Object[])null);

					newModel.setSource(value25);

					Method method26 = oldModelClass.getMethod("getRating");

					Long value26 = (Long)method26.invoke(oldModel,
							(Object[])null);

					newModel.setRating(value26);

					Method method27 = oldModelClass.getMethod("getImportance");

					Long value27 = (Long)method27.invoke(oldModel,
							(Object[])null);

					newModel.setImportance(value27);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static ClassLoader _classLoader;
}