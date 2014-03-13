package nl.wur.alterra.cgi.ace.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import nl.wur.alterra.cgi.ace.model.Project;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Project in entity cache.
 *
 * @author Groot052
 * @see Project
 * @generated
 */
public class ProjectCacheModel implements CacheModel<Project>, Externalizable {
    public long projectId;
    public long companyId;
    public long groupId;
    public String admincomment;
    public String acronym;
    public String title;
    public long startdate;
    public long enddate;
    public String lead;
    public String partners;
    public String funding;
    public String sectors;
    public String spatiallayer;
    public String abstracts;
    public String element;
    public String keywords;
    public String website;
    public String duration;
    public long rating;
    public long importance;
    public String specialtagging;
    public short controlstatus;
    public String creator;
    public long creationdate;
    public String moderator;
    public long approvaldate;
    public long replacesId;
    public String comments;
    public String textwebpage;
    public String spatialvalues;
    public String source;
    public String climateimpacts;
    public long lockdate;
    public String feature;
    public String supdocs;
    public String geochars;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(73);

        sb.append("{projectId=");
        sb.append(projectId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", admincomment=");
        sb.append(admincomment);
        sb.append(", acronym=");
        sb.append(acronym);
        sb.append(", title=");
        sb.append(title);
        sb.append(", startdate=");
        sb.append(startdate);
        sb.append(", enddate=");
        sb.append(enddate);
        sb.append(", lead=");
        sb.append(lead);
        sb.append(", partners=");
        sb.append(partners);
        sb.append(", funding=");
        sb.append(funding);
        sb.append(", sectors=");
        sb.append(sectors);
        sb.append(", spatiallayer=");
        sb.append(spatiallayer);
        sb.append(", abstracts=");
        sb.append(abstracts);
        sb.append(", element=");
        sb.append(element);
        sb.append(", keywords=");
        sb.append(keywords);
        sb.append(", website=");
        sb.append(website);
        sb.append(", duration=");
        sb.append(duration);
        sb.append(", rating=");
        sb.append(rating);
        sb.append(", importance=");
        sb.append(importance);
        sb.append(", specialtagging=");
        sb.append(specialtagging);
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
        sb.append(", spatialvalues=");
        sb.append(spatialvalues);
        sb.append(", source=");
        sb.append(source);
        sb.append(", climateimpacts=");
        sb.append(climateimpacts);
        sb.append(", lockdate=");
        sb.append(lockdate);
        sb.append(", feature=");
        sb.append(feature);
        sb.append(", supdocs=");
        sb.append(supdocs);
        sb.append(", geochars=");
        sb.append(geochars);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Project toEntityModel() {
        ProjectImpl projectImpl = new ProjectImpl();

        projectImpl.setProjectId(projectId);
        projectImpl.setCompanyId(companyId);
        projectImpl.setGroupId(groupId);

        if (admincomment == null) {
            projectImpl.setAdmincomment(StringPool.BLANK);
        } else {
            projectImpl.setAdmincomment(admincomment);
        }

        if (acronym == null) {
            projectImpl.setAcronym(StringPool.BLANK);
        } else {
            projectImpl.setAcronym(acronym);
        }

        if (title == null) {
            projectImpl.setTitle(StringPool.BLANK);
        } else {
            projectImpl.setTitle(title);
        }

        if (startdate == Long.MIN_VALUE) {
            projectImpl.setStartdate(null);
        } else {
            projectImpl.setStartdate(new Date(startdate));
        }

        if (enddate == Long.MIN_VALUE) {
            projectImpl.setEnddate(null);
        } else {
            projectImpl.setEnddate(new Date(enddate));
        }

        if (lead == null) {
            projectImpl.setLead(StringPool.BLANK);
        } else {
            projectImpl.setLead(lead);
        }

        if (partners == null) {
            projectImpl.setPartners(StringPool.BLANK);
        } else {
            projectImpl.setPartners(partners);
        }

        if (funding == null) {
            projectImpl.setFunding(StringPool.BLANK);
        } else {
            projectImpl.setFunding(funding);
        }

        if (sectors == null) {
            projectImpl.setSectors(StringPool.BLANK);
        } else {
            projectImpl.setSectors(sectors);
        }

        if (spatiallayer == null) {
            projectImpl.setSpatiallayer(StringPool.BLANK);
        } else {
            projectImpl.setSpatiallayer(spatiallayer);
        }

        if (abstracts == null) {
            projectImpl.setAbstracts(StringPool.BLANK);
        } else {
            projectImpl.setAbstracts(abstracts);
        }

        if (element == null) {
            projectImpl.setElement(StringPool.BLANK);
        } else {
            projectImpl.setElement(element);
        }

        if (keywords == null) {
            projectImpl.setKeywords(StringPool.BLANK);
        } else {
            projectImpl.setKeywords(keywords);
        }

        if (website == null) {
            projectImpl.setWebsite(StringPool.BLANK);
        } else {
            projectImpl.setWebsite(website);
        }

        if (duration == null) {
            projectImpl.setDuration(StringPool.BLANK);
        } else {
            projectImpl.setDuration(duration);
        }

        projectImpl.setRating(rating);
        projectImpl.setImportance(importance);

        if (specialtagging == null) {
            projectImpl.setSpecialtagging(StringPool.BLANK);
        } else {
            projectImpl.setSpecialtagging(specialtagging);
        }

        projectImpl.setControlstatus(controlstatus);

        if (creator == null) {
            projectImpl.setCreator(StringPool.BLANK);
        } else {
            projectImpl.setCreator(creator);
        }

        if (creationdate == Long.MIN_VALUE) {
            projectImpl.setCreationdate(null);
        } else {
            projectImpl.setCreationdate(new Date(creationdate));
        }

        if (moderator == null) {
            projectImpl.setModerator(StringPool.BLANK);
        } else {
            projectImpl.setModerator(moderator);
        }

        if (approvaldate == Long.MIN_VALUE) {
            projectImpl.setApprovaldate(null);
        } else {
            projectImpl.setApprovaldate(new Date(approvaldate));
        }

        projectImpl.setReplacesId(replacesId);

        if (comments == null) {
            projectImpl.setComments(StringPool.BLANK);
        } else {
            projectImpl.setComments(comments);
        }

        if (textwebpage == null) {
            projectImpl.setTextwebpage(StringPool.BLANK);
        } else {
            projectImpl.setTextwebpage(textwebpage);
        }

        if (spatialvalues == null) {
            projectImpl.setSpatialvalues(StringPool.BLANK);
        } else {
            projectImpl.setSpatialvalues(spatialvalues);
        }

        if (source == null) {
            projectImpl.setSource(StringPool.BLANK);
        } else {
            projectImpl.setSource(source);
        }

        if (climateimpacts == null) {
            projectImpl.setClimateimpacts(StringPool.BLANK);
        } else {
            projectImpl.setClimateimpacts(climateimpacts);
        }

        if (lockdate == Long.MIN_VALUE) {
            projectImpl.setLockdate(null);
        } else {
            projectImpl.setLockdate(new Date(lockdate));
        }

        if (feature == null) {
            projectImpl.setFeature(StringPool.BLANK);
        } else {
            projectImpl.setFeature(feature);
        }

        if (supdocs == null) {
            projectImpl.setSupdocs(StringPool.BLANK);
        } else {
            projectImpl.setSupdocs(supdocs);
        }

        if (geochars == null) {
            projectImpl.setGeochars(StringPool.BLANK);
        } else {
            projectImpl.setGeochars(geochars);
        }

        projectImpl.resetOriginalValues();

        return projectImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        projectId = objectInput.readLong();
        companyId = objectInput.readLong();
        groupId = objectInput.readLong();
        admincomment = objectInput.readUTF();
        acronym = objectInput.readUTF();
        title = objectInput.readUTF();
        startdate = objectInput.readLong();
        enddate = objectInput.readLong();
        lead = objectInput.readUTF();
        partners = objectInput.readUTF();
        funding = objectInput.readUTF();
        sectors = objectInput.readUTF();
        spatiallayer = objectInput.readUTF();
        abstracts = objectInput.readUTF();
        element = objectInput.readUTF();
        keywords = objectInput.readUTF();
        website = objectInput.readUTF();
        duration = objectInput.readUTF();
        rating = objectInput.readLong();
        importance = objectInput.readLong();
        specialtagging = objectInput.readUTF();
        controlstatus = objectInput.readShort();
        creator = objectInput.readUTF();
        creationdate = objectInput.readLong();
        moderator = objectInput.readUTF();
        approvaldate = objectInput.readLong();
        replacesId = objectInput.readLong();
        comments = objectInput.readUTF();
        textwebpage = objectInput.readUTF();
        spatialvalues = objectInput.readUTF();
        source = objectInput.readUTF();
        climateimpacts = objectInput.readUTF();
        lockdate = objectInput.readLong();
        feature = objectInput.readUTF();
        supdocs = objectInput.readUTF();
        geochars = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(projectId);
        objectOutput.writeLong(companyId);
        objectOutput.writeLong(groupId);

        if (admincomment == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(admincomment);
        }

        if (acronym == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(acronym);
        }

        if (title == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(title);
        }

        objectOutput.writeLong(startdate);
        objectOutput.writeLong(enddate);

        if (lead == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(lead);
        }

        if (partners == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(partners);
        }

        if (funding == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(funding);
        }

        if (sectors == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(sectors);
        }

        if (spatiallayer == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(spatiallayer);
        }

        if (abstracts == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(abstracts);
        }

        if (element == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(element);
        }

        if (keywords == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(keywords);
        }

        if (website == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(website);
        }

        if (duration == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(duration);
        }

        objectOutput.writeLong(rating);
        objectOutput.writeLong(importance);

        if (specialtagging == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(specialtagging);
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

        if (spatialvalues == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(spatialvalues);
        }

        if (source == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(source);
        }

        if (climateimpacts == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(climateimpacts);
        }

        objectOutput.writeLong(lockdate);

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

        if (geochars == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(geochars);
        }
    }
}
