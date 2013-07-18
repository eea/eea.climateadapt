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

					Method method3 = newModelClass.getMethod("setAdmincomment",
							new Class[] { String.class });

					String value3 = oldCplModel.getAdmincomment();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setCasestudyfeature",
							new Class[] { String.class });

					String value4 = oldCplModel.getCasestudyfeature();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setName",
							new Class[] { String.class });

					String value5 = oldCplModel.getName();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setDescription",
							new Class[] { String.class });

					String value6 = oldCplModel.getDescription();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setImplementationtype",
							new Class[] { String.class });

					String value7 = oldCplModel.getImplementationtype();

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setImplementationtime",
							new Class[] { String.class });

					String value8 = oldCplModel.getImplementationtime();

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setLifetime",
							new Class[] { String.class });

					String value9 = oldCplModel.getLifetime();

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setSpatiallayer",
							new Class[] { String.class });

					String value10 = oldCplModel.getSpatiallayer();

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setSpatialvalues",
							new Class[] { String.class });

					String value11 = oldCplModel.getSpatialvalues();

					method11.invoke(newModel, value11);

					Method method12 = newModelClass.getMethod("setLegalaspects",
							new Class[] { String.class });

					String value12 = oldCplModel.getLegalaspects();

					method12.invoke(newModel, value12);

					Method method13 = newModelClass.getMethod("setStakeholderparticipation",
							new Class[] { String.class });

					String value13 = oldCplModel.getStakeholderparticipation();

					method13.invoke(newModel, value13);

					Method method14 = newModelClass.getMethod("setContact",
							new Class[] { String.class });

					String value14 = oldCplModel.getContact();

					method14.invoke(newModel, value14);

					Method method15 = newModelClass.getMethod("setObjectives",
							new Class[] { String.class });

					String value15 = oldCplModel.getObjectives();

					method15.invoke(newModel, value15);

					Method method16 = newModelClass.getMethod("setChallenges",
							new Class[] { String.class });

					String value16 = oldCplModel.getChallenges();

					method16.invoke(newModel, value16);

					Method method17 = newModelClass.getMethod("setAdaptationoptions",
							new Class[] { String.class });

					String value17 = oldCplModel.getAdaptationoptions();

					method17.invoke(newModel, value17);

					Method method18 = newModelClass.getMethod("setSolutions",
							new Class[] { String.class });

					String value18 = oldCplModel.getSolutions();

					method18.invoke(newModel, value18);

					Method method19 = newModelClass.getMethod("setRelevance",
							new Class[] { String.class });

					String value19 = oldCplModel.getRelevance();

					method19.invoke(newModel, value19);

					Method method20 = newModelClass.getMethod("setSucceslimitations",
							new Class[] { String.class });

					String value20 = oldCplModel.getSucceslimitations();

					method20.invoke(newModel, value20);

					Method method21 = newModelClass.getMethod("setWebsite",
							new Class[] { String.class });

					String value21 = oldCplModel.getWebsite();

					method21.invoke(newModel, value21);

					Method method22 = newModelClass.getMethod("setCostbenefit",
							new Class[] { String.class });

					String value22 = oldCplModel.getCostbenefit();

					method22.invoke(newModel, value22);

					Method method23 = newModelClass.getMethod("setKeywords",
							new Class[] { String.class });

					String value23 = oldCplModel.getKeywords();

					method23.invoke(newModel, value23);

					Method method24 = newModelClass.getMethod("setGeos_",
							new Class[] { String.class });

					String value24 = oldCplModel.getGeos_();

					method24.invoke(newModel, value24);

					Method method25 = newModelClass.getMethod("setStartdate",
							new Class[] { Date.class });

					Date value25 = oldCplModel.getStartdate();

					method25.invoke(newModel, value25);

					Method method26 = newModelClass.getMethod("setEnddate",
							new Class[] { Date.class });

					Date value26 = oldCplModel.getEnddate();

					method26.invoke(newModel, value26);

					Method method27 = newModelClass.getMethod("setPublicationdate",
							new Class[] { Date.class });

					Date value27 = oldCplModel.getPublicationdate();

					method27.invoke(newModel, value27);

					Method method28 = newModelClass.getMethod("setSpecialtagging",
							new Class[] { String.class });

					String value28 = oldCplModel.getSpecialtagging();

					method28.invoke(newModel, value28);

					Method method29 = newModelClass.getMethod("setSectors_",
							new Class[] { String.class });

					String value29 = oldCplModel.getSectors_();

					method29.invoke(newModel, value29);

					Method method30 = newModelClass.getMethod("setElements_",
							new Class[] { String.class });

					String value30 = oldCplModel.getElements_();

					method30.invoke(newModel, value30);

					Method method31 = newModelClass.getMethod("setClimateimpacts_",
							new Class[] { String.class });

					String value31 = oldCplModel.getClimateimpacts_();

					method31.invoke(newModel, value31);

					Method method32 = newModelClass.getMethod("setMao_type",
							new Class[] { String.class });

					String value32 = oldCplModel.getMao_type();

					method32.invoke(newModel, value32);

					Method method33 = newModelClass.getMethod("setSource",
							new Class[] { String.class });

					String value33 = oldCplModel.getSource();

					method33.invoke(newModel, value33);

					Method method34 = newModelClass.getMethod("setRating",
							new Class[] { Long.TYPE });

					Long value34 = new Long(oldCplModel.getRating());

					method34.invoke(newModel, value34);

					Method method35 = newModelClass.getMethod("setImportance",
							new Class[] { Long.TYPE });

					Long value35 = new Long(oldCplModel.getImportance());

					method35.invoke(newModel, value35);

					Method method36 = newModelClass.getMethod("setLon",
							new Class[] { Double.TYPE });

					Double value36 = new Double(oldCplModel.getLon());

					method36.invoke(newModel, value36);

					Method method37 = newModelClass.getMethod("setLat",
							new Class[] { Double.TYPE });

					Double value37 = new Double(oldCplModel.getLat());

					method37.invoke(newModel, value37);

					Method method38 = newModelClass.getMethod("setSatarea",
							new Class[] { String.class });

					String value38 = oldCplModel.getSatarea();

					method38.invoke(newModel, value38);

					Method method39 = newModelClass.getMethod("setControlstatus",
							new Class[] { Short.TYPE });

					Short value39 = new Short(oldCplModel.getControlstatus());

					method39.invoke(newModel, value39);

					Method method40 = newModelClass.getMethod("setCreator",
							new Class[] { String.class });

					String value40 = oldCplModel.getCreator();

					method40.invoke(newModel, value40);

					Method method41 = newModelClass.getMethod("setCreationdate",
							new Class[] { Date.class });

					Date value41 = oldCplModel.getCreationdate();

					method41.invoke(newModel, value41);

					Method method42 = newModelClass.getMethod("setModerator",
							new Class[] { String.class });

					String value42 = oldCplModel.getModerator();

					method42.invoke(newModel, value42);

					Method method43 = newModelClass.getMethod("setApprovaldate",
							new Class[] { Date.class });

					Date value43 = oldCplModel.getApprovaldate();

					method43.invoke(newModel, value43);

					Method method44 = newModelClass.getMethod("setReplacesId",
							new Class[] { Long.TYPE });

					Long value44 = new Long(oldCplModel.getReplacesId());

					method44.invoke(newModel, value44);

					Method method45 = newModelClass.getMethod("setComments",
							new Class[] { String.class });

					String value45 = oldCplModel.getComments();

					method45.invoke(newModel, value45);

					Method method46 = newModelClass.getMethod("setTextwebpage",
							new Class[] { String.class });

					String value46 = oldCplModel.getTextwebpage();

					method46.invoke(newModel, value46);

					Method method47 = newModelClass.getMethod("setPrimephoto",
							new Class[] { String.class });

					String value47 = oldCplModel.getPrimephoto();

					method47.invoke(newModel, value47);

					Method method48 = newModelClass.getMethod("setSupphotos",
							new Class[] { String.class });

					String value48 = oldCplModel.getSupphotos();

					method48.invoke(newModel, value48);

					Method method49 = newModelClass.getMethod("setSupdocs",
							new Class[] { String.class });

					String value49 = oldCplModel.getSupdocs();

					method49.invoke(newModel, value49);

					Method method50 = newModelClass.getMethod("setYear",
							new Class[] { String.class });

					String value50 = oldCplModel.getYear();

					method50.invoke(newModel, value50);

					Method method51 = newModelClass.getMethod("setGeochars",
							new Class[] { String.class });

					String value51 = oldCplModel.getGeochars();

					method51.invoke(newModel, value51);

					Method method52 = newModelClass.getMethod("setCategory",
							new Class[] { String.class });

					String value52 = oldCplModel.getCategory();

					method52.invoke(newModel, value52);

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

					Method method3 = oldModelClass.getMethod("getAdmincomment");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setAdmincomment(value3);

					Method method4 = oldModelClass.getMethod(
							"getCasestudyfeature");

					String value4 = (String)method4.invoke(oldModel,
							(Object[])null);

					newModel.setCasestudyfeature(value4);

					Method method5 = oldModelClass.getMethod("getName");

					String value5 = (String)method5.invoke(oldModel,
							(Object[])null);

					newModel.setName(value5);

					Method method6 = oldModelClass.getMethod("getDescription");

					String value6 = (String)method6.invoke(oldModel,
							(Object[])null);

					newModel.setDescription(value6);

					Method method7 = oldModelClass.getMethod(
							"getImplementationtype");

					String value7 = (String)method7.invoke(oldModel,
							(Object[])null);

					newModel.setImplementationtype(value7);

					Method method8 = oldModelClass.getMethod(
							"getImplementationtime");

					String value8 = (String)method8.invoke(oldModel,
							(Object[])null);

					newModel.setImplementationtime(value8);

					Method method9 = oldModelClass.getMethod("getLifetime");

					String value9 = (String)method9.invoke(oldModel,
							(Object[])null);

					newModel.setLifetime(value9);

					Method method10 = oldModelClass.getMethod("getSpatiallayer");

					String value10 = (String)method10.invoke(oldModel,
							(Object[])null);

					newModel.setSpatiallayer(value10);

					Method method11 = oldModelClass.getMethod(
							"getSpatialvalues");

					String value11 = (String)method11.invoke(oldModel,
							(Object[])null);

					newModel.setSpatialvalues(value11);

					Method method12 = oldModelClass.getMethod("getLegalaspects");

					String value12 = (String)method12.invoke(oldModel,
							(Object[])null);

					newModel.setLegalaspects(value12);

					Method method13 = oldModelClass.getMethod(
							"getStakeholderparticipation");

					String value13 = (String)method13.invoke(oldModel,
							(Object[])null);

					newModel.setStakeholderparticipation(value13);

					Method method14 = oldModelClass.getMethod("getContact");

					String value14 = (String)method14.invoke(oldModel,
							(Object[])null);

					newModel.setContact(value14);

					Method method15 = oldModelClass.getMethod("getObjectives");

					String value15 = (String)method15.invoke(oldModel,
							(Object[])null);

					newModel.setObjectives(value15);

					Method method16 = oldModelClass.getMethod("getChallenges");

					String value16 = (String)method16.invoke(oldModel,
							(Object[])null);

					newModel.setChallenges(value16);

					Method method17 = oldModelClass.getMethod(
							"getAdaptationoptions");

					String value17 = (String)method17.invoke(oldModel,
							(Object[])null);

					newModel.setAdaptationoptions(value17);

					Method method18 = oldModelClass.getMethod("getSolutions");

					String value18 = (String)method18.invoke(oldModel,
							(Object[])null);

					newModel.setSolutions(value18);

					Method method19 = oldModelClass.getMethod("getRelevance");

					String value19 = (String)method19.invoke(oldModel,
							(Object[])null);

					newModel.setRelevance(value19);

					Method method20 = oldModelClass.getMethod(
							"getSucceslimitations");

					String value20 = (String)method20.invoke(oldModel,
							(Object[])null);

					newModel.setSucceslimitations(value20);

					Method method21 = oldModelClass.getMethod("getWebsite");

					String value21 = (String)method21.invoke(oldModel,
							(Object[])null);

					newModel.setWebsite(value21);

					Method method22 = oldModelClass.getMethod("getCostbenefit");

					String value22 = (String)method22.invoke(oldModel,
							(Object[])null);

					newModel.setCostbenefit(value22);

					Method method23 = oldModelClass.getMethod("getKeywords");

					String value23 = (String)method23.invoke(oldModel,
							(Object[])null);

					newModel.setKeywords(value23);

					Method method24 = oldModelClass.getMethod("getGeos_");

					String value24 = (String)method24.invoke(oldModel,
							(Object[])null);

					newModel.setGeos_(value24);

					Method method25 = oldModelClass.getMethod("getStartdate");

					Date value25 = (Date)method25.invoke(oldModel,
							(Object[])null);

					newModel.setStartdate(value25);

					Method method26 = oldModelClass.getMethod("getEnddate");

					Date value26 = (Date)method26.invoke(oldModel,
							(Object[])null);

					newModel.setEnddate(value26);

					Method method27 = oldModelClass.getMethod(
							"getPublicationdate");

					Date value27 = (Date)method27.invoke(oldModel,
							(Object[])null);

					newModel.setPublicationdate(value27);

					Method method28 = oldModelClass.getMethod(
							"getSpecialtagging");

					String value28 = (String)method28.invoke(oldModel,
							(Object[])null);

					newModel.setSpecialtagging(value28);

					Method method29 = oldModelClass.getMethod("getSectors_");

					String value29 = (String)method29.invoke(oldModel,
							(Object[])null);

					newModel.setSectors_(value29);

					Method method30 = oldModelClass.getMethod("getElements_");

					String value30 = (String)method30.invoke(oldModel,
							(Object[])null);

					newModel.setElements_(value30);

					Method method31 = oldModelClass.getMethod(
							"getClimateimpacts_");

					String value31 = (String)method31.invoke(oldModel,
							(Object[])null);

					newModel.setClimateimpacts_(value31);

					Method method32 = oldModelClass.getMethod("getMao_type");

					String value32 = (String)method32.invoke(oldModel,
							(Object[])null);

					newModel.setMao_type(value32);

					Method method33 = oldModelClass.getMethod("getSource");

					String value33 = (String)method33.invoke(oldModel,
							(Object[])null);

					newModel.setSource(value33);

					Method method34 = oldModelClass.getMethod("getRating");

					Long value34 = (Long)method34.invoke(oldModel,
							(Object[])null);

					newModel.setRating(value34);

					Method method35 = oldModelClass.getMethod("getImportance");

					Long value35 = (Long)method35.invoke(oldModel,
							(Object[])null);

					newModel.setImportance(value35);

					Method method36 = oldModelClass.getMethod("getLon");

					Double value36 = (Double)method36.invoke(oldModel,
							(Object[])null);

					newModel.setLon(value36);

					Method method37 = oldModelClass.getMethod("getLat");

					Double value37 = (Double)method37.invoke(oldModel,
							(Object[])null);

					newModel.setLat(value37);

					Method method38 = oldModelClass.getMethod("getSatarea");

					String value38 = (String)method38.invoke(oldModel,
							(Object[])null);

					newModel.setSatarea(value38);

					Method method39 = oldModelClass.getMethod(
							"getControlstatus");

					Short value39 = (Short)method39.invoke(oldModel,
							(Object[])null);

					newModel.setControlstatus(value39);

					Method method40 = oldModelClass.getMethod("getCreator");

					String value40 = (String)method40.invoke(oldModel,
							(Object[])null);

					newModel.setCreator(value40);

					Method method41 = oldModelClass.getMethod("getCreationdate");

					Date value41 = (Date)method41.invoke(oldModel,
							(Object[])null);

					newModel.setCreationdate(value41);

					Method method42 = oldModelClass.getMethod("getModerator");

					String value42 = (String)method42.invoke(oldModel,
							(Object[])null);

					newModel.setModerator(value42);

					Method method43 = oldModelClass.getMethod("getApprovaldate");

					Date value43 = (Date)method43.invoke(oldModel,
							(Object[])null);

					newModel.setApprovaldate(value43);

					Method method44 = oldModelClass.getMethod("getReplacesId");

					Long value44 = (Long)method44.invoke(oldModel,
							(Object[])null);

					newModel.setReplacesId(value44);

					Method method45 = oldModelClass.getMethod("getComments");

					String value45 = (String)method45.invoke(oldModel,
							(Object[])null);

					newModel.setComments(value45);

					Method method46 = oldModelClass.getMethod("getTextwebpage");

					String value46 = (String)method46.invoke(oldModel,
							(Object[])null);

					newModel.setTextwebpage(value46);

					Method method47 = oldModelClass.getMethod("getPrimephoto");

					String value47 = (String)method47.invoke(oldModel,
							(Object[])null);

					newModel.setPrimephoto(value47);

					Method method48 = oldModelClass.getMethod("getSupphotos");

					String value48 = (String)method48.invoke(oldModel,
							(Object[])null);

					newModel.setSupphotos(value48);

					Method method49 = oldModelClass.getMethod("getSupdocs");

					String value49 = (String)method49.invoke(oldModel,
							(Object[])null);

					newModel.setSupdocs(value49);

					Method method50 = oldModelClass.getMethod("getYear");

					String value50 = (String)method50.invoke(oldModel,
							(Object[])null);

					newModel.setYear(value50);

					Method method51 = oldModelClass.getMethod("getGeochars");

					String value51 = (String)method51.invoke(oldModel,
							(Object[])null);

					newModel.setGeochars(value51);

					Method method52 = oldModelClass.getMethod("getCategory");

					String value52 = (String)method52.invoke(oldModel,
							(Object[])null);

					newModel.setCategory(value52);

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