<%@page import="nl.wur.alterra.cgi.ace.model.constants.AceItemElement"%>
<%@ page import="java.util.Arrays" %>
<%@page import="nl.wur.alterra.cgi.ace.search.AceSearchFormBean"%>
<%@page import="nl.wur.alterra.cgi.ace.search.SearchRequestParams"%>
<%@page import="nl.wur.alterra.cgi.ace.search.AceItemSearchResult"%>
<%@page import="nl.wur.alterra.cgi.ace.portlet.PortletUtils"%>
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
String[] aceitemtypes = null;
String[] sectors = null;
String[] elements = null;
String[] impacts = null;
String[] countries = null;
String startyear = null;
String endyear = null;
String conditionAdaptationSector = null;
String conditionAdaptationCountry = null;

AceSearchFormBean acesearchformbean = (AceSearchFormBean) request.getAttribute(SearchRequestParams.SEARCH_PARAMS);

String freetextAny = ParamUtil.getString(request, "freetextAny");
String datainfo_type = ParamUtil.getString(request, "datainfo_type");
if(acesearchformbean != null) {
   anyOfThese = acesearchformbean.getAnyOfThese();
   if ((freetextAny == null) || (freetextAny.equals(""))) freetextAny = "2";
   aceitemtypes = acesearchformbean.getAceitemtype();
   if ( (datainfo_type == null) || (datainfo_type.equals("") ) ) datainfo_type = ((aceitemtypes == null) ? "1" : "2");
    sectors = acesearchformbean.getSector();
	elements = acesearchformbean.getElement();
	impacts = acesearchformbean.getImpact();
	countries = acesearchformbean.getCountries();
	
	if (acesearchformbean.getConditionAdaptationSector() != null)
	{
		conditionAdaptationSector = acesearchformbean.getConditionAdaptationSector() ;
	}
	
	if (acesearchformbean.getConditionAdaptationCountry() != null)
	{
		conditionAdaptationCountry = acesearchformbean.getConditionAdaptationCountry();
	}
	

	if (acesearchformbean.getStartyear() != null)
	{
	   startyear = acesearchformbean.getStartyear()[0];
	}
	
	if (acesearchformbean.getEndyear() != null)
	{
	   endyear = acesearchformbean.getEndyear()[0];	
	}
}
else {
	anyOfThese = ParamUtil.getString(request, "anyOfThese");
	if ((freetextAny == null) || (freetextAny.equals(""))) freetextAny = "1";
	aceitemtypes = request.getParameterValues("aceitemtype");
	if ((datainfo_type == null) || (datainfo_type.equals(""))) datainfo_type = "1";
	sectors = request.getParameterValues("sector");
	elements = request.getParameterValues("element");
	impacts = request.getParameterValues("impact");
	countries = request.getParameterValues("countries");
	countries = request.getParameterValues("countries");
	startyear = request.getParameter("startyear");
	endyear = request.getParameter("endyear");
}

String date_type = ParamUtil.getString(request, "date_type");
if ((date_type == null) || (date_type.equals(""))) date_type = "1";

// it might be populated from form bean
if (conditionAdaptationSector == null )
{
   conditionAdaptationSector = ParamUtil.getString(request, "conditionAdaptationSector");
   if ((conditionAdaptationSector == null) || (conditionAdaptationSector.equals(""))) conditionAdaptationSector = "AND";
}

String conditionAdaptationElement = ParamUtil.getString(request, "conditionAdaptationElement");
if ((conditionAdaptationElement == null) || (conditionAdaptationElement.equals(""))) conditionAdaptationElement = "AND";

//it might be populated from form bean
if (conditionAdaptationCountry == null)
{
	conditionAdaptationCountry = ParamUtil.getString(request, "conditionAdaptationCountry");
	if ((conditionAdaptationCountry == null) || (conditionAdaptationCountry.equals(""))) conditionAdaptationCountry = "AND";
}

String conditionClimateImpact = ParamUtil.getString(request, "conditionClimateImpact");
if ((conditionClimateImpact == null) || (conditionClimateImpact.equals(""))) conditionClimateImpact = "AND";

if (aceitemtypes == null) aceitemtypes =  new String[0];
List<String> aceitemtypesList = Arrays.asList(aceitemtypes);
pageContext.setAttribute("aceitemtypesList", aceitemtypesList);

