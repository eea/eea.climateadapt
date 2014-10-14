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

int filter = Integer.parseInt( renderRequest.getPreferences().getValue(Constants.FREEPAR, "0") );

long sofarnr = 0;

long prefnritemspage = Long.parseLong(renderRequest.getPreferences().getValue(Constants.NRITEMSPAGE, "10"));

int nrOfCheckboxes = Integer.parseInt( renderRequest.getPreferences().getValue(Constants.NRCHECKBOXES, "2") );

String defaultImpact = renderRequest.getPreferences().getValue(Constants.USERDEFAULTIMPACT, "all");

String defaultSector = renderRequest.getPreferences().getValue(Constants.USERDEFAULTSECTOR, "all");

String defaultScenario = renderRequest.getPreferences().getValue(Constants.USERDEFAULTSCENARIO, "all");

String defaultPeriod = renderRequest.getPreferences().getValue(Constants.USERDEFAULTPERIOD, "all");

AceSearchFormBean acesearchformbean = (AceSearchFormBean) request.getAttribute(SearchRequestParams.SEARCH_PARAMS);

// Retrieve parameters to fill form

String anyOfThese = null;
	
String[] aceitemtypes = null;

if(acesearchformbean != null) {
	anyOfThese = acesearchformbean.getAnyOfThese();
	
	aceitemtypes = acesearchformbean.getAceitemtype();
}
else {
	anyOfThese = renderRequest.getPreferences().getValue(SearchRequestParams.ANY,"");
	
	aceitemtypes = renderRequest.getPreferences().getValues(SearchRequestParams.ACEITEM_TYPE, new String[] {} );	
}
String selected = "";

String selected_impact = (String) renderRequest.getPortletSession().getAttribute(Constants.USERIMPACT);

String selected_sector = (String) renderRequest.getPortletSession().getAttribute(Constants.USERSECTOR);

String selected_scenario = (String) renderRequest.getPortletSession().getAttribute(Constants.USERSCENARIO);

String selected_timeperiod = (String) renderRequest.getPortletSession().getAttribute(Constants.USERTIMEPERIOD);

if (selected_impact == null  ) {
	selected_impact = defaultImpact; 
}
else if ( !selected_impact.equalsIgnoreCase("all") )  {
	selected = "selected='selected'";
}

String redirect = PortalUtil.getCurrentURL(renderRequest);

%>
<portlet:actionURL name="searchAceitem" var="searchAceitemURL"/>


<!--  portlet:resourceURL var="sortURL" id="view.jsp" escapeXml="false" / -->

<%-- this is here and not in js file, because we're using some JSP code in it. TODO solve that and move to js file --%>
<script type="text/javascript">

	var groupedJSONResults = new Array();
								
</script>

