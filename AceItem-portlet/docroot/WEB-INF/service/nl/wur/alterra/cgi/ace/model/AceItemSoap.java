package nl.wur.alterra.cgi.ace.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author groot052
 * @generated
 */
public class AceItemSoap implements Serializable {
    private long _aceItemId;
    private long _companyId;
    private long _groupId;
    private long _wxsharvesterId;
    private long _cswharvesterId;
    private String _name;
    private String _description;
    private String _datatype;
    private String _storedAt;
    private String _storagetype;
    private String _specialtagging;
    private String _textSearch;
    private String _keyword;
    private String _targetresolution;
    private String _spatialLayer;
    private String _spatialValues;
    private Date _startDate;
    private Date _endDate;
    private Date _publicationDate;
    private String _sectors_;
    private String _elements_;
    private String _climateimpacts_;
    private long _rating;
    private long _importance;
    private String _source;
    private String _deeplink;
    private short _controlstatus;
    private String _creator;
    private Date _creationdate;
    private String _moderator;
    private Date _approvaldate;
    private long _replacesId;
    private String _comments;
    private String _textwebpage;

    public AceItemSoap() {
    }

    public static AceItemSoap toSoapModel(AceItem model) {
        AceItemSoap soapModel = new AceItemSoap();

        soapModel.setAceItemId(model.getAceItemId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setWxsharvesterId(model.getWxsharvesterId());
        soapModel.setCswharvesterId(model.getCswharvesterId());
        soapModel.setName(model.getName());
        soapModel.setDescription(model.getDescription());
        soapModel.setDatatype(model.getDatatype());
        soapModel.setStoredAt(model.getStoredAt());
        soapModel.setStoragetype(model.getStoragetype());
        soapModel.setSpecialtagging(model.getSpecialtagging());
        soapModel.setTextSearch(model.getTextSearch());
        soapModel.setKeyword(model.getKeyword());
        soapModel.setTargetresolution(model.getTargetresolution());
        soapModel.setSpatialLayer(model.getSpatialLayer());
        soapModel.setSpatialValues(model.getSpatialValues());
        soapModel.setStartDate(model.getStartDate());
        soapModel.setEndDate(model.getEndDate());
        soapModel.setPublicationDate(model.getPublicationDate());
        soapModel.setSectors_(model.getSectors_());
        soapModel.setElements_(model.getElements_());
        soapModel.setClimateimpacts_(model.getClimateimpacts_());
        soapModel.setRating(model.getRating());
        soapModel.setImportance(model.getImportance());
        soapModel.setSource(model.getSource());
        soapModel.setDeeplink(model.getDeeplink());
        soapModel.setControlstatus(model.getControlstatus());
        soapModel.setCreator(model.getCreator());
        soapModel.setCreationdate(model.getCreationdate());
        soapModel.setModerator(model.getModerator());
        soapModel.setApprovaldate(model.getApprovaldate());
        soapModel.setReplacesId(model.getReplacesId());
        soapModel.setComments(model.getComments());
        soapModel.setTextwebpage(model.getTextwebpage());

        return soapModel;
    }

    public static AceItemSoap[] toSoapModels(AceItem[] models) {
        AceItemSoap[] soapModels = new AceItemSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static AceItemSoap[][] toSoapModels(AceItem[][] models) {
        AceItemSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new AceItemSoap[models.length][models[0].length];
        } else {
            soapModels = new AceItemSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static AceItemSoap[] toSoapModels(List<AceItem> models) {
        List<AceItemSoap> soapModels = new ArrayList<AceItemSoap>(models.size());

        for (AceItem model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new AceItemSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _aceItemId;
    }

    public void setPrimaryKey(long pk) {
        setAceItemId(pk);
    }

    public long getAceItemId() {
        return _aceItemId;
    }

    public void setAceItemId(long aceItemId) {
        _aceItemId = aceItemId;
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

    public long getWxsharvesterId() {
        return _wxsharvesterId;
    }

    public void setWxsharvesterId(long wxsharvesterId) {
        _wxsharvesterId = wxsharvesterId;
    }

    public long getCswharvesterId() {
        return _cswharvesterId;
    }

    public void setCswharvesterId(long cswharvesterId) {
        _cswharvesterId = cswharvesterId;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public String getDatatype() {
        return _datatype;
    }

    public void setDatatype(String datatype) {
        _datatype = datatype;
    }

    public String getStoredAt() {
        return _storedAt;
    }

    public void setStoredAt(String storedAt) {
        _storedAt = storedAt;
    }

    public String getStoragetype() {
        return _storagetype;
    }

    public void setStoragetype(String storagetype) {
        _storagetype = storagetype;
    }

    public String getSpecialtagging() {
        return _specialtagging;
    }

    public void setSpecialtagging(String specialtagging) {
        _specialtagging = specialtagging;
    }

    public String getTextSearch() {
        return _textSearch;
    }

    public void setTextSearch(String textSearch) {
        _textSearch = textSearch;
    }

    public String getKeyword() {
        return _keyword;
    }

    public void setKeyword(String keyword) {
        _keyword = keyword;
    }

    public String getTargetresolution() {
        return _targetresolution;
    }

    public void setTargetresolution(String targetresolution) {
        _targetresolution = targetresolution;
    }

    public String getSpatialLayer() {
        return _spatialLayer;
    }

    public void setSpatialLayer(String spatialLayer) {
        _spatialLayer = spatialLayer;
    }

    public String getSpatialValues() {
        return _spatialValues;
    }

    public void setSpatialValues(String spatialValues) {
        _spatialValues = spatialValues;
    }

    public Date getStartDate() {
        return _startDate;
    }

    public void setStartDate(Date startDate) {
        _startDate = startDate;
    }

    public Date getEndDate() {
        return _endDate;
    }

    public void setEndDate(Date endDate) {
        _endDate = endDate;
    }

    public Date getPublicationDate() {
        return _publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        _publicationDate = publicationDate;
    }

    public String getSectors_() {
        return _sectors_;
    }

    public void setSectors_(String sectors_) {
        _sectors_ = sectors_;
    }

    public String getElements_() {
        return _elements_;
    }

    public void setElements_(String elements_) {
        _elements_ = elements_;
    }

    public String getClimateimpacts_() {
        return _climateimpacts_;
    }

    public void setClimateimpacts_(String climateimpacts_) {
        _climateimpacts_ = climateimpacts_;
    }

    public long getRating() {
        return _rating;
    }

    public void setRating(long rating) {
        _rating = rating;
    }

    public long getImportance() {
        return _importance;
    }

    public void setImportance(long importance) {
        _importance = importance;
    }

    public String getSource() {
        return _source;
    }

    public void setSource(String source) {
        _source = source;
    }

    public String getDeeplink() {
        return _deeplink;
    }

    public void setDeeplink(String deeplink) {
        _deeplink = deeplink;
    }

    public short getControlstatus() {
        return _controlstatus;
    }

    public void setControlstatus(short controlstatus) {
        _controlstatus = controlstatus;
    }

    public String getCreator() {
        return _creator;
    }

    public void setCreator(String creator) {
        _creator = creator;
    }

    public Date getCreationdate() {
        return _creationdate;
    }

    public void setCreationdate(Date creationdate) {
        _creationdate = creationdate;
    }

    public String getModerator() {
        return _moderator;
    }

    public void setModerator(String moderator) {
        _moderator = moderator;
    }

    public Date getApprovaldate() {
        return _approvaldate;
    }

    public void setApprovaldate(Date approvaldate) {
        _approvaldate = approvaldate;
    }

    public long getReplacesId() {
        return _replacesId;
    }

    public void setReplacesId(long replacesId) {
        _replacesId = replacesId;
    }

    public String getComments() {
        return _comments;
    }

    public void setComments(String comments) {
        _comments = comments;
    }

    public String getTextwebpage() {
        return _textwebpage;
    }

    public void setTextwebpage(String textwebpage) {
        _textwebpage = textwebpage;
    }
}
