package nl.wur.alterra.cgi.ace.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import nl.wur.alterra.cgi.ace.model.WxsHarvester;

/**
 * The persistence interface for the wxs harvester service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author groot052
 * @see WxsHarvesterPersistenceImpl
 * @see WxsHarvesterUtil
 * @generated
 */
public interface WxsHarvesterPersistence extends BasePersistence<WxsHarvester> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link WxsHarvesterUtil} to access the wxs harvester persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the wxs harvesters where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching wxs harvesters
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<nl.wur.alterra.cgi.ace.model.WxsHarvester> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the wxs harvesters where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.wur.alterra.cgi.ace.model.impl.WxsHarvesterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of wxs harvesters
    * @param end the upper bound of the range of wxs harvesters (not inclusive)
    * @return the range of matching wxs harvesters
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<nl.wur.alterra.cgi.ace.model.WxsHarvester> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the wxs harvesters where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.wur.alterra.cgi.ace.model.impl.WxsHarvesterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of wxs harvesters
    * @param end the upper bound of the range of wxs harvesters (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching wxs harvesters
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<nl.wur.alterra.cgi.ace.model.WxsHarvester> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first wxs harvester in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching wxs harvester
    * @throws nl.wur.alterra.cgi.ace.NoSuchWxsHarvesterException if a matching wxs harvester could not be found
    * @throws SystemException if a system exception occurred
    */
    public nl.wur.alterra.cgi.ace.model.WxsHarvester findByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.wur.alterra.cgi.ace.NoSuchWxsHarvesterException;

    /**
    * Returns the first wxs harvester in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching wxs harvester, or <code>null</code> if a matching wxs harvester could not be found
    * @throws SystemException if a system exception occurred
    */
    public nl.wur.alterra.cgi.ace.model.WxsHarvester fetchByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last wxs harvester in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching wxs harvester
    * @throws nl.wur.alterra.cgi.ace.NoSuchWxsHarvesterException if a matching wxs harvester could not be found
    * @throws SystemException if a system exception occurred
    */
    public nl.wur.alterra.cgi.ace.model.WxsHarvester findByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.wur.alterra.cgi.ace.NoSuchWxsHarvesterException;

    /**
    * Returns the last wxs harvester in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching wxs harvester, or <code>null</code> if a matching wxs harvester could not be found
    * @throws SystemException if a system exception occurred
    */
    public nl.wur.alterra.cgi.ace.model.WxsHarvester fetchByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the wxs harvesters before and after the current wxs harvester in the ordered set where groupId = &#63;.
    *
    * @param wxsharvesterid the primary key of the current wxs harvester
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next wxs harvester
    * @throws nl.wur.alterra.cgi.ace.NoSuchWxsHarvesterException if a wxs harvester with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public nl.wur.alterra.cgi.ace.model.WxsHarvester[] findByGroupId_PrevAndNext(
        long wxsharvesterid, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.wur.alterra.cgi.ace.NoSuchWxsHarvesterException;

    /**
    * Removes all the wxs harvesters where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of wxs harvesters where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching wxs harvesters
    * @throws SystemException if a system exception occurred
    */
    public int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the wxs harvester in the entity cache if it is enabled.
    *
    * @param wxsHarvester the wxs harvester
    */
    public void cacheResult(
        nl.wur.alterra.cgi.ace.model.WxsHarvester wxsHarvester);

    /**
    * Caches the wxs harvesters in the entity cache if it is enabled.
    *
    * @param wxsHarvesters the wxs harvesters
    */
    public void cacheResult(
        java.util.List<nl.wur.alterra.cgi.ace.model.WxsHarvester> wxsHarvesters);

    /**
    * Creates a new wxs harvester with the primary key. Does not add the wxs harvester to the database.
    *
    * @param wxsharvesterid the primary key for the new wxs harvester
    * @return the new wxs harvester
    */
    public nl.wur.alterra.cgi.ace.model.WxsHarvester create(long wxsharvesterid);

    /**
    * Removes the wxs harvester with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param wxsharvesterid the primary key of the wxs harvester
    * @return the wxs harvester that was removed
    * @throws nl.wur.alterra.cgi.ace.NoSuchWxsHarvesterException if a wxs harvester with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public nl.wur.alterra.cgi.ace.model.WxsHarvester remove(long wxsharvesterid)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.wur.alterra.cgi.ace.NoSuchWxsHarvesterException;

    public nl.wur.alterra.cgi.ace.model.WxsHarvester updateImpl(
        nl.wur.alterra.cgi.ace.model.WxsHarvester wxsHarvester)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the wxs harvester with the primary key or throws a {@link nl.wur.alterra.cgi.ace.NoSuchWxsHarvesterException} if it could not be found.
    *
    * @param wxsharvesterid the primary key of the wxs harvester
    * @return the wxs harvester
    * @throws nl.wur.alterra.cgi.ace.NoSuchWxsHarvesterException if a wxs harvester with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public nl.wur.alterra.cgi.ace.model.WxsHarvester findByPrimaryKey(
        long wxsharvesterid)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.wur.alterra.cgi.ace.NoSuchWxsHarvesterException;

    /**
    * Returns the wxs harvester with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param wxsharvesterid the primary key of the wxs harvester
    * @return the wxs harvester, or <code>null</code> if a wxs harvester with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public nl.wur.alterra.cgi.ace.model.WxsHarvester fetchByPrimaryKey(
        long wxsharvesterid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the wxs harvesters.
    *
    * @return the wxs harvesters
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<nl.wur.alterra.cgi.ace.model.WxsHarvester> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the wxs harvesters.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.wur.alterra.cgi.ace.model.impl.WxsHarvesterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of wxs harvesters
    * @param end the upper bound of the range of wxs harvesters (not inclusive)
    * @return the range of wxs harvesters
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<nl.wur.alterra.cgi.ace.model.WxsHarvester> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the wxs harvesters.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.wur.alterra.cgi.ace.model.impl.WxsHarvesterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of wxs harvesters
    * @param end the upper bound of the range of wxs harvesters (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of wxs harvesters
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<nl.wur.alterra.cgi.ace.model.WxsHarvester> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the wxs harvesters from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of wxs harvesters.
    *
    * @return the number of wxs harvesters
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
