<%@include file="/html/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
AceItem aceItem = (AceItem)row.getObject();
long aceItemId = aceItem.getAceItemId();
String checkBoxName = AceItemPortlet.SUBMITTED_ACE_ITEM_ID_PREFIX + aceItemId;

// If in approved status then only administrator can delete; otherwise power-user can delete too.
boolean deleteAllowed = renderRequest.isUserInRole("Portal Content Reviewer") || renderRequest.isUserInRole("administrator") ||
    (renderRequest.isUserInRole("power-user") && (aceItem.getControlstatus()==0));

if (deleteAllowed) {
    %>
    <liferay-ui:input-checkbox param="<%=checkBoxName%>"/><%
}
%>