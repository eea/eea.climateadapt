package eu.europa.eea.mayors_adapt.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for Data. This utility wraps
 * {@link eu.europa.eea.mayors_adapt.service.impl.DataServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see DataService
 * @see eu.europa.eea.mayors_adapt.service.base.DataServiceBaseImpl
 * @see eu.europa.eea.mayors_adapt.service.impl.DataServiceImpl
 * @generated
 */
public class DataServiceUtil {
    private static DataService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link eu.europa.eea.mayors_adapt.service.impl.DataServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

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

    public static java.util.TreeSet<java.lang.String> getDataTypes() {
        return getService().getDataTypes();
    }

    public static java.util.TreeSet<java.lang.String> getAdaptationSectors() {
        return getService().getAdaptationSectors();
    }

    public static java.util.TreeSet<java.lang.String> getClimateImpacts() {
        return getService().getClimateImpacts();
    }

    public static java.util.TreeSet<java.lang.String> getAdaptationElements() {
        return getService().getAdaptationElements();
    }

    public static java.util.TreeSet<java.lang.String> getCountries() {
        return getService().getCountries();
    }

    public static com.liferay.portlet.dynamicdatamapping.model.DDMStructure getStructure()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getStructure();
    }

    public static java.util.TreeMap<java.lang.String,java.lang.String> getCitiesByCriteria(
        java.util.List<java.lang.String> countries,
        java.util.List<java.lang.String> sectors,
        java.util.List<java.lang.String> impacts,
        java.util.List<java.lang.String> stages) {
        return getService()
                   .getCitiesByCriteria(countries, sectors, impacts, stages);
    }

    public static void clearService() {
        _service = null;
    }

    public static DataService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    DataService.class.getName());

            if (invokableService instanceof DataService) {
                _service = (DataService) invokableService;
            } else {
                _service = new DataServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(DataServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(DataService service) {
    }
}
