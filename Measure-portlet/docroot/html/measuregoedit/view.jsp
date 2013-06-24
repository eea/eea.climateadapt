<%@include file="/html/init.jsp" %>

<%		
	if(request.getAttribute(Constants.MEASUREID)!=null) {

		String editUrl = ""; 

		long measureId = 0;	
		
		Measure measure = null;
		
		String moderator = "";
		
		String newModerator = user.getFullName() + " (" + user.getEmailAddress() + ")" ; 
		
		try {
			measureId = Long.parseLong((String) request.getAttribute(Constants.MEASUREID));		
			
			if (measureId > 0) {
				measure = MeasureLocalServiceUtil.getMeasure(measureId);
			}
		}
		catch (NumberFormatException e) {
			// do nothing
		}		
		
		if (measure != null) {
			
			moderator = measure.getModerator();

			if (renderRequest.isUserInRole("Portal Content Reviewer") 
					|| renderRequest.isUserInRole("administrator")
					|| renderRequest.isUserInRole("Power User")) {
				
				//editUrl = prefs.getValue(Constants.EDITURL,"/web/guest/measures?p_p_id=measureportlet_WAR_Measureportlet&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1&_measureportlet_WAR_Measureportlet_jspPage=%2Fhtml%2Fmeasure%2Fedit_measure.jsp&_measureportlet_WAR_Measureportlet_redirect=%2Fweb%2Fguest%2Fmeasures&_measureportlet_WAR_Measureportlet_measureId=");
				
				if(measure.getMao_type().equalsIgnoreCase("A")) { // "A" = Action, ofwel case Study 
						editUrl = prefs.getValue(Constants.CASESTUDYSHAREEDITURL,"/web/guest/share-your-info/case-studies?p_p_id=sharemeasureportlet_WAR_Measureportlet&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-2&p_p_col_count=1&_sharemeasureportlet_WAR_Measureportlet_jspPage=%2Fhtml%2Fshareinfo%2Fadd_measureRevised.jsp&_sharemeasureportlet_WAR_Measureportlet_redirect=%2Fen%2Fshare-your-info%2Fcase-studies&_sharemeasureportlet_WAR_Measureportlet_measureId=") ;
						                                                          
				}
				else { // "M" = Measure, ofwel adaptation option
						editUrl = prefs.getValue(Constants.ADAPATIONOPTIONSHAREEDITURL,"/web/guest/share-your-info/adaptation-options?p_p_id=sharemeasureportlet_WAR_Measureportlet&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-2&p_p_col_count=1&_sharemeasureportlet_WAR_Measureportlet_jspPage=%2Fhtml%2Fshareinfo%2Fadd_measureRevised.jsp&_sharemeasureportlet_WAR_Measureportlet_redirect=%2Fen%2Fshare-your-info%2Fadaptation-options&_sharemeasureportlet_WAR_Measureportlet_measureId=");
				}
				
			}
			else if ( (moderator.indexOf(newModerator) > -1) && (measure.getControlstatus() >= ACEIndexUtil.Status_APPROVED) ) {
%>   
				(Editing this item is no longer permitted for it has been approved.)			
			 	<BR/><BR/>   				
<%			}
			else if ( (moderator.indexOf(newModerator) > -1) && ((measure.getControlstatus() == ACEIndexUtil.Status_DRAFT) || (measure.getControlstatus() == ACEIndexUtil.Status_SUBMITTED))) {
				
				if(measure.getMao_type().equalsIgnoreCase("A")) { // "A" = Action, ofwel case Study 
					editUrl = prefs.getValue(Constants.CASESTUDYSHAREEDITURL,"/web/guest/share-your-info/case-studies?p_p_id=sharemeasureportlet_WAR_Measureportlet&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-2&p_p_col_count=1&_sharemeasureportlet_WAR_Measureportlet_jspPage=%2Fhtml%2Fshareinfo%2Fadd_measureRevised.jsp&_sharemeasureportlet_WAR_Measureportlet_redirect=%2Fen%2Fshare-your-info%2Fcase-studies&_sharemeasureportlet_WAR_Measureportlet_measureId=") ;
				}
				else { // "M" = Measure, ofwel adaptation option
					editUrl = prefs.getValue(Constants.ADAPATIONOPTIONSHAREEDITURL,"/web/guest/share-your-info/adaptation-options?p_p_id=sharemeasureportlet_WAR_Measureportlet&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-2&p_p_col_count=1&_sharemeasureportlet_WAR_Measureportlet_jspPage=%2Fhtml%2Fshareinfo%2Fadd_measureRevised.jsp&_sharemeasureportlet_WAR_Measureportlet_redirect=%2Fen%2Fshare-your-info%2Fadaptation-options&_sharemeasureportlet_WAR_Measureportlet_measureId=");
				}
				
			}
			
			editUrl += "" + measureId ;
			
			if (renderRequest.isUserInRole("Portal Content Reviewer") 
					|| renderRequest.isUserInRole("administrator")
					|| renderRequest.isUserInRole("Power User")
					|| ( (moderator.indexOf(newModerator) > -1) && ((measure.getControlstatus() == ACEIndexUtil.Status_DRAFT) || (measure.getControlstatus() == ACEIndexUtil.Status_SUBMITTED)) ) ) {
%>
 				<input type="button" value="Edit" onClick="document.location.href='<%= editUrl %>';">
 				<BR/><BR/>  	
<%			}
		}	
	}
%>