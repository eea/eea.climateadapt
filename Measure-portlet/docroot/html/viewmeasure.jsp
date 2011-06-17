<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@include file="/html/init.jsp" %>


<%
	Long measure_id = 0l ;
	Measure measure = null;
	String[] urls = null;
	String url = null;
	String type = "Measure";
	String websitelabel = "Website";
	
	if(request.getAttribute("measure_id")!=null) {
		measure_id = Long.parseLong( (String) request.getAttribute("measure_id") ) ;
		measure = MeasureLocalServiceUtil.getMeasure( measure_id ) ;
		
		url = measure.getWebsite();
		
		if(url != null && url.trim().length() > 0) {
			urls = url.split(";");
			
			url = "" ;
			for(int i=0; i<urls.length; i++) {
				
				if(i>0) { websitelabel += "s" ;}
				
				if(urls[i].trim().length() > 0) {
					if ( !urls[i].startsWith("http://")) {
						
						urls[i] = "http://" + urls[i];
					}
					
					url += "<a href='" + urls[i] + "' target='_blank'>" + urls[i] + "</a>&nbsp;&nbsp;&nbsp;&nbsp;" ;
				}
			} 
		}
		
		if( measure.getMao_type().equalsIgnoreCase("A")) {
			type = "Action" ;
		}
	}
	
%>

 <c:choose>
   <c:when test="${measure_id>0}">
	 <H1><% out.print( measure.getName() ); %> (<%= type %>)</H1>
	 <b>Description</b><br />
	 <% out.print( measure.getDescription() ); %><br /><br />
	 <b>Contact</b><br />
	 <% out.print( measure.getContact() ); %><br /><br />	 

	 <b>Source</b><br />
	 <% out.print( measure.getSource() ); %><br /><br />
   
	 <b>Sectors</b><br />
	 <c:set var="aceItemSectors" value="<%= measure.getSectors_() %>" />
     <c:forEach var="adaptationSector" items="<%= nl.wur.alterra.cgi.ace.model.impl.AceItemSector.values() %>" >
		<c:if test="${fn:indexOf(aceItemSectors, adaptationSector)>=0}">
			<liferay-ui:message key="acesearch-sectors-lbl-${adaptationSector}" /><br />
		</c:if>	
	 </c:forEach>
	 <br /><br />
	 
	 <b>Elements</b><br />
	 <c:set var="aceItemElements" value="<%= measure.getElements_() %>" />
     <c:forEach var="adaptationElement" items="<%= nl.wur.alterra.cgi.ace.model.impl.AceItemElement.values() %>" >
		<c:if test="${fn:indexOf(aceItemElements, adaptationElement)>=0}">
			<liferay-ui:message key="acesearch-elements-lbl-${adaptationElement}" /><br />
		</c:if>	
	 </c:forEach>
	 <br /><br />
	 
	 <b>Climate impacts</b><br />
	 <c:set var="aceItemClimateImpacts" value="<%= measure.getClimateimpacts_() %>" />
     <c:forEach var="adaptationClimateImpact" items="<%= nl.wur.alterra.cgi.ace.model.impl.AceItemClimateImpact.values() %>" >
		<c:if test="${fn:indexOf(aceItemClimateImpacts, adaptationClimateImpact)>=0}">
			<liferay-ui:message key="aceitem-climateimpacts-lbl-${adaptationClimateImpact}" /><br />
		</c:if>	
	 </c:forEach>
	 <br /><br />
	 
	 	<b>Keywords</b><br />
	 <% out.print( measure.getKeywords()); %><br /><br />
	 
	 
	 <b>Implementationtype</b><br />
	 <% out.print( measure.getImplementationtype() ); %><br /><br />
	 
	 <b>Implementationtime</b><br />
	 <% out.print( measure.getImplementationtime() ); %><br /><br />
	 
	 <b>Lifetime</b><br />
	 <% out.print( measure.getLifetime() ); %><br /><br />
	 
	 <b>Spatial layer</b><br />
	 <% out.print( measure.getSpatiallayer() ); %><br /><br />
	 
	 <b>Spatial values</b><br />
	 <% out.print( measure.getSpatialvalues() ); %><br /><br />
	 
	 <b>Legal aspects</b><br />
	 <% out.print( measure.getLegalaspects() ); %><br /><br />
	 
	 <b>Stakeholder participation</b><br />
	 <% out.print( measure.getStakeholderparticipation() ); %><br /><br />
	 
	 <b>Succes and limitation factors</b><br />
	 <% out.print( measure.getSucceslimitations() ); %><br /><br />
	 
	 <b>Cost benefit</b><br />
	 <% out.print( measure.getCostbenefit() ); %><br /><br />	
	 
		<% if (url != null && url.trim().length() > 0)  {%>		
			 <b><%= websitelabel %></b><br />
			 <%= url %><br /><br />
		<% } %>
   </c:when>
   <c:otherwise>
     <H1>No Measure selected</H1>
   </c:otherwise>
 </c:choose>
