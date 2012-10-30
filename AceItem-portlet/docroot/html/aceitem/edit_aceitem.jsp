<%@include file="/html/init.jsp" %>
<%
	AceItem aceitem = null;

	long aceItemId = ParamUtil.getLong(request, "aceItemId");

	if (aceItemId > 0) {
		aceitem = AceItemLocalServiceUtil.getAceItem(aceItemId);
	}

	String redirect = ParamUtil.getString(request, "redirect");

	String selectedDatatype = aceitem == null ? request.getParameter("datatype") : aceitem.getDatatype();
	if (selectedDatatype == null){
	    selectedDatatype = "";
	}
%>
<script type="text/javascript">

		    function checkallcountries() {
			<%
				nl.wur.alterra.cgi.ace.model.constants.AceItemCountry[] country = nl.wur.alterra.cgi.ace.model.constants.AceItemCountry.values();
				for(int i=0; i < country.length; i++) {
					out.print("document.getElementById('chk_countries_" +  country[i]  + "').checked = true;");
				}
			%>
		    }

		    function uncheckallcountries() {
		    <%
		    	for(int i=0; i < country.length; i++) {
		    		out.print("document.getElementById('chk_countries_" +  country[i]  + "').checked = false;");
		    	}
		    %>
		    }

		    function <portlet:namespace />initEditor() {
                var editorValue = document.getElementById("<portlet:namespace />descriptionField").value;
                return editorValue;
            }

            function saveData() {
                var x = window.<portlet:namespace />editor.getHTML();
                document.getElementById("<portlet:namespace />descriptionField").value = x;
                return true;
            }

</script>

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

		<aui:input type="hidden" name="wxsharvesterId" value='<%= aceitem == null ? "" : aceitem.getWxsharvesterId() %>'/>

        <liferay-ui:error key="aceitem-add-tech-error" message="aceitem-add-tech-error" />
        <liferay-ui:error key="aceitem-save-tech-error" message="aceitem-save-tech-error" />

