<%@include file="/html/init.jsp" %>

<%		
	if(request.getAttribute(Constants.PROJECTID)!=null) {

		String editUrl = prefs.getValue(Constants.EDITURL, "/web/guest/projects")
						 + (String) request.getAttribute(Constants.PROJECTID) ;

		Project project = null;
		
		String moderator = "";
		
		long projectId = Long.parseLong((String) request.getAttribute(Constants.PROJECTID));

		if (projectId > 0) {
			project = ProjectLocalServiceUtil.getProject(projectId);
			
			moderator = project.getModerator();
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
