
<%@include file="/html/init.jsp" %>

<%

   if ( ! renderRequest.isUserInRole("user") ) { // || renderRequest.isUserInRole("portal-content-reviewer") ) { 
	    // if approved only administrator can delete; otherwise also power user can delete %>
		Please <a href='/home?p_p_id=58&p_p_lifecycle=0&p_p_state=maximized&p_p_mode=view&saveLastPath=0&_58_struts_action=%2Flogin%2Flogin'>sign in with your EIONET account</a> to add a research / knowledge project. 
<% }	    
   else {
	Project project = null;

	long projectId = ParamUtil.getLong(request, "projectId");

	if (projectId > 0) {
		project = ProjectLocalServiceUtil.getProject(projectId);
	}

	String redirect = ParamUtil.getString(request, "redirect");
%>
<script type="text/javascript"> 

		    function checkallcountries() {
			<% 
				nl.wur.alterra.cgi.ace.model.constants.AceItemCountry[] country = nl.wur.alterra.cgi.ace.model.constants.AceItemCountry.values();
				for(int i=0; i < country.length; i++) {
					out.print("document.getElementById('chk_countries_" +  country[i]  + "').checked = true;");
				}
			%>		    	
		    }
		    
		    function uncheckallcountries() {
		    <% 
		    	for(int i=0; i < country.length; i++) {
		    		out.print("document.getElementById('chk_countries_" +  country[i]  + "').checked = false;");
		    	}
		    %>
		    }
			
</script>
<liferay-ui:header
	backURL="<%= redirect %>"
	title='Add / edit the research / knowledge project'
/>


<aui:model-context bean="<%= project %>" model="<%= Project.class %>" />


<!--  PERFORM THE PORTLET ACTION addProject OR updateProject AT FORM SUBMIT  -->
<portlet:actionURL name='<%= project == null ? "addProject" : "updateProject" %>' var="saveProjectURL" />

<aui:form action="<%= saveProjectURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />

		<aui:input type="hidden" name="projectId" value='<%= project == null ? "" : project.getProjectId() %>'/>

		<liferay-ui:error key="projectacronym-required" message="projectacronym-required" />		
		<b>acronym</b> <i>(required)</i><br />	
		<input name="acronym" type="text" size="70" value="<%= project == null ? "" : project.getAcronym() %>"><br /><br />

		
		<liferay-ui:error key="projecttitle-required" message="projecttitle-required" />

	  <div style="float: left; margin-right: 35px;">
		<b>project title</b> <i>(required)</i><br />	
		<input name="title" type="text" size="120" value="<%= project == null ? "" : project.getTitle() %>"><br /><br />

		<liferay-ui:error key="projectlead-required" message="projectlead-required" />
		<b>lead</b> <i>(required)</i><br />	
		<input name="lead" type="text" size="120" value="<%= project == null ? "" : project.getLead() %>"><br /><br />


		<b>website</b><br />	
		<input name="website" type="text" size="120" value="<%= project == null ? "" : project.getWebsite() %>"><br /><br />

		<b>abstract</b><br />
		<textarea name="abstracts" rows=10 cols=100><%= project == null ? "" : project.getAbstracts() %></textarea><br /><br />

		<b>partners</b><br />
		<textarea name="partners" rows=5 cols=100><%= project == null ? "" : project.getPartners() %></textarea><br /><br />

		<b>keywords</b><br />
		<textarea name="keywords" rows=5 cols=100><%= project == null ? "" : project.getKeywords() %></textarea><br />

	  </div>
	  <div style="float: left;">	

	   <b>Sectors</b><br />
       <%-- note : i18n file should always be in sync with AceItemSector enum --%>	
		<c:forEach var="adaptationSector" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemSector.values() %>" >
			<div class="check">
				<c:set var="aceItemSectors" value="<%= project == null ? "" : project.getSectors() %>" />
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

		<b>Element(s)</b><br />
		<%-- note : i18n file should always be in sync with AceItemElement enum --%>
		<c:forEach var="adaptationElement" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemElement.values() %>" >
			<div class="check">
				<c:set var="aceItemElements" value="<%= project == null ? "" : project.getElement() %>" />
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
				<c:set var="aceItemClimateImpacts" value='<%= project == null ? "" : project.getClimateimpacts() %>' />
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
						
		<aui:input name="funding"  />
		
		<aui:input name="duration"  />	
			
		<b>source</b><br />	
		<input name="source" type="text" size="65" maxlength="75" value="<%= project == null ? "" : project.getSource() %>"><br /><br />

		<b>Geographic characterisation</b><br />	
		<input name="spatiallayer" type="text" size="65" value='<%= project == null ? "" : project.getSpatiallayer() %>'>
		
	  </div>
	</aui:fieldset>

	<b>Countries&nbsp; &nbsp; &nbsp; 
	<span id='all_countries'><a href="Javascript:checkallcountries();">check all</a></span>&nbsp; &nbsp; &nbsp;	
	<span id='no_countries'><a href="Javascript:uncheckallcountries();">check none</a></span></b><br />
	<table width="100%" border="0">
	<tr><td width="70">
	    <%-- note : i18n file should always be in sync with AceItemCountry enum --%>
		<c:set var="i_country" value="0" />
		<c:forEach var="countryElement" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemCountry.values() %>" >
			<!--  div class="check" -->
				<c:set var="countryElementMustBeChecked" value="false" />
				<c:set var="aceItemCountries" value='<%= project == null ? "" : project.getSpatialvalues() %>' />
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
	
    <b>Comments about this database item <i>[information entered below will not be displayed on the public pages of climate-adapt]</i></b><br />	
	<textarea style="border-color: blue; border-style: solid; border-width: thin;" name="comments" rows=10 cols=150><%= project == null ? "" : project.getComments() %></textarea><br /><br />

	<input type="hidden" name="chk_controlstatus" id="chk_controlstatus" value="<% out.print("" + ACEIndexUtil.Status_SUBMITTED); %>" />
	
	<aui:button-row>
		<aui:button type="submit" />

		<aui:button type="cancel" onClick="<%= redirect %>" />
	</aui:button-row>
</aui:form>
<% }  %>		
		