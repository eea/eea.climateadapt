package nl.wur.alterra.cgi.ace.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CSWHarvesterLocalService}.
 *
 * @author groot052
 * @see CSWHarvesterLocalService
 * @generated
 */
public class CSWHarvesterLocalServiceWrapper implements CSWHarvesterLocalService,
    ServiceWrapper<CSWHarvesterLocalService> {
    private CSWHarvesterLocalService _cswHarvesterLocalService;

    public CSWHarvesterLocalServiceWrapper(
        CSWHarvesterLocalService cswHarvesterLocalService) {
        _cswHarvesterLocalService = cswHarvesterLocalService;
    }

    /**
    * Adds the c s w harvester to the database. Also notifies the appropriate model listeners.
    *
    * @param cswHarvester the c s w harvester
    * @return the c s w harvester that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public nl.wur.alterra.cgi.ace.model.CSWHarvester addCSWHarvester(
        nl.wur.alterra.cgi.ace.model.CSWHarvester cswHarvester)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _cswHarvesterLocalService.addCSWHarvester(cswHarvester);
    }

    /**
    * Creates a new c s w harvester with the primary key. Does not add the c s w harvester to the database.
    *
    * @param cswharvesterid the primary key for the new c s w harvester
    * @return the new c s w harvester
    */
    @Override
    public nl.wur.alterra.cgi.ace.model.CSWHarvester createCSWHarvester(
        long cswharvesterid) {
        return _cswHarvesterLocalService.createCSWHarvester(cswharvesterid);
    }

    /**
    * Deletes the c s w harvester with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param cswharvesterid the primary key of the c s w harvester
    * @return the c s w harvester that was removed
    * @throws PortalException if a c s w harvester with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public nl.wur.alterra.cgi.ace.model.CSWHarvester deleteCSWHarvester(
        long cswharvesterid)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _cswHarvesterLocalService.deleteCSWHarvester(cswharvesterid);
    }

    /**
    * Deletes the c s w harvester from the database. Also notifies the appropriate model listeners.
    *
    * @param cswHarvester the c s w harvester
    * @return the c s w harvester that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public nl.wur.alterra.cgi.ace.model.CSWHarvester deleteCSWHarvester(
        nl.wur.alterra.cgi.ace.model.CSWHarvester cswHarvester)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _cswHarvesterLocalService.deleteCSWHarvester(cswHarvester);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _cswHarvesterLocalService.dynamicQuery();
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
        return _cswHarvesterLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.wur.alterra.cgi.ace.model.impl.CSWHarvesterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _cswHarvesterLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.wur.alterra.cgi.ace.model.impl.CSWHarvesterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _cswHarvesterLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _cswHarvesterLocalService.dynamicQueryCount(dynamicQuery);
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
        return _cswHarvesterLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public nl.wur.alterra.cgi.ace.model.CSWHarvester fetchCSWHarvester(
        long cswharvesterid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _cswHarvesterLocalService.fetchCSWHarvester(cswharvesterid);
    }

    /**
    * Returns the c s w harvester with the primary key.
    *
    * @param cswharvesterid the primary key of the c s w harvester
    * @return the c s w harvester
    * @throws PortalException if a c s w harvester with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public nl.wur.alterra.cgi.ace.model.CSWHarvester getCSWHarvester(
        long cswharvesterid)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _cswHarvesterLocalService.getCSWHarvester(cswharvesterid);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _cswHarvesterLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the c s w harvesters.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.wur.alterra.cgi.ace.model.impl.CSWHarvesterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of c s w harvesters
    * @param end the upper bound of the range of c s w harvesters (not inclusive)
    * @return the range of c s w harvesters
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<nl.wur.alterra.cgi.ace.model.CSWHarvester> getCSWHarvesters(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _cswHarvesterLocalService.getCSWHarvesters(start, end);
    }

    /**
    * Returns the number of c s w harvesters.
    *
    * @return the number of c s w harvesters
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getCSWHarvestersCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _cswHarvesterLocalService.getCSWHarvestersCount();
    }

    /**
    * Updates the c s w harvester in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param cswHarvester the c s w harvester
    * @return the c s w harvester that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public nl.wur.alterra.cgi.ace.model.CSWHarvester updateCSWHarvester(
        nl.wur.alterra.cgi.ace.model.CSWHarvester cswHarvester)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _cswHarvesterLocalService.updateCSWHarvester(cswHarvester);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _cswHarvesterLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _cswHarvesterLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _cswHarvesterLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
    * Creates empty CSWHarvester.
    *
    * @return cswharvester
    */
    @Override
    public nl.wur.alterra.cgi.ace.model.CSWHarvester createCSWHarvester() {
        return _cswHarvesterLocalService.createCSWHarvester();
    }

    /**
    * Updates a CSWHarvester. Also tries to update in GeoNetwork if asked to do so. Sets status to GEONETWORK_UPDATE_FAILURE
    * if GeoNetwork update fails; sets it to NEVER_RUN if status was not already SUCCESS. Removes existing scheduler and
    * creates a new one if asked to do so.
    *
    * @param cswHarvester
    * @param propagateToGeoNetwork
    * @param reschedule
    * @return
    * @throws com.liferay.portal.kernel.exception.SystemException
    */
    @Override
    public nl.wur.alterra.cgi.ace.model.CSWHarvester updateCSWHarvester(
        nl.wur.alterra.cgi.ace.model.CSWHarvester cswHarvester,
        java.lang.Boolean propagateToGeoNetwork, java.lang.Boolean reschedule)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _cswHarvesterLocalService.updateCSWHarvester(cswHarvester,
            propagateToGeoNetwork, reschedule);
    }

    /**
    * Gets a list with all the CSWHarvesters in a group.
    */
    @Override
    public java.util.List<nl.wur.alterra.cgi.ace.model.CSWHarvester> getCSWHarvesterByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _cswHarvesterLocalService.getCSWHarvesterByGroupId(groupId);
    }

    /**
    * Gets a list with a range of CSWHarvesters from a group.
    */
    @Override
    public java.util.List<nl.wur.alterra.cgi.ace.model.CSWHarvester> getCSWHarvestersByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _cswHarvesterLocalService.getCSWHarvestersByGroupId(groupId,
            start, end);
    }

    /**
    * Gets the number of CSWHarvesters in a group.
    */
    @Override
    public int getCSWHarvestersCountByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _cswHarvesterLocalService.getCSWHarvestersCountByGroupId(groupId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public CSWHarvesterLocalService getWrappedCSWHarvesterLocalService() {
        return _cswHarvesterLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedCSWHarvesterLocalService(
        CSWHarvesterLocalService cswHarvesterLocalService) {
        _cswHarvesterLocalService = cswHarvesterLocalService;
    }

    @Override
    public CSWHarvesterLocalService getWrappedService() {
        return _cswHarvesterLocalService;
    }

    @Override
    public void setWrappedService(
        CSWHarvesterLocalService cswHarvesterLocalService) {
        _cswHarvesterLocalService = cswHarvesterLocalService;
    }
}
