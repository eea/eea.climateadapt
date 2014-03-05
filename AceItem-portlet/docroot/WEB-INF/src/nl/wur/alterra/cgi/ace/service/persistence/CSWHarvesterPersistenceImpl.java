package nl.wur.alterra.cgi.ace.service.persistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.portlet.asset.service.persistence.AssetEntryPersistence;

import nl.wur.alterra.cgi.ace.NoSuchCSWHarvesterException;
import nl.wur.alterra.cgi.ace.model.CSWHarvester;
import nl.wur.alterra.cgi.ace.model.impl.CSWHarvesterImpl;
import nl.wur.alterra.cgi.ace.model.impl.CSWHarvesterModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the c s w harvester service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link CSWHarvesterUtil} to access the c s w harvester persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author groot052
 * @see CSWHarvesterPersistence
 * @see CSWHarvesterUtil
 * @generated
 */
public class CSWHarvesterPersistenceImpl extends BasePersistenceImpl<CSWHarvester>
    implements CSWHarvesterPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = CSWHarvesterImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_GROUPID = new FinderPath(CSWHarvesterModelImpl.ENTITY_CACHE_ENABLED,
            CSWHarvesterModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByGroupId",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(CSWHarvesterModelImpl.ENTITY_CACHE_ENABLED,
            CSWHarvesterModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByGroupId", new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(CSWHarvesterModelImpl.ENTITY_CACHE_ENABLED,
            CSWHarvesterModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CSWHarvesterModelImpl.ENTITY_CACHE_ENABLED,
            CSWHarvesterModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countAll", new String[0]);
    private static final String _SQL_SELECT_CSWHARVESTER = "SELECT cswHarvester FROM CSWHarvester cswHarvester";
    private static final String _SQL_SELECT_CSWHARVESTER_WHERE = "SELECT cswHarvester FROM CSWHarvester cswHarvester WHERE ";
    private static final String _SQL_COUNT_CSWHARVESTER = "SELECT COUNT(cswHarvester) FROM CSWHarvester cswHarvester";
    private static final String _SQL_COUNT_CSWHARVESTER_WHERE = "SELECT COUNT(cswHarvester) FROM CSWHarvester cswHarvester WHERE ";
    private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "cswHarvester.groupId = ?";
    private static final String _ORDER_BY_ENTITY_ALIAS = "cswHarvester.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CSWHarvester exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CSWHarvester exists with the key {";
    private static Log _log = LogFactoryUtil.getLog(CSWHarvesterPersistenceImpl.class);
    @BeanReference(type = AceItemPersistence.class)
    protected AceItemPersistence aceItemPersistence;
    @BeanReference(type = WxsHarvesterPersistence.class)
    protected WxsHarvesterPersistence wxsHarvesterPersistence;
    @BeanReference(type = CSWHarvesterPersistence.class)
    protected CSWHarvesterPersistence cswHarvesterPersistence;
    @BeanReference(type = ResourcePersistence.class)
    protected ResourcePersistence resourcePersistence;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;
    @BeanReference(type = AssetEntryPersistence.class)
    protected AssetEntryPersistence assetEntryPersistence;

    /**
     * Caches the c s w harvester in the entity cache if it is enabled.
     *
     * @param cswHarvester the c s w harvester to cache
     */
    public void cacheResult(CSWHarvester cswHarvester) {
        EntityCacheUtil.putResult(CSWHarvesterModelImpl.ENTITY_CACHE_ENABLED,
            CSWHarvesterImpl.class, cswHarvester.getPrimaryKey(), cswHarvester);
    }

    /**
     * Caches the c s w harvesters in the entity cache if it is enabled.
     *
     * @param cswHarvesters the c s w harvesters to cache
     */
    public void cacheResult(List<CSWHarvester> cswHarvesters) {
        for (CSWHarvester cswHarvester : cswHarvesters) {
            if (EntityCacheUtil.getResult(
                        CSWHarvesterModelImpl.ENTITY_CACHE_ENABLED,
                        CSWHarvesterImpl.class, cswHarvester.getPrimaryKey(),
                        this) == null) {
                cacheResult(cswHarvester);
            }
        }
    }

    /**
     * Clears the cache for all c s w harvesters.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    public void clearCache() {
        CacheRegistryUtil.clear(CSWHarvesterImpl.class.getName());
        EntityCacheUtil.clearCache(CSWHarvesterImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    /**
     * Clears the cache for the c s w harvester.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    public void clearCache(CSWHarvester cswHarvester) {
        EntityCacheUtil.removeResult(CSWHarvesterModelImpl.ENTITY_CACHE_ENABLED,
            CSWHarvesterImpl.class, cswHarvester.getPrimaryKey());
    }

    /**
     * Creates a new c s w harvester with the primary key. Does not add the c s w harvester to the database.
     *
     * @param cswharvesterid the primary key for the new c s w harvester
     * @return the new c s w harvester
     */
    public CSWHarvester create(long cswharvesterid) {
        CSWHarvester cswHarvester = new CSWHarvesterImpl();

        cswHarvester.setNew(true);
        cswHarvester.setPrimaryKey(cswharvesterid);

        return cswHarvester;
    }

    /**
     * Removes the c s w harvester with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the c s w harvester to remove
     * @return the c s w harvester that was removed
     * @throws com.liferay.portal.NoSuchModelException if a c s w harvester with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public CSWHarvester remove(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return remove(((Long) primaryKey).longValue());
    }

    /**
     * Removes the c s w harvester with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param cswharvesterid the primary key of the c s w harvester to remove
     * @return the c s w harvester that was removed
     * @throws nl.wur.alterra.cgi.ace.NoSuchCSWHarvesterException if a c s w harvester with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public CSWHarvester remove(long cswharvesterid)
        throws NoSuchCSWHarvesterException, SystemException {
        Session session = null;

        try {
            session = openSession();

            CSWHarvester cswHarvester = (CSWHarvester) session.get(CSWHarvesterImpl.class,
                    new Long(cswharvesterid));

            if (cswHarvester == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                        cswharvesterid);
                }

                throw new NoSuchCSWHarvesterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    cswharvesterid);
            }

            return remove(cswHarvester);
        } catch (NoSuchCSWHarvesterException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected CSWHarvester removeImpl(CSWHarvester cswHarvester)
        throws SystemException {
        cswHarvester = toUnwrappedModel(cswHarvester);

        Session session = null;

        try {
            session = openSession();

            if (cswHarvester.isCachedModel() || BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(CSWHarvesterImpl.class,
                        cswHarvester.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(cswHarvester);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(CSWHarvesterModelImpl.ENTITY_CACHE_ENABLED,
            CSWHarvesterImpl.class, cswHarvester.getPrimaryKey());

        return cswHarvester;
    }

    public CSWHarvester updateImpl(
        nl.wur.alterra.cgi.ace.model.CSWHarvester cswHarvester, boolean merge)
        throws SystemException {
        cswHarvester = toUnwrappedModel(cswHarvester);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, cswHarvester, merge);

            cswHarvester.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(CSWHarvesterModelImpl.ENTITY_CACHE_ENABLED,
            CSWHarvesterImpl.class, cswHarvester.getPrimaryKey(), cswHarvester);

        return cswHarvester;
    }

    protected CSWHarvester toUnwrappedModel(CSWHarvester cswHarvester) {
        if (cswHarvester instanceof CSWHarvesterImpl) {
            return cswHarvester;
        }

        CSWHarvesterImpl cswHarvesterImpl = new CSWHarvesterImpl();

        cswHarvesterImpl.setNew(cswHarvester.isNew());
        cswHarvesterImpl.setPrimaryKey(cswHarvester.getPrimaryKey());

        cswHarvesterImpl.setCswharvesterid(cswHarvester.getCswharvesterid());
        cswHarvesterImpl.setName(cswHarvester.getName());
        cswHarvesterImpl.setUrl(cswHarvester.getUrl());
        cswHarvesterImpl.setFreetext(cswHarvester.getFreetext());
        cswHarvesterImpl.setTitle(cswHarvester.getTitle());
        cswHarvesterImpl.setAbstrakt(cswHarvester.getAbstrakt());
        cswHarvesterImpl.setSubject(cswHarvester.getSubject());
        cswHarvesterImpl.setEvery(cswHarvester.getEvery());
        cswHarvesterImpl.setTopic(cswHarvester.getTopic());
        cswHarvesterImpl.setStatus(cswHarvester.getStatus());
        cswHarvesterImpl.setSavedToGeoNetwork(cswHarvester.isSavedToGeoNetwork());
        cswHarvesterImpl.setGeonetworkId(cswHarvester.getGeonetworkId());
        cswHarvesterImpl.setGeonetworkUUID(cswHarvester.getGeonetworkUUID());
        cswHarvesterImpl.setCompanyId(cswHarvester.getCompanyId());
        cswHarvesterImpl.setGroupId(cswHarvester.getGroupId());
        cswHarvesterImpl.setType(cswHarvester.getType());
        cswHarvesterImpl.setUsername(cswHarvester.getUsername());
        cswHarvesterImpl.setPassword(cswHarvester.getPassword());

        return cswHarvesterImpl;
    }

    /**
     * Finds the c s w harvester with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the c s w harvester to find
     * @return the c s w harvester
     * @throws com.liferay.portal.NoSuchModelException if a c s w harvester with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public CSWHarvester findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Finds the c s w harvester with the primary key or throws a {@link nl.wur.alterra.cgi.ace.NoSuchCSWHarvesterException} if it could not be found.
     *
     * @param cswharvesterid the primary key of the c s w harvester to find
     * @return the c s w harvester
     * @throws nl.wur.alterra.cgi.ace.NoSuchCSWHarvesterException if a c s w harvester with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public CSWHarvester findByPrimaryKey(long cswharvesterid)
        throws NoSuchCSWHarvesterException, SystemException {
        CSWHarvester cswHarvester = fetchByPrimaryKey(cswharvesterid);

        if (cswHarvester == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + cswharvesterid);
            }

            throw new NoSuchCSWHarvesterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                cswharvesterid);
        }

        return cswHarvester;
    }

    /**
     * Finds the c s w harvester with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the c s w harvester to find
     * @return the c s w harvester, or <code>null</code> if a c s w harvester with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public CSWHarvester fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Finds the c s w harvester with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param cswharvesterid the primary key of the c s w harvester to find
     * @return the c s w harvester, or <code>null</code> if a c s w harvester with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public CSWHarvester fetchByPrimaryKey(long cswharvesterid)
        throws SystemException {
        CSWHarvester cswHarvester = (CSWHarvester) EntityCacheUtil.getResult(CSWHarvesterModelImpl.ENTITY_CACHE_ENABLED,
                CSWHarvesterImpl.class, cswharvesterid, this);

        if (cswHarvester == null) {
            Session session = null;

            try {
                session = openSession();

                cswHarvester = (CSWHarvester) session.get(CSWHarvesterImpl.class,
                        new Long(cswharvesterid));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (cswHarvester != null) {
                    cacheResult(cswHarvester);
                }

                closeSession(session);
            }
        }

        return cswHarvester;
    }

    /**
     * Finds all the c s w harvesters where groupId = &#63;.
     *
     * @param groupId the group id to search with
     * @return the matching c s w harvesters
     * @throws SystemException if a system exception occurred
     */
    public List<CSWHarvester> findByGroupId(long groupId)
        throws SystemException {
        return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<CSWHarvester> findByGroupId(long groupId, int start, int end)
        throws SystemException {
        return findByGroupId(groupId, start, end, null);
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
    public List<CSWHarvester> findByGroupId(long groupId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        Object[] finderArgs = new Object[] {
                groupId,
                
                String.valueOf(start), String.valueOf(end),
                String.valueOf(orderByComparator)
            };

        List<CSWHarvester> list = (List<CSWHarvester>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_GROUPID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBundler query = null;

                if (orderByComparator != null) {
                    query = new StringBundler(3 +
                            (orderByComparator.getOrderByFields().length * 3));
                } else {
                    query = new StringBundler(3);
                }

                query.append(_SQL_SELECT_CSWHARVESTER_WHERE);

                query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

                if (orderByComparator != null) {
                    appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                        orderByComparator);
                }
                else {
                    query.append(CSWHarvesterModelImpl.ORDER_BY_JPQL);
                }

                String sql = query.toString();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                list = (List<CSWHarvester>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<CSWHarvester>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_GROUPID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
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
    public CSWHarvester findByGroupId_First(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchCSWHarvesterException, SystemException {
        List<CSWHarvester> list = findByGroupId(groupId, 0, 1, orderByComparator);

        if (list.isEmpty()) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("groupId=");
            msg.append(groupId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchCSWHarvesterException(msg.toString());
        } else {
            return list.get(0);
        }
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
    public CSWHarvester findByGroupId_Last(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchCSWHarvesterException, SystemException {
        int count = countByGroupId(groupId);

        List<CSWHarvester> list = findByGroupId(groupId, count - 1, count,
                orderByComparator);

        if (list.isEmpty()) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("groupId=");
            msg.append(groupId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchCSWHarvesterException(msg.toString());
        } else {
            return list.get(0);
        }
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
    public CSWHarvester[] findByGroupId_PrevAndNext(long cswharvesterid,
        long groupId, OrderByComparator orderByComparator)
        throws NoSuchCSWHarvesterException, SystemException {
        CSWHarvester cswHarvester = findByPrimaryKey(cswharvesterid);

        Session session = null;

        try {
            session = openSession();

            CSWHarvester[] array = new CSWHarvesterImpl[3];

            array[0] = getByGroupId_PrevAndNext(session, cswHarvester, groupId,
                    orderByComparator, true);

            array[1] = cswHarvester;

            array[2] = getByGroupId_PrevAndNext(session, cswHarvester, groupId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected CSWHarvester getByGroupId_PrevAndNext(Session session,
        CSWHarvester cswHarvester, long groupId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_CSWHARVESTER_WHERE);

        query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

        if (orderByComparator != null) {
            String[] orderByFields = orderByComparator.getOrderByFields();

            if (orderByFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        }
        else {
            query.append(CSWHarvesterModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByValues(cswHarvester);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<CSWHarvester> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Finds all the c s w harvesters.
     *
     * @return the c s w harvesters
     * @throws SystemException if a system exception occurred
     */
    public List<CSWHarvester> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<CSWHarvester> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
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
    public List<CSWHarvester> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end),
                String.valueOf(orderByComparator)
            };

        List<CSWHarvester> list = (List<CSWHarvester>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBundler query = null;
                String sql = null;

                if (orderByComparator != null) {
                    query = new StringBundler(2 +
                            (orderByComparator.getOrderByFields().length * 3));

                    query.append(_SQL_SELECT_CSWHARVESTER);

                    appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                        orderByComparator);

                    sql = query.toString();
                } else {
                    sql = _SQL_SELECT_CSWHARVESTER.concat(CSWHarvesterModelImpl.ORDER_BY_JPQL);
                }

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<CSWHarvester>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<CSWHarvester>) QueryUtil.list(q, getDialect(),
                            start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<CSWHarvester>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the c s w harvesters where groupId = &#63; from the database.
     *
     * @param groupId the group id to search with
     * @throws SystemException if a system exception occurred
     */
    public void removeByGroupId(long groupId) throws SystemException {
        for (CSWHarvester cswHarvester : findByGroupId(groupId)) {
            remove(cswHarvester);
        }
    }

    /**
     * Removes all the c s w harvesters from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (CSWHarvester cswHarvester : findAll()) {
            remove(cswHarvester);
        }
    }

    /**
     * Counts all the c s w harvesters where groupId = &#63;.
     *
     * @param groupId the group id to search with
     * @return the number of matching c s w harvesters
     * @throws SystemException if a system exception occurred
     */
    public int countByGroupId(long groupId) throws SystemException {
        Object[] finderArgs = new Object[] { groupId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBundler query = new StringBundler(2);

                query.append(_SQL_COUNT_CSWHARVESTER_WHERE);

                query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

                String sql = query.toString();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Counts all the c s w harvesters.
     *
     * @return the number of c s w harvesters
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Object[] finderArgs = new Object[0];

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_CSWHARVESTER);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL, finderArgs,
                    count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Initializes the c s w harvester persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.nl.wur.alterra.cgi.ace.model.CSWHarvester")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<CSWHarvester>> listenersList = new ArrayList<ModelListener<CSWHarvester>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<CSWHarvester>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
