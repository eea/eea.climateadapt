/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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
 * The base model interface for the Measure service. Represents a row in the &quot;Ace_Measure&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link nl.wur.alterra.cgi.ace.model.impl.MeasureModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link nl.wur.alterra.cgi.ace.model.impl.MeasureImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this interface directly. All methods that expect a measure model instance should use the {@link Measure} interface instead.
 * </p>
 *
 * @author groot052
 * @see Measure
 * @see nl.wur.alterra.cgi.ace.model.impl.MeasureImpl
 * @see nl.wur.alterra.cgi.ace.model.impl.MeasureModelImpl
 * @generated
 */
public interface MeasureModel extends BaseModel<Measure> {
	/**
	 * Gets the primary key of this measure.
	 *
	 * @return the primary key of this measure
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this measure
	 *
	 * @param pk the primary key of this measure
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the measure id of this measure.
	 *
	 * @return the measure id of this measure
	 */
	public long getMeasureId();

	/**
	 * Sets the measure id of this measure.
	 *
	 * @param measureId the measure id of this measure
	 */
	public void setMeasureId(long measureId);

	/**
	 * Gets the company id of this measure.
	 *
	 * @return the company id of this measure
	 */
	public long getCompanyId();

	/**
	 * Sets the company id of this measure.
	 *
	 * @param companyId the company id of this measure
	 */
	public void setCompanyId(long companyId);

	/**
	 * Gets the group id of this measure.
	 *
	 * @return the group id of this measure
	 */
	public long getGroupId();

	/**
	 * Sets the group id of this measure.
	 *
	 * @param groupId the group id of this measure
	 */
	public void setGroupId(long groupId);

	/**
	 * Gets the admincomment of this measure.
	 *
	 * @return the admincomment of this measure
	 */
	@AutoEscape
	public String getAdmincomment();

	/**
	 * Sets the admincomment of this measure.
	 *
	 * @param admincomment the admincomment of this measure
	 */
	public void setAdmincomment(String admincomment);

	/**
	 * Gets the casestudyfeature of this measure.
	 *
	 * @return the casestudyfeature of this measure
	 */
	@AutoEscape
	public String getCasestudyfeature();

	/**
	 * Sets the casestudyfeature of this measure.
	 *
	 * @param casestudyfeature the casestudyfeature of this measure
	 */
	public void setCasestudyfeature(String casestudyfeature);

	/**
	 * Gets the name of this measure.
	 *
	 * @return the name of this measure
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this measure.
	 *
	 * @param name the name of this measure
	 */
	public void setName(String name);

	/**
	 * Gets the description of this measure.
	 *
	 * @return the description of this measure
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this measure.
	 *
	 * @param description the description of this measure
	 */
	public void setDescription(String description);

	/**
	 * Gets the implementationtype of this measure.
	 *
	 * @return the implementationtype of this measure
	 */
	@AutoEscape
	public String getImplementationtype();

	/**
	 * Sets the implementationtype of this measure.
	 *
	 * @param implementationtype the implementationtype of this measure
	 */
	public void setImplementationtype(String implementationtype);

	/**
	 * Gets the implementationtime of this measure.
	 *
	 * @return the implementationtime of this measure
	 */
	@AutoEscape
	public String getImplementationtime();

	/**
	 * Sets the implementationtime of this measure.
	 *
	 * @param implementationtime the implementationtime of this measure
	 */
	public void setImplementationtime(String implementationtime);

	/**
	 * Gets the lifetime of this measure.
	 *
	 * @return the lifetime of this measure
	 */
	@AutoEscape
	public String getLifetime();

	/**
	 * Sets the lifetime of this measure.
	 *
	 * @param lifetime the lifetime of this measure
	 */
	public void setLifetime(String lifetime);

	/**
	 * Gets the spatiallayer of this measure.
	 *
	 * @return the spatiallayer of this measure
	 */
	@AutoEscape
	public String getSpatiallayer();

	/**
	 * Sets the spatiallayer of this measure.
	 *
	 * @param spatiallayer the spatiallayer of this measure
	 */
	public void setSpatiallayer(String spatiallayer);

	/**
	 * Gets the spatialvalues of this measure.
	 *
	 * @return the spatialvalues of this measure
	 */
	@AutoEscape
	public String getSpatialvalues();

