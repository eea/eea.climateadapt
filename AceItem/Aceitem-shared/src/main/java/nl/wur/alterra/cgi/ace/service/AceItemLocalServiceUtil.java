package nl.wur.alterra.cgi.ace.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for AceItem. This utility wraps
 * {@link nl.wur.alterra.cgi.ace.service.impl.AceItemLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author groot052
 * @see AceItemLocalService
 * @see nl.wur.alterra.cgi.ace.service.base.AceItemLocalServiceBaseImpl
 * @see nl.wur.alterra.cgi.ace.service.impl.AceItemLocalServiceImpl
 * @generated
 */
public class AceItemLocalServiceUtil {
    private static AceItemLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link nl.wur.alterra.cgi.ace.service.impl.AceItemLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the ace item to the database. Also notifies the appropriate model listeners.
    *
    * @param aceItem the ace item
    * @return the ace item that was added
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.AceItem addAceItem(
        nl.wur.alterra.cgi.ace.model.AceItem aceItem)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addAceItem(aceItem);
    }

    /**
    * Creates a new ace item with the primary key. Does not add the ace item to the database.
    *
    * @param aceItemId the primary key for the new ace item
    * @return the new ace item
    */
    public static nl.wur.alterra.cgi.ace.model.AceItem createAceItem(
        long aceItemId) {
        return getService().createAceItem(aceItemId);
    }

    /**
    * Deletes the ace item with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param aceItemId the primary key of the ace item
    * @return the ace item that was removed
    * @throws PortalException if a ace item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.AceItem deleteAceItem(
        long aceItemId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteAceItem(aceItemId);
    }

    /**
    * Deletes the ace item from the database. Also notifies the appropriate model listeners.
    *
    * @param aceItem the ace item
    * @return the ace item that was removed
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.AceItem deleteAceItem(
        nl.wur.alterra.cgi.ace.model.AceItem aceItem)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteAceItem(aceItem);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.wur.alterra.cgi.ace.model.impl.AceItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.wur.alterra.cgi.ace.model.impl.AceItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static nl.wur.alterra.cgi.ace.model.AceItem fetchAceItem(
        long aceItemId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchAceItem(aceItemId);
    }

    /**
    * Returns the ace item with the primary key.
    *
    * @param aceItemId the primary key of the ace item
    * @return the ace item
    * @throws PortalException if a ace item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.AceItem getAceItem(
        long aceItemId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getAceItem(aceItemId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the ace items.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.wur.alterra.cgi.ace.model.impl.AceItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of ace items
    * @param end the upper bound of the range of ace items (not inclusive)
    * @return the range of ace items
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<nl.wur.alterra.cgi.ace.model.AceItem> getAceItems(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAceItems(start, end);
    }

    /**
    * Returns the number of ace items.
    *
    * @return the number of ace items
    * @throws SystemException if a system exception occurred
    */
    public static int getAceItemsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAceItemsCount();
    }

    /**
    * Updates the ace item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param aceItem the ace item
    * @return the ace item that was updated
    * @throws SystemException if a system exception occurred
    */
    public static nl.wur.alterra.cgi.ace.model.AceItem updateAceItem(
        nl.wur.alterra.cgi.ace.model.AceItem aceItem)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateAceItem(aceItem);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    /**
    * Creates new empty aceitem.
    *
    * @return
    */
    public static nl.wur.alterra.cgi.ace.model.AceItem createAceItem() {
        return getService().createAceItem();
    }

    /**
    * Retrieves an AceItem by its storedAt value.
    *
    * @param s requested storedAt value
    * @return aceitem, or null if not found
    * @throws SystemException hmm
    */
    public static nl.wur.alterra.cgi.ace.model.AceItem getAceItemByStoredAt(
        java.lang.String s)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAceItemByStoredAt(s);
    }

    /**
    * Hugo de Groot: add these methods by hand to <portlet>LocalServiceImpl
    * and rerun ServiceBuilder if auto generation fails
    *
    * Gets a list with all the AceItems in a group
    */
    public static java.util.List<nl.wur.alterra.cgi.ace.model.AceItem> getAceItemsByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAceItemsByGroupId(groupId);
    }

    /**
    * Hugo de Groot: add these methods by hand to <portlet>LocalServiceImpl
    * and rerun ServiceBuilder if auto generation fails
    *
    * Gets a list with a range of AceItems from a group
    */
    public static java.util.List<nl.wur.alterra.cgi.ace.model.AceItem> getAceItemsByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAceItemsByGroupId(groupId, start, end);
    }

    /**
    * Hugo de Groot: add these methods by hand to <portlet>LocalServiceImpl
    * and rerun ServiceBuilder if auto generation fails
    *
    * Gets a list with a range of AceItems from a group
    */
    public static java.util.List<nl.wur.alterra.cgi.ace.model.AceItem> getAceItemsByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .getAceItemsByGroupId(groupId, start, end, orderByComparator);
    }

    /**
    * Hugo de Groot: add these methods by hand to <portlet>LocalServiceImpl
    * and rerun ServiceBuilder if auto generation fails
    *
    * Gets the number of AceItems in a group
    */
    public static int getAceItemsCountByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAceItemsCountByGroupId(groupId);
    }

    /**
    * Retrieves aceitems by nas id, which contains the ids of the wxsharvester that created the aceitems.
    *
    * @author heikki doeleman
    * @param wxsHarvesterId
    * @return
    * @throws SystemException
    */
    public static java.util.List<nl.wur.alterra.cgi.ace.model.AceItem> getAceItemsByWxsharvesterId(
        long wxsHarvesterId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAceItemsByWxsharvesterId(wxsHarvesterId);
    }

    /**
    * Retrieves aceitems by nas id, which contains the ids of the cswharvester that created the aceitems.
    *
    * @author heikki doeleman
    * @param cswHarvesterId
    * @return
    * @throws SystemException
    */
    public static java.util.List<nl.wur.alterra.cgi.ace.model.AceItem> getAceItemsByCSWharvesterId(
        long cswHarvesterId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAceItemsByCSWharvesterId(cswHarvesterId);
    }

    public static void clearService() {
        _service = null;
    }

    public static AceItemLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    AceItemLocalService.class.getName());

            if (invokableLocalService instanceof AceItemLocalService) {
                _service = (AceItemLocalService) invokableLocalService;
            } else {
                _service = new AceItemLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(AceItemLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(AceItemLocalService service) {
    }
}
