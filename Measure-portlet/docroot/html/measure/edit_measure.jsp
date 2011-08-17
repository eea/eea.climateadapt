<%@include file="/html/init.jsp" %>
<%
	Measure measure = null;

	long measureId = ParamUtil.getLong(request, "measureId");

	if (measureId > 0) {
		measure = MeasureLocalServiceUtil.getMeasure(measureId);
	}

	String redirect = ParamUtil.getString(request, "redirect");
%>

<liferay-ui:header
	backURL="<%= redirect %>"
	title='<%= (measure != null) ? measure.getName() : "new-measure" %>'
/>


<aui:model-context bean="<%= measure %>" model="<%= Measure.class %>" />

<portlet:actionURL name='<%= measure == null ? "addMeasure" : "updateMeasure" %>' var="editMeasureURL" />

<aui:form action="<%= editMeasureURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />

		<aui:input type="hidden" name="measureId" value='<%= measure == null ? "" : measure.getMeasureId() %>'/>

		<liferay-ui:error key="measurename-required" message="measurename-required" />
		<b>name</b><br />	
		<input name="name" type="text" size="120" value="<%= measure == null ? "" : measure.getName() %>"><br /><br />

		<b>website</b><br />	
		<input name="website" type="text" size="120" value="<%= measure == null ? "" : measure.getWebsite() %>"><br /><br />

	<div style="float: left; margin-right: 35px;">		
		<b>description</b><br />
		<textarea name="description" rows=10 cols=100><%= measure == null ? "" : measure.getDescription() %></textarea>
		<br /><br />

		<b>legal aspects</b><br />
		<textarea name="legalaspects" rows=5 cols=100><%= measure == null ? "" : measure.getLegalaspects() %></textarea>
		<br /><br />

		<b>stakeholder participation</b><br />
		<textarea name="stakeholderparticipation" rows=5 cols=100><%= measure == null ? "" : measure.getStakeholderparticipation() %></textarea>
		<br /><br />

		<b>contact</b><br />
		<textarea name="contact" rows=5 cols=100><%= measure == null ? "" : measure.getContact() %></textarea>
		<br /><br />

		<b>succes limitations</b><br />
		<textarea name="succeslimitations" rows=5 cols=100><%= measure == null ? "" : measure.getSucceslimitations() %></textarea>
		<br /><br />
		<b>cost / benefit</b><br />
		<textarea name="costbenefit" rows=5 cols=100><%= measure == null ? "" : measure.getCostbenefit() %></textarea>
		<br /><br />
			
		<b>keywords</b><br />	
		<textarea name="keywords"  rows=5 cols=100><%= measure == null ? "" : measure.getKeywords() %></textarea>
		<br /><br />
	
		<input type="checkbox" name="chk_importance" id="chk_importance" value="1" <% if (measure != null) { out.print( measure.getImportance() == 1 ? "checked" : "") ; } %> />
		<b>High importance</b><br />
	 </div>
	<div style="float: left;">	

		<b>implementationtype</b><br />	
		<input name="implementationtype" type="text" size="65" value="<%= measure == null ? "" : measure.getImplementationtype() %>"><br /><br />
		
		<aui:input name="implementationtime" />
		
		<aui:input name="lifetime" />
		
		<b>language</b><br />	
		<input name="language" type="text" size="24" maxlength="24" value="<%= measure == null ? "en_UK" : measure.getImplementationtype() %>"><br /><br />
		
		<aui:input name="spatiallayer" />
		
		<b>spatialvalues - separate them by ';' - Country search works on Nuts member state codes.</b><br />
		<input name="spatialvalues" type="text" size="65" value="<%= measure == null ? "" : measure.getSpatialvalues() %>"><br /><br />

	   <b>Sectors</b><br />
       <%-- note : i18n file should always be in sync with AceItemSector enum --%>	
		<c:forEach var="adaptationSector" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemSector.values() %>" >
			<div class="check">
				<c:set var="aceItemSectors" value='<%= measure == null ? "" : measure.getSectors_() %>' />
				<c:set var="adaptationSectorMustBeChecked" value="false" />
				<c:if test="${fn:indexOf(aceItemSectors, adaptationSector)>=0}">
					<c:set var="adaptationSectorMustBeChecked" value="true" />
				</c:if>	
				<c:choose>
					<c:when test="${adaptationSectorMustBeChecked}">
						<input type="checkbox" name="chk_sectors_${adaptationSector}" id="chk_sectors_${adaptationSector}" value="${adaptationSector}" checked="checked" />
					</c:when>
					<c:otherwise>
						<input type="checkbox" name="chk_sectors_${adaptationSector}" id="chk_sectors_${adaptationSector}" value="${adaptationSector}" />
					</c:otherwise>
				</c:choose>
				<label for="chk_sectors_${adaptationSector}"><liferay-ui:message key="acesearch-sectors-lbl-${adaptationSector}" /></label>
			</div>							
		</c:forEach>
        <br />
		
		<b>Elements</b><br />
		<%-- note : i18n file should always be in sync with AceItemElement enum --%>
		<c:forEach var="adaptationElement" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemElement.values() %>" >
			<div class="check">
				<c:set var="adaptationElementMustBeChecked" value="false" />
				<c:set var="aceItemElements" value='<%= measure == null ? "" : measure.getElements_() %>' />
				<c:set var="adaptationElementMustBeChecked" value="false" />
				<c:if test="${fn:indexOf(aceItemElements, adaptationElement)>=0}">
					<c:set var="adaptationElementMustBeChecked" value="true" />
				</c:if>	
				<c:choose>
					<c:when test="${adaptationElementMustBeChecked}">
						<input type="checkbox" name="chk_elements_${adaptationElement}" id="chk_elements_${adaptationElement}" value="${adaptationElement}" checked="checked" />
					</c:when>
					<c:otherwise>
						<input type="checkbox" name="chk_elements_${adaptationElement}" id="chk_elements_${adaptationElement}" value="${adaptationElement}" />
					</c:otherwise>
				</c:choose>
				<label for="chk_elements_${adaptationElement}"><liferay-ui:message key="acesearch-elements-lbl-${adaptationElement}" /></label>
			</div>							
		</c:forEach>
       <br />
		
		<b>Climate Impacts</b><br />
		<%-- note : i18n file should always be in sync with AceItemClimateImpact enum --%>
		<c:forEach var="adaptationClimateImpact" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemClimateImpact.values() %>" >
			<div class="check">
				<c:set var="adaptationClimateImpactMustBeChecked" value="false" />
				<c:set var="aceItemClimateImpacts" value='<%= measure == null ? "" : measure.getClimateimpacts_() %>' />
				<c:set var="adaptationClimateImpactMustBeChecked" value="false" />
				<c:if test="${fn:indexOf(aceItemClimateImpacts, adaptationClimateImpact)>=0}">
					<c:set var="adaptationClimateImpactMustBeChecked" value="true" />
				</c:if>	
				<c:choose>
					<c:when test="${adaptationClimateImpactMustBeChecked}">
						<input type="checkbox" name="chk_climateimpacts_${adaptationClimateImpact}" id="chk_climateimpacts_${adaptationClimateImpact}" value="${adaptationClimateImpact}" checked="checked" />
					</c:when>
					<c:otherwise>
						<input type="checkbox" name="chk_climateimpacts_${adaptationClimateImpact}" id="chk_climateimpacts_${adaptationClimateImpact}" value="${adaptationClimateImpact}" />
					</c:otherwise>
				</c:choose>
				<label for="chk_climateimpacts_${adaptationClimateImpact}"><liferay-ui:message key="aceitem-climateimpacts-lbl-${adaptationClimateImpact}" /></label>
			</div>							
		</c:forEach>
       <br />

