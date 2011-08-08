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

/**
 * @author groot052
 */
public class NASClp extends BaseModelImpl<NAS> implements NAS {
	public NASClp() {
	}

	public long getPrimaryKey() {
		return _nasId;
	}

	public void setPrimaryKey(long pk) {
		setNasId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_nasId);
	}

	public long getNasId() {
		return _nasId;
	}

	public void setNasId(long nasId) {
		_nasId = nasId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getAdoptedStatus() {
		return _adoptedStatus;
	}

	public void setAdoptedStatus(String adoptedStatus) {
		_adoptedStatus = adoptedStatus;
	}

	public String getAdoptedDescription() {
		return _adoptedDescription;
	}

	public void setAdoptedDescription(String adoptedDescription) {
		_adoptedDescription = adoptedDescription;
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

	public long getParentNasId() {
		return _parentNasId;
	}

	public void setParentNasId(long parentNasId) {
		_parentNasId = parentNasId;
	}

	public String getIsoCountry() {
		return _isoCountry;
	}

	public void setIsoCountry(String isoCountry) {
		_isoCountry = isoCountry;
	}

	public NAS toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (NAS)Proxy.newProxyInstance(NAS.class.getClassLoader(),
				new Class[] { NAS.class }, new AutoEscapeBeanHandler(this));
		}
	}

	public Object clone() {
		NASClp clone = new NASClp();

		clone.setNasId(getNasId());
		clone.setName(getName());
		clone.setAdoptedStatus(getAdoptedStatus());
		clone.setAdoptedDescription(getAdoptedDescription());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setParentNasId(getParentNasId());
		clone.setIsoCountry(getIsoCountry());

		return clone;
	}

	public int compareTo(NAS nas) {
		int value = 0;

		value = getName().toLowerCase().compareTo(nas.getName().toLowerCase());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		NASClp nas = null;

		try {
			nas = (NASClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = nas.getPrimaryKey();

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
		StringBundler sb = new StringBundler(17);

		sb.append("{nasId=");
		sb.append(getNasId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", adoptedStatus=");
		sb.append(getAdoptedStatus());
		sb.append(", adoptedDescription=");
		sb.append(getAdoptedDescription());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", parentNasId=");
		sb.append(getParentNasId());
		sb.append(", isoCountry=");
		sb.append(getIsoCountry());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("nl.wur.alterra.cgi.ace.model.NAS");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>nasId</column-name><column-value><![CDATA[");
		sb.append(getNasId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>adoptedStatus</column-name><column-value><![CDATA[");
		sb.append(getAdoptedStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>adoptedDescription</column-name><column-value><![CDATA[");
		sb.append(getAdoptedDescription());
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
			"<column><column-name>parentNasId</column-name><column-value><![CDATA[");
		sb.append(getParentNasId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isoCountry</column-name><column-value><![CDATA[");
		sb.append(getIsoCountry());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _nasId;
	private String _name;
	private String _adoptedStatus;
	private String _adoptedDescription;
	private long _companyId;
	private long _groupId;
	private long _parentNasId;
	private String _isoCountry;
}