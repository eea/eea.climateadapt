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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.portlet.asset.service.persistence.AssetEntryPersistence;

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
 * Never modify or reference this class directly. Always use {@link AceItemUtil} to access the ace item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
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
	public static final String FINDER_CLASS_NAME_ENTITY = AceItemImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_GROUPID = new FinderPath(AceItemModelImpl.ENTITY_CACHE_ENABLED,
			AceItemModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(AceItemModelImpl.ENTITY_CACHE_ENABLED,
			AceItemModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByGroupId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_STOREDAT = new FinderPath(AceItemModelImpl.ENTITY_CACHE_ENABLED,
			AceItemModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_ENTITY,
			"fetchByStoredAt", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_COUNT_BY_STOREDAT = new FinderPath(AceItemModelImpl.ENTITY_CACHE_ENABLED,
			AceItemModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByStoredAt", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(AceItemModelImpl.ENTITY_CACHE_ENABLED,
			AceItemModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AceItemModelImpl.ENTITY_CACHE_ENABLED,
			AceItemModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the ace item in the entity cache if it is enabled.
	 *
	 * @param aceItem the ace item to cache
	 */
	public void cacheResult(AceItem aceItem) {
		EntityCacheUtil.putResult(AceItemModelImpl.ENTITY_CACHE_ENABLED,
			AceItemImpl.class, aceItem.getPrimaryKey(), aceItem);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STOREDAT,
			new Object[] { aceItem.getStoredAt() }, aceItem);
	}

	/**
	 * Caches the ace items in the entity cache if it is enabled.
	 *
	 * @param aceItems the ace items to cache
	 */
	public void cacheResult(List<AceItem> aceItems) {
		for (AceItem aceItem : aceItems) {
			if (EntityCacheUtil.getResult(
						AceItemModelImpl.ENTITY_CACHE_ENABLED,
						AceItemImpl.class, aceItem.getPrimaryKey(), this) == null) {
				cacheResult(aceItem);
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
	public void clearCache() {
		CacheRegistryUtil.clear(AceItemImpl.class.getName());
		EntityCacheUtil.clearCache(AceItemImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the ace item.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(AceItem aceItem) {
		EntityCacheUtil.removeResult(AceItemModelImpl.ENTITY_CACHE_ENABLED,
			AceItemImpl.class, aceItem.getPrimaryKey());

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STOREDAT,
			new Object[] { aceItem.getStoredAt() });
	}

	/**
	 * Creates a new ace item with the primary key. Does not add the ace item to the database.
	 *
	 * @param aceItemId the primary key for the new ace item
	 * @return the new ace item
	 */
	public AceItem create(long aceItemId) {
		AceItem aceItem = new AceItemImpl();

		aceItem.setNew(true);
		aceItem.setPrimaryKey(aceItemId);

		return aceItem;
	}

	/**
	 * Removes the ace item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ace item to remove
	 * @return the ace item that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a ace item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AceItem remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the ace item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param aceItemId the primary key of the ace item to remove
	 * @return the ace item that was removed
	 * @throws nl.wur.alterra.cgi.ace.NoSuchItemException if a ace item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AceItem remove(long aceItemId)
		throws NoSuchItemException, SystemException {
		Session session = null;

		try {
			session = openSession();

			AceItem aceItem = (AceItem)session.get(AceItemImpl.class,
					new Long(aceItemId));

			if (aceItem == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + aceItemId);
				}

				throw new NoSuchItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					aceItemId);
			}

			return remove(aceItem);
		}
		catch (NoSuchItemException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AceItem removeImpl(AceItem aceItem) throws SystemException {
		aceItem = toUnwrappedModel(aceItem);

		Session session = null;

		try {
			session = openSession();

			if (aceItem.isCachedModel() || BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(AceItemImpl.class,
						aceItem.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(aceItem);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		AceItemModelImpl aceItemModelImpl = (AceItemModelImpl)aceItem;

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STOREDAT,
			new Object[] { aceItemModelImpl.getOriginalStoredAt() });

		EntityCacheUtil.removeResult(AceItemModelImpl.ENTITY_CACHE_ENABLED,
			AceItemImpl.class, aceItem.getPrimaryKey());

		return aceItem;
	}

	public AceItem updateImpl(nl.wur.alterra.cgi.ace.model.AceItem aceItem,
		boolean merge) throws SystemException {
		aceItem = toUnwrappedModel(aceItem);

		boolean isNew = aceItem.isNew();

		AceItemModelImpl aceItemModelImpl = (AceItemModelImpl)aceItem;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, aceItem, merge);

			aceItem.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(AceItemModelImpl.ENTITY_CACHE_ENABLED,
			AceItemImpl.class, aceItem.getPrimaryKey(), aceItem);

		if (!isNew &&
				(!Validator.equals(aceItem.getStoredAt(),
					aceItemModelImpl.getOriginalStoredAt()))) {
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STOREDAT,
				new Object[] { aceItemModelImpl.getOriginalStoredAt() });
		}

		if (isNew ||
				(!Validator.equals(aceItem.getStoredAt(),
					aceItemModelImpl.getOriginalStoredAt()))) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STOREDAT,
				new Object[] { aceItem.getStoredAt() }, aceItem);
		}

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

		return aceItemImpl;
	}

	/**
	 * Finds the ace item with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the ace item to find
	 * @return the ace item
	 * @throws com.liferay.portal.NoSuchModelException if a ace item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AceItem findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the ace item with the primary key or throws a {@link nl.wur.alterra.cgi.ace.NoSuchItemException} if it could not be found.
	 *
	 * @param aceItemId the primary key of the ace item to find
	 * @return the ace item
	 * @throws nl.wur.alterra.cgi.ace.NoSuchItemException if a ace item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AceItem findByPrimaryKey(long aceItemId)
		throws NoSuchItemException, SystemException {
		AceItem aceItem = fetchByPrimaryKey(aceItemId);

		if (aceItem == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + aceItemId);
			}

			throw new NoSuchItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				aceItemId);
		}

		return aceItem;
	}

	/**
	 * Finds the ace item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ace item to find
	 * @return the ace item, or <code>null</code> if a ace item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AceItem fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the ace item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param aceItemId the primary key of the ace item to find
	 * @return the ace item, or <code>null</code> if a ace item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AceItem fetchByPrimaryKey(long aceItemId) throws SystemException {
		AceItem aceItem = (AceItem)EntityCacheUtil.getResult(AceItemModelImpl.ENTITY_CACHE_ENABLED,
				AceItemImpl.class, aceItemId, this);

		if (aceItem == null) {
			Session session = null;

			try {
				session = openSession();

				aceItem = (AceItem)session.get(AceItemImpl.class,
						new Long(aceItemId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (aceItem != null) {
					cacheResult(aceItem);
				}

				closeSession(session);
			}
		}

		return aceItem;
	}

	/**
	 * Finds all the ace items where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the matching ace items
	 * @throws SystemException if a system exception occurred
	 */
	public List<AceItem> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the ace items where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of ace items to return
	 * @param end the upper bound of the range of ace items to return (not inclusive)
	 * @return the range of matching ace items
	 * @throws SystemException if a system exception occurred
	 */
	public List<AceItem> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the ace items where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of ace items to return
	 * @param end the upper bound of the range of ace items to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching ace items
	 * @throws SystemException if a system exception occurred
	 */
	public List<AceItem> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<AceItem> list = (List<AceItem>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_GROUPID,
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

				query.append(_SQL_SELECT_ACEITEM_WHERE);

				query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
				}

				else {
					query.append(AceItemModelImpl.ORDER_BY_JPQL);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<AceItem>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<AceItem>();
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
	 * Finds the first ace item in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching ace item
	 * @throws nl.wur.alterra.cgi.ace.NoSuchItemException if a matching ace item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AceItem findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchItemException, SystemException {
		List<AceItem> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchItemException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last ace item in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching ace item
	 * @throws nl.wur.alterra.cgi.ace.NoSuchItemException if a matching ace item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AceItem findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchItemException, SystemException {
		int count = countByGroupId(groupId);

		List<AceItem> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchItemException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the ace items before and after the current ace item in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param aceItemId the primary key of the current ace item
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next ace item
	 * @throws nl.wur.alterra.cgi.ace.NoSuchItemException if a ace item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
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
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
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
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ACEITEM_WHERE);

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
			query.append(AceItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(aceItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AceItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds the ace item where storedAt = &#63; or throws a {@link nl.wur.alterra.cgi.ace.NoSuchItemException} if it could not be found.
	 *
	 * @param storedAt the stored at to search with
	 * @return the matching ace item
	 * @throws nl.wur.alterra.cgi.ace.NoSuchItemException if a matching ace item could not be found
	 * @throws SystemException if a system exception occurred
	 */
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
	 * Finds the ace item where storedAt = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param storedAt the stored at to search with
	 * @return the matching ace item, or <code>null</code> if a matching ace item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AceItem fetchByStoredAt(String storedAt) throws SystemException {
		return fetchByStoredAt(storedAt, true);
	}

	/**
	 * Finds the ace item where storedAt = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param storedAt the stored at to search with
	 * @return the matching ace item, or <code>null</code> if a matching ace item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AceItem fetchByStoredAt(String storedAt, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { storedAt };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_STOREDAT,
					finderArgs, this);
		}

		if (result == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(3);

				query.append(_SQL_SELECT_ACEITEM_WHERE);

				if (storedAt == null) {
					query.append(_FINDER_COLUMN_STOREDAT_STOREDAT_1);
				}
				else {
					if (storedAt.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_STOREDAT_STOREDAT_3);
					}
					else {
						query.append(_FINDER_COLUMN_STOREDAT_STOREDAT_2);
					}
				}

				query.append(AceItemModelImpl.ORDER_BY_JPQL);

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (storedAt != null) {
					qPos.add(storedAt);
				}

				List<AceItem> list = q.list();

				result = list;

				AceItem aceItem = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STOREDAT,
						finderArgs, list);
				}
				else {
					aceItem = list.get(0);

					cacheResult(aceItem);

					if ((aceItem.getStoredAt() == null) ||
							!aceItem.getStoredAt().equals(storedAt)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STOREDAT,
							finderArgs, aceItem);
					}
				}

				return aceItem;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STOREDAT,
						finderArgs, new ArrayList<AceItem>());
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (AceItem)result;
			}
		}
	}

	/**
	 * Finds all the ace items.
	 *
	 * @return the ace items
	 * @throws SystemException if a system exception occurred
	 */
	public List<AceItem> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the ace items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of ace items to return
	 * @param end the upper bound of the range of ace items to return (not inclusive)
	 * @return the range of ace items
	 * @throws SystemException if a system exception occurred
	 */
	public List<AceItem> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Finds an ordered range of all the ace items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of ace items to return
	 * @param end the upper bound of the range of ace items to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of ace items
	 * @throws SystemException if a system exception occurred
	 */
	public List<AceItem> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<AceItem> list = (List<AceItem>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
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

					query.append(_SQL_SELECT_ACEITEM);

					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);

					sql = query.toString();
				}
				else {
					sql = _SQL_SELECT_ACEITEM.concat(AceItemModelImpl.ORDER_BY_JPQL);
				}

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<AceItem>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<AceItem>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<AceItem>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the ace items where groupId = &#63; from the database.
	 *
	 * @param groupId the group id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroupId(long groupId) throws SystemException {
		for (AceItem aceItem : findByGroupId(groupId)) {
			remove(aceItem);
		}
	}

	/**
	 * Removes the ace item where storedAt = &#63; from the database.
	 *
	 * @param storedAt the stored at to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByStoredAt(String storedAt)
		throws NoSuchItemException, SystemException {
		AceItem aceItem = findByStoredAt(storedAt);

		remove(aceItem);
	}

	/**
	 * Removes all the ace items from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (AceItem aceItem : findAll()) {
			remove(aceItem);
		}
	}

	/**
	 * Counts all the ace items where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the number of matching ace items
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

				query.append(_SQL_COUNT_ACEITEM_WHERE);

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
	 * Counts all the ace items where storedAt = &#63;.
	 *
	 * @param storedAt the stored at to search with
	 * @return the number of matching ace items
	 * @throws SystemException if a system exception occurred
	 */
	public int countByStoredAt(String storedAt) throws SystemException {
		Object[] finderArgs = new Object[] { storedAt };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STOREDAT,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(2);

				query.append(_SQL_COUNT_ACEITEM_WHERE);

				if (storedAt == null) {
					query.append(_FINDER_COLUMN_STOREDAT_STOREDAT_1);
				}
				else {
					if (storedAt.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_STOREDAT_STOREDAT_3);
					}
					else {
						query.append(_FINDER_COLUMN_STOREDAT_STOREDAT_2);
					}
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (storedAt != null) {
					qPos.add(storedAt);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STOREDAT,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the ace items.
	 *
	 * @return the number of ace items
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

				Query q = session.createQuery(_SQL_COUNT_ACEITEM);

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
					listenersList.add((ModelListener<AceItem>)InstanceFactory.newInstance(
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
	@BeanReference(type = WxsHarvesterPersistence.class)
	protected WxsHarvesterPersistence wxsHarvesterPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@BeanReference(type = AssetEntryPersistence.class)
	protected AssetEntryPersistence assetEntryPersistence;
	private static final String _SQL_SELECT_ACEITEM = "SELECT aceItem FROM AceItem aceItem";
	private static final String _SQL_SELECT_ACEITEM_WHERE = "SELECT aceItem FROM AceItem aceItem WHERE ";
	private static final String _SQL_COUNT_ACEITEM = "SELECT COUNT(aceItem) FROM AceItem aceItem";
	private static final String _SQL_COUNT_ACEITEM_WHERE = "SELECT COUNT(aceItem) FROM AceItem aceItem WHERE ";
	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "aceItem.groupId = ?";
	private static final String _FINDER_COLUMN_STOREDAT_STOREDAT_1 = "aceItem.storedAt IS NULL";
	private static final String _FINDER_COLUMN_STOREDAT_STOREDAT_2 = "aceItem.storedAt = ?";
	private static final String _FINDER_COLUMN_STOREDAT_STOREDAT_3 = "(aceItem.storedAt IS NULL OR aceItem.storedAt = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "aceItem.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AceItem exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AceItem exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(AceItemPersistenceImpl.class);
}