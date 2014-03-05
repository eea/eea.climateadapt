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

/**
 * <p>
 * This class is a wrapper for {@link ProjectLocalService}.
 * </p>
 *
 * @author    Groot052
 * @see       ProjectLocalService
 * @generated
 */
public class ProjectLocalServiceWrapper implements ProjectLocalService {
	public ProjectLocalServiceWrapper(ProjectLocalService projectLocalService) {
		_projectLocalService = projectLocalService;
	}

	/**
	* Adds the project to the database. Also notifies the appropriate model listeners.
	*
	* @param project the project to add
	* @return the project that was added
	* @throws SystemException if a system exception occurred
	*/
	public nl.wur.alterra.cgi.ace.model.Project addProject(
		nl.wur.alterra.cgi.ace.model.Project project)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectLocalService.addProject(project);
	}

	/**
	* Creates a new project with the primary key. Does not add the project to the database.
	*
	* @param projectId the primary key for the new project
	* @return the new project
	*/
	public nl.wur.alterra.cgi.ace.model.Project createProject(long projectId) {
		return _projectLocalService.createProject(projectId);
	}

	/**
	* Deletes the project with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param projectId the primary key of the project to delete
	* @throws PortalException if a project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteProject(long projectId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_projectLocalService.deleteProject(projectId);
	}

	/**
	* Deletes the project from the database. Also notifies the appropriate model listeners.
	*
	* @param project the project to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteProject(nl.wur.alterra.cgi.ace.model.Project project)
		throws com.liferay.portal.kernel.exception.SystemException {
		_projectLocalService.deleteProject(project);
	}

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
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectLocalService.dynamicQuery(dynamicQuery);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _projectLocalService.dynamicQuery(dynamicQuery, start, end);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the project with the primary key.
	*
	* @param projectId the primary key of the project to get
	* @return the project
	* @throws PortalException if a project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public nl.wur.alterra.cgi.ace.model.Project getProject(long projectId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _projectLocalService.getProject(projectId);
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
	public java.util.List<nl.wur.alterra.cgi.ace.model.Project> getProjects(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectLocalService.getProjects(start, end);
	}

	/**
	* Gets the number of projects.
	*
	* @return the number of projects
	* @throws SystemException if a system exception occurred
	*/
	public int getProjectsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectLocalService.getProjectsCount();
	}

	/**
	* Updates the project in the database. Also notifies the appropriate model listeners.
	*
	* @param project the project to update
	* @return the project that was updated
	* @throws SystemException if a system exception occurred
	*/
	public nl.wur.alterra.cgi.ace.model.Project updateProject(
		nl.wur.alterra.cgi.ace.model.Project project)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectLocalService.updateProject(project);
	}

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
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectLocalService.updateProject(project, merge);
	}

	/**
	* Gets a list with all the Projects in a group
	*/
	public java.util.List<nl.wur.alterra.cgi.ace.model.Project> getProjectsByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectLocalService.getProjectsByGroupId(groupId);
	}

	/**
	* Gets a list with a range of Projects from a group
	*/
	public java.util.List<nl.wur.alterra.cgi.ace.model.Project> getProjectsByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectLocalService.getProjectsByGroupId(groupId, start, end);
	}

	/**
	* Hugo de Groot: add these methods by hand to <portlet>LocalServiceImpl
	* and rerun ServiceBuilder if auto generation fails
	*
	* Gets a list with a range of Projects from a group
	*/
	public java.util.List<nl.wur.alterra.cgi.ace.model.Project> getProjectsByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectLocalService.getProjectsByGroupId(groupId, start, end,
			orderByComparator);
	}

	/**
	* Gets the number of Projects in a group
	*/
	public int getProjectsCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectLocalService.getProjectsCountByGroupId(groupId);
	}

	/**
	* Gets a list with all the Projects by controlstatus
	*/
	public java.util.List<nl.wur.alterra.cgi.ace.model.Project> getProjectsByControlstatus(
		short controlstatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectLocalService.getProjectsByControlstatus(controlstatus);
	}

	/**
	* Gets a list with a range of Projects by controlstatus
	*/
	public java.util.List<nl.wur.alterra.cgi.ace.model.Project> getProjectsByGroupId(
		short controlstatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectLocalService.getProjectsByGroupId(controlstatus, start,
			end);
	}

	/**
	* Gets a list with a range of Projects by controlstatus
	*/
	public java.util.List<nl.wur.alterra.cgi.ace.model.Project> getProjectsByControlstatus(
		short controlstatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectLocalService.getProjectsByControlstatus(controlstatus,
			start, end);
	}

	/**
	* Gets the number of Projects by controlstatus
	*/
	public int getProjectsCountByGroupId(short controlstatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectLocalService.getProjectsCountByGroupId(controlstatus);
	}

	/**
	* Gets the number of Projects by controlstatus
	*/
	public int getProjectsCountByControlstatus(short controlstatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectLocalService.getProjectsCountByControlstatus(controlstatus);
	}

	public ProjectLocalService getWrappedProjectLocalService() {
		return _projectLocalService;
	}

	private ProjectLocalService _projectLocalService;
}