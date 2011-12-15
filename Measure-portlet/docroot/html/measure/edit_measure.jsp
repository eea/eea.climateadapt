<%@include file="/html/init.jsp" %>

<%
	Measure measure = null;

	long measureId = ParamUtil.getLong(request, "measureId");
	
	if (measureId > 0) {
		measure = MeasureLocalServiceUtil.getMeasure(measureId);
	}

	String redirect = ParamUtil.getString(request, "redirect");
%>
		<script type="text/javascript"> 
			
		jQuery(document).ready(function() {

			var $j = jQuery.noConflict();	

		    $j("#mao_m").click(function() {
			       $j("#locationselection").removeClass("toggleshow");
			       $j("#locationselection").addClass("togglehide");
		    });
		    
		    $j("#mao_a").click(function() {	
			       $j("#locationselection").removeClass("togglehide");
			       $j("#locationselection").addClass("toggleshow");
		    });
		    
		    $j("#all_countries").click(function() {
			<% 
				nl.wur.alterra.cgi.ace.model.constants.AceItemCountry[] country = nl.wur.alterra.cgi.ace.model.constants.AceItemCountry.values();
				for(int i=0; i < country.length; i++) {
					out.print("document.getElementById('chk_countries_" +  country[i]  + "').checked = true;");
				}
			%>		    	
		    });
		    
		    $j("#no_countries").click(function() {
		    <% 
		    	for(int i=0; i < country.length; i++) {
		    		out.print("document.getElementById('chk_countries_" +  country[i]  + "').checked = false;");
		    	}
		    %>
		    });

		});		
			
		</script>

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
		<br />

	 </div>
	<div style="float: left;">	
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
       
		<b>Implementationtype</b><br />	
		<select name="implementationtype">	
		<option value="" >Unknown</option>	
<% 		String help = "";
		if (measure!=null && measure.getImplementationtype().equalsIgnoreCase("grey"))	{
			help = "selected" ;
		} %>

			<option value="grey" <%= help %> >Technical ('grey')</option>
<%		help="";
		if (measure!=null && measure.getImplementationtype().equalsIgnoreCase("green"))	{
			help = "selected" ;
		} %>			
			<option value="green" <%= help %> >Ecological ('green')</option>
<%		help="";
		if (measure!=null && measure.getImplementationtype().equalsIgnoreCase("soft"))	{
			help = "selected" ;
		} %>			
			<option value="soft" <%= help %> >Behavioural / policy ('soft')</option>			
		</select>		
		<aui:input name="implementationtime" />
		
		<aui:input name="lifetime" />

		<b>Source</b><br />
		<input name="source" type="text" size="65" value='<%= measure == null ? "" : measure.getSource() %>'><br /><br />
		
		<b>special tagging</b><br />	
		<input name="specialtagging" type="text" size="65" maxlength="75" value="<%= measure == null ? "" : measure.getSpecialtagging() %>"><br /><br />
		
		<b>Geographic characterisation</b><br />	
		<input name="spatiallayer" type="text" size="65" value='<%= measure == null ? "" : measure.getSpatiallayer() %>'><br /><br />

<%
		String m_checked = "";
		String a_checked = "";
		String toggleclass = "togglehide";
		
		if(measure != null && measure.getMao_type().equalsIgnoreCase("M") ) {
			m_checked = "checked";
		}
		else {
			a_checked = "checked";
			toggleclass = "toggleshow";
		}
