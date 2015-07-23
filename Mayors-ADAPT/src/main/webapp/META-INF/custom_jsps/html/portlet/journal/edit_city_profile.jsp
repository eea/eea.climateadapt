<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

<%@page import="com.liferay.portal.service.WorkflowInstanceLinkLocalServiceUtil"%>
<%@page import="com.liferay.portal.NoSuchWorkflowInstanceLinkException"%>
<%@ include file="/html/portlet/journal/init.jsp" %>

<%
String cmd = ParamUtil.getString(request, Constants.CMD);

String tabs2 = ParamUtil.getString(request, "tabs2");

String redirect = ParamUtil.getString(request, "redirect");

String FINISH = "FINISH";

System.out.println("CMD: "+cmd);

// Make sure the redirect is correct. This is a workaround for a layout that
// has both the Journal and Journal Content portlets and the user edits an
// article through the Journal Content portlet and then hits cancel.

/*if (redirect.indexOf("p_p_id=" + PortletKeys.JOURNAL_CONTENT) != -1) {
	if (layoutTypePortlet.hasPortletId(PortletKeys.JOURNAL)) {
		PortletURL portletURL = renderResponse.createRenderURL();

		portletURL.setPortletMode(PortletMode.VIEW);
		portletURL.setWindowState(WindowState.NORMAL);

		redirect = portletURL.toString();
	}
}*/

String backURL = ParamUtil.getString(request, "backURL");

String portletResource = ParamUtil.getString(request, "portletResource");

String referringPortletResource = ParamUtil.getString(request, "referringPortletResource");

JournalArticle article = (JournalArticle)request.getAttribute(WebKeys.JOURNAL_ARTICLE);

long groupId = BeanParamUtil.getLong(article, request, "groupId", scopeGroupId);

long folderId = ParamUtil.getLong(request, "folderId", JournalFolderConstants.DEFAULT_PARENT_FOLDER_ID);

long classNameId = BeanParamUtil.getLong(article, request, "classNameId");
long classPK = BeanParamUtil.getLong(article, request, "classPK");

String articleId = BeanParamUtil.getString(article, request, "articleId");

double version = BeanParamUtil.getDouble(article, request, "version", JournalArticleConstants.VERSION_DEFAULT);

String structureId = BeanParamUtil.getString(article, request, "structureId");

DDMStructure ddmStructure = null;

long ddmStructureId = ParamUtil.getLong(request, "ddmStructureId");

if (ddmStructureId > 0) {
	try {
		ddmStructure = DDMStructureLocalServiceUtil.getStructure(ddmStructureId);
	}
	catch (NoSuchStructureException nsse) {
	}
}
else if (Validator.isNotNull(structureId)) {
	try {
		ddmStructure = DDMStructureLocalServiceUtil.getStructure(themeDisplay.getSiteGroupId(), PortalUtil.getClassNameId(JournalArticle.class), structureId, true);
	}
	catch (NoSuchStructureException nsse) {
	}
}

String templateId = BeanParamUtil.getString(article, request, "templateId");

DDMTemplate ddmTemplate = null;

long ddmTemplateId = ParamUtil.getLong(request, "ddmTemplateId");

if (ddmTemplateId > 0) {
	try {
		ddmTemplate = DDMTemplateLocalServiceUtil.getTemplate(ddmTemplateId);
	}
	catch (NoSuchTemplateException nste) {
	}
}
else if (Validator.isNotNull(templateId)) {
	try {
		ddmTemplate = DDMTemplateLocalServiceUtil.getTemplate(groupId, PortalUtil.getClassNameId(DDMStructure.class), templateId, true);
	}
	catch (NoSuchStructureException nste) {
	}
}

String defaultLanguageId = ParamUtil.getString(request, "defaultLanguageId");

String toLanguageId = ParamUtil.getString(request, "toLanguageId");

if (Validator.isNull(defaultLanguageId) || !LanguageUtil.isAvailableLocale(themeDisplay.getSiteGroupId(), defaultLanguageId)) {
	if (article != null) {
		defaultLanguageId = article.getDefaultLanguageId();
	}
	else {
		defaultLanguageId = LocaleUtil.toLanguageId(themeDisplay.getSiteDefaultLocale());
	}
}

boolean showHeader = ParamUtil.getBoolean(request, "showHeader", true);
showHeader = false;

