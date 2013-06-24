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
   String mao_type = prefs.getValue(Constants.mao_typePreferenceName, "A");

   if ( ! renderRequest.isUserInRole("user") ) {
%>
		Please <a href='/home?p_p_id=58&p_p_lifecycle=0&p_p_state=maximized&p_p_mode=view&saveLastPath=0&_58_struts_action=%2Flogin%2Flogin'>sign in with your EIONET account</a> to <%= mao_type.equalsIgnoreCase("A") ? "add a case study" : "add an adaptation option" %>.
<% }
   else {
	   
	 Measure measure = null;

	 // We don't need it as the back button always comes to the view.jsp
	 /*  String redirect = PortalUtil.getCurrentURL(renderRequest); */
	
    // looking for measure from email
	long measureId = 0;

	Measure measureFromMail = null;
	try {
		measureId = Long.parseLong( (String) renderRequest.getPortletSession().getAttribute("lastAddedMeasureId") );


		if (measureId > 0) {
			measureFromMail = MeasureLocalServiceUtil.getMeasure(measureId);

		}
	}
	catch (Exception e) {
		measureFromMail = null;
	} 
 
%>
	
	<portlet:renderURL var="addMeasureURLRevised">
		<portlet:param name="jspPage" value="/html/shareinfo/add_measureRevised.jsp" />
	</portlet:renderURL>

	<a href='<%= addMeasureURLRevised.toString() %>'><%= mao_type.equalsIgnoreCase("A") ? "Add a case study" : "Add an adaptation option" %></a><br/><br/>
	
	
	<% if (measureFromMail != null) { %>
		 <portlet:renderURL var="mailMeasureURL">
			<portlet:param name="jspPage" value="/html/shareinfo/add_measureRevised.jsp" />
			<portlet:param name="measureId" value="<%= String.valueOf(measureFromMail.getMeasureId()) %>"/>
		 </portlet:renderURL>
		 
		  <span style="text-decoration:underline;text-style:normal;">Reviewed case study:</span><br/><br/>
		  <a href='<%= mailMeasureURL.toString() %>'><%= mao_type.equalsIgnoreCase("A") ? "Modify the submitted case study as requested by Reviewer" : "Modify the submitted adaptation option as requested by Reviewer" %></a><br/><br/>
	<% } %>
	
	<% 
		// get the case studies saved by the user
		String moderator = user.getFullName() + " (" + user.getEmailAddress() + ")" ;  
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(Measure.class);
		query.add(PropertyFactoryUtil.forName("moderator").like(moderator));
		query.add(PropertyFactoryUtil.forName("controlstatus").eq(new Short((short)-1)));
		List results = MeasureLocalServiceUtil.dynamicQuery(query);
		
		if (results != null && results.size() > 0)
		{
			
		%>
		   <span style="text-decoration:underline;text-style:normal;">Saved Case Studies:</span><br/><br/>
		  
		<% 
		   List<Measure> listOfMeasure = (List<Measure>) results;
		
		
		for (Measure m: listOfMeasure)
		{
	%>
 
	<portlet:renderURL var="editMeasureURL">
		<portlet:param name="jspPage" value="/html/shareinfo/add_measureRevised.jsp" />
		<portlet:param name="measureId" value="<%= String.valueOf(m.getMeasureId()) %>"/>
	</portlet:renderURL>
	&nbsp;&nbsp;&nbsp;&nbsp;
	<a href='<%= editMeasureURL.toString() %>'><%= mao_type.equalsIgnoreCase("A") ? "Modify the saved case study " : "Modify the saved adaptation option " %>'<%= m.getName() %>'</a>
	</br>

<%	} // end of for
  } // end of if results != null
} // else main %>