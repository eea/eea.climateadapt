package eu.europa.eea.mayors_adapt.service;

import com.liferay.portal.service.InvokableService;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DataServiceClp implements DataService {
	private InvokableService _invokableService;
	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;

	public DataServiceClp(InvokableService invokableService) {
		_invokableService = invokableService;

		_methodName0 = "getBeanIdentifier";

		_methodParameterTypes0 = new String[] {};

		_methodName1 = "setBeanIdentifier";

		_methodParameterTypes1 = new String[] { "java.lang.String" };

		_methodName3 = "getDataTypes";

		_methodParameterTypes3 = new String[] {};

		_methodName4 = "getAdaptationSectors";

		_methodParameterTypes4 = new String[] {};

		_methodName5 = "getClimateImpacts";

		_methodParameterTypes5 = new String[] {};

		_methodName6 = "getAdaptationElements";

		_methodParameterTypes6 = new String[] {};

		_methodName7 = "getCountries";

		_methodParameterTypes7 = new String[] {};

		_methodName8 = "getStructure";

		_methodParameterTypes8 = new String[] {};

		_methodName9 = "getCitiesByCriteria";

		_methodParameterTypes9 = new String[] { "java.util.List",
				"java.util.List", "java.util.List", "java.util.List" };
	}

	@Override
	public java.lang.String getBeanIdentifier() {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName0,
					_methodParameterTypes0, new Object[] {});
		} catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException) t;
			} else {
				throw new RuntimeException(t.getClass().getName()
						+ " is not a valid exception");
			}
		}

		return (java.lang.String) ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		try {
			_invokableService
					.invokeMethod(_methodName1, _methodParameterTypes1,
							new Object[] { ClpSerializer
									.translateInput(beanIdentifier) });
		} catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException) t;
			} else {
				throw new RuntimeException(t.getClass().getName()
						+ " is not a valid exception");
			}
		}
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
			java.lang.String[] parameterTypes, java.lang.Object[] arguments)
			throws java.lang.Throwable {
		throw new UnsupportedOperationException();
	}

	@Override
	public java.util.TreeSet<java.lang.String> getDataTypes() {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName3,
					_methodParameterTypes3, new Object[] {});
		} catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException) t;
			} else {
				throw new RuntimeException(t.getClass().getName()
						+ " is not a valid exception");
			}
		}

		return (java.util.TreeSet<java.lang.String>) ClpSerializer
				.translateOutput(returnObj);
	}

	@Override
	public java.util.TreeSet<java.lang.String> getAdaptationSectors() {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName4,
					_methodParameterTypes4, new Object[] {});
		} catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException) t;
			} else {
				throw new RuntimeException(t.getClass().getName()
						+ " is not a valid exception");
			}
		}

		return (java.util.TreeSet<java.lang.String>) ClpSerializer
				.translateOutput(returnObj);
	}

	@Override
	public java.util.TreeSet<java.lang.String> getClimateImpacts() {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName5,
					_methodParameterTypes5, new Object[] {});
		} catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException) t;
			} else {
				throw new RuntimeException(t.getClass().getName()
						+ " is not a valid exception");
			}
		}

		return (java.util.TreeSet<java.lang.String>) ClpSerializer
				.translateOutput(returnObj);
	}

	@Override
	public java.util.TreeSet<java.lang.String> getAdaptationElements() {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName6,
					_methodParameterTypes6, new Object[] {});
		} catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException) t;
			} else {
				throw new RuntimeException(t.getClass().getName()
						+ " is not a valid exception");
			}
		}

		return (java.util.TreeSet<java.lang.String>) ClpSerializer
				.translateOutput(returnObj);
	}

	@Override
	public java.util.TreeSet<java.lang.String> getCountries() {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName7,
					_methodParameterTypes7, new Object[] {});
		} catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException) t;
			} else {
				throw new RuntimeException(t.getClass().getName()
						+ " is not a valid exception");
			}
		}

		return (java.util.TreeSet<java.lang.String>) ClpSerializer
				.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portlet.dynamicdatamapping.model.DDMStructure getStructure()
			throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName8,
					_methodParameterTypes8, new Object[] {});
		} catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException) t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException) t;
			} else {
				throw new RuntimeException(t.getClass().getName()
						+ " is not a valid exception");
			}
		}

		return (com.liferay.portlet.dynamicdatamapping.model.DDMStructure) ClpSerializer
				.translateOutput(returnObj);
	}

	@Override
	public java.util.TreeMap<java.lang.String, java.lang.String> getCitiesByCriteria(
			java.util.List<java.lang.String> countries,
			java.util.List<java.lang.String> sectors,
			java.util.List<java.lang.String> impacts,
			java.util.List<java.lang.String> stages) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName9,
					_methodParameterTypes9,
					new Object[] { ClpSerializer.translateInput(countries),

					ClpSerializer.translateInput(sectors),

					ClpSerializer.translateInput(impacts),

					ClpSerializer.translateInput(stages) });
		} catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException) t;
			} else {
				throw new RuntimeException(t.getClass().getName()
						+ " is not a valid exception");
			}
		}

		return (java.util.TreeMap<java.lang.String, java.lang.String>) ClpSerializer
				.translateOutput(returnObj);
	}
}
