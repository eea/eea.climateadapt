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

import nl.wur.alterra.cgi.ace.model.AceItem;
import nl.wur.alterra.cgi.ace.model.AceItemModel;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.Date;

/**
 * The base model implementation for the AceItem service. Represents a row in the &quot;Ace_AceItem&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link nl.wur.alterra.cgi.ace.model.AceItemModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AceItemImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this class directly. All methods that expect a ace item model instance should use the {@link nl.wur.alterra.cgi.ace.model.AceItem} interface instead.
 * </p>
 *
 * @author groot052
 * @see AceItemImpl
 * @see nl.wur.alterra.cgi.ace.model.AceItem
 * @see nl.wur.alterra.cgi.ace.model.AceItemModel
 * @generated
 */
public class AceItemModelImpl extends BaseModelImpl<AceItem>
	implements AceItemModel {
	public static final String TABLE_NAME = "Ace_AceItem";
	public static final Object[][] TABLE_COLUMNS = {
			{ "aceItemId", new Integer(Types.BIGINT) },
			{ "companyId", new Integer(Types.BIGINT) },
			{ "groupId", new Integer(Types.BIGINT) },
			{ "wxsharvesterId", new Integer(Types.BIGINT) },
			{ "cswharvesterId", new Integer(Types.BIGINT) },
			{ "name", new Integer(Types.VARCHAR) },
			{ "description", new Integer(Types.VARCHAR) },
			{ "datatype", new Integer(Types.VARCHAR) },
			{ "storedAt", new Integer(Types.VARCHAR) },
			{ "storagetype", new Integer(Types.VARCHAR) },
			{ "specialtagging", new Integer(Types.VARCHAR) },
			{ "textSearch", new Integer(Types.VARCHAR) },
			{ "keyword", new Integer(Types.VARCHAR) },
			{ "targetresolution", new Integer(Types.VARCHAR) },
			{ "spatialLayer", new Integer(Types.VARCHAR) },
			{ "spatialValues", new Integer(Types.VARCHAR) },
			{ "startDate", new Integer(Types.TIMESTAMP) },
			{ "endDate", new Integer(Types.TIMESTAMP) },
			{ "publicationDate", new Integer(Types.TIMESTAMP) },
			{ "sectors_", new Integer(Types.VARCHAR) },
			{ "elements_", new Integer(Types.VARCHAR) },
			{ "climateimpacts_", new Integer(Types.VARCHAR) },
			{ "rating", new Integer(Types.BIGINT) },
			{ "importance", new Integer(Types.BIGINT) },
			{ "source", new Integer(Types.VARCHAR) },
			{ "deeplink", new Integer(Types.VARCHAR) },
			{ "controlstatus", new Integer(Types.INTEGER) },
			{ "creator", new Integer(Types.VARCHAR) },
			{ "creationdate", new Integer(Types.TIMESTAMP) },
			{ "moderator", new Integer(Types.VARCHAR) },
			{ "approvaldate", new Integer(Types.TIMESTAMP) },
			{ "replacesId", new Integer(Types.BIGINT) },
			{ "comments", new Integer(Types.VARCHAR) },
			{ "textwebpage", new Integer(Types.VARCHAR) }
		};
	public static final String TABLE_SQL_CREATE = "create table Ace_AceItem (aceItemId LONG not null primary key,companyId LONG,groupId LONG,wxsharvesterId LONG,cswharvesterId LONG,name VARCHAR(75) null,description VARCHAR(75) null,datatype VARCHAR(75) null,storedAt VARCHAR(75) null,storagetype VARCHAR(75) null,specialtagging VARCHAR(75) null,textSearch VARCHAR(75) null,keyword VARCHAR(75) null,targetresolution VARCHAR(75) null,spatialLayer VARCHAR(75) null,spatialValues VARCHAR(75) null,startDate DATE null,endDate DATE null,publicationDate DATE null,sectors_ VARCHAR(75) null,elements_ VARCHAR(75) null,climateimpacts_ VARCHAR(75) null,rating LONG,importance LONG,source VARCHAR(75) null,deeplink VARCHAR(75) null,controlstatus INTEGER,creator VARCHAR(75) null,creationdate DATE null,moderator VARCHAR(75) null,approvaldate DATE null,replacesId LONG,comments VARCHAR(75) null,textwebpage VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table Ace_AceItem";
	public static final String ORDER_BY_JPQL = " ORDER BY aceItem.name ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Ace_AceItem.name ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.nl.wur.alterra.cgi.ace.model.AceItem"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.nl.wur.alterra.cgi.ace.model.AceItem"),
			true);
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.nl.wur.alterra.cgi.ace.model.AceItem"));

	public AceItemModelImpl() {
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

	public long getWxsharvesterId() {
		return _wxsharvesterId;
	}

	public void setWxsharvesterId(long wxsharvesterId) {
		_wxsharvesterId = wxsharvesterId;
	}

	public long getCswharvesterId() {
		return _cswharvesterId;
	}

	public void setCswharvesterId(long cswharvesterId) {
		_cswharvesterId = cswharvesterId;
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

	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getDatatype() {
		if (_datatype == null) {
			return StringPool.BLANK;
		}
		else {
			return _datatype;
		}
	}

	public void setDatatype(String datatype) {
		_datatype = datatype;
	}

	public String getStoredAt() {
		if (_storedAt == null) {
			return StringPool.BLANK;
		}
		else {
			return _storedAt;
		}
	}

	public void setStoredAt(String storedAt) {
		_storedAt = storedAt;

		if (_originalStoredAt == null) {
			_originalStoredAt = storedAt;
		}
	}

	public String getOriginalStoredAt() {
		return GetterUtil.getString(_originalStoredAt);
	}

	public String getStoragetype() {
		if (_storagetype == null) {
			return StringPool.BLANK;
		}
		else {
			return _storagetype;
		}
	}

	public void setStoragetype(String storagetype) {
		_storagetype = storagetype;
	}

	public String getSpecialtagging() {
		if (_specialtagging == null) {
			return StringPool.BLANK;
		}
		else {
			return _specialtagging;
		}
	}

	public void setSpecialtagging(String specialtagging) {
		_specialtagging = specialtagging;
	}

	public String getTextSearch() {
		if (_textSearch == null) {
			return StringPool.BLANK;
		}
		else {
			return _textSearch;
		}
	}

	public void setTextSearch(String textSearch) {
		_textSearch = textSearch;
	}

	public String getKeyword() {
		if (_keyword == null) {
			return StringPool.BLANK;
		}
		else {
			return _keyword;
		}
	}

	public void setKeyword(String keyword) {
		_keyword = keyword;
	}

	public String getTargetresolution() {
		if (_targetresolution == null) {
			return StringPool.BLANK;
		}
		else {
			return _targetresolution;
		}
	}

	public void setTargetresolution(String targetresolution) {
		_targetresolution = targetresolution;
	}

	public String getSpatialLayer() {
		if (_spatialLayer == null) {
			return StringPool.BLANK;
		}
		else {
			return _spatialLayer;
		}
	}

	public void setSpatialLayer(String spatialLayer) {
		_spatialLayer = spatialLayer;
	}

	public String getSpatialValues() {
		if (_spatialValues == null) {
			return StringPool.BLANK;
		}
		else {
			return _spatialValues;
		}
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
		if (_sectors_ == null) {
			return StringPool.BLANK;
		}
		else {
			return _sectors_;
		}
	}

	public void setSectors_(String sectors_) {
		_sectors_ = sectors_;
	}

	public String getElements_() {
		if (_elements_ == null) {
			return StringPool.BLANK;
		}
		else {
			return _elements_;
		}
	}

	public void setElements_(String elements_) {
		_elements_ = elements_;
	}

	public String getClimateimpacts_() {
		if (_climateimpacts_ == null) {
			return StringPool.BLANK;
		}
		else {
			return _climateimpacts_;
		}
	}

	public void setClimateimpacts_(String climateimpacts_) {
		_climateimpacts_ = climateimpacts_;
	}

	public long getRating() {
		return _rating;
	}

	public void setRating(long rating) {
		_rating = rating;
	}

	public long getImportance() {
		return _importance;
	}

	public void setImportance(long importance) {
		_importance = importance;
	}

	public String getSource() {
		if (_source == null) {
			return StringPool.BLANK;
		}
		else {
			return _source;
		}
	}

	public void setSource(String source) {
		_source = source;
	}

	public String getDeeplink() {
		if (_deeplink == null) {
			return StringPool.BLANK;
		}
		else {
			return _deeplink;
		}
	}

	public void setDeeplink(String deeplink) {
		_deeplink = deeplink;
	}

	public short getControlstatus() {
		return _controlstatus;
	}

	public void setControlstatus(short controlstatus) {
		_controlstatus = controlstatus;
	}

	public String getCreator() {
		if (_creator == null) {
			return StringPool.BLANK;
		}
		else {
			return _creator;
		}
	}

	public void setCreator(String creator) {
		_creator = creator;
	}

	public Date getCreationdate() {
		return _creationdate;
	}

	public void setCreationdate(Date creationdate) {
		_creationdate = creationdate;
	}

	public String getModerator() {
		if (_moderator == null) {
			return StringPool.BLANK;
		}
		else {
			return _moderator;
		}
	}

	public void setModerator(String moderator) {
		_moderator = moderator;
	}

	public Date getApprovaldate() {
		return _approvaldate;
	}

	public void setApprovaldate(Date approvaldate) {
		_approvaldate = approvaldate;
	}

	public long getReplacesId() {
		return _replacesId;
	}

	public void setReplacesId(long replacesId) {
		_replacesId = replacesId;
	}

	public String getComments() {
		if (_comments == null) {
			return StringPool.BLANK;
		}
		else {
			return _comments;
		}
	}

	public void setComments(String comments) {
		_comments = comments;
	}

	public String getTextwebpage() {
		if (_textwebpage == null) {
			return StringPool.BLANK;
		}
		else {
			return _textwebpage;
		}
	}

	public void setTextwebpage(String textwebpage) {
		_textwebpage = textwebpage;
	}

	public AceItem toEscapedModel() {
		if (isEscapedModel()) {
			return (AceItem)this;
		}
		else {
			return (AceItem)Proxy.newProxyInstance(AceItem.class.getClassLoader(),
				new Class[] { AceItem.class }, new AutoEscapeBeanHandler(this));
		}
	}

	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
					AceItem.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	public Object clone() {
		AceItemImpl clone = new AceItemImpl();

		clone.setAceItemId(getAceItemId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setWxsharvesterId(getWxsharvesterId());
		clone.setCswharvesterId(getCswharvesterId());
		clone.setName(getName());
		clone.setDescription(getDescription());
		clone.setDatatype(getDatatype());
		clone.setStoredAt(getStoredAt());
		clone.setStoragetype(getStoragetype());
		clone.setSpecialtagging(getSpecialtagging());
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
		clone.setRating(getRating());
		clone.setImportance(getImportance());
		clone.setSource(getSource());
		clone.setDeeplink(getDeeplink());
		clone.setControlstatus(getControlstatus());
		clone.setCreator(getCreator());
		clone.setCreationdate(getCreationdate());
		clone.setModerator(getModerator());
		clone.setApprovaldate(getApprovaldate());
		clone.setReplacesId(getReplacesId());
		clone.setComments(getComments());
		clone.setTextwebpage(getTextwebpage());

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

		AceItem aceItem = null;

		try {
			aceItem = (AceItem)obj;
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
		StringBundler sb = new StringBundler(69);

		sb.append("{aceItemId=");
		sb.append(getAceItemId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", wxsharvesterId=");
		sb.append(getWxsharvesterId());
		sb.append(", cswharvesterId=");
		sb.append(getCswharvesterId());
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
		sb.append(", specialtagging=");
		sb.append(getSpecialtagging());
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
		sb.append(", rating=");
		sb.append(getRating());
		sb.append(", importance=");
		sb.append(getImportance());
		sb.append(", source=");
		sb.append(getSource());
		sb.append(", deeplink=");
		sb.append(getDeeplink());
		sb.append(", controlstatus=");
		sb.append(getControlstatus());
		sb.append(", creator=");
		sb.append(getCreator());
		sb.append(", creationdate=");
		sb.append(getCreationdate());
		sb.append(", moderator=");
		sb.append(getModerator());
		sb.append(", approvaldate=");
		sb.append(getApprovaldate());
		sb.append(", replacesId=");
		sb.append(getReplacesId());
		sb.append(", comments=");
		sb.append(getComments());
		sb.append(", textwebpage=");
		sb.append(getTextwebpage());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(106);

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
			"<column><column-name>wxsharvesterId</column-name><column-value><![CDATA[");
		sb.append(getWxsharvesterId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cswharvesterId</column-name><column-value><![CDATA[");
		sb.append(getCswharvesterId());
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
			"<column><column-name>specialtagging</column-name><column-value><![CDATA[");
		sb.append(getSpecialtagging());
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
		sb.append(
			"<column><column-name>rating</column-name><column-value><![CDATA[");
		sb.append(getRating());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>importance</column-name><column-value><![CDATA[");
		sb.append(getImportance());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>source</column-name><column-value><![CDATA[");
		sb.append(getSource());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deeplink</column-name><column-value><![CDATA[");
		sb.append(getDeeplink());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>controlstatus</column-name><column-value><![CDATA[");
		sb.append(getControlstatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>creator</column-name><column-value><![CDATA[");
		sb.append(getCreator());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>creationdate</column-name><column-value><![CDATA[");
		sb.append(getCreationdate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>moderator</column-name><column-value><![CDATA[");
		sb.append(getModerator());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>approvaldate</column-name><column-value><![CDATA[");
		sb.append(getApprovaldate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>replacesId</column-name><column-value><![CDATA[");
		sb.append(getReplacesId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>comments</column-name><column-value><![CDATA[");
		sb.append(getComments());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>textwebpage</column-name><column-value><![CDATA[");
		sb.append(getTextwebpage());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _aceItemId;
	private long _companyId;
	private long _groupId;
	private long _wxsharvesterId;
	private long _cswharvesterId;
	private String _name;
	private String _description;
	private String _datatype;
	private String _storedAt;
	private String _originalStoredAt;
	private String _storagetype;
	private String _specialtagging;
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
	private long _rating;
	private long _importance;
	private String _source;
	private String _deeplink;
	private short _controlstatus;
	private String _creator;
	private Date _creationdate;
	private String _moderator;
	private Date _approvaldate;
	private long _replacesId;
	private String _comments;
	private String _textwebpage;
	private transient ExpandoBridge _expandoBridge;
}
