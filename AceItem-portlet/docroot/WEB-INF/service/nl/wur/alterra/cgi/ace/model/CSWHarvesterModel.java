package nl.wur.alterra.cgi.ace.model;

import com.liferay.portal.kernel.annotation.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the CSWHarvester service. Represents a row in the &quot;Ace_CSWHarvester&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link nl.wur.alterra.cgi.ace.model.impl.CSWHarvesterModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link nl.wur.alterra.cgi.ace.model.impl.CSWHarvesterImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this interface directly. All methods that expect a c s w harvester model instance should use the {@link CSWHarvester} interface instead.
 * </p>
 *
 * @author groot052
 * @see CSWHarvester
 * @see nl.wur.alterra.cgi.ace.model.impl.CSWHarvesterImpl
 * @see nl.wur.alterra.cgi.ace.model.impl.CSWHarvesterModelImpl
 * @generated
 */
public interface CSWHarvesterModel extends BaseModel<CSWHarvester> {
    /**
     * Gets the primary key of this c s w harvester.
     *
     * @return the primary key of this c s w harvester
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this c s w harvester
     *
     * @param pk the primary key of this c s w harvester
     */
    public void setPrimaryKey(long pk);

    /**
     * Gets the cswharvesterid of this c s w harvester.
     *
     * @return the cswharvesterid of this c s w harvester
     */
    public long getCswharvesterid();

    /**
     * Sets the cswharvesterid of this c s w harvester.
     *
     * @param cswharvesterid the cswharvesterid of this c s w harvester
     */
    public void setCswharvesterid(long cswharvesterid);

    /**
     * Gets the name of this c s w harvester.
     *
     * @return the name of this c s w harvester
     */
    @AutoEscape
    public String getName();

    /**
     * Sets the name of this c s w harvester.
     *
     * @param name the name of this c s w harvester
     */
    public void setName(String name);

    /**
     * Gets the url of this c s w harvester.
     *
     * @return the url of this c s w harvester
     */
    @AutoEscape
    public String getUrl();

    /**
     * Sets the url of this c s w harvester.
     *
     * @param url the url of this c s w harvester
     */
    public void setUrl(String url);

    /**
     * Gets the freetext of this c s w harvester.
     *
     * @return the freetext of this c s w harvester
     */
    @AutoEscape
    public String getFreetext();

    /**
     * Sets the freetext of this c s w harvester.
     *
     * @param freetext the freetext of this c s w harvester
     */
    public void setFreetext(String freetext);

    /**
     * Gets the title of this c s w harvester.
     *
     * @return the title of this c s w harvester
     */
    @AutoEscape
    public String getTitle();

    /**
     * Sets the title of this c s w harvester.
     *
     * @param title the title of this c s w harvester
     */
    public void setTitle(String title);

    /**
     * Gets the abstrakt of this c s w harvester.
     *
     * @return the abstrakt of this c s w harvester
     */
    @AutoEscape
    public String getAbstrakt();

    /**
     * Sets the abstrakt of this c s w harvester.
     *
     * @param abstrakt the abstrakt of this c s w harvester
     */
    public void setAbstrakt(String abstrakt);

    /**
     * Gets the subject of this c s w harvester.
     *
     * @return the subject of this c s w harvester
     */
    @AutoEscape
    public String getSubject();

    /**
     * Sets the subject of this c s w harvester.
     *
     * @param subject the subject of this c s w harvester
     */
    public void setSubject(String subject);

    /**
     * Gets the every of this c s w harvester.
     *
     * @return the every of this c s w harvester
     */
    public int getEvery();

    /**
     * Sets the every of this c s w harvester.
     *
     * @param every the every of this c s w harvester
     */
    public void setEvery(int every);

    /**
     * Gets the topic of this c s w harvester.
     *
     * @return the topic of this c s w harvester
     */
    @AutoEscape
    public String getTopic();

    /**
     * Sets the topic of this c s w harvester.
     *
     * @param topic the topic of this c s w harvester
     */
    public void setTopic(String topic);

    /**
     * Gets the status of this c s w harvester.
     *
     * @return the status of this c s w harvester
     */
    @AutoEscape
    public String getStatus();

    /**
     * Sets the status of this c s w harvester.
     *
     * @param status the status of this c s w harvester
     */
    public void setStatus(String status);

    /**
     * Gets the saved to geo network of this c s w harvester.
     *
     * @return the saved to geo network of this c s w harvester
     */
    public boolean getSavedToGeoNetwork();

    /**
     * Determines whether this c s w harvester is saved to geo network.
     *
     * @return whether this c s w harvester is saved to geo network
     */
    public boolean isSavedToGeoNetwork();

    /**
     * Sets whether this {$entity.humanName} is saved to geo network.
     *
     * @param savedToGeoNetwork the saved to geo network of this c s w harvester
     */
    public void setSavedToGeoNetwork(boolean savedToGeoNetwork);

    /**
     * Gets the geonetwork id of this c s w harvester.
     *
     * @return the geonetwork id of this c s w harvester
     */
    public long getGeonetworkId();

    /**
     * Sets the geonetwork id of this c s w harvester.
     *
     * @param geonetworkId the geonetwork id of this c s w harvester
     */
    public void setGeonetworkId(long geonetworkId);

    /**
     * Gets the geonetwork u u i d of this c s w harvester.
     *
     * @return the geonetwork u u i d of this c s w harvester
     */
    @AutoEscape
    public String getGeonetworkUUID();

    /**
     * Sets the geonetwork u u i d of this c s w harvester.
     *
     * @param geonetworkUUID the geonetwork u u i d of this c s w harvester
     */
    public void setGeonetworkUUID(String geonetworkUUID);

    /**
     * Gets the company id of this c s w harvester.
     *
     * @return the company id of this c s w harvester
     */
    public long getCompanyId();

    /**
     * Sets the company id of this c s w harvester.
     *
     * @param companyId the company id of this c s w harvester
     */
    public void setCompanyId(long companyId);

    /**
     * Gets the group id of this c s w harvester.
     *
     * @return the group id of this c s w harvester
     */
    public long getGroupId();

    /**
     * Sets the group id of this c s w harvester.
     *
     * @param groupId the group id of this c s w harvester
     */
    public void setGroupId(long groupId);

    /**
     * Gets the type of this c s w harvester.
     *
     * @return the type of this c s w harvester
     */
    @AutoEscape
    public String getType();

    /**
     * Sets the type of this c s w harvester.
     *
     * @param type the type of this c s w harvester
     */
    public void setType(String type);

    /**
     * Gets the username of this c s w harvester.
     *
     * @return the username of this c s w harvester
     */
    @AutoEscape
    public String getUsername();

    /**
     * Sets the username of this c s w harvester.
     *
     * @param username the username of this c s w harvester
     */
    public void setUsername(String username);

    /**
     * Gets the password of this c s w harvester.
     *
     * @return the password of this c s w harvester
     */
    @AutoEscape
    public String getPassword();

    /**
     * Sets the password of this c s w harvester.
     *
     * @param password the password of this c s w harvester
     */
    public void setPassword(String password);

    /**
     * Gets a copy of this c s w harvester as an escaped model instance by wrapping it with an {@link com.liferay.portal.kernel.bean.AutoEscapeBeanHandler}.
     *
     * @return the escaped model instance
     * @see com.liferay.portal.kernel.bean.AutoEscapeBeanHandler
     */
    public CSWHarvester toEscapedModel();

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

    public int compareTo(CSWHarvester cswHarvester);

    public int hashCode();

    public String toString();

    public String toXmlString();
}
