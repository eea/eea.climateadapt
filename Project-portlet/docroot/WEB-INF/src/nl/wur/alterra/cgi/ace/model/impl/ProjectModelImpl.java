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

import nl.wur.alterra.cgi.ace.model.Project;
import nl.wur.alterra.cgi.ace.model.ProjectModel;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.Date;

/**
 * The base model implementation for the Project service. Represents a row in the &quot;Ace_Project&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link nl.wur.alterra.cgi.ace.model.ProjectModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ProjectImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this class directly. All methods that expect a project model instance should use the {@link nl.wur.alterra.cgi.ace.model.Project} interface instead.
 * </p>
 *
 * @author Groot052
 * @see ProjectImpl
 * @see nl.wur.alterra.cgi.ace.model.Project
 * @see nl.wur.alterra.cgi.ace.model.ProjectModel
 * @generated
 */
public class ProjectModelImpl extends BaseModelImpl<Project>
	implements ProjectModel {
	public static final String TABLE_NAME = "Ace_Project";
	public static final Object[][] TABLE_COLUMNS = {
			{ "projectId", new Integer(Types.BIGINT) },
			{ "companyId", new Integer(Types.BIGINT) },
			{ "groupId", new Integer(Types.BIGINT) },
			{ "acronym", new Integer(Types.VARCHAR) },
			{ "title", new Integer(Types.VARCHAR) },
			{ "startdate", new Integer(Types.TIMESTAMP) },
			{ "enddate", new Integer(Types.TIMESTAMP) },
			{ "lead", new Integer(Types.VARCHAR) },
			{ "partners", new Integer(Types.VARCHAR) },
			{ "funding", new Integer(Types.VARCHAR) },
			{ "sectors", new Integer(Types.VARCHAR) },
			{ "spatiallevel", new Integer(Types.VARCHAR) },
			{ "abstracts", new Integer(Types.VARCHAR) },
			{ "element", new Integer(Types.VARCHAR) },
			{ "keywords", new Integer(Types.VARCHAR) },
			{ "website", new Integer(Types.VARCHAR) },
			{ "duration", new Integer(Types.VARCHAR) },
			{ "rating", new Integer(Types.BIGINT) },
			{ "importance", new Integer(Types.BIGINT) }
		};
	public static final String TABLE_SQL_CREATE = "create table Ace_Project (projectId LONG not null primary key,companyId LONG,groupId LONG,acronym VARCHAR(75) null,title VARCHAR(75) null,startdate DATE null,enddate DATE null,lead VARCHAR(75) null,partners VARCHAR(75) null,funding VARCHAR(75) null,sectors VARCHAR(75) null,spatiallevel VARCHAR(75) null,abstracts VARCHAR(75) null,element VARCHAR(75) null,keywords VARCHAR(75) null,website VARCHAR(75) null,duration VARCHAR(75) null,rating LONG,importance LONG)";
	public static final String TABLE_SQL_DROP = "drop table Ace_Project";
	public static final String ORDER_BY_JPQL = " ORDER BY project.acronym ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Ace_Project.acronym ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.nl.wur.alterra.cgi.ace.model.Project"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.nl.wur.alterra.cgi.ace.model.Project"),
			true);
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.nl.wur.alterra.cgi.ace.model.Project"));

	public ProjectModelImpl() {
	}

	public long getPrimaryKey() {
		return _projectId;
	}

	public void setPrimaryKey(long pk) {
		setProjectId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_projectId);
	}

	public long getProjectId() {
		return _projectId;
	}

	public void setProjectId(long projectId) {
		_projectId = projectId;
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

	public String getAcronym() {
		if (_acronym == null) {
			return StringPool.BLANK;
		}
		else {
			return _acronym;
		}
	}

	public void setAcronym(String acronym) {
		_acronym = acronym;
	}

	public String getTitle() {
		if (_title == null) {
			return StringPool.BLANK;
		}
		else {
			return _title;
		}
	}

	public void setTitle(String title) {
		_title = title;
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

	public String getLead() {
		if (_lead == null) {
			return StringPool.BLANK;
		}
		else {
			return _lead;
		}
	}

	public void setLead(String lead) {
		_lead = lead;
	}

	public String getPartners() {
		if (_partners == null) {
			return StringPool.BLANK;
		}
		else {
			return _partners;
		}
	}

	public void setPartners(String partners) {
		_partners = partners;
	}

	public String getFunding() {
		if (_funding == null) {
			return StringPool.BLANK;
		}
		else {
			return _funding;
		}
	}

	public void setFunding(String funding) {
		_funding = funding;
	}

	public String getSectors() {
		if (_sectors == null) {
			return StringPool.BLANK;
		}
		else {
			return _sectors;
		}
	}

	public void setSectors(String sectors) {
		_sectors = sectors;
	}

	public String getSpatiallevel() {
		if (_spatiallevel == null) {
			return StringPool.BLANK;
		}
		else {
			return _spatiallevel;
		}
	}

	public void setSpatiallevel(String spatiallevel) {
		_spatiallevel = spatiallevel;
	}

	public String getAbstracts() {
		if (_abstracts == null) {
			return StringPool.BLANK;
		}
		else {
			return _abstracts;
		}
	}

	public void setAbstracts(String abstracts) {
		_abstracts = abstracts;
	}

	public String getElement() {
		if (_element == null) {
			return StringPool.BLANK;
		}
		else {
			return _element;
		}
	}

	public void setElement(String element) {
		_element = element;
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

	public String getDuration() {
		if (_duration == null) {
			return StringPool.BLANK;
		}
		else {
			return _duration;
		}
	}

	public void setDuration(String duration) {
		_duration = duration;
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

	public Project toEscapedModel() {
		if (isEscapedModel()) {
			return (Project)this;
		}
		else {
			return (Project)Proxy.newProxyInstance(Project.class.getClassLoader(),
				new Class[] { Project.class }, new AutoEscapeBeanHandler(this));
		}
	}

	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
					Project.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	public Object clone() {
		ProjectImpl clone = new ProjectImpl();

		clone.setProjectId(getProjectId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setAcronym(getAcronym());
		clone.setTitle(getTitle());
		clone.setStartdate(getStartdate());
		clone.setEnddate(getEnddate());
		clone.setLead(getLead());
		clone.setPartners(getPartners());
		clone.setFunding(getFunding());
		clone.setSectors(getSectors());
		clone.setSpatiallevel(getSpatiallevel());
		clone.setAbstracts(getAbstracts());
		clone.setElement(getElement());
		clone.setKeywords(getKeywords());
		clone.setWebsite(getWebsite());
		clone.setDuration(getDuration());
		clone.setRating(getRating());
		clone.setImportance(getImportance());

		return clone;
	}

	public int compareTo(Project project) {
		int value = 0;

		value = getAcronym().compareTo(project.getAcronym());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		Project project = null;

		try {
			project = (Project)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = project.getPrimaryKey();

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
		StringBundler sb = new StringBundler(39);

		sb.append("{projectId=");
		sb.append(getProjectId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", acronym=");
		sb.append(getAcronym());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", startdate=");
		sb.append(getStartdate());
		sb.append(", enddate=");
		sb.append(getEnddate());
		sb.append(", lead=");
		sb.append(getLead());
		sb.append(", partners=");
		sb.append(getPartners());
		sb.append(", funding=");
		sb.append(getFunding());
		sb.append(", sectors=");
		sb.append(getSectors());
		sb.append(", spatiallevel=");
		sb.append(getSpatiallevel());
		sb.append(", abstracts=");
		sb.append(getAbstracts());
		sb.append(", element=");
		sb.append(getElement());
		sb.append(", keywords=");
		sb.append(getKeywords());
		sb.append(", website=");
		sb.append(getWebsite());
		sb.append(", duration=");
		sb.append(getDuration());
		sb.append(", rating=");
		sb.append(getRating());
		sb.append(", importance=");
		sb.append(getImportance());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append("nl.wur.alterra.cgi.ace.model.Project");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>projectId</column-name><column-value><![CDATA[");
		sb.append(getProjectId());
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
			"<column><column-name>acronym</column-name><column-value><![CDATA[");
		sb.append(getAcronym());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
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
			"<column><column-name>lead</column-name><column-value><![CDATA[");
		sb.append(getLead());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>partners</column-name><column-value><![CDATA[");
		sb.append(getPartners());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>funding</column-name><column-value><![CDATA[");
		sb.append(getFunding());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sectors</column-name><column-value><![CDATA[");
		sb.append(getSectors());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spatiallevel</column-name><column-value><![CDATA[");
		sb.append(getSpatiallevel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>abstracts</column-name><column-value><![CDATA[");
		sb.append(getAbstracts());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>element</column-name><column-value><![CDATA[");
		sb.append(getElement());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>keywords</column-name><column-value><![CDATA[");
		sb.append(getKeywords());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>website</column-name><column-value><![CDATA[");
		sb.append(getWebsite());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>duration</column-name><column-value><![CDATA[");
		sb.append(getDuration());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rating</column-name><column-value><![CDATA[");
		sb.append(getRating());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>importance</column-name><column-value><![CDATA[");
		sb.append(getImportance());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _projectId;
	private long _companyId;
	private long _groupId;
	private String _acronym;
	private String _title;
	private Date _startdate;
	private Date _enddate;
	private String _lead;
	private String _partners;
	private String _funding;
	private String _sectors;
	private String _spatiallevel;
	private String _abstracts;
	private String _element;
	private String _keywords;
	private String _website;
	private String _duration;
	private long _rating;
	private long _importance;
	private transient ExpandoBridge _expandoBridge;
}