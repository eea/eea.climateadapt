<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@include file="/html/init.jsp" %>


<%
	Long project_id = 0l ;
	Project project = null;
	String[] urls = null;
	String url = null;
	String websitelabel = "Website";
	
	if(request.getAttribute("project_id")!=null) {
		project_id = Long.parseLong( (String) request.getAttribute("project_id") ) ;
		project = ProjectLocalServiceUtil.getProject( project_id ) ;
		
		url = project.getWebsite();
		
		if(url != null && url.trim().length() > 0) {
			urls = url.split(";");
			
			url = "" ;
			for(int i=0; i<urls.length; i++) {
				
				if(i>0) { websitelabel += "s" ;}
				
				if(urls[i].trim().length() > 0) {
					if ( ! urls[i].startsWith("http://")  && ! urls[i].startsWith("/") ) {
						
						urls[i] = "http://" + urls[i];
					}
					
					url += "<a href='" + urls[i] + "' target='_blank'>" + urls[i] + "</a>&nbsp;&nbsp;&nbsp;&nbsp;" ;
				}
			} 
		}
	}
	
%>

 <c:choose>
   <c:when test="${project_id>0}">
	 <H1><% out.print( project.getAcronym() ); %>: <% out.print( project.getTitle() ); %></H1>
	 <b>Abstract</b><br />
	 <% out.print( project.getAbstracts() ); %><br /><br />
	<div style="float: left; margin-right: 15px;">
 	 <b>Lead</b><br />
	 <% out.print( project.getLead() ); %><br /><br />
	 <b>Partners</b><br />
	 <% out.print( project.getPartners() ); %><br /><br />
	 <b>Sectors</b><br />
	 <c:set var="aceItemSectors" value="<%= project.getSectors() %>" />
     <c:forEach var="adaptationSector" items="<%= nl.wur.alterra.cgi.ace.model.impl.AceItemSector.values() %>" >
		<c:if test="${fn:indexOf(aceItemSectors, adaptationSector)>=0}">
			<liferay-ui:message key="acesearch-sectors-lbl-${adaptationSector}" /><br />
		</c:if>	
	 </c:forEach>
	 <br />	 
	 <b>Elements</b><br />
	 <c:set var="aceItemElements" value="<%= project.getElement() %>" />
     <c:forEach var="adaptationElement" items="<%= nl.wur.alterra.cgi.ace.model.impl.AceItemElement.values() %>" >
		<c:if test="${fn:indexOf(aceItemElements, adaptationElement)>=0}">
			<liferay-ui:message key="acesearch-elements-lbl-${adaptationElement}" /><br />
		</c:if>	
	 </c:forEach>
	 <br />

	 </div>
	<div style="float: left;">		 
	 <b>Funding</b><br />
	 <% out.print( project.getFunding() ); %><br /><br />
	 <b>Keywords</b><br />
	 <% out.print( project.getKeywords()); %><br /><br />
	 <b>Spatial Level</b><br />
	 <% out.print( project.getSpatiallevel() ); %><br /><br />
	 	 
	 <b>Duration</b><br />
	 <% out.print( project.getDuration() ); %><br /><br />
	 <% if (url != null && url.trim().length() > 0)  {%>		
		 <b><%= websitelabel %></b><br />
		 <%= url %><br /><br />
	 <% } %>
	</div>
   </c:when>
   <c:otherwise>
     <H1>No Project selected</H1>
   </c:otherwise>
 </c:choose>