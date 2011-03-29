<%@include file="/html/init.jsp" %>
<%
	Measure measure = null;

	long measureId = ParamUtil.getLong(request, "measureId");

	if (measureId > 0) {
		measure = MeasureLocalServiceUtil.getMeasure(measureId);
	}

	String redirect = ParamUtil.getString(request, "redirect");
%>

<liferay-ui:header
	backURL="<%= redirect %>"
	title='<%= (measure != null) ? measure.getName() : "new-measure" %>'
/>


<aui:model-context bean="<%= measure %>" model="<%= Measure.class %>" />

<portlet:actionURL name='<%= measure == null ? "addMeasure" : "updateMeasure" %>' var="editMeasureURL" />

<aui:form action="<%= editMeasureURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />

		<aui:input type="hidden" name="measureId" value='<%= measure == null ? "" : measure.getMeasureId() %>'/>

		<liferay-ui:error key="measurename-required" message="measurename-required" />
		<aui:input name="name" />

		<b>description</b><br />
		<textarea name="description" rows=10 cols=100><%= measure == null ? "" : measure.getDescription() %></textarea>
		<br /><br />
				
		<b>implementationtype</b><br />
		<textarea name="implementationtype" rows=10 cols=100><%= measure == null ? "" : measure.getImplementationtype() %></textarea>
		
		<aui:input name="implementationtime" />
		
		<aui:input name="lifetime" />
		
		<aui:input name="spatiallayer"  />
		
		<aui:input name="spatialvalues"  />

		<b>legal aspects</b><br />
		<textarea name="legalaspects" rows=10 cols=100><%= measure == null ? "" : measure.getLegalaspects() %></textarea>
		<br /><br />

		<b>stakeholder participation</b><br />
		<textarea name="stakeholderparticipation" rows=10 cols=100><%= measure == null ? "" : measure.getStakeholderparticipation() %></textarea>
		<br /><br />

		<b>contact</b><br />
		<textarea name="contact" rows=10 cols=100><%= measure == null ? "" : measure.getContact() %></textarea>
		<br /><br />

		<b>succes limitations</b><br />
		<textarea name="succeslimitations" rows=10 cols=100><%= measure == null ? "" : measure.getSucceslimitations() %></textarea>

		<aui:input name="website"  />	
		
		<b>cost / benefit</b><br />
		<textarea name="costbenefit" rows=10 cols=100><%= measure == null ? "" : measure.getCostbenefit() %></textarea>
		<br /><br />
		
		<aui:input name="keywords"  />	
		
		<aui:input name="language"  />	

		<b>Sectors</b><br />
		<input name="sectors_" type="text" size="65" value="<%= measure == null ? "" : measure.getSectors_() %>">
		<br /><br />
		
		<b>Elements</b><br />
		<input name="elements_" type="text" size="65" value="<%= measure == null ? "" : measure.getElements_() %>">
		<br /><br />
		
		<b>Climate Impacts</b><br />
		<input name="climateimpacts_" type="text" size="65" value="<%= measure == null ? "" : measure.getClimateimpacts_() %>"><br /><br />
		
		<b>M (measure) or A (action)</b><br />
		<input name="mao_type" type="text" size="5" value="<%= measure == null ? "" : measure.getMao_type() %>"><br /><br />
		
		<!--  a u i :input name="startdate" / >
		
		< a u  i:input name="enddate" / >
		
		< a u i  :input name="publicationdate" / -->
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />

		<aui:button type="cancel"  onClick="<%= redirect %>" />
	</aui:button-row>
</aui:form>