<div id="<portlet:namespace/>content" style="width: 100%;">
<%
	if (filter==1 || filter==3) {
%>
			<form action="<%=searchAceitemURL%>" method="post" id="ace_simplefilter_30x" name="<portlet:namespace/>aceItemSearchForm">

	<portlet:actionURL name="searchAceitem" var="searchURL">
		<portlet:param name="redirect" value="<%= redirect %>"/>
	</portlet:actionURL>	

       					<div id="risk-selector-div" class="adaptationtools-selector" style="width:400px;">
						<span style="margin-right:10px;float:left;width:95px;" >
							Climate impact
						</span>
						<select id="risk-selector" name="risk-selector" style="float:left;width: 239px;" onchange="document.getElementById('ace_simplefilter_30x').submit()" >
							<option value="all" <%= selected %>>All climate impacts</option>
							<c:set var="selectedImpact" value="<%= selected_impact %>" />
							<c:forEach var="adaptationClimateImpact" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemClimateImpact.values() %>" >	
							        <option value="${adaptationClimateImpact}"
									<c:if test="${fn:indexOf(selectedImpact, adaptationClimateImpact)>=0}">
										selected='selected'
									</c:if>       
							        ><liferay-ui:message key="aceitem-climateimpacts-lbl-${adaptationClimateImpact}" /></option>
							</c:forEach>
						</select>
					</div>
<%

if (selected_sector == null  ) {
	selected_sector = defaultSector; 
}
else if ( !selected_sector.equalsIgnoreCase("all") )  {
	selected = "selected='selected'";
}

%>					
					<!-- added width because IE8 renders a 100% width otherwise -->
					<div id="sector-selector-div" class="adaptationtools-selector" style="margin-top:10px;float:left;width:400px;"> <!--  style="float:left;width:306px; -->
						<span style="margin-right:10px;float:left;width:95px;"> 
							Adaptation sector
						</span>
						<select id="sector-selector" name="sector-selector" style="float:left;width: 239px;" onchange="document.getElementById('ace_simplefilter_30x').submit()" >
							<option value="all" <%= selected %>>All adaptation sectors</option>
							<c:set var="selectedSector" value="<%= selected_sector %>" />
							<c:forEach var="adaptationSector" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemSector.values() %>">	
							        <option value="${adaptationSector}"
									<c:if test="${fn:indexOf(selectedSector, adaptationSector)>=0}">
										selected='selected'
									</c:if>       
							        ><liferay-ui:message key="acesearch-sectors-lbl-${adaptationSector}" /></option>
							</c:forEach>
						</select>
					</div>	
					
					
<%
	if(nrOfCheckboxes == 4) {
		if (selected_scenario == null  ) {
			selected_scenario = defaultScenario; 
		}
		else if ( !selected_scenario.equalsIgnoreCase("all") )  {
			selected = "selected='selected'";
		}
%>					
					<!-- added width because IE8 renders a 100% width otherwise -->
					<div id="scenario-selector-div" class="adaptationtools-selector" style="margin-top:10px;float:left;width:400px;">
						<span style="margin-right:10px;float:left;width:95px;">
							Scenario
						</span>
						<select id="scenario-selector" name="scenario-selector" style="float:left;width: 239px;" onchange="document.getElementById('ace_simplefilter_30x').submit()" >
							<option value="all" <%= selected %>>All scenarios</option>
							<c:set var="selectedScenario" value="<%= selected_scenario %>" />
							<c:forEach var="adaptationScenario" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemScenario.values() %>">	
							        <option value="${adaptationScenario}"
									<c:if test="${fn:indexOf(selectedScenario, adaptationScenario)>=0}">
										selected='selected'
									</c:if>       
							        ><liferay-ui:message key="acesearch-scenario-lbl-${adaptationScenario}" /></option>
							</c:forEach>
						</select>
					</div>	
					
					
<%
if (selected_timeperiod == null  ) {
	selected_timeperiod = defaultPeriod;
}
else if ( !selected_timeperiod.equalsIgnoreCase("all") )  {
	selected = "selected='selected'";
}
%>					
					<!-- added width because IE8 renders a 100% width otherwise -->
					<div id="timeperiod-selector-div" class="adaptationtools-selector" style="margin-top:10px;float:left;width:400px;">
						<span style="margin-right:10px;float:left;width:95px;">
							Time period
						</span>
						<select id="timeperiod-selector" name="timeperiod-selector" style="float:left;width: 239px;" onchange="document.getElementById('ace_simplefilter_30x').submit()" >
							<option value="all" <%= selected %>>All time periods</option>
							<c:set var="selectedTimePeriod" value="<%= selected_timeperiod %>" />
							<c:forEach var="adaptationTimePeriod" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemTimePeriod.values() %>">	
							        <option value="${adaptationTimePeriod}"
									<c:if test="${fn:indexOf(selectedTimePeriod, adaptationTimePeriod)>=0}">
										selected='selected'
									</c:if>       
							        ><liferay-ui:message key="acesearch-timeperiod-lbl-${adaptationTimePeriod}" /></option>
							</c:forEach>
						</select>
					</div>	
<%	}
%>									
        </form>
<%
	if(nrOfCheckboxes == 4) { 
%>		<br />        
        <br />      
        <br />
<%	}
%>        
        <br />
        <br />        
        <br />       
        <br />
<% 		
	}
