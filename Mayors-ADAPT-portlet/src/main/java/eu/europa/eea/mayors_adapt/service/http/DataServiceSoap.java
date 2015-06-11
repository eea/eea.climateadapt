package eu.europa.eea.mayors_adapt.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import eu.europa.eea.mayors_adapt.service.DataServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link eu.europa.eea.mayors_adapt.service.DataServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DataServiceHttp
 * @see eu.europa.eea.mayors_adapt.service.DataServiceUtil
 * @generated
 */
public class DataServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(DataServiceSoap.class);

    public static java.util.TreeMap<java.lang.String, java.lang.String> getDataTypes()
        throws RemoteException {
        try {
            java.util.TreeMap<java.lang.String, java.lang.String> returnValue = DataServiceUtil.getDataTypes();

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static java.util.TreeMap<java.lang.String, java.lang.String> getAdaptationSectors()
        throws RemoteException {
        try {
            java.util.TreeMap<java.lang.String, java.lang.String> returnValue = DataServiceUtil.getAdaptationSectors();

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static java.util.TreeMap<java.lang.String, java.lang.String> getClimateImpacts()
        throws RemoteException {
        try {
            java.util.TreeMap<java.lang.String, java.lang.String> returnValue = DataServiceUtil.getClimateImpacts();

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static java.util.TreeMap<java.lang.String, java.lang.String> getAdaptationElements()
        throws RemoteException {
        try {
            java.util.TreeMap<java.lang.String, java.lang.String> returnValue = DataServiceUtil.getAdaptationElements();

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static java.util.TreeMap<java.lang.String, java.lang.String> getCountries()
        throws RemoteException {
        try {
            java.util.TreeMap<java.lang.String, java.lang.String> returnValue = DataServiceUtil.getCountries();

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.liferay.portlet.dynamicdatamapping.model.DDMStructure getStructure()
        throws RemoteException {
        try {
            com.liferay.portlet.dynamicdatamapping.model.DDMStructure returnValue =
                DataServiceUtil.getStructure();

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
