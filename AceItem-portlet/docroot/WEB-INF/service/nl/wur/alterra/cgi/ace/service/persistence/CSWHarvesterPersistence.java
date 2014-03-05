package nl.wur.alterra.cgi.ace.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import nl.wur.alterra.cgi.ace.model.CSWHarvester;

/**
 * The persistence interface for the c s w harvester service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link CSWHarvesterUtil} to access the c s w harvester persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author groot052
 * @see CSWHarvesterPersistenceImpl
 * @see CSWHarvesterUtil
 * @generated
 */
public interface CSWHarvesterPersistence extends BasePersistence<CSWHarvester> {
    /**
    * Caches the c s w harvester in the entity cache if it is enabled.
    *
    * @param cswHarvester the c s w harvester to cache
    */
    public void cacheResult(
        nl.wur.alterra.cgi.ace.model.CSWHarvester cswHarvester);

    /**
    * Caches the c s w harvesters in the entity cache if it is enabled.
    *
    * @param cswHarvesters the c s w harvesters to cache
    */
    public void cacheResult(
        java.util.List<nl.wur.alterra.cgi.ace.model.CSWHarvester> cswHarvesters);

    /**
    * Creates a new c s w harvester with the primary key. Does not add the c s w harvester to the database.
    *
    * @param cswharvesterid the primary key for the new c s w harvester
    * @return the new c s w harvester
    */
    public nl.wur.alterra.cgi.ace.model.CSWHarvester create(long cswharvesterid);

    /**
    * Removes the c s w harvester with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param cswharvesterid the primary key of the c s w harvester to remove
    * @return the c s w harvester that was removed
    * @throws nl.wur.alterra.cgi.ace.NoSuchCSWHarvesterException if a c s w harvester with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public nl.wur.alterra.cgi.ace.model.CSWHarvester remove(long cswharvesterid)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.wur.alterra.cgi.ace.NoSuchCSWHarvesterException;

    public nl.wur.alterra.cgi.ace.model.CSWHarvester updateImpl(
        nl.wur.alterra.cgi.ace.model.CSWHarvester cswHarvester, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Finds the c s w harvester with the primary key or throws a {@link nl.wur.alterra.cgi.ace.NoSuchCSWHarvesterException} if it could not be found.
    *
    * @param cswharvesterid the primary key of the c s w harvester to find
    * @return the c s w harvester
    * @throws nl.wur.alterra.cgi.ace.NoSuchCSWHarvesterException if a c s w harvester with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public nl.wur.alterra.cgi.ace.model.CSWHarvester findByPrimaryKey(
        long cswharvesterid)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.wur.alterra.cgi.ace.NoSuchCSWHarvesterException;

    /**
    * Finds the c s w harvester with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param cswharvesterid the primary key of the c s w harvester to find
    * @return the c s w harvester, or <code>null</code> if a c s w harvester with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public nl.wur.alterra.cgi.ace.model.CSWHarvester fetchByPrimaryKey(
        long cswharvesterid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Finds all the c s w harvesters where groupId = &#63;.
    *
    * @param groupId the group id to search with
    * @return the matching c s w harvesters
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<nl.wur.alterra.cgi.ace.model.CSWHarvester> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Finds a range of all the c s w harvesters where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param groupId the group id to search with
    * @param start the lower bound of the range of c s w harvesters to return
    * @param end the upper bound of the range of c s w harvesters to return (not inclusive)
    * @return the range of matching c s w harvesters
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<nl.wur.alterra.cgi.ace.model.CSWHarvester> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Finds an ordered range of all the c s w harvesters where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param groupId the group id to search with
    * @param start the lower bound of the range of c s w harvesters to return
    * @param end the upper bound of the range of c s w harvesters to return (not inclusive)
    * @param orderByComparator the comparator to order the results by
    * @return the ordered range of matching c s w harvesters
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<nl.wur.alterra.cgi.ace.model.CSWHarvester> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Finds the first c s w harvester in the ordered set where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param groupId the group id to search with
    * @param orderByComparator the comparator to order the set by
    * @return the first matching c s w harvester
    * @throws nl.wur.alterra.cgi.ace.NoSuchCSWHarvesterException if a matching c s w harvester could not be found
    * @throws SystemException if a system exception occurred
    */
    public nl.wur.alterra.cgi.ace.model.CSWHarvester findByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.wur.alterra.cgi.ace.NoSuchCSWHarvesterException;

    /**
    * Finds the last c s w harvester in the ordered set where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param groupId the group id to search with
    * @param orderByComparator the comparator to order the set by
    * @return the last matching c s w harvester
    * @throws nl.wur.alterra.cgi.ace.NoSuchCSWHarvesterException if a matching c s w harvester could not be found
    * @throws SystemException if a system exception occurred
    */
    public nl.wur.alterra.cgi.ace.model.CSWHarvester findByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.wur.alterra.cgi.ace.NoSuchCSWHarvesterException;

    /**
    * Finds the c s w harvesters before and after the current c s w harvester in the ordered set where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param cswharvesterid the primary key of the current c s w harvester
    * @param groupId the group id to search with
    * @param orderByComparator the comparator to order the set by
    * @return the previous, current, and next c s w harvester
    * @throws nl.wur.alterra.cgi.ace.NoSuchCSWHarvesterException if a c s w harvester with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public nl.wur.alterra.cgi.ace.model.CSWHarvester[] findByGroupId_PrevAndNext(
        long cswharvesterid, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.wur.alterra.cgi.ace.NoSuchCSWHarvesterException;

    /**
    * Finds all the c s w harvesters.
    *
    * @return the c s w harvesters
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<nl.wur.alterra.cgi.ace.model.CSWHarvester> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Finds a range of all the c s w harvesters.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of c s w harvesters to return
    * @param end the upper bound of the range of c s w harvesters to return (not inclusive)
    * @return the range of c s w harvesters
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<nl.wur.alterra.cgi.ace.model.CSWHarvester> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Finds an ordered range of all the c s w harvesters.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of c s w harvesters to return
    * @param end the upper bound of the range of c s w harvesters to return (not inclusive)
    * @param orderByComparator the comparator to order the results by
    * @return the ordered range of c s w harvesters
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<nl.wur.alterra.cgi.ace.model.CSWHarvester> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the c s w harvesters where groupId = &#63; from the database.
    *
    * @param groupId the group id to search with
    * @throws SystemException if a system exception occurred
    */
    public void removeByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the c s w harvesters from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Counts all the c s w harvesters where groupId = &#63;.
    *
    * @param groupId the group id to search with
    * @return the number of matching c s w harvesters
    * @throws SystemException if a system exception occurred
    */
    public int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Counts all the c s w harvesters.
    *
    * @return the number of c s w harvesters
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