<%
		String m_checked = "";
		String a_checked = "";
		
		if(measure != null && measure.getMao_type().equalsIgnoreCase("A") ) {
			a_checked = "checked";
		}
		else {
			m_checked = "checked";
		}
%>
		<b>Type</b><br />
		<input name="mao_type" type="radio" value="M" <%= m_checked %>>Adaptation option&nbsp;&nbsp;&nbsp;
		<input name="mao_type" type="radio" value="A" <%= a_checked %>>Case study<br /><br />
		
		<b>Source</b><br />
		<input name="source" type="text" size="65" value='<%= measure == null ? "" : measure.getSource() %>'><br /><br />
		<!--  a u i :input name="startdate" / >
		
		< a u  i:input name="enddate" / >
		
		< a u i  :input name="publicationdate" / -->
		
		<div id="map_element" style='width: 500px; height: 500px;'></div>
		
		<b>lat</b><br />	
		<input name="lat" type="text" size="10" value='<%= measure == null ? "" : measure.getLat() %>'><br /><br />
		
		<b>lon</b><br />	
		<input name="lon" type="text" size="10" value='<%= measure == null ? "" : measure.getLon() %>'><br /><br />
		
		<a onclick="handleClick(event)">Apply</a><br />
		
		<b>satarea</b><br />	
		<input name="satarea" type="text" size="50" value='<%= measure == null ? "" : measure.getSatarea() %>'><br /><br />
		</div>		
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />

		<aui:button type="cancel"  onClick="<%= redirect %>" />
	</aui:button-row>
</aui:form>

<script type="text/javascript">
	var proxyUrl = '<%= prefs.getValue(Constants.proxyUrlPreferenceName, "") %>';
	
	var geoserverUrl = '<%= prefs.getValue(Constants.geoserverUrlPreferenceName, "http://ace.geocat.net/geoserver/") %>';
	
	var wms = '<%= prefs.getValue(Constants.wmsPreferenceName, "wms") %>';
	
	var wfs = '<%= prefs.getValue(Constants.wfsPreferenceName, "wfs") %>';
				
	var measurechmmap = new CHM.MeasureCHMMap('map_element', {});
	
	measurechmmap.setOnMeasureChanged(this.measureChanged);
				
	measurechmmap.setOnAreaChanged(this.areaChanged);
	
	handleClick(null);
			
	function handleClick(e) {
		measurechmmap.setMeasure(new CHM.Measure(document._measureportlet_WAR_Measureportlet_fm.lat.value, document._measureportlet_WAR_Measureportlet_fm.lon.value, "EPSG:4326"));
	}
			
	function measureChanged() {
		var measure = measurechmmap.getMeasure('EPSG:4326');
				
		document._measureportlet_WAR_Measureportlet_fm.lat.value = measure.x;
				
		document._measureportlet_WAR_Measureportlet_fm.lon.value = measure.y;
	}
			
	function areaChanged() {
		document._measureportlet_WAR_Measureportlet_fm.satarea.value = measurechmmap.getArea();
	}
</script>
