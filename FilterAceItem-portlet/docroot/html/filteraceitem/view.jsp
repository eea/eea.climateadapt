<%@page import="nl.wur.alterra.cgi.ace.search.AceSearchFormBean"%>
<%@page import="nl.wur.alterra.cgi.ace.search.SearchRequestParams"%>
<%@page import="nl.wur.alterra.cgi.ace.portlet.FilterAceItemPortlet"%>
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

int paging = Integer.parseInt( renderRequest.getPreferences().getValue(Constants.PAGING, "0") );

long sofarnr = 0;

long prefnritemspage = Long.parseLong(renderRequest.getPreferences().getValue(Constants.NRITEMSPAGE, "10"));

AceSearchFormBean acesearchformbean = (AceSearchFormBean) request.getAttribute(SearchRequestParams.SEARCH_PARAMS);

// Retrieve parameters to fill form
String anyOfThese = acesearchformbean.getAnyOfThese();
	
String[] aceitemtypes = acesearchformbean.getAceitemtype();

String[] sectors = acesearchformbean.getSector();
	
String[] elements = acesearchformbean.getElement();
	
String[] countries = acesearchformbean.getCountries();

String searchstring = "";

String searchbasestring = "/data-and-downloads" ;

String handle = "?" ;

if( anyOfThese != null) { 
	searchbasestring += handle + "searchtext=" + anyOfThese ; 
	handle="&" ; 
}

if(  sectors != null) { 
	searchbasestring += handle + "searchsectors=" ;
	handle="&" ; 			
	for(int j=0; j < sectors.length; j++ ) 
		{ searchbasestring += (j > 0 ? ";" : "" ) + sectors[j] ; } 
}
	
if(  elements != null) { 
	searchbasestring += handle + "searchelements=" ;
	handle="&" ; 			
	for(int j=0; j < elements.length; j++ ) 
		{ searchbasestring += (j > 0 ? ";" : "" ) + elements[j] ; } 
}
	
if(  countries != null) { 
	searchbasestring += handle + "searchcountries=" ;
	handle="&" ; 			
	for(int j=0; j < countries.length; j++ ) 
		{ searchbasestring += (j > 0 ? ";" : "" ) + countries[j] ; } 
}

%>
<portlet:actionURL name="searchAceitem" var="searchAceitemURL"/>

<div id="filteraceitems_container">

<portlet:resourceURL var="sortURL" id="view.jsp" escapeXml="false" />

