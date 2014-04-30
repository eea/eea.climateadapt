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

<portlet:actionURL name="setIFramePref" var="setIFramePrefUrl" />

<aui:form action="<%= setIFramePrefUrl %>" method="POST" name="fm" >

	<b>url</b><br />	
	<input name="url" type="text" size="150" value="<%= renderRequest.getPreferences().getValue("url","") %>"><br /><br />

	<b>IFrame inline attributes</b><br />	
	<input name="inline" type="text" size="150" value="<%= renderRequest.getPreferences().getValue("inline-attributes","") %>"><br /><br />

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>