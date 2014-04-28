package nl.wur.alterra.cgi.ace.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import nl.wur.alterra.cgi.ace.model.CSWHarvester;
import nl.wur.alterra.cgi.ace.service.CSWHarvesterLocalServiceUtil;

/**
 * @author groot052
 * @generated
 */
public abstract class CSWHarvesterActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public CSWHarvesterActionableDynamicQuery() throws SystemException {
        setBaseLocalService(CSWHarvesterLocalServiceUtil.getService());
        setClass(CSWHarvester.class);

        setClassLoader(nl.wur.alterra.cgi.ace.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("cswharvesterid");
    }
}
