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

import nl.wur.alterra.cgi.ace.model.ProjectClp;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static final String SERVLET_CONTEXT_NAME = "Project-portlet";

	public static void setClassLoader(ClassLoader classLoader) {
		_classLoader = classLoader;
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(ProjectClp.class.getName())) {
			ProjectClp oldCplModel = (ProjectClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("nl.wur.alterra.cgi.ace.model.impl.ProjectImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setProjectId",
							new Class[] { Long.TYPE });

					Long value0 = new Long(oldCplModel.getProjectId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setCompanyId",
							new Class[] { Long.TYPE });

					Long value1 = new Long(oldCplModel.getCompanyId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setGroupId",
							new Class[] { Long.TYPE });

					Long value2 = new Long(oldCplModel.getGroupId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setAcronym",
							new Class[] { String.class });

					String value3 = oldCplModel.getAcronym();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setTitle",
							new Class[] { String.class });

					String value4 = oldCplModel.getTitle();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setStartdate",
							new Class[] { Date.class });

					Date value5 = oldCplModel.getStartdate();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setEnddate",
							new Class[] { Date.class });

					Date value6 = oldCplModel.getEnddate();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setLead",
							new Class[] { String.class });

					String value7 = oldCplModel.getLead();

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setPartners",
							new Class[] { String.class });

					String value8 = oldCplModel.getPartners();

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setFunding",
							new Class[] { String.class });

					String value9 = oldCplModel.getFunding();

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setSectors",
							new Class[] { String.class });

					String value10 = oldCplModel.getSectors();

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setSpatiallayer",
							new Class[] { String.class });

					String value11 = oldCplModel.getSpatiallayer();

					method11.invoke(newModel, value11);

					Method method12 = newModelClass.getMethod("setAbstracts",
							new Class[] { String.class });

					String value12 = oldCplModel.getAbstracts();

					method12.invoke(newModel, value12);

					Method method13 = newModelClass.getMethod("setElement",
							new Class[] { String.class });

					String value13 = oldCplModel.getElement();

					method13.invoke(newModel, value13);

					Method method14 = newModelClass.getMethod("setKeywords",
							new Class[] { String.class });

					String value14 = oldCplModel.getKeywords();

					method14.invoke(newModel, value14);

					Method method15 = newModelClass.getMethod("setWebsite",
							new Class[] { String.class });

					String value15 = oldCplModel.getWebsite();

					method15.invoke(newModel, value15);

					Method method16 = newModelClass.getMethod("setDuration",
							new Class[] { String.class });

					String value16 = oldCplModel.getDuration();

					method16.invoke(newModel, value16);

					Method method17 = newModelClass.getMethod("setRating",
							new Class[] { Long.TYPE });

					Long value17 = new Long(oldCplModel.getRating());

					method17.invoke(newModel, value17);

					Method method18 = newModelClass.getMethod("setImportance",
							new Class[] { Long.TYPE });

					Long value18 = new Long(oldCplModel.getImportance());

					method18.invoke(newModel, value18);

					Method method19 = newModelClass.getMethod("setSpecialtagging",
							new Class[] { String.class });

					String value19 = oldCplModel.getSpecialtagging();

					method19.invoke(newModel, value19);

					Method method20 = newModelClass.getMethod("setControlstatus",
							new Class[] { Short.TYPE });

					Short value20 = new Short(oldCplModel.getControlstatus());

					method20.invoke(newModel, value20);

					Method method21 = newModelClass.getMethod("setCreator",
							new Class[] { String.class });

					String value21 = oldCplModel.getCreator();

					method21.invoke(newModel, value21);

					Method method22 = newModelClass.getMethod("setCreationdate",
							new Class[] { Date.class });

					Date value22 = oldCplModel.getCreationdate();

					method22.invoke(newModel, value22);

					Method method23 = newModelClass.getMethod("setModerator",
							new Class[] { String.class });

					String value23 = oldCplModel.getModerator();

					method23.invoke(newModel, value23);

					Method method24 = newModelClass.getMethod("setApprovaldate",
							new Class[] { Date.class });

					Date value24 = oldCplModel.getApprovaldate();

					method24.invoke(newModel, value24);

					Method method25 = newModelClass.getMethod("setReplacesId",
							new Class[] { Long.TYPE });

					Long value25 = new Long(oldCplModel.getReplacesId());

					method25.invoke(newModel, value25);

					Method method26 = newModelClass.getMethod("setComments",
							new Class[] { String.class });

					String value26 = oldCplModel.getComments();

					method26.invoke(newModel, value26);

					Method method27 = newModelClass.getMethod("setTextwebpage",
							new Class[] { String.class });

					String value27 = oldCplModel.getTextwebpage();

					method27.invoke(newModel, value27);

					Method method28 = newModelClass.getMethod("setSpatialvalues",
							new Class[] { String.class });

					String value28 = oldCplModel.getSpatialvalues();

					method28.invoke(newModel, value28);

					Method method29 = newModelClass.getMethod("setSource",
							new Class[] { String.class });

					String value29 = oldCplModel.getSource();

					method29.invoke(newModel, value29);

					Method method30 = newModelClass.getMethod("setClimateimpacts",
							new Class[] { String.class });

					String value30 = oldCplModel.getClimateimpacts();

					method30.invoke(newModel, value30);

					Method method31 = newModelClass.getMethod("setLockdate",
							new Class[] { Date.class });

					Date value31 = oldCplModel.getLockdate();

					method31.invoke(newModel, value31);

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
					"nl.wur.alterra.cgi.ace.model.impl.ProjectImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ProjectClp newModel = new ProjectClp();

					Method method0 = oldModelClass.getMethod("getProjectId");

					Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

					newModel.setProjectId(value0);

					Method method1 = oldModelClass.getMethod("getCompanyId");

					Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

					newModel.setCompanyId(value1);

					Method method2 = oldModelClass.getMethod("getGroupId");

					Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

					newModel.setGroupId(value2);

					Method method3 = oldModelClass.getMethod("getAcronym");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setAcronym(value3);

					Method method4 = oldModelClass.getMethod("getTitle");

					String value4 = (String)method4.invoke(oldModel,
							(Object[])null);

					newModel.setTitle(value4);

					Method method5 = oldModelClass.getMethod("getStartdate");

					Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

					newModel.setStartdate(value5);

					Method method6 = oldModelClass.getMethod("getEnddate");

					Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

					newModel.setEnddate(value6);

					Method method7 = oldModelClass.getMethod("getLead");

					String value7 = (String)method7.invoke(oldModel,
							(Object[])null);

					newModel.setLead(value7);

					Method method8 = oldModelClass.getMethod("getPartners");

					String value8 = (String)method8.invoke(oldModel,
							(Object[])null);

					newModel.setPartners(value8);

					Method method9 = oldModelClass.getMethod("getFunding");

					String value9 = (String)method9.invoke(oldModel,
							(Object[])null);

					newModel.setFunding(value9);

					Method method10 = oldModelClass.getMethod("getSectors");

					String value10 = (String)method10.invoke(oldModel,
							(Object[])null);

					newModel.setSectors(value10);

					Method method11 = oldModelClass.getMethod("getSpatiallayer");

					String value11 = (String)method11.invoke(oldModel,
							(Object[])null);

					newModel.setSpatiallayer(value11);

					Method method12 = oldModelClass.getMethod("getAbstracts");

					String value12 = (String)method12.invoke(oldModel,
							(Object[])null);

					newModel.setAbstracts(value12);

					Method method13 = oldModelClass.getMethod("getElement");

					String value13 = (String)method13.invoke(oldModel,
							(Object[])null);

					newModel.setElement(value13);

					Method method14 = oldModelClass.getMethod("getKeywords");

					String value14 = (String)method14.invoke(oldModel,
							(Object[])null);

					newModel.setKeywords(value14);

					Method method15 = oldModelClass.getMethod("getWebsite");

					String value15 = (String)method15.invoke(oldModel,
							(Object[])null);

					newModel.setWebsite(value15);

					Method method16 = oldModelClass.getMethod("getDuration");

					String value16 = (String)method16.invoke(oldModel,
							(Object[])null);

					newModel.setDuration(value16);

					Method method17 = oldModelClass.getMethod("getRating");

					Long value17 = (Long)method17.invoke(oldModel,
							(Object[])null);

					newModel.setRating(value17);

					Method method18 = oldModelClass.getMethod("getImportance");

					Long value18 = (Long)method18.invoke(oldModel,
							(Object[])null);

					newModel.setImportance(value18);

					Method method19 = oldModelClass.getMethod(
							"getSpecialtagging");

					String value19 = (String)method19.invoke(oldModel,
							(Object[])null);

					newModel.setSpecialtagging(value19);

					Method method20 = oldModelClass.getMethod(
							"getControlstatus");

					Short value20 = (Short)method20.invoke(oldModel,
							(Object[])null);

					newModel.setControlstatus(value20);

					Method method21 = oldModelClass.getMethod("getCreator");

					String value21 = (String)method21.invoke(oldModel,
							(Object[])null);

					newModel.setCreator(value21);

					Method method22 = oldModelClass.getMethod("getCreationdate");

					Date value22 = (Date)method22.invoke(oldModel,
							(Object[])null);

					newModel.setCreationdate(value22);

					Method method23 = oldModelClass.getMethod("getModerator");

					String value23 = (String)method23.invoke(oldModel,
							(Object[])null);

					newModel.setModerator(value23);

					Method method24 = oldModelClass.getMethod("getApprovaldate");

					Date value24 = (Date)method24.invoke(oldModel,
							(Object[])null);

					newModel.setApprovaldate(value24);

					Method method25 = oldModelClass.getMethod("getReplacesId");

					Long value25 = (Long)method25.invoke(oldModel,
							(Object[])null);

					newModel.setReplacesId(value25);

					Method method26 = oldModelClass.getMethod("getComments");

					String value26 = (String)method26.invoke(oldModel,
							(Object[])null);

					newModel.setComments(value26);

					Method method27 = oldModelClass.getMethod("getTextwebpage");

					String value27 = (String)method27.invoke(oldModel,
							(Object[])null);

					newModel.setTextwebpage(value27);

					Method method28 = oldModelClass.getMethod(
							"getSpatialvalues");

					String value28 = (String)method28.invoke(oldModel,
							(Object[])null);

					newModel.setSpatialvalues(value28);

					Method method29 = oldModelClass.getMethod("getSource");

					String value29 = (String)method29.invoke(oldModel,
							(Object[])null);

					newModel.setSource(value29);

					Method method30 = oldModelClass.getMethod(
							"getClimateimpacts");

					String value30 = (String)method30.invoke(oldModel,
							(Object[])null);

					newModel.setClimateimpacts(value30);

					Method method31 = oldModelClass.getMethod("getLockdate");

					Date value31 = (Date)method31.invoke(oldModel,
							(Object[])null);

					newModel.setLockdate(value31);

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