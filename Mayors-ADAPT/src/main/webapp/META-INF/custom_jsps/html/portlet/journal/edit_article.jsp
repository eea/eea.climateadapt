
<%@ include file="/html/portlet/journal/init.jsp"%>
<%
	boolean cityProfile = user.getScreenName().equalsIgnoreCase(
			"cityprofilecontact");
%>
<c:choose>
	<c:when test="<%=cityProfile%>">
		<liferay-util:include
			page="/html/portlet/journal/edit_city_profile.jsp" />
	</c:when>
	<c:otherwise>
		<liferay-util:include
			page="/html/portlet/journal/edit_article_regular.jsp" />
	</c:otherwise>
</c:choose>
