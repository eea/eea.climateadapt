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

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public String getStoredAt() {
		return _storedAt;
	}

	public void setStoredAt(String storedAt) {
		_storedAt = storedAt;
	}

	public String getSector() {
		return _sector;
	}

	public void setSector(String sector) {
		_sector = sector;
	}

	public String getPilar() {
		return _pilar;
	}

	public void setPilar(String pilar) {
		_pilar = pilar;
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

	public String getNutsId() {
		return _nutsId;
	}

	public void setNutsId(String nutsId) {
		_nutsId = nutsId;
	}

	public String getNutsLevel() {
		return _nutsLevel;
	}

	public void setNutsLevel(String nutsLevel) {
		_nutsLevel = nutsLevel;
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
		clone.setType(getType());
		clone.setStoredAt(getStoredAt());
		clone.setSector(getSector());
		clone.setPilar(getPilar());
		clone.setTextSearch(getTextSearch());
		clone.setKeyword(getKeyword());
		clone.setNutsId(getNutsId());
		clone.setNutsLevel(getNutsLevel());
		clone.setStartDate(getStartDate());
		clone.setEndDate(getEndDate());

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
		StringBundler sb = new StringBundler(31);

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
		sb.append(", type=");
		sb.append(getType());
		sb.append(", storedAt=");
		sb.append(getStoredAt());
		sb.append(", sector=");
		sb.append(getSector());
		sb.append(", pilar=");
		sb.append(getPilar());
		sb.append(", textSearch=");
		sb.append(getTextSearch());
		sb.append(", keyword=");
		sb.append(getKeyword());
		sb.append(", nutsId=");
		sb.append(getNutsId());
		sb.append(", nutsLevel=");
		sb.append(getNutsLevel());
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(49);

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
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>storedAt</column-name><column-value><![CDATA[");
		sb.append(getStoredAt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sector</column-name><column-value><![CDATA[");
		sb.append(getSector());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pilar</column-name><column-value><![CDATA[");
		sb.append(getPilar());
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
			"<column><column-name>nutsId</column-name><column-value><![CDATA[");
		sb.append(getNutsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nutsLevel</column-name><column-value><![CDATA[");
		sb.append(getNutsLevel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startDate</column-name><column-value><![CDATA[");
		sb.append(getStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endDate</column-name><column-value><![CDATA[");
		sb.append(getEndDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _aceItemId;
	private long _companyId;
	private long _groupId;
	private String _name;
	private String _description;
	private String _type;
	private String _storedAt;
	private String _sector;
	private String _pilar;
	private String _textSearch;
	private String _keyword;
	private String _nutsId;
	private String _nutsLevel;
	private Date _startDate;
	private Date _endDate;
}