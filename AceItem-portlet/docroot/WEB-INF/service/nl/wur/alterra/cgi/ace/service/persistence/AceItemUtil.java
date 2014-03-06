package nl.wur.alterra.cgi.ace.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import nl.wur.alterra.cgi.ace.model.AceItem;

import java.util.List;

/**
 * The persistence utility for the ace item service. This utility wraps {@link AceItemPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author groot052
 * @see AceItemPersistence
 * @see AceItemPersistenceImpl
 * @generated
 */
public class AceItemUtil {
    private static AceItemPersistence _persistence;

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
    public static void clearCache(AceItem aceItem) {
        getPersistence().clearCache(aceItem);
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
    public static List<AceItem> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<AceItem> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<AceItem> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static AceItem update(AceItem aceItem) throws SystemException {
        return getPersistence().update(aceItem);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static AceItem update(AceItem aceItem, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(aceItem, serviceContext);
    }

    /**
    * Returns all the ace items where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching ace items
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<nl.wur.alterra.cgi.ace.model.AceItem> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId(groupId);
    }

    /**
    * Returns a range of all the ace items where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.wur.alterra.cgi.ace.model.impl.AceItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of ace items
    * @param end the upper bound of the range of ace items (not inclusive)
    * @return the range of matching ace items
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<nl.wur.alterra.cgi.ace.model.AceItem> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId(groupId, start, end);
    }

    /**
    * Returns an ordered range of all the ace items where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.wur.alterra.cgi.ace.model.impl.AceItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of ace items
    * @param end the upper bound of the range of ace items (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching ace items
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<nl.wur.alterra.cgi.ace.model.AceItem> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupId(groupId, start, end, orderByComparator);
    }

    /**
    * Returns the first ace item in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching ace item
    * @throws nl.wur.alterra.cgi.ace.NoSuchItemException if a matching ace item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.AceItem findByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.wur.alterra.cgi.ace.NoSuchItemException {
        return getPersistence().findByGroupId_First(groupId, orderByComparator);
    }

    /**
    * Returns the first ace item in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching ace item, or <code>null</code> if a matching ace item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.AceItem fetchByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
    }

    /**
    * Returns the last ace item in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching ace item
    * @throws nl.wur.alterra.cgi.ace.NoSuchItemException if a matching ace item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.AceItem findByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.wur.alterra.cgi.ace.NoSuchItemException {
        return getPersistence().findByGroupId_Last(groupId, orderByComparator);
    }

    /**
    * Returns the last ace item in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching ace item, or <code>null</code> if a matching ace item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.AceItem fetchByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
    }

    /**
    * Returns the ace items before and after the current ace item in the ordered set where groupId = &#63;.
    *
    * @param aceItemId the primary key of the current ace item
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next ace item
    * @throws nl.wur.alterra.cgi.ace.NoSuchItemException if a ace item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.AceItem[] findByGroupId_PrevAndNext(
        long aceItemId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.wur.alterra.cgi.ace.NoSuchItemException {
        return getPersistence()
                   .findByGroupId_PrevAndNext(aceItemId, groupId,
            orderByComparator);
    }

    /**
    * Removes all the ace items where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByGroupId(groupId);
    }

    /**
    * Returns the number of ace items where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching ace items
    * @throws SystemException if a system exception occurred
    */
    public static int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByGroupId(groupId);
    }

    /**
    * Returns the ace item where storedAt = &#63; or throws a {@link nl.wur.alterra.cgi.ace.NoSuchItemException} if it could not be found.
    *
    * @param storedAt the stored at
    * @return the matching ace item
    * @throws nl.wur.alterra.cgi.ace.NoSuchItemException if a matching ace item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.AceItem findByStoredAt(
        java.lang.String storedAt)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.wur.alterra.cgi.ace.NoSuchItemException {
        return getPersistence().findByStoredAt(storedAt);
    }

    /**
    * Returns the ace item where storedAt = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param storedAt the stored at
    * @return the matching ace item, or <code>null</code> if a matching ace item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.AceItem fetchByStoredAt(
        java.lang.String storedAt)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByStoredAt(storedAt);
    }

    /**
    * Returns the ace item where storedAt = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param storedAt the stored at
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching ace item, or <code>null</code> if a matching ace item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.AceItem fetchByStoredAt(
        java.lang.String storedAt, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByStoredAt(storedAt, retrieveFromCache);
    }

    /**
    * Removes the ace item where storedAt = &#63; from the database.
    *
    * @param storedAt the stored at
    * @return the ace item that was removed
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.AceItem removeByStoredAt(
        java.lang.String storedAt)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.wur.alterra.cgi.ace.NoSuchItemException {
        return getPersistence().removeByStoredAt(storedAt);
    }

    /**
    * Returns the number of ace items where storedAt = &#63;.
    *
    * @param storedAt the stored at
    * @return the number of matching ace items
    * @throws SystemException if a system exception occurred
    */
    public static int countByStoredAt(java.lang.String storedAt)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByStoredAt(storedAt);
    }

