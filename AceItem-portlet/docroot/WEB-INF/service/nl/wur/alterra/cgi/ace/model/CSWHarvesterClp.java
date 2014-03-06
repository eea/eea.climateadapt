package nl.wur.alterra.cgi.ace.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import nl.wur.alterra.cgi.ace.service.CSWHarvesterLocalServiceUtil;
import nl.wur.alterra.cgi.ace.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class CSWHarvesterClp extends BaseModelImpl<CSWHarvester>
    implements CSWHarvester {
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
    private BaseModel<?> _cswHarvesterRemoteModel;

    public CSWHarvesterClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return CSWHarvester.class;
    }

    @Override
    public String getModelClassName() {
        return CSWHarvester.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _cswharvesterid;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setCswharvesterid(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _cswharvesterid;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("cswharvesterid", getCswharvesterid());
        attributes.put("name", getName());
        attributes.put("url", getUrl());
        attributes.put("freetext", getFreetext());
        attributes.put("title", getTitle());
        attributes.put("abstrakt", getAbstrakt());
        attributes.put("subject", getSubject());
        attributes.put("every", getEvery());
        attributes.put("topic", getTopic());
        attributes.put("status", getStatus());
        attributes.put("savedToGeoNetwork", getSavedToGeoNetwork());
        attributes.put("geonetworkId", getGeonetworkId());
        attributes.put("geonetworkUUID", getGeonetworkUUID());
        attributes.put("companyId", getCompanyId());
        attributes.put("groupId", getGroupId());
        attributes.put("type", getType());
        attributes.put("username", getUsername());
        attributes.put("password", getPassword());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long cswharvesterid = (Long) attributes.get("cswharvesterid");

        if (cswharvesterid != null) {
            setCswharvesterid(cswharvesterid);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String url = (String) attributes.get("url");

        if (url != null) {
            setUrl(url);
        }

        String freetext = (String) attributes.get("freetext");

        if (freetext != null) {
            setFreetext(freetext);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        String abstrakt = (String) attributes.get("abstrakt");

        if (abstrakt != null) {
            setAbstrakt(abstrakt);
        }

        String subject = (String) attributes.get("subject");

        if (subject != null) {
            setSubject(subject);
        }

        Integer every = (Integer) attributes.get("every");

        if (every != null) {
            setEvery(every);
        }

        String topic = (String) attributes.get("topic");

        if (topic != null) {
            setTopic(topic);
        }

        String status = (String) attributes.get("status");

        if (status != null) {
            setStatus(status);
        }

        Boolean savedToGeoNetwork = (Boolean) attributes.get(
                "savedToGeoNetwork");

        if (savedToGeoNetwork != null) {
            setSavedToGeoNetwork(savedToGeoNetwork);
        }

        Long geonetworkId = (Long) attributes.get("geonetworkId");

        if (geonetworkId != null) {
            setGeonetworkId(geonetworkId);
        }

        String geonetworkUUID = (String) attributes.get("geonetworkUUID");

        if (geonetworkUUID != null) {
            setGeonetworkUUID(geonetworkUUID);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        String type = (String) attributes.get("type");

        if (type != null) {
            setType(type);
        }

        String username = (String) attributes.get("username");

        if (username != null) {
            setUsername(username);
        }

        String password = (String) attributes.get("password");

        if (password != null) {
            setPassword(password);
        }
    }

    @Override
    public long getCswharvesterid() {
        return _cswharvesterid;
    }

    @Override
    public void setCswharvesterid(long cswharvesterid) {
        _cswharvesterid = cswharvesterid;

        if (_cswHarvesterRemoteModel != null) {
            try {
                Class<?> clazz = _cswHarvesterRemoteModel.getClass();

                Method method = clazz.getMethod("setCswharvesterid", long.class);

                method.invoke(_cswHarvesterRemoteModel, cswharvesterid);
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

        if (_cswHarvesterRemoteModel != null) {
            try {
                Class<?> clazz = _cswHarvesterRemoteModel.getClass();

                Method method = clazz.getMethod("setName", String.class);

                method.invoke(_cswHarvesterRemoteModel, name);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getUrl() {
        return _url;
    }

    @Override
    public void setUrl(String url) {
        _url = url;

        if (_cswHarvesterRemoteModel != null) {
            try {
                Class<?> clazz = _cswHarvesterRemoteModel.getClass();

                Method method = clazz.getMethod("setUrl", String.class);

                method.invoke(_cswHarvesterRemoteModel, url);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getFreetext() {
        return _freetext;
    }

    @Override
    public void setFreetext(String freetext) {
        _freetext = freetext;

        if (_cswHarvesterRemoteModel != null) {
            try {
                Class<?> clazz = _cswHarvesterRemoteModel.getClass();

                Method method = clazz.getMethod("setFreetext", String.class);

                method.invoke(_cswHarvesterRemoteModel, freetext);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getTitle() {
        return _title;
    }

    @Override
    public void setTitle(String title) {
        _title = title;

        if (_cswHarvesterRemoteModel != null) {
            try {
                Class<?> clazz = _cswHarvesterRemoteModel.getClass();

                Method method = clazz.getMethod("setTitle", String.class);

                method.invoke(_cswHarvesterRemoteModel, title);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getAbstrakt() {
        return _abstrakt;
    }

    @Override
    public void setAbstrakt(String abstrakt) {
        _abstrakt = abstrakt;

        if (_cswHarvesterRemoteModel != null) {
            try {
                Class<?> clazz = _cswHarvesterRemoteModel.getClass();

                Method method = clazz.getMethod("setAbstrakt", String.class);

                method.invoke(_cswHarvesterRemoteModel, abstrakt);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getSubject() {
        return _subject;
    }

    @Override
    public void setSubject(String subject) {
        _subject = subject;

        if (_cswHarvesterRemoteModel != null) {
            try {
                Class<?> clazz = _cswHarvesterRemoteModel.getClass();

                Method method = clazz.getMethod("setSubject", String.class);

                method.invoke(_cswHarvesterRemoteModel, subject);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getEvery() {
        return _every;
    }

    @Override
    public void setEvery(int every) {
        _every = every;

        if (_cswHarvesterRemoteModel != null) {
            try {
                Class<?> clazz = _cswHarvesterRemoteModel.getClass();

                Method method = clazz.getMethod("setEvery", int.class);

                method.invoke(_cswHarvesterRemoteModel, every);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getTopic() {
        return _topic;
    }

    @Override
    public void setTopic(String topic) {
        _topic = topic;

        if (_cswHarvesterRemoteModel != null) {
            try {
                Class<?> clazz = _cswHarvesterRemoteModel.getClass();

                Method method = clazz.getMethod("setTopic", String.class);

                method.invoke(_cswHarvesterRemoteModel, topic);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getStatus() {
        return _status;
    }

    @Override
    public void setStatus(String status) {
        _status = status;

        if (_cswHarvesterRemoteModel != null) {
            try {
                Class<?> clazz = _cswHarvesterRemoteModel.getClass();

                Method method = clazz.getMethod("setStatus", String.class);

                method.invoke(_cswHarvesterRemoteModel, status);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getSavedToGeoNetwork() {
        return _savedToGeoNetwork;
    }

    @Override
    public boolean isSavedToGeoNetwork() {
        return _savedToGeoNetwork;
    }

    @Override
    public void setSavedToGeoNetwork(boolean savedToGeoNetwork) {
        _savedToGeoNetwork = savedToGeoNetwork;

        if (_cswHarvesterRemoteModel != null) {
            try {
                Class<?> clazz = _cswHarvesterRemoteModel.getClass();

                Method method = clazz.getMethod("setSavedToGeoNetwork",
                        boolean.class);

                method.invoke(_cswHarvesterRemoteModel, savedToGeoNetwork);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getGeonetworkId() {
        return _geonetworkId;
    }

    @Override
    public void setGeonetworkId(long geonetworkId) {
        _geonetworkId = geonetworkId;

        if (_cswHarvesterRemoteModel != null) {
            try {
                Class<?> clazz = _cswHarvesterRemoteModel.getClass();

                Method method = clazz.getMethod("setGeonetworkId", long.class);

                method.invoke(_cswHarvesterRemoteModel, geonetworkId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getGeonetworkUUID() {
        return _geonetworkUUID;
    }

    @Override
    public void setGeonetworkUUID(String geonetworkUUID) {
        _geonetworkUUID = geonetworkUUID;

        if (_cswHarvesterRemoteModel != null) {
            try {
                Class<?> clazz = _cswHarvesterRemoteModel.getClass();

                Method method = clazz.getMethod("setGeonetworkUUID",
                        String.class);

                method.invoke(_cswHarvesterRemoteModel, geonetworkUUID);
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

        if (_cswHarvesterRemoteModel != null) {
            try {
                Class<?> clazz = _cswHarvesterRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_cswHarvesterRemoteModel, companyId);
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

        if (_cswHarvesterRemoteModel != null) {
            try {
                Class<?> clazz = _cswHarvesterRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_cswHarvesterRemoteModel, groupId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getType() {
        return _type;
    }

    @Override
    public void setType(String type) {
        _type = type;

        if (_cswHarvesterRemoteModel != null) {
            try {
                Class<?> clazz = _cswHarvesterRemoteModel.getClass();

                Method method = clazz.getMethod("setType", String.class);

                method.invoke(_cswHarvesterRemoteModel, type);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getUsername() {
        return _username;
    }

    @Override
    public void setUsername(String username) {
        _username = username;

        if (_cswHarvesterRemoteModel != null) {
            try {
                Class<?> clazz = _cswHarvesterRemoteModel.getClass();

                Method method = clazz.getMethod("setUsername", String.class);

                method.invoke(_cswHarvesterRemoteModel, username);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getPassword() {
        return _password;
    }

    @Override
    public void setPassword(String password) {
        _password = password;

        if (_cswHarvesterRemoteModel != null) {
            try {
                Class<?> clazz = _cswHarvesterRemoteModel.getClass();

                Method method = clazz.getMethod("setPassword", String.class);

                method.invoke(_cswHarvesterRemoteModel, password);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public java.lang.String toShortString() {
        try {
            String methodName = "toShortString";

            Class<?>[] parameterTypes = new Class<?>[] {  };

            Object[] parameterValues = new Object[] {  };

            java.lang.String returnObj = (java.lang.String) invokeOnRemoteModel(methodName,
                    parameterTypes, parameterValues);

            return returnObj;
        } catch (Exception e) {
            throw new UnsupportedOperationException(e);
        }
    }

    public BaseModel<?> getCSWHarvesterRemoteModel() {
        return _cswHarvesterRemoteModel;
    }

    public void setCSWHarvesterRemoteModel(BaseModel<?> cswHarvesterRemoteModel) {
        _cswHarvesterRemoteModel = cswHarvesterRemoteModel;
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

        Class<?> remoteModelClass = _cswHarvesterRemoteModel.getClass();

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

        Object returnValue = method.invoke(_cswHarvesterRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            CSWHarvesterLocalServiceUtil.addCSWHarvester(this);
        } else {
            CSWHarvesterLocalServiceUtil.updateCSWHarvester(this);
        }
    }

    @Override
    public CSWHarvester toEscapedModel() {
        return (CSWHarvester) ProxyUtil.newProxyInstance(CSWHarvester.class.getClassLoader(),
            new Class[] { CSWHarvester.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        CSWHarvesterClp clone = new CSWHarvesterClp();

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

    @Override
    public int compareTo(CSWHarvester cswHarvester) {
        int value = 0;

        value = getName().compareToIgnoreCase(cswHarvester.getName());

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

        if (!(obj instanceof CSWHarvesterClp)) {
            return false;
        }

        CSWHarvesterClp cswHarvester = (CSWHarvesterClp) obj;

        long primaryKey = cswHarvester.getPrimaryKey();

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

    @Override
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
