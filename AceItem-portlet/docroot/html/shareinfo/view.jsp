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
	String aceItemType = "";

   if (sharetype.equalsIgnoreCase(AceItemType.DOCUMENT.toString())) {
	   typedescription = "publication or report";
	   aceItemType = "Publication and Reports";
   }
   else if (sharetype.equalsIgnoreCase(AceItemType.INFORMATIONSOURCE.toString())) {
	   typedescription = "information portal";
	   literal = "an ";
	   aceItemType = "Information Portal";
   }
   else if (sharetype.equalsIgnoreCase(AceItemType.GUIDANCE.toString())) {
	   typedescription = "guidance document";
	   aceItemType = "Guidance Document";
   }
   else if (sharetype.equalsIgnoreCase(AceItemType.TOOL.toString())) {
	   typedescription = "tool";
	   aceItemType = "Tools";
   }
   else if (sharetype.equalsIgnoreCase(AceItemType.ORGANISATION.toString())) {
	   typedescription = "organisation";
	   literal = "an ";
	   aceItemType = "Organization";
   }

   if ( ! renderRequest.isUserInRole("user") ) {
%>
		Please <a href='/home?p_p_id=58&p_p_lifecycle=0&p_p_state=maximized&p_p_mode=view&saveLastPath=0&_58_struts_action=%2Flogin%2Flogin'>sign in with your EIONET account</a> to add <%= literal %><%= typedescription %>.
<% }
   else {

	String redirect = PortalUtil.getCurrentURL(renderRequest);

	long aceitemId = 0;

	AceItem aceitemFromMail = null;

	try {
		aceitemId = Long.parseLong( (String) renderRequest.getPortletSession().getAttribute("lastAddedAceItemId") );

		if (aceitemId > 0) {
			aceitemFromMail = AceItemLocalServiceUtil.getAceItem(aceitemId);
		}
	}
	catch (Exception e) {
		aceitemFromMail = null;
	}

%>

    <!-- link for adding new ace item -->
	<portlet:renderURL var="addAceItemURL">
		<portlet:param name="jspPage" value="/html/shareinfo/add_aceitem.jsp" />
	</portlet:renderURL>

	<a href='<%= addAceItemURL.toString() %>'>Add <%= literal %><%= aceItemType %></a><br/><br/>
<%
    // forming link for submitted ace item so the user can still edit the submitted item
	if ( (aceitemFromMail != null) && (aceitemFromMail.getControlstatus() != ACEIndexUtil.Status_APPROVED) ) {
%>
	<portlet:renderURL var="editMailAceItemURL">
		<portlet:param name="jspPage" value="/html/shareinfo/add_aceitem.jsp" />
		<portlet:param name="aceItemId" value="<%= String.valueOf(aceitemId) %>"/>
	</portlet:renderURL>
	
	<a href='<%= editMailAceItemURL.toString() %>'>Modify the submitted <%= aceItemType + ' ' %>'<%=  aceitemFromMail.getName() %>'</a><br/><br/>

	<%	}
	
	// get the ace item types saved by the user
	String moderator = user.getFullName() + " (" + user.getEmailAddress() + ")" ;  
	DynamicQuery query = DynamicQueryFactoryUtil.forClass(AceItem.class);
	query.add(PropertyFactoryUtil.forName("moderator").like(moderator));
	query.add(PropertyFactoryUtil.forName("controlstatus").eq(new Short((short)-1)));
	query.add(PropertyFactoryUtil.forName("datatype").eq(sharetype));
	List results = AceItemLocalServiceUtil.dynamicQuery(query);
	
	if (results != null && results.size() > 0)
	{ %>
	
	   <span style="text-decoration:underline;text-style:normal;">Saved <%=aceItemType %>:</span><br/><br/>
	   
	  <%  List<AceItem> listOfAceItem = (List<AceItem>) results;
	
	
	for (AceItem m: listOfAceItem)
	{
	%>

<portlet:renderURL var="editAceItemURL">
	<portlet:param name="jspPage" value="/html/shareinfo/add_aceitem.jsp" />
	<portlet:param name="aceItemId" value="<%= String.valueOf(m.getAceItemId()) %>"/>
</portlet:renderURL>
&nbsp;&nbsp;&nbsp;&nbsp;
<a href='<%= editAceItemURL.toString() %>'>Modify the saved <%=aceItemType%> <%= m.getName() %>'</a>
</br>

<%	} // end of for
} // end of if results != null


} // else isUserInRole %>