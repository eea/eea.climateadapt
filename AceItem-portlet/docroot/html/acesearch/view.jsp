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


// Retrieve parameters to fill form
String anyOfThese = ParamUtil.getString(request, "anyOfThese");

String datainfo_type = ParamUtil.getString(request, "datainfo_type");
if ((datainfo_type == null) || (datainfo_type.equals(""))) datainfo_type = "1";

String date_type = ParamUtil.getString(request, "date_type");
if ((date_type == null) || (date_type.equals(""))) date_type = "1";


String[] aceitemtypes = request.getParameterValues("aceitemtype");
if (aceitemtypes == null) aceitemtypes =  new String[0];
List<String> aceitemtypesList = Arrays.asList(aceitemtypes);


String initial_date = ParamUtil.getString(request, "initial_date");
String final_date = ParamUtil.getString(request, "final_date");
String simple_date = ParamUtil.getString(request, "simple_date");

String[] sectors = request.getParameterValues("sector");
if (sectors == null) sectors =  new String[0];
List<String> sectorsList = Arrays.asList(sectors);


%>


<portlet:actionURL name="searchAceitem" var="searchAceitemURL"/>

<div id="acesearch_container">

<portlet:resourceURL var="sortURL" id="view.jsp" escapeXml="false" />

<%-- this is here and not in js file, because we're using some JSP code in it. TODO solve that and move to js file --%>
<script type="text/javascript">

	// display only first 5 searchresults
	jQuery(document).ready(function(){
		for(var i  = 0; i < 5; i++) {
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
		var querystring = 'anyOfThese=' + $j("#sortsearchformId-"+unique + " input[name=anyOfThese]").val();
		querystring += '&aceitemtype=' + $j("#sortsearchformId-"+unique + " input[name=aceitemtype]").val();
        if ($j("#sortsearchformId-"+unique + " input[name=sector]").val() != undefined) {
		    querystring += '&sector=' + $j("#sortsearchformId-"+unique + " input[name=sector]").val();
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
				var firstFiveAceitemResults = new Array();
				for(var i = 0; i < 5; i++) {
					firstFiveAceitemResults.push(aceitemResults[i]);
				}
				displayJSONResults(unique, firstFiveAceitemResults);
				$j('#paginationId-'+unique + ' .jPag-pages li:first-child a').click();
			} 
		});
 
		function displayJSONResults(unique, aceitemResults) {
			var resultlist = '<div id="resultsListId-'+unique+'">';
			jQuery.each(aceitemResults, function(idx, aceitem){ 
				// add searchresult
				resultlist += '<div class="searchresult">';
				// add name and description
				if (aceitem._storedAt.substr(0, 4) == "http") {
					resultlist += '<div><span class="bolder">&#187; <a href="' + aceitem._storedAt + '">' + aceitem._name + '</a></span> - ' + aceitem._description + '</div>';
				} else {
					resultlist += '<div><span class="bolder">&#187; ' + aceitem._name + ' </span> - ' + aceitem._description + '</div>';
				}
				// add result footer 
				// TODO use actual date from aceitem, if available
				resultlist += '<div class="resultfooter"><hr class="clearer"/></div>';
				// close searchresult
				resultlist += '</div>';					
			});
			// close searchresultlist
			resultlist += '</div>';
			$j('#expandedId-'+unique).append(resultlist);
		}

	}
										
</script>

