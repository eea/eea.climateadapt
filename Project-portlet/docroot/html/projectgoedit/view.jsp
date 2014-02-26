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
			
			moderator = project.getModerator();

			if (renderRequest.isUserInRole("Portal Content Reviewer") 
					|| renderRequest.isUserInRole("administrator")
					|| renderRequest.isUserInRole("Power User")) {
				
				editUrl = prefs.getValue(Constants.SHAREINFOEDITURL,"/web/guest/share-your-info/research-and-knowledge-projects?p_p_id=shareprojectportlet_WAR_Projectportlet&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-2&p_p_col_count=1&_shareprojectportlet_WAR_Projectportlet_jspPage=%2Fhtml%2Fshareinfo%2Fadd_projectRevised.jsp&_shareprojectportlet_WAR_Projectportlet_redirect=%2Fen%2Fshare-your-info%2Fresearch-and-knowledge-projects&_shareprojectportlet_WAR_Projectportlet_projectId=") ;
			}
			else if ( (moderator.indexOf(newModerator) > -1) && (project.getControlstatus() >= ACEIndexUtil.Status_APPROVED) ) {
%>  
				(Editing this item is no longer permitted for it has been approved.)
 				<BR/><BR/>							
<%			}
			else if ( (moderator.indexOf(newModerator) > -1) && ((project.getControlstatus() == ACEIndexUtil.Status_DRAFT) || (project.getControlstatus() == ACEIndexUtil.Status_SUBMITTED))) { 
				
				editUrl = prefs.getValue(Constants.SHAREINFOEDITURL,"/web/guest/share-your-info/research-and-knowledge-projects?p_p_id=shareprojectportlet_WAR_Projectportlet&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-2&p_p_col_count=1&_shareprojectportlet_WAR_Projectportlet_jspPage=%2Fhtml%2Fshareinfo%2Fadd_projectRevised.jsp&_shareprojectportlet_WAR_Projectportlet_redirect=%2Fen%2Fshare-your-info%2Fresearch-and-knowledge-projects&_shareprojectportlet_WAR_Projectportlet_projectId=") ;	
			}
			
			editUrl += "" + projectId ;
				
			if (renderRequest.isUserInRole("Portal Content Reviewer") 
					|| renderRequest.isUserInRole("administrator")
					|| renderRequest.isUserInRole("Power User")
					|| ( (moderator.indexOf(newModerator) > -1) && ((project.getControlstatus() == ACEIndexUtil.Status_DRAFT) || (project.getControlstatus() == ACEIndexUtil.Status_SUBMITTED)) ) ) { 
%>
 				<input type="button" value="Edit" onClick="document.location.href='<%= editUrl %>';">
 				<BR/><BR/>
<%			}
		}
	}
%>
