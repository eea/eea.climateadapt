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
 * This class is a wrapper for {@link Measure}.
 * </p>
 *
 * @author    groot052
 * @see       Measure
 * @generated
 */
public class MeasureWrapper implements Measure {
	public MeasureWrapper(Measure measure) {
		_measure = measure;
	}

	public long getPrimaryKey() {
		return _measure.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_measure.setPrimaryKey(pk);
	}

	public long getMeasureId() {
		return _measure.getMeasureId();
	}

	public void setMeasureId(long measureId) {
		_measure.setMeasureId(measureId);
	}

	public long getCompanyId() {
		return _measure.getCompanyId();
	}

	public void setCompanyId(long companyId) {
		_measure.setCompanyId(companyId);
	}

	public long getGroupId() {
		return _measure.getGroupId();
	}

	public void setGroupId(long groupId) {
		_measure.setGroupId(groupId);
	}

	public java.lang.String getName() {
		return _measure.getName();
	}

	public void setName(java.lang.String name) {
		_measure.setName(name);
	}

	public java.lang.String getDescription() {
		return _measure.getDescription();
	}

	public void setDescription(java.lang.String description) {
		_measure.setDescription(description);
	}

	public java.lang.String getImplementationtype() {
		return _measure.getImplementationtype();
	}

	public void setImplementationtype(java.lang.String implementationtype) {
		_measure.setImplementationtype(implementationtype);
	}

	public long getImplementationtime() {
		return _measure.getImplementationtime();
	}

	public void setImplementationtime(long implementationtime) {
		_measure.setImplementationtime(implementationtime);
	}

	public long getLifetime() {
		return _measure.getLifetime();
	}

	public void setLifetime(long lifetime) {
		_measure.setLifetime(lifetime);
	}

	public java.lang.String getSpatiallayer() {
		return _measure.getSpatiallayer();
	}

	public void setSpatiallayer(java.lang.String spatiallayer) {
		_measure.setSpatiallayer(spatiallayer);
	}

	public java.lang.String getSpatialvalues() {
		return _measure.getSpatialvalues();
	}

	public void setSpatialvalues(java.lang.String spatialvalues) {
		_measure.setSpatialvalues(spatialvalues);
	}

	public java.lang.String getLegalaspects() {
		return _measure.getLegalaspects();
	}

	public void setLegalaspects(java.lang.String legalaspects) {
		_measure.setLegalaspects(legalaspects);
	}

	public java.lang.String getStakeholderparticipation() {
		return _measure.getStakeholderparticipation();
	}

	public void setStakeholderparticipation(
		java.lang.String stakeholderparticipation) {
		_measure.setStakeholderparticipation(stakeholderparticipation);
	}

	public java.lang.String getContact() {
		return _measure.getContact();
	}

	public void setContact(java.lang.String contact) {
		_measure.setContact(contact);
	}

	public java.lang.String getSucceslimitations() {
		return _measure.getSucceslimitations();
	}

	public void setSucceslimitations(java.lang.String succeslimitations) {
		_measure.setSucceslimitations(succeslimitations);
	}

	public java.lang.String getWebsite() {
		return _measure.getWebsite();
	}

	public void setWebsite(java.lang.String website) {
		_measure.setWebsite(website);
	}

	public java.lang.String getCostbenefit() {
		return _measure.getCostbenefit();
	}

	public void setCostbenefit(java.lang.String costbenefit) {
		_measure.setCostbenefit(costbenefit);
	}

	public java.lang.String getKeywords() {
		return _measure.getKeywords();
	}

	public void setKeywords(java.lang.String keywords) {
		_measure.setKeywords(keywords);
	}

	public java.util.Date getStartdate() {
		return _measure.getStartdate();
	}

	public void setStartdate(java.util.Date startdate) {
		_measure.setStartdate(startdate);
	}

	public java.util.Date getEnddate() {
		return _measure.getEnddate();
	}

	public void setEnddate(java.util.Date enddate) {
		_measure.setEnddate(enddate);
	}

	public java.util.Date getPublicationdate() {
		return _measure.getPublicationdate();
	}

	public void setPublicationdate(java.util.Date publicationdate) {
		_measure.setPublicationdate(publicationdate);
	}

	public java.lang.String getLanguage() {
		return _measure.getLanguage();
	}

	public void setLanguage(java.lang.String language) {
		_measure.setLanguage(language);
	}

	public java.lang.String getSectors_() {
		return _measure.getSectors_();
	}

	public void setSectors_(java.lang.String sectors_) {
		_measure.setSectors_(sectors_);
	}

	public java.lang.String getElements_() {
		return _measure.getElements_();
	}

	public void setElements_(java.lang.String elements_) {
		_measure.setElements_(elements_);
	}

	public java.lang.String getClimateimpacts_() {
		return _measure.getClimateimpacts_();
	}

	public void setClimateimpacts_(java.lang.String climateimpacts_) {
		_measure.setClimateimpacts_(climateimpacts_);
	}

	public java.lang.String getMao_type() {
		return _measure.getMao_type();
	}

	public void setMao_type(java.lang.String mao_type) {
		_measure.setMao_type(mao_type);
	}

	public nl.wur.alterra.cgi.ace.model.Measure toEscapedModel() {
		return _measure.toEscapedModel();
	}

	public boolean isNew() {
		return _measure.isNew();
	}

	public void setNew(boolean n) {
		_measure.setNew(n);
	}

	public boolean isCachedModel() {
		return _measure.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_measure.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _measure.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_measure.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _measure.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _measure.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_measure.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _measure.clone();
	}

	public int compareTo(nl.wur.alterra.cgi.ace.model.Measure measure) {
		return _measure.compareTo(measure);
	}

	public int hashCode() {
		return _measure.hashCode();
	}

	public java.lang.String toString() {
		return _measure.toString();
	}

	public java.lang.String toXmlString() {
		return _measure.toXmlString();
	}

	public Measure getWrappedMeasure() {
		return _measure;
	}

	private Measure _measure;
}