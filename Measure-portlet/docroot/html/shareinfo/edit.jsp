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

<%
		String m_checked = "";
		String a_checked = "";
		
		String mao_type = prefs.getValue(Constants.mao_typePreferenceName, "A");
		
		if( mao_type.equalsIgnoreCase("M")) {
			m_checked = "checked";
		}
		else {
			a_checked = "checked";
		}
%>

<portlet:actionURL name="setAddMeasurePref" var="setAddMeasurePrefUrl" />

<aui:form action="<%= setAddMeasurePrefUrl %>" method="POST" name="fm" >

		<b>Type</b><br />
		<input id="mao_m" name="mao_type" type="radio" value="M" <%= m_checked %>>Adaptation option&nbsp;&nbsp;&nbsp;
		<input id="mao_a" name="mao_type" type="radio" value="A" <%= a_checked %>>Case study<br /><br />

	
	<aui:input name="<%= Constants.proxyUrlPreferenceName %>" value='<%= prefs.getValue(Constants.proxyUrlPreferenceName, "/SimilarAreasTool-portlet/proxy?url=") %>' size="45" type="text" />

	<aui:input name="<%= Constants.geoserverUrlPreferenceName %>" value='<%= prefs.getValue(Constants.geoserverUrlPreferenceName, "http://climate-adapt.eea.europa.eu/geoserver/") %>' size="45" type="text" />

    <aui:input name="<%= Constants.wmsPreferenceName %>" value='<%= prefs.getValue(Constants.wmsPreferenceName, "wms") %>' size="45" type="text" />

	<aui:input name="<%= Constants.wfsPreferenceName %>" value='<%= prefs.getValue(Constants.wfsPreferenceName, "wfs") %>' size="45" type="text" />
    
    <aui:input name="<%= Constants.featureNamespacePreferenceName %>" value='<%= prefs.getValue(Constants.featureNamespacePreferenceName, "http://climate-adapt.eea.europa.eu") %>' size="45" type="text" />

    <aui:input name="<%= Constants.areasFeatureTypePreferenceName %>" value='<%= prefs.getValue(Constants.areasFeatureTypePreferenceName, "biogeo_2008") %>' size="45" type="text" />

    <aui:input name="<%= Constants.areasLayerPreferenceName %>" value='<%= prefs.getValue(Constants.areasLayerPreferenceName, "chm:biogeo_2008") %>' size="45" type="text" />

    <aui:input name="<%= Constants.caseStudiesFeatureTypePreferenceName %>" value='<%= prefs.getValue(Constants.caseStudiesFeatureTypePreferenceName, "casestudies") %>' size="45" type="text" />

    <aui:input name="<%= Constants.geometryColumnPreferenceName %>" value='<%= prefs.getValue(Constants.geometryColumnPreferenceName, "geom") %>' size="45" type="text" />

    <aui:input name="<%= Constants.locatorUrlPreferenceName %>" value='<%= prefs.getValue(Constants.locatorUrlPreferenceName, "/ve/REST/v1/Locations/") %>' size="45" type="text" />

	<aui:input name="<%= Constants.locatorKeyPreferenceName %>" value='<%= prefs.getValue(Constants.locatorKeyPreferenceName, "Ao9qujBzDtg-nFiusTjt5VQ9x2NJB2wAD7YCRjaPz7hQQjxdFcl24tyhOwCDCIrw") %>' size="45" type="text" />

	<aui:input name="<%= Constants.bingTimeOutPreferenceName %>" value='<%= prefs.getValue(Constants.bingTimeOutPreferenceName, "100") %>' size="45" type="text" />

	<aui:input name="<%= Constants.zoomLevelPreferenceName %>" value='<%= prefs.getValue(Constants.zoomLevelPreferenceName, "2") %>' size="45" type="text" />

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>