String[] mainSections = PropsValues.JOURNAL_ARTICLE_FORM_ADD;

if (Validator.isNotNull(toLanguageId)) {
	mainSections = PropsValues.JOURNAL_ARTICLE_FORM_TRANSLATE;
}
else if ((article != null) && (article.getId() > 0)) {
	mainSections = PropsValues.JOURNAL_ARTICLE_FORM_UPDATE;
}
else if (classNameId > JournalArticleConstants.CLASSNAME_ID_DEFAULT) {
	mainSections = PropsValues.JOURNAL_ARTICLE_FORM_DEFAULT_VALUES;
}

//String[][] categorySections = {mainSections};
String[][] categorySections = {new String[] {"content","categorization","schedule","display-page"}};

request.setAttribute("edit_article.jsp-redirect", redirect);

request.setAttribute("edit_article.jsp-structure", ddmStructure);
request.setAttribute("edit_article.jsp-template", ddmTemplate);

request.setAttribute("edit_article.jsp-defaultLanguageId", defaultLanguageId);
request.setAttribute("edit_article.jsp-toLanguageId", toLanguageId);
%>

<div class="article-form <%= ((article != null) && !article.isNew()) ? "article-form-edit" : "article-form-add" %>">
	<c:if test="<%= showHeader %>">
		<liferay-util:include page="/html/portlet/journal/article_header.jsp" />
	</c:if>

	<aui:form enctype="multipart/form-data" method="post" name="fm2">
		<input name="groupId" type="hidden" value="" />
		<input name="articleId" type="hidden" value="" />
		<input name="version" type="hidden" value="" />
		<input name="title" type="hidden" value="" />
		<input name="xml" type="hidden" value="" />
	</aui:form>

	<portlet:actionURL var="editArticleActionURL" windowState="<%= WindowState.MAXIMIZED.toString() %>">
		<portlet:param name="struts_action" value="/journal/edit_article" />
	</portlet:actionURL>

	<portlet:renderURL var="editArticleRenderURL" windowState="<%= WindowState.MAXIMIZED.toString() %>">
		<portlet:param name="struts_action" value="/journal/edit_article" />
	</portlet:renderURL>

	<aui:form action="<%= editArticleActionURL %>" cssClass="lfr-dynamic-form" enctype="multipart/form-data" method="post" name="fm1" onSubmit='<%= renderResponse.getNamespace() + "submitForm(event);" %>'>
		<aui:input name="<%= Constants.CMD %>" type="hidden" />
		<aui:input name="tabs2" type="hidden" value="<%= tabs2 %>" />
		<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
		<aui:input name="backURL" type="hidden" value="<%= backURL %>" />
		<aui:input name="portletResource" type="hidden" value="<%= portletResource %>" />
		<aui:input name="referringPortletResource" type="hidden" value="<%= referringPortletResource %>" />
		<aui:input name="groupId" type="hidden" value="<%= groupId %>" />
		<aui:input name="privateLayout" type="hidden" value="<%= layout.isPrivateLayout() %>" />
		<aui:input name="folderId" type="hidden" value="<%= folderId %>" />
		<aui:input name="classNameId" type="hidden" value="<%= classNameId %>" />
		<aui:input name="classPK" type="hidden" value="<%= classPK %>" />
		<aui:input name="articleId" type="hidden" value="<%= articleId %>" />
		<aui:input name="articleIds" type="hidden" value="<%= articleId + EditArticleAction.VERSION_SEPARATOR + version %>" />
		<aui:input name="version" type="hidden" value="<%= ((article == null) || article.isNew()) ? version : article.getVersion() %>" />
		<aui:input name="languageId" type="hidden" value="<%= Validator.isNotNull(toLanguageId) ? toLanguageId : defaultLanguageId %>" />
		<aui:input name="articleURL" type="hidden" value="<%= editArticleRenderURL %>" />
		<aui:input name="ddmStructureId" type="hidden" />
		<aui:input name="ddmTemplateId" type="hidden" />
		<aui:input name="workflowAction" type="hidden" value="<%= String.valueOf(WorkflowConstants.ACTION_SAVE_DRAFT) %>" />

		<liferay-ui:error exception="<%= ArticleContentSizeException.class %>" message="you-have-exceeded-the-maximum-web-content-size-allowed" />

		<aui:model-context bean="<%= article %>" defaultLanguageId="<%= defaultLanguageId %>" model="<%= JournalArticle.class %>" />

		<div class="journal-article-wrapper" id="<portlet:namespace />journalArticleWrapper">
			<div class="journal-article-wrapper-content">
				<c:if test="<%= Validator.isNull(toLanguageId) %>">
					<c:if test="<%= (article != null) && !article.isNew() %>">
						<aui:workflow-status id="<%= String.valueOf(article.getArticleId()) %>" status="<%= article.getStatus() %>" version="<%= String.valueOf(article.getVersion()) %>" />

						<liferay-util:include page="/html/portlet/journal/article_toolbar.jsp" />
					</c:if>
				</c:if>

				<liferay-util:buffer var="htmlTop">
					<c:if test="<%= article != null %>">
						<div class="article-info">
							<div class="float-container">
								<c:if test="<%= article.isSmallImage() %>">
									<img alt="" class="article-image" src="<%= HtmlUtil.escape(article.getArticleImageURL(themeDisplay)) %>" width="150" />
								</c:if>

								<c:if test="<%= !article.isNew() %>">
									<span class="article-name"><%= HtmlUtil.escape(article.getTitle(locale)) %></span>
								</c:if>
							</div>
						</div>
					</c:if>
				</liferay-util:buffer>

				<liferay-util:buffer var="htmlBottom">

					<%
					boolean approved = false;
					boolean pending = false;

					if ((article != null) && (version > 0)) {
						approved = article.isApproved();

						if (WorkflowDefinitionLinkLocalServiceUtil.hasWorkflowDefinitionLink(themeDisplay.getCompanyId(), scopeGroupId, JournalArticle.class.getName())) {
							pending = article.isPending();
						}
					}
					%>

					<c:if test="<%= approved %>">
						<div class="alert alert-info">
							<liferay-ui:message key="a-new-version-will-be-created-automatically-if-this-content-is-modified" />
						</div>
					</c:if>

					<!-- <c:if test="<%= pending %>">
						<div class="alert alert-info">
							<liferay-ui:message key="there-is-a-publication-workflow-in-process" />
						</div>
					</c:if>-->

					<aui:button-row cssClass="journal-article-button-row">

						<%
						boolean hasSavePermission = false;

						if (article != null) {
							hasSavePermission = JournalArticlePermission.contains(permissionChecker, article, ActionKeys.UPDATE);
						}
						else {
							hasSavePermission = JournalPermission.contains(permissionChecker, groupId, ActionKeys.ADD_ARTICLE);
						}

						String saveButtonLabel = "save";

						if ((article == null) || article.isDraft()
								|| article.isApproved()) {
							pending = true;
							saveButtonLabel = "save";
							//							saveButtonLabel = "save-as-draft";
						}

						String publishButtonLabel = "publish";

						if (WorkflowDefinitionLinkLocalServiceUtil
								.hasWorkflowDefinitionLink(
										themeDisplay.getCompanyId(), groupId,
										JournalArticle.class.getName())) {
							publishButtonLabel = "submit-for-publication";
						}

						if (classNameId > JournalArticleConstants.CLASSNAME_ID_DEFAULT) {
							publishButtonLabel = "save";
						}
						boolean pending_review_administrator = false;
						try {
							if (WorkflowInstanceLinkLocalServiceUtil.getState(
									article.getCompanyId(),
									article.getGroupId(),
									JournalArticle.class.getName(),
									article.getId()).equalsIgnoreCase(
									"review_administrator"))
								pending_review_administrator = true;
						} catch (NoSuchWorkflowInstanceLinkException e) {
						}

						System.out.println("pending?" + pending
								+ "   pending_admin?"
								+ pending_review_administrator);
						%>

						<c:choose>
							<c:when test="<%= Validator.isNull(toLanguageId) %>">
								<c:if test="<%= hasSavePermission %>">
									<c:if test="<%= classNameId == JournalArticleConstants.CLASSNAME_ID_DEFAULT %>">
										<aui:button disabled="<%=pending_review_administrator%>" name="saveButton" onClick='<%= renderResponse.getNamespace() + "saveArticle()" %>' primary="<%= false %>" type="submit" value="<%= saveButtonLabel %>" />
										<aui:button disabled="<%=pending_review_administrator%>" name="finishButton" onClick='<%= renderResponse.getNamespace() + "finishArticle()" %>' primary="<%= false %>" type="submit" value="Finish (Test)" />
									</c:if>

									<!--<aui:button disabled="<%= pending %>" name="publishButton" onClick='<%= renderResponse.getNamespace() + "publishArticle()" %>' type="submit" value="<%= publishButtonLabel %>" />-->
								</c:if>
							</c:when>
							<c:otherwise>
								<aui:button name="translateButton" onClick='<%= renderResponse.getNamespace() + "translateArticle()" %>' type="submit" value="save" />

								<%
								String[] translations = article.getAvailableLanguageIds();
								%>

								<aui:button disabled="<%= toLanguageId.equals(defaultLanguageId) || !ArrayUtil.contains(translations, toLanguageId) %>" name="removeArticleLocaleButton" onClick='<%= renderResponse.getNamespace() + "removeArticleLocale();" %>' value="remove-translation" />
							</c:otherwise>
						</c:choose>
						<aui:button href="<%= redirect %>" type="cancel" />
					</aui:button-row>
				</liferay-util:buffer>

				<c:choose>
					<c:when test="<%= Validator.isNull(toLanguageId) %>">
						<liferay-ui:form-navigator
							categoryNames="<%= _CATEGORY_NAMES %>"
							categorySections="<%= categorySections %>"
							formName="fm1"
							htmlBottom="<%= htmlBottom %>"
							htmlTop="<%= htmlTop %>"
							jspPath="/html/portlet/journal/city_profile/"
							showButtons="<%= false %>"
						/>
					</c:when>
					<c:otherwise>

						<%
						for (String section : mainSections) {
						%>

							<div class="form-section">
								<liferay-util:include page='<%= "/html/portlet/journal/article/" + _getSectionJsp(section) + ".jsp" %>' />
							</div>

						<%
						}
						%>

						<%= htmlBottom %>

					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</aui:form>
