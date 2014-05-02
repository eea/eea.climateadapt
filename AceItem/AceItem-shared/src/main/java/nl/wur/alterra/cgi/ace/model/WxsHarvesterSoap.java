package nl.wur.alterra.cgi.ace.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author groot052
 * @generated
 */
public class WxsHarvesterSoap implements Serializable {
    private long _wxsharvesterid;
    private String _name;
    private String _url;
    private String _ogctype;
    private int _every;
    private String _topic;
    private String _status;
    private boolean _savedToGeoNetwork;
    private long _geonetworkId;
    private String _geonetworkUUID;
    private long _companyId;
    private long _groupId;

    public WxsHarvesterSoap() {
    }

    public static WxsHarvesterSoap toSoapModel(WxsHarvester model) {
        WxsHarvesterSoap soapModel = new WxsHarvesterSoap();

        soapModel.setWxsharvesterid(model.getWxsharvesterid());
        soapModel.setName(model.getName());
        soapModel.setUrl(model.getUrl());
        soapModel.setOgctype(model.getOgctype());
        soapModel.setEvery(model.getEvery());
        soapModel.setTopic(model.getTopic());
        soapModel.setStatus(model.getStatus());
        soapModel.setSavedToGeoNetwork(model.getSavedToGeoNetwork());
        soapModel.setGeonetworkId(model.getGeonetworkId());
        soapModel.setGeonetworkUUID(model.getGeonetworkUUID());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setGroupId(model.getGroupId());

        return soapModel;
    }

    public static WxsHarvesterSoap[] toSoapModels(WxsHarvester[] models) {
        WxsHarvesterSoap[] soapModels = new WxsHarvesterSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static WxsHarvesterSoap[][] toSoapModels(WxsHarvester[][] models) {
        WxsHarvesterSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new WxsHarvesterSoap[models.length][models[0].length];
        } else {
            soapModels = new WxsHarvesterSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static WxsHarvesterSoap[] toSoapModels(List<WxsHarvester> models) {
        List<WxsHarvesterSoap> soapModels = new ArrayList<WxsHarvesterSoap>(models.size());

        for (WxsHarvester model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new WxsHarvesterSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _wxsharvesterid;
    }

    public void setPrimaryKey(long pk) {
        setWxsharvesterid(pk);
    }

    public long getWxsharvesterid() {
        return _wxsharvesterid;
    }

    public void setWxsharvesterid(long wxsharvesterid) {
        _wxsharvesterid = wxsharvesterid;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getUrl() {
        return _url;
    }

    public void setUrl(String url) {
        _url = url;
    }

    public String getOgctype() {
        return _ogctype;
    }

    public void setOgctype(String ogctype) {
        _ogctype = ogctype;
    }

    public int getEvery() {
        return _every;
    }

    public void setEvery(int every) {
        _every = every;
    }

    public String getTopic() {
        return _topic;
    }

    public void setTopic(String topic) {
        _topic = topic;
    }

    public String getStatus() {
        return _status;
    }

    public void setStatus(String status) {
        _status = status;
    }

    public boolean getSavedToGeoNetwork() {
        return _savedToGeoNetwork;
    }

    public boolean isSavedToGeoNetwork() {
        return _savedToGeoNetwork;
    }

    public void setSavedToGeoNetwork(boolean savedToGeoNetwork) {
        _savedToGeoNetwork = savedToGeoNetwork;
    }

    public long getGeonetworkId() {
        return _geonetworkId;
    }

    public void setGeonetworkId(long geonetworkId) {
        _geonetworkId = geonetworkId;
    }

    public String getGeonetworkUUID() {
        return _geonetworkUUID;
    }

    public void setGeonetworkUUID(String geonetworkUUID) {
        _geonetworkUUID = geonetworkUUID;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }
}
