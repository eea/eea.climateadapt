<%
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
%>

<%@include file="/html/init.jsp" %>

<%

   if ( ! renderRequest.isUserInRole("user") ) { 
 %>
		Please <a href='/home?p_p_id=58&p_p_lifecycle=0&p_p_state=maximized&p_p_mode=view&saveLastPath=0&_58_struts_action=%2Flogin%2Flogin'>sign in with your EIONET account</a> to add a research / knowledge project.
<% }	    
   else {
	   
	String redirect = PortalUtil.getCurrentURL(renderRequest);

	long projectId = 0;
	
	Project project = null;
	
	try {
		projectId = Long.parseLong( (String) renderRequest.getPortletSession().getAttribute("lastAddedProjectId") );
		
		if (projectId > 0) {
			project = ProjectLocalServiceUtil.getProject(projectId);
		}
	}
	catch (Exception e) {
		project = null;
	}
	
%>		
	<portlet:renderURL var="addProjectURL">
		<portlet:param name="jspPage" value="/html/shareinfo/add_project.jsp" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>

	<a href='<%= addProjectURL.toString() %>'>Add a research / knowledge project.</a>
<% 
	if ( (project != null) && (project.getControlstatus() != ACEIndexUtil.Status_APPROVED) ) {
%>
	<portlet:renderURL var="editProjectURL">
		<portlet:param name="jspPage" value="/html/shareinfo/add_project.jsp" />
		<portlet:param name="projectId" value="<%= String.valueOf(projectId) %>"/>
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>
	&nbsp;&nbsp;&nbsp;&nbsp;	
	<a href='<%= editProjectURL.toString() %>'>Modify last edited research / knowledge project.</a>
	
<%	} 
} // else main %>