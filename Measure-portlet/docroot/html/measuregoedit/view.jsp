<%@include file="/html/init.jsp" %>

<%		
	if(request.getAttribute(Constants.MEASUREID)!=null) {

		String editUrl = prefs.getValue(Constants.EDITURL, "/web/guest/measures")
						 + (String) request.getAttribute(Constants.MEASUREID) ;		
		
		Measure measure = null;
							
		String moderator = "";
		
		long measureId = Long.parseLong((String) request.getAttribute(Constants.MEASUREID));

		if (measureId > 0) {
			measure = MeasureLocalServiceUtil.getMeasure(measureId);
			
			moderator = measure.getModerator();
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
<%		}	
	}
%>