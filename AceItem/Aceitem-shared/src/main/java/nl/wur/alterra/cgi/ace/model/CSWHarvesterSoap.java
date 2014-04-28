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
public class CSWHarvesterSoap implements Serializable {
    private long _cswharvesterid;
    private String _name;
    private String _url;
    private String _freetext;
    private String _title;
    private String _abstrakt;
    private String _subject;
    private int _every;
    private String _topic;
    private String _status;
    private boolean _savedToGeoNetwork;
    private long _geonetworkId;
    private String _geonetworkUUID;
    private long _companyId;
    private long _groupId;
    private String _type;
    private String _username;
    private String _password;

    public CSWHarvesterSoap() {
    }

    public static CSWHarvesterSoap toSoapModel(CSWHarvester model) {
        CSWHarvesterSoap soapModel = new CSWHarvesterSoap();

        soapModel.setCswharvesterid(model.getCswharvesterid());
        soapModel.setName(model.getName());
        soapModel.setUrl(model.getUrl());
        soapModel.setFreetext(model.getFreetext());
        soapModel.setTitle(model.getTitle());
        soapModel.setAbstrakt(model.getAbstrakt());
        soapModel.setSubject(model.getSubject());
        soapModel.setEvery(model.getEvery());
        soapModel.setTopic(model.getTopic());
        soapModel.setStatus(model.getStatus());
        soapModel.setSavedToGeoNetwork(model.getSavedToGeoNetwork());
        soapModel.setGeonetworkId(model.getGeonetworkId());
        soapModel.setGeonetworkUUID(model.getGeonetworkUUID());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setType(model.getType());
        soapModel.setUsername(model.getUsername());
        soapModel.setPassword(model.getPassword());

        return soapModel;
    }

    public static CSWHarvesterSoap[] toSoapModels(CSWHarvester[] models) {
        CSWHarvesterSoap[] soapModels = new CSWHarvesterSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static CSWHarvesterSoap[][] toSoapModels(CSWHarvester[][] models) {
        CSWHarvesterSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new CSWHarvesterSoap[models.length][models[0].length];
        } else {
            soapModels = new CSWHarvesterSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static CSWHarvesterSoap[] toSoapModels(List<CSWHarvester> models) {
        List<CSWHarvesterSoap> soapModels = new ArrayList<CSWHarvesterSoap>(models.size());

        for (CSWHarvester model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new CSWHarvesterSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _cswharvesterid;
    }

    public void setPrimaryKey(long pk) {
        setCswharvesterid(pk);
    }

    public long getCswharvesterid() {
        return _cswharvesterid;
    }

    public void setCswharvesterid(long cswharvesterid) {
        _cswharvesterid = cswharvesterid;
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

    public String getFreetext() {
        return _freetext;
    }

    public void setFreetext(String freetext) {
        _freetext = freetext;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        _title = title;
    }

    public String getAbstrakt() {
        return _abstrakt;
    }

    public void setAbstrakt(String abstrakt) {
        _abstrakt = abstrakt;
    }

    public String getSubject() {
        return _subject;
    }

    public void setSubject(String subject) {
        _subject = subject;
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

    public String getType() {
        return _type;
    }

    public void setType(String type) {
        _type = type;
    }

    public String getUsername() {
        return _username;
    }

    public void setUsername(String username) {
        _username = username;
    }

    public String getPassword() {
        return _password;
    }

    public void setPassword(String password) {
        _password = password;
    }
}