    /**
    * Returns all the ace items where wxsharvesterId = &#63;.
    *
    * @param wxsharvesterId the wxsharvester ID
    * @return the matching ace items
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<nl.wur.alterra.cgi.ace.model.AceItem> findByWxsharvesterId(
        long wxsharvesterId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByWxsharvesterId(wxsharvesterId);
    }

    /**
    * Returns a range of all the ace items where wxsharvesterId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.wur.alterra.cgi.ace.model.impl.AceItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param wxsharvesterId the wxsharvester ID
    * @param start the lower bound of the range of ace items
    * @param end the upper bound of the range of ace items (not inclusive)
    * @return the range of matching ace items
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<nl.wur.alterra.cgi.ace.model.AceItem> findByWxsharvesterId(
        long wxsharvesterId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByWxsharvesterId(wxsharvesterId, start, end);
    }

    /**
    * Returns an ordered range of all the ace items where wxsharvesterId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.wur.alterra.cgi.ace.model.impl.AceItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param wxsharvesterId the wxsharvester ID
    * @param start the lower bound of the range of ace items
    * @param end the upper bound of the range of ace items (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching ace items
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<nl.wur.alterra.cgi.ace.model.AceItem> findByWxsharvesterId(
        long wxsharvesterId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByWxsharvesterId(wxsharvesterId, start, end,
            orderByComparator);
    }

    /**
    * Returns the first ace item in the ordered set where wxsharvesterId = &#63;.
    *
    * @param wxsharvesterId the wxsharvester ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching ace item
    * @throws nl.wur.alterra.cgi.ace.NoSuchItemException if a matching ace item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.AceItem findByWxsharvesterId_First(
        long wxsharvesterId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.wur.alterra.cgi.ace.NoSuchItemException {
        return getPersistence()
                   .findByWxsharvesterId_First(wxsharvesterId, orderByComparator);
    }

    /**
    * Returns the first ace item in the ordered set where wxsharvesterId = &#63;.
    *
    * @param wxsharvesterId the wxsharvester ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching ace item, or <code>null</code> if a matching ace item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.AceItem fetchByWxsharvesterId_First(
        long wxsharvesterId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByWxsharvesterId_First(wxsharvesterId,
            orderByComparator);
    }

    /**
    * Returns the last ace item in the ordered set where wxsharvesterId = &#63;.
    *
    * @param wxsharvesterId the wxsharvester ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching ace item
    * @throws nl.wur.alterra.cgi.ace.NoSuchItemException if a matching ace item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.AceItem findByWxsharvesterId_Last(
        long wxsharvesterId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.wur.alterra.cgi.ace.NoSuchItemException {
        return getPersistence()
                   .findByWxsharvesterId_Last(wxsharvesterId, orderByComparator);
    }

    /**
    * Returns the last ace item in the ordered set where wxsharvesterId = &#63;.
    *
    * @param wxsharvesterId the wxsharvester ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching ace item, or <code>null</code> if a matching ace item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.AceItem fetchByWxsharvesterId_Last(
        long wxsharvesterId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByWxsharvesterId_Last(wxsharvesterId, orderByComparator);
    }

    /**
    * Returns the ace items before and after the current ace item in the ordered set where wxsharvesterId = &#63;.
    *
    * @param aceItemId the primary key of the current ace item
    * @param wxsharvesterId the wxsharvester ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next ace item
    * @throws nl.wur.alterra.cgi.ace.NoSuchItemException if a ace item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.AceItem[] findByWxsharvesterId_PrevAndNext(
        long aceItemId, long wxsharvesterId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.wur.alterra.cgi.ace.NoSuchItemException {
        return getPersistence()
                   .findByWxsharvesterId_PrevAndNext(aceItemId, wxsharvesterId,
            orderByComparator);
    }

    /**
    * Removes all the ace items where wxsharvesterId = &#63; from the database.
    *
    * @param wxsharvesterId the wxsharvester ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByWxsharvesterId(long wxsharvesterId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByWxsharvesterId(wxsharvesterId);
    }

    /**
    * Returns the number of ace items where wxsharvesterId = &#63;.
    *
    * @param wxsharvesterId the wxsharvester ID
    * @return the number of matching ace items
    * @throws SystemException if a system exception occurred
    */
    public static int countByWxsharvesterId(long wxsharvesterId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByWxsharvesterId(wxsharvesterId);
    }