	/**
	 * Sets the spatialvalues of this measure.
	 *
	 * @param spatialvalues the spatialvalues of this measure
	 */
	public void setSpatialvalues(String spatialvalues);

	/**
	 * Gets the legalaspects of this measure.
	 *
	 * @return the legalaspects of this measure
	 */
	@AutoEscape
	public String getLegalaspects();

	/**
	 * Sets the legalaspects of this measure.
	 *
	 * @param legalaspects the legalaspects of this measure
	 */
	public void setLegalaspects(String legalaspects);

	/**
	 * Gets the stakeholderparticipation of this measure.
	 *
	 * @return the stakeholderparticipation of this measure
	 */
	@AutoEscape
	public String getStakeholderparticipation();

	/**
	 * Sets the stakeholderparticipation of this measure.
	 *
	 * @param stakeholderparticipation the stakeholderparticipation of this measure
	 */
	public void setStakeholderparticipation(String stakeholderparticipation);

	/**
	 * Gets the contact of this measure.
	 *
	 * @return the contact of this measure
	 */
	@AutoEscape
	public String getContact();

	/**
	 * Sets the contact of this measure.
	 *
	 * @param contact the contact of this measure
	 */
	public void setContact(String contact);

	/**
	 * Gets the objectives of this measure.
	 *
	 * @return the objectives of this measure
	 */
	@AutoEscape
	public String getObjectives();

	/**
	 * Sets the objectives of this measure.
	 *
	 * @param objectives the objectives of this measure
	 */
	public void setObjectives(String objectives);

	/**
	 * Gets the challenges of this measure.
	 *
	 * @return the challenges of this measure
	 */
	@AutoEscape
	public String getChallenges();

	/**
	 * Sets the challenges of this measure.
	 *
	 * @param challenges the challenges of this measure
	 */
	public void setChallenges(String challenges);

	/**
	 * Gets the adaptationoptions of this measure.
	 *
	 * @return the adaptationoptions of this measure
	 */
	@AutoEscape
	public String getAdaptationoptions();

	/**
	 * Sets the adaptationoptions of this measure.
	 *
	 * @param adaptationoptions the adaptationoptions of this measure
	 */
	public void setAdaptationoptions(String adaptationoptions);

	/**
	 * Gets the solutions of this measure.
	 *
	 * @return the solutions of this measure
	 */
	@AutoEscape
	public String getSolutions();

	/**
	 * Sets the solutions of this measure.
	 *
	 * @param solutions the solutions of this measure
	 */
	public void setSolutions(String solutions);

	/**
	 * Gets the relevance of this measure.
	 *
	 * @return the relevance of this measure
	 */
	@AutoEscape
	public String getRelevance();

	/**
	 * Sets the relevance of this measure.
	 *
	 * @param relevance the relevance of this measure
	 */
	public void setRelevance(String relevance);

	/**
	 * Gets the succeslimitations of this measure.
	 *
	 * @return the succeslimitations of this measure
	 */
	@AutoEscape
	public String getSucceslimitations();

	/**
	 * Sets the succeslimitations of this measure.
	 *
	 * @param succeslimitations the succeslimitations of this measure
	 */
	public void setSucceslimitations(String succeslimitations);

	/**
	 * Gets the website of this measure.
	 *
	 * @return the website of this measure
	 */
	@AutoEscape
	public String getWebsite();

	/**
	 * Sets the website of this measure.
	 *
	 * @param website the website of this measure
	 */
	public void setWebsite(String website);

	/**
	 * Gets the costbenefit of this measure.
	 *
	 * @return the costbenefit of this measure
	 */
	@AutoEscape
	public String getCostbenefit();

	/**
	 * Sets the costbenefit of this measure.
	 *
	 * @param costbenefit the costbenefit of this measure
	 */
	public void setCostbenefit(String costbenefit);

	/**
	 * Gets the keywords of this measure.
	 *
	 * @return the keywords of this measure
	 */
	@AutoEscape
	public String getKeywords();

	/**
	 * Sets the keywords of this measure.
	 *
	 * @param keywords the keywords of this measure
	 */
	public void setKeywords(String keywords);

	/**
	 * Gets the geos_ of this measure.
	 *
	 * @return the geos_ of this measure
	 */
	@AutoEscape
	public String getGeos_();

	/**
	 * Sets the geos_ of this measure.
	 *
	 * @param geos_ the geos_ of this measure
	 */
	public void setGeos_(String geos_);

