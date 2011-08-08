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
 * This class is a wrapper for {@link NASSource}.
 * </p>
 *
 * @author    groot052
 * @see       NASSource
 * @generated
 */
public class NASSourceWrapper implements NASSource {
	public NASSourceWrapper(NASSource nasSource) {
		_nasSource = nasSource;
	}

	public long getPrimaryKey() {
		return _nasSource.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_nasSource.setPrimaryKey(pk);
	}

	public long getNassourceid() {
		return _nasSource.getNassourceid();
	}

	public void setNassourceid(long nassourceid) {
		_nasSource.setNassourceid(nassourceid);
	}

	public long getNasId() {
		return _nasSource.getNasId();
	}

	public void setNasId(long nasId) {
		_nasSource.setNasId(nasId);
	}

	public java.lang.String getName() {
		return _nasSource.getName();
	}

	public void setName(java.lang.String name) {
		_nasSource.setName(name);
	}

	public long getCompanyId() {
		return _nasSource.getCompanyId();
	}

	public void setCompanyId(long companyId) {
		_nasSource.setCompanyId(companyId);
	}

	public long getGroupId() {
		return _nasSource.getGroupId();
	}

	public void setGroupId(long groupId) {
		_nasSource.setGroupId(groupId);
	}

	public nl.wur.alterra.cgi.ace.model.NASSource toEscapedModel() {
		return _nasSource.toEscapedModel();
	}

	public boolean isNew() {
		return _nasSource.isNew();
	}

	public void setNew(boolean n) {
		_nasSource.setNew(n);
	}

	public boolean isCachedModel() {
		return _nasSource.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_nasSource.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _nasSource.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_nasSource.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _nasSource.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _nasSource.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_nasSource.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _nasSource.clone();
	}

	public int compareTo(NASSource nasSource) {
		return _nasSource.compareTo(nasSource);
	}

	public int hashCode() {
		return _nasSource.hashCode();
	}

	public java.lang.String toString() {
		return _nasSource.toString();
	}

	public java.lang.String toXmlString() {
		return _nasSource.toXmlString();
	}

	public NASSource getWrappedNASSource() {
		return _nasSource;
	}

	private NASSource _nasSource;
}
