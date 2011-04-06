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

 <c:choose>
   <c:when test="${aceitem_id>0}">
	 <H1><% out.print( aceitem.getName() ); %></H1>
	 <b>Description</b><br />
	 <% out.print( aceitem.getDescription() ); %><br /><br />
	 <b>Keywords</b><br />
	 <% out.print( aceitem.getKeyword()); %><br /><br />
	 <b>Elements</b><br />
	 <% 
	 	String e = aceitem.getElements_() ; 
	 		
		e = e.replace("OBSERVATIONS","Observations and Scenarios");
		e = e.replace("VULNERABILITY","Vulnerability Assessment");
		e = e.replace("MEASUREACTION","Adaptation Measures and Adaptation Actions");
		e = e.replace("PLANSTRATEGY","National Adaptation Plans and Strategies");
		e = e.replace("EU_POLICY","EU Sector Policy");

		out.print( e.replace(";","<br />") ); %><br /><br />
	 <b>Sectors</b><br />
	 <% 
		String s = aceitem.getSectors_();
		
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
	 <b>Climate impacts</b><br />
	 <% 
	    String c = aceitem.getClimateimpacts_();
		
		c = c.replace("FLOODING","Flooding");		
		c = c.replace("DROUGHT","Drought");		
		c = c.replace("STORM","Strorm");		
		c = c.replace("ICEANDSNOW","Ice and Snow");		
		
		out.print( c.replace(";","<br />") ); %><br /><br />
	 <b>Website</b><br />
	 <% out.print(  url ); %><br /><br />

	 <b>Resolution</b><br />
	 <% out.print( aceitem.getTargetresolution()); %><br /><br />

	 <b>Spatial reference</b><br />
	 <% out.print( aceitem.getSpatialLayer() + " " + aceitem.getSpatialValues()); %><br /><br />

   </c:when>
   <c:otherwise>
     <H1>No AceItem selected</H1>
   </c:otherwise>
 </c:choose>