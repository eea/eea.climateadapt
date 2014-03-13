package nl.wur.alterra.cgi.ace.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import nl.wur.alterra.cgi.ace.model.Project;
import nl.wur.alterra.cgi.ace.service.ProjectLocalServiceUtil;

/**
 * @author Groot052
 * @generated
 */
public abstract class ProjectActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public ProjectActionableDynamicQuery() throws SystemException {
        setBaseLocalService(ProjectLocalServiceUtil.getService());
        setClass(Project.class);

        setClassLoader(nl.wur.alterra.cgi.ace.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("projectId");
    }
}
