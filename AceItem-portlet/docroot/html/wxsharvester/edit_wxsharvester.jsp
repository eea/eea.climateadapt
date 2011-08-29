<%@include file="/html/init.jsp" %>
<%
	WxsHarvester wxsHarvester = null;

	long wxsHarvesterId = ParamUtil.getLong(request, "wxsharvesterid");

	if (wxsHarvesterId > 0) {
		wxsHarvester = WxsHarvesterLocalServiceUtil.getWxsHarvester(wxsHarvesterId);
	}

	String redirect = ParamUtil.getString(request, "redirect");
%>

<liferay-ui:header
	backURL="<%= redirect %>"
	title='<%= (wxsHarvester != null) ? wxsHarvester.getName() : "new-wxsHarvester" %>'
/>

<aui:model-context bean="<%= wxsHarvester %>" model="<%= WxsHarvester.class %>" />

<portlet:actionURL name='<%= wxsHarvester == null ? "addWxsHarvester" : "updateWxsHarvester" %>' var="editWxsHarvesterURL" />

<aui:form action="<%= editWxsHarvesterURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />

		<aui:input type="hidden" name="wxsharvesterid" value='<%= wxsHarvester == null ? "" : wxsHarvester.getWxsharvesterid() %>'/>

		<b>name</b><br />	
		<input name="name" type="text" size="120" value='<%= wxsHarvester == null ? "" : wxsHarvester.getName() %>'><br /><br />

		<b>url</b><br />
		<input name="url" type="text" size="120" value='<%= wxsHarvester == null ? "" : wxsHarvester.getUrl() %>'><br /><br />

        <div style="float: left; margin-right: 35px;">
            <b>every</b><br />
            <input name="every" type="text" size="10" value='<%= wxsHarvester == null ? "" : wxsHarvester.getEvery() %>'><br /><br />

            <input type="checkbox" name="savedToGeoNetwork" id="savedToGeoNetwork" value="false" <% if (wxsHarvester != null) { out.print( wxsHarvester.getSavedToGeoNetwork() == true ? "checked" : "") ; } %> />
            <b>Saved to GeoNetwork?</b><br />
         </div>
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />
		<aui:button type="cancel"  onClick="<%= redirect %>" />
	</aui:button-row>
</aui:form>
