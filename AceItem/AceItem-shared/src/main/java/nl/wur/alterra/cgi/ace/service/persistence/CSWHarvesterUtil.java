package nl.wur.alterra.cgi.ace.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import nl.wur.alterra.cgi.ace.model.CSWHarvester;

import java.util.List;

/**
 * The persistence utility for the c s w harvester service. This utility wraps {@link CSWHarvesterPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
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

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

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
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
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
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static CSWHarvester update(CSWHarvester cswHarvester)
        throws SystemException {
        return getPersistence().update(cswHarvester);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static CSWHarvester update(CSWHarvester cswHarvester,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(cswHarvester, serviceContext);
    }

    /**
    * Returns all the c s w harvesters where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching c s w harvesters
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<nl.wur.alterra.cgi.ace.model.CSWHarvester> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId(groupId);
    }

    /**
    * Returns a range of all the c s w harvesters where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.wur.alterra.cgi.ace.model.impl.CSWHarvesterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of c s w harvesters
    * @param end the upper bound of the range of c s w harvesters (not inclusive)
    * @return the range of matching c s w harvesters
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<nl.wur.alterra.cgi.ace.model.CSWHarvester> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId(groupId, start, end);
    }

    /**
    * Returns an ordered range of all the c s w harvesters where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.wur.alterra.cgi.ace.model.impl.CSWHarvesterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of c s w harvesters
    * @param end the upper bound of the range of c s w harvesters (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
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
    * Returns the first c s w harvester in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
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
    * Returns the first c s w harvester in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching c s w harvester, or <code>null</code> if a matching c s w harvester could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.CSWHarvester fetchByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
    }

    /**
    * Returns the last c s w harvester in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
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
    * Returns the last c s w harvester in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching c s w harvester, or <code>null</code> if a matching c s w harvester could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.CSWHarvester fetchByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
    }

    /**
    * Returns the c s w harvesters before and after the current c s w harvester in the ordered set where groupId = &#63;.
    *
    * @param cswharvesterid the primary key of the current c s w harvester
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
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
    * Removes all the c s w harvesters where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByGroupId(groupId);
    }

    /**
    * Returns the number of c s w harvesters where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching c s w harvesters
    * @throws SystemException if a system exception occurred
    */
    public static int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByGroupId(groupId);
    }

    /**
    * Caches the c s w harvester in the entity cache if it is enabled.
    *
    * @param cswHarvester the c s w harvester
    */
    public static void cacheResult(
        nl.wur.alterra.cgi.ace.model.CSWHarvester cswHarvester) {
        getPersistence().cacheResult(cswHarvester);
    }

    /**
    * Caches the c s w harvesters in the entity cache if it is enabled.
    *
    * @param cswHarvesters the c s w harvesters
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
    * @param cswharvesterid the primary key of the c s w harvester
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
        nl.wur.alterra.cgi.ace.model.CSWHarvester cswHarvester)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(cswHarvester);
    }

    /**
    * Returns the c s w harvester with the primary key or throws a {@link nl.wur.alterra.cgi.ace.NoSuchCSWHarvesterException} if it could not be found.
    *
    * @param cswharvesterid the primary key of the c s w harvester
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
    * Returns the c s w harvester with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param cswharvesterid the primary key of the c s w harvester
    * @return the c s w harvester, or <code>null</code> if a c s w harvester with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.CSWHarvester fetchByPrimaryKey(
        long cswharvesterid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(cswharvesterid);
    }

    /**
    * Returns all the c s w harvesters.
    *
    * @return the c s w harvesters
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<nl.wur.alterra.cgi.ace.model.CSWHarvester> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the c s w harvesters.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.wur.alterra.cgi.ace.model.impl.CSWHarvesterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of c s w harvesters
    * @param end the upper bound of the range of c s w harvesters (not inclusive)
    * @return the range of c s w harvesters
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<nl.wur.alterra.cgi.ace.model.CSWHarvester> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the c s w harvesters.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.wur.alterra.cgi.ace.model.impl.CSWHarvesterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of c s w harvesters
    * @param end the upper bound of the range of c s w harvesters (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
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
    * Removes all the c s w harvesters from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of c s w harvesters.
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
            _persistence = (CSWHarvesterPersistence) PortletBeanLocatorUtil.locate(nl.wur.alterra.cgi.ace.service.ClpSerializer.getServletContextName(),
                    CSWHarvesterPersistence.class.getName());

            ReferenceRegistry.registerReference(CSWHarvesterUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(CSWHarvesterPersistence persistence) {
    }
}
