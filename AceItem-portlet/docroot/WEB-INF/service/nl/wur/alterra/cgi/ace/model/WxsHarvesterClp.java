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
public class WxsHarvesterClp extends BaseModelImpl<WxsHarvester>
	implements WxsHarvester {
	public WxsHarvesterClp() {
	}

	public long getPrimaryKey() {
		return _wxsharvesterid;
	}

	public void setPrimaryKey(long pk) {
		setWxsharvesterid(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_wxsharvesterid);
	}

	public long getWxsharvesterid() {
		return _wxsharvesterid;
	}

	public void setWxsharvesterid(long wxsharvesterid) {
		_wxsharvesterid = wxsharvesterid;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getUrl() {
		return _url;
	}

	public void setUrl(String url) {
		_url = url;
	}

	public String getOgctype() {
		return _ogctype;
	}

	public void setOgctype(String ogctype) {
		_ogctype = ogctype;
	}

	public int getEvery() {
		return _every;
	}

	public void setEvery(int every) {
		_every = every;
	}

	public String getTopic() {
		return _topic;
	}

	public void setTopic(String topic) {
		_topic = topic;
	}

	public boolean getSavedToGeoNetwork() {
		return _savedToGeoNetwork;
	}

	public boolean isSavedToGeoNetwork() {
		return _savedToGeoNetwork;
	}

	public void setSavedToGeoNetwork(boolean savedToGeoNetwork) {
		_savedToGeoNetwork = savedToGeoNetwork;
	}

	public long getGeonetworkId() {
		return _geonetworkId;
	}

	public void setGeonetworkId(long geonetworkId) {
		_geonetworkId = geonetworkId;
	}

	public String getGeonetworkUUID() {
		return _geonetworkUUID;
	}

	public void setGeonetworkUUID(String geonetworkUUID) {
		_geonetworkUUID = geonetworkUUID;
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

	public WxsHarvester toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (WxsHarvester)Proxy.newProxyInstance(WxsHarvester.class.getClassLoader(),
				new Class[] { WxsHarvester.class },
				new AutoEscapeBeanHandler(this));
		}
	}

	public Object clone() {
		WxsHarvesterClp clone = new WxsHarvesterClp();

		clone.setWxsharvesterid(getWxsharvesterid());
		clone.setName(getName());
		clone.setUrl(getUrl());
		clone.setOgctype(getOgctype());
		clone.setEvery(getEvery());
		clone.setTopic(getTopic());
		clone.setSavedToGeoNetwork(getSavedToGeoNetwork());
		clone.setGeonetworkId(getGeonetworkId());
		clone.setGeonetworkUUID(getGeonetworkUUID());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());

		return clone;
	}

	public int compareTo(WxsHarvester wxsHarvester) {
		int value = 0;

		value = getName().toLowerCase()
					.compareTo(wxsHarvester.getName().toLowerCase());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		WxsHarvesterClp wxsHarvester = null;

		try {
			wxsHarvester = (WxsHarvesterClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = wxsHarvester.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{wxsharvesterid=");
		sb.append(getWxsharvesterid());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", url=");
		sb.append(getUrl());
		sb.append(", ogctype=");
		sb.append(getOgctype());
		sb.append(", every=");
		sb.append(getEvery());
		sb.append(", topic=");
		sb.append(getTopic());
		sb.append(", savedToGeoNetwork=");
		sb.append(getSavedToGeoNetwork());
		sb.append(", geonetworkId=");
		sb.append(getGeonetworkId());
		sb.append(", geonetworkUUID=");
		sb.append(getGeonetworkUUID());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("nl.wur.alterra.cgi.ace.model.WxsHarvester");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>wxsharvesterid</column-name><column-value><![CDATA[");
		sb.append(getWxsharvesterid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>url</column-name><column-value><![CDATA[");
		sb.append(getUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ogctype</column-name><column-value><![CDATA[");
		sb.append(getOgctype());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>every</column-name><column-value><![CDATA[");
		sb.append(getEvery());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>topic</column-name><column-value><![CDATA[");
		sb.append(getTopic());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>savedToGeoNetwork</column-name><column-value><![CDATA[");
		sb.append(getSavedToGeoNetwork());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>geonetworkId</column-name><column-value><![CDATA[");
		sb.append(getGeonetworkId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>geonetworkUUID</column-name><column-value><![CDATA[");
		sb.append(getGeonetworkUUID());
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

	private long _wxsharvesterid;
	private String _name;
	private String _url;
	private String _ogctype;
	private int _every;
	private String _topic;
	private boolean _savedToGeoNetwork;
	private long _geonetworkId;
	private String _geonetworkUUID;
	private long _companyId;
	private long _groupId;
}