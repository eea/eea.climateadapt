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
public class AceItemClp extends BaseModelImpl<AceItem> implements AceItem {
	public AceItemClp() {
	}

	public long getPrimaryKey() {
		return _aceItemId;
	}

	public void setPrimaryKey(long pk) {
		setAceItemId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_aceItemId);
	}

	public long getAceItemId() {
		return _aceItemId;
	}

	public void setAceItemId(long aceItemId) {
		_aceItemId = aceItemId;
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

	public String getDatatype() {
		return _datatype;
	}

	public void setDatatype(String datatype) {
		_datatype = datatype;
	}

	public String getStoredAt() {
		return _storedAt;
	}

	public void setStoredAt(String storedAt) {
		_storedAt = storedAt;
	}

	public String getStoragetype() {
		return _storagetype;
	}

	public void setStoragetype(String storagetype) {
		_storagetype = storagetype;
	}

	public String getLanguage() {
		return _language;
	}

	public void setLanguage(String language) {
		_language = language;
	}

	public String getTextSearch() {
		return _textSearch;
	}

	public void setTextSearch(String textSearch) {
		_textSearch = textSearch;
	}

	public String getKeyword() {
		return _keyword;
	}

	public void setKeyword(String keyword) {
		_keyword = keyword;
	}

	public String getTargetresolution() {
		return _targetresolution;
	}

	public void setTargetresolution(String targetresolution) {
		_targetresolution = targetresolution;
	}

	public String getSpatialLayer() {
		return _spatialLayer;
	}

	public void setSpatialLayer(String spatialLayer) {
		_spatialLayer = spatialLayer;
	}

	public String getSpatialValues() {
		return _spatialValues;
	}

	public void setSpatialValues(String spatialValues) {
		_spatialValues = spatialValues;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public Date getPublicationDate() {
		return _publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		_publicationDate = publicationDate;
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

	public AceItem toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (AceItem)Proxy.newProxyInstance(AceItem.class.getClassLoader(),
				new Class[] { AceItem.class }, new AutoEscapeBeanHandler(this));
		}
	}

	public Object clone() {
		AceItemClp clone = new AceItemClp();

		clone.setAceItemId(getAceItemId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setName(getName());
		clone.setDescription(getDescription());
		clone.setDatatype(getDatatype());
		clone.setStoredAt(getStoredAt());
		clone.setStoragetype(getStoragetype());
		clone.setLanguage(getLanguage());
		clone.setTextSearch(getTextSearch());
		clone.setKeyword(getKeyword());
		clone.setTargetresolution(getTargetresolution());
		clone.setSpatialLayer(getSpatialLayer());
		clone.setSpatialValues(getSpatialValues());
		clone.setStartDate(getStartDate());
		clone.setEndDate(getEndDate());
		clone.setPublicationDate(getPublicationDate());
		clone.setSectors_(getSectors_());
		clone.setElements_(getElements_());
		clone.setClimateimpacts_(getClimateimpacts_());

		return clone;
	}

	public int compareTo(AceItem aceItem) {
		int value = 0;

		value = getName().compareTo(aceItem.getName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		AceItemClp aceItem = null;

		try {
			aceItem = (AceItemClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = aceItem.getPrimaryKey();

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
		StringBundler sb = new StringBundler(41);

		sb.append("{aceItemId=");
		sb.append(getAceItemId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", datatype=");
		sb.append(getDatatype());
		sb.append(", storedAt=");
		sb.append(getStoredAt());
		sb.append(", storagetype=");
		sb.append(getStoragetype());
		sb.append(", language=");
		sb.append(getLanguage());
		sb.append(", textSearch=");
		sb.append(getTextSearch());
		sb.append(", keyword=");
		sb.append(getKeyword());
		sb.append(", targetresolution=");
		sb.append(getTargetresolution());
		sb.append(", spatialLayer=");
		sb.append(getSpatialLayer());
		sb.append(", spatialValues=");
		sb.append(getSpatialValues());
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append(", publicationDate=");
		sb.append(getPublicationDate());
		sb.append(", sectors_=");
		sb.append(getSectors_());
		sb.append(", elements_=");
		sb.append(getElements_());
		sb.append(", climateimpacts_=");
		sb.append(getClimateimpacts_());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(64);

		sb.append("<model><model-name>");
		sb.append("nl.wur.alterra.cgi.ace.model.AceItem");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>aceItemId</column-name><column-value><![CDATA[");
		sb.append(getAceItemId());
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
			"<column><column-name>datatype</column-name><column-value><![CDATA[");
		sb.append(getDatatype());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>storedAt</column-name><column-value><![CDATA[");
		sb.append(getStoredAt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>storagetype</column-name><column-value><![CDATA[");
		sb.append(getStoragetype());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>language</column-name><column-value><![CDATA[");
		sb.append(getLanguage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>textSearch</column-name><column-value><![CDATA[");
		sb.append(getTextSearch());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>keyword</column-name><column-value><![CDATA[");
		sb.append(getKeyword());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>targetresolution</column-name><column-value><![CDATA[");
		sb.append(getTargetresolution());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spatialLayer</column-name><column-value><![CDATA[");
		sb.append(getSpatialLayer());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spatialValues</column-name><column-value><![CDATA[");
		sb.append(getSpatialValues());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startDate</column-name><column-value><![CDATA[");
		sb.append(getStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endDate</column-name><column-value><![CDATA[");
		sb.append(getEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publicationDate</column-name><column-value><![CDATA[");
		sb.append(getPublicationDate());
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

		sb.append("</model>");

		return sb.toString();
	}

	private long _aceItemId;
	private long _companyId;
	private long _groupId;
	private String _name;
	private String _description;
	private String _datatype;
	private String _storedAt;
	private String _storagetype;
	private String _language;
	private String _textSearch;
	private String _keyword;
	private String _targetresolution;
	private String _spatialLayer;
	private String _spatialValues;
	private Date _startDate;
	private Date _endDate;
	private Date _publicationDate;
	private String _sectors_;
	private String _elements_;
	private String _climateimpacts_;
}