%>
		<b>Type</b><br />
		<input id="mao_m" name="mao_type" type="radio" value="M" <%= m_checked %>>Adaptation option&nbsp;&nbsp;&nbsp;
		<input id="mao_a" name="mao_type" type="radio" value="A" <%= a_checked %>>Case study<br /><br />
		
		<!--  a u i :input name="startdate" / >
		
		< a u  i:input name="enddate" / >
		
		< a u i  :input name="publicationdate" / -->
	<div id="locationselection" class="<%= toggleclass %>">	
		<div id="locator">
			<input type="text" name="location" id="location" />
			<a onclick="locate(document.getElementById('location').value)">Locate</a>
		</div>
		
		<div id='locations_element'></div>

		<div id="map_element" style='width: 500px; height: 500px;'></div>
		
		<b>lon</b><br />	
		<input name="lon" type="text" size="10" value='<%= measure == null ? "" : measure.getLon() %>'><br /><br />
		
		<b>lat</b><br />	
		<input name="lat" type="text" size="10" value='<%= measure == null ? "" : measure.getLat() %>'><br /><br />
		
		<a onclick="handleClick(event)">Apply</a><br /><br />
		
		<b>satarea</b><br />	
		<input name="satarea" type="text" size="50" value='<%= measure == null ? "" : measure.getSatarea() %>'>
	  </div>
 
	 </div>	

	</aui:fieldset>
	
	<b>Countries&nbsp; &nbsp; &nbsp; 
	<span id='all_countries'><a href="Javascript:none">check all</a></span>&nbsp; &nbsp; &nbsp;	
	<span id='no_countries'><a href="Javascript:none">check none</a></span></b><br />	
	<table width="100%" border="0">
	<tr><td width="70">
	    <%-- note : i18n file should always be in sync with AceItemCountry enum --%>
		<c:set var="i_country" value="0" />
		<c:forEach var="countryElement" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemCountry.values() %>" >
			<!--  div class="check" -->
				<c:set var="countryElementMustBeChecked" value="false" />
				<c:set var="aceItemCountries" value='<%= measure == null ? "" : measure.getSpatialvalues() %>' />
				<c:if test="${fn:indexOf(aceItemCountries, countryElement)>=0}">
					<c:set var="countryElementMustBeChecked" value="true" />
				</c:if>
				<c:choose>
					<c:when test="${countryElementMustBeChecked}">
						<input type="checkbox" name="chk_countries_${countryElement}" id="chk_countries_${countryElement}" value="${countryElement}" checked="checked" />
					</c:when>
					<c:otherwise>
						<input type="checkbox" name="chk_countries_${countryElement}" id="chk_countries_${countryElement}" value="${countryElement}" />
					</c:otherwise>
				</c:choose>
				<c:set var="i_country" value="${i_country + 1}" />
				<label for="chk_countries_${countryElement}"><liferay-ui:message key="acesearch-country-lbl-${countryElement}" /></label>
				</td>
			<!--  /div -->
			    <c:if test="${i_country==8}">
			       </tr><tr>
					<c:set var="i_country" value="0" />								    
				</c:if>
				<td width="70">
		</c:forEach>
	</td></tr>
	</table>
	<br />
	
    <b>Comments about this database item <i>[information entered below will not be displayed on the public pages of the clearinghouse]</i></b><br />	
	<textarea style="border-color: blue; border-style: solid; border-width: thin;" name="comments" rows=10 cols=150><%= measure == null ? "" : measure.getComments() %></textarea><br /><br />

	<input type="checkbox" name="chk_importance" id="chk_importance" value="1" <% if (measure != null) { out.print( measure.getImportance() == 1 ? "checked" : "") ; } %> />
	<b>High importance</b>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
 	<input type="checkbox" name="chk_controlstatus" id="chk_controlstatus" value="1" <% if (measure != null) { out.print( measure.getControlstatus() == 1 ? "checked" : "") ; } %> />
	<b>Reviewed</b>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
	<b>Edited by: <% if (measure != null) { out.print( measure.getModerator() ) ; } %> </b>	
 	<br />
	
	<aui:button-row>
		<aui:button type="submit" />

		<aui:button type="cancel"  onClick="history.go(-1);" /> <!-- onClick="< %= redirect % >" -->
	</aui:button-row>
</aui:form>

<div id='map_element'></div>

<script>
	var proxyUrl = '<%= prefs.getValue(Constants.proxyUrlPreferenceName, "") %>';
	
	var geoserverUrl = '<%= prefs.getValue(Constants.geoserverUrlPreferenceName, "http://ace.geocat.net/geoserver/") %>';
	
	var wms = '<%= prefs.getValue(Constants.wmsPreferenceName, "wms") %>';
	
	var wfs = '<%= prefs.getValue(Constants.wfsPreferenceName, "wfs") %>';
	
	var locatorUrl = '<%= prefs.getValue(Constants.locatorUrlPreferenceName, "http://dev.virtualearth.net/REST/v1/Locations/") %>';
	
	var locatorKey = '<%= prefs.getValue(Constants.locatorKeyPreferenceName, "Ao9qujBzDtg-nFiusTjt5VQ9x2NJB2wAD7YCRjaPz7hQQjxdFcl24tyhOwCDCIrw") %>';
	
	var measurechmmap;
	
	var locator;
	
    $(document).ready(function() {
    	setTimeout(function(){init();}, <%= prefs.getValue(Constants.bingTimeOutPreferenceName, "100") %>);
    });
    
    function init() {	
    	measurechmmap = new CHM.MeasureCHMMap('map_element', {});
    	
    	measurechmmap.setOnMeasureChanged(this.measureChanged);
		
    	measurechmmap.setOnAreaChanged(this.areaChanged);
		
    	locator = new CHM.Locator('locations_element', {});

    	locator.setOnLocationChanged(handleLocationChanged);
    	
    	handleClick(null);
    }    			

	function handleLocationChanged() {
		measurechmmap.setMeasure(new CHM.Measure(locator.getLocation().x, locator.getLocation().y, new OpenLayers.Projection('EPSG:4326')));
	}

    function handleClick(e) {
		measurechmmap.setMeasure(new CHM.Measure(document._measureportlet_WAR_Measureportlet_fm.lon.value, document._measureportlet_WAR_Measureportlet_fm.lat.value, new OpenLayers.Projection('EPSG:4326')));
	}
			
	function measureChanged() {
		var measure = measurechmmap.getMeasure(new OpenLayers.Projection('EPSG:4326'));
				
		document._measureportlet_WAR_Measureportlet_fm.lon.value = measure.x;
				
		document._measureportlet_WAR_Measureportlet_fm.lat.value = measure.y;
	}
			
	function areaChanged() {
		document._measureportlet_WAR_Measureportlet_fm.satarea.value = measurechmmap.getArea();
	}
	
    function locate(aLocation) {
    	locator.locate(aLocation);
    }
</script>
