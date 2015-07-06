package eu.europa.eea.mayors_adapt.service.base;

import java.util.Arrays;

import eu.europa.eea.mayors_adapt.service.DataServiceUtil;

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
    private String _methodName29;
    private String[] _methodParameterTypes29;
    private String _methodName30;
    private String[] _methodParameterTypes30;
    private String _methodName31;
    private String[] _methodParameterTypes31;
    private String _methodName32;
    private String[] _methodParameterTypes32;

    public DataServiceClpInvoker() {
        _methodName22 = "getBeanIdentifier";

        _methodParameterTypes22 = new String[] {  };

        _methodName23 = "setBeanIdentifier";

        _methodParameterTypes23 = new String[] { "java.lang.String" };

        _methodName26 = "getDataTypes";

        _methodParameterTypes26 = new String[] {  };

        _methodName27 = "getAdaptationSectors";

        _methodParameterTypes27 = new String[] {  };

        _methodName28 = "getClimateImpacts";

        _methodParameterTypes28 = new String[] {  };

        _methodName29 = "getAdaptationElements";

        _methodParameterTypes29 = new String[] {  };

        _methodName30 = "getCountries";

        _methodParameterTypes30 = new String[] {  };

        _methodName31 = "getStructure";

        _methodParameterTypes31 = new String[] {  };

        _methodName32 = "getCitiesByCriteria";

        _methodParameterTypes32 = new String[] {
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
            return DataServiceUtil.getDataTypes();
        }

        if (_methodName27.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes27, parameterTypes)) {
            return DataServiceUtil.getAdaptationSectors();
        }

        if (_methodName28.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes28, parameterTypes)) {
            return DataServiceUtil.getClimateImpacts();
        }

        if (_methodName29.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes29, parameterTypes)) {
            return DataServiceUtil.getAdaptationElements();
        }

        if (_methodName30.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes30, parameterTypes)) {
            return DataServiceUtil.getCountries();
        }

        if (_methodName31.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes31, parameterTypes)) {
            return DataServiceUtil.getStructure();
        }

        if (_methodName32.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes32, parameterTypes)) {
            return DataServiceUtil.getCitiesByCriteria((java.util.List<java.lang.String>) arguments[0],
                (java.util.List<java.lang.String>) arguments[1],
                (java.util.List<java.lang.String>) arguments[2],
                (java.util.List<java.lang.String>) arguments[3]);
        }

        throw new UnsupportedOperationException();
    }
}
