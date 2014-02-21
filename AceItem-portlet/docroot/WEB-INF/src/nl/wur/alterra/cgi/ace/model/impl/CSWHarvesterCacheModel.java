package nl.wur.alterra.cgi.ace.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import nl.wur.alterra.cgi.ace.model.CSWHarvester;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing CSWHarvester in entity cache.
 *
 * @author groot052
 * @see CSWHarvester
 * @generated
 */
public class CSWHarvesterCacheModel implements CacheModel<CSWHarvester>,
    Externalizable {
    public long cswharvesterid;
    public String name;
    public String url;
    public String freetext;
    public String title;
    public String abstrakt;
    public String subject;
    public int every;
    public String topic;
    public String status;
    public boolean savedToGeoNetwork;
    public long geonetworkId;
    public String geonetworkUUID;
    public long companyId;
    public long groupId;
    public String type;
    public String username;
    public String password;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(37);

        sb.append("{cswharvesterid=");
        sb.append(cswharvesterid);
        sb.append(", name=");
        sb.append(name);
        sb.append(", url=");
        sb.append(url);
        sb.append(", freetext=");
        sb.append(freetext);
        sb.append(", title=");
        sb.append(title);
        sb.append(", abstrakt=");
        sb.append(abstrakt);
        sb.append(", subject=");
        sb.append(subject);
        sb.append(", every=");
        sb.append(every);
        sb.append(", topic=");
        sb.append(topic);
        sb.append(", status=");
        sb.append(status);
        sb.append(", savedToGeoNetwork=");
        sb.append(savedToGeoNetwork);
        sb.append(", geonetworkId=");
        sb.append(geonetworkId);
        sb.append(", geonetworkUUID=");
        sb.append(geonetworkUUID);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", type=");
        sb.append(type);
        sb.append(", username=");
        sb.append(username);
        sb.append(", password=");
        sb.append(password);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public CSWHarvester toEntityModel() {
        CSWHarvesterImpl cswHarvesterImpl = new CSWHarvesterImpl();

        cswHarvesterImpl.setCswharvesterid(cswharvesterid);

        if (name == null) {
            cswHarvesterImpl.setName(StringPool.BLANK);
        } else {
            cswHarvesterImpl.setName(name);
        }

        if (url == null) {
            cswHarvesterImpl.setUrl(StringPool.BLANK);
        } else {
            cswHarvesterImpl.setUrl(url);
        }

        if (freetext == null) {
            cswHarvesterImpl.setFreetext(StringPool.BLANK);
        } else {
            cswHarvesterImpl.setFreetext(freetext);
        }

        if (title == null) {
            cswHarvesterImpl.setTitle(StringPool.BLANK);
        } else {
            cswHarvesterImpl.setTitle(title);
        }

        if (abstrakt == null) {
            cswHarvesterImpl.setAbstrakt(StringPool.BLANK);
        } else {
            cswHarvesterImpl.setAbstrakt(abstrakt);
        }

        if (subject == null) {
            cswHarvesterImpl.setSubject(StringPool.BLANK);
        } else {
            cswHarvesterImpl.setSubject(subject);
        }

        cswHarvesterImpl.setEvery(every);

        if (topic == null) {
            cswHarvesterImpl.setTopic(StringPool.BLANK);
        } else {
            cswHarvesterImpl.setTopic(topic);
        }

        if (status == null) {
            cswHarvesterImpl.setStatus(StringPool.BLANK);
        } else {
            cswHarvesterImpl.setStatus(status);
        }

        cswHarvesterImpl.setSavedToGeoNetwork(savedToGeoNetwork);
        cswHarvesterImpl.setGeonetworkId(geonetworkId);

        if (geonetworkUUID == null) {
            cswHarvesterImpl.setGeonetworkUUID(StringPool.BLANK);
        } else {
            cswHarvesterImpl.setGeonetworkUUID(geonetworkUUID);
        }

        cswHarvesterImpl.setCompanyId(companyId);
        cswHarvesterImpl.setGroupId(groupId);

        if (type == null) {
            cswHarvesterImpl.setType(StringPool.BLANK);
        } else {
            cswHarvesterImpl.setType(type);
        }

        if (username == null) {
            cswHarvesterImpl.setUsername(StringPool.BLANK);
        } else {
            cswHarvesterImpl.setUsername(username);
        }

        if (password == null) {
            cswHarvesterImpl.setPassword(StringPool.BLANK);
        } else {
            cswHarvesterImpl.setPassword(password);
        }

        cswHarvesterImpl.resetOriginalValues();

        return cswHarvesterImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        cswharvesterid = objectInput.readLong();
        name = objectInput.readUTF();
        url = objectInput.readUTF();
        freetext = objectInput.readUTF();
        title = objectInput.readUTF();
        abstrakt = objectInput.readUTF();
        subject = objectInput.readUTF();
        every = objectInput.readInt();
        topic = objectInput.readUTF();
        status = objectInput.readUTF();
        savedToGeoNetwork = objectInput.readBoolean();
        geonetworkId = objectInput.readLong();
        geonetworkUUID = objectInput.readUTF();
        companyId = objectInput.readLong();
        groupId = objectInput.readLong();
        type = objectInput.readUTF();
        username = objectInput.readUTF();
        password = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(cswharvesterid);

        if (name == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(name);
        }

        if (url == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(url);
        }

        if (freetext == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(freetext);
        }

        if (title == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(title);
        }

        if (abstrakt == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(abstrakt);
        }

        if (subject == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(subject);
        }

        objectOutput.writeInt(every);

        if (topic == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(topic);
        }

        if (status == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(status);
        }

        objectOutput.writeBoolean(savedToGeoNetwork);
        objectOutput.writeLong(geonetworkId);

        if (geonetworkUUID == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(geonetworkUUID);
        }

        objectOutput.writeLong(companyId);
        objectOutput.writeLong(groupId);

        if (type == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(type);
        }

        if (username == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(username);
        }

        if (password == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(password);
        }
    }
}
