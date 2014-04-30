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
public class MeasureSoap implements Serializable {
    private long _measureId;
    private long _companyId;
    private long _groupId;
    private String _admincomment;
    private String _casestudyfeature;
    private String _name;
    private String _description;
    private String _implementationtype;
    private String _implementationtime;
    private String _lifetime;
    private String _spatiallayer;
    private String _spatialvalues;
    private String _legalaspects;
    private String _stakeholderparticipation;
    private String _contact;
    private String _objectives;
    private String _challenges;
    private String _adaptationoptions;
    private String _solutions;
    private String _relevance;
    private String _succeslimitations;
    private String _website;
    private String _costbenefit;
    private String _keywords;
    private String _geos_;
    private Date _startdate;
    private Date _enddate;
    private Date _publicationdate;
    private String _specialtagging;
    private String _sectors_;
    private String _elements_;
    private String _climateimpacts_;
    private String _mao_type;
    private String _source;
    private long _rating;
    private long _importance;
    private double _lon;
    private double _lat;
    private String _satarea;
    private short _controlstatus;
    private String _creator;
    private Date _creationdate;
    private String _moderator;
    private Date _approvaldate;
    private long _replacesId;
    private String _comments;
    private String _textwebpage;
    private String _primephoto;
    private String _supphotos;
    private String _supdocs;
    private String _year;
    private String _geochars;
    private String _category;
    private Date _lockdate;

    public MeasureSoap() {
    }

