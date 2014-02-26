package nl.wur.alterra.cgi.ace.model;

import com.liferay.portal.kernel.annotation.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the WxsHarvester service. Represents a row in the &quot;Ace_WxsHarvester&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link nl.wur.alterra.cgi.ace.model.impl.WxsHarvesterModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link nl.wur.alterra.cgi.ace.model.impl.WxsHarvesterImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this interface directly. All methods that expect a wxs harvester model instance should use the {@link WxsHarvester} interface instead.
 * </p>
 *
 * @author groot052
 * @see WxsHarvester
 * @see nl.wur.alterra.cgi.ace.model.impl.WxsHarvesterImpl
 * @see nl.wur.alterra.cgi.ace.model.impl.WxsHarvesterModelImpl
 * @generated
 */
public interface WxsHarvesterModel extends BaseModel<WxsHarvester> {
    /**
     * Gets the primary key of this wxs harvester.
     *
     * @return the primary key of this wxs harvester
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this wxs harvester
     *
     * @param pk the primary key of this wxs harvester
     */
    public void setPrimaryKey(long pk);

    /**
     * Gets the wxsharvesterid of this wxs harvester.
     *
     * @return the wxsharvesterid of this wxs harvester
     */
    public long getWxsharvesterid();

    /**
     * Sets the wxsharvesterid of this wxs harvester.
     *
     * @param wxsharvesterid the wxsharvesterid of this wxs harvester
     */
    public void setWxsharvesterid(long wxsharvesterid);

    /**
     * Gets the name of this wxs harvester.
     *
     * @return the name of this wxs harvester
     */
    @AutoEscape
    public String getName();

    /**
     * Sets the name of this wxs harvester.
     *
     * @param name the name of this wxs harvester
     */
    public void setName(String name);

    /**
     * Gets the url of this wxs harvester.
     *
     * @return the url of this wxs harvester
     */
    @AutoEscape
    public String getUrl();

    /**
     * Sets the url of this wxs harvester.
     *
     * @param url the url of this wxs harvester
     */
    public void setUrl(String url);

    /**
     * Gets the ogctype of this wxs harvester.
     *
     * @return the ogctype of this wxs harvester
     */
    @AutoEscape
    public String getOgctype();

    /**
     * Sets the ogctype of this wxs harvester.
     *
     * @param ogctype the ogctype of this wxs harvester
     */
    public void setOgctype(String ogctype);

    /**
     * Gets the every of this wxs harvester.
     *
     * @return the every of this wxs harvester
     */
    public int getEvery();

    /**
     * Sets the every of this wxs harvester.
     *
     * @param every the every of this wxs harvester
     */
    public void setEvery(int every);

    /**
     * Gets the topic of this wxs harvester.
     *
     * @return the topic of this wxs harvester
     */
    @AutoEscape
    public String getTopic();

    /**
     * Sets the topic of this wxs harvester.
     *
     * @param topic the topic of this wxs harvester
     */
    public void setTopic(String topic);

    /**
     * Gets the status of this wxs harvester.
     *
     * @return the status of this wxs harvester
     */
    @AutoEscape
    public String getStatus();

    /**
     * Sets the status of this wxs harvester.
     *
     * @param status the status of this wxs harvester
     */
    public void setStatus(String status);

    /**
     * Gets the saved to geo network of this wxs harvester.
     *
     * @return the saved to geo network of this wxs harvester
     */
    public boolean getSavedToGeoNetwork();

    /**
     * Determines whether this wxs harvester is saved to geo network.
     *
     * @return whether this wxs harvester is saved to geo network
     */
    public boolean isSavedToGeoNetwork();

    /**
     * Sets whether this {$entity.humanName} is saved to geo network.
     *
     * @param savedToGeoNetwork the saved to geo network of this wxs harvester
     */
    public void setSavedToGeoNetwork(boolean savedToGeoNetwork);

    /**
     * Gets the geonetwork id of this wxs harvester.
     *
     * @return the geonetwork id of this wxs harvester
     */
    public long getGeonetworkId();

    /**
     * Sets the geonetwork id of this wxs harvester.
     *
     * @param geonetworkId the geonetwork id of this wxs harvester
     */
    public void setGeonetworkId(long geonetworkId);

    /**
     * Gets the geonetwork u u i d of this wxs harvester.
     *
     * @return the geonetwork u u i d of this wxs harvester
     */
    @AutoEscape
    public String getGeonetworkUUID();

    /**
     * Sets the geonetwork u u i d of this wxs harvester.
     *
     * @param geonetworkUUID the geonetwork u u i d of this wxs harvester
     */
    public void setGeonetworkUUID(String geonetworkUUID);

    /**
     * Gets the company id of this wxs harvester.
     *
     * @return the company id of this wxs harvester
     */
    public long getCompanyId();

    /**
     * Sets the company id of this wxs harvester.
     *
     * @param companyId the company id of this wxs harvester
     */
    public void setCompanyId(long companyId);

    /**
     * Gets the group id of this wxs harvester.
     *
     * @return the group id of this wxs harvester
     */
    public long getGroupId();

    /**
     * Sets the group id of this wxs harvester.
     *
     * @param groupId the group id of this wxs harvester
     */
    public void setGroupId(long groupId);

    /**
     * Gets a copy of this wxs harvester as an escaped model instance by wrapping it with an {@link com.liferay.portal.kernel.bean.AutoEscapeBeanHandler}.
     *
     * @return the escaped model instance
     * @see com.liferay.portal.kernel.bean.AutoEscapeBeanHandler
     */
    public WxsHarvester toEscapedModel();

    public boolean isNew();

    public void setNew(boolean n);

    public boolean isCachedModel();

    public void setCachedModel(boolean cachedModel);

    public boolean isEscapedModel();

    public void setEscapedModel(boolean escapedModel);

    public Serializable getPrimaryKeyObj();

    public ExpandoBridge getExpandoBridge();

    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    public Object clone();

    public int compareTo(WxsHarvester wxsHarvester);

    public int hashCode();

    public String toString();

    public String toXmlString();
}
