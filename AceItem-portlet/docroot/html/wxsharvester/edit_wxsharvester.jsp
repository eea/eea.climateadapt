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

<%
	String ogcType = nl.wur.alterra.cgi.ace.model.constants.OGCType.WMS130.getString();	// Default value
	String isoTopic = "";																// Default value
	
	if (wxsHarvester != null) {
		ogcType = wxsHarvester.getOgctype();
		if (ogcType == "") ogcType = nl.wur.alterra.cgi.ace.model.constants.OGCType.WMS130.getString();
		isoTopic = wxsHarvester.getTopic();
	}

%>

<aui:form action="<%= editWxsHarvesterURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />

		<aui:input type="hidden" name="wxsharvesterid" value='<%= wxsHarvester == null ? "" : wxsHarvester.getWxsharvesterid() %>'/>

		<b><liferay-ui:message key="aceharvester-name" /></b><br />	
		<input name="name" type="text" size="120" value='<%= wxsHarvester == null ? "" : wxsHarvester.getName() %>'><br /><br />

		<b><liferay-ui:message key="aceharvester-url" /></b><br />
		<input name="url" type="text" size="120" value='<%= wxsHarvester == null ? "" : wxsHarvester.getUrl() %>'><br /><br />

		<b><liferay-ui:message key="aceharvester-ocgtype" /></b><br />	
		<c:set var="ogcTypeVal" value="<%= ogcType %>" />

		<select name="ogctype">
			<c:forEach var="ogcTypeEl" items="<%= nl.wur.alterra.cgi.ace.model.constants.OGCType.values() %>" >
			
				<c:set var="ogcTypeElMustBeChecked" value="false" />
				
				<c:if test="${ogcTypeEl == ogcTypeVal}">
					<c:set var="ogcTypeElMustBeChecked" value="true" />
				</c:if>	
				
				<c:choose>
					<c:when test="${ogcTypeElMustBeChecked}">
						<option value="${ogcTypeEl}" selected="selected" ><liferay-ui:message key="aceharvester-ocgtype-lbl-${ogcTypeEl}" /></option>
					</c:when>
					<c:otherwise>
						<option value="${ogcTypeEl}" ><liferay-ui:message key="aceharvester-ocgtype-lbl-${ogcTypeEl}" /></option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select><br /><br />	
		
		
		<b><liferay-ui:message key="aceharvester-isotopic" /></b><br />	
		<c:set var="isoTopicVal" value="<%= isoTopic %>" />
		
		<select name="topic">
			 <option value=""></option>
			 <c:forEach var="isoTopicEl" items="<%= nl.wur.alterra.cgi.ace.model.constants.ISOTopicCategory.values() %>" >
				<c:set var="isoTopicElMustBeChecked" value="false" />
				
				<c:if test="${isoTopicEl.string eq isoTopicVal}">
					<c:set var="isoTopicElMustBeChecked" value="true" />
				</c:if>	
			 	
			 	<c:choose>
					<c:when test="${isoTopicElMustBeChecked}">
						<option value="${isoTopicEl}" selected="selected" ><liferay-ui:message key="aceharvester-isotopic-lbl-${isoTopicEl}" /></option>
					</c:when>
					<c:otherwise>
						<option value="${isoTopicEl}" ><liferay-ui:message key="aceharvester-isotopic-lbl-${isoTopicEl}" /></option>
					</c:otherwise>
				</c:choose>
				
			 </c:forEach>
		</select><br /><br />	
		
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
