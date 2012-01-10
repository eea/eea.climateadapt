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
 * The base model interface for the AceItem service. Represents a row in the &quot;Ace_AceItem&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link nl.wur.alterra.cgi.ace.model.impl.AceItemModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link nl.wur.alterra.cgi.ace.model.impl.AceItemImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this interface directly. All methods that expect a ace item model instance should use the {@link AceItem} interface instead.
 * </p>
 *
 * @author groot052
 * @see AceItem
 * @see nl.wur.alterra.cgi.ace.model.impl.AceItemImpl
 * @see nl.wur.alterra.cgi.ace.model.impl.AceItemModelImpl
 * @generated
 */
public interface AceItemModel extends BaseModel<AceItem> {
	/**
	 * Gets the primary key of this ace item.
	 *
	 * @return the primary key of this ace item
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this ace item
	 *
	 * @param pk the primary key of this ace item
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the ace item id of this ace item.
	 *
	 * @return the ace item id of this ace item
	 */
	public long getAceItemId();

	/**
	 * Sets the ace item id of this ace item.
	 *
	 * @param aceItemId the ace item id of this ace item
	 */
	public void setAceItemId(long aceItemId);

	/**
	 * Gets the company id of this ace item.
	 *
	 * @return the company id of this ace item
	 */
	public long getCompanyId();

	/**
	 * Sets the company id of this ace item.
	 *
	 * @param companyId the company id of this ace item
	 */
	public void setCompanyId(long companyId);

	/**
	 * Gets the group id of this ace item.
	 *
	 * @return the group id of this ace item
	 */
	public long getGroupId();

	/**
	 * Sets the group id of this ace item.
	 *
	 * @param groupId the group id of this ace item
	 */
	public void setGroupId(long groupId);

	/**
	 * Gets the wxsharvester id of this ace item.
	 *
	 * @return the wxsharvester id of this ace item
	 */
	public long getWxsharvesterId();

	/**
	 * Sets the wxsharvester id of this ace item.
	 *
	 * @param wxsharvesterId the wxsharvester id of this ace item
	 */
	public void setWxsharvesterId(long wxsharvesterId);

	/**
	 * Gets the cswharvester id of this ace item.
	 *
	 * @return the cswharvester id of this ace item
	 */
	public long getCswharvesterId();

	/**
	 * Sets the cswharvester id of this ace item.
	 *
	 * @param cswharvesterId the cswharvester id of this ace item
	 */
	public void setCswharvesterId(long cswharvesterId);

	/**
	 * Gets the name of this ace item.
	 *
	 * @return the name of this ace item
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this ace item.
	 *
	 * @param name the name of this ace item
	 */
	public void setName(String name);

	/**
	 * Gets the description of this ace item.
	 *
	 * @return the description of this ace item
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this ace item.
	 *
	 * @param description the description of this ace item
	 */
	public void setDescription(String description);

	/**
	 * Gets the datatype of this ace item.
	 *
	 * @return the datatype of this ace item
	 */
	@AutoEscape
	public String getDatatype();

	/**
	 * Sets the datatype of this ace item.
	 *
	 * @param datatype the datatype of this ace item
	 */
	public void setDatatype(String datatype);

	/**
	 * Gets the stored at of this ace item.
	 *
	 * @return the stored at of this ace item
	 */
	@AutoEscape
	public String getStoredAt();

	/**
	 * Sets the stored at of this ace item.
	 *
	 * @param storedAt the stored at of this ace item
	 */
	public void setStoredAt(String storedAt);

	/**
	 * Gets the storagetype of this ace item.
	 *
	 * @return the storagetype of this ace item
	 */
	@AutoEscape
	public String getStoragetype();

	/**
	 * Sets the storagetype of this ace item.
	 *
	 * @param storagetype the storagetype of this ace item
	 */
	public void setStoragetype(String storagetype);

	/**
	 * Gets the specialtagging of this ace item.
	 *
	 * @return the specialtagging of this ace item
	 */
	@AutoEscape
	public String getSpecialtagging();

