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

package nl.wur.alterra.cgi.ace.service.impl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.List;

import nl.wur.alterra.cgi.ace.model.Project;
import nl.wur.alterra.cgi.ace.service.base.ProjectLocalServiceBaseImpl;

/**
 * The implementation of the project local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link nl.wur.alterra.cgi.ace.service.ProjectLocalService} interface.
 * </p>
 *
 * <p>
 * Never reference this interface directly. Always use {@link nl.wur.alterra.cgi.ace.service.ProjectLocalServiceUtil} to access the project local service.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Groot052
 * @see nl.wur.alterra.cgi.ace.service.base.ProjectLocalServiceBaseImpl
 * @see nl.wur.alterra.cgi.ace.service.ProjectLocalServiceUtil
 */
public class ProjectLocalServiceImpl extends ProjectLocalServiceBaseImpl {


    /**
     * Adds the Project to the database incrementing the primary key
     *
     */
    public Project addProject(Project project) throws SystemException {
        long projectId = CounterLocalServiceUtil.increment(Project.class.getName());

        project.setProjectId(projectId);

        return super.addProject(project);
    }

    /**
     * Gets a list with all the Projects in a group
     *
     */
    public List<Project> getProjectsByGroupId(long groupId) throws SystemException {
        return projectPersistence.findByGroupId(groupId);
    }

    /**
     * Gets a list with a range of Projects from a group
     *
     */
    public List<Project> getProjectsByGroupId(long groupId, int start, int end) throws SystemException {
        return projectPersistence.findByGroupId(groupId, start, end);
    }
    /**
     *
     * Hugo de Groot: add these methods by hand to <portlet>LocalServiceImpl
     * and rerun ServiceBuilder if auto generation fails
     *
     * Gets a list with a range of Projects from a group
     *
     */
    public List<Project> getProjectsByGroupId(long groupId, int start, int end, OrderByComparator orderByComparator) throws SystemException {
        return projectPersistence.findByGroupId(groupId, start, end, orderByComparator);
    }
    /**
     * Gets the number of Projects in a group
     *
     */
    public int getProjectsCountByGroupId(long groupId) throws SystemException {
        return projectPersistence.countByGroupId(groupId);
    }


    /**
     * Gets a list with all the Projects by controlstatus
     *
     */
    public List<Project> getProjectsByControlstatus(short controlstatus) throws SystemException {
        return projectPersistence.findByControlstatus(controlstatus);
    }

    /**
     * Gets a list with a range of Projects by controlstatus
     *
     */
    public List<Project> getProjectsByGroupId(short controlstatus, int start, int end) throws SystemException {
        return projectPersistence.findByControlstatus(controlstatus, start, end);
    }


    /**
     * Gets a list with a range of Projects by controlstatus
     *
     */
    public List<Project> getProjectsByControlstatus(short controlstatus, int start, int end) throws SystemException {
        return projectPersistence.findByControlstatus(controlstatus, start, end);
    }

    /**
     * Gets the number of Projects by controlstatus
     *
     */

    public int getProjectsCountByGroupId(short controlstatus) throws SystemException {
        return projectPersistence.countByControlstatus(controlstatus);
    }

    /**
     * Gets the number of Projects by controlstatus
     *
     */
    public int getProjectsCountByControlstatus(short controlstatus) throws SystemException {
        return projectPersistence.countByControlstatus(controlstatus);
    }
}
