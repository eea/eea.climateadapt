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

<liferay-ui:success key="contribution-success" message="contribution-successful" />

<%
   
   if ( ! renderRequest.isUserInRole("user") ) {
 %>
		Please <a href='/home?p_p_id=58&p_p_lifecycle=0&p_p_state=maximized&p_p_mode=view&saveLastPath=0&_58_struts_action=%2Flogin%2Flogin'>sign in with your EIONET account</a> to add a research / knowledge project.
<% }
   else {

	String redirect = PortalUtil.getCurrentURL(renderRequest);

	long projectId = 0;

	Project projectFromMail = null;

	try {
		projectId = Long.parseLong( (String) renderRequest.getPortletSession().getAttribute("lastAddedProjectId") );

		if (projectId > 0) {
			projectFromMail = ProjectLocalServiceUtil.getProject(projectId);
		}
	}
	catch (Exception e) {
		projectFromMail = null;
	}

%>
	<portlet:renderURL var="addProjectURLRevised">
		<portlet:param name="jspPage" value="/html/shareinfo/add_projectRevised.jsp" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>

	<a href='<%= addProjectURLRevised.toString() %>'>Add a Research / Knowledge project.</a><br/><br/>
<%
	if  (projectFromMail != null)  {
%>
	<portlet:renderURL var="mailProjectURL">
		<portlet:param name="jspPage" value="/html/shareinfo/add_projectRevised.jsp" />
		<portlet:param name="projectId" value="<%= String.valueOf(projectId) %>"/>
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>
	 <span style="text-decoration:underline;text-style:normal;">Reviewed Research / Knowledge project:</span><br/><br/>
	 <a href='<%= mailProjectURL.toString() %>'>Modify the submitted Research / Knowledge project '<%= projectFromMail.getAcronym() %>' as requested by Reviewer</a><br/><br/>

<%	}

        //get the case studies saved by the user
		String moderator = user.getFullName() + " (" + user.getEmailAddress() + ")" ;  
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(Project.class);
		query.add(PropertyFactoryUtil.forName("moderator").like(moderator));
		query.add(PropertyFactoryUtil.forName("controlstatus").eq(new Short((short)-1)));
		List results = ProjectLocalServiceUtil.dynamicQuery(query);
		
		if (results != null && results.size() > 0)
		{
		 %>
		   <span style="text-decoration:underline;text-style:normal;">Saved Research / Knowledge projects:</span><br/><br/>
		<% 
		   
		   List<Project> listOfProjects = (List<Project>) results;
		
		
		for (Project m: listOfProjects)
		{
	%>

	<portlet:renderURL var="editMeasureURL">
		<portlet:param name="jspPage" value="/html/shareinfo/add_projectRevised.jsp" />
		<portlet:param name="projectId" value="<%= String.valueOf(m.getProjectId()) %>"/>
	</portlet:renderURL>
	&nbsp;&nbsp;&nbsp;&nbsp;
	<a href='<%= editMeasureURL.toString() %>'>Modify the saved Research / Knowledge project <%= m.getAcronym() %></a>
	</br>

<%	} // end of for
} // end of if results != null
} // else main %>