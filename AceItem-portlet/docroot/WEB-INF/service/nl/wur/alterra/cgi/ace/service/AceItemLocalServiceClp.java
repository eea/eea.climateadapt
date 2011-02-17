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

package nl.wur.alterra.cgi.ace.service;

import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * @author groot052
 */
public class AceItemLocalServiceClp implements AceItemLocalService {
	public AceItemLocalServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;
	}

	public nl.wur.alterra.cgi.ace.model.AceItem addAceItem(
		nl.wur.alterra.cgi.ace.model.AceItem aceItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addAceItemMethodKey0,
				aceItem);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (nl.wur.alterra.cgi.ace.model.AceItem)ClpSerializer.translateOutput(returnObj);
	}

	public nl.wur.alterra.cgi.ace.model.AceItem createAceItem(long aceItemId) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_createAceItemMethodKey1,
				aceItemId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (nl.wur.alterra.cgi.ace.model.AceItem)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteAceItem(long aceItemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteAceItemMethodKey2,
				aceItemId);

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void deleteAceItem(nl.wur.alterra.cgi.ace.model.AceItem aceItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteAceItemMethodKey3,
				aceItem);

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey4,
				dynamicQuery);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey5,
				dynamicQuery, start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey6,
				dynamicQuery, start, end, orderByComparator);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryCountMethodKey7,
				dynamicQuery);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Long)returnObj).longValue();
	}

	public nl.wur.alterra.cgi.ace.model.AceItem getAceItem(long aceItemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getAceItemMethodKey8,
				aceItemId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (nl.wur.alterra.cgi.ace.model.AceItem)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<nl.wur.alterra.cgi.ace.model.AceItem> getAceItems(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getAceItemsMethodKey9,
				start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<nl.wur.alterra.cgi.ace.model.AceItem>)ClpSerializer.translateOutput(returnObj);
	}

	public int getAceItemsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getAceItemsCountMethodKey10);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public nl.wur.alterra.cgi.ace.model.AceItem updateAceItem(
		nl.wur.alterra.cgi.ace.model.AceItem aceItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateAceItemMethodKey11,
				aceItem);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (nl.wur.alterra.cgi.ace.model.AceItem)ClpSerializer.translateOutput(returnObj);
	}

	public nl.wur.alterra.cgi.ace.model.AceItem updateAceItem(
		nl.wur.alterra.cgi.ace.model.AceItem aceItem, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateAceItemMethodKey12,
				aceItem, merge);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (nl.wur.alterra.cgi.ace.model.AceItem)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<nl.wur.alterra.cgi.ace.model.AceItem> getAceItemsByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getAceItemsByGroupIdMethodKey13,
				groupId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<nl.wur.alterra.cgi.ace.model.AceItem>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<nl.wur.alterra.cgi.ace.model.AceItem> getAceItemsByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getAceItemsByGroupIdMethodKey14,
				groupId, start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<nl.wur.alterra.cgi.ace.model.AceItem>)ClpSerializer.translateOutput(returnObj);
	}

	public int getAceItemsCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getAceItemsCountByGroupIdMethodKey15,
				groupId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _addAceItemMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
			"addAceItem", nl.wur.alterra.cgi.ace.model.AceItem.class);
	private MethodKey _createAceItemMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
			"createAceItem", long.class);
	private MethodKey _deleteAceItemMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
			"deleteAceItem", long.class);
	private MethodKey _deleteAceItemMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
			"deleteAceItem", nl.wur.alterra.cgi.ace.model.AceItem.class);
	private MethodKey _dynamicQueryMethodKey4 = new MethodKey(_classLoaderProxy.getClassName(),
			"dynamicQuery", com.liferay.portal.kernel.dao.orm.DynamicQuery.class);
	private MethodKey _dynamicQueryMethodKey5 = new MethodKey(_classLoaderProxy.getClassName(),
			"dynamicQuery",
			com.liferay.portal.kernel.dao.orm.DynamicQuery.class, int.class,
			int.class);
	private MethodKey _dynamicQueryMethodKey6 = new MethodKey(_classLoaderProxy.getClassName(),
			"dynamicQuery",
			com.liferay.portal.kernel.dao.orm.DynamicQuery.class, int.class,
			int.class, com.liferay.portal.kernel.util.OrderByComparator.class);
	private MethodKey _dynamicQueryCountMethodKey7 = new MethodKey(_classLoaderProxy.getClassName(),
			"dynamicQueryCount",
			com.liferay.portal.kernel.dao.orm.DynamicQuery.class);
	private MethodKey _getAceItemMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
			"getAceItem", long.class);
	private MethodKey _getAceItemsMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
			"getAceItems", int.class, int.class);
	private MethodKey _getAceItemsCountMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
			"getAceItemsCount");
	private MethodKey _updateAceItemMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
			"updateAceItem", nl.wur.alterra.cgi.ace.model.AceItem.class);
	private MethodKey _updateAceItemMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
			"updateAceItem", nl.wur.alterra.cgi.ace.model.AceItem.class,
			boolean.class);
	private MethodKey _getAceItemsByGroupIdMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
			"getAceItemsByGroupId", long.class);
	private MethodKey _getAceItemsByGroupIdMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
			"getAceItemsByGroupId", long.class, int.class, int.class);
	private MethodKey _getAceItemsCountByGroupIdMethodKey15 = new MethodKey(_classLoaderProxy.getClassName(),
			"getAceItemsCountByGroupId", long.class);
}