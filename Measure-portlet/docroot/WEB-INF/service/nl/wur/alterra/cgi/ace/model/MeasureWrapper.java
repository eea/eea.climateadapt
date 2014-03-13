package nl.wur.alterra.cgi.ace.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Measure}.
 * </p>
 *
 * @author groot052
 * @see Measure
 * @generated
 */
public class MeasureWrapper implements Measure, ModelWrapper<Measure> {
    private Measure _measure;

    public MeasureWrapper(Measure measure) {
        _measure = measure;
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

    /**
    * Returns the primary key of this measure.
    *
    * @return the primary key of this measure
    */
    @Override
    public long getPrimaryKey() {
        return _measure.getPrimaryKey();
    }

    /**
    * Sets the primary key of this measure.
    *
    * @param primaryKey the primary key of this measure
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _measure.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the measure ID of this measure.
    *
    * @return the measure ID of this measure
    */
    @Override
    public long getMeasureId() {
        return _measure.getMeasureId();
    }

    /**
    * Sets the measure ID of this measure.
    *
    * @param measureId the measure ID of this measure
    */
    @Override
    public void setMeasureId(long measureId) {
        _measure.setMeasureId(measureId);
    }

    /**
    * Returns the company ID of this measure.
    *
    * @return the company ID of this measure
    */
    @Override
    public long getCompanyId() {
        return _measure.getCompanyId();
    }

    /**
    * Sets the company ID of this measure.
    *
    * @param companyId the company ID of this measure
    */
    @Override
    public void setCompanyId(long companyId) {
        _measure.setCompanyId(companyId);
    }

    /**
    * Returns the group ID of this measure.
    *
    * @return the group ID of this measure
    */
    @Override
    public long getGroupId() {
        return _measure.getGroupId();
    }

    /**
    * Sets the group ID of this measure.
    *
    * @param groupId the group ID of this measure
    */
    @Override
    public void setGroupId(long groupId) {
        _measure.setGroupId(groupId);
    }

    /**
    * Returns the admincomment of this measure.
    *
    * @return the admincomment of this measure
    */
    @Override
    public java.lang.String getAdmincomment() {
        return _measure.getAdmincomment();
    }

    /**
    * Sets the admincomment of this measure.
    *
    * @param admincomment the admincomment of this measure
    */
    @Override
    public void setAdmincomment(java.lang.String admincomment) {
        _measure.setAdmincomment(admincomment);
    }

    /**
    * Returns the casestudyfeature of this measure.
    *
    * @return the casestudyfeature of this measure
    */
    @Override
    public java.lang.String getCasestudyfeature() {
        return _measure.getCasestudyfeature();
    }

    /**
    * Sets the casestudyfeature of this measure.
    *
    * @param casestudyfeature the casestudyfeature of this measure
    */
    @Override
    public void setCasestudyfeature(java.lang.String casestudyfeature) {
        _measure.setCasestudyfeature(casestudyfeature);
    }

    /**
    * Returns the name of this measure.
    *
    * @return the name of this measure
    */
    @Override
    public java.lang.String getName() {
        return _measure.getName();
    }

    /**
    * Sets the name of this measure.
    *
    * @param name the name of this measure
    */
    @Override
    public void setName(java.lang.String name) {
        _measure.setName(name);
    }

    /**
    * Returns the description of this measure.
    *
    * @return the description of this measure
    */
    @Override
    public java.lang.String getDescription() {
        return _measure.getDescription();
    }

    /**
    * Sets the description of this measure.
    *
    * @param description the description of this measure
    */
    @Override
    public void setDescription(java.lang.String description) {
        _measure.setDescription(description);
    }

    /**
    * Returns the implementationtype of this measure.
    *
    * @return the implementationtype of this measure
    */
    @Override
    public java.lang.String getImplementationtype() {
        return _measure.getImplementationtype();
    }

    /**
    * Sets the implementationtype of this measure.
    *
    * @param implementationtype the implementationtype of this measure
    */
    @Override
    public void setImplementationtype(java.lang.String implementationtype) {
        _measure.setImplementationtype(implementationtype);
    }

    /**
    * Returns the implementationtime of this measure.
    *
    * @return the implementationtime of this measure
    */
    @Override
    public java.lang.String getImplementationtime() {
        return _measure.getImplementationtime();
    }

    /**
    * Sets the implementationtime of this measure.
    *
    * @param implementationtime the implementationtime of this measure
    */
    @Override
    public void setImplementationtime(java.lang.String implementationtime) {
        _measure.setImplementationtime(implementationtime);
    }

    /**
    * Returns the lifetime of this measure.
    *
    * @return the lifetime of this measure
    */
    @Override
    public java.lang.String getLifetime() {
        return _measure.getLifetime();
    }

    /**
    * Sets the lifetime of this measure.
    *
    * @param lifetime the lifetime of this measure
    */
    @Override
    public void setLifetime(java.lang.String lifetime) {
        _measure.setLifetime(lifetime);
    }

    /**
    * Returns the spatiallayer of this measure.
    *
    * @return the spatiallayer of this measure
    */
    @Override
    public java.lang.String getSpatiallayer() {
        return _measure.getSpatiallayer();
    }

    /**
    * Sets the spatiallayer of this measure.
    *
    * @param spatiallayer the spatiallayer of this measure
    */
    @Override
    public void setSpatiallayer(java.lang.String spatiallayer) {
        _measure.setSpatiallayer(spatiallayer);
    }

    /**
    * Returns the spatialvalues of this measure.
    *
    * @return the spatialvalues of this measure
    */
    @Override
    public java.lang.String getSpatialvalues() {
        return _measure.getSpatialvalues();
    }

    /**
    * Sets the spatialvalues of this measure.
    *
    * @param spatialvalues the spatialvalues of this measure
    */
    @Override
    public void setSpatialvalues(java.lang.String spatialvalues) {
        _measure.setSpatialvalues(spatialvalues);
    }

    /**
    * Returns the legalaspects of this measure.
    *
    * @return the legalaspects of this measure
    */
    @Override
    public java.lang.String getLegalaspects() {
        return _measure.getLegalaspects();
    }

    /**
    * Sets the legalaspects of this measure.
    *
    * @param legalaspects the legalaspects of this measure
    */
    @Override
    public void setLegalaspects(java.lang.String legalaspects) {
        _measure.setLegalaspects(legalaspects);
    }

    /**
    * Returns the stakeholderparticipation of this measure.
    *
    * @return the stakeholderparticipation of this measure
    */
    @Override
    public java.lang.String getStakeholderparticipation() {
        return _measure.getStakeholderparticipation();
    }

    /**
    * Sets the stakeholderparticipation of this measure.
    *
    * @param stakeholderparticipation the stakeholderparticipation of this measure
    */
    @Override
    public void setStakeholderparticipation(
        java.lang.String stakeholderparticipation) {
        _measure.setStakeholderparticipation(stakeholderparticipation);
    }

    /**
    * Returns the contact of this measure.
    *
    * @return the contact of this measure
    */
    @Override
    public java.lang.String getContact() {
        return _measure.getContact();
    }

    /**
    * Sets the contact of this measure.
    *
    * @param contact the contact of this measure
    */
    @Override
    public void setContact(java.lang.String contact) {
        _measure.setContact(contact);
    }

    /**
    * Returns the objectives of this measure.
    *
    * @return the objectives of this measure
    */
    @Override
    public java.lang.String getObjectives() {
        return _measure.getObjectives();
    }

    /**
    * Sets the objectives of this measure.
    *
    * @param objectives the objectives of this measure
    */
    @Override
    public void setObjectives(java.lang.String objectives) {
        _measure.setObjectives(objectives);
    }

    /**
    * Returns the challenges of this measure.
    *
    * @return the challenges of this measure
    */
    @Override
    public java.lang.String getChallenges() {
        return _measure.getChallenges();
    }

    /**
    * Sets the challenges of this measure.
    *
    * @param challenges the challenges of this measure
    */
    @Override
    public void setChallenges(java.lang.String challenges) {
        _measure.setChallenges(challenges);
    }

    /**
    * Returns the adaptationoptions of this measure.
    *
    * @return the adaptationoptions of this measure
    */
    @Override
    public java.lang.String getAdaptationoptions() {
        return _measure.getAdaptationoptions();
    }

    /**
    * Sets the adaptationoptions of this measure.
    *
    * @param adaptationoptions the adaptationoptions of this measure
    */
    @Override
    public void setAdaptationoptions(java.lang.String adaptationoptions) {
        _measure.setAdaptationoptions(adaptationoptions);
    }

    /**
    * Returns the solutions of this measure.
    *
    * @return the solutions of this measure
    */
    @Override
    public java.lang.String getSolutions() {
        return _measure.getSolutions();
    }

    /**
    * Sets the solutions of this measure.
    *
    * @param solutions the solutions of this measure
    */
    @Override
    public void setSolutions(java.lang.String solutions) {
        _measure.setSolutions(solutions);
    }

    /**
    * Returns the relevance of this measure.
    *
    * @return the relevance of this measure
    */
    @Override
    public java.lang.String getRelevance() {
        return _measure.getRelevance();
    }

    /**
    * Sets the relevance of this measure.
    *
    * @param relevance the relevance of this measure
    */
    @Override
    public void setRelevance(java.lang.String relevance) {
        _measure.setRelevance(relevance);
    }

    /**
    * Returns the succeslimitations of this measure.
    *
    * @return the succeslimitations of this measure
    */
    @Override
    public java.lang.String getSucceslimitations() {
        return _measure.getSucceslimitations();
    }

    /**
    * Sets the succeslimitations of this measure.
    *
    * @param succeslimitations the succeslimitations of this measure
    */
    @Override
    public void setSucceslimitations(java.lang.String succeslimitations) {
        _measure.setSucceslimitations(succeslimitations);
    }

    /**
    * Returns the website of this measure.
    *
    * @return the website of this measure
    */
    @Override
    public java.lang.String getWebsite() {
        return _measure.getWebsite();
    }

    /**
    * Sets the website of this measure.
    *
    * @param website the website of this measure
    */
    @Override
    public void setWebsite(java.lang.String website) {
        _measure.setWebsite(website);
    }

    /**
    * Returns the costbenefit of this measure.
    *
    * @return the costbenefit of this measure
    */
    @Override
    public java.lang.String getCostbenefit() {
        return _measure.getCostbenefit();
    }

    /**
    * Sets the costbenefit of this measure.
    *
    * @param costbenefit the costbenefit of this measure
    */
    @Override
    public void setCostbenefit(java.lang.String costbenefit) {
        _measure.setCostbenefit(costbenefit);
    }

    /**
    * Returns the keywords of this measure.
    *
    * @return the keywords of this measure
    */
    @Override
    public java.lang.String getKeywords() {
        return _measure.getKeywords();
    }

    /**
    * Sets the keywords of this measure.
    *
    * @param keywords the keywords of this measure
    */
    @Override
    public void setKeywords(java.lang.String keywords) {
        _measure.setKeywords(keywords);
    }

    /**
    * Returns the geos_ of this measure.
    *
    * @return the geos_ of this measure
    */
    @Override
    public java.lang.String getGeos_() {
        return _measure.getGeos_();
    }

    /**
    * Sets the geos_ of this measure.
    *
    * @param geos_ the geos_ of this measure
    */
    @Override
    public void setGeos_(java.lang.String geos_) {
        _measure.setGeos_(geos_);
    }

    /**
    * Returns the startdate of this measure.
    *
    * @return the startdate of this measure
    */
    @Override
    public java.util.Date getStartdate() {
        return _measure.getStartdate();
    }

    /**
    * Sets the startdate of this measure.
    *
    * @param startdate the startdate of this measure
    */
    @Override
    public void setStartdate(java.util.Date startdate) {
        _measure.setStartdate(startdate);
    }

    /**
    * Returns the enddate of this measure.
    *
    * @return the enddate of this measure
    */
    @Override
    public java.util.Date getEnddate() {
        return _measure.getEnddate();
    }

    /**
    * Sets the enddate of this measure.
    *
    * @param enddate the enddate of this measure
    */
    @Override
    public void setEnddate(java.util.Date enddate) {
        _measure.setEnddate(enddate);
    }

    /**
    * Returns the publicationdate of this measure.
    *
    * @return the publicationdate of this measure
    */
    @Override
    public java.util.Date getPublicationdate() {
        return _measure.getPublicationdate();
    }

    /**
    * Sets the publicationdate of this measure.
    *
    * @param publicationdate the publicationdate of this measure
    */
    @Override
    public void setPublicationdate(java.util.Date publicationdate) {
        _measure.setPublicationdate(publicationdate);
    }

    /**
    * Returns the specialtagging of this measure.
    *
    * @return the specialtagging of this measure
    */
    @Override
    public java.lang.String getSpecialtagging() {
        return _measure.getSpecialtagging();
    }

    /**
    * Sets the specialtagging of this measure.
    *
    * @param specialtagging the specialtagging of this measure
    */
    @Override
    public void setSpecialtagging(java.lang.String specialtagging) {
        _measure.setSpecialtagging(specialtagging);
    }

    /**
    * Returns the sectors_ of this measure.
    *
    * @return the sectors_ of this measure
    */
    @Override
    public java.lang.String getSectors_() {
        return _measure.getSectors_();
    }

    /**
    * Sets the sectors_ of this measure.
    *
    * @param sectors_ the sectors_ of this measure
    */
    @Override
    public void setSectors_(java.lang.String sectors_) {
        _measure.setSectors_(sectors_);
    }

    /**
    * Returns the elements_ of this measure.
    *
    * @return the elements_ of this measure
    */
    @Override
    public java.lang.String getElements_() {
        return _measure.getElements_();
    }

    /**
    * Sets the elements_ of this measure.
    *
    * @param elements_ the elements_ of this measure
    */
    @Override
    public void setElements_(java.lang.String elements_) {
        _measure.setElements_(elements_);
    }

    /**
    * Returns the climateimpacts_ of this measure.
    *
    * @return the climateimpacts_ of this measure
    */
    @Override
    public java.lang.String getClimateimpacts_() {
        return _measure.getClimateimpacts_();
    }

    /**
    * Sets the climateimpacts_ of this measure.
    *
    * @param climateimpacts_ the climateimpacts_ of this measure
    */
    @Override
    public void setClimateimpacts_(java.lang.String climateimpacts_) {
        _measure.setClimateimpacts_(climateimpacts_);
    }

    /**
    * Returns the mao_type of this measure.
    *
    * @return the mao_type of this measure
    */
    @Override
    public java.lang.String getMao_type() {
        return _measure.getMao_type();
    }

    /**
    * Sets the mao_type of this measure.
    *
    * @param mao_type the mao_type of this measure
    */
    @Override
    public void setMao_type(java.lang.String mao_type) {
        _measure.setMao_type(mao_type);
    }

    /**
    * Returns the source of this measure.
    *
    * @return the source of this measure
    */
    @Override
    public java.lang.String getSource() {
        return _measure.getSource();
    }

    /**
    * Sets the source of this measure.
    *
    * @param source the source of this measure
    */
    @Override
    public void setSource(java.lang.String source) {
        _measure.setSource(source);
    }

    /**
    * Returns the rating of this measure.
    *
    * @return the rating of this measure
    */
    @Override
    public long getRating() {
        return _measure.getRating();
    }

    /**
    * Sets the rating of this measure.
    *
    * @param rating the rating of this measure
    */
    @Override
    public void setRating(long rating) {
        _measure.setRating(rating);
    }

    /**
    * Returns the importance of this measure.
    *
    * @return the importance of this measure
    */
    @Override
    public long getImportance() {
        return _measure.getImportance();
    }

    /**
    * Sets the importance of this measure.
    *
    * @param importance the importance of this measure
    */
    @Override
    public void setImportance(long importance) {
        _measure.setImportance(importance);
    }

    /**
    * Returns the lon of this measure.
    *
    * @return the lon of this measure
    */
    @Override
    public double getLon() {
        return _measure.getLon();
    }

    /**
    * Sets the lon of this measure.
    *
    * @param lon the lon of this measure
    */
    @Override
    public void setLon(double lon) {
        _measure.setLon(lon);
    }

    /**
    * Returns the lat of this measure.
    *
    * @return the lat of this measure
    */
    @Override
    public double getLat() {
        return _measure.getLat();
    }

    /**
    * Sets the lat of this measure.
    *
    * @param lat the lat of this measure
    */
    @Override
    public void setLat(double lat) {
        _measure.setLat(lat);
    }

    /**
    * Returns the satarea of this measure.
    *
    * @return the satarea of this measure
    */
    @Override
    public java.lang.String getSatarea() {
        return _measure.getSatarea();
    }

    /**
    * Sets the satarea of this measure.
    *
    * @param satarea the satarea of this measure
    */
    @Override
    public void setSatarea(java.lang.String satarea) {
        _measure.setSatarea(satarea);
    }

    /**
    * Returns the controlstatus of this measure.
    *
    * @return the controlstatus of this measure
    */
    @Override
    public short getControlstatus() {
        return _measure.getControlstatus();
    }

    /**
    * Sets the controlstatus of this measure.
    *
    * @param controlstatus the controlstatus of this measure
    */
    @Override
    public void setControlstatus(short controlstatus) {
        _measure.setControlstatus(controlstatus);
    }

    /**
    * Returns the creator of this measure.
    *
    * @return the creator of this measure
    */
    @Override
    public java.lang.String getCreator() {
        return _measure.getCreator();
    }

    /**
    * Sets the creator of this measure.
    *
    * @param creator the creator of this measure
    */
    @Override
    public void setCreator(java.lang.String creator) {
        _measure.setCreator(creator);
    }

    /**
    * Returns the creationdate of this measure.
    *
    * @return the creationdate of this measure
    */
    @Override
    public java.util.Date getCreationdate() {
        return _measure.getCreationdate();
    }

    /**
    * Sets the creationdate of this measure.
    *
    * @param creationdate the creationdate of this measure
    */
    @Override
    public void setCreationdate(java.util.Date creationdate) {
        _measure.setCreationdate(creationdate);
    }

    /**
    * Returns the moderator of this measure.
    *
    * @return the moderator of this measure
    */
    @Override
    public java.lang.String getModerator() {
        return _measure.getModerator();
    }

    /**
    * Sets the moderator of this measure.
    *
    * @param moderator the moderator of this measure
    */
    @Override
    public void setModerator(java.lang.String moderator) {
        _measure.setModerator(moderator);
    }

    /**
    * Returns the approvaldate of this measure.
    *
    * @return the approvaldate of this measure
    */
    @Override
    public java.util.Date getApprovaldate() {
        return _measure.getApprovaldate();
    }

    /**
    * Sets the approvaldate of this measure.
    *
    * @param approvaldate the approvaldate of this measure
    */
    @Override
    public void setApprovaldate(java.util.Date approvaldate) {
        _measure.setApprovaldate(approvaldate);
    }

    /**
    * Returns the replaces ID of this measure.
    *
    * @return the replaces ID of this measure
    */
    @Override
    public long getReplacesId() {
        return _measure.getReplacesId();
    }

    /**
    * Sets the replaces ID of this measure.
    *
    * @param replacesId the replaces ID of this measure
    */
    @Override
    public void setReplacesId(long replacesId) {
        _measure.setReplacesId(replacesId);
    }

    /**
    * Returns the comments of this measure.
    *
    * @return the comments of this measure
    */
    @Override
    public java.lang.String getComments() {
        return _measure.getComments();
    }

    /**
    * Sets the comments of this measure.
    *
    * @param comments the comments of this measure
    */
    @Override
    public void setComments(java.lang.String comments) {
        _measure.setComments(comments);
    }

    /**
    * Returns the textwebpage of this measure.
    *
    * @return the textwebpage of this measure
    */
    @Override
    public java.lang.String getTextwebpage() {
        return _measure.getTextwebpage();
    }

    /**
    * Sets the textwebpage of this measure.
    *
    * @param textwebpage the textwebpage of this measure
    */
    @Override
    public void setTextwebpage(java.lang.String textwebpage) {
        _measure.setTextwebpage(textwebpage);
    }

    /**
    * Returns the primephoto of this measure.
    *
    * @return the primephoto of this measure
    */
    @Override
    public java.lang.String getPrimephoto() {
        return _measure.getPrimephoto();
    }

    /**
    * Sets the primephoto of this measure.
    *
    * @param primephoto the primephoto of this measure
    */
    @Override
    public void setPrimephoto(java.lang.String primephoto) {
        _measure.setPrimephoto(primephoto);
    }

    /**
    * Returns the supphotos of this measure.
    *
    * @return the supphotos of this measure
    */
    @Override
    public java.lang.String getSupphotos() {
        return _measure.getSupphotos();
    }

    /**
    * Sets the supphotos of this measure.
    *
    * @param supphotos the supphotos of this measure
    */
    @Override
    public void setSupphotos(java.lang.String supphotos) {
        _measure.setSupphotos(supphotos);
    }

    /**
    * Returns the supdocs of this measure.
    *
    * @return the supdocs of this measure
    */
    @Override
    public java.lang.String getSupdocs() {
        return _measure.getSupdocs();
    }

    /**
    * Sets the supdocs of this measure.
    *
    * @param supdocs the supdocs of this measure
    */
    @Override
    public void setSupdocs(java.lang.String supdocs) {
        _measure.setSupdocs(supdocs);
    }

    /**
    * Returns the year of this measure.
    *
    * @return the year of this measure
    */
    @Override
    public java.lang.String getYear() {
        return _measure.getYear();
    }

    /**
    * Sets the year of this measure.
    *
    * @param year the year of this measure
    */
    @Override
    public void setYear(java.lang.String year) {
        _measure.setYear(year);
    }

    /**
    * Returns the geochars of this measure.
    *
    * @return the geochars of this measure
    */
    @Override
    public java.lang.String getGeochars() {
        return _measure.getGeochars();
    }

    /**
    * Sets the geochars of this measure.
    *
    * @param geochars the geochars of this measure
    */
    @Override
    public void setGeochars(java.lang.String geochars) {
        _measure.setGeochars(geochars);
    }

    /**
    * Returns the category of this measure.
    *
    * @return the category of this measure
    */
    @Override
    public java.lang.String getCategory() {
        return _measure.getCategory();
    }

    /**
    * Sets the category of this measure.
    *
    * @param category the category of this measure
    */
    @Override
    public void setCategory(java.lang.String category) {
        _measure.setCategory(category);
    }

    /**
    * Returns the lockdate of this measure.
    *
    * @return the lockdate of this measure
    */
    @Override
    public java.util.Date getLockdate() {
        return _measure.getLockdate();
    }

    /**
    * Sets the lockdate of this measure.
    *
    * @param lockdate the lockdate of this measure
    */
    @Override
    public void setLockdate(java.util.Date lockdate) {
        _measure.setLockdate(lockdate);
    }

    @Override
    public boolean isNew() {
        return _measure.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _measure.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _measure.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _measure.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _measure.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _measure.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _measure.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _measure.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _measure.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _measure.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _measure.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new MeasureWrapper((Measure) _measure.clone());
    }

    @Override
    public int compareTo(nl.wur.alterra.cgi.ace.model.Measure measure) {
        return _measure.compareTo(measure);
    }

    @Override
    public int hashCode() {
        return _measure.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<nl.wur.alterra.cgi.ace.model.Measure> toCacheModel() {
        return _measure.toCacheModel();
    }

    @Override
    public nl.wur.alterra.cgi.ace.model.Measure toEscapedModel() {
        return new MeasureWrapper(_measure.toEscapedModel());
    }

    @Override
    public nl.wur.alterra.cgi.ace.model.Measure toUnescapedModel() {
        return new MeasureWrapper(_measure.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _measure.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _measure.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _measure.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof MeasureWrapper)) {
            return false;
        }

        MeasureWrapper measureWrapper = (MeasureWrapper) obj;

        if (Validator.equals(_measure, measureWrapper._measure)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Measure getWrappedMeasure() {
        return _measure;
    }

    @Override
    public Measure getWrappedModel() {
        return _measure;
    }

    @Override
    public void resetOriginalValues() {
        _measure.resetOriginalValues();
    }
}
