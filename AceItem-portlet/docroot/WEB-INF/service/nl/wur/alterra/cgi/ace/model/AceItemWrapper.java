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

	public java.lang.String getType() {
		return _aceItem.getType();
	}

	public void setType(java.lang.String type) {
		_aceItem.setType(type);
	}

	public java.lang.String getStoredAt() {
		return _aceItem.getStoredAt();
	}

	public void setStoredAt(java.lang.String storedAt) {
		_aceItem.setStoredAt(storedAt);
	}

	public java.lang.String getSector() {
		return _aceItem.getSector();
	}

	public void setSector(java.lang.String sector) {
		_aceItem.setSector(sector);
	}

	public java.lang.String getPilar() {
		return _aceItem.getPilar();
	}

	public void setPilar(java.lang.String pilar) {
		_aceItem.setPilar(pilar);
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

	public java.lang.String getNutsId() {
		return _aceItem.getNutsId();
	}

	public void setNutsId(java.lang.String nutsId) {
		_aceItem.setNutsId(nutsId);
	}

	public java.lang.String getNutsLevel() {
		return _aceItem.getNutsLevel();
	}

	public void setNutsLevel(java.lang.String nutsLevel) {
		_aceItem.setNutsLevel(nutsLevel);
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