package nl.wur.alterra.cgi.ace.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import nl.wur.alterra.cgi.ace.model.Project;

/**
 * The persistence interface for the project service.
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
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ProjectUtil} to access the project persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the projects where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching projects
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<nl.wur.alterra.cgi.ace.model.Project> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the projects where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.wur.alterra.cgi.ace.model.impl.ProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of projects
    * @param end the upper bound of the range of projects (not inclusive)
    * @return the range of matching projects
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<nl.wur.alterra.cgi.ace.model.Project> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the projects where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.wur.alterra.cgi.ace.model.impl.ProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of projects
    * @param end the upper bound of the range of projects (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching projects
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<nl.wur.alterra.cgi.ace.model.Project> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first project in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
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
    * Returns the first project in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching project, or <code>null</code> if a matching project could not be found
    * @throws SystemException if a system exception occurred
    */
    public nl.wur.alterra.cgi.ace.model.Project fetchByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last project in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
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
    * Returns the last project in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching project, or <code>null</code> if a matching project could not be found
    * @throws SystemException if a system exception occurred
    */
    public nl.wur.alterra.cgi.ace.model.Project fetchByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the projects before and after the current project in the ordered set where groupId = &#63;.
    *
    * @param projectId the primary key of the current project
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
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
    * Removes all the projects where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of projects where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching projects
    * @throws SystemException if a system exception occurred
    */
    public int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the projects where controlstatus = &#63;.
    *
    * @param controlstatus the controlstatus
    * @return the matching projects
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<nl.wur.alterra.cgi.ace.model.Project> findByControlstatus(
        short controlstatus)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the projects where controlstatus = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.wur.alterra.cgi.ace.model.impl.ProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param controlstatus the controlstatus
    * @param start the lower bound of the range of projects
    * @param end the upper bound of the range of projects (not inclusive)
    * @return the range of matching projects
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<nl.wur.alterra.cgi.ace.model.Project> findByControlstatus(
        short controlstatus, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the projects where controlstatus = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.wur.alterra.cgi.ace.model.impl.ProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param controlstatus the controlstatus
    * @param start the lower bound of the range of projects
    * @param end the upper bound of the range of projects (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching projects
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<nl.wur.alterra.cgi.ace.model.Project> findByControlstatus(
        short controlstatus, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first project in the ordered set where controlstatus = &#63;.
    *
    * @param controlstatus the controlstatus
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
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
    * Returns the first project in the ordered set where controlstatus = &#63;.
    *
    * @param controlstatus the controlstatus
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching project, or <code>null</code> if a matching project could not be found
    * @throws SystemException if a system exception occurred
    */
    public nl.wur.alterra.cgi.ace.model.Project fetchByControlstatus_First(
        short controlstatus,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last project in the ordered set where controlstatus = &#63;.
    *
    * @param controlstatus the controlstatus
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
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
    * Returns the last project in the ordered set where controlstatus = &#63;.
    *
    * @param controlstatus the controlstatus
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching project, or <code>null</code> if a matching project could not be found
    * @throws SystemException if a system exception occurred
    */
    public nl.wur.alterra.cgi.ace.model.Project fetchByControlstatus_Last(
        short controlstatus,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the projects before and after the current project in the ordered set where controlstatus = &#63;.
    *
    * @param projectId the primary key of the current project
    * @param controlstatus the controlstatus
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
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
    * Removes all the projects where controlstatus = &#63; from the database.
    *
    * @param controlstatus the controlstatus
    * @throws SystemException if a system exception occurred
    */
    public void removeByControlstatus(short controlstatus)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of projects where controlstatus = &#63;.
    *
    * @param controlstatus the controlstatus
    * @return the number of matching projects
    * @throws SystemException if a system exception occurred
    */
    public int countByControlstatus(short controlstatus)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the project in the entity cache if it is enabled.
    *
    * @param project the project
    */
    public void cacheResult(nl.wur.alterra.cgi.ace.model.Project project);

    /**
    * Caches the projects in the entity cache if it is enabled.
    *
    * @param projects the projects
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
    * @param projectId the primary key of the project
    * @return the project that was removed
    * @throws nl.wur.alterra.cgi.ace.NoSuchProjectException if a project with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public nl.wur.alterra.cgi.ace.model.Project remove(long projectId)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.wur.alterra.cgi.ace.NoSuchProjectException;

    public nl.wur.alterra.cgi.ace.model.Project updateImpl(
        nl.wur.alterra.cgi.ace.model.Project project)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the project with the primary key or throws a {@link nl.wur.alterra.cgi.ace.NoSuchProjectException} if it could not be found.
    *
    * @param projectId the primary key of the project
    * @return the project
    * @throws nl.wur.alterra.cgi.ace.NoSuchProjectException if a project with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public nl.wur.alterra.cgi.ace.model.Project findByPrimaryKey(long projectId)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.wur.alterra.cgi.ace.NoSuchProjectException;

    /**
    * Returns the project with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param projectId the primary key of the project
    * @return the project, or <code>null</code> if a project with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public nl.wur.alterra.cgi.ace.model.Project fetchByPrimaryKey(
        long projectId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the projects.
    *
    * @return the projects
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<nl.wur.alterra.cgi.ace.model.Project> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the projects.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.wur.alterra.cgi.ace.model.impl.ProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of projects
    * @param end the upper bound of the range of projects (not inclusive)
    * @return the range of projects
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<nl.wur.alterra.cgi.ace.model.Project> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the projects.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.wur.alterra.cgi.ace.model.impl.ProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of projects
    * @param end the upper bound of the range of projects (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of projects
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<nl.wur.alterra.cgi.ace.model.Project> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the projects from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of projects.
    *
    * @return the number of projects
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
