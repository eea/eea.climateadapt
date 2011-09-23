<%@page import="nl.wur.alterra.cgi.ace.search.AceSearchFormBean"%>
<%@page import="nl.wur.alterra.cgi.ace.SimpleFilterPortlet"%>
<%@ page import="java.util.Arrays" %>
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

<%@include file="/html/init.jsp" %>

<%
Long totalResults = (Long) request.getAttribute("total_results");

int filter = Integer.parseInt( renderRequest.getPreferences().getValue(Constants.FREEPAR, "0") );

String includeFile = "searchresultsonetype.jspf";

String selected ;

String selected_impact = (String) request.getAttribute(Constants.USERIMPACT);

String selected_sector = (String) request.getAttribute(Constants.USERSECTOR);

if (selected_impact == null || selected_impact.equalsIgnoreCase("all")) {
	
	selected = "";
}
else {
	selected = "selected='selected'";
}

String redirect = PortalUtil.getCurrentURL(renderRequest);

%>
<portlet:actionURL name="searchAceitem" var="searchAceitemURL"/>


<!--  portlet:resourceURL var="sortURL" id="view.jsp" escapeXml="false" / -->

<%-- this is here and not in js file, because we're using some JSP code in it. TODO solve that and move to js file --%>
<script type="text/javascript">

	var groupedJSONResults = new Array();
								
</script>

<div id="<portlet:namespace/>content" style="width: 100%;">
<%
	if (filter==1) {
%>
			<form action="<%=searchAceitemURL%>" method="post" id="ace_simplefilter_30x" name="<portlet:namespace/>aceItemSearchForm">

	<portlet:actionURL name="searchAceitem" var="searchURL">
		<portlet:param name="redirect" value="<%= redirect %>"/>
	</portlet:actionURL>	

       					<div id="risk-selector-div" class="adaptationtools-selector" style="width:288px;">
						<span style="margin-right:10px;float:left;" >
							Climate impact
						</span>
						<select id="risk-selector" name="risk-selector" style="float:left;" onchange="document.getElementById('ace_simplefilter_30x').submit()" >
							<option value="all" <%= selected %>>All climate impacts</option>
							<c:set var="selectedImpact" value="<%= selected_impact %>" />
							<c:forEach var="adaptationClimateImpact" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemClimateImpact.values() %>" >	
							        <option value="${adaptationClimateImpact}"
									<c:if test="${fn:indexOf(selectedImpact, adaptationClimateImpact)>=0}">
										selected='selected'
									</c:if>       
							        ><liferay-ui:message key="aceitem-climateimpacts-lbl-${adaptationClimateImpact}" /></option>
							</c:forEach>
						</select>
					</div>
<%
	if (selected_sector == null || selected_sector.equalsIgnoreCase("all")) {
	
		selected = "";
	}
	else {
		selected = "selected='selected'";
	}
%>					
					<!-- added width because IE8 renders a 100% width otherwise -->
					<div id="sector-selector-div" class="adaptationtools-selector" style="float:left;width:306px;">
						<span style="margin-left:10px; margin-right:10px;float:left;">
							Adaptation sector
						</span>
						<select id="sector-selector" name="sector-selector" style="float:left;" onchange="document.getElementById('ace_simplefilter_30x').submit()" >
							<option value="all" <%= selected %>>All adaptation sectors</option>
							<c:set var="selectedSector" value="<%= selected_sector %>" />
							<c:forEach var="adaptationSector" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemSector.values() %>">	
							        <option value="${adaptationSector}"
									<c:if test="${fn:indexOf(selectedSector, adaptationSector)>=0}">
										selected='selected'
									</c:if>       
							        ><liferay-ui:message key="acesearch-sectors-lbl-${adaptationSector}" /></option>
							</c:forEach>
						</select>
					</div>				
        </form>
        <br />        
        <br />
<% 		
	}
%>
</div>
<div id="filteraceitems_container" style="width: 100%;">
	<!-- Results column  -->
	<div id="filter_results" class="filteraceitems_column">
        <c:set var="groupedResults" scope="page" value="${DOCUMENT_searchResults}"/>
		<c:set var="groupedJSONResults" scope="page" value="${DOCUMENT_JSONsearchResults}"/>
		<c:set var="aceitemtype" scope="page" value="DOCUMENT"/>
		<c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-DOCUMENT" /></c:set>
        
<% 	if( filter <= 1) {	%>	
        <%@ include file="searchresultsonetype.jspf" %>
<% } else { %>	
        <%@ include file="searchresultsgowebsite.jspf" %>
<% } %>	

		<c:set var="groupedResults" scope="page" value="${INFORMATIONSOURCE_searchResults}"/>
		<c:set var="groupedJSONResults" scope="page" value="${INFORMATIONSOURCE_JSONsearchResults}"/>
		<c:set var="aceitemtype" scope="page" value="INFORMATIONSOURCE"/>				
		<c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-INFORMATIONSOURCE" /></c:set>

