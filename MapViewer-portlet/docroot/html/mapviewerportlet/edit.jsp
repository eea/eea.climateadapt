<%--
/**
* Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
*
* This library is free software; you can redistribute it and/or modify it under
* the terms of the GNU Lesser General Public License as published by the Free
* Software Foundation; either version 2.1 of the License, or (at your option)
* any later version.
*
* This library is distributed in the hope that it will be useful, but WITHOUT
* ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
* FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
* details.
*/
--%>

<%@include file="/html/init.jsp" %>

<portlet:actionURL name="setPreferences" var="setPreferences" />

<aui:form action="<%= setPreferences %>" method="POST" name="form" >
	<aui:input name="<%= Constants.proxyUrlPreferenceName %>" value='<%= prefs.getValue(Constants.proxyUrlPreferenceName, "/SimilarAreasTool-portlet/proxy?url=") %>' size="45" type="text" />

	<aui:input name="<%= Constants.cswURLPreferenceName %>" value='<%= prefs.getValue(Constants.cswURLPreferenceName, "http://ace.geocat.net/geonetwork/srv/") %>' size="45" type="text" />

	<aui:input name="<%= Constants.cswCswPreferenceName %>" value='<%= prefs.getValue(Constants.cswCswPreferenceName, "en/csw?") %>' size="45" type="text" />

	<aui:input name="<%= Constants.cswShowMetadataPreferenceName %>" value='<%= prefs.getValue(Constants.cswShowMetadataPreferenceName, "en/metadata.show?uuid=") %>' size="45" type="text" />

    <aui:input name="<%= Constants.cswUserNamePreferenceName %>" value='<%= prefs.getValue(Constants.cswUserNamePreferenceName, "") %>' size="45" type="text" />

    <aui:input name="<%= Constants.cswPassWordPreferenceName %>" value='<%= prefs.getValue(Constants.cswPassWordPreferenceName, "") %>' size="45" type="text" />

	<aui:input name="<%= Constants.cswServletURLPreferenceName %>" value='<%= prefs.getValue(Constants.cswServletURLPreferenceName, "/MapViewer-portlet/cswservlet") %>' size="45" type="text" />

	<aui:input name="<%= Constants.mapViewerServletURLPreferenceName %>" value='<%= prefs.getValue(Constants.mapViewerServletURLPreferenceName, "/MapViewer-portlet/mapviewerservlet") %>' size="45" type="text" />

	<aui:input name="<%= Constants.mapViewerAppIdPreferenceName %>" value='<%= prefs.getValue(Constants.mapViewerAppIdPreferenceName, "default") %>' size="45" type="text" />

	<aui:input name="<%= Constants.mapViewerWmcDirectoryPreferenceName %>" value='<%= prefs.getValue(Constants.mapViewerWmcDirectoryPreferenceName, "/home/mapviewer") %>' size="45" type="text" />

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>