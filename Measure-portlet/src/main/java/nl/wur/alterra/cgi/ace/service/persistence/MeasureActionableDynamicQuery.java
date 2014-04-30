package nl.wur.alterra.cgi.ace.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import nl.wur.alterra.cgi.ace.model.Measure;
import nl.wur.alterra.cgi.ace.service.MeasureLocalServiceUtil;

/**
 * @author groot052
 * @generated
 */
public abstract class MeasureActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public MeasureActionableDynamicQuery() throws SystemException {
        setBaseLocalService(MeasureLocalServiceUtil.getService());
        setClass(Measure.class);

        setClassLoader(nl.wur.alterra.cgi.ace.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("measureId");
    }
}
