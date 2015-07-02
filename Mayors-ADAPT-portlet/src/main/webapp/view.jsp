<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowTask"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page
	import="com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil"%>
<%@page import="java.util.List"%>
<%@page
	import="com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowInstance"%>
<%@page
	import="com.liferay.portal.service.WorkflowInstanceLinkLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.WorkflowInstanceLink"%>
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
	String uuid = httpReq.getParameter("token");

	long groupId = ParamUtil.getLong(request, "groupId", 18L);
	long companyId = ParamUtil.getLong(request, "companyId", 1L);
	long userId = ParamUtil.getLong(request, "userId", UserLocalServiceUtil
			.getUserByScreenName(companyId, "cityprofilecontact")
			.getUserId());
	
	Log _log = LogFactoryUtil
			.getLog("Mayors-ADAPT-portlet/view.jsp");
	
	JournalArticle article = JournalArticleLocalServiceUtil.getJournalArticleByUuidAndGroupId(uuid, layout.getGroupId());
	request.setAttribute(WebKeys.JOURNAL_ARTICLE,article);
	String cityName = article.getTitle(locale);
	String articleId = article.getArticleId();
	
%>
<h2>
	Welcome to
	<%=cityName%>
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

<liferay-portlet:actionURL var="finishTaskURL" name="finishTask"
	windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<liferay-portlet:param name="token"
		value="<%=uuid %>" />
	<liferay-portlet:param name="companyId"
		value="<%=String.valueOf(companyId)%>" />
	<liferay-portlet:param name="groupId"
		value="<%=String.valueOf(groupId)%>" />
	<liferay-portlet:param name="userId" 
		value="<%=String.valueOf(userId)%>" />
</liferay-portlet:actionURL>

<liferay-security:doAsURL doAsUserId="11270901"
	var="impersonateArticleContentURL" />

<aui:row>
	<h3>Step 1 - Edit your City Profile</h3>
	<aui:button value="Edit" onClick="edit()" />
</aui:row>
<aui:row>
	<h3>Step 2 - Preview your City Profile Mayors-ADAPT page</h3>
	<aui:button value="Preview" onClick="preview()" />
</aui:row>
<aui:row>
	<h3>Step 3 - Finish your page and publish it</h3>
	<aui:button value="Finish" onClick="finish()" />
</aui:row>

<aui:row>
	<h3>Step 4 - Check your page in our Portal (after ours administrators approve it)</h3>
	<aui:button value="Open"  onClick="check()" />
</aui:row>

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
	function finish() {
		Liferay
				.fire(
						'previewArticle',
						{
							title : '<%= HtmlUtil.escapeJS(article.getTitle(locale)) %>',
							uri : '<%= HtmlUtil.escapeJS(finishTaskURL.toString()) %>'
						});
	}
	function check() {
		window.open('/-/<%= HtmlUtil.escapeJS(cityName.toString())%>')
	}
</aui:script>
	

































