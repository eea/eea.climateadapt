<%@include file="/html/init.jsp" %>

<%
	AceItem aceitem = null;

	long aceItemId = ParamUtil.getLong(request, "aceItemId");

	if (aceItemId > 0) {
		aceitem = AceItemLocalServiceUtil.getAceItem(aceItemId);
	}

	String redirect = ParamUtil.getString(request, "redirect");
%>

<liferay-ui:header
	backURL="<%= redirect %>"
	title='<%= (aceitem != null) ? aceitem.getName() : "new-aceitem" %>'
/>


<aui:model-context bean="<%= aceitem %>" model="<%= AceItem.class %>" />

<portlet:actionURL name='<%= aceitem == null ? "addAceItem" : "updateAceItem" %>' var="editAceItemURL" />

<aui:form action="<%= editAceItemURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />

		<aui:input type="hidden" name="aceItemId" value='<%= aceitem == null ? "" : aceitem.getAceItemId() %>'/>

		<aui:input name="name" />

		<b>description</b><br />
		<textarea name="description" rows=10 cols=100><%= aceitem == null ? "" : aceitem.getDescription() %></textarea>
		
		<liferay-ui:error key="aceitemtype-required" message="aceitemtype-required" />		
		<aui:input name="type" />
		
		<liferay-ui:error key="aceitemstoredat-required" message="aceitemstoredat-required" />
		<aui:input name="storedAt" />
			
		<aui:input name="sector"  />
		
		<b>Element</b><br />
		<input name="pilar" type="text" value="<%= aceitem == null ? "" : aceitem.getPilar() %>"><br /><br />

		
		<b>textsearch</b><br />
		<textarea name="textSearch" rows=15 cols=100><%= aceitem == null ? "" : aceitem.getTextSearch() %></textarea>
		
		<aui:input name="keyword"  />
		
		<aui:input name="nutsId"  />
		
		<aui:input name="nutsLevel"  />
		
		<aui:input name="startdate" />
		
		<aui:input name="enddate" />
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />

		<aui:button type="cancel"  onClick="<%= redirect %>" />
	</aui:button-row>
</aui:form>