<%-- this is here and not in js file, because we're using some JSP code in it. TODO solve that and move to js file --%>
<script type="text/javascript">

	// ENABLE THIS WHEN RUNNING STANDALONE (WITHOUT REST OF ACE- view.jsp from FilterAceItem-portlet)
	var $j = jQuery.noConflict();

    // Stores results for each data type group
    var groupedJSONResults = new Array();

	// display only first 5 searchresults
	jQuery(document).ready(function(){
		for(var i  = 0; i < <%= renderRequest.getPreferences().getValue(Constants.NRITEMSPAGE, "10") %>; i++) {
			$j(".searchresult").next().show();
		}
	});     

    /**
	 * retrieves search parameters from the sort-search form that invoked this, executes the search through XHR, and sets json response to correct search results panel.
	 *
	 */ 
	function sortedSearch(sortRadio) {	
		// grab unique part, after dash
		var unique = sortRadio.id.match(/-([0-9]+)/)[1];	
		var sortedSearchForm = $j("#sortsearchformId-"+unique);		
		var querystring = 'datainfo_type=2&anyOfThese=' + $j("#sortsearchformId-"+unique + " input[name=anyOfThese]").val();
		querystring += '&aceitemtype=' + $j("#sortsearchformId-"+unique + " input[name=aceitemtype]").val();
        if ($j("#sortsearchformId-"+unique + " input[name=sector]").val() != undefined) {
		    querystring += '&sector=' + $j("#sortsearchformId-"+unique + " input[name=sector]").val();
        } 
        if ($j("#sortsearchformId-"+unique + " input[name=element]").val() != undefined) {
		    querystring += '&element=' + $j("#sortsearchformId-"+unique + " input[name=element]").val();
        } 		
		querystring += '&initial_date=' + $j("#sortsearchformId-"+unique + " input[name=initial_date]").val(); 
		querystring += '&final_date=' + $j("#sortsearchformId-"+unique + " input[name=final_date]").val(); 
		querystring += '&simple_date=' + $j("#sortsearchformId-"+unique + " input[name=simple_date]").val(); 
		querystring += '&sortBy=' + $j('#'+sortRadio.id).val();
		// replace existing resultlist with loading icon 
		$j('#resultsListId-'+unique).remove();
		$j('#expandedId-'+unique).append('<div id="loadingId-'+unique+'" style="text-align:center;"><img src="<%=renderRequest.getContextPath()%>/images/icons/loading.gif" title="loading" alt="loading"></div>');
		jQuery.ajax({
			type: "POST",
			url: "<%=renderResponse.encodeURL(sortURL.toString())%>",
			data: querystring,
			success: function(json) {

				// remove loading icon and add results to resultlist	
				$j('#loadingId-'+unique).remove();
				var aceitemResults = new Array();
				aceitemResults = jQuery.parseJSON(json);	

                // Updates the results for each data type sorted
                groupedJSONResults[$j("#sortsearchformId-"+unique + " input[name=aceitemtype]").val()] = aceitemResults;

                var firstAceitemResults = new Array();
				for(var i = 0; i < <%= renderRequest.getPreferences().getValue(Constants.NRITEMSPAGE, "10") %>; i++) {
					firstAceitemResults.push(aceitemResults[i]);
				}
				//displayJSONResults(unique, firstAceitemResults);
				$j('#paginationId-'+unique).trigger('setPage', [0]); // invokes displayJSONResults
			} 
		});
		
	}      
										
</script>

<div id="<portlet:namespace/>content">
</div>

	<!-- Results column  -->
	<!-- determine the results contain multiple data types -->
	
   <c:set var="cnt" value="0" />
	
   <c:if test="${fn:length(DOCUMENT_searchResults) > 0}">
       <c:set var="cnt" value="${cnt+1}" />
   </c:if>
   
   <c:if test="${fn:length(INFORMATIONSOURCE_searchResults) > 0}">
       <c:set var="cnt" value="${cnt+1}" />
   </c:if>
   
   <c:if test="${fn:length(GUIDANCE_searchResults) > 0}">
       <c:set var="cnt" value="${cnt+1}" />
   </c:if>
   
   <c:if test="${fn:length(TOOL_searchResults) > 0}">
       <c:set var="cnt" value="${cnt+1}" />
   </c:if>
   
   <c:if test="${fn:length(RESEARCHPROJECT_searchResults) > 0}">
       <c:set var="cnt" value="${cnt+1}" />
   </c:if>
   
    <c:if test="${fn:length(MEASURE_searchResults) > 0}">
       <c:set var="cnt" value="${cnt+1}" />
   </c:if>
   
    <c:if test="${fn:length(ORGANISATION_searchResults) > 0}">
       <c:set var="cnt" value="${cnt+1}" />
   </c:if>
	 
	<div id="filter_results" class="filteraceitems_column">
        <c:set var="groupedResults" scope="page" value="${DOCUMENT_searchResults}"/>
		<c:set var="groupedJSONResults" scope="page" value="${DOCUMENT_JSONsearchResults}"/>
		<c:set var="aceitemtype" scope="page" value="DOCUMENT"/>
		<c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-DOCUMENT" /></c:set>
