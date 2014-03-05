package nl.wur.alterra.cgi.ace.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

import nl.wur.alterra.cgi.ace.model.CSWHarvester;

import java.util.List;

/**
 * The persistence utility for the c s w harvester service. This utility wraps {@link CSWHarvesterPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author groot052
 * @see CSWHarvesterPersistence
 * @see CSWHarvesterPersistenceImpl
 * @generated
 */
public class CSWHarvesterUtil {
    private static CSWHarvesterPersistence _persistence;

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(CSWHarvester cswHarvester) {
        getPersistence().clearCache(cswHarvester);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<CSWHarvester> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<CSWHarvester> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<CSWHarvester> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
     */
    public static CSWHarvester remove(CSWHarvester cswHarvester)
        throws SystemException {
        return getPersistence().remove(cswHarvester);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static CSWHarvester update(CSWHarvester cswHarvester, boolean merge)
        throws SystemException {
        return getPersistence().update(cswHarvester, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static CSWHarvester update(CSWHarvester cswHarvester, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(cswHarvester, merge, serviceContext);
    }

    /**
    * Caches the c s w harvester in the entity cache if it is enabled.
    *
    * @param cswHarvester the c s w harvester to cache
    */
    public static void cacheResult(
        nl.wur.alterra.cgi.ace.model.CSWHarvester cswHarvester) {
        getPersistence().cacheResult(cswHarvester);
    }

    /**
    * Caches the c s w harvesters in the entity cache if it is enabled.
    *
    * @param cswHarvesters the c s w harvesters to cache
    */
    public static void cacheResult(
        java.util.List<nl.wur.alterra.cgi.ace.model.CSWHarvester> cswHarvesters) {
        getPersistence().cacheResult(cswHarvesters);
    }

    /**
    * Creates a new c s w harvester with the primary key. Does not add the c s w harvester to the database.
    *
    * @param cswharvesterid the primary key for the new c s w harvester
    * @return the new c s w harvester
    */
    public static nl.wur.alterra.cgi.ace.model.CSWHarvester create(
        long cswharvesterid) {
        return getPersistence().create(cswharvesterid);
    }

    /**
    * Removes the c s w harvester with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param cswharvesterid the primary key of the c s w harvester to remove
    * @return the c s w harvester that was removed
    * @throws nl.wur.alterra.cgi.ace.NoSuchCSWHarvesterException if a c s w harvester with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.CSWHarvester remove(
        long cswharvesterid)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.wur.alterra.cgi.ace.NoSuchCSWHarvesterException {
        return getPersistence().remove(cswharvesterid);
    }

    public static nl.wur.alterra.cgi.ace.model.CSWHarvester updateImpl(
        nl.wur.alterra.cgi.ace.model.CSWHarvester cswHarvester, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(cswHarvester, merge);
    }

    /**
    * Finds the c s w harvester with the primary key or throws a {@link nl.wur.alterra.cgi.ace.NoSuchCSWHarvesterException} if it could not be found.
    *
    * @param cswharvesterid the primary key of the c s w harvester to find
    * @return the c s w harvester
    * @throws nl.wur.alterra.cgi.ace.NoSuchCSWHarvesterException if a c s w harvester with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.CSWHarvester findByPrimaryKey(
        long cswharvesterid)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.wur.alterra.cgi.ace.NoSuchCSWHarvesterException {
        return getPersistence().findByPrimaryKey(cswharvesterid);
    }

    /**
    * Finds the c s w harvester with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param cswharvesterid the primary key of the c s w harvester to find
    * @return the c s w harvester, or <code>null</code> if a c s w harvester with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.CSWHarvester fetchByPrimaryKey(
        long cswharvesterid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(cswharvesterid);
    }

    /**
    * Finds all the c s w harvesters where groupId = &#63;.
    *
    * @param groupId the group id to search with
    * @return the matching c s w harvesters
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<nl.wur.alterra.cgi.ace.model.CSWHarvester> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId(groupId);
    }

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
    public static java.util.List<nl.wur.alterra.cgi.ace.model.CSWHarvester> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId(groupId, start, end);
    }

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
    public static java.util.List<nl.wur.alterra.cgi.ace.model.CSWHarvester> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupId(groupId, start, end, orderByComparator);
    }

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
    public static nl.wur.alterra.cgi.ace.model.CSWHarvester findByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.wur.alterra.cgi.ace.NoSuchCSWHarvesterException {
        return getPersistence().findByGroupId_First(groupId, orderByComparator);
    }

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
    public static nl.wur.alterra.cgi.ace.model.CSWHarvester findByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.wur.alterra.cgi.ace.NoSuchCSWHarvesterException {
        return getPersistence().findByGroupId_Last(groupId, orderByComparator);
    }

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
    public static nl.wur.alterra.cgi.ace.model.CSWHarvester[] findByGroupId_PrevAndNext(
        long cswharvesterid, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.wur.alterra.cgi.ace.NoSuchCSWHarvesterException {
        return getPersistence()
                   .findByGroupId_PrevAndNext(cswharvesterid, groupId,
            orderByComparator);
    }

    /**
    * Finds all the c s w harvesters.
    *
    * @return the c s w harvesters
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<nl.wur.alterra.cgi.ace.model.CSWHarvester> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

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
    public static java.util.List<nl.wur.alterra.cgi.ace.model.CSWHarvester> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

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
    public static java.util.List<nl.wur.alterra.cgi.ace.model.CSWHarvester> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the c s w harvesters where groupId = &#63; from the database.
    *
    * @param groupId the group id to search with
    * @throws SystemException if a system exception occurred
    */
    public static void removeByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByGroupId(groupId);
    }

    /**
    * Removes all the c s w harvesters from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Counts all the c s w harvesters where groupId = &#63;.
    *
    * @param groupId the group id to search with
    * @return the number of matching c s w harvesters
    * @throws SystemException if a system exception occurred
    */
    public static int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByGroupId(groupId);
    }

    /**
    * Counts all the c s w harvesters.
    *
    * @return the number of c s w harvesters
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static CSWHarvesterPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (CSWHarvesterPersistence) PortletBeanLocatorUtil.locate(nl.wur.alterra.cgi.ace.service.ClpSerializer.SERVLET_CONTEXT_NAME,
                    CSWHarvesterPersistence.class.getName());
        }

        return _persistence;
    }

    public void setPersistence(CSWHarvesterPersistence persistence) {
        _persistence = persistence;
    }
}