	/**
	 * Gets the startdate of this measure.
	 *
	 * @return the startdate of this measure
	 */
	public Date getStartdate();

	/**
	 * Sets the startdate of this measure.
	 *
	 * @param startdate the startdate of this measure
	 */
	public void setStartdate(Date startdate);

	/**
	 * Gets the enddate of this measure.
	 *
	 * @return the enddate of this measure
	 */
	public Date getEnddate();

	/**
	 * Sets the enddate of this measure.
	 *
	 * @param enddate the enddate of this measure
	 */
	public void setEnddate(Date enddate);

	/**
	 * Gets the publicationdate of this measure.
	 *
	 * @return the publicationdate of this measure
	 */
	public Date getPublicationdate();

	/**
	 * Sets the publicationdate of this measure.
	 *
	 * @param publicationdate the publicationdate of this measure
	 */
	public void setPublicationdate(Date publicationdate);

	/**
	 * Gets the specialtagging of this measure.
	 *
	 * @return the specialtagging of this measure
	 */
	@AutoEscape
	public String getSpecialtagging();

	/**
	 * Sets the specialtagging of this measure.
	 *
	 * @param specialtagging the specialtagging of this measure
	 */
	public void setSpecialtagging(String specialtagging);

	/**
	 * Gets the sectors_ of this measure.
	 *
	 * @return the sectors_ of this measure
	 */
	@AutoEscape
	public String getSectors_();

	/**
	 * Sets the sectors_ of this measure.
	 *
	 * @param sectors_ the sectors_ of this measure
	 */
	public void setSectors_(String sectors_);

	/**
	 * Gets the elements_ of this measure.
	 *
	 * @return the elements_ of this measure
	 */
	@AutoEscape
	public String getElements_();

	/**
	 * Sets the elements_ of this measure.
	 *
	 * @param elements_ the elements_ of this measure
	 */
	public void setElements_(String elements_);

	/**
	 * Gets the climateimpacts_ of this measure.
	 *
	 * @return the climateimpacts_ of this measure
	 */
	@AutoEscape
	public String getClimateimpacts_();

	/**
	 * Sets the climateimpacts_ of this measure.
	 *
	 * @param climateimpacts_ the climateimpacts_ of this measure
	 */
	public void setClimateimpacts_(String climateimpacts_);

	/**
	 * Gets the mao_type of this measure.
	 *
	 * @return the mao_type of this measure
	 */
	@AutoEscape
	public String getMao_type();

	/**
	 * Sets the mao_type of this measure.
	 *
	 * @param mao_type the mao_type of this measure
	 */
	public void setMao_type(String mao_type);

	/**
	 * Gets the source of this measure.
	 *
	 * @return the source of this measure
	 */
	@AutoEscape
	public String getSource();

	/**
	 * Sets the source of this measure.
	 *
	 * @param source the source of this measure
	 */
	public void setSource(String source);

	/**
	 * Gets the rating of this measure.
	 *
	 * @return the rating of this measure
	 */
	public long getRating();

	/**
	 * Sets the rating of this measure.
	 *
	 * @param rating the rating of this measure
	 */
	public void setRating(long rating);

	/**
	 * Gets the importance of this measure.
	 *
	 * @return the importance of this measure
	 */
	public long getImportance();

	/**
	 * Sets the importance of this measure.
	 *
	 * @param importance the importance of this measure
	 */
	public void setImportance(long importance);

	/**
	 * Gets the lon of this measure.
	 *
	 * @return the lon of this measure
	 */
	public double getLon();

	/**
	 * Sets the lon of this measure.
	 *
	 * @param lon the lon of this measure
	 */
	public void setLon(double lon);

	/**
	 * Gets the lat of this measure.
	 *
	 * @return the lat of this measure
	 */
	public double getLat();

	/**
	 * Sets the lat of this measure.
	 *
	 * @param lat the lat of this measure
	 */
	public void setLat(double lat);

	/**
	 * Gets the satarea of this measure.
	 *
	 * @return the satarea of this measure
	 */
	@AutoEscape
	public String getSatarea();

	/**
	 * Sets the satarea of this measure.
	 *
	 * @param satarea the satarea of this measure
	 */
	public void setSatarea(String satarea);

	/**
	 * Gets the controlstatus of this measure.
	 *
	 * @return the controlstatus of this measure
	 */
	public short getControlstatus();