<% if (aceitem != null) {
        long creationTime = aceitem.getCreationdate() == null ? 0 : aceitem.getCreationdate().getTime();
        %>
		<liferay-ui:error key="aceitem-changed" message="aceitem-changed" />
		<aui:input type="hidden" name="checkcreationdate" value='<%= creationTime %>'/>
<% } %>
		<liferay-ui:error key="aceitemname-required" message="aceitemname-required" />
		<b>item-name</b> <i>(required)</i><br />
		<input name="name" type="text" size="120" maxlength="255" value='<%= aceitem == null ? "" : aceitem.getName() %>'><br /><br />

		<liferay-ui:error key="aceitemstoredat-required" message="aceitemstoredat-required" />
		<b>website</b> <i>(required)</i><br />
		<input name="storedAt" type="text" size="120" maxlength="255" value='<%= aceitem == null ? "" : aceitem.getStoredAt() %>'><br /><br />


	<div style="float: left; margin-right: 35px;">
	    <table width="100%" border="0"><tr>
	    <td width=50%>
		<b>Datatype</b><br />
	    <select name="datatype">
		<%-- note : i18n file should always be in sync with AceItemElement enum --%>
		<c:set var="skiptypes" value="RESEARCHPROJECT_MEASURE_ACTION" />
		<c:forEach var="adaptationType" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemType.values() %>" >
			<div class="check">
				<c:set var="adaptationTypeMustBeChecked" value="false" />
				<c:set var="showtype" value="true" />
				<c:set var="aceItemType" value='<%=selectedDatatype%>' />
				<c:set var="adaptationTypeMustBeChecked" value="false" />
				<c:if test="${fn:indexOf(aceItemType, adaptationType)>=0}">
					<c:set var="adaptationTypeMustBeChecked" value="true" />
				</c:if>
				<c:if test="${fn:indexOf(skiptypes, adaptationType)>=0}">
					<c:set var="showtype" value="false" />
				</c:if>
				<c:choose>
					<c:when test="${showtype}">
					<c:choose>
						<c:when test="${adaptationTypeMustBeChecked}">
							<option value="${adaptationType}" selected="selected" >
							<liferay-ui:message key="acesearch-datainfotype-lbl-${adaptationType}" /></option>
						</c:when>
						<c:otherwise>
							<option value="${adaptationType}">
							<liferay-ui:message key="acesearch-datainfotype-lbl-${adaptationType}" /></option>
						</c:otherwise>
					</c:choose>
					</c:when>
				</c:choose>
			</div>
		</c:forEach>
		</select>
		</td>
		<td width=50%><b>storagetype</b><br />
	    <select name="storagetype">
			<option value="URL" <%= ((aceitem==null || aceitem.getStoragetype().equalsIgnoreCase("URL")) ? "selected" : "")%> >URL</option>
			<option value="MAPLAYER" <%= ((aceitem!=null && aceitem.getStoragetype().equalsIgnoreCase("MAPLAYER")) ? "selected" : "") %> >MAPLAYER</option>
			<option value="PLAINMETADATA" <%= ((aceitem!=null && aceitem.getStoragetype().equalsIgnoreCase("PLAINMETADATA")) ? "selected" : "") %> >PLAINMETADATA</option>
			<option value="SETOFMAPS" <%= ((aceitem!=null && aceitem.getStoragetype().equalsIgnoreCase("SETOFMAPS")) ? "selected" : "") %> >SETOFMAPS</option>
		</select>
		</td>
	    </tr></table>

		<br/>
        <b>description</b><br />
        <liferay-ui:input-editor/>
        <input id="<portlet:namespace />descriptionField" type="hidden" name="description" value="<%= aceitem==null ? "" : (aceitem.getDescription()==null ? "" : aceitem.getDescription()) %>"/>
        <br/>

        <b>keywords</b><br />
		<textarea name="keyword" rows=5 cols=100><%= aceitem == null ? "" : aceitem.getKeyword() %></textarea><br /><br />

		<aui:input name="source" maxlength="75" />

		<b>special tagging</b><br />
		<input name="specialtagging" type="text" size="65" maxlength="75" value='<%= aceitem == null ? "" : aceitem.getSpecialtagging() %>'><br /><br />

		<b>Geographic characterisation</b><br />
		<input name="spatialLayer" type="text" size="65" maxlength="75" value='<%= aceitem == null ? "" : aceitem.getSpatialLayer() %>'>
	 </div>
	<div style="float: left;">
		<br>
		<b>Sectors</b><br />
		<!--   input name="sectors_" type="text" size="65" value="< %= aceitem == null ? "" : aceitem.getSectors_() % >"><br /><br / -->

       <%-- note : i18n file should always be in sync with AceItemSector enum --%>
		<c:forEach var="adaptationSector" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemSector.values() %>" >
			<div class="check">
				<c:set var="aceItemSectors" value='<%= aceitem == null ? "" : aceitem.getSectors_() %>' />
				<c:set var="adaptationSectorMustBeChecked" value="false" />
				<c:if test="${fn:indexOf(aceItemSectors, adaptationSector)>=0}">
					<c:set var="adaptationSectorMustBeChecked" value="true" />
				</c:if>
				<c:choose>
					<c:when test="${adaptationSectorMustBeChecked}">
						<input type="checkbox" name="chk_sectors_${adaptationSector}" id="chk_sectors_${adaptationSector}" value="${adaptationSector}" checked="checked" />
					</c:when>
					<c:otherwise>
						<input type="checkbox" name="chk_sectors_${adaptationSector}" id="chk_sectors_${adaptationSector}" value="${adaptationSector}" />
					</c:otherwise>
				</c:choose>
				<label for="chk_sectors_${adaptationSector}"><liferay-ui:message key="acesearch-sectors-lbl-${adaptationSector}" /></label>
			</div>
		</c:forEach>
        <br />

		<b>Elements</b><br />
		<%-- note : i18n file should always be in sync with AceItemElement enum --%>
		<c:forEach var="adaptationElement" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemElement.values() %>" >
			<div class="check">
				<c:set var="adaptationElementMustBeChecked" value="false" />
				<c:set var="aceItemElements" value='<%= aceitem == null ? "" : aceitem.getElements_() %>' />
				<c:set var="adaptationElementMustBeChecked" value="false" />
				<c:if test="${fn:indexOf(aceItemElements, adaptationElement)>=0}">
					<c:set var="adaptationElementMustBeChecked" value="true" />
				</c:if>
				<c:choose>
					<c:when test="${adaptationElementMustBeChecked}">
						<input type="checkbox" name="chk_elements_${adaptationElement}" id="chk_elements_${adaptationElement}" value="${adaptationElement}" checked="checked" />
					</c:when>
					<c:otherwise>
						<input type="checkbox" name="chk_elements_${adaptationElement}" id="chk_elements_${adaptationElement}" value="${adaptationElement}" />
					</c:otherwise>
				</c:choose>
				<label for="chk_elements_${adaptationElement}"><liferay-ui:message key="acesearch-elements-lbl-${adaptationElement}" /></label>
			</div>
		</c:forEach>
       <br />

		<b>Climate Impacts</b><br />
		<%-- note : i18n file should always be in sync with AceItemClimateImpact enum --%>
		<c:forEach var="adaptationClimateImpact" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemClimateImpact.values() %>" >
			<div class="check">
				<c:set var="adaptationClimateImpactMustBeChecked" value="false" />
				<c:set var="aceItemClimateImpacts" value='<%= aceitem == null ? "" : aceitem.getClimateimpacts_() %>' />
				<c:set var="adaptationClimateImpactMustBeChecked" value="false" />
				<c:if test="${fn:indexOf(aceItemClimateImpacts, adaptationClimateImpact)>=0}">
					<c:set var="adaptationClimateImpactMustBeChecked" value="true" />
				</c:if>
				<c:choose>
					<c:when test="${adaptationClimateImpactMustBeChecked}">
						<input type="checkbox" name="chk_climateimpacts_${adaptationClimateImpact}" id="chk_climateimpacts_${adaptationClimateImpact}" value="${adaptationClimateImpact}" checked="checked" />
					</c:when>
					<c:otherwise>
						<input type="checkbox" name="chk_climateimpacts_${adaptationClimateImpact}" id="chk_climateimpacts_${adaptationClimateImpact}" value="${adaptationClimateImpact}" />
					</c:otherwise>
				</c:choose>
				<label for="chk_climateimpacts_${adaptationClimateImpact}"><liferay-ui:message key="aceitem-climateimpacts-lbl-${adaptationClimateImpact}" /></label>
			</div>
		</c:forEach>
       <br />
	  </div>

		<!--  a u i :input name="startdate" / >

		< a u  i:input name="enddate" / >

		< a u i  :input name="publicationdate" / -->
	</aui:fieldset>
	<b>Countries&nbsp; &nbsp; &nbsp;
	<span id='all_countries'><a href="Javascript:checkallcountries();">check all</a></span>&nbsp; &nbsp; &nbsp;
	<span id='no_countries'><a href="Javascript:uncheckallcountries();">check none</a></span></b><br />
	<table width="100%" border="0">
	<tr><td width="70">
	    <%-- note : i18n file should always be in sync with AceItemCountry enum --%>
		<c:set var="i_country" value="0" />
		<c:forEach var="countryElement" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemCountry.values() %>" >
			<!--  div class="check" -->
				<c:set var="countryElementMustBeChecked" value="false" />
				<c:set var="aceItemCountries" value='<%= aceitem == null ? "" : aceitem.getSpatialValues() %>' />
				<c:if test="${fn:indexOf(aceItemCountries, countryElement)>=0}">
					<c:set var="countryElementMustBeChecked" value="true" />
				</c:if>
				<c:choose>
					<c:when test="${countryElementMustBeChecked}">
						<input type="checkbox" name="chk_countries_${countryElement}" id="chk_countries_${countryElement}" value="${countryElement}" checked="checked" />
					</c:when>
					<c:otherwise>
						<input type="checkbox" name="chk_countries_${countryElement}" id="chk_countries_${countryElement}" value="${countryElement}" />
					</c:otherwise>
				</c:choose>
				<c:set var="i_country" value="${i_country + 1}" />
				<label for="chk_countries_${countryElement}"><liferay-ui:message key="acesearch-country-lbl-${countryElement}" /></label>
				</td>
			<!--  /div -->
			    <c:if test="${i_country==8}">
			       </tr><tr>
					<c:set var="i_country" value="0" />
				</c:if>
				<td width="70">
		</c:forEach>
	</td></tr>
	</table>
	<br />

    <b>Comments about this database item <i>[information entered below will not be displayed on the public pages of climate-adapt]</i></b><br />
	<textarea style="border-color: blue; border-style: solid; border-width: thin;" name="comments" rows=10 cols=150><%= aceitem == null ? "" : aceitem.getComments() %></textarea><br /><br />

