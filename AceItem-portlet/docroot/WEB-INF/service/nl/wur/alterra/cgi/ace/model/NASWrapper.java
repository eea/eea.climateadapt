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
 * This class is a wrapper for {@link NAS}.
 * </p>
 *
 * @author    groot052
 * @see       NAS
 * @generated
 */
public class NASWrapper implements NAS {
	public NASWrapper(NAS nas) {
		_nas = nas;
	}

	public long getPrimaryKey() {
		return _nas.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_nas.setPrimaryKey(pk);
	}

	public long getNasId() {
		return _nas.getNasId();
	}

	public void setNasId(long nasId) {
		_nas.setNasId(nasId);
	}

	public java.lang.String getName() {
		return _nas.getName();
	}

	public void setName(java.lang.String name) {
		_nas.setName(name);
	}

	public java.lang.String getAdoptedStatus() {
		return _nas.getAdoptedStatus();
	}

	public void setAdoptedStatus(java.lang.String adoptedStatus) {
		_nas.setAdoptedStatus(adoptedStatus);
	}

	public java.lang.String getAdoptedDescription() {
		return _nas.getAdoptedDescription();
	}

	public void setAdoptedDescription(java.lang.String adoptedDescription) {
		_nas.setAdoptedDescription(adoptedDescription);
	}

	public long getCompanyId() {
		return _nas.getCompanyId();
	}

	public void setCompanyId(long companyId) {
		_nas.setCompanyId(companyId);
	}

	public long getGroupId() {
		return _nas.getGroupId();
	}

	public void setGroupId(long groupId) {
		_nas.setGroupId(groupId);
	}

	public nl.wur.alterra.cgi.ace.model.NAS toEscapedModel() {
		return _nas.toEscapedModel();
	}

	public boolean isNew() {
		return _nas.isNew();
	}

	public void setNew(boolean n) {
		_nas.setNew(n);
	}

	public boolean isCachedModel() {
		return _nas.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_nas.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _nas.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_nas.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _nas.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _nas.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_nas.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _nas.clone();
	}

	public int compareTo(nl.wur.alterra.cgi.ace.model.NAS nas) {
		return _nas.compareTo(nas);
	}

	public int hashCode() {
		return _nas.hashCode();
	}

	public java.lang.String toString() {
		return _nas.toString();
	}

	public java.lang.String toXmlString() {
		return _nas.toXmlString();
	}

	public NAS getWrappedNAS() {
		return _nas;
	}

	private NAS _nas;
}