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

					Method method3 = newModelClass.getMethod("setName",
							new Class[] { String.class });

					String value3 = oldCplModel.getName();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setDescription",
							new Class[] { String.class });

					String value4 = oldCplModel.getDescription();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setType",
							new Class[] { String.class });

					String value5 = oldCplModel.getType();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setStoredAt",
							new Class[] { String.class });

					String value6 = oldCplModel.getStoredAt();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setSector",
							new Class[] { String.class });

					String value7 = oldCplModel.getSector();

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setPilar",
							new Class[] { String.class });

					String value8 = oldCplModel.getPilar();

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setTextSearch",
							new Class[] { String.class });

					String value9 = oldCplModel.getTextSearch();

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setKeyword",
							new Class[] { String.class });

					String value10 = oldCplModel.getKeyword();

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setNutsId",
							new Class[] { String.class });

					String value11 = oldCplModel.getNutsId();

					method11.invoke(newModel, value11);

					Method method12 = newModelClass.getMethod("setNutsLevel",
							new Class[] { String.class });

					String value12 = oldCplModel.getNutsLevel();

					method12.invoke(newModel, value12);

					Method method13 = newModelClass.getMethod("setStartDate",
							new Class[] { Date.class });

					Date value13 = oldCplModel.getStartDate();

					method13.invoke(newModel, value13);

					Method method14 = newModelClass.getMethod("setEndDate",
							new Class[] { Date.class });

					Date value14 = oldCplModel.getEndDate();

					method14.invoke(newModel, value14);

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

					Method method3 = oldModelClass.getMethod("getName");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setName(value3);

					Method method4 = oldModelClass.getMethod("getDescription");

					String value4 = (String)method4.invoke(oldModel,
							(Object[])null);

					newModel.setDescription(value4);

					Method method5 = oldModelClass.getMethod("getType");

					String value5 = (String)method5.invoke(oldModel,
							(Object[])null);

					newModel.setType(value5);

					Method method6 = oldModelClass.getMethod("getStoredAt");

					String value6 = (String)method6.invoke(oldModel,
							(Object[])null);

					newModel.setStoredAt(value6);

					Method method7 = oldModelClass.getMethod("getSector");

					String value7 = (String)method7.invoke(oldModel,
							(Object[])null);

					newModel.setSector(value7);

					Method method8 = oldModelClass.getMethod("getPilar");

					String value8 = (String)method8.invoke(oldModel,
							(Object[])null);

					newModel.setPilar(value8);

					Method method9 = oldModelClass.getMethod("getTextSearch");

					String value9 = (String)method9.invoke(oldModel,
							(Object[])null);

					newModel.setTextSearch(value9);

					Method method10 = oldModelClass.getMethod("getKeyword");

					String value10 = (String)method10.invoke(oldModel,
							(Object[])null);

					newModel.setKeyword(value10);

					Method method11 = oldModelClass.getMethod("getNutsId");

					String value11 = (String)method11.invoke(oldModel,
							(Object[])null);

					newModel.setNutsId(value11);

					Method method12 = oldModelClass.getMethod("getNutsLevel");

					String value12 = (String)method12.invoke(oldModel,
							(Object[])null);

					newModel.setNutsLevel(value12);

					Method method13 = oldModelClass.getMethod("getStartDate");

					Date value13 = (Date)method13.invoke(oldModel,
							(Object[])null);

					newModel.setStartDate(value13);

					Method method14 = oldModelClass.getMethod("getEndDate");

					Date value14 = (Date)method14.invoke(oldModel,
							(Object[])null);

					newModel.setEndDate(value14);

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