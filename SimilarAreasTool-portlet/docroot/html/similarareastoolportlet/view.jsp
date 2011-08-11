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

<portlet:defineObjects />

<form>
	<select id="riskSelect" onchange="riskChange()">
		<option value="EXTREMETEMP">Extreme Temperatures</option>
		<option value="WATERSCARCE">Water Scarcity</option>
		<option value="FLOODING">Flooding</option>
		<option value="SEALEVELRISE">Sea Level Rise</option>
		<option value="DROUGHT">Droughts</option>
		<option value="STORM">Storms</option>
		<option value="ICEANDSNOW">Ice and Snow</option>
	</select>
	<select id="sectorSelect" onchange="sectorChange()">
		<option value="AGRICULTURE">Agriculture and Forest</option>
		<option value="BIODIVERSITY">Biodiversity</option>
		<option value="COASTAL">Coastal areas</option>
		<option value="DISASTERRISKREDUCTION">Disaster Risk Reduction</option>
		<option value="FINANCIAL">Financial</option>
		<option value="HEALTH">Health</option>
		<option value="INFRASTRUCTURE">Infrastructure</option>
		<option value="MARINE">Marine and Fisheries</option>
		<option value="WATERMANAGEMENT">Water management</option>
	</select>
</form>

<div id='map_element' style='width: 500px; height: 500px;'></div>

<script type="text/javascript">
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

