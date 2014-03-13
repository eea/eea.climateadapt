package nl.wur.alterra.cgi.ace.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Groot052
 * @generated
 */
public class ProjectSoap implements Serializable {
    private long _projectId;
    private long _companyId;
    private long _groupId;
    private String _admincomment;
    private String _acronym;
    private String _title;
    private Date _startdate;
    private Date _enddate;
    private String _lead;
    private String _partners;
    private String _funding;
    private String _sectors;
    private String _spatiallayer;
    private String _abstracts;
    private String _element;
    private String _keywords;
    private String _website;
    private String _duration;
    private long _rating;
    private long _importance;
    private String _specialtagging;
    private short _controlstatus;
    private String _creator;
    private Date _creationdate;
    private String _moderator;
    private Date _approvaldate;
    private long _replacesId;
    private String _comments;
    private String _textwebpage;
    private String _spatialvalues;
    private String _source;
    private String _climateimpacts;
    private Date _lockdate;
    private String _feature;
    private String _supdocs;
    private String _geochars;

    public ProjectSoap() {
    }

    public static ProjectSoap toSoapModel(Project model) {
        ProjectSoap soapModel = new ProjectSoap();

        soapModel.setProjectId(model.getProjectId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setAdmincomment(model.getAdmincomment());
        soapModel.setAcronym(model.getAcronym());
        soapModel.setTitle(model.getTitle());
        soapModel.setStartdate(model.getStartdate());
        soapModel.setEnddate(model.getEnddate());
        soapModel.setLead(model.getLead());
        soapModel.setPartners(model.getPartners());
        soapModel.setFunding(model.getFunding());
        soapModel.setSectors(model.getSectors());
        soapModel.setSpatiallayer(model.getSpatiallayer());
        soapModel.setAbstracts(model.getAbstracts());
        soapModel.setElement(model.getElement());
        soapModel.setKeywords(model.getKeywords());
        soapModel.setWebsite(model.getWebsite());
        soapModel.setDuration(model.getDuration());
        soapModel.setRating(model.getRating());
        soapModel.setImportance(model.getImportance());
        soapModel.setSpecialtagging(model.getSpecialtagging());
        soapModel.setControlstatus(model.getControlstatus());
        soapModel.setCreator(model.getCreator());
        soapModel.setCreationdate(model.getCreationdate());
        soapModel.setModerator(model.getModerator());
        soapModel.setApprovaldate(model.getApprovaldate());
        soapModel.setReplacesId(model.getReplacesId());
        soapModel.setComments(model.getComments());
        soapModel.setTextwebpage(model.getTextwebpage());
        soapModel.setSpatialvalues(model.getSpatialvalues());
        soapModel.setSource(model.getSource());
        soapModel.setClimateimpacts(model.getClimateimpacts());
        soapModel.setLockdate(model.getLockdate());
        soapModel.setFeature(model.getFeature());
        soapModel.setSupdocs(model.getSupdocs());
        soapModel.setGeochars(model.getGeochars());

        return soapModel;
    }

    public static ProjectSoap[] toSoapModels(Project[] models) {
        ProjectSoap[] soapModels = new ProjectSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ProjectSoap[][] toSoapModels(Project[][] models) {
        ProjectSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ProjectSoap[models.length][models[0].length];
        } else {
            soapModels = new ProjectSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ProjectSoap[] toSoapModels(List<Project> models) {
        List<ProjectSoap> soapModels = new ArrayList<ProjectSoap>(models.size());

        for (Project model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ProjectSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _projectId;
    }

    public void setPrimaryKey(long pk) {
        setProjectId(pk);
    }

    public long getProjectId() {
        return _projectId;
    }

    public void setProjectId(long projectId) {
        _projectId = projectId;
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

    public String getAdmincomment() {
        return _admincomment;
    }

    public void setAdmincomment(String admincomment) {
        _admincomment = admincomment;
    }

    public String getAcronym() {
        return _acronym;
    }

    public void setAcronym(String acronym) {
        _acronym = acronym;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        _title = title;
    }

    public Date getStartdate() {
        return _startdate;
    }

    public void setStartdate(Date startdate) {
        _startdate = startdate;
    }

    public Date getEnddate() {
        return _enddate;
    }

    public void setEnddate(Date enddate) {
        _enddate = enddate;
    }

    public String getLead() {
        return _lead;
    }

    public void setLead(String lead) {
        _lead = lead;
    }

    public String getPartners() {
        return _partners;
    }

    public void setPartners(String partners) {
        _partners = partners;
    }

    public String getFunding() {
        return _funding;
    }

    public void setFunding(String funding) {
        _funding = funding;
    }

    public String getSectors() {
        return _sectors;
    }

    public void setSectors(String sectors) {
        _sectors = sectors;
    }

    public String getSpatiallayer() {
        return _spatiallayer;
    }

    public void setSpatiallayer(String spatiallayer) {
        _spatiallayer = spatiallayer;
    }

    public String getAbstracts() {
        return _abstracts;
    }

    public void setAbstracts(String abstracts) {
        _abstracts = abstracts;
    }

    public String getElement() {
        return _element;
    }

    public void setElement(String element) {
        _element = element;
    }

    public String getKeywords() {
        return _keywords;
    }

    public void setKeywords(String keywords) {
        _keywords = keywords;
    }

    public String getWebsite() {
        return _website;
    }

    public void setWebsite(String website) {
        _website = website;
    }

    public String getDuration() {
        return _duration;
    }

    public void setDuration(String duration) {
        _duration = duration;
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

    public String getSpecialtagging() {
        return _specialtagging;
    }

    public void setSpecialtagging(String specialtagging) {
        _specialtagging = specialtagging;
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

    public String getSpatialvalues() {
        return _spatialvalues;
    }

    public void setSpatialvalues(String spatialvalues) {
        _spatialvalues = spatialvalues;
    }

    public String getSource() {
        return _source;
    }

    public void setSource(String source) {
        _source = source;
    }

    public String getClimateimpacts() {
        return _climateimpacts;
    }

    public void setClimateimpacts(String climateimpacts) {
        _climateimpacts = climateimpacts;
    }

    public Date getLockdate() {
        return _lockdate;
    }

    public void setLockdate(Date lockdate) {
        _lockdate = lockdate;
    }

    public String getFeature() {
        return _feature;
    }

    public void setFeature(String feature) {
        _feature = feature;
    }

    public String getSupdocs() {
        return _supdocs;
    }

    public void setSupdocs(String supdocs) {
        _supdocs = supdocs;
    }

    public String getGeochars() {
        return _geochars;
    }

    public void setGeochars(String geochars) {
        _geochars = geochars;
    }
}
