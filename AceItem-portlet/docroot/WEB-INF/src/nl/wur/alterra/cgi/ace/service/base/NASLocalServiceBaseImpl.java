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

package nl.wur.alterra.cgi.ace.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import com.liferay.portlet.asset.service.AssetEntryLocalService;
import com.liferay.portlet.asset.service.AssetEntryService;
import com.liferay.portlet.asset.service.persistence.AssetEntryPersistence;

import nl.wur.alterra.cgi.ace.model.NAS;
import nl.wur.alterra.cgi.ace.service.AceItemLocalService;
import nl.wur.alterra.cgi.ace.service.NASLocalService;
import nl.wur.alterra.cgi.ace.service.persistence.AceItemPersistence;
import nl.wur.alterra.cgi.ace.service.persistence.NASPersistence;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the n a s local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link nl.wur.alterra.cgi.ace.service.impl.NASLocalServiceImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link nl.wur.alterra.cgi.ace.service.NASLocalServiceUtil} to access the n a s local service.
 * </p>
 *
 * @author groot052
 * @see nl.wur.alterra.cgi.ace.service.impl.NASLocalServiceImpl
 * @see nl.wur.alterra.cgi.ace.service.NASLocalServiceUtil
 * @generated
 */
public abstract class NASLocalServiceBaseImpl implements NASLocalService {
	/**
	 * Adds the n a s to the database. Also notifies the appropriate model listeners.
	 *
	 * @param nas the n a s to add
	 * @return the n a s that was added
	 * @throws SystemException if a system exception occurred
	 */
	public NAS addNAS(NAS nas) throws SystemException {
		nas.setNew(true);

		return nasPersistence.update(nas, false);
	}

	/**
	 * Creates a new n a s with the primary key. Does not add the n a s to the database.
	 *
	 * @param nasId the primary key for the new n a s
	 * @return the new n a s
	 */
	public NAS createNAS(long nasId) {
		return nasPersistence.create(nasId);
	}

