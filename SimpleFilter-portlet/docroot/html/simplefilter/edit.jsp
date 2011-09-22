<%@page import="nl.wur.alterra.cgi.ace.search.AceSearchFormBean"%>
<%@page import="nl.wur.alterra.cgi.ace.search.SearchRequestParams"%>
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

AceSearchFormBean acesearchformbean = (AceSearchFormBean) request.getAttribute(SearchRequestParams.SEARCH_PARAMS);

// Retrieve parameters to fill form
String anyOfThese = acesearchformbean.getAnyOfThese();
	
String datainfo_type = null;
if ((datainfo_type == null) || (datainfo_type.equals(""))) datainfo_type = "2";
	
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

<%-- this is here and not in js file, because we're using some JSP code in it. TODO solve that and move to js file --%>
<script type="text/javascript">

    // Stores results for each data type group
    var groupedJSONResults = new Array();
										
</script>

<div id="<portlet:namespace/>content">
</div>



    <!-- Search colum -->
    <div id="filteraceitems_column" class="filteraceitems_column">
        <aui:form action="<%=searchAceitemURL%>" method="post" name="<portlet:namespace/>aceItemSearchForm">
        	        
            <div class="search_section">
                <div class="row">
                    <label for='<%= Constants.FREEPAR %>' class="input"><liferay-ui:message key='acefilter-lbl-freeparameter' /></label>
                    <input type="text" class="text" name='<%= Constants.FREEPAR %>' id='<%= Constants.FREEPAR %>' value='<%= renderRequest.getPreferences().getValue(Constants.FREEPAR,"0") %>'/>
                 </div>
            </div>
            <div class="search_section">
                <div class="row">
                    <label for='<%= Constants.NRITEMSPAGE %>' class="input"><liferay-ui:message key='acefilter-lbl-nritemspage' /></label>
                    <input type="text" class="text" name='<%= Constants.NRITEMSPAGE %>' id='<%= Constants.NRITEMSPAGE %>' value='<%= renderRequest.getPreferences().getValue(Constants.NRITEMSPAGE,"10") %>'/>
                </div>
            </div>
        
            <div class="search_section">
                <div class="row">
                    <label for='<%= Constants.FUZZINESS %>' class="input"><liferay-ui:message key='acefilter-lbl-fuzziness' /></label>
                    <input type="text" class="text" name="<%= Constants.FUZZINESS %>" value='<%= renderRequest.getPreferences().getValue(Constants.FUZZINESS, "0.7") %>' />
                 </div>
            </div>  

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
                    <% //  input type="radio" name="datainfo_type" value="1" < %= (datainfo_type.equals("1"))?"checked":"" % > /><liferay-ui:message key="acesearch-datainfotype-lbl-all" / -->  %>
                    <input type="radio" name="datainfo_type" value="2" <%= (datainfo_type.equals("2"))?"checked":"" %> /><liferay-ui:message key="acesearch-datainfotype-lbl-sel" /> (select none = all)

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

            <div class="search_section">
                <h2><liferay-ui:message key="acesearch-section-header4" /></h2>
                <ul>
                    <li>
                        <a href="#" id="adaptation_sectors_btn" class="expanded_section"><liferay-ui:message key="acesearch-section-adaptation-sectors" /></a>
                        <div id="adaptation_sectors_container" class="checks_container">		
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

                    <li>
                        <a href="#" id="adaptation_elements_btn" class="collapsed_section"><liferay-ui:message key="acesearch-section-adaptation-elements" /></a>
                        <div id="adaptation_elements_container" class="checks_container">		
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
                </ul>
            </div>

            <div id="form_footer">
                <input type="submit" value="<liferay-ui:message key="acesearch-search-btn" />"/>
            </div>
        </aui:form>
    </div>
</div>

<hr class="clearer"/>