</div>

<c:if test="<%= (article != null) && Validator.equals(cmd, Constants.PREVIEW) %>">
	<aui:script use="liferay-journal-preview">
		<liferay-portlet:renderURL plid="<%= JournalUtil.getPreviewPlid(article, themeDisplay) %>" var="previewArticleContentURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
			<portlet:param name="struts_action" value="/journal/preview_article_content" />
			<portlet:param name="groupId" value="<%= String.valueOf(article.getGroupId()) %>" />
			<portlet:param name="articleId" value="<%= article.getArticleId() %>" />
			<portlet:param name="version" value="<%= String.valueOf(article.getVersion()) %>" />
		</liferay-portlet:renderURL>

		Liferay.fire(
			'previewArticle',
			{
				title: '<%= HtmlUtil.escapeJS(article.getTitle(locale)) %>',
				uri: '<%= HtmlUtil.escapeJS(previewArticleContentURL.toString()) %>'
			}
		);
	</aui:script>
</c:if>

<c:if test="<%= (article != null) && Validator.equals(cmd, FINISH) %>">
	<aui:script use="city-profile-finish">
		<liferay-portlet:actionURL portletName="Mayors-ADAPT-portlet" var="finishTaskURL" name="finishTask" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
			<liferay-portlet:param name="token" value="<%=article.getUuid()%>" />
			<liferay-portlet:param name="companyId"	value="<%=String.valueOf(article.getCompanyId())%>" />
			<liferay-portlet:param name="groupId" value="<%=String.valueOf(article.getGroupId())%>" />
			<liferay-portlet:param name="userId" value="<%=String.valueOf(article.getUserId())%>" />
		</liferay-portlet:actionURL>
		alert('<%= HtmlUtil.escapeJS(finishTaskURL.toString())%>');
		window.open('<%= HtmlUtil.escapeJS(finishTaskURL.toString())%>','_self',false)
	</aui:script>
