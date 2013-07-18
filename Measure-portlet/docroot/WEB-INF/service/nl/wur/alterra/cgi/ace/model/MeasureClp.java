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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author groot052
 */
public class MeasureClp extends BaseModelImpl<Measure> implements Measure {
	public MeasureClp() {
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

	public String getAdmincomment() {
		return _admincomment;
	}

	public void setAdmincomment(String admincomment) {
		_admincomment = admincomment;
	}

	public String getCasestudyfeature() {
		return _casestudyfeature;
	}

	public void setCasestudyfeature(String casestudyfeature) {
		_casestudyfeature = casestudyfeature;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getImplementationtype() {
		return _implementationtype;
	}

	public void setImplementationtype(String implementationtype) {
		_implementationtype = implementationtype;
	}

	public String getImplementationtime() {
		return _implementationtime;
	}

	public void setImplementationtime(String implementationtime) {
		_implementationtime = implementationtime;
	}

	public String getLifetime() {
		return _lifetime;
	}

	public void setLifetime(String lifetime) {
		_lifetime = lifetime;
	}

	public String getSpatiallayer() {
		return _spatiallayer;
	}

	public void setSpatiallayer(String spatiallayer) {
		_spatiallayer = spatiallayer;
	}

	public String getSpatialvalues() {
		return _spatialvalues;
	}

	public void setSpatialvalues(String spatialvalues) {
		_spatialvalues = spatialvalues;
	}

	public String getLegalaspects() {
		return _legalaspects;
	}

	public void setLegalaspects(String legalaspects) {
		_legalaspects = legalaspects;
	}

	public String getStakeholderparticipation() {
		return _stakeholderparticipation;
	}

	public void setStakeholderparticipation(String stakeholderparticipation) {
		_stakeholderparticipation = stakeholderparticipation;
	}

	public String getContact() {
		return _contact;
	}

	public void setContact(String contact) {
		_contact = contact;
	}

	public String getObjectives() {
		return _objectives;
	}

	public void setObjectives(String objectives) {
		_objectives = objectives;
	}

	public String getChallenges() {
		return _challenges;
	}

	public void setChallenges(String challenges) {
		_challenges = challenges;
	}

	public String getAdaptationoptions() {
		return _adaptationoptions;
	}

	public void setAdaptationoptions(String adaptationoptions) {
		_adaptationoptions = adaptationoptions;
	}

	public String getSolutions() {
		return _solutions;
	}

	public void setSolutions(String solutions) {
		_solutions = solutions;
	}

	public String getRelevance() {
		return _relevance;
	}

	public void setRelevance(String relevance) {
		_relevance = relevance;
	}

	public String getSucceslimitations() {
		return _succeslimitations;
	}

	public void setSucceslimitations(String succeslimitations) {
		_succeslimitations = succeslimitations;
	}

	public String getWebsite() {
		return _website;
	}

	public void setWebsite(String website) {
		_website = website;
	}

	public String getCostbenefit() {
		return _costbenefit;
	}

	public void setCostbenefit(String costbenefit) {
		_costbenefit = costbenefit;
	}

	public String getKeywords() {
		return _keywords;
	}

	public void setKeywords(String keywords) {
		_keywords = keywords;
	}

	public String getGeos_() {
		return _geos_;
	}

	public void setGeos_(String geos_) {
		_geos_ = geos_;
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
		return _specialtagging;
	}

	public void setSpecialtagging(String specialtagging) {
		_specialtagging = specialtagging;
	}

	public String getSectors_() {
		return _sectors_;
	}

	public void setSectors_(String sectors_) {
		_sectors_ = sectors_;
	}

	public String getElements_() {
		return _elements_;
	}

	public void setElements_(String elements_) {
		_elements_ = elements_;
	}

	public String getClimateimpacts_() {
		return _climateimpacts_;
	}

	public void setClimateimpacts_(String climateimpacts_) {
		_climateimpacts_ = climateimpacts_;
	}

	public String getMao_type() {
		return _mao_type;
	}

	public void setMao_type(String mao_type) {
		_mao_type = mao_type;
	}

	public String getSource() {
		return _source;
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
		return _satarea;
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

	public long getReplacesId() {
		return _replacesId;
	}

	public void setReplacesId(long replacesId) {
		_replacesId = replacesId;
	}

	public String getComments() {
		return _comments;
	}

	public void setComments(String comments) {
		_comments = comments;
	}

	public String getTextwebpage() {
		return _textwebpage;
	}

	public void setTextwebpage(String textwebpage) {
		_textwebpage = textwebpage;
	}

	public String getPrimephoto() {
		return _primephoto;
	}

	public void setPrimephoto(String primephoto) {
		_primephoto = primephoto;
	}

	public String getSupphotos() {
		return _supphotos;
	}

	public void setSupphotos(String supphotos) {
		_supphotos = supphotos;
	}

	public String getSupdocs() {
		return _supdocs;
	}

	public void setSupdocs(String supdocs) {
		_supdocs = supdocs;
	}

	public String getYear() {
		return _year;
	}

	public void setYear(String year) {
		_year = year;
	}

	public String getGeochars() {
		return _geochars;
	}

	public void setGeochars(String geochars) {
		_geochars = geochars;
	}

	public String getCategory() {
		return _category;
	}

	public void setCategory(String category) {
		_category = category;
	}

	public Measure toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (Measure)Proxy.newProxyInstance(Measure.class.getClassLoader(),
				new Class[] { Measure.class }, new AutoEscapeBeanHandler(this));
		}
	}

	public Object clone() {
		MeasureClp clone = new MeasureClp();

		clone.setMeasureId(getMeasureId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setAdmincomment(getAdmincomment());
		clone.setCasestudyfeature(getCasestudyfeature());
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
		clone.setObjectives(getObjectives());
		clone.setChallenges(getChallenges());
		clone.setAdaptationoptions(getAdaptationoptions());
		clone.setSolutions(getSolutions());
		clone.setRelevance(getRelevance());
		clone.setSucceslimitations(getSucceslimitations());
		clone.setWebsite(getWebsite());
		clone.setCostbenefit(getCostbenefit());
		clone.setKeywords(getKeywords());
		clone.setGeos_(getGeos_());
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
		clone.setReplacesId(getReplacesId());
		clone.setComments(getComments());
		clone.setTextwebpage(getTextwebpage());
		clone.setPrimephoto(getPrimephoto());
		clone.setSupphotos(getSupphotos());
		clone.setSupdocs(getSupdocs());
		clone.setYear(getYear());
		clone.setGeochars(getGeochars());
		clone.setCategory(getCategory());

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

		MeasureClp measure = null;

		try {
			measure = (MeasureClp)obj;
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
		StringBundler sb = new StringBundler(107);

		sb.append("{measureId=");
		sb.append(getMeasureId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", admincomment=");
		sb.append(getAdmincomment());
		sb.append(", casestudyfeature=");
		sb.append(getCasestudyfeature());
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
		sb.append(", objectives=");
		sb.append(getObjectives());
		sb.append(", challenges=");
		sb.append(getChallenges());
		sb.append(", adaptationoptions=");
		sb.append(getAdaptationoptions());
		sb.append(", solutions=");
		sb.append(getSolutions());
		sb.append(", relevance=");
		sb.append(getRelevance());
		sb.append(", succeslimitations=");
		sb.append(getSucceslimitations());
		sb.append(", website=");
		sb.append(getWebsite());
		sb.append(", costbenefit=");
		sb.append(getCostbenefit());
		sb.append(", keywords=");
		sb.append(getKeywords());
		sb.append(", geos_=");
		sb.append(getGeos_());
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
		sb.append(", replacesId=");
		sb.append(getReplacesId());
		sb.append(", comments=");
		sb.append(getComments());
		sb.append(", textwebpage=");
		sb.append(getTextwebpage());
		sb.append(", primephoto=");
		sb.append(getPrimephoto());
		sb.append(", supphotos=");
		sb.append(getSupphotos());
		sb.append(", supdocs=");
		sb.append(getSupdocs());
		sb.append(", year=");
		sb.append(getYear());
		sb.append(", geochars=");
		sb.append(getGeochars());
		sb.append(", category=");
		sb.append(getCategory());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(163);

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
			"<column><column-name>admincomment</column-name><column-value><![CDATA[");
		sb.append(getAdmincomment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>casestudyfeature</column-name><column-value><![CDATA[");
		sb.append(getCasestudyfeature());
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
			"<column><column-name>objectives</column-name><column-value><![CDATA[");
		sb.append(getObjectives());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>challenges</column-name><column-value><![CDATA[");
		sb.append(getChallenges());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>adaptationoptions</column-name><column-value><![CDATA[");
		sb.append(getAdaptationoptions());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>solutions</column-name><column-value><![CDATA[");
		sb.append(getSolutions());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>relevance</column-name><column-value><![CDATA[");
		sb.append(getRelevance());
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
			"<column><column-name>geos_</column-name><column-value><![CDATA[");
		sb.append(getGeos_());
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
		sb.append(
			"<column><column-name>primephoto</column-name><column-value><![CDATA[");
		sb.append(getPrimephoto());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>supphotos</column-name><column-value><![CDATA[");
		sb.append(getSupphotos());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>supdocs</column-name><column-value><![CDATA[");
		sb.append(getSupdocs());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>year</column-name><column-value><![CDATA[");
		sb.append(getYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>geochars</column-name><column-value><![CDATA[");
		sb.append(getGeochars());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>category</column-name><column-value><![CDATA[");
		sb.append(getCategory());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _measureId;
	private long _companyId;
	private long _groupId;
	private String _admincomment;
	private String _casestudyfeature;
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
	private String _objectives;
	private String _challenges;
	private String _adaptationoptions;
	private String _solutions;
	private String _relevance;
	private String _succeslimitations;
	private String _website;
	private String _costbenefit;
	private String _keywords;
	private String _geos_;
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
	private long _replacesId;
	private String _comments;
	private String _textwebpage;
	private String _primephoto;
	private String _supphotos;
	private String _supdocs;
	private String _year;
	private String _geochars;
	private String _category;
}