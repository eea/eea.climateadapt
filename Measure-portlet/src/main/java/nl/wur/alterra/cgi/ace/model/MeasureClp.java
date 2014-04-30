package nl.wur.alterra.cgi.ace.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import nl.wur.alterra.cgi.ace.service.ClpSerializer;
import nl.wur.alterra.cgi.ace.service.MeasureLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class MeasureClp extends BaseModelImpl<Measure> implements Measure {
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
    private BaseModel<?> _measureRemoteModel;

    public MeasureClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Measure.class;
    }

    @Override
    public String getModelClassName() {
        return Measure.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _measureId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setMeasureId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _measureId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("measureId", getMeasureId());
        attributes.put("companyId", getCompanyId());
        attributes.put("groupId", getGroupId());
        attributes.put("admincomment", getAdmincomment());
        attributes.put("casestudyfeature", getCasestudyfeature());
        attributes.put("name", getName());
        attributes.put("description", getDescription());
        attributes.put("implementationtype", getImplementationtype());
        attributes.put("implementationtime", getImplementationtime());
        attributes.put("lifetime", getLifetime());
        attributes.put("spatiallayer", getSpatiallayer());
        attributes.put("spatialvalues", getSpatialvalues());
        attributes.put("legalaspects", getLegalaspects());
        attributes.put("stakeholderparticipation", getStakeholderparticipation());
        attributes.put("contact", getContact());
        attributes.put("objectives", getObjectives());
        attributes.put("challenges", getChallenges());
        attributes.put("adaptationoptions", getAdaptationoptions());
        attributes.put("solutions", getSolutions());
        attributes.put("relevance", getRelevance());
        attributes.put("succeslimitations", getSucceslimitations());
        attributes.put("website", getWebsite());
        attributes.put("costbenefit", getCostbenefit());
        attributes.put("keywords", getKeywords());
        attributes.put("geos_", getGeos_());
        attributes.put("startdate", getStartdate());
        attributes.put("enddate", getEnddate());
        attributes.put("publicationdate", getPublicationdate());
        attributes.put("specialtagging", getSpecialtagging());
        attributes.put("sectors_", getSectors_());
        attributes.put("elements_", getElements_());
        attributes.put("climateimpacts_", getClimateimpacts_());
        attributes.put("mao_type", getMao_type());
        attributes.put("source", getSource());
        attributes.put("rating", getRating());
        attributes.put("importance", getImportance());
        attributes.put("lon", getLon());
        attributes.put("lat", getLat());
        attributes.put("satarea", getSatarea());
        attributes.put("controlstatus", getControlstatus());
        attributes.put("creator", getCreator());
        attributes.put("creationdate", getCreationdate());
        attributes.put("moderator", getModerator());
        attributes.put("approvaldate", getApprovaldate());
        attributes.put("replacesId", getReplacesId());
        attributes.put("comments", getComments());
        attributes.put("textwebpage", getTextwebpage());
        attributes.put("primephoto", getPrimephoto());
        attributes.put("supphotos", getSupphotos());
        attributes.put("supdocs", getSupdocs());
        attributes.put("year", getYear());
        attributes.put("geochars", getGeochars());
        attributes.put("category", getCategory());
        attributes.put("lockdate", getLockdate());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long measureId = (Long) attributes.get("measureId");

        if (measureId != null) {
            setMeasureId(measureId);
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

        String casestudyfeature = (String) attributes.get("casestudyfeature");

        if (casestudyfeature != null) {
            setCasestudyfeature(casestudyfeature);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        String implementationtype = (String) attributes.get(
                "implementationtype");

        if (implementationtype != null) {
            setImplementationtype(implementationtype);
        }

        String implementationtime = (String) attributes.get(
                "implementationtime");

        if (implementationtime != null) {
            setImplementationtime(implementationtime);
        }

        String lifetime = (String) attributes.get("lifetime");

        if (lifetime != null) {
            setLifetime(lifetime);
        }

        String spatiallayer = (String) attributes.get("spatiallayer");

        if (spatiallayer != null) {
            setSpatiallayer(spatiallayer);
        }

        String spatialvalues = (String) attributes.get("spatialvalues");

        if (spatialvalues != null) {
            setSpatialvalues(spatialvalues);
        }

        String legalaspects = (String) attributes.get("legalaspects");

        if (legalaspects != null) {
            setLegalaspects(legalaspects);
        }

        String stakeholderparticipation = (String) attributes.get(
                "stakeholderparticipation");

        if (stakeholderparticipation != null) {
            setStakeholderparticipation(stakeholderparticipation);
        }

        String contact = (String) attributes.get("contact");

        if (contact != null) {
            setContact(contact);
        }

        String objectives = (String) attributes.get("objectives");

        if (objectives != null) {
            setObjectives(objectives);
        }

        String challenges = (String) attributes.get("challenges");

        if (challenges != null) {
            setChallenges(challenges);
        }

        String adaptationoptions = (String) attributes.get("adaptationoptions");

        if (adaptationoptions != null) {
            setAdaptationoptions(adaptationoptions);
        }

        String solutions = (String) attributes.get("solutions");

        if (solutions != null) {
            setSolutions(solutions);
        }

        String relevance = (String) attributes.get("relevance");

        if (relevance != null) {
            setRelevance(relevance);
        }

        String succeslimitations = (String) attributes.get("succeslimitations");

        if (succeslimitations != null) {
            setSucceslimitations(succeslimitations);
        }

        String website = (String) attributes.get("website");

        if (website != null) {
            setWebsite(website);
        }

        String costbenefit = (String) attributes.get("costbenefit");

        if (costbenefit != null) {
            setCostbenefit(costbenefit);
        }

        String keywords = (String) attributes.get("keywords");

        if (keywords != null) {
            setKeywords(keywords);
        }

        String geos_ = (String) attributes.get("geos_");

        if (geos_ != null) {
            setGeos_(geos_);
        }

        Date startdate = (Date) attributes.get("startdate");

        if (startdate != null) {
            setStartdate(startdate);
        }

        Date enddate = (Date) attributes.get("enddate");

        if (enddate != null) {
            setEnddate(enddate);
        }

        Date publicationdate = (Date) attributes.get("publicationdate");

        if (publicationdate != null) {
            setPublicationdate(publicationdate);
        }

        String specialtagging = (String) attributes.get("specialtagging");

        if (specialtagging != null) {
            setSpecialtagging(specialtagging);
        }

        String sectors_ = (String) attributes.get("sectors_");

        if (sectors_ != null) {
            setSectors_(sectors_);
        }

        String elements_ = (String) attributes.get("elements_");

        if (elements_ != null) {
            setElements_(elements_);
        }

        String climateimpacts_ = (String) attributes.get("climateimpacts_");

        if (climateimpacts_ != null) {
            setClimateimpacts_(climateimpacts_);
        }

        String mao_type = (String) attributes.get("mao_type");

        if (mao_type != null) {
            setMao_type(mao_type);
        }

        String source = (String) attributes.get("source");

        if (source != null) {
            setSource(source);
        }

        Long rating = (Long) attributes.get("rating");

        if (rating != null) {
            setRating(rating);
        }

        Long importance = (Long) attributes.get("importance");

        if (importance != null) {
            setImportance(importance);
        }

        Double lon = (Double) attributes.get("lon");

        if (lon != null) {
            setLon(lon);
        }

        Double lat = (Double) attributes.get("lat");

        if (lat != null) {
            setLat(lat);
        }

        String satarea = (String) attributes.get("satarea");

        if (satarea != null) {
            setSatarea(satarea);
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

        String primephoto = (String) attributes.get("primephoto");

        if (primephoto != null) {
            setPrimephoto(primephoto);
        }

        String supphotos = (String) attributes.get("supphotos");

        if (supphotos != null) {
            setSupphotos(supphotos);
        }

        String supdocs = (String) attributes.get("supdocs");

        if (supdocs != null) {
            setSupdocs(supdocs);
        }

        String year = (String) attributes.get("year");

        if (year != null) {
            setYear(year);
        }

        String geochars = (String) attributes.get("geochars");

        if (geochars != null) {
            setGeochars(geochars);
        }

        String category = (String) attributes.get("category");

        if (category != null) {
            setCategory(category);
        }

        Date lockdate = (Date) attributes.get("lockdate");

        if (lockdate != null) {
            setLockdate(lockdate);
        }
    }

    @Override
    public long getMeasureId() {
        return _measureId;
    }

    @Override
    public void setMeasureId(long measureId) {
        _measureId = measureId;

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setMeasureId", long.class);

                method.invoke(_measureRemoteModel, measureId);
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

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_measureRemoteModel, companyId);
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

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_measureRemoteModel, groupId);
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

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setAdmincomment", String.class);

                method.invoke(_measureRemoteModel, admincomment);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getCasestudyfeature() {
        return _casestudyfeature;
    }

    @Override
    public void setCasestudyfeature(String casestudyfeature) {
        _casestudyfeature = casestudyfeature;

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setCasestudyfeature",
                        String.class);

                method.invoke(_measureRemoteModel, casestudyfeature);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public void setName(String name) {
        _name = name;

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setName", String.class);

                method.invoke(_measureRemoteModel, name);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDescription() {
        return _description;
    }

    @Override
    public void setDescription(String description) {
        _description = description;

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setDescription", String.class);

                method.invoke(_measureRemoteModel, description);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getImplementationtype() {
        return _implementationtype;
    }

    @Override
    public void setImplementationtype(String implementationtype) {
        _implementationtype = implementationtype;

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setImplementationtype",
                        String.class);

                method.invoke(_measureRemoteModel, implementationtype);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getImplementationtime() {
        return _implementationtime;
    }

    @Override
    public void setImplementationtime(String implementationtime) {
        _implementationtime = implementationtime;

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setImplementationtime",
                        String.class);

                method.invoke(_measureRemoteModel, implementationtime);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getLifetime() {
        return _lifetime;
    }

    @Override
    public void setLifetime(String lifetime) {
        _lifetime = lifetime;

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setLifetime", String.class);

                method.invoke(_measureRemoteModel, lifetime);
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

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setSpatiallayer", String.class);

                method.invoke(_measureRemoteModel, spatiallayer);
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

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setSpatialvalues", String.class);

                method.invoke(_measureRemoteModel, spatialvalues);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getLegalaspects() {
        return _legalaspects;
    }

    @Override
    public void setLegalaspects(String legalaspects) {
        _legalaspects = legalaspects;

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setLegalaspects", String.class);

                method.invoke(_measureRemoteModel, legalaspects);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getStakeholderparticipation() {
        return _stakeholderparticipation;
    }

    @Override
    public void setStakeholderparticipation(String stakeholderparticipation) {
        _stakeholderparticipation = stakeholderparticipation;

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setStakeholderparticipation",
                        String.class);

                method.invoke(_measureRemoteModel, stakeholderparticipation);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getContact() {
        return _contact;
    }

    @Override
    public void setContact(String contact) {
        _contact = contact;

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setContact", String.class);

                method.invoke(_measureRemoteModel, contact);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getObjectives() {
        return _objectives;
    }

    @Override
    public void setObjectives(String objectives) {
        _objectives = objectives;

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setObjectives", String.class);

                method.invoke(_measureRemoteModel, objectives);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getChallenges() {
        return _challenges;
    }

    @Override
    public void setChallenges(String challenges) {
        _challenges = challenges;

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setChallenges", String.class);

                method.invoke(_measureRemoteModel, challenges);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getAdaptationoptions() {
        return _adaptationoptions;
    }

    @Override
    public void setAdaptationoptions(String adaptationoptions) {
        _adaptationoptions = adaptationoptions;

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setAdaptationoptions",
                        String.class);

                method.invoke(_measureRemoteModel, adaptationoptions);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getSolutions() {
        return _solutions;
    }

    @Override
    public void setSolutions(String solutions) {
        _solutions = solutions;

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setSolutions", String.class);

                method.invoke(_measureRemoteModel, solutions);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getRelevance() {
        return _relevance;
    }

    @Override
    public void setRelevance(String relevance) {
        _relevance = relevance;

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setRelevance", String.class);

                method.invoke(_measureRemoteModel, relevance);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getSucceslimitations() {
        return _succeslimitations;
    }

    @Override
    public void setSucceslimitations(String succeslimitations) {
        _succeslimitations = succeslimitations;

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setSucceslimitations",
                        String.class);

                method.invoke(_measureRemoteModel, succeslimitations);
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

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setWebsite", String.class);

                method.invoke(_measureRemoteModel, website);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getCostbenefit() {
        return _costbenefit;
    }

    @Override
    public void setCostbenefit(String costbenefit) {
        _costbenefit = costbenefit;

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setCostbenefit", String.class);

                method.invoke(_measureRemoteModel, costbenefit);
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

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setKeywords", String.class);

                method.invoke(_measureRemoteModel, keywords);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getGeos_() {
        return _geos_;
    }

    @Override
    public void setGeos_(String geos_) {
        _geos_ = geos_;

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setGeos_", String.class);

                method.invoke(_measureRemoteModel, geos_);
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

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setStartdate", Date.class);

                method.invoke(_measureRemoteModel, startdate);
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

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setEnddate", Date.class);

                method.invoke(_measureRemoteModel, enddate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getPublicationdate() {
        return _publicationdate;
    }

    @Override
    public void setPublicationdate(Date publicationdate) {
        _publicationdate = publicationdate;

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setPublicationdate", Date.class);

                method.invoke(_measureRemoteModel, publicationdate);
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

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setSpecialtagging",
                        String.class);

                method.invoke(_measureRemoteModel, specialtagging);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getSectors_() {
        return _sectors_;
    }

    @Override
    public void setSectors_(String sectors_) {
        _sectors_ = sectors_;

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setSectors_", String.class);

                method.invoke(_measureRemoteModel, sectors_);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getElements_() {
        return _elements_;
    }

    @Override
    public void setElements_(String elements_) {
        _elements_ = elements_;

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setElements_", String.class);

                method.invoke(_measureRemoteModel, elements_);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getClimateimpacts_() {
        return _climateimpacts_;
    }

    @Override
    public void setClimateimpacts_(String climateimpacts_) {
        _climateimpacts_ = climateimpacts_;

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setClimateimpacts_",
                        String.class);

                method.invoke(_measureRemoteModel, climateimpacts_);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getMao_type() {
        return _mao_type;
    }

    @Override
    public void setMao_type(String mao_type) {
        _mao_type = mao_type;

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setMao_type", String.class);

                method.invoke(_measureRemoteModel, mao_type);
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

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setSource", String.class);

                method.invoke(_measureRemoteModel, source);
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

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setRating", long.class);

                method.invoke(_measureRemoteModel, rating);
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

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setImportance", long.class);

                method.invoke(_measureRemoteModel, importance);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public double getLon() {
        return _lon;
    }

    @Override
    public void setLon(double lon) {
        _lon = lon;

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setLon", double.class);

                method.invoke(_measureRemoteModel, lon);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public double getLat() {
        return _lat;
    }

    @Override
    public void setLat(double lat) {
        _lat = lat;

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setLat", double.class);

                method.invoke(_measureRemoteModel, lat);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getSatarea() {
        return _satarea;
    }

    @Override
    public void setSatarea(String satarea) {
        _satarea = satarea;

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setSatarea", String.class);

                method.invoke(_measureRemoteModel, satarea);
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

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setControlstatus", short.class);

                method.invoke(_measureRemoteModel, controlstatus);
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

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setCreator", String.class);

                method.invoke(_measureRemoteModel, creator);
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

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setCreationdate", Date.class);

                method.invoke(_measureRemoteModel, creationdate);
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

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setModerator", String.class);

                method.invoke(_measureRemoteModel, moderator);
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

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setApprovaldate", Date.class);

                method.invoke(_measureRemoteModel, approvaldate);
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

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setReplacesId", long.class);

                method.invoke(_measureRemoteModel, replacesId);
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

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setComments", String.class);

                method.invoke(_measureRemoteModel, comments);
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

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setTextwebpage", String.class);

                method.invoke(_measureRemoteModel, textwebpage);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getPrimephoto() {
        return _primephoto;
    }

    @Override
    public void setPrimephoto(String primephoto) {
        _primephoto = primephoto;

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setPrimephoto", String.class);

                method.invoke(_measureRemoteModel, primephoto);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getSupphotos() {
        return _supphotos;
    }

    @Override
    public void setSupphotos(String supphotos) {
        _supphotos = supphotos;

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setSupphotos", String.class);

                method.invoke(_measureRemoteModel, supphotos);
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

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setSupdocs", String.class);

                method.invoke(_measureRemoteModel, supdocs);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getYear() {
        return _year;
    }

    @Override
    public void setYear(String year) {
        _year = year;

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setYear", String.class);

                method.invoke(_measureRemoteModel, year);
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

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setGeochars", String.class);

                method.invoke(_measureRemoteModel, geochars);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getCategory() {
        return _category;
    }

    @Override
    public void setCategory(String category) {
        _category = category;

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setCategory", String.class);

                method.invoke(_measureRemoteModel, category);
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

        if (_measureRemoteModel != null) {
            try {
                Class<?> clazz = _measureRemoteModel.getClass();

                Method method = clazz.getMethod("setLockdate", Date.class);

                method.invoke(_measureRemoteModel, lockdate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getMeasureRemoteModel() {
        return _measureRemoteModel;
    }

    public void setMeasureRemoteModel(BaseModel<?> measureRemoteModel) {
        _measureRemoteModel = measureRemoteModel;
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

        Class<?> remoteModelClass = _measureRemoteModel.getClass();

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

        Object returnValue = method.invoke(_measureRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            MeasureLocalServiceUtil.addMeasure(this);
        } else {
            MeasureLocalServiceUtil.updateMeasure(this);
        }
    }

    @Override
    public Measure toEscapedModel() {
        return (Measure) ProxyUtil.newProxyInstance(Measure.class.getClassLoader(),
            new Class[] { Measure.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        MeasureClp clone = new MeasureClp();

        clone.setMeasureId(getMeasureId());
        clone.setCompanyId(getCompanyId());
        clone.setGroupId(getGroupId());
        clone.setAdmincomment(getAdmincomment());
        clone.setCasestudyfeature(getCasestudyfeature());
        clone.setName(getName());
        clone.setDescription(getDescription());
        clone.setImplementationtype(getImplementationtype());
        clone.setImplementationtime(getImplementationtime());
        clone.setLifetime(getLifetime());
        clone.setSpatiallayer(getSpatiallayer());
        clone.setSpatialvalues(getSpatialvalues());
        clone.setLegalaspects(getLegalaspects());
        clone.setStakeholderparticipation(getStakeholderparticipation());
        clone.setContact(getContact());
        clone.setObjectives(getObjectives());
        clone.setChallenges(getChallenges());
        clone.setAdaptationoptions(getAdaptationoptions());
        clone.setSolutions(getSolutions());
        clone.setRelevance(getRelevance());
        clone.setSucceslimitations(getSucceslimitations());
        clone.setWebsite(getWebsite());
        clone.setCostbenefit(getCostbenefit());
        clone.setKeywords(getKeywords());
        clone.setGeos_(getGeos_());
        clone.setStartdate(getStartdate());
        clone.setEnddate(getEnddate());
        clone.setPublicationdate(getPublicationdate());
        clone.setSpecialtagging(getSpecialtagging());
        clone.setSectors_(getSectors_());
        clone.setElements_(getElements_());
        clone.setClimateimpacts_(getClimateimpacts_());
        clone.setMao_type(getMao_type());
        clone.setSource(getSource());
        clone.setRating(getRating());
        clone.setImportance(getImportance());
        clone.setLon(getLon());
        clone.setLat(getLat());
        clone.setSatarea(getSatarea());
        clone.setControlstatus(getControlstatus());
        clone.setCreator(getCreator());
        clone.setCreationdate(getCreationdate());
        clone.setModerator(getModerator());
        clone.setApprovaldate(getApprovaldate());
        clone.setReplacesId(getReplacesId());
        clone.setComments(getComments());
        clone.setTextwebpage(getTextwebpage());
        clone.setPrimephoto(getPrimephoto());
        clone.setSupphotos(getSupphotos());
        clone.setSupdocs(getSupdocs());
        clone.setYear(getYear());
        clone.setGeochars(getGeochars());
        clone.setCategory(getCategory());
        clone.setLockdate(getLockdate());

        return clone;
    }

    @Override
    public int compareTo(Measure measure) {
        int value = 0;

        value = getName().compareTo(measure.getName());

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

        if (!(obj instanceof MeasureClp)) {
            return false;
        }

        MeasureClp measure = (MeasureClp) obj;

        long primaryKey = measure.getPrimaryKey();

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
        StringBundler sb = new StringBundler(109);

        sb.append("{measureId=");
        sb.append(getMeasureId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", admincomment=");
        sb.append(getAdmincomment());
        sb.append(", casestudyfeature=");
        sb.append(getCasestudyfeature());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", implementationtype=");
        sb.append(getImplementationtype());
        sb.append(", implementationtime=");
        sb.append(getImplementationtime());
        sb.append(", lifetime=");
        sb.append(getLifetime());
        sb.append(", spatiallayer=");
        sb.append(getSpatiallayer());
        sb.append(", spatialvalues=");
        sb.append(getSpatialvalues());
        sb.append(", legalaspects=");
        sb.append(getLegalaspects());
        sb.append(", stakeholderparticipation=");
        sb.append(getStakeholderparticipation());
        sb.append(", contact=");
        sb.append(getContact());
        sb.append(", objectives=");
        sb.append(getObjectives());
        sb.append(", challenges=");
        sb.append(getChallenges());
        sb.append(", adaptationoptions=");
        sb.append(getAdaptationoptions());
        sb.append(", solutions=");
        sb.append(getSolutions());
        sb.append(", relevance=");
        sb.append(getRelevance());
        sb.append(", succeslimitations=");
        sb.append(getSucceslimitations());
        sb.append(", website=");
        sb.append(getWebsite());
        sb.append(", costbenefit=");
        sb.append(getCostbenefit());
        sb.append(", keywords=");
        sb.append(getKeywords());
        sb.append(", geos_=");
        sb.append(getGeos_());
        sb.append(", startdate=");
        sb.append(getStartdate());
        sb.append(", enddate=");
        sb.append(getEnddate());
        sb.append(", publicationdate=");
        sb.append(getPublicationdate());
        sb.append(", specialtagging=");
        sb.append(getSpecialtagging());
        sb.append(", sectors_=");
        sb.append(getSectors_());
        sb.append(", elements_=");
        sb.append(getElements_());
        sb.append(", climateimpacts_=");
        sb.append(getClimateimpacts_());
        sb.append(", mao_type=");
        sb.append(getMao_type());
        sb.append(", source=");
        sb.append(getSource());
        sb.append(", rating=");
        sb.append(getRating());
        sb.append(", importance=");
        sb.append(getImportance());
        sb.append(", lon=");
        sb.append(getLon());
        sb.append(", lat=");
        sb.append(getLat());
        sb.append(", satarea=");
        sb.append(getSatarea());
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
        sb.append(", primephoto=");
        sb.append(getPrimephoto());
        sb.append(", supphotos=");
        sb.append(getSupphotos());
        sb.append(", supdocs=");
        sb.append(getSupdocs());
        sb.append(", year=");
        sb.append(getYear());
        sb.append(", geochars=");
        sb.append(getGeochars());
        sb.append(", category=");
        sb.append(getCategory());
        sb.append(", lockdate=");
        sb.append(getLockdate());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(166);

        sb.append("<model><model-name>");
        sb.append("nl.wur.alterra.cgi.ace.model.Measure");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>measureId</column-name><column-value><![CDATA[");
        sb.append(getMeasureId());
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
            "<column><column-name>casestudyfeature</column-name><column-value><![CDATA[");
        sb.append(getCasestudyfeature());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>implementationtype</column-name><column-value><![CDATA[");
        sb.append(getImplementationtype());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>implementationtime</column-name><column-value><![CDATA[");
        sb.append(getImplementationtime());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>lifetime</column-name><column-value><![CDATA[");
        sb.append(getLifetime());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>spatiallayer</column-name><column-value><![CDATA[");
        sb.append(getSpatiallayer());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>spatialvalues</column-name><column-value><![CDATA[");
        sb.append(getSpatialvalues());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>legalaspects</column-name><column-value><![CDATA[");
        sb.append(getLegalaspects());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>stakeholderparticipation</column-name><column-value><![CDATA[");
        sb.append(getStakeholderparticipation());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>contact</column-name><column-value><![CDATA[");
        sb.append(getContact());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>objectives</column-name><column-value><![CDATA[");
        sb.append(getObjectives());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>challenges</column-name><column-value><![CDATA[");
        sb.append(getChallenges());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>adaptationoptions</column-name><column-value><![CDATA[");
        sb.append(getAdaptationoptions());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>solutions</column-name><column-value><![CDATA[");
        sb.append(getSolutions());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>relevance</column-name><column-value><![CDATA[");
        sb.append(getRelevance());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>succeslimitations</column-name><column-value><![CDATA[");
        sb.append(getSucceslimitations());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>website</column-name><column-value><![CDATA[");
        sb.append(getWebsite());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>costbenefit</column-name><column-value><![CDATA[");
        sb.append(getCostbenefit());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>keywords</column-name><column-value><![CDATA[");
        sb.append(getKeywords());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>geos_</column-name><column-value><![CDATA[");
        sb.append(getGeos_());
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
            "<column><column-name>publicationdate</column-name><column-value><![CDATA[");
        sb.append(getPublicationdate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>specialtagging</column-name><column-value><![CDATA[");
        sb.append(getSpecialtagging());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>sectors_</column-name><column-value><![CDATA[");
        sb.append(getSectors_());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>elements_</column-name><column-value><![CDATA[");
        sb.append(getElements_());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>climateimpacts_</column-name><column-value><![CDATA[");
        sb.append(getClimateimpacts_());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>mao_type</column-name><column-value><![CDATA[");
        sb.append(getMao_type());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>source</column-name><column-value><![CDATA[");
        sb.append(getSource());
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
            "<column><column-name>lon</column-name><column-value><![CDATA[");
        sb.append(getLon());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>lat</column-name><column-value><![CDATA[");
        sb.append(getLat());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>satarea</column-name><column-value><![CDATA[");
        sb.append(getSatarea());
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
            "<column><column-name>primephoto</column-name><column-value><![CDATA[");
        sb.append(getPrimephoto());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>supphotos</column-name><column-value><![CDATA[");
        sb.append(getSupphotos());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>supdocs</column-name><column-value><![CDATA[");
        sb.append(getSupdocs());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>year</column-name><column-value><![CDATA[");
        sb.append(getYear());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>geochars</column-name><column-value><![CDATA[");
        sb.append(getGeochars());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>category</column-name><column-value><![CDATA[");
        sb.append(getCategory());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>lockdate</column-name><column-value><![CDATA[");
        sb.append(getLockdate());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
