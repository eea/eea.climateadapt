package nl.wur.alterra.cgi.ace.service.persistence;

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
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import nl.wur.alterra.cgi.ace.NoSuchCSWHarvesterException;
import nl.wur.alterra.cgi.ace.model.CSWHarvester;
import nl.wur.alterra.cgi.ace.model.impl.CSWHarvesterImpl;
import nl.wur.alterra.cgi.ace.model.impl.CSWHarvesterModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the c s w harvester service.
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
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link CSWHarvesterUtil} to access the c s w harvester persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = CSWHarvesterImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CSWHarvesterModelImpl.ENTITY_CACHE_ENABLED,
            CSWHarvesterModelImpl.FINDER_CACHE_ENABLED, CSWHarvesterImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CSWHarvesterModelImpl.ENTITY_CACHE_ENABLED,
            CSWHarvesterModelImpl.FINDER_CACHE_ENABLED, CSWHarvesterImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CSWHarvesterModelImpl.ENTITY_CACHE_ENABLED,
            CSWHarvesterModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(CSWHarvesterModelImpl.ENTITY_CACHE_ENABLED,
            CSWHarvesterModelImpl.FINDER_CACHE_ENABLED, CSWHarvesterImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
        new FinderPath(CSWHarvesterModelImpl.ENTITY_CACHE_ENABLED,
            CSWHarvesterModelImpl.FINDER_CACHE_ENABLED, CSWHarvesterImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
            new String[] { Long.class.getName() },
            CSWHarvesterModelImpl.GROUPID_COLUMN_BITMASK |
            CSWHarvesterModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(CSWHarvesterModelImpl.ENTITY_CACHE_ENABLED,
            CSWHarvesterModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "cswHarvester.groupId = ?";
    private static final String _SQL_SELECT_CSWHARVESTER = "SELECT cswHarvester FROM CSWHarvester cswHarvester";
    private static final String _SQL_SELECT_CSWHARVESTER_WHERE = "SELECT cswHarvester FROM CSWHarvester cswHarvester WHERE ";
    private static final String _SQL_COUNT_CSWHARVESTER = "SELECT COUNT(cswHarvester) FROM CSWHarvester cswHarvester";
    private static final String _SQL_COUNT_CSWHARVESTER_WHERE = "SELECT COUNT(cswHarvester) FROM CSWHarvester cswHarvester WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "cswHarvester.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CSWHarvester exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CSWHarvester exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(CSWHarvesterPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "type", "password"
            });
    private static CSWHarvester _nullCSWHarvester = new CSWHarvesterImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<CSWHarvester> toCacheModel() {
                return _nullCSWHarvesterCacheModel;
            }
        };

    private static CacheModel<CSWHarvester> _nullCSWHarvesterCacheModel = new CacheModel<CSWHarvester>() {
            @Override
            public CSWHarvester toEntityModel() {
                return _nullCSWHarvester;
            }
        };

    public CSWHarvesterPersistenceImpl() {
        setModelClass(CSWHarvester.class);
    }

    /**
     * Returns all the c s w harvesters where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the matching c s w harvesters
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<CSWHarvester> findByGroupId(long groupId)
        throws SystemException {
        return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<CSWHarvester> findByGroupId(long groupId, int start, int end)
        throws SystemException {
        return findByGroupId(groupId, start, end, null);
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
    @Override
    public List<CSWHarvester> findByGroupId(long groupId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
            finderArgs = new Object[] { groupId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
            finderArgs = new Object[] { groupId, start, end, orderByComparator };
        }

        List<CSWHarvester> list = (List<CSWHarvester>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (CSWHarvester cswHarvester : list) {
                if ((groupId != cswHarvester.getGroupId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
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
            } else
             if (pagination) {
                query.append(CSWHarvesterModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                if (!pagination) {
                    list = (List<CSWHarvester>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<CSWHarvester>(list);
                } else {
                    list = (List<CSWHarvester>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public CSWHarvester findByGroupId_First(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchCSWHarvesterException, SystemException {
        CSWHarvester cswHarvester = fetchByGroupId_First(groupId,
                orderByComparator);

        if (cswHarvester != null) {
            return cswHarvester;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchCSWHarvesterException(msg.toString());
    }

    /**
     * Returns the first c s w harvester in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching c s w harvester, or <code>null</code> if a matching c s w harvester could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public CSWHarvester fetchByGroupId_First(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        List<CSWHarvester> list = findByGroupId(groupId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public CSWHarvester findByGroupId_Last(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchCSWHarvesterException, SystemException {
        CSWHarvester cswHarvester = fetchByGroupId_Last(groupId,
                orderByComparator);

        if (cswHarvester != null) {
            return cswHarvester;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchCSWHarvesterException(msg.toString());
    }

    /**
     * Returns the last c s w harvester in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching c s w harvester, or <code>null</code> if a matching c s w harvester could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public CSWHarvester fetchByGroupId_Last(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByGroupId(groupId);

        if (count == 0) {
            return null;
        }

        List<CSWHarvester> list = findByGroupId(groupId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
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
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
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

            String[] orderByFields = orderByComparator.getOrderByFields();

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
        } else {
            query.append(CSWHarvesterModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(cswHarvester);

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
     * Removes all the c s w harvesters where groupId = &#63; from the database.
     *
     * @param groupId the group ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByGroupId(long groupId) throws SystemException {
        for (CSWHarvester cswHarvester : findByGroupId(groupId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(cswHarvester);
        }
    }

    /**
     * Returns the number of c s w harvesters where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the number of matching c s w harvesters
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByGroupId(long groupId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

        Object[] finderArgs = new Object[] { groupId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_CSWHARVESTER_WHERE);

            query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the c s w harvester in the entity cache if it is enabled.
     *
     * @param cswHarvester the c s w harvester
     */
    @Override
    public void cacheResult(CSWHarvester cswHarvester) {
        EntityCacheUtil.putResult(CSWHarvesterModelImpl.ENTITY_CACHE_ENABLED,
            CSWHarvesterImpl.class, cswHarvester.getPrimaryKey(), cswHarvester);

        cswHarvester.resetOriginalValues();
    }

    /**
     * Caches the c s w harvesters in the entity cache if it is enabled.
     *
     * @param cswHarvesters the c s w harvesters
     */
    @Override
    public void cacheResult(List<CSWHarvester> cswHarvesters) {
        for (CSWHarvester cswHarvester : cswHarvesters) {
            if (EntityCacheUtil.getResult(
                        CSWHarvesterModelImpl.ENTITY_CACHE_ENABLED,
                        CSWHarvesterImpl.class, cswHarvester.getPrimaryKey()) == null) {
                cacheResult(cswHarvester);
            } else {
                cswHarvester.resetOriginalValues();
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
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(CSWHarvesterImpl.class.getName());
        }

        EntityCacheUtil.clearCache(CSWHarvesterImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the c s w harvester.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(CSWHarvester cswHarvester) {
        EntityCacheUtil.removeResult(CSWHarvesterModelImpl.ENTITY_CACHE_ENABLED,
            CSWHarvesterImpl.class, cswHarvester.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<CSWHarvester> cswHarvesters) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (CSWHarvester cswHarvester : cswHarvesters) {
            EntityCacheUtil.removeResult(CSWHarvesterModelImpl.ENTITY_CACHE_ENABLED,
                CSWHarvesterImpl.class, cswHarvester.getPrimaryKey());
        }
    }

    /**
     * Creates a new c s w harvester with the primary key. Does not add the c s w harvester to the database.
     *
     * @param cswharvesterid the primary key for the new c s w harvester
     * @return the new c s w harvester
     */
    @Override
    public CSWHarvester create(long cswharvesterid) {
        CSWHarvester cswHarvester = new CSWHarvesterImpl();

        cswHarvester.setNew(true);
        cswHarvester.setPrimaryKey(cswharvesterid);

        return cswHarvester;
    }

    /**
     * Removes the c s w harvester with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param cswharvesterid the primary key of the c s w harvester
     * @return the c s w harvester that was removed
     * @throws nl.wur.alterra.cgi.ace.NoSuchCSWHarvesterException if a c s w harvester with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public CSWHarvester remove(long cswharvesterid)
        throws NoSuchCSWHarvesterException, SystemException {
        return remove((Serializable) cswharvesterid);
    }

    /**
     * Removes the c s w harvester with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the c s w harvester
     * @return the c s w harvester that was removed
     * @throws nl.wur.alterra.cgi.ace.NoSuchCSWHarvesterException if a c s w harvester with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public CSWHarvester remove(Serializable primaryKey)
        throws NoSuchCSWHarvesterException, SystemException {
        Session session = null;

        try {
            session = openSession();

            CSWHarvester cswHarvester = (CSWHarvester) session.get(CSWHarvesterImpl.class,
                    primaryKey);

            if (cswHarvester == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchCSWHarvesterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
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

    @Override
    protected CSWHarvester removeImpl(CSWHarvester cswHarvester)
        throws SystemException {
        cswHarvester = toUnwrappedModel(cswHarvester);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(cswHarvester)) {
                cswHarvester = (CSWHarvester) session.get(CSWHarvesterImpl.class,
                        cswHarvester.getPrimaryKeyObj());
            }

            if (cswHarvester != null) {
                session.delete(cswHarvester);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (cswHarvester != null) {
            clearCache(cswHarvester);
        }

        return cswHarvester;
    }

    @Override
    public CSWHarvester updateImpl(
        nl.wur.alterra.cgi.ace.model.CSWHarvester cswHarvester)
        throws SystemException {
        cswHarvester = toUnwrappedModel(cswHarvester);

        boolean isNew = cswHarvester.isNew();

        CSWHarvesterModelImpl cswHarvesterModelImpl = (CSWHarvesterModelImpl) cswHarvester;

        Session session = null;

        try {
            session = openSession();

            if (cswHarvester.isNew()) {
                session.save(cswHarvester);

                cswHarvester.setNew(false);
            } else {
                session.merge(cswHarvester);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !CSWHarvesterModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((cswHarvesterModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        cswHarvesterModelImpl.getOriginalGroupId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);

                args = new Object[] { cswHarvesterModelImpl.getGroupId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);
            }
        }

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
     * Returns the c s w harvester with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the c s w harvester
     * @return the c s w harvester
     * @throws nl.wur.alterra.cgi.ace.NoSuchCSWHarvesterException if a c s w harvester with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public CSWHarvester findByPrimaryKey(Serializable primaryKey)
        throws NoSuchCSWHarvesterException, SystemException {
        CSWHarvester cswHarvester = fetchByPrimaryKey(primaryKey);

        if (cswHarvester == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchCSWHarvesterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return cswHarvester;
    }

    /**
     * Returns the c s w harvester with the primary key or throws a {@link nl.wur.alterra.cgi.ace.NoSuchCSWHarvesterException} if it could not be found.
     *
     * @param cswharvesterid the primary key of the c s w harvester
     * @return the c s w harvester
     * @throws nl.wur.alterra.cgi.ace.NoSuchCSWHarvesterException if a c s w harvester with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public CSWHarvester findByPrimaryKey(long cswharvesterid)
        throws NoSuchCSWHarvesterException, SystemException {
        return findByPrimaryKey((Serializable) cswharvesterid);
    }

    /**
     * Returns the c s w harvester with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the c s w harvester
     * @return the c s w harvester, or <code>null</code> if a c s w harvester with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public CSWHarvester fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        CSWHarvester cswHarvester = (CSWHarvester) EntityCacheUtil.getResult(CSWHarvesterModelImpl.ENTITY_CACHE_ENABLED,
                CSWHarvesterImpl.class, primaryKey);

        if (cswHarvester == _nullCSWHarvester) {
            return null;
        }

        if (cswHarvester == null) {
            Session session = null;

            try {
                session = openSession();

                cswHarvester = (CSWHarvester) session.get(CSWHarvesterImpl.class,
                        primaryKey);

                if (cswHarvester != null) {
                    cacheResult(cswHarvester);
                } else {
                    EntityCacheUtil.putResult(CSWHarvesterModelImpl.ENTITY_CACHE_ENABLED,
                        CSWHarvesterImpl.class, primaryKey, _nullCSWHarvester);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(CSWHarvesterModelImpl.ENTITY_CACHE_ENABLED,
                    CSWHarvesterImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return cswHarvester;
    }

    /**
     * Returns the c s w harvester with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param cswharvesterid the primary key of the c s w harvester
     * @return the c s w harvester, or <code>null</code> if a c s w harvester with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public CSWHarvester fetchByPrimaryKey(long cswharvesterid)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) cswharvesterid);
    }

    /**
     * Returns all the c s w harvesters.
     *
     * @return the c s w harvesters
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<CSWHarvester> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<CSWHarvester> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
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
    @Override
    public List<CSWHarvester> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<CSWHarvester> list = (List<CSWHarvester>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
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
                sql = _SQL_SELECT_CSWHARVESTER;

                if (pagination) {
                    sql = sql.concat(CSWHarvesterModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<CSWHarvester>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<CSWHarvester>(list);
                } else {
                    list = (List<CSWHarvester>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the c s w harvesters from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (CSWHarvester cswHarvester : findAll()) {
            remove(cswHarvester);
        }
    }

    /**
     * Returns the number of c s w harvesters.
     *
     * @return the number of c s w harvesters
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_CSWHARVESTER);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    @Override
    protected Set<String> getBadColumnNames() {
        return _badColumnNames;
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
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(CSWHarvesterImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
