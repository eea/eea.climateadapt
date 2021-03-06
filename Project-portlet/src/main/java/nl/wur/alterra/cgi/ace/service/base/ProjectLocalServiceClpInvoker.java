package nl.wur.alterra.cgi.ace.service.base;

import nl.wur.alterra.cgi.ace.service.ProjectLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Groot052
 * @generated
 */
public class ProjectLocalServiceClpInvoker {
    private String _methodName0;
    private String[] _methodParameterTypes0;
    private String _methodName1;
    private String[] _methodParameterTypes1;
    private String _methodName2;
    private String[] _methodParameterTypes2;
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
    private String _methodName10;
    private String[] _methodParameterTypes10;
    private String _methodName11;
    private String[] _methodParameterTypes11;
    private String _methodName12;
    private String[] _methodParameterTypes12;
    private String _methodName13;
    private String[] _methodParameterTypes13;
    private String _methodName14;
    private String[] _methodParameterTypes14;
    private String _methodName15;
    private String[] _methodParameterTypes15;
    private String _methodName32;
    private String[] _methodParameterTypes32;
    private String _methodName33;
    private String[] _methodParameterTypes33;
    private String _methodName38;
    private String[] _methodParameterTypes38;
    private String _methodName39;
    private String[] _methodParameterTypes39;
    private String _methodName40;
    private String[] _methodParameterTypes40;
    private String _methodName41;
    private String[] _methodParameterTypes41;
    private String _methodName42;
    private String[] _methodParameterTypes42;
    private String _methodName43;
    private String[] _methodParameterTypes43;
    private String _methodName44;
    private String[] _methodParameterTypes44;
    private String _methodName45;
    private String[] _methodParameterTypes45;
    private String _methodName46;
    private String[] _methodParameterTypes46;
    private String _methodName47;
    private String[] _methodParameterTypes47;

    public ProjectLocalServiceClpInvoker() {
        _methodName0 = "addProject";

        _methodParameterTypes0 = new String[] {
                "nl.wur.alterra.cgi.ace.model.Project"
            };

        _methodName1 = "createProject";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteProject";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteProject";

        _methodParameterTypes3 = new String[] {
                "nl.wur.alterra.cgi.ace.model.Project"
            };

        _methodName4 = "dynamicQuery";

        _methodParameterTypes4 = new String[] {  };

        _methodName5 = "dynamicQuery";

        _methodParameterTypes5 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName6 = "dynamicQuery";

        _methodParameterTypes6 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
            };

        _methodName7 = "dynamicQuery";

        _methodParameterTypes7 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };

        _methodName8 = "dynamicQueryCount";

        _methodParameterTypes8 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName9 = "dynamicQueryCount";

        _methodParameterTypes9 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery",
                "com.liferay.portal.kernel.dao.orm.Projection"
            };

        _methodName10 = "fetchProject";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getProject";

        _methodParameterTypes11 = new String[] { "long" };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getProjects";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getProjectsCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateProject";

        _methodParameterTypes15 = new String[] {
                "nl.wur.alterra.cgi.ace.model.Project"
            };

        _methodName32 = "getBeanIdentifier";

        _methodParameterTypes32 = new String[] {  };

        _methodName33 = "setBeanIdentifier";

        _methodParameterTypes33 = new String[] { "java.lang.String" };

        _methodName38 = "addProject";

        _methodParameterTypes38 = new String[] {
                "nl.wur.alterra.cgi.ace.model.Project"
            };

        _methodName39 = "getProjectsByGroupId";

        _methodParameterTypes39 = new String[] { "long" };

        _methodName40 = "getProjectsByGroupId";

        _methodParameterTypes40 = new String[] { "long", "int", "int" };

        _methodName41 = "getProjectsByGroupId";

        _methodParameterTypes41 = new String[] {
                "long", "int", "int",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };

        _methodName42 = "getProjectsCountByGroupId";

        _methodParameterTypes42 = new String[] { "long" };

        _methodName43 = "getProjectsByControlstatus";

        _methodParameterTypes43 = new String[] { "short" };

        _methodName44 = "getProjectsByGroupId";

        _methodParameterTypes44 = new String[] { "short", "int", "int" };

        _methodName45 = "getProjectsByControlstatus";

        _methodParameterTypes45 = new String[] { "short", "int", "int" };

        _methodName46 = "getProjectsCountByGroupId";

        _methodParameterTypes46 = new String[] { "short" };

        _methodName47 = "getProjectsCountByControlstatus";

        _methodParameterTypes47 = new String[] { "short" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return ProjectLocalServiceUtil.addProject((nl.wur.alterra.cgi.ace.model.Project) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return ProjectLocalServiceUtil.createProject(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return ProjectLocalServiceUtil.deleteProject(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return ProjectLocalServiceUtil.deleteProject((nl.wur.alterra.cgi.ace.model.Project) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return ProjectLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return ProjectLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return ProjectLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return ProjectLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return ProjectLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return ProjectLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return ProjectLocalServiceUtil.fetchProject(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return ProjectLocalServiceUtil.getProject(((Long) arguments[0]).longValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return ProjectLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return ProjectLocalServiceUtil.getProjects(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return ProjectLocalServiceUtil.getProjectsCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return ProjectLocalServiceUtil.updateProject((nl.wur.alterra.cgi.ace.model.Project) arguments[0]);
        }

        if (_methodName32.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes32, parameterTypes)) {
            return ProjectLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName33.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes33, parameterTypes)) {
            ProjectLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName38.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes38, parameterTypes)) {
            return ProjectLocalServiceUtil.addProject((nl.wur.alterra.cgi.ace.model.Project) arguments[0]);
        }

        if (_methodName39.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes39, parameterTypes)) {
            return ProjectLocalServiceUtil.getProjectsByGroupId(((Long) arguments[0]).longValue());
        }

        if (_methodName40.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes40, parameterTypes)) {
            return ProjectLocalServiceUtil.getProjectsByGroupId(((Long) arguments[0]).longValue(),
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName41.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes41, parameterTypes)) {
            return ProjectLocalServiceUtil.getProjectsByGroupId(((Long) arguments[0]).longValue(),
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName42.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes42, parameterTypes)) {
            return ProjectLocalServiceUtil.getProjectsCountByGroupId(((Long) arguments[0]).longValue());
        }

        if (_methodName43.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes43, parameterTypes)) {
            return ProjectLocalServiceUtil.getProjectsByControlstatus(((Short) arguments[0]).shortValue());
        }

        if (_methodName44.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes44, parameterTypes)) {
            return ProjectLocalServiceUtil.getProjectsByGroupId(((Short) arguments[0]).shortValue(),
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName45.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes45, parameterTypes)) {
            return ProjectLocalServiceUtil.getProjectsByControlstatus(((Short) arguments[0]).shortValue(),
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName46.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes46, parameterTypes)) {
            return ProjectLocalServiceUtil.getProjectsCountByGroupId(((Short) arguments[0]).shortValue());
        }

        if (_methodName47.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes47, parameterTypes)) {
            return ProjectLocalServiceUtil.getProjectsCountByControlstatus(((Short) arguments[0]).shortValue());
        }

        throw new UnsupportedOperationException();
    }
}
