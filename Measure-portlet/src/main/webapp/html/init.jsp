<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="org.json.simple.JSONArray" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="org.json.simple.JSONValue" %>

<%@ page import="javax.portlet.PortletPreferences" %>

<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.util.OrderByComparator" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.model.Group"%>
<%@ page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@page import="nl.wur.alterra.cgi.ace.portlet.Constants"%>
<%@ page import="nl.wur.alterra.cgi.ace.model.Measure"%>
<%@ page import="nl.wur.alterra.cgi.ace.service.MeasureLocalServiceUtil"%>
<%@ page import="nl.wur.alterra.cgi.ace.portlet.MeasureUtil"%>
<%@ page import="nl.wur.alterra.cgi.ace.search.lucene.ACEIndexUtil"%>
<%@ page import="nl.wur.alterra.cgi.ace.portlet.MeasurePortlet"%>
<%@ page import ="com.liferay.portal.kernel.upload.UploadPortletRequest" %>
<%@ page import ="com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil"  %>
<%@ page import ="com.liferay.portlet.documentlibrary.model.DLFileEntry"  %>
<%@ page import =" com.liferay.portal.kernel.util.HttpUtil"  %>
<%@ page import ="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import ="com.liferay.portal.service.ImageLocalServiceUtil"  %>
<%@ page import ="com.liferay.portal.model.Image" %>
<%@ page import ="com.liferay.portal.kernel.util.PrefsPropsUtil" %>
<%@ page import ="com.liferay.portal.kernel.util.PropsKeys" %>
<%@ page import = "com.liferay.portal.kernel.dao.orm.DynamicQuery" %>
<%@ page import = "com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil" %>
<%@ page import = "com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil" %>
<%@ page import = "nl.wur.alterra.cgi.ace.model.AceItem" %>
<%@ page import = "nl.wur.alterra.cgi.ace.portlet.SliderPortlet.JournalEvent" %>
<%@ page import = "com.liferay.portlet.documentlibrary.model.DLFileEntry" %>
<%@ page import = "com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil" %>
<%@ page import = "com.liferay.portal.webserver.WebServerServletTokenUtil" %>


<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
PortletPreferences prefs = renderRequest.getPreferences();
%>

