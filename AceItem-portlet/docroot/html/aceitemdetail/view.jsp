<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@include file="/html/init.jsp" %>


<%
	Long aceitem_id = 0l ;
	AceItem aceitem = null;
	String url = null;

	String redirect = PortalUtil.getCurrentURL(renderRequest);
	
	if(request.getAttribute(Constants.ACEITEMID)!=null) {
		aceitem_id = Long.parseLong( (String) request.getAttribute(Constants.ACEITEMID) ) ;
		aceitem = AceItemLocalServiceUtil.getAceItem( aceitem_id ) ;
		
		if(aceitem.getStoragetype().equalsIgnoreCase("GEONETWORK")) {
			url = "<a href='/map-viewer?cswRecordFileIdentifier=" + aceitem.getStoredAt() + "' >" + aceitem.getName() + "</a>" ; 
		}
		else {	
			url = "<a href='" + aceitem.getStoredAt() + "' target='_blank'>" + aceitem.getStoredAt() + "</a>" ;
		}

	}
	
%>
<div class="item-detail">
<div class="text-container">
 <c:choose>
   <c:when test="${aceitem_id>0}">
     <div class="portlet-title">
	 <H1><% out.print( aceitem.getName() ); %></H1>
	 </div>
	 <div class="body">
	 <b>Description</b><br />
	 <% out.print( aceitem.getDescription() ); %><br /><br />

	<table border="0" width="100%"><tr>
	<td width="50%" valign="top"><div style="margin-right: 35px;">	 
	 <b>Keywords</b><br />
	 <% out.print( aceitem.getKeyword()); %><br /><br />
	 
	 <b>Source</b><br />
	 <% out.print( aceitem.getSource()); %><br /><br />
<%  	if(aceitem.getStoragetype().equalsIgnoreCase("GEONETWORK") ) { %>
	<b>View map</b><br />
<%	 }
	 else { %>
	 	<b>Website</b><br />
<% 	} %>
	 <% out.print(  url ); %><br /><br />
	 <b>Resolution</b><br />
	 <% out.print( aceitem.getTargetresolution()); %><br /><br />

	 <b>Spatial reference</b><br />
	 <% out.print( aceitem.getSpatialLayer() + " " + aceitem.getSpatialValues()); %><br /><br />
	
	</div></td>
	<td width="50%" valign="top"><div>	
	
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

	 </div></td></tr>
      </table>	 
     </div>
<%  
	String lastratedaceitemid = "";

	if( renderRequest.getPortletSession().getAttribute("lastRatedAceItemId") != null) {
		
		lastratedaceitemid = (String) renderRequest.getPortletSession().getAttribute("lastRatedAceItemId") ;
	}
	if( ! aceitem_id.toString().equalsIgnoreCase( lastratedaceitemid )) { %>
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
<%	 }  %>     
   </c:when>
   <c:otherwise>
   <div class="portlet-title">
     <H1>No AceItem selected</H1>
    </div>
   </c:otherwise>
 </c:choose>
 </div>
 </div>