%>
</div>
<div id="filteraceitems_container" style="width: 100%;">
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
        
<% 		if( sofarnr < prefnritemspage ) {
			if( filter <= 1) {	%>	
       			<%@ include file="searchresultsonetype.jspf" %>
<% 			} else { %>	
        		<%@ include file="searchresultsgowebsite.jspf" %>
<% 			}
  		}	%>	
		<c:set var="groupedResults" scope="page" value="${INFORMATIONSOURCE_searchResults}"/>
		<c:set var="groupedJSONResults" scope="page" value="${INFORMATIONSOURCE_JSONsearchResults}"/>
		<c:set var="aceitemtype" scope="page" value="INFORMATIONSOURCE"/>				
		<c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-INFORMATIONSOURCE" /></c:set>

<% 		if( sofarnr < prefnritemspage ) {
			if( filter <= 1) {	%>	
       			<%@ include file="searchresultsonetype.jspf" %>
<% 			} else { %>	
        		<%@ include file="searchresultsgowebsite.jspf" %>
<% 			}
  		}	%>	

        <c:set var="groupedResults" scope="page" value="${GUIDANCE_searchResults}"/>
        <c:set var="groupedJSONResults" scope="page" value="${GUIDANCE_JSONsearchResults}"/>
        <c:set var="aceitemtype" scope="page" value="GUIDANCE"/>
        <c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-GUIDANCE" /></c:set>

<% 		if( sofarnr < prefnritemspage ) {
			if( filter <= 1) {	%>	
       			<%@ include file="searchresultsonetype.jspf" %>
<% 			} else { %>	
        		<%@ include file="searchresultsgowebsite.jspf" %>
<% 			}
  		}	%>	

        <c:set var="groupedResults" scope="page" value="${TOOL_searchResults}"/>
        <c:set var="groupedJSONResults" scope="page" value="${TOOL_JSONsearchResults}"/>
        <c:set var="aceitemtype" scope="page" value="TOOL"/>
        <c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-TOOL" /></c:set>

<% 		if( sofarnr < prefnritemspage ) {
			if( filter <= 1) {	%>	
       			<%@ include file="searchresultsonetype.jspf" %>
<% 			} else { %>	
        		<%@ include file="searchresultsgowebsite.jspf" %>
<% 			}
  		}	%>	

		<c:set var="groupedResults" scope="page" value="${MAPGRAPHDATASET_searchResults}"/>
		<c:set var="groupedJSONResults" scope="page" value="${MAPGRAPHDATASET_JSONsearchResults}"/>
		<c:set var="aceitemtype" scope="page" value="MAPGRAPHDATASET"/>		
		<c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-MAPGRAPHDATASET" /></c:set>

<% 		if( sofarnr < prefnritemspage ) {
			if( filter <= 1) {	%>	
       			<%@ include file="searchresultsonetype.jspf" %>
<% 			} else { %>	
        		<%@ include file="searchresultsgowebsite.jspf" %>
<% 			}
  		}	%>	

        <c:set var="groupedResults" scope="page" value="${INDICATOR_searchResults}"/>
		<c:set var="groupedJSONResults" scope="page" value="${INDICATOR_JSONsearchResults}"/>
		<c:set var="aceitemtype" scope="page" value="INDICATOR"/>
		<c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-INDICATOR" /></c:set>

<% 		if( sofarnr < prefnritemspage ) {
			if( filter <= 1) {	%>	
       			<%@ include file="searchresultsonetype.jspf" %>
<% 			} else { %>	
        		<%@ include file="searchresultsgowebsite.jspf" %>
<% 			}
  		}	%>	

        <c:set var="groupedResults" scope="page" value="${RESEARCHPROJECT_searchResults}"/>
		<c:set var="groupedJSONResults" scope="page" value="${RESEARCHPROJECT_JSONsearchResults}"/>
		<c:set var="aceitemtype" scope="page" value="RESEARCHPROJECT"/>
		<c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-RESEARCHPROJECT" /></c:set>