	/**
	 * Sets the specialtagging of this ace item.
	 *
	 * @param specialtagging the specialtagging of this ace item
	 */
	public void setSpecialtagging(String specialtagging);

	/**
	 * Gets the text search of this ace item.
	 *
	 * @return the text search of this ace item
	 */
	@AutoEscape
	public String getTextSearch();

	/**
	 * Sets the text search of this ace item.
	 *
	 * @param textSearch the text search of this ace item
	 */
	public void setTextSearch(String textSearch);

	/**
	 * Gets the keyword of this ace item.
	 *
	 * @return the keyword of this ace item
	 */
	@AutoEscape
	public String getKeyword();

	/**
	 * Sets the keyword of this ace item.
	 *
	 * @param keyword the keyword of this ace item
	 */
	public void setKeyword(String keyword);

	/**
	 * Gets the targetresolution of this ace item.
	 *
	 * @return the targetresolution of this ace item
	 */
	@AutoEscape
	public String getTargetresolution();

	/**
	 * Sets the targetresolution of this ace item.
	 *
	 * @param targetresolution the targetresolution of this ace item
	 */
	public void setTargetresolution(String targetresolution);

	/**
	 * Gets the spatial layer of this ace item.
	 *
	 * @return the spatial layer of this ace item
	 */
	@AutoEscape
	public String getSpatialLayer();

	/**
	 * Sets the spatial layer of this ace item.
	 *
	 * @param spatialLayer the spatial layer of this ace item
	 */
	public void setSpatialLayer(String spatialLayer);

	/**
	 * Gets the spatial values of this ace item.
	 *
	 * @return the spatial values of this ace item
	 */
	@AutoEscape
	public String getSpatialValues();

	/**
	 * Sets the spatial values of this ace item.
	 *
	 * @param spatialValues the spatial values of this ace item
	 */
	public void setSpatialValues(String spatialValues);

	/**
	 * Gets the start date of this ace item.
	 *
	 * @return the start date of this ace item
	 */
	public Date getStartDate();

	/**
	 * Sets the start date of this ace item.
	 *
	 * @param startDate the start date of this ace item
	 */
	public void setStartDate(Date startDate);

	/**
	 * Gets the end date of this ace item.
	 *
	 * @return the end date of this ace item
	 */
	public Date getEndDate();

	/**
	 * Sets the end date of this ace item.
	 *
	 * @param endDate the end date of this ace item
	 */
	public void setEndDate(Date endDate);

	/**
	 * Gets the publication date of this ace item.
	 *
	 * @return the publication date of this ace item
	 */
	public Date getPublicationDate();

	/**
	 * Sets the publication date of this ace item.
	 *
	 * @param publicationDate the publication date of this ace item
	 */
	public void setPublicationDate(Date publicationDate);

	/**
	 * Gets the sectors_ of this ace item.
	 *
	 * @return the sectors_ of this ace item
	 */
	@AutoEscape
	public String getSectors_();

	/**
	 * Sets the sectors_ of this ace item.
	 *
	 * @param sectors_ the sectors_ of this ace item
	 */
	public void setSectors_(String sectors_);

	/**
	 * Gets the elements_ of this ace item.
	 *
	 * @return the elements_ of this ace item
	 */
	@AutoEscape
	public String getElements_();

	/**
	 * Sets the elements_ of this ace item.
	 *
	 * @param elements_ the elements_ of this ace item
	 */
	public void setElements_(String elements_);

	/**
	 * Gets the climateimpacts_ of this ace item.
	 *
	 * @return the climateimpacts_ of this ace item
	 */
	@AutoEscape
	public String getClimateimpacts_();

	/**
	 * Sets the climateimpacts_ of this ace item.
	 *
	 * @param climateimpacts_ the climateimpacts_ of this ace item
	 */
	public void setClimateimpacts_(String climateimpacts_);

	/**
	 * Gets the rating of this ace item.
	 *
	 * @return the rating of this ace item
	 */
	public long getRating();

