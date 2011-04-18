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

package nl.wur.alterra.cgi.ace.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author groot052
 */
public class MeasureClp extends BaseModelImpl<Measure> implements Measure {
	public MeasureClp() {
	}

	public long getPrimaryKey() {
		return _measureId;
	}

	public void setPrimaryKey(long pk) {
		setMeasureId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_measureId);
	}

	public long getMeasureId() {
		return _measureId;
	}

	public void setMeasureId(long measureId) {
		_measureId = measureId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getImplementationtype() {
		return _implementationtype;
	}

	public void setImplementationtype(String implementationtype) {
		_implementationtype = implementationtype;
	}

	public String getImplementationtime() {
		return _implementationtime;
	}

	public void setImplementationtime(String implementationtime) {
		_implementationtime = implementationtime;
	}

	public String getLifetime() {
		return _lifetime;
	}

	public void setLifetime(String lifetime) {
		_lifetime = lifetime;
	}

	public String getSpatiallayer() {
		return _spatiallayer;
	}

	public void setSpatiallayer(String spatiallayer) {
		_spatiallayer = spatiallayer;
	}

	public String getSpatialvalues() {
		return _spatialvalues;
	}

	public void setSpatialvalues(String spatialvalues) {
		_spatialvalues = spatialvalues;
	}

	public String getLegalaspects() {
		return _legalaspects;
	}

	public void setLegalaspects(String legalaspects) {
		_legalaspects = legalaspects;
	}

	public String getStakeholderparticipation() {
		return _stakeholderparticipation;
	}

	public void setStakeholderparticipation(String stakeholderparticipation) {
		_stakeholderparticipation = stakeholderparticipation;
	}

	public String getContact() {
		return _contact;
	}

	public void setContact(String contact) {
		_contact = contact;
	}

	public String getSucceslimitations() {
		return _succeslimitations;
	}

	public void setSucceslimitations(String succeslimitations) {
		_succeslimitations = succeslimitations;
	}

	public String getWebsite() {
		return _website;
	}

	public void setWebsite(String website) {
		_website = website;
	}

	public String getCostbenefit() {
		return _costbenefit;
	}

	public void setCostbenefit(String costbenefit) {
		_costbenefit = costbenefit;
	}

	public String getKeywords() {
		return _keywords;
	}

	public void setKeywords(String keywords) {
		_keywords = keywords;
	}

	public Date getStartdate() {
		return _startdate;
	}

	public void setStartdate(Date startdate) {
		_startdate = startdate;
	}

	public Date getEnddate() {
		return _enddate;
	}

	public void setEnddate(Date enddate) {
		_enddate = enddate;
	}

	public Date getPublicationdate() {
		return _publicationdate;
	}

	public void setPublicationdate(Date publicationdate) {
		_publicationdate = publicationdate;
	}

	public String getLanguage() {
		return _language;
	}

	public void setLanguage(String language) {
		_language = language;
	}

	public String getSectors_() {
		return _sectors_;
	}

	public void setSectors_(String sectors_) {
		_sectors_ = sectors_;
	}

	public String getElements_() {
		return _elements_;
	}

	public void setElements_(String elements_) {
		_elements_ = elements_;
	}

	public String getClimateimpacts_() {
		return _climateimpacts_;
	}

	public void setClimateimpacts_(String climateimpacts_) {
		_climateimpacts_ = climateimpacts_;
	}

	public String getMao_type() {
		return _mao_type;
	}

	public void setMao_type(String mao_type) {
		_mao_type = mao_type;
	}

	public Measure toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (Measure)Proxy.newProxyInstance(Measure.class.getClassLoader(),
				new Class[] { Measure.class }, new AutoEscapeBeanHandler(this));
		}
	}

	public Object clone() {
		MeasureClp clone = new MeasureClp();

		clone.setMeasureId(getMeasureId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setName(getName());
		clone.setDescription(getDescription());
		clone.setImplementationtype(getImplementationtype());
		clone.setImplementationtime(getImplementationtime());
		clone.setLifetime(getLifetime());
		clone.setSpatiallayer(getSpatiallayer());
		clone.setSpatialvalues(getSpatialvalues());
		clone.setLegalaspects(getLegalaspects());
		clone.setStakeholderparticipation(getStakeholderparticipation());
		clone.setContact(getContact());
		clone.setSucceslimitations(getSucceslimitations());
		clone.setWebsite(getWebsite());
		clone.setCostbenefit(getCostbenefit());
		clone.setKeywords(getKeywords());
		clone.setStartdate(getStartdate());
		clone.setEnddate(getEnddate());
		clone.setPublicationdate(getPublicationdate());
		clone.setLanguage(getLanguage());
		clone.setSectors_(getSectors_());
		clone.setElements_(getElements_());
		clone.setClimateimpacts_(getClimateimpacts_());
		clone.setMao_type(getMao_type());

		return clone;
	}

	public int compareTo(Measure measure) {
		int value = 0;

		value = getName().compareTo(measure.getName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		MeasureClp measure = null;

		try {
			measure = (MeasureClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = measure.getPrimaryKey();

		if (getPrimaryKey() == pk) {
			return true;
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return (int)getPrimaryKey();
	}

	public String toString() {
		StringBundler sb = new StringBundler(51);

		sb.append("{measureId=");
		sb.append(getMeasureId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", implementationtype=");
		sb.append(getImplementationtype());
		sb.append(", implementationtime=");
		sb.append(getImplementationtime());
		sb.append(", lifetime=");
		sb.append(getLifetime());
		sb.append(", spatiallayer=");
		sb.append(getSpatiallayer());
		sb.append(", spatialvalues=");
		sb.append(getSpatialvalues());
		sb.append(", legalaspects=");
		sb.append(getLegalaspects());
		sb.append(", stakeholderparticipation=");
		sb.append(getStakeholderparticipation());
		sb.append(", contact=");
		sb.append(getContact());
		sb.append(", succeslimitations=");
		sb.append(getSucceslimitations());
		sb.append(", website=");
		sb.append(getWebsite());
		sb.append(", costbenefit=");
		sb.append(getCostbenefit());
		sb.append(", keywords=");
		sb.append(getKeywords());
		sb.append(", startdate=");
		sb.append(getStartdate());
		sb.append(", enddate=");
		sb.append(getEnddate());
		sb.append(", publicationdate=");
		sb.append(getPublicationdate());
		sb.append(", language=");
		sb.append(getLanguage());
		sb.append(", sectors_=");
		sb.append(getSectors_());
		sb.append(", elements_=");
		sb.append(getElements_());
		sb.append(", climateimpacts_=");
		sb.append(getClimateimpacts_());
		sb.append(", mao_type=");
		sb.append(getMao_type());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(79);

		sb.append("<model><model-name>");
		sb.append("nl.wur.alterra.cgi.ace.model.Measure");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>measureId</column-name><column-value><![CDATA[");
		sb.append(getMeasureId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>implementationtype</column-name><column-value><![CDATA[");
		sb.append(getImplementationtype());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>implementationtime</column-name><column-value><![CDATA[");
		sb.append(getImplementationtime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lifetime</column-name><column-value><![CDATA[");
		sb.append(getLifetime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spatiallayer</column-name><column-value><![CDATA[");
		sb.append(getSpatiallayer());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spatialvalues</column-name><column-value><![CDATA[");
		sb.append(getSpatialvalues());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>legalaspects</column-name><column-value><![CDATA[");
		sb.append(getLegalaspects());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stakeholderparticipation</column-name><column-value><![CDATA[");
		sb.append(getStakeholderparticipation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contact</column-name><column-value><![CDATA[");
		sb.append(getContact());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>succeslimitations</column-name><column-value><![CDATA[");
		sb.append(getSucceslimitations());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>website</column-name><column-value><![CDATA[");
		sb.append(getWebsite());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>costbenefit</column-name><column-value><![CDATA[");
		sb.append(getCostbenefit());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>keywords</column-name><column-value><![CDATA[");
		sb.append(getKeywords());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startdate</column-name><column-value><![CDATA[");
		sb.append(getStartdate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>enddate</column-name><column-value><![CDATA[");
		sb.append(getEnddate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publicationdate</column-name><column-value><![CDATA[");
		sb.append(getPublicationdate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>language</column-name><column-value><![CDATA[");
		sb.append(getLanguage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sectors_</column-name><column-value><![CDATA[");
		sb.append(getSectors_());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>elements_</column-name><column-value><![CDATA[");
		sb.append(getElements_());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>climateimpacts_</column-name><column-value><![CDATA[");
		sb.append(getClimateimpacts_());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mao_type</column-name><column-value><![CDATA[");
		sb.append(getMao_type());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _measureId;
	private long _companyId;
	private long _groupId;
	private String _name;
	private String _description;
	private String _implementationtype;
	private String _implementationtime;
	private String _lifetime;
	private String _spatiallayer;
	private String _spatialvalues;
	private String _legalaspects;
	private String _stakeholderparticipation;
	private String _contact;
	private String _succeslimitations;
	private String _website;
	private String _costbenefit;
	private String _keywords;
	private Date _startdate;
	private Date _enddate;
	private Date _publicationdate;
	private String _language;
	private String _sectors_;
	private String _elements_;
	private String _climateimpacts_;
	private String _mao_type;
}