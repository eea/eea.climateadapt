<%--
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
--%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@include file="/html/init.jsp" %>

<portlet:actionURL name="setAceItemGoEditPref" var="setAceItemGoEditPrefUrl" />

<aui:form action="<%= setAceItemGoEditPrefUrl %>" method="POST" name="fm" >

	<b>Normal edit url (long stuff ending with 'aceItemId=')</b><br />
	<input name='<%= Constants.EDITURL %>' type="text" size="180" 
	value='<%= prefs.getValue(Constants.EDITURL,"/web/guest/aceitems1?p_p_id=aceitemportlet_WAR_AceItemportlet&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1&_aceitemportlet_WAR_AceItemportlet_jspPage=%2Fhtml%2Faceitem%2Fedit_aceitem.jsp&_aceitemportlet_WAR_AceItemportlet_redirect=%2Fweb%2Fguest%2Faceitems1&_aceitemportlet_WAR_AceItemportlet_aceItemId=") %>' />
	<br /><br />

	<b>Share publication and report edit url (/web/guest/share-your-info/publications-and-reports?...  ending with 'aceItemId=')</b><br />
	<input name='<%= Constants.PUBLICATIONSHAREEDITURL %>' type="text" size="180" 
	value='<%= prefs.getValue(Constants.PUBLICATIONSHAREEDITURL,"/web/guest/share-your-info/publications-and-reports?p_p_id=shareaceitemportlet_WAR_AceItemportlet_INSTANCE_A8ua&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-2&p_p_col_count=1&_shareaceitemportlet_WAR_AceItemportlet_INSTANCE_A8ua_jspPage=%2Fhtml%2Fshareinfo%2Fadd_aceitem.jsp&_shareaceitemportlet_WAR_AceItemportlet_INSTANCE_A8ua_redirect=%2Fen%2Fshare-your-info%2Fpublications-and-reports&_shareaceitemportlet_WAR_AceItemportlet_INSTANCE_A8ua_aceItemId=") %>' />
	<br /><br />

	<b>Share information portal edit url (/web/guest/share-your-info/tools?...  ending with 'aceItemId=')</b><br />
	<input name='<%= Constants.INFOPORTALSHAREEDITURL %>' type="text" size="180" 
	value='<%= prefs.getValue(Constants.INFOPORTALSHAREEDITURL,"/web/guest/share-your-info/information-portals?p_p_id=shareaceitemportlet_WAR_AceItemportlet_INSTANCE_K5tr&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-2&p_p_col_count=1&_shareaceitemportlet_WAR_AceItemportlet_INSTANCE_K5tr_jspPage=%2Fhtml%2Fshareinfo%2Fadd_aceitem.jsp&_shareaceitemportlet_WAR_AceItemportlet_INSTANCE_K5tr_redirect=%2Fen%2Fshare-your-info%2Finformation-portals&_shareaceitemportlet_WAR_AceItemportlet_INSTANCE_K5tr_aceItemId=") %>' />
	<br /><br />

	<b>Share guidance document edit url (/web/guest/share-your-info/guidance-documents?...  ending with 'aceItemId=')</b><br />
	<input name='<%= Constants.GUIDANCESHAREEDITURL %>' type="text" size="180" 
	value='<%= prefs.getValue(Constants.GUIDANCESHAREEDITURL,"/web/guest/share-your-info/guidance-documents?p_p_id=shareaceitemportlet_WAR_AceItemportlet_INSTANCE_J4yK&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-2&p_p_col_count=1&_shareaceitemportlet_WAR_AceItemportlet_INSTANCE_J4yK_jspPage=%2Fhtml%2Fshareinfo%2Fadd_aceitem.jsp&_shareaceitemportlet_WAR_AceItemportlet_INSTANCE_J4yK_redirect=%2Fen%2Fshare-your-info%2Fguidance-documents&_shareaceitemportlet_WAR_AceItemportlet_INSTANCE_J4yK_aceItemId=") %>' />
	<br /><br />

	<b>Share tool edit url (/web/guest/share-your-info/tools?...  ending with 'aceItemId=')</b><br />
	<input name='<%= Constants.TOOLSHAREEDITURL %>' type="text" size="180" 
	value='<%= prefs.getValue(Constants.TOOLSHAREEDITURL,"/web/guest/share-your-info/tools?p_p_id=shareaceitemportlet_WAR_AceItemportlet_INSTANCE_gZM7&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-2&p_p_col_count=1&_shareaceitemportlet_WAR_AceItemportlet_INSTANCE_gZM7_jspPage=%2Fhtml%2Fshareinfo%2Fadd_aceitem.jsp&_shareaceitemportlet_WAR_AceItemportlet_INSTANCE_gZM7_redirect=%2Fen%2Fshare-your-info%2Ftools&_shareaceitemportlet_WAR_AceItemportlet_INSTANCE_gZM7_aceItemId=") %>' />
	<br /><br />

	<b>Share organisation edit url (/web/guest/share-your-info/tools?...  ending with 'aceItemId=')</b><br />
	<input name='<%= Constants.ORGANISATIONSHAREEDITURL %>' type="text" size="180" 
	value='<%= prefs.getValue(Constants.ORGANISATIONSHAREEDITURL,"/web/guest/share-your-info/organisations?p_p_id=shareaceitemportlet_WAR_AceItemportlet_INSTANCE_vfO6&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-2&p_p_col_count=1&_shareaceitemportlet_WAR_AceItemportlet_INSTANCE_vfO6_jspPage=%2Fhtml%2Fshareinfo%2Fadd_aceitem.jsp&_shareaceitemportlet_WAR_AceItemportlet_INSTANCE_vfO6_redirect=%2Fen%2Fshare-your-info%2Forganisations&_shareaceitemportlet_WAR_AceItemportlet_INSTANCE_vfO6_aceItemId=") %>' />
	<br /><br />
	
	<b>Share indication edit url (/web/guest/share-your-info/indicators?...  ending with 'aceItemId=')</b><br />
 	<input name='<%= Constants.INDICATORSSHAREEDITURL %>' type="text" size="180"
 	value='<%= prefs.getValue(Constants.INDICATORSSHAREEDITURL,"/web/guest/share-your-info/indicators?p_p_id=shareaceitemportlet_WAR_AceItemportlet_INSTANCE_4e0wgmd0N2fB&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1&_shareaceitemportlet_WAR_AceItemportlet_INSTANCE_4e0wgmd0N2fB_jspPage=%2Fhtml%2Fshareinfo%2Fadd_aceitem.jsp&_shareaceitemportlet_WAR_AceItemportlet_INSTANCE_4e0wgmd0N2fB_redirect=%2Fen%2Fshare-your-info%2Findicators&_shareaceitemportlet_WAR_AceItemportlet_INSTANCE_4e0wgmd0N2fB_aceItemId=") %>' />
	<br /><br />
	
	<b>Share map graph data edit url (/web/guest/share-your-info/map-graph-data?...  ending with 'aceItemId=')</b><br />
	<input name='<%= Constants.MAPGRAPHDATAEDITURL %>' type="text" size="180" 
	value='<%= prefs.getValue(Constants.MAPGRAPHDATAEDITURL,"/web/guest/share-your-info/map-graph-data?p_p_id=shareaceitemportlet_WAR_AceItemportlet_INSTANCE_0JfX0wbAluvS&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1&_shareaceitemportlet_WAR_AceItemportlet_INSTANCE_0JfX0wbAluvS_jspPage=%2Fhtml%2Fshareinfo%2Fadd_aceitem.jsp&_shareaceitemportlet_WAR_AceItemportlet_INSTANCE_0JfX0wbAluvS_redirect=%2Fen%2Fshare-your-info%2Findicators&_shareaceitemportlet_WAR_AceItemportlet_INSTANCE_0JfX0wbAluvS_aceItemId=") %>' />
	<br /><br />
	
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>
