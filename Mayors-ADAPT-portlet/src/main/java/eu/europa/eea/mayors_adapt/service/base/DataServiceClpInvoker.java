package eu.europa.eea.mayors_adapt.service.base;

import eu.europa.eea.mayors_adapt.service.DataServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DataServiceClpInvoker {
    private String _methodName22;
    private String[] _methodParameterTypes22;
    private String _methodName23;
    private String[] _methodParameterTypes23;
    private String _methodName26;
    private String[] _methodParameterTypes26;
    private String _methodName27;
    private String[] _methodParameterTypes27;
    private String _methodName28;
    private String[] _methodParameterTypes28;

    public DataServiceClpInvoker() {
        _methodName22 = "getBeanIdentifier";

        _methodParameterTypes22 = new String[] {  };

        _methodName23 = "setBeanIdentifier";

        _methodParameterTypes23 = new String[] { "java.lang.String" };

        _methodName26 = "getOptions";

        _methodParameterTypes26 = new String[] { "java.lang.String" };

        _methodName27 = "getFieldsNames";

        _methodParameterTypes27 = new String[] {  };

        _methodName28 = "getCitiesByCriteria";

        _methodParameterTypes28 = new String[] {
                "java.util.List", "java.util.List", "java.util.List",
                "java.util.List"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName22.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes22, parameterTypes)) {
            return DataServiceUtil.getBeanIdentifier();
        }

        if (_methodName23.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes23, parameterTypes)) {
            DataServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName26.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes26, parameterTypes)) {
            return DataServiceUtil.getOptions((java.lang.String) arguments[0]);
        }

        if (_methodName27.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes27, parameterTypes)) {
            return DataServiceUtil.getFieldsNames();
        }

        if (_methodName28.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes28, parameterTypes)) {
            return DataServiceUtil.getCitiesByCriteria((java.util.List<java.lang.String>) arguments[0],
                (java.util.List<java.lang.String>) arguments[1],
                (java.util.List<java.lang.String>) arguments[2],
                (java.util.List<java.lang.String>) arguments[3]);
        }

        throw new UnsupportedOperationException();
    }
}
