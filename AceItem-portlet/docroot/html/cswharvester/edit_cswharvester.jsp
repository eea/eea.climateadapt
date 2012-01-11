<%@include file="/html/init.jsp" %>
<%
	CSWHarvester cswHarvester = null;

	long cswHarvesterId = ParamUtil.getLong(request, "cswharvesterid");

	if (cswHarvesterId > 0) {
		cswHarvester = CSWHarvesterLocalServiceUtil.getCSWHarvester(cswHarvesterId);
	}

	String redirect = ParamUtil.getString(request, "redirect");
%>

<liferay-ui:header
	backURL="<%= redirect %>"
	title='<%= (cswHarvester != null) ? cswHarvester.getName() : "new-cswHarvester" %>'
/>

<aui:model-context bean="<%= cswHarvester %>" model="<%= CSWHarvester.class %>" />

<portlet:actionURL name='<%= cswHarvester == null ? "addCSWHarvester" : "updateCSWHarvester" %>' var="editCSWHarvesterURL" />

<portlet:actionURL name="saveCSWHarvesterToGeoNetwork" var="saveCSWHarvesterToGeoNetworkURL"/>
<portlet:actionURL name="executeCswHarvester" var="executeCswHarvester"/>

<%
	// Default values
	String isoTopic = "";
	String every_days = "0";
	String every_hours = "0";
	String every_minutes = "0";
	
	boolean savedToGeoNetwork = false;

	if (cswHarvester != null) {
		isoTopic = cswHarvester.getTopic();
		savedToGeoNetwork = cswHarvester.getSavedToGeoNetwork();
		
		int every = cswHarvester.getEvery();
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
		form.action = "<%= saveCSWHarvesterToGeoNetworkURL %>";
	}
	
	function executeHarvester() {
		var form = document.forms["<%= renderResponse.getNamespace() %>fm"];
		form.action = "<%= executeCswHarvester %>";
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

<aui:form action="<%= editCSWHarvesterURL %>" method="POST" name="fm" onSubmit="return submitFormHandler(event);">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />

		<aui:input type="hidden" name="cswharvesterid" value='<%= cswHarvester == null ? "" : cswHarvester.getCswharvesterid() %>'/>
        <aui:input type="hidden" name="geonetworkId" value='<%= cswHarvester == null ? "" : cswHarvester.getGeonetworkId() %>'/>
        <aui:input type="hidden" name="geonetworkUUID" value='<%= cswHarvester == null ? "" : cswHarvester.getGeonetworkUUID() %>'/>

		<aui:input type="hidden" name="every" value='<%= cswHarvester == null ? "" : cswHarvester.getEvery() %>'/>

		<liferay-ui:error key="aceharvestername-required" message="aceharvestername-required" />		
		<b><liferay-ui:message key="aceharvester-name" /></b><br />	
		<input name="name" type="text" size="120" value='<%= cswHarvester == null ? "" : cswHarvester.getName() %>'><br /><br />

		<liferay-ui:error key="aceharvesterurl-required" message="aceharvesterurl-required" />		
		<b><liferay-ui:message key="aceharvester-url" /></b><br />
		<input name="url" type="text" size="120" value='<%= cswHarvester == null ? "" : cswHarvester.getUrl() %>'><br /><br />

        <b><liferay-ui:message key="aceharvester-freetext" /></b><br />
        <input name="freetext" type="text" size="120" value='<%= cswHarvester == null ? "" : cswHarvester.getFreetext() %>'><br /><br />

        <b><liferay-ui:message key="aceharvester-title" /></b><br />
        <input name="title" type="text" size="120" value='<%= cswHarvester == null ? "" : cswHarvester.getTitle() %>'><br /><br />

        <b><liferay-ui:message key="aceharvester-abstract" /></b><br />
        <input name="abstrakt" type="text" size="120" value='<%= cswHarvester == null ? "" : cswHarvester.getAbstrakt() %>'><br /><br />

        <b><liferay-ui:message key="aceharvester-subject" /></b><br />
        <input name="subject" type="text" size="120" value='<%= cswHarvester == null ? "" : cswHarvester.getSubject() %>'><br /><br />


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
            
            
            <% if ((savedToGeoNetwork == false) && (cswHarvester != null)) {  %>
				<span style="color: #ff0000; font-weight: bold"><liferay-ui:message key="aceharvestergeonetwork-notexist" /></span>             
            <% } else if (cswHarvester != null) { %>
				<span style="color: #000000; font-weight: bold"><liferay-ui:message key="aceharvestergeonetwork-exist" /></span>             
            <% } %>
         </div>
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />
		<aui:button type="cancel"  onClick="<%= redirect %>" />
	</aui:button-row>
</aui:form>
