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

package nl.wur.alterra.cgi.ace.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import nl.wur.alterra.cgi.ace.model.Project;

/**
 * The persistence interface for the project service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link ProjectUtil} to access the project persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Groot052
 * @see ProjectPersistenceImpl
 * @see ProjectUtil
 * @generated
 */
public interface ProjectPersistence extends BasePersistence<Project> {
	/**
	* Caches the project in the entity cache if it is enabled.
	*
	* @param project the project to cache
	*/
	public void cacheResult(nl.wur.alterra.cgi.ace.model.Project project);

	/**
	* Caches the projects in the entity cache if it is enabled.
	*
	* @param projects the projects to cache
	*/
	public void cacheResult(
		java.util.List<nl.wur.alterra.cgi.ace.model.Project> projects);

	/**
	* Creates a new project with the primary key. Does not add the project to the database.
	*
	* @param projectId the primary key for the new project
	* @return the new project
	*/
	public nl.wur.alterra.cgi.ace.model.Project create(long projectId);

	/**
	* Removes the project with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param projectId the primary key of the project to remove
	* @return the project that was removed
	* @throws nl.wur.alterra.cgi.ace.NoSuchProjectException if a project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public nl.wur.alterra.cgi.ace.model.Project remove(long projectId)
		throws com.liferay.portal.kernel.exception.SystemException,
			nl.wur.alterra.cgi.ace.NoSuchProjectException;

	public nl.wur.alterra.cgi.ace.model.Project updateImpl(
		nl.wur.alterra.cgi.ace.model.Project project, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the project with the primary key or throws a {@link nl.wur.alterra.cgi.ace.NoSuchProjectException} if it could not be found.
	*
	* @param projectId the primary key of the project to find
	* @return the project
	* @throws nl.wur.alterra.cgi.ace.NoSuchProjectException if a project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public nl.wur.alterra.cgi.ace.model.Project findByPrimaryKey(long projectId)
		throws com.liferay.portal.kernel.exception.SystemException,
			nl.wur.alterra.cgi.ace.NoSuchProjectException;

	/**
	* Finds the project with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param projectId the primary key of the project to find
	* @return the project, or <code>null</code> if a project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public nl.wur.alterra.cgi.ace.model.Project fetchByPrimaryKey(
		long projectId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the projects where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the matching projects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<nl.wur.alterra.cgi.ace.model.Project> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the projects where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of projects to return
	* @param end the upper bound of the range of projects to return (not inclusive)
	* @return the range of matching projects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<nl.wur.alterra.cgi.ace.model.Project> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the projects where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of projects to return
	* @param end the upper bound of the range of projects to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching projects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<nl.wur.alterra.cgi.ace.model.Project> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first project in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching project
	* @throws nl.wur.alterra.cgi.ace.NoSuchProjectException if a matching project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public nl.wur.alterra.cgi.ace.model.Project findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			nl.wur.alterra.cgi.ace.NoSuchProjectException;

	/**
	* Finds the last project in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching project
	* @throws nl.wur.alterra.cgi.ace.NoSuchProjectException if a matching project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public nl.wur.alterra.cgi.ace.model.Project findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			nl.wur.alterra.cgi.ace.NoSuchProjectException;

	/**
	* Finds the projects before and after the current project in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param projectId the primary key of the current project
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next project
	* @throws nl.wur.alterra.cgi.ace.NoSuchProjectException if a project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public nl.wur.alterra.cgi.ace.model.Project[] findByGroupId_PrevAndNext(
		long projectId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			nl.wur.alterra.cgi.ace.NoSuchProjectException;

	/**
	* Finds all the projects where controlstatus = &#63;.
	*
	* @param controlstatus the controlstatus to search with
	* @return the matching projects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<nl.wur.alterra.cgi.ace.model.Project> findByControlstatus(
		short controlstatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the projects where controlstatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param controlstatus the controlstatus to search with
	* @param start the lower bound of the range of projects to return
	* @param end the upper bound of the range of projects to return (not inclusive)
	* @return the range of matching projects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<nl.wur.alterra.cgi.ace.model.Project> findByControlstatus(
		short controlstatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the projects where controlstatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param controlstatus the controlstatus to search with
	* @param start the lower bound of the range of projects to return
	* @param end the upper bound of the range of projects to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching projects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<nl.wur.alterra.cgi.ace.model.Project> findByControlstatus(
		short controlstatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first project in the ordered set where controlstatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param controlstatus the controlstatus to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching project
	* @throws nl.wur.alterra.cgi.ace.NoSuchProjectException if a matching project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public nl.wur.alterra.cgi.ace.model.Project findByControlstatus_First(
		short controlstatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			nl.wur.alterra.cgi.ace.NoSuchProjectException;

	/**
	* Finds the last project in the ordered set where controlstatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param controlstatus the controlstatus to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching project
	* @throws nl.wur.alterra.cgi.ace.NoSuchProjectException if a matching project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public nl.wur.alterra.cgi.ace.model.Project findByControlstatus_Last(
		short controlstatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			nl.wur.alterra.cgi.ace.NoSuchProjectException;

	/**
	* Finds the projects before and after the current project in the ordered set where controlstatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param projectId the primary key of the current project
	* @param controlstatus the controlstatus to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next project
	* @throws nl.wur.alterra.cgi.ace.NoSuchProjectException if a project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public nl.wur.alterra.cgi.ace.model.Project[] findByControlstatus_PrevAndNext(
		long projectId, short controlstatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			nl.wur.alterra.cgi.ace.NoSuchProjectException;

	/**
	* Finds all the projects.
	*
	* @return the projects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<nl.wur.alterra.cgi.ace.model.Project> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the projects.
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
	public java.util.List<nl.wur.alterra.cgi.ace.model.Project> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the projects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of projects to return
	* @param end the upper bound of the range of projects to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of projects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<nl.wur.alterra.cgi.ace.model.Project> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the projects where groupId = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the projects where controlstatus = &#63; from the database.
	*
	* @param controlstatus the controlstatus to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByControlstatus(short controlstatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the projects from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the projects where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the number of matching projects
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the projects where controlstatus = &#63;.
	*
	* @param controlstatus the controlstatus to search with
	* @return the number of matching projects
	* @throws SystemException if a system exception occurred
	*/
	public int countByControlstatus(short controlstatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the projects.
	*
	* @return the number of projects
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}