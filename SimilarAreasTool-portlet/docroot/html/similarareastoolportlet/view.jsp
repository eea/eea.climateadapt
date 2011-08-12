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
	<select id="riskSelect" onchange="riskChange()">
		<c:forEach var="adaptationClimateImpact" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemClimateImpact.values() %>" >
			<option id="chk_climateimpacts_${adaptationClimateImpact}" value="${adaptationClimateImpact}" />
			<label for="chk_climateimpacts_${adaptationClimateImpact}"><liferay-ui:message key="aceitem-climateimpacts-lbl-${adaptationClimateImpact}" /></label>
		</c:forEach>
	</select>
	<select id="sectorSelect" onchange="sectorChange()">
		<c:forEach var="adaptationSector" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemSector.values() %>" >
			<option id="chk_sectors_${adaptationSector}" value="${adaptationSector}" />
			<label for="chk_sectors_${adaptationSector}"><liferay-ui:message key="acesearch-sectors-lbl-${adaptationSector}" /></label>
		</c:forEach>
	</select>
</form>

<div id='map_element' style='width: 500px; height: 500px;'></div>

<script type="text/javascript">
	var proxyUrl = '<%= request.getContextPath() %>/proxy?url=';
	
	var geoserverUrl = '<%= prefs.getValue(Constants.geoserverUrlPreferenceName, "http://ace.geocat.net/geoserver/") %>';
	
	var wms = '<%= prefs.getValue(Constants.wfsPreferenceName, "wfs") %>';
	
	var wfs = '<%= prefs.getValue(Constants.wmsPreferenceName, "wms") %>';
	
	var satchmmap = new CHM.SATCHMMap('map_element', {});
				
	riskChange();
				
	sectorChange();
		
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
</script>
