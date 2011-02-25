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

<portlet:actionURL name="searchAceitem" var="searchAceitemURL"/>

<div id="acesearch_container">

<portlet:resourceURL var="sortURL" id="view.jsp" escapeXml="false" />

<%-- this is here and not in js file, because we're using some JSP code in it. TODO solve that and move to js file --%>
<script type="text/javascript">
    /**
	 * retrieves search parameters from the sort-search form that invoked this, executes the search through XHR, and sets json response to correct search results panel.
	 *
	 */
	function sortedSearch(sortRadio) {
		// grab unique part, after dash
		var unique = sortRadio.id.match(/-([0-9]+)/)[1];	
		var sortedSearchForm = $("#sortsearchformId-"+unique);		
		var querystring = 'anyOfThese=' + $("#sortsearchformId-"+unique + " input[name=anyOfThese]").val();
		querystring += '&aceitemtype=' + $("#sortsearchformId-"+unique + " input[name=aceitemtype]").val(); 
		querystring += '&sector=' + $("#sortsearchformId-"+unique + " input[name=sector]").val(); 
		querystring += '&initial_date=' + $("#sortsearchformId-"+unique + " input[name=initial_date]").val(); 
		querystring += '&final_date=' + $("#sortsearchformId-"+unique + " input[name=final_date]").val(); 
		querystring += '&simple_date=' + $("#sortsearchformId-"+unique + " input[name=simple_date]").val(); 
		querystring += '&sortBy=' + $('#'+sortRadio.id).val();
		// replace existing resultlist with loading icon
		$('#resultsListId-'+unique).remove();
		$('#expandedId-'+unique).append('<div id="loadingId-'+unique+'" style="text-align:center;"><img src="<%=renderRequest.getContextPath()%>/images/icons/loading.gif" title="loading" alt="loading"></div>');
		jQuery.ajax({
			type: "POST",
			url: "<%=renderResponse.encodeURL(sortURL.toString())%>",
			data: querystring,
			success: function(json) {
				// remove loading icon and add results to resultlist	
				$('#loadingId-'+unique).remove();
				var resultlist = '<div id="resultsListId-'+unique+'">';				
				var aceitemResults = new Array();
				aceitemResults = jQuery.parseJSON(json);
				jQuery.each(aceitemResults, function(idx, aceitem){ 
					// add searchresult
					resultlist += '<div class="searchresult">';
					// add name and description
					resultlist += '<div><span class="bolder">&#187; ' + aceitem._name + ' -</span> ' + aceitem._description + '</div>';		
					// add result footer
					// TODO use actual date from aceitem, if available
					resultlist += '<div class="resultfooter"><div class="aceitemdate">4 Nov 2010</div><div class="aceitemlinks"><img class="pdficon" src="<%=renderRequest.getContextPath()%>/images/icons/pdf.png" alt="Open" title="Open"/><span class="aceitemlink">Open</span><span class="aceitemlinkseparator">&#9474;</span><span class="aceitemlink">View metadata</span></div><hr class="clearer"/></div>';					
					// close searchresult
					resultlist += '</div>';					
				});
				// close searchresultlist
				resultlist += '</div>';
				$('#expandedId-'+unique).append(resultlist);
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
                    <input type="text" class="text" name="anyOfThese" id="anyOfThese"/>
                </div>
            </div>

            <div class="search_section">
                <h2><liferay-ui:message key="acesearch-section-header2" /></h2>

                <div class="row">
                    <input type="radio" name="datainfo_type" value="1" checked/><liferay-ui:message key="acesearch-datainfotype-lbl-all" />
                    <input type="radio" name="datainfo_type" value="2"/><liferay-ui:message key="acesearch-datainfotype-lbl-sel" />

                    <div id="all_selection_types">
                        <div class="checks_container">

                            <div class="check">
                                <input type="checkbox" name="aceitemtype" id="chk_type_articles" value="ARTICLE"/>
                                <label for="chk_type_articles"><liferay-ui:message key="acesearch-datainfotype-lbl-articles" /></label>
                            </div>

                            <div class="check">
                                <input type="checkbox" name="aceitemtype" id="chk_type_lists" value="LIST"/>
                                <label for="chk_type_lists"><liferay-ui:message key="acesearch-datainfotype-lbl-lists" /></label>
                            </div>

                            <div class="check">
                                <input type="checkbox" name="aceitemtype" id="chk_type_datasets" value="DATA"/>
                                <label for="chk_type_datasets"><liferay-ui:message key="acesearch-datainfotype-lbl-datasets" /></label>
                            </div>

                            <div class="check">
                                <input type="checkbox" name="aceitemtype" id="chk_type_tables" value="TABLE"/>
                                <label for="chk_type_tables"><liferay-ui:message key="acesearch-datainfotype-lbl-tables" /></label>
                            </div>

                            <div class="check">
                                <input type="checkbox" name="aceitemtype" id="chk_type_indicators" value="INDICATOR"/>
                                <label for="chk_type_indicators"><liferay-ui:message key="acesearch-datainfotype-lbl-indicators" /></label>
                            </div>

                            <div class="check">
                                <input type="checkbox" name="aceitemtype" id="chk_type_tools" value="TOOL"/>
                                <label for="chk_type_tools"><liferay-ui:message key="acesearch-datainfotype-lbl-tools" /></label>
                            </div>

                            <div class="check">
                                <input type="checkbox" name="aceitemtype" id="chk_type_maps" value="MAP"/>
                                <label for="chk_type_maps"><liferay-ui:message key="acesearch-datainfotype-lbl-maps" /></label>
                            </div>

                            <div class="check">
                                <input type="checkbox" name="aceitemtype" id="chk_type_multimedia" value="MULTIMEDIA"/>
                                <label for="chk_type_multimedia"><liferay-ui:message key="acesearch-datainfotype-lbl-multimedia" /></label>
                            </div>

                            <div class="check">
                                <input type="checkbox" name="aceitemtype" id="chk_type_flood" value="FLOOD"/>
                                <label for="chk_type_flood"><liferay-ui:message key="acesearch-datainfotype-lbl-flood" /></label>
                            </div>

                        </div>
                    </div>
                </div>
            </div>

            <div class="search_section">
                <h2><liferay-ui:message key="acesearch-section-header3" /></h2>

                <div class="row">
                    <input type="radio" name="date_type" value="1" checked/><liferay-ui:message key="acesearch-datetype-lbl-all" />
                    <input type="radio" name="date_type" value="2"/><liferay-ui:message key="acesearch-datetype-lbl-range" />
                    <input type="radio" name="date_type" value="3"/><liferay-ui:message key="acesearch-datetype-lbl-simple" />

                    <div id="range_dates">
                        <div class="row">
                            <label for="initial_date" class="input_small"><liferay-ui:message key="acesearch-datetype-lbl-initialdate" /></label>
                            <input type="text" class="date" name="initial_date" id="initial_date"/>
                        </div>
                        <div class="row">
                            <label for="final_date" class="input_small"><liferay-ui:message key="acesearch-datetype-lbl-finaldate" /></label>
                            <input type="text" class="date" name="final_date" id="final_date"/>
                        </div>

                    </div>

                    <div id="specific_date">
                        <div class="row">
                            <label for="simple_date" class="input_small"><liferay-ui:message key="acesearch-datetype-lbl-date" /></label>
                            <input type="text" class="date" name="simple_date" id="simple_date"/>
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
                                <input type="checkbox" name="sector" id="chk_sectors_agriculture" value="AGRICULTURE"/>
                                <label for="chk_sectors_agriculture"><liferay-ui:message key="acesearch-sectors-lbl-agriculture" /></label>
                            </div>

                            <div class="check">
                                <input type="checkbox" name="sector" id="chk_sectors_health" value="HEALTH"/>
                                <label for="chk_sectors_health"><liferay-ui:message key="acesearch-sectors-lbl-health" /></label>
                            </div>

                            <div class="check">
                                <input type="checkbox" name="sector" id="chk_sectors_biodiversity" value="BIODIVERSITY"/>
                                <label for="chk_sectors_biodiversity"><liferay-ui:message key="acesearch-sectors-lbl-biodiversity" /></label>
                            </div>

                            <div class="check">
                                <input type="checkbox" name="sector" id="chk_sectors_tourism" value="TOURISM"/>
                                <label for="chk_sectors_tourism"><liferay-ui:message key="acesearch-sectors-lbl-tourism" /></label>
                            </div>

                            <div class="check">
                                <input type="checkbox" name="sector" id="chk_sectors_coastal" value="COASTAL"/>
                                <label for="chk_sectors_coastal"><liferay-ui:message key="acesearch-sectors-lbl-coastal" /></label>
                            </div>

                            <div class="check">
                                <input type="checkbox" name="sector" id="chk_sectors_transport" value="TRANSPORT"/>
                                <label for="chk_sectors_transport"><liferay-ui:message key="acesearch-sectors-lbl-transport" /></label>
                            </div>

                            <div class="check">
                                <input type="checkbox" name="sector" id="chk_sectors_fisheries" value="FISHERIES"/>
                                <label for="chk_sectors_fisheries"><liferay-ui:message key="acesearch-sectors-lbl-fisheries" /></label>
                            </div>

                            <div class="check">
                                <input type="checkbox" name="sector" id="chk_sectors_water" value="WATER"/>
                                <label for="chk_sectors_water"><liferay-ui:message key="acesearch-sectors-lbl-water" /></label>
                            </div>

                            <div class="check">
                                <input type="checkbox" name="sector" id="chk_sectors_flood" value="FLOOD"/>
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
                <input type="submit" value="<liferay-ui:message key="acesearch-search-btn" />"/>
            </div>
        </aui:form>
    </div>

	<!-- Results column  -->
	<div id="search_results" class="acesearch_column">
	
		<h1>Data & downloads</h1>
		
		<h2 id="searchresultstitle">Search results</h2>
					
		<c:set var="groupedResults" scope="page" value="${ARTICLE_searchResults}"/>
		<c:set var="aceitemtype" scope="page" value="ARTICLE"/>		
		<c:set var="groupTitle" scope="page" value="Articles and publications"/>
		<%@ include file="searchresultsbytype.jspf" %>
		 
		<c:set var="groupedResults" scope="page" value="${MAP_searchResults}"/>
		<c:set var="aceitemtype" scope="page" value="MAP"/>		
		<c:set var="groupTitle" scope="page" value="Maps"/>			
		<%@ include file="searchresultsbytype.jspf" %>	
		
		<c:set var="groupedResults" scope="page" value="${MULTIMEDIA_searchResults}"/>
		<c:set var="aceitemtype" scope="page" value="MULTIMEDIA"/>				
		<c:set var="groupTitle" scope="page" value="Multimedia"/>			
		<%@ include file="searchresultsbytype.jspf" %>					 

		<c:set var="groupedResults" scope="page" value="${DATA_searchResults}"/>
		<c:set var="aceitemtype" scope="page" value="DATA"/>				
		<c:set var="groupTitle" scope="page" value="Data (sets)"/>			
		<%@ include file="searchresultsbytype.jspf" %>	
		
		<%-- TODO all types --%>

	</div>
	
	<hr class="clearer"/>

</div>