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
pageContext.setAttribute("aceitemtypesList", aceitemtypesList);

String initial_date = ParamUtil.getString(request, "initial_date");
String final_date = ParamUtil.getString(request, "final_date");
String simple_date = ParamUtil.getString(request, "simple_date");

String[] sectors = request.getParameterValues("sector");
if (sectors == null) sectors = new String[0];
List<String> sectorsList = Arrays.asList(sectors);
pageContext.setAttribute("sectorsList", sectorsList);

String[] elements = request.getParameterValues("element");
if (elements == null) elements = new String[0];
List<String> elementsList = Arrays.asList(elements);
pageContext.setAttribute("elementsList", elementsList);

String[] countries = request.getParameterValues("countries");
if (countries == null) countries = new String[0];
List<String> countriesList = Arrays.asList(countries);
pageContext.setAttribute("countriesList", countriesList);
%>


<portlet:actionURL name="searchAceitem" var="searchAceitemURL"/>

<div id="acesearch_container">

<portlet:resourceURL var="sortURL" id="view.jsp" escapeXml="false" />

<%-- this is here and not in js file, because we're using some JSP code in it. TODO solve that and move to js file --%>
<script type="text/javascript">

	// ENABLE THIS WHEN RUNNING STANDALONE (WITHOUT REST OF ACE)
	var $j = jQuery.noConflict();

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
				var firstFiveAceitemResults = new Array();
				for(var i = 0; i < 5; i++) {
					firstFiveAceitemResults.push(aceitemResults[i]);
				}
				displayJSONResults(unique, firstFiveAceitemResults);
				$j('#paginationId-'+unique + ' .jPag-pages li:first-child a').click();
			} 
		});
		
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
							<%-- note : i18n file should always be in sync with AceItemType enum --%>						
							<c:forEach var="aceItemType" items="<%= nl.wur.alterra.cgi.ace.model.impl.AceItemType.values() %>" >	
								<div class="check">
									<c:set var="aceItemMustBeChecked" value="false" />
									<c:forEach var="requestedAceItemType" items="${aceitemtypesList}">
										<c:if test="${requestedAceItemType eq aceItemType}">
											<c:set var="aceItemMustBeChecked" value="true" />
										</c:if>
									</c:forEach>	
									<c:choose>
										<c:when test="${aceItemMustBeChecked}">
											<input type="checkbox" name="aceitemtype" id="chk_type_${aceItemType}" value="${aceItemType}" checked="checked" />
										</c:when>
										<c:otherwise>
											<input type="checkbox" name="aceitemtype" id="chk_type_${aceItemType}" value="${aceItemType}" />
										</c:otherwise>
									</c:choose>
									<label for="chk_type_${aceItemType}"><liferay-ui:message key="acesearch-datainfotype-lbl-${aceItemType}" /></label>								
								</div>							
							</c:forEach>						
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
							<%-- note : i18n file should always be in sync with AceItemSector enum --%>	
							<c:forEach var="adaptationSector" items="<%= nl.wur.alterra.cgi.ace.model.impl.AceItemSector.values() %>" >							
								<div class="check">
									<c:set var="adaptationSectorMustBeChecked" value="false" />
									<c:forEach var="requestedSector" items="${sectorsList}">
										<c:if test="${requestedSector eq adaptationSector}">
											<c:set var="adaptationSectorMustBeChecked" value="true" />
										</c:if>
									</c:forEach>	
									<c:choose>
										<c:when test="${adaptationSectorMustBeChecked}">
											<input type="checkbox" name="sector" id="chk_sectors_${adaptationSector}" value="${adaptationSector}" checked="checked" />
										</c:when>
										<c:otherwise>
											<input type="checkbox" name="sector" id="chk_sectors_${adaptationSector}" value="${adaptationSector}" />
										</c:otherwise>
									</c:choose>
									<label for="chk_sectors_${adaptationSector}"><liferay-ui:message key="acesearch-sectors-lbl-${adaptationSector}" /></label>
								</div>							
							</c:forEach>
                        </div>
                    </li>

                    <li>
                        <a href="#" id="countries_btn" class="collapsed_section"><liferay-ui:message key="acesearch-section-countries" /></a>
                        <div id="countries_container" class="checks_container">
                            <%-- note : i18n file should always be in sync with AceItemCountry enum --%>
							<c:forEach var="countryElement" items="<%= nl.wur.alterra.cgi.ace.model.impl.AceItemCountry.values() %>" >
								<div class="check">
									<c:set var="countryElementMustBeChecked" value="false" />
									<c:forEach var="requestedElement" items="${countriesList}">
										<c:if test="${requestedElement eq countryElement}">
											<c:set var="countryElementMustBeChecked" value="true" />
										</c:if>
									</c:forEach>
									<c:choose>
										<c:when test="${countryElementMustBeChecked}">
											<input type="checkbox" name="countries" id="chk_countries_${countryElement}" value="${countryElement}" checked="checked" />
										</c:when>
										<c:otherwise>
											<input type="checkbox" name="countries" id="chk_countries_${countryElement}" value="${countryElement}" />
										</c:otherwise>
									</c:choose>
									<label for="chk_countries_${countryElement}"><liferay-ui:message key="acesearch-country-lbl-${countryElement}" /></label>
								</div>
							</c:forEach>
                        </div>

                    </li>

                    <li>
                        <a href="#" id="adaptation_elements_btn" class="collapsed_section"><liferay-ui:message key="acesearch-section-adaptation-elements" /></a>
                        <div id="adaptation_elements_container" class="checks_container">		
							<%-- note : i18n file should always be in sync with AceItemElement enum --%>
							<c:forEach var="adaptationElement" items="<%= nl.wur.alterra.cgi.ace.model.impl.AceItemElement.values() %>" >
								<div class="check">
									<c:set var="adaptationElementMustBeChecked" value="false" />
									<c:forEach var="requestedElement" items="${elementsList}">
										<c:if test="${requestedElement eq adaptationElement}">
											<c:set var="adaptationElementMustBeChecked" value="true" />
										</c:if>
									</c:forEach>	
									<c:choose>
										<c:when test="${adaptationElementMustBeChecked}">
											<input type="checkbox" name="element" id="chk_elements_${adaptationElement}" value="${adaptationElement}" checked="checked" />
										</c:when>
										<c:otherwise>
											<input type="checkbox" name="element" id="chk_elements_${adaptationElement}" value="${adaptationElement}" />
										</c:otherwise>
									</c:choose>
									<label for="chk_elements_${adaptationElement}"><liferay-ui:message key="acesearch-elements-lbl-${adaptationElement}" /></label>
								</div>							
							</c:forEach>
                        </div>						
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
	
		<h1><liferay-ui:message key="acesearch-data-downloads-header" /></h1>
		
		<h2 id="searchresultstitle"><liferay-ui:message key="acesearch-results-header" /></h2>

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

        <c:set var="groupedResults" scope="page" value="${DOCUMENT_searchResults}"/>
		<c:set var="groupedJSONResults" scope="page" value="${DOCUMENT_JSONsearchResults}"/>
		<c:set var="aceitemtype" scope="page" value="DOCUMENT"/>
		<c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-DOCUMENT" /></c:set>
		<%@ include file="searchresultsbytype.jspf" %>

        <c:set var="groupedResults" scope="page" value="${TABLE_searchResults}"/>
        <c:set var="groupedJSONResults" scope="page" value="${TABLE_JSONsearchResults}"/>
        <c:set var="aceitemtype" scope="page" value="TABLE"/>
        <c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-TABLE" /></c:set>
        <%@ include file="searchresultsbytype.jspf" %>
		   
		<c:set var="groupedResults" scope="page" value="${ARTICLE_searchResults}"/>
		<c:set var="groupedJSONResults" scope="page" value="${ARTICLE_JSONsearchResults}"/>		
		<c:set var="aceitemtype" scope="page" value="ARTICLE"/>		
		<c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-ARTICLE" /></c:set>
		<%@ include file="searchresultsbytype.jspf" %>

        <c:set var="groupedResults" scope="page" value="${TOOLGUIDANCE_searchResults}"/>
        <c:set var="groupedJSONResults" scope="page" value="${TOOLGUIDANCE_JSONsearchResults}"/>
        <c:set var="aceitemtype" scope="page" value="TABLE"/>
        <c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-TOOLGUIDANCE" /></c:set>
        <%@ include file="searchresultsbytype.jspf" %>

		<c:set var="groupedResults" scope="page" value="${MAP_searchResults}"/>
		<c:set var="groupedJSONResults" scope="page" value="${MAP_JSONsearchResults}"/>
		<c:set var="aceitemtype" scope="page" value="MAP"/>		
		<c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-MAP" /></c:set>
		<%@ include file="searchresultsbytype.jspf" %>	
		
		<c:set var="groupedResults" scope="page" value="${MULTIMEDIA_searchResults}"/>
		<c:set var="groupedJSONResults" scope="page" value="${MULTIMEDIA_JSONsearchResults}"/>
		<c:set var="aceitemtype" scope="page" value="MULTIMEDIA"/>				
		<c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-MULTIMEDIA" /></c:set>
		<%@ include file="searchresultsbytype.jspf" %>

        <c:set var="groupedResults" scope="page" value="${INDICATOR_searchResults}"/>
		<c:set var="groupedJSONResults" scope="page" value="${INDICATOR_JSONsearchResults}"/>
		<c:set var="aceitemtype" scope="page" value="INDICATOR"/>
		<c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-INDICATOR" /></c:set>
		<%@ include file="searchresultsbytype.jspf" %>

		<c:set var="groupedResults" scope="page" value="${DATASET_searchResults}"/>
		<c:set var="groupedJSONResults" scope="page" value="${DATASET_JSONsearchResults}"/>
		<c:set var="aceitemtype" scope="page" value="DATASET"/>				
		<c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-DATASET" /></c:set>
		<%@ include file="searchresultsbytype.jspf" %>

        <c:set var="groupedResults" scope="page" value="${RESEARCHPROJECT_searchResults}"/>
		<c:set var="groupedJSONResults" scope="page" value="${RESEARCHPROJECT_JSONsearchResults}"/>
		<c:set var="aceitemtype" scope="page" value="RESEARCHPROJECT"/>
		<c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-RESEARCHPROJECT" /></c:set>
		<%@ include file="searchresultsbytype.jspf" %>

          <c:set var="groupedResults" scope="page" value="${MEASURE_searchResults}"/>
		<c:set var="groupedJSONResults" scope="page" value="${MEASURE_JSONsearchResults}"/>
		<c:set var="aceitemtype" scope="page" value="MEASURE"/>
		<c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-MEASURE" /></c:set>
		<%@ include file="searchresultsbytype.jspf" %>

        <c:set var="groupedResults" scope="page" value="${ACTION_searchResults}"/>
		<c:set var="groupedJSONResults" scope="page" value="${ACTION_JSONsearchResults}"/>
		<c:set var="aceitemtype" scope="page" value="MEASUREACTIONOPTION"/>
		<c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-ACTION" /></c:set>
		<%@ include file="searchresultsbytype.jspf" %>

        <c:set var="groupedResults" scope="page" value="${ORGANISATION_searchResults}"/>
		<c:set var="groupedJSONResults" scope="page" value="${ORGANISATION_JSONsearchResults}"/>
		<c:set var="aceitemtype" scope="page" value="ORGANISATION"/>
		<c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-ORGANISATION" /></c:set>
		<%@ include file="searchresultsbytype.jspf" %>
		
		<%-- TODO all types --%>

	</div>
	
	<hr class="clearer"/>

</div>
