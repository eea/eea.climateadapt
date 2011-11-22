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

import nl.wur.alterra.cgi.ace.model.AceItemClp;
import nl.wur.alterra.cgi.ace.model.WxsHarvesterClp;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static final String SERVLET_CONTEXT_NAME = "AceItem-portlet";

	public static void setClassLoader(ClassLoader classLoader) {
		_classLoader = classLoader;
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(AceItemClp.class.getName())) {
			AceItemClp oldCplModel = (AceItemClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("nl.wur.alterra.cgi.ace.model.impl.AceItemImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setAceItemId",
							new Class[] { Long.TYPE });

					Long value0 = new Long(oldCplModel.getAceItemId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setCompanyId",
							new Class[] { Long.TYPE });

					Long value1 = new Long(oldCplModel.getCompanyId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setGroupId",
							new Class[] { Long.TYPE });

					Long value2 = new Long(oldCplModel.getGroupId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setWxsharvesterId",
							new Class[] { Long.TYPE });

					Long value3 = new Long(oldCplModel.getWxsharvesterId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setName",
							new Class[] { String.class });

					String value4 = oldCplModel.getName();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setDescription",
							new Class[] { String.class });

					String value5 = oldCplModel.getDescription();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setDatatype",
							new Class[] { String.class });

					String value6 = oldCplModel.getDatatype();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setStoredAt",
							new Class[] { String.class });

					String value7 = oldCplModel.getStoredAt();

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setStoragetype",
							new Class[] { String.class });

					String value8 = oldCplModel.getStoragetype();

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setSpecialtagging",
							new Class[] { String.class });

					String value9 = oldCplModel.getSpecialtagging();

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setTextSearch",
							new Class[] { String.class });

					String value10 = oldCplModel.getTextSearch();

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setKeyword",
							new Class[] { String.class });

					String value11 = oldCplModel.getKeyword();

					method11.invoke(newModel, value11);

					Method method12 = newModelClass.getMethod("setTargetresolution",
							new Class[] { String.class });

					String value12 = oldCplModel.getTargetresolution();

					method12.invoke(newModel, value12);

					Method method13 = newModelClass.getMethod("setSpatialLayer",
							new Class[] { String.class });

					String value13 = oldCplModel.getSpatialLayer();

					method13.invoke(newModel, value13);

					Method method14 = newModelClass.getMethod("setSpatialValues",
							new Class[] { String.class });

					String value14 = oldCplModel.getSpatialValues();

					method14.invoke(newModel, value14);

					Method method15 = newModelClass.getMethod("setStartDate",
							new Class[] { Date.class });

					Date value15 = oldCplModel.getStartDate();

					method15.invoke(newModel, value15);

					Method method16 = newModelClass.getMethod("setEndDate",
							new Class[] { Date.class });

					Date value16 = oldCplModel.getEndDate();

					method16.invoke(newModel, value16);

					Method method17 = newModelClass.getMethod("setPublicationDate",
							new Class[] { Date.class });

					Date value17 = oldCplModel.getPublicationDate();

					method17.invoke(newModel, value17);

					Method method18 = newModelClass.getMethod("setSectors_",
							new Class[] { String.class });

					String value18 = oldCplModel.getSectors_();

					method18.invoke(newModel, value18);

					Method method19 = newModelClass.getMethod("setElements_",
							new Class[] { String.class });

					String value19 = oldCplModel.getElements_();

					method19.invoke(newModel, value19);

					Method method20 = newModelClass.getMethod("setClimateimpacts_",
							new Class[] { String.class });

					String value20 = oldCplModel.getClimateimpacts_();

					method20.invoke(newModel, value20);

					Method method21 = newModelClass.getMethod("setRating",
							new Class[] { Long.TYPE });

					Long value21 = new Long(oldCplModel.getRating());

					method21.invoke(newModel, value21);

					Method method22 = newModelClass.getMethod("setImportance",
							new Class[] { Long.TYPE });

					Long value22 = new Long(oldCplModel.getImportance());

					method22.invoke(newModel, value22);

					Method method23 = newModelClass.getMethod("setSource",
							new Class[] { String.class });

					String value23 = oldCplModel.getSource();

					method23.invoke(newModel, value23);

					Method method24 = newModelClass.getMethod("setDeeplink",
							new Class[] { String.class });

					String value24 = oldCplModel.getDeeplink();

					method24.invoke(newModel, value24);

					Method method25 = newModelClass.getMethod("setControlstatus",
							new Class[] { Short.TYPE });

					Short value25 = new Short(oldCplModel.getControlstatus());

					method25.invoke(newModel, value25);

					Method method26 = newModelClass.getMethod("setCreator",
							new Class[] { String.class });

					String value26 = oldCplModel.getCreator();

					method26.invoke(newModel, value26);

					Method method27 = newModelClass.getMethod("setCreationdate",
							new Class[] { Date.class });

					Date value27 = oldCplModel.getCreationdate();

					method27.invoke(newModel, value27);

					Method method28 = newModelClass.getMethod("setModerator",
							new Class[] { String.class });

					String value28 = oldCplModel.getModerator();

					method28.invoke(newModel, value28);

					Method method29 = newModelClass.getMethod("setApprovaldate",
							new Class[] { Date.class });

					Date value29 = oldCplModel.getApprovaldate();

					method29.invoke(newModel, value29);

					Method method30 = newModelClass.getMethod("setReplacesId",
							new Class[] { Long.TYPE });

					Long value30 = new Long(oldCplModel.getReplacesId());

					method30.invoke(newModel, value30);

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

		if (oldModelClassName.equals(WxsHarvesterClp.class.getName())) {
			WxsHarvesterClp oldCplModel = (WxsHarvesterClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("nl.wur.alterra.cgi.ace.model.impl.WxsHarvesterImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setWxsharvesterid",
							new Class[] { Long.TYPE });

					Long value0 = new Long(oldCplModel.getWxsharvesterid());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setName",
							new Class[] { String.class });

					String value1 = oldCplModel.getName();

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setUrl",
							new Class[] { String.class });

					String value2 = oldCplModel.getUrl();

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setOgctype",
							new Class[] { String.class });

					String value3 = oldCplModel.getOgctype();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setEvery",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getEvery());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setTopic",
							new Class[] { String.class });

					String value5 = oldCplModel.getTopic();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setSavedToGeoNetwork",
							new Class[] { Boolean.TYPE });

					Boolean value6 = new Boolean(oldCplModel.getSavedToGeoNetwork());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setGeonetworkId",
							new Class[] { Long.TYPE });

					Long value7 = new Long(oldCplModel.getGeonetworkId());

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setGeonetworkUUID",
							new Class[] { String.class });

					String value8 = oldCplModel.getGeonetworkUUID();

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setCompanyId",
							new Class[] { Long.TYPE });

					Long value9 = new Long(oldCplModel.getCompanyId());

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setGroupId",
							new Class[] { Long.TYPE });

					Long value10 = new Long(oldCplModel.getGroupId());

					method10.invoke(newModel, value10);

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
					"nl.wur.alterra.cgi.ace.model.impl.AceItemImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					AceItemClp newModel = new AceItemClp();

					Method method0 = oldModelClass.getMethod("getAceItemId");

					Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

					newModel.setAceItemId(value0);

					Method method1 = oldModelClass.getMethod("getCompanyId");

					Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

					newModel.setCompanyId(value1);

					Method method2 = oldModelClass.getMethod("getGroupId");

					Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

					newModel.setGroupId(value2);

					Method method3 = oldModelClass.getMethod(
							"getWxsharvesterId");

					Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

					newModel.setWxsharvesterId(value3);

					Method method4 = oldModelClass.getMethod("getName");

					String value4 = (String)method4.invoke(oldModel,
							(Object[])null);

					newModel.setName(value4);

					Method method5 = oldModelClass.getMethod("getDescription");

					String value5 = (String)method5.invoke(oldModel,
							(Object[])null);

					newModel.setDescription(value5);

					Method method6 = oldModelClass.getMethod("getDatatype");

					String value6 = (String)method6.invoke(oldModel,
							(Object[])null);

					newModel.setDatatype(value6);

					Method method7 = oldModelClass.getMethod("getStoredAt");

					String value7 = (String)method7.invoke(oldModel,
							(Object[])null);

					newModel.setStoredAt(value7);

					Method method8 = oldModelClass.getMethod("getStoragetype");

					String value8 = (String)method8.invoke(oldModel,
							(Object[])null);

					newModel.setStoragetype(value8);

					Method method9 = oldModelClass.getMethod(
							"getSpecialtagging");

					String value9 = (String)method9.invoke(oldModel,
							(Object[])null);

					newModel.setSpecialtagging(value9);

					Method method10 = oldModelClass.getMethod("getTextSearch");

					String value10 = (String)method10.invoke(oldModel,
							(Object[])null);

					newModel.setTextSearch(value10);

					Method method11 = oldModelClass.getMethod("getKeyword");

					String value11 = (String)method11.invoke(oldModel,
							(Object[])null);

					newModel.setKeyword(value11);

					Method method12 = oldModelClass.getMethod(
							"getTargetresolution");

					String value12 = (String)method12.invoke(oldModel,
							(Object[])null);

					newModel.setTargetresolution(value12);

					Method method13 = oldModelClass.getMethod("getSpatialLayer");

					String value13 = (String)method13.invoke(oldModel,
							(Object[])null);

					newModel.setSpatialLayer(value13);

					Method method14 = oldModelClass.getMethod(
							"getSpatialValues");

					String value14 = (String)method14.invoke(oldModel,
							(Object[])null);

					newModel.setSpatialValues(value14);

					Method method15 = oldModelClass.getMethod("getStartDate");

					Date value15 = (Date)method15.invoke(oldModel,
							(Object[])null);

					newModel.setStartDate(value15);

					Method method16 = oldModelClass.getMethod("getEndDate");

					Date value16 = (Date)method16.invoke(oldModel,
							(Object[])null);

					newModel.setEndDate(value16);

					Method method17 = oldModelClass.getMethod(
							"getPublicationDate");

					Date value17 = (Date)method17.invoke(oldModel,
							(Object[])null);

					newModel.setPublicationDate(value17);

					Method method18 = oldModelClass.getMethod("getSectors_");

					String value18 = (String)method18.invoke(oldModel,
							(Object[])null);

					newModel.setSectors_(value18);

					Method method19 = oldModelClass.getMethod("getElements_");

					String value19 = (String)method19.invoke(oldModel,
							(Object[])null);

					newModel.setElements_(value19);

					Method method20 = oldModelClass.getMethod(
							"getClimateimpacts_");

					String value20 = (String)method20.invoke(oldModel,
							(Object[])null);

					newModel.setClimateimpacts_(value20);

					Method method21 = oldModelClass.getMethod("getRating");

					Long value21 = (Long)method21.invoke(oldModel,
							(Object[])null);

					newModel.setRating(value21);

					Method method22 = oldModelClass.getMethod("getImportance");

					Long value22 = (Long)method22.invoke(oldModel,
							(Object[])null);

					newModel.setImportance(value22);

					Method method23 = oldModelClass.getMethod("getSource");

					String value23 = (String)method23.invoke(oldModel,
							(Object[])null);

					newModel.setSource(value23);

					Method method24 = oldModelClass.getMethod("getDeeplink");

					String value24 = (String)method24.invoke(oldModel,
							(Object[])null);

					newModel.setDeeplink(value24);

					Method method25 = oldModelClass.getMethod(
							"getControlstatus");

					Short value25 = (Short)method25.invoke(oldModel,
							(Object[])null);

					newModel.setControlstatus(value25);

					Method method26 = oldModelClass.getMethod("getCreator");

					String value26 = (String)method26.invoke(oldModel,
							(Object[])null);

					newModel.setCreator(value26);

					Method method27 = oldModelClass.getMethod("getCreationdate");

					Date value27 = (Date)method27.invoke(oldModel,
							(Object[])null);

					newModel.setCreationdate(value27);

					Method method28 = oldModelClass.getMethod("getModerator");

					String value28 = (String)method28.invoke(oldModel,
							(Object[])null);

					newModel.setModerator(value28);

					Method method29 = oldModelClass.getMethod("getApprovaldate");

					Date value29 = (Date)method29.invoke(oldModel,
							(Object[])null);

					newModel.setApprovaldate(value29);

					Method method30 = oldModelClass.getMethod("getReplacesId");

					Long value30 = (Long)method30.invoke(oldModel,
							(Object[])null);

					newModel.setReplacesId(value30);

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

		if (oldModelClassName.equals(
					"nl.wur.alterra.cgi.ace.model.impl.WxsHarvesterImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					WxsHarvesterClp newModel = new WxsHarvesterClp();

					Method method0 = oldModelClass.getMethod(
							"getWxsharvesterid");

					Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

					newModel.setWxsharvesterid(value0);

					Method method1 = oldModelClass.getMethod("getName");

					String value1 = (String)method1.invoke(oldModel,
							(Object[])null);

					newModel.setName(value1);

					Method method2 = oldModelClass.getMethod("getUrl");

					String value2 = (String)method2.invoke(oldModel,
							(Object[])null);

					newModel.setUrl(value2);

					Method method3 = oldModelClass.getMethod("getOgctype");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setOgctype(value3);

					Method method4 = oldModelClass.getMethod("getEvery");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setEvery(value4);

					Method method5 = oldModelClass.getMethod("getTopic");

					String value5 = (String)method5.invoke(oldModel,
							(Object[])null);

					newModel.setTopic(value5);

					Method method6 = oldModelClass.getMethod(
							"getSavedToGeoNetwork");

					Boolean value6 = (Boolean)method6.invoke(oldModel,
							(Object[])null);

					newModel.setSavedToGeoNetwork(value6);

					Method method7 = oldModelClass.getMethod("getGeonetworkId");

					Long value7 = (Long)method7.invoke(oldModel, (Object[])null);

					newModel.setGeonetworkId(value7);

					Method method8 = oldModelClass.getMethod(
							"getGeonetworkUUID");

					String value8 = (String)method8.invoke(oldModel,
							(Object[])null);

					newModel.setGeonetworkUUID(value8);

					Method method9 = oldModelClass.getMethod("getCompanyId");

					Long value9 = (Long)method9.invoke(oldModel, (Object[])null);

					newModel.setCompanyId(value9);

					Method method10 = oldModelClass.getMethod("getGroupId");

					Long value10 = (Long)method10.invoke(oldModel,
							(Object[])null);

					newModel.setGroupId(value10);

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