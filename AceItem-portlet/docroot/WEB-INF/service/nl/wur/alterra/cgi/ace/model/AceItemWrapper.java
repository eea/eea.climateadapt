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
 * This class is a wrapper for {@link AceItem}.
 * </p>
 *
 * @author    groot052
 * @see       AceItem
 * @generated
 */
public class AceItemWrapper implements AceItem {
	public AceItemWrapper(AceItem aceItem) {
		_aceItem = aceItem;
	}

	public long getPrimaryKey() {
		return _aceItem.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_aceItem.setPrimaryKey(pk);
	}

	public long getAceItemId() {
		return _aceItem.getAceItemId();
	}

	public void setAceItemId(long aceItemId) {
		_aceItem.setAceItemId(aceItemId);
	}

	public long getCompanyId() {
		return _aceItem.getCompanyId();
	}

	public void setCompanyId(long companyId) {
		_aceItem.setCompanyId(companyId);
	}

	public long getGroupId() {
		return _aceItem.getGroupId();
	}

	public void setGroupId(long groupId) {
		_aceItem.setGroupId(groupId);
	}

	public long getWxsharvesterId() {
		return _aceItem.getWxsharvesterId();
	}

	public void setWxsharvesterId(long wxsharvesterId) {
		_aceItem.setWxsharvesterId(wxsharvesterId);
	}

	public java.lang.String getName() {
		return _aceItem.getName();
	}

	public void setName(java.lang.String name) {
		_aceItem.setName(name);
	}

	public java.lang.String getDescription() {
		return _aceItem.getDescription();
	}

	public void setDescription(java.lang.String description) {
		_aceItem.setDescription(description);
	}

	public java.lang.String getDatatype() {
		return _aceItem.getDatatype();
	}

	public void setDatatype(java.lang.String datatype) {
		_aceItem.setDatatype(datatype);
	}

	public java.lang.String getStoredAt() {
		return _aceItem.getStoredAt();
	}

	public void setStoredAt(java.lang.String storedAt) {
		_aceItem.setStoredAt(storedAt);
	}

	public java.lang.String getStoragetype() {
		return _aceItem.getStoragetype();
	}

	public void setStoragetype(java.lang.String storagetype) {
		_aceItem.setStoragetype(storagetype);
	}

	public java.lang.String getSpecialtagging() {
		return _aceItem.getSpecialtagging();
	}

	public void setSpecialtagging(java.lang.String specialtagging) {
		_aceItem.setSpecialtagging(specialtagging);
	}

	public java.lang.String getTextSearch() {
		return _aceItem.getTextSearch();
	}

	public void setTextSearch(java.lang.String textSearch) {
		_aceItem.setTextSearch(textSearch);
	}

	public java.lang.String getKeyword() {
		return _aceItem.getKeyword();
	}

	public void setKeyword(java.lang.String keyword) {
		_aceItem.setKeyword(keyword);
	}

	public java.lang.String getTargetresolution() {
		return _aceItem.getTargetresolution();
	}

	public void setTargetresolution(java.lang.String targetresolution) {
		_aceItem.setTargetresolution(targetresolution);
	}

	public java.lang.String getSpatialLayer() {
		return _aceItem.getSpatialLayer();
	}

	public void setSpatialLayer(java.lang.String spatialLayer) {
		_aceItem.setSpatialLayer(spatialLayer);
	}

	public java.lang.String getSpatialValues() {
		return _aceItem.getSpatialValues();
	}

	public void setSpatialValues(java.lang.String spatialValues) {
		_aceItem.setSpatialValues(spatialValues);
	}

	public java.util.Date getStartDate() {
		return _aceItem.getStartDate();
	}

	public void setStartDate(java.util.Date startDate) {
		_aceItem.setStartDate(startDate);
	}

	public java.util.Date getEndDate() {
		return _aceItem.getEndDate();
	}

	public void setEndDate(java.util.Date endDate) {
		_aceItem.setEndDate(endDate);
	}

