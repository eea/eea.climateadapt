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
%>

<aui:button-row>
	<portlet:renderURL var="addMeasureURL">
		<portlet:param name="jspPage" value="/html/measure/edit_measure.jsp" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>

	<aui:button value="add-measure" onClick="<%= addMeasureURL.toString() %>"/>
</aui:button-row>

<liferay-ui:search-container delta='10' emptyResultsMessage="measure-empty-results-message">
	<liferay-ui:search-container-results
		results="<%= MeasureLocalServiceUtil.getMeasuresByGroupId(scopeGroupId, searchContainer.getStart(), searchContainer.getEnd()) %>"
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
		<liferay-ui:search-container-column-text
			name="name"
			value="<%= measure.getName() %>"
		/>
		<liferay-ui:search-container-column-text
			name="description"
			property="description"
		/>

		<liferay-ui:search-container-column-text
			name="sectors_"
			property="sectors_"
		/>

		<liferay-ui:search-container-column-text
			name="elements_"
			property="elements_"
		/>

		<liferay-ui:search-container-column-text
			name="climateimpacts_"
			property="climateimpacts_"
		/>

		<liferay-ui:search-container-column-jsp
			align="right"
			path="/html/measure/measure_actions.jsp"
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>