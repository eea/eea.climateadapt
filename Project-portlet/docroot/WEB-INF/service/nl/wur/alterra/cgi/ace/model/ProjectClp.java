package nl.wur.alterra.cgi.ace.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import nl.wur.alterra.cgi.ace.service.ClpSerializer;
import nl.wur.alterra.cgi.ace.service.ProjectLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class ProjectClp extends BaseModelImpl<Project> implements Project {
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
    private BaseModel<?> _projectRemoteModel;

    public ProjectClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Project.class;
    }

    @Override
    public String getModelClassName() {
        return Project.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _projectId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setProjectId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _projectId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("projectId", getProjectId());
        attributes.put("companyId", getCompanyId());
        attributes.put("groupId", getGroupId());
        attributes.put("admincomment", getAdmincomment());
        attributes.put("acronym", getAcronym());
        attributes.put("title", getTitle());
        attributes.put("startdate", getStartdate());
        attributes.put("enddate", getEnddate());
        attributes.put("lead", getLead());
        attributes.put("partners", getPartners());
        attributes.put("funding", getFunding());
        attributes.put("sectors", getSectors());
        attributes.put("spatiallayer", getSpatiallayer());
        attributes.put("abstracts", getAbstracts());
        attributes.put("element", getElement());
        attributes.put("keywords", getKeywords());
        attributes.put("website", getWebsite());
        attributes.put("duration", getDuration());
        attributes.put("rating", getRating());
        attributes.put("importance", getImportance());
        attributes.put("specialtagging", getSpecialtagging());
        attributes.put("controlstatus", getControlstatus());
        attributes.put("creator", getCreator());
        attributes.put("creationdate", getCreationdate());
        attributes.put("moderator", getModerator());
        attributes.put("approvaldate", getApprovaldate());
        attributes.put("replacesId", getReplacesId());
        attributes.put("comments", getComments());
        attributes.put("textwebpage", getTextwebpage());
        attributes.put("spatialvalues", getSpatialvalues());
        attributes.put("source", getSource());
        attributes.put("climateimpacts", getClimateimpacts());
        attributes.put("lockdate", getLockdate());
        attributes.put("feature", getFeature());
        attributes.put("supdocs", getSupdocs());
        attributes.put("geochars", getGeochars());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long projectId = (Long) attributes.get("projectId");

        if (projectId != null) {
            setProjectId(projectId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        String admincomment = (String) attributes.get("admincomment");

        if (admincomment != null) {
            setAdmincomment(admincomment);
        }

        String acronym = (String) attributes.get("acronym");

        if (acronym != null) {
            setAcronym(acronym);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        Date startdate = (Date) attributes.get("startdate");

        if (startdate != null) {
            setStartdate(startdate);
        }

        Date enddate = (Date) attributes.get("enddate");

        if (enddate != null) {
            setEnddate(enddate);
        }

        String lead = (String) attributes.get("lead");

        if (lead != null) {
            setLead(lead);
        }

        String partners = (String) attributes.get("partners");

        if (partners != null) {
            setPartners(partners);
        }

        String funding = (String) attributes.get("funding");

        if (funding != null) {
            setFunding(funding);
        }

        String sectors = (String) attributes.get("sectors");

        if (sectors != null) {
            setSectors(sectors);
        }

        String spatiallayer = (String) attributes.get("spatiallayer");

        if (spatiallayer != null) {
            setSpatiallayer(spatiallayer);
        }

        String abstracts = (String) attributes.get("abstracts");

        if (abstracts != null) {
            setAbstracts(abstracts);
        }

        String element = (String) attributes.get("element");

        if (element != null) {
            setElement(element);
        }

        String keywords = (String) attributes.get("keywords");

        if (keywords != null) {
            setKeywords(keywords);
        }

        String website = (String) attributes.get("website");

        if (website != null) {
            setWebsite(website);
        }

        String duration = (String) attributes.get("duration");

        if (duration != null) {
            setDuration(duration);
        }

        Long rating = (Long) attributes.get("rating");

        if (rating != null) {
            setRating(rating);
        }

        Long importance = (Long) attributes.get("importance");

        if (importance != null) {
            setImportance(importance);
        }

        String specialtagging = (String) attributes.get("specialtagging");

        if (specialtagging != null) {
            setSpecialtagging(specialtagging);
        }

        Short controlstatus = (Short) attributes.get("controlstatus");

        if (controlstatus != null) {
            setControlstatus(controlstatus);
        }

        String creator = (String) attributes.get("creator");

        if (creator != null) {
            setCreator(creator);
        }

        Date creationdate = (Date) attributes.get("creationdate");

        if (creationdate != null) {
            setCreationdate(creationdate);
        }

        String moderator = (String) attributes.get("moderator");

        if (moderator != null) {
            setModerator(moderator);
        }

        Date approvaldate = (Date) attributes.get("approvaldate");

        if (approvaldate != null) {
            setApprovaldate(approvaldate);
        }

        Long replacesId = (Long) attributes.get("replacesId");

        if (replacesId != null) {
            setReplacesId(replacesId);
        }

        String comments = (String) attributes.get("comments");

        if (comments != null) {
            setComments(comments);
        }

        String textwebpage = (String) attributes.get("textwebpage");

        if (textwebpage != null) {
            setTextwebpage(textwebpage);
        }

        String spatialvalues = (String) attributes.get("spatialvalues");

        if (spatialvalues != null) {
            setSpatialvalues(spatialvalues);
        }

        String source = (String) attributes.get("source");

        if (source != null) {
            setSource(source);
        }

        String climateimpacts = (String) attributes.get("climateimpacts");

        if (climateimpacts != null) {
            setClimateimpacts(climateimpacts);
        }

        Date lockdate = (Date) attributes.get("lockdate");

        if (lockdate != null) {
            setLockdate(lockdate);
        }

        String feature = (String) attributes.get("feature");

        if (feature != null) {
            setFeature(feature);
        }

        String supdocs = (String) attributes.get("supdocs");

        if (supdocs != null) {
            setSupdocs(supdocs);
        }

        String geochars = (String) attributes.get("geochars");

        if (geochars != null) {
            setGeochars(geochars);
        }
    }

    @Override
    public long getProjectId() {
        return _projectId;
    }

    @Override
    public void setProjectId(long projectId) {
        _projectId = projectId;

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setProjectId", long.class);

                method.invoke(_projectRemoteModel, projectId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getCompanyId() {
        return _companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        _companyId = companyId;

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_projectRemoteModel, companyId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getGroupId() {
        return _groupId;
    }

    @Override
    public void setGroupId(long groupId) {
        _groupId = groupId;

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_projectRemoteModel, groupId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getAdmincomment() {
        return _admincomment;
    }

    @Override
    public void setAdmincomment(String admincomment) {
        _admincomment = admincomment;

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setAdmincomment", String.class);

                method.invoke(_projectRemoteModel, admincomment);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getAcronym() {
        return _acronym;
    }

    @Override
    public void setAcronym(String acronym) {
        _acronym = acronym;

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setAcronym", String.class);

                method.invoke(_projectRemoteModel, acronym);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getTitle() {
        return _title;
    }

    @Override
    public void setTitle(String title) {
        _title = title;

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setTitle", String.class);

                method.invoke(_projectRemoteModel, title);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getStartdate() {
        return _startdate;
    }

    @Override
    public void setStartdate(Date startdate) {
        _startdate = startdate;

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setStartdate", Date.class);

                method.invoke(_projectRemoteModel, startdate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getEnddate() {
        return _enddate;
    }

    @Override
    public void setEnddate(Date enddate) {
        _enddate = enddate;

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setEnddate", Date.class);

                method.invoke(_projectRemoteModel, enddate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getLead() {
        return _lead;
    }

    @Override
    public void setLead(String lead) {
        _lead = lead;

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setLead", String.class);

                method.invoke(_projectRemoteModel, lead);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getPartners() {
        return _partners;
    }

    @Override
    public void setPartners(String partners) {
        _partners = partners;

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setPartners", String.class);

                method.invoke(_projectRemoteModel, partners);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getFunding() {
        return _funding;
    }

    @Override
    public void setFunding(String funding) {
        _funding = funding;

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setFunding", String.class);

                method.invoke(_projectRemoteModel, funding);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getSectors() {
        return _sectors;
    }

    @Override
    public void setSectors(String sectors) {
        _sectors = sectors;

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setSectors", String.class);

                method.invoke(_projectRemoteModel, sectors);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getSpatiallayer() {
        return _spatiallayer;
    }

    @Override
    public void setSpatiallayer(String spatiallayer) {
        _spatiallayer = spatiallayer;

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setSpatiallayer", String.class);

                method.invoke(_projectRemoteModel, spatiallayer);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getAbstracts() {
        return _abstracts;
    }

    @Override
    public void setAbstracts(String abstracts) {
        _abstracts = abstracts;

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setAbstracts", String.class);

                method.invoke(_projectRemoteModel, abstracts);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getElement() {
        return _element;
    }

    @Override
    public void setElement(String element) {
        _element = element;

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setElement", String.class);

                method.invoke(_projectRemoteModel, element);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getKeywords() {
        return _keywords;
    }

    @Override
    public void setKeywords(String keywords) {
        _keywords = keywords;

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setKeywords", String.class);

                method.invoke(_projectRemoteModel, keywords);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getWebsite() {
        return _website;
    }

    @Override
    public void setWebsite(String website) {
        _website = website;

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setWebsite", String.class);

                method.invoke(_projectRemoteModel, website);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDuration() {
        return _duration;
    }

    @Override
    public void setDuration(String duration) {
        _duration = duration;

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setDuration", String.class);

                method.invoke(_projectRemoteModel, duration);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getRating() {
        return _rating;
    }

    @Override
    public void setRating(long rating) {
        _rating = rating;

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setRating", long.class);

                method.invoke(_projectRemoteModel, rating);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getImportance() {
        return _importance;
    }

    @Override
    public void setImportance(long importance) {
        _importance = importance;

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setImportance", long.class);

                method.invoke(_projectRemoteModel, importance);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getSpecialtagging() {
        return _specialtagging;
    }

    @Override
    public void setSpecialtagging(String specialtagging) {
        _specialtagging = specialtagging;

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setSpecialtagging",
                        String.class);

                method.invoke(_projectRemoteModel, specialtagging);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public short getControlstatus() {
        return _controlstatus;
    }

    @Override
    public void setControlstatus(short controlstatus) {
        _controlstatus = controlstatus;

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setControlstatus", short.class);

                method.invoke(_projectRemoteModel, controlstatus);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getCreator() {
        return _creator;
    }

    @Override
    public void setCreator(String creator) {
        _creator = creator;

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setCreator", String.class);

                method.invoke(_projectRemoteModel, creator);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getCreationdate() {
        return _creationdate;
    }

    @Override
    public void setCreationdate(Date creationdate) {
        _creationdate = creationdate;

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setCreationdate", Date.class);

                method.invoke(_projectRemoteModel, creationdate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getModerator() {
        return _moderator;
    }

    @Override
    public void setModerator(String moderator) {
        _moderator = moderator;

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setModerator", String.class);

                method.invoke(_projectRemoteModel, moderator);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getApprovaldate() {
        return _approvaldate;
    }

    @Override
    public void setApprovaldate(Date approvaldate) {
        _approvaldate = approvaldate;

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setApprovaldate", Date.class);

                method.invoke(_projectRemoteModel, approvaldate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getReplacesId() {
        return _replacesId;
    }

    @Override
    public void setReplacesId(long replacesId) {
        _replacesId = replacesId;

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setReplacesId", long.class);

                method.invoke(_projectRemoteModel, replacesId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getComments() {
        return _comments;
    }

    @Override
    public void setComments(String comments) {
        _comments = comments;

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setComments", String.class);

                method.invoke(_projectRemoteModel, comments);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getTextwebpage() {
        return _textwebpage;
    }

    @Override
    public void setTextwebpage(String textwebpage) {
        _textwebpage = textwebpage;

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setTextwebpage", String.class);

                method.invoke(_projectRemoteModel, textwebpage);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getSpatialvalues() {
        return _spatialvalues;
    }

    @Override
    public void setSpatialvalues(String spatialvalues) {
        _spatialvalues = spatialvalues;

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setSpatialvalues", String.class);

                method.invoke(_projectRemoteModel, spatialvalues);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getSource() {
        return _source;
    }

    @Override
    public void setSource(String source) {
        _source = source;

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setSource", String.class);

                method.invoke(_projectRemoteModel, source);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getClimateimpacts() {
        return _climateimpacts;
    }

    @Override
    public void setClimateimpacts(String climateimpacts) {
        _climateimpacts = climateimpacts;

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setClimateimpacts",
                        String.class);

                method.invoke(_projectRemoteModel, climateimpacts);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getLockdate() {
        return _lockdate;
    }

    @Override
    public void setLockdate(Date lockdate) {
        _lockdate = lockdate;

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setLockdate", Date.class);

                method.invoke(_projectRemoteModel, lockdate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getFeature() {
        return _feature;
    }

    @Override
    public void setFeature(String feature) {
        _feature = feature;

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setFeature", String.class);

                method.invoke(_projectRemoteModel, feature);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getSupdocs() {
        return _supdocs;
    }

    @Override
    public void setSupdocs(String supdocs) {
        _supdocs = supdocs;

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setSupdocs", String.class);

                method.invoke(_projectRemoteModel, supdocs);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getGeochars() {
        return _geochars;
    }

    @Override
    public void setGeochars(String geochars) {
        _geochars = geochars;

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setGeochars", String.class);

                method.invoke(_projectRemoteModel, geochars);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getProjectRemoteModel() {
        return _projectRemoteModel;
    }

    public void setProjectRemoteModel(BaseModel<?> projectRemoteModel) {
        _projectRemoteModel = projectRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _projectRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_projectRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            ProjectLocalServiceUtil.addProject(this);
        } else {
            ProjectLocalServiceUtil.updateProject(this);
        }
    }

    @Override
    public Project toEscapedModel() {
        return (Project) ProxyUtil.newProxyInstance(Project.class.getClassLoader(),
            new Class[] { Project.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        ProjectClp clone = new ProjectClp();

        clone.setProjectId(getProjectId());
        clone.setCompanyId(getCompanyId());
        clone.setGroupId(getGroupId());
        clone.setAdmincomment(getAdmincomment());
        clone.setAcronym(getAcronym());
        clone.setTitle(getTitle());
        clone.setStartdate(getStartdate());
        clone.setEnddate(getEnddate());
        clone.setLead(getLead());
        clone.setPartners(getPartners());
        clone.setFunding(getFunding());
        clone.setSectors(getSectors());
        clone.setSpatiallayer(getSpatiallayer());
        clone.setAbstracts(getAbstracts());
        clone.setElement(getElement());
        clone.setKeywords(getKeywords());
        clone.setWebsite(getWebsite());
        clone.setDuration(getDuration());
        clone.setRating(getRating());
        clone.setImportance(getImportance());
        clone.setSpecialtagging(getSpecialtagging());
        clone.setControlstatus(getControlstatus());
        clone.setCreator(getCreator());
        clone.setCreationdate(getCreationdate());
        clone.setModerator(getModerator());
        clone.setApprovaldate(getApprovaldate());
        clone.setReplacesId(getReplacesId());
        clone.setComments(getComments());
        clone.setTextwebpage(getTextwebpage());
        clone.setSpatialvalues(getSpatialvalues());
        clone.setSource(getSource());
        clone.setClimateimpacts(getClimateimpacts());
        clone.setLockdate(getLockdate());
        clone.setFeature(getFeature());
        clone.setSupdocs(getSupdocs());
        clone.setGeochars(getGeochars());

        return clone;
    }

    @Override
    public int compareTo(Project project) {
        int value = 0;

        value = getAcronym().compareTo(project.getAcronym());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ProjectClp)) {
            return false;
        }

        ProjectClp project = (ProjectClp) obj;

        long primaryKey = project.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(73);

        sb.append("{projectId=");
        sb.append(getProjectId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", admincomment=");
        sb.append(getAdmincomment());
        sb.append(", acronym=");
        sb.append(getAcronym());
        sb.append(", title=");
        sb.append(getTitle());
        sb.append(", startdate=");
        sb.append(getStartdate());
        sb.append(", enddate=");
        sb.append(getEnddate());
        sb.append(", lead=");
        sb.append(getLead());
        sb.append(", partners=");
        sb.append(getPartners());
        sb.append(", funding=");
        sb.append(getFunding());
        sb.append(", sectors=");
        sb.append(getSectors());
        sb.append(", spatiallayer=");
        sb.append(getSpatiallayer());
        sb.append(", abstracts=");
        sb.append(getAbstracts());
        sb.append(", element=");
        sb.append(getElement());
        sb.append(", keywords=");
        sb.append(getKeywords());
        sb.append(", website=");
        sb.append(getWebsite());
        sb.append(", duration=");
        sb.append(getDuration());
        sb.append(", rating=");
        sb.append(getRating());
        sb.append(", importance=");
        sb.append(getImportance());
        sb.append(", specialtagging=");
        sb.append(getSpecialtagging());
        sb.append(", controlstatus=");
        sb.append(getControlstatus());
        sb.append(", creator=");
        sb.append(getCreator());
        sb.append(", creationdate=");
        sb.append(getCreationdate());
        sb.append(", moderator=");
        sb.append(getModerator());
        sb.append(", approvaldate=");
        sb.append(getApprovaldate());
        sb.append(", replacesId=");
        sb.append(getReplacesId());
        sb.append(", comments=");
        sb.append(getComments());
        sb.append(", textwebpage=");
        sb.append(getTextwebpage());
        sb.append(", spatialvalues=");
        sb.append(getSpatialvalues());
        sb.append(", source=");
        sb.append(getSource());
        sb.append(", climateimpacts=");
        sb.append(getClimateimpacts());
        sb.append(", lockdate=");
        sb.append(getLockdate());
        sb.append(", feature=");
        sb.append(getFeature());
        sb.append(", supdocs=");
        sb.append(getSupdocs());
        sb.append(", geochars=");
        sb.append(getGeochars());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(112);

        sb.append("<model><model-name>");
        sb.append("nl.wur.alterra.cgi.ace.model.Project");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>projectId</column-name><column-value><![CDATA[");
        sb.append(getProjectId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyId</column-name><column-value><![CDATA[");
        sb.append(getCompanyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>groupId</column-name><column-value><![CDATA[");
        sb.append(getGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>admincomment</column-name><column-value><![CDATA[");
        sb.append(getAdmincomment());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>acronym</column-name><column-value><![CDATA[");
        sb.append(getAcronym());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>title</column-name><column-value><![CDATA[");
        sb.append(getTitle());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>startdate</column-name><column-value><![CDATA[");
        sb.append(getStartdate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>enddate</column-name><column-value><![CDATA[");
        sb.append(getEnddate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>lead</column-name><column-value><![CDATA[");
        sb.append(getLead());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>partners</column-name><column-value><![CDATA[");
        sb.append(getPartners());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>funding</column-name><column-value><![CDATA[");
        sb.append(getFunding());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>sectors</column-name><column-value><![CDATA[");
        sb.append(getSectors());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>spatiallayer</column-name><column-value><![CDATA[");
        sb.append(getSpatiallayer());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>abstracts</column-name><column-value><![CDATA[");
        sb.append(getAbstracts());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>element</column-name><column-value><![CDATA[");
        sb.append(getElement());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>keywords</column-name><column-value><![CDATA[");
        sb.append(getKeywords());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>website</column-name><column-value><![CDATA[");
        sb.append(getWebsite());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>duration</column-name><column-value><![CDATA[");
        sb.append(getDuration());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>rating</column-name><column-value><![CDATA[");
        sb.append(getRating());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>importance</column-name><column-value><![CDATA[");
        sb.append(getImportance());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>specialtagging</column-name><column-value><![CDATA[");
        sb.append(getSpecialtagging());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>controlstatus</column-name><column-value><![CDATA[");
        sb.append(getControlstatus());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>creator</column-name><column-value><![CDATA[");
        sb.append(getCreator());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>creationdate</column-name><column-value><![CDATA[");
        sb.append(getCreationdate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>moderator</column-name><column-value><![CDATA[");
        sb.append(getModerator());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>approvaldate</column-name><column-value><![CDATA[");
        sb.append(getApprovaldate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>replacesId</column-name><column-value><![CDATA[");
        sb.append(getReplacesId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>comments</column-name><column-value><![CDATA[");
        sb.append(getComments());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>textwebpage</column-name><column-value><![CDATA[");
        sb.append(getTextwebpage());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>spatialvalues</column-name><column-value><![CDATA[");
        sb.append(getSpatialvalues());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>source</column-name><column-value><![CDATA[");
        sb.append(getSource());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>climateimpacts</column-name><column-value><![CDATA[");
        sb.append(getClimateimpacts());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>lockdate</column-name><column-value><![CDATA[");
        sb.append(getLockdate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>feature</column-name><column-value><![CDATA[");
        sb.append(getFeature());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>supdocs</column-name><column-value><![CDATA[");
        sb.append(getSupdocs());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>geochars</column-name><column-value><![CDATA[");
        sb.append(getGeochars());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
