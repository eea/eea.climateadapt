package nl.wur.alterra.cgi.ace.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import nl.wur.alterra.cgi.ace.model.Measure;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Measure in entity cache.
 *
 * @author groot052
 * @see Measure
 * @generated
 */
public class MeasureCacheModel implements CacheModel<Measure>, Externalizable {
    public long measureId;
    public long companyId;
    public long groupId;
    public String admincomment;
    public String casestudyfeature;
    public String name;
    public String description;
    public String implementationtype;
    public String implementationtime;
    public String lifetime;
    public String spatiallayer;
    public String spatialvalues;
    public String legalaspects;
    public String stakeholderparticipation;
    public String contact;
    public String objectives;
    public String challenges;
    public String adaptationoptions;
    public String solutions;
    public String relevance;
    public String succeslimitations;
    public String website;
    public String costbenefit;
    public String keywords;
    public String geos_;
    public long startdate;
    public long enddate;
    public long publicationdate;
    public String specialtagging;
    public String sectors_;
    public String elements_;
    public String climateimpacts_;
    public String mao_type;
    public String source;
    public long rating;
    public long importance;
    public double lon;
    public double lat;
    public String satarea;
    public short controlstatus;
    public String creator;
    public long creationdate;
    public String moderator;
    public long approvaldate;
    public long replacesId;
    public String comments;
    public String textwebpage;
    public String primephoto;
    public String supphotos;
    public String supdocs;
    public String year;
    public String geochars;
    public String category;
    public long lockdate;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(109);