<% 		if( sofarnr < prefnritemspage ) {
			if( filter <= 1) {	%>	
       			<%@ include file="searchresultsonetype.jspf" %>
<% 			} else { %>	
        		<%@ include file="searchresultsgowebsite.jspf" %>
<% 			}
  		}	%>	

        <c:set var="groupedResults" scope="page" value="${MEASURE_searchResults}"/>
		<c:set var="groupedJSONResults" scope="page" value="${MEASURE_JSONsearchResults}"/>
		<c:set var="aceitemtype" scope="page" value="MEASURE"/>
		<c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-MEASURE" /></c:set>

<% 		if( sofarnr < prefnritemspage ) {
			if( filter <= 1) {	%>	
       			<%@ include file="searchresultsonetype.jspf" %>
<% 			} else { %>	
        		<%@ include file="searchresultsgowebsite.jspf" %>
<% 			}
  		}	%>	

        <c:set var="groupedResults" scope="page" value="${ACTION_searchResults}"/>
		<c:set var="groupedJSONResults" scope="page" value="${ACTION_JSONsearchResults}"/>
		<c:set var="aceitemtype" scope="page" value="ACTION"/>
		<c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-ACTION" /></c:set>

<% 		if( sofarnr < prefnritemspage ) {
			if( filter <= 1) {	%>	
       			<%@ include file="searchresultsonetype.jspf" %>
<% 			} else { %>	
        		<%@ include file="searchresultsgowebsite.jspf" %>
<% 			}
  		}	%>	

        <c:set var="groupedResults" scope="page" value="${ORGANISATION_searchResults}"/>
		<c:set var="groupedJSONResults" scope="page" value="${ORGANISATION_JSONsearchResults}"/>
		<c:set var="aceitemtype" scope="page" value="ORGANISATION"/>
		<c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-ORGANISATION" /></c:set>

<% 		if( sofarnr < prefnritemspage ) {
			if( filter <= 1) {	%>	
       			<%@ include file="searchresultsonetype.jspf" %>
<% 			} else { %>	
        		<%@ include file="searchresultsgowebsite.jspf" %>
<% 			}
  		}	%>	
 		
<% 	if( sofarnr < totalResults ) {	
		String searchstring = "/data-and-downloads" ;
		
		String handle = "?" ;
		
		if( anyOfThese != null) { 
			searchstring += handle + "searchtext=" + anyOfThese ; 
			handle="&" ; 
		}
		
		if( (aceitemtypes != null) && (aceitemtypes.length > 0) ) { 
			searchstring += handle + "searchtypes=" ;
			handle="&" ; 			
			for(int j=0; j < aceitemtypes.length; j++ )
				{ searchstring += (j > 0 ? ";" : "" ) + aceitemtypes[j] ; } 
		}
		
		if (filter==1 || filter==3) {

			if (selected_sector != null && ! selected_sector.equalsIgnoreCase("all")) {
				searchstring += handle + "searchsectors=" ;
				handle="&" ; 			
				searchstring += selected_sector;
			}
				
			if(  selected_impact != null && ! selected_impact.equalsIgnoreCase("all")) {
				searchstring += handle + "searchimpacts=" ;
				handle="&" ; 			
				searchstring += selected_impact;
			}
		}
		
%>		
		<div class='searchAll' style='text-align: right'>
			<br /><a href='<%= searchstring %>'>View all</a>
		</div>
<% 		
	}  	
		String portletId = themeDisplay.getPortletDisplay().getId();
		javax.portlet.PortletPreferences portletSetup = PortletPreferencesFactoryUtil.getLayoutPortletSetup(themeDisplay.getLayout(), portletId);
		String portletCustomTitle = themeDisplay.getPortletDisplay().getTitle();
		portletCustomTitle = portletSetup.getValue("portlet-setup-title-" + themeDisplay.getLanguageId(),portletCustomTitle);
		
	 %>

	</div>
	
	<hr class="clearer"/>

</div>