<% 	if( paging > 0) {	
		searchstring = searchbasestring	+ handle + "searchtypes=DOCUMENT"; // no handle adjustment %>
        <%@ include file="searchresultsbytype.jspf" %>
<% } else if( sofarnr < prefnritemspage ) { %>	
        <%@ include file="searchresultsonetype.jspf" %>
<% } %>	        
		<c:set var="groupedResults" scope="page" value="${INFORMATIONSOURCE_searchResults}"/>
		<c:set var="groupedJSONResults" scope="page" value="${INFORMATIONSOURCE_JSONsearchResults}"/>
		<c:set var="aceitemtype" scope="page" value="INFORMATIONSOURCE"/>				
		<c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-INFORMATIONSOURCE" /></c:set>
<% 	if( paging > 0) {		
		searchstring = searchbasestring	+ handle + "searchtypes=INFORMATIONSOURCE"; // no handle adjustment %>
        <%@ include file="searchresultsbytype.jspf" %>
<% } else if( sofarnr < prefnritemspage ) { %>	
        <%@ include file="searchresultsonetype.jspf" %>
<% } %>

        <c:set var="groupedResults" scope="page" value="${GUIDANCE_searchResults}"/>
        <c:set var="groupedJSONResults" scope="page" value="${GUIDANCE_JSONsearchResults}"/>
        <c:set var="aceitemtype" scope="page" value="GUIDANCE"/>
        <c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-GUIDANCE" /></c:set>
<% 	if( paging > 0) {		
		searchstring = searchbasestring	+ handle + "searchtypes=GUIDANCE"; // no handle adjustment %>
        <%@ include file="searchresultsbytype.jspf" %>
<% } else if( sofarnr  < prefnritemspage ) { %>	
        <%@ include file="searchresultsonetype.jspf" %>
<% } %>       

        <c:set var="groupedResults" scope="page" value="${TOOL_searchResults}"/>
        <c:set var="groupedJSONResults" scope="page" value="${TOOL_JSONsearchResults}"/>
        <c:set var="aceitemtype" scope="page" value="TOOL"/>
        <c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-TOOL" /></c:set>
<% 	if( paging > 0) {		
		searchstring = searchbasestring	+ handle + "searchtypes=TOOL"; // no handle adjustment %>
        <%@ include file="searchresultsbytype.jspf" %>
<% } else if( sofarnr  < prefnritemspage ) { %>	
        <%@ include file="searchresultsonetype.jspf" %>
<% } %>

		<c:set var="groupedResults" scope="page" value="${MAPGRAPHDATASET_searchResults}"/>
		<c:set var="groupedJSONResults" scope="page" value="${MAPGRAPHDATASET_JSONsearchResults}"/>
		<c:set var="aceitemtype" scope="page" value="MAPGRAPHDATASET"/>		
		<c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-MAPGRAPHDATASET" /></c:set>
<% 	if( paging > 0) {		
		searchstring = searchbasestring	+ handle + "searchtypes=MAPGRAPHDATASET"; // no handle adjustment %>
        <%@ include file="searchresultsbytype.jspf" %>
<% } else if( sofarnr  < prefnritemspage ) { %>	
        <%@ include file="searchresultsonetype.jspf" %>
<% } %>
		
        <c:set var="groupedResults" scope="page" value="${INDICATOR_searchResults}"/>
		<c:set var="groupedJSONResults" scope="page" value="${INDICATOR_JSONsearchResults}"/>
		<c:set var="aceitemtype" scope="page" value="INDICATOR"/>
		<c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-INDICATOR" /></c:set>
<% 	if( paging > 0) {		
		searchstring = searchbasestring	+ handle + "searchtypes=INDICATOR"; // no handle adjustment %>
        <%@ include file="searchresultsbytype.jspf" %>
<% } else if( sofarnr  < prefnritemspage ) { %>	
        <%@ include file="searchresultsonetype.jspf" %>
<% } %>

        <c:set var="groupedResults" scope="page" value="${RESEARCHPROJECT_searchResults}"/>
		<c:set var="groupedJSONResults" scope="page" value="${RESEARCHPROJECT_JSONsearchResults}"/>
		<c:set var="aceitemtype" scope="page" value="RESEARCHPROJECT"/>
		<c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-RESEARCHPROJECT" /></c:set>
