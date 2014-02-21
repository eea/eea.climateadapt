package nl.wur.alterra.cgi.ace.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link WxsHarvester}.
 * </p>
 *
 * @author groot052
 * @see WxsHarvester
 * @generated
 */
public class WxsHarvesterWrapper implements WxsHarvester,
    ModelWrapper<WxsHarvester> {
    private WxsHarvester _wxsHarvester;

    public WxsHarvesterWrapper(WxsHarvester wxsHarvester) {
        _wxsHarvester = wxsHarvester;
    }

    @Override
    public Class<?> getModelClass() {
        return WxsHarvester.class;
    }

    @Override
    public String getModelClassName() {
        return WxsHarvester.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("wxsharvesterid", getWxsharvesterid());
        attributes.put("name", getName());
        attributes.put("url", getUrl());
        attributes.put("ogctype", getOgctype());
        attributes.put("every", getEvery());
        attributes.put("topic", getTopic());
        attributes.put("status", getStatus());
        attributes.put("savedToGeoNetwork", getSavedToGeoNetwork());
        attributes.put("geonetworkId", getGeonetworkId());
        attributes.put("geonetworkUUID", getGeonetworkUUID());
        attributes.put("companyId", getCompanyId());
        attributes.put("groupId", getGroupId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long wxsharvesterid = (Long) attributes.get("wxsharvesterid");

        if (wxsharvesterid != null) {
            setWxsharvesterid(wxsharvesterid);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String url = (String) attributes.get("url");

        if (url != null) {
            setUrl(url);
        }

        String ogctype = (String) attributes.get("ogctype");

        if (ogctype != null) {
            setOgctype(ogctype);
        }

        Integer every = (Integer) attributes.get("every");

        if (every != null) {
            setEvery(every);
        }

        String topic = (String) attributes.get("topic");

        if (topic != null) {
            setTopic(topic);
        }

        String status = (String) attributes.get("status");

        if (status != null) {
            setStatus(status);
        }

        Boolean savedToGeoNetwork = (Boolean) attributes.get(
                "savedToGeoNetwork");

        if (savedToGeoNetwork != null) {
            setSavedToGeoNetwork(savedToGeoNetwork);
        }

        Long geonetworkId = (Long) attributes.get("geonetworkId");

        if (geonetworkId != null) {
            setGeonetworkId(geonetworkId);
        }

        String geonetworkUUID = (String) attributes.get("geonetworkUUID");

        if (geonetworkUUID != null) {
            setGeonetworkUUID(geonetworkUUID);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }
    }

    /**
    * Returns the primary key of this wxs harvester.
    *
    * @return the primary key of this wxs harvester
    */
    @Override
    public long getPrimaryKey() {
        return _wxsHarvester.getPrimaryKey();
    }

    /**
    * Sets the primary key of this wxs harvester.
    *
    * @param primaryKey the primary key of this wxs harvester
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _wxsHarvester.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the wxsharvesterid of this wxs harvester.
    *
    * @return the wxsharvesterid of this wxs harvester
    */
    @Override
    public long getWxsharvesterid() {
        return _wxsHarvester.getWxsharvesterid();
    }

    /**
    * Sets the wxsharvesterid of this wxs harvester.
    *
    * @param wxsharvesterid the wxsharvesterid of this wxs harvester
    */
    @Override
    public void setWxsharvesterid(long wxsharvesterid) {
        _wxsHarvester.setWxsharvesterid(wxsharvesterid);
    }

    /**
    * Returns the name of this wxs harvester.
    *
    * @return the name of this wxs harvester
    */
    @Override
    public java.lang.String getName() {
        return _wxsHarvester.getName();
    }

    /**
    * Sets the name of this wxs harvester.
    *
    * @param name the name of this wxs harvester
    */
    @Override
    public void setName(java.lang.String name) {
        _wxsHarvester.setName(name);
    }

    /**
    * Returns the url of this wxs harvester.
    *
    * @return the url of this wxs harvester
    */
    @Override
    public java.lang.String getUrl() {
        return _wxsHarvester.getUrl();
    }

    /**
    * Sets the url of this wxs harvester.
    *
    * @param url the url of this wxs harvester
    */
    @Override
    public void setUrl(java.lang.String url) {
        _wxsHarvester.setUrl(url);
    }

    /**
    * Returns the ogctype of this wxs harvester.
    *
    * @return the ogctype of this wxs harvester
    */
    @Override
    public java.lang.String getOgctype() {
        return _wxsHarvester.getOgctype();
    }

    /**
    * Sets the ogctype of this wxs harvester.
    *
    * @param ogctype the ogctype of this wxs harvester
    */
    @Override
    public void setOgctype(java.lang.String ogctype) {
        _wxsHarvester.setOgctype(ogctype);
    }

    /**
    * Returns the every of this wxs harvester.
    *
    * @return the every of this wxs harvester
    */
    @Override
    public int getEvery() {
        return _wxsHarvester.getEvery();
    }

    /**
    * Sets the every of this wxs harvester.
    *
    * @param every the every of this wxs harvester
    */
    @Override
    public void setEvery(int every) {
        _wxsHarvester.setEvery(every);
    }

    /**
    * Returns the topic of this wxs harvester.
    *
    * @return the topic of this wxs harvester
    */
    @Override
    public java.lang.String getTopic() {
        return _wxsHarvester.getTopic();
    }

    /**
    * Sets the topic of this wxs harvester.
    *
    * @param topic the topic of this wxs harvester
    */
    @Override
    public void setTopic(java.lang.String topic) {
        _wxsHarvester.setTopic(topic);
    }

    /**
    * Returns the status of this wxs harvester.
    *
    * @return the status of this wxs harvester
    */
    @Override
    public java.lang.String getStatus() {
        return _wxsHarvester.getStatus();
    }

    /**
    * Sets the status of this wxs harvester.
    *
    * @param status the status of this wxs harvester
    */
    @Override
    public void setStatus(java.lang.String status) {
        _wxsHarvester.setStatus(status);
    }

    /**
    * Returns the saved to geo network of this wxs harvester.
    *
    * @return the saved to geo network of this wxs harvester
    */
    @Override
    public boolean getSavedToGeoNetwork() {
        return _wxsHarvester.getSavedToGeoNetwork();
    }

    /**
    * Returns <code>true</code> if this wxs harvester is saved to geo network.
    *
    * @return <code>true</code> if this wxs harvester is saved to geo network; <code>false</code> otherwise
    */
    @Override
    public boolean isSavedToGeoNetwork() {
        return _wxsHarvester.isSavedToGeoNetwork();
    }

    /**
    * Sets whether this wxs harvester is saved to geo network.
    *
    * @param savedToGeoNetwork the saved to geo network of this wxs harvester
    */
    @Override
    public void setSavedToGeoNetwork(boolean savedToGeoNetwork) {
        _wxsHarvester.setSavedToGeoNetwork(savedToGeoNetwork);
    }

    /**
    * Returns the geonetwork ID of this wxs harvester.
    *
    * @return the geonetwork ID of this wxs harvester
    */
    @Override
    public long getGeonetworkId() {
        return _wxsHarvester.getGeonetworkId();
    }

    /**
    * Sets the geonetwork ID of this wxs harvester.
    *
    * @param geonetworkId the geonetwork ID of this wxs harvester
    */
    @Override
    public void setGeonetworkId(long geonetworkId) {
        _wxsHarvester.setGeonetworkId(geonetworkId);
    }

    /**
    * Returns the geonetwork u u i d of this wxs harvester.
    *
    * @return the geonetwork u u i d of this wxs harvester
    */
    @Override
    public java.lang.String getGeonetworkUUID() {
        return _wxsHarvester.getGeonetworkUUID();
    }

    /**
    * Sets the geonetwork u u i d of this wxs harvester.
    *
    * @param geonetworkUUID the geonetwork u u i d of this wxs harvester
    */
    @Override
    public void setGeonetworkUUID(java.lang.String geonetworkUUID) {
        _wxsHarvester.setGeonetworkUUID(geonetworkUUID);
    }

    /**
    * Returns the company ID of this wxs harvester.
    *
    * @return the company ID of this wxs harvester
    */
    @Override
    public long getCompanyId() {
        return _wxsHarvester.getCompanyId();
    }

    /**
    * Sets the company ID of this wxs harvester.
    *
    * @param companyId the company ID of this wxs harvester
    */
    @Override
    public void setCompanyId(long companyId) {
        _wxsHarvester.setCompanyId(companyId);
    }

    /**
    * Returns the group ID of this wxs harvester.
    *
    * @return the group ID of this wxs harvester
    */
    @Override
    public long getGroupId() {
        return _wxsHarvester.getGroupId();
    }

    /**
    * Sets the group ID of this wxs harvester.
    *
    * @param groupId the group ID of this wxs harvester
    */
    @Override
    public void setGroupId(long groupId) {
        _wxsHarvester.setGroupId(groupId);
    }

    @Override
    public boolean isNew() {
        return _wxsHarvester.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _wxsHarvester.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _wxsHarvester.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _wxsHarvester.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _wxsHarvester.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _wxsHarvester.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _wxsHarvester.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _wxsHarvester.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _wxsHarvester.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _wxsHarvester.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _wxsHarvester.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new WxsHarvesterWrapper((WxsHarvester) _wxsHarvester.clone());
    }

    @Override
    public int compareTo(WxsHarvester wxsHarvester) {
        return _wxsHarvester.compareTo(wxsHarvester);
    }

    @Override
    public int hashCode() {
        return _wxsHarvester.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<WxsHarvester> toCacheModel() {
        return _wxsHarvester.toCacheModel();
    }

    @Override
    public WxsHarvester toEscapedModel() {
        return new WxsHarvesterWrapper(_wxsHarvester.toEscapedModel());
    }

    @Override
    public WxsHarvester toUnescapedModel() {
        return new WxsHarvesterWrapper(_wxsHarvester.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _wxsHarvester.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _wxsHarvester.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _wxsHarvester.persist();
    }

    /**
    * heikki doeleman: Liferay won't let me override toString(), because if I do that it generates 2 declarations of toString()
    * in WxsHarvesterCpl, which does not compile. Thanks Liferay !
    *
    * @return shorter string than toString()
    */
    @Override
    public java.lang.String toShortString() {
        return _wxsHarvester.toShortString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof WxsHarvesterWrapper)) {
            return false;
        }

        WxsHarvesterWrapper wxsHarvesterWrapper = (WxsHarvesterWrapper) obj;

        if (Validator.equals(_wxsHarvester, wxsHarvesterWrapper._wxsHarvester)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public WxsHarvester getWrappedWxsHarvester() {
        return _wxsHarvester;
    }

    @Override
    public WxsHarvester getWrappedModel() {
        return _wxsHarvester;
    }

    @Override
    public void resetOriginalValues() {
        _wxsHarvester.resetOriginalValues();
    }
}
