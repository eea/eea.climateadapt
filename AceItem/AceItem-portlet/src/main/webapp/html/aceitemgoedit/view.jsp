<%@include file="/html/init.jsp" %>

<%		
	if(request.getAttribute(Constants.ACEITEMID)!=null) {

		String editUrl = "" ;

		long aceitemId = 0;
		
		AceItem aceitem = null;
		
		String moderator = "";
		boolean userInRole = false;
		
		String newModerator = user.getFullName() + " (" + user.getEmailAddress() + ")" ;  ;	
		
		try {
			aceitemId = Long.parseLong((String) request.getAttribute(Constants.ACEITEMID));
			
			if (aceitemId > 0) {
				aceitem = AceItemLocalServiceUtil.getAceItem(aceitemId);
			}
		}
		catch (NumberFormatException e) {
			// do nothing
		}		

		if (aceitem != null) {
			
			moderator = aceitem.getModerator();
			
			
			if (renderRequest.isUserInRole("Portal Content Reviewer") 
					|| renderRequest.isUserInRole("administrator")
					|| renderRequest.isUserInRole("Power User")) {
				
				//deprecated url
				editUrl = prefs.getValue(Constants.EDITURL,"/web/guest/aceitems1?p_p_id=aceitemportlet_WAR_AceItemportlet&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1&_aceitemportlet_WAR_AceItemportlet_jspPage=%2Fhtml%2Faceitem%2Fedit_aceitem.jsp&_aceitemportlet_WAR_AceItemportlet_redirect=%2Fweb%2Fguest%2Faceitems1&_aceitemportlet_WAR_AceItemportlet_aceItemId=") ;
                userInRole = true;
			}
			else if ( (moderator.indexOf(newModerator) > -1) && (aceitem.getControlstatus() >= ACEIndexUtil.Status_APPROVED) ) {
%>
				(Editing this item is no longer permitted for it has been approved.)
 				<BR/><BR/>			
<%			}			
			
			if (userInRole || (moderator.indexOf(newModerator) > -1) && ((aceitem.getControlstatus() == ACEIndexUtil.Status_DRAFT) || (aceitem.getControlstatus() == ACEIndexUtil.Status_SUBMITTED))) { 
				
				if(aceitem.getDatatype().equalsIgnoreCase( AceItemType.DOCUMENT.toString() )) {  
					editUrl = prefs.getValue(Constants.PUBLICATIONSHAREEDITURL,"/web/guest/share-your-info/publications-and-reports?p_p_id=shareaceitemportlet_WAR_AceItemportlet_INSTANCE_A8ua&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-2&p_p_col_count=1&_shareaceitemportlet_WAR_AceItemportlet_INSTANCE_A8ua_jspPage=%2Fhtml%2Fshareinfo%2Fadd_aceitem.jsp&_shareaceitemportlet_WAR_AceItemportlet_INSTANCE_A8ua_redirect=%2Fen%2Fshare-your-info%2Fpublications-and-reports&_shareaceitemportlet_WAR_AceItemportlet_INSTANCE_A8ua_aceItemId=") ;
				}
				else if(aceitem.getDatatype().equalsIgnoreCase( AceItemType.INFORMATIONSOURCE.toString() )){ 
					editUrl = prefs.getValue(Constants.INFOPORTALSHAREEDITURL,"/web/guest/share-your-info/information-portals?p_p_id=shareaceitemportlet_WAR_AceItemportlet_INSTANCE_K5tr&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-2&p_p_col_count=1&_shareaceitemportlet_WAR_AceItemportlet_INSTANCE_K5tr_jspPage=%2Fhtml%2Fshareinfo%2Fadd_aceitem.jsp&_shareaceitemportlet_WAR_AceItemportlet_INSTANCE_K5tr_redirect=%2Fen%2Fshare-your-info%2Finformation-portals&_shareaceitemportlet_WAR_AceItemportlet_INSTANCE_K5tr_aceItemId=") ;
				}
				else if(aceitem.getDatatype().equalsIgnoreCase( AceItemType.GUIDANCE.toString() )){ 
					editUrl = prefs.getValue(Constants.GUIDANCESHAREEDITURL,"/web/guest/share-your-info/guidance-documents?p_p_id=shareaceitemportlet_WAR_AceItemportlet_INSTANCE_J4yK&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-2&p_p_col_count=1&_shareaceitemportlet_WAR_AceItemportlet_INSTANCE_J4yK_jspPage=%2Fhtml%2Fshareinfo%2Fadd_aceitem.jsp&_shareaceitemportlet_WAR_AceItemportlet_INSTANCE_J4yK_redirect=%2Fen%2Fshare-your-info%2Fguidance-documents&_shareaceitemportlet_WAR_AceItemportlet_INSTANCE_J4yK_aceItemId=") ;
				}
				else if(aceitem.getDatatype().equalsIgnoreCase( AceItemType.TOOL.toString() )){ 
					editUrl = prefs.getValue(Constants.TOOLSHAREEDITURL,"/web/guest/share-your-info/tools?p_p_id=shareaceitemportlet_WAR_AceItemportlet_INSTANCE_gZM7&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-2&p_p_col_count=1&_shareaceitemportlet_WAR_AceItemportlet_INSTANCE_gZM7_jspPage=%2Fhtml%2Fshareinfo%2Fadd_aceitem.jsp&_shareaceitemportlet_WAR_AceItemportlet_INSTANCE_gZM7_redirect=%2Fen%2Fshare-your-info%2Ftools&_shareaceitemportlet_WAR_AceItemportlet_INSTANCE_gZM7_aceItemId=") ;
				}
				else if(aceitem.getDatatype().equalsIgnoreCase( AceItemType.ORGANISATION.toString() )){ 
					editUrl = prefs.getValue(Constants.ORGANISATIONSHAREEDITURL,"/web/guest/share-your-info/organisations?p_p_id=shareaceitemportlet_WAR_AceItemportlet_INSTANCE_vfO6&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-2&p_p_col_count=1&_shareaceitemportlet_WAR_AceItemportlet_INSTANCE_vfO6_jspPage=%2Fhtml%2Fshareinfo%2Fadd_aceitem.jsp&_shareaceitemportlet_WAR_AceItemportlet_INSTANCE_vfO6_redirect=%2Fen%2Fshare-your-info%2Forganisations&_shareaceitemportlet_WAR_AceItemportlet_INSTANCE_vfO6_aceItemId=") ;
				}
				else if (aceitem.getDatatype().equalsIgnoreCase( AceItemType.INDICATOR.toString())) {					
					editUrl = prefs.getValue(Constants.INDICATORSSHAREEDITURL,"/web/guest/share-your-info/indicators?p_p_id=shareaceitemportlet_WAR_AceItemportlet_INSTANCE_4e0wgmd0N2fB&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1&_shareaceitemportlet_WAR_AceItemportlet_INSTANCE_4e0wgmd0N2fB_jspPage=%2Fhtml%2Fshareinfo%2Fadd_aceitem.jsp&_shareaceitemportlet_WAR_AceItemportlet_INSTANCE_4e0wgmd0N2fB_redirect=%2Fen%2Fshare-your-info%2Findicators&_shareaceitemportlet_WAR_AceItemportlet_INSTANCE_4e0wgmd0N2fB_aceItemId=");
					//System.out.println("after: INDICATOR item with url: "+editUrl);
				}
				else if (aceitem.getDatatype().equalsIgnoreCase( AceItemType.MAPGRAPHDATASET.toString())) {
					editUrl = prefs.getValue(Constants.MAPGRAPHDATAEDITURL, "/web/guest/share-your-info/map-graph-data?p_p_id=shareaceitemportlet_WAR_AceItemportlet_INSTANCE_0JfX0wbAluvS&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1&_shareaceitemportlet_WAR_AceItemportlet_INSTANCE_0JfX0wbAluvS_jspPage=%2Fhtml%2Fshareinfo%2Fadd_aceitem.jsp&_shareaceitemportlet_WAR_AceItemportlet_INSTANCE_0JfX0wbAluvS_redirect=%2Fen%2Fshare-your-info%2Fmap-graph-data&_shareaceitemportlet_WAR_AceItemportlet_INSTANCE_0JfX0wbAluvS_aceItemId=");
					//System.out.println("after: MAPGRAPHDATA item with url: "+editUrl);
				}
				
				
			}
			
			editUrl += aceitemId ;
			
			System.out.println("final url: "+editUrl);
			
			if (userInRole || ((moderator.indexOf(newModerator) > -1) && ((aceitem.getControlstatus() == ACEIndexUtil.Status_DRAFT) || (aceitem.getControlstatus() == ACEIndexUtil.Status_SUBMITTED)) ) ) { 
%>		 
				<input type="button" value="Edit" onClick="document.location.href='<%= editUrl %>';">
 				<BR/><BR/>	 
<%			}
		}	
	}
%>