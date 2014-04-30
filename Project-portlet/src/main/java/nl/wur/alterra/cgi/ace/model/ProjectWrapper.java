package nl.wur.alterra.cgi.ace.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Project}.
 * </p>
 *
 * @author Groot052
 * @see Project
 * @generated
 */
public class ProjectWrapper implements Project, ModelWrapper<Project> {
    private Project _project;

    public ProjectWrapper(Project project) {
        _project = project;
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

    /**
    * Returns the primary key of this project.
    *
    * @return the primary key of this project
    */
    @Override
    public long getPrimaryKey() {
        return _project.getPrimaryKey();
    }

    /**
    * Sets the primary key of this project.
    *
    * @param primaryKey the primary key of this project
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _project.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the project ID of this project.
    *
    * @return the project ID of this project
    */
    @Override
    public long getProjectId() {
        return _project.getProjectId();
    }

    /**
    * Sets the project ID of this project.
    *
    * @param projectId the project ID of this project
    */
    @Override
    public void setProjectId(long projectId) {
        _project.setProjectId(projectId);
    }

    /**
    * Returns the company ID of this project.
    *
    * @return the company ID of this project
    */
    @Override
    public long getCompanyId() {
        return _project.getCompanyId();
    }

    /**
    * Sets the company ID of this project.
    *
    * @param companyId the company ID of this project
    */
    @Override
    public void setCompanyId(long companyId) {
        _project.setCompanyId(companyId);
    }

    /**
    * Returns the group ID of this project.
    *
    * @return the group ID of this project
    */
    @Override
    public long getGroupId() {
        return _project.getGroupId();
    }

    /**
    * Sets the group ID of this project.
    *
    * @param groupId the group ID of this project
    */
    @Override
    public void setGroupId(long groupId) {
        _project.setGroupId(groupId);
    }

    /**
    * Returns the admincomment of this project.
    *
    * @return the admincomment of this project
    */
    @Override
    public java.lang.String getAdmincomment() {
        return _project.getAdmincomment();
    }

    /**
    * Sets the admincomment of this project.
    *
    * @param admincomment the admincomment of this project
    */
    @Override
    public void setAdmincomment(java.lang.String admincomment) {
        _project.setAdmincomment(admincomment);
    }

    /**
    * Returns the acronym of this project.
    *
    * @return the acronym of this project
    */
    @Override
    public java.lang.String getAcronym() {
        return _project.getAcronym();
    }

    /**
    * Sets the acronym of this project.
    *
    * @param acronym the acronym of this project
    */
    @Override
    public void setAcronym(java.lang.String acronym) {
        _project.setAcronym(acronym);
    }

    /**
    * Returns the title of this project.
    *
    * @return the title of this project
    */
    @Override
    public java.lang.String getTitle() {
        return _project.getTitle();
    }

    /**
    * Sets the title of this project.
    *
    * @param title the title of this project
    */
    @Override
    public void setTitle(java.lang.String title) {
        _project.setTitle(title);
    }

    /**
    * Returns the startdate of this project.
    *
    * @return the startdate of this project
    */
    @Override
    public java.util.Date getStartdate() {
        return _project.getStartdate();
    }

    /**
    * Sets the startdate of this project.
    *
    * @param startdate the startdate of this project
    */
    @Override
    public void setStartdate(java.util.Date startdate) {
        _project.setStartdate(startdate);
    }

    /**
    * Returns the enddate of this project.
    *
    * @return the enddate of this project
    */
    @Override
    public java.util.Date getEnddate() {
        return _project.getEnddate();
    }

    /**
    * Sets the enddate of this project.
    *
    * @param enddate the enddate of this project
    */
    @Override
    public void setEnddate(java.util.Date enddate) {
        _project.setEnddate(enddate);
    }

    /**
    * Returns the lead of this project.
    *
    * @return the lead of this project
    */
    @Override
    public java.lang.String getLead() {
        return _project.getLead();
    }

    /**
    * Sets the lead of this project.
    *
    * @param lead the lead of this project
    */
    @Override
    public void setLead(java.lang.String lead) {
        _project.setLead(lead);
    }

    /**
    * Returns the partners of this project.
    *
    * @return the partners of this project
    */
    @Override
    public java.lang.String getPartners() {
        return _project.getPartners();
    }

    /**
    * Sets the partners of this project.
    *
    * @param partners the partners of this project
    */
    @Override
    public void setPartners(java.lang.String partners) {
        _project.setPartners(partners);
    }

    /**
    * Returns the funding of this project.
    *
    * @return the funding of this project
    */
    @Override
    public java.lang.String getFunding() {
        return _project.getFunding();
    }

    /**
    * Sets the funding of this project.
    *
    * @param funding the funding of this project
    */
    @Override
    public void setFunding(java.lang.String funding) {
        _project.setFunding(funding);
    }

    /**
    * Returns the sectors of this project.
    *
    * @return the sectors of this project
    */
    @Override
    public java.lang.String getSectors() {
        return _project.getSectors();
    }

    /**
    * Sets the sectors of this project.
    *
    * @param sectors the sectors of this project
    */
    @Override
    public void setSectors(java.lang.String sectors) {
        _project.setSectors(sectors);
    }

    /**
    * Returns the spatiallayer of this project.
    *
    * @return the spatiallayer of this project
    */
    @Override
    public java.lang.String getSpatiallayer() {
        return _project.getSpatiallayer();
    }

    /**
    * Sets the spatiallayer of this project.
    *
    * @param spatiallayer the spatiallayer of this project
    */
    @Override
    public void setSpatiallayer(java.lang.String spatiallayer) {
        _project.setSpatiallayer(spatiallayer);
    }

    /**
    * Returns the abstracts of this project.
    *
    * @return the abstracts of this project
    */
    @Override
    public java.lang.String getAbstracts() {
        return _project.getAbstracts();
    }

    /**
    * Sets the abstracts of this project.
    *
    * @param abstracts the abstracts of this project
    */
    @Override
    public void setAbstracts(java.lang.String abstracts) {
        _project.setAbstracts(abstracts);
    }

    /**
    * Returns the element of this project.
    *
    * @return the element of this project
    */
    @Override
    public java.lang.String getElement() {
        return _project.getElement();
    }

    /**
    * Sets the element of this project.
    *
    * @param element the element of this project
    */
    @Override
    public void setElement(java.lang.String element) {
        _project.setElement(element);
    }

    /**
    * Returns the keywords of this project.
    *
    * @return the keywords of this project
    */
    @Override
    public java.lang.String getKeywords() {
        return _project.getKeywords();
    }

    /**
    * Sets the keywords of this project.
    *
    * @param keywords the keywords of this project
    */
    @Override
    public void setKeywords(java.lang.String keywords) {
        _project.setKeywords(keywords);
    }

    /**
    * Returns the website of this project.
    *
    * @return the website of this project
    */
    @Override
    public java.lang.String getWebsite() {
        return _project.getWebsite();
    }

    /**
    * Sets the website of this project.
    *
    * @param website the website of this project
    */
    @Override
    public void setWebsite(java.lang.String website) {
        _project.setWebsite(website);
    }

    /**
    * Returns the duration of this project.
    *
    * @return the duration of this project
    */
    @Override
    public java.lang.String getDuration() {
        return _project.getDuration();
    }

    /**
    * Sets the duration of this project.
    *
    * @param duration the duration of this project
    */
    @Override
    public void setDuration(java.lang.String duration) {
        _project.setDuration(duration);
    }

    /**
    * Returns the rating of this project.
    *
    * @return the rating of this project
    */
    @Override
    public long getRating() {
        return _project.getRating();
    }

    /**
    * Sets the rating of this project.
    *
    * @param rating the rating of this project
    */
    @Override
    public void setRating(long rating) {
        _project.setRating(rating);
    }

    /**
    * Returns the importance of this project.
    *
    * @return the importance of this project
    */
    @Override
    public long getImportance() {
        return _project.getImportance();
    }

    /**
    * Sets the importance of this project.
    *
    * @param importance the importance of this project
    */
    @Override
    public void setImportance(long importance) {
        _project.setImportance(importance);
    }

    /**
    * Returns the specialtagging of this project.
    *
    * @return the specialtagging of this project
    */
    @Override
    public java.lang.String getSpecialtagging() {
        return _project.getSpecialtagging();
    }

    /**
    * Sets the specialtagging of this project.
    *
    * @param specialtagging the specialtagging of this project
    */
    @Override
    public void setSpecialtagging(java.lang.String specialtagging) {
        _project.setSpecialtagging(specialtagging);
    }

    /**
    * Returns the controlstatus of this project.
    *
    * @return the controlstatus of this project
    */
    @Override
    public short getControlstatus() {
        return _project.getControlstatus();
    }

    /**
    * Sets the controlstatus of this project.
    *
    * @param controlstatus the controlstatus of this project
    */
    @Override
    public void setControlstatus(short controlstatus) {
        _project.setControlstatus(controlstatus);
    }

    /**
    * Returns the creator of this project.
    *
    * @return the creator of this project
    */
    @Override
    public java.lang.String getCreator() {
        return _project.getCreator();
    }

    /**
    * Sets the creator of this project.
    *
    * @param creator the creator of this project
    */
    @Override
    public void setCreator(java.lang.String creator) {
        _project.setCreator(creator);
    }

    /**
    * Returns the creationdate of this project.
    *
    * @return the creationdate of this project
    */
    @Override
    public java.util.Date getCreationdate() {
        return _project.getCreationdate();
    }

    /**
    * Sets the creationdate of this project.
    *
    * @param creationdate the creationdate of this project
    */
    @Override
    public void setCreationdate(java.util.Date creationdate) {
        _project.setCreationdate(creationdate);
    }

    /**
    * Returns the moderator of this project.
    *
    * @return the moderator of this project
    */
    @Override
    public java.lang.String getModerator() {
        return _project.getModerator();
    }

    /**
    * Sets the moderator of this project.
    *
    * @param moderator the moderator of this project
    */
    @Override
    public void setModerator(java.lang.String moderator) {
        _project.setModerator(moderator);
    }

    /**
    * Returns the approvaldate of this project.
    *
    * @return the approvaldate of this project
    */
    @Override
    public java.util.Date getApprovaldate() {
        return _project.getApprovaldate();
    }

    /**
    * Sets the approvaldate of this project.
    *
    * @param approvaldate the approvaldate of this project
    */
    @Override
    public void setApprovaldate(java.util.Date approvaldate) {
        _project.setApprovaldate(approvaldate);
    }

    /**
    * Returns the replaces ID of this project.
    *
    * @return the replaces ID of this project
    */
    @Override
    public long getReplacesId() {
        return _project.getReplacesId();
    }

    /**
    * Sets the replaces ID of this project.
    *
    * @param replacesId the replaces ID of this project
    */
    @Override
    public void setReplacesId(long replacesId) {
        _project.setReplacesId(replacesId);
    }

    /**
    * Returns the comments of this project.
    *
    * @return the comments of this project
    */
    @Override
    public java.lang.String getComments() {
        return _project.getComments();
    }

    /**
    * Sets the comments of this project.
    *
    * @param comments the comments of this project
    */
    @Override
    public void setComments(java.lang.String comments) {
        _project.setComments(comments);
    }

    /**
    * Returns the textwebpage of this project.
    *
    * @return the textwebpage of this project
    */
    @Override
    public java.lang.String getTextwebpage() {
        return _project.getTextwebpage();
    }

    /**
    * Sets the textwebpage of this project.
    *
    * @param textwebpage the textwebpage of this project
    */
    @Override
    public void setTextwebpage(java.lang.String textwebpage) {
        _project.setTextwebpage(textwebpage);
    }

    /**
    * Returns the spatialvalues of this project.
    *
    * @return the spatialvalues of this project
    */
    @Override
    public java.lang.String getSpatialvalues() {
        return _project.getSpatialvalues();
    }

    /**
    * Sets the spatialvalues of this project.
    *
    * @param spatialvalues the spatialvalues of this project
    */
    @Override
    public void setSpatialvalues(java.lang.String spatialvalues) {
        _project.setSpatialvalues(spatialvalues);
    }

    /**
    * Returns the source of this project.
    *
    * @return the source of this project
    */
    @Override
    public java.lang.String getSource() {
        return _project.getSource();
    }

    /**
    * Sets the source of this project.
    *
    * @param source the source of this project
    */
    @Override
    public void setSource(java.lang.String source) {
        _project.setSource(source);
    }

    /**
    * Returns the climateimpacts of this project.
    *
    * @return the climateimpacts of this project
    */
    @Override
    public java.lang.String getClimateimpacts() {
        return _project.getClimateimpacts();
    }

    /**
    * Sets the climateimpacts of this project.
    *
    * @param climateimpacts the climateimpacts of this project
    */
    @Override
    public void setClimateimpacts(java.lang.String climateimpacts) {
        _project.setClimateimpacts(climateimpacts);
    }

    /**
    * Returns the lockdate of this project.
    *
    * @return the lockdate of this project
    */
    @Override
    public java.util.Date getLockdate() {
        return _project.getLockdate();
    }

    /**
    * Sets the lockdate of this project.
    *
    * @param lockdate the lockdate of this project
    */
    @Override
    public void setLockdate(java.util.Date lockdate) {
        _project.setLockdate(lockdate);
    }

    /**
    * Returns the feature of this project.
    *
    * @return the feature of this project
    */
    @Override
    public java.lang.String getFeature() {
        return _project.getFeature();
    }

    /**
    * Sets the feature of this project.
    *
    * @param feature the feature of this project
    */
    @Override
    public void setFeature(java.lang.String feature) {
        _project.setFeature(feature);
    }

    /**
    * Returns the supdocs of this project.
    *
    * @return the supdocs of this project
    */
    @Override
    public java.lang.String getSupdocs() {
        return _project.getSupdocs();
    }

    /**
    * Sets the supdocs of this project.
    *
    * @param supdocs the supdocs of this project
    */
    @Override
    public void setSupdocs(java.lang.String supdocs) {
        _project.setSupdocs(supdocs);
    }

    /**
    * Returns the geochars of this project.
    *
    * @return the geochars of this project
    */
    @Override
    public java.lang.String getGeochars() {
        return _project.getGeochars();
    }

    /**
    * Sets the geochars of this project.
    *
    * @param geochars the geochars of this project
    */
    @Override
    public void setGeochars(java.lang.String geochars) {
        _project.setGeochars(geochars);
    }

    @Override
    public boolean isNew() {
        return _project.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _project.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _project.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _project.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _project.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _project.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _project.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _project.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _project.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _project.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _project.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new ProjectWrapper((Project) _project.clone());
    }

    @Override
    public int compareTo(nl.wur.alterra.cgi.ace.model.Project project) {
        return _project.compareTo(project);
    }

    @Override
    public int hashCode() {
        return _project.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<nl.wur.alterra.cgi.ace.model.Project> toCacheModel() {
        return _project.toCacheModel();
    }

    @Override
    public nl.wur.alterra.cgi.ace.model.Project toEscapedModel() {
        return new ProjectWrapper(_project.toEscapedModel());
    }

    @Override
    public nl.wur.alterra.cgi.ace.model.Project toUnescapedModel() {
        return new ProjectWrapper(_project.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _project.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _project.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _project.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ProjectWrapper)) {
            return false;
        }

        ProjectWrapper projectWrapper = (ProjectWrapper) obj;

        if (Validator.equals(_project, projectWrapper._project)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Project getWrappedProject() {
        return _project;
    }

    @Override
    public Project getWrappedModel() {
        return _project;
    }

    @Override
    public void resetOriginalValues() {
        _project.resetOriginalValues();
    }
}
