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

import com.liferay.portal.kernel.annotation.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Project service. Represents a row in the &quot;Ace_Project&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link nl.wur.alterra.cgi.ace.model.impl.ProjectModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link nl.wur.alterra.cgi.ace.model.impl.ProjectImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this interface directly. All methods that expect a project model instance should use the {@link Project} interface instead.
 * </p>
 *
 * @author Groot052
 * @see Project
 * @see nl.wur.alterra.cgi.ace.model.impl.ProjectImpl
 * @see nl.wur.alterra.cgi.ace.model.impl.ProjectModelImpl
 * @generated
 */
public interface ProjectModel extends BaseModel<Project> {
	/**
	 * Gets the primary key of this project.
	 *
	 * @return the primary key of this project
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this project
	 *
	 * @param pk the primary key of this project
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the project id of this project.
	 *
	 * @return the project id of this project
	 */
	public long getProjectId();

	/**
	 * Sets the project id of this project.
	 *
	 * @param projectId the project id of this project
	 */
	public void setProjectId(long projectId);

	/**
	 * Gets the company id of this project.
	 *
	 * @return the company id of this project
	 */
	public long getCompanyId();

	/**
	 * Sets the company id of this project.
	 *
	 * @param companyId the company id of this project
	 */
	public void setCompanyId(long companyId);

	/**
	 * Gets the group id of this project.
	 *
	 * @return the group id of this project
	 */
	public long getGroupId();

	/**
	 * Sets the group id of this project.
	 *
	 * @param groupId the group id of this project
	 */
	public void setGroupId(long groupId);

	/**
	 * Gets the acronym of this project.
	 *
	 * @return the acronym of this project
	 */
	@AutoEscape
	public String getAcronym();

	/**
	 * Sets the acronym of this project.
	 *
	 * @param acronym the acronym of this project
	 */
	public void setAcronym(String acronym);

	/**
	 * Gets the title of this project.
	 *
	 * @return the title of this project
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this project.
	 *
	 * @param title the title of this project
	 */
	public void setTitle(String title);

	/**
	 * Gets the startdate of this project.
	 *
	 * @return the startdate of this project
	 */
	public Date getStartdate();

	/**
	 * Sets the startdate of this project.
	 *
	 * @param startdate the startdate of this project
	 */
	public void setStartdate(Date startdate);

	/**
	 * Gets the enddate of this project.
	 *
	 * @return the enddate of this project
	 */
	public Date getEnddate();

	/**
	 * Sets the enddate of this project.
	 *
	 * @param enddate the enddate of this project
	 */
	public void setEnddate(Date enddate);

	/**
	 * Gets the lead of this project.
	 *
	 * @return the lead of this project
	 */
	@AutoEscape
	public String getLead();

	/**
	 * Sets the lead of this project.
	 *
	 * @param lead the lead of this project
	 */
	public void setLead(String lead);

	/**
	 * Gets the partners of this project.
	 *
	 * @return the partners of this project
	 */
	@AutoEscape
	public String getPartners();

	/**
	 * Sets the partners of this project.
	 *
	 * @param partners the partners of this project
	 */
	public void setPartners(String partners);

	/**
	 * Gets the funding of this project.
	 *
	 * @return the funding of this project
	 */
	@AutoEscape
	public String getFunding();

	/**
	 * Sets the funding of this project.
	 *
	 * @param funding the funding of this project
	 */
	public void setFunding(String funding);

	/**
	 * Gets the sectors of this project.
	 *
	 * @return the sectors of this project
	 */
	@AutoEscape
	public String getSectors();

	/**
	 * Sets the sectors of this project.
	 *
	 * @param sectors the sectors of this project
	 */
	public void setSectors(String sectors);

	/**
	 * Gets the spatiallayer of this project.
	 *
	 * @return the spatiallayer of this project
	 */
	@AutoEscape
	public String getSpatiallayer();

	/**
	 * Sets the spatiallayer of this project.
	 *
	 * @param spatiallayer the spatiallayer of this project
	 */
	public void setSpatiallayer(String spatiallayer);

	/**
	 * Gets the abstracts of this project.
	 *
	 * @return the abstracts of this project
	 */
	@AutoEscape
	public String getAbstracts();

	/**
	 * Sets the abstracts of this project.
	 *
	 * @param abstracts the abstracts of this project
	 */
	public void setAbstracts(String abstracts);

	/**
	 * Gets the element of this project.
	 *
	 * @return the element of this project
	 */
	@AutoEscape
	public String getElement();

	/**
	 * Sets the element of this project.
	 *
	 * @param element the element of this project
	 */
	public void setElement(String element);

	/**
	 * Gets the keywords of this project.
	 *
	 * @return the keywords of this project
	 */
	@AutoEscape
	public String getKeywords();

	/**
	 * Sets the keywords of this project.
	 *
	 * @param keywords the keywords of this project
	 */
	public void setKeywords(String keywords);

	/**
	 * Gets the website of this project.
	 *
	 * @return the website of this project
	 */
	@AutoEscape
	public String getWebsite();

	/**
	 * Sets the website of this project.
	 *
	 * @param website the website of this project
	 */
	public void setWebsite(String website);

