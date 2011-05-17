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

<portlet:defineObjects />

<%
	String step = renderRequest.getPreferences().getValue("step", "");

	String headertext = renderRequest.getPreferences().getValue("headertext", "Header text");
%>
<table border="0" cellpadding="5">
<tr valign="middle">
	<td>
	<img src="<%= request.getContextPath() %>/images/bullit<%= step %>.png">
	</td>
	<td width="10px">
	&nbsp;
	</td>
	<td style="font-size: 24px">
	<%= headertext %>
	</td>
</tr>
</table>

