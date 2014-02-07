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

package nl.wur.alterra.cgi.ace.service;

import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The interface for the project local service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link ProjectLocalServiceUtil} to access the project local service. Add custom service methods to {@link nl.wur.alterra.cgi.ace.service.impl.ProjectLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Groot052
 * @see ProjectLocalServiceUtil
 * @see nl.wur.alterra.cgi.ace.service.base.ProjectLocalServiceBaseImpl
 * @see nl.wur.alterra.cgi.ace.service.impl.ProjectLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ProjectLocalService {
	/**
	* Adds the project to the database. Also notifies the appropriate model listeners.
	*
	* @param project the project to add
	* @return the project that was added
	* @throws SystemException if a system exception occurred
	*/
	public nl.wur.alterra.cgi.ace.model.Project addProject(
		nl.wur.alterra.cgi.ace.model.Project project)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new project with the primary key. Does not add the project to the database.
	*
	* @param projectId the primary key for the new project
	* @return the new project
	*/
	public nl.wur.alterra.cgi.ace.model.Project createProject(long projectId);

	/**
	* Deletes the project with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param projectId the primary key of the project to delete
	* @throws PortalException if a project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteProject(long projectId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the project from the database. Also notifies the appropriate model listeners.
	*
	* @param project the project to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteProject(nl.wur.alterra.cgi.ace.model.Project project)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the project with the primary key.
	*
	* @param projectId the primary key of the project to get
	* @return the project
	* @throws PortalException if a project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public nl.wur.alterra.cgi.ace.model.Project getProject(long projectId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<nl.wur.alterra.cgi.ace.model.Project> getProjects(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the number of projects.
	*
	* @return the number of projects
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getProjectsCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the project in the database. Also notifies the appropriate model listeners.
	*
	* @param project the project to update
	* @return the project that was updated
	* @throws SystemException if a system exception occurred
	*/
	public nl.wur.alterra.cgi.ace.model.Project updateProject(
		nl.wur.alterra.cgi.ace.model.Project project)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the project in the database. Also notifies the appropriate model listeners.
	*
	* @param project the project to update
	* @param merge whether to merge the project with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the project that was updated
	* @throws SystemException if a system exception occurred
	*/
	public nl.wur.alterra.cgi.ace.model.Project updateProject(
		nl.wur.alterra.cgi.ace.model.Project project, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets a list with all the Projects in a group
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<nl.wur.alterra.cgi.ace.model.Project> getProjectsByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets a list with a range of Projects from a group
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<nl.wur.alterra.cgi.ace.model.Project> getProjectsByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Hugo de Groot: add these methods by hand to <portlet>LocalServiceImpl
	* and rerun ServiceBuilder if auto generation fails
	*
	* Gets a list with a range of Projects from a group
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<nl.wur.alterra.cgi.ace.model.Project> getProjectsByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the number of Projects in a group
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getProjectsCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets a list with all the Projects by controlstatus
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<nl.wur.alterra.cgi.ace.model.Project> getProjectsByControlstatus(
		short controlstatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets a list with a range of Projects by controlstatus
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<nl.wur.alterra.cgi.ace.model.Project> getProjectsByGroupId(
		short controlstatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets a list with a range of Projects by controlstatus
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<nl.wur.alterra.cgi.ace.model.Project> getProjectsByControlstatus(
		short controlstatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the number of Projects by controlstatus
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getProjectsCountByGroupId(short controlstatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the number of Projects by controlstatus
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getProjectsCountByControlstatus(short controlstatus)
		throws com.liferay.portal.kernel.exception.SystemException;
}