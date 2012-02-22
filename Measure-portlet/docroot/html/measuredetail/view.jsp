<%
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
%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@include file="/html/init.jsp" %>


<%
	Long measure_id = 0l ;
	Measure measure = null;
	String[] urls = null;
	String url = null;
	String type = "Adaptation option";
	String websitelabel = "Website";
	String implementationtype = "";

	String redirect = PortalUtil.getCurrentURL(renderRequest);
	
	if(request.getAttribute(Constants.MEASUREID)!=null) {
		measure_id = Long.parseLong( (String) request.getAttribute(Constants.MEASUREID) ) ;
		
		try {
			measure = MeasureLocalServiceUtil.getMeasure( measure_id ) ;
		}
		catch(Exception exc) {
			
			measure = null;
		}
		
		if(measure != null) {
			
			url = measure.getWebsite();
			
			if(url != null && url.trim().length() > 0) {
	
				// Portlet code checks for splitter to be '; '
				urls = url.split(";");
				
				url = "" ;
				for(int i=0; i<urls.length; i++) {
					
					if(i==2) { websitelabel += "s" ;}
					
					urls[i] = urls[i].trim();
					
					if(urls[i].length() > 0) {
						if ( ! (urls[i].startsWith("http://")  || urls[i].startsWith("/") ) ) {
							
							urls[i] = "http://" + urls[i];
						}
						
						url += "<a href='" + urls[i] + "' target='_blank'>" + urls[i] + "</a>&nbsp;&nbsp;" ;
					}
				} 
			}
			
			if( measure.getMao_type().equalsIgnoreCase("A")) {
				type = "Case study" ;
			}
			
			if (measure.getImplementationtype().equalsIgnoreCase("grey"))	{
				implementationtype = "Technical ('grey')" ;
			}
			else if (measure.getImplementationtype().equalsIgnoreCase("green"))	{
				implementationtype = "Ecological ('green')" ;
			}
			else if (measure.getImplementationtype().equalsIgnoreCase("soft"))	{
				implementationtype = "Behavioural / policy ('soft')" ;
			}
		}
		else {
			
			measure_id = 0l;
		}
	}
	
	if(measure != null) {
%>

	 <div class="detailcontainer">
	 <div class="detailheader">
	 <span class="portlet-title"><H6><% out.print( measure.getName() ); %> (<%= type %>)</H6>
	 </div>
	 	 
	 <div class="detailleft">	 
	 <b>Description</b><br />
	 <% out.print( measure.getDescription() ); %><br /><br />

	<% if (url != null && url.trim().length() > 0)  {%>		
		 <b><%= websitelabel %></b><br />
		 <%= url %><br /><br />
	<% } %>
		 
	 <b>Contact</b><br />
	 <% out.print( measure.getContact() ); %><br /><br />	 
	 
	 <b>Implementationtype</b><br />
	 <% out.print( implementationtype ); %><br /><br />
	 
	 <b>Implementationtime</b><br />
	 <% out.print( measure.getImplementationtime() ); %><br /><br />
	 
	 <b>Lifetime</b><br />
	 <% out.print( measure.getLifetime() ); %><br /><br />
	 
	 <b>Legal aspects</b><br />
	 <% out.print( measure.getLegalaspects() ); %><br /><br />
	 
	 <b>Stakeholder participation</b><br />
	 <% out.print( measure.getStakeholderparticipation() ); %><br /><br />
	 
	 <b>Succes and limitation factors</b><br />
	 <% out.print( measure.getSucceslimitations() ); %><br /><br />
	 
	 <b>Cost benefit</b><br />
	 <% out.print( measure.getCostbenefit() ); %><br /><br />
	 	 
	 <b>Source</b><br />
	 <% out.print( measure.getSource() ); %><br /><br />
	 
	 </div>
	 <div class="detailright">	 
	
	 <b>Keywords</b><br />
	 <% out.print( measure.getKeywords()); %><br /><br />

	 <b>Sectors</b><br />
	 <c:set var="aceItemSectors" value="<%= measure.getSectors_() %>" />
     <c:forEach var="adaptationSector" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemSector.values() %>" >
		<c:if test="${fn:indexOf(aceItemSectors, adaptationSector)>=0}">
			<liferay-ui:message key="acesearch-sectors-lbl-${adaptationSector}" /><br />
		</c:if>	
	 </c:forEach>
	 <br /><br />
	 
	 <b>Elements</b><br />
	 <c:set var="aceItemElements" value="<%= measure.getElements_() %>" />
     <c:forEach var="adaptationElement" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemElement.values() %>" >
		<c:if test="${fn:indexOf(aceItemElements, adaptationElement)>=0}">
			<liferay-ui:message key="acesearch-elements-lbl-${adaptationElement}" /><br />
		</c:if>	
	 </c:forEach>
	 <br /><br />
	 
	 <b>Climate impacts</b><br />
	 <c:set var="aceItemClimateImpacts" value="<%= measure.getClimateimpacts_() %>" />
     <c:forEach var="adaptationClimateImpact" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemClimateImpact.values() %>" >
		<c:if test="${fn:indexOf(aceItemClimateImpacts, adaptationClimateImpact)>=0}">
			<liferay-ui:message key="aceitem-climateimpacts-lbl-${adaptationClimateImpact}" /><br />
		</c:if>	
	 </c:forEach>
	 <br /><br />	 
	 <b>Geographic characterisation</b><br />
	 <% out.print( measure.getSpatiallayer().replace("_", " ") ); %><br /><br />
	 
	 <b>Countries</b><br />
	 <% out.print( measure.getSpatialvalues() ); %><br /><br />
	 </div>
<%  
	String lastratedmeasureid = "";

	if( renderRequest.getPortletSession().getAttribute("lastRatedMeasureId") != null) {
		
		lastratedmeasureid = (String) renderRequest.getPortletSession().getAttribute("lastRatedMeasureId") ;
	}
	if( ! measure_id.toString().equalsIgnoreCase( lastratedmeasureid )) { %>
  <div class="detailfooter"> 	
	Would you recommend this item to others?
	&nbsp;&nbsp;
	
    <!--  PERFORM PORTLET ACTION rateDownMeasure -->
	<portlet:actionURL name="rateDownMeasure" var="rateDownURL">
		<portlet:param name="measureId" value="<%= measure_id.toString() %>" />
		<portlet:param name="redirect" value="<%= redirect %>"/>
	</portlet:actionURL>
	
	<liferay-ui:icon image="no" url="<%=rateDownURL.toString() %>" />
	&nbsp;&nbsp;
	
    <!--  PERFORM PORTLET ACTION rateUpMeasure -->
	<portlet:actionURL name="rateUpMeasure" var="rateUpURL">
		<portlet:param name="measureId" value="<%= measure_id.toString() %>" />
		<portlet:param name="redirect" value="<%= redirect %>"/>
	</portlet:actionURL>
	
	<liferay-ui:icon image="yes" url="<%=rateUpURL.toString() %>" />
	 &nbsp;&nbsp;<br />	
	 </div>
<%	 } %>
  </div>
<%	}
  else {%>      
   <div class="portlet-title">
 		<H1>No available measure selected</H1>
    </div>
<% } 
	%> 

