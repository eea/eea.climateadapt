package eu.europa.eea.mayors_adapt.service.service.base;

import eu.europa.eea.mayors_adapt.service.service.DataLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DataLocalServiceClpInvoker {
    private String _methodName22;
    private String[] _methodParameterTypes22;
    private String _methodName23;
    private String[] _methodParameterTypes23;

    public DataLocalServiceClpInvoker() {
        _methodName22 = "getBeanIdentifier";

        _methodParameterTypes22 = new String[] {  };

        _methodName23 = "setBeanIdentifier";

        _methodParameterTypes23 = new String[] { "java.lang.String" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName22.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes22, parameterTypes)) {
            return DataLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName23.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes23, parameterTypes)) {
            DataLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
