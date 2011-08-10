<%@page import="nl.wur.alterra.cgi.ace.search.AceSearchFormBean"%>
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

AceSearchFormBean acesearchformbean = (AceSearchFormBean) request.getAttribute(FilterAceItemPortlet.SEARCH_PARAMS);

// Retrieve parameters to fill form
String anyOfThese = acesearchformbean.getAnyOfThese();
	
String datainfo_type = null;
if ((datainfo_type == null) || (datainfo_type.equals(""))) datainfo_type = "1";
	
String date_type = null;
if ((date_type == null) || (date_type.equals(""))) date_type = "1";
	
String[] aceitemtypes = acesearchformbean.getAceitemtype();
if (aceitemtypes == null) aceitemtypes =  new String[0];
List<String> aceitemtypesList = Arrays.asList(aceitemtypes);
pageContext.setAttribute("aceitemtypesList", aceitemtypesList);
	
String initial_date = null;
String final_date = null;
String simple_date = null;

String[] sectors = acesearchformbean.getSector();
if (sectors == null) sectors = new String[0];
List<String> sectorsList = Arrays.asList(sectors);
pageContext.setAttribute("sectorsList", sectorsList);
	
String[] elements = acesearchformbean.getElement();
if (elements == null) elements = new String[0];
List<String> elementsList = Arrays.asList(elements);
pageContext.setAttribute("elementsList", elementsList);
	
String[] countries = acesearchformbean.getCountries();
if (countries == null) countries = new String[0];
List<String> countriesList = Arrays.asList(countries);
pageContext.setAttribute("countriesList", countriesList);
%>


<portlet:actionURL name="setFilterAceItemPref" var="searchAceitemURL"/>

<div id="filteraceitems_container">

<portlet:resourceURL var="sortURL" id="view.jsp" escapeXml="false" />

<%-- this is here and not in js file, because we're using some JSP code in it. TODO solve that and move to js file --%>
<script type="text/javascript">

	// ENABLE THIS WHEN RUNNING STANDALONE (WITHOUT REST OF ACE)
	var $j = jQuery.noConflict();

    // Stores results for each data type group
    var groupedJSONResults = new Array();

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

                // Updates the results for each data type sorted
                groupedJSONResults[$j("#sortsearchformId-"+unique + " input[name=aceitemtype]").val()] = aceitemResults;

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
    <div id="filteraceitems_column" class="filteraceitems_column">
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
</div>

<hr class="clearer"/>
