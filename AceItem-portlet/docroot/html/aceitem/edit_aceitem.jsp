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

		<aui:input type="hidden" name="aceItemId" value='<%= aceitem == null ? "" : aceitem.getAceItemId() %>'/>
		
		<b>nasId</b><br />	
		<input name="nasId" type="text" size="10" READONLY style="color:grey" value="<%= aceitem == null ? "0" : aceitem.getNasId() %>"><br /><br />

		<b>name</b><br />	
		<input name="name" type="text" size="120" value="<%= aceitem == null ? "" : aceitem.getName() %>"><br /><br />

		<b>description</b><br />
		<textarea name="description" rows=10 cols=100><%= aceitem == null ? "" : aceitem.getDescription() %></textarea>
		
		<liferay-ui:error key="aceitemdatatype-required" message="aceitemdatatype-required" />		
		<aui:input name="datatype" />
		
		<liferay-ui:error key="aceitemstoredat-required" message="aceitemstoredat-required" />
		<b>website</b><br />	
		<input name="storedAt" type="text" size="120" value="<%= aceitem == null ? "" : aceitem.getStoredAt() %>"><br /><br />
		
		<b>storagetype</b><br />	
		<input name="storagetype" type="text" size="65" READONLY style="color:grey" value="<%= aceitem == null ? "URL" : aceitem.getStoragetype() %>"><br /><br />

		<b>Sectors</b><br />
		<!--   input name="sectors_" type="text" size="65" value="< %= aceitem == null ? "" : aceitem.getSectors_() % >"><br /><br / -->
		
       <%-- note : i18n file should always be in sync with AceItemSector enum --%>	
		<c:forEach var="adaptationSector" items="<%= nl.wur.alterra.cgi.ace.model.impl.AceItemSector.values() %>" >
			<div class="check">
				<c:set var="aceItemSectors" value="<%= aceitem == null ? "" : aceitem.getSectors_() %>" />
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
		<c:forEach var="adaptationElement" items="<%= nl.wur.alterra.cgi.ace.model.impl.AceItemElement.values() %>" >
			<div class="check">
				<c:set var="adaptationElementMustBeChecked" value="false" />
				<c:set var="aceItemElements" value="<%= aceitem == null ? "" : aceitem.getElements_() %>" />
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
		<c:forEach var="adaptationClimateImpact" items="<%= nl.wur.alterra.cgi.ace.model.impl.AceItemClimateImpact.values() %>" >
			<div class="check">
				<c:set var="adaptationClimateImpactMustBeChecked" value="false" />
				<c:set var="aceItemClimateImpacts" value="<%= aceitem == null ? "" : aceitem.getClimateimpacts_() %>" />
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
       		
		<b>textsearch</b><br />
		<textarea name="textSearch" rows=15 cols=100><%= aceitem == null ? "" : aceitem.getTextSearch() %></textarea>
		
		<b>keyword</b><br />	
		<input name="keyword" type="text" size="120" value="<%= aceitem == null ? "" : aceitem.getKeyword() %>"><br /><br />
		
		<b>spatialLayer</b><br />	
		<input name="spatialLayer" type="text" size="120" value="<%= aceitem == null ? "" : aceitem.getSpatialLayer() %>"><br /><br />
		
		<b>spatialValues</b><br />	
		<input name="spatialValues" type="text" size="120" value="<%= aceitem == null ? "" : aceitem.getSpatialValues() %>"><br /><br />
		
		<!--  a u i :input name="startdate" / >
		
		< a u  i:input name="enddate" / >
		
		< a u i  :input name="publicationdate" / -->
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />

		<aui:button type="cancel"  onClick="<%= redirect %>" />
	</aui:button-row>
</aui:form>