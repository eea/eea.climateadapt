package nl.wur.alterra.cgi.ace.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import nl.wur.alterra.cgi.ace.model.AceItem;
import nl.wur.alterra.cgi.ace.service.AceItemLocalServiceUtil;

/**
 * @author groot052
 * @generated
 */
public abstract class AceItemActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public AceItemActionableDynamicQuery() throws SystemException {
        setBaseLocalService(AceItemLocalServiceUtil.getService());
        setClass(AceItem.class);

        setClassLoader(nl.wur.alterra.cgi.ace.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("aceItemId");
    }
}
