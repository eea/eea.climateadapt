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
   String sharetype = prefs.getValue(Constants.SHARETYPE, AceItemType.DOCUMENT.toString());

	String typedescription = "";
	String literal = "a ";

   if (sharetype.equalsIgnoreCase(AceItemType.DOCUMENT.toString())) {
	   typedescription = "publication or report";
   }
   else if (sharetype.equalsIgnoreCase(AceItemType.INFORMATIONSOURCE.toString())) {
	   typedescription = "information portal";
	   literal = "an ";
   }
   else if (sharetype.equalsIgnoreCase(AceItemType.GUIDANCE.toString())) {
	   typedescription = "guidance document";
   }
   else if (sharetype.equalsIgnoreCase(AceItemType.TOOL.toString())) {
	   typedescription = "tool";
   }
   else if (sharetype.equalsIgnoreCase(AceItemType.ORGANISATION.toString())) {
	   typedescription = "organisation";
	   literal = "an ";
   }

   if ( ! renderRequest.isUserInRole("user") ) {
%>
		Please <a href='/home?p_p_id=58&p_p_lifecycle=0&p_p_state=maximized&p_p_mode=view&saveLastPath=0&_58_struts_action=%2Flogin%2Flogin'>sign in with your EIONET account</a> to add <%= literal %><%= typedescription %>.
<% }
   else {

	String redirect = PortalUtil.getCurrentURL(renderRequest);

	long aceitemId = 0;

	AceItem aceitem = null;

	try {
		aceitemId = Long.parseLong( (String) renderRequest.getPortletSession().getAttribute("lastAddedAceItemId") );

		if (aceitemId > 0) {
			aceitem = AceItemLocalServiceUtil.getAceItem(aceitemId);
		}
	}
	catch (Exception e) {
		aceitem = null;
	}

%>
	<portlet:renderURL var="addAceItemURL">
		<portlet:param name="jspPage" value="/html/shareinfo/add_aceitem.jsp" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>

	<a href='<%= addAceItemURL.toString() %>'>Add <%= literal %><%= typedescription %></a>
<%
	if ( (aceitem != null) && (aceitem.getControlstatus() != ACEIndexUtil.Status_APPROVED) ) {
%>
	<portlet:renderURL var="editAceItemURL">
		<portlet:param name="jspPage" value="/html/shareinfo/add_aceitem.jsp" />
		<portlet:param name="aceItemId" value="<%= String.valueOf(aceitemId) %>"/>
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>
	&nbsp;&nbsp;&nbsp;&nbsp;
	<a href='<%= editAceItemURL.toString() %>'>Modify last edited <%= typedescription %></a>

<%	}
} // else isUserInRole %>