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

    <!-- Search colum -->
    <div id="acesearch_column" class="acesearch_column" style="float:left;width:45%;">

        <aui:form action="<%=searchAceitemURL%>" method="post" name="<portlet:namespace/>aceItemSearchForm">
            <div class="search_section">
                <h2><liferay-ui:message key="acesearch-section-header1" /></h2>

                <div class="row">
                    <label for="all_words" class="input"><liferay-ui:message key="acesearch-lbl-allwords" /></label>
                    <input type="text" class="text" name="all_words" id="all_words"/>
                </div>

                <div class="row">
                    <label for="exact_words" class="input"><liferay-ui:message key="acesearch-lbl-exactwords" /></label>
                    <input type="text" class="text" name="exact_words" id="exact_words"/>
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
                                <input type="checkbox" name="aceitemtype" id="chk_type_articles" value="nl.wur.alterra.cgi.ace.model.impl.AceItemType.ARTICLE"/>
                                <label for="chk_type_articles"><liferay-ui:message key="acesearch-datainfotype-lbl-articles" /></label>
                            </div>

                            <div class="check">
                                <input type="checkbox" name="aceitemtype" id="chk_type_lists" value="nl.wur.alterra.cgi.ace.model.impl.AceItemType.LIST"/>
                                <label for="chk_type_lists"><liferay-ui:message key="acesearch-datainfotype-lbl-lists" /></label>
                            </div>

                            <div class="check">
                                <input type="checkbox" name="aceitemtype" id="chk_type_datasets" value="nl.wur.alterra.cgi.ace.model.impl.AceItemType.DATA"/>
                                <label for="chk_type_datasets"><liferay-ui:message key="acesearch-datainfotype-lbl-datasets" /></label>
                            </div>

                            <div class="check">
                                <input type="checkbox" name="aceitemtype" id="chk_type_tables" value="nl.wur.alterra.cgi.ace.model.impl.AceItemType.TABLE"/>
                                <label for="chk_type_tables"><liferay-ui:message key="acesearch-datainfotype-lbl-tables" /></label>
                            </div>

                            <div class="check">
                                <input type="checkbox" name="aceitemtype" id="chk_type_indicators" value="nl.wur.alterra.cgi.ace.model.impl.AceItemType.INDICATOR"/>
                                <label for="chk_type_indicators"><liferay-ui:message key="acesearch-datainfotype-lbl-indicators" /></label>
                            </div>

                            <div class="check">
                                <input type="checkbox" name="aceitemtype" id="chk_type_tools" value="nl.wur.alterra.cgi.ace.model.impl.AceItemType.TOOL"/>
                                <label for="chk_type_tools"><liferay-ui:message key="acesearch-datainfotype-lbl-tools" /></label>
                            </div>

                            <div class="check">
                                <input type="checkbox" name="aceitemtype" id="chk_type_maps" value="nl.wur.alterra.cgi.ace.model.impl.AceItemType.MAP"/>
                                <label for="chk_type_maps"><liferay-ui:message key="acesearch-datainfotype-lbl-maps" /></label>
                            </div>

                            <div class="check">
                                <input type="checkbox" name="aceitemtype" id="chk_type_multimedia" value="nl.wur.alterra.cgi.ace.model.impl.AceItemType.MULTIMEDIA"/>
                                <label for="chk_type_multimedia"><liferay-ui:message key="acesearch-datainfotype-lbl-multimedia" /></label>
                            </div>

                            <div class="check">
                                <input type="checkbox" name="aceitemtype" id="chk_type_flood" value="nl.wur.alterra.cgi.ace.model.impl.AceItemType.FLOOD"/>
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
                                <input type="checkbox" name="chk_sectors_agriculture" id="chk_sectors_agriculture"/>
                                <label for="chk_sectors_agriculture"><liferay-ui:message key="acesearch-sectors-lbl-agriculture" /></label>
                            </div>

                            <div class="check">
                                <input type="checkbox" name="chk_sectors_health" id="chk_sectors_health"/>
                                <label for="chk_sectors_health"><liferay-ui:message key="acesearch-sectors-lbl-health" /></label>
                            </div>

                            <div class="check">
                                <input type="checkbox" name="chk_sectors_biodiversity" id="chk_sectors_biodiversity"/>
                                <label for="chk_sectors_biodiversity"><liferay-ui:message key="acesearch-sectors-lbl-biodiversity" /></label>
                            </div>

                            <div class="check">
                                <input type="checkbox" name="chk_sectors_tourism" id="chk_sectors_tourism"/>
                                <label for="chk_sectors_tourism"><liferay-ui:message key="acesearch-sectors-lbl-tourism" /></label>
                            </div>

                            <div class="check">
                                <input type="checkbox" name="chk_sectors_coastal" id="chk_sectors_coastal"/>
                                <label for="chk_sectors_coastal"><liferay-ui:message key="acesearch-sectors-lbl-coastal" /></label>
                            </div>

                            <div class="check">
                                <input type="checkbox" name="chk_sectors_transport" id="chk_sectors_transport"/>
                                <label for="chk_sectors_transport"><liferay-ui:message key="acesearch-sectors-lbl-transport" /></label>
                            </div>

                            <div class="check">
                                <input type="checkbox" name="chk_sectors_fisheries" id="chk_sectors_fisheries"/>
                                <label for="chk_sectors_fisheries"><liferay-ui:message key="acesearch-sectors-lbl-fisheries" /></label>
                            </div>

                            <div class="check">
                                <input type="checkbox" name="chk_sectors_water" id="chk_sectors_water"/>
                                <label for="chk_sectors_water"><liferay-ui:message key="acesearch-sectors-lbl-water" /></label>
                            </div>

                            <div class="check">
                                <input type="checkbox" name="chk_sectors_flood" id="chk_sectors_flood"/>
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
		<div id="search_results" class="acesearch_column" style="float:right;width:45%;">
		
			<h1>Data & downloads</h1>
			
			<h2 style="color:#808080;">Search results</h2>
		
			<c:if test="${fn:length(searchResults) > 0}">	
			
				<div class="resultsgroup" style="width:100%;background-color:#d3d3d3;margin:5px 0px 0px 0px;padding:5px;font-size:x-large;">
					&#9658; Articles and publications
				</div>
				<div class="sortbar" style="width:100%;background-color:#eeeeee;margin:0px;padding:10px;font-size:larger;border-bottom:dashed #d3d3d3;">
					Sort results by: <input type="radio" name="sort" value="date" checked/>Date <input type="radio" name="sort" value="sector"/>Adaptation sector <input type="radio" name="sort" value="country"/>Country
				</div>
				
				<c:forEach var="searchResult" items="${searchResults}">
				  <div style="padding:5px;background-color:#fff;width:100%;">
					<div>
						<span style="font-weight:bolder;">&#187; <c:out value="${searchResult.name}"/> -</span> <c:out value="${searchResult.description}"/>
					</div>
					<div style="color:#d3d3d3;margin-top:20px;">
						<span style="float:left;">4 Nov 2010</span>
						<div style="display:inline;float:right;">
							<img src="<%=renderRequest.getContextPath()%>/images/icons/pdf.png" alt="Open" title="Open" style="width:30px;"/>
							<span style="padding: 0px 5px;text-decoration:underline;">Open</span>
							<span style="padding: 0px 5px;">&#9474;</span>
							<span style="padding: 0px 5px;text-decoration:underline;">View metadata</span>							
						</div>
						<hr style="clear:both;display:block;visibility:hidden;"/>
					</div>
				  </div>
				</c:forEach>

				<div class="resultsgroup" style="width:100%;background-color:#d3d3d3;margin:5px 0px 0px 0px;padding:5px;font-size:x-large;">
					&#9658; Maps
				</div>
				<div class="resultsgroup" style="width:100%;background-color:#d3d3d3;margin:5px 0px 0px 0px;padding:5px;font-size:x-large;">
					&#9658; Multimedia
				</div>
				<div class="resultsgroup" style="width:100%;background-color:#d3d3d3;margin:5px 0px 0px 0px;padding:5px;font-size:x-large;">
					&#9658; Data (sets)
				</div>
				
			</c:if>

		</div>
	
	<hr style="clear:both;display:block;visibility:hidden;"/>

</div>