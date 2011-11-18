
<%@include file="/html/init.jsp" %>

<%
	Project project = null;

	long projectId = ParamUtil.getLong(request, "projectId");

	if (projectId > 0) {
		project = ProjectLocalServiceUtil.getProject(projectId);
	}

	String redirect = ParamUtil.getString(request, "redirect");
%>

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


		<liferay-ui:error key="projectacronym-required" message="projectacronym-required" />		
		<aui:input name="acronym"  />
		
		<liferay-ui:error key="projecttitle-required" message="projecttitle-required" />

		<b>title</b><br />	
		<input name="title" type="text" size="120" value="<%= project == null ? "" : project.getTitle() %>"><br /><br />

		<b>lead</b><br />	
		<input name="lead" type="text" size="120" value="<%= project == null ? "" : project.getLead() %>"><br /><br />


		<b>website</b><br />	
		<input name="website" type="text" size="120" value="<%= project == null ? "" : project.getWebsite() %>"><br /><br />

	<div style="float: left; margin-right: 35px;">
		<b>abstract</b><br />
		<textarea name="abstracts" rows=10 cols=100><%= project == null ? "" : project.getAbstracts() %></textarea><br /><br />

		<b>partners</b><br />
		<textarea name="partners" rows=5 cols=100><%= project == null ? "" : project.getPartners() %></textarea><br /><br />

		<b>keywords</b><br />
		<textarea name="keywords" rows=5 cols=100><%= project == null ? "" : project.getKeywords() %></textarea><br /><br />

		<input type="checkbox" name="chk_importance" id="chk_importance" value="1" <% if (project != null) { out.print( project.getImportance() == 1 ? "checked" : "") ; } %> />
		<b>High importance</b><br />
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
						
		<aui:input name="funding"  />

		<aui:input name="spatiallevel"  />
		
		<aui:input name="duration"  />	
			
		<b>special tagging</b><br />	
		<input name="specialtagging" type="text" size="65" maxlength="75" value="<%= project == null ? "" : project.getSpecialtagging() %>"><br /><br />
		
		
	 </div>
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />

		<aui:button type="cancel"  onClick="<%= redirect %>" />
	</aui:button-row>
</aui:form>
		
		