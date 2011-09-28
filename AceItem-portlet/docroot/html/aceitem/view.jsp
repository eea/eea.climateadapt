<%--
/**
* Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
*
* This library is free software; you can redistribute it and/or modify it under
* the terms of the GNU Lesser General Public License as published by the Free
* Software Foundation; either version 2.1 of the License, or (at your option)
* any later version.
*
* This library is distributed in the hope that it will be useful, but WITHOUT
* ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
* FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
* details.
*/
--%>

<%@include file="/html/init.jsp" %>

<%
	String redirect = PortalUtil.getCurrentURL(renderRequest);	
%>

<aui:button-row>
	<portlet:actionURL name="synchronizeIndex" var="rebuildIndexURL"/>
	<aui:button value="rebuild-index" onClick="<%= rebuildIndexURL.toString() %>"/>
</aui:button-row>

<aui:button-row>
	<portlet:renderURL var="addAceItemURL">
		<portlet:param name="jspPage" value="/html/aceitem/edit_aceitem.jsp" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>

	<aui:button value="add-aceitem" onClick="<%= addAceItemURL.toString() %>"/>
</aui:button-row>

<liferay-ui:search-container delta='<%= GetterUtil.getInteger(prefs.getValue("rowsPerPage", "10")) %>' emptyResultsMessage="aceitem-empty-results-message">
	<liferay-ui:search-container-results
		results="<%= AceItemLocalServiceUtil.getAceItemsByGroupId(scopeGroupId, searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= AceItemLocalServiceUtil.getAceItemsCountByGroupId(scopeGroupId) %>"
	/>

	<liferay-ui:search-container-row
		className="nl.wur.alterra.cgi.ace.model.AceItem"
		keyProperty="aceItemId"
		modelVar="aceitem" escapedModel="true"
	>
	
<!--  escapedModel="true"  is needed in order to escape the acronym 
      which is accessed by < %= aceitem.getAcronym() % > 
      
      better alternative: als access the acronym by property="acronym"
      properties always get escaped                                   -->
<%
	  String nameLink = aceitem.getName() ;
	  
	  String sectors = aceitem.getSectors_() ;
	  sectors = sectors.replace(";","; ");
	  
	  String elements = aceitem.getElements_() ;
	  elements = elements.replace(";","; ");
	  
	  if (aceitem.getStoragetype().equalsIgnoreCase("URL") || aceitem.getStoragetype().equalsIgnoreCase("GEONETWORK")) {
	  	  // Only URL type gets viewed by viewaceitem portlet; Ace Serviced Entities have their own portlets
		  nameLink = "<a href='/viewaceitem?aceitem_id=" + aceitem.getAceItemId() + "'>" +  aceitem.getName() + "</a>" ;
	  }
%>      
      
		<liferay-ui:search-container-column-text
			name="name"
			value="<%= nameLink %>"
		/>  

		<liferay-ui:search-container-column-text
			name="sectors_"
			value="<%= sectors %>"
		/>

		<liferay-ui:search-container-column-text
			name="storedAt"
			property="storedAt"
		/>

		<liferay-ui:search-container-column-text
			name="elements_"
			value="<%= elements %>"
		/>

		<liferay-ui:search-container-column-text
			name="datatype"
			property="datatype"
		/>

<%
	  if (aceitem.getStoragetype().equalsIgnoreCase("URL")|| aceitem.getStoragetype().equalsIgnoreCase("GEONETWORK")) {
		// Only URL type get maintained here; Ace Serviced Entities have their own maintenance pages
%>		  
	  	
		<liferay-ui:search-container-column-jsp
			align="right"
			path="/html/aceitem/aceitem_actions.jsp"
		/>
<%
	  }
%> 

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>