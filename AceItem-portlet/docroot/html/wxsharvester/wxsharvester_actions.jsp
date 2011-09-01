<%@include file="/html/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
WxsHarvester wxsHarvester = (WxsHarvester)row.getObject();

long groupId = wxsHarvester.getGroupId();
String name = WxsHarvester.class.getName();
long wxsharvesterid = wxsHarvester.getWxsharvesterid();
boolean savedToGeoNetwork = wxsHarvester.getSavedToGeoNetwork();

String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<!--  Commented out: no Actons button: liferay-ui:icon-menu -->	

    <!--  START RENDERING edit_wxsharvester.jsp AT CHOICE edit -->
	<portlet:renderURL var="editURL">
		<portlet:param name="jspPage" value="/html/wxsharvester/edit_wxsharvester.jsp" />
		<portlet:param name="wxsharvesterid" value="<%= String.valueOf(wxsharvesterid) %>"/>
		<portlet:param name="redirect" value="<%= redirect %>"/>
	</portlet:renderURL>
	
	<liferay-ui:icon image="edit" url="<%=editURL.toString() %>" />

    <!--  PERFORM PORTLET ACTION deleteWxsHarvester AT CHOICE delete -->
	<portlet:actionURL name="deleteWxsHarvester" var="deleteURL">
		<portlet:param name="wxsharvesterid" value="<%= String.valueOf(wxsharvesterid) %>" />
		<portlet:param name="redirect" value="<%= redirect %>"/>
	</portlet:actionURL>



    <%
		String confirmURL = "Javascript: if(confirm('Delete?')){document.location.replace('" + deleteURL.toString() + "')};";
    %>
    <liferay-ui:icon image="delete" url="<%= confirmURL %>" />

	
<% if (savedToGeoNetwork) { %>
	<portlet:actionURL name="executeWxsHarvester" var="executeWxsHarvesterURL">
		<portlet:param name="wxsharvesterid" value="<%= String.valueOf(wxsharvesterid) %>" />
		<portlet:param name="redirect" value="<%= redirect %>"/>
	</portlet:actionURL>
	
		&nbsp;&nbsp;<liferay-ui:icon image="copy" message="Execute harvester" url="<%=executeWxsHarvesterURL.toString() %>" />

<% } else { %>
	<portlet:actionURL name="saveWxsHarvesterToGeoNetwork"  var="saveWxsHarvesterToGeoNetworkURL">
		<portlet:param name="wxsharvesterid" value="<%= String.valueOf(wxsharvesterid) %>" />
		<portlet:param name="redirect" value="<%= redirect %>"/>
	</portlet:actionURL>
	
		&nbsp;&nbsp;<liferay-ui:icon image="add"  message="Add to GeoNetwork" url="<%=saveWxsHarvesterToGeoNetworkURL.toString() %>" />

<% } %>
 <!--  Commented out: no Actons button: /liferay-ui:icon-menu -->