<% if (renderRequest.isUserInRole("Portal Content Reviewer") || renderRequest.isUserInRole("administrator") )  { // || renderRequest.isUserInRole("Power User")) { %>
	<input type="checkbox" name="chk_importance" id="chk_importance" value="1" <% if ((aceitem != null) && (aceitem.getImportance() == 1) ) { out.print( "checked" ) ; } %> />
	<b>High importance</b>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;

	<input type="checkbox" name="chk_controlstatus" id="chk_controlstatus" value="<%= ACEIndexUtil.Status_APPROVED %>" <% if ((renderRequest.isUserInRole("Portal Content Reviewer") || renderRequest.isUserInRole("administrator")) && (aceitem != null) && (aceitem.getControlstatus() == ACEIndexUtil.Status_APPROVED) ) { out.print( "checked" ) ; } %> />
	<b>Approved</b>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;

	<b>Edited by: <% if (aceitem != null) { out.print( aceitem.getModerator() ) ; } %> </b>
	<br /><br />
	<aui:button-row>
		<aui:button type="submit" onClick="return saveData();"/>

		<aui:button type="cancel"  onClick="history.go(-1);" /> <!-- onClick="< %= redirect % >" -->
	</aui:button-row>
<% }
  else  {
     if(renderRequest.isUserInRole("Power User")) { %>
		<b>Edited by: <% if (aceitem != null) { out.print( aceitem.getModerator() ) ; } %> </b>
		<br />
<% 	 } %>
	<input type="hidden" name="chk_controlstatus" id="chk_controlstatus" value=<% out.print( ((aceitem != null) && (aceitem.getControlstatus() == ACEIndexUtil.Status_SUBMITTED)) ? "" + ACEIndexUtil.Status_SUBMITTED : "" + ACEIndexUtil.Status_DRAFT ) ;%> />
	<input type="hidden" name="notify_status" id="notify_status" value="1" />
	<aui:button-row>
		<input value="Save as draft" type="button" onClick="document.getElementById('chk_controlstatus').value=<% out.print("" + ACEIndexUtil.Status_DRAFT); %>; document._aceitemportlet_WAR_AceItemportlet_fm.submit();" />

		<input value="Submit for publication" type="button" onClick="document.getElementById('chk_controlstatus').value=<% out.print("" + ACEIndexUtil.Status_SUBMITTED); %>; document._aceitemportlet_WAR_AceItemportlet_fm.submit();" />

		<input value="Cancel" type="button"  onClick="history.go(-1);" /> <!-- onClick="< %= redirect % >" -->
	</aui:button-row>
<% } %>
</aui:form>
