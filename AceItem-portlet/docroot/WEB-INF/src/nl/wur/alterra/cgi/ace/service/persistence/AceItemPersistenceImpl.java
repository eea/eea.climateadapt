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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import nl.wur.alterra.cgi.ace.NoSuchItemException;
import nl.wur.alterra.cgi.ace.model.AceItem;
import nl.wur.alterra.cgi.ace.model.impl.AceItemImpl;
import nl.wur.alterra.cgi.ace.model.impl.AceItemModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the ace item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author groot052
 * @see AceItemPersistence
 * @see AceItemUtil
 * @generated
 */
public class AceItemPersistenceImpl extends BasePersistenceImpl<AceItem>
    implements AceItemPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link AceItemUtil} to access the ace item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = AceItemImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AceItemModelImpl.ENTITY_CACHE_ENABLED,
            AceItemModelImpl.FINDER_CACHE_ENABLED, AceItemImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AceItemModelImpl.ENTITY_CACHE_ENABLED,
            AceItemModelImpl.FINDER_CACHE_ENABLED, AceItemImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AceItemModelImpl.ENTITY_CACHE_ENABLED,
            AceItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(AceItemModelImpl.ENTITY_CACHE_ENABLED,
            AceItemModelImpl.FINDER_CACHE_ENABLED, AceItemImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
        new FinderPath(AceItemModelImpl.ENTITY_CACHE_ENABLED,
            AceItemModelImpl.FINDER_CACHE_ENABLED, AceItemImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
            new String[] { Long.class.getName() },
            AceItemModelImpl.GROUPID_COLUMN_BITMASK |
            AceItemModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(AceItemModelImpl.ENTITY_CACHE_ENABLED,
            AceItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "aceItem.groupId = ?";
    public static final FinderPath FINDER_PATH_FETCH_BY_STOREDAT = new FinderPath(AceItemModelImpl.ENTITY_CACHE_ENABLED,
            AceItemModelImpl.FINDER_CACHE_ENABLED, AceItemImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByStoredAt",
            new String[] { String.class.getName() },
            AceItemModelImpl.STOREDAT_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_STOREDAT = new FinderPath(AceItemModelImpl.ENTITY_CACHE_ENABLED,
            AceItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStoredAt",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_STOREDAT_STOREDAT_1 = "aceItem.storedAt IS NULL";
    private static final String _FINDER_COLUMN_STOREDAT_STOREDAT_2 = "aceItem.storedAt = ?";
    private static final String _FINDER_COLUMN_STOREDAT_STOREDAT_3 = "(aceItem.storedAt IS NULL OR aceItem.storedAt = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_WXSHARVESTERID =
        new FinderPath(AceItemModelImpl.ENTITY_CACHE_ENABLED,
            AceItemModelImpl.FINDER_CACHE_ENABLED, AceItemImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByWxsharvesterId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WXSHARVESTERID =
        new FinderPath(AceItemModelImpl.ENTITY_CACHE_ENABLED,
            AceItemModelImpl.FINDER_CACHE_ENABLED, AceItemImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByWxsharvesterId",
            new String[] { Long.class.getName() },
            AceItemModelImpl.WXSHARVESTERID_COLUMN_BITMASK |
            AceItemModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_WXSHARVESTERID = new FinderPath(AceItemModelImpl.ENTITY_CACHE_ENABLED,
            AceItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByWxsharvesterId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_WXSHARVESTERID_WXSHARVESTERID_2 = "aceItem.wxsharvesterId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CSWHARVESTERID =
        new FinderPath(AceItemModelImpl.ENTITY_CACHE_ENABLED,
            AceItemModelImpl.FINDER_CACHE_ENABLED, AceItemImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCSWharvesterId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CSWHARVESTERID =
        new FinderPath(AceItemModelImpl.ENTITY_CACHE_ENABLED,
            AceItemModelImpl.FINDER_CACHE_ENABLED, AceItemImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCSWharvesterId",
            new String[] { Long.class.getName() },
            AceItemModelImpl.CSWHARVESTERID_COLUMN_BITMASK |
            AceItemModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CSWHARVESTERID = new FinderPath(AceItemModelImpl.ENTITY_CACHE_ENABLED,
            AceItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCSWharvesterId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_CSWHARVESTERID_CSWHARVESTERID_2 = "aceItem.cswharvesterId = ?";
    private static final String _SQL_SELECT_ACEITEM = "SELECT aceItem FROM AceItem aceItem";
    private static final String _SQL_SELECT_ACEITEM_WHERE = "SELECT aceItem FROM AceItem aceItem WHERE ";
    private static final String _SQL_COUNT_ACEITEM = "SELECT COUNT(aceItem) FROM AceItem aceItem";
    private static final String _SQL_COUNT_ACEITEM_WHERE = "SELECT COUNT(aceItem) FROM AceItem aceItem WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "aceItem.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AceItem exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AceItem exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(AceItemPersistenceImpl.class);
    private static AceItem _nullAceItem = new AceItemImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<AceItem> toCacheModel() {
                return _nullAceItemCacheModel;
            }
        };

    private static CacheModel<AceItem> _nullAceItemCacheModel = new CacheModel<AceItem>() {
            @Override
            public AceItem toEntityModel() {
                return _nullAceItem;
            }
        };

    public AceItemPersistenceImpl() {
        setModelClass(AceItem.class);
    }

    /**
     * Returns all the ace items where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the matching ace items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AceItem> findByGroupId(long groupId) throws SystemException {
        return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<AceItem> findByGroupId(long groupId, int start, int end)
        throws SystemException {
        return findByGroupId(groupId, start, end, null);
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
    @Override
    public List<AceItem> findByGroupId(long groupId, int start, int end,
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

        List<AceItem> list = (List<AceItem>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (AceItem aceItem : list) {
                if ((groupId != aceItem.getGroupId())) {
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

            query.append(_SQL_SELECT_ACEITEM_WHERE);

            query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(AceItemModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                if (!pagination) {
                    list = (List<AceItem>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<AceItem>(list);
                } else {
                    list = (List<AceItem>) QueryUtil.list(q, getDialect(),
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
     * Returns the first ace item in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching ace item
     * @throws nl.wur.alterra.cgi.ace.NoSuchItemException if a matching ace item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AceItem findByGroupId_First(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchItemException, SystemException {
        AceItem aceItem = fetchByGroupId_First(groupId, orderByComparator);

        if (aceItem != null) {
            return aceItem;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchItemException(msg.toString());
    }

    /**
     * Returns the first ace item in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching ace item, or <code>null</code> if a matching ace item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AceItem fetchByGroupId_First(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        List<AceItem> list = findByGroupId(groupId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public AceItem findByGroupId_Last(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchItemException, SystemException {
        AceItem aceItem = fetchByGroupId_Last(groupId, orderByComparator);

        if (aceItem != null) {
            return aceItem;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchItemException(msg.toString());
    }

    /**
     * Returns the last ace item in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching ace item, or <code>null</code> if a matching ace item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AceItem fetchByGroupId_Last(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByGroupId(groupId);

        if (count == 0) {
            return null;
        }

        List<AceItem> list = findByGroupId(groupId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public AceItem[] findByGroupId_PrevAndNext(long aceItemId, long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchItemException, SystemException {
        AceItem aceItem = findByPrimaryKey(aceItemId);

        Session session = null;

        try {
            session = openSession();

            AceItem[] array = new AceItemImpl[3];

            array[0] = getByGroupId_PrevAndNext(session, aceItem, groupId,
                    orderByComparator, true);

            array[1] = aceItem;

            array[2] = getByGroupId_PrevAndNext(session, aceItem, groupId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected AceItem getByGroupId_PrevAndNext(Session session,
        AceItem aceItem, long groupId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_ACEITEM_WHERE);

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
            query.append(AceItemModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(aceItem);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<AceItem> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the ace items where groupId = &#63; from the database.
     *
     * @param groupId the group ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByGroupId(long groupId) throws SystemException {
        for (AceItem aceItem : findByGroupId(groupId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(aceItem);
        }
    }

    /**
     * Returns the number of ace items where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the number of matching ace items
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

            query.append(_SQL_COUNT_ACEITEM_WHERE);

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
     * Returns the ace item where storedAt = &#63; or throws a {@link nl.wur.alterra.cgi.ace.NoSuchItemException} if it could not be found.
     *
     * @param storedAt the stored at
     * @return the matching ace item
     * @throws nl.wur.alterra.cgi.ace.NoSuchItemException if a matching ace item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AceItem findByStoredAt(String storedAt)
        throws NoSuchItemException, SystemException {
        AceItem aceItem = fetchByStoredAt(storedAt);

        if (aceItem == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("storedAt=");
            msg.append(storedAt);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchItemException(msg.toString());
        }

        return aceItem;
    }

    /**
     * Returns the ace item where storedAt = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param storedAt the stored at
     * @return the matching ace item, or <code>null</code> if a matching ace item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AceItem fetchByStoredAt(String storedAt) throws SystemException {
        return fetchByStoredAt(storedAt, true);
    }

    /**
     * Returns the ace item where storedAt = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param storedAt the stored at
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching ace item, or <code>null</code> if a matching ace item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AceItem fetchByStoredAt(String storedAt, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { storedAt };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_STOREDAT,
                    finderArgs, this);
        }

        if (result instanceof AceItem) {
            AceItem aceItem = (AceItem) result;

            if (!Validator.equals(storedAt, aceItem.getStoredAt())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_ACEITEM_WHERE);

            boolean bindStoredAt = false;

            if (storedAt == null) {
                query.append(_FINDER_COLUMN_STOREDAT_STOREDAT_1);
            } else if (storedAt.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_STOREDAT_STOREDAT_3);
            } else {
                bindStoredAt = true;

                query.append(_FINDER_COLUMN_STOREDAT_STOREDAT_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindStoredAt) {
                    qPos.add(storedAt);
                }

                List<AceItem> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STOREDAT,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "AceItemPersistenceImpl.fetchByStoredAt(String, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    AceItem aceItem = list.get(0);

                    result = aceItem;

                    cacheResult(aceItem);

                    if ((aceItem.getStoredAt() == null) ||
                            !aceItem.getStoredAt().equals(storedAt)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STOREDAT,
                            finderArgs, aceItem);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STOREDAT,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (AceItem) result;
        }
    }

    /**
     * Removes the ace item where storedAt = &#63; from the database.
     *
     * @param storedAt the stored at
     * @return the ace item that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AceItem removeByStoredAt(String storedAt)
        throws NoSuchItemException, SystemException {
        AceItem aceItem = findByStoredAt(storedAt);

        return remove(aceItem);
    }

    /**
     * Returns the number of ace items where storedAt = &#63;.
     *
     * @param storedAt the stored at
     * @return the number of matching ace items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByStoredAt(String storedAt) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_STOREDAT;

        Object[] finderArgs = new Object[] { storedAt };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_ACEITEM_WHERE);

            boolean bindStoredAt = false;

            if (storedAt == null) {
                query.append(_FINDER_COLUMN_STOREDAT_STOREDAT_1);
            } else if (storedAt.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_STOREDAT_STOREDAT_3);
            } else {
                bindStoredAt = true;

                query.append(_FINDER_COLUMN_STOREDAT_STOREDAT_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindStoredAt) {
                    qPos.add(storedAt);
                }

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
     * Returns all the ace items where wxsharvesterId = &#63;.
     *
     * @param wxsharvesterId the wxsharvester ID
     * @return the matching ace items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AceItem> findByWxsharvesterId(long wxsharvesterId)
        throws SystemException {
        return findByWxsharvesterId(wxsharvesterId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    @Override
    public List<AceItem> findByWxsharvesterId(long wxsharvesterId, int start,
        int end) throws SystemException {
        return findByWxsharvesterId(wxsharvesterId, start, end, null);
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
    @Override
    public List<AceItem> findByWxsharvesterId(long wxsharvesterId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WXSHARVESTERID;
            finderArgs = new Object[] { wxsharvesterId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_WXSHARVESTERID;
            finderArgs = new Object[] {
                    wxsharvesterId,
                    
                    start, end, orderByComparator
                };
        }

        List<AceItem> list = (List<AceItem>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (AceItem aceItem : list) {
                if ((wxsharvesterId != aceItem.getWxsharvesterId())) {
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

            query.append(_SQL_SELECT_ACEITEM_WHERE);

            query.append(_FINDER_COLUMN_WXSHARVESTERID_WXSHARVESTERID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(AceItemModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(wxsharvesterId);

                if (!pagination) {
                    list = (List<AceItem>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<AceItem>(list);
                } else {
                    list = (List<AceItem>) QueryUtil.list(q, getDialect(),
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
     * Returns the first ace item in the ordered set where wxsharvesterId = &#63;.
     *
     * @param wxsharvesterId the wxsharvester ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching ace item
     * @throws nl.wur.alterra.cgi.ace.NoSuchItemException if a matching ace item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AceItem findByWxsharvesterId_First(long wxsharvesterId,
        OrderByComparator orderByComparator)
        throws NoSuchItemException, SystemException {
        AceItem aceItem = fetchByWxsharvesterId_First(wxsharvesterId,
                orderByComparator);

        if (aceItem != null) {
            return aceItem;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("wxsharvesterId=");
        msg.append(wxsharvesterId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchItemException(msg.toString());
    }

    /**
     * Returns the first ace item in the ordered set where wxsharvesterId = &#63;.
     *
     * @param wxsharvesterId the wxsharvester ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching ace item, or <code>null</code> if a matching ace item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AceItem fetchByWxsharvesterId_First(long wxsharvesterId,
        OrderByComparator orderByComparator) throws SystemException {
        List<AceItem> list = findByWxsharvesterId(wxsharvesterId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public AceItem findByWxsharvesterId_Last(long wxsharvesterId,
        OrderByComparator orderByComparator)
        throws NoSuchItemException, SystemException {
        AceItem aceItem = fetchByWxsharvesterId_Last(wxsharvesterId,
                orderByComparator);

        if (aceItem != null) {
            return aceItem;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("wxsharvesterId=");
        msg.append(wxsharvesterId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchItemException(msg.toString());
    }

    /**
     * Returns the last ace item in the ordered set where wxsharvesterId = &#63;.
     *
     * @param wxsharvesterId the wxsharvester ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching ace item, or <code>null</code> if a matching ace item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AceItem fetchByWxsharvesterId_Last(long wxsharvesterId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByWxsharvesterId(wxsharvesterId);

        if (count == 0) {
            return null;
        }

        List<AceItem> list = findByWxsharvesterId(wxsharvesterId, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public AceItem[] findByWxsharvesterId_PrevAndNext(long aceItemId,
        long wxsharvesterId, OrderByComparator orderByComparator)
        throws NoSuchItemException, SystemException {
        AceItem aceItem = findByPrimaryKey(aceItemId);

        Session session = null;

        try {
            session = openSession();

            AceItem[] array = new AceItemImpl[3];

            array[0] = getByWxsharvesterId_PrevAndNext(session, aceItem,
                    wxsharvesterId, orderByComparator, true);

            array[1] = aceItem;

            array[2] = getByWxsharvesterId_PrevAndNext(session, aceItem,
                    wxsharvesterId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected AceItem getByWxsharvesterId_PrevAndNext(Session session,
        AceItem aceItem, long wxsharvesterId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_ACEITEM_WHERE);

        query.append(_FINDER_COLUMN_WXSHARVESTERID_WXSHARVESTERID_2);

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
            query.append(AceItemModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(wxsharvesterId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(aceItem);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<AceItem> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the ace items where wxsharvesterId = &#63; from the database.
     *
     * @param wxsharvesterId the wxsharvester ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByWxsharvesterId(long wxsharvesterId)
        throws SystemException {
        for (AceItem aceItem : findByWxsharvesterId(wxsharvesterId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(aceItem);
        }
    }

    /**
     * Returns the number of ace items where wxsharvesterId = &#63;.
     *
     * @param wxsharvesterId the wxsharvester ID
     * @return the number of matching ace items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByWxsharvesterId(long wxsharvesterId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_WXSHARVESTERID;

        Object[] finderArgs = new Object[] { wxsharvesterId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_ACEITEM_WHERE);

            query.append(_FINDER_COLUMN_WXSHARVESTERID_WXSHARVESTERID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(wxsharvesterId);

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
     * Returns all the ace items where cswharvesterId = &#63;.
     *
     * @param cswharvesterId the cswharvester ID
     * @return the matching ace items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AceItem> findByCSWharvesterId(long cswharvesterId)
        throws SystemException {
        return findByCSWharvesterId(cswharvesterId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    @Override
    public List<AceItem> findByCSWharvesterId(long cswharvesterId, int start,
        int end) throws SystemException {
        return findByCSWharvesterId(cswharvesterId, start, end, null);
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
    @Override
    public List<AceItem> findByCSWharvesterId(long cswharvesterId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CSWHARVESTERID;
            finderArgs = new Object[] { cswharvesterId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CSWHARVESTERID;
            finderArgs = new Object[] {
                    cswharvesterId,
                    
                    start, end, orderByComparator
                };
        }

        List<AceItem> list = (List<AceItem>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (AceItem aceItem : list) {
                if ((cswharvesterId != aceItem.getCswharvesterId())) {
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

            query.append(_SQL_SELECT_ACEITEM_WHERE);

            query.append(_FINDER_COLUMN_CSWHARVESTERID_CSWHARVESTERID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(AceItemModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(cswharvesterId);

                if (!pagination) {
                    list = (List<AceItem>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<AceItem>(list);
                } else {
                    list = (List<AceItem>) QueryUtil.list(q, getDialect(),
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
     * Returns the first ace item in the ordered set where cswharvesterId = &#63;.
     *
     * @param cswharvesterId the cswharvester ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching ace item
     * @throws nl.wur.alterra.cgi.ace.NoSuchItemException if a matching ace item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AceItem findByCSWharvesterId_First(long cswharvesterId,
        OrderByComparator orderByComparator)
        throws NoSuchItemException, SystemException {
        AceItem aceItem = fetchByCSWharvesterId_First(cswharvesterId,
                orderByComparator);

        if (aceItem != null) {
            return aceItem;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("cswharvesterId=");
        msg.append(cswharvesterId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchItemException(msg.toString());
    }

    /**
     * Returns the first ace item in the ordered set where cswharvesterId = &#63;.
     *
     * @param cswharvesterId the cswharvester ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching ace item, or <code>null</code> if a matching ace item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AceItem fetchByCSWharvesterId_First(long cswharvesterId,
        OrderByComparator orderByComparator) throws SystemException {
        List<AceItem> list = findByCSWharvesterId(cswharvesterId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public AceItem findByCSWharvesterId_Last(long cswharvesterId,
        OrderByComparator orderByComparator)
        throws NoSuchItemException, SystemException {
        AceItem aceItem = fetchByCSWharvesterId_Last(cswharvesterId,
                orderByComparator);

        if (aceItem != null) {
            return aceItem;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("cswharvesterId=");
        msg.append(cswharvesterId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchItemException(msg.toString());
    }

    /**
     * Returns the last ace item in the ordered set where cswharvesterId = &#63;.
     *
     * @param cswharvesterId the cswharvester ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching ace item, or <code>null</code> if a matching ace item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AceItem fetchByCSWharvesterId_Last(long cswharvesterId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByCSWharvesterId(cswharvesterId);

        if (count == 0) {
            return null;
        }

        List<AceItem> list = findByCSWharvesterId(cswharvesterId, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public AceItem[] findByCSWharvesterId_PrevAndNext(long aceItemId,
        long cswharvesterId, OrderByComparator orderByComparator)
        throws NoSuchItemException, SystemException {
        AceItem aceItem = findByPrimaryKey(aceItemId);

        Session session = null;

        try {
            session = openSession();

            AceItem[] array = new AceItemImpl[3];

            array[0] = getByCSWharvesterId_PrevAndNext(session, aceItem,
                    cswharvesterId, orderByComparator, true);

            array[1] = aceItem;

            array[2] = getByCSWharvesterId_PrevAndNext(session, aceItem,
                    cswharvesterId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected AceItem getByCSWharvesterId_PrevAndNext(Session session,
        AceItem aceItem, long cswharvesterId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_ACEITEM_WHERE);

        query.append(_FINDER_COLUMN_CSWHARVESTERID_CSWHARVESTERID_2);

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
            query.append(AceItemModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(cswharvesterId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(aceItem);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<AceItem> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the ace items where cswharvesterId = &#63; from the database.
     *
     * @param cswharvesterId the cswharvester ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByCSWharvesterId(long cswharvesterId)
        throws SystemException {
        for (AceItem aceItem : findByCSWharvesterId(cswharvesterId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(aceItem);
        }
    }

    /**
     * Returns the number of ace items where cswharvesterId = &#63;.
     *
     * @param cswharvesterId the cswharvester ID
     * @return the number of matching ace items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByCSWharvesterId(long cswharvesterId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_CSWHARVESTERID;

        Object[] finderArgs = new Object[] { cswharvesterId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_ACEITEM_WHERE);

            query.append(_FINDER_COLUMN_CSWHARVESTERID_CSWHARVESTERID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(cswharvesterId);

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
     * Caches the ace item in the entity cache if it is enabled.
     *
     * @param aceItem the ace item
     */
    @Override
    public void cacheResult(AceItem aceItem) {
        EntityCacheUtil.putResult(AceItemModelImpl.ENTITY_CACHE_ENABLED,
            AceItemImpl.class, aceItem.getPrimaryKey(), aceItem);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STOREDAT,
            new Object[] { aceItem.getStoredAt() }, aceItem);

        aceItem.resetOriginalValues();
    }

    /**
     * Caches the ace items in the entity cache if it is enabled.
     *
     * @param aceItems the ace items
     */
    @Override
    public void cacheResult(List<AceItem> aceItems) {
        for (AceItem aceItem : aceItems) {
            if (EntityCacheUtil.getResult(
                        AceItemModelImpl.ENTITY_CACHE_ENABLED,
                        AceItemImpl.class, aceItem.getPrimaryKey()) == null) {
                cacheResult(aceItem);
            } else {
                aceItem.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all ace items.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(AceItemImpl.class.getName());
        }

        EntityCacheUtil.clearCache(AceItemImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the ace item.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(AceItem aceItem) {
        EntityCacheUtil.removeResult(AceItemModelImpl.ENTITY_CACHE_ENABLED,
            AceItemImpl.class, aceItem.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(aceItem);
    }

    @Override
    public void clearCache(List<AceItem> aceItems) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (AceItem aceItem : aceItems) {
            EntityCacheUtil.removeResult(AceItemModelImpl.ENTITY_CACHE_ENABLED,
                AceItemImpl.class, aceItem.getPrimaryKey());

            clearUniqueFindersCache(aceItem);
        }
    }

    protected void cacheUniqueFindersCache(AceItem aceItem) {
        if (aceItem.isNew()) {
            Object[] args = new Object[] { aceItem.getStoredAt() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STOREDAT, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STOREDAT, args,
                aceItem);
        } else {
            AceItemModelImpl aceItemModelImpl = (AceItemModelImpl) aceItem;

            if ((aceItemModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_STOREDAT.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { aceItem.getStoredAt() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STOREDAT, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STOREDAT, args,
                    aceItem);
            }
        }
    }

    protected void clearUniqueFindersCache(AceItem aceItem) {
        AceItemModelImpl aceItemModelImpl = (AceItemModelImpl) aceItem;

        Object[] args = new Object[] { aceItem.getStoredAt() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STOREDAT, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STOREDAT, args);

        if ((aceItemModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_STOREDAT.getColumnBitmask()) != 0) {
            args = new Object[] { aceItemModelImpl.getOriginalStoredAt() };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STOREDAT, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STOREDAT, args);
        }
    }

    /**
     * Creates a new ace item with the primary key. Does not add the ace item to the database.
     *
     * @param aceItemId the primary key for the new ace item
     * @return the new ace item
     */
    @Override
    public AceItem create(long aceItemId) {
        AceItem aceItem = new AceItemImpl();

        aceItem.setNew(true);
        aceItem.setPrimaryKey(aceItemId);

        return aceItem;
    }

    /**
     * Removes the ace item with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param aceItemId the primary key of the ace item
     * @return the ace item that was removed
     * @throws nl.wur.alterra.cgi.ace.NoSuchItemException if a ace item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AceItem remove(long aceItemId)
        throws NoSuchItemException, SystemException {
        return remove((Serializable) aceItemId);
    }

    /**
     * Removes the ace item with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the ace item
     * @return the ace item that was removed
     * @throws nl.wur.alterra.cgi.ace.NoSuchItemException if a ace item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AceItem remove(Serializable primaryKey)
        throws NoSuchItemException, SystemException {
        Session session = null;

        try {
            session = openSession();

            AceItem aceItem = (AceItem) session.get(AceItemImpl.class,
                    primaryKey);

            if (aceItem == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(aceItem);
        } catch (NoSuchItemException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected AceItem removeImpl(AceItem aceItem) throws SystemException {
        aceItem = toUnwrappedModel(aceItem);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(aceItem)) {
                aceItem = (AceItem) session.get(AceItemImpl.class,
                        aceItem.getPrimaryKeyObj());
            }

            if (aceItem != null) {
                session.delete(aceItem);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (aceItem != null) {
            clearCache(aceItem);
        }

        return aceItem;
    }

    @Override
    public AceItem updateImpl(nl.wur.alterra.cgi.ace.model.AceItem aceItem)
        throws SystemException {
        aceItem = toUnwrappedModel(aceItem);

        boolean isNew = aceItem.isNew();

        AceItemModelImpl aceItemModelImpl = (AceItemModelImpl) aceItem;

        Session session = null;

        try {
            session = openSession();

            if (aceItem.isNew()) {
                session.save(aceItem);

                aceItem.setNew(false);
            } else {
                session.merge(aceItem);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !AceItemModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((aceItemModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        aceItemModelImpl.getOriginalGroupId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);

                args = new Object[] { aceItemModelImpl.getGroupId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);
            }

            if ((aceItemModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WXSHARVESTERID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        aceItemModelImpl.getOriginalWxsharvesterId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_WXSHARVESTERID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WXSHARVESTERID,
                    args);

                args = new Object[] { aceItemModelImpl.getWxsharvesterId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_WXSHARVESTERID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WXSHARVESTERID,
                    args);
            }

            if ((aceItemModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CSWHARVESTERID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        aceItemModelImpl.getOriginalCswharvesterId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CSWHARVESTERID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CSWHARVESTERID,
                    args);

                args = new Object[] { aceItemModelImpl.getCswharvesterId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CSWHARVESTERID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CSWHARVESTERID,
                    args);
            }
        }

        EntityCacheUtil.putResult(AceItemModelImpl.ENTITY_CACHE_ENABLED,
            AceItemImpl.class, aceItem.getPrimaryKey(), aceItem);

        clearUniqueFindersCache(aceItem);
        cacheUniqueFindersCache(aceItem);

        return aceItem;
    }

    protected AceItem toUnwrappedModel(AceItem aceItem) {
        if (aceItem instanceof AceItemImpl) {
            return aceItem;
        }

        AceItemImpl aceItemImpl = new AceItemImpl();

        aceItemImpl.setNew(aceItem.isNew());
        aceItemImpl.setPrimaryKey(aceItem.getPrimaryKey());

        aceItemImpl.setAceItemId(aceItem.getAceItemId());
        aceItemImpl.setCompanyId(aceItem.getCompanyId());
        aceItemImpl.setGroupId(aceItem.getGroupId());
        aceItemImpl.setWxsharvesterId(aceItem.getWxsharvesterId());
        aceItemImpl.setCswharvesterId(aceItem.getCswharvesterId());
        aceItemImpl.setName(aceItem.getName());
        aceItemImpl.setDescription(aceItem.getDescription());
        aceItemImpl.setDatatype(aceItem.getDatatype());
        aceItemImpl.setStoredAt(aceItem.getStoredAt());
        aceItemImpl.setStoragetype(aceItem.getStoragetype());
        aceItemImpl.setSpecialtagging(aceItem.getSpecialtagging());
        aceItemImpl.setTextSearch(aceItem.getTextSearch());
        aceItemImpl.setKeyword(aceItem.getKeyword());
        aceItemImpl.setTargetresolution(aceItem.getTargetresolution());
        aceItemImpl.setSpatialLayer(aceItem.getSpatialLayer());
        aceItemImpl.setSpatialValues(aceItem.getSpatialValues());
        aceItemImpl.setStartDate(aceItem.getStartDate());
        aceItemImpl.setEndDate(aceItem.getEndDate());
        aceItemImpl.setPublicationDate(aceItem.getPublicationDate());
        aceItemImpl.setSectors_(aceItem.getSectors_());
        aceItemImpl.setElements_(aceItem.getElements_());
        aceItemImpl.setClimateimpacts_(aceItem.getClimateimpacts_());
        aceItemImpl.setRating(aceItem.getRating());
        aceItemImpl.setImportance(aceItem.getImportance());
        aceItemImpl.setSource(aceItem.getSource());
        aceItemImpl.setDeeplink(aceItem.getDeeplink());
        aceItemImpl.setControlstatus(aceItem.getControlstatus());
        aceItemImpl.setCreator(aceItem.getCreator());
        aceItemImpl.setCreationdate(aceItem.getCreationdate());
        aceItemImpl.setModerator(aceItem.getModerator());
        aceItemImpl.setApprovaldate(aceItem.getApprovaldate());
        aceItemImpl.setReplacesId(aceItem.getReplacesId());
        aceItemImpl.setComments(aceItem.getComments());
        aceItemImpl.setTextwebpage(aceItem.getTextwebpage());
        aceItemImpl.setYear(aceItem.getYear());
        aceItemImpl.setGeochars(aceItem.getGeochars());
        aceItemImpl.setFeature(aceItem.getFeature());
        aceItemImpl.setSupdocs(aceItem.getSupdocs());
        aceItemImpl.setAdmincomment(aceItem.getAdmincomment());
        aceItemImpl.setScenario(aceItem.getScenario());
        aceItemImpl.setTimeperiod(aceItem.getTimeperiod());
        aceItemImpl.setLockdate(aceItem.getLockdate());

        return aceItemImpl;
    }

    /**
     * Returns the ace item with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the ace item
     * @return the ace item
     * @throws nl.wur.alterra.cgi.ace.NoSuchItemException if a ace item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AceItem findByPrimaryKey(Serializable primaryKey)
        throws NoSuchItemException, SystemException {
        AceItem aceItem = fetchByPrimaryKey(primaryKey);

        if (aceItem == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return aceItem;
    }

    /**
     * Returns the ace item with the primary key or throws a {@link nl.wur.alterra.cgi.ace.NoSuchItemException} if it could not be found.
     *
     * @param aceItemId the primary key of the ace item
     * @return the ace item
     * @throws nl.wur.alterra.cgi.ace.NoSuchItemException if a ace item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AceItem findByPrimaryKey(long aceItemId)
        throws NoSuchItemException, SystemException {
        return findByPrimaryKey((Serializable) aceItemId);
    }

    /**
     * Returns the ace item with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the ace item
     * @return the ace item, or <code>null</code> if a ace item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AceItem fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        AceItem aceItem = (AceItem) EntityCacheUtil.getResult(AceItemModelImpl.ENTITY_CACHE_ENABLED,
                AceItemImpl.class, primaryKey);

        if (aceItem == _nullAceItem) {
            return null;
        }

        if (aceItem == null) {
            Session session = null;

            try {
                session = openSession();

                aceItem = (AceItem) session.get(AceItemImpl.class, primaryKey);

                if (aceItem != null) {
                    cacheResult(aceItem);
                } else {
                    EntityCacheUtil.putResult(AceItemModelImpl.ENTITY_CACHE_ENABLED,
                        AceItemImpl.class, primaryKey, _nullAceItem);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(AceItemModelImpl.ENTITY_CACHE_ENABLED,
                    AceItemImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return aceItem;
    }

    /**
     * Returns the ace item with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param aceItemId the primary key of the ace item
     * @return the ace item, or <code>null</code> if a ace item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AceItem fetchByPrimaryKey(long aceItemId) throws SystemException {
        return fetchByPrimaryKey((Serializable) aceItemId);
    }

    /**
     * Returns all the ace items.
     *
     * @return the ace items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AceItem> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<AceItem> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
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
    @Override
    public List<AceItem> findAll(int start, int end,
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

        List<AceItem> list = (List<AceItem>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_ACEITEM);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_ACEITEM;

                if (pagination) {
                    sql = sql.concat(AceItemModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<AceItem>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<AceItem>(list);
                } else {
                    list = (List<AceItem>) QueryUtil.list(q, getDialect(),
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
     * Removes all the ace items from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (AceItem aceItem : findAll()) {
            remove(aceItem);
        }
    }

    /**
     * Returns the number of ace items.
     *
     * @return the number of ace items
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

                Query q = session.createQuery(_SQL_COUNT_ACEITEM);

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
     * Initializes the ace item persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.nl.wur.alterra.cgi.ace.model.AceItem")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<AceItem>> listenersList = new ArrayList<ModelListener<AceItem>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<AceItem>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(AceItemImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
