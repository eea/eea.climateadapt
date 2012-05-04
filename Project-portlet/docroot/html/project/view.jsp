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

	String orderByCol = ParamUtil.getString(request, Constants.ORDERBYCOL);
	String orderByType = ParamUtil.getString(request, Constants.ORDERBYTYPE);
	
	if (Validator.isNotNull(orderByCol)) {
		renderRequest.getPortletSession().setAttribute(Constants.ORDERBYCOL, orderByCol );
	}
	else {
		orderByCol = (String) renderRequest.getPortletSession().getAttribute(Constants.ORDERBYCOL);
	}
	if (Validator.isNotNull(orderByType)) {
		renderRequest.getPortletSession().setAttribute(Constants.ORDERBYTYPE, orderByType );
	}
	else {
		orderByType = (String) renderRequest.getPortletSession().getAttribute(Constants.ORDERBYTYPE);
	}	
	
	if (Validator.isNotNull(orderByCol) && Validator.isNotNull(orderByType)) {
		//prefs.setValue(Constants.ORDERBYCOL, orderByCol);
		//prefs.setValue(Constants.ORDERBYTYPE, orderByType);
	
		renderRequest.getPortletSession().setAttribute(Constants.ORDERBYCOL, orderByCol );
		renderRequest.getPortletSession().setAttribute(Constants.ORDERBYTYPE, orderByType );		
	
	} else {
	
		orderByCol = prefs.getValue(Constants.ORDERBYCOL, "acronym");
		orderByType = prefs.getValue(Constants.ORDERBYTYPE, "asc");
		renderRequest.getPortletSession().setAttribute(Constants.ORDERBYCOL, orderByCol );
		renderRequest.getPortletSession().setAttribute(Constants.ORDERBYTYPE, orderByType );
	
	}
	
	orderByCol = (String) renderRequest.getPortletSession().getAttribute(Constants.ORDERBYCOL);
	orderByType = (String) renderRequest.getPortletSession().getAttribute(Constants.ORDERBYTYPE);

	OrderByComparator orderByComparator = ProjectUtil.getProjectOrderByComparator(orderByCol, orderByType);
%>

<aui:button-row>
	<portlet:renderURL var="addProjectURL">
		<portlet:param name="jspPage" value="/html/project/edit_project.jsp" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>

	<aui:button value="add-project" onClick="<%= addProjectURL.toString() %>"/>
</aui:button-row>

<liferay-ui:search-container delta='<%= GetterUtil.getInteger(prefs.getValue("rowsPerPage", "75")) %>' emptyResultsMessage="project-empty-results-message" orderByCol="<%= orderByCol %>" orderByType="<%= orderByType %>">
	<liferay-ui:search-container-results
		results="<%= ProjectLocalServiceUtil.getProjectsByGroupId(scopeGroupId, searchContainer.getStart(), searchContainer.getEnd(), orderByComparator) %>"
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

<%
	String acronymLink = "<a href='/projects1?ace_project_id=" + project.getProjectId() + "'>" +  project.getAcronym() + "</a>" ;

	  String sectors = project.getSectors() ;
	  sectors = sectors.replace(";","; ");	
	  
	  String elements = project.getElement() ;
	  elements = elements.replace(";","; ");	
%>      
		<liferay-ui:search-container-column-text
			name="projectId" orderable="<%= true %>" orderableProperty="projectId" >
			<%= project.getProjectId() %>
		</liferay-ui:search-container-column-text> 
		      
		<liferay-ui:search-container-column-text
			name="acronym" orderable="<%= true %>" orderableProperty="acronym" >
			<%= acronymLink %>
		</liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-text
			name="title"
			property="title"
		/>
		
		<liferay-ui:search-container-column-text  
			name="status" orderable="<%= true %>" orderableProperty="controlstatus" >
		<%= (project.getControlstatus()<ACEIndexUtil.Status_APPROVED ? (project.getControlstatus()==ACEIndexUtil.Status_SUBMITTED ? "Submitted" : "Draft") : "Approved") %>
		</liferay-ui:search-container-column-text> 

		<liferay-ui:search-container-column-text  
			name="source" orderable="<%= true %>" orderableProperty="source" >
		<%= project.getSource() %>
		</liferay-ui:search-container-column-text> 
				
		<liferay-ui:search-container-column-text
			name="sectors"
			value="<%= sectors %>"
		/>

		<liferay-ui:search-container-column-text
			name="elements"
			value="<%= elements %>"
		/>
<%
			if(project.getReplacesId() !=  project.getProjectId()) {
			// Only editable if no candidate item exists for this project
%>
		<liferay-ui:search-container-column-jsp
			align="right"
			path="/html/project/project_actions.jsp"
		/>
<%			
	  }
%> 		
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>