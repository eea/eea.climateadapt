<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%@ page import="javax.portlet.PortletPreferences" %>

<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>

<%@ page import="com.liferay.portal.kernel.util.OrderByComparator" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.model.Group"%>
<%@ page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@ page import="com.liferay.portal.util.PortalUtil" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<portlet:actionURL name="setASTHeaderPref" var="setASTHeaderPrefUrl" />

<aui:form action="<%= setASTHeaderPrefUrl %>" method="POST" name="fm" >

	<b>Step number</b><br />	
	<input name="step" type="text" size="150" value="<%= renderRequest.getPreferences().getValue("step","2") %>"><br /><br />

	<b>Header text</b><br />	
	<input name="headertext" type="text" size="150" value="<%= renderRequest.getPreferences().getValue("headertext","Header text") %>"><br /><br />

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>
