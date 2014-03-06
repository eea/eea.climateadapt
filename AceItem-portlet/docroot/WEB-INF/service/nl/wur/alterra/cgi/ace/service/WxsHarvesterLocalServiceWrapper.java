package nl.wur.alterra.cgi.ace.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link WxsHarvesterLocalService}.
 *
 * @author groot052
 * @see WxsHarvesterLocalService
 * @generated
 */
public class WxsHarvesterLocalServiceWrapper implements WxsHarvesterLocalService,
    ServiceWrapper<WxsHarvesterLocalService> {
    private WxsHarvesterLocalService _wxsHarvesterLocalService;

    public WxsHarvesterLocalServiceWrapper(
        WxsHarvesterLocalService wxsHarvesterLocalService) {
        _wxsHarvesterLocalService = wxsHarvesterLocalService;
    }

    /**
    * Adds the wxs harvester to the database. Also notifies the appropriate model listeners.
    *
    * @param wxsHarvester the wxs harvester
    * @return the wxs harvester that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public nl.wur.alterra.cgi.ace.model.WxsHarvester addWxsHarvester(
        nl.wur.alterra.cgi.ace.model.WxsHarvester wxsHarvester)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _wxsHarvesterLocalService.addWxsHarvester(wxsHarvester);
    }

    /**
    * Creates a new wxs harvester with the primary key. Does not add the wxs harvester to the database.
    *
    * @param wxsharvesterid the primary key for the new wxs harvester
    * @return the new wxs harvester
    */
    @Override
    public nl.wur.alterra.cgi.ace.model.WxsHarvester createWxsHarvester(
        long wxsharvesterid) {
        return _wxsHarvesterLocalService.createWxsHarvester(wxsharvesterid);
    }

    /**
    * Deletes the wxs harvester with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param wxsharvesterid the primary key of the wxs harvester
    * @return the wxs harvester that was removed
    * @throws PortalException if a wxs harvester with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public nl.wur.alterra.cgi.ace.model.WxsHarvester deleteWxsHarvester(
        long wxsharvesterid)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _wxsHarvesterLocalService.deleteWxsHarvester(wxsharvesterid);
    }

    /**
    * Deletes the wxs harvester from the database. Also notifies the appropriate model listeners.
    *
    * @param wxsHarvester the wxs harvester
    * @return the wxs harvester that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public nl.wur.alterra.cgi.ace.model.WxsHarvester deleteWxsHarvester(
        nl.wur.alterra.cgi.ace.model.WxsHarvester wxsHarvester)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _wxsHarvesterLocalService.deleteWxsHarvester(wxsHarvester);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _wxsHarvesterLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _wxsHarvesterLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.wur.alterra.cgi.ace.model.impl.WxsHarvesterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _wxsHarvesterLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.wur.alterra.cgi.ace.model.impl.WxsHarvesterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _wxsHarvesterLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _wxsHarvesterLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _wxsHarvesterLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public nl.wur.alterra.cgi.ace.model.WxsHarvester fetchWxsHarvester(
        long wxsharvesterid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _wxsHarvesterLocalService.fetchWxsHarvester(wxsharvesterid);
    }

    /**
    * Returns the wxs harvester with the primary key.
    *
    * @param wxsharvesterid the primary key of the wxs harvester
    * @return the wxs harvester
    * @throws PortalException if a wxs harvester with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public nl.wur.alterra.cgi.ace.model.WxsHarvester getWxsHarvester(
        long wxsharvesterid)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _wxsHarvesterLocalService.getWxsHarvester(wxsharvesterid);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _wxsHarvesterLocalService.getPersistedModel(primaryKeyObj);
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
    public java.util.List<nl.wur.alterra.cgi.ace.model.WxsHarvester> getWxsHarvesters(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _wxsHarvesterLocalService.getWxsHarvesters(start, end);
    }

    /**
    * Returns the number of wxs harvesters.
    *
    * @return the number of wxs harvesters
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getWxsHarvestersCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _wxsHarvesterLocalService.getWxsHarvestersCount();
    }

    /**
    * Updates the wxs harvester in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param wxsHarvester the wxs harvester
    * @return the wxs harvester that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public nl.wur.alterra.cgi.ace.model.WxsHarvester updateWxsHarvester(
        nl.wur.alterra.cgi.ace.model.WxsHarvester wxsHarvester)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _wxsHarvesterLocalService.updateWxsHarvester(wxsHarvester);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _wxsHarvesterLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _wxsHarvesterLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _wxsHarvesterLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
    * Creates empty WxsHarvester.
    *
    * @return wxsharvester
    */
    @Override
    public nl.wur.alterra.cgi.ace.model.WxsHarvester createWxsHarvester() {
        return _wxsHarvesterLocalService.createWxsHarvester();
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
    @Override
    public nl.wur.alterra.cgi.ace.model.WxsHarvester updateWxsHarvester(
        nl.wur.alterra.cgi.ace.model.WxsHarvester wxsHarvester,
        java.lang.Boolean propagateToGeoNetwork, java.lang.Boolean reschedule)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _wxsHarvesterLocalService.updateWxsHarvester(wxsHarvester,
            propagateToGeoNetwork, reschedule);
    }

    /**
    * Gets a list with all the WxsHarvesters in a group.
    */
    @Override
    public java.util.List<nl.wur.alterra.cgi.ace.model.WxsHarvester> getWxsHarvesterByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _wxsHarvesterLocalService.getWxsHarvesterByGroupId(groupId);
    }

    /**
    * Gets a list with a range of WxsHarvesters from a group.
    */
    @Override
    public java.util.List<nl.wur.alterra.cgi.ace.model.WxsHarvester> getWxsHarvestersByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _wxsHarvesterLocalService.getWxsHarvestersByGroupId(groupId,
            start, end);
    }

    /**
    * Gets the number of WxsHarvesters in a group.
    */
    @Override
    public int getWxsHarvestersCountByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _wxsHarvesterLocalService.getWxsHarvestersCountByGroupId(groupId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public WxsHarvesterLocalService getWrappedWxsHarvesterLocalService() {
        return _wxsHarvesterLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedWxsHarvesterLocalService(
        WxsHarvesterLocalService wxsHarvesterLocalService) {
        _wxsHarvesterLocalService = wxsHarvesterLocalService;
    }

    @Override
    public WxsHarvesterLocalService getWrappedService() {
        return _wxsHarvesterLocalService;
    }

    @Override
    public void setWrappedService(
        WxsHarvesterLocalService wxsHarvesterLocalService) {
        _wxsHarvesterLocalService = wxsHarvesterLocalService;
    }
}
