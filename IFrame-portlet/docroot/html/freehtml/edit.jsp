<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>


<%@ page import="javax.portlet.PortletPreferences" %>

<%@ page import="com.liferay.portal.model.Group"%>
<%@ page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@ page import="com.liferay.portal.util.PortalUtil" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<portlet:actionURL name="setHTMLTextPref" var="setHTMLTextPref" />

<aui:form action="<%= setHTMLTextPref %>" method="POST" name="fm" >
	<br />
	<b>Enter the html: (don't use double quotes)</b><br />	
	<input name="htmltext" type="text" size="200" value="<%= renderRequest.getPreferences().getValue("htmltext","") %>"><br /><br />

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>