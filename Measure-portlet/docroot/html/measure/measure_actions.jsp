<%@include file="/html/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Measure measure = (Measure)row.getObject();

long groupId = measure.getGroupId();
String name = Measure.class.getName();
long measureId = measure.getMeasureId();

String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<!--  Commented out: no Actons button: liferay-ui:icon-menu -->	

    <!--  START RENDERING edit_measure.jsp AT CHOICE edit -->
	<portlet:renderURL var="editURL">
		<portlet:param name="jspPage" value="/html/measure/edit_measure.jsp" />
		<portlet:param name="measureId" value="<%= String.valueOf(measureId) %>"/>
		<portlet:param name="redirect" value="<%= redirect %>"/>
	</portlet:renderURL>
	
	<liferay-ui:icon image="edit" url="<%=editURL.toString() %>" />

    <!--  PERFORM PORTLET ACTION deleteMeasure AT CHOICE delete -->
	<portlet:actionURL name="deleteMeasure" var="deleteURL">
		<portlet:param name="measureId" value="<%= String.valueOf(measureId) %>" />
		<portlet:param name="redirect" value="<%= redirect %>"/>
	</portlet:actionURL>

<%
String confirmURL = "Javascript: if(confirm('Delete?')){document.location.replace('" + deleteURL.toString() + "')};";
%>
	<liferay-ui:icon image="delete" url="<%= confirmURL %>" />		

<!--  Commented out: no Actons button: /liferay-ui:icon-menu -->