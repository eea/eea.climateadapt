package nl.wur.alterra.cgi.ace.service;

import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;


public class WxsHarvesterLocalServiceClp implements WxsHarvesterLocalService {
    private ClassLoaderProxy _classLoaderProxy;
    private MethodKey _addWxsHarvesterMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
            "addWxsHarvester", nl.wur.alterra.cgi.ace.model.WxsHarvester.class);
    private MethodKey _createWxsHarvesterMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
            "createWxsHarvester", long.class);
    private MethodKey _deleteWxsHarvesterMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
            "deleteWxsHarvester", long.class);
    private MethodKey _deleteWxsHarvesterMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
            "deleteWxsHarvester",
            nl.wur.alterra.cgi.ace.model.WxsHarvester.class);
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
    private MethodKey _getWxsHarvesterMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
            "getWxsHarvester", long.class);
    private MethodKey _getWxsHarvestersMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
            "getWxsHarvesters", int.class, int.class);
    private MethodKey _getWxsHarvestersCountMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
            "getWxsHarvestersCount");
    private MethodKey _updateWxsHarvesterMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
            "updateWxsHarvester",
            nl.wur.alterra.cgi.ace.model.WxsHarvester.class);
    private MethodKey _updateWxsHarvesterMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
            "updateWxsHarvester",
            nl.wur.alterra.cgi.ace.model.WxsHarvester.class, boolean.class);
    private MethodKey _createWxsHarvesterMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
            "createWxsHarvester");
    private MethodKey _updateWxsHarvesterMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
            "updateWxsHarvester",
            nl.wur.alterra.cgi.ace.model.WxsHarvester.class,
            java.lang.Boolean.class, java.lang.Boolean.class);
    private MethodKey _getWxsHarvesterByGroupIdMethodKey15 = new MethodKey(_classLoaderProxy.getClassName(),
            "getWxsHarvesterByGroupId", long.class);
    private MethodKey _getWxsHarvestersByGroupIdMethodKey16 = new MethodKey(_classLoaderProxy.getClassName(),
            "getWxsHarvestersByGroupId", long.class, int.class, int.class);
    private MethodKey _getWxsHarvestersCountByGroupIdMethodKey17 = new MethodKey(_classLoaderProxy.getClassName(),
            "getWxsHarvestersCountByGroupId", long.class);

    public WxsHarvesterLocalServiceClp(ClassLoaderProxy classLoaderProxy) {
        _classLoaderProxy = classLoaderProxy;
    }

    public nl.wur.alterra.cgi.ace.model.WxsHarvester addWxsHarvester(
        nl.wur.alterra.cgi.ace.model.WxsHarvester wxsHarvester)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_addWxsHarvesterMethodKey0,
                wxsHarvester);

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (nl.wur.alterra.cgi.ace.model.WxsHarvester) ClpSerializer.translateOutput(returnObj);
    }

    public nl.wur.alterra.cgi.ace.model.WxsHarvester createWxsHarvester(
        long wxsharvesterid) {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_createWxsHarvesterMethodKey1,
                wxsharvesterid);

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (nl.wur.alterra.cgi.ace.model.WxsHarvester) ClpSerializer.translateOutput(returnObj);
    }

    public void deleteWxsHarvester(long wxsharvesterid)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        MethodHandler methodHandler = new MethodHandler(_deleteWxsHarvesterMethodKey2,
                wxsharvesterid);

        try {
            _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    public void deleteWxsHarvester(
        nl.wur.alterra.cgi.ace.model.WxsHarvester wxsHarvester)
        throws com.liferay.portal.kernel.exception.SystemException {
        MethodHandler methodHandler = new MethodHandler(_deleteWxsHarvesterMethodKey3,
                wxsHarvester);

        try {
            _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
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
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List) ClpSerializer.translateOutput(returnObj);
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
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List) ClpSerializer.translateOutput(returnObj);
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
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List) ClpSerializer.translateOutput(returnObj);
    }

    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_dynamicQueryCountMethodKey7,
                dynamicQuery);

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return ((Long) returnObj).longValue();
    }

    public nl.wur.alterra.cgi.ace.model.WxsHarvester getWxsHarvester(
        long wxsharvesterid)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_getWxsHarvesterMethodKey8,
                wxsharvesterid);

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (nl.wur.alterra.cgi.ace.model.WxsHarvester) ClpSerializer.translateOutput(returnObj);
    }

    public java.util.List<nl.wur.alterra.cgi.ace.model.WxsHarvester> getWxsHarvesters(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_getWxsHarvestersMethodKey9,
                start, end);

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<nl.wur.alterra.cgi.ace.model.WxsHarvester>) ClpSerializer.translateOutput(returnObj);
    }

    public int getWxsHarvestersCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_getWxsHarvestersCountMethodKey10);

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return ((Integer) returnObj).intValue();
    }

    public nl.wur.alterra.cgi.ace.model.WxsHarvester updateWxsHarvester(
        nl.wur.alterra.cgi.ace.model.WxsHarvester wxsHarvester)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_updateWxsHarvesterMethodKey11,
                wxsHarvester);

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (nl.wur.alterra.cgi.ace.model.WxsHarvester) ClpSerializer.translateOutput(returnObj);
    }

    public nl.wur.alterra.cgi.ace.model.WxsHarvester updateWxsHarvester(
        nl.wur.alterra.cgi.ace.model.WxsHarvester wxsHarvester, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_updateWxsHarvesterMethodKey12,
                wxsHarvester, merge);

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (nl.wur.alterra.cgi.ace.model.WxsHarvester) ClpSerializer.translateOutput(returnObj);
    }

    public nl.wur.alterra.cgi.ace.model.WxsHarvester createWxsHarvester() {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_createWxsHarvesterMethodKey13);

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (nl.wur.alterra.cgi.ace.model.WxsHarvester) ClpSerializer.translateOutput(returnObj);
    }

    public nl.wur.alterra.cgi.ace.model.WxsHarvester updateWxsHarvester(
        nl.wur.alterra.cgi.ace.model.WxsHarvester wxsHarvester,
        java.lang.Boolean propagateToGeoNetwork, java.lang.Boolean reschedule)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_updateWxsHarvesterMethodKey14,
                wxsHarvester, propagateToGeoNetwork, reschedule);

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (nl.wur.alterra.cgi.ace.model.WxsHarvester) ClpSerializer.translateOutput(returnObj);
    }

    public java.util.List<nl.wur.alterra.cgi.ace.model.WxsHarvester> getWxsHarvesterByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_getWxsHarvesterByGroupIdMethodKey15,
                groupId);

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<nl.wur.alterra.cgi.ace.model.WxsHarvester>) ClpSerializer.translateOutput(returnObj);
    }

    public java.util.List<nl.wur.alterra.cgi.ace.model.WxsHarvester> getWxsHarvestersByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_getWxsHarvestersByGroupIdMethodKey16,
                groupId, start, end);

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<nl.wur.alterra.cgi.ace.model.WxsHarvester>) ClpSerializer.translateOutput(returnObj);
    }

    public int getWxsHarvestersCountByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_getWxsHarvestersCountByGroupIdMethodKey17,
                groupId);

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return ((Integer) returnObj).intValue();
    }

    public ClassLoaderProxy getClassLoaderProxy() {
        return _classLoaderProxy;
    }
}