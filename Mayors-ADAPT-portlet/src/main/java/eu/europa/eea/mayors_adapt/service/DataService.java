package eu.europa.eea.mayors_adapt.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.BaseService;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service interface for Data. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see DataServiceUtil
 * @see eu.europa.eea.mayors_adapt.service.base.DataServiceBaseImpl
 * @see eu.europa.eea.mayors_adapt.service.impl.DataServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface DataService extends BaseService, InvokableService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link DataServiceUtil} to access the data remote service. Add custom service methods to {@link eu.europa.eea.mayors_adapt.service.impl.DataServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

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

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.TreeMap<java.lang.String, java.lang.String> getDataTypes();

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.TreeMap<java.lang.String, java.lang.String> getAdaptationSectors();

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.TreeMap<java.lang.String, java.lang.String> getClimateImpacts();

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.TreeMap<java.lang.String, java.lang.String> getAdaptationElements();

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.TreeMap<java.lang.String, java.lang.String> getCountries();

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portlet.dynamicdatamapping.model.DDMStructure getStructure()
        throws com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.TreeSet<java.lang.String> getCitiesByCriteria(
        java.util.List<java.lang.String> countries,
        java.util.List<java.lang.String> sectors,
        java.util.List<java.lang.String> impacts,
        java.util.List<java.lang.String> stages);
}
