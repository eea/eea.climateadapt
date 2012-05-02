<%@include file="/html/init.jsp" %>

<%		
	if(request.getAttribute(Constants.ACEITEMID)!=null) {

		String editUrl = prefs.getValue(Constants.EDITURL, "/web/guest/aceitems1")
						 + (String) request.getAttribute(Constants.ACEITEMID) ;
		
		AceItem aceitem = null;
		
		String moderator = "";
		
		long aceitemId = Long.parseLong((String) request.getAttribute(Constants.ACEITEMID));

		if (aceitemId > 0) {
			aceitem = AceItemLocalServiceUtil.getAceItem(aceitemId);
			
			moderator = aceitem.getModerator();
		}
		
		String newModerator = user.getFullName() + " (" + user.getEmailAddress() + ")" ;  ;
			
		if (renderRequest.isUserInRole("Portal Content Reviewer") 
				|| renderRequest.isUserInRole("administrator")
				|| renderRequest.isUserInRole("Power User")
				|| (moderator.indexOf(newModerator) > -1) ) { 
%>		
<div style="clear: both">   
	<input type="button" value="Edit" onClick="document.location.href='<%= editUrl %>';">
</div>     
<%		
		}		
	}
%>