package nl.wur.alterra.cgi.ace.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import nl.wur.alterra.cgi.ace.service.AceItemLocalServiceUtil;
import nl.wur.alterra.cgi.ace.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class AceItemClp extends BaseModelImpl<AceItem> implements AceItem {
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
    private String _year;
    private String _geochars;
    private String _feature;
    private String _supdocs;
    private String _admincomment;
    private String _scenario;
    private String _timeperiod;
    private Date _lockdate;
    private String _metaData;
    private BaseModel<?> _aceItemRemoteModel;

    public AceItemClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return AceItem.class;
    }

    @Override
    public String getModelClassName() {
        return AceItem.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _aceItemId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setAceItemId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _aceItemId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("aceItemId", getAceItemId());
        attributes.put("companyId", getCompanyId());
        attributes.put("groupId", getGroupId());
        attributes.put("wxsharvesterId", getWxsharvesterId());
        attributes.put("cswharvesterId", getCswharvesterId());
        attributes.put("name", getName());
        attributes.put("description", getDescription());
        attributes.put("datatype", getDatatype());
        attributes.put("storedAt", getStoredAt());
        attributes.put("storagetype", getStoragetype());
        attributes.put("specialtagging", getSpecialtagging());
        attributes.put("textSearch", getTextSearch());
        attributes.put("keyword", getKeyword());
        attributes.put("targetresolution", getTargetresolution());
        attributes.put("spatialLayer", getSpatialLayer());
        attributes.put("spatialValues", getSpatialValues());
        attributes.put("startDate", getStartDate());
        attributes.put("endDate", getEndDate());
        attributes.put("publicationDate", getPublicationDate());
        attributes.put("sectors_", getSectors_());
        attributes.put("elements_", getElements_());
        attributes.put("climateimpacts_", getClimateimpacts_());
        attributes.put("rating", getRating());
        attributes.put("importance", getImportance());
        attributes.put("source", getSource());
        attributes.put("deeplink", getDeeplink());
        attributes.put("controlstatus", getControlstatus());
        attributes.put("creator", getCreator());
        attributes.put("creationdate", getCreationdate());
        attributes.put("moderator", getModerator());
        attributes.put("approvaldate", getApprovaldate());
        attributes.put("replacesId", getReplacesId());
        attributes.put("comments", getComments());
        attributes.put("textwebpage", getTextwebpage());
        attributes.put("year", getYear());
        attributes.put("geochars", getGeochars());
        attributes.put("feature", getFeature());
        attributes.put("supdocs", getSupdocs());
        attributes.put("admincomment", getAdmincomment());
        attributes.put("scenario", getScenario());
        attributes.put("timeperiod", getTimeperiod());
        attributes.put("lockdate", getLockdate());
        attributes.put("metaData", getMetaData());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long aceItemId = (Long) attributes.get("aceItemId");

        if (aceItemId != null) {
            setAceItemId(aceItemId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Long wxsharvesterId = (Long) attributes.get("wxsharvesterId");

        if (wxsharvesterId != null) {
            setWxsharvesterId(wxsharvesterId);
        }

        Long cswharvesterId = (Long) attributes.get("cswharvesterId");

        if (cswharvesterId != null) {
            setCswharvesterId(cswharvesterId);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        String datatype = (String) attributes.get("datatype");

        if (datatype != null) {
            setDatatype(datatype);
        }

        String storedAt = (String) attributes.get("storedAt");

        if (storedAt != null) {
            setStoredAt(storedAt);
        }

        String storagetype = (String) attributes.get("storagetype");

        if (storagetype != null) {
            setStoragetype(storagetype);
        }

        String specialtagging = (String) attributes.get("specialtagging");

        if (specialtagging != null) {
            setSpecialtagging(specialtagging);
        }

        String textSearch = (String) attributes.get("textSearch");

        if (textSearch != null) {
            setTextSearch(textSearch);
        }

        String keyword = (String) attributes.get("keyword");

        if (keyword != null) {
            setKeyword(keyword);
        }

        String targetresolution = (String) attributes.get("targetresolution");

        if (targetresolution != null) {
            setTargetresolution(targetresolution);
        }

        String spatialLayer = (String) attributes.get("spatialLayer");

        if (spatialLayer != null) {
            setSpatialLayer(spatialLayer);
        }

        String spatialValues = (String) attributes.get("spatialValues");

        if (spatialValues != null) {
            setSpatialValues(spatialValues);
        }

        Date startDate = (Date) attributes.get("startDate");

        if (startDate != null) {
            setStartDate(startDate);
        }

        Date endDate = (Date) attributes.get("endDate");

        if (endDate != null) {
            setEndDate(endDate);
        }

        Date publicationDate = (Date) attributes.get("publicationDate");

        if (publicationDate != null) {
            setPublicationDate(publicationDate);
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

        Long rating = (Long) attributes.get("rating");

        if (rating != null) {
            setRating(rating);
        }

        Long importance = (Long) attributes.get("importance");

        if (importance != null) {
            setImportance(importance);
        }

        String source = (String) attributes.get("source");

        if (source != null) {
            setSource(source);
        }

        String deeplink = (String) attributes.get("deeplink");

        if (deeplink != null) {
            setDeeplink(deeplink);
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

        String year = (String) attributes.get("year");

        if (year != null) {
            setYear(year);
        }

        String geochars = (String) attributes.get("geochars");

        if (geochars != null) {
            setGeochars(geochars);
        }

        String feature = (String) attributes.get("feature");

        if (feature != null) {
            setFeature(feature);
        }

        String supdocs = (String) attributes.get("supdocs");

        if (supdocs != null) {
            setSupdocs(supdocs);
        }

        String admincomment = (String) attributes.get("admincomment");

        if (admincomment != null) {
            setAdmincomment(admincomment);
        }

        String scenario = (String) attributes.get("scenario");

        if (scenario != null) {
            setScenario(scenario);
        }

        String timeperiod = (String) attributes.get("timeperiod");

        if (timeperiod != null) {
            setTimeperiod(timeperiod);
        }

        Date lockdate = (Date) attributes.get("lockdate");

        if (lockdate != null) {
            setLockdate(lockdate);
        }

        String metaData = (String) attributes.get("metaData");

        if (metaData != null) {
            setMetaData(metaData);
        }
    }

    @Override
    public long getAceItemId() {
        return _aceItemId;
    }

    @Override
    public void setAceItemId(long aceItemId) {
        _aceItemId = aceItemId;

        if (_aceItemRemoteModel != null) {
            try {
                Class<?> clazz = _aceItemRemoteModel.getClass();

                Method method = clazz.getMethod("setAceItemId", long.class);

                method.invoke(_aceItemRemoteModel, aceItemId);
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

        if (_aceItemRemoteModel != null) {
            try {
                Class<?> clazz = _aceItemRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_aceItemRemoteModel, companyId);
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

        if (_aceItemRemoteModel != null) {
            try {
                Class<?> clazz = _aceItemRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_aceItemRemoteModel, groupId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getWxsharvesterId() {
        return _wxsharvesterId;
    }

    @Override
    public void setWxsharvesterId(long wxsharvesterId) {
        _wxsharvesterId = wxsharvesterId;

        if (_aceItemRemoteModel != null) {
            try {
                Class<?> clazz = _aceItemRemoteModel.getClass();

                Method method = clazz.getMethod("setWxsharvesterId", long.class);

                method.invoke(_aceItemRemoteModel, wxsharvesterId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getCswharvesterId() {
        return _cswharvesterId;
    }

    @Override
    public void setCswharvesterId(long cswharvesterId) {
        _cswharvesterId = cswharvesterId;

        if (_aceItemRemoteModel != null) {
            try {
                Class<?> clazz = _aceItemRemoteModel.getClass();

                Method method = clazz.getMethod("setCswharvesterId", long.class);

                method.invoke(_aceItemRemoteModel, cswharvesterId);
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

        if (_aceItemRemoteModel != null) {
            try {
                Class<?> clazz = _aceItemRemoteModel.getClass();

                Method method = clazz.getMethod("setName", String.class);

                method.invoke(_aceItemRemoteModel, name);
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

        if (_aceItemRemoteModel != null) {
            try {
                Class<?> clazz = _aceItemRemoteModel.getClass();

                Method method = clazz.getMethod("setDescription", String.class);

                method.invoke(_aceItemRemoteModel, description);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDatatype() {
        return _datatype;
    }

    @Override
    public void setDatatype(String datatype) {
        _datatype = datatype;

        if (_aceItemRemoteModel != null) {
            try {
                Class<?> clazz = _aceItemRemoteModel.getClass();

                Method method = clazz.getMethod("setDatatype", String.class);

                method.invoke(_aceItemRemoteModel, datatype);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getStoredAt() {
        return _storedAt;
    }

    @Override
    public void setStoredAt(String storedAt) {
        _storedAt = storedAt;

        if (_aceItemRemoteModel != null) {
            try {
                Class<?> clazz = _aceItemRemoteModel.getClass();

                Method method = clazz.getMethod("setStoredAt", String.class);

                method.invoke(_aceItemRemoteModel, storedAt);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getStoragetype() {
        return _storagetype;
    }

    @Override
    public void setStoragetype(String storagetype) {
        _storagetype = storagetype;

        if (_aceItemRemoteModel != null) {
            try {
                Class<?> clazz = _aceItemRemoteModel.getClass();

                Method method = clazz.getMethod("setStoragetype", String.class);

                method.invoke(_aceItemRemoteModel, storagetype);
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

        if (_aceItemRemoteModel != null) {
            try {
                Class<?> clazz = _aceItemRemoteModel.getClass();

                Method method = clazz.getMethod("setSpecialtagging",
                        String.class);

                method.invoke(_aceItemRemoteModel, specialtagging);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getTextSearch() {
        return _textSearch;
    }

    @Override
    public void setTextSearch(String textSearch) {
        _textSearch = textSearch;

        if (_aceItemRemoteModel != null) {
            try {
                Class<?> clazz = _aceItemRemoteModel.getClass();

                Method method = clazz.getMethod("setTextSearch", String.class);

                method.invoke(_aceItemRemoteModel, textSearch);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getKeyword() {
        return _keyword;
    }

    @Override
    public void setKeyword(String keyword) {
        _keyword = keyword;

        if (_aceItemRemoteModel != null) {
            try {
                Class<?> clazz = _aceItemRemoteModel.getClass();

                Method method = clazz.getMethod("setKeyword", String.class);

                method.invoke(_aceItemRemoteModel, keyword);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getTargetresolution() {
        return _targetresolution;
    }

    @Override
    public void setTargetresolution(String targetresolution) {
        _targetresolution = targetresolution;

        if (_aceItemRemoteModel != null) {
            try {
                Class<?> clazz = _aceItemRemoteModel.getClass();

                Method method = clazz.getMethod("setTargetresolution",
                        String.class);

                method.invoke(_aceItemRemoteModel, targetresolution);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getSpatialLayer() {
        return _spatialLayer;
    }

    @Override
    public void setSpatialLayer(String spatialLayer) {
        _spatialLayer = spatialLayer;

        if (_aceItemRemoteModel != null) {
            try {
                Class<?> clazz = _aceItemRemoteModel.getClass();

                Method method = clazz.getMethod("setSpatialLayer", String.class);

                method.invoke(_aceItemRemoteModel, spatialLayer);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getSpatialValues() {
        return _spatialValues;
    }

    @Override
    public void setSpatialValues(String spatialValues) {
        _spatialValues = spatialValues;

        if (_aceItemRemoteModel != null) {
            try {
                Class<?> clazz = _aceItemRemoteModel.getClass();

                Method method = clazz.getMethod("setSpatialValues", String.class);

                method.invoke(_aceItemRemoteModel, spatialValues);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getStartDate() {
        return _startDate;
    }

    @Override
    public void setStartDate(Date startDate) {
        _startDate = startDate;

        if (_aceItemRemoteModel != null) {
            try {
                Class<?> clazz = _aceItemRemoteModel.getClass();

                Method method = clazz.getMethod("setStartDate", Date.class);

                method.invoke(_aceItemRemoteModel, startDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getEndDate() {
        return _endDate;
    }

    @Override
    public void setEndDate(Date endDate) {
        _endDate = endDate;

        if (_aceItemRemoteModel != null) {
            try {
                Class<?> clazz = _aceItemRemoteModel.getClass();

                Method method = clazz.getMethod("setEndDate", Date.class);

                method.invoke(_aceItemRemoteModel, endDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getPublicationDate() {
        return _publicationDate;
    }

    @Override
    public void setPublicationDate(Date publicationDate) {
        _publicationDate = publicationDate;

        if (_aceItemRemoteModel != null) {
            try {
                Class<?> clazz = _aceItemRemoteModel.getClass();

                Method method = clazz.getMethod("setPublicationDate", Date.class);

                method.invoke(_aceItemRemoteModel, publicationDate);
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

        if (_aceItemRemoteModel != null) {
            try {
                Class<?> clazz = _aceItemRemoteModel.getClass();

                Method method = clazz.getMethod("setSectors_", String.class);

                method.invoke(_aceItemRemoteModel, sectors_);
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

        if (_aceItemRemoteModel != null) {
            try {
                Class<?> clazz = _aceItemRemoteModel.getClass();

                Method method = clazz.getMethod("setElements_", String.class);

                method.invoke(_aceItemRemoteModel, elements_);
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

        if (_aceItemRemoteModel != null) {
            try {
                Class<?> clazz = _aceItemRemoteModel.getClass();

                Method method = clazz.getMethod("setClimateimpacts_",
                        String.class);

                method.invoke(_aceItemRemoteModel, climateimpacts_);
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

        if (_aceItemRemoteModel != null) {
            try {
                Class<?> clazz = _aceItemRemoteModel.getClass();

                Method method = clazz.getMethod("setRating", long.class);

                method.invoke(_aceItemRemoteModel, rating);
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

        if (_aceItemRemoteModel != null) {
            try {
                Class<?> clazz = _aceItemRemoteModel.getClass();

                Method method = clazz.getMethod("setImportance", long.class);

                method.invoke(_aceItemRemoteModel, importance);
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

        if (_aceItemRemoteModel != null) {
            try {
                Class<?> clazz = _aceItemRemoteModel.getClass();

                Method method = clazz.getMethod("setSource", String.class);

                method.invoke(_aceItemRemoteModel, source);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDeeplink() {
        return _deeplink;
    }

    @Override
    public void setDeeplink(String deeplink) {
        _deeplink = deeplink;

        if (_aceItemRemoteModel != null) {
            try {
                Class<?> clazz = _aceItemRemoteModel.getClass();

                Method method = clazz.getMethod("setDeeplink", String.class);

                method.invoke(_aceItemRemoteModel, deeplink);
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

        if (_aceItemRemoteModel != null) {
            try {
                Class<?> clazz = _aceItemRemoteModel.getClass();

                Method method = clazz.getMethod("setControlstatus", short.class);

                method.invoke(_aceItemRemoteModel, controlstatus);
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

        if (_aceItemRemoteModel != null) {
            try {
                Class<?> clazz = _aceItemRemoteModel.getClass();

                Method method = clazz.getMethod("setCreator", String.class);

                method.invoke(_aceItemRemoteModel, creator);
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

        if (_aceItemRemoteModel != null) {
            try {
                Class<?> clazz = _aceItemRemoteModel.getClass();

                Method method = clazz.getMethod("setCreationdate", Date.class);

                method.invoke(_aceItemRemoteModel, creationdate);
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

        if (_aceItemRemoteModel != null) {
            try {
                Class<?> clazz = _aceItemRemoteModel.getClass();

                Method method = clazz.getMethod("setModerator", String.class);

                method.invoke(_aceItemRemoteModel, moderator);
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

        if (_aceItemRemoteModel != null) {
            try {
                Class<?> clazz = _aceItemRemoteModel.getClass();

                Method method = clazz.getMethod("setApprovaldate", Date.class);

                method.invoke(_aceItemRemoteModel, approvaldate);
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

        if (_aceItemRemoteModel != null) {
            try {
                Class<?> clazz = _aceItemRemoteModel.getClass();

                Method method = clazz.getMethod("setReplacesId", long.class);

                method.invoke(_aceItemRemoteModel, replacesId);
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

        if (_aceItemRemoteModel != null) {
            try {
                Class<?> clazz = _aceItemRemoteModel.getClass();

                Method method = clazz.getMethod("setComments", String.class);

                method.invoke(_aceItemRemoteModel, comments);
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

        if (_aceItemRemoteModel != null) {
            try {
                Class<?> clazz = _aceItemRemoteModel.getClass();

                Method method = clazz.getMethod("setTextwebpage", String.class);

                method.invoke(_aceItemRemoteModel, textwebpage);
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

        if (_aceItemRemoteModel != null) {
            try {
                Class<?> clazz = _aceItemRemoteModel.getClass();

                Method method = clazz.getMethod("setYear", String.class);

                method.invoke(_aceItemRemoteModel, year);
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

        if (_aceItemRemoteModel != null) {
            try {
                Class<?> clazz = _aceItemRemoteModel.getClass();

                Method method = clazz.getMethod("setGeochars", String.class);

                method.invoke(_aceItemRemoteModel, geochars);
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

        if (_aceItemRemoteModel != null) {
            try {
                Class<?> clazz = _aceItemRemoteModel.getClass();

                Method method = clazz.getMethod("setFeature", String.class);

                method.invoke(_aceItemRemoteModel, feature);
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

        if (_aceItemRemoteModel != null) {
            try {
                Class<?> clazz = _aceItemRemoteModel.getClass();

                Method method = clazz.getMethod("setSupdocs", String.class);

                method.invoke(_aceItemRemoteModel, supdocs);
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

        if (_aceItemRemoteModel != null) {
            try {
                Class<?> clazz = _aceItemRemoteModel.getClass();

                Method method = clazz.getMethod("setAdmincomment", String.class);

                method.invoke(_aceItemRemoteModel, admincomment);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getScenario() {
        return _scenario;
    }

    @Override
    public void setScenario(String scenario) {
        _scenario = scenario;

        if (_aceItemRemoteModel != null) {
            try {
                Class<?> clazz = _aceItemRemoteModel.getClass();

                Method method = clazz.getMethod("setScenario", String.class);

                method.invoke(_aceItemRemoteModel, scenario);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getTimeperiod() {
        return _timeperiod;
    }

    @Override
    public void setTimeperiod(String timeperiod) {
        _timeperiod = timeperiod;

        if (_aceItemRemoteModel != null) {
            try {
                Class<?> clazz = _aceItemRemoteModel.getClass();

                Method method = clazz.getMethod("setTimeperiod", String.class);

                method.invoke(_aceItemRemoteModel, timeperiod);
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

        if (_aceItemRemoteModel != null) {
            try {
                Class<?> clazz = _aceItemRemoteModel.getClass();

                Method method = clazz.getMethod("setLockdate", Date.class);

                method.invoke(_aceItemRemoteModel, lockdate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getMetaData() {
        return _metaData;
    }

    @Override
    public void setMetaData(String metaData) {
        _metaData = metaData;

        if (_aceItemRemoteModel != null) {
            try {
                Class<?> clazz = _aceItemRemoteModel.getClass();

                Method method = clazz.getMethod("setMetaData", String.class);

                method.invoke(_aceItemRemoteModel, metaData);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getAceItemRemoteModel() {
        return _aceItemRemoteModel;
    }

    public void setAceItemRemoteModel(BaseModel<?> aceItemRemoteModel) {
        _aceItemRemoteModel = aceItemRemoteModel;
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

        Class<?> remoteModelClass = _aceItemRemoteModel.getClass();

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

        Object returnValue = method.invoke(_aceItemRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            AceItemLocalServiceUtil.addAceItem(this);
        } else {
            AceItemLocalServiceUtil.updateAceItem(this);
        }
    }

    @Override
    public AceItem toEscapedModel() {
        return (AceItem) ProxyUtil.newProxyInstance(AceItem.class.getClassLoader(),
            new Class[] { AceItem.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        AceItemClp clone = new AceItemClp();

        clone.setAceItemId(getAceItemId());
        clone.setCompanyId(getCompanyId());
        clone.setGroupId(getGroupId());
        clone.setWxsharvesterId(getWxsharvesterId());
        clone.setCswharvesterId(getCswharvesterId());
        clone.setName(getName());
        clone.setDescription(getDescription());
        clone.setDatatype(getDatatype());
        clone.setStoredAt(getStoredAt());
        clone.setStoragetype(getStoragetype());
        clone.setSpecialtagging(getSpecialtagging());
        clone.setTextSearch(getTextSearch());
        clone.setKeyword(getKeyword());
        clone.setTargetresolution(getTargetresolution());
        clone.setSpatialLayer(getSpatialLayer());
        clone.setSpatialValues(getSpatialValues());
        clone.setStartDate(getStartDate());
        clone.setEndDate(getEndDate());
        clone.setPublicationDate(getPublicationDate());
        clone.setSectors_(getSectors_());
        clone.setElements_(getElements_());
        clone.setClimateimpacts_(getClimateimpacts_());
        clone.setRating(getRating());
        clone.setImportance(getImportance());
        clone.setSource(getSource());
        clone.setDeeplink(getDeeplink());
        clone.setControlstatus(getControlstatus());
        clone.setCreator(getCreator());
        clone.setCreationdate(getCreationdate());
        clone.setModerator(getModerator());
        clone.setApprovaldate(getApprovaldate());
        clone.setReplacesId(getReplacesId());
        clone.setComments(getComments());
        clone.setTextwebpage(getTextwebpage());
        clone.setYear(getYear());
        clone.setGeochars(getGeochars());
        clone.setFeature(getFeature());
        clone.setSupdocs(getSupdocs());
        clone.setAdmincomment(getAdmincomment());
        clone.setScenario(getScenario());
        clone.setTimeperiod(getTimeperiod());
        clone.setLockdate(getLockdate());
        clone.setMetaData(getMetaData());

        return clone;
    }

    @Override
    public int compareTo(AceItem aceItem) {
        int value = 0;

        value = getName().compareTo(aceItem.getName());

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

        if (!(obj instanceof AceItemClp)) {
            return false;
        }

        AceItemClp aceItem = (AceItemClp) obj;

        long primaryKey = aceItem.getPrimaryKey();

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
        StringBundler sb = new StringBundler(87);

        sb.append("{aceItemId=");
        sb.append(getAceItemId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", wxsharvesterId=");
        sb.append(getWxsharvesterId());
        sb.append(", cswharvesterId=");
        sb.append(getCswharvesterId());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", datatype=");
        sb.append(getDatatype());
        sb.append(", storedAt=");
        sb.append(getStoredAt());
        sb.append(", storagetype=");
        sb.append(getStoragetype());
        sb.append(", specialtagging=");
        sb.append(getSpecialtagging());
        sb.append(", textSearch=");
        sb.append(getTextSearch());
        sb.append(", keyword=");
        sb.append(getKeyword());
        sb.append(", targetresolution=");
        sb.append(getTargetresolution());
        sb.append(", spatialLayer=");
        sb.append(getSpatialLayer());
        sb.append(", spatialValues=");
        sb.append(getSpatialValues());
        sb.append(", startDate=");
        sb.append(getStartDate());
        sb.append(", endDate=");
        sb.append(getEndDate());
        sb.append(", publicationDate=");
        sb.append(getPublicationDate());
        sb.append(", sectors_=");
        sb.append(getSectors_());
        sb.append(", elements_=");
        sb.append(getElements_());
        sb.append(", climateimpacts_=");
        sb.append(getClimateimpacts_());
        sb.append(", rating=");
        sb.append(getRating());
        sb.append(", importance=");
        sb.append(getImportance());
        sb.append(", source=");
        sb.append(getSource());
        sb.append(", deeplink=");
        sb.append(getDeeplink());
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
        sb.append(", year=");
        sb.append(getYear());
        sb.append(", geochars=");
        sb.append(getGeochars());
        sb.append(", feature=");
        sb.append(getFeature());
        sb.append(", supdocs=");
        sb.append(getSupdocs());
        sb.append(", admincomment=");
        sb.append(getAdmincomment());
        sb.append(", scenario=");
        sb.append(getScenario());
        sb.append(", timeperiod=");
        sb.append(getTimeperiod());
        sb.append(", lockdate=");
        sb.append(getLockdate());
        sb.append(", metaData=");
        sb.append(getMetaData());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(133);

        sb.append("<model><model-name>");
        sb.append("nl.wur.alterra.cgi.ace.model.AceItem");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>aceItemId</column-name><column-value><![CDATA[");
        sb.append(getAceItemId());
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
            "<column><column-name>wxsharvesterId</column-name><column-value><![CDATA[");
        sb.append(getWxsharvesterId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>cswharvesterId</column-name><column-value><![CDATA[");
        sb.append(getCswharvesterId());
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
            "<column><column-name>datatype</column-name><column-value><![CDATA[");
        sb.append(getDatatype());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>storedAt</column-name><column-value><![CDATA[");
        sb.append(getStoredAt());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>storagetype</column-name><column-value><![CDATA[");
        sb.append(getStoragetype());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>specialtagging</column-name><column-value><![CDATA[");
        sb.append(getSpecialtagging());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>textSearch</column-name><column-value><![CDATA[");
        sb.append(getTextSearch());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>keyword</column-name><column-value><![CDATA[");
        sb.append(getKeyword());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>targetresolution</column-name><column-value><![CDATA[");
        sb.append(getTargetresolution());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>spatialLayer</column-name><column-value><![CDATA[");
        sb.append(getSpatialLayer());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>spatialValues</column-name><column-value><![CDATA[");
        sb.append(getSpatialValues());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>startDate</column-name><column-value><![CDATA[");
        sb.append(getStartDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>endDate</column-name><column-value><![CDATA[");
        sb.append(getEndDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>publicationDate</column-name><column-value><![CDATA[");
        sb.append(getPublicationDate());
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
            "<column><column-name>rating</column-name><column-value><![CDATA[");
        sb.append(getRating());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>importance</column-name><column-value><![CDATA[");
        sb.append(getImportance());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>source</column-name><column-value><![CDATA[");
        sb.append(getSource());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>deeplink</column-name><column-value><![CDATA[");
        sb.append(getDeeplink());
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
            "<column><column-name>year</column-name><column-value><![CDATA[");
        sb.append(getYear());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>geochars</column-name><column-value><![CDATA[");
        sb.append(getGeochars());
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
            "<column><column-name>admincomment</column-name><column-value><![CDATA[");
        sb.append(getAdmincomment());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>scenario</column-name><column-value><![CDATA[");
        sb.append(getScenario());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>timeperiod</column-name><column-value><![CDATA[");
        sb.append(getTimeperiod());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>lockdate</column-name><column-value><![CDATA[");
        sb.append(getLockdate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>metaData</column-name><column-value><![CDATA[");
        sb.append(getMetaData());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
