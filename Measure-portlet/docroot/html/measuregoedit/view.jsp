<%@include file="/html/init.jsp" %>

<%		
	if(request.getAttribute(Constants.MEASUREID)!=null) {

		String editUrl = prefs.getValue(Constants.EDITURL, "/web/guest/measures")
						 + (String) request.getAttribute(Constants.MEASUREID) ;
%>
	<input type="button" value="Edit" onClick="document.location.href='<%= editUrl %>';">
    <br />    <br />
<%			
	}
%>