package nl.wur.alterra.cgi.ace.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import nl.wur.alterra.cgi.ace.model.Measure;

/**
 * The persistence interface for the measure service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author groot052
 * @see MeasurePersistenceImpl
 * @see MeasureUtil
 * @generated
 */
public interface MeasurePersistence extends BasePersistence<Measure> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link MeasureUtil} to access the measure persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the measures where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching measures
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<nl.wur.alterra.cgi.ace.model.Measure> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<nl.wur.alterra.cgi.ace.model.Measure> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<nl.wur.alterra.cgi.ace.model.Measure> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first measure in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching measure
    * @throws nl.wur.alterra.cgi.ace.NoSuchMeasureException if a matching measure could not be found
    * @throws SystemException if a system exception occurred
    */
    public nl.wur.alterra.cgi.ace.model.Measure findByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.wur.alterra.cgi.ace.NoSuchMeasureException;

    /**
    * Returns the first measure in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching measure, or <code>null</code> if a matching measure could not be found
    * @throws SystemException if a system exception occurred
    */
    public nl.wur.alterra.cgi.ace.model.Measure fetchByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last measure in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching measure
    * @throws nl.wur.alterra.cgi.ace.NoSuchMeasureException if a matching measure could not be found
    * @throws SystemException if a system exception occurred
    */
    public nl.wur.alterra.cgi.ace.model.Measure findByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.wur.alterra.cgi.ace.NoSuchMeasureException;

    /**
    * Returns the last measure in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching measure, or <code>null</code> if a matching measure could not be found
    * @throws SystemException if a system exception occurred
    */
    public nl.wur.alterra.cgi.ace.model.Measure fetchByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public nl.wur.alterra.cgi.ace.model.Measure[] findByGroupId_PrevAndNext(
        long measureId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.wur.alterra.cgi.ace.NoSuchMeasureException;

    /**
    * Removes all the measures where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of measures where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching measures
    * @throws SystemException if a system exception occurred
    */
    public int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the measures where controlstatus = &#63;.
    *
    * @param controlstatus the controlstatus
    * @return the matching measures
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<nl.wur.alterra.cgi.ace.model.Measure> findByControlstatus(
        short controlstatus)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<nl.wur.alterra.cgi.ace.model.Measure> findByControlstatus(
        short controlstatus, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<nl.wur.alterra.cgi.ace.model.Measure> findByControlstatus(
        short controlstatus, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first measure in the ordered set where controlstatus = &#63;.
    *
    * @param controlstatus the controlstatus
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching measure
    * @throws nl.wur.alterra.cgi.ace.NoSuchMeasureException if a matching measure could not be found
    * @throws SystemException if a system exception occurred
    */
    public nl.wur.alterra.cgi.ace.model.Measure findByControlstatus_First(
        short controlstatus,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.wur.alterra.cgi.ace.NoSuchMeasureException;

    /**
    * Returns the first measure in the ordered set where controlstatus = &#63;.
    *
    * @param controlstatus the controlstatus
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching measure, or <code>null</code> if a matching measure could not be found
    * @throws SystemException if a system exception occurred
    */
    public nl.wur.alterra.cgi.ace.model.Measure fetchByControlstatus_First(
        short controlstatus,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last measure in the ordered set where controlstatus = &#63;.
    *
    * @param controlstatus the controlstatus
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching measure
    * @throws nl.wur.alterra.cgi.ace.NoSuchMeasureException if a matching measure could not be found
    * @throws SystemException if a system exception occurred
    */
    public nl.wur.alterra.cgi.ace.model.Measure findByControlstatus_Last(
        short controlstatus,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.wur.alterra.cgi.ace.NoSuchMeasureException;

    /**
    * Returns the last measure in the ordered set where controlstatus = &#63;.
    *
    * @param controlstatus the controlstatus
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching measure, or <code>null</code> if a matching measure could not be found
    * @throws SystemException if a system exception occurred
    */
    public nl.wur.alterra.cgi.ace.model.Measure fetchByControlstatus_Last(
        short controlstatus,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public nl.wur.alterra.cgi.ace.model.Measure[] findByControlstatus_PrevAndNext(
        long measureId, short controlstatus,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.wur.alterra.cgi.ace.NoSuchMeasureException;

    /**
    * Removes all the measures where controlstatus = &#63; from the database.
    *
    * @param controlstatus the controlstatus
    * @throws SystemException if a system exception occurred
    */
    public void removeByControlstatus(short controlstatus)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of measures where controlstatus = &#63;.
    *
    * @param controlstatus the controlstatus
    * @return the number of matching measures
    * @throws SystemException if a system exception occurred
    */
    public int countByControlstatus(short controlstatus)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the measure in the entity cache if it is enabled.
    *
    * @param measure the measure
    */
    public void cacheResult(nl.wur.alterra.cgi.ace.model.Measure measure);

    /**
    * Caches the measures in the entity cache if it is enabled.
    *
    * @param measures the measures
    */
    public void cacheResult(
        java.util.List<nl.wur.alterra.cgi.ace.model.Measure> measures);

    /**
    * Creates a new measure with the primary key. Does not add the measure to the database.
    *
    * @param measureId the primary key for the new measure
    * @return the new measure
    */
    public nl.wur.alterra.cgi.ace.model.Measure create(long measureId);

    /**
    * Removes the measure with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param measureId the primary key of the measure
    * @return the measure that was removed
    * @throws nl.wur.alterra.cgi.ace.NoSuchMeasureException if a measure with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public nl.wur.alterra.cgi.ace.model.Measure remove(long measureId)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.wur.alterra.cgi.ace.NoSuchMeasureException;

    public nl.wur.alterra.cgi.ace.model.Measure updateImpl(
        nl.wur.alterra.cgi.ace.model.Measure measure)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the measure with the primary key or throws a {@link nl.wur.alterra.cgi.ace.NoSuchMeasureException} if it could not be found.
    *
    * @param measureId the primary key of the measure
    * @return the measure
    * @throws nl.wur.alterra.cgi.ace.NoSuchMeasureException if a measure with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public nl.wur.alterra.cgi.ace.model.Measure findByPrimaryKey(long measureId)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.wur.alterra.cgi.ace.NoSuchMeasureException;

    /**
    * Returns the measure with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param measureId the primary key of the measure
    * @return the measure, or <code>null</code> if a measure with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public nl.wur.alterra.cgi.ace.model.Measure fetchByPrimaryKey(
        long measureId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the measures.
    *
    * @return the measures
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<nl.wur.alterra.cgi.ace.model.Measure> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<nl.wur.alterra.cgi.ace.model.Measure> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<nl.wur.alterra.cgi.ace.model.Measure> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the measures from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of measures.
    *
    * @return the number of measures
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
