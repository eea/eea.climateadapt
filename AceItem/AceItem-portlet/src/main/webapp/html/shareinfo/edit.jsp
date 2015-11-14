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

<%
	String sharetype = prefs.getValue(Constants.SHARETYPE, AceItemType.DOCUMENT.toString());

	String doc_selected = "";
	String inf_selected = "";
	String gui_selected = "";
	String too_selected = "";
	String org_selected = "";
	String ind_selected = "";
	String map_selected = "";
	
	if (sharetype.equalsIgnoreCase(AceItemType.DOCUMENT.toString())) {
		doc_selected = "selected";  
	}
	else if (sharetype.equalsIgnoreCase(AceItemType.INFORMATIONSOURCE.toString())) {
		inf_selected = "selected";  
	}
	else if (sharetype.equalsIgnoreCase(AceItemType.GUIDANCE.toString())) {
		gui_selected = "selected";  
	}
	else if (sharetype.equalsIgnoreCase(AceItemType.TOOL.toString())) {
		too_selected = "selected";  
	}
	else if (sharetype.equalsIgnoreCase(AceItemType.ORGANISATION.toString())) {
		org_selected = "selected";  
	}
	else if (sharetype.equalsIgnoreCase(AceItemType.INDICATOR.toString())) {
		ind_selected = "selected";
	}
	else if (sharetype.equalsIgnoreCase(AceItemType.MAPGRAPHDATASET.toString())) {
		map_selected = "selected";
	}
%>

<portlet:actionURL name="setAddAceItemPref" var="setAddAceItemPrefUrl" />

<aui:form action="<%= setAddAceItemPrefUrl %>" method="POST" name="fm" >

	<b>Datatype</b><br />
	<select name="<%= Constants.SHARETYPE %>">
		<option value=<%= AceItemType.DOCUMENT.toString() %> <%= doc_selected %>>
				<liferay-ui:message key="acesearch-datainfotype-lbl-DOCUMENT" /></option>
		<option value=<%= AceItemType.INFORMATIONSOURCE.toString() %> <%= inf_selected %>>
				<liferay-ui:message key="acesearch-datainfotype-lbl-INFORMATIONSOURCE" /></option>
		<option value=<%= AceItemType.GUIDANCE.toString() %> <%= gui_selected %>>
				<liferay-ui:message key="acesearch-datainfotype-lbl-GUIDANCE" /></option>
		<option value=<%= AceItemType.TOOL.toString() %> <%= too_selected %>>
				<liferay-ui:message key="acesearch-datainfotype-lbl-TOOL" /></option>
		<option value=<%= AceItemType.ORGANISATION.toString() %> <%= org_selected %>>
				<liferay-ui:message key="acesearch-datainfotype-lbl-ORGANISATION" /></option>
		<option value=<%= AceItemType.INDICATOR.toString() %> <%= ind_selected %>>
				<liferay-ui:message key="acesearch-datainfotype-lbl-INDICATOR" /></option>	
		<option value=<%= AceItemType.MAPGRAPHDATASET.toString() %> <%= map_selected %>>
				<liferay-ui:message key="acesearch-datainfotype-lbl-MAPGRAPHDATASET" /></option>			
	</select>
	
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>