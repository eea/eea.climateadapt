<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@include file="/html/init.jsp" %>


<%
	Long aceitem_id = 0l ;
	AceItem aceitem = null;
	String url = null;
	String language = null;
	
	if(request.getAttribute("aceitem_id")!=null) {
		aceitem_id = Long.parseLong( (String) request.getAttribute("aceitem_id") ) ;
		aceitem = AceItemLocalServiceUtil.getAceItem( aceitem_id ) ;
		
		url = "<a href='" + aceitem.getStoredAt() + "' target='_blank'>" + aceitem.getStoredAt() + "</a>" ;
		
		language = ( aceitem.getLanguage() == null ? "" : aceitem.getLanguage() );
		
		if(language.equalsIgnoreCase("de_DE")) {
			
			url = url + "&nbsp;&nbsp;(in german)&nbsp;&nbsp;&nbsp;<a href='http://babelfish.yahoo.com/translate_url?doit=done&tt=url&intl=1&fr=bf-home&lp=de_en&btnTrUrl=Translate&&trurl=" + aceitem.getStoredAt() + "' target='_blank'>(machine translate to english)</a>" ;
			
		} 
		else if(language.equalsIgnoreCase("nl_NL")) {
			
			url = url + "&nbsp;&nbsp;(in dutch)&nbsp;&nbsp;&nbsp;<a href='http://babelfish.yahoo.com/translate_url?doit=done&tt=url&intl=1&fr=bf-home&lp=nl_en&btnTrUrl=Translate&&trurl=" + aceitem.getStoredAt() + "' target='_blank'>(machine translate to english)</a>" ;
			
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
	 <b>Keywords</b><br />
	 <% out.print( aceitem.getKeyword()); %><br /><br />
     <br /><br />
     
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
	 
	 <b>Website</b><br />
	 <% out.print(  url ); %><br /><br />

	 <b>Resolution</b><br />
	 <% out.print( aceitem.getTargetresolution()); %><br /><br />

	 <b>Spatial reference</b><br />
	 <% out.print( aceitem.getSpatialLayer() + " " + aceitem.getSpatialValues()); %><br /><br />
     </div>
   </c:when>
   <c:otherwise>
   <div class="portlet-title">
     <H1>No AceItem selected</H1>
    </div>
   </c:otherwise>
 </c:choose>
 </div>
 </div>
