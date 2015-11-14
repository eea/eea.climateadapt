package nl.wur.alterra.cgi.ace.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the AceItem service. Represents a row in the &quot;Ace_AceItem&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link nl.wur.alterra.cgi.ace.model.impl.AceItemModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link nl.wur.alterra.cgi.ace.model.impl.AceItemImpl}.
 * </p>
 *
 * @author groot052
 * @see AceItem
 * @see nl.wur.alterra.cgi.ace.model.impl.AceItemImpl
 * @see nl.wur.alterra.cgi.ace.model.impl.AceItemModelImpl
 * @generated
 */
public interface AceItemModel extends BaseModel<AceItem> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a ace item model instance should use the {@link AceItem} interface instead.
     */

    /**
     * Returns the primary key of this ace item.
     *
     * @return the primary key of this ace item
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this ace item.
     *
     * @param primaryKey the primary key of this ace item
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the ace item ID of this ace item.
     *
     * @return the ace item ID of this ace item
     */
    public long getAceItemId();

    /**
     * Sets the ace item ID of this ace item.
     *
     * @param aceItemId the ace item ID of this ace item
     */
    public void setAceItemId(long aceItemId);

    /**
     * Returns the company ID of this ace item.
     *
     * @return the company ID of this ace item
     */
    public long getCompanyId();

    /**
     * Sets the company ID of this ace item.
     *
     * @param companyId the company ID of this ace item
     */
    public void setCompanyId(long companyId);

    /**
     * Returns the group ID of this ace item.
     *
     * @return the group ID of this ace item
     */
    public long getGroupId();

    /**
     * Sets the group ID of this ace item.
     *
     * @param groupId the group ID of this ace item
     */
    public void setGroupId(long groupId);

    /**
     * Returns the wxsharvester ID of this ace item.
     *
     * @return the wxsharvester ID of this ace item
     */
    public long getWxsharvesterId();

    /**
     * Sets the wxsharvester ID of this ace item.
     *
     * @param wxsharvesterId the wxsharvester ID of this ace item
     */
    public void setWxsharvesterId(long wxsharvesterId);

    /**
     * Returns the cswharvester ID of this ace item.
     *
     * @return the cswharvester ID of this ace item
     */
    public long getCswharvesterId();

    /**
     * Sets the cswharvester ID of this ace item.
     *
     * @param cswharvesterId the cswharvester ID of this ace item
     */
    public void setCswharvesterId(long cswharvesterId);

    /**
     * Returns the name of this ace item.
     *
     * @return the name of this ace item
     */
    @AutoEscape
    public String getName();

    /**
     * Sets the name of this ace item.
     *
     * @param name the name of this ace item
     */
    public void setName(String name);

    /**
     * Returns the description of this ace item.
     *
     * @return the description of this ace item
     */
    @AutoEscape
    public String getDescription();

    /**
     * Sets the description of this ace item.
     *
     * @param description the description of this ace item
     */
    public void setDescription(String description);

    /**
     * Returns the datatype of this ace item.
     *
     * @return the datatype of this ace item
     */
    @AutoEscape
    public String getDatatype();

    /**
     * Sets the datatype of this ace item.
     *
     * @param datatype the datatype of this ace item
     */
    public void setDatatype(String datatype);

    /**
     * Returns the stored at of this ace item.
     *
     * @return the stored at of this ace item
     */
    @AutoEscape
    public String getStoredAt();

    /**
     * Sets the stored at of this ace item.
     *
     * @param storedAt the stored at of this ace item
     */
    public void setStoredAt(String storedAt);

    /**
     * Returns the storagetype of this ace item.
     *
     * @return the storagetype of this ace item
     */
    @AutoEscape
    public String getStoragetype();

    /**
     * Sets the storagetype of this ace item.
     *
     * @param storagetype the storagetype of this ace item
     */
    public void setStoragetype(String storagetype);

    /**
     * Returns the specialtagging of this ace item.
     *
     * @return the specialtagging of this ace item
     */
    @AutoEscape
    public String getSpecialtagging();

    /**
     * Sets the specialtagging of this ace item.
     *
     * @param specialtagging the specialtagging of this ace item
     */
    public void setSpecialtagging(String specialtagging);

    /**
     * Returns the text search of this ace item.
     *
     * @return the text search of this ace item
     */
    @AutoEscape
    public String getTextSearch();

    /**
     * Sets the text search of this ace item.
     *
     * @param textSearch the text search of this ace item
     */
    public void setTextSearch(String textSearch);

    /**
     * Returns the keyword of this ace item.
     *
     * @return the keyword of this ace item
     */
    @AutoEscape
    public String getKeyword();

    /**
     * Sets the keyword of this ace item.
     *
     * @param keyword the keyword of this ace item
     */
    public void setKeyword(String keyword);

    /**
     * Returns the targetresolution of this ace item.
     *
     * @return the targetresolution of this ace item
     */
    @AutoEscape
    public String getTargetresolution();

    /**
     * Sets the targetresolution of this ace item.
     *
     * @param targetresolution the targetresolution of this ace item
     */
    public void setTargetresolution(String targetresolution);

    /**
     * Returns the spatial layer of this ace item.
     *
     * @return the spatial layer of this ace item
     */
    @AutoEscape
    public String getSpatialLayer();

    /**
     * Sets the spatial layer of this ace item.
     *
     * @param spatialLayer the spatial layer of this ace item
     */
    public void setSpatialLayer(String spatialLayer);

    /**
     * Returns the spatial values of this ace item.
     *
     * @return the spatial values of this ace item
     */
    @AutoEscape
    public String getSpatialValues();

    /**
     * Sets the spatial values of this ace item.
     *
     * @param spatialValues the spatial values of this ace item
     */
    public void setSpatialValues(String spatialValues);

    /**
     * Returns the start date of this ace item.
     *
     * @return the start date of this ace item
     */
    public Date getStartDate();

    /**
     * Sets the start date of this ace item.
     *
     * @param startDate the start date of this ace item
     */
    public void setStartDate(Date startDate);

    /**
     * Returns the end date of this ace item.
     *
     * @return the end date of this ace item
     */
    public Date getEndDate();

    /**
     * Sets the end date of this ace item.
     *
     * @param endDate the end date of this ace item
     */
    public void setEndDate(Date endDate);

    /**
     * Returns the publication date of this ace item.
     *
     * @return the publication date of this ace item
     */
    public Date getPublicationDate();

    /**
     * Sets the publication date of this ace item.
     *
     * @param publicationDate the publication date of this ace item
     */
    public void setPublicationDate(Date publicationDate);

    /**
     * Returns the sectors_ of this ace item.
     *
     * @return the sectors_ of this ace item
     */
    @AutoEscape
    public String getSectors_();

    /**
     * Sets the sectors_ of this ace item.
     *
     * @param sectors_ the sectors_ of this ace item
     */
    public void setSectors_(String sectors_);

    /**
     * Returns the elements_ of this ace item.
     *
     * @return the elements_ of this ace item
     */
    @AutoEscape
    public String getElements_();

    /**
     * Sets the elements_ of this ace item.
     *
     * @param elements_ the elements_ of this ace item
     */
    public void setElements_(String elements_);

    /**
     * Returns the climateimpacts_ of this ace item.
     *
     * @return the climateimpacts_ of this ace item
     */
    @AutoEscape
    public String getClimateimpacts_();

    /**
     * Sets the climateimpacts_ of this ace item.
     *
     * @param climateimpacts_ the climateimpacts_ of this ace item
     */
    public void setClimateimpacts_(String climateimpacts_);

    /**
     * Returns the rating of this ace item.
     *
     * @return the rating of this ace item
     */
    public long getRating();

    /**
     * Sets the rating of this ace item.
     *
     * @param rating the rating of this ace item
     */
    public void setRating(long rating);

    /**
     * Returns the importance of this ace item.
     *
     * @return the importance of this ace item
     */
    public long getImportance();

    /**
     * Sets the importance of this ace item.
     *
     * @param importance the importance of this ace item
     */
    public void setImportance(long importance);

    /**
     * Returns the source of this ace item.
     *
     * @return the source of this ace item
     */
    @AutoEscape
    public String getSource();

    /**
     * Sets the source of this ace item.
     *
     * @param source the source of this ace item
     */
    public void setSource(String source);

    /**
     * Returns the deeplink of this ace item.
     *
     * @return the deeplink of this ace item
     */
    @AutoEscape
    public String getDeeplink();

    /**
     * Sets the deeplink of this ace item.
     *
     * @param deeplink the deeplink of this ace item
     */
    public void setDeeplink(String deeplink);

    /**
     * Returns the controlstatus of this ace item.
     *
     * @return the controlstatus of this ace item
     */
    public short getControlstatus();

    /**
     * Sets the controlstatus of this ace item.
     *
     * @param controlstatus the controlstatus of this ace item
     */
    public void setControlstatus(short controlstatus);

    /**
     * Returns the creator of this ace item.
     *
     * @return the creator of this ace item
     */
    @AutoEscape
    public String getCreator();

    /**
     * Sets the creator of this ace item.
     *
     * @param creator the creator of this ace item
     */
    public void setCreator(String creator);

    /**
     * Returns the creationdate of this ace item.
     *
     * @return the creationdate of this ace item
     */
    public Date getCreationdate();

    /**
     * Sets the creationdate of this ace item.
     *
     * @param creationdate the creationdate of this ace item
     */
    public void setCreationdate(Date creationdate);

    /**
     * Returns the moderator of this ace item.
     *
     * @return the moderator of this ace item
     */
    @AutoEscape
    public String getModerator();

    /**
     * Sets the moderator of this ace item.
     *
     * @param moderator the moderator of this ace item
     */
    public void setModerator(String moderator);

    /**
     * Returns the approvaldate of this ace item.
     *
     * @return the approvaldate of this ace item
     */
    public Date getApprovaldate();

    /**
     * Sets the approvaldate of this ace item.
     *
     * @param approvaldate the approvaldate of this ace item
     */
    public void setApprovaldate(Date approvaldate);

    /**
     * Returns the replaces ID of this ace item.
     *
     * @return the replaces ID of this ace item
     */
    public long getReplacesId();

    /**
     * Sets the replaces ID of this ace item.
     *
     * @param replacesId the replaces ID of this ace item
     */
    public void setReplacesId(long replacesId);

    /**
     * Returns the comments of this ace item.
     *
     * @return the comments of this ace item
     */
    @AutoEscape
    public String getComments();

    /**
     * Sets the comments of this ace item.
     *
     * @param comments the comments of this ace item
     */
    public void setComments(String comments);

    /**
     * Returns the textwebpage of this ace item.
     *
     * @return the textwebpage of this ace item
     */
    @AutoEscape
    public String getTextwebpage();

    /**
     * Sets the textwebpage of this ace item.
     *
     * @param textwebpage the textwebpage of this ace item
     */
    public void setTextwebpage(String textwebpage);

    /**
     * Returns the year of this ace item.
     *
     * @return the year of this ace item
     */
    @AutoEscape
    public String getYear();

    /**
     * Sets the year of this ace item.
     *
     * @param year the year of this ace item
     */
    public void setYear(String year);

    /**
     * Returns the geochars of this ace item.
     *
     * @return the geochars of this ace item
     */
    @AutoEscape
    public String getGeochars();

    /**
     * Sets the geochars of this ace item.
     *
     * @param geochars the geochars of this ace item
     */
    public void setGeochars(String geochars);

    /**
     * Returns the feature of this ace item.
     *
     * @return the feature of this ace item
     */
    @AutoEscape
    public String getFeature();

    /**
     * Sets the feature of this ace item.
     *
     * @param feature the feature of this ace item
     */
    public void setFeature(String feature);

    /**
     * Returns the supdocs of this ace item.
     *
     * @return the supdocs of this ace item
     */
    @AutoEscape
    public String getSupdocs();

    /**
     * Sets the supdocs of this ace item.
     *
     * @param supdocs the supdocs of this ace item
     */
    public void setSupdocs(String supdocs);

    /**
     * Returns the admincomment of this ace item.
     *
     * @return the admincomment of this ace item
     */
    @AutoEscape
    public String getAdmincomment();

    /**
     * Sets the admincomment of this ace item.
     *
     * @param admincomment the admincomment of this ace item
     */
    public void setAdmincomment(String admincomment);

    /**
     * Returns the scenario of this ace item.
     *
     * @return the scenario of this ace item
     */
    @AutoEscape
    public String getScenario();

    /**
     * Sets the scenario of this ace item.
     *
     * @param scenario the scenario of this ace item
     */
    public void setScenario(String scenario);

    /**
     * Returns the timeperiod of this ace item.
     *
     * @return the timeperiod of this ace item
     */
    @AutoEscape
    public String getTimeperiod();

    /**
     * Sets the timeperiod of this ace item.
     *
     * @param timeperiod the timeperiod of this ace item
     */
    public void setTimeperiod(String timeperiod);

    /**
     * Returns the lockdate of this ace item.
     *
     * @return the lockdate of this ace item
     */
    public Date getLockdate();

    /**
     * Sets the lockdate of this ace item.
     *
     * @param lockdate the lockdate of this ace item
     */
    public void setLockdate(Date lockdate);

    /**
     * Returns the meta data of this ace item.
     *
     * @return the meta data of this ace item
     */
    @AutoEscape
    public String getMetaData();

    /**
     * Sets the meta data of this ace item.
     *
     * @param metaData the meta data of this ace item
     */
    public void setMetaData(String metaData);

    @Override
    public boolean isNew();

    @Override
    public void setNew(boolean n);

    @Override
    public boolean isCachedModel();

    @Override
    public void setCachedModel(boolean cachedModel);

    @Override
    public boolean isEscapedModel();

    @Override
    public Serializable getPrimaryKeyObj();

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    @Override
    public ExpandoBridge getExpandoBridge();

    @Override
    public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

    @Override
    public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    @Override
    public Object clone();

    @Override
    public int compareTo(AceItem aceItem);

    @Override
    public int hashCode();

    @Override
    public CacheModel<AceItem> toCacheModel();

    @Override
    public AceItem toEscapedModel();

    @Override
    public AceItem toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}
