<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@include file="/html/init.jsp" %>

<%
	Long aceitem_id = 0l ;
	AceItem aceitem = null;
	String url = null;
	String metadataurl = null;
	String[] urls = null;
	String websitelabel = "Website";

	String redirect = PortalUtil.getCurrentURL(renderRequest);
	
	if(request.getAttribute(Constants.ACEITEMID)!=null) {

		aceitem_id = Long.parseLong( (String) request.getAttribute(Constants.ACEITEMID) ) ;

		try {
			
			aceitem = AceItemLocalServiceUtil.getAceItem( aceitem_id ) ;
		}
		catch(Exception exc) {
			
			aceitem = null;
		}
				
		if(aceitem != null) {
			
			if(aceitem.getStoragetype().equalsIgnoreCase("GEONETWORK")) {
				// cswRecordFileIdentifier gets handled inside mapviewer-portlet
				url = "<a href='/map-viewer?cswRecordFileIdentifier=" + aceitem.getStoredAt() + "' >View map " + aceitem.getName() + "</a>" ; 
				//dev:	metadataurl = "<a href='http://dev.ace.geocat.net/geonetwork/srv/en/metadata.show?uuid=" + aceitem.getStoredAt() + "' target='_blank'>View metadata " + aceitem.getName() + "</a>" ; 
				metadataurl = "<a href='/geonetwork/srv/en/metadata.show?uuid=" + aceitem.getStoredAt() + "' target='_blank'>View metadata " + aceitem.getName() + "</a>" ; 
			}
			else if(aceitem.getStoragetype().equalsIgnoreCase("SETOFMAPS")) {
				// mapViewerAppId gets handled inside mapviewer-portlet
				url = "<a href='/map-viewer?mapViewerAppId=" + aceitem.getStoredAt() + "' > " + aceitem.getName() + "</a>" ; 
			}
			else {	

				url = aceitem.getStoredAt();
				
				if(url != null && url.trim().length() > 0) {
	
					// Portlet code checks for splitter to be '; '
					urls = url.split(";");
					
					url = "" ;
					for(int i=0; i<urls.length; i++) {
						
						if(i==2) { websitelabel += "s" ;}
						
						urls[i] = urls[i].trim();
						
						if(urls[i].length() > 0) {
							if ( ! (urls[i].startsWith("http")  || urls[i].startsWith("/") ) ) {
								
								urls[i] = "http://" + urls[i];
							}
							
							url += "<a href='" + urls[i] + "' target='_blank'>" + urls[i] + "</a>&nbsp;&nbsp;" ;
						}
					} 
				}
			}
		}		
	}

	if(aceitem != null) {	
%>

	 <div class="detailcontainer">
	 <div class="detailheader">
	 <span class="portlet-title"><H6><% out.print( aceitem.getName() ); %></H6>
	 </div>
	 	 
	 <div class="detailleft">	 
	 <b>Description</b><br />
	 <% out.print( aceitem.getDescription() ); %><br /><br />

<%  	if(aceitem.getStoragetype().equalsIgnoreCase("GEONETWORK") ) { %>
	<b>Go to the service</b><br />
	 <% out.print( url ); %><br /><br />
	 <% out.print( metadataurl ); %><br /><br />
<%	 }
	 else if(aceitem.getStoragetype().equalsIgnoreCase("SETOFMAPS") ) { %>
		<b>View set of maps</b><br />
		 <% out.print( url ); %><br /><br />
	<%	 }
		 else{ %>
	 	<b>Website</b><br />
	 <% out.print(  url ); %><br /><br />
<% 	} %>

	 
	 <b>Source</b><br />
	 <% out.print( aceitem.getSource()); %><br /><br />
	
	 </div>
	 <div class="detailright">
	 <div class="detailrightinner">
	 
	 <b>Keywords</b><br />
	 <% out.print( aceitem.getKeyword()); %><br /><br />
	
	 <b>Sectors</b><br />
	 <c:set var="aceItemSectors" value="<%= aceitem.getSectors_() %>" />
     <c:forEach var="adaptationSector" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemSector.values() %>" >
		<c:if test="${fn:indexOf(aceItemSectors, adaptationSector)>=0}">
			<liferay-ui:message key="acesearch-sectors-lbl-${adaptationSector}" /><br />
		</c:if>	
	 </c:forEach>
	 <br /><br />
	 
	 <b>Elements</b><br />
	 <c:set var="aceItemElements" value="<%= aceitem.getElements_() %>" />
     <c:forEach var="adaptationElement" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemElement.values() %>" >
		<c:if test="${fn:indexOf(aceItemElements, adaptationElement)>=0}">
			<liferay-ui:message key="acesearch-elements-lbl-${adaptationElement}" /><br />
		</c:if>	
	 </c:forEach>
	 <br /><br />
	 
	 <b>Climate impacts</b><br />
	 <c:set var="aceItemClimateImpacts" value="<%= aceitem.getClimateimpacts_() %>" />
     <c:forEach var="adaptationClimateImpact" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemClimateImpact.values() %>" >
		<c:if test="${fn:indexOf(aceItemClimateImpacts, adaptationClimateImpact)>=0}">
			<liferay-ui:message key="aceitem-climateimpacts-lbl-${adaptationClimateImpact}" /><br />
		</c:if>	
	 </c:forEach>
	 <br /><br />

	 <b>Geographic area</b><br />
	 <% out.print( aceitem.getSpatialLayer().replace("_", " ")); %><br /><br />
	 
	 <b>Countries</b><br />
	 <% out.print( aceitem.getSpatialValues() ); %><br /><br />

<%  
	String lastratedaceitemid = "";

	if( renderRequest.getPortletSession().getAttribute("lastRatedAceItemId") != null) {
		
		lastratedaceitemid = (String) renderRequest.getPortletSession().getAttribute("lastRatedAceItemId") ;
	}
	if( ! aceitem_id.toString().equalsIgnoreCase( lastratedaceitemid )) { %>
  <div class="detailfooter"> 		
	Would you recommend this item to others?
	&nbsp;&nbsp;
	
    <!--  PERFORM PORTLET ACTION rateDownAceItem -->
	<portlet:actionURL name="rateDownAceItem" var="rateDownURL">
		<portlet:param name="aceitemId" value="<%= aceitem_id.toString() %>" />
		<portlet:param name="redirect" value="<%= redirect %>"/>
	</portlet:actionURL>
	
	<liferay-ui:icon image="no" url="<%=rateDownURL.toString() %>" />
	&nbsp;&nbsp;
	
    <!--  PERFORM PORTLET ACTION rateUpAceItem -->
	<portlet:actionURL name="rateUpAceItem" var="rateUpURL">
		<portlet:param name="aceitemId" value="<%= aceitem_id.toString() %>" />
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
     <H6>No available item selected</H6>
    </div>
<% } 
	%> 

