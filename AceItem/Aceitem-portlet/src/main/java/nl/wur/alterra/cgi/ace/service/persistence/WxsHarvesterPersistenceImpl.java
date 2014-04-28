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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import nl.wur.alterra.cgi.ace.NoSuchWxsHarvesterException;
import nl.wur.alterra.cgi.ace.model.WxsHarvester;
import nl.wur.alterra.cgi.ace.model.impl.WxsHarvesterImpl;
import nl.wur.alterra.cgi.ace.model.impl.WxsHarvesterModelImpl;
import nl.wur.alterra.cgi.ace.service.persistence.WxsHarvesterPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the wxs harvester service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author groot052
 * @see WxsHarvesterPersistence
 * @see WxsHarvesterUtil
 * @generated
 */
public class WxsHarvesterPersistenceImpl extends BasePersistenceImpl<WxsHarvester>
    implements WxsHarvesterPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link WxsHarvesterUtil} to access the wxs harvester persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = WxsHarvesterImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WxsHarvesterModelImpl.ENTITY_CACHE_ENABLED,
            WxsHarvesterModelImpl.FINDER_CACHE_ENABLED, WxsHarvesterImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WxsHarvesterModelImpl.ENTITY_CACHE_ENABLED,
            WxsHarvesterModelImpl.FINDER_CACHE_ENABLED, WxsHarvesterImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WxsHarvesterModelImpl.ENTITY_CACHE_ENABLED,
            WxsHarvesterModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(WxsHarvesterModelImpl.ENTITY_CACHE_ENABLED,
            WxsHarvesterModelImpl.FINDER_CACHE_ENABLED, WxsHarvesterImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
        new FinderPath(WxsHarvesterModelImpl.ENTITY_CACHE_ENABLED,
            WxsHarvesterModelImpl.FINDER_CACHE_ENABLED, WxsHarvesterImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
            new String[] { Long.class.getName() },
            WxsHarvesterModelImpl.GROUPID_COLUMN_BITMASK |
            WxsHarvesterModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(WxsHarvesterModelImpl.ENTITY_CACHE_ENABLED,
            WxsHarvesterModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "wxsHarvester.groupId = ?";
    private static final String _SQL_SELECT_WXSHARVESTER = "SELECT wxsHarvester FROM WxsHarvester wxsHarvester";
    private static final String _SQL_SELECT_WXSHARVESTER_WHERE = "SELECT wxsHarvester FROM WxsHarvester wxsHarvester WHERE ";
    private static final String _SQL_COUNT_WXSHARVESTER = "SELECT COUNT(wxsHarvester) FROM WxsHarvester wxsHarvester";
    private static final String _SQL_COUNT_WXSHARVESTER_WHERE = "SELECT COUNT(wxsHarvester) FROM WxsHarvester wxsHarvester WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "wxsHarvester.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WxsHarvester exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No WxsHarvester exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(WxsHarvesterPersistenceImpl.class);
    private static WxsHarvester _nullWxsHarvester = new WxsHarvesterImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<WxsHarvester> toCacheModel() {
                return _nullWxsHarvesterCacheModel;
            }
        };

    private static CacheModel<WxsHarvester> _nullWxsHarvesterCacheModel = new CacheModel<WxsHarvester>() {
            @Override
            public WxsHarvester toEntityModel() {
                return _nullWxsHarvester;
            }
        };

    public WxsHarvesterPersistenceImpl() {
        setModelClass(WxsHarvester.class);
    }

    /**
     * Returns all the wxs harvesters where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the matching wxs harvesters
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<WxsHarvester> findByGroupId(long groupId)
        throws SystemException {
        return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

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
    @Override
    public List<WxsHarvester> findByGroupId(long groupId, int start, int end)
        throws SystemException {
        return findByGroupId(groupId, start, end, null);
    }

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
    @Override
    public List<WxsHarvester> findByGroupId(long groupId, int start, int end,
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

        List<WxsHarvester> list = (List<WxsHarvester>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (WxsHarvester wxsHarvester : list) {
                if ((groupId != wxsHarvester.getGroupId())) {
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

            query.append(_SQL_SELECT_WXSHARVESTER_WHERE);

            query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(WxsHarvesterModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                if (!pagination) {
                    list = (List<WxsHarvester>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<WxsHarvester>(list);
                } else {
                    list = (List<WxsHarvester>) QueryUtil.list(q, getDialect(),
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
     * Returns the first wxs harvester in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching wxs harvester
     * @throws nl.wur.alterra.cgi.ace.NoSuchWxsHarvesterException if a matching wxs harvester could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public WxsHarvester findByGroupId_First(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchWxsHarvesterException, SystemException {
        WxsHarvester wxsHarvester = fetchByGroupId_First(groupId,
                orderByComparator);

        if (wxsHarvester != null) {
            return wxsHarvester;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchWxsHarvesterException(msg.toString());
    }

    /**
     * Returns the first wxs harvester in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching wxs harvester, or <code>null</code> if a matching wxs harvester could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public WxsHarvester fetchByGroupId_First(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        List<WxsHarvester> list = findByGroupId(groupId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last wxs harvester in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching wxs harvester
     * @throws nl.wur.alterra.cgi.ace.NoSuchWxsHarvesterException if a matching wxs harvester could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public WxsHarvester findByGroupId_Last(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchWxsHarvesterException, SystemException {
        WxsHarvester wxsHarvester = fetchByGroupId_Last(groupId,
                orderByComparator);

        if (wxsHarvester != null) {
            return wxsHarvester;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchWxsHarvesterException(msg.toString());
    }

    /**
     * Returns the last wxs harvester in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching wxs harvester, or <code>null</code> if a matching wxs harvester could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public WxsHarvester fetchByGroupId_Last(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByGroupId(groupId);

        if (count == 0) {
            return null;
        }

        List<WxsHarvester> list = findByGroupId(groupId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

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
    @Override
    public WxsHarvester[] findByGroupId_PrevAndNext(long wxsharvesterid,
        long groupId, OrderByComparator orderByComparator)
        throws NoSuchWxsHarvesterException, SystemException {
        WxsHarvester wxsHarvester = findByPrimaryKey(wxsharvesterid);

        Session session = null;

        try {
            session = openSession();

            WxsHarvester[] array = new WxsHarvesterImpl[3];

            array[0] = getByGroupId_PrevAndNext(session, wxsHarvester, groupId,
                    orderByComparator, true);

            array[1] = wxsHarvester;

            array[2] = getByGroupId_PrevAndNext(session, wxsHarvester, groupId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected WxsHarvester getByGroupId_PrevAndNext(Session session,
        WxsHarvester wxsHarvester, long groupId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_WXSHARVESTER_WHERE);

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
            query.append(WxsHarvesterModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(wxsHarvester);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<WxsHarvester> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the wxs harvesters where groupId = &#63; from the database.
     *
     * @param groupId the group ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByGroupId(long groupId) throws SystemException {
        for (WxsHarvester wxsHarvester : findByGroupId(groupId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(wxsHarvester);
        }
    }

    /**
     * Returns the number of wxs harvesters where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the number of matching wxs harvesters
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

            query.append(_SQL_COUNT_WXSHARVESTER_WHERE);

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
     * Caches the wxs harvester in the entity cache if it is enabled.
     *
     * @param wxsHarvester the wxs harvester
     */
    @Override
    public void cacheResult(WxsHarvester wxsHarvester) {
        EntityCacheUtil.putResult(WxsHarvesterModelImpl.ENTITY_CACHE_ENABLED,
            WxsHarvesterImpl.class, wxsHarvester.getPrimaryKey(), wxsHarvester);

        wxsHarvester.resetOriginalValues();
    }

    /**
     * Caches the wxs harvesters in the entity cache if it is enabled.
     *
     * @param wxsHarvesters the wxs harvesters
     */
    @Override
    public void cacheResult(List<WxsHarvester> wxsHarvesters) {
        for (WxsHarvester wxsHarvester : wxsHarvesters) {
            if (EntityCacheUtil.getResult(
                        WxsHarvesterModelImpl.ENTITY_CACHE_ENABLED,
                        WxsHarvesterImpl.class, wxsHarvester.getPrimaryKey()) == null) {
                cacheResult(wxsHarvester);
            } else {
                wxsHarvester.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all wxs harvesters.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(WxsHarvesterImpl.class.getName());
        }

        EntityCacheUtil.clearCache(WxsHarvesterImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the wxs harvester.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(WxsHarvester wxsHarvester) {
        EntityCacheUtil.removeResult(WxsHarvesterModelImpl.ENTITY_CACHE_ENABLED,
            WxsHarvesterImpl.class, wxsHarvester.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<WxsHarvester> wxsHarvesters) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (WxsHarvester wxsHarvester : wxsHarvesters) {
            EntityCacheUtil.removeResult(WxsHarvesterModelImpl.ENTITY_CACHE_ENABLED,
                WxsHarvesterImpl.class, wxsHarvester.getPrimaryKey());
        }
    }

    /**
     * Creates a new wxs harvester with the primary key. Does not add the wxs harvester to the database.
     *
     * @param wxsharvesterid the primary key for the new wxs harvester
     * @return the new wxs harvester
     */
    @Override
    public WxsHarvester create(long wxsharvesterid) {
        WxsHarvester wxsHarvester = new WxsHarvesterImpl();

        wxsHarvester.setNew(true);
        wxsHarvester.setPrimaryKey(wxsharvesterid);

        return wxsHarvester;
    }

    /**
     * Removes the wxs harvester with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param wxsharvesterid the primary key of the wxs harvester
     * @return the wxs harvester that was removed
     * @throws nl.wur.alterra.cgi.ace.NoSuchWxsHarvesterException if a wxs harvester with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public WxsHarvester remove(long wxsharvesterid)
        throws NoSuchWxsHarvesterException, SystemException {
        return remove((Serializable) wxsharvesterid);
    }

    /**
     * Removes the wxs harvester with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the wxs harvester
     * @return the wxs harvester that was removed
     * @throws nl.wur.alterra.cgi.ace.NoSuchWxsHarvesterException if a wxs harvester with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public WxsHarvester remove(Serializable primaryKey)
        throws NoSuchWxsHarvesterException, SystemException {
        Session session = null;

        try {
            session = openSession();

            WxsHarvester wxsHarvester = (WxsHarvester) session.get(WxsHarvesterImpl.class,
                    primaryKey);

            if (wxsHarvester == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchWxsHarvesterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(wxsHarvester);
        } catch (NoSuchWxsHarvesterException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected WxsHarvester removeImpl(WxsHarvester wxsHarvester)
        throws SystemException {
        wxsHarvester = toUnwrappedModel(wxsHarvester);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(wxsHarvester)) {
                wxsHarvester = (WxsHarvester) session.get(WxsHarvesterImpl.class,
                        wxsHarvester.getPrimaryKeyObj());
            }

            if (wxsHarvester != null) {
                session.delete(wxsHarvester);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (wxsHarvester != null) {
            clearCache(wxsHarvester);
        }

        return wxsHarvester;
    }

    @Override
    public WxsHarvester updateImpl(
        nl.wur.alterra.cgi.ace.model.WxsHarvester wxsHarvester)
        throws SystemException {
        wxsHarvester = toUnwrappedModel(wxsHarvester);

        boolean isNew = wxsHarvester.isNew();

        WxsHarvesterModelImpl wxsHarvesterModelImpl = (WxsHarvesterModelImpl) wxsHarvester;

        Session session = null;

        try {
            session = openSession();

            if (wxsHarvester.isNew()) {
                session.save(wxsHarvester);

                wxsHarvester.setNew(false);
            } else {
                session.merge(wxsHarvester);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !WxsHarvesterModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((wxsHarvesterModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        wxsHarvesterModelImpl.getOriginalGroupId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);

                args = new Object[] { wxsHarvesterModelImpl.getGroupId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);
            }
        }

        EntityCacheUtil.putResult(WxsHarvesterModelImpl.ENTITY_CACHE_ENABLED,
            WxsHarvesterImpl.class, wxsHarvester.getPrimaryKey(), wxsHarvester);

        return wxsHarvester;
    }

    protected WxsHarvester toUnwrappedModel(WxsHarvester wxsHarvester) {
        if (wxsHarvester instanceof WxsHarvesterImpl) {
            return wxsHarvester;
        }

        WxsHarvesterImpl wxsHarvesterImpl = new WxsHarvesterImpl();

        wxsHarvesterImpl.setNew(wxsHarvester.isNew());
        wxsHarvesterImpl.setPrimaryKey(wxsHarvester.getPrimaryKey());

        wxsHarvesterImpl.setWxsharvesterid(wxsHarvester.getWxsharvesterid());
        wxsHarvesterImpl.setName(wxsHarvester.getName());
        wxsHarvesterImpl.setUrl(wxsHarvester.getUrl());
        wxsHarvesterImpl.setOgctype(wxsHarvester.getOgctype());
        wxsHarvesterImpl.setEvery(wxsHarvester.getEvery());
        wxsHarvesterImpl.setTopic(wxsHarvester.getTopic());
        wxsHarvesterImpl.setStatus(wxsHarvester.getStatus());
        wxsHarvesterImpl.setSavedToGeoNetwork(wxsHarvester.isSavedToGeoNetwork());
        wxsHarvesterImpl.setGeonetworkId(wxsHarvester.getGeonetworkId());
        wxsHarvesterImpl.setGeonetworkUUID(wxsHarvester.getGeonetworkUUID());
        wxsHarvesterImpl.setCompanyId(wxsHarvester.getCompanyId());
        wxsHarvesterImpl.setGroupId(wxsHarvester.getGroupId());

        return wxsHarvesterImpl;
    }

    /**
     * Returns the wxs harvester with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the wxs harvester
     * @return the wxs harvester
     * @throws nl.wur.alterra.cgi.ace.NoSuchWxsHarvesterException if a wxs harvester with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public WxsHarvester findByPrimaryKey(Serializable primaryKey)
        throws NoSuchWxsHarvesterException, SystemException {
        WxsHarvester wxsHarvester = fetchByPrimaryKey(primaryKey);

        if (wxsHarvester == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchWxsHarvesterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return wxsHarvester;
    }

    /**
     * Returns the wxs harvester with the primary key or throws a {@link nl.wur.alterra.cgi.ace.NoSuchWxsHarvesterException} if it could not be found.
     *
     * @param wxsharvesterid the primary key of the wxs harvester
     * @return the wxs harvester
     * @throws nl.wur.alterra.cgi.ace.NoSuchWxsHarvesterException if a wxs harvester with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public WxsHarvester findByPrimaryKey(long wxsharvesterid)
        throws NoSuchWxsHarvesterException, SystemException {
        return findByPrimaryKey((Serializable) wxsharvesterid);
    }

    /**
     * Returns the wxs harvester with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the wxs harvester
     * @return the wxs harvester, or <code>null</code> if a wxs harvester with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public WxsHarvester fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        WxsHarvester wxsHarvester = (WxsHarvester) EntityCacheUtil.getResult(WxsHarvesterModelImpl.ENTITY_CACHE_ENABLED,
                WxsHarvesterImpl.class, primaryKey);

        if (wxsHarvester == _nullWxsHarvester) {
            return null;
        }

        if (wxsHarvester == null) {
            Session session = null;

            try {
                session = openSession();

                wxsHarvester = (WxsHarvester) session.get(WxsHarvesterImpl.class,
                        primaryKey);

                if (wxsHarvester != null) {
                    cacheResult(wxsHarvester);
                } else {
                    EntityCacheUtil.putResult(WxsHarvesterModelImpl.ENTITY_CACHE_ENABLED,
                        WxsHarvesterImpl.class, primaryKey, _nullWxsHarvester);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(WxsHarvesterModelImpl.ENTITY_CACHE_ENABLED,
                    WxsHarvesterImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return wxsHarvester;
    }

    /**
     * Returns the wxs harvester with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param wxsharvesterid the primary key of the wxs harvester
     * @return the wxs harvester, or <code>null</code> if a wxs harvester with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public WxsHarvester fetchByPrimaryKey(long wxsharvesterid)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) wxsharvesterid);
    }

    /**
     * Returns all the wxs harvesters.
     *
     * @return the wxs harvesters
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<WxsHarvester> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

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
    @Override
    public List<WxsHarvester> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

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
    @Override
    public List<WxsHarvester> findAll(int start, int end,
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

        List<WxsHarvester> list = (List<WxsHarvester>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_WXSHARVESTER);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_WXSHARVESTER;

                if (pagination) {
                    sql = sql.concat(WxsHarvesterModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<WxsHarvester>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<WxsHarvester>(list);
                } else {
                    list = (List<WxsHarvester>) QueryUtil.list(q, getDialect(),
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
     * Removes all the wxs harvesters from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (WxsHarvester wxsHarvester : findAll()) {
            remove(wxsHarvester);
        }
    }

    /**
     * Returns the number of wxs harvesters.
     *
     * @return the number of wxs harvesters
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

                Query q = session.createQuery(_SQL_COUNT_WXSHARVESTER);

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

    /**
     * Initializes the wxs harvester persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.nl.wur.alterra.cgi.ace.model.WxsHarvester")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<WxsHarvester>> listenersList = new ArrayList<ModelListener<WxsHarvester>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<WxsHarvester>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(WxsHarvesterImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
