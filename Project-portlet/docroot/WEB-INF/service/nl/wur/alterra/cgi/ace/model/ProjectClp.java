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
 * @author Groot052
 */
public class ProjectClp extends BaseModelImpl<Project> implements Project {
	public ProjectClp() {
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
		return _acronym;
	}

	public void setAcronym(String acronym) {
		_acronym = acronym;
	}

	public String getTitle() {
		return _title;
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
		return _lead;
	}

	public void setLead(String lead) {
		_lead = lead;
	}

	public String getPartners() {
		return _partners;
	}

	public void setPartners(String partners) {
		_partners = partners;
	}

	public String getFunding() {
		return _funding;
	}

	public void setFunding(String funding) {
		_funding = funding;
	}

	public String getSectors() {
		return _sectors;
	}

	public void setSectors(String sectors) {
		_sectors = sectors;
	}

	public String getSpatiallevel() {
		return _spatiallevel;
	}

	public void setSpatiallevel(String spatiallevel) {
		_spatiallevel = spatiallevel;
	}

	public String getAbstracts() {
		return _abstracts;
	}

	public void setAbstracts(String abstracts) {
		_abstracts = abstracts;
	}

	public String getElement() {
		return _element;
	}

	public void setElement(String element) {
		_element = element;
	}

	public String getKeywords() {
		return _keywords;
	}

	public void setKeywords(String keywords) {
		_keywords = keywords;
	}

	public String getWebsite() {
		return _website;
	}

	public void setWebsite(String website) {
		_website = website;
	}

	public String getDuration() {
		return _duration;
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

	public String getSpecialtagging() {
		return _specialtagging;
	}

	public void setSpecialtagging(String specialtagging) {
		_specialtagging = specialtagging;
	}

	public short getControlstatus() {
		return _controlstatus;
	}

	public void setControlstatus(short controlstatus) {
		_controlstatus = controlstatus;
	}

	public String getCreator() {
		return _creator;
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
		return _moderator;
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

	public Project toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (Project)Proxy.newProxyInstance(Project.class.getClassLoader(),
				new Class[] { Project.class }, new AutoEscapeBeanHandler(this));
		}
	}

	public Object clone() {
		ProjectClp clone = new ProjectClp();

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
		clone.setSpecialtagging(getSpecialtagging());
		clone.setControlstatus(getControlstatus());
		clone.setCreator(getCreator());
		clone.setCreationdate(getCreationdate());
		clone.setModerator(getModerator());
		clone.setApprovaldate(getApprovaldate());

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

		ProjectClp project = null;

		try {
			project = (ProjectClp)obj;
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
		StringBundler sb = new StringBundler(51);

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
		sb.append(", specialtagging=");
		sb.append(getSpecialtagging());
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
		StringBundler sb = new StringBundler(79);

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
		sb.append(
			"<column><column-name>specialtagging</column-name><column-value><![CDATA[");
		sb.append(getSpecialtagging());
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
	private String _specialtagging;
	private short _controlstatus;
	private String _creator;
	private Date _creationdate;
	private String _moderator;
	private Date _approvaldate;
}