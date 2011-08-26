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

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@include file="/html/init.jsp" %>

<portlet:actionURL name="setMeasurePref" var="setMeasurePrefUrl" />

<aui:form action="<%= setMeasurePrefUrl %>" method="POST" name="fm" >
	<b>Order By Column (name or measureId)</b><br />
	<input name='<%= Constants.ORDERBYCOL %>' type="text" size="45" value='<%= prefs.getValue(Constants.ORDERBYCOL,"name") %>' /><br /><br />
		
	<b>Order By Type (asc or desc)</b><br />
	<input name='<%= Constants.ORDERBYTYPE %>' type="text" size="45" value='<%= prefs.getValue(Constants.ORDERBYTYPE,"asc") %>' /><br /><br />
	
	<aui:input name="<%= nl.wur.alterra.cgi.ace.portlet.Constants.proxyUrlPreferenceName %>" value='<%= prefs.getValue(Constants.proxyUrlPreferenceName, "/SimilarAreasTool-portlet/proxy?url=") %>' size="45" type="text" />

	<aui:input name="<%= Constants.geoserverUrlPreferenceName %>" value='<%= prefs.getValue(Constants.geoserverUrlPreferenceName, "http://ace.geocat.net/geoserver/") %>' size="45" type="text" />

    <aui:input name="<%= Constants.wfsPreferenceName %>" value='<%= prefs.getValue(Constants.wfsPreferenceName, "wfs") %>' size="45" type="text" />

    <aui:input name="<%= Constants.wmsPreferenceName %>" value='<%= prefs.getValue(Constants.wmsPreferenceName, "wms") %>' size="45" type="text" />

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>