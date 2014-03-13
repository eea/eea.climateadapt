package nl.wur.alterra.cgi.ace.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import nl.wur.alterra.cgi.ace.model.Measure;

import java.util.List;

/**
 * The persistence utility for the measure service. This utility wraps {@link MeasurePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author groot052
 * @see MeasurePersistence
 * @see MeasurePersistenceImpl
 * @generated
 */
public class MeasureUtil {
    private static MeasurePersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(Measure measure) {
        getPersistence().clearCache(measure);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<Measure> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Measure> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Measure> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Measure update(Measure measure) throws SystemException {
        return getPersistence().update(measure);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Measure update(Measure measure, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(measure, serviceContext);
    }

    /**
    * Returns all the measures where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching measures
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<nl.wur.alterra.cgi.ace.model.Measure> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId(groupId);
    }

    /**
    * Returns a range of all the measures where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.wur.alterra.cgi.ace.model.impl.MeasureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of measures
    * @param end the upper bound of the range of measures (not inclusive)
    * @return the range of matching measures
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<nl.wur.alterra.cgi.ace.model.Measure> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId(groupId, start, end);
    }

    /**
    * Returns an ordered range of all the measures where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.wur.alterra.cgi.ace.model.impl.MeasureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of measures
    * @param end the upper bound of the range of measures (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching measures
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<nl.wur.alterra.cgi.ace.model.Measure> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupId(groupId, start, end, orderByComparator);
    }

    /**
    * Returns the first measure in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching measure
    * @throws nl.wur.alterra.cgi.ace.NoSuchMeasureException if a matching measure could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.Measure findByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.wur.alterra.cgi.ace.NoSuchMeasureException {
        return getPersistence().findByGroupId_First(groupId, orderByComparator);
    }

    /**
    * Returns the first measure in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching measure, or <code>null</code> if a matching measure could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.Measure fetchByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
    }

    /**
    * Returns the last measure in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching measure
    * @throws nl.wur.alterra.cgi.ace.NoSuchMeasureException if a matching measure could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.Measure findByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.wur.alterra.cgi.ace.NoSuchMeasureException {
        return getPersistence().findByGroupId_Last(groupId, orderByComparator);
    }

    /**
    * Returns the last measure in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching measure, or <code>null</code> if a matching measure could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.Measure fetchByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
    }

    /**
    * Returns the measures before and after the current measure in the ordered set where groupId = &#63;.
    *
    * @param measureId the primary key of the current measure
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next measure
    * @throws nl.wur.alterra.cgi.ace.NoSuchMeasureException if a measure with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.Measure[] findByGroupId_PrevAndNext(
        long measureId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.wur.alterra.cgi.ace.NoSuchMeasureException {
        return getPersistence()
                   .findByGroupId_PrevAndNext(measureId, groupId,
            orderByComparator);
    }

    /**
    * Removes all the measures where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByGroupId(groupId);
    }

    /**
    * Returns the number of measures where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching measures
    * @throws SystemException if a system exception occurred
    */
    public static int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByGroupId(groupId);
    }

    /**
    * Returns all the measures where controlstatus = &#63;.
    *
    * @param controlstatus the controlstatus
    * @return the matching measures
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<nl.wur.alterra.cgi.ace.model.Measure> findByControlstatus(
        short controlstatus)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByControlstatus(controlstatus);
    }

    /**
    * Returns a range of all the measures where controlstatus = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.wur.alterra.cgi.ace.model.impl.MeasureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param controlstatus the controlstatus
    * @param start the lower bound of the range of measures
    * @param end the upper bound of the range of measures (not inclusive)
    * @return the range of matching measures
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<nl.wur.alterra.cgi.ace.model.Measure> findByControlstatus(
        short controlstatus, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByControlstatus(controlstatus, start, end);
    }

    /**
    * Returns an ordered range of all the measures where controlstatus = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.wur.alterra.cgi.ace.model.impl.MeasureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param controlstatus the controlstatus
    * @param start the lower bound of the range of measures
    * @param end the upper bound of the range of measures (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching measures
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<nl.wur.alterra.cgi.ace.model.Measure> findByControlstatus(
        short controlstatus, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByControlstatus(controlstatus, start, end,
            orderByComparator);
    }

    /**
    * Returns the first measure in the ordered set where controlstatus = &#63;.
    *
    * @param controlstatus the controlstatus
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching measure
    * @throws nl.wur.alterra.cgi.ace.NoSuchMeasureException if a matching measure could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.Measure findByControlstatus_First(
        short controlstatus,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.wur.alterra.cgi.ace.NoSuchMeasureException {
        return getPersistence()
                   .findByControlstatus_First(controlstatus, orderByComparator);
    }

    /**
    * Returns the first measure in the ordered set where controlstatus = &#63;.
    *
    * @param controlstatus the controlstatus
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching measure, or <code>null</code> if a matching measure could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.Measure fetchByControlstatus_First(
        short controlstatus,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByControlstatus_First(controlstatus, orderByComparator);
    }

    /**
    * Returns the last measure in the ordered set where controlstatus = &#63;.
    *
    * @param controlstatus the controlstatus
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching measure
    * @throws nl.wur.alterra.cgi.ace.NoSuchMeasureException if a matching measure could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.Measure findByControlstatus_Last(
        short controlstatus,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.wur.alterra.cgi.ace.NoSuchMeasureException {
        return getPersistence()
                   .findByControlstatus_Last(controlstatus, orderByComparator);
    }

    /**
    * Returns the last measure in the ordered set where controlstatus = &#63;.
    *
    * @param controlstatus the controlstatus
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching measure, or <code>null</code> if a matching measure could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.Measure fetchByControlstatus_Last(
        short controlstatus,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByControlstatus_Last(controlstatus, orderByComparator);
    }

    /**
    * Returns the measures before and after the current measure in the ordered set where controlstatus = &#63;.
    *
    * @param measureId the primary key of the current measure
    * @param controlstatus the controlstatus
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next measure
    * @throws nl.wur.alterra.cgi.ace.NoSuchMeasureException if a measure with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.Measure[] findByControlstatus_PrevAndNext(
        long measureId, short controlstatus,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.wur.alterra.cgi.ace.NoSuchMeasureException {
        return getPersistence()
                   .findByControlstatus_PrevAndNext(measureId, controlstatus,
            orderByComparator);
    }

    /**
    * Removes all the measures where controlstatus = &#63; from the database.
    *
    * @param controlstatus the controlstatus
    * @throws SystemException if a system exception occurred
    */
    public static void removeByControlstatus(short controlstatus)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByControlstatus(controlstatus);
    }