	/**
	 * Sets the rating of this ace item.
	 *
	 * @param rating the rating of this ace item
	 */
	public void setRating(long rating);

	/**
	 * Gets the importance of this ace item.
	 *
	 * @return the importance of this ace item
	 */
	public long getImportance();

	/**
	 * Sets the importance of this ace item.
	 *
	 * @param importance the importance of this ace item
	 */
	public void setImportance(long importance);

	/**
	 * Gets the source of this ace item.
	 *
	 * @return the source of this ace item
	 */
	@AutoEscape
	public String getSource();

	/**
	 * Sets the source of this ace item.
	 *
	 * @param source the source of this ace item
	 */
	public void setSource(String source);

	/**
	 * Gets the deeplink of this ace item.
	 *
	 * @return the deeplink of this ace item
	 */
	@AutoEscape
	public String getDeeplink();

	/**
	 * Sets the deeplink of this ace item.
	 *
	 * @param deeplink the deeplink of this ace item
	 */
	public void setDeeplink(String deeplink);

	/**
	 * Gets the controlstatus of this ace item.
	 *
	 * @return the controlstatus of this ace item
	 */
	public short getControlstatus();

	/**
	 * Sets the controlstatus of this ace item.
	 *
	 * @param controlstatus the controlstatus of this ace item
	 */
	public void setControlstatus(short controlstatus);

	/**
	 * Gets the creator of this ace item.
	 *
	 * @return the creator of this ace item
	 */
	@AutoEscape
	public String getCreator();

	/**
	 * Sets the creator of this ace item.
	 *
	 * @param creator the creator of this ace item
	 */
	public void setCreator(String creator);

	/**
	 * Gets the creationdate of this ace item.
	 *
	 * @return the creationdate of this ace item
	 */
	public Date getCreationdate();

	/**
	 * Sets the creationdate of this ace item.
	 *
	 * @param creationdate the creationdate of this ace item
	 */
	public void setCreationdate(Date creationdate);

	/**
	 * Gets the moderator of this ace item.
	 *
	 * @return the moderator of this ace item
	 */
	@AutoEscape
	public String getModerator();

	/**
	 * Sets the moderator of this ace item.
	 *
	 * @param moderator the moderator of this ace item
	 */
	public void setModerator(String moderator);

	/**
	 * Gets the approvaldate of this ace item.
	 *
	 * @return the approvaldate of this ace item
	 */
	public Date getApprovaldate();

	/**
	 * Sets the approvaldate of this ace item.
	 *
	 * @param approvaldate the approvaldate of this ace item
	 */
	public void setApprovaldate(Date approvaldate);

	/**
	 * Gets the replaces id of this ace item.
	 *
	 * @return the replaces id of this ace item
	 */
	public long getReplacesId();

	/**
	 * Sets the replaces id of this ace item.
	 *
	 * @param replacesId the replaces id of this ace item
	 */
	public void setReplacesId(long replacesId);

	/**
	 * Gets the comments of this ace item.
	 *
	 * @return the comments of this ace item
	 */
	@AutoEscape
	public String getComments();

	/**
	 * Sets the comments of this ace item.
	 *
	 * @param comments the comments of this ace item
	 */
	public void setComments(String comments);

	/**
	 * Gets the textwebpage of this ace item.
	 *
	 * @return the textwebpage of this ace item
	 */
	@AutoEscape
	public String getTextwebpage();

	/**
	 * Sets the textwebpage of this ace item.
	 *
	 * @param textwebpage the textwebpage of this ace item
	 */
	public void setTextwebpage(String textwebpage);

	/**
	 * Gets a copy of this ace item as an escaped model instance by wrapping it with an {@link com.liferay.portal.kernel.bean.AutoEscapeBeanHandler}.
	 *
	 * @return the escaped model instance
	 * @see com.liferay.portal.kernel.bean.AutoEscapeBeanHandler
	 */
	public AceItem toEscapedModel();

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

	public int compareTo(AceItem aceItem);

	public int hashCode();

	public String toString();

	public String toXmlString();
}