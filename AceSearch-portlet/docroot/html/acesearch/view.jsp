<%@ page import="java.util.Arrays" %>
<%@page import="nl.wur.alterra.cgi.ace.search.AceSearchFormBean"%>
<%@page import="nl.wur.alterra.cgi.ace.search.SearchRequestParams"%>
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
String anyOfThese;

AceSearchFormBean acesearchformbean = (AceSearchFormBean) request.getAttribute(SearchRequestParams.SEARCH_PARAMS);

if(acesearchformbean != null) {
   anyOfThese = acesearchformbean.getAnyOfThese();
}
else {
	anyOfThese = ParamUtil.getString(request, "anyOfThese");
}

String freetextAny = ParamUtil.getString(request, "freetextAny");
if ((freetextAny == null) || (freetextAny.equals(""))) freetextAny = "1";

String datainfo_type = ParamUtil.getString(request, "datainfo_type");
if ((datainfo_type == null) || (datainfo_type.equals(""))) datainfo_type = "1";

String date_type = ParamUtil.getString(request, "date_type");
if ((date_type == null) || (date_type.equals(""))) date_type = "1";

String conditionAdaptationSector = ParamUtil.getString(request, "conditionAdaptationSector");
if ((conditionAdaptationSector == null) || (conditionAdaptationSector.equals(""))) conditionAdaptationSector = "AND";

String conditionAdaptationElement = ParamUtil.getString(request, "conditionAdaptationElement");
if ((conditionAdaptationElement == null) || (conditionAdaptationElement.equals(""))) conditionAdaptationElement = "AND";

String conditionClimateImpact = ParamUtil.getString(request, "conditionClimateImpact");
if ((conditionClimateImpact == null) || (conditionClimateImpact.equals(""))) conditionClimateImpact = "AND";

String[] aceitemtypes = request.getParameterValues("aceitemtype");
if (aceitemtypes == null) aceitemtypes =  new String[0];
List<String> aceitemtypesList = Arrays.asList(aceitemtypes);
pageContext.setAttribute("aceitemtypesList", aceitemtypesList);

String[] sectors = request.getParameterValues("sector");
if (sectors == null) sectors = new String[0];
List<String> sectorsList = Arrays.asList(sectors);
pageContext.setAttribute("sectorsList", sectorsList);

String[] elements = request.getParameterValues("element");
if (elements == null) elements = new String[0];
List<String> elementsList = Arrays.asList(elements);
pageContext.setAttribute("elementsList", elementsList);

