package nl.wur.alterra.cgi.ace.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * Provides the local service interface for CSWHarvester. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author groot052
 * @see CSWHarvesterLocalServiceUtil
 * @see nl.wur.alterra.cgi.ace.service.base.CSWHarvesterLocalServiceBaseImpl
 * @see nl.wur.alterra.cgi.ace.service.impl.CSWHarvesterLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface CSWHarvesterLocalService extends BaseLocalService,
    InvokableLocalService, PersistedModelLocalService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link CSWHarvesterLocalServiceUtil} to access the c s w harvester local service. Add custom service methods to {@link nl.wur.alterra.cgi.ace.service.impl.CSWHarvesterLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Adds the c s w harvester to the database. Also notifies the appropriate model listeners.
    *
    * @param cswHarvester the c s w harvester
    * @return the c s w harvester that was added
    * @throws SystemException if a system exception occurred
    */
    public nl.wur.alterra.cgi.ace.model.CSWHarvester addCSWHarvester(
        nl.wur.alterra.cgi.ace.model.CSWHarvester cswHarvester)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Creates a new c s w harvester with the primary key. Does not add the c s w harvester to the database.
    *
    * @param cswharvesterid the primary key for the new c s w harvester
    * @return the new c s w harvester
    */
    public nl.wur.alterra.cgi.ace.model.CSWHarvester createCSWHarvester(
        long cswharvesterid);

    /**
    * Deletes the c s w harvester with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param cswharvesterid the primary key of the c s w harvester
    * @return the c s w harvester that was removed
    * @throws PortalException if a c s w harvester with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public nl.wur.alterra.cgi.ace.model.CSWHarvester deleteCSWHarvester(
        long cswharvesterid)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Deletes the c s w harvester from the database. Also notifies the appropriate model listeners.
    *
    * @param cswHarvester the c s w harvester
    * @return the c s w harvester that was removed
    * @throws SystemException if a system exception occurred
    */
    public nl.wur.alterra.cgi.ace.model.CSWHarvester deleteCSWHarvester(
        nl.wur.alterra.cgi.ace.model.CSWHarvester cswHarvester)
        throws com.liferay.portal.kernel.exception.SystemException;

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

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
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public nl.wur.alterra.cgi.ace.model.CSWHarvester fetchCSWHarvester(
        long cswharvesterid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the c s w harvester with the primary key.
    *
    * @param cswharvesterid the primary key of the c s w harvester
    * @return the c s w harvester
    * @throws PortalException if a c s w harvester with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public nl.wur.alterra.cgi.ace.model.CSWHarvester getCSWHarvester(
        long cswharvesterid)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<nl.wur.alterra.cgi.ace.model.CSWHarvester> getCSWHarvesters(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of c s w harvesters.
    *
    * @return the number of c s w harvesters
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getCSWHarvestersCount()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Updates the c s w harvester in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param cswHarvester the c s w harvester
    * @return the c s w harvester that was updated
    * @throws SystemException if a system exception occurred
    */
    public nl.wur.alterra.cgi.ace.model.CSWHarvester updateCSWHarvester(
        nl.wur.alterra.cgi.ace.model.CSWHarvester cswHarvester)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier();

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier);

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable;

    /**
    * Creates empty CSWHarvester.
    *
    * @return cswharvester
    */
    public nl.wur.alterra.cgi.ace.model.CSWHarvester createCSWHarvester();

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
    public nl.wur.alterra.cgi.ace.model.CSWHarvester updateCSWHarvester(
        nl.wur.alterra.cgi.ace.model.CSWHarvester cswHarvester,
        java.lang.Boolean propagateToGeoNetwork, java.lang.Boolean reschedule)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Gets a list with all the CSWHarvesters in a group.
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<nl.wur.alterra.cgi.ace.model.CSWHarvester> getCSWHarvesterByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Gets a list with a range of CSWHarvesters from a group.
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<nl.wur.alterra.cgi.ace.model.CSWHarvester> getCSWHarvestersByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Gets the number of CSWHarvesters in a group.
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getCSWHarvestersCountByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;
}
