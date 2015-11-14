package nl.wur.alterra.cgi.ace.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import nl.wur.alterra.cgi.ace.model.AceItem;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AceItem in entity cache.
 *
 * @author groot052
 * @see AceItem
 * @generated
 */
public class AceItemCacheModel implements CacheModel<AceItem>, Externalizable {
    public long aceItemId;
    public long companyId;
    public long groupId;
    public long wxsharvesterId;
    public long cswharvesterId;
    public String name;
    public String description;
    public String datatype;
    public String storedAt;
    public String storagetype;
    public String specialtagging;
    public String textSearch;
    public String keyword;
    public String targetresolution;
    public String spatialLayer;
    public String spatialValues;
    public long startDate;
    public long endDate;
    public long publicationDate;
    public String sectors_;
    public String elements_;
    public String climateimpacts_;
    public long rating;
    public long importance;
    public String source;
    public String deeplink;
    public short controlstatus;
    public String creator;
    public long creationdate;
    public String moderator;
    public long approvaldate;
    public long replacesId;
    public String comments;
    public String textwebpage;
    public String year;
    public String geochars;
    public String feature;
    public String supdocs;
    public String admincomment;
    public String scenario;
    public String timeperiod;
    public long lockdate;
    public String metaData;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(87);

        sb.append("{aceItemId=");
        sb.append(aceItemId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", wxsharvesterId=");
        sb.append(wxsharvesterId);
        sb.append(", cswharvesterId=");
        sb.append(cswharvesterId);
        sb.append(", name=");
        sb.append(name);
        sb.append(", description=");
        sb.append(description);
        sb.append(", datatype=");
        sb.append(datatype);
        sb.append(", storedAt=");
        sb.append(storedAt);
        sb.append(", storagetype=");
        sb.append(storagetype);
        sb.append(", specialtagging=");
        sb.append(specialtagging);
        sb.append(", textSearch=");
        sb.append(textSearch);
        sb.append(", keyword=");
        sb.append(keyword);
        sb.append(", targetresolution=");
        sb.append(targetresolution);
        sb.append(", spatialLayer=");
        sb.append(spatialLayer);
        sb.append(", spatialValues=");
        sb.append(spatialValues);
        sb.append(", startDate=");
        sb.append(startDate);
        sb.append(", endDate=");
        sb.append(endDate);
        sb.append(", publicationDate=");
        sb.append(publicationDate);
        sb.append(", sectors_=");
        sb.append(sectors_);
        sb.append(", elements_=");
        sb.append(elements_);
        sb.append(", climateimpacts_=");
        sb.append(climateimpacts_);
        sb.append(", rating=");
        sb.append(rating);
        sb.append(", importance=");
        sb.append(importance);
        sb.append(", source=");
        sb.append(source);
        sb.append(", deeplink=");
        sb.append(deeplink);
        sb.append(", controlstatus=");
        sb.append(controlstatus);
        sb.append(", creator=");
        sb.append(creator);
        sb.append(", creationdate=");
        sb.append(creationdate);
        sb.append(", moderator=");
        sb.append(moderator);
        sb.append(", approvaldate=");
        sb.append(approvaldate);
        sb.append(", replacesId=");
        sb.append(replacesId);
        sb.append(", comments=");
        sb.append(comments);
        sb.append(", textwebpage=");
        sb.append(textwebpage);
        sb.append(", year=");
        sb.append(year);
        sb.append(", geochars=");
        sb.append(geochars);
        sb.append(", feature=");
        sb.append(feature);
        sb.append(", supdocs=");
        sb.append(supdocs);
        sb.append(", admincomment=");
        sb.append(admincomment);
        sb.append(", scenario=");
        sb.append(scenario);
        sb.append(", timeperiod=");
        sb.append(timeperiod);
        sb.append(", lockdate=");
        sb.append(lockdate);
        sb.append(", metaData=");
        sb.append(metaData);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public AceItem toEntityModel() {
        AceItemImpl aceItemImpl = new AceItemImpl();

        aceItemImpl.setAceItemId(aceItemId);
        aceItemImpl.setCompanyId(companyId);
        aceItemImpl.setGroupId(groupId);
        aceItemImpl.setWxsharvesterId(wxsharvesterId);
        aceItemImpl.setCswharvesterId(cswharvesterId);

        if (name == null) {
            aceItemImpl.setName(StringPool.BLANK);
        } else {
            aceItemImpl.setName(name);
        }

        if (description == null) {
            aceItemImpl.setDescription(StringPool.BLANK);
        } else {
            aceItemImpl.setDescription(description);
        }

        if (datatype == null) {
            aceItemImpl.setDatatype(StringPool.BLANK);
        } else {
            aceItemImpl.setDatatype(datatype);
        }

        if (storedAt == null) {
            aceItemImpl.setStoredAt(StringPool.BLANK);
        } else {
            aceItemImpl.setStoredAt(storedAt);
        }

        if (storagetype == null) {
            aceItemImpl.setStoragetype(StringPool.BLANK);
        } else {
            aceItemImpl.setStoragetype(storagetype);
        }

        if (specialtagging == null) {
            aceItemImpl.setSpecialtagging(StringPool.BLANK);
        } else {
            aceItemImpl.setSpecialtagging(specialtagging);
        }

        if (textSearch == null) {
            aceItemImpl.setTextSearch(StringPool.BLANK);
        } else {
            aceItemImpl.setTextSearch(textSearch);
        }

        if (keyword == null) {
            aceItemImpl.setKeyword(StringPool.BLANK);
        } else {
            aceItemImpl.setKeyword(keyword);
        }

        if (targetresolution == null) {
            aceItemImpl.setTargetresolution(StringPool.BLANK);
        } else {
            aceItemImpl.setTargetresolution(targetresolution);
        }

        if (spatialLayer == null) {
            aceItemImpl.setSpatialLayer(StringPool.BLANK);
        } else {
            aceItemImpl.setSpatialLayer(spatialLayer);
        }

        if (spatialValues == null) {
            aceItemImpl.setSpatialValues(StringPool.BLANK);
        } else {
            aceItemImpl.setSpatialValues(spatialValues);
        }

        if (startDate == Long.MIN_VALUE) {
            aceItemImpl.setStartDate(null);
        } else {
            aceItemImpl.setStartDate(new Date(startDate));
        }

        if (endDate == Long.MIN_VALUE) {
            aceItemImpl.setEndDate(null);
        } else {
            aceItemImpl.setEndDate(new Date(endDate));
        }

        if (publicationDate == Long.MIN_VALUE) {
            aceItemImpl.setPublicationDate(null);
        } else {
            aceItemImpl.setPublicationDate(new Date(publicationDate));
        }

        if (sectors_ == null) {
            aceItemImpl.setSectors_(StringPool.BLANK);
        } else {
            aceItemImpl.setSectors_(sectors_);
        }

        if (elements_ == null) {
            aceItemImpl.setElements_(StringPool.BLANK);
        } else {
            aceItemImpl.setElements_(elements_);
        }

        if (climateimpacts_ == null) {
            aceItemImpl.setClimateimpacts_(StringPool.BLANK);
        } else {
            aceItemImpl.setClimateimpacts_(climateimpacts_);
        }

        aceItemImpl.setRating(rating);
        aceItemImpl.setImportance(importance);

        if (source == null) {
            aceItemImpl.setSource(StringPool.BLANK);
        } else {
            aceItemImpl.setSource(source);
        }

        if (deeplink == null) {
            aceItemImpl.setDeeplink(StringPool.BLANK);
        } else {
            aceItemImpl.setDeeplink(deeplink);
        }

        aceItemImpl.setControlstatus(controlstatus);

        if (creator == null) {
            aceItemImpl.setCreator(StringPool.BLANK);
        } else {
            aceItemImpl.setCreator(creator);
        }

        if (creationdate == Long.MIN_VALUE) {
            aceItemImpl.setCreationdate(null);
        } else {
            aceItemImpl.setCreationdate(new Date(creationdate));
        }

        if (moderator == null) {
            aceItemImpl.setModerator(StringPool.BLANK);
        } else {
            aceItemImpl.setModerator(moderator);
        }

        if (approvaldate == Long.MIN_VALUE) {
            aceItemImpl.setApprovaldate(null);
        } else {
            aceItemImpl.setApprovaldate(new Date(approvaldate));
        }

        aceItemImpl.setReplacesId(replacesId);

        if (comments == null) {
            aceItemImpl.setComments(StringPool.BLANK);
        } else {
            aceItemImpl.setComments(comments);
        }

        if (textwebpage == null) {
            aceItemImpl.setTextwebpage(StringPool.BLANK);
        } else {
            aceItemImpl.setTextwebpage(textwebpage);
        }

        if (year == null) {
            aceItemImpl.setYear(StringPool.BLANK);
        } else {
            aceItemImpl.setYear(year);
        }

        if (geochars == null) {
            aceItemImpl.setGeochars(StringPool.BLANK);
        } else {
            aceItemImpl.setGeochars(geochars);
        }

        if (feature == null) {
            aceItemImpl.setFeature(StringPool.BLANK);
        } else {
            aceItemImpl.setFeature(feature);
        }

        if (supdocs == null) {
            aceItemImpl.setSupdocs(StringPool.BLANK);
        } else {
            aceItemImpl.setSupdocs(supdocs);
        }

        if (admincomment == null) {
            aceItemImpl.setAdmincomment(StringPool.BLANK);
        } else {
            aceItemImpl.setAdmincomment(admincomment);
        }

        if (scenario == null) {
            aceItemImpl.setScenario(StringPool.BLANK);
        } else {
            aceItemImpl.setScenario(scenario);
        }

        if (timeperiod == null) {
            aceItemImpl.setTimeperiod(StringPool.BLANK);
        } else {
            aceItemImpl.setTimeperiod(timeperiod);
        }

        if (lockdate == Long.MIN_VALUE) {
            aceItemImpl.setLockdate(null);
        } else {
            aceItemImpl.setLockdate(new Date(lockdate));
        }

        if (metaData == null) {
            aceItemImpl.setMetaData(StringPool.BLANK);
        } else {
            aceItemImpl.setMetaData(metaData);
        }

        aceItemImpl.resetOriginalValues();

        return aceItemImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        aceItemId = objectInput.readLong();
        companyId = objectInput.readLong();
        groupId = objectInput.readLong();
        wxsharvesterId = objectInput.readLong();
        cswharvesterId = objectInput.readLong();
        name = objectInput.readUTF();
        description = objectInput.readUTF();
        datatype = objectInput.readUTF();
        storedAt = objectInput.readUTF();
        storagetype = objectInput.readUTF();
        specialtagging = objectInput.readUTF();
        textSearch = objectInput.readUTF();
        keyword = objectInput.readUTF();
        targetresolution = objectInput.readUTF();
        spatialLayer = objectInput.readUTF();
        spatialValues = objectInput.readUTF();
        startDate = objectInput.readLong();
        endDate = objectInput.readLong();
        publicationDate = objectInput.readLong();
        sectors_ = objectInput.readUTF();
        elements_ = objectInput.readUTF();
        climateimpacts_ = objectInput.readUTF();
        rating = objectInput.readLong();
        importance = objectInput.readLong();
        source = objectInput.readUTF();
        deeplink = objectInput.readUTF();
        controlstatus = objectInput.readShort();
        creator = objectInput.readUTF();
        creationdate = objectInput.readLong();
        moderator = objectInput.readUTF();
        approvaldate = objectInput.readLong();
        replacesId = objectInput.readLong();
        comments = objectInput.readUTF();
        textwebpage = objectInput.readUTF();
        year = objectInput.readUTF();
        geochars = objectInput.readUTF();
        feature = objectInput.readUTF();
        supdocs = objectInput.readUTF();
        admincomment = objectInput.readUTF();
        scenario = objectInput.readUTF();
        timeperiod = objectInput.readUTF();
        lockdate = objectInput.readLong();
        metaData = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(aceItemId);
        objectOutput.writeLong(companyId);
        objectOutput.writeLong(groupId);
        objectOutput.writeLong(wxsharvesterId);
        objectOutput.writeLong(cswharvesterId);

        if (name == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(name);
        }

        if (description == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(description);
        }

        if (datatype == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(datatype);
        }

        if (storedAt == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(storedAt);
        }

        if (storagetype == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(storagetype);
        }

        if (specialtagging == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(specialtagging);
        }

        if (textSearch == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(textSearch);
        }

        if (keyword == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(keyword);
        }

        if (targetresolution == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(targetresolution);
        }

        if (spatialLayer == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(spatialLayer);
        }

        if (spatialValues == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(spatialValues);
        }

        objectOutput.writeLong(startDate);
        objectOutput.writeLong(endDate);
        objectOutput.writeLong(publicationDate);

        if (sectors_ == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(sectors_);
        }

        if (elements_ == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(elements_);
        }

        if (climateimpacts_ == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(climateimpacts_);
        }

        objectOutput.writeLong(rating);
        objectOutput.writeLong(importance);

        if (source == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(source);
        }

        if (deeplink == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(deeplink);
        }

        objectOutput.writeShort(controlstatus);

        if (creator == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(creator);
        }

        objectOutput.writeLong(creationdate);

        if (moderator == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(moderator);
        }

        objectOutput.writeLong(approvaldate);
        objectOutput.writeLong(replacesId);

        if (comments == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(comments);
        }

        if (textwebpage == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(textwebpage);
        }

        if (year == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(year);
        }

        if (geochars == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(geochars);
        }

        if (feature == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(feature);
        }

        if (supdocs == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(supdocs);
        }

        if (admincomment == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(admincomment);
        }

        if (scenario == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(scenario);
        }

        if (timeperiod == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(timeperiod);
        }

        objectOutput.writeLong(lockdate);

        if (metaData == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(metaData);
        }
    }
}
