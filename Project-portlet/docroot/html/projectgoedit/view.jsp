<%@include file="/html/init.jsp" %>

<%		
	if(request.getAttribute(Constants.PROJECTID)!=null) {
		
		String editUrl = "";
		
		long projectId = 0;
		
		Project project = null;
		
		String moderator = "";
		
		String newModerator = user.getFullName() + " (" + user.getEmailAddress() + ")" ; 

		try {
			projectId = Long.parseLong((String) request.getAttribute(Constants.PROJECTID));
			
			if (projectId > 0) {
				project = ProjectLocalServiceUtil.getProject(projectId);
			}
		}
		catch (NumberFormatException e) {
			// do nothing
		}
		
		if (project != null) {
			project = ProjectLocalServiceUtil.getProject(projectId);
			
			moderator = project.getModerator();


			if (renderRequest.isUserInRole("Portal Content Reviewer") 
					|| renderRequest.isUserInRole("administrator")
					|| renderRequest.isUserInRole("Power User")) {
				
				editUrl = prefs.getValue(Constants.EDITURL,"/web/guest/projects?p_p_id=projectportlet_WAR_Projectportlet&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1&_projectportlet_WAR_Projectportlet_jspPage=%2Fhtml%2Fproject%2Fedit_project.jsp&_projectportlet_WAR_Projectportlet_redirect=%2Fweb%2Fguest%2Fprojects&_projectportlet_WAR_Projectportlet_projectId=") ;
			}
			else if (moderator.indexOf(newModerator) > -1 ) { 
				
				editUrl = prefs.getValue(Constants.SHAREINFOEDITURL,"/web/guest/share-your-info/research-and-knowledge-projects?p_p_id=shareprojectportlet_WAR_Projectportlet&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-2&p_p_col_count=1&_shareprojectportlet_WAR_Projectportlet_jspPage=%2Fhtml%2Fshareinfo%2Fadd_project.jsp&_shareprojectportlet_WAR_Projectportlet_redirect=%2Fen%2Fshare-your-info%2Fresearch-and-knowledge-projects&_shareprojectportlet_WAR_Projectportlet_projectId=") ;	
			}
			
			editUrl += "" + projectId ;
				
			if (renderRequest.isUserInRole("Portal Content Reviewer") 
					|| renderRequest.isUserInRole("administrator")
					|| renderRequest.isUserInRole("Power User")
					|| (moderator.indexOf(newModerator) > -1) ) { 
%>
			<div style="clear: both">   		
				<input type="button" value="Edit" onClick="document.location.href='<%= editUrl %>';">
			</div>    
<%			}
		}
	}
%>