    /**
    * Returns all the ace items where cswharvesterId = &#63;.
    *
    * @param cswharvesterId the cswharvester ID
    * @return the matching ace items
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<nl.wur.alterra.cgi.ace.model.AceItem> findByCSWharvesterId(
        long cswharvesterId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCSWharvesterId(cswharvesterId);
    }

    /**
    * Returns a range of all the ace items where cswharvesterId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.wur.alterra.cgi.ace.model.impl.AceItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param cswharvesterId the cswharvester ID
    * @param start the lower bound of the range of ace items
    * @param end the upper bound of the range of ace items (not inclusive)
    * @return the range of matching ace items
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<nl.wur.alterra.cgi.ace.model.AceItem> findByCSWharvesterId(
        long cswharvesterId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCSWharvesterId(cswharvesterId, start, end);
    }

    /**
    * Returns an ordered range of all the ace items where cswharvesterId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.wur.alterra.cgi.ace.model.impl.AceItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param cswharvesterId the cswharvester ID
    * @param start the lower bound of the range of ace items
    * @param end the upper bound of the range of ace items (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching ace items
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<nl.wur.alterra.cgi.ace.model.AceItem> findByCSWharvesterId(
        long cswharvesterId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCSWharvesterId(cswharvesterId, start, end,
            orderByComparator);
    }

    /**
    * Returns the first ace item in the ordered set where cswharvesterId = &#63;.
    *
    * @param cswharvesterId the cswharvester ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching ace item
    * @throws nl.wur.alterra.cgi.ace.NoSuchItemException if a matching ace item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.AceItem findByCSWharvesterId_First(
        long cswharvesterId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.wur.alterra.cgi.ace.NoSuchItemException {
        return getPersistence()
                   .findByCSWharvesterId_First(cswharvesterId, orderByComparator);
    }

    /**
    * Returns the first ace item in the ordered set where cswharvesterId = &#63;.
    *
    * @param cswharvesterId the cswharvester ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching ace item, or <code>null</code> if a matching ace item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.AceItem fetchByCSWharvesterId_First(
        long cswharvesterId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCSWharvesterId_First(cswharvesterId,
            orderByComparator);
    }

    /**
    * Returns the last ace item in the ordered set where cswharvesterId = &#63;.
    *
    * @param cswharvesterId the cswharvester ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching ace item
    * @throws nl.wur.alterra.cgi.ace.NoSuchItemException if a matching ace item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.AceItem findByCSWharvesterId_Last(
        long cswharvesterId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.wur.alterra.cgi.ace.NoSuchItemException {
        return getPersistence()
                   .findByCSWharvesterId_Last(cswharvesterId, orderByComparator);
    }

    /**
    * Returns the last ace item in the ordered set where cswharvesterId = &#63;.
    *
    * @param cswharvesterId the cswharvester ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching ace item, or <code>null</code> if a matching ace item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.AceItem fetchByCSWharvesterId_Last(
        long cswharvesterId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCSWharvesterId_Last(cswharvesterId, orderByComparator);
    }

    /**
    * Returns the ace items before and after the current ace item in the ordered set where cswharvesterId = &#63;.
    *
    * @param aceItemId the primary key of the current ace item
    * @param cswharvesterId the cswharvester ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next ace item
    * @throws nl.wur.alterra.cgi.ace.NoSuchItemException if a ace item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.AceItem[] findByCSWharvesterId_PrevAndNext(
        long aceItemId, long cswharvesterId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.wur.alterra.cgi.ace.NoSuchItemException {
        return getPersistence()
                   .findByCSWharvesterId_PrevAndNext(aceItemId, cswharvesterId,
            orderByComparator);
    }

    /**
    * Removes all the ace items where cswharvesterId = &#63; from the database.
    *
    * @param cswharvesterId the cswharvester ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByCSWharvesterId(long cswharvesterId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByCSWharvesterId(cswharvesterId);
    }

    /**
    * Returns the number of ace items where cswharvesterId = &#63;.
    *
    * @param cswharvesterId the cswharvester ID
    * @return the number of matching ace items
    * @throws SystemException if a system exception occurred
    */
    public static int countByCSWharvesterId(long cswharvesterId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByCSWharvesterId(cswharvesterId);
    }

