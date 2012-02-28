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
	String redirect = PortalUtil.getCurrentURL(renderRequest);

	String mao_type = prefs.getValue(Constants.mao_typePreferenceName, "A");
%>

	<portlet:renderURL var="addMeasureURL">
		<portlet:param name="jspPage" value="/html/shareinfo/add_measure.jsp" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>

	<a href='<%= addMeasureURL.toString() %>'><%= mao_type.equalsIgnoreCase("A") ? "Add a case study" : "Add an adaptation option" %></a>
