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

<%--
<aui:button-row>
	<portlet:actionURL name="synchronizeIndex" var="rebuildIndexURL"/>
	<aui:button value="rebuild-index" onClick="<%= rebuildIndexURL.toString() %>"/>
</aui:button-row>
--%>

<aui:button-row>
	<portlet:renderURL var="addCSWHarvesterURL">
		<portlet:param name="jspPage" value="/html/cswharvester/edit_cswharvester.jsp" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>

	<aui:button value="add-cswharvester" onClick="<%= addCSWHarvesterURL.toString() %>"/>
</aui:button-row>

<liferay-ui:search-container delta='<%= GetterUtil.getInteger(prefs.getValue("rowsPerPage", "10")) %>' emptyResultsMessage="cswHarvester-empty-results-message">
	<liferay-ui:search-container-results
		results="<%= CSWHarvesterLocalServiceUtil.getCSWHarvestersByGroupId(scopeGroupId, searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= CSWHarvesterLocalServiceUtil.getCSWHarvestersCountByGroupId(scopeGroupId) %>"
	/>

	<liferay-ui:search-container-row
		className="nl.wur.alterra.cgi.ace.model.CSWHarvester"
		keyProperty="cswharvesterid"
		modelVar="cswharvester" escapedModel="true"
	>
	
<!--  escapedModel="true"  is needed in order to escape the acronym 
      which is accessed by < %= aceitem.getAcronym() % > 
      
      better alternative: als access the acronym by property="acronym"
      properties always get escaped                                   -->
<%
	  String nameLink = cswharvester.getName() ;
	  String urlLink = cswharvester.getUrl() ;
	  
	  String availableInGeoNetwork = (cswharvester.getSavedToGeoNetwork() ? "yes" : "no");
%>      
      
		<liferay-ui:search-container-column-text
			name="name"
			value="<%= nameLink %>"
		/>
		
		<liferay-ui:search-container-column-text
			name="url"
			value="<%= urlLink %>"
		/>

		<liferay-ui:search-container-column-text
			name="Available in GeoNetwork"
			value="<%= availableInGeoNetwork %>"
		/>

		<liferay-ui:search-container-column-jsp
			align="right"
			path="/html/cswharvester/cswharvester_actions.jsp"
		/>

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>