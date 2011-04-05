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
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQuery;
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQueryFactoryUtil;
import com.liferay.portal.kernel.dao.jdbc.RowMapper;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
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

import nl.wur.alterra.cgi.ace.NoSuchNASException;
import nl.wur.alterra.cgi.ace.model.NAS;
import nl.wur.alterra.cgi.ace.model.impl.NASImpl;
import nl.wur.alterra.cgi.ace.model.impl.NASModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the n a s service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link NASUtil} to access the n a s persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author groot052
 * @see NASPersistence
 * @see NASUtil
 * @generated
 */
public class NASPersistenceImpl extends BasePersistenceImpl<NAS>
	implements NASPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = NASImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_GROUPID = new FinderPath(NASModelImpl.ENTITY_CACHE_ENABLED,
			NASModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(NASModelImpl.ENTITY_CACHE_ENABLED,
			NASModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByGroupId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(NASModelImpl.ENTITY_CACHE_ENABLED,
			NASModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(NASModelImpl.ENTITY_CACHE_ENABLED,
			NASModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the n a s in the entity cache if it is enabled.
	 *
	 * @param nas the n a s to cache
	 */
	public void cacheResult(NAS nas) {
		EntityCacheUtil.putResult(NASModelImpl.ENTITY_CACHE_ENABLED,
			NASImpl.class, nas.getPrimaryKey(), nas);
	}

	/**
	 * Caches the n a ses in the entity cache if it is enabled.
	 *
	 * @param nases the n a ses to cache
	 */
	public void cacheResult(List<NAS> nases) {
		for (NAS nas : nases) {
			if (EntityCacheUtil.getResult(NASModelImpl.ENTITY_CACHE_ENABLED,
						NASImpl.class, nas.getPrimaryKey(), this) == null) {
				cacheResult(nas);
			}
		}
	}

	/**
	 * Clears the cache for all n a ses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(NASImpl.class.getName());
		EntityCacheUtil.clearCache(NASImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the n a s.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(NAS nas) {
		EntityCacheUtil.removeResult(NASModelImpl.ENTITY_CACHE_ENABLED,
			NASImpl.class, nas.getPrimaryKey());
	}

	/**
	 * Creates a new n a s with the primary key. Does not add the n a s to the database.
	 *
	 * @param nasId the primary key for the new n a s
	 * @return the new n a s
	 */
	public NAS create(long nasId) {
		NAS nas = new NASImpl();

		nas.setNew(true);
		nas.setPrimaryKey(nasId);

		return nas;
	}

	/**
	 * Removes the n a s with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the n a s to remove
	 * @return the n a s that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a n a s with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NAS remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the n a s with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param nasId the primary key of the n a s to remove
	 * @return the n a s that was removed
	 * @throws nl.wur.alterra.cgi.ace.NoSuchNASException if a n a s with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NAS remove(long nasId) throws NoSuchNASException, SystemException {
		Session session = null;

		try {
			session = openSession();

			NAS nas = (NAS)session.get(NASImpl.class, new Long(nasId));

			if (nas == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + nasId);
				}

				throw new NoSuchNASException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					nasId);
			}

			return remove(nas);
		}
		catch (NoSuchNASException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected NAS removeImpl(NAS nas) throws SystemException {
		nas = toUnwrappedModel(nas);

		Session session = null;

		try {
			session = openSession();

			if (nas.isCachedModel() || BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(NASImpl.class,
						nas.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(nas);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(NASModelImpl.ENTITY_CACHE_ENABLED,
			NASImpl.class, nas.getPrimaryKey());

		return nas;
	}

	public NAS updateImpl(nl.wur.alterra.cgi.ace.model.NAS nas, boolean merge)
		throws SystemException {
		nas = toUnwrappedModel(nas);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, nas, merge);

			nas.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(NASModelImpl.ENTITY_CACHE_ENABLED,
			NASImpl.class, nas.getPrimaryKey(), nas);

		return nas;
	}

	protected NAS toUnwrappedModel(NAS nas) {
		if (nas instanceof NASImpl) {
			return nas;
		}

		NASImpl nasImpl = new NASImpl();

		nasImpl.setNew(nas.isNew());
		nasImpl.setPrimaryKey(nas.getPrimaryKey());

		nasImpl.setNasId(nas.getNasId());
		nasImpl.setName(nas.getName());
		nasImpl.setAdoptedStatus(nas.getAdoptedStatus());
		nasImpl.setAdoptedDescription(nas.getAdoptedDescription());
		nasImpl.setCompanyId(nas.getCompanyId());
		nasImpl.setGroupId(nas.getGroupId());

		return nasImpl;
	}

	/**
	 * Finds the n a s with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the n a s to find
	 * @return the n a s
	 * @throws com.liferay.portal.NoSuchModelException if a n a s with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NAS findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the n a s with the primary key or throws a {@link nl.wur.alterra.cgi.ace.NoSuchNASException} if it could not be found.
	 *
	 * @param nasId the primary key of the n a s to find
	 * @return the n a s
	 * @throws nl.wur.alterra.cgi.ace.NoSuchNASException if a n a s with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NAS findByPrimaryKey(long nasId)
		throws NoSuchNASException, SystemException {
		NAS nas = fetchByPrimaryKey(nasId);

		if (nas == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + nasId);
			}

			throw new NoSuchNASException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				nasId);
		}

		return nas;
	}

	/**
	 * Finds the n a s with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the n a s to find
	 * @return the n a s, or <code>null</code> if a n a s with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NAS fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the n a s with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param nasId the primary key of the n a s to find
	 * @return the n a s, or <code>null</code> if a n a s with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NAS fetchByPrimaryKey(long nasId) throws SystemException {
		NAS nas = (NAS)EntityCacheUtil.getResult(NASModelImpl.ENTITY_CACHE_ENABLED,
				NASImpl.class, nasId, this);

		if (nas == null) {
			Session session = null;

			try {
				session = openSession();

				nas = (NAS)session.get(NASImpl.class, new Long(nasId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (nas != null) {
					cacheResult(nas);
				}

				closeSession(session);
			}
		}

		return nas;
	}

	/**
	 * Finds all the n a ses where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the matching n a ses
	 * @throws SystemException if a system exception occurred
	 */
	public List<NAS> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the n a ses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of n a ses to return
	 * @param end the upper bound of the range of n a ses to return (not inclusive)
	 * @return the range of matching n a ses
	 * @throws SystemException if a system exception occurred
	 */
	public List<NAS> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the n a ses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of n a ses to return
	 * @param end the upper bound of the range of n a ses to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching n a ses
	 * @throws SystemException if a system exception occurred
	 */
	public List<NAS> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<NAS> list = (List<NAS>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_GROUPID,
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

				query.append(_SQL_SELECT_NAS_WHERE);

				query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
				}

				else {
					query.append(NASModelImpl.ORDER_BY_JPQL);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<NAS>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<NAS>();
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
	 * Finds the first n a s in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching n a s
	 * @throws nl.wur.alterra.cgi.ace.NoSuchNASException if a matching n a s could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NAS findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchNASException, SystemException {
		List<NAS> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchNASException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last n a s in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching n a s
	 * @throws nl.wur.alterra.cgi.ace.NoSuchNASException if a matching n a s could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NAS findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchNASException, SystemException {
		int count = countByGroupId(groupId);

		List<NAS> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchNASException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the n a ses before and after the current n a s in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param nasId the primary key of the current n a s
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next n a s
	 * @throws nl.wur.alterra.cgi.ace.NoSuchNASException if a n a s with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NAS[] findByGroupId_PrevAndNext(long nasId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchNASException, SystemException {
		NAS nas = findByPrimaryKey(nasId);

		Session session = null;

		try {
			session = openSession();

			NAS[] array = new NASImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, nas, groupId,
					orderByComparator, true);

			array[1] = nas;

			array[2] = getByGroupId_PrevAndNext(session, nas, groupId,
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

	protected NAS getByGroupId_PrevAndNext(Session session, NAS nas,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_NAS_WHERE);

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
			query.append(NASModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(nas);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<NAS> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the n a ses.
	 *
	 * @return the n a ses
	 * @throws SystemException if a system exception occurred
	 */
	public List<NAS> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the n a ses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of n a ses to return
	 * @param end the upper bound of the range of n a ses to return (not inclusive)
	 * @return the range of n a ses
	 * @throws SystemException if a system exception occurred
	 */
	public List<NAS> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Finds an ordered range of all the n a ses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of n a ses to return
	 * @param end the upper bound of the range of n a ses to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of n a ses
	 * @throws SystemException if a system exception occurred
	 */
	public List<NAS> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<NAS> list = (List<NAS>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
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

					query.append(_SQL_SELECT_NAS);

					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);

					sql = query.toString();
				}
				else {
					sql = _SQL_SELECT_NAS.concat(NASModelImpl.ORDER_BY_JPQL);
				}

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<NAS>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<NAS>)QueryUtil.list(q, getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<NAS>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the n a ses where groupId = &#63; from the database.
	 *
	 * @param groupId the group id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroupId(long groupId) throws SystemException {
		for (NAS nas : findByGroupId(groupId)) {
			remove(nas);
		}
	}

	/**
	 * Removes all the n a ses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (NAS nas : findAll()) {
			remove(nas);
		}
	}

	/**
	 * Counts all the n a ses where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the number of matching n a ses
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

				query.append(_SQL_COUNT_NAS_WHERE);

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
	 * Counts all the n a ses.
	 *
	 * @return the number of n a ses
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

				Query q = session.createQuery(_SQL_COUNT_NAS);

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
	 * Gets all the ace items associated with the n a s.
	 *
	 * @param pk the primary key of the n a s to get the associated ace items for
	 * @return the ace items associated with the n a s
	 * @throws SystemException if a system exception occurred
	 */
	public List<nl.wur.alterra.cgi.ace.model.AceItem> getAceItems(long pk)
		throws SystemException {
		return getAceItems(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Gets a range of all the ace items associated with the n a s.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the n a s to get the associated ace items for
	 * @param start the lower bound of the range of n a ses to return
	 * @param end the upper bound of the range of n a ses to return (not inclusive)
	 * @return the range of ace items associated with the n a s
	 * @throws SystemException if a system exception occurred
	 */
	public List<nl.wur.alterra.cgi.ace.model.AceItem> getAceItems(long pk,
		int start, int end) throws SystemException {
		return getAceItems(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_ACEITEMS = new FinderPath(nl.wur.alterra.cgi.ace.model.impl.AceItemModelImpl.ENTITY_CACHE_ENABLED,
			nl.wur.alterra.cgi.ace.model.impl.AceItemModelImpl.FINDER_CACHE_ENABLED,
			nl.wur.alterra.cgi.ace.service.persistence.AceItemPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getAceItems",
			new String[] {
				Long.class.getName(), "java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	/**
	 * Gets an ordered range of all the ace items associated with the n a s.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the n a s to get the associated ace items for
	 * @param start the lower bound of the range of n a ses to return
	 * @param end the upper bound of the range of n a ses to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of ace items associated with the n a s
	 * @throws SystemException if a system exception occurred
	 */
	public List<nl.wur.alterra.cgi.ace.model.AceItem> getAceItems(long pk,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				pk, String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<nl.wur.alterra.cgi.ace.model.AceItem> list = (List<nl.wur.alterra.cgi.ace.model.AceItem>)FinderCacheUtil.getResult(FINDER_PATH_GET_ACEITEMS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				String sql = null;

				if (orderByComparator != null) {
					sql = _SQL_GETACEITEMS.concat(ORDER_BY_CLAUSE)
										  .concat(orderByComparator.getOrderBy());
				}
				else {
					sql = _SQL_GETACEITEMS.concat(nl.wur.alterra.cgi.ace.model.impl.AceItemModelImpl.ORDER_BY_SQL);
				}

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("Ace_AceItem",
					nl.wur.alterra.cgi.ace.model.impl.AceItemImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<nl.wur.alterra.cgi.ace.model.AceItem>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<nl.wur.alterra.cgi.ace.model.AceItem>();
				}

				aceItemPersistence.cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_GET_ACEITEMS, finderArgs,
					list);

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_ACEITEMS_SIZE = new FinderPath(nl.wur.alterra.cgi.ace.model.impl.AceItemModelImpl.ENTITY_CACHE_ENABLED,
			nl.wur.alterra.cgi.ace.model.impl.AceItemModelImpl.FINDER_CACHE_ENABLED,
			nl.wur.alterra.cgi.ace.service.persistence.AceItemPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getAceItemsSize", new String[] { Long.class.getName() });

	/**
	 * Gets the number of ace items associated with the n a s.
	 *
	 * @param pk the primary key of the n a s to get the number of associated ace items for
	 * @return the number of ace items associated with the n a s
	 * @throws SystemException if a system exception occurred
	 */
	public int getAceItemsSize(long pk) throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_ACEITEMS_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETACEITEMSSIZE);

				q.addScalar(COUNT_COLUMN_NAME,
					com.liferay.portal.kernel.dao.orm.Type.LONG);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_GET_ACEITEMS_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_ACEITEM = new FinderPath(nl.wur.alterra.cgi.ace.model.impl.AceItemModelImpl.ENTITY_CACHE_ENABLED,
			nl.wur.alterra.cgi.ace.model.impl.AceItemModelImpl.FINDER_CACHE_ENABLED,
			nl.wur.alterra.cgi.ace.service.persistence.AceItemPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"containsAceItem",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Determines whether the ace item is associated with the n a s.
	 *
	 * @param pk the primary key of the n a s
	 * @param aceItemPK the primary key of the ace item
	 * @return whether the ace item is associated with the n a s
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsAceItem(long pk, long aceItemPK)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk, aceItemPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_ACEITEM,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsAceItem.contains(pk, aceItemPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_ACEITEM,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	/**
	 * Determines whether the n a s has any ace items associated with it.
	 *
	 * @param pk the primary key of the n a s to check for associations with ace items
	 * @return whether the n a s has any ace items associated with it
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsAceItems(long pk) throws SystemException {
		if (getAceItemsSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Initializes the n a s persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.nl.wur.alterra.cgi.ace.model.NAS")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<NAS>> listenersList = new ArrayList<ModelListener<NAS>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<NAS>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		containsAceItem = new ContainsAceItem(this);
	}

	@BeanReference(type = AceItemPersistence.class)
	protected AceItemPersistence aceItemPersistence;
	@BeanReference(type = NASPersistence.class)
	protected NASPersistence nasPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@BeanReference(type = AssetEntryPersistence.class)
	protected AssetEntryPersistence assetEntryPersistence;
	protected ContainsAceItem containsAceItem;

	protected class ContainsAceItem {
		protected ContainsAceItem(NASPersistenceImpl persistenceImpl) {
			super();

			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSACEITEM,
					new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT },
					RowMapper.COUNT);
		}

		protected boolean contains(long nasId, long aceItemId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						new Long(nasId), new Long(aceItemId)
					});

			if (results.size() > 0) {
				Integer count = results.get(0);

				if (count.intValue() > 0) {
					return true;
				}
			}

			return false;
		}

		private MappingSqlQuery<Integer> _mappingSqlQuery;
	}

	private static final String _SQL_SELECT_NAS = "SELECT nas FROM NAS nas";
	private static final String _SQL_SELECT_NAS_WHERE = "SELECT nas FROM NAS nas WHERE ";
	private static final String _SQL_COUNT_NAS = "SELECT COUNT(nas) FROM NAS nas";
	private static final String _SQL_COUNT_NAS_WHERE = "SELECT COUNT(nas) FROM NAS nas WHERE ";
	private static final String _SQL_GETACEITEMS = "SELECT {Ace_AceItem.*} FROM Ace_AceItem INNER JOIN Ace_NAS ON (Ace_NAS.nasId = Ace_AceItem.nasId) WHERE (Ace_NAS.nasId = ?)";
	private static final String _SQL_GETACEITEMSSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM Ace_AceItem WHERE nasId = ?";
	private static final String _SQL_CONTAINSACEITEM = "SELECT COUNT(*) AS COUNT_VALUE FROM Ace_AceItem WHERE nasId = ? AND aceItemId = ?";
	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "nas.groupId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "nas.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No NAS exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No NAS exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(NASPersistenceImpl.class);
}