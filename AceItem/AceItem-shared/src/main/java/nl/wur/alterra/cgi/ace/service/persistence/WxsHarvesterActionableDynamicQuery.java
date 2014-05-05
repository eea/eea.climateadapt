package nl.wur.alterra.cgi.ace.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import nl.wur.alterra.cgi.ace.model.WxsHarvester;
import nl.wur.alterra.cgi.ace.service.WxsHarvesterLocalServiceUtil;

/**
 * @author groot052
 * @generated
 */
public abstract class WxsHarvesterActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public WxsHarvesterActionableDynamicQuery() throws SystemException {
        setBaseLocalService(WxsHarvesterLocalServiceUtil.getService());
        setClass(WxsHarvester.class);

        setClassLoader(nl.wur.alterra.cgi.ace.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("wxsharvesterid");
    }
}
