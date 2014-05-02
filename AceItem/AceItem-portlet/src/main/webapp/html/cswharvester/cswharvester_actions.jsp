<%@include file="/html/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
CSWHarvester cswHarvester = (CSWHarvester)row.getObject();

long groupId = cswHarvester.getGroupId();
String name = CSWHarvester.class.getName();
long cswharvesterid = cswHarvester.getCswharvesterid();
boolean savedToGeoNetwork = cswHarvester.getSavedToGeoNetwork();

int cswharvesterevery = cswHarvester.getEvery();
String cswharvesterstatus = cswHarvester.getStatus();

String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<!--  Commented out: no Actons button: liferay-ui:icon-menu -->	

    <!--  START RENDERING edit_cswharvester.jsp AT CHOICE edit -->
	<portlet:renderURL var="editURL">
		<portlet:param name="jspPage" value="/html/cswharvester/edit_cswharvester.jsp" />
		<portlet:param name="cswharvesterid" value="<%= String.valueOf(cswharvesterid) %>"/>
		<portlet:param name="redirect" value="<%= redirect %>"/>
	</portlet:renderURL>
	
	<liferay-ui:icon image="edit" url="<%=editURL.toString() %>" />

    <!--  PERFORM PORTLET ACTION deleteCSWHarvester AT CHOICE delete -->
	<portlet:actionURL name="deleteCSWHarvester" var="deleteURL">
		<portlet:param name="cswharvesterid" value="<%= String.valueOf(cswharvesterid) %>" />
		<portlet:param name="redirect" value="<%= redirect %>"/>
	</portlet:actionURL>



    <%
		String confirmURL = "Javascript: if(confirm('Delete?')){document.location.replace('" + deleteURL.toString() + "')};";
    %>
    <liferay-ui:icon image="delete" url="<%= confirmURL %>" />

	
<% if (savedToGeoNetwork) { %>
	<portlet:actionURL name="executeCswHarvester" var="executeCswHarvesterURL">
		<portlet:param name="cswharvesterid" value="<%= String.valueOf(cswharvesterid) %>" />
		<portlet:param name="redirect" value="<%= redirect %>"/>
	</portlet:actionURL>
	
        &nbsp;&nbsp;<img id="harvester-execute" onclick="window.location='<%=executeCswHarvesterURL.toString() %>'" src="<%=renderRequest.getContextPath()%>/images/icons/harvester-run.png" alt="Execute harvester" title="Execute harvester"/>

<% } else { %>
	<portlet:actionURL name="saveCSWHarvesterToGeoNetwork"  var="saveCSWHarvesterToGeoNetworkURL">
		<portlet:param name="cswharvesterid" value="<%= String.valueOf(cswharvesterid) %>" />
		<portlet:param name="redirect" value="<%= redirect %>"/>
	</portlet:actionURL>
	
		&nbsp;&nbsp;<liferay-ui:icon image="add"  message="Add to GeoNetwork" url="<%=saveCSWHarvesterToGeoNetworkURL.toString() %>" />

<% } %>

<% if(cswharvesterevery == 0) { %>
        &nbsp;&nbsp;<img id="harvester-scheduled" src="<%=renderRequest.getContextPath()%>/images/icons/harvester-manual.png" alt="Manual harvester execution" title="Manual harvester execution"/>
<% } else { %>
        &nbsp;&nbsp;<img id="harvester-scheduled" src="<%=renderRequest.getContextPath()%>/images/icons/harvester-scheduled.png" alt="Automatic harvester execution" title="Automatic harvester execution"/>
<% } %>

<% if(cswharvesterstatus.equals("NEVER_RUN") || cswharvesterstatus.equals("GEONETWORK_GET_SUCCESS")) { %>
        &nbsp;&nbsp;<img id="harvester-status" src="<%=renderRequest.getContextPath()%>/images/icons/harvester-never-run.png" alt="Waiting for first run" title="Waiting for first run"/>

<% } else if(cswharvesterstatus.equals("RUNNING")) { %>
        &nbsp;&nbsp;<img id="harvester-status" src="<%=renderRequest.getContextPath()%>/images/icons/harvester-running.png" alt="Running" title="Running"/>

<% } else if(cswharvesterstatus.equals("SUCCESS")) { %>
        &nbsp;&nbsp;<img id="harvester-status" src="<%=renderRequest.getContextPath()%>/images/icons/harvester-run-success.png" alt="Succesfully run" title="Succesfully run"/>

<% } else { %>
        &nbsp;&nbsp;<img id="harvester-status" src="<%=renderRequest.getContextPath()%>/images/icons/harvester-run-failure.png" alt="Error: status is <%=cswharvesterstatus%>" title="Error: status is <%=cswharvesterstatus%>"/>
<% } %>

&nbsp;&nbsp;

 <!--  Commented out: no Actons button: /liferay-ui:icon-menu -->