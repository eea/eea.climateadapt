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

<%@ include file="/html/taglib/init.jsp" %>

<%
String key = (String)request.getAttribute("liferay-ui:error:key");
String message = (String)request.getAttribute("liferay-ui:error:message");
boolean translateMessage = GetterUtil.getBoolean((String)request.getAttribute("liferay-ui:error:translateMessage"));
String rowBreak = (String)request.getAttribute("liferay-ui:error:rowBreak");
%>

<c:choose>
	<c:when test="<%= (key != null) && Validator.isNull(message) %>">
		<c:if test="<%= SessionErrors.contains(portletRequest, key) %>">
			</div>

			<%= rowBreak %>
		</c:if>
	</c:when>
	<c:when test="<%= key == null %>">
		<c:if test="<%= !SessionErrors.isEmpty(portletRequest) %>">

			<%--
				This if block is an addition to the original JSP and the sole reason for this hook.
				The idea is to not display the default error message coming from the <liferay-ui:error />
				that is present in webapps/ROOT/html/common/themes/portlet_messages.jspf.

				We detect this by detecting if the message is null too. If it is null (and we're already in this
				block because the key is null too), then we identify this as the <liferay-ui:error /> coming
				from webapps/ROOT/html/common/themes/portlet_messages.jspf. Therefore we display the default
				error message (i.e. the "you-have-entered-invalid-data") only when this is not the case.
			--%>
			<c:if test="<%= message!=null %>">
				<div class="portlet-msg-error">
					<liferay-ui:message key="you-have-entered-invalid-data" />
				</div>
				<%= rowBreak %>
			</c:if>
		</c:if>
	</c:when>
	<c:otherwise>
		<c:if test="<%= SessionErrors.contains(portletRequest, key) %>">
			<div class="portlet-msg-error">

			<c:choose>
				<c:when test="<%= translateMessage %>">
					<%= LanguageUtil.get(pageContext, message) %>
				</c:when>
				<c:otherwise>
					<%= message %>
				</c:otherwise>
			</c:choose>

			</div>

			<%= rowBreak %>
		</c:if>
	</c:otherwise>
</c:choose>