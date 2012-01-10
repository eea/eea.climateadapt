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
 * This class is a wrapper for {@link CSWHarvester}.
 * </p>
 *
 * @author    groot052
 * @see       CSWHarvester
 * @generated
 */
public class CSWHarvesterWrapper implements CSWHarvester {
	public CSWHarvesterWrapper(CSWHarvester cswHarvester) {
		_cswHarvester = cswHarvester;
	}

	public long getPrimaryKey() {
		return _cswHarvester.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_cswHarvester.setPrimaryKey(pk);
	}

	public long getCswharvesterid() {
		return _cswHarvester.getCswharvesterid();
	}

	public void setCswharvesterid(long cswharvesterid) {
		_cswHarvester.setCswharvesterid(cswharvesterid);
	}

	public java.lang.String getName() {
		return _cswHarvester.getName();
	}

	public void setName(java.lang.String name) {
		_cswHarvester.setName(name);
	}

	public java.lang.String getUrl() {
		return _cswHarvester.getUrl();
	}

	public void setUrl(java.lang.String url) {
		_cswHarvester.setUrl(url);
	}

	public java.lang.String getFreetext() {
		return _cswHarvester.getFreetext();
	}

	public void setFreetext(java.lang.String freetext) {
		_cswHarvester.setFreetext(freetext);
	}

	public java.lang.String getTitle() {
		return _cswHarvester.getTitle();
	}

	public void setTitle(java.lang.String title) {
		_cswHarvester.setTitle(title);
	}

	public java.lang.String getAbstrakt() {
		return _cswHarvester.getAbstrakt();
	}

	public void setAbstrakt(java.lang.String abstrakt) {
		_cswHarvester.setAbstrakt(abstrakt);
	}

	public java.lang.String getSubject() {
		return _cswHarvester.getSubject();
	}

	public void setSubject(java.lang.String subject) {
		_cswHarvester.setSubject(subject);
	}

	public int getEvery() {
		return _cswHarvester.getEvery();
	}

	public void setEvery(int every) {
		_cswHarvester.setEvery(every);
	}

	public java.lang.String getTopic() {
		return _cswHarvester.getTopic();
	}

	public void setTopic(java.lang.String topic) {
		_cswHarvester.setTopic(topic);
	}

	public java.lang.String getStatus() {
		return _cswHarvester.getStatus();
	}

	public void setStatus(java.lang.String status) {
		_cswHarvester.setStatus(status);
	}

	public boolean getSavedToGeoNetwork() {
		return _cswHarvester.getSavedToGeoNetwork();
	}

	public boolean isSavedToGeoNetwork() {
		return _cswHarvester.isSavedToGeoNetwork();
	}

	public void setSavedToGeoNetwork(boolean savedToGeoNetwork) {
		_cswHarvester.setSavedToGeoNetwork(savedToGeoNetwork);
	}

	public long getGeonetworkId() {
		return _cswHarvester.getGeonetworkId();
	}

	public void setGeonetworkId(long geonetworkId) {
		_cswHarvester.setGeonetworkId(geonetworkId);
	}

	public java.lang.String getGeonetworkUUID() {
		return _cswHarvester.getGeonetworkUUID();
	}

	public void setGeonetworkUUID(java.lang.String geonetworkUUID) {
		_cswHarvester.setGeonetworkUUID(geonetworkUUID);
	}

	public long getCompanyId() {
		return _cswHarvester.getCompanyId();
	}

	public void setCompanyId(long companyId) {
		_cswHarvester.setCompanyId(companyId);
	}

	public long getGroupId() {
		return _cswHarvester.getGroupId();
	}

	public void setGroupId(long groupId) {
		_cswHarvester.setGroupId(groupId);
	}

	public nl.wur.alterra.cgi.ace.model.CSWHarvester toEscapedModel() {
		return _cswHarvester.toEscapedModel();
	}

	public boolean isNew() {
		return _cswHarvester.isNew();
	}

	public void setNew(boolean n) {
		_cswHarvester.setNew(n);
	}

	public boolean isCachedModel() {
		return _cswHarvester.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_cswHarvester.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _cswHarvester.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_cswHarvester.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _cswHarvester.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _cswHarvester.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_cswHarvester.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _cswHarvester.clone();
	}

	public int compareTo(nl.wur.alterra.cgi.ace.model.CSWHarvester cswHarvester) {
		return _cswHarvester.compareTo(cswHarvester);
	}

	public int hashCode() {
		return _cswHarvester.hashCode();
	}

	public java.lang.String toString() {
		return _cswHarvester.toString();
	}

	public java.lang.String toXmlString() {
		return _cswHarvester.toXmlString();
	}

	public java.lang.String toShortString() {
		return _cswHarvester.toShortString();
	}

	public CSWHarvester getWrappedCSWHarvester() {
		return _cswHarvester;
	}

	private CSWHarvester _cswHarvester;
}