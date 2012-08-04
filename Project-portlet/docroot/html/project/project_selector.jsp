<%@include file="/html/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

Project project = (Project)row.getObject();
long projectId = project.getProjectId();
String checkBoxName = ProjectPortlet.SUBMITTED_PROJECT_ID_PREFIX + projectId;

// If in approved status then only administrator can delete; otherwise power-user can delete too.
boolean deleteAllowed = renderRequest.isUserInRole("Portal Content Reviewer") || renderRequest.isUserInRole("administrator") ||
    (renderRequest.isUserInRole("power-user") && (project.getControlstatus()==0));

if (deleteAllowed) {
    %>
    <liferay-ui:input-checkbox param="<%=checkBoxName%>"/><%
}
%>