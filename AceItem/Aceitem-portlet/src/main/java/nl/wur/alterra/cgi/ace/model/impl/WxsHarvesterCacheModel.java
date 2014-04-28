package nl.wur.alterra.cgi.ace.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import nl.wur.alterra.cgi.ace.model.WxsHarvester;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing WxsHarvester in entity cache.
 *
 * @author groot052
 * @see WxsHarvester
 * @generated
 */
public class WxsHarvesterCacheModel implements CacheModel<WxsHarvester>,
    Externalizable {
    public long wxsharvesterid;
    public String name;
    public String url;
    public String ogctype;
    public int every;
    public String topic;
    public String status;
    public boolean savedToGeoNetwork;
    public long geonetworkId;
    public String geonetworkUUID;
    public long companyId;
    public long groupId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(25);

        sb.append("{wxsharvesterid=");
        sb.append(wxsharvesterid);
        sb.append(", name=");
        sb.append(name);
        sb.append(", url=");
        sb.append(url);
        sb.append(", ogctype=");
        sb.append(ogctype);
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
        sb.append("}");

        return sb.toString();
    }

    @Override
    public WxsHarvester toEntityModel() {
        WxsHarvesterImpl wxsHarvesterImpl = new WxsHarvesterImpl();

        wxsHarvesterImpl.setWxsharvesterid(wxsharvesterid);

        if (name == null) {
            wxsHarvesterImpl.setName(StringPool.BLANK);
        } else {
            wxsHarvesterImpl.setName(name);
        }

        if (url == null) {
            wxsHarvesterImpl.setUrl(StringPool.BLANK);
        } else {
            wxsHarvesterImpl.setUrl(url);
        }

        if (ogctype == null) {
            wxsHarvesterImpl.setOgctype(StringPool.BLANK);
        } else {
            wxsHarvesterImpl.setOgctype(ogctype);
        }

        wxsHarvesterImpl.setEvery(every);

        if (topic == null) {
            wxsHarvesterImpl.setTopic(StringPool.BLANK);
        } else {
            wxsHarvesterImpl.setTopic(topic);
        }

        if (status == null) {
            wxsHarvesterImpl.setStatus(StringPool.BLANK);
        } else {
            wxsHarvesterImpl.setStatus(status);
        }

        wxsHarvesterImpl.setSavedToGeoNetwork(savedToGeoNetwork);
        wxsHarvesterImpl.setGeonetworkId(geonetworkId);

        if (geonetworkUUID == null) {
            wxsHarvesterImpl.setGeonetworkUUID(StringPool.BLANK);
        } else {
            wxsHarvesterImpl.setGeonetworkUUID(geonetworkUUID);
        }

        wxsHarvesterImpl.setCompanyId(companyId);
        wxsHarvesterImpl.setGroupId(groupId);

        wxsHarvesterImpl.resetOriginalValues();

        return wxsHarvesterImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        wxsharvesterid = objectInput.readLong();
        name = objectInput.readUTF();
        url = objectInput.readUTF();
        ogctype = objectInput.readUTF();
        every = objectInput.readInt();
        topic = objectInput.readUTF();
        status = objectInput.readUTF();
        savedToGeoNetwork = objectInput.readBoolean();
        geonetworkId = objectInput.readLong();
        geonetworkUUID = objectInput.readUTF();
        companyId = objectInput.readLong();
        groupId = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(wxsharvesterid);

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

        if (ogctype == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(ogctype);
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
    }
}
