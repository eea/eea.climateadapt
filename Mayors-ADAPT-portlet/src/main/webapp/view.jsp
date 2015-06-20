<%@page import="com.liferay.portal.kernel.util.LocaleUtil"%>
<%@page import="com.liferay.util.Encryptor"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticle"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page
	import="com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.bean.BeanParamUtil"%>
<%@ include file="init.jsp"%>
<%
	HttpServletRequest httpReq = PortalUtil
	.getOriginalServletRequest(request);
	String articleId = httpReq.getParameter("articleId");
	String uuid = httpReq.getParameter("token");
	
	
	JournalArticle article = JournalArticleLocalServiceUtil.getJournalArticleByUuidAndGroupId(uuid, layout.getGroupId());
	request.setAttribute(WebKeys.JOURNAL_ARTICLE,article);
	String cityName = article.getTitle(locale);
%>
<h2>
	Welcome to
	<%=cityName %>
	city profile administration page
</h2>
Here you can manage Mayors-ADAPT initiative information relative to your
city.

<liferay-portlet:renderURL portletName="15"
	var="previewArticleContentURL"
	windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<liferay-portlet:param name="struts_action"
		value="/journal/preview_article_content" />
	<liferay-portlet:param name="groupId"
		value="<%=String.valueOf(article.getGroupId())%>" />
	<liferay-portlet:param name="articleId"
		value="<%=article.getArticleId()%>" />
	<liferay-portlet:param name="version"
		value="<%=String.valueOf(article.getVersion())%>" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL portletName="15" var="editArticleContentURL"
	windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<liferay-portlet:param name="struts_action"
		value="/journal/edit_article" />
	<liferay-portlet:param name="groupId"
		value="<%=String.valueOf(article.getGroupId())%>" />
	<liferay-portlet:param name="articleId"
		value="<%=article.getArticleId()%>" />
	<liferay-portlet:param name="version"
		value="<%=String.valueOf(article.getVersion())%>" />
	<liferay-portlet:param name="showHeader" value="false" />
</liferay-portlet:renderURL>

<liferay-security:doAsURL doAsUserId="11270901"
	var="impersonateArticleContentURL" />

<aui:row>
	<h3>Step 1 - Edit your City Profile</h3>
	<aui:button value="Edit City Profile" onClick="edit()" />
</aui:row>
<aui:row>
	<h3>Step 2 - Preview your City Profile Mayors-ADAPT page</h3>
	<aui:button value="Preview" onClick="preview()" />
</aui:row>
<!--<aui:row>
	<h3>Step 3 - Finish your page and publish it</h3>
	<aui:button value="Finish" onClick="finish()" />
</aui:row>-->

<aui:script>
	function preview() {
		Liferay
				.fire(
						'previewArticle',
						{
							title : '<%= HtmlUtil.escapeJS(article.getTitle(locale)) %>',
							uri : '<%= HtmlUtil.escapeJS(previewArticleContentURL.toString()) %>'
						});
	}
	function edit() {
		Liferay.fire('previewArticle', {
			title : '<%= HtmlUtil.escapeJS(article.getTitle(locale)) %>',
			uri : '<%= HtmlUtil.escapeJS(editArticleContentURL.toString()) %>'
		});
	}
	function impersonate() {
		Liferay
				.fire(
						'previewArticle',
						{
							title : '<%= HtmlUtil.escapeJS(article.getTitle(locale)) %>',
							uri : '<%= HtmlUtil.escapeJS(impersonateArticleContentURL.toString()) %>'
						});
	}
</aui:script>
	































