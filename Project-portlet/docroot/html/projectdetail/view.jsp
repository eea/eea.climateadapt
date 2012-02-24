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
	Long project_id = 0l ;
	Project project = null;
	String[] urls = null;
	String url = null;
	String websitelabel = "Website";

	String redirect = PortalUtil.getCurrentURL(renderRequest);
	
	if(request.getAttribute(Constants.PROJECTID)!=null) {
		 
		project_id = Long.parseLong( (String) request.getAttribute(Constants.PROJECTID) ) ;
		
		try {
			
			project = ProjectLocalServiceUtil.getProject( project_id ) ;
		}
		catch(Exception exc) {
			
			project = null;
		}
		
		if(project != null) {
				
			url = project.getWebsite();
			
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
		}		
	}

	if(project != null) {
	
%>
	 <div class="detailcontainer">
	 <div class="detailheader">
	 <span class="portlet-title"><H6><% out.print( project.getAcronym() ); %>: <% out.print( project.getTitle() ); %></H6></span>
	 </div>

	 <div class="detailleft">
	 <b>Abstract</b><br />
	 <% out.print( project.getAbstracts() ); %><br /><br />
	 
	 <% if (url != null && url.trim().length() > 0)  {%>		
		 <b><%= websitelabel %></b><br />
		 <%= url %><br /><br />
	 <% } %>
	 
 	 <b>Lead</b><br />
	 <% out.print( project.getLead() ); %><br /><br />
	 <b>Partners</b><br />
	 <% out.print( project.getPartners() ); %><br /><br />

	 <b>Funding</b><br />
	 <% out.print( project.getFunding() ); %><br /><br />
 
	 <b>Duration</b><br />
	 <% out.print( project.getDuration() ); %><br /><br />


	 <% if (project.getSource().trim().length() > 0)  {%>		
	 	<b>Source</b><br />
	 	<% out.print( project.getSource() ); %><br /><br />
	 <% } %>
	 
	 </div>
	 <div class="detailright">
	 <div class="detailrightinner">
	 <b>Keywords</b><br />
	 <% out.print( project.getKeywords()); %><br /><br />	 
	 <b>Sectors</b><br />
	 <c:set var="aceItemSectors" value="<%= project.getSectors() %>" />
     <c:forEach var="adaptationSector" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemSector.values() %>" >
		<c:if test="${fn:indexOf(aceItemSectors, adaptationSector)>=0}">
			<liferay-ui:message key="acesearch-sectors-lbl-${adaptationSector}" /><br />
		</c:if>	
	 </c:forEach>
	 <br />	 
	 <b>Elements</b><br />
	 <c:set var="aceItemElements" value="<%= project.getElement() %>" />
     <c:forEach var="adaptationElement" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemElement.values() %>" >
		<c:if test="${fn:indexOf(aceItemElements, adaptationElement)>=0}">
			<liferay-ui:message key="acesearch-elements-lbl-${adaptationElement}" /><br />
		</c:if>	
	 </c:forEach>
	 <br />
<%   if ( (project.getClimateimpacts() != null) && (project.getClimateimpacts().length() > 0) ) { %>
	 <b>Climate impacts</b><br />
	 <c:set var="aceItemClimateImpacts" value="<%= project.getClimateimpacts() %>" />
     <c:forEach var="adaptationClimateImpact" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemClimateImpact.values() %>" >
		<c:if test="${fn:indexOf(aceItemClimateImpacts, adaptationClimateImpact)>=0}">
			<liferay-ui:message key="aceitem-climateimpacts-lbl-${adaptationClimateImpact}" /><br />
		</c:if>	
	 </c:forEach>
	 <br />
<%   } // end if %>	 
	 <b>Geographic characterisation</b><br />
	 <% out.print( project.getSpatiallayer().replace("_", " ") ); %><br /><br />
	 
	 <b>Countries</b><br />
	 <% out.print( project.getSpatialvalues().replace(";","; ") ); %><br /><br />
<%  
	String lastratedprojectid = "";

	if( renderRequest.getPortletSession().getAttribute("lastRatedProjectId") != null) {
		
		lastratedprojectid = (String) renderRequest.getPortletSession().getAttribute("lastRatedProjectId") ;
	}
	if( ! project_id.toString().equalsIgnoreCase( lastratedprojectid )) { %>
  <div class="detailfooter"> 
	Would you recommend this item to others?
	&nbsp;&nbsp;
	
    <!--  PERFORM PORTLET ACTION rateDownProject -->
	<portlet:actionURL name="rateDownProject" var="rateDownURL">
		<portlet:param name="projectId" value="<%= project_id.toString() %>" />
		<portlet:param name="redirect" value="<%= redirect %>"/>
	</portlet:actionURL>
	
	<liferay-ui:icon image="no" url="<%=rateDownURL.toString() %>" />
	&nbsp;&nbsp;
	
    <!--  PERFORM PORTLET ACTION rateUpProject -->
	<portlet:actionURL name="rateUpProject" var="rateUpURL">
		<portlet:param name="projectId" value="<%= project_id.toString() %>" />
		<portlet:param name="redirect" value="<%= redirect %>"/>
	</portlet:actionURL>
	
	<liferay-ui:icon image="yes" url="<%=rateUpURL.toString() %>" />
	 &nbsp;&nbsp;<br />	
	 </div>
<%	 } %>
	 </div>
	</div>
  </div>
<%	}
  else {%>      
   <div class="portlet-title">
 		<H6>No available project selected</H6>
    </div>
<% } 
	%> 
<div style="clear: both"> </div>
