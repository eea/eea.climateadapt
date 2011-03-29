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

<portlet:actionURL name="setProjectPref" var="setProjectPrefUrl" />

<aui:form action="<%= setProjectPrefUrl %>" method="POST" name="fm" >
	<aui:input name="rowsPerPage" value='<%= prefs.getValue("rowsPerPage","") %>' size="45" type="text" />

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>