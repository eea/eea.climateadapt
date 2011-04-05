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

/**
 * The base model interface for the NAS service. Represents a row in the &quot;Ace_NAS&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link nl.wur.alterra.cgi.ace.model.impl.NASModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link nl.wur.alterra.cgi.ace.model.impl.NASImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this interface directly. All methods that expect a n a s model instance should use the {@link NAS} interface instead.
 * </p>
 *
 * @author groot052
 * @see NAS
 * @see nl.wur.alterra.cgi.ace.model.impl.NASImpl
 * @see nl.wur.alterra.cgi.ace.model.impl.NASModelImpl
 * @generated
 */
public interface NASModel extends BaseModel<NAS> {
	/**
	 * Gets the primary key of this n a s.
	 *
	 * @return the primary key of this n a s
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this n a s
	 *
	 * @param pk the primary key of this n a s
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the nas id of this n a s.
	 *
	 * @return the nas id of this n a s
	 */
	public long getNasId();

	/**
	 * Sets the nas id of this n a s.
	 *
	 * @param nasId the nas id of this n a s
	 */
	public void setNasId(long nasId);

	/**
	 * Gets the name of this n a s.
	 *
	 * @return the name of this n a s
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this n a s.
	 *
	 * @param name the name of this n a s
	 */
	public void setName(String name);

	/**
	 * Gets the adopted status of this n a s.
	 *
	 * @return the adopted status of this n a s
	 */
	@AutoEscape
	public String getAdoptedStatus();

	/**
	 * Sets the adopted status of this n a s.
	 *
	 * @param adoptedStatus the adopted status of this n a s
	 */
	public void setAdoptedStatus(String adoptedStatus);

	/**
	 * Gets the adopted description of this n a s.
	 *
	 * @return the adopted description of this n a s
	 */
	@AutoEscape
	public String getAdoptedDescription();

	/**
	 * Sets the adopted description of this n a s.
	 *
	 * @param adoptedDescription the adopted description of this n a s
	 */
	public void setAdoptedDescription(String adoptedDescription);

	/**
	 * Gets the company id of this n a s.
	 *
	 * @return the company id of this n a s
	 */
	public long getCompanyId();

	/**
	 * Sets the company id of this n a s.
	 *
	 * @param companyId the company id of this n a s
	 */
	public void setCompanyId(long companyId);

	/**
	 * Gets the group id of this n a s.
	 *
	 * @return the group id of this n a s
	 */
	public long getGroupId();

	/**
	 * Sets the group id of this n a s.
	 *
	 * @param groupId the group id of this n a s
	 */
	public void setGroupId(long groupId);

	/**
	 * Gets a copy of this n a s as an escaped model instance by wrapping it with an {@link com.liferay.portal.kernel.bean.AutoEscapeBeanHandler}.
	 *
	 * @return the escaped model instance
	 * @see com.liferay.portal.kernel.bean.AutoEscapeBeanHandler
	 */
	public NAS toEscapedModel();

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

	public int compareTo(NAS nas);

	public int hashCode();

	public String toString();

	public String toXmlString();
}