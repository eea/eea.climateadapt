package nl.wur.alterra.cgi.ace.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CSWHarvester}.
 * </p>
 *
 * @author groot052
 * @see CSWHarvester
 * @generated
 */
public class CSWHarvesterWrapper implements CSWHarvester,
    ModelWrapper<CSWHarvester> {
    private CSWHarvester _cswHarvester;

    public CSWHarvesterWrapper(CSWHarvester cswHarvester) {
        _cswHarvester = cswHarvester;
    }

    @Override
    public Class<?> getModelClass() {
        return CSWHarvester.class;
    }

    @Override
    public String getModelClassName() {
        return CSWHarvester.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("cswharvesterid", getCswharvesterid());
        attributes.put("name", getName());
        attributes.put("url", getUrl());
        attributes.put("freetext", getFreetext());
        attributes.put("title", getTitle());
        attributes.put("abstrakt", getAbstrakt());
        attributes.put("subject", getSubject());
        attributes.put("every", getEvery());
        attributes.put("topic", getTopic());
        attributes.put("status", getStatus());
        attributes.put("savedToGeoNetwork", getSavedToGeoNetwork());
        attributes.put("geonetworkId", getGeonetworkId());
        attributes.put("geonetworkUUID", getGeonetworkUUID());
        attributes.put("companyId", getCompanyId());
        attributes.put("groupId", getGroupId());
        attributes.put("type", getType());
        attributes.put("username", getUsername());
        attributes.put("password", getPassword());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long cswharvesterid = (Long) attributes.get("cswharvesterid");

        if (cswharvesterid != null) {
            setCswharvesterid(cswharvesterid);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String url = (String) attributes.get("url");

        if (url != null) {
            setUrl(url);
        }

        String freetext = (String) attributes.get("freetext");

        if (freetext != null) {
            setFreetext(freetext);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        String abstrakt = (String) attributes.get("abstrakt");

        if (abstrakt != null) {
            setAbstrakt(abstrakt);
        }

        String subject = (String) attributes.get("subject");

        if (subject != null) {
            setSubject(subject);
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

        String type = (String) attributes.get("type");

        if (type != null) {
            setType(type);
        }

        String username = (String) attributes.get("username");

        if (username != null) {
            setUsername(username);
        }

        String password = (String) attributes.get("password");

        if (password != null) {
            setPassword(password);
        }
    }

    /**
    * Returns the primary key of this c s w harvester.
    *
    * @return the primary key of this c s w harvester
    */
    @Override
    public long getPrimaryKey() {
        return _cswHarvester.getPrimaryKey();
    }

    /**
    * Sets the primary key of this c s w harvester.
    *
    * @param primaryKey the primary key of this c s w harvester
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _cswHarvester.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the cswharvesterid of this c s w harvester.
    *
    * @return the cswharvesterid of this c s w harvester
    */
    @Override
    public long getCswharvesterid() {
        return _cswHarvester.getCswharvesterid();
    }

    /**
    * Sets the cswharvesterid of this c s w harvester.
    *
    * @param cswharvesterid the cswharvesterid of this c s w harvester
    */
    @Override
    public void setCswharvesterid(long cswharvesterid) {
        _cswHarvester.setCswharvesterid(cswharvesterid);
    }

    /**
    * Returns the name of this c s w harvester.
    *
    * @return the name of this c s w harvester
    */
    @Override
    public java.lang.String getName() {
        return _cswHarvester.getName();
    }

    /**
    * Sets the name of this c s w harvester.
    *
    * @param name the name of this c s w harvester
    */
    @Override
    public void setName(java.lang.String name) {
        _cswHarvester.setName(name);
    }

    /**
    * Returns the url of this c s w harvester.
    *
    * @return the url of this c s w harvester
    */
    @Override
    public java.lang.String getUrl() {
        return _cswHarvester.getUrl();
    }

    /**
    * Sets the url of this c s w harvester.
    *
    * @param url the url of this c s w harvester
    */
    @Override
    public void setUrl(java.lang.String url) {
        _cswHarvester.setUrl(url);
    }

    /**
    * Returns the freetext of this c s w harvester.
    *
    * @return the freetext of this c s w harvester
    */
    @Override
    public java.lang.String getFreetext() {
        return _cswHarvester.getFreetext();
    }

    /**
    * Sets the freetext of this c s w harvester.
    *
    * @param freetext the freetext of this c s w harvester
    */
    @Override
    public void setFreetext(java.lang.String freetext) {
        _cswHarvester.setFreetext(freetext);
    }

    /**
    * Returns the title of this c s w harvester.
    *
    * @return the title of this c s w harvester
    */
    @Override
    public java.lang.String getTitle() {
        return _cswHarvester.getTitle();
    }

    /**
    * Sets the title of this c s w harvester.
    *
    * @param title the title of this c s w harvester
    */
    @Override
    public void setTitle(java.lang.String title) {
        _cswHarvester.setTitle(title);
    }

    /**
    * Returns the abstrakt of this c s w harvester.
    *
    * @return the abstrakt of this c s w harvester
    */
    @Override
    public java.lang.String getAbstrakt() {
        return _cswHarvester.getAbstrakt();
    }

    /**
    * Sets the abstrakt of this c s w harvester.
    *
    * @param abstrakt the abstrakt of this c s w harvester
    */
    @Override
    public void setAbstrakt(java.lang.String abstrakt) {
        _cswHarvester.setAbstrakt(abstrakt);
    }

    /**
    * Returns the subject of this c s w harvester.
    *
    * @return the subject of this c s w harvester
    */
    @Override
    public java.lang.String getSubject() {
        return _cswHarvester.getSubject();
    }

    /**
    * Sets the subject of this c s w harvester.
    *
    * @param subject the subject of this c s w harvester
    */
    @Override
    public void setSubject(java.lang.String subject) {
        _cswHarvester.setSubject(subject);
    }

    /**
    * Returns the every of this c s w harvester.
    *
    * @return the every of this c s w harvester
    */
    @Override
    public int getEvery() {
        return _cswHarvester.getEvery();
    }

    /**
    * Sets the every of this c s w harvester.
    *
    * @param every the every of this c s w harvester
    */
    @Override
    public void setEvery(int every) {
        _cswHarvester.setEvery(every);
    }

    /**
    * Returns the topic of this c s w harvester.
    *
    * @return the topic of this c s w harvester
    */
    @Override
    public java.lang.String getTopic() {
        return _cswHarvester.getTopic();
    }

    /**
    * Sets the topic of this c s w harvester.
    *
    * @param topic the topic of this c s w harvester
    */
    @Override
    public void setTopic(java.lang.String topic) {
        _cswHarvester.setTopic(topic);
    }

    /**
    * Returns the status of this c s w harvester.
    *
    * @return the status of this c s w harvester
    */
    @Override
    public java.lang.String getStatus() {
        return _cswHarvester.getStatus();
    }

    /**
    * Sets the status of this c s w harvester.
    *
    * @param status the status of this c s w harvester
    */
    @Override
    public void setStatus(java.lang.String status) {
        _cswHarvester.setStatus(status);
    }

    /**
    * Returns the saved to geo network of this c s w harvester.
    *
    * @return the saved to geo network of this c s w harvester
    */
    @Override
    public boolean getSavedToGeoNetwork() {
        return _cswHarvester.getSavedToGeoNetwork();
    }

    /**
    * Returns <code>true</code> if this c s w harvester is saved to geo network.
    *
    * @return <code>true</code> if this c s w harvester is saved to geo network; <code>false</code> otherwise
    */
    @Override
    public boolean isSavedToGeoNetwork() {
        return _cswHarvester.isSavedToGeoNetwork();
    }

    /**
    * Sets whether this c s w harvester is saved to geo network.
    *
    * @param savedToGeoNetwork the saved to geo network of this c s w harvester
    */
    @Override
    public void setSavedToGeoNetwork(boolean savedToGeoNetwork) {
        _cswHarvester.setSavedToGeoNetwork(savedToGeoNetwork);
    }

    /**
    * Returns the geonetwork ID of this c s w harvester.
    *
    * @return the geonetwork ID of this c s w harvester
    */
    @Override
    public long getGeonetworkId() {
        return _cswHarvester.getGeonetworkId();
    }

    /**
    * Sets the geonetwork ID of this c s w harvester.
    *
    * @param geonetworkId the geonetwork ID of this c s w harvester
    */
    @Override
    public void setGeonetworkId(long geonetworkId) {
        _cswHarvester.setGeonetworkId(geonetworkId);
    }

    /**
    * Returns the geonetwork u u i d of this c s w harvester.
    *
    * @return the geonetwork u u i d of this c s w harvester
    */
    @Override
    public java.lang.String getGeonetworkUUID() {
        return _cswHarvester.getGeonetworkUUID();
    }

    /**
    * Sets the geonetwork u u i d of this c s w harvester.
    *
    * @param geonetworkUUID the geonetwork u u i d of this c s w harvester
    */
    @Override
    public void setGeonetworkUUID(java.lang.String geonetworkUUID) {
        _cswHarvester.setGeonetworkUUID(geonetworkUUID);
    }

    /**
    * Returns the company ID of this c s w harvester.
    *
    * @return the company ID of this c s w harvester
    */
    @Override
    public long getCompanyId() {
        return _cswHarvester.getCompanyId();
    }

    /**
    * Sets the company ID of this c s w harvester.
    *
    * @param companyId the company ID of this c s w harvester
    */
    @Override
    public void setCompanyId(long companyId) {
        _cswHarvester.setCompanyId(companyId);
    }

    /**
    * Returns the group ID of this c s w harvester.
    *
    * @return the group ID of this c s w harvester
    */
    @Override
    public long getGroupId() {
        return _cswHarvester.getGroupId();
    }

    /**
    * Sets the group ID of this c s w harvester.
    *
    * @param groupId the group ID of this c s w harvester
    */
    @Override
    public void setGroupId(long groupId) {
        _cswHarvester.setGroupId(groupId);
    }

    /**
    * Returns the type of this c s w harvester.
    *
    * @return the type of this c s w harvester
    */
    @Override
    public java.lang.String getType() {
        return _cswHarvester.getType();
    }

    /**
    * Sets the type of this c s w harvester.
    *
    * @param type the type of this c s w harvester
    */
    @Override
    public void setType(java.lang.String type) {
        _cswHarvester.setType(type);
    }

    /**
    * Returns the username of this c s w harvester.
    *
    * @return the username of this c s w harvester
    */
    @Override
    public java.lang.String getUsername() {
        return _cswHarvester.getUsername();
    }

    /**
    * Sets the username of this c s w harvester.
    *
    * @param username the username of this c s w harvester
    */
    @Override
    public void setUsername(java.lang.String username) {
        _cswHarvester.setUsername(username);
    }

    /**
    * Returns the password of this c s w harvester.
    *
    * @return the password of this c s w harvester
    */
    @Override
    public java.lang.String getPassword() {
        return _cswHarvester.getPassword();
    }

    /**
    * Sets the password of this c s w harvester.
    *
    * @param password the password of this c s w harvester
    */
    @Override
    public void setPassword(java.lang.String password) {
        _cswHarvester.setPassword(password);
    }

    @Override
    public boolean isNew() {
        return _cswHarvester.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _cswHarvester.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _cswHarvester.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _cswHarvester.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _cswHarvester.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _cswHarvester.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _cswHarvester.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _cswHarvester.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _cswHarvester.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _cswHarvester.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _cswHarvester.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new CSWHarvesterWrapper((CSWHarvester) _cswHarvester.clone());
    }

    @Override
    public int compareTo(CSWHarvester cswHarvester) {
        return _cswHarvester.compareTo(cswHarvester);
    }

    @Override
    public int hashCode() {
        return _cswHarvester.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<CSWHarvester> toCacheModel() {
        return _cswHarvester.toCacheModel();
    }

    @Override
    public CSWHarvester toEscapedModel() {
        return new CSWHarvesterWrapper(_cswHarvester.toEscapedModel());
    }

    @Override
    public CSWHarvester toUnescapedModel() {
        return new CSWHarvesterWrapper(_cswHarvester.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _cswHarvester.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _cswHarvester.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _cswHarvester.persist();
    }

    /**
    * heikki doeleman: Liferay won't let me override toString(), because if I do that it generates 2 declarations of toString()
    * in CSWHarvesterCpl, which does not compile. Thanks Liferay !
    *
    * @return shorter string than toString()
    */
    @Override
    public java.lang.String toShortString() {
        return _cswHarvester.toShortString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof CSWHarvesterWrapper)) {
            return false;
        }

        CSWHarvesterWrapper cswHarvesterWrapper = (CSWHarvesterWrapper) obj;

        if (Validator.equals(_cswHarvester, cswHarvesterWrapper._cswHarvester)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public CSWHarvester getWrappedCSWHarvester() {
        return _cswHarvester;
    }

    @Override
    public CSWHarvester getWrappedModel() {
        return _cswHarvester;
    }

    @Override
    public void resetOriginalValues() {
        _cswHarvester.resetOriginalValues();
    }
}
