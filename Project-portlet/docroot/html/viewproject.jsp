<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@include file="/html/init.jsp" %>


<%
	Long project_id = 0l ;
	Project project = null;
	String url = null;
	
	if(request.getAttribute("project_id")!=null) {
		project_id = Long.parseLong( (String) request.getAttribute("project_id") ) ;
		project = ProjectLocalServiceUtil.getProject( project_id ) ;
		url = project.getWebsite();
		//if(url.startsWith("http")) {
			url = "<a href='" + url + "' target='_blank'>" + url + "</a>" ;
		//} 
	}
	
%>

 <c:choose>
   <c:when test="${project_id>0}">
	 <H1><% out.print( project.getAcronym() ); %>: <% out.print( project.getTitle() ); %></H1>
	 <b>Lead</b><br />
	 <% out.print( project.getLead() ); %><br /><br />
	 <b>Partners</b><br />
	 <% out.print( project.getPartners() ); %><br /><br />
	 <b>Abstract</b><br />
	 <% out.print( project.getAbstracts() ); %><br /><br />
	 <b>Element</b><br />
	 <% out.print( project.getElement() ); %><br /><br />
	 <b>Funding</b><br />
	 <% out.print( project.getFunding() ); %><br /><br />
	 <b>Keywords</b><br />
	 <% out.print( project.getKeywords()); %><br /><br />
	 <b>Spatial Level</b><br />
	 <% out.print( project.getSpatiallevel() ); %><br /><br />
	 <b>Sector</b><br />
	 <% out.print( project.getSectors() ); %><br /><br />
	 <b>Duration</b><br />
	 <% out.print( project.getDuration() ); %><br /><br />
	 <b>Website</b><br />
	 <% out.print(  url ); %><br /><br />

   </c:when>
   <c:otherwise>
     <H1>No Project Identification available</H1>
   </c:otherwise>
 </c:choose>