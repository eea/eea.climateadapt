<%@include file="/html/init.jsp" %>

<%		
	if(request.getAttribute(Constants.ACEITEMID)!=null) {

		String editUrl = prefs.getValue(Constants.EDITURL, "/web/guest/aceitems1")
						 + (String) request.getAttribute(Constants.ACEITEMID) ;
%>
	<input type="button" value="Edit" onClick="document.location.href='<%= editUrl %>';">
    <br />    <br />
<%			
	}
%>