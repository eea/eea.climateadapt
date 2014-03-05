package nl.wur.alterra.cgi.ace.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;

/**
 * The utility for the wxs harvester local service. This utility wraps {@link nl.wur.alterra.cgi.ace.service.impl.WxsHarvesterLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * Never modify this class directly. Add custom service methods to {@link nl.wur.alterra.cgi.ace.service.impl.WxsHarvesterLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author groot052
 * @see WxsHarvesterLocalService
 * @see nl.wur.alterra.cgi.ace.service.base.WxsHarvesterLocalServiceBaseImpl
 * @see nl.wur.alterra.cgi.ace.service.impl.WxsHarvesterLocalServiceImpl
 * @generated
 */
public class WxsHarvesterLocalServiceUtil {
    private static WxsHarvesterLocalService _service;

    /**
    * Adds the wxs harvester to the database. Also notifies the appropriate model listeners.
    *
    * @param wxsHarvester the wxs harvester to add
    * @return the wxs harvester that was added
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.WxsHarvester addWxsHarvester(
        nl.wur.alterra.cgi.ace.model.WxsHarvester wxsHarvester)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addWxsHarvester(wxsHarvester);
    }

    /**
    * Creates a new wxs harvester with the primary key. Does not add the wxs harvester to the database.
    *
    * @param wxsharvesterid the primary key for the new wxs harvester
    * @return the new wxs harvester
    */
    public static nl.wur.alterra.cgi.ace.model.WxsHarvester createWxsHarvester(
        long wxsharvesterid) {
        return getService().createWxsHarvester(wxsharvesterid);
    }

    /**
    * Deletes the wxs harvester with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param wxsharvesterid the primary key of the wxs harvester to delete
    * @throws PortalException if a wxs harvester with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static void deleteWxsHarvester(long wxsharvesterid)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().deleteWxsHarvester(wxsharvesterid);
    }

    /**
    * Deletes the wxs harvester from the database. Also notifies the appropriate model listeners.
    *
    * @param wxsHarvester the wxs harvester to delete
    * @throws SystemException if a system exception occurred
    */
    public static void deleteWxsHarvester(
        nl.wur.alterra.cgi.ace.model.WxsHarvester wxsHarvester)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().deleteWxsHarvester(wxsHarvester);
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query to search with
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query to search with
    * @param start the lower bound of the range of model instances to return
    * @param end the upper bound of the range of model instances to return (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query to search with
    * @param start the lower bound of the range of model instances to return
    * @param end the upper bound of the range of model instances to return (not inclusive)
    * @param orderByComparator the comparator to order the results by
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Counts the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query to search with
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Gets the wxs harvester with the primary key.
    *
    * @param wxsharvesterid the primary key of the wxs harvester to get
    * @return the wxs harvester
    * @throws PortalException if a wxs harvester with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.WxsHarvester getWxsHarvester(
        long wxsharvesterid)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getWxsHarvester(wxsharvesterid);
    }

    /**
    * Gets a range of all the wxs harvesters.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of wxs harvesters to return
    * @param end the upper bound of the range of wxs harvesters to return (not inclusive)
    * @return the range of wxs harvesters
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<nl.wur.alterra.cgi.ace.model.WxsHarvester> getWxsHarvesters(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getWxsHarvesters(start, end);
    }

    /**
    * Gets the number of wxs harvesters.
    *
    * @return the number of wxs harvesters
    * @throws SystemException if a system exception occurred
    */
    public static int getWxsHarvestersCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getWxsHarvestersCount();
    }

    /**
    * Updates the wxs harvester in the database. Also notifies the appropriate model listeners.
    *
    * @param wxsHarvester the wxs harvester to update
    * @return the wxs harvester that was updated
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.WxsHarvester updateWxsHarvester(
        nl.wur.alterra.cgi.ace.model.WxsHarvester wxsHarvester)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateWxsHarvester(wxsHarvester);
    }

    /**
    * Updates the wxs harvester in the database. Also notifies the appropriate model listeners.
    *
    * @param wxsHarvester the wxs harvester to update
    * @param merge whether to merge the wxs harvester with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the wxs harvester that was updated
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.WxsHarvester updateWxsHarvester(
        nl.wur.alterra.cgi.ace.model.WxsHarvester wxsHarvester, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateWxsHarvester(wxsHarvester, merge);
    }

    /**
    * Creates empty WxsHarvester.
    *
    * @return wxsharvester
    */
    public static nl.wur.alterra.cgi.ace.model.WxsHarvester createWxsHarvester() {
        return getService().createWxsHarvester();
    }

    /**
    * Updates a WxsHarvester. Also tries to update in GeoNetwork if asked to do so. Sets status to GEONETWORK_UPDATE_FAILURE
    * if GeoNetwork update fails; sets it to NEVER_RUN if status was not already SUCCESS. Removes existing scheduler and
    * creates a new one if asked to do so.
    *
    * @param wxsHarvester
    * @param propagateToGeoNetwork
    * @param reschedule
    * @return
    * @throws SystemException
    */
    public static nl.wur.alterra.cgi.ace.model.WxsHarvester updateWxsHarvester(
        nl.wur.alterra.cgi.ace.model.WxsHarvester wxsHarvester,
        java.lang.Boolean propagateToGeoNetwork, java.lang.Boolean reschedule)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .updateWxsHarvester(wxsHarvester, propagateToGeoNetwork,
            reschedule);
    }

    /**
    * Gets a list with all the WxsHarvesters in a group.
    */
    public static java.util.List<nl.wur.alterra.cgi.ace.model.WxsHarvester> getWxsHarvesterByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getWxsHarvesterByGroupId(groupId);
    }

    /**
    * Gets a list with a range of WxsHarvesters from a group.
    */
    public static java.util.List<nl.wur.alterra.cgi.ace.model.WxsHarvester> getWxsHarvestersByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getWxsHarvestersByGroupId(groupId, start, end);
    }

    /**
    * Gets the number of WxsHarvesters in a group.
    */
    public static int getWxsHarvestersCountByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getWxsHarvestersCountByGroupId(groupId);
    }

    public static void clearService() {
        _service = null;
    }

    public static WxsHarvesterLocalService getService() {
        if (_service == null) {
            Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
                    WxsHarvesterLocalService.class.getName());
            ClassLoader portletClassLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
                    "portletClassLoader");

            ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
                    portletClassLoader);

            _service = new WxsHarvesterLocalServiceClp(classLoaderProxy);

            ClpSerializer.setClassLoader(portletClassLoader);
        }

        return _service;
    }

    public void setService(WxsHarvesterLocalService service) {
        _service = service;
    }
}
