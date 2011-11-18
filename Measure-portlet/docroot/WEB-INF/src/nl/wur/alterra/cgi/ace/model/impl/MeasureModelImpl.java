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

import nl.wur.alterra.cgi.ace.model.Measure;
import nl.wur.alterra.cgi.ace.model.MeasureModel;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.Date;

/**
 * The base model implementation for the Measure service. Represents a row in the &quot;Ace_Measure&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link nl.wur.alterra.cgi.ace.model.MeasureModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link MeasureImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this class directly. All methods that expect a measure model instance should use the {@link nl.wur.alterra.cgi.ace.model.Measure} interface instead.
 * </p>
 *
 * @author groot052
 * @see MeasureImpl
 * @see nl.wur.alterra.cgi.ace.model.Measure
 * @see nl.wur.alterra.cgi.ace.model.MeasureModel
 * @generated
 */
public class MeasureModelImpl extends BaseModelImpl<Measure>
	implements MeasureModel {
	public static final String TABLE_NAME = "Ace_Measure";
	public static final Object[][] TABLE_COLUMNS = {
			{ "measureId", new Integer(Types.BIGINT) },
			{ "companyId", new Integer(Types.BIGINT) },
			{ "groupId", new Integer(Types.BIGINT) },
			{ "name", new Integer(Types.VARCHAR) },
			{ "description", new Integer(Types.VARCHAR) },
			{ "implementationtype", new Integer(Types.VARCHAR) },
			{ "implementationtime", new Integer(Types.VARCHAR) },
			{ "lifetime", new Integer(Types.VARCHAR) },
			{ "spatiallayer", new Integer(Types.VARCHAR) },
			{ "spatialvalues", new Integer(Types.VARCHAR) },
			{ "legalaspects", new Integer(Types.VARCHAR) },
			{ "stakeholderparticipation", new Integer(Types.VARCHAR) },
			{ "contact", new Integer(Types.VARCHAR) },
			{ "succeslimitations", new Integer(Types.VARCHAR) },
			{ "website", new Integer(Types.VARCHAR) },
			{ "costbenefit", new Integer(Types.VARCHAR) },
			{ "keywords", new Integer(Types.VARCHAR) },
			{ "startdate", new Integer(Types.TIMESTAMP) },
			{ "enddate", new Integer(Types.TIMESTAMP) },
			{ "publicationdate", new Integer(Types.TIMESTAMP) },
			{ "specialtagging", new Integer(Types.VARCHAR) },
			{ "sectors_", new Integer(Types.VARCHAR) },
			{ "elements_", new Integer(Types.VARCHAR) },
			{ "climateimpacts_", new Integer(Types.VARCHAR) },
			{ "mao_type", new Integer(Types.VARCHAR) },
			{ "source", new Integer(Types.VARCHAR) },
			{ "rating", new Integer(Types.BIGINT) },
			{ "importance", new Integer(Types.BIGINT) },
			{ "lon", new Integer(Types.DOUBLE) },
			{ "lat", new Integer(Types.DOUBLE) },
			{ "satarea", new Integer(Types.VARCHAR) },
			{ "controlstatus", new Integer(Types.INTEGER) },
			{ "creator", new Integer(Types.VARCHAR) },
			{ "creationdate", new Integer(Types.TIMESTAMP) },
			{ "moderator", new Integer(Types.VARCHAR) },
			{ "approvaldate", new Integer(Types.TIMESTAMP) }
		};
	public static final String TABLE_SQL_CREATE = "create table Ace_Measure (measureId LONG not null primary key,companyId LONG,groupId LONG,name VARCHAR(75) null,description VARCHAR(75) null,implementationtype VARCHAR(75) null,implementationtime VARCHAR(75) null,lifetime VARCHAR(75) null,spatiallayer VARCHAR(75) null,spatialvalues VARCHAR(75) null,legalaspects VARCHAR(75) null,stakeholderparticipation VARCHAR(75) null,contact VARCHAR(75) null,succeslimitations VARCHAR(75) null,website VARCHAR(75) null,costbenefit VARCHAR(75) null,keywords VARCHAR(75) null,startdate DATE null,enddate DATE null,publicationdate DATE null,specialtagging VARCHAR(75) null,sectors_ VARCHAR(75) null,elements_ VARCHAR(75) null,climateimpacts_ VARCHAR(75) null,mao_type VARCHAR(75) null,source VARCHAR(75) null,rating LONG,importance LONG,lon DOUBLE,lat DOUBLE,satarea VARCHAR(75) null,controlstatus INTEGER,creator VARCHAR(75) null,creationdate DATE null,moderator VARCHAR(75) null,approvaldate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table Ace_Measure";
	public static final String ORDER_BY_JPQL = " ORDER BY measure.name ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Ace_Measure.name ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.nl.wur.alterra.cgi.ace.model.Measure"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.nl.wur.alterra.cgi.ace.model.Measure"),
			true);
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.nl.wur.alterra.cgi.ace.model.Measure"));

	public MeasureModelImpl() {
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

	public String getImplementationtype() {
		if (_implementationtype == null) {
			return StringPool.BLANK;
		}
		else {
			return _implementationtype;
		}
	}

	public void setImplementationtype(String implementationtype) {
		_implementationtype = implementationtype;
	}

	public String getImplementationtime() {
		if (_implementationtime == null) {
			return StringPool.BLANK;
		}
		else {
			return _implementationtime;
		}
	}

	public void setImplementationtime(String implementationtime) {
		_implementationtime = implementationtime;
	}

	public String getLifetime() {
		if (_lifetime == null) {
			return StringPool.BLANK;
		}
		else {
			return _lifetime;
		}
	}

	public void setLifetime(String lifetime) {
		_lifetime = lifetime;
	}

	public String getSpatiallayer() {
		if (_spatiallayer == null) {
			return StringPool.BLANK;
		}
		else {
			return _spatiallayer;
		}
	}

	public void setSpatiallayer(String spatiallayer) {
		_spatiallayer = spatiallayer;
	}

	public String getSpatialvalues() {
		if (_spatialvalues == null) {
			return StringPool.BLANK;
		}
		else {
			return _spatialvalues;
		}
	}

	public void setSpatialvalues(String spatialvalues) {
		_spatialvalues = spatialvalues;
	}

	public String getLegalaspects() {
		if (_legalaspects == null) {
			return StringPool.BLANK;
		}
		else {
			return _legalaspects;
		}
	}

	public void setLegalaspects(String legalaspects) {
		_legalaspects = legalaspects;
	}

	public String getStakeholderparticipation() {
		if (_stakeholderparticipation == null) {
			return StringPool.BLANK;
		}
		else {
			return _stakeholderparticipation;
		}
	}

	public void setStakeholderparticipation(String stakeholderparticipation) {
		_stakeholderparticipation = stakeholderparticipation;
	}

	public String getContact() {
		if (_contact == null) {
			return StringPool.BLANK;
		}
		else {
			return _contact;
		}
	}

	public void setContact(String contact) {
		_contact = contact;
	}

	public String getSucceslimitations() {
		if (_succeslimitations == null) {
			return StringPool.BLANK;
		}
		else {
			return _succeslimitations;
		}
	}

	public void setSucceslimitations(String succeslimitations) {
		_succeslimitations = succeslimitations;
	}

	public String getWebsite() {
		if (_website == null) {
			return StringPool.BLANK;
		}
		else {
			return _website;
		}
	}

	public void setWebsite(String website) {
		_website = website;
	}

	public String getCostbenefit() {
		if (_costbenefit == null) {
			return StringPool.BLANK;
		}
		else {
			return _costbenefit;
		}
	}

	public void setCostbenefit(String costbenefit) {
		_costbenefit = costbenefit;
	}

	public String getKeywords() {
		if (_keywords == null) {
			return StringPool.BLANK;
		}
		else {
			return _keywords;
		}
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

	public String getMao_type() {
		if (_mao_type == null) {
			return StringPool.BLANK;
		}
		else {
			return _mao_type;
		}
	}

	public void setMao_type(String mao_type) {
		_mao_type = mao_type;
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

	public double getLon() {
		return _lon;
	}

	public void setLon(double lon) {
		_lon = lon;
	}

	public double getLat() {
		return _lat;
	}

	public void setLat(double lat) {
		_lat = lat;
	}

	public String getSatarea() {
		if (_satarea == null) {
			return StringPool.BLANK;
		}
		else {
			return _satarea;
		}
	}

	public void setSatarea(String satarea) {
		_satarea = satarea;
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

	public Measure toEscapedModel() {
		if (isEscapedModel()) {
			return (Measure)this;
		}
		else {
			return (Measure)Proxy.newProxyInstance(Measure.class.getClassLoader(),
				new Class[] { Measure.class }, new AutoEscapeBeanHandler(this));
		}
	}

	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
					Measure.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	public Object clone() {
		MeasureImpl clone = new MeasureImpl();

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
		clone.setSpecialtagging(getSpecialtagging());
		clone.setSectors_(getSectors_());
		clone.setElements_(getElements_());
		clone.setClimateimpacts_(getClimateimpacts_());
		clone.setMao_type(getMao_type());
		clone.setSource(getSource());
		clone.setRating(getRating());
		clone.setImportance(getImportance());
		clone.setLon(getLon());
		clone.setLat(getLat());
		clone.setSatarea(getSatarea());
		clone.setControlstatus(getControlstatus());
		clone.setCreator(getCreator());
		clone.setCreationdate(getCreationdate());
		clone.setModerator(getModerator());
		clone.setApprovaldate(getApprovaldate());

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

		Measure measure = null;

		try {
			measure = (Measure)obj;
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
		StringBundler sb = new StringBundler(73);

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
		sb.append(", specialtagging=");
		sb.append(getSpecialtagging());
		sb.append(", sectors_=");
		sb.append(getSectors_());
		sb.append(", elements_=");
		sb.append(getElements_());
		sb.append(", climateimpacts_=");
		sb.append(getClimateimpacts_());
		sb.append(", mao_type=");
		sb.append(getMao_type());
		sb.append(", source=");
		sb.append(getSource());
		sb.append(", rating=");
		sb.append(getRating());
		sb.append(", importance=");
		sb.append(getImportance());
		sb.append(", lon=");
		sb.append(getLon());
		sb.append(", lat=");
		sb.append(getLat());
		sb.append(", satarea=");
		sb.append(getSatarea());
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
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(112);

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
			"<column><column-name>specialtagging</column-name><column-value><![CDATA[");
		sb.append(getSpecialtagging());
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
		sb.append(
			"<column><column-name>source</column-name><column-value><![CDATA[");
		sb.append(getSource());
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
			"<column><column-name>lon</column-name><column-value><![CDATA[");
		sb.append(getLon());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lat</column-name><column-value><![CDATA[");
		sb.append(getLat());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>satarea</column-name><column-value><![CDATA[");
		sb.append(getSatarea());
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
	private String _specialtagging;
	private String _sectors_;
	private String _elements_;
	private String _climateimpacts_;
	private String _mao_type;
	private String _source;
	private long _rating;
	private long _importance;
	private double _lon;
	private double _lat;
	private String _satarea;
	private short _controlstatus;
	private String _creator;
	private Date _creationdate;
	private String _moderator;
	private Date _approvaldate;
	private transient ExpandoBridge _expandoBridge;
}