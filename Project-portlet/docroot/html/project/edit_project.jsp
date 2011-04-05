
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
		<aui:input name="title"  />
		
		<liferay-ui:error key="projectlead-required" message="projectlead-required" />		
		<aui:input name="lead"  />

		<b>partners</b><br />
		<textarea name="partners" rows=10 cols=100><%= project == null ? "" : project.getPartners() %></textarea>
		
		<br /><br />

		<b>abstract</b><br />
		<textarea name="abstracts" rows=10 cols=100><%= project == null ? "" : project.getAbstracts() %></textarea>
				
		<aui:input name="funding"  />
		<aui:input name="sectors"  />
		<aui:input name="spatiallevel"  />
		<aui:input name="element"  />

		<b>keywords</b><br />
		<textarea name="keywords" rows=10 cols=100><%= project == null ? "" : project.getKeywords() %></textarea>
			
		<aui:input name=""  />

		<b>website</b><br />	
		<input name="website" type="text" size="120" value="<%= project == null ? "" : project.getWebsite() %>"><br /><br />
		
		<aui:input name="duration"  />

	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />

		<aui:button type="cancel"  onClick="<%= redirect %>" />
	</aui:button-row>
</aui:form>
		
		