<%@include file="/html/init.jsp" %>

<%		
	if(request.getAttribute(Constants.PROJECTID)!=null) {

		String editUrl = prefs.getValue(Constants.EDITURL, "/web/guest/projects")
						 + (String) request.getAttribute(Constants.PROJECTID) ;
%>
	<input type="button" value="Edit" onClick="document.location.href='<%= editUrl %>';">
    <br />    <br />
<%			
	}
%>
