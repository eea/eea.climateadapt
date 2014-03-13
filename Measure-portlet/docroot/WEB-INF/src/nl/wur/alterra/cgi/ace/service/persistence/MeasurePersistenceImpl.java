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

import nl.wur.alterra.cgi.ace.NoSuchMeasureException;
import nl.wur.alterra.cgi.ace.model.Measure;
import nl.wur.alterra.cgi.ace.model.impl.MeasureImpl;
import nl.wur.alterra.cgi.ace.model.impl.MeasureModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the measure service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author groot052
 * @see MeasurePersistence
 * @see MeasureUtil
 * @generated
 */
public class MeasurePersistenceImpl extends BasePersistenceImpl<Measure>
    implements MeasurePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link MeasureUtil} to access the measure persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = MeasureImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MeasureModelImpl.ENTITY_CACHE_ENABLED,
            MeasureModelImpl.FINDER_CACHE_ENABLED, MeasureImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MeasureModelImpl.ENTITY_CACHE_ENABLED,
            MeasureModelImpl.FINDER_CACHE_ENABLED, MeasureImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MeasureModelImpl.ENTITY_CACHE_ENABLED,
            MeasureModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(MeasureModelImpl.ENTITY_CACHE_ENABLED,
            MeasureModelImpl.FINDER_CACHE_ENABLED, MeasureImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
        new FinderPath(MeasureModelImpl.ENTITY_CACHE_ENABLED,
            MeasureModelImpl.FINDER_CACHE_ENABLED, MeasureImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
            new String[] { Long.class.getName() },
            MeasureModelImpl.GROUPID_COLUMN_BITMASK |
            MeasureModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(MeasureModelImpl.ENTITY_CACHE_ENABLED,
            MeasureModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "measure.groupId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTROLSTATUS =
        new FinderPath(MeasureModelImpl.ENTITY_CACHE_ENABLED,
            MeasureModelImpl.FINDER_CACHE_ENABLED, MeasureImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByControlstatus",
            new String[] {
                Short.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTROLSTATUS =
        new FinderPath(MeasureModelImpl.ENTITY_CACHE_ENABLED,
            MeasureModelImpl.FINDER_CACHE_ENABLED, MeasureImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByControlstatus",
            new String[] { Short.class.getName() },
            MeasureModelImpl.CONTROLSTATUS_COLUMN_BITMASK |
            MeasureModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CONTROLSTATUS = new FinderPath(MeasureModelImpl.ENTITY_CACHE_ENABLED,
            MeasureModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByControlstatus",
            new String[] { Short.class.getName() });
    private static final String _FINDER_COLUMN_CONTROLSTATUS_CONTROLSTATUS_2 = "measure.controlstatus = ?";
    private static final String _SQL_SELECT_MEASURE = "SELECT measure FROM Measure measure";
    private static final String _SQL_SELECT_MEASURE_WHERE = "SELECT measure FROM Measure measure WHERE ";
    private static final String _SQL_COUNT_MEASURE = "SELECT COUNT(measure) FROM Measure measure";
    private static final String _SQL_COUNT_MEASURE_WHERE = "SELECT COUNT(measure) FROM Measure measure WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "measure.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Measure exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Measure exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(MeasurePersistenceImpl.class);
    private static Measure _nullMeasure = new MeasureImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Measure> toCacheModel() {
                return _nullMeasureCacheModel;
            }
        };

    private static CacheModel<Measure> _nullMeasureCacheModel = new CacheModel<Measure>() {
            @Override
            public Measure toEntityModel() {
                return _nullMeasure;
            }
        };

    public MeasurePersistenceImpl() {
        setModelClass(Measure.class);
    }

    /**
     * Returns all the measures where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the matching measures
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Measure> findByGroupId(long groupId) throws SystemException {
        return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the measures where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.wur.alterra.cgi.ace.model.impl.MeasureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param groupId the group ID
     * @param start the lower bound of the range of measures
     * @param end the upper bound of the range of measures (not inclusive)
     * @return the range of matching measures
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Measure> findByGroupId(long groupId, int start, int end)
        throws SystemException {
        return findByGroupId(groupId, start, end, null);
    }

    /**
     * Returns an ordered range of all the measures where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.wur.alterra.cgi.ace.model.impl.MeasureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param groupId the group ID
     * @param start the lower bound of the range of measures
     * @param end the upper bound of the range of measures (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching measures
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Measure> findByGroupId(long groupId, int start, int end,
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

        List<Measure> list = (List<Measure>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Measure measure : list) {
                if ((groupId != measure.getGroupId())) {
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

            query.append(_SQL_SELECT_MEASURE_WHERE);

            query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(MeasureModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                if (!pagination) {
                    list = (List<Measure>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Measure>(list);
                } else {
                    list = (List<Measure>) QueryUtil.list(q, getDialect(),
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
     * Returns the first measure in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching measure
     * @throws nl.wur.alterra.cgi.ace.NoSuchMeasureException if a matching measure could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Measure findByGroupId_First(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchMeasureException, SystemException {
        Measure measure = fetchByGroupId_First(groupId, orderByComparator);

        if (measure != null) {
            return measure;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchMeasureException(msg.toString());
    }

    /**
     * Returns the first measure in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching measure, or <code>null</code> if a matching measure could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Measure fetchByGroupId_First(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Measure> list = findByGroupId(groupId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last measure in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching measure
     * @throws nl.wur.alterra.cgi.ace.NoSuchMeasureException if a matching measure could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Measure findByGroupId_Last(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchMeasureException, SystemException {
        Measure measure = fetchByGroupId_Last(groupId, orderByComparator);

        if (measure != null) {
            return measure;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchMeasureException(msg.toString());
    }

    /**
     * Returns the last measure in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching measure, or <code>null</code> if a matching measure could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Measure fetchByGroupId_Last(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByGroupId(groupId);

        if (count == 0) {
            return null;
        }

        List<Measure> list = findByGroupId(groupId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the measures before and after the current measure in the ordered set where groupId = &#63;.
     *
     * @param measureId the primary key of the current measure
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next measure
     * @throws nl.wur.alterra.cgi.ace.NoSuchMeasureException if a measure with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Measure[] findByGroupId_PrevAndNext(long measureId, long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchMeasureException, SystemException {
        Measure measure = findByPrimaryKey(measureId);

        Session session = null;

        try {
            session = openSession();

            Measure[] array = new MeasureImpl[3];

            array[0] = getByGroupId_PrevAndNext(session, measure, groupId,
                    orderByComparator, true);

            array[1] = measure;

            array[2] = getByGroupId_PrevAndNext(session, measure, groupId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Measure getByGroupId_PrevAndNext(Session session,
        Measure measure, long groupId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_MEASURE_WHERE);

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
            query.append(MeasureModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(measure);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Measure> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the measures where groupId = &#63; from the database.
     *
     * @param groupId the group ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByGroupId(long groupId) throws SystemException {
        for (Measure measure : findByGroupId(groupId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(measure);
        }
    }

    /**
     * Returns the number of measures where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the number of matching measures
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

            query.append(_SQL_COUNT_MEASURE_WHERE);

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
     * Returns all the measures where controlstatus = &#63;.
     *
     * @param controlstatus the controlstatus
     * @return the matching measures
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Measure> findByControlstatus(short controlstatus)
        throws SystemException {
        return findByControlstatus(controlstatus, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the measures where controlstatus = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.wur.alterra.cgi.ace.model.impl.MeasureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param controlstatus the controlstatus
     * @param start the lower bound of the range of measures
     * @param end the upper bound of the range of measures (not inclusive)
     * @return the range of matching measures
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Measure> findByControlstatus(short controlstatus, int start,
        int end) throws SystemException {
        return findByControlstatus(controlstatus, start, end, null);
    }

    /**
     * Returns an ordered range of all the measures where controlstatus = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.wur.alterra.cgi.ace.model.impl.MeasureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param controlstatus the controlstatus
     * @param start the lower bound of the range of measures
     * @param end the upper bound of the range of measures (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching measures
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Measure> findByControlstatus(short controlstatus, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTROLSTATUS;
            finderArgs = new Object[] { controlstatus };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTROLSTATUS;
            finderArgs = new Object[] {
                    controlstatus,
                    
                    start, end, orderByComparator
                };
        }

        List<Measure> list = (List<Measure>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Measure measure : list) {
                if ((controlstatus != measure.getControlstatus())) {
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

            query.append(_SQL_SELECT_MEASURE_WHERE);

            query.append(_FINDER_COLUMN_CONTROLSTATUS_CONTROLSTATUS_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(MeasureModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(controlstatus);

                if (!pagination) {
                    list = (List<Measure>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Measure>(list);
                } else {
                    list = (List<Measure>) QueryUtil.list(q, getDialect(),
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
     * Returns the first measure in the ordered set where controlstatus = &#63;.
     *
     * @param controlstatus the controlstatus
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching measure
     * @throws nl.wur.alterra.cgi.ace.NoSuchMeasureException if a matching measure could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Measure findByControlstatus_First(short controlstatus,
        OrderByComparator orderByComparator)
        throws NoSuchMeasureException, SystemException {
        Measure measure = fetchByControlstatus_First(controlstatus,
                orderByComparator);

        if (measure != null) {
            return measure;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("controlstatus=");
        msg.append(controlstatus);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchMeasureException(msg.toString());
    }

    /**
     * Returns the first measure in the ordered set where controlstatus = &#63;.
     *
     * @param controlstatus the controlstatus
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching measure, or <code>null</code> if a matching measure could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Measure fetchByControlstatus_First(short controlstatus,
        OrderByComparator orderByComparator) throws SystemException {
        List<Measure> list = findByControlstatus(controlstatus, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last measure in the ordered set where controlstatus = &#63;.
     *
     * @param controlstatus the controlstatus
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching measure
     * @throws nl.wur.alterra.cgi.ace.NoSuchMeasureException if a matching measure could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Measure findByControlstatus_Last(short controlstatus,
        OrderByComparator orderByComparator)
        throws NoSuchMeasureException, SystemException {
        Measure measure = fetchByControlstatus_Last(controlstatus,
                orderByComparator);

        if (measure != null) {
            return measure;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("controlstatus=");
        msg.append(controlstatus);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchMeasureException(msg.toString());
    }

    /**
     * Returns the last measure in the ordered set where controlstatus = &#63;.
     *
     * @param controlstatus the controlstatus
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching measure, or <code>null</code> if a matching measure could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Measure fetchByControlstatus_Last(short controlstatus,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByControlstatus(controlstatus);

        if (count == 0) {
            return null;
        }

        List<Measure> list = findByControlstatus(controlstatus, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the measures before and after the current measure in the ordered set where controlstatus = &#63;.
     *
     * @param measureId the primary key of the current measure
     * @param controlstatus the controlstatus
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next measure
     * @throws nl.wur.alterra.cgi.ace.NoSuchMeasureException if a measure with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Measure[] findByControlstatus_PrevAndNext(long measureId,
        short controlstatus, OrderByComparator orderByComparator)
        throws NoSuchMeasureException, SystemException {
        Measure measure = findByPrimaryKey(measureId);

        Session session = null;

        try {
            session = openSession();

            Measure[] array = new MeasureImpl[3];

            array[0] = getByControlstatus_PrevAndNext(session, measure,
                    controlstatus, orderByComparator, true);

            array[1] = measure;

            array[2] = getByControlstatus_PrevAndNext(session, measure,
                    controlstatus, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Measure getByControlstatus_PrevAndNext(Session session,
        Measure measure, short controlstatus,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_MEASURE_WHERE);

        query.append(_FINDER_COLUMN_CONTROLSTATUS_CONTROLSTATUS_2);

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
            query.append(MeasureModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(controlstatus);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(measure);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Measure> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the measures where controlstatus = &#63; from the database.
     *
     * @param controlstatus the controlstatus
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByControlstatus(short controlstatus)
        throws SystemException {
        for (Measure measure : findByControlstatus(controlstatus,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(measure);
        }
    }

    /**
     * Returns the number of measures where controlstatus = &#63;.
     *
     * @param controlstatus the controlstatus
     * @return the number of matching measures
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByControlstatus(short controlstatus)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_CONTROLSTATUS;

        Object[] finderArgs = new Object[] { controlstatus };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_MEASURE_WHERE);

            query.append(_FINDER_COLUMN_CONTROLSTATUS_CONTROLSTATUS_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(controlstatus);

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
     * Caches the measure in the entity cache if it is enabled.
     *
     * @param measure the measure
     */
    @Override
    public void cacheResult(Measure measure) {
        EntityCacheUtil.putResult(MeasureModelImpl.ENTITY_CACHE_ENABLED,
            MeasureImpl.class, measure.getPrimaryKey(), measure);

        measure.resetOriginalValues();
    }

    /**
     * Caches the measures in the entity cache if it is enabled.
     *
     * @param measures the measures
     */
    @Override
    public void cacheResult(List<Measure> measures) {
        for (Measure measure : measures) {
            if (EntityCacheUtil.getResult(
                        MeasureModelImpl.ENTITY_CACHE_ENABLED,
                        MeasureImpl.class, measure.getPrimaryKey()) == null) {
                cacheResult(measure);
            } else {
                measure.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all measures.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(MeasureImpl.class.getName());
        }

        EntityCacheUtil.clearCache(MeasureImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the measure.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Measure measure) {
        EntityCacheUtil.removeResult(MeasureModelImpl.ENTITY_CACHE_ENABLED,
            MeasureImpl.class, measure.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Measure> measures) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Measure measure : measures) {
            EntityCacheUtil.removeResult(MeasureModelImpl.ENTITY_CACHE_ENABLED,
                MeasureImpl.class, measure.getPrimaryKey());
        }
    }

    /**
     * Creates a new measure with the primary key. Does not add the measure to the database.
     *
     * @param measureId the primary key for the new measure
     * @return the new measure
     */
    @Override
    public Measure create(long measureId) {
        Measure measure = new MeasureImpl();

        measure.setNew(true);
        measure.setPrimaryKey(measureId);

        return measure;
    }

    /**
     * Removes the measure with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param measureId the primary key of the measure
     * @return the measure that was removed
     * @throws nl.wur.alterra.cgi.ace.NoSuchMeasureException if a measure with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Measure remove(long measureId)
        throws NoSuchMeasureException, SystemException {
        return remove((Serializable) measureId);
    }

    /**
     * Removes the measure with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the measure
     * @return the measure that was removed
     * @throws nl.wur.alterra.cgi.ace.NoSuchMeasureException if a measure with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Measure remove(Serializable primaryKey)
        throws NoSuchMeasureException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Measure measure = (Measure) session.get(MeasureImpl.class,
                    primaryKey);

            if (measure == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchMeasureException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(measure);
        } catch (NoSuchMeasureException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Measure removeImpl(Measure measure) throws SystemException {
        measure = toUnwrappedModel(measure);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(measure)) {
                measure = (Measure) session.get(MeasureImpl.class,
                        measure.getPrimaryKeyObj());
            }

            if (measure != null) {
                session.delete(measure);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (measure != null) {
            clearCache(measure);
        }

        return measure;
    }

    @Override
    public Measure updateImpl(nl.wur.alterra.cgi.ace.model.Measure measure)
        throws SystemException {
        measure = toUnwrappedModel(measure);

        boolean isNew = measure.isNew();

        MeasureModelImpl measureModelImpl = (MeasureModelImpl) measure;

        Session session = null;

        try {
            session = openSession();

            if (measure.isNew()) {
                session.save(measure);

                measure.setNew(false);
            } else {
                session.merge(measure);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !MeasureModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((measureModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        measureModelImpl.getOriginalGroupId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);

                args = new Object[] { measureModelImpl.getGroupId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);
            }

            if ((measureModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTROLSTATUS.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        measureModelImpl.getOriginalControlstatus()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTROLSTATUS,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTROLSTATUS,
                    args);

                args = new Object[] { measureModelImpl.getControlstatus() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTROLSTATUS,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTROLSTATUS,
                    args);
            }
        }

        EntityCacheUtil.putResult(MeasureModelImpl.ENTITY_CACHE_ENABLED,
            MeasureImpl.class, measure.getPrimaryKey(), measure);

        return measure;
    }

    protected Measure toUnwrappedModel(Measure measure) {
        if (measure instanceof MeasureImpl) {
            return measure;
        }

        MeasureImpl measureImpl = new MeasureImpl();

        measureImpl.setNew(measure.isNew());
        measureImpl.setPrimaryKey(measure.getPrimaryKey());

        measureImpl.setMeasureId(measure.getMeasureId());
        measureImpl.setCompanyId(measure.getCompanyId());
        measureImpl.setGroupId(measure.getGroupId());
        measureImpl.setAdmincomment(measure.getAdmincomment());
        measureImpl.setCasestudyfeature(measure.getCasestudyfeature());
        measureImpl.setName(measure.getName());
        measureImpl.setDescription(measure.getDescription());
        measureImpl.setImplementationtype(measure.getImplementationtype());
        measureImpl.setImplementationtime(measure.getImplementationtime());
        measureImpl.setLifetime(measure.getLifetime());
        measureImpl.setSpatiallayer(measure.getSpatiallayer());
        measureImpl.setSpatialvalues(measure.getSpatialvalues());
        measureImpl.setLegalaspects(measure.getLegalaspects());
        measureImpl.setStakeholderparticipation(measure.getStakeholderparticipation());
        measureImpl.setContact(measure.getContact());
        measureImpl.setObjectives(measure.getObjectives());
        measureImpl.setChallenges(measure.getChallenges());
        measureImpl.setAdaptationoptions(measure.getAdaptationoptions());
        measureImpl.setSolutions(measure.getSolutions());
        measureImpl.setRelevance(measure.getRelevance());
        measureImpl.setSucceslimitations(measure.getSucceslimitations());
        measureImpl.setWebsite(measure.getWebsite());
        measureImpl.setCostbenefit(measure.getCostbenefit());
        measureImpl.setKeywords(measure.getKeywords());
        measureImpl.setGeos_(measure.getGeos_());
        measureImpl.setStartdate(measure.getStartdate());
        measureImpl.setEnddate(measure.getEnddate());
        measureImpl.setPublicationdate(measure.getPublicationdate());
        measureImpl.setSpecialtagging(measure.getSpecialtagging());
        measureImpl.setSectors_(measure.getSectors_());
        measureImpl.setElements_(measure.getElements_());
        measureImpl.setClimateimpacts_(measure.getClimateimpacts_());
        measureImpl.setMao_type(measure.getMao_type());
        measureImpl.setSource(measure.getSource());
        measureImpl.setRating(measure.getRating());
        measureImpl.setImportance(measure.getImportance());
        measureImpl.setLon(measure.getLon());
        measureImpl.setLat(measure.getLat());
        measureImpl.setSatarea(measure.getSatarea());
        measureImpl.setControlstatus(measure.getControlstatus());
        measureImpl.setCreator(measure.getCreator());
        measureImpl.setCreationdate(measure.getCreationdate());
        measureImpl.setModerator(measure.getModerator());
        measureImpl.setApprovaldate(measure.getApprovaldate());
        measureImpl.setReplacesId(measure.getReplacesId());
        measureImpl.setComments(measure.getComments());
        measureImpl.setTextwebpage(measure.getTextwebpage());
        measureImpl.setPrimephoto(measure.getPrimephoto());
        measureImpl.setSupphotos(measure.getSupphotos());
        measureImpl.setSupdocs(measure.getSupdocs());
        measureImpl.setYear(measure.getYear());
        measureImpl.setGeochars(measure.getGeochars());
        measureImpl.setCategory(measure.getCategory());
        measureImpl.setLockdate(measure.getLockdate());

        return measureImpl;
    }

    /**
     * Returns the measure with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the measure
     * @return the measure
     * @throws nl.wur.alterra.cgi.ace.NoSuchMeasureException if a measure with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Measure findByPrimaryKey(Serializable primaryKey)
        throws NoSuchMeasureException, SystemException {
        Measure measure = fetchByPrimaryKey(primaryKey);

        if (measure == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchMeasureException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return measure;
    }

    /**
     * Returns the measure with the primary key or throws a {@link nl.wur.alterra.cgi.ace.NoSuchMeasureException} if it could not be found.
     *
     * @param measureId the primary key of the measure
     * @return the measure
     * @throws nl.wur.alterra.cgi.ace.NoSuchMeasureException if a measure with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Measure findByPrimaryKey(long measureId)
        throws NoSuchMeasureException, SystemException {
        return findByPrimaryKey((Serializable) measureId);
    }

    /**
     * Returns the measure with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the measure
     * @return the measure, or <code>null</code> if a measure with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Measure fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Measure measure = (Measure) EntityCacheUtil.getResult(MeasureModelImpl.ENTITY_CACHE_ENABLED,
                MeasureImpl.class, primaryKey);

        if (measure == _nullMeasure) {
            return null;
        }

        if (measure == null) {
            Session session = null;

            try {
                session = openSession();

                measure = (Measure) session.get(MeasureImpl.class, primaryKey);

                if (measure != null) {
                    cacheResult(measure);
                } else {
                    EntityCacheUtil.putResult(MeasureModelImpl.ENTITY_CACHE_ENABLED,
                        MeasureImpl.class, primaryKey, _nullMeasure);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(MeasureModelImpl.ENTITY_CACHE_ENABLED,
                    MeasureImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return measure;
    }

    /**
     * Returns the measure with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param measureId the primary key of the measure
     * @return the measure, or <code>null</code> if a measure with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Measure fetchByPrimaryKey(long measureId) throws SystemException {
        return fetchByPrimaryKey((Serializable) measureId);
    }

    /**
     * Returns all the measures.
     *
     * @return the measures
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Measure> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the measures.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.wur.alterra.cgi.ace.model.impl.MeasureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of measures
     * @param end the upper bound of the range of measures (not inclusive)
     * @return the range of measures
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Measure> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the measures.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.wur.alterra.cgi.ace.model.impl.MeasureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of measures
     * @param end the upper bound of the range of measures (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of measures
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Measure> findAll(int start, int end,
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

        List<Measure> list = (List<Measure>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_MEASURE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_MEASURE;

                if (pagination) {
                    sql = sql.concat(MeasureModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Measure>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Measure>(list);
                } else {
                    list = (List<Measure>) QueryUtil.list(q, getDialect(),
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
     * Removes all the measures from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Measure measure : findAll()) {
            remove(measure);
        }
    }

    /**
     * Returns the number of measures.
     *
     * @return the number of measures
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

                Query q = session.createQuery(_SQL_COUNT_MEASURE);

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
     * Initializes the measure persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.nl.wur.alterra.cgi.ace.model.Measure")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Measure>> listenersList = new ArrayList<ModelListener<Measure>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Measure>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(MeasureImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
