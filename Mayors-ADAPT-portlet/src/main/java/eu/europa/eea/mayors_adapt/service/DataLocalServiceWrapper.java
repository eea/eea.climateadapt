package eu.europa.eea.mayors_adapt.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DataLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DataLocalService
 * @generated
 */
public class DataLocalServiceWrapper implements DataLocalService,
    ServiceWrapper<DataLocalService> {
    private DataLocalService _dataLocalService;

    public DataLocalServiceWrapper(DataLocalService dataLocalService) {
        _dataLocalService = dataLocalService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _dataLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _dataLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _dataLocalService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public DataLocalService getWrappedDataLocalService() {
        return _dataLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedDataLocalService(DataLocalService dataLocalService) {
        _dataLocalService = dataLocalService;
    }

    @Override
    public DataLocalService getWrappedService() {
        return _dataLocalService;
    }

    @Override
    public void setWrappedService(DataLocalService dataLocalService) {
        _dataLocalService = dataLocalService;
    }
}
