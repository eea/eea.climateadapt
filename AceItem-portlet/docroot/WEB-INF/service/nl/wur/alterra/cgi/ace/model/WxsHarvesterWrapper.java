package nl.wur.alterra.cgi.ace.model;

/**
 * <p>
 * This class is a wrapper for {@link WxsHarvester}.
 * </p>
 *
 * @author    groot052
 * @see       WxsHarvester
 * @generated
 */
public class WxsHarvesterWrapper implements WxsHarvester {
    private WxsHarvester _wxsHarvester;

    public WxsHarvesterWrapper(WxsHarvester wxsHarvester) {
        _wxsHarvester = wxsHarvester;
    }

    public long getPrimaryKey() {
        return _wxsHarvester.getPrimaryKey();
    }

    public void setPrimaryKey(long pk) {
        _wxsHarvester.setPrimaryKey(pk);
    }

    public long getWxsharvesterid() {
        return _wxsHarvester.getWxsharvesterid();
    }

    public void setWxsharvesterid(long wxsharvesterid) {
        _wxsHarvester.setWxsharvesterid(wxsharvesterid);
    }

    public java.lang.String getName() {
        return _wxsHarvester.getName();
    }

    public void setName(java.lang.String name) {
        _wxsHarvester.setName(name);
    }

    public java.lang.String getUrl() {
        return _wxsHarvester.getUrl();
    }

    public void setUrl(java.lang.String url) {
        _wxsHarvester.setUrl(url);
    }

    public java.lang.String getOgctype() {
        return _wxsHarvester.getOgctype();
    }

    public void setOgctype(java.lang.String ogctype) {
        _wxsHarvester.setOgctype(ogctype);
    }

    public int getEvery() {
        return _wxsHarvester.getEvery();
    }

    public void setEvery(int every) {
        _wxsHarvester.setEvery(every);
    }

    public java.lang.String getTopic() {
        return _wxsHarvester.getTopic();
    }

    public void setTopic(java.lang.String topic) {
        _wxsHarvester.setTopic(topic);
    }

    public java.lang.String getStatus() {
        return _wxsHarvester.getStatus();
    }

    public void setStatus(java.lang.String status) {
        _wxsHarvester.setStatus(status);
    }

    public boolean getSavedToGeoNetwork() {
        return _wxsHarvester.getSavedToGeoNetwork();
    }

    public boolean isSavedToGeoNetwork() {
        return _wxsHarvester.isSavedToGeoNetwork();
    }

    public void setSavedToGeoNetwork(boolean savedToGeoNetwork) {
        _wxsHarvester.setSavedToGeoNetwork(savedToGeoNetwork);
    }

    public long getGeonetworkId() {
        return _wxsHarvester.getGeonetworkId();
    }

    public void setGeonetworkId(long geonetworkId) {
        _wxsHarvester.setGeonetworkId(geonetworkId);
    }

    public java.lang.String getGeonetworkUUID() {
        return _wxsHarvester.getGeonetworkUUID();
    }

    public void setGeonetworkUUID(java.lang.String geonetworkUUID) {
        _wxsHarvester.setGeonetworkUUID(geonetworkUUID);
    }

    public long getCompanyId() {
        return _wxsHarvester.getCompanyId();
    }

    public void setCompanyId(long companyId) {
        _wxsHarvester.setCompanyId(companyId);
    }

    public long getGroupId() {
        return _wxsHarvester.getGroupId();
    }

    public void setGroupId(long groupId) {
        _wxsHarvester.setGroupId(groupId);
    }

    public nl.wur.alterra.cgi.ace.model.WxsHarvester toEscapedModel() {
        return _wxsHarvester.toEscapedModel();
    }

    public boolean isNew() {
        return _wxsHarvester.isNew();
    }

    public void setNew(boolean n) {
        _wxsHarvester.setNew(n);
    }

    public boolean isCachedModel() {
        return _wxsHarvester.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _wxsHarvester.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _wxsHarvester.isEscapedModel();
    }

    public void setEscapedModel(boolean escapedModel) {
        _wxsHarvester.setEscapedModel(escapedModel);
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _wxsHarvester.getPrimaryKeyObj();
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _wxsHarvester.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _wxsHarvester.setExpandoBridgeAttributes(serviceContext);
    }

    public java.lang.Object clone() {
        return _wxsHarvester.clone();
    }

    public int compareTo(nl.wur.alterra.cgi.ace.model.WxsHarvester wxsHarvester) {
        return _wxsHarvester.compareTo(wxsHarvester);
    }

    public int hashCode() {
        return _wxsHarvester.hashCode();
    }

    public java.lang.String toString() {
        return _wxsHarvester.toString();
    }

    public java.lang.String toXmlString() {
        return _wxsHarvester.toXmlString();
    }

    public java.lang.String toShortString() {
        return _wxsHarvester.toShortString();
    }

    public WxsHarvester getWrappedWxsHarvester() {
        return _wxsHarvester;
    }
}
