package eu.europa.eea.mayors_adapt.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DataService}.
 *
 * @author Brian Wing Shun Chan
 * @see DataService
 * @generated
 */
public class DataServiceWrapper implements DataService,
    ServiceWrapper<DataService> {
    private DataService _dataService;

    public DataServiceWrapper(DataService dataService) {
        _dataService = dataService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _dataService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _dataService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _dataService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    //public java.util.TreeSet<java.lang.String> getOptions(
    public java.util.Set<java.lang.String> getOptions(
        java.lang.String fieldName) {
        return _dataService.getOptions(fieldName);
    }

    @Override
    public java.util.TreeSet<java.lang.String> getFieldsNames() {
        return _dataService.getFieldsNames();
    }

    @Override
    public java.util.TreeMap<java.lang.String, java.lang.String> getCitiesByCriteria(
        java.util.List<java.lang.String> countries,
        java.util.List<java.lang.String> sectors,
        java.util.List<java.lang.String> impacts,
        java.util.List<java.lang.String> stages) {
        return _dataService.getCitiesByCriteria(countries, sectors, impacts,
            stages);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public DataService getWrappedDataService() {
        return _dataService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedDataService(DataService dataService) {
        _dataService = dataService;
    }

    @Override
    public DataService getWrappedService() {
        return _dataService;
    }

    @Override
    public void setWrappedService(DataService dataService) {
        _dataService = dataService;
    }
}
