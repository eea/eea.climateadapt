package nl.wur.alterra.cgi.ace.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import nl.wur.alterra.cgi.ace.model.WxsHarvester;
import nl.wur.alterra.cgi.ace.service.WxsHarvesterLocalServiceUtil;

/**
 * The extended model base implementation for the WxsHarvester service. Represents a row in the &quot;Ace_WxsHarvester&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link WxsHarvesterImpl}.
 * </p>
 *
 * @author groot052
 * @see WxsHarvesterImpl
 * @see nl.wur.alterra.cgi.ace.model.WxsHarvester
 * @generated
 */
public abstract class WxsHarvesterBaseImpl extends WxsHarvesterModelImpl
    implements WxsHarvester {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a wxs harvester model instance should use the {@link WxsHarvester} interface instead.
     */
    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            WxsHarvesterLocalServiceUtil.addWxsHarvester(this);
        } else {
            WxsHarvesterLocalServiceUtil.updateWxsHarvester(this);
        }
    }
}