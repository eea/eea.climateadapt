package nl.wur.alterra.cgi.ace.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import nl.wur.alterra.cgi.ace.service.ClpSerializer;
import nl.wur.alterra.cgi.ace.service.WxsHarvesterLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class WxsHarvesterClp extends BaseModelImpl<WxsHarvester>
    implements WxsHarvester {
    private long _wxsharvesterid;
    private String _name;
    private String _url;
    private String _ogctype;
    private int _every;
    private String _topic;
    private String _status;
    private boolean _savedToGeoNetwork;
    private long _geonetworkId;
    private String _geonetworkUUID;
    private long _companyId;
    private long _groupId;
    private BaseModel<?> _wxsHarvesterRemoteModel;

    public WxsHarvesterClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return WxsHarvester.class;
    }

    @Override
    public String getModelClassName() {
        return WxsHarvester.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _wxsharvesterid;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setWxsharvesterid(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _wxsharvesterid;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("wxsharvesterid", getWxsharvesterid());
        attributes.put("name", getName());
        attributes.put("url", getUrl());
        attributes.put("ogctype", getOgctype());
        attributes.put("every", getEvery());
        attributes.put("topic", getTopic());
        attributes.put("status", getStatus());
        attributes.put("savedToGeoNetwork", getSavedToGeoNetwork());
        attributes.put("geonetworkId", getGeonetworkId());
        attributes.put("geonetworkUUID", getGeonetworkUUID());
        attributes.put("companyId", getCompanyId());
        attributes.put("groupId", getGroupId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long wxsharvesterid = (Long) attributes.get("wxsharvesterid");

        if (wxsharvesterid != null) {
            setWxsharvesterid(wxsharvesterid);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String url = (String) attributes.get("url");

        if (url != null) {
            setUrl(url);
        }

        String ogctype = (String) attributes.get("ogctype");

        if (ogctype != null) {
            setOgctype(ogctype);
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
    }

    @Override
    public long getWxsharvesterid() {
        return _wxsharvesterid;
    }

    @Override
    public void setWxsharvesterid(long wxsharvesterid) {
        _wxsharvesterid = wxsharvesterid;

        if (_wxsHarvesterRemoteModel != null) {
            try {
                Class<?> clazz = _wxsHarvesterRemoteModel.getClass();

                Method method = clazz.getMethod("setWxsharvesterid", long.class);

                method.invoke(_wxsHarvesterRemoteModel, wxsharvesterid);
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

        if (_wxsHarvesterRemoteModel != null) {
            try {
                Class<?> clazz = _wxsHarvesterRemoteModel.getClass();

                Method method = clazz.getMethod("setName", String.class);

                method.invoke(_wxsHarvesterRemoteModel, name);
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

        if (_wxsHarvesterRemoteModel != null) {
            try {
                Class<?> clazz = _wxsHarvesterRemoteModel.getClass();

                Method method = clazz.getMethod("setUrl", String.class);

                method.invoke(_wxsHarvesterRemoteModel, url);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getOgctype() {
        return _ogctype;
    }

    @Override
    public void setOgctype(String ogctype) {
        _ogctype = ogctype;

        if (_wxsHarvesterRemoteModel != null) {
            try {
                Class<?> clazz = _wxsHarvesterRemoteModel.getClass();

                Method method = clazz.getMethod("setOgctype", String.class);

                method.invoke(_wxsHarvesterRemoteModel, ogctype);
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

        if (_wxsHarvesterRemoteModel != null) {
            try {
                Class<?> clazz = _wxsHarvesterRemoteModel.getClass();

                Method method = clazz.getMethod("setEvery", int.class);

                method.invoke(_wxsHarvesterRemoteModel, every);
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

        if (_wxsHarvesterRemoteModel != null) {
            try {
                Class<?> clazz = _wxsHarvesterRemoteModel.getClass();

                Method method = clazz.getMethod("setTopic", String.class);

                method.invoke(_wxsHarvesterRemoteModel, topic);
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

        if (_wxsHarvesterRemoteModel != null) {
            try {
                Class<?> clazz = _wxsHarvesterRemoteModel.getClass();

                Method method = clazz.getMethod("setStatus", String.class);

                method.invoke(_wxsHarvesterRemoteModel, status);
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

        if (_wxsHarvesterRemoteModel != null) {
            try {
                Class<?> clazz = _wxsHarvesterRemoteModel.getClass();

                Method method = clazz.getMethod("setSavedToGeoNetwork",
                        boolean.class);

                method.invoke(_wxsHarvesterRemoteModel, savedToGeoNetwork);
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

        if (_wxsHarvesterRemoteModel != null) {
            try {
                Class<?> clazz = _wxsHarvesterRemoteModel.getClass();

                Method method = clazz.getMethod("setGeonetworkId", long.class);

                method.invoke(_wxsHarvesterRemoteModel, geonetworkId);
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

        if (_wxsHarvesterRemoteModel != null) {
            try {
                Class<?> clazz = _wxsHarvesterRemoteModel.getClass();

                Method method = clazz.getMethod("setGeonetworkUUID",
                        String.class);

                method.invoke(_wxsHarvesterRemoteModel, geonetworkUUID);
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

        if (_wxsHarvesterRemoteModel != null) {
            try {
                Class<?> clazz = _wxsHarvesterRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_wxsHarvesterRemoteModel, companyId);
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

        if (_wxsHarvesterRemoteModel != null) {
            try {
                Class<?> clazz = _wxsHarvesterRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_wxsHarvesterRemoteModel, groupId);
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

    public BaseModel<?> getWxsHarvesterRemoteModel() {
        return _wxsHarvesterRemoteModel;
    }

    public void setWxsHarvesterRemoteModel(BaseModel<?> wxsHarvesterRemoteModel) {
        _wxsHarvesterRemoteModel = wxsHarvesterRemoteModel;
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

        Class<?> remoteModelClass = _wxsHarvesterRemoteModel.getClass();

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

        Object returnValue = method.invoke(_wxsHarvesterRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            WxsHarvesterLocalServiceUtil.addWxsHarvester(this);
        } else {
            WxsHarvesterLocalServiceUtil.updateWxsHarvester(this);
        }
    }

    @Override
    public WxsHarvester toEscapedModel() {
        return (WxsHarvester) ProxyUtil.newProxyInstance(WxsHarvester.class.getClassLoader(),
            new Class[] { WxsHarvester.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        WxsHarvesterClp clone = new WxsHarvesterClp();

        clone.setWxsharvesterid(getWxsharvesterid());
        clone.setName(getName());
        clone.setUrl(getUrl());
        clone.setOgctype(getOgctype());
        clone.setEvery(getEvery());
        clone.setTopic(getTopic());
        clone.setStatus(getStatus());
        clone.setSavedToGeoNetwork(getSavedToGeoNetwork());
        clone.setGeonetworkId(getGeonetworkId());
        clone.setGeonetworkUUID(getGeonetworkUUID());
        clone.setCompanyId(getCompanyId());
        clone.setGroupId(getGroupId());

        return clone;
    }

    @Override
    public int compareTo(WxsHarvester wxsHarvester) {
        int value = 0;

        value = getName().compareToIgnoreCase(wxsHarvester.getName());

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

        if (!(obj instanceof WxsHarvesterClp)) {
            return false;
        }

        WxsHarvesterClp wxsHarvester = (WxsHarvesterClp) obj;

        long primaryKey = wxsHarvester.getPrimaryKey();

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
        StringBundler sb = new StringBundler(25);

        sb.append("{wxsharvesterid=");
        sb.append(getWxsharvesterid());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", url=");
        sb.append(getUrl());
        sb.append(", ogctype=");
        sb.append(getOgctype());
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
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(40);

        sb.append("<model><model-name>");
        sb.append("nl.wur.alterra.cgi.ace.model.WxsHarvester");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>wxsharvesterid</column-name><column-value><![CDATA[");
        sb.append(getWxsharvesterid());
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
            "<column><column-name>ogctype</column-name><column-value><![CDATA[");
        sb.append(getOgctype());
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

        sb.append("</model>");

        return sb.toString();
    }
}