if (sectors == null) sectors = new String[0];
List<String> sectorsList = Arrays.asList(sectors);
pageContext.setAttribute("sectorsList", sectorsList);

if (elements == null) elements = new String[0];
List<String> elementsList = Arrays.asList(elements);
pageContext.setAttribute("elementsList", elementsList);

if (impacts == null) impacts = new String[0];
List<String> impactsList = Arrays.asList(impacts);
pageContext.setAttribute("impactsList", impactsList);

if (countries == null) countries = new String[0];
List<String> countriesList = Arrays.asList(countries);
pageContext.setAttribute("countriesList", countriesList);

if (startyear != null)
{
	pageContext.setAttribute("startyear", startyear);
}

if (endyear != null)
{
	pageContext.setAttribute("endyear", endyear);
}

%>


<portlet:actionURL name="searchAceitem" var="searchAceitemURL"/>

<div id="wrapper">

<portlet:resourceURL var="sortURL" id="view.jsp" escapeXml="false" />

<%-- this is here and not in js file, because we're using some JSP code in it. TODO solve that and move to js file --%>
<script type="text/javascript">

	/* ENABLE THIS WHEN RUNNING STANDALONE (WITHOUT REST OF ACE - view.jsp from AceSearch-portlet) */
	var $j = jQuery.noConflict();

    /* Stores results for each data type group */
    var groupedJSONResults = new Array();

    /**
	 * retrieves search parameters from the sort-search form that invoked this, executes the search through XHR, and sets json response to correct search results panel.
	 *
	 */ 
	function sortedSearch(sortRadio) {	
		// grab unique part, after dash
		var unique = sortRadio.id.match(/-([0-9]+)/)[1];	
		var sortedSearchForm = $j("#sortsearchformId-"+unique);
		// pass sortitemtype instead off aceitemtype !
		var querystring = 'anyOfThese=' + $j("#sortsearchformId-"+unique + " input[name=anyOfThese]").val();
		querystring += '&sortitemtype=' + $j("#sortsearchformId-"+unique + " input[name=aceitemtype]").val();
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
    	console.log("QueryString: "+querystring);
    	console.log("URL: "+"<%=renderResponse.encodeURL(sortURL.toString())%>");
				
		// replace existing resultlist with loading icon 
		$j('#resultsListId-'+unique).remove();
		$j('#expandedId-'+unique).append('<div id="loadingId-'+unique+'" style="text-align:center;"><img src="<%=renderRequest.getContextPath()%>/images/icons/loading.gif" title="loading" alt="loading"></div>');
		jQuery.ajax({
			type: "POST",
			url: "<%=renderResponse.encodeURL(sortURL.toString())%>",
			data: querystring,
			success: function(json) {
		    	console.log("json: "+json);

				// remove loading icon and add results to resultlist	
				$j('#loadingId-'+unique).remove();
				var aceitemResults = new Array();
				aceitemResults = jQuery.parseJSON(json);	


                // Updates the results for each data type sorted
                groupedJSONResults[$j("#sortsearchformId-"+unique + " input[name=aceitemtype]").val()] = aceitemResults;

                var firstFiveAceitemResults = new Array();
				for(var i = 0; i < <%= renderRequest.getPreferences().getValue(Constants.rowsPerPagePreferenceName, "5") %>; i++) {
					firstFiveAceitemResults.push(aceitemResults[i]);
				}
				//displayJSONResults(unique, firstFiveAceitemResults);				
				$j('#paginationId-'+unique).trigger('setPage', [0]); // invokes displayJSONResults
			} 
		});
		
	}
    
    function submitform()
    {
    	  var freeTextId = document.getElementById("freetextAnyId");
    	  var anyOfTheseId = document.getElementById("anyOfTheseId");
    	
    	  if ($j("#tb_keywords").val().length > 0)
    	  {
    		  anyOfTheseId.value = $j("#tb_keywords").val();
    	  }
    	  
    	  
    	 
    	  if ($j("#rb_keywords_options_any").is(':checked'))
          {
    		  freeTextId.value="1";
    	  }
    	  else if ($j("#rb_keywords_options_all").is(':checked'))
          {
    		  freeTextId.value="2";
    	  }
    	  document.<portlet:namespace />aceItemSearchForm.submit();
    }
    
    function submitIfEnter(event)
    {
 	   if (event && event.keyCode == 13)
 	   {
 		   submitform();
 		   return false;
 		   
 	   }
 	   else
 	   {
 		   return true;
 	   }
    }
										
