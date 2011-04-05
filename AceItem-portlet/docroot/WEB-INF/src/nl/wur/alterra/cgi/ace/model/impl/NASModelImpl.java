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

package nl.wur.alterra.cgi.ace.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import nl.wur.alterra.cgi.ace.model.NAS;
import nl.wur.alterra.cgi.ace.model.NASModel;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

/**
 * The base model implementation for the NAS service. Represents a row in the &quot;Ace_NAS&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link nl.wur.alterra.cgi.ace.model.NASModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link NASImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this class directly. All methods that expect a n a s model instance should use the {@link nl.wur.alterra.cgi.ace.model.NAS} interface instead.
 * </p>
 *
 * @author groot052
 * @see NASImpl
 * @see nl.wur.alterra.cgi.ace.model.NAS
 * @see nl.wur.alterra.cgi.ace.model.NASModel
 * @generated
 */
public class NASModelImpl extends BaseModelImpl<NAS> implements NASModel {
	public static final String TABLE_NAME = "Ace_NAS";
	public static final Object[][] TABLE_COLUMNS = {
			{ "nasId", new Integer(Types.BIGINT) },
			{ "name", new Integer(Types.VARCHAR) },
			{ "adoptedStatus", new Integer(Types.VARCHAR) },
			{ "adoptedDescription", new Integer(Types.VARCHAR) },
			{ "companyId", new Integer(Types.BIGINT) },
			{ "groupId", new Integer(Types.BIGINT) }
		};
	public static final String TABLE_SQL_CREATE = "create table Ace_NAS (nasId LONG not null primary key,name VARCHAR(75) null,adoptedStatus VARCHAR(75) null,adoptedDescription VARCHAR(75) null,companyId LONG,groupId LONG)";
	public static final String TABLE_SQL_DROP = "drop table Ace_NAS";
	public static final String ORDER_BY_JPQL = " ORDER BY nas.name ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Ace_NAS.name ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.nl.wur.alterra.cgi.ace.model.NAS"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.nl.wur.alterra.cgi.ace.model.NAS"),
			true);
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.nl.wur.alterra.cgi.ace.model.NAS"));

	public NASModelImpl() {
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
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	public void setName(String name) {
		_name = name;
	}

	public String getAdoptedStatus() {
		if (_adoptedStatus == null) {
			return StringPool.BLANK;
		}
		else {
			return _adoptedStatus;
		}
	}

	public void setAdoptedStatus(String adoptedStatus) {
		_adoptedStatus = adoptedStatus;
	}

	public String getAdoptedDescription() {
		if (_adoptedDescription == null) {
			return StringPool.BLANK;
		}
		else {
			return _adoptedDescription;
		}
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

	public NAS toEscapedModel() {
		if (isEscapedModel()) {
			return (NAS)this;
		}
		else {
			return (NAS)Proxy.newProxyInstance(NAS.class.getClassLoader(),
				new Class[] { NAS.class }, new AutoEscapeBeanHandler(this));
		}
	}

	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
					NAS.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	public Object clone() {
		NASImpl clone = new NASImpl();

		clone.setNasId(getNasId());
		clone.setName(getName());
		clone.setAdoptedStatus(getAdoptedStatus());
		clone.setAdoptedDescription(getAdoptedDescription());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());

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

		NAS nas = null;

		try {
			nas = (NAS)obj;
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
		StringBundler sb = new StringBundler(13);

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
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

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

		sb.append("</model>");

		return sb.toString();
	}

	private long _nasId;
	private String _name;
	private String _adoptedStatus;
	private String _adoptedDescription;
	private long _companyId;
	private long _groupId;
	private transient ExpandoBridge _expandoBridge;
}