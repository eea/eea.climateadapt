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
   String mao_type = prefs.getValue(Constants.mao_typePreferenceName, "A");

   if ( ! renderRequest.isUserInRole("user") ) { // || renderRequest.isUserInRole("portal-content-reviewer") ) { 
	    // if approved only administrator can delete; otherwise also power user can delete %>
		Please sign in (at the upper right menu bar) to <%= mao_type.equalsIgnoreCase("A") ? "add a case study" : "add an adaptation option" %>.
<% }	    
   else {
	   
	String redirect = PortalUtil.getCurrentURL(renderRequest);

	long measureId = 0;
	
	Measure measure = null;
	
	try {
		measureId = Long.parseLong( (String) renderRequest.getPortletSession().getAttribute("lastAddedMeasureId") );
		
		if (measureId > 0) {
			measure = MeasureLocalServiceUtil.getMeasure(measureId);
		}
	}
	catch (NumberFormatException e) {
		// do nothing
	}
	
%>		
	<portlet:renderURL var="addMeasureURL">
		<portlet:param name="jspPage" value="/html/shareinfo/add_measure.jsp" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>

	<a href='<%= addMeasureURL.toString() %>'><%= mao_type.equalsIgnoreCase("A") ? "Add a case study" : "Add an adaptation option" %></a>
<% 
	if ( (measure != null) && (measure.getControlstatus() == 0) ) {
%>
	<portlet:renderURL var="editMeasureURL">
		<portlet:param name="jspPage" value="/html/shareinfo/add_measure.jsp" />
		<portlet:param name="measureId" value="<%= String.valueOf(measureId) %>"/>
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>
	&nbsp;&nbsp;&nbsp;&nbsp;	
	<a href='<%= editMeasureURL.toString() %>'><%= mao_type.equalsIgnoreCase("A") ? "Modify last added case study" : "Modify last added adaptation option" %></a>
	
<%	} 
} // else main %>