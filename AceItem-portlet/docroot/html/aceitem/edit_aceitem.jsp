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
		
		<liferay-ui:error key="aceitemdatatype-required" message="aceitemdatatype-required" />		
		<aui:input name="datatype" />
		
		<liferay-ui:error key="aceitemstoredat-required" message="aceitemstoredat-required" />
		<b>website</b><br />	
		<input name="storedAt" type="text" size="120" value="<%= aceitem == null ? "" : aceitem.getStoredAt() %>"><br /><br />
		
		<b>storagetype</b><br />	
		<input name="storagetype" type="text" size="65" value="<%= aceitem == null ? "URL" : aceitem.getStoragetype() %>"><br /><br />

		<b>Sectors (A;B;C;D;F;H;I;M;W;)</b><br />
		<input name="sectors_" type="text" size="65" value="<%= aceitem == null ? "" : aceitem.getSectors_() %>"><br /><br />
		
		<b>Elements(O;V;M;P;E;)</b><br />
		<input name="elements_" type="text" size="65" value="<%= aceitem == null ? "" : aceitem.getElements_() %>"><br /><br />
		
		<b>Climate Impacts (E;W;D;F;S;I;)</b><br />
		<input name="climateimpacts_" type="text" size="65" value="<%= aceitem == null ? "" : aceitem.getClimateimpacts_() %>"><br /><br />
		
		<b>textsearch</b><br />
		<textarea name="textSearch" rows=15 cols=100><%= aceitem == null ? "" : aceitem.getTextSearch() %></textarea>
		
		<aui:input name="keyword"  />
		
		<aui:input name="spatialLayer"  />
		
		<aui:input name="spatialValues"  />
		
		<!--  a u i :input name="startdate" / >
		
		< a u  i:input name="enddate" / >
		
		< a u i  :input name="publicationdate" / -->
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />

		<aui:button type="cancel"  onClick="<%= redirect %>" />
	</aui:button-row>
</aui:form>