	/**
	 * Deletes the n a s with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param nasId the primary key of the n a s to delete
	 * @throws PortalException if a n a s with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public void deleteNAS(long nasId) throws PortalException, SystemException {
		nasPersistence.remove(nasId);
	}

	/**
	 * Deletes the n a s from the database. Also notifies the appropriate model listeners.
	 *
	 * @param nas the n a s to delete
	 * @throws SystemException if a system exception occurred
	 */
	public void deleteNAS(NAS nas) throws SystemException {
		nasPersistence.remove(nas);
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query to search with
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return nasPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query to search with
	 * @param start the lower bound of the range of model instances to return
	 * @param end the upper bound of the range of model instances to return (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return nasPersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query to search with
	 * @param start the lower bound of the range of model instances to return
	 * @param end the upper bound of the range of model instances to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return nasPersistence.findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * Counts the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query to search with
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return nasPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Gets the n a s with the primary key.
	 *
	 * @param nasId the primary key of the n a s to get
	 * @return the n a s
	 * @throws PortalException if a n a s with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NAS getNAS(long nasId) throws PortalException, SystemException {
		return nasPersistence.findByPrimaryKey(nasId);
	}

	/**
	 * Gets a range of all the n a ses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of n a ses to return
	 * @param end the upper bound of the range of n a ses to return (not inclusive)
	 * @return the range of n a ses
	 * @throws SystemException if a system exception occurred
	 */
	public List<NAS> getNASs(int start, int end) throws SystemException {
		return nasPersistence.findAll(start, end);
	}

	/**
	 * Gets the number of n a ses.
	 *
	 * @return the number of n a ses
	 * @throws SystemException if a system exception occurred
	 */
	public int getNASsCount() throws SystemException {
		return nasPersistence.countAll();
	}

	/**
	 * Updates the n a s in the database. Also notifies the appropriate model listeners.
	 *
	 * @param nas the n a s to update
	 * @return the n a s that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public NAS updateNAS(NAS nas) throws SystemException {
		nas.setNew(false);

		return nasPersistence.update(nas, true);
	}

	/**
	 * Updates the n a s in the database. Also notifies the appropriate model listeners.
	 *
	 * @param nas the n a s to update
	 * @param merge whether to merge the n a s with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the n a s that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public NAS updateNAS(NAS nas, boolean merge) throws SystemException {
		nas.setNew(false);

		return nasPersistence.update(nas, merge);
	}

	/**
	 * Gets the ace item local service.
	 *
	 * @return the ace item local service
	 */
	public AceItemLocalService getAceItemLocalService() {
		return aceItemLocalService;
	}

	/**
	 * Sets the ace item local service.
	 *
	 * @param aceItemLocalService the ace item local service
	 */
	public void setAceItemLocalService(AceItemLocalService aceItemLocalService) {
		this.aceItemLocalService = aceItemLocalService;
	}

	/**
	 * Gets the ace item persistence.
	 *
	 * @return the ace item persistence
	 */
	public AceItemPersistence getAceItemPersistence() {
		return aceItemPersistence;
	}

	/**
	 * Sets the ace item persistence.
	 *
	 * @param aceItemPersistence the ace item persistence
	 */
	public void setAceItemPersistence(AceItemPersistence aceItemPersistence) {
		this.aceItemPersistence = aceItemPersistence;
	}

	/**
	 * Gets the n a s local service.
	 *
	 * @return the n a s local service
	 */
	public NASLocalService getNASLocalService() {
		return nasLocalService;
	}

	/**
	 * Sets the n a s local service.
	 *
	 * @param nasLocalService the n a s local service
	 */
	public void setNASLocalService(NASLocalService nasLocalService) {
		this.nasLocalService = nasLocalService;
	}

	/**
	 * Gets the n a s persistence.
	 *
	 * @return the n a s persistence
	 */
	public NASPersistence getNASPersistence() {
		return nasPersistence;
	}

	/**
	 * Sets the n a s persistence.
	 *
	 * @param nasPersistence the n a s persistence
	 */
	public void setNASPersistence(NASPersistence nasPersistence) {
		this.nasPersistence = nasPersistence;
	}

	/**
	 * Gets the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Gets the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Gets the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Gets the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Gets the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Gets the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Gets the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	/**
	 * Gets the asset entry local service.
	 *
	 * @return the asset entry local service
	 */
	public AssetEntryLocalService getAssetEntryLocalService() {
		return assetEntryLocalService;
	}

	/**
	 * Sets the asset entry local service.
	 *
	 * @param assetEntryLocalService the asset entry local service
	 */
	public void setAssetEntryLocalService(
		AssetEntryLocalService assetEntryLocalService) {
		this.assetEntryLocalService = assetEntryLocalService;
	}

	/**
	 * Gets the asset entry remote service.
	 *
	 * @return the asset entry remote service
	 */
	public AssetEntryService getAssetEntryService() {
		return assetEntryService;
	}

	/**
	 * Sets the asset entry remote service.
	 *
	 * @param assetEntryService the asset entry remote service
	 */
	public void setAssetEntryService(AssetEntryService assetEntryService) {
		this.assetEntryService = assetEntryService;
	}

	/**
	 * Gets the asset entry persistence.
	 *
	 * @return the asset entry persistence
	 */
	public AssetEntryPersistence getAssetEntryPersistence() {
		return assetEntryPersistence;
	}

	/**
	 * Sets the asset entry persistence.
	 *
	 * @param assetEntryPersistence the asset entry persistence
	 */
	public void setAssetEntryPersistence(
		AssetEntryPersistence assetEntryPersistence) {
		this.assetEntryPersistence = assetEntryPersistence;
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query to perform
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = nasPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = AceItemLocalService.class)
	protected AceItemLocalService aceItemLocalService;
	@BeanReference(type = AceItemPersistence.class)
	protected AceItemPersistence aceItemPersistence;
	@BeanReference(type = NASLocalService.class)
	protected NASLocalService nasLocalService;
	@BeanReference(type = NASPersistence.class)
	protected NASPersistence nasPersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@BeanReference(type = AssetEntryLocalService.class)
	protected AssetEntryLocalService assetEntryLocalService;
	@BeanReference(type = AssetEntryService.class)
	protected AssetEntryService assetEntryService;
	@BeanReference(type = AssetEntryPersistence.class)
	protected AssetEntryPersistence assetEntryPersistence;
}