<% 	if( filter <= 1) {	%>	
        <%@ include file="searchresultsonetype.jspf" %>
<% } else { %>	
        <%@ include file="searchresultsgowebsite.jspf" %>
<% } %>

        <c:set var="groupedResults" scope="page" value="${GUIDANCE_searchResults}"/>
        <c:set var="groupedJSONResults" scope="page" value="${GUIDANCE_JSONsearchResults}"/>
        <c:set var="aceitemtype" scope="page" value="GUIDANCE"/>
        <c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-GUIDANCE" /></c:set>

<% 	if( filter <= 1) {	%>	
        <%@ include file="searchresultsonetype.jspf" %>
<% } else { %>	
        <%@ include file="searchresultsgowebsite.jspf" %>
<% } %>

        <c:set var="groupedResults" scope="page" value="${TOOL_searchResults}"/>
        <c:set var="groupedJSONResults" scope="page" value="${TOOL_JSONsearchResults}"/>
        <c:set var="aceitemtype" scope="page" value="TOOL"/>
        <c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-TOOL" /></c:set>

<% 	if( filter <= 1) {	%>	
        <%@ include file="searchresultsonetype.jspf" %>
<% } else { %>	
        <%@ include file="searchresultsgowebsite.jspf" %>
<% } %>

		<c:set var="groupedResults" scope="page" value="${MAPGRAPHDATASET_searchResults}"/>
		<c:set var="groupedJSONResults" scope="page" value="${MAPGRAPHDATASET_JSONsearchResults}"/>
		<c:set var="aceitemtype" scope="page" value="MAPGRAPHDATASET"/>		
		<c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-MAPGRAPHDATASET" /></c:set>

<% 	if( filter <= 1) {	%>	
        <%@ include file="searchresultsonetype.jspf" %>
<% } else { %>	
        <%@ include file="searchresultsgowebsite.jspf" %>
<% } %>

        <c:set var="groupedResults" scope="page" value="${INDICATOR_searchResults}"/>
		<c:set var="groupedJSONResults" scope="page" value="${INDICATOR_JSONsearchResults}"/>
		<c:set var="aceitemtype" scope="page" value="INDICATOR"/>
		<c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-INDICATOR" /></c:set>

<% 	if( filter <= 1) {	%>	
        <%@ include file="searchresultsonetype.jspf" %>
<% } else { %>	
        <%@ include file="searchresultsgowebsite.jspf" %>
<% } %>

        <c:set var="groupedResults" scope="page" value="${RESEARCHPROJECT_searchResults}"/>
		<c:set var="groupedJSONResults" scope="page" value="${RESEARCHPROJECT_JSONsearchResults}"/>
		<c:set var="aceitemtype" scope="page" value="RESEARCHPROJECT"/>
		<c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-RESEARCHPROJECT" /></c:set>

<% 	if( filter <= 1) {	%>	
        <%@ include file="searchresultsonetype.jspf" %>
<% } else { %>	
        <%@ include file="searchresultsgowebsite.jspf" %>
<% } %>

        <c:set var="groupedResults" scope="page" value="${MEASURE_searchResults}"/>
		<c:set var="groupedJSONResults" scope="page" value="${MEASURE_JSONsearchResults}"/>
		<c:set var="aceitemtype" scope="page" value="MEASURE"/>
		<c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-MEASURE" /></c:set>

<% 	if( filter <= 1) {	%>	
        <%@ include file="searchresultsonetype.jspf" %>
<% } else { %>	
        <%@ include file="searchresultsgowebsite.jspf" %>
<% } %>

        <c:set var="groupedResults" scope="page" value="${ACTION_searchResults}"/>
		<c:set var="groupedJSONResults" scope="page" value="${ACTION_JSONsearchResults}"/>
		<c:set var="aceitemtype" scope="page" value="ACTION"/>
		<c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-ACTION" /></c:set>

<% 	if( filter <= 1) {	%>	
        <%@ include file="searchresultsonetype.jspf" %>
<% } else { %>	
        <%@ include file="searchresultsgowebsite.jspf" %>
<% } %>

        <c:set var="groupedResults" scope="page" value="${ORGANISATION_searchResults}"/>
		<c:set var="groupedJSONResults" scope="page" value="${ORGANISATION_JSONsearchResults}"/>
		<c:set var="aceitemtype" scope="page" value="ORGANISATION"/>
		<c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-ORGANISATION" /></c:set>

<% 	if( filter <= 1) {	%>	
        <%@ include file="searchresultsonetype.jspf" %>
<% } else { %>	
        <%@ include file="searchresultsgowebsite.jspf" %>
<% } %>
		
		<%-- TODO all types --%>

	</div>
	
	<hr class="clearer"/>

</div>
