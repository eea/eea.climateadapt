/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

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
 * Never modify or reference this class directly. Always use {@link MeasureUtil} to access the measure persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
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
	public static final String FINDER_CLASS_NAME_ENTITY = MeasureImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_GROUPID = new FinderPath(MeasureModelImpl.ENTITY_CACHE_ENABLED,
			MeasureModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(MeasureModelImpl.ENTITY_CACHE_ENABLED,
			MeasureModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByGroupId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_CONTROLSTATUS = new FinderPath(MeasureModelImpl.ENTITY_CACHE_ENABLED,
			MeasureModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByControlstatus",
			new String[] {
				Short.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_CONTROLSTATUS = new FinderPath(MeasureModelImpl.ENTITY_CACHE_ENABLED,
			MeasureModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByControlstatus", new String[] { Short.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(MeasureModelImpl.ENTITY_CACHE_ENABLED,
			MeasureModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MeasureModelImpl.ENTITY_CACHE_ENABLED,
			MeasureModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the measure in the entity cache if it is enabled.
	 *
	 * @param measure the measure to cache
	 */
	public void cacheResult(Measure measure) {
		EntityCacheUtil.putResult(MeasureModelImpl.ENTITY_CACHE_ENABLED,
			MeasureImpl.class, measure.getPrimaryKey(), measure);
	}

	/**
	 * Caches the measures in the entity cache if it is enabled.
	 *
	 * @param measures the measures to cache
	 */
	public void cacheResult(List<Measure> measures) {
		for (Measure measure : measures) {
			if (EntityCacheUtil.getResult(
						MeasureModelImpl.ENTITY_CACHE_ENABLED,
						MeasureImpl.class, measure.getPrimaryKey(), this) == null) {
				cacheResult(measure);
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
	public void clearCache() {
		CacheRegistryUtil.clear(MeasureImpl.class.getName());
		EntityCacheUtil.clearCache(MeasureImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the measure.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(Measure measure) {
		EntityCacheUtil.removeResult(MeasureModelImpl.ENTITY_CACHE_ENABLED,
			MeasureImpl.class, measure.getPrimaryKey());
	}

	/**
	 * Creates a new measure with the primary key. Does not add the measure to the database.
	 *
	 * @param measureId the primary key for the new measure
	 * @return the new measure
	 */
	public Measure create(long measureId) {
		Measure measure = new MeasureImpl();

		measure.setNew(true);
		measure.setPrimaryKey(measureId);

		return measure;
	}

	/**
	 * Removes the measure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the measure to remove
	 * @return the measure that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a measure with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Measure remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the measure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param measureId the primary key of the measure to remove
	 * @return the measure that was removed
	 * @throws nl.wur.alterra.cgi.ace.NoSuchMeasureException if a measure with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Measure remove(long measureId)
		throws NoSuchMeasureException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Measure measure = (Measure)session.get(MeasureImpl.class,
					new Long(measureId));

			if (measure == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + measureId);
				}

				throw new NoSuchMeasureException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					measureId);
			}

			return remove(measure);
		}
		catch (NoSuchMeasureException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Measure removeImpl(Measure measure) throws SystemException {
		measure = toUnwrappedModel(measure);

		Session session = null;

		try {
			session = openSession();

			if (measure.isCachedModel() || BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(MeasureImpl.class,
						measure.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(measure);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(MeasureModelImpl.ENTITY_CACHE_ENABLED,
			MeasureImpl.class, measure.getPrimaryKey());

		return measure;
	}

	public Measure updateImpl(nl.wur.alterra.cgi.ace.model.Measure measure,
		boolean merge) throws SystemException {
		measure = toUnwrappedModel(measure);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, measure, merge);

			measure.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

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
		measureImpl.setSucceslimitations(measure.getSucceslimitations());
		measureImpl.setWebsite(measure.getWebsite());
		measureImpl.setCostbenefit(measure.getCostbenefit());
		measureImpl.setKeywords(measure.getKeywords());
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

		return measureImpl;
	}

	/**
	 * Finds the measure with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the measure to find
	 * @return the measure
	 * @throws com.liferay.portal.NoSuchModelException if a measure with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Measure findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the measure with the primary key or throws a {@link nl.wur.alterra.cgi.ace.NoSuchMeasureException} if it could not be found.
	 *
	 * @param measureId the primary key of the measure to find
	 * @return the measure
	 * @throws nl.wur.alterra.cgi.ace.NoSuchMeasureException if a measure with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Measure findByPrimaryKey(long measureId)
		throws NoSuchMeasureException, SystemException {
		Measure measure = fetchByPrimaryKey(measureId);

		if (measure == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + measureId);
			}

			throw new NoSuchMeasureException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				measureId);
		}

		return measure;
	}

	/**
	 * Finds the measure with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the measure to find
	 * @return the measure, or <code>null</code> if a measure with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Measure fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the measure with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param measureId the primary key of the measure to find
	 * @return the measure, or <code>null</code> if a measure with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Measure fetchByPrimaryKey(long measureId) throws SystemException {
		Measure measure = (Measure)EntityCacheUtil.getResult(MeasureModelImpl.ENTITY_CACHE_ENABLED,
				MeasureImpl.class, measureId, this);

		if (measure == null) {
			Session session = null;

			try {
				session = openSession();

				measure = (Measure)session.get(MeasureImpl.class,
						new Long(measureId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (measure != null) {
					cacheResult(measure);
				}

				closeSession(session);
			}
		}

		return measure;
	}

	/**
	 * Finds all the measures where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the matching measures
	 * @throws SystemException if a system exception occurred
	 */
	public List<Measure> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the measures where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of measures to return
	 * @param end the upper bound of the range of measures to return (not inclusive)
	 * @return the range of matching measures
	 * @throws SystemException if a system exception occurred
	 */
	public List<Measure> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the measures where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of measures to return
	 * @param end the upper bound of the range of measures to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching measures
	 * @throws SystemException if a system exception occurred
	 */
	public List<Measure> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Measure> list = (List<Measure>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_GROUPID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;

				if (orderByComparator != null) {
					query = new StringBundler(3 +
							(orderByComparator.getOrderByFields().length * 3));
				}
				else {
					query = new StringBundler(3);
				}

				query.append(_SQL_SELECT_MEASURE_WHERE);

				query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
				}

				else {
					query.append(MeasureModelImpl.ORDER_BY_JPQL);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<Measure>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Measure>();
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
	 * Finds the first measure in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching measure
	 * @throws nl.wur.alterra.cgi.ace.NoSuchMeasureException if a matching measure could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Measure findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchMeasureException, SystemException {
		List<Measure> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchMeasureException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last measure in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching measure
	 * @throws nl.wur.alterra.cgi.ace.NoSuchMeasureException if a matching measure could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Measure findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchMeasureException, SystemException {
		int count = countByGroupId(groupId);

		List<Measure> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchMeasureException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the measures before and after the current measure in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param measureId the primary key of the current measure
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next measure
	 * @throws nl.wur.alterra.cgi.ace.NoSuchMeasureException if a measure with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
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
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
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
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MEASURE_WHERE);

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
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
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
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(MeasureModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(measure);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Measure> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the measures where controlstatus = &#63;.
	 *
	 * @param controlstatus the controlstatus to search with
	 * @return the matching measures
	 * @throws SystemException if a system exception occurred
	 */
	public List<Measure> findByControlstatus(short controlstatus)
		throws SystemException {
		return findByControlstatus(controlstatus, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the measures where controlstatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param controlstatus the controlstatus to search with
	 * @param start the lower bound of the range of measures to return
	 * @param end the upper bound of the range of measures to return (not inclusive)
	 * @return the range of matching measures
	 * @throws SystemException if a system exception occurred
	 */
	public List<Measure> findByControlstatus(short controlstatus, int start,
		int end) throws SystemException {
		return findByControlstatus(controlstatus, start, end, null);
	}

	/**
	 * Finds an ordered range of all the measures where controlstatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param controlstatus the controlstatus to search with
	 * @param start the lower bound of the range of measures to return
	 * @param end the upper bound of the range of measures to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching measures
	 * @throws SystemException if a system exception occurred
	 */
	public List<Measure> findByControlstatus(short controlstatus, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				controlstatus,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Measure> list = (List<Measure>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_CONTROLSTATUS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;

				if (orderByComparator != null) {
					query = new StringBundler(3 +
							(orderByComparator.getOrderByFields().length * 3));
				}
				else {
					query = new StringBundler(3);
				}

				query.append(_SQL_SELECT_MEASURE_WHERE);

				query.append(_FINDER_COLUMN_CONTROLSTATUS_CONTROLSTATUS_2);

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
				}

				else {
					query.append(MeasureModelImpl.ORDER_BY_JPQL);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(controlstatus);

				list = (List<Measure>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Measure>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_CONTROLSTATUS,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first measure in the ordered set where controlstatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param controlstatus the controlstatus to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching measure
	 * @throws nl.wur.alterra.cgi.ace.NoSuchMeasureException if a matching measure could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Measure findByControlstatus_First(short controlstatus,
		OrderByComparator orderByComparator)
		throws NoSuchMeasureException, SystemException {
		List<Measure> list = findByControlstatus(controlstatus, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("controlstatus=");
			msg.append(controlstatus);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchMeasureException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last measure in the ordered set where controlstatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param controlstatus the controlstatus to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching measure
	 * @throws nl.wur.alterra.cgi.ace.NoSuchMeasureException if a matching measure could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Measure findByControlstatus_Last(short controlstatus,
		OrderByComparator orderByComparator)
		throws NoSuchMeasureException, SystemException {
		int count = countByControlstatus(controlstatus);

		List<Measure> list = findByControlstatus(controlstatus, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("controlstatus=");
			msg.append(controlstatus);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchMeasureException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the measures before and after the current measure in the ordered set where controlstatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param measureId the primary key of the current measure
	 * @param controlstatus the controlstatus to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next measure
	 * @throws nl.wur.alterra.cgi.ace.NoSuchMeasureException if a measure with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
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
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
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
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MEASURE_WHERE);

		query.append(_FINDER_COLUMN_CONTROLSTATUS_CONTROLSTATUS_2);

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
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
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
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(MeasureModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(controlstatus);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(measure);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Measure> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the measures.
	 *
	 * @return the measures
	 * @throws SystemException if a system exception occurred
	 */
	public List<Measure> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the measures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of measures to return
	 * @param end the upper bound of the range of measures to return (not inclusive)
	 * @return the range of measures
	 * @throws SystemException if a system exception occurred
	 */
	public List<Measure> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Finds an ordered range of all the measures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of measures to return
	 * @param end the upper bound of the range of measures to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of measures
	 * @throws SystemException if a system exception occurred
	 */
	public List<Measure> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Measure> list = (List<Measure>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
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

					query.append(_SQL_SELECT_MEASURE);

					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);

					sql = query.toString();
				}
				else {
					sql = _SQL_SELECT_MEASURE.concat(MeasureModelImpl.ORDER_BY_JPQL);
				}

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Measure>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Measure>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Measure>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the measures where groupId = &#63; from the database.
	 *
	 * @param groupId the group id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroupId(long groupId) throws SystemException {
		for (Measure measure : findByGroupId(groupId)) {
			remove(measure);
		}
	}

	/**
	 * Removes all the measures where controlstatus = &#63; from the database.
	 *
	 * @param controlstatus the controlstatus to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByControlstatus(short controlstatus)
		throws SystemException {
		for (Measure measure : findByControlstatus(controlstatus)) {
			remove(measure);
		}
	}

	/**
	 * Removes all the measures from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Measure measure : findAll()) {
			remove(measure);
		}
	}

	/**
	 * Counts all the measures where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the number of matching measures
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroupId(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(2);

				query.append(_SQL_COUNT_MEASURE_WHERE);

				query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
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
	 * Counts all the measures where controlstatus = &#63;.
	 *
	 * @param controlstatus the controlstatus to search with
	 * @return the number of matching measures
	 * @throws SystemException if a system exception occurred
	 */
	public int countByControlstatus(short controlstatus)
		throws SystemException {
		Object[] finderArgs = new Object[] { controlstatus };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CONTROLSTATUS,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(2);

				query.append(_SQL_COUNT_MEASURE_WHERE);

				query.append(_FINDER_COLUMN_CONTROLSTATUS_CONTROLSTATUS_2);

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(controlstatus);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CONTROLSTATUS,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the measures.
	 *
	 * @return the number of measures
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_MEASURE);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
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
					listenersList.add((ModelListener<Measure>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	@BeanReference(type = MeasurePersistence.class)
	protected MeasurePersistence measurePersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_MEASURE = "SELECT measure FROM Measure measure";
	private static final String _SQL_SELECT_MEASURE_WHERE = "SELECT measure FROM Measure measure WHERE ";
	private static final String _SQL_COUNT_MEASURE = "SELECT COUNT(measure) FROM Measure measure";
	private static final String _SQL_COUNT_MEASURE_WHERE = "SELECT COUNT(measure) FROM Measure measure WHERE ";
	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "measure.groupId = ?";
	private static final String _FINDER_COLUMN_CONTROLSTATUS_CONTROLSTATUS_2 = "measure.controlstatus = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "measure.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Measure exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Measure exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(MeasurePersistenceImpl.class);
}