</c:if>

<aui:script>
	var <portlet:namespace />documentLibraryInput = null;
	var <portlet:namespace />imageGalleryInput = null;

	disableSeparatorFields()

    function disableSeparatorFields() {
	    /* Disable title Fields (separators) and improve aspect form */
        var formu = document.<portlet:namespace />fm1;
        var selects =  formu.getElementsByTagName("select");
        var inputs = formu.getElementsByTagName("input");
        for (var i=0; i<inputs.length; i++){
                if ((inputs[i].name).indexOf("_ti_") >= 0){
                        inputs[i].disabled="disabled";
                        inputs[i].style.backgroundColor = "#828282";
                        inputs[i].style.color = "white";
                }
        }

        for (var j=0; j<selects.length; j++){
                if ((selects[j].name).indexOf("_15_a_m_country")>= 0 || ((selects[j].name).indexOf("_15_b_m_sector"))>= 0 || ((selects[j].name).indexOf("_15_c_m_stage_of_the_implementation_cycle"))>= 0 || (selects[j].name).indexOf("_15_b_m_current_status_of_mayors_adapt_enrolment") >= 0){
                        selects[j].style.height="30px";
                }
        }
	}

	function <portlet:namespace />finishArticle() {
		document.<portlet:namespace />fm1.<portlet:namespace /><%= Constants.CMD %>.value = "FINISH";
	}

	function <portlet:namespace />publishArticle() {
		document.<portlet:namespace />fm1.<portlet:namespace /><%= Constants.CMD %>.value = "<%= Constants.PUBLISH %>";
	}

	function <portlet:namespace />removeArticleLocale() {
		if (confirm("<%= UnicodeLanguageUtil.get(pageContext, "are-you-sure-you-want-to-deactivate-this-language") %>")) {
			document.<portlet:namespace />fm1.<portlet:namespace /><%= Constants.CMD %>.value = "<%= Constants.DELETE_TRANSLATION %>";
			document.<portlet:namespace />fm1.<portlet:namespace />redirect.value = "<portlet:renderURL><portlet:param name="redirect" value="<%= redirect %>" /><portlet:param name="struts_action" value="/journal/edit_article" /><portlet:param name="groupId" value="<%= String.valueOf(groupId) %>" /><portlet:param name="articleId" value="<%= articleId %>" /><portlet:param name="version" value="<%= String.valueOf(version) %>" /></portlet:renderURL>&<portlet:namespace />languageId=<%= HtmlUtil.escapeJS(defaultLanguageId) %>";

			submitForm(document.<portlet:namespace />fm1);
		}
	}

	function <portlet:namespace />saveArticle() {
		document.<portlet:namespace />fm1.<portlet:namespace /><%= Constants.CMD %>.value = "<%= ((article == null) || Validator.isNull(article.getArticleId())) ? Constants.ADD : Constants.UPDATE %>";
	}

	function <portlet:namespace />selectDocumentLibrary(url) {
		document.getElementById(<portlet:namespace />documentLibraryInput).value = url;
	}

	function <portlet:namespace />selectImageGallery(url) {
		document.getElementById(<portlet:namespace />imageGalleryInput).value = url;
	}

	function <portlet:namespace />submitForm(event) {
		event.preventDefault();

		if (window.<portlet:namespace />journalPortlet) {
			var cmd = document.<portlet:namespace />fm1.<portlet:namespace /><%= Constants.CMD %>.value;

			if (cmd === '<%= Constants.TRANSLATE %>') {
				window.<portlet:namespace />journalPortlet.translateArticle();
			}
			else {
				window.<portlet:namespace />journalPortlet.saveArticle(cmd);
			}
		}
	}

	function <portlet:namespace />translateArticle() {
		document.<portlet:namespace />fm1.<portlet:namespace /><%= Constants.CMD %>.value = "<%= Constants.TRANSLATE %>";
	}

	<c:if test="<%= windowState.equals(WindowState.MAXIMIZED) %>">
		<c:choose>
			<c:when test="<%= PropsValues.JOURNAL_ARTICLE_FORCE_AUTOGENERATE_ID %>">
				Liferay.Util.focusFormField(document.<portlet:namespace />fm1.<portlet:namespace />title);
			</c:when>
			<c:otherwise>
				Liferay.Util.focusFormField(document.<portlet:namespace />fm1.<portlet:namespace /><%= (article == null) ? "newArticleId" : "title" %>);
			</c:otherwise>
		</c:choose>
	</c:if>
</aui:script>

<%!
private String _getSectionJsp(String name) {
	return TextFormatter.format(name, TextFormatter.N);
}

private static final String[] _CATEGORY_NAMES = {""};
%>