        sb.append("{measureId=");
        sb.append(measureId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", admincomment=");
        sb.append(admincomment);
        sb.append(", casestudyfeature=");
        sb.append(casestudyfeature);
        sb.append(", name=");
        sb.append(name);
        sb.append(", description=");
        sb.append(description);
        sb.append(", implementationtype=");
        sb.append(implementationtype);
        sb.append(", implementationtime=");
        sb.append(implementationtime);
        sb.append(", lifetime=");
        sb.append(lifetime);
        sb.append(", spatiallayer=");
        sb.append(spatiallayer);
        sb.append(", spatialvalues=");
        sb.append(spatialvalues);
        sb.append(", legalaspects=");
        sb.append(legalaspects);
        sb.append(", stakeholderparticipation=");
        sb.append(stakeholderparticipation);
        sb.append(", contact=");
        sb.append(contact);
        sb.append(", objectives=");
        sb.append(objectives);
        sb.append(", challenges=");
        sb.append(challenges);
        sb.append(", adaptationoptions=");
        sb.append(adaptationoptions);
        sb.append(", solutions=");
        sb.append(solutions);
        sb.append(", relevance=");
        sb.append(relevance);
        sb.append(", succeslimitations=");
        sb.append(succeslimitations);
        sb.append(", website=");
        sb.append(website);
        sb.append(", costbenefit=");
        sb.append(costbenefit);
        sb.append(", keywords=");
        sb.append(keywords);
        sb.append(", geos_=");
        sb.append(geos_);
        sb.append(", startdate=");
        sb.append(startdate);
        sb.append(", enddate=");
        sb.append(enddate);
        sb.append(", publicationdate=");
        sb.append(publicationdate);
        sb.append(", specialtagging=");
        sb.append(specialtagging);
        sb.append(", sectors_=");
        sb.append(sectors_);
        sb.append(", elements_=");
        sb.append(elements_);
        sb.append(", climateimpacts_=");
        sb.append(climateimpacts_);
        sb.append(", mao_type=");
        sb.append(mao_type);
        sb.append(", source=");
        sb.append(source);
        sb.append(", rating=");
        sb.append(rating);
        sb.append(", importance=");
        sb.append(importance);
        sb.append(", lon=");
        sb.append(lon);
        sb.append(", lat=");
        sb.append(lat);
        sb.append(", satarea=");
        sb.append(satarea);
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
        sb.append(", primephoto=");
        sb.append(primephoto);
        sb.append(", supphotos=");
        sb.append(supphotos);
        sb.append(", supdocs=");
        sb.append(supdocs);
        sb.append(", year=");
        sb.append(year);
        sb.append(", geochars=");
        sb.append(geochars);
        sb.append(", category=");
        sb.append(category);
        sb.append(", lockdate=");
        sb.append(lockdate);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Measure toEntityModel() {
        MeasureImpl measureImpl = new MeasureImpl();

        measureImpl.setMeasureId(measureId);
        measureImpl.setCompanyId(companyId);
        measureImpl.setGroupId(groupId);

        if (admincomment == null) {
            measureImpl.setAdmincomment(StringPool.BLANK);
        } else {
            measureImpl.setAdmincomment(admincomment);
        }

        if (casestudyfeature == null) {
            measureImpl.setCasestudyfeature(StringPool.BLANK);
        } else {
            measureImpl.setCasestudyfeature(casestudyfeature);
        }

        if (name == null) {
            measureImpl.setName(StringPool.BLANK);
        } else {
            measureImpl.setName(name);
        }

        if (description == null) {
            measureImpl.setDescription(StringPool.BLANK);
        } else {
            measureImpl.setDescription(description);
        }

        if (implementationtype == null) {
            measureImpl.setImplementationtype(StringPool.BLANK);
        } else {
            measureImpl.setImplementationtype(implementationtype);
        }

        if (implementationtime == null) {
            measureImpl.setImplementationtime(StringPool.BLANK);
        } else {
            measureImpl.setImplementationtime(implementationtime);
        }

        if (lifetime == null) {
            measureImpl.setLifetime(StringPool.BLANK);
        } else {
            measureImpl.setLifetime(lifetime);
        }

        if (spatiallayer == null) {
            measureImpl.setSpatiallayer(StringPool.BLANK);
        } else {
            measureImpl.setSpatiallayer(spatiallayer);
        }

        if (spatialvalues == null) {
            measureImpl.setSpatialvalues(StringPool.BLANK);
        } else {
            measureImpl.setSpatialvalues(spatialvalues);
        }

        if (legalaspects == null) {
            measureImpl.setLegalaspects(StringPool.BLANK);
        } else {
            measureImpl.setLegalaspects(legalaspects);
        }

        if (stakeholderparticipation == null) {
            measureImpl.setStakeholderparticipation(StringPool.BLANK);
        } else {
            measureImpl.setStakeholderparticipation(stakeholderparticipation);
        }

        if (contact == null) {
            measureImpl.setContact(StringPool.BLANK);
        } else {
            measureImpl.setContact(contact);
        }

        if (objectives == null) {
            measureImpl.setObjectives(StringPool.BLANK);
        } else {
            measureImpl.setObjectives(objectives);
        }

        if (challenges == null) {
            measureImpl.setChallenges(StringPool.BLANK);
        } else {
            measureImpl.setChallenges(challenges);
        }

        if (adaptationoptions == null) {
            measureImpl.setAdaptationoptions(StringPool.BLANK);
        } else {
            measureImpl.setAdaptationoptions(adaptationoptions);
        }

        if (solutions == null) {
            measureImpl.setSolutions(StringPool.BLANK);
        } else {
            measureImpl.setSolutions(solutions);
        }

        if (relevance == null) {
            measureImpl.setRelevance(StringPool.BLANK);
        } else {
            measureImpl.setRelevance(relevance);
        }

        if (succeslimitations == null) {
            measureImpl.setSucceslimitations(StringPool.BLANK);
        } else {
            measureImpl.setSucceslimitations(succeslimitations);
        }

        if (website == null) {
            measureImpl.setWebsite(StringPool.BLANK);
        } else {
            measureImpl.setWebsite(website);
        }

        if (costbenefit == null) {
            measureImpl.setCostbenefit(StringPool.BLANK);
        } else {
            measureImpl.setCostbenefit(costbenefit);
        }

        if (keywords == null) {
            measureImpl.setKeywords(StringPool.BLANK);
        } else {
            measureImpl.setKeywords(keywords);
        }

        if (geos_ == null) {
            measureImpl.setGeos_(StringPool.BLANK);
        } else {
            measureImpl.setGeos_(geos_);
        }

        if (startdate == Long.MIN_VALUE) {
            measureImpl.setStartdate(null);
        } else {
            measureImpl.setStartdate(new Date(startdate));
        }

        if (enddate == Long.MIN_VALUE) {
            measureImpl.setEnddate(null);
        } else {
            measureImpl.setEnddate(new Date(enddate));
        }

        if (publicationdate == Long.MIN_VALUE) {
            measureImpl.setPublicationdate(null);
        } else {
            measureImpl.setPublicationdate(new Date(publicationdate));
        }

        if (specialtagging == null) {
            measureImpl.setSpecialtagging(StringPool.BLANK);
        } else {
            measureImpl.setSpecialtagging(specialtagging);
        }

        if (sectors_ == null) {
            measureImpl.setSectors_(StringPool.BLANK);
        } else {
            measureImpl.setSectors_(sectors_);
        }

        if (elements_ == null) {
            measureImpl.setElements_(StringPool.BLANK);
        } else {
            measureImpl.setElements_(elements_);
        }

        if (climateimpacts_ == null) {
            measureImpl.setClimateimpacts_(StringPool.BLANK);
        } else {
            measureImpl.setClimateimpacts_(climateimpacts_);
        }

        if (mao_type == null) {
            measureImpl.setMao_type(StringPool.BLANK);
        } else {
            measureImpl.setMao_type(mao_type);
        }

        if (source == null) {
            measureImpl.setSource(StringPool.BLANK);
        } else {
            measureImpl.setSource(source);
        }

        measureImpl.setRating(rating);
        measureImpl.setImportance(importance);
        measureImpl.setLon(lon);
        measureImpl.setLat(lat);

        if (satarea == null) {
            measureImpl.setSatarea(StringPool.BLANK);
        } else {
            measureImpl.setSatarea(satarea);
        }

        measureImpl.setControlstatus(controlstatus);

        if (creator == null) {
            measureImpl.setCreator(StringPool.BLANK);
        } else {
            measureImpl.setCreator(creator);
        }

        if (creationdate == Long.MIN_VALUE) {
            measureImpl.setCreationdate(null);
        } else {
            measureImpl.setCreationdate(new Date(creationdate));
        }

        if (moderator == null) {
            measureImpl.setModerator(StringPool.BLANK);
        } else {
            measureImpl.setModerator(moderator);
        }

        if (approvaldate == Long.MIN_VALUE) {
            measureImpl.setApprovaldate(null);
        } else {
            measureImpl.setApprovaldate(new Date(approvaldate));
        }

        measureImpl.setReplacesId(replacesId);

        if (comments == null) {
            measureImpl.setComments(StringPool.BLANK);
        } else {
            measureImpl.setComments(comments);
        }

        if (textwebpage == null) {
            measureImpl.setTextwebpage(StringPool.BLANK);
        } else {
            measureImpl.setTextwebpage(textwebpage);
        }

        if (primephoto == null) {
            measureImpl.setPrimephoto(StringPool.BLANK);
        } else {
            measureImpl.setPrimephoto(primephoto);
        }

        if (supphotos == null) {
            measureImpl.setSupphotos(StringPool.BLANK);
        } else {
            measureImpl.setSupphotos(supphotos);
        }

        if (supdocs == null) {
            measureImpl.setSupdocs(StringPool.BLANK);
        } else {
            measureImpl.setSupdocs(supdocs);
        }

        if (year == null) {
            measureImpl.setYear(StringPool.BLANK);
        } else {
            measureImpl.setYear(year);
        }

        if (geochars == null) {
            measureImpl.setGeochars(StringPool.BLANK);
        } else {
            measureImpl.setGeochars(geochars);
        }

        if (category == null) {
            measureImpl.setCategory(StringPool.BLANK);
        } else {
            measureImpl.setCategory(category);
        }

        if (lockdate == Long.MIN_VALUE) {
            measureImpl.setLockdate(null);
        } else {
            measureImpl.setLockdate(new Date(lockdate));
        }

        measureImpl.resetOriginalValues();

        return measureImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        measureId = objectInput.readLong();
        companyId = objectInput.readLong();
        groupId = objectInput.readLong();
        admincomment = objectInput.readUTF();
        casestudyfeature = objectInput.readUTF();
        name = objectInput.readUTF();
        description = objectInput.readUTF();
        implementationtype = objectInput.readUTF();
        implementationtime = objectInput.readUTF();
        lifetime = objectInput.readUTF();
        spatiallayer = objectInput.readUTF();
        spatialvalues = objectInput.readUTF();
        legalaspects = objectInput.readUTF();
        stakeholderparticipation = objectInput.readUTF();
        contact = objectInput.readUTF();
        objectives = objectInput.readUTF();
        challenges = objectInput.readUTF();
        adaptationoptions = objectInput.readUTF();
        solutions = objectInput.readUTF();
        relevance = objectInput.readUTF();
        succeslimitations = objectInput.readUTF();
        website = objectInput.readUTF();
        costbenefit = objectInput.readUTF();
        keywords = objectInput.readUTF();
        geos_ = objectInput.readUTF();
        startdate = objectInput.readLong();
        enddate = objectInput.readLong();
        publicationdate = objectInput.readLong();
        specialtagging = objectInput.readUTF();
        sectors_ = objectInput.readUTF();
        elements_ = objectInput.readUTF();
        climateimpacts_ = objectInput.readUTF();
        mao_type = objectInput.readUTF();
        source = objectInput.readUTF();
        rating = objectInput.readLong();
        importance = objectInput.readLong();
        lon = objectInput.readDouble();
        lat = objectInput.readDouble();
        satarea = objectInput.readUTF();
        controlstatus = objectInput.readShort();
        creator = objectInput.readUTF();
        creationdate = objectInput.readLong();
        moderator = objectInput.readUTF();
        approvaldate = objectInput.readLong();
        replacesId = objectInput.readLong();
        comments = objectInput.readUTF();
        textwebpage = objectInput.readUTF();
        primephoto = objectInput.readUTF();
        supphotos = objectInput.readUTF();
        supdocs = objectInput.readUTF();
        year = objectInput.readUTF();
        geochars = objectInput.readUTF();
        category = objectInput.readUTF();
        lockdate = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(measureId);
        objectOutput.writeLong(companyId);
        objectOutput.writeLong(groupId);

        if (admincomment == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(admincomment);
        }

        if (casestudyfeature == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(casestudyfeature);
        }

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

        if (implementationtype == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(implementationtype);
        }

        if (implementationtime == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(implementationtime);
        }

        if (lifetime == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(lifetime);
        }

        if (spatiallayer == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(spatiallayer);
        }

        if (spatialvalues == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(spatialvalues);
        }

        if (legalaspects == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(legalaspects);
        }

        if (stakeholderparticipation == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(stakeholderparticipation);
        }

        if (contact == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(contact);
        }

        if (objectives == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(objectives);
        }

        if (challenges == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(challenges);
        }

        if (adaptationoptions == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(adaptationoptions);
        }

        if (solutions == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(solutions);
        }

        if (relevance == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(relevance);
        }

        if (succeslimitations == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(succeslimitations);
        }

        if (website == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(website);
        }

        if (costbenefit == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(costbenefit);
        }

        if (keywords == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(keywords);
        }

        if (geos_ == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(geos_);
        }

        objectOutput.writeLong(startdate);
        objectOutput.writeLong(enddate);
        objectOutput.writeLong(publicationdate);

        if (specialtagging == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(specialtagging);
        }

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

        if (mao_type == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(mao_type);
        }

        if (source == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(source);
        }

        objectOutput.writeLong(rating);
        objectOutput.writeLong(importance);
        objectOutput.writeDouble(lon);
        objectOutput.writeDouble(lat);

        if (satarea == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(satarea);
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

        if (primephoto == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(primephoto);
        }

        if (supphotos == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(supphotos);
        }

        if (supdocs == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(supdocs);
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

        if (category == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(category);
        }

        objectOutput.writeLong(lockdate);
    }
}
