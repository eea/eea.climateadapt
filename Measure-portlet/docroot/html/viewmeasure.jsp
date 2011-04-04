<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@include file="/html/init.jsp" %>


<%
	Long measure_id = 0l ;
	Measure measure = null;
	String url = null;
	String type = "Measure";
	
	if(request.getAttribute("measure_id")!=null) {
		measure_id = Long.parseLong( (String) request.getAttribute("measure_id") ) ;
		measure = MeasureLocalServiceUtil.getMeasure( measure_id ) ;
		url = measure.getWebsite();
		if(url.trim().length() > 0) {
			if ( !url.startsWith("http://")) {
				
				url = "http://" + url;
			}
			
			url = "<a href='" + url + "' target='_blank'>" + url + "</a>" ;
		} 
		
		if( measure.getMao_type().equalsIgnoreCase("A")) {
			type = "Action" ;
		}
	}
	
%>

 <c:choose>
   <c:when test="${measure_id>0}">
	 <H1><% out.print( measure.getName() ); %>( <%= type %> )</H1>
	 <b>Description</b><br />
	 <% out.print( measure.getDescription() ); %><br /><br />
	 <b>Contact</b><br />
	 <% out.print( measure.getContact() ); %><br /><br />
	 <b>Elements</b><br />
	 <% 
	 	String e = measure.getElements_() ; 

		e = e.replace("A","M");
		e = e.replace("M","Adaptation Measures and Adaptation Actions");
		e = e.replace("O","Observations and Scenarios");
		e = e.replace("V","Vulnerability Assessment");
		e = e.replace("P","National Adaptation Plans and Strategies");
		e = e.replace("E","EU Sector Policy");
	 		
		//e = e.replace("OBSERVATIONS","Observations and Scenarios");
		//e = e.replace("VULNERABILITY","Vulnerability Assessment");
		//e = e.replace("MEASUREACTION","Adaptation Measures and Adaptation Actions");
		//e = e.replace("PLANSTRATEGY","National Adaptation Plans and Strategies");
		//e = e.replace("EU_POLICY","EU Sector Policy");

		out.print( e.replace(";","<br />") ); %><br /><br />
	 <b>Sectors</b><br />
	 <% 
		String s = measure.getSectors_();
		
		s = s.replace("F","Financial");
		s = s.replace("A","Agriculture and Forest");		
		s = s.replace("B","Biodiversity");		
		s = s.replace("C","Coastal areas");		
		s = s.replace("D","Disaster Risk Reduction");		
		s = s.replace("H","Health");		
		s = s.replace("I","Infrastructure");		
		s = s.replace("M","Marine and Fisheries");		
		s = s.replace("W","Water management");
		
		//s = s.replace("AGRICULTURE","Agriculture and Forest");		
		//s = s.replace("BIODIVERSITY","Biodiversity");		
		//s = s.replace("COASTAL","Coastal areas");		
		//s = s.replace("DISASTERRISKREDUCTION","Disaster Risk Reduction");		
		//s = s.replace("FINANCIAL","Financial");		
		//s = s.replace("HEALTH","Health");		
		//s = s.replace("INFRASTRUCTURE","Infrastructure");		
		//s = s.replace("MARINE","Marine and Fisheries");		
		//s = s.replace("WATERMANAGEMENT","Water management");	
		
		out.print( s.replace(";","<br />") ); %><br /><br />
	 	<b>Keywords</b><br />
	 <% out.print( measure.getKeywords()); %><br /><br />
		<% if (url != null && url.trim().length() > 0)  {%>		
			 <b>Website</b><br />
			 <%= url %><br /><br />
		<% } %>
   </c:when>
   <c:otherwise>
     <H1>No Measure Identification available</H1>
   </c:otherwise>
 </c:choose>
