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

import nl.wur.alterra.cgi.ace.model.Project;
import nl.wur.alterra.cgi.ace.service.ProjectLocalService;
import nl.wur.alterra.cgi.ace.service.persistence.ProjectPersistence;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the project local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link nl.wur.alterra.cgi.ace.service.impl.ProjectLocalServiceImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link nl.wur.alterra.cgi.ace.service.ProjectLocalServiceUtil} to access the project local service.
 * </p>
 *
 * @author Groot052
 * @see nl.wur.alterra.cgi.ace.service.impl.ProjectLocalServiceImpl
 * @see nl.wur.alterra.cgi.ace.service.ProjectLocalServiceUtil
 * @generated
 */
public abstract class ProjectLocalServiceBaseImpl implements ProjectLocalService {
	/**
	 * Adds the project to the database. Also notifies the appropriate model listeners.
	 *
	 * @param project the project to add
	 * @return the project that was added
	 * @throws SystemException if a system exception occurred
	 */
	public Project addProject(Project project) throws SystemException {
		project.setNew(true);

		return projectPersistence.update(project, false);
	}

	/**
	 * Creates a new project with the primary key. Does not add the project to the database.
	 *
	 * @param projectId the primary key for the new project
	 * @return the new project
	 */
	public Project createProject(long projectId) {
		return projectPersistence.create(projectId);
	}

	/**
	 * Deletes the project with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param projectId the primary key of the project to delete
	 * @throws PortalException if a project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public void deleteProject(long projectId)
		throws PortalException, SystemException {
		projectPersistence.remove(projectId);
	}

	/**
	 * Deletes the project from the database. Also notifies the appropriate model listeners.
	 *
	 * @param project the project to delete
	 * @throws SystemException if a system exception occurred
	 */
	public void deleteProject(Project project) throws SystemException {
		projectPersistence.remove(project);
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
		return projectPersistence.findWithDynamicQuery(dynamicQuery);
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
		return projectPersistence.findWithDynamicQuery(dynamicQuery, start, end);
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
		return projectPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return projectPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Gets the project with the primary key.
	 *
	 * @param projectId the primary key of the project to get
	 * @return the project
	 * @throws PortalException if a project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Project getProject(long projectId)
		throws PortalException, SystemException {
		return projectPersistence.findByPrimaryKey(projectId);
	}

	/**
	 * Gets a range of all the projects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of projects to return
	 * @param end the upper bound of the range of projects to return (not inclusive)
	 * @return the range of projects
	 * @throws SystemException if a system exception occurred
	 */
	public List<Project> getProjects(int start, int end)
		throws SystemException {
		return projectPersistence.findAll(start, end);
	}

	/**
	 * Gets the number of projects.
	 *
	 * @return the number of projects
	 * @throws SystemException if a system exception occurred
	 */
	public int getProjectsCount() throws SystemException {
		return projectPersistence.countAll();
	}

	/**
	 * Updates the project in the database. Also notifies the appropriate model listeners.
	 *
	 * @param project the project to update
	 * @return the project that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public Project updateProject(Project project) throws SystemException {
		project.setNew(false);

		return projectPersistence.update(project, true);
	}

	/**
	 * Updates the project in the database. Also notifies the appropriate model listeners.
	 *
	 * @param project the project to update
	 * @param merge whether to merge the project with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the project that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public Project updateProject(Project project, boolean merge)
		throws SystemException {
		project.setNew(false);

		return projectPersistence.update(project, merge);
	}

	/**
	 * Gets the project local service.
	 *
	 * @return the project local service
	 */
	public ProjectLocalService getProjectLocalService() {
		return projectLocalService;
	}

	/**
	 * Sets the project local service.
	 *
	 * @param projectLocalService the project local service
	 */
	public void setProjectLocalService(ProjectLocalService projectLocalService) {
		this.projectLocalService = projectLocalService;
	}

	/**
	 * Gets the project persistence.
	 *
	 * @return the project persistence
	 */
	public ProjectPersistence getProjectPersistence() {
		return projectPersistence;
	}

	/**
	 * Sets the project persistence.
	 *
	 * @param projectPersistence the project persistence
	 */
	public void setProjectPersistence(ProjectPersistence projectPersistence) {
		this.projectPersistence = projectPersistence;
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
	 * Performs an SQL query.
	 *
	 * @param sql the sql query to perform
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = projectPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = ProjectLocalService.class)
	protected ProjectLocalService projectLocalService;
	@BeanReference(type = ProjectPersistence.class)
	protected ProjectPersistence projectPersistence;
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
}