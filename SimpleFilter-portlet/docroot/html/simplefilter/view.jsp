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

String includeFile = "searchresultsonetype.jspf";

%>
<portlet:actionURL name="searchAceitem" var="searchAceitemURL"/>

<div id="filteraceitems_container">

<portlet:resourceURL var="sortURL" id="view.jsp" escapeXml="false" />

<%-- this is here and not in js file, because we're using some JSP code in it. TODO solve that and move to js file --%>
<script type="text/javascript">

	// ENABLE THIS WHEN RUNNING STANDALONE (WITHOUT REST OF ACE)
	
	
	//var $ = jQuery.noConflict();

    // Stores results for each data type group
    var groupedJSONResults = new Array();

	// display only first 5 searchresults
	jQuery(document).ready(function(){
		for(var i  = 0; i < <%= renderRequest.getPreferences().getValue(Constants.NRITEMSPAGE, "10") %>; i++) {
			$(".searchresult").next().show();
		}
	});     
    
										
</script>

<div id="<portlet:namespace/>content">
</div>

	<!-- Results column  -->
	<div id="filter_results" class="filteraceitems_column">
        <c:set var="groupedResults" scope="page" value="${DOCUMENT_searchResults}"/>
		<c:set var="groupedJSONResults" scope="page" value="${DOCUMENT_JSONsearchResults}"/>
		<c:set var="aceitemtype" scope="page" value="DOCUMENT"/>
		<c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-DOCUMENT" /></c:set>
	
        <%@ include file="searchresultsonetype.jspf" %>

		<c:set var="groupedResults" scope="page" value="${INFORMATIONSOURCE_searchResults}"/>
		<c:set var="groupedJSONResults" scope="page" value="${INFORMATIONSOURCE_JSONsearchResults}"/>
		<c:set var="aceitemtype" scope="page" value="INFORMATIONSOURCE"/>				
		<c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-INFORMATIONSOURCE" /></c:set>

        <%@ include file="searchresultsonetype.jspf" %>

        <c:set var="groupedResults" scope="page" value="${GUIDANCE_searchResults}"/>
        <c:set var="groupedJSONResults" scope="page" value="${GUIDANCE_JSONsearchResults}"/>
        <c:set var="aceitemtype" scope="page" value="GUIDANCE"/>
        <c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-GUIDANCE" /></c:set>

        <%@ include file="searchresultsonetype.jspf" %>

        <c:set var="groupedResults" scope="page" value="${TOOL_searchResults}"/>
        <c:set var="groupedJSONResults" scope="page" value="${TOOL_JSONsearchResults}"/>
        <c:set var="aceitemtype" scope="page" value="TOOL"/>
        <c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-TOOL" /></c:set>

        <%@ include file="searchresultsonetype.jspf" %>

		<c:set var="groupedResults" scope="page" value="${MAPGRAPHDATASET_searchResults}"/>
		<c:set var="groupedJSONResults" scope="page" value="${MAPGRAPHDATASET_JSONsearchResults}"/>
		<c:set var="aceitemtype" scope="page" value="MAPGRAPHDATASET"/>		
		<c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-MAPGRAPHDATASET" /></c:set>

        <%@ include file="searchresultsonetype.jspf" %>

        <c:set var="groupedResults" scope="page" value="${INDICATOR_searchResults}"/>
		<c:set var="groupedJSONResults" scope="page" value="${INDICATOR_JSONsearchResults}"/>
		<c:set var="aceitemtype" scope="page" value="INDICATOR"/>
		<c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-INDICATOR" /></c:set>

        <%@ include file="searchresultsonetype.jspf" %>

        <c:set var="groupedResults" scope="page" value="${RESEARCHPROJECT_searchResults}"/>
		<c:set var="groupedJSONResults" scope="page" value="${RESEARCHPROJECT_JSONsearchResults}"/>
		<c:set var="aceitemtype" scope="page" value="RESEARCHPROJECT"/>
		<c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-RESEARCHPROJECT" /></c:set>

        <%@ include file="searchresultsonetype.jspf" %>

        <c:set var="groupedResults" scope="page" value="${MEASURE_searchResults}"/>
		<c:set var="groupedJSONResults" scope="page" value="${MEASURE_JSONsearchResults}"/>
		<c:set var="aceitemtype" scope="page" value="MEASURE"/>
		<c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-MEASURE" /></c:set>

        <%@ include file="searchresultsonetype.jspf" %>

        <c:set var="groupedResults" scope="page" value="${ACTION_searchResults}"/>
		<c:set var="groupedJSONResults" scope="page" value="${ACTION_JSONsearchResults}"/>
		<c:set var="aceitemtype" scope="page" value="ACTION"/>
		<c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-ACTION" /></c:set>

        <%@ include file="searchresultsonetype.jspf" %>

        <c:set var="groupedResults" scope="page" value="${ORGANISATION_searchResults}"/>
		<c:set var="groupedJSONResults" scope="page" value="${ORGANISATION_JSONsearchResults}"/>
		<c:set var="aceitemtype" scope="page" value="ORGANISATION"/>
		<c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-ORGANISATION" /></c:set>

        <%@ include file="searchresultsonetype.jspf" %>
		
		<%-- TODO all types --%>

	</div>
	
	<hr class="clearer"/>

</div>