<% 	if( paging > 0) {		
		searchstring = searchbasestring	+ handle + "searchtypes=RESEARCHPROJECT"; // no handle adjustment %>
        <%@ include file="searchresultsbytype.jspf" %>
<% } else if( sofarnr  < prefnritemspage ) { %>	
        <%@ include file="searchresultsonetype.jspf" %>
<% } %>

        <c:set var="groupedResults" scope="page" value="${MEASURE_searchResults}"/>
		<c:set var="groupedJSONResults" scope="page" value="${MEASURE_JSONsearchResults}"/>
		<c:set var="aceitemtype" scope="page" value="MEASURE"/>
		<c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-MEASURE" /></c:set>
<% 	if( paging > 0) {		
		searchstring = searchbasestring	+ handle + "searchtypes=MEASURE"; // no handle adjustment %>
        <%@ include file="searchresultsbytype.jspf" %>
<% } else if( sofarnr  < prefnritemspage ) { %>	
        <%@ include file="searchresultsonetype.jspf" %>
<% } %>

        <c:set var="groupedResults" scope="page" value="${ACTION_searchResults}"/>
		<c:set var="groupedJSONResults" scope="page" value="${ACTION_JSONsearchResults}"/>
		<c:set var="aceitemtype" scope="page" value="ACTION"/>
		<c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-ACTION" /></c:set>
<% 	if( paging > 0) {		
		searchstring = searchbasestring	+ handle + "searchtypes=ACTION"; // no handle adjustment %>	
        <%@ include file="searchresultsbytype.jspf" %>
<% } else if( sofarnr < prefnritemspage ) { %>	
        <%@ include file="searchresultsonetype.jspf" %>
<% } %>

        <c:set var="groupedResults" scope="page" value="${ORGANISATION_searchResults}"/>
		<c:set var="groupedJSONResults" scope="page" value="${ORGANISATION_JSONsearchResults}"/>
		<c:set var="aceitemtype" scope="page" value="ORGANISATION"/>
		<c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-ORGANISATION" /></c:set>
<% 	if( paging > 0) {		
		searchstring = searchbasestring	+ handle + "searchtypes=ORGANISATION"; // no handle adjustment %>
        <%@ include file="searchresultsbytype.jspf" %>
<% } else if( sofarnr < prefnritemspage) { %>	
        <%@ include file="searchresultsonetype.jspf" %>
<% } %>
<% 	if( (paging == 0) && (sofarnr < totalResults)){	
	
		if( aceitemtypes != null) { 
			searchbasestring += handle + "searchtypes=" ;
			handle="&" ; 			
			for(int j=0; j < aceitemtypes.length; j++ )
				{ searchbasestring += (j > 0 ? ";" : "" ) + aceitemtypes[j] ; } 
		}

%>		
		<div class='searchAll' style='text-align: right'>
			<br /><a href='<%= searchbasestring %>'>View all</a>
		</div>
<% 		
	} %>		

	</div>
	
	<% 
		String portletId = themeDisplay.getPortletDisplay().getId();
		javax.portlet.PortletPreferences portletSetup = PortletPreferencesFactoryUtil.getLayoutPortletSetup(themeDisplay.getLayout(), portletId);
		String portletCustomTitle = themeDisplay.getPortletDisplay().getTitle();
		portletCustomTitle = portletSetup.getValue("portlet-setup-title-" + themeDisplay.getLanguageId(),portletCustomTitle);
	
	   if ( ! ( portletCustomTitle.equalsIgnoreCase("discover") || portletCustomTitle.equalsIgnoreCase("search results") || portletCustomTitle.equalsIgnoreCase("interactive maps"))) { %>
	    <c:if test="${cnt gt 1 }">
	          <c:set var="url" scope="page" value="/share-your-info" />
	          <div class="bluebuttondiv">
	           <a href="${url}" class="bluebutton">Share your information</a>
	        </div>
	     </c:if>	
	<% } %>
	<hr class="clearer"/>

</div>
