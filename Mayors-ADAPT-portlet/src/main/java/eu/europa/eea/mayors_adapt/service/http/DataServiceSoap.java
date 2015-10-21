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

    public static java.util.TreeSet<java.lang.String> getOptions(
        java.lang.String fieldName) throws RemoteException {
        try {
            java.util.TreeSet<java.lang.String> returnValue = DataServiceUtil.getOptions(fieldName);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static java.util.TreeSet<java.lang.String> getFieldsNames()
        throws RemoteException {
        try {
            java.util.TreeSet<java.lang.String> returnValue = DataServiceUtil.getFieldsNames();

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static java.util.TreeMap<java.lang.String, java.lang.String> getCitiesByCriteria(
        java.util.List<java.lang.String> countries,
        java.util.List<java.lang.String> sectors,
        java.util.List<java.lang.String> impacts,
        java.util.List<java.lang.String> stages) throws RemoteException {
        try {
            java.util.TreeMap<java.lang.String, java.lang.String> returnValue = DataServiceUtil.getCitiesByCriteria(countries,
                    sectors, impacts, stages);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
