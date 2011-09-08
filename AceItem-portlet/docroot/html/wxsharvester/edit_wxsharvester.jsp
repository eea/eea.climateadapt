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

<portlet:actionURL name="saveWxsHarvesterToGeoNetwork" var="saveWxsHarvesterToGeoNetworkURL"/>
<portlet:actionURL name="executeWxsHarvester" var="executeWxsHarvester"/>

<%
	// Default values
	String ogcType = nl.wur.alterra.cgi.ace.model.constants.OGCType.WMS111.getString();
	String isoTopic = "";
	String every_days = "0";
	String every_hours = "1";
	String every_minutes = "30";
	
	boolean savedToGeoNetwork = false;

	if (wxsHarvester != null) {
		ogcType = wxsHarvester.getOgctype();
		if (ogcType == null || ogcType.equals("")) ogcType = nl.wur.alterra.cgi.ace.model.constants.OGCType.WMS111.getString();
		isoTopic = wxsHarvester.getTopic();
		savedToGeoNetwork = wxsHarvester.getSavedToGeoNetwork();
		
		int every = wxsHarvester.getEvery();
		if (every > 0) {
			int every_days_i 	= every/(24*60);
		    int every_hours_i 	= (every%(24*60)) / 60;
   			int every_minutes_i =(every%(24*60)) % 60;
		
			every_days = every_days_i+"";
			every_hours = every_hours_i+"";
			every_minutes = every_minutes_i+"";	
		}
	}

%>

<script type="text/javascript">
	function addToGeoNetwork() {
		var form = document.forms["<%= renderResponse.getNamespace() %>fm"];
		form.action = "<%= saveWxsHarvesterToGeoNetworkURL %>";
	}
	
	function executeHarvester() {
		var form = document.forms["<%= renderResponse.getNamespace() %>fm"];
		form.action = "<%= executeWxsHarvester %>";
	}
	
	
	function submitFormHandler(e) {
		var form = document.forms["<%= renderResponse.getNamespace() %>fm"];
			
		// Validate interval values
		var everyDaysVal = parseInt(form.elements["every_days"].value);
		var everyHoursVal = parseInt(form.elements["every_hours"].value);
		if ((everyHoursVal < 0) || (everyHoursVal > 23)) {
			alert("Hour interval must be between 0-23");
			e.returnValue = false; 
			return false;
		}
		
		var everyMinutesVal = parseInt(form.elements["every_minutes"].value);
		if ((everyMinutesVal < 0) || (everyMinutesVal > 59)) {
			alert("Minutes interval must be between 0-59");
			e.returnValue = false; 
			return false;
		}
		
		// Every value is stored in minutes
		var everyVal = (everyDaysVal * 24 * 60) + (everyHoursVal * 60) + everyMinutesVal;
		
		form.elements["<%= renderResponse.getNamespace() %>every"].value = everyVal + "";		 
		
		return true;
	}

</script>

<aui:form action="<%= editWxsHarvesterURL %>" method="POST" name="fm" onSubmit="return submitFormHandler(event);">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />

		<aui:input type="hidden" name="wxsharvesterid" value='<%= wxsHarvester == null ? "" : wxsHarvester.getWxsharvesterid() %>'/>

		<aui:input type="hidden" name="every" value='<%= wxsHarvester == null ? "" : wxsHarvester.getEvery() %>'/>

		<liferay-ui:error key="aceharvestername-required" message="aceharvestername-required" />		
		<b><liferay-ui:message key="aceharvester-name" /></b><br />	
		<input name="name" type="text" size="120" value='<%= wxsHarvester == null ? "" : wxsHarvester.getName() %>'><br /><br />

		<liferay-ui:error key="aceharvesterurl-required" message="aceharvesterurl-required" />		
		<b><liferay-ui:message key="aceharvester-url" /></b><br />
		<input name="url" type="text" size="120" value='<%= wxsHarvester == null ? "" : wxsHarvester.getUrl() %>'><br /><br />

		<b><liferay-ui:message key="aceharvester-ocgtype" /></b><br />	
		<c:set var="ogcTypeVal" value="<%= ogcType %>" />

		<select name="ogctype">
			<c:forEach var="ogcTypeEl" items="<%= nl.wur.alterra.cgi.ace.model.constants.OGCType.stringvalues() %>" >
			
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
            <b><liferay-ui:message key="aceharvester-every" /></b><br />
            <input name="every_days" type="text" size="5" maxlength="2" value='<%= every_days %>'> : 
            <input name="every_hours" type="text" size="5" maxlength="2"value='<%= every_hours %>'> :            
            <input name="every_minutes" type="text" size="5" maxlength="2" value='<%= every_minutes %>'>
            <liferay-ui:message key="aceharvester-every-lbl-description" /><br /><br />
            
            
            <% if ((savedToGeoNetwork == false) && (wxsHarvester != null)) {  %>
				<span style="color: #ff0000; font-weight: bold"><liferay-ui:message key="aceharvestergeonetwork-notexist" /></span>             
            <% } else if (wxsHarvester != null) { %>
				<span style="color: #000000; font-weight: bold"><liferay-ui:message key="aceharvestergeonetwork-exist" /></span>             
            <% } %>
         </div>
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />
		<aui:button type="cancel"  onClick="<%= redirect %>" />
		
		<% if ((savedToGeoNetwork == false) && (wxsHarvester != null)) {  %>
	  		<aui:button name="addToGeoNetwork" type="submit" value="Add to GeoNetwork"  onClick="javascript:addToGeoNetwork()" />  
        <% } else if (wxsHarvester != null) { %>
			<aui:button name="runHarvester" type="submit" value="Execute harvester"  onClick="javascript:executeHarvester()" />  
        <% } %>
	</aui:button-row>
</aui:form>
