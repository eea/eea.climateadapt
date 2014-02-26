package nl.wur.alterra.cgi.ace.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

import nl.wur.alterra.cgi.ace.model.WxsHarvester;

import java.util.List;

/**
 * The persistence utility for the wxs harvester service. This utility wraps {@link WxsHarvesterPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
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
 * @see WxsHarvesterPersistence
 * @see WxsHarvesterPersistenceImpl
 * @generated
 */
public class WxsHarvesterUtil {
    private static WxsHarvesterPersistence _persistence;

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(WxsHarvester wxsHarvester) {
        getPersistence().clearCache(wxsHarvester);
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
    public static List<WxsHarvester> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<WxsHarvester> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<WxsHarvester> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
     */
    public static WxsHarvester remove(WxsHarvester wxsHarvester)
        throws SystemException {
        return getPersistence().remove(wxsHarvester);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static WxsHarvester update(WxsHarvester wxsHarvester, boolean merge)
        throws SystemException {
        return getPersistence().update(wxsHarvester, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static WxsHarvester update(WxsHarvester wxsHarvester, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(wxsHarvester, merge, serviceContext);
    }

    /**
    * Caches the wxs harvester in the entity cache if it is enabled.
    *
    * @param wxsHarvester the wxs harvester to cache
    */
    public static void cacheResult(
        nl.wur.alterra.cgi.ace.model.WxsHarvester wxsHarvester) {
        getPersistence().cacheResult(wxsHarvester);
    }

    /**
    * Caches the wxs harvesters in the entity cache if it is enabled.
    *
    * @param wxsHarvesters the wxs harvesters to cache
    */
    public static void cacheResult(
        java.util.List<nl.wur.alterra.cgi.ace.model.WxsHarvester> wxsHarvesters) {
        getPersistence().cacheResult(wxsHarvesters);
    }

    /**
    * Creates a new wxs harvester with the primary key. Does not add the wxs harvester to the database.
    *
    * @param wxsharvesterid the primary key for the new wxs harvester
    * @return the new wxs harvester
    */
    public static nl.wur.alterra.cgi.ace.model.WxsHarvester create(
        long wxsharvesterid) {
        return getPersistence().create(wxsharvesterid);
    }

    /**
    * Removes the wxs harvester with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param wxsharvesterid the primary key of the wxs harvester to remove
    * @return the wxs harvester that was removed
    * @throws nl.wur.alterra.cgi.ace.NoSuchWxsHarvesterException if a wxs harvester with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.WxsHarvester remove(
        long wxsharvesterid)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.wur.alterra.cgi.ace.NoSuchWxsHarvesterException {
        return getPersistence().remove(wxsharvesterid);
    }

    public static nl.wur.alterra.cgi.ace.model.WxsHarvester updateImpl(
        nl.wur.alterra.cgi.ace.model.WxsHarvester wxsHarvester, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(wxsHarvester, merge);
    }

    /**
    * Finds the wxs harvester with the primary key or throws a {@link nl.wur.alterra.cgi.ace.NoSuchWxsHarvesterException} if it could not be found.
    *
    * @param wxsharvesterid the primary key of the wxs harvester to find
    * @return the wxs harvester
    * @throws nl.wur.alterra.cgi.ace.NoSuchWxsHarvesterException if a wxs harvester with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.WxsHarvester findByPrimaryKey(
        long wxsharvesterid)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.wur.alterra.cgi.ace.NoSuchWxsHarvesterException {
        return getPersistence().findByPrimaryKey(wxsharvesterid);
    }

    /**
    * Finds the wxs harvester with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param wxsharvesterid the primary key of the wxs harvester to find
    * @return the wxs harvester, or <code>null</code> if a wxs harvester with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.WxsHarvester fetchByPrimaryKey(
        long wxsharvesterid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(wxsharvesterid);
    }

    /**
    * Finds all the wxs harvesters where groupId = &#63;.
    *
    * @param groupId the group id to search with
    * @return the matching wxs harvesters
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<nl.wur.alterra.cgi.ace.model.WxsHarvester> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId(groupId);
    }

    /**
    * Finds a range of all the wxs harvesters where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param groupId the group id to search with
    * @param start the lower bound of the range of wxs harvesters to return
    * @param end the upper bound of the range of wxs harvesters to return (not inclusive)
    * @return the range of matching wxs harvesters
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<nl.wur.alterra.cgi.ace.model.WxsHarvester> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId(groupId, start, end);
    }

    /**
    * Finds an ordered range of all the wxs harvesters where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param groupId the group id to search with
    * @param start the lower bound of the range of wxs harvesters to return
    * @param end the upper bound of the range of wxs harvesters to return (not inclusive)
    * @param orderByComparator the comparator to order the results by
    * @return the ordered range of matching wxs harvesters
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<nl.wur.alterra.cgi.ace.model.WxsHarvester> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupId(groupId, start, end, orderByComparator);
    }

    /**
    * Finds the first wxs harvester in the ordered set where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param groupId the group id to search with
    * @param orderByComparator the comparator to order the set by
    * @return the first matching wxs harvester
    * @throws nl.wur.alterra.cgi.ace.NoSuchWxsHarvesterException if a matching wxs harvester could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.WxsHarvester findByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.wur.alterra.cgi.ace.NoSuchWxsHarvesterException {
        return getPersistence().findByGroupId_First(groupId, orderByComparator);
    }

    /**
    * Finds the last wxs harvester in the ordered set where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param groupId the group id to search with
    * @param orderByComparator the comparator to order the set by
    * @return the last matching wxs harvester
    * @throws nl.wur.alterra.cgi.ace.NoSuchWxsHarvesterException if a matching wxs harvester could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.WxsHarvester findByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.wur.alterra.cgi.ace.NoSuchWxsHarvesterException {
        return getPersistence().findByGroupId_Last(groupId, orderByComparator);
    }

    /**
    * Finds the wxs harvesters before and after the current wxs harvester in the ordered set where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param wxsharvesterid the primary key of the current wxs harvester
    * @param groupId the group id to search with
    * @param orderByComparator the comparator to order the set by
    * @return the previous, current, and next wxs harvester
    * @throws nl.wur.alterra.cgi.ace.NoSuchWxsHarvesterException if a wxs harvester with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.WxsHarvester[] findByGroupId_PrevAndNext(
        long wxsharvesterid, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.wur.alterra.cgi.ace.NoSuchWxsHarvesterException {
        return getPersistence()
                   .findByGroupId_PrevAndNext(wxsharvesterid, groupId,
            orderByComparator);
    }

    /**
    * Finds all the wxs harvesters.
    *
    * @return the wxs harvesters
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<nl.wur.alterra.cgi.ace.model.WxsHarvester> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Finds a range of all the wxs harvesters.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of wxs harvesters to return
    * @param end the upper bound of the range of wxs harvesters to return (not inclusive)
    * @return the range of wxs harvesters
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<nl.wur.alterra.cgi.ace.model.WxsHarvester> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Finds an ordered range of all the wxs harvesters.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of wxs harvesters to return
    * @param end the upper bound of the range of wxs harvesters to return (not inclusive)
    * @param orderByComparator the comparator to order the results by
    * @return the ordered range of wxs harvesters
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<nl.wur.alterra.cgi.ace.model.WxsHarvester> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the wxs harvesters where groupId = &#63; from the database.
    *
    * @param groupId the group id to search with
    * @throws SystemException if a system exception occurred
    */
    public static void removeByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByGroupId(groupId);
    }

    /**
    * Removes all the wxs harvesters from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Counts all the wxs harvesters where groupId = &#63;.
    *
    * @param groupId the group id to search with
    * @return the number of matching wxs harvesters
    * @throws SystemException if a system exception occurred
    */
    public static int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByGroupId(groupId);
    }

    /**
    * Counts all the wxs harvesters.
    *
    * @return the number of wxs harvesters
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static WxsHarvesterPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (WxsHarvesterPersistence) PortletBeanLocatorUtil.locate(nl.wur.alterra.cgi.ace.service.ClpSerializer.SERVLET_CONTEXT_NAME,
                    WxsHarvesterPersistence.class.getName());
        }

        return _persistence;
    }

    public void setPersistence(WxsHarvesterPersistence persistence) {
        _persistence = persistence;
    }
}
