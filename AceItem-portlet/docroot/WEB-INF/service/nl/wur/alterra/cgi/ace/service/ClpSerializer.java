/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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
import nl.wur.alterra.cgi.ace.model.CSWHarvesterClp;
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

					Method method4 = newModelClass.getMethod("setCswharvesterId",
							new Class[] { Long.TYPE });

					Long value4 = new Long(oldCplModel.getCswharvesterId());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setName",
							new Class[] { String.class });

					String value5 = oldCplModel.getName();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setDescription",
							new Class[] { String.class });

					String value6 = oldCplModel.getDescription();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setDatatype",
							new Class[] { String.class });

					String value7 = oldCplModel.getDatatype();

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setStoredAt",
							new Class[] { String.class });

					String value8 = oldCplModel.getStoredAt();

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setStoragetype",
							new Class[] { String.class });

					String value9 = oldCplModel.getStoragetype();

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setSpecialtagging",
							new Class[] { String.class });

					String value10 = oldCplModel.getSpecialtagging();

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setTextSearch",
							new Class[] { String.class });

					String value11 = oldCplModel.getTextSearch();

					method11.invoke(newModel, value11);

					Method method12 = newModelClass.getMethod("setKeyword",
							new Class[] { String.class });

					String value12 = oldCplModel.getKeyword();

					method12.invoke(newModel, value12);

					Method method13 = newModelClass.getMethod("setTargetresolution",
							new Class[] { String.class });

					String value13 = oldCplModel.getTargetresolution();

					method13.invoke(newModel, value13);

					Method method14 = newModelClass.getMethod("setSpatialLayer",
							new Class[] { String.class });

					String value14 = oldCplModel.getSpatialLayer();

					method14.invoke(newModel, value14);

					Method method15 = newModelClass.getMethod("setSpatialValues",
							new Class[] { String.class });

					String value15 = oldCplModel.getSpatialValues();

					method15.invoke(newModel, value15);

					Method method16 = newModelClass.getMethod("setStartDate",
							new Class[] { Date.class });

					Date value16 = oldCplModel.getStartDate();

					method16.invoke(newModel, value16);

					Method method17 = newModelClass.getMethod("setEndDate",
							new Class[] { Date.class });

					Date value17 = oldCplModel.getEndDate();

					method17.invoke(newModel, value17);

					Method method18 = newModelClass.getMethod("setPublicationDate",
							new Class[] { Date.class });

					Date value18 = oldCplModel.getPublicationDate();

					method18.invoke(newModel, value18);

					Method method19 = newModelClass.getMethod("setSectors_",
							new Class[] { String.class });

					String value19 = oldCplModel.getSectors_();

					method19.invoke(newModel, value19);

					Method method20 = newModelClass.getMethod("setElements_",
							new Class[] { String.class });

					String value20 = oldCplModel.getElements_();

					method20.invoke(newModel, value20);

					Method method21 = newModelClass.getMethod("setClimateimpacts_",
							new Class[] { String.class });

					String value21 = oldCplModel.getClimateimpacts_();

					method21.invoke(newModel, value21);

					Method method22 = newModelClass.getMethod("setRating",
							new Class[] { Long.TYPE });

					Long value22 = new Long(oldCplModel.getRating());

					method22.invoke(newModel, value22);

					Method method23 = newModelClass.getMethod("setImportance",
							new Class[] { Long.TYPE });

					Long value23 = new Long(oldCplModel.getImportance());

					method23.invoke(newModel, value23);

					Method method24 = newModelClass.getMethod("setSource",
							new Class[] { String.class });

					String value24 = oldCplModel.getSource();

					method24.invoke(newModel, value24);

					Method method25 = newModelClass.getMethod("setDeeplink",
							new Class[] { String.class });

					String value25 = oldCplModel.getDeeplink();

					method25.invoke(newModel, value25);

					Method method26 = newModelClass.getMethod("setControlstatus",
							new Class[] { Short.TYPE });

					Short value26 = new Short(oldCplModel.getControlstatus());

					method26.invoke(newModel, value26);

					Method method27 = newModelClass.getMethod("setCreator",
							new Class[] { String.class });

					String value27 = oldCplModel.getCreator();

					method27.invoke(newModel, value27);

					Method method28 = newModelClass.getMethod("setCreationdate",
							new Class[] { Date.class });

					Date value28 = oldCplModel.getCreationdate();

					method28.invoke(newModel, value28);

					Method method29 = newModelClass.getMethod("setModerator",
							new Class[] { String.class });

					String value29 = oldCplModel.getModerator();

					method29.invoke(newModel, value29);

					Method method30 = newModelClass.getMethod("setApprovaldate",
							new Class[] { Date.class });

					Date value30 = oldCplModel.getApprovaldate();

					method30.invoke(newModel, value30);

					Method method31 = newModelClass.getMethod("setReplacesId",
							new Class[] { Long.TYPE });

					Long value31 = new Long(oldCplModel.getReplacesId());

					method31.invoke(newModel, value31);

					Method method32 = newModelClass.getMethod("setComments",
							new Class[] { String.class });

					String value32 = oldCplModel.getComments();

					method32.invoke(newModel, value32);

					Method method33 = newModelClass.getMethod("setTextwebpage",
							new Class[] { String.class });

					String value33 = oldCplModel.getTextwebpage();

					method33.invoke(newModel, value33);

					Method method34 = newModelClass.getMethod("setYear",
							new Class[] { String.class });

					String value34 = oldCplModel.getYear();

					method34.invoke(newModel, value34);

					Method method35 = newModelClass.getMethod("setGeochars",
							new Class[] { String.class });

					String value35 = oldCplModel.getGeochars();

					method35.invoke(newModel, value35);

					Method method36 = newModelClass.getMethod("setFeature",
							new Class[] { String.class });

					String value36 = oldCplModel.getFeature();

					method36.invoke(newModel, value36);

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

					Method method6 = newModelClass.getMethod("setStatus",
							new Class[] { String.class });

					String value6 = oldCplModel.getStatus();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setSavedToGeoNetwork",
							new Class[] { Boolean.TYPE });

					Boolean value7 = new Boolean(oldCplModel.getSavedToGeoNetwork());

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setGeonetworkId",
							new Class[] { Long.TYPE });

					Long value8 = new Long(oldCplModel.getGeonetworkId());

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setGeonetworkUUID",
							new Class[] { String.class });

					String value9 = oldCplModel.getGeonetworkUUID();

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setCompanyId",
							new Class[] { Long.TYPE });

					Long value10 = new Long(oldCplModel.getCompanyId());

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setGroupId",
							new Class[] { Long.TYPE });

					Long value11 = new Long(oldCplModel.getGroupId());

					method11.invoke(newModel, value11);

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

		if (oldModelClassName.equals(CSWHarvesterClp.class.getName())) {
			CSWHarvesterClp oldCplModel = (CSWHarvesterClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("nl.wur.alterra.cgi.ace.model.impl.CSWHarvesterImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setCswharvesterid",
							new Class[] { Long.TYPE });

					Long value0 = new Long(oldCplModel.getCswharvesterid());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setName",
							new Class[] { String.class });

					String value1 = oldCplModel.getName();

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setUrl",
							new Class[] { String.class });

					String value2 = oldCplModel.getUrl();

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setFreetext",
							new Class[] { String.class });

					String value3 = oldCplModel.getFreetext();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setTitle",
							new Class[] { String.class });

					String value4 = oldCplModel.getTitle();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setAbstrakt",
							new Class[] { String.class });

					String value5 = oldCplModel.getAbstrakt();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setSubject",
							new Class[] { String.class });

					String value6 = oldCplModel.getSubject();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setEvery",
							new Class[] { Integer.TYPE });

					Integer value7 = new Integer(oldCplModel.getEvery());

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setTopic",
							new Class[] { String.class });

					String value8 = oldCplModel.getTopic();

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setStatus",
							new Class[] { String.class });

					String value9 = oldCplModel.getStatus();

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setSavedToGeoNetwork",
							new Class[] { Boolean.TYPE });

					Boolean value10 = new Boolean(oldCplModel.getSavedToGeoNetwork());

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setGeonetworkId",
							new Class[] { Long.TYPE });

					Long value11 = new Long(oldCplModel.getGeonetworkId());

					method11.invoke(newModel, value11);

					Method method12 = newModelClass.getMethod("setGeonetworkUUID",
							new Class[] { String.class });

					String value12 = oldCplModel.getGeonetworkUUID();

					method12.invoke(newModel, value12);

					Method method13 = newModelClass.getMethod("setCompanyId",
							new Class[] { Long.TYPE });

					Long value13 = new Long(oldCplModel.getCompanyId());

					method13.invoke(newModel, value13);

					Method method14 = newModelClass.getMethod("setGroupId",
							new Class[] { Long.TYPE });

					Long value14 = new Long(oldCplModel.getGroupId());

					method14.invoke(newModel, value14);

					Method method15 = newModelClass.getMethod("setType",
							new Class[] { String.class });

					String value15 = oldCplModel.getType();

					method15.invoke(newModel, value15);

					Method method16 = newModelClass.getMethod("setUsername",
							new Class[] { String.class });

					String value16 = oldCplModel.getUsername();

					method16.invoke(newModel, value16);

					Method method17 = newModelClass.getMethod("setPassword",
							new Class[] { String.class });

					String value17 = oldCplModel.getPassword();

					method17.invoke(newModel, value17);

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

					Method method4 = oldModelClass.getMethod(
							"getCswharvesterId");

					Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

					newModel.setCswharvesterId(value4);

					Method method5 = oldModelClass.getMethod("getName");

					String value5 = (String)method5.invoke(oldModel,
							(Object[])null);

					newModel.setName(value5);

					Method method6 = oldModelClass.getMethod("getDescription");

					String value6 = (String)method6.invoke(oldModel,
							(Object[])null);

					newModel.setDescription(value6);

					Method method7 = oldModelClass.getMethod("getDatatype");

					String value7 = (String)method7.invoke(oldModel,
							(Object[])null);

					newModel.setDatatype(value7);

					Method method8 = oldModelClass.getMethod("getStoredAt");

					String value8 = (String)method8.invoke(oldModel,
							(Object[])null);

					newModel.setStoredAt(value8);

					Method method9 = oldModelClass.getMethod("getStoragetype");

					String value9 = (String)method9.invoke(oldModel,
							(Object[])null);

					newModel.setStoragetype(value9);

					Method method10 = oldModelClass.getMethod(
							"getSpecialtagging");

					String value10 = (String)method10.invoke(oldModel,
							(Object[])null);

					newModel.setSpecialtagging(value10);

					Method method11 = oldModelClass.getMethod("getTextSearch");

					String value11 = (String)method11.invoke(oldModel,
							(Object[])null);

					newModel.setTextSearch(value11);

					Method method12 = oldModelClass.getMethod("getKeyword");

					String value12 = (String)method12.invoke(oldModel,
							(Object[])null);

					newModel.setKeyword(value12);

					Method method13 = oldModelClass.getMethod(
							"getTargetresolution");

					String value13 = (String)method13.invoke(oldModel,
							(Object[])null);

					newModel.setTargetresolution(value13);

					Method method14 = oldModelClass.getMethod("getSpatialLayer");

					String value14 = (String)method14.invoke(oldModel,
							(Object[])null);

					newModel.setSpatialLayer(value14);

					Method method15 = oldModelClass.getMethod(
							"getSpatialValues");

					String value15 = (String)method15.invoke(oldModel,
							(Object[])null);

					newModel.setSpatialValues(value15);

					Method method16 = oldModelClass.getMethod("getStartDate");

					Date value16 = (Date)method16.invoke(oldModel,
							(Object[])null);

					newModel.setStartDate(value16);

					Method method17 = oldModelClass.getMethod("getEndDate");

					Date value17 = (Date)method17.invoke(oldModel,
							(Object[])null);

					newModel.setEndDate(value17);

					Method method18 = oldModelClass.getMethod(
							"getPublicationDate");

					Date value18 = (Date)method18.invoke(oldModel,
							(Object[])null);

					newModel.setPublicationDate(value18);

					Method method19 = oldModelClass.getMethod("getSectors_");

					String value19 = (String)method19.invoke(oldModel,
							(Object[])null);

					newModel.setSectors_(value19);

					Method method20 = oldModelClass.getMethod("getElements_");

					String value20 = (String)method20.invoke(oldModel,
							(Object[])null);

					newModel.setElements_(value20);

					Method method21 = oldModelClass.getMethod(
							"getClimateimpacts_");

					String value21 = (String)method21.invoke(oldModel,
							(Object[])null);

					newModel.setClimateimpacts_(value21);

					Method method22 = oldModelClass.getMethod("getRating");

					Long value22 = (Long)method22.invoke(oldModel,
							(Object[])null);

					newModel.setRating(value22);

					Method method23 = oldModelClass.getMethod("getImportance");

					Long value23 = (Long)method23.invoke(oldModel,
							(Object[])null);

					newModel.setImportance(value23);

					Method method24 = oldModelClass.getMethod("getSource");

					String value24 = (String)method24.invoke(oldModel,
							(Object[])null);

					newModel.setSource(value24);

					Method method25 = oldModelClass.getMethod("getDeeplink");

					String value25 = (String)method25.invoke(oldModel,
							(Object[])null);

					newModel.setDeeplink(value25);

					Method method26 = oldModelClass.getMethod(
							"getControlstatus");

					Short value26 = (Short)method26.invoke(oldModel,
							(Object[])null);

					newModel.setControlstatus(value26);

					Method method27 = oldModelClass.getMethod("getCreator");

					String value27 = (String)method27.invoke(oldModel,
							(Object[])null);

					newModel.setCreator(value27);

					Method method28 = oldModelClass.getMethod("getCreationdate");

					Date value28 = (Date)method28.invoke(oldModel,
							(Object[])null);

					newModel.setCreationdate(value28);

					Method method29 = oldModelClass.getMethod("getModerator");

					String value29 = (String)method29.invoke(oldModel,
							(Object[])null);

					newModel.setModerator(value29);

					Method method30 = oldModelClass.getMethod("getApprovaldate");

					Date value30 = (Date)method30.invoke(oldModel,
							(Object[])null);

					newModel.setApprovaldate(value30);

					Method method31 = oldModelClass.getMethod("getReplacesId");

					Long value31 = (Long)method31.invoke(oldModel,
							(Object[])null);

					newModel.setReplacesId(value31);

					Method method32 = oldModelClass.getMethod("getComments");

					String value32 = (String)method32.invoke(oldModel,
							(Object[])null);

					newModel.setComments(value32);

					Method method33 = oldModelClass.getMethod("getTextwebpage");

					String value33 = (String)method33.invoke(oldModel,
							(Object[])null);

					newModel.setTextwebpage(value33);

					Method method34 = oldModelClass.getMethod("getYear");

					String value34 = (String)method34.invoke(oldModel,
							(Object[])null);

					newModel.setYear(value34);

					Method method35 = oldModelClass.getMethod("getGeochars");

					String value35 = (String)method35.invoke(oldModel,
							(Object[])null);

					newModel.setGeochars(value35);

					Method method36 = oldModelClass.getMethod("getFeature");

					String value36 = (String)method36.invoke(oldModel,
							(Object[])null);

					newModel.setFeature(value36);

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

					Method method6 = oldModelClass.getMethod("getStatus");

					String value6 = (String)method6.invoke(oldModel,
							(Object[])null);

					newModel.setStatus(value6);

					Method method7 = oldModelClass.getMethod(
							"getSavedToGeoNetwork");

					Boolean value7 = (Boolean)method7.invoke(oldModel,
							(Object[])null);

					newModel.setSavedToGeoNetwork(value7);

					Method method8 = oldModelClass.getMethod("getGeonetworkId");

					Long value8 = (Long)method8.invoke(oldModel, (Object[])null);

					newModel.setGeonetworkId(value8);

					Method method9 = oldModelClass.getMethod(
							"getGeonetworkUUID");

					String value9 = (String)method9.invoke(oldModel,
							(Object[])null);

					newModel.setGeonetworkUUID(value9);

					Method method10 = oldModelClass.getMethod("getCompanyId");

					Long value10 = (Long)method10.invoke(oldModel,
							(Object[])null);

					newModel.setCompanyId(value10);

					Method method11 = oldModelClass.getMethod("getGroupId");

					Long value11 = (Long)method11.invoke(oldModel,
							(Object[])null);

					newModel.setGroupId(value11);

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
					"nl.wur.alterra.cgi.ace.model.impl.CSWHarvesterImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					CSWHarvesterClp newModel = new CSWHarvesterClp();

					Method method0 = oldModelClass.getMethod(
							"getCswharvesterid");

					Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

					newModel.setCswharvesterid(value0);

					Method method1 = oldModelClass.getMethod("getName");

					String value1 = (String)method1.invoke(oldModel,
							(Object[])null);

					newModel.setName(value1);

					Method method2 = oldModelClass.getMethod("getUrl");

					String value2 = (String)method2.invoke(oldModel,
							(Object[])null);

					newModel.setUrl(value2);

					Method method3 = oldModelClass.getMethod("getFreetext");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setFreetext(value3);

					Method method4 = oldModelClass.getMethod("getTitle");

					String value4 = (String)method4.invoke(oldModel,
							(Object[])null);

					newModel.setTitle(value4);

					Method method5 = oldModelClass.getMethod("getAbstrakt");

					String value5 = (String)method5.invoke(oldModel,
							(Object[])null);

					newModel.setAbstrakt(value5);

					Method method6 = oldModelClass.getMethod("getSubject");

					String value6 = (String)method6.invoke(oldModel,
							(Object[])null);

					newModel.setSubject(value6);

					Method method7 = oldModelClass.getMethod("getEvery");

					Integer value7 = (Integer)method7.invoke(oldModel,
							(Object[])null);

					newModel.setEvery(value7);

					Method method8 = oldModelClass.getMethod("getTopic");

					String value8 = (String)method8.invoke(oldModel,
							(Object[])null);

					newModel.setTopic(value8);

					Method method9 = oldModelClass.getMethod("getStatus");

					String value9 = (String)method9.invoke(oldModel,
							(Object[])null);

					newModel.setStatus(value9);

					Method method10 = oldModelClass.getMethod(
							"getSavedToGeoNetwork");

					Boolean value10 = (Boolean)method10.invoke(oldModel,
							(Object[])null);

					newModel.setSavedToGeoNetwork(value10);

					Method method11 = oldModelClass.getMethod("getGeonetworkId");

					Long value11 = (Long)method11.invoke(oldModel,
							(Object[])null);

					newModel.setGeonetworkId(value11);

					Method method12 = oldModelClass.getMethod(
							"getGeonetworkUUID");

					String value12 = (String)method12.invoke(oldModel,
							(Object[])null);

					newModel.setGeonetworkUUID(value12);

					Method method13 = oldModelClass.getMethod("getCompanyId");

					Long value13 = (Long)method13.invoke(oldModel,
							(Object[])null);

					newModel.setCompanyId(value13);

					Method method14 = oldModelClass.getMethod("getGroupId");

					Long value14 = (Long)method14.invoke(oldModel,
							(Object[])null);

					newModel.setGroupId(value14);

					Method method15 = oldModelClass.getMethod("getType");

					String value15 = (String)method15.invoke(oldModel,
							(Object[])null);

					newModel.setType(value15);

					Method method16 = oldModelClass.getMethod("getUsername");

					String value16 = (String)method16.invoke(oldModel,
							(Object[])null);

					newModel.setUsername(value16);

					Method method17 = oldModelClass.getMethod("getPassword");

					String value17 = (String)method17.invoke(oldModel,
							(Object[])null);

					newModel.setPassword(value17);

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