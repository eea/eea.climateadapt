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

	String orderByCol = ParamUtil.getString(request, Constants.ORDERBYCOL);
	String orderByType = ParamUtil.getString(request, Constants.ORDERBYTYPE);

	if (Validator.isNotNull(orderByCol) && Validator.isNotNull(orderByType)) {
		prefs.setValue(Constants.ORDERBYCOL, orderByCol);
		prefs.setValue(Constants.ORDERBYTYPE, orderByType);

	} else {

		orderByCol = prefs.getValue(Constants.ORDERBYCOL, "name");
		orderByType = prefs.getValue(Constants.ORDERBYTYPE, "asc");

	}

	OrderByComparator orderByComparator = MeasureUtil.getMeasureOrderByComparator(orderByCol, orderByType);
%>
<aui:button-row>
	<portlet:renderURL var="addMeasureURL">
		<portlet:param name="jspPage" value="/html/measure/edit_measure.jsp" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>

	<aui:button value="add-measure" onClick="<%= addMeasureURL.toString() %>"/>
</aui:button-row>

<liferay-ui:search-container delta='<%= GetterUtil.getInteger(prefs.getValue("rowsPerPage", "75")) %>' emptyResultsMessage="measure-empty-results-message" orderByCol="<%= orderByCol %>" orderByType="<%= orderByType %>">
	<liferay-ui:search-container-results
		results="<%= MeasureLocalServiceUtil.getMeasuresByGroupId(scopeGroupId, searchContainer.getStart(), searchContainer.getEnd(), orderByComparator) %>"
		total="<%= MeasureLocalServiceUtil.getMeasuresCountByGroupId(scopeGroupId) %>"
	/>

	<liferay-ui:search-container-row
		className="nl.wur.alterra.cgi.ace.model.Measure"
		keyProperty="measureId"
		modelVar="measure" escapedModel="true"
	>
	
<!--  escapedModel="true"  is needed in order to escape the acronym 
      which is accessed by < %= measure.getAcronym() % > 
      
      better alternative: als access the acronym by property="acronym"
      properties always get escaped                                   -->	
      
<%
	String nameLink = "<a href='/viewmeasure?ace_measure_id=" + measure.getMeasureId() + "'>" +  measure.getName() + "</a>" ;
	String desc =  measure.getDescription() ;
	if (desc.length() > 300) {
		desc = desc.substring(0,299) + " ..." ;
	}
	
	String sectors = measure.getSectors_() ;
	sectors = sectors.replace(";","; ");
	
	String impacts = measure.getClimateimpacts_() ;
	impacts = impacts.replace(";","; ");	
	
	String type = "Adaptation option";
	if( measure.getMao_type().equalsIgnoreCase("A")) {
		type = "Case study" ;
	}
%>      
      
		<liferay-ui:search-container-column-text
			name="measureId" orderable="<%= true %>" orderableProperty="measureId" >
			<%= measure.getMeasureId() %>
		</liferay-ui:search-container-column-text> 
      
		<liferay-ui:search-container-column-text
			name="name" orderable="<%= true %>" orderableProperty="name" >
			<%= nameLink %>
		</liferay-ui:search-container-column-text>      

		<liferay-ui:search-container-column-text  
			name="reviewed" orderable="<%= true %>" orderableProperty="controlstatus" >
		<%= (measure.getControlstatus()<1 ? "No" : "Yes") %>
		</liferay-ui:search-container-column-text> 

		<liferay-ui:search-container-column-text  
			name="source" orderable="<%= true %>" orderableProperty="source" >
		<%= measure.getSource() %>
		</liferay-ui:search-container-column-text> 
		
		<liferay-ui:search-container-column-text
			name="sectors" 
			value="<%= sectors %>"
		/> 

		<liferay-ui:search-container-column-text
			name="impacts"
			value="<%= impacts %>"
		/>

		<liferay-ui:search-container-column-text
			name="lon" 
			value='<%= "" + measure.getLon() %>'
		/>

		<liferay-ui:search-container-column-text
			name="type" orderable="<%= true %>" orderableProperty="type" 
			value="<%= type %>"
		/>
<%
			if(measure.getReplacesId() !=  measure.getMeasureId()) {
			// Only editable if no candidate item exists for this measure
%>
		<liferay-ui:search-container-column-jsp
			align="right"
			path="/html/measure/measure_actions.jsp"
		/>
<%			
	  }
%> 		
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>