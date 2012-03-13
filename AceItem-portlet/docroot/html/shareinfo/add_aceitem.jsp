<%@include file="/html/init.jsp" %>
<%
	String sharetype = prefs.getValue(Constants.SHARETYPE, AceItemType.DOCUMENT.toString());
	
	String typedescription = "";
	
	if (sharetype.equalsIgnoreCase(AceItemType.DOCUMENT.toString())) {
	   typedescription = "add a publication or report";  
	}
	else if (sharetype.equalsIgnoreCase(AceItemType.INFORMATIONSOURCE.toString())) {
	   typedescription = "add an information portal";
	}
	else if (sharetype.equalsIgnoreCase(AceItemType.GUIDANCE.toString())) {
	   typedescription = "add a guidance document";  
	}
	else if (sharetype.equalsIgnoreCase(AceItemType.TOOL.toString())) {
	   typedescription = "add a tool";  
	}
	else if (sharetype.equalsIgnoreCase(AceItemType.ORGANISATION.toString())) {
	   typedescription = "add an organisation"; 
	}
	
 if ( ! renderRequest.isUserInRole("user") ) { // || renderRequest.isUserInRole("portal-content-reviewer") ) { 
	    // if approved only administrator can delete; otherwise also power user can delete %>
		Please <a href='/home?p_p_id=58&p_p_lifecycle=0&p_p_state=maximized&p_p_mode=view&saveLastPath=0&_58_struts_action=%2Flogin%2Flogin'>sign in with your EIONET account</a> to <%= typedescription %>.
<% }	    
 else {
	AceItem aceitem = null;
	
	long aceItemId = ParamUtil.getLong(request, "aceitemId");

	if (aceItemId > 0) {
		aceitem = AceItemLocalServiceUtil.getAceItem(aceItemId);
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
	backURL="<%= redirect %>" title="<%= typedescription %>"
/>

<aui:model-context bean="<%= aceitem %>" model="<%= AceItem.class %>" />

<portlet:actionURL name='<%= aceitem == null ? "addAceItem" : "updateAceItem" %>' var="editAceItemURL" />

<aui:form action="<%= editAceItemURL %>" method="POST" name="fm">
	<aui:fieldset>

	    <input name="datatype" type="hidden" value="<%=sharetype%>">
	    
	    <input name="storagetype" type="hidden" value="URL">

		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />

		<aui:input type="hidden" name="aceItemId" value='<%= aceitem == null ? "" : aceitem.getAceItemId() %>'/>

		<aui:input type="hidden" name="wxsharvesterId" value='<%= aceitem == null ? "" : aceitem.getWxsharvesterId() %>'/>
		
		<liferay-ui:error key="aceitemname-required" message="aceitemname-required" />
		<b>name</b> <i>(required)</i><br />	
		<input name="name" type="text" size="120" value='<%= aceitem == null ? "" : aceitem.getName() %>'><br /><br />
		
		<liferay-ui:error key="aceitemstoredat-required" message="aceitemstoredat-required" />
		<b>website</b> <i>(required)</i><br />	
		<input name="storedAt" type="text" size="120" value='<%= aceitem == null ? "" : aceitem.getStoredAt() %>'><br /><br />


	<div style="float: left; margin-right: 35px;">
		
		<b>description</b><br />
		<textarea name="description" rows=10 cols=100><%= aceitem == null ? "" : aceitem.getDescription() %></textarea><br /><br />
		
        <b>keywords</b><br />	
		<textarea name="keyword" rows=5 cols=100><%= aceitem == null ? "" : aceitem.getKeyword() %></textarea><br /><br />

		<aui:input name="source" />

		<b>Geographic characterisation</b><br />	
		<input name="spatialLayer" type="text" size="65" value='<%= aceitem == null ? "" : aceitem.getSpatialLayer() %>'>	
	 </div>
	<div style="float: left;">			
		<br>
		<b>Sectors</b><br />
		<!--   input name="sectors_" type="text" size="65" value="< %= aceitem == null ? "" : aceitem.getSectors_() % >"><br /><br / -->
		
       <%-- note : i18n file should always be in sync with AceItemSector enum --%>	
		<c:forEach var="adaptationSector" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemSector.values() %>" >
			<div class="check">
				<c:set var="aceItemSectors" value='<%= aceitem == null ? "" : aceitem.getSectors_() %>' />
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
				<c:set var="aceItemElements" value='<%= aceitem == null ? "" : aceitem.getElements_() %>' />
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
				<c:set var="aceItemClimateImpacts" value='<%= aceitem == null ? "" : aceitem.getClimateimpacts_() %>' />
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
	  </div>
		
		<!--  a u i :input name="startdate" / >
		
		< a u  i:input name="enddate" / >
		
		< a u i  :input name="publicationdate" / -->
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
				<c:set var="aceItemCountries" value='<%= aceitem == null ? "" : aceitem.getSpatialValues() %>' />
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
	<textarea style="border-color: blue; border-style: solid; border-width: thin;" name="comments" rows=10 cols=150><%= aceitem == null ? "" : aceitem.getComments() %></textarea><br /><br />

	<input type="hidden" name="chk_controlstatus" id="chk_controlstatus" value="<% out.print("" + ACEIndexUtil.Status_SUBMITTED); %>" />

	<aui:button-row>
		<aui:button type="submit" />

		<aui:button type="cancel" onClick="<%= redirect %>" />
	</aui:button-row>
</aui:form>
<% } %>