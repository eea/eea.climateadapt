<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<%@ page import="javax.portlet.PortletPreferences" %>
<%@page import="nl.wur.alterra.cgi.ace.portlet.Constants"%>

<portlet:defineObjects />

<%
PortletPreferences prefs = renderRequest.getPreferences();
%>