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
public class NASSourceClp extends BaseModelImpl<NASSource> implements NASSource {
	public NASSourceClp() {
	}

	public long getPrimaryKey() {
		return _nassourceid;
	}

	public void setPrimaryKey(long pk) {
		setNassourceid(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_nassourceid);
	}

	public long getNassourceid() {
		return _nassourceid;
	}

	public void setNassourceid(long nassourceid) {
		_nassourceid = nassourceid;
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

	public NASSource toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (NASSource)Proxy.newProxyInstance(NASSource.class.getClassLoader(),
				new Class[] { NASSource.class }, new AutoEscapeBeanHandler(this));
		}
	}

	public Object clone() {
		NASSourceClp clone = new NASSourceClp();

		clone.setNassourceid(getNassourceid());
		clone.setNasId(getNasId());
		clone.setName(getName());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());

		return clone;
	}

	public int compareTo(NASSource nasSource) {
		int value = 0;

		value = getName().toLowerCase()
					.compareTo(nasSource.getName().toLowerCase());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		NASSourceClp nasSource = null;

		try {
			nasSource = (NASSourceClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = nasSource.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{nassourceid=");
		sb.append(getNassourceid());
		sb.append(", nasId=");
		sb.append(getNasId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("nl.wur.alterra.cgi.ace.model.NASSource");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>nassourceid</column-name><column-value><![CDATA[");
		sb.append(getNassourceid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nasId</column-name><column-value><![CDATA[");
		sb.append(getNasId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _nassourceid;
	private long _nasId;
	private String _name;
	private long _companyId;
	private long _groupId;
}