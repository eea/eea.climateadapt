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

<form>
	<label for="riskSelect"><liferay-ui:message key="select-climate-impact" /></label>
	<select id="riskSelect" onchange="riskChange()">
		<option id="chk_risks_all" value="ALL" />
		<label for="chk_risks_all"><liferay-ui:message key="aceitem-climateimpacts-lbl-ALL" /></label>
		<c:forEach var="adaptationClimateImpact" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemClimateImpact.values() %>" >
			<option id="chk_climateimpacts_${adaptationClimateImpact}" value="${adaptationClimateImpact}" />
			<label for="chk_climateimpacts_${adaptationClimateImpact}"><liferay-ui:message key="aceitem-climateimpacts-lbl-${adaptationClimateImpact}" /></label>
		</c:forEach>
	</select>
	<br />
	<label for="riskSelect"><liferay-ui:message key="select-adaptation-sector" /></label>
	<select id="sectorSelect" onchange="sectorChange()">
		<option id="chk_sectors_all" value="ALL" />
		<label for="chk_sectors_all"><liferay-ui:message key="acesearch-sectors-lbl-ALL" /></label>
		<c:forEach var="adaptationSector" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemSector.values() %>" >
			<option id="chk_sectors_${adaptationSector}" value="${adaptationSector}" />
			<label for="chk_sectors_${adaptationSector}"><liferay-ui:message key="acesearch-sectors-lbl-${adaptationSector}" /></label>
		</c:forEach>
	</select>
</form>

<div id="locator">
	<input type="text" name="location" id="location" />
	<input type="submit" value="Locate" onclick="locate(document.getElementById('location').value)"/>
</div>

<div id='locations_element'></div>

<div id='map_element'></div>

<div id='legend_element'><img id="legendGraphicImage"/></div>

<script>
	var proxyUrl = '<%= prefs.getValue(Constants.proxyUrlPreferenceName, "") %>';
	
	var geoserverUrl = '<%= prefs.getValue(Constants.geoserverUrlPreferenceName, "http://ace.geocat.net/geoserver/") %>';
	
	var wms = '<%= prefs.getValue(Constants.wmsPreferenceName, "wms") %>';
	
	var wfs = '<%= prefs.getValue(Constants.wfsPreferenceName, "wfs") %>';
	
	var locatorUrl = '<%= prefs.getValue(Constants.locatorUrlPreferenceName, "http://dev.virtualearth.net/REST/v1/Locations/") %>';
	
	var locatorKey = '<%= prefs.getValue(Constants.locatorKeyPreferenceName, "Ao9qujBzDtg-nFiusTjt5VQ9x2NJB2wAD7YCRjaPz7hQQjxdFcl24tyhOwCDCIrw") %>';
	
	var satchmmap;
				
	var locator;
	
    Ext.onReady(function() {
    	satchmmap = new CHM.SATCHMMap();

        new GeoExt.MapPanel({
            renderTo: 'map_element',
            height: 500,
            width: 500,
            map: satchmmap
        });

        satchmmap.addBingLayers();
        
        satchmmap.addSATLayers();
        
        document.getElementById('legendGraphicImage').src = geoserverUrl + wms + "?TRANSPARENT=true&SERVICE=WMS&VERSION=1.1.1&REQUEST=GetLegendGraphic&EXCEPTIONS=application%2Fvnd.ogc.se_xml&LAYER=chm%3Abiogeo_2005&SCALE=55468034.09051751&FORMAT=image%2Fgif";		

        locator = new CHM.Locator('locations_element', {});

    	locator.setOnLocationChanged(handleLocationChanged);
    	
    	riskChange();
    				
    	sectorChange();
    });

	function handleLocationChanged() {
		satchmmap.setLocation(locator.getLocation());
	}
    		
    function getSelectedValue(select) {
    	return select.options[select.selectedIndex].value;
    }
    			
    function riskChange() {
    	var risk = getSelectedValue(document.getElementById('riskSelect'));
    				
    	satchmmap.setRisk(risk);
    }
    			
    function sectorChange() {
    	var sector = getSelectedValue(document.getElementById('sectorSelect'));
    			
    	satchmmap.setSector(sector);
    }
    	
    function locate(aLocation) {
    	locator.locate(aLocation);
    }
</script>