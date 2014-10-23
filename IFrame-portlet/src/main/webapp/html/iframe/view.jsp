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
	String url = renderRequest.getPreferences().getValue("url", "");

	String inline = renderRequest.getPreferences().getValue("inline-attributes", "frameborder='0' style='min-width:984px;min-height:800px' width='100%' height='100%' ");
%>

<div>
	<img class="loading-image" src="/IFrame-portlet/images/loading-green-50.gif"/>
	<br />
	<iframe class="ace-iframe" <%= inline %> src='<%= url %>'></iframe>
</div>

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script>
    $(document).ready(function () {
        $(".ace-iframe").on('load', function () {
        	$(".loading-image").hide();
        });
    });
</script>