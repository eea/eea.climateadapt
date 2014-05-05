package nl.wur.alterra.cgi.ace.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import nl.wur.alterra.cgi.ace.model.CSWHarvester;
import nl.wur.alterra.cgi.ace.model.CSWHarvesterModel;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

/**
 * The base model implementation for the CSWHarvester service. Represents a row in the &quot;Ace_CSWHarvester&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link nl.wur.alterra.cgi.ace.model.CSWHarvesterModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CSWHarvesterImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this class directly. All methods that expect a c s w harvester model instance should use the {@link nl.wur.alterra.cgi.ace.model.CSWHarvester} interface instead.
 * </p>
 *
 * @author groot052
 * @see CSWHarvesterImpl
 * @see nl.wur.alterra.cgi.ace.model.CSWHarvester
 * @see nl.wur.alterra.cgi.ace.model.CSWHarvesterModel
 * @generated
 */
public class CSWHarvesterModelImpl extends BaseModelImpl<CSWHarvester>
    implements CSWHarvesterModel {
    public static final String TABLE_NAME = "Ace_CSWHarvester";
    public static final Object[][] TABLE_COLUMNS = {
            { "cswharvesterid", new Integer(Types.BIGINT) },
            { "name", new Integer(Types.VARCHAR) },
            { "url", new Integer(Types.VARCHAR) },
            { "freetext", new Integer(Types.VARCHAR) },
            { "title", new Integer(Types.VARCHAR) },
            { "abstrakt", new Integer(Types.VARCHAR) },
            { "subject", new Integer(Types.VARCHAR) },
            { "every", new Integer(Types.INTEGER) },
            { "topic", new Integer(Types.VARCHAR) },
            { "status", new Integer(Types.VARCHAR) },
            { "savedToGeoNetwork", new Integer(Types.BOOLEAN) },
            { "geonetworkId", new Integer(Types.BIGINT) },
            { "geonetworkUUID", new Integer(Types.VARCHAR) },
            { "companyId", new Integer(Types.BIGINT) },
            { "groupId", new Integer(Types.BIGINT) },
            { "type_", new Integer(Types.VARCHAR) },
            { "username", new Integer(Types.VARCHAR) },
            { "password_", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table Ace_CSWHarvester (cswharvesterid LONG not null primary key,name VARCHAR(75) null,url VARCHAR(75) null,freetext VARCHAR(75) null,title VARCHAR(75) null,abstrakt VARCHAR(75) null,subject VARCHAR(75) null,every INTEGER,topic VARCHAR(75) null,status VARCHAR(75) null,savedToGeoNetwork BOOLEAN,geonetworkId LONG,geonetworkUUID VARCHAR(75) null,companyId LONG,groupId LONG,type_ VARCHAR(75) null,username VARCHAR(75) null,password_ VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table Ace_CSWHarvester";
    public static final String ORDER_BY_JPQL = " ORDER BY cswHarvester.name ASC";
    public static final String ORDER_BY_SQL = " ORDER BY Ace_CSWHarvester.name ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.nl.wur.alterra.cgi.ace.model.CSWHarvester"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.nl.wur.alterra.cgi.ace.model.CSWHarvester"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.nl.wur.alterra.cgi.ace.model.CSWHarvester"));
    private long _cswharvesterid;
    private String _name;
    private String _url;
    private String _freetext;
    private String _title;
    private String _abstrakt;
    private String _subject;
    private int _every;
    private String _topic;
    private String _status;
    private boolean _savedToGeoNetwork;
    private long _geonetworkId;
    private String _geonetworkUUID;
    private long _companyId;
    private long _groupId;
    private String _type;
    private String _username;
    private String _password;
    private transient ExpandoBridge _expandoBridge;

    public CSWHarvesterModelImpl() {
    }

    public long getPrimaryKey() {
        return _cswharvesterid;
    }

    public void setPrimaryKey(long pk) {
        setCswharvesterid(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_cswharvesterid);
    }

    public long getCswharvesterid() {
        return _cswharvesterid;
    }

    public void setCswharvesterid(long cswharvesterid) {
        _cswharvesterid = cswharvesterid;
    }

    public String getName() {
        if (_name == null) {
            return StringPool.BLANK;
        } else {
            return _name;
        }
    }

    public void setName(String name) {
        _name = name;
    }

    public String getUrl() {
        if (_url == null) {
            return StringPool.BLANK;
        } else {
            return _url;
        }
    }

    public void setUrl(String url) {
        _url = url;
    }

    public String getFreetext() {
        if (_freetext == null) {
            return StringPool.BLANK;
        } else {
            return _freetext;
        }
    }

    public void setFreetext(String freetext) {
        _freetext = freetext;
    }

    public String getTitle() {
        if (_title == null) {
            return StringPool.BLANK;
        } else {
            return _title;
        }
    }

    public void setTitle(String title) {
        _title = title;
    }

    public String getAbstrakt() {
        if (_abstrakt == null) {
            return StringPool.BLANK;
        } else {
            return _abstrakt;
        }
    }

    public void setAbstrakt(String abstrakt) {
        _abstrakt = abstrakt;
    }

    public String getSubject() {
        if (_subject == null) {
            return StringPool.BLANK;
        } else {
            return _subject;
        }
    }

    public void setSubject(String subject) {
        _subject = subject;
    }

    public int getEvery() {
        return _every;
    }

    public void setEvery(int every) {
        _every = every;
    }

    public String getTopic() {
        if (_topic == null) {
            return StringPool.BLANK;
        } else {
            return _topic;
        }
    }

    public void setTopic(String topic) {
        _topic = topic;
    }

    public String getStatus() {
        if (_status == null) {
            return StringPool.BLANK;
        } else {
            return _status;
        }
    }

    public void setStatus(String status) {
        _status = status;
    }

    public boolean getSavedToGeoNetwork() {
        return _savedToGeoNetwork;
    }

    public boolean isSavedToGeoNetwork() {
        return _savedToGeoNetwork;
    }

    public void setSavedToGeoNetwork(boolean savedToGeoNetwork) {
        _savedToGeoNetwork = savedToGeoNetwork;
    }

    public long getGeonetworkId() {
        return _geonetworkId;
    }

    public void setGeonetworkId(long geonetworkId) {
        _geonetworkId = geonetworkId;
    }

    public String getGeonetworkUUID() {
        if (_geonetworkUUID == null) {
            return StringPool.BLANK;
        } else {
            return _geonetworkUUID;
        }
    }

    public void setGeonetworkUUID(String geonetworkUUID) {
        _geonetworkUUID = geonetworkUUID;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    public String getType() {
        if (_type == null) {
            return StringPool.BLANK;
        } else {
            return _type;
        }
    }

    public void setType(String type) {
        _type = type;
    }

    public String getUsername() {
        if (_username == null) {
            return StringPool.BLANK;
        } else {
            return _username;
        }
    }

    public void setUsername(String username) {
        _username = username;
    }

    public String getPassword() {
        if (_password == null) {
            return StringPool.BLANK;
        } else {
            return _password;
        }
    }

    public void setPassword(String password) {
        _password = password;
    }

    public CSWHarvester toEscapedModel() {
        if (isEscapedModel()) {
            return (CSWHarvester) this;
        } else {
            return (CSWHarvester) Proxy.newProxyInstance(CSWHarvester.class.getClassLoader(),
                new Class[] { CSWHarvester.class },
                new AutoEscapeBeanHandler(this));
        }
    }

    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
                    CSWHarvester.class.getName(), getPrimaryKey());
        }

        return _expandoBridge;
    }

    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        getExpandoBridge().setAttributes(serviceContext);
    }

    public Object clone() {
        CSWHarvesterImpl clone = new CSWHarvesterImpl();

        clone.setCswharvesterid(getCswharvesterid());
        clone.setName(getName());
        clone.setUrl(getUrl());
        clone.setFreetext(getFreetext());
        clone.setTitle(getTitle());
        clone.setAbstrakt(getAbstrakt());
        clone.setSubject(getSubject());
        clone.setEvery(getEvery());
        clone.setTopic(getTopic());
        clone.setStatus(getStatus());
        clone.setSavedToGeoNetwork(getSavedToGeoNetwork());
        clone.setGeonetworkId(getGeonetworkId());
        clone.setGeonetworkUUID(getGeonetworkUUID());
        clone.setCompanyId(getCompanyId());
        clone.setGroupId(getGroupId());
        clone.setType(getType());
        clone.setUsername(getUsername());
        clone.setPassword(getPassword());

        return clone;
    }

    public int compareTo(CSWHarvester cswHarvester) {
        int value = 0;

        value = getName().toLowerCase()
                    .compareTo(cswHarvester.getName().toLowerCase());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        CSWHarvester cswHarvester = null;

        try {
            cswHarvester = (CSWHarvester) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = cswHarvester.getPrimaryKey();

        if (getPrimaryKey() == pk) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (int) getPrimaryKey();
    }

    public String toString() {
        StringBundler sb = new StringBundler(37);

        sb.append("{cswharvesterid=");
        sb.append(getCswharvesterid());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", url=");
        sb.append(getUrl());
        sb.append(", freetext=");
        sb.append(getFreetext());
        sb.append(", title=");
        sb.append(getTitle());
        sb.append(", abstrakt=");
        sb.append(getAbstrakt());
        sb.append(", subject=");
        sb.append(getSubject());
        sb.append(", every=");
        sb.append(getEvery());
        sb.append(", topic=");
        sb.append(getTopic());
        sb.append(", status=");
        sb.append(getStatus());
        sb.append(", savedToGeoNetwork=");
        sb.append(getSavedToGeoNetwork());
        sb.append(", geonetworkId=");
        sb.append(getGeonetworkId());
        sb.append(", geonetworkUUID=");
        sb.append(getGeonetworkUUID());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", type=");
        sb.append(getType());
        sb.append(", username=");
        sb.append(getUsername());
        sb.append(", password=");
        sb.append(getPassword());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(58);

        sb.append("<model><model-name>");
        sb.append("nl.wur.alterra.cgi.ace.model.CSWHarvester");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>cswharvesterid</column-name><column-value><![CDATA[");
        sb.append(getCswharvesterid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>url</column-name><column-value><![CDATA[");
        sb.append(getUrl());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>freetext</column-name><column-value><![CDATA[");
        sb.append(getFreetext());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>title</column-name><column-value><![CDATA[");
        sb.append(getTitle());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>abstrakt</column-name><column-value><![CDATA[");
        sb.append(getAbstrakt());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>subject</column-name><column-value><![CDATA[");
        sb.append(getSubject());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>every</column-name><column-value><![CDATA[");
        sb.append(getEvery());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>topic</column-name><column-value><![CDATA[");
        sb.append(getTopic());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>status</column-name><column-value><![CDATA[");
        sb.append(getStatus());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>savedToGeoNetwork</column-name><column-value><![CDATA[");
        sb.append(getSavedToGeoNetwork());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>geonetworkId</column-name><column-value><![CDATA[");
        sb.append(getGeonetworkId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>geonetworkUUID</column-name><column-value><![CDATA[");
        sb.append(getGeonetworkUUID());
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
            "<column><column-name>type</column-name><column-value><![CDATA[");
        sb.append(getType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>username</column-name><column-value><![CDATA[");
        sb.append(getUsername());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>password</column-name><column-value><![CDATA[");
        sb.append(getPassword());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}