<div id="<portlet:namespace/>content">
</div>



    <!-- Search colum -->
    <div id="acesearch_column" class="acesearch_column">
        <aui:form action="<%=searchAceitemURL%>" method="post" name="<portlet:namespace/>aceItemSearchForm">
            <div class="search_section">
                <h2><liferay-ui:message key="acesearch-section-header1" /></h2>

                <div class="row">
                    <label for="anyOfThese" class="input"><liferay-ui:message key="acesearch-lbl-allwords" /></label>
                    <input type="text" class="text" name="anyOfThese" id="anyOfThese" value="<%= anyOfThese %>"/>
                </div>
            </div>

            <div class="search_section">
                <h2><liferay-ui:message key="acesearch-section-header2" /></h2>

                <div class="row">
                    <input type="radio" name="datainfo_type" value="1" <%= (datainfo_type.equals("1"))?"checked":"" %> /><liferay-ui:message key="acesearch-datainfotype-lbl-all" />
                    <input type="radio" name="datainfo_type" value="2" <%= (datainfo_type.equals("2"))?"checked":"" %> /><liferay-ui:message key="acesearch-datainfotype-lbl-sel" />

                    <div id="all_selection_types">
                        <div class="checks_container">

                            <div class="check">
                                <input type="checkbox" name="aceitemtype" id="chk_type_articles" value="ARTICLE" <%= aceitemtypesList.contains("ARTICLE")?"checked":"" %> />
                                <label for="chk_type_articles"><liferay-ui:message key="acesearch-datainfotype-lbl-articles" /></label>
                            </div>

                            <div class="check">
                                <input type="checkbox" name="aceitemtype" id="chk_type_lists" value="LIST" <%= aceitemtypesList.contains("LIST")?"checked":"" %> />
                                <label for="chk_type_lists"><liferay-ui:message key="acesearch-datainfotype-lbl-lists" /></label>
                            </div>

                            <div class="check">
                                <input type="checkbox" name="aceitemtype" id="chk_type_datasets" value="DATA" <%= aceitemtypesList.contains("DATA")?"checked":"" %> />
                                <label for="chk_type_datasets"><liferay-ui:message key="acesearch-datainfotype-lbl-datasets" /></label>
                            </div>

                            <div class="check">
                                <input type="checkbox" name="aceitemtype" id="chk_type_tables" value="TABLE" <%= aceitemtypesList.contains("TABLE")?"checked":"" %> />
                                <label for="chk_type_tables"><liferay-ui:message key="acesearch-datainfotype-lbl-tables" /></label>
                            </div>

                            <div class="check">
                                <input type="checkbox" name="aceitemtype" id="chk_type_indicators" value="INDICATOR" <%= aceitemtypesList.contains("INDICATOR")?"checked":"" %> />
                                <label for="chk_type_indicators"><liferay-ui:message key="acesearch-datainfotype-lbl-indicators" /></label>
                            </div>

                            <div class="check">
                                <input type="checkbox" name="aceitemtype" id="chk_type_tools" value="TOOL" <%= aceitemtypesList.contains("TOOL")?"checked":"" %> />
                                <label for="chk_type_tools"><liferay-ui:message key="acesearch-datainfotype-lbl-tools" /></label>
                            </div>

                            <div class="check">
                                <input type="checkbox" name="aceitemtype" id="chk_type_maps" value="MAP" <%= aceitemtypesList.contains("MAP")?"checked":"" %> />
                                <label for="chk_type_maps"><liferay-ui:message key="acesearch-datainfotype-lbl-maps" /></label>
                            </div>

                            <div class="check">
                                <input type="checkbox" name="aceitemtype" id="chk_type_multimedia" value="MULTIMEDIA" <%= aceitemtypesList.contains("MULTIMEDIA")?"checked":"" %> />
                                <label for="chk_type_multimedia"><liferay-ui:message key="acesearch-datainfotype-lbl-multimedia" /></label>
                            </div>

                            <div class="check">
                                <input type="checkbox" name="aceitemtype" id="chk_type_flood" value="FLOOD"  <%= aceitemtypesList.contains("FLOOD")?"checked":"" %> />
                                <label for="chk_type_flood"><liferay-ui:message key="acesearch-datainfotype-lbl-flood" /></label>
                            </div>

                        </div>
                    </div>
                </div>
            </div>

            <div class="search_section">
                <h2><liferay-ui:message key="acesearch-section-header3" /></h2>

                <div class="row">
                    <input type="radio" name="date_type" value="1" <%= (date_type.equals("1"))?"checked":"" %> /><liferay-ui:message key="acesearch-datetype-lbl-all" />
                    <input type="radio" name="date_type" value="2" <%= (date_type.equals("2"))?"checked":"" %> /><liferay-ui:message key="acesearch-datetype-lbl-range" />
                    <input type="radio" name="date_type" value="3" <%= (date_type.equals("3"))?"checked":"" %> /><liferay-ui:message key="acesearch-datetype-lbl-simple" />

                    <div id="range_dates">
                        <div class="row">
                            <label for="initial_date" class="input_small"><liferay-ui:message key="acesearch-datetype-lbl-initialdate" /></label>
                            <input type="text" class="date" name="initial_date" id="initial_date" value="<%= initial_date %>" />
                        </div>
                        <div class="row">
                            <label for="final_date" class="input_small"><liferay-ui:message key="acesearch-datetype-lbl-finaldate" /></label>
                            <input type="text" class="date" name="final_date" id="final_date" value="<%= final_date %>"/>
                        </div>

                    </div>

                    <div id="specific_date">
                        <div class="row">
                            <label for="simple_date" class="input_small"><liferay-ui:message key="acesearch-datetype-lbl-date" /></label>
                            <input type="text" class="date" name="simple_date" id="simple_date" value="<%= simple_date %>" />
                        </div>
                    </div>
                </div>
            </div>

            <div class="search_section">
                <h2><liferay-ui:message key="acesearch-section-header4" /></h2>
                <ul>
                    <li>
                        <a href="#" id="adaptation_sectors_btn" class="expanded_section"><liferay-ui:message key="acesearch-section-adaptation-sectors" /></a>

                        <div id="adaptation_sectors_container" class="checks_container">

                            <div class="check">
                                <input type="checkbox" name="sector" id="chk_sectors_agriculture" value="AGRICULTURE" <%= sectorsList.contains("AGRICULTURE")?"checked":"" %> />
                                <label for="chk_sectors_agriculture"><liferay-ui:message key="acesearch-sectors-lbl-agriculture" /></label>
                            </div>

                            <div class="check">
                                <input type="checkbox" name="sector" id="chk_sectors_health" value="HEALTH" <%= sectorsList.contains("HEALTH")?"checked":"" %> />
                                <label for="chk_sectors_health"><liferay-ui:message key="acesearch-sectors-lbl-health" /></label>
                            </div>

                            <div class="check">
                                <input type="checkbox" name="sector" id="chk_sectors_biodiversity" value="BIODIVERSITY" <%= sectorsList.contains("BIODIVERSITY")?"checked":"" %> />
                                <label for="chk_sectors_biodiversity"><liferay-ui:message key="acesearch-sectors-lbl-biodiversity" /></label>
                            </div>

                            <div class="check">
                                <input type="checkbox" name="sector" id="chk_sectors_tourism" value="TOURISM" <%= sectorsList.contains("TOURISM")?"checked":"" %> />
                                <label for="chk_sectors_tourism"><liferay-ui:message key="acesearch-sectors-lbl-tourism" /></label>
                            </div>

                            <div class="check">
                                <input type="checkbox" name="sector" id="chk_sectors_coastal" value="COASTAL" <%= sectorsList.contains("COASTAL")?"checked":"" %> />
                                <label for="chk_sectors_coastal"><liferay-ui:message key="acesearch-sectors-lbl-coastal" /></label>
                            </div>

                            <div class="check">
                                <input type="checkbox" name="sector" id="chk_sectors_transport" value="TRANSPORT" <%= sectorsList.contains("TRANSPORT")?"checked":"" %> />
                                <label for="chk_sectors_transport"><liferay-ui:message key="acesearch-sectors-lbl-transport" /></label>
                            </div>

                            <div class="check">
                                <input type="checkbox" name="sector" id="chk_sectors_fisheries" value="FISHERIES" <%= sectorsList.contains("FISHERIES")?"checked":"" %> />
                                <label for="chk_sectors_fisheries"><liferay-ui:message key="acesearch-sectors-lbl-fisheries" /></label>
                            </div>

                            <div class="check">
                                <input type="checkbox" name="sector" id="chk_sectors_water" value="WATER" <%= sectorsList.contains("WATER")?"checked":"" %> />
                                <label for="chk_sectors_water"><liferay-ui:message key="acesearch-sectors-lbl-water" /></label>
                            </div>

                            <div class="check">
                                <input type="checkbox" name="sector" id="chk_sectors_flood" value="FLOOD" <%= sectorsList.contains("FLOOD")?"checked":"" %> />
                                <label for="chk_sectors_flood"><liferay-ui:message key="acesearch-sectors-lbl-flood" /></label>
                             </div>

                        </div>
                    </li>

                    <li>
                        <a href="#" class="collapsed_section"><liferay-ui:message key="acesearch-section-countries" /></a>
                    </li>

                    <li>
                        <a href="#" class="collapsed_section"><liferay-ui:message key="acesearch-section-adaptation-pillars" /></a>
                    </li>
                </ul>
            </div>

            <div id="form_footer">
                <input type="button" id="clear-search-form-btn" value="<liferay-ui:message key="acesearch-reset-btn" />" />
                <input type="submit" value="<liferay-ui:message key="acesearch-search-btn" />"/>
            </div>
        </aui:form>
    </div>

	<!-- Results column  -->
	<div id="search_results" class="acesearch_column">
	
		<h1>Data & downloads</h1>
		
		<h2 id="searchresultstitle">Search results</h2>

        <c:if test="<%= totalResults != null %>">
            <c:choose>
                <c:when test="<%= totalResults == 0 %>">
                <h3><liferay-ui:message key="acesearch-no-results" /></h3>
                </c:when>
                <c:otherwise>
                <h3><liferay-ui:message key="acesearch-total-results" /> <%= totalResults%></h3>
                </c:otherwise>
            </c:choose>
			
        </c:if> 

		<c:set var="groupedResults" scope="page" value="${ARTICLE_searchResults}"/>
		<c:set var="groupedJSONResults" scope="page" value="${ARTICLE_JSONsearchResults}"/>		
		<c:set var="aceitemtype" scope="page" value="ARTICLE"/>		
		<c:set var="groupTitle" scope="page" value="Articles and publications"/>
		<%@ include file="searchresultsbytype.jspf" %>
		 
		<c:set var="groupedResults" scope="page" value="${MAP_searchResults}"/>
		<c:set var="groupedJSONResults" scope="page" value="${MAP_JSONsearchResults}"/>
		<c:set var="aceitemtype" scope="page" value="MAP"/>		
		<c:set var="groupTitle" scope="page" value="Maps"/>			
		<%@ include file="searchresultsbytype.jspf" %>	
		
		<c:set var="groupedResults" scope="page" value="${MULTIMEDIA_searchResults}"/>
		<c:set var="groupedJSONResults" scope="page" value="${MULTIMEDIA_JSONsearchResults}"/>
		<c:set var="aceitemtype" scope="page" value="MULTIMEDIA"/>				
		<c:set var="groupTitle" scope="page" value="Multimedia"/>			
		<%@ include file="searchresultsbytype.jspf" %>					 

		<c:set var="groupedResults" scope="page" value="${DATA_searchResults}"/>
		<c:set var="groupedJSONResults" scope="page" value="${DATA_JSONsearchResults}"/>
		<c:set var="aceitemtype" scope="page" value="DATA"/>				
		<c:set var="groupTitle" scope="page" value="Data (sets)"/>			
		<%@ include file="searchresultsbytype.jspf" %>	
		
		<%-- TODO all types --%>

	</div>
	
	<hr class="clearer"/>

</div>