String[] impacts = request.getParameterValues("impact");
if (impacts == null) impacts = new String[0];
List<String> impactsList = Arrays.asList(impacts);
pageContext.setAttribute("impactsList", impactsList);

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

        if ($j("#sortsearchformId-"+unique + " input[name=countries]").val() != undefined) {
		    querystring += '&countries=' + $j("#sortsearchformId-"+unique + " input[name=countries]").val();
        }

        querystring += '&conditionAdaptationSector=' + $j("#sortsearchformId-"+unique + " input[name=conditionAdaptationSector]").val();
        querystring += '&conditionAdaptationElement=' + $j("#sortsearchformId-"+unique + " input[name=conditionAdaptationElement]").val();

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
				//displayJSONResults(unique, firstFiveAceitemResults);				
				$j('#paginationId-'+unique).trigger('setPage', [0]); // invokes displayJSONResults
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
				
					<div id="anyorall" style="">
						<!-- any of these words -->
						<input type="radio" id="any" name="freetextAny" value="1" <%= (freetextAny.equals("1"))?"checked":"" %> style="float:left;"/>
						<label for="any" class="input"  style="float:left;width:120px;margin-left:3px;">
							<liferay-ui:message key="acesearch-lbl-anywords" />
						</label>

						<!-- all of these words -->
						<input type="radio" id="all" name="freetextAny" value="2" <%= (freetextAny.equals("2"))?"checked":"" %>  style="float:left;"/>
						<label for="all" class="input"  style="float:left;width:120px;margin-left:3px;">
							<liferay-ui:message key="acesearch-lbl-allwords" />
						</label>
					</div>
					
					<!-- freetext input -->
                    <input type="text" class="text" name="anyOfThese" id="anyOfThese" size="60" value="<%= anyOfThese %>" style="margin-top:5px;" />

				</div>
            </div>
			
			<hr class="clearer"/>

            <div class="search_section">
                <h2><liferay-ui:message key="acesearch-section-header2" /></h2>

                <div class="row">
                    <input type="radio" id="alltypes" name="datainfo_type" value="1" <%= (datainfo_type.equals("1"))?"checked":"" %> />
					<label for="alltypes">
						<liferay-ui:message key="acesearch-datainfotype-lbl-all" />
					</label>
                    <input type="radio" id="anytypes" name="datainfo_type" value="2" <%= (datainfo_type.equals("2"))?"checked":"" %> />
					<label for="anytypes">
						<liferay-ui:message key="acesearch-datainfotype-lbl-sel" />
					</label>					
                    <div id="all_selection_types">
                        <div class="checks_container">						
							<%-- note : i18n file should always be in sync with AceItemType enum --%>						
							<c:forEach var="aceItemType" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemType.values() %>" >	
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
                            <div class="condition_container">
                                <input type="radio" id="anysectors" name="conditionAdaptationSector" value="OR" <%= (conditionAdaptationSector.equals("OR"))?"checked":"" %> />
								<label for="anysectors">
									&nbsp;<liferay-ui:message key="acesearch-anysectors" />
								</label>	
                                &nbsp;&nbsp;<input type="radio" id="allsectors" name="conditionAdaptationSector" value="AND" <%= (conditionAdaptationSector.equals("AND"))?"checked":"" %> />
								<label for="allsectors">
									&nbsp;<liferay-ui:message key="acesearch-allsectors" />
								</label>	
                            </div>

							<%-- note : i18n file should always be in sync with AceItemSector enum --%>	
							<c:forEach var="adaptationSector" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemSector.values() %>" >							
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
                        <a href="#" id="climate_impacts_btn" class="collapsed_section"><liferay-ui:message key="acesearch-section-climate-impacts" /></a>

                        <div id="climate_impacts_container" class="checks_container">
                            <div class="condition_container">
                                <input type="radio" id="anyimpacts" name="conditionClimateImpact" value="OR" <%= (conditionClimateImpact.equals("OR"))?"checked":"" %> />
								<label for="anyimpacts">
									&nbsp;<liferay-ui:message key="acesearch-anyimpacts" />
								</label>	
                                &nbsp;&nbsp;<input type="radio" id="allimpacts" name="conditionClimateImpact" value="AND" <%= (conditionClimateImpact.equals("AND"))?"checked":"" %> />
								<label for="allimpacts">
									&nbsp;<liferay-ui:message key="acesearch-allimpacts" />
								</label>	
                            </div>

							<%-- note : i18n file should always be in sync with AceItemClimateImpact enum --%>
							<c:forEach var="climateImpact" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemClimateImpact.values() %>" >
								<div class="check">
									<c:set var="climateImpactMustBeChecked" value="false" />
									<c:forEach var="requestedImpact" items="${impactsList}">
										<c:if test="${requestedImpact eq climateImpact}">
											<c:set var="climateImpactMustBeChecked" value="true" />
										</c:if>
									</c:forEach>	
									<c:choose>
										<c:when test="${climateImpactMustBeChecked}">
											<input type="checkbox" name="impact" id="chk_impacts_${climateImpact}" value="${climateImpact}" checked="checked" />
										</c:when>
										<c:otherwise>
											<input type="checkbox" name="impact" id="chk_impacts_${climateImpact}" value="${climateImpact}" />
										</c:otherwise>
									</c:choose>
									<label for="chk_impacts_${climateImpact}"><liferay-ui:message key="aceitem-climateimpacts-lbl-${climateImpact}" /></label>
								</div>							
							</c:forEach>
                        </div>						
                    </li>

                    <li>
                        <a href="#" id="adaptation_elements_btn" class="collapsed_section"><liferay-ui:message key="acesearch-section-adaptation-elements" /></a>

                        <div id="adaptation_elements_container" class="checks_container">
                            <div class="condition_container">
                                <input type="radio" id="anyelements" name="conditionAdaptationElement" value="OR" <%= (conditionAdaptationElement.equals("OR"))?"checked":"" %> />
								<label for="anyelements">
									&nbsp;<liferay-ui:message key="acesearch-anyelements" />
								</label>	
                                &nbsp;&nbsp;<input type="radio" id="allelements" name="conditionAdaptationElement" value="AND" <%= (conditionAdaptationElement.equals("AND"))?"checked":"" %> />
								<label for="allelements">
									&nbsp;<liferay-ui:message key="acesearch-allelements" />
								</label>	
                            </div>

							<%-- note : i18n file should always be in sync with AceItemElement enum --%>
							<c:forEach var="adaptationElement" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemElement.values() %>" >
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

                    <li>
                        <a href="#" id="countries_btn" class="collapsed_section"><liferay-ui:message key="acesearch-section-countries" /></a>
                        <div id="countries_container" class="checks_container">
                            <%-- note : i18n file should always be in sync with AceItemCountry enum --%>
							<c:forEach var="countryElement" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemCountry.values() %>" >
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
	<!--
		<h1><liferay-ui:message key="acesearch-data-downloads-header" /></h1>
		
		<h2 id="searchresultstitle"><liferay-ui:message key="acesearch-results-header" /></h2>
	-->
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

		<c:set var="groupedResults" scope="page" value="${INFORMATIONSOURCE_searchResults}"/>
		<c:set var="groupedJSONResults" scope="page" value="${INFORMATIONSOURCE_JSONsearchResults}"/>
		<c:set var="aceitemtype" scope="page" value="INFORMATIONSOURCE"/>				
		<c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-INFORMATIONSOURCE" /></c:set>
		<%@ include file="searchresultsbytype.jspf" %>
		
        <c:set var="groupedResults" scope="page" value="${GUIDANCE_searchResults}"/>
        <c:set var="groupedJSONResults" scope="page" value="${GUIDANCE_JSONsearchResults}"/>
        <c:set var="aceitemtype" scope="page" value="GUIDANCE"/>
        <c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-GUIDANCE" /></c:set>
        <%@ include file="searchresultsbytype.jspf" %>

        <c:set var="groupedResults" scope="page" value="${TOOL_searchResults}"/>
        <c:set var="groupedJSONResults" scope="page" value="${TOOL_JSONsearchResults}"/>
        <c:set var="aceitemtype" scope="page" value="TOOL"/>
        <c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-TOOL" /></c:set>
        <%@ include file="searchresultsbytype.jspf" %>

		<c:set var="groupedResults" scope="page" value="${MAPGRAPHDATASET_searchResults}"/>
		<c:set var="groupedJSONResults" scope="page" value="${MAPGRAPHDATASET_JSONsearchResults}"/>
		<c:set var="aceitemtype" scope="page" value="MAPGRAPHDATASET"/>		
		<c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-MAPGRAPHDATASET" /></c:set>
		<%@ include file="searchresultsbytype.jspf" %>	

        <c:set var="groupedResults" scope="page" value="${INDICATOR_searchResults}"/>
		<c:set var="groupedJSONResults" scope="page" value="${INDICATOR_JSONsearchResults}"/>
		<c:set var="aceitemtype" scope="page" value="INDICATOR"/>
		<c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-INDICATOR" /></c:set>
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
		<c:set var="aceitemtype" scope="page" value="ACTION"/>
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