    public static MeasureSoap toSoapModel(Measure model) {
        MeasureSoap soapModel = new MeasureSoap();

        soapModel.setMeasureId(model.getMeasureId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setAdmincomment(model.getAdmincomment());
        soapModel.setCasestudyfeature(model.getCasestudyfeature());
        soapModel.setName(model.getName());
        soapModel.setDescription(model.getDescription());
        soapModel.setImplementationtype(model.getImplementationtype());
        soapModel.setImplementationtime(model.getImplementationtime());
        soapModel.setLifetime(model.getLifetime());
        soapModel.setSpatiallayer(model.getSpatiallayer());
        soapModel.setSpatialvalues(model.getSpatialvalues());
        soapModel.setLegalaspects(model.getLegalaspects());
        soapModel.setStakeholderparticipation(model.getStakeholderparticipation());
        soapModel.setContact(model.getContact());
        soapModel.setObjectives(model.getObjectives());
        soapModel.setChallenges(model.getChallenges());
        soapModel.setAdaptationoptions(model.getAdaptationoptions());
        soapModel.setSolutions(model.getSolutions());
        soapModel.setRelevance(model.getRelevance());
        soapModel.setSucceslimitations(model.getSucceslimitations());
        soapModel.setWebsite(model.getWebsite());
        soapModel.setCostbenefit(model.getCostbenefit());
        soapModel.setKeywords(model.getKeywords());
        soapModel.setGeos_(model.getGeos_());
        soapModel.setStartdate(model.getStartdate());
        soapModel.setEnddate(model.getEnddate());
        soapModel.setPublicationdate(model.getPublicationdate());
        soapModel.setSpecialtagging(model.getSpecialtagging());
        soapModel.setSectors_(model.getSectors_());
        soapModel.setElements_(model.getElements_());
        soapModel.setClimateimpacts_(model.getClimateimpacts_());
        soapModel.setMao_type(model.getMao_type());
        soapModel.setSource(model.getSource());
        soapModel.setRating(model.getRating());
        soapModel.setImportance(model.getImportance());
        soapModel.setLon(model.getLon());
        soapModel.setLat(model.getLat());
        soapModel.setSatarea(model.getSatarea());
        soapModel.setControlstatus(model.getControlstatus());
        soapModel.setCreator(model.getCreator());
        soapModel.setCreationdate(model.getCreationdate());
        soapModel.setModerator(model.getModerator());
        soapModel.setApprovaldate(model.getApprovaldate());
        soapModel.setReplacesId(model.getReplacesId());
        soapModel.setComments(model.getComments());
        soapModel.setTextwebpage(model.getTextwebpage());
        soapModel.setPrimephoto(model.getPrimephoto());
        soapModel.setSupphotos(model.getSupphotos());
        soapModel.setSupdocs(model.getSupdocs());
        soapModel.setYear(model.getYear());
        soapModel.setGeochars(model.getGeochars());
        soapModel.setCategory(model.getCategory());
        soapModel.setLockdate(model.getLockdate());

        return soapModel;
    }

    public static MeasureSoap[] toSoapModels(Measure[] models) {
        MeasureSoap[] soapModels = new MeasureSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static MeasureSoap[][] toSoapModels(Measure[][] models) {
        MeasureSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new MeasureSoap[models.length][models[0].length];
        } else {
            soapModels = new MeasureSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static MeasureSoap[] toSoapModels(List<Measure> models) {
        List<MeasureSoap> soapModels = new ArrayList<MeasureSoap>(models.size());

        for (Measure model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new MeasureSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _measureId;
    }

    public void setPrimaryKey(long pk) {
        setMeasureId(pk);
    }

    public long getMeasureId() {
        return _measureId;
    }

    public void setMeasureId(long measureId) {
        _measureId = measureId;
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

    public String getCasestudyfeature() {
        return _casestudyfeature;
    }

    public void setCasestudyfeature(String casestudyfeature) {
        _casestudyfeature = casestudyfeature;
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

    public String getImplementationtype() {
        return _implementationtype;
    }

    public void setImplementationtype(String implementationtype) {
        _implementationtype = implementationtype;
    }

    public String getImplementationtime() {
        return _implementationtime;
    }

    public void setImplementationtime(String implementationtime) {
        _implementationtime = implementationtime;
    }

    public String getLifetime() {
        return _lifetime;
    }

    public void setLifetime(String lifetime) {
        _lifetime = lifetime;
    }

    public String getSpatiallayer() {
        return _spatiallayer;
    }

    public void setSpatiallayer(String spatiallayer) {
        _spatiallayer = spatiallayer;
    }

    public String getSpatialvalues() {
        return _spatialvalues;
    }

    public void setSpatialvalues(String spatialvalues) {
        _spatialvalues = spatialvalues;
    }

    public String getLegalaspects() {
        return _legalaspects;
    }

    public void setLegalaspects(String legalaspects) {
        _legalaspects = legalaspects;
    }

    public String getStakeholderparticipation() {
        return _stakeholderparticipation;
    }

    public void setStakeholderparticipation(String stakeholderparticipation) {
        _stakeholderparticipation = stakeholderparticipation;
    }

    public String getContact() {
        return _contact;
    }

    public void setContact(String contact) {
        _contact = contact;
    }

    public String getObjectives() {
        return _objectives;
    }

    public void setObjectives(String objectives) {
        _objectives = objectives;
    }

    public String getChallenges() {
        return _challenges;
    }

    public void setChallenges(String challenges) {
        _challenges = challenges;
    }

    public String getAdaptationoptions() {
        return _adaptationoptions;
    }

    public void setAdaptationoptions(String adaptationoptions) {
        _adaptationoptions = adaptationoptions;
    }

    public String getSolutions() {
        return _solutions;
    }

    public void setSolutions(String solutions) {
        _solutions = solutions;
    }

    public String getRelevance() {
        return _relevance;
    }

    public void setRelevance(String relevance) {
        _relevance = relevance;
    }

    public String getSucceslimitations() {
        return _succeslimitations;
    }

    public void setSucceslimitations(String succeslimitations) {
        _succeslimitations = succeslimitations;
    }

    public String getWebsite() {
        return _website;
    }

    public void setWebsite(String website) {
        _website = website;
    }

    public String getCostbenefit() {
        return _costbenefit;
    }

    public void setCostbenefit(String costbenefit) {
        _costbenefit = costbenefit;
    }

    public String getKeywords() {
        return _keywords;
    }

    public void setKeywords(String keywords) {
        _keywords = keywords;
    }

    public String getGeos_() {
        return _geos_;
    }

    public void setGeos_(String geos_) {
        _geos_ = geos_;
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

    public Date getPublicationdate() {
        return _publicationdate;
    }

    public void setPublicationdate(Date publicationdate) {
        _publicationdate = publicationdate;
    }

    public String getSpecialtagging() {
        return _specialtagging;
    }

    public void setSpecialtagging(String specialtagging) {
        _specialtagging = specialtagging;
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

    public String getMao_type() {
        return _mao_type;
    }

    public void setMao_type(String mao_type) {
        _mao_type = mao_type;
    }

    public String getSource() {
        return _source;
    }

    public void setSource(String source) {
        _source = source;
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

    public double getLon() {
        return _lon;
    }

    public void setLon(double lon) {
        _lon = lon;
    }

    public double getLat() {
        return _lat;
    }

    public void setLat(double lat) {
        _lat = lat;
    }

    public String getSatarea() {
        return _satarea;
    }

    public void setSatarea(String satarea) {
        _satarea = satarea;
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

    public String getPrimephoto() {
        return _primephoto;
    }

    public void setPrimephoto(String primephoto) {
        _primephoto = primephoto;
    }

    public String getSupphotos() {
        return _supphotos;
    }

    public void setSupphotos(String supphotos) {
        _supphotos = supphotos;
    }

    public String getSupdocs() {
        return _supdocs;
    }

    public void setSupdocs(String supdocs) {
        _supdocs = supdocs;
    }

    public String getYear() {
        return _year;
    }

    public void setYear(String year) {
        _year = year;
    }

    public String getGeochars() {
        return _geochars;
    }

    public void setGeochars(String geochars) {
        _geochars = geochars;
    }

    public String getCategory() {
        return _category;
    }

    public void setCategory(String category) {
        _category = category;
    }

    public Date getLockdate() {
        return _lockdate;
    }

    public void setLockdate(Date lockdate) {
        _lockdate = lockdate;
    }
}
