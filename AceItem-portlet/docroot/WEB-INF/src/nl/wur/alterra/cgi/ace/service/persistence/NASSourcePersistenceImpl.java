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

import com.liferay.portlet.asset.service.persistence.AssetEntryPersistence;

import nl.wur.alterra.cgi.ace.NoSuchNASSourceException;
import nl.wur.alterra.cgi.ace.model.NASSource;
import nl.wur.alterra.cgi.ace.model.impl.NASSourceImpl;
import nl.wur.alterra.cgi.ace.model.impl.NASSourceModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the n a s source service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link NASSourceUtil} to access the n a s source persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author groot052
 * @see NASSourcePersistence
 * @see NASSourceUtil
 * @generated
 */
public class NASSourcePersistenceImpl extends BasePersistenceImpl<NASSource>
	implements NASSourcePersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = NASSourceImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_GROUPID = new FinderPath(NASSourceModelImpl.ENTITY_CACHE_ENABLED,
			NASSourceModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(NASSourceModelImpl.ENTITY_CACHE_ENABLED,
			NASSourceModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByGroupId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(NASSourceModelImpl.ENTITY_CACHE_ENABLED,
			NASSourceModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(NASSourceModelImpl.ENTITY_CACHE_ENABLED,
			NASSourceModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the n a s source in the entity cache if it is enabled.
	 *
	 * @param nasSource the n a s source to cache
	 */
	public void cacheResult(NASSource nasSource) {
		EntityCacheUtil.putResult(NASSourceModelImpl.ENTITY_CACHE_ENABLED,
			NASSourceImpl.class, nasSource.getPrimaryKey(), nasSource);
	}

	/**
	 * Caches the n a s sources in the entity cache if it is enabled.
	 *
	 * @param nasSources the n a s sources to cache
	 */
	public void cacheResult(List<NASSource> nasSources) {
		for (NASSource nasSource : nasSources) {
			if (EntityCacheUtil.getResult(
						NASSourceModelImpl.ENTITY_CACHE_ENABLED,
						NASSourceImpl.class, nasSource.getPrimaryKey(), this) == null) {
				cacheResult(nasSource);
			}
		}
	}

	/**
	 * Clears the cache for all n a s sources.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(NASSourceImpl.class.getName());
		EntityCacheUtil.clearCache(NASSourceImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the n a s source.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(NASSource nasSource) {
		EntityCacheUtil.removeResult(NASSourceModelImpl.ENTITY_CACHE_ENABLED,
			NASSourceImpl.class, nasSource.getPrimaryKey());
	}

	/**
	 * Creates a new n a s source with the primary key. Does not add the n a s source to the database.
	 *
	 * @param nassourceid the primary key for the new n a s source
	 * @return the new n a s source
	 */
	public NASSource create(long nassourceid) {
		NASSource nasSource = new NASSourceImpl();

		nasSource.setNew(true);
		nasSource.setPrimaryKey(nassourceid);

		return nasSource;
	}

	/**
	 * Removes the n a s source with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the n a s source to remove
	 * @return the n a s source that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a n a s source with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NASSource remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the n a s source with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param nassourceid the primary key of the n a s source to remove
	 * @return the n a s source that was removed
	 * @throws nl.wur.alterra.cgi.ace.NoSuchNASSourceException if a n a s source with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NASSource remove(long nassourceid)
		throws NoSuchNASSourceException, SystemException {
		Session session = null;

		try {
			session = openSession();

			NASSource nasSource = (NASSource)session.get(NASSourceImpl.class,
					new Long(nassourceid));

			if (nasSource == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + nassourceid);
				}

				throw new NoSuchNASSourceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					nassourceid);
			}

			return remove(nasSource);
		}
		catch (NoSuchNASSourceException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected NASSource removeImpl(NASSource nasSource)
		throws SystemException {
		nasSource = toUnwrappedModel(nasSource);

		Session session = null;

		try {
			session = openSession();

			if (nasSource.isCachedModel() || BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(NASSourceImpl.class,
						nasSource.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(nasSource);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(NASSourceModelImpl.ENTITY_CACHE_ENABLED,
			NASSourceImpl.class, nasSource.getPrimaryKey());

		return nasSource;
	}

	public NASSource updateImpl(
		nl.wur.alterra.cgi.ace.model.NASSource nasSource, boolean merge)
		throws SystemException {
		nasSource = toUnwrappedModel(nasSource);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, nasSource, merge);

			nasSource.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(NASSourceModelImpl.ENTITY_CACHE_ENABLED,
			NASSourceImpl.class, nasSource.getPrimaryKey(), nasSource);

		return nasSource;
	}

	protected NASSource toUnwrappedModel(NASSource nasSource) {
		if (nasSource instanceof NASSourceImpl) {
			return nasSource;
		}

		NASSourceImpl nasSourceImpl = new NASSourceImpl();

		nasSourceImpl.setNew(nasSource.isNew());
		nasSourceImpl.setPrimaryKey(nasSource.getPrimaryKey());

		nasSourceImpl.setNassourceid(nasSource.getNassourceid());
		nasSourceImpl.setNasId(nasSource.getNasId());
		nasSourceImpl.setName(nasSource.getName());
		nasSourceImpl.setCompanyId(nasSource.getCompanyId());
		nasSourceImpl.setGroupId(nasSource.getGroupId());

		return nasSourceImpl;
	}

	/**
	 * Finds the n a s source with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the n a s source to find
	 * @return the n a s source
	 * @throws com.liferay.portal.NoSuchModelException if a n a s source with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NASSource findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the n a s source with the primary key or throws a {@link nl.wur.alterra.cgi.ace.NoSuchNASSourceException} if it could not be found.
	 *
	 * @param nassourceid the primary key of the n a s source to find
	 * @return the n a s source
	 * @throws nl.wur.alterra.cgi.ace.NoSuchNASSourceException if a n a s source with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NASSource findByPrimaryKey(long nassourceid)
		throws NoSuchNASSourceException, SystemException {
		NASSource nasSource = fetchByPrimaryKey(nassourceid);

		if (nasSource == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + nassourceid);
			}

			throw new NoSuchNASSourceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				nassourceid);
		}

		return nasSource;
	}

	/**
	 * Finds the n a s source with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the n a s source to find
	 * @return the n a s source, or <code>null</code> if a n a s source with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NASSource fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the n a s source with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param nassourceid the primary key of the n a s source to find
	 * @return the n a s source, or <code>null</code> if a n a s source with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NASSource fetchByPrimaryKey(long nassourceid)
		throws SystemException {
		NASSource nasSource = (NASSource)EntityCacheUtil.getResult(NASSourceModelImpl.ENTITY_CACHE_ENABLED,
				NASSourceImpl.class, nassourceid, this);

		if (nasSource == null) {
			Session session = null;

			try {
				session = openSession();

				nasSource = (NASSource)session.get(NASSourceImpl.class,
						new Long(nassourceid));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (nasSource != null) {
					cacheResult(nasSource);
				}

				closeSession(session);
			}
		}

		return nasSource;
	}

	/**
	 * Finds all the n a s sources where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the matching n a s sources
	 * @throws SystemException if a system exception occurred
	 */
	public List<NASSource> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the n a s sources where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of n a s sources to return
	 * @param end the upper bound of the range of n a s sources to return (not inclusive)
	 * @return the range of matching n a s sources
	 * @throws SystemException if a system exception occurred
	 */
	public List<NASSource> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the n a s sources where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of n a s sources to return
	 * @param end the upper bound of the range of n a s sources to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching n a s sources
	 * @throws SystemException if a system exception occurred
	 */
	public List<NASSource> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<NASSource> list = (List<NASSource>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_GROUPID,
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

				query.append(_SQL_SELECT_NASSOURCE_WHERE);

				query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
				}

				else {
					query.append(NASSourceModelImpl.ORDER_BY_JPQL);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<NASSource>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<NASSource>();
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
	 * Finds the first n a s source in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching n a s source
	 * @throws nl.wur.alterra.cgi.ace.NoSuchNASSourceException if a matching n a s source could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NASSource findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchNASSourceException, SystemException {
		List<NASSource> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchNASSourceException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last n a s source in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching n a s source
	 * @throws nl.wur.alterra.cgi.ace.NoSuchNASSourceException if a matching n a s source could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NASSource findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchNASSourceException, SystemException {
		int count = countByGroupId(groupId);

		List<NASSource> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchNASSourceException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the n a s sources before and after the current n a s source in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param nassourceid the primary key of the current n a s source
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next n a s source
	 * @throws nl.wur.alterra.cgi.ace.NoSuchNASSourceException if a n a s source with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NASSource[] findByGroupId_PrevAndNext(long nassourceid,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchNASSourceException, SystemException {
		NASSource nasSource = findByPrimaryKey(nassourceid);

		Session session = null;

		try {
			session = openSession();

			NASSource[] array = new NASSourceImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, nasSource, groupId,
					orderByComparator, true);

			array[1] = nasSource;

			array[2] = getByGroupId_PrevAndNext(session, nasSource, groupId,
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

	protected NASSource getByGroupId_PrevAndNext(Session session,
		NASSource nasSource, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_NASSOURCE_WHERE);

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
			query.append(NASSourceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(nasSource);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<NASSource> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the n a s sources.
	 *
	 * @return the n a s sources
	 * @throws SystemException if a system exception occurred
	 */
	public List<NASSource> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the n a s sources.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of n a s sources to return
	 * @param end the upper bound of the range of n a s sources to return (not inclusive)
	 * @return the range of n a s sources
	 * @throws SystemException if a system exception occurred
	 */
	public List<NASSource> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Finds an ordered range of all the n a s sources.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of n a s sources to return
	 * @param end the upper bound of the range of n a s sources to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of n a s sources
	 * @throws SystemException if a system exception occurred
	 */
	public List<NASSource> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<NASSource> list = (List<NASSource>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
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

					query.append(_SQL_SELECT_NASSOURCE);

					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);

					sql = query.toString();
				}
				else {
					sql = _SQL_SELECT_NASSOURCE.concat(NASSourceModelImpl.ORDER_BY_JPQL);
				}

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<NASSource>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<NASSource>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<NASSource>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the n a s sources where groupId = &#63; from the database.
	 *
	 * @param groupId the group id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroupId(long groupId) throws SystemException {
		for (NASSource nasSource : findByGroupId(groupId)) {
			remove(nasSource);
		}
	}

	/**
	 * Removes all the n a s sources from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (NASSource nasSource : findAll()) {
			remove(nasSource);
		}
	}

	/**
	 * Counts all the n a s sources where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the number of matching n a s sources
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

				query.append(_SQL_COUNT_NASSOURCE_WHERE);

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
	 * Counts all the n a s sources.
	 *
	 * @return the number of n a s sources
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

				Query q = session.createQuery(_SQL_COUNT_NASSOURCE);

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
	 * Initializes the n a s source persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.nl.wur.alterra.cgi.ace.model.NASSource")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<NASSource>> listenersList = new ArrayList<ModelListener<NASSource>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<NASSource>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	@BeanReference(type = AceItemPersistence.class)
	protected AceItemPersistence aceItemPersistence;
	@BeanReference(type = NASPersistence.class)
	protected NASPersistence nasPersistence;
	@BeanReference(type = NASSourcePersistence.class)
	protected NASSourcePersistence nasSourcePersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@BeanReference(type = AssetEntryPersistence.class)
	protected AssetEntryPersistence assetEntryPersistence;
	private static final String _SQL_SELECT_NASSOURCE = "SELECT nasSource FROM NASSource nasSource";
	private static final String _SQL_SELECT_NASSOURCE_WHERE = "SELECT nasSource FROM NASSource nasSource WHERE ";
	private static final String _SQL_COUNT_NASSOURCE = "SELECT COUNT(nasSource) FROM NASSource nasSource";
	private static final String _SQL_COUNT_NASSOURCE_WHERE = "SELECT COUNT(nasSource) FROM NASSource nasSource WHERE ";
	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "nasSource.groupId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "nasSource.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No NASSource exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No NASSource exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(NASSourcePersistenceImpl.class);
}