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

<portlet:actionURL name="setMeasureGoEditPref" var="setMeasureGoEditPrefUrl" />

<aui:form action="<%= setMeasureGoEditPrefUrl %>" method="POST" name="fm" >

	<b>Normal edit url (long stuff ending with 'measureId=')</b><br />
	<input name='<%= Constants.EDITURL %>' type="text" size="180" 
	value='<%= prefs.getValue(Constants.EDITURL,"/web/guest/measures?p_p_id=measureportlet_WAR_Measureportlet&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1&_measureportlet_WAR_Measureportlet_jspPage=%2Fhtml%2Fmeasure%2Fedit_measure.jsp&_measureportlet_WAR_Measureportlet_redirect=%2Fweb%2Fguest%2Fmeasures&_measureportlet_WAR_Measureportlet_measureId=") %>' />
	<br /><br />
	
	<b>Share adapatation option edit url (/web/guest/share-your-info/adaptation-options?... ending with 'measureId=')</b><br />
	<input name='<%= Constants.ADAPATIONOPTIONSHAREEDITURL %>' type="text" size="180" 
	value='<%= prefs.getValue(Constants.ADAPATIONOPTIONSHAREEDITURL,"/web/guest/share-your-info/adaptation-options?p_p_id=sharemeasureportlet_WAR_Measureportlet&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-2&p_p_col_count=1&_sharemeasureportlet_WAR_Measureportlet_jspPage=%2Fhtml%2Fshareinfo%2Fadd_measure.jsp&_sharemeasureportlet_WAR_Measureportlet_redirect=%2Fen%2Fshare-your-info%2Fadaptation-options&_sharemeasureportlet_WAR_Measureportlet_measureId=") %>' />
	<br /><br />
	
	<b>Share case study edit url (/web/guest/share-your-info/case-studies?... ending with 'measureId=')</b><br />
	<input name='<%= Constants.CASESTUDYSHAREEDITURL %>' type="text" size="180" 
	value='<%= prefs.getValue(Constants.CASESTUDYSHAREEDITURL,"/web/guest/share-your-info/case-studies?p_p_id=sharemeasureportlet_WAR_Measureportlet&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-2&p_p_col_count=1&_sharemeasureportlet_WAR_Measureportlet_jspPage=%2Fhtml%2Fshareinfo%2Fadd_measure.jsp&_sharemeasureportlet_WAR_Measureportlet_redirect=%2Fen%2Fshare-your-info%2Fcase-studies&_sharemeasureportlet_WAR_Measureportlet_measureId=") %>' />
	<br /><br />

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>