    /**
    * Caches the ace item in the entity cache if it is enabled.
    *
    * @param aceItem the ace item
    */
    public static void cacheResult(nl.wur.alterra.cgi.ace.model.AceItem aceItem) {
        getPersistence().cacheResult(aceItem);
    }

    /**
    * Caches the ace items in the entity cache if it is enabled.
    *
    * @param aceItems the ace items
    */
    public static void cacheResult(
        java.util.List<nl.wur.alterra.cgi.ace.model.AceItem> aceItems) {
        getPersistence().cacheResult(aceItems);
    }

    /**
    * Creates a new ace item with the primary key. Does not add the ace item to the database.
    *
    * @param aceItemId the primary key for the new ace item
    * @return the new ace item
    */
    public static nl.wur.alterra.cgi.ace.model.AceItem create(long aceItemId) {
        return getPersistence().create(aceItemId);
    }

    /**
    * Removes the ace item with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param aceItemId the primary key of the ace item
    * @return the ace item that was removed
    * @throws nl.wur.alterra.cgi.ace.NoSuchItemException if a ace item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.AceItem remove(long aceItemId)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.wur.alterra.cgi.ace.NoSuchItemException {
        return getPersistence().remove(aceItemId);
    }

    public static nl.wur.alterra.cgi.ace.model.AceItem updateImpl(
        nl.wur.alterra.cgi.ace.model.AceItem aceItem)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(aceItem);
    }

    /**
    * Returns the ace item with the primary key or throws a {@link nl.wur.alterra.cgi.ace.NoSuchItemException} if it could not be found.
    *
    * @param aceItemId the primary key of the ace item
    * @return the ace item
    * @throws nl.wur.alterra.cgi.ace.NoSuchItemException if a ace item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.AceItem findByPrimaryKey(
        long aceItemId)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.wur.alterra.cgi.ace.NoSuchItemException {
        return getPersistence().findByPrimaryKey(aceItemId);
    }

    /**
    * Returns the ace item with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param aceItemId the primary key of the ace item
    * @return the ace item, or <code>null</code> if a ace item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.AceItem fetchByPrimaryKey(
        long aceItemId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(aceItemId);
    }

    /**
    * Returns all the ace items.
    *
    * @return the ace items
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<nl.wur.alterra.cgi.ace.model.AceItem> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the ace items.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.wur.alterra.cgi.ace.model.impl.AceItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of ace items
    * @param end the upper bound of the range of ace items (not inclusive)
    * @return the range of ace items
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<nl.wur.alterra.cgi.ace.model.AceItem> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the ace items.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.wur.alterra.cgi.ace.model.impl.AceItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of ace items
    * @param end the upper bound of the range of ace items (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of ace items
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<nl.wur.alterra.cgi.ace.model.AceItem> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the ace items from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of ace items.
    *
    * @return the number of ace items
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static AceItemPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (AceItemPersistence) PortletBeanLocatorUtil.locate(nl.wur.alterra.cgi.ace.service.ClpSerializer.getServletContextName(),
                    AceItemPersistence.class.getName());

            ReferenceRegistry.registerReference(AceItemUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(AceItemPersistence persistence) {
    }
}
