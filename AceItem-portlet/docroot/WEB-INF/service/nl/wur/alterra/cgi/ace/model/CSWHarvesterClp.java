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
public class CSWHarvesterClp extends BaseModelImpl<CSWHarvester>
	implements CSWHarvester {
	public CSWHarvesterClp() {
	}

	public long getPrimaryKey() {
		return _cswharvesterid;
	}

	public void setPrimaryKey(long pk) {
		setCswharvesterid(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_cswharvesterid);
	}

	public long getCswharvesterid() {
		return _cswharvesterid;
	}

	public void setCswharvesterid(long cswharvesterid) {
		_cswharvesterid = cswharvesterid;
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

	public String getFreetext() {
		return _freetext;
	}

	public void setFreetext(String freetext) {
		_freetext = freetext;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getAbstrakt() {
		return _abstrakt;
	}

	public void setAbstrakt(String abstrakt) {
		_abstrakt = abstrakt;
	}

	public String getSubject() {
		return _subject;
	}

	public void setSubject(String subject) {
		_subject = subject;
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

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
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

	public java.lang.String toShortString() {
		throw new UnsupportedOperationException();
	}

	public CSWHarvester toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (CSWHarvester)Proxy.newProxyInstance(CSWHarvester.class.getClassLoader(),
				new Class[] { CSWHarvester.class },
				new AutoEscapeBeanHandler(this));
		}
	}

	public Object clone() {
		CSWHarvesterClp clone = new CSWHarvesterClp();

		clone.setCswharvesterid(getCswharvesterid());
		clone.setName(getName());
		clone.setUrl(getUrl());
		clone.setFreetext(getFreetext());
		clone.setTitle(getTitle());
		clone.setAbstrakt(getAbstrakt());
		clone.setSubject(getSubject());
		clone.setEvery(getEvery());
		clone.setTopic(getTopic());
		clone.setStatus(getStatus());
		clone.setSavedToGeoNetwork(getSavedToGeoNetwork());
		clone.setGeonetworkId(getGeonetworkId());
		clone.setGeonetworkUUID(getGeonetworkUUID());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());

		return clone;
	}

	public int compareTo(CSWHarvester cswHarvester) {
		int value = 0;

		value = getName().toLowerCase()
					.compareTo(cswHarvester.getName().toLowerCase());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		CSWHarvesterClp cswHarvester = null;

		try {
			cswHarvester = (CSWHarvesterClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = cswHarvester.getPrimaryKey();

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

		sb.append("{cswharvesterid=");
		sb.append(getCswharvesterid());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", url=");
		sb.append(getUrl());
		sb.append(", freetext=");
		sb.append(getFreetext());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", abstrakt=");
		sb.append(getAbstrakt());
		sb.append(", subject=");
		sb.append(getSubject());
		sb.append(", every=");
		sb.append(getEvery());
		sb.append(", topic=");
		sb.append(getTopic());
		sb.append(", status=");
		sb.append(getStatus());
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
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("nl.wur.alterra.cgi.ace.model.CSWHarvester");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>cswharvesterid</column-name><column-value><![CDATA[");
		sb.append(getCswharvesterid());
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
			"<column><column-name>freetext</column-name><column-value><![CDATA[");
		sb.append(getFreetext());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>abstrakt</column-name><column-value><![CDATA[");
		sb.append(getAbstrakt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subject</column-name><column-value><![CDATA[");
		sb.append(getSubject());
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
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
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

	private long _cswharvesterid;
	private String _name;
	private String _url;
	private String _freetext;
	private String _title;
	private String _abstrakt;
	private String _subject;
	private int _every;
	private String _topic;
	private String _status;
	private boolean _savedToGeoNetwork;
	private long _geonetworkId;
	private String _geonetworkUUID;
	private long _companyId;
	private long _groupId;
}