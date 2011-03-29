<%@include file="/html/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Project project = (Project)row.getObject();

long groupId = project.getGroupId();
String name = Project.class.getName();
long projectId = project.getProjectId();

String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<!--  Commented out: no Actons button: liferay-ui:icon-menu -->	

    <!--  START RENDERING edit_project.jsp AT CHOICE edit -->
	<portlet:renderURL var="editURL">
		<portlet:param name="jspPage" value="/html/project/edit_project.jsp" />
		<portlet:param name="projectId" value="<%= String.valueOf(projectId) %>"/>
		<portlet:param name="redirect" value="<%= redirect %>"/>
	</portlet:renderURL>
	
	<liferay-ui:icon image="edit" url="<%=editURL.toString() %>" />

    <!--  PERFORM PORTLET ACTION deleteProject AT CHOICE delete -->
	<portlet:actionURL name="deleteProject" var="deleteURL">
		<portlet:param name="projectId" value="<%= String.valueOf(projectId) %>" />
		<portlet:param name="redirect" value="<%= redirect %>"/>
	</portlet:actionURL>
		
	<liferay-ui:icon image="delete" url="<%=deleteURL.toString() %>" />
<!--  Commented out: no Actons button: /liferay-ui:icon-menu -->