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

<%@include file="/html/init.jsp" %>

<portlet:actionURL name="setAceSearchPref" var="setAceSearchPref" />

<aui:form action="<%= setAceSearchPref %>" method="POST" name="fm" >
	<aui:input name="<%= Constants.rowsPerPagePreferenceName %>" value='<%= prefs.getValue(Constants.rowsPerPagePreferenceName,"10") %>' size="45" type="text" />
	
	<aui:input name="<%= Constants.fuzzinessPreferenceName %>" value='<%= prefs.getValue(Constants.fuzzinessPreferenceName, "0.7") %>' size="45" type="text" />

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>
