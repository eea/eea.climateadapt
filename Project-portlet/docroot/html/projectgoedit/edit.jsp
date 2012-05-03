<%
/**
* Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
*
* This library is free software; you can redistribute it and/or modify it under
* the terms of the GNU Lesser General Public License as published by the Free
* Software Foundation; either version 2.1 of the License, or (at your option)
* any later version.
*
* This library is distributed in the hope that it will be useful, but WITHOUT
* ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
* FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
* details.
*/
%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@include file="/html/init.jsp" %>

<portlet:actionURL name="setProjectGoEditPref" var="setProjectGoEditPrefUrl" />

<aui:form action="<%= setProjectGoEditPrefUrl %>" method="POST" name="fm" >

	<b>Normal edit url (long stuff ending with 'projectId=')</b><br />
	<input name='<%= Constants.EDITURL %>' type="text" size="180" 
	value='<%= prefs.getValue(Constants.EDITURL,"/web/guest/projects?p_p_id=projectportlet_WAR_Projectportlet&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1&_projectportlet_WAR_Projectportlet_jspPage=%2Fhtml%2Fproject%2Fedit_project.jsp&_projectportlet_WAR_Projectportlet_redirect=%2Fweb%2Fguest%2Fprojects&_projectportlet_WAR_Projectportlet_projectId=") %>' />
	<br /><br />

	<b>EIONET edit url (/web/guest/share-your-info/research-and-knowledge-projects?... ending with 'projectId=')</b><br />
	<input name='<%= Constants.SHAREINFOEDITURL %>' type="text" size="180" 
	value='<%= prefs.getValue(Constants.SHAREINFOEDITURL,"/web/guest/share-your-info/research-and-knowledge-projects?p_p_id=shareprojectportlet_WAR_Projectportlet&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-2&p_p_col_count=1&_shareprojectportlet_WAR_Projectportlet_jspPage=%2Fhtml%2Fshareinfo%2Fadd_project.jsp&_shareprojectportlet_WAR_Projectportlet_redirect=%2Fen%2Fshare-your-info%2Fresearch-and-knowledge-projects&_shareprojectportlet_WAR_Projectportlet_projectId=") %>' />
	<br /><br />

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>