	/**
	 * Gets the duration of this project.
	 *
	 * @return the duration of this project
	 */
	@AutoEscape
	public String getDuration();

	/**
	 * Sets the duration of this project.
	 *
	 * @param duration the duration of this project
	 */
	public void setDuration(String duration);

	/**
	 * Gets the rating of this project.
	 *
	 * @return the rating of this project
	 */
	public long getRating();

	/**
	 * Sets the rating of this project.
	 *
	 * @param rating the rating of this project
	 */
	public void setRating(long rating);

	/**
	 * Gets the importance of this project.
	 *
	 * @return the importance of this project
	 */
	public long getImportance();

	/**
	 * Sets the importance of this project.
	 *
	 * @param importance the importance of this project
	 */
	public void setImportance(long importance);

	/**
	 * Gets the specialtagging of this project.
	 *
	 * @return the specialtagging of this project
	 */
	@AutoEscape
	public String getSpecialtagging();

	/**
	 * Sets the specialtagging of this project.
	 *
	 * @param specialtagging the specialtagging of this project
	 */
	public void setSpecialtagging(String specialtagging);

	/**
	 * Gets the controlstatus of this project.
	 *
	 * @return the controlstatus of this project
	 */
	public short getControlstatus();

	/**
	 * Sets the controlstatus of this project.
	 *
	 * @param controlstatus the controlstatus of this project
	 */
	public void setControlstatus(short controlstatus);

	/**
	 * Gets the creator of this project.
	 *
	 * @return the creator of this project
	 */
	@AutoEscape
	public String getCreator();

	/**
	 * Sets the creator of this project.
	 *
	 * @param creator the creator of this project
	 */
	public void setCreator(String creator);

	/**
	 * Gets the creationdate of this project.
	 *
	 * @return the creationdate of this project
	 */
	public Date getCreationdate();

	/**
	 * Sets the creationdate of this project.
	 *
	 * @param creationdate the creationdate of this project
	 */
	public void setCreationdate(Date creationdate);

	/**
	 * Gets the moderator of this project.
	 *
	 * @return the moderator of this project
	 */
	@AutoEscape
	public String getModerator();

	/**
	 * Sets the moderator of this project.
	 *
	 * @param moderator the moderator of this project
	 */
	public void setModerator(String moderator);

	/**
	 * Gets the approvaldate of this project.
	 *
	 * @return the approvaldate of this project
	 */
	public Date getApprovaldate();

	/**
	 * Sets the approvaldate of this project.
	 *
	 * @param approvaldate the approvaldate of this project
	 */
	public void setApprovaldate(Date approvaldate);

	/**
	 * Gets the replaces id of this project.
	 *
	 * @return the replaces id of this project
	 */
	public long getReplacesId();

	/**
	 * Sets the replaces id of this project.
	 *
	 * @param replacesId the replaces id of this project
	 */
	public void setReplacesId(long replacesId);

	/**
	 * Gets the comments of this project.
	 *
	 * @return the comments of this project
	 */
	@AutoEscape
	public String getComments();

	/**
	 * Sets the comments of this project.
	 *
	 * @param comments the comments of this project
	 */
	public void setComments(String comments);

	/**
	 * Gets the textwebpage of this project.
	 *
	 * @return the textwebpage of this project
	 */
	@AutoEscape
	public String getTextwebpage();

	/**
	 * Sets the textwebpage of this project.
	 *
	 * @param textwebpage the textwebpage of this project
	 */
	public void setTextwebpage(String textwebpage);

	/**
	 * Gets the spatialvalues of this project.
	 *
	 * @return the spatialvalues of this project
	 */
	@AutoEscape
	public String getSpatialvalues();

	/**
	 * Sets the spatialvalues of this project.
	 *
	 * @param spatialvalues the spatialvalues of this project
	 */
	public void setSpatialvalues(String spatialvalues);

	/**
	 * Gets the source of this project.
	 *
	 * @return the source of this project
	 */
	@AutoEscape
	public String getSource();

	/**
	 * Sets the source of this project.
	 *
	 * @param source the source of this project
	 */
	public void setSource(String source);

	/**
	 * Gets the climateimpacts of this project.
	 *
	 * @return the climateimpacts of this project
	 */
	@AutoEscape
	public String getClimateimpacts();

	/**
	 * Sets the climateimpacts of this project.
	 *
	 * @param climateimpacts the climateimpacts of this project
	 */
	public void setClimateimpacts(String climateimpacts);

	/**
	 * Gets the lockdate of this project.
	 *
	 * @return the lockdate of this project
	 */
	public Date getLockdate();

	/**
	 * Sets the lockdate of this project.
	 *
	 * @param lockdate the lockdate of this project
	 */
	public void setLockdate(Date lockdate);

	/**
	 * Gets a copy of this project as an escaped model instance by wrapping it with an {@link com.liferay.portal.kernel.bean.AutoEscapeBeanHandler}.
	 *
	 * @return the escaped model instance
	 * @see com.liferay.portal.kernel.bean.AutoEscapeBeanHandler
	 */
	public Project toEscapedModel();

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public void setEscapedModel(boolean escapedModel);

	public Serializable getPrimaryKeyObj();

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(Project project);

	public int hashCode();

	public String toString();

	public String toXmlString();
}