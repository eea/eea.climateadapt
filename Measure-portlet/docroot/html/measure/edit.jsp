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
    <aui:input name="rowsPerPage" value='<%= prefs.getValue("rowsPerPage","75") %>' size="45" type="text" />

	<b>Order By Column (use database column name)</b><br />
	<input name='<%= Constants.ORDERBYCOL %>' type="text" size="45" value='<%= prefs.getValue(Constants.ORDERBYCOL,"name") %>' /><br /><br />
		
	<b>Order By Type (asc or desc)</b><br />
	<input name='<%= Constants.ORDERBYTYPE %>' type="text" size="45" value='<%= prefs.getValue(Constants.ORDERBYTYPE,"asc") %>' /><br /><br />
	
	<aui:input name="<%= Constants.proxyUrlPreferenceName %>" value='<%= prefs.getValue(Constants.proxyUrlPreferenceName, "/SimilarAreasTool-portlet/proxy?url=") %>' size="45" type="text" />

	<aui:input name="<%= Constants.geoserverUrlPreferenceName %>" value='<%= prefs.getValue(Constants.geoserverUrlPreferenceName, "http://climate-adapt.eea.europa.eu/geoserver/") %>' size="45" type="text" />

    <aui:input name="<%= Constants.wmsPreferenceName %>" value='<%= prefs.getValue(Constants.wmsPreferenceName, "wms") %>' size="45" type="text" />

	<aui:input name="<%= Constants.wfsPreferenceName %>" value='<%= prefs.getValue(Constants.wfsPreferenceName, "wfs") %>' size="45" type="text" />
    
    <aui:input name="<%= Constants.featureNamespacePreferenceName %>" value='<%= prefs.getValue(Constants.featureNamespacePreferenceName, "http://climate-adapt.eea.europa.eu") %>' size="45" type="text" />

    <aui:input name="<%= Constants.areasFeatureTypePreferenceName %>" value='<%= prefs.getValue(Constants.areasFeatureTypePreferenceName, "biogeo_2005") %>' size="45" type="text" />

    <aui:input name="<%= Constants.areasLayerPreferenceName %>" value='<%= prefs.getValue(Constants.areasLayerPreferenceName, "chm:biogeo_2005") %>' size="45" type="text" />

    <aui:input name="<%= Constants.caseStudiesFeatureTypePreferenceName %>" value='<%= prefs.getValue(Constants.caseStudiesFeatureTypePreferenceName, "casestudies") %>' size="45" type="text" />

    <aui:input name="<%= Constants.geometryColumnPreferenceName %>" value='<%= prefs.getValue(Constants.geometryColumnPreferenceName, "geom") %>' size="45" type="text" />

    <aui:input name="<%= Constants.locatorUrlPreferenceName %>" value='<%= prefs.getValue(Constants.locatorUrlPreferenceName, "http://dev.virtualearth.net/REST/v1/Locations/") %>' size="45" type="text" />

	<aui:input name="<%= Constants.locatorKeyPreferenceName %>" value='<%= prefs.getValue(Constants.locatorKeyPreferenceName, "Ao9qujBzDtg-nFiusTjt5VQ9x2NJB2wAD7YCRjaPz7hQQjxdFcl24tyhOwCDCIrw") %>' size="45" type="text" />

	<aui:input name="<%= Constants.bingTimeOutPreferenceName %>" value='<%= prefs.getValue(Constants.bingTimeOutPreferenceName, "100") %>' size="45" type="text" />

	<aui:input name="<%= Constants.zoomLevelPreferenceName %>" value='<%= prefs.getValue(Constants.zoomLevelPreferenceName, "2") %>' size="45" type="text" />

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>