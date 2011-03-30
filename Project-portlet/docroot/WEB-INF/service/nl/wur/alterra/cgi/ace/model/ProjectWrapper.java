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

/**
 * <p>
 * This class is a wrapper for {@link Project}.
 * </p>
 *
 * @author    Groot052
 * @see       Project
 * @generated
 */
public class ProjectWrapper implements Project {
	public ProjectWrapper(Project project) {
		_project = project;
	}

	public long getPrimaryKey() {
		return _project.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_project.setPrimaryKey(pk);
	}

	public long getProjectId() {
		return _project.getProjectId();
	}

	public void setProjectId(long projectId) {
		_project.setProjectId(projectId);
	}

	public long getCompanyId() {
		return _project.getCompanyId();
	}

	public void setCompanyId(long companyId) {
		_project.setCompanyId(companyId);
	}

	public long getGroupId() {
		return _project.getGroupId();
	}

	public void setGroupId(long groupId) {
		_project.setGroupId(groupId);
	}

	public java.lang.String getAcronym() {
		return _project.getAcronym();
	}

	public void setAcronym(java.lang.String acronym) {
		_project.setAcronym(acronym);
	}

	public java.lang.String getTitle() {
		return _project.getTitle();
	}

	public void setTitle(java.lang.String title) {
		_project.setTitle(title);
	}

	public java.util.Date getStartdate() {
		return _project.getStartdate();
	}

	public void setStartdate(java.util.Date startdate) {
		_project.setStartdate(startdate);
	}

	public java.util.Date getEnddate() {
		return _project.getEnddate();
	}

	public void setEnddate(java.util.Date enddate) {
		_project.setEnddate(enddate);
	}

	public java.lang.String getLead() {
		return _project.getLead();
	}

	public void setLead(java.lang.String lead) {
		_project.setLead(lead);
	}

	public java.lang.String getPartners() {
		return _project.getPartners();
	}

	public void setPartners(java.lang.String partners) {
		_project.setPartners(partners);
	}

	public java.lang.String getFunding() {
		return _project.getFunding();
	}

	public void setFunding(java.lang.String funding) {
		_project.setFunding(funding);
	}

	public java.lang.String getSectors() {
		return _project.getSectors();
	}

	public void setSectors(java.lang.String sectors) {
		_project.setSectors(sectors);
	}

	public java.lang.String getSpatiallevel() {
		return _project.getSpatiallevel();
	}

	public void setSpatiallevel(java.lang.String spatiallevel) {
		_project.setSpatiallevel(spatiallevel);
	}

	public java.lang.String getAbstracts() {
		return _project.getAbstracts();
	}

	public void setAbstracts(java.lang.String abstracts) {
		_project.setAbstracts(abstracts);
	}

	public java.lang.String getElement() {
		return _project.getElement();
	}

	public void setElement(java.lang.String element) {
		_project.setElement(element);
	}

	public java.lang.String getKeywords() {
		return _project.getKeywords();
	}

	public void setKeywords(java.lang.String keywords) {
		_project.setKeywords(keywords);
	}

	public java.lang.String getWebsite() {
		return _project.getWebsite();
	}

	public void setWebsite(java.lang.String website) {
		_project.setWebsite(website);
	}

	public java.lang.String getDuration() {
		return _project.getDuration();
	}

	public void setDuration(java.lang.String duration) {
		_project.setDuration(duration);
	}

	public nl.wur.alterra.cgi.ace.model.Project toEscapedModel() {
		return _project.toEscapedModel();
	}

	public boolean isNew() {
		return _project.isNew();
	}

	public void setNew(boolean n) {
		_project.setNew(n);
	}

	public boolean isCachedModel() {
		return _project.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_project.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _project.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_project.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _project.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _project.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_project.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _project.clone();
	}

	public int compareTo(nl.wur.alterra.cgi.ace.model.Project project) {
		return _project.compareTo(project);
	}

	public int hashCode() {
		return _project.hashCode();
	}

	public java.lang.String toString() {
		return _project.toString();
	}

	public java.lang.String toXmlString() {
		return _project.toXmlString();
	}

	public Project getWrappedProject() {
		return _project;
	}

	private Project _project;
}