</script>

<div id="<portlet:namespace/>content">
</div>
    <!-- Search colum -->
    <div id="case-studies-database-search-filters-wrapper">
       <aui:form action="<%=searchAceitemURL%>" method="post" name="aceItemSearchForm">
   
               <img src="<%=renderRequest.getContextPath()%>/images/search.png" alt=""/>
			 
				<div id="case-studies-database-search-filters">
					<div class="case-studies-database-search-filters-section">
						<a href="#" class="case-studies-database-search-filters-section-header">Type of Data <span class="case-studies-database-search-filters-section-header-icon">-</span></a>
						<ul class="case-studies-database-search-filters-options">
							<li><label for="alltypes"><input type="radio" value="1" id="rb_types_data_all" name="datainfo_type" <%= (datainfo_type.equals("1"))?"checked":"" %> /> <liferay-ui:message key="acesearch-datainfotype-lbl-all" /></label></li>
							<li><label for="anytypes"><input type="radio" value="2" id="rb_types_data_selected" name="datainfo_type" <%= (datainfo_type.equals("2"))?"checked":"" %>/> <liferay-ui:message key="acesearch-datainfotype-lbl-sel" /></label></li>
							<li>
							   <!-- listing data types -->
								<ul class="case-studies-database-search-filters-sub-options">
								    <c:forEach var="aceItemType" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemType.values() %>" >	
								         <c:set var="aceItemMustBeChecked" value="false" />
										 <c:forEach var="requestedAceItemType" items="${aceitemtypesList}">
											<c:if test="${requestedAceItemType eq fn:substring(aceItemType,0,-1)}">
												<c:set var="aceItemMustBeChecked" value="true" />
											</c:if>
										 </c:forEach>	
										 
										<li>
											<label for="chk_type_${aceItemType}">
											   <c:choose>
												 <c:when test="${aceItemMustBeChecked}">
													<input type="checkbox" name="aceitemtype" id="chk_types_${aceItemType}" value="${aceItemType}" checked="checked" /> <liferay-ui:message key="acesearch-datainfotype-lbl-${aceItemType}" />
												 </c:when>
												 <c:otherwise>
												    <input type="checkbox" name="aceitemtype" id="chk_types_${aceItemType}" value="${aceItemType}" /> <liferay-ui:message key="acesearch-datainfotype-lbl-${aceItemType}" />
												 </c:otherwise>
											  </c:choose>
											</label>
									   </li>
								    </c:forEach>
								</ul>
							</li>
						</ul>
					</div>
					
					<div class="case-studies-database-search-filters-section">
						<a href="#" class="case-studies-database-search-filters-section-header"><liferay-ui:message key="acesearch-section-adaptation-sectors" /> <span class="case-studies-database-search-filters-section-header-icon">-</span></a>
						<ul class="case-studies-database-search-filters-options">
							<li><label for="anysectors"><input type="radio" value="OR" id="anysectors" name="conditionAdaptationSector" <%= (conditionAdaptationSector.equals("OR"))?"checked":"" %> /> <liferay-ui:message key="acesearch-anysectors" /></label></li>
							<li><label for="allsectors"><input type="radio" value="AND" id="allsectors" name="conditionAdaptationSector" <%= (conditionAdaptationSector.equals("AND"))?"checked":"" %> /> <liferay-ui:message key="acesearch-allsectors" /></label></li>
							
							<li>
							  <!-- start of adaptation sector options -->
							  <ul class="case-studies-database-search-filters-sub-options">
							   <%-- note : i18n file should always be in sync with AceItemSector enum --%>	
								<c:forEach var="adaptationSector" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemSector.values() %>" >							
									
										<c:set var="adaptationSectorMustBeChecked" value="false" />
										<c:forEach var="requestedSector" items="${sectorsList}">
											<c:if test="${requestedSector eq fn:substring(adaptationSector,0,-1)}">
												<c:set var="adaptationSectorMustBeChecked" value="true" />
										    </c:if>
										</c:forEach>
										
										<li>
											<label for="chk_sectors_${adaptationSector}">
												<c:choose>
													<c:when test="${adaptationSectorMustBeChecked}">
														<input type="checkbox" name="sector" id="chk_sectors_${adaptationSector}" value="${adaptationSector}" checked="checked" />
														<liferay-ui:message key="acesearch-sectors-lbl-${adaptationSector}" />
													</c:when>
													<c:otherwise>
														<input type="checkbox" name="sector" id="chk_sectors_${adaptationSector}" value="${adaptationSector}" />
														<liferay-ui:message key="acesearch-sectors-lbl-${adaptationSector}" />
													</c:otherwise>
												</c:choose>
												
											</label>
										</li>
								</c:forEach>
								</ul>
							</li>
						</ul>
					</div>
					
					<div class="case-studies-database-search-filters-section">
						<a href="#" class="case-studies-database-search-filters-section-header">Climate Impacts <span class="case-studies-database-search-filters-section-header-icon">-</span></a>
						<ul class="case-studies-database-search-filters-options">
							<li><label for="anyimpacts"><input type="radio" value="OR" id="rb_impacts_any" name="conditionClimateImpact" <%= (conditionClimateImpact.equals("OR"))?"checked":"" %> /> <liferay-ui:message key="acesearch-anyimpacts" /></label></li>
							<li><label for="allimpacts"><input type="radio" value="AND" id="rb_impacts_all" name="conditionClimateImpact" <%= (conditionClimateImpact.equals("AND"))?"checked":"" %> /> <liferay-ui:message key="acesearch-allimpacts" /></label></li>
							<li>
							    <!-- start of climate impacts -->
								<ul class="case-studies-database-search-filters-sub-options">
								    <%-- note : i18n file should always be in sync with AceItemClimateImpact enum --%>
									<c:forEach var="climateImpact" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemClimateImpact.values() %>" >
											<c:set var="climateImpactMustBeChecked" value="false" />
											<c:forEach var="requestedImpact" items="${impactsList}">
												<c:if test="${requestedImpact eq fn:substring(climateImpact,0,-1)}">
													<c:set var="climateImpactMustBeChecked" value="true" />
												</c:if>
											</c:forEach>	
											
											<li>
											     <label for="chk_impacts_${climateImpact}">
													<c:choose>
														<c:when test="${climateImpactMustBeChecked}">
															<input type="checkbox" name="impact" id="chk_impacts_${climateImpact}" value="${climateImpact}" checked="checked" />
															<liferay-ui:message key="aceitem-climateimpacts-lbl-${climateImpact}" />
														</c:when>
														<c:otherwise>
															<input type="checkbox" name="impact" id="chk_impacts_${climateImpact}" value="${climateImpact}" />
															<liferay-ui:message key="aceitem-climateimpacts-lbl-${climateImpact}" />
														</c:otherwise>
													</c:choose>
													
												</label>
											</li>
									</c:forEach>
								</ul>
							</li>
						</ul>
					</div>
					
					<div class="case-studies-database-search-filters-section">
						<a href="#" class="case-studies-database-search-filters-section-header">Adaptation Elements <span class="case-studies-database-search-filters-section-header-icon">-</span></a>
						<ul class="case-studies-database-search-filters-options">
							<li><label for="anyelements"><input type="radio" value="OR" id="rb_elements_any" name="conditionAdaptationElement" <%= (conditionAdaptationElement.equals("OR"))?"checked":"" %> /> <liferay-ui:message key="acesearch-anyelements" /></label></li>
							<li><label for="allelements"><input type="radio" value="AND" id="rb_elements_all" name="conditionAdaptationElement" <%= (conditionAdaptationElement.equals("AND"))?"checked":"" %> /> <liferay-ui:message key="acesearch-allelements" /></label></li>
							<li>
							    <!-- start of adaptation element -->
								<ul class="case-studies-database-search-filters-sub-options">
								    <%-- note : i18n file should always be in sync with AceItemElement enum --%>
									<c:forEach var="adaptationElement" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemElement.values() %>" >
											<c:set var="adaptationElementMustBeChecked" value="false" />
											<c:forEach var="requestedElement" items="${elementsList}">
												<c:if test="${requestedElement eq fn:substring(adaptationElement,0,-1)}">
													<c:set var="adaptationElementMustBeChecked" value="true" />
												</c:if>
											</c:forEach>	
											
											<li>
											     <label for="chk_elements_${adaptationElement}">
													<c:choose>
														<c:when test="${adaptationElementMustBeChecked}">
															<input type="checkbox" name="element" id="chk_elements_${adaptationElement}" value="${adaptationElement}" checked="checked" />
															<liferay-ui:message key="acesearch-elements-lbl-${adaptationElement}" />
														</c:when>
														<c:otherwise>
															<input type="checkbox" name="element" id="chk_elements_${adaptationElement}" value="${adaptationElement}" />
															<liferay-ui:message key="acesearch-elements-lbl-${adaptationElement}" />
														</c:otherwise>
													</c:choose>
													
												</label>
											</li>
									</c:forEach>
								</ul>
							</li>
						</ul>
					</div>
					
					<div class="case-studies-database-search-filters-section">
						<a href="#" class="case-studies-database-search-filters-section-header"><liferay-ui:message key="acesearch-section-countries" /> <span class="case-studies-database-search-filters-section-header-icon">-</span></a>
						<ul class="case-studies-database-search-filters-options">
						    <li><label for="anycountry"><input type="radio" value="OR" id="rb_countries_any" name="conditionAdaptationCountry" <%= (conditionAdaptationCountry.equals("OR"))?"checked":"" %> /> <liferay-ui:message key="acesearch-anycountries" /></label></li>
							<li><label for="allcountries"><input type="radio" value="AND" id="rb_countries_all" name="conditionAdaptationCountry" <%= (conditionAdaptationCountry.equals("AND"))?"checked":"" %> /> <liferay-ui:message key="acesearch-allcountries" /></label></li>
							<li>
							   <!--  start of countries -->
								<ul class="case-studies-database-search-filters-sub-options">
									    <%-- note : i18n file should always be in sync with AceItemCountry enum --%>
										<c:forEach var="countryElement" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemCountry.values() %>" >
												<c:set var="countryElementMustBeChecked" value="false" />
												<c:forEach var="requestedElement" items="${countriesList}">
													<c:if test="${requestedElement eq fn:substring(countryElement,0,-1)}">
														<c:set var="countryElementMustBeChecked" value="true" />
													</c:if>
												</c:forEach>
												
												<li>
											      <label for="chk_countries_${countryElement}">
											      
												<c:choose>
													<c:when test="${countryElementMustBeChecked}">
														<input type="checkbox" name="countries" id="chk_countries_${countryElement}" value="${countryElement}" checked="checked" />
														<liferay-ui:message key="acesearch-country-lbl-${countryElement}" />
													</c:when>
													<c:otherwise>
														<input type="checkbox" name="countries" id="chk_countries_${countryElement}" value="${countryElement}" />
														<liferay-ui:message key="acesearch-country-lbl-${countryElement}" />
													</c:otherwise>
													
												</c:choose>
										</c:forEach>
								</ul>
							</li>
						</ul>
					</div>
					
					<div class="case-studies-database-search-filters-section">
						<a href="#" class="case-studies-database-search-filters-section-header">Year <span class="case-studies-database-search-filters-section-header-icon">-</span></a>
						<ul class="case-studies-database-search-filters-options">
							<li>
								<input type="text" name="startyear" id="tb_year_start" size="11" maxlength="4" value="${startyear}" /> to <input type="text" name="endyear" id="tb_year_end" size="11" maxlength="4" value="${endyear}" />
							</li>
						</ul>
					</div>
				</div>
			      <input type="hidden" id="anyOfTheseId" name="anyOfThese" value=""/>
			      <input type="hidden" id="freetextAnyId" name="freetextAny" value="" />
                </aui:form> <!-- end of aui form -->	
			</div>
	<!-- Results column  -->
	<div id="search_results" class="acesearch_column" style="padding-top: 0px;">
	     <div style="margin-top:0px; font-weight:bold; padding-bottom:5px">The database contains quality checked information and is annotated by climate adaptation experts with keywords.</div>
	     <p>Search the database using the keywords field below and filter the results using one or more of the filters from the left side bar</p>
        <div id="case-studies-database-search-section">
					<label for="tb_keywords">
						<strong>Keywords</strong>
						<input type="text" name="anyOfThese" id="tb_keywords" size="30" maxlength="255" value="<%= anyOfThese %>" onkeypress="return submitIfEnter(event)" />
					</label>
					<ul id="case-studies-database-search-options">
					    <li><label for="any"><input type="radio" value="1" id="rb_keywords_options_any" name="freetextAny" <%= (freetextAny.equals("1"))?"checked":"" %>/> <liferay-ui:message key="acesearch-lbl-anywords" /></label></li>
						<li><label for="all"><input type="radio" value="2" id="rb_keywords_options_all" name="freetextAny" <%= (freetextAny.equals("2"))?"checked":"" %> /> <liferay-ui:message key="acesearch-lbl-allwords" /></label></li>
					</ul>
					<a class="case-studies-database-search-button-green" href="#" onClick="submitform()">Search</a>
					<div class="case-studies-form-clearing"></div>
		</div>
		
		<c:if test="<%= totalResults != null %>">
        	<!-- div class="results_header"><liferay-ui:message key="acesearch-data-downloads-header" /></div -->
            <c:choose>
                <c:when test="<%= totalResults == 0 %>">
                <div class="number_of_results"><br/><liferay-ui:message key="acesearch-no-results" /></div>
                </c:when>
                <c:otherwise>
                <div class="number_of_results"><liferay-ui:message key="acesearch-total-results" /> <%= totalResults%></div>
                </c:otherwise>
            </c:choose>
        </c:if>
		

        <%-- <c:set var="groupedResults" scope="page" value="${CITYPROFILE_searchResults}"/>
		<c:set var="groupedJSONResults" scope="page" value="${CITYPROFILE_JSONsearchResults}"/>
		<c:set var="aceitemtype" scope="page" value="CITYPROFILE"/>
		<c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-CITYPROFILE" /></c:set>
		<%@ include file="searchresultsbytype.jspf" %> --%>

        <c:set var="groupedResults" scope="page" value="${ARTICLE_searchResults}"/>
		<c:set var="groupedJSONResults" scope="page" value="${ARTICLE_JSONsearchResults}"/>
		<c:set var="aceitemtype" scope="page" value="ARTICLE"/>
		<c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-ARTICLE" /></c:set>
		<%@ include file="searchresultsbytype.jspf" %>

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

		<%						
		List<AceItemSearchResult> results = (List<AceItemSearchResult>)pageContext.getAttribute("groupedResults");
			
				for (AceItemSearchResult result : results) {
					String storedAtBasic = "ace_measure_id=";
					String storedAt = result.getStoredAt();
					String measureId = storedAt.substring(storedAt.indexOf('=') + 1);			
					long filteredMeasureId = PortletUtils.filterAdaptationOptionIds(Long.parseLong(measureId));
					
					if (filteredMeasureId != Long.parseLong(measureId)) {
						String filteredStoredAt = storedAtBasic+Long.toString(filteredMeasureId);

						AceItem aceItem = null;
						
						try {
							aceItem = AceItemLocalServiceUtil.getAceItemByStoredAt(filteredStoredAt);							
						} catch (Exception e) {
							e.printStackTrace();
						}
						
						if (aceItem != null) { //the filtering is meaningless if there is no such AceItem in DB
							result.setStoredAt(filteredStoredAt);
							result.setName(aceItem.getName());
							result.setYear(aceItem.getYear());
							result.setShortdescription(aceItem.getDescription());						
						}
					}
					
				}
		
		pageContext.setAttribute("measureResults", results);				
		pageContext.setAttribute("measureJSONResults", PortletUtils.getJSONResults(results));
		%>
		<c:set var="groupedResults" scope="page" value="${measureResults}"/>
		<c:set var="groupedJSONResults" scope="page" value="${measureJSONResults}"/>
		<c:set var="aceitemtype" scope="page" value="MEASURE"/>
		<c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-MEASURE" /></c:set>
		<%@ include file="searchresultsbytype.jspf" %>

        <c:set var="groupedResults" scope="page" value="${ACTION_searchResults}"/>
		<c:set var="groupedJSONResults" scope="page" value="${ACTION_JSONsearchResults}"/>
		<c:set var="aceitemtype" scope="page" value="ACTION"/>
		<c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-ACTION" /></c:set>
		<%@ include file="searchresultsbytype.jspf" %>

		<c:set var="groupedResults" scope="page" value="${CITYPROFILE_searchResults}"/>
		<c:set var="groupedJSONResults" scope="page" value="${CITYPROFILE_JSONsearchResults}"/>
		<c:set var="aceitemtype" scope="page" value="CITYPROFILE"/>
		<c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-CITYPROFILE" /></c:set>
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
