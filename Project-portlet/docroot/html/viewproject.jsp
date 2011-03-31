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
	 <b>Elements</b><br />
	 <% 
	 	String e = project.getElement() ; 
	 		
		e = e.replace("OBSERVATIONS","Observations and Scenarios");
		e = e.replace("VULNERABILITY","Vulnerability Assessment");
		e = e.replace("MEASUREACTION","Adaptation Measures and Adaptation Actions");
		e = e.replace("PLANSTRATEGY","National Adaptation Plans and Strategies");
		e = e.replace("EU_POLICY","EU Sector Policy");

		out.print( e.replace(";","<br />") ); %><br /><br />
	 <b>Funding</b><br />
	 <% out.print( project.getFunding() ); %><br /><br />
	 <b>Keywords</b><br />
	 <% out.print( project.getKeywords()); %><br /><br />
	 <b>Spatial Level</b><br />
	 <% out.print( project.getSpatiallevel() ); %><br /><br />
	 <b>Sectors</b><br />
	 <% 
		String s = project.getSectors();
		
		s = s.replace("AGRICULTURE","Agriculture and Forest");		
		s = s.replace("BIODIVERSITY","Biodiversity");		
		s = s.replace("COASTAL","Coastal areas");		
		s = s.replace("DISASTERRISKREDUCTION","Disaster Risk Reduction");		
		s = s.replace("FINANCIAL","Financial");		
		s = s.replace("HEALTH","Health");		
		s = s.replace("INFRASTRUCTURE","Infrastructure");		
		s = s.replace("MARINE","Marine and Fisheries");		
		s = s.replace("WATERMANAGEMENT","Water management");	
		
		out.print( s.replace(";","<br />") ); %><br /><br />	 
	 <b>Duration</b><br />
	 <% out.print( project.getDuration() ); %><br /><br />
	 <b>Website</b><br />
	 <% out.print(  url ); %><br /><br />

   </c:when>
   <c:otherwise>
     <H1>No Project Identification available</H1>
   </c:otherwise>
 </c:choose>