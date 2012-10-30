
<%@include file="/html/init.jsp" %>

<%
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

		    function <portlet:namespace />initEditor() {
                var editorValue = document.getElementById("<portlet:namespace />abstractsField").value;
                return editorValue;
            }

            function saveData() {
                var x = window.<portlet:namespace />editor.getHTML();
                document.getElementById("<portlet:namespace />abstractsField").value = x;
                return true;
            }

</script>
<liferay-ui:header
	backURL="<%= redirect %>"
	title='<%= (project != null) ? project.getAcronym() : "new-project" %>'
/>


<aui:model-context bean="<%= project %>" model="<%= Project.class %>" />


<!--  PERFORM THE PORTLET ACTION addProject OR updateProject AT FORM SUBMIT  -->
<portlet:actionURL name='<%= project == null ? "addProject" : "updateProject" %>' var="saveProjectURL" />

<aui:form action="<%= saveProjectURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />

		<aui:input type="hidden" name="projectId" value='<%= project == null ? "" : project.getProjectId() %>'/>

        <liferay-ui:error key="project-add-tech-error" message="project-add-tech-error" />
        <liferay-ui:error key="project-save-tech-error" message="project-save-tech-error" />

<% if (project != null) {
        long creationTime = project.getCreationdate() == null ? 0 : project.getCreationdate().getTime();
        %>
		<liferay-ui:error key="project-change" message="project-change" />
		<aui:input type="hidden" name="checkcreationdate" value="<%=creationTime%>"/>
<% } %>
		<liferay-ui:error key="projectacronym-required" message="projectacronym-required" />
		<b>acronym</b> <i>(required)</i><br />
		<input name="acronym" type="text" size="70" maxlength="75" value="<%= project == null ? "" : project.getAcronym() %>"><br /><br />

		<liferay-ui:error key="projecttitle-required" message="projecttitle-required" />

	  <div style="float: left; margin-right: 35px;">
		<b>project title</b> <i>(required)</i><br />
		<input name="title" type="text" size="120" maxlength="255" value="<%= project == null ? "" : project.getTitle() %>"><br /><br />

		<liferay-ui:error key="projectlead-required" message="projectlead-required" />
		<b>lead</b> <i>(required)</i><br />
		<input name="lead" type="text" size="120" maxlength="255" value="<%= project == null ? "" : project.getLead() %>"><br /><br />


		<b>website</b><br />
		<input name="website" type="text" size="120" maxlength="255" value="<%= project == null ? "" : project.getWebsite() %>"><br /><br />

		<b>abstract</b><br />
		<liferay-ui:input-editor/>
		<input id="<portlet:namespace />abstractsField" type="hidden" name="abstracts" value="<%= project==null ? "" : (project.getAbstracts()==null ? "" : project.getAbstracts()) %>"/><br /><br />

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

		<b>special tagging</b><br />
		<input name="specialtagging" type="text" size="65" maxlength="75" value="<%= project == null ? "" : project.getSpecialtagging() %>"><br /><br />

		<b>Geographic characterisation</b><br />
		<input name="spatiallayer" type="text" size="65" maxlength="75" value='<%= project == null ? "" : project.getSpatiallayer() %>'>

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

<% if ((renderRequest.isUserInRole("Portal Content Reviewer") || renderRequest.isUserInRole("administrator")) ) { // || renderRequest.isUserInRole("Power User")) { %>
 	<input type="checkbox" name="chk_importance" id="chk_importance" value="1" <% if ((project != null) && (project.getImportance() == 1) ) { out.print( "checked" ) ; } %> />
	<b>High importance</b>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;

	<input type="checkbox" name="chk_controlstatus" id="chk_controlstatus" value="<%= ACEIndexUtil.Status_APPROVED %>" <% if ((renderRequest.isUserInRole("Portal Content Reviewer") || renderRequest.isUserInRole("administrator")) && (project != null) && (project.getControlstatus() == ACEIndexUtil.Status_APPROVED) ) { out.print( "checked" ) ; } %> />
	<b>Approved</b>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;

	<b>Edited by: <% if (project != null) { out.print( project.getModerator() ) ; } %> </b>
	<br />

	<aui:button-row>
		<aui:button type="submit" onClick="return saveData();"/>

		<aui:button type="cancel"  onClick="history.go(-1);" /> <!-- onClick="< %= redirect % >" -->
	</aui:button-row>
<% }
  else  {
     if(renderRequest.isUserInRole("Power User")) { %>
		<b>Edited by: <% if (project != null) { out.print( project.getModerator() ) ; } %> </b>
		<br />
<% 	 } %>
	<input type="hidden" name="chk_controlstatus" id="chk_controlstatus" value=<% out.print( ((project != null) && (project.getControlstatus() == ACEIndexUtil.Status_SUBMITTED)) ? "" + ACEIndexUtil.Status_SUBMITTED : "" + ACEIndexUtil.Status_DRAFT ) ;%> />
	<input type="hidden" name="notify_status" id="notify_status" value="1" />
	<aui:button-row>
		<input value="Save as draft" type="button" onClick="document.getElementById('chk_controlstatus').value=<% out.print("" + ACEIndexUtil.Status_DRAFT); %>; document._projectportlet_WAR_Projectportlet_fm.submit();" />

		<input value="Submit for publication" type="button" onClick="document.getElementById('chk_controlstatus').value=<% out.print("" + ACEIndexUtil.Status_SUBMITTED); %>; document._projectportlet_WAR_Projectportlet_fm.submit();" />

		<input value="Cancel" type="button"  onClick="history.go(-1);" /> <!-- onClick="< %= redirect % >" -->
	</aui:button-row>
<% } %>

</aui:form>