	/**
	 * Sets the controlstatus of this measure.
	 *
	 * @param controlstatus the controlstatus of this measure
	 */
	public void setControlstatus(short controlstatus);

	/**
	 * Gets the creator of this measure.
	 *
	 * @return the creator of this measure
	 */
	@AutoEscape
	public String getCreator();

	/**
	 * Sets the creator of this measure.
	 *
	 * @param creator the creator of this measure
	 */
	public void setCreator(String creator);

	/**
	 * Gets the creationdate of this measure.
	 *
	 * @return the creationdate of this measure
	 */
	public Date getCreationdate();

	/**
	 * Sets the creationdate of this measure.
	 *
	 * @param creationdate the creationdate of this measure
	 */
	public void setCreationdate(Date creationdate);

	/**
	 * Gets the moderator of this measure.
	 *
	 * @return the moderator of this measure
	 */
	@AutoEscape
	public String getModerator();

	/**
	 * Sets the moderator of this measure.
	 *
	 * @param moderator the moderator of this measure
	 */
	public void setModerator(String moderator);

	/**
	 * Gets the approvaldate of this measure.
	 *
	 * @return the approvaldate of this measure
	 */
	public Date getApprovaldate();

	/**
	 * Sets the approvaldate of this measure.
	 *
	 * @param approvaldate the approvaldate of this measure
	 */
	public void setApprovaldate(Date approvaldate);

	/**
	 * Gets the replaces id of this measure.
	 *
	 * @return the replaces id of this measure
	 */
	public long getReplacesId();

	/**
	 * Sets the replaces id of this measure.
	 *
	 * @param replacesId the replaces id of this measure
	 */
	public void setReplacesId(long replacesId);

	/**
	 * Gets the comments of this measure.
	 *
	 * @return the comments of this measure
	 */
	@AutoEscape
	public String getComments();

	/**
	 * Sets the comments of this measure.
	 *
	 * @param comments the comments of this measure
	 */
	public void setComments(String comments);

	/**
	 * Gets the textwebpage of this measure.
	 *
	 * @return the textwebpage of this measure
	 */
	@AutoEscape
	public String getTextwebpage();

	/**
	 * Sets the textwebpage of this measure.
	 *
	 * @param textwebpage the textwebpage of this measure
	 */
	public void setTextwebpage(String textwebpage);

	/**
	 * Gets the primephoto of this measure.
	 *
	 * @return the primephoto of this measure
	 */
	@AutoEscape
	public String getPrimephoto();

	/**
	 * Sets the primephoto of this measure.
	 *
	 * @param primephoto the primephoto of this measure
	 */
	public void setPrimephoto(String primephoto);

	/**
	 * Gets the supphotos of this measure.
	 *
	 * @return the supphotos of this measure
	 */
	@AutoEscape
	public String getSupphotos();

	/**
	 * Sets the supphotos of this measure.
	 *
	 * @param supphotos the supphotos of this measure
	 */
	public void setSupphotos(String supphotos);

	/**
	 * Gets the supdocs of this measure.
	 *
	 * @return the supdocs of this measure
	 */
	@AutoEscape
	public String getSupdocs();

	/**
	 * Sets the supdocs of this measure.
	 *
	 * @param supdocs the supdocs of this measure
	 */
	public void setSupdocs(String supdocs);

	/**
	 * Gets the year of this measure.
	 *
	 * @return the year of this measure
	 */
	@AutoEscape
	public String getYear();

	/**
	 * Sets the year of this measure.
	 *
	 * @param year the year of this measure
	 */
	public void setYear(String year);

	/**
	 * Gets the geochars of this measure.
	 *
	 * @return the geochars of this measure
	 */
	@AutoEscape
	public String getGeochars();

	/**
	 * Sets the geochars of this measure.
	 *
	 * @param geochars the geochars of this measure
	 */
	public void setGeochars(String geochars);

	/**
	 * Gets a copy of this measure as an escaped model instance by wrapping it with an {@link com.liferay.portal.kernel.bean.AutoEscapeBeanHandler}.
	 *
	 * @return the escaped model instance
	 * @see com.liferay.portal.kernel.bean.AutoEscapeBeanHandler
	 */
	public Measure toEscapedModel();

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

	public int compareTo(Measure measure);

	public int hashCode();

	public String toString();

	public String toXmlString();
}