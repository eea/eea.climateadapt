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

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@include file="/html/init.jsp" %>

<liferay-ui:success key="project-added" message="project-added-successfully" />
<liferay-ui:success key="project-updated" message="project-updated-successfully" />
<liferay-ui:success key="project-deleted" message="project-deleted-successfully" />

<%
	String redirect = PortalUtil.getCurrentURL(renderRequest);	
%>

<aui:button-row>
	<portlet:renderURL var="addProjectURL">
		<portlet:param name="jspPage" value="/html/project/edit_project.jsp" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>

	<aui:button value="add-project" onClick="<%= addProjectURL.toString() %>"/>
</aui:button-row>

<liferay-ui:search-container delta='<%= GetterUtil.getInteger(prefs.getValue("rowsPerPage", "10")) %>' emptyResultsMessage="project-empty-results-message">
	<liferay-ui:search-container-results
		results="<%= ProjectLocalServiceUtil.getProjectsByGroupId(scopeGroupId, searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= ProjectLocalServiceUtil.getProjectsCountByGroupId(scopeGroupId) %>"
	/>

	<liferay-ui:search-container-row
		className="nl.wur.alterra.cgi.ace.model.Project"
		keyProperty="projectId"
		modelVar="project" escapedModel="true"
	>
	
<!--  escapedModel="true"  is needed in order to escape the acronym 
      which is accessed by < %= project.getAcronym() % > 
      
      better alternative: als access the acronym by property="acronym"
      properties always get escaped                                   -->	
		<liferay-ui:search-container-column-text
			name="acronym"
			value="<%= project.getAcronym() %>"
		/>

		<liferay-ui:search-container-column-text
			name="title"
			property="title"
		/>

		<liferay-ui:search-container-column-text
			name="lead"
			property="lead"
		/>

		<liferay-ui:search-container-column-text
			name="sectors"
			property="sectors"
		/>

		<liferay-ui:search-container-column-text
			name="duration"
			property="duration"
		/>

		<liferay-ui:search-container-column-jsp
			align="right"
			path="/html/project/project_actions.jsp"
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>