    /**
    * Returns the number of measures where controlstatus = &#63;.
    *
    * @param controlstatus the controlstatus
    * @return the number of matching measures
    * @throws SystemException if a system exception occurred
    */
    public static int countByControlstatus(short controlstatus)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByControlstatus(controlstatus);
    }

    /**
    * Caches the measure in the entity cache if it is enabled.
    *
    * @param measure the measure
    */
    public static void cacheResult(nl.wur.alterra.cgi.ace.model.Measure measure) {
        getPersistence().cacheResult(measure);
    }

    /**
    * Caches the measures in the entity cache if it is enabled.
    *
    * @param measures the measures
    */
    public static void cacheResult(
        java.util.List<nl.wur.alterra.cgi.ace.model.Measure> measures) {
        getPersistence().cacheResult(measures);
    }

    /**
    * Creates a new measure with the primary key. Does not add the measure to the database.
    *
    * @param measureId the primary key for the new measure
    * @return the new measure
    */
    public static nl.wur.alterra.cgi.ace.model.Measure create(long measureId) {
        return getPersistence().create(measureId);
    }

    /**
    * Removes the measure with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param measureId the primary key of the measure
    * @return the measure that was removed
    * @throws nl.wur.alterra.cgi.ace.NoSuchMeasureException if a measure with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.Measure remove(long measureId)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.wur.alterra.cgi.ace.NoSuchMeasureException {
        return getPersistence().remove(measureId);
    }

    public static nl.wur.alterra.cgi.ace.model.Measure updateImpl(
        nl.wur.alterra.cgi.ace.model.Measure measure)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(measure);
    }

    /**
    * Returns the measure with the primary key or throws a {@link nl.wur.alterra.cgi.ace.NoSuchMeasureException} if it could not be found.
    *
    * @param measureId the primary key of the measure
    * @return the measure
    * @throws nl.wur.alterra.cgi.ace.NoSuchMeasureException if a measure with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.Measure findByPrimaryKey(
        long measureId)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.wur.alterra.cgi.ace.NoSuchMeasureException {
        return getPersistence().findByPrimaryKey(measureId);
    }

    /**
    * Returns the measure with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param measureId the primary key of the measure
    * @return the measure, or <code>null</code> if a measure with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.Measure fetchByPrimaryKey(
        long measureId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(measureId);
    }

    /**
    * Returns all the measures.
    *
    * @return the measures
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<nl.wur.alterra.cgi.ace.model.Measure> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

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
    public static java.util.List<nl.wur.alterra.cgi.ace.model.Measure> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the measures.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.wur.alterra.cgi.ace.model.impl.MeasureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of measures
    * @param end the upper bound of the range of measures (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of measures
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<nl.wur.alterra.cgi.ace.model.Measure> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the measures from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of measures.
    *
    * @return the number of measures
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static MeasurePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (MeasurePersistence) PortletBeanLocatorUtil.locate(nl.wur.alterra.cgi.ace.service.ClpSerializer.getServletContextName(),
                    MeasurePersistence.class.getName());

            ReferenceRegistry.registerReference(MeasureUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(MeasurePersistence persistence) {
    }
}
