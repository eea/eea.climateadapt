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

	<select id="riskSelect" onchange="riskChange()">
		<option id="chk_risks_all" value="ALL" />
		<label for="chk_risks_all"><liferay-ui:message key="aceitem-climateimpacts-lbl-ALL" /></label>
		<c:forEach var="adaptationClimateImpact" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemClimateImpact.values() %>" >
			<option id="chk_climateimpacts_${adaptationClimateImpact}" value="${adaptationClimateImpact}" />
			<label for="chk_climateimpacts_${adaptationClimateImpact}"><liferay-ui:message key="aceitem-climateimpacts-lbl-${adaptationClimateImpact}" /></label>
		</c:forEach>
	</select>

	<select id="sectorSelect" onchange="sectorChange()">
		<option id="chk_sectors_all" value="ALL" />
		<label for="chk_sectors_all"><liferay-ui:message key="acesearch-sectors-lbl-ALL" /></label>
		<c:forEach var="adaptationSector" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemSector.values() %>" >
			<option id="chk_sectors_${adaptationSector}" value="${adaptationSector}" />
			<label for="chk_sectors_${adaptationSector}"><liferay-ui:message key="acesearch-sectors-lbl-${adaptationSector}" /></label>
		</c:forEach>
	</select>

<div id='csst_element'></div>

<script>
	var proxyUrl = '<%= prefs.getValue(Constants.proxyUrlPreferenceName, "/proxy/url=") %>';
	
	var geoserverUrl = '<%= prefs.getValue(Constants.geoserverUrlPreferenceName, "http://ace.geocat.net/geoserver/") %>';
	
	var wms = '<%= prefs.getValue(Constants.wmsPreferenceName, "wms") %>';
	
	var wfs = '<%= prefs.getValue(Constants.wfsPreferenceName, "wfs") %>';
	
	var featureNamespace = '<%= prefs.getValue(Constants.featureNamespacePreferenceName, "http://climate-adapt.eea.europa.eu") %>';
	
	var areasFeatureType = '<%= prefs.getValue(Constants.areasFeatureTypePreferenceName, "biogeo_2005") %>';
	
	var areasLayer = '<%= prefs.getValue(Constants.areasLayerPreferenceName, "chm:biogeo_2005") %>';
	
	var caseStudiesFeatureType = '<%= prefs.getValue(Constants.caseStudiesFeatureTypePreferenceName, "casestudies") %>';
	
	var geometryColumn = '<%= prefs.getValue(Constants.geometryColumnPreferenceName, "geom") %>';
	
	var areaColumn = '<%= prefs.getValue(Constants.areaColumnPreferenceName, "area") %>';
	
	var locatorUrl = '<%= prefs.getValue(Constants.locatorUrlPreferenceName, "http://geocode.arcgis.com/arcgis/rest/services/World/GeocodeServer") %>';
	
	var locatorKey = '<%= prefs.getValue(Constants.locatorKeyPreferenceName, "Ao9qujBzDtg-nFiusTjt5VQ9x2NJB2wAD7YCRjaPz7hQQjxdFcl24tyhOwCDCIrw") %>';
	
	var zoomLevel = '<%= prefs.getValue(Constants.zoomLevelPreferenceName, "2") %>';
	
	var root = '/SimilarAreasTool-portlet/';
</script>