	public java.util.Date getPublicationDate() {
		return _aceItem.getPublicationDate();
	}

	public void setPublicationDate(java.util.Date publicationDate) {
		_aceItem.setPublicationDate(publicationDate);
	}

	public java.lang.String getSectors_() {
		return _aceItem.getSectors_();
	}

	public void setSectors_(java.lang.String sectors_) {
		_aceItem.setSectors_(sectors_);
	}

	public java.lang.String getElements_() {
		return _aceItem.getElements_();
	}

	public void setElements_(java.lang.String elements_) {
		_aceItem.setElements_(elements_);
	}

	public java.lang.String getClimateimpacts_() {
		return _aceItem.getClimateimpacts_();
	}

	public void setClimateimpacts_(java.lang.String climateimpacts_) {
		_aceItem.setClimateimpacts_(climateimpacts_);
	}

	public long getRating() {
		return _aceItem.getRating();
	}

	public void setRating(long rating) {
		_aceItem.setRating(rating);
	}

	public long getImportance() {
		return _aceItem.getImportance();
	}

	public void setImportance(long importance) {
		_aceItem.setImportance(importance);
	}

	public java.lang.String getSource() {
		return _aceItem.getSource();
	}

	public void setSource(java.lang.String source) {
		_aceItem.setSource(source);
	}

	public java.lang.String getDeeplink() {
		return _aceItem.getDeeplink();
	}

	public void setDeeplink(java.lang.String deeplink) {
		_aceItem.setDeeplink(deeplink);
	}

	public short getControlstatus() {
		return _aceItem.getControlstatus();
	}

	public void setControlstatus(short controlstatus) {
		_aceItem.setControlstatus(controlstatus);
	}

	public java.lang.String getCreator() {
		return _aceItem.getCreator();
	}

	public void setCreator(java.lang.String creator) {
		_aceItem.setCreator(creator);
	}

	public java.util.Date getCreationdate() {
		return _aceItem.getCreationdate();
	}

	public void setCreationdate(java.util.Date creationdate) {
		_aceItem.setCreationdate(creationdate);
	}

	public java.lang.String getModerator() {
		return _aceItem.getModerator();
	}

	public void setModerator(java.lang.String moderator) {
		_aceItem.setModerator(moderator);
	}

	public java.util.Date getApprovaldate() {
		return _aceItem.getApprovaldate();
	}

	public void setApprovaldate(java.util.Date approvaldate) {
		_aceItem.setApprovaldate(approvaldate);
	}

	public long getReplacesId() {
		return _aceItem.getReplacesId();
	}

	public void setReplacesId(long replacesId) {
		_aceItem.setReplacesId(replacesId);
	}

	public java.lang.String getComments() {
		return _aceItem.getComments();
	}

	public void setComments(java.lang.String comments) {
		_aceItem.setComments(comments);
	}

	public java.lang.String getTextwebpage() {
		return _aceItem.getTextwebpage();
	}

	public void setTextwebpage(java.lang.String textwebpage) {
		_aceItem.setTextwebpage(textwebpage);
	}

	public nl.wur.alterra.cgi.ace.model.AceItem toEscapedModel() {
		return _aceItem.toEscapedModel();
	}

	public boolean isNew() {
		return _aceItem.isNew();
	}

	public void setNew(boolean n) {
		_aceItem.setNew(n);
	}

	public boolean isCachedModel() {
		return _aceItem.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_aceItem.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _aceItem.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_aceItem.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _aceItem.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _aceItem.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_aceItem.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _aceItem.clone();
	}

	public int compareTo(nl.wur.alterra.cgi.ace.model.AceItem aceItem) {
		return _aceItem.compareTo(aceItem);
	}

	public int hashCode() {
		return _aceItem.hashCode();
	}

	public java.lang.String toString() {
		return _aceItem.toString();
	}

	public java.lang.String toXmlString() {
		return _aceItem.toXmlString();
	}

	public AceItem getWrappedAceItem() {
		return _aceItem;
	}

	private AceItem _aceItem;
}