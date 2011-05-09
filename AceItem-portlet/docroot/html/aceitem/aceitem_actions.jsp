<%@include file="/html/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
AceItem aceitem = (AceItem)row.getObject();

long groupId = aceitem.getGroupId();
String name = AceItem.class.getName();
long aceItemId = aceitem.getAceItemId();
long nasId = aceitem.getNasId();

String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<!--  Commented out: no Actons button: liferay-ui:icon-menu -->	

    <!--  START RENDERING edit_aceitem.jsp AT CHOICE edit -->
	<portlet:renderURL var="editURL">
		<portlet:param name="jspPage" value="/html/aceitem/edit_aceitem.jsp" />
		<portlet:param name="aceItemId" value="<%= String.valueOf(aceItemId) %>"/>
		<portlet:param name="redirect" value="<%= redirect %>"/>
	</portlet:renderURL>
	
	<liferay-ui:icon image="edit" url="<%=editURL.toString() %>" />

    <!--  PERFORM PORTLET ACTION deleteAceItem AT CHOICE delete -->
	<portlet:actionURL name="deleteAceItem" var="deleteURL">
		<portlet:param name="aceItemId" value="<%= String.valueOf(aceItemId) %>" />
		<portlet:param name="redirect" value="<%= redirect %>"/>
	</portlet:actionURL>
		
<%
    if(nasId ==0) {
		String confirmURL = "Javascript: if(confirm('Delete?')){document.location.replace('" + deleteURL.toString() + "')};";
%>
		<liferay-ui:icon image="delete" url="<%= confirmURL %>" />

<%
    }
%>

 <!--  Commented out: no Actons button: /liferay-ui:icon-menu -->