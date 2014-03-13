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
 * Provides the local service interface for Measure. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author groot052
 * @see MeasureLocalServiceUtil
 * @see nl.wur.alterra.cgi.ace.service.base.MeasureLocalServiceBaseImpl
 * @see nl.wur.alterra.cgi.ace.service.impl.MeasureLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface MeasureLocalService extends BaseLocalService,
    InvokableLocalService, PersistedModelLocalService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link MeasureLocalServiceUtil} to access the measure local service. Add custom service methods to {@link nl.wur.alterra.cgi.ace.service.impl.MeasureLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Adds the measure to the database. Also notifies the appropriate model listeners.
    *
    * @param measure the measure
    * @return the measure that was added
    * @throws SystemException if a system exception occurred
    */
    public nl.wur.alterra.cgi.ace.model.Measure addMeasure(
        nl.wur.alterra.cgi.ace.model.Measure measure)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Creates a new measure with the primary key. Does not add the measure to the database.
    *
    * @param measureId the primary key for the new measure
    * @return the new measure
    */
    public nl.wur.alterra.cgi.ace.model.Measure createMeasure(long measureId);

    /**
    * Deletes the measure with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param measureId the primary key of the measure
    * @return the measure that was removed
    * @throws PortalException if a measure with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public nl.wur.alterra.cgi.ace.model.Measure deleteMeasure(long measureId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Deletes the measure from the database. Also notifies the appropriate model listeners.
    *
    * @param measure the measure
    * @return the measure that was removed
    * @throws SystemException if a system exception occurred
    */
    public nl.wur.alterra.cgi.ace.model.Measure deleteMeasure(
        nl.wur.alterra.cgi.ace.model.Measure measure)
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.wur.alterra.cgi.ace.model.impl.MeasureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.wur.alterra.cgi.ace.model.impl.MeasureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    public nl.wur.alterra.cgi.ace.model.Measure fetchMeasure(long measureId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the measure with the primary key.
    *
    * @param measureId the primary key of the measure
    * @return the measure
    * @throws PortalException if a measure with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public nl.wur.alterra.cgi.ace.model.Measure getMeasure(long measureId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the measures.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.wur.alterra.cgi.ace.model.impl.MeasureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of measures
    * @param end the upper bound of the range of measures (not inclusive)
    * @return the range of measures
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<nl.wur.alterra.cgi.ace.model.Measure> getMeasures(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of measures.
    *
    * @return the number of measures
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getMeasuresCount()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Updates the measure in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param measure the measure
    * @return the measure that was updated
    * @throws SystemException if a system exception occurred
    */
    public nl.wur.alterra.cgi.ace.model.Measure updateMeasure(
        nl.wur.alterra.cgi.ace.model.Measure measure)
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
    * Hugo de Groot: add these methods by hand to <portlet>LocalServiceImpl
    * and rerun ServiceBuilder if auto generation fails
    *
    * Gets a list with all the Measures in a group
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<nl.wur.alterra.cgi.ace.model.Measure> getMeasuresByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Hugo de Groot: add these methods by hand to <portlet>LocalServiceImpl
    * and rerun ServiceBuilder if auto generation fails
    *
    * Gets a list with a range of Measures from a group
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<nl.wur.alterra.cgi.ace.model.Measure> getMeasuresByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Hugo de Groot: add these methods by hand to <portlet>LocalServiceImpl
    * and rerun ServiceBuilder if auto generation fails
    *
    * Gets a list with a range of Measures from a group
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<nl.wur.alterra.cgi.ace.model.Measure> getMeasuresByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Hugo de Groot: add these methods by hand to <portlet>LocalServiceImpl
    * and rerun ServiceBuilder if auto generation fails
    *
    * Gets the number of Measures in a group
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getMeasuresCountByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Gets a list with all the Measures by controlstatus
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<nl.wur.alterra.cgi.ace.model.Measure> getMeasuresByControlstatus(
        short controlstatus)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Gets a list with a range of Measures by controlstatus
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<nl.wur.alterra.cgi.ace.model.Measure> getMeasuresByGroupId(
        short controlstatus, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Gets a list with a range of Measures by controlstatus
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<nl.wur.alterra.cgi.ace.model.Measure> getMeasuresByControlstatus(
        short controlstatus, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Gets the number of Measures by controlstatus
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getMeasuresCountByGroupId(short controlstatus)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Gets the number of Measures by controlstatus
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getMeasuresCountByControlstatus(short controlstatus)
        throws com.liferay.portal.kernel.exception.SystemException;
}
