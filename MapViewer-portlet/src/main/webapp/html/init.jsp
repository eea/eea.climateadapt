<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<%@ page import="javax.portlet.PortletPreferences" %>
<%@ page import="com.liferay.portal.util.PortalUtil "%>
<%@ page import="nl.wur.alterra.cgi.ace.portlet.Constants" %>
<%@ page import="nl.wur.alterra.quickanddirtyows.csw.CSW" %>
<%@ page import="nl.wur.alterra.quickanddirtyows.csw.CSWRecord" %>
<%@ page import="nl.wur.alterra.quickanddirtyows.csw.digitaltransferoption.DigitalTransferOption" %>
<%@ page import="nl.wur.alterra.quickanddirtyows.csw.FileIdentifiers"%>

<portlet:defineObjects />

<%
PortletPreferences prefs = renderRequest.getPreferences();
%>
