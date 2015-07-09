<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>
<%@page import="com.liferay.portal.model.Portlet"%>
<%@page import="com.liferay.portal.model.LayoutTypePortlet"%>
<%@page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Layout"%>
<%@page import="com.liferay.portal.model.PortletPreferences"%>
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
	Log _log = LogFactoryUtil
	.getLog("Mayors-ADAPT-portlet/view.jsp");

	HttpServletRequest httpReq = PortalUtil
	.getOriginalServletRequest(request);
	String uuid = httpReq.getParameter("token");
	
	if (uuid==null) uuid= (String) request.getAttribute("token");
	
	_log.info("Managing page for token: "+uuid);
	

	long companyId = PortalUtil.getDefaultCompanyId();
	long groupId = GroupLocalServiceUtil.getGroup(companyId, "Guest").getGroupId();
	long userId = ParamUtil.getLong(request, "userId", UserLocalServiceUtil
	.getUserByScreenName(companyId, "cityprofilecontact")
	.getUserId()); 
	
	JournalArticle article = JournalArticleLocalServiceUtil.getJournalArticleByUuidAndGroupId(uuid, layout.getGroupId());
	request.setAttribute(WebKeys.JOURNAL_ARTICLE,article);
	String cityName = article.getTitle(locale);
	String articleId = article.getArticleId();
	String cityUrlName = article.getUrlTitle(); 
	
	boolean disableFinish=true;
	boolean disableOpen=true;
	boolean disableEdit=true;
	boolean disablePreview=true;
	String state = WorkflowInstanceLinkLocalServiceUtil.getState(
			article.getCompanyId(),
			article.getGroupId(),
			JournalArticle.class.getName(),
			article.getId());
	if (article.getStatus()==WorkflowConstants.STATUS_PENDING && !state.equalsIgnoreCase("review_administrator")) 
	{
		disableFinish=false;
		disableEdit=false;
	}
	if (article.getStatus()==WorkflowConstants.STATUS_PENDING && state.equalsIgnoreCase("review_administrator")) 
	{
		disablePreview =false;
	}
	if (article.getStatus()==WorkflowConstants.STATUS_APPROVED) disableOpen=false;
	
	_log.info("status: "+article.getStatus());
	_log.info("state: "+state);
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
	<liferay-portlet:param name="token" value="<%=uuid%>" />
	<liferay-portlet:param name="companyId"
		value="<%=String.valueOf(companyId)%>" />
	<liferay-portlet:param name="groupId"
		value="<%=String.valueOf(groupId)%>" />
	<liferay-portlet:param name="userId"
		value="<%=String.valueOf(userId)%>" />
</liferay-portlet:actionURL>

<aui:row>
	<h3>Step 1 - Edit your City Profile</h3>
	<aui:button value="Edit" onClick="edit()" disabled="<%=disableEdit %>" />
</aui:row>
<aui:row>
	<h3>Step 2 - Finish your page to preview it</h3>
	<aui:button value="Finish" onClick="finish()" disabled="<%=disableFinish %>" />
</aui:row>
<aui:row>
	<h3>Step 3 - Preview your City Profile Mayors Adapt page</h3>
	<aui:button value="Preview" onClick="preview()" disabled="<%=disablePreview %>" />
</aui:row>
<aui:row>
	<h3>Step 4 - Check your page in our Portal (as soon as our
		administrators approve it)</h3>
	<aui:button value="Check" onClick="check()" disabled="<%=disableOpen %>"  />
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
	function finish() {
		window.open('<%= HtmlUtil.escapeJS(finishTaskURL.toString())%>','_self',false)
	}
	function check() {
		window.open('/-/<%= HtmlUtil.escapeJS(cityUrlName.toLowerCase().toString())%>','_self',false)
	}
</aui:script>
	















































