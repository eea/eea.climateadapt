<%@include file="/html/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

Measure measure = (Measure)row.getObject();
long measureId = measure.getMeasureId();
String checkBoxName = MeasurePortlet.SUBMITTED_MEASURE_ID_PREFIX + measureId;

// If in approved status then only administrator can delete; otherwise power-user can delete too.
boolean deleteAllowed = renderRequest.isUserInRole("Portal Content Reviewer") || renderRequest.isUserInRole("administrator") ||
    (renderRequest.isUserInRole("power-user") && (measure.getControlstatus()==0));

if (deleteAllowed) {
    %>
    <liferay-ui:input-checkbox param="<%=checkBoxName%>"/><%
}
%>