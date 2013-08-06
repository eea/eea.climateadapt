<%@include file="/html/init.jsp" %>
<%
	String sharetype = prefs.getValue(Constants.SHARETYPE, AceItemType.DOCUMENT.toString());
	
	String typedescription = "";

	AceItem aceitem = null;
	
	long aceItemId = ParamUtil.getLong(request, "aceItemId");
	
	
	// look for request attribute because this might be the result of edit
		if (aceItemId == 0)
		{
			Long aceitem_id;
			if (request.getAttribute("aceitemId") != null)
			{
			    aceitem_id = (Long) request.getAttribute("aceitemId");
			    aceItemId = aceitem_id.longValue();
			}
		}
	
	String moderator = "";
	
	String literal = "a ";
	
	String justSaved = null;
	
	String aceitemType = null;
	
	String newModerator = user.getFullName() + " (" + user.getEmailAddress() + ")" ; 

	if (sharetype.equalsIgnoreCase(AceItemType.DOCUMENT.toString())) {
	   typedescription = "publication and reports";  
	   aceitemType = "Publication and Reports";
	}
	else if (sharetype.equalsIgnoreCase(AceItemType.INFORMATIONSOURCE.toString())) {
	   typedescription = "information portal";
	   literal = "an ";
	   aceitemType = "Information Portal";
	}
	else if (sharetype.equalsIgnoreCase(AceItemType.GUIDANCE.toString())) {
	   typedescription = "Guidance Document";  
	   aceitemType = typedescription;
	}
	else if (sharetype.equalsIgnoreCase(AceItemType.TOOL.toString())) {
	   typedescription = "tool";  
	   aceitemType = "Tools";
	}
	else if (sharetype.equalsIgnoreCase(AceItemType.ORGANISATION.toString())) {
	   typedescription = "organisation";
	   literal = "an "; 
	   aceitemType = "Organisation";
	}	

	if (aceItemId > 0) {
		
		try {
			aceitem = AceItemLocalServiceUtil.getAceItem(aceItemId);
			moderator = aceitem.getModerator();
		}
		catch(Exception e) {
			aceItemId = 0;
			aceitem = null;
		}
	}
	
	
	if ( ! renderRequest.isUserInRole("user") ) { 
%>
		Please <a href='/home?p_p_id=58&p_p_lifecycle=0&p_p_state=maximized&p_p_mode=view&saveLastPath=0&_58_struts_action=%2Flogin%2Flogin'>sign in with your EIONET account</a> to add  <%= literal %><%= typedescription %>.
<% }	
 else  if ( (aceitem != null)
		     && 
		     ((moderator.indexOf(newModerator) == -1 ) || (aceitem.getControlstatus() >= ACEIndexUtil.Status_APPROVED) ) 
		    ) { 

		out.print("You are not allowed to edit the " + typedescription + " <b>" + '"' + aceitem.getName() + '"' + "</b>" + 
				( moderator.indexOf(newModerator) > -1 ? " for it has already been approved." : "." ) );
 }
 else {

		String redirect = ParamUtil.getString(request, "redirect");
		
		if(aceitem==null) {
			typedescription = "Add " + literal + typedescription ;
		}
		else {
			typedescription = "Edit the " + typedescription ;
		}
		
		// get the justSaved status
		if (request.getAttribute("justsaved") != null)
		{
				justSaved = (String) request.getAttribute("justsaved");
		}
	
%>

    <!-- ==================== -->
	<!-- FOR WYSIWYG :: Begin -->
	<!-- ==================== -->
	
	<script src="http://tinymce.cachefly.net/4.0/tinymce.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/jquery.dualListBox-1.3.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/jquery.dualListBox-1.3.min.js" type="text/javascript"></script>
	<!-- ================== -->
	<!-- FOR WYSIWYG :: End -->
	<!-- ================== -->
	
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
		    %>}
		    
		    
		    
		    
		    function submitform(saveType)
			{
				if (saveType == 'save')
				{
				    document.<portlet:namespace />fm.chk_controlstatus.value = "-1";
				}
				else
				{
					// it must be submit
					if (document.<portlet:namespace />fm.chk_controlstatus_for_approved != null && document.<portlet:namespace />fm.chk_controlstatus_for_approved.checked)
				    {
					   document.<portlet:namespace />fm.chk_controlstatus.value = "1";
				    }
					else
					{
						 document.<portlet:namespace />fm.chk_controlstatus.value = "0";
					}
				}
			
				
				var geoCharsValue = {"geoElements":{"element":"","macrotrans":[],"biotrans":[],"countries":[],"subnational":[],"city":""}};
				geoCharsValue.geoElements.element = $('input:radio[name=rad_geo_chars]:checked').val();
				
	         
				if (geoCharsValue.geoElements.element == 'EUROPE')
				{
					
				       // subnational selected
					   ctr = 0;
					   $('#subnationals_selected').children('option').each(function() {
					       geoCharsValue.geoElements.subnational[ctr] = $(this).val();
					       ctr ++;
					   });
					 
					   //alert("city value is " + $('.shared_form_city').val());
					   // if city selected
					   if (typeof $('.shared_form_city').val() != undefined)
					   {
						   geoCharsValue.geoElements.city = $('.shared_form_city').val();
					   }
					   
					 
					   // macro transnational
					   ctr = 0;
					   $('#trans_macro_nationals option:selected').each(function(){
					    	geoCharsValue.geoElements.macrotrans[ctr] = $(this).val();
					    	ctr ++
					   });
					   
					   // biographical region selected
					   ctr = 0;
	                   $('#trans_bio_nationals option:selected').each(function(){
					    	   geoCharsValue.geoElements.biotrans[ctr] = $(this).val();
					    	   ctr ++
					   });
	                   
	                   // countries selected
	                   ctr = 0;
	                   $('.chk_countries_geochars:checked').each(function(){
					    	   geoCharsValue.geoElements.countries[ctr] = $(this).val();
					    	   ctr ++
					   });
	                   
				}
				
			   var result = JSON.stringify(geoCharsValue);
			   
			   $('input:radio[name=rad_geo_chars]:checked').val(result);
			   document.<portlet:namespace />fm.submit();
			}
		    
		   
</script>

<liferay-ui:header backURL='<%= redirect %>' title='<%= typedescription %>' />

<aui:model-context bean="<%= aceitem %>" model="<%= AceItem.class %>" />

<portlet:actionURL name='<%= aceitem == null ? "addAceItem" : "updateAceItem" %>' var="editAceItemURL" />

<aui:form action='<%= editAceItemURL %>' method="POST" name="fm">
   <liferay-ui:error key="invalid-form-data" message="The form has errors please correct them" />
	<aui:fieldset>

	    <input name="datatype" type="hidden" value="<%=sharetype%>">
	    
	    <input name="storagetype" type="hidden" value="URL">

		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />

		<aui:input type="hidden" name="aceItemId" value='<%= aceitem == null ? "" : aceitem.getAceItemId() %>'/>

		<aui:input type="hidden" name="wxsharvesterId" value='<%= aceitem == null ? "" : aceitem.getWxsharvesterId() %>'/>
		
		<input type="hidden" name="chk_controlstatus" id="chk_controlstatus" value="" />
		
		<div id="wrapper">
		
		<div id="case-studies-form-wrapper">

		<!-- =========================== -->
		<!-- Portlet Content Starts Here -->
		<!-- =========================== -->
		<div class="case-studies-tabs-wrapper">
		
		<div class="case-studies-tabs">
					<ul>
					   <% 
						 if (justSaved == null)
						 { %>
							<li class="active"><a href="#">Item Description</a></li> 
						   <% } else {
						 %>
						    <li class="#"><a href="#">Item Description</a></li>
						<% } %>
						<li><a href="#">Reference Information</a></li>
						<li><a href="#">Geographic Information</a></li>
						
						<%
						   if (aceitem != null) { 
						    if (justSaved != null) {%>
						       <li class="active"><a href="#">Review &amp; Submit</a></li>
						    <%} else { %>
						       <li><a href="#">Review &amp; Submit</a></li>
						  <% } // end of else
						   } // end of aceitem != null
					   %>
					</ul>
		</div>
		
		
<% if (aceitem != null) { %>
		<liferay-ui:error key="aceitem-changed" message="aceitem-changed" />
		<aui:input type="hidden" name="checkcreationdate" value='<%= aceitem.getCreationdate().getTime() %>'/>
<% } %>

      <div class="case-studies-tabbed-content">
         <ul>
               <% if (justSaved != null) { %>
						<li>
						<% } else { %>
				 <li class="active">
						<% } %>
							<div class="case-studies-tabbed-content-header"><%=aceitemType %> - <em>Description</em></div>
							<p>To help other people find and use this <%=aceitemType.toLowerCase() %>, please provide as much detail as possible about this <%=aceitemType %>. We will e-mail you after we review the <%=aceitemType %>.</p>
							<p><a href="#">More About the Review Process</a></p>

                           <% if (renderRequest.isUserInRole("Portal Content Reviewer") || renderRequest.isUserInRole("administrator") ) {  %>
							<div class="case-studies-tabbed-content-section">
								<div class="case-studies-tabbed-content-subheader">Content Administrator Area</div>
								<ul>
									
									    <!-- approved check box -->
									    <!-- show only if it was submitted -->
										 <% 
										     // show the approved checkbox only if the user is reviewer or administrator
										  String checked = "";
										  if (aceitem != null && aceitem.getControlstatus() >= ACEIndexUtil.Status_SUBMITTED && (renderRequest.isUserInRole("Portal Content Reviewer") || renderRequest.isUserInRole("administrator")) )
										  { 
										
											  if (aceitem.getControlstatus() == ACEIndexUtil.Status_APPROVED)
											  {
													  checked = "checked";
											  }
										      else if (renderRequest.getParameter("chk_controlstatus_for_approved") != null)
										      {
											          checked = "checked";
										      }
										
												  
											  pageContext.setAttribute("checked", checked);
										  
									      %>
											  
								           <li>
	                                         <input type="checkbox" name="chk_controlstatus_for_approved" id="chk_controlstatus_for_approved" value="1" ${checked} />
	                                                                     
	                                         Approved &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
	                                       </li>
		                               <% } %>
									  <!-- end of approved check box -->
									  
								<li>
									  <p><strong><em>Featured <%=aceitemType %>:</em></strong></p>
									  
									  <%
									      String feature = "";
									      if (aceitem != null && Validator.isNotNull(aceitem.getFeature()))
									      {
									    	  feature = "checked";
									      }
									      else if (Validator.isNotNull(renderRequest.getParameter("feature")))
									      {
									    	 feature = "checked";  
									      }
									      
									  %>
									  <input type="checkbox" name="feature" id="chk_adaptation_feature" value="CASE_SEARCH" <%=feature %>/>
									  <label for="Feature this on <%=aceitemType %> search results page">Feature this on <%=aceitemType %> search results page</label>
														
									
										<br /><br />
										<p><em>Content Administration Comments:</em> (500 character limit)</p> 
										<%
										    String adminComment = "";
										    if (aceitem != null && Validator.isNotNull(aceitem.getComments()))
										    {
										    	adminComment = aceitem.getComments(); 
										    }
										    else
										    {
										    	if (renderRequest.getParameter("comments") != null)
										    	{
										    		adminComment = renderRequest.getParameter("comments");
										    	}
										    }
										%>
									
										<textarea id="ta_caa_contact" cols="40" name="comments" rows="10" class="WYSIWYG" data-maxlength="500"><%= adminComment %></textarea>
										<div class="case-studies-character-count"></div>
										
										<% 
											// show the special tagging 
											String specialTagging = ""; 
										    if (aceitem != null && Validator.isNotNull(aceitem.getSpecialtagging()))
										    {
										    	specialTagging = aceitem.getSpecialtagging();
										    }
										    else
										    {
										    	if (renderRequest.getParameter("specialtagging") != null)
										    	{
										    		specialTagging = renderRequest.getParameter("specialtagging");
										    	}
										    }
										%>
											 
											 <br/>
	                                         <p><em>Special Tagging</em></p>
	                                      	 <input name="specialtagging" type="text" size="65" maxlength="75" value="<%= specialTagging %>"><br /><br />
                             </li>
           
                       </ul>
                    </div>
                   <% } %>
      
     <div class="case-studies-tabbed-content-section">
      <div class="case-studies-tabbed-content-subheader">Item Name</div>
        <liferay-ui:error key="aceitemname-required" message="Aceitem name required" />
        <ul>
	        <li>
				<p><strong><span class="red">*</span> <em>Item Name (50 character limit)</em></strong></p>
				<input name="name" type="text" size="75" maxlength="50" value='<%= aceitem == null ? renderRequest.getParameter("name") == null ? "" : renderRequest.getParameter("name") : aceitem.getName() %>'><br /><br />
			</li>
		</ul>
	 </div>
	 
	  <div class="case-studies-tabbed-content-section">
	   <div class="case-studies-tabbed-content-subheader">Item Description</div>
	      <liferay-ui:error key="aceitemdescription-required" message="Aceitem description required" />
	   <ul>
		    <li>
				<p><strong><span class="red">*</span> <em>Provide a description of the item. (5,000 character limit)</em></strong></p>
				<textarea id="descriptionId" name="description" cols="40" rows="10" class="WYSIWYG" data-maxlength="5000"><%= aceitem == null ? renderRequest.getParameter("description") == null ? "" : renderRequest.getParameter("description") : aceitem.getDescription() %></textarea>
				<div class="case-studies-character-count"></div>
			</li>
	   </ul>
	  </div>
	  
	 
	<div class="case-studies-tabbed-content-section">
	    <div class="case-studies-tabbed-content-subheader">Keywords</div>
	      <liferay-ui:error key="aceitemkeywords-required" message="Aceitem keywords required" />
	   <ul>
	     <li>
            <p><strong><span class="red">*</span> <em>Describe and tag this item with relevant keywords. Separate each keyword with a comma. For example, example keyword 1, example keyword 2 (1,000 character limit)</em></strong></p>
		    <textarea id="keywordId" name="keyword" cols="40" rows="10" class="WYSIWYG" data-maxlength="1000"><%= aceitem == null ? renderRequest.getParameter("keyword") == null ? "" :renderRequest.getParameter("keyword") : aceitem.getKeyword() %></textarea>
		    <div class="case-studies-character-count"></div>
		 </li>
	  </ul>
   </div>
	  
	  
	 <div class="case-studies-tabbed-content-section">
	      <div class="case-studies-tabbed-content-subheader">Policy Sectors</div>
	      <liferay-ui:error key="aceitem_sectors-required" message="Aceitem sectors required" />
	       <ul>
	        <li>
	        <p><strong><span class="red">*</span> <em>Select one or more relevant sector policies that this item relates to.</em></strong></p>
		     <ul class="three-col">
			<!--   input name="sectors_" type="text" size="65" value="< %= aceitem == null ? "" : aceitem.getSectors_() % >"><br /><br / -->
			 <%
				         String choosensectors = "";
				         if (aceitem == null )
				         {
				        	
				        	  for (nl.wur.alterra.cgi.ace.model.constants.AceItemSector aceitemsector : nl.wur.alterra.cgi.ace.model.constants.AceItemSector.values()) {

				                  if (ParamUtil.getString(request, "sectors_" + aceitemsector.toString()) != null) {
				                      String s = ParamUtil.getString(request, "sectors_" + aceitemsector.toString());
				                      if (s.equalsIgnoreCase(aceitemsector.toString())) {
				                          choosensectors += aceitemsector.toString() + ";";
				                      }
				                  }
				              }
				        	
				         }
				%>
				
		       <%-- note : i18n file should always be in sync with AceItemSector enum --%>	
				<c:forEach var="adaptationSector" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemSector.values() %>" >
					<div class="check">
						<c:set var="aceItemSectors" value='<%= aceitem == null ? choosensectors : aceitem.getSectors_() %>' />
						<c:set var="adaptationSectorMustBeChecked" value="false" />
						<c:if test="${fn:indexOf(aceItemSectors, adaptationSector)>=0}">
							<c:set var="adaptationSectorMustBeChecked" value="true" />
						</c:if>	
						<c:choose>
							<c:when test="${adaptationSectorMustBeChecked}">
								<li><label for="sectors_${adaptationSector}"><input type="checkbox" name="sectors_${adaptationSector}" id="chk_sectors_${adaptationSector}" value="${adaptationSector}" checked="checked" /><liferay-ui:message key="acesearch-sectors-lbl-${adaptationSector}" /></label></li>
							</c:when>
							<c:otherwise>
								<li><label for="sectors_${adaptationSector}"><input type="checkbox" name="sectors_${adaptationSector}" id="chk_sectors_${adaptationSector}" value="${adaptationSector}" /><liferay-ui:message key="acesearch-sectors-lbl-${adaptationSector}" /></label></li>
							</c:otherwise>
						</c:choose>
					</div>							
				</c:forEach>
		    </ul>
		   </li>
		   </ul>
	   </div>
	   <div class="case-studies-form-clearing"></div>
   <br/>	
   <div class="case-studies-tabbed-content-section">
      <div class="case-studies-tabbed-content-subheader">Climate Impacts</div>
      <liferay-ui:error key="aceitem_climate_impacts-required" message="Aceitem climate impacts required" />
	  <ul>
	    <%
	       String choosenclimateimpacts = "";
	       if (aceitem == null)
	       {
	    	   for (nl.wur.alterra.cgi.ace.model.constants.AceItemClimateImpact aceitemclimateimpact : nl.wur.alterra.cgi.ace.model.constants.AceItemClimateImpact.values()) {
	               if (ParamUtil.getString(request, "chk_climateimpacts_" + aceitemclimateimpact) != null) {
	                   String e = ParamUtil.getString(request, "chk_climateimpacts_" + aceitemclimateimpact);
	                   if (e.equalsIgnoreCase(aceitemclimateimpact.toString())) {
	                       choosenclimateimpacts += aceitemclimateimpact.toString() + ";";
	                   }
	               }
	           }
	       }
	    
	    %>
	  
	    <li>
	     <p><strong><span class="red">*</span> <em>Select one or more climate change impact topics that this item relates to.</em></strong></p>
	     <ul class="three-col">
		<%-- note : i18n file should always be in sync with AceItemClimateImpact enum --%>
		<c:forEach var="adaptationClimateImpact" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemClimateImpact.values() %>" >
			<div class="check">
				<c:set var="adaptationClimateImpactMustBeChecked" value="false" />
				<c:set var="aceItemClimateImpacts" value='<%= aceitem == null ? choosenclimateimpacts : aceitem.getClimateimpacts_() %>' />
				<c:set var="adaptationClimateImpactMustBeChecked" value="false" />
				<c:if test="${fn:indexOf(aceItemClimateImpacts, adaptationClimateImpact)>=0}">
					<c:set var="adaptationClimateImpactMustBeChecked" value="true" />
				</c:if>	
				<c:choose>
					<c:when test="${adaptationClimateImpactMustBeChecked}">
						<li><label for="aceitem-climateimpacts-lbl-${adaptationClimateImpact}"><input type="checkbox" name="chk_climateimpacts_${adaptationClimateImpact}" id="chk_climateimpacts_${adaptationClimateImpact}" value="${adaptationClimateImpact}" checked="checked" /><liferay-ui:message key="aceitem-climateimpacts-lbl-${adaptationClimateImpact}" /></label></li>
					</c:when>
					<c:otherwise>
						<li><label for="aceitem-climateimpacts-lbl-${adaptationClimateImpact}"><input type="checkbox" name="chk_climateimpacts_${adaptationClimateImpact}" id="chk_climateimpacts_${adaptationClimateImpact}" value="${adaptationClimateImpact}" /><liferay-ui:message key="aceitem-climateimpacts-lbl-${adaptationClimateImpact}" /></label></li>
					</c:otherwise>
				</c:choose>
			</div>							
		</c:forEach>
       </ul>
       </li>
       </ul>
    </div>
    <div class="case-studies-form-clearing"></div>
    <br/>
    
    <% if (! aceitemType.equalsIgnoreCase("organisation")) { %>
     <div class="case-studies-tabbed-content-section"> 
        <div class="case-studies-tabbed-content-subheader">Year</div>
         <liferay-ui:error key="year-required" message="Enter correct value for year or leave blank" />
		   <ul>
			   <li>
			       <p><strong><em>Date of publication/release/update of the item</em></strong></p>
				   <input name="year" type="text" size="5" maxlength="4" value="<%= aceitem == null ? renderRequest.getParameter("year") == null ? "":renderRequest.getParameter("year")  : aceitem.getYear() %>" /><br /><br />
			   </li>
		   </ul>
     </div>
     <% } %>
     
     <div class="case-studies-tabbed-content-button-row">
			<a href="#" class="case-studies-tabbed-content-button-green" onClick="submitform('save')">Save as Draft</a>
			<a href="#" class="case-studies-tabbed-content-button-green case-studies-tabbed-content-button-next">Reference Information</a>
	</div>
    
 </li>
	  
	<li>
	  <div class="case-studies-tabbed-content-header"><em>Reference Information</em></div>	
	  <br/>
	  <div class="case-studies-tabbed-content-section">
	   <div class="case-studies-tabbed-content-subheader">Website</div>
		<liferay-ui:error key="aceitemstoredat-required" message="aceitemstoredat-required" />
	   <ul>
	    <li>	
	        <p><strong><em>List the Name and Website where the item can be found or is described. (500 character limit).</em></strong></p>
			<textarea id="storeAtId" name="storedAt" cols="40" rows="10" class="WYSIWYG" data-maxlength="500"><%= aceitem == null ? renderRequest.getParameter("storedAt") == null ? "":renderRequest.getParameter("storedAt") : aceitem.getStoredAt() %></textarea>
			<div class="case-studies-character-count"></div>
		</li>
	   </ul>
	  </div>
	  
	 <div class="case-studies-tabbed-content-section">
	  <div class="case-studies-tabbed-content-subheader">Source</div>
	   <ul>
	     <li>
	        <p><strong><em>Describe the original source of the item description (250 character limit)</em></strong></p>
		    <textarea id="aceItemStore" name="source" cols="40" rows="10" class="WYSIWYG" data-maxlength="500"><%= aceitem == null ? renderRequest.getParameter("source") == null ? "":renderRequest.getParameter("source") : aceitem.getSource() %></textarea>
		    <div class="case-studies-character-count"></div>
		 </li>
	   </ul>
	 </div>
		<div class="case-studies-tabbed-content-button-row">
		        <a href="#" class="case-studies-tabbed-content-button-green case-studies-tabbed-content-button-previous case-studies-tabbed-content-float-left">Back To Item Description</a>
				<a href="#" class="case-studies-tabbed-content-button-green" onClick="submitform('save')">Save as Draft</a>
				<a href="#" class="case-studies-tabbed-content-button-green case-studies-tabbed-content-button-next">Geographic Information</a>
		</div>
   </li>
		

	<li>
	<div class="case-studies-tabbed-content-header">Geographic Information</div>
	 <br/>
	 <div class="case-studies-tabbed-content-section"> 
	   <div class="case-studies-tabbed-content-subheader">Geographic Characterization</div>
	   <liferay-ui:error key="geo-characterization-required" message="Geo Characterization Required" />
	   <ul>
			<li>
				<p><em>Select the characterization for this case study</em></p>
        <ul class="one-col">
										   <%
										        ArrayList subnationalRegions = new ArrayList();
										        ArrayList transMacroElements = new ArrayList();
										        ArrayList transBioElements = new ArrayList();
										        
										        // get the subnational elements and store it in page context
										        for (nl.wur.alterra.cgi.ace.model.constants.AceItemGeoChars geoCharElement : nl.wur.alterra.cgi.ace.model.constants.AceItemGeoChars.values()) 
										        {
										        	
										        	if (geoCharElement.toString().contains("SUBN_"))
										        	{
										        		subnationalRegions.add(geoCharElement);
										        	}
										        	else if (geoCharElement.toString().contains("TRANS_MACRO"))
										        	{
										        		transMacroElements.add(geoCharElement.toString());
										        	}
										        	else if (geoCharElement.toString().contains("TRANS_BIO"))
										        	{
										        		transBioElements.add(geoCharElement.toString());
										        	}
										        }
										        pageContext.setAttribute("subnationals", subnationalRegions);
										        pageContext.setAttribute("transmacro", transMacroElements);
										        pageContext.setAttribute("transbio", transBioElements);
										        
										        
										    
										        
										        String geoCharsStr = null;
										        if (aceitem != null)
										        {
										        	geoCharsStr = aceitem.getGeochars();
										        }
										        else if (renderRequest.getParameter("rad_geo_chars") != null)
										        {
										        	geoCharsStr = (String) renderRequest.getParameter("rad_geo_chars");
										        }
										        
										        String elementSelected = "";
										        ArrayList macroTransElements = new ArrayList();
										        ArrayList biographicalElements = new ArrayList();
										        ArrayList subNationalElements = new ArrayList();
										        ArrayList countryElements = new ArrayList();
										        String city = "";
										        
										        if (geoCharsStr != null )
										        {
										        	try {
											        	Object obj=JSONValue.parse(geoCharsStr);
														JSONObject jsonObject = (JSONObject) obj;
														JSONObject geoElements = (JSONObject) jsonObject.get("geoElements");
														elementSelected = (String) geoElements.get("element");
														
														JSONArray macroTransArray = (JSONArray) geoElements.get("macrotrans");
														
														for (int i = 0; i < macroTransArray.size(); i++ )
														{
														     macroTransElements.add(macroTransArray.get(i));
														}
														
		                                                JSONArray bioTransArray = (JSONArray) geoElements.get("biotrans");
														
														for (int i = 0; i < bioTransArray.size(); i++ )
														{
														     biographicalElements.add(bioTransArray.get(i));
														}
														
														JSONArray subNationalsArray = (JSONArray) geoElements.get("subnational");
															
													    for (int i = 0; i < subNationalsArray.size(); i++ )
													    {
															     subNationalElements.add(subNationalsArray.get(i));
														}
													    
													    JSONArray countriesArray = (JSONArray) geoElements.get("countries");
														
													    for (int i = 0; i < countriesArray.size(); i++ )
													    {
															     countryElements.add(countriesArray.get(i));
														}
													    
													    city = (String) geoElements.get("city");
										        	}
										        	catch(Exception e)
										        	{
										        		e.printStackTrace();
										        	}
										        }
										        
										        pageContext.setAttribute("geoElementSelected", elementSelected);
										        pageContext.setAttribute("macroTransSelected", macroTransElements);
										        pageContext.setAttribute("bioRegionSelected", biographicalElements);
										        pageContext.setAttribute("subNationalsSelected", subNationalElements);
										        pageContext.setAttribute("countriesSelected", countryElements);
										        pageContext.setAttribute("city", city);
										   %>
										   
										   <c:forEach var="geoCharElement" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemGeoChars.values() %>" >
											        <c:choose>
											            <c:when test="${geoCharElement == 'GLOBAL'}" >
											                <c:choose>
												                <c:when test="${geoElementSelected eq 'GLOBAL'}">
													             <li><label for="rad_geochars_${geoCharElement}"><input type="radio" name="rad_geo_chars" id="global_geo_chars" value="${geoCharElement}" checked/><liferay-ui:message key="acesearch-geochars-lbl-${geoCharElement}" /></label></li>
													            </c:when>
													            <c:otherwise>
													             <li><label for="rad_geochars_${geoCharElement}"><input type="radio" name="rad_geo_chars" id="global_geo_chars" value="${geoCharElement}" /><liferay-ui:message key="acesearch-geochars-lbl-${geoCharElement}" /></label></li>
													            </c:otherwise>
													       </c:choose>
										               </c:when>
										               
											           <c:when test="${geoCharElement == 'EUROPE'}" >
											                <c:choose>
												                <c:when test="${geoElementSelected eq 'EUROPE'}">
														             <li><label for="rad_geochars_${geoCharElement}"><input type="radio" name="rad_geo_chars" id="europe_geo_chars" value="${geoCharElement}"  checked/><liferay-ui:message key="acesearch-geochars-lbl-${geoCharElement}" /></label></li>
														        </c:when>
														        <c:otherwise>
														           <li><label for="rad_geochars_${geoCharElement}"><input type="radio" name="rad_geo_chars" id="europe_geo_chars" value="${geoCharElement}" /><liferay-ui:message key="acesearch-geochars-lbl-${geoCharElement}" /></label></li>
														        </c:otherwise>
														     </c:choose>
														          <div class="europe_geochar_class">	<!-- important - starting div for europe_geochar_class -->
										               </c:when>
										             
											           <c:when test="${geoCharElement == 'MACRO_TRANSNATIONAL_REGION'}" >
											               <label for="rad_geochars_${geoCharElement}"><strong><liferay-ui:message key="acesearch-geochars-lbl-${geoCharElement}" /></strong></label>
											               <table class="case-studies-tabbed-content-table-for-translists">
                                                             <tr>
                                                                <td width="45%">
													               <select id="trans_macro_nationals" style="height:150px;width:200px;" multiple>
													                  <c:forEach var="transMacroElement" items="${transmacro}" >
													                      <c:choose>
																	               <c:when test="${fn:contains(macroTransSelected, transMacroElement)}" >
																	                   <option value="${transMacroElement}" selected><liferay-ui:message key="acesearch-geochars-lbl-${transMacroElement}"/></option>												                  
																	               </c:when>
												               
																	               <c:otherwise>
																	                   <option value="${transMacroElement}"><liferay-ui:message key="acesearch-geochars-lbl-${transMacroElement}"/></option>		
																	               </c:otherwise>
											                              </c:choose>
													                  </c:forEach>
													               </select>
													            </td>
													          </tr>
													         </table>
													         <br/>
													    </c:when>
													    
												        <c:when test="${geoCharElement == 'BIOGRAPHICAL_REGION'}" >
												           <label for="rad_geochars_${geoCharElement}"><strong><liferay-ui:message key="acesearch-geochars-lbl-${geoCharElement}" /></strong></label>
											               
												           <table class="case-studies-tabbed-content-table-for-translists">
                                                           <tr>
												             <td width="45%">
												                   <select id="trans_bio_nationals" style="height:100px;width:200px;" multiple>
													                  <c:forEach var="transBioElement" items="${transbio}" >
													                      <c:choose>
																	               <c:when test="${fn:contains(bioRegionSelected, transBioElement)}" >
																	                   <option value="${transBioElement}" selected><liferay-ui:message key="acesearch-geochars-lbl-${transBioElement}"/></option>												                  
																	               </c:when>
												               
																	               <c:otherwise>
																	                   <option value="${transBioElement}"><liferay-ui:message key="acesearch-geochars-lbl-${transBioElement}"/></option>		
																	               </c:otherwise>
											                              </c:choose>
													                  </c:forEach>
													               </select>
												             </td>
												           </tr>
												          </table>
												          <br/>
										               </c:when>
										               
										              <c:when test="${geoCharElement ==  'COUNTRIES'}" >
										                    <label for="rad_geochars_${geoCharElement}"><strong><liferay-ui:message key="acesearch-geochars-lbl-${geoCharElement}" /></strong></label>
											               
															<ul>
																<li>
																	<p><em>Select one or more European Union countries covered by this case study</em></p>
																	<ul class="five-col">
																	
																		<c:forEach var="countryElement" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemCountry.values() %>" >
																		        
																		        <c:set var="countryElementMustBeChecked" value="false" />
																				<c:if test="${fn:contains(countriesSelected, countryElement)}">
																					<c:set var="countryElementMustBeChecked" value="true" />
																				</c:if>
																				
																				<c:choose>
																					<c:when test="${countryElementMustBeChecked}">
																						<li><label for="chk_countries_${countryElement}"><input type="checkbox" class="chk_countries_geochars" name="chk_countries_${countryElement}" id="chk_countries_${countryElement}" value="${countryElement}" checked="checked" /><liferay-ui:message key="acesearch-country-lbl-${countryElement}" /></label></li>
																					</c:when>
																					<c:otherwise>
																						<li><label for="chk_countries_${countryElement}"><input type="checkbox" class="chk_countries_geochars" name="chk_countries_${countryElement}" id="chk_countries_${countryElement}" value="${countryElement}" /><liferay-ui:message key="acesearch-country-lbl-${countryElement}" /></label></li>
																					</c:otherwise>
																				</c:choose>
																		</c:forEach>
																	</ul>
																</li>
															</ul>
										              </c:when>
										              
											           <c:when test="${geoCharElement == 'SUBNATIONAL'}" >
											               <label for="rad_geochars_${geoCharElement}"><strong><liferay-ui:message key="acesearch-geochars-lbl-${geoCharElement}" />:</strong></label>
											               <p>
											               <table class="case-studies-tabbed-content-table-for-lists">
                                                             <tr>
                                                                <td width="40%">
                                                                   Select applicable regions:
													               <select id="subnationals" multiple="multiple" style="height:300px;width:250px;">
													                  <c:forEach var="subNationalElement" items="${subnationals}" >
													                      <option value="${subNationalElement}">${subNationalElement.description}</option>
													                  </c:forEach>
													               </select>
													            </td>
												               
												             <td width="12%">
												                <button id="to2" type="button">&nbsp;>&nbsp;</button>
                                                                <button id="to1" type="button">&nbsp;<&nbsp;</button>
												             </td>
												            
												             <td width="40%">
												                   Your selections:
												                   <select id="subnationals_selected" multiple="multiple" style="height:300px;width:250px;">
												                     <c:forEach var="subNationalElement" items="${subnationals}" >
													                     <c:if test="${fn:contains(subNationalsSelected,subNationalElement) }">
														                      <option value="${subNationalElement}">${subNationalElement.description}</option>
														                 </c:if>
														             </c:forEach>
                                                                   </select>
												             </td>
												           </tr>
												          </table>
												          </p>
										               </c:when>
										               <c:when test="${geoCharElement == 'CITY'}" >
										                 <label for="rad_geochars_${geoCharElement}"><strong><liferay-ui:message key="acesearch-geochars-lbl-${geoCharElement}" /></strong></label>
										                 <span class="case-studies-tabbed-content-text-for-geochars"><input class="shared_form_city" type="text" size="50" maxlength="50" value="${city}" /></span>
										                 </div> <!-- important - closing div for europe_geochar_class -->
										               </c:when>
										               <c:otherwise>
										                 <!-- do nothing -->
										              </c:otherwise>
											        </c:choose>
										   </c:forEach>
										</ul>	
									</li>
								</ul>	
		   </div> 
		   
		   <div class="case-studies-tabbed-content-button-row">
							 
					<a href="#" class="case-studies-tabbed-content-button-green case-studies-tabbed-content-button-previous case-studies-tabbed-content-float-left">Back To Reference Information</a>
					<a href="#" class="case-studies-tabbed-content-button-green" onClick="submitform('save')">Save as Draft</a>
					<% if (aceitem != null) { %>
					   <a href="#" class="case-studies-tabbed-content-button-green case-studies-tabbed-content-button-next">Review &amp; Submit</a>
					<% } %>
		   </div>
		   
		</li>
	
	 <!-- REVIEW SECTION STARTS - show only if the form was already savedd -->
	 <% if (aceitem != null) { 
	   if (justSaved != null) {
	 %>
	     <li class="active">
	  <%} else { %>
			<li>
	<% } %>
     
		    <div class="case-studies-tabbed-content-header"><em>Review &amp; Submit for Review Process</em></div>	
			<p>Review the <%=aceitemType %> and submit the <%=aceitemType %> for <a href="#">review</a> for inclusion in the Climate- ADAPT Database. <strong>Note</strong> This preview page may appear slightly more narrow than the actual display. After this <%=aceitemType%> has been added to the database, the <%=aceitemType%> page will display slightly wider than it appears below.</p>

			  <div class="case-studies-tabbed-content-button-row">
					<a href="#" class="case-studies-tabbed-content-button-green case-studies-tabbed-content-button-previous case-studies-tabbed-content-float-left">Back To Geographical Information</a>
					<a href="#" class="case-studies-tabbed-content-button-green" onClick="submitform('submit')">Submit for Review Process</a>
			 </div>
			 <br><br>
			 
			 <div class="case-studies-tabbed-content-review-wrapper">
								<div class="case-studies-tabbed-content-review-column-left">
								     <div class="case-studies-tabbed-content-section">
										<p class="case-studies-tabbed-content-review-header"><%= aceitem.getName() %> (<%=aceitemType%>)</p>
										<p><%= aceitem.getDescription() %></p>
									</div>
						

									<div class="case-studies-form-clearing"></div>

									<div class="case-studies-tabbed-content-section">
										<ul>
											<!--  <li>
												<p><strong><em><%=aceitemType %> Description</em></strong></p>
												<ul class="case-studies-tabbed-content-bullted-list">
													<li><a href="#climate_impacts_anchor">Climate Impacts</a></li>
													<li><a href="#sector_policies_anchor">Sector Policies</a></li>
												</ul>
											</li> -->
											
											<li>
												<p><strong><em>Reference Information</em></strong></p>
												<ul class="case-studies-tabbed-content-bullted-list">
													<li><a href="#website_anchor">Websites</a></li>
												   <%  if (Validator.isNotNull(aceitem.getSource())) { %>
													<li><a href="#source_anchor">Source</a></li>
												  <% } %>
												</ul>
											</li>
										</ul>
										<div class="case-studies-form-clearing"></div>
									</div>

								

									<div class="case-studies-tabbed-content-section">
										<div class="case-studies-tabbed-content-subheader">Reference Information</div>
										<ul>
											<li>
												<a name="website_anchor"><strong><em>Websites</em></strong></a>
												<p><%=aceitem.getStoredAt() %></p>
												<div class="case-studies-form-clearing"></div>
											</li>
											
										<% if (Validator.isNotNull(aceitem.getSource()))
										   {%>	
												<li>
													<a name="source_anchor"><strong><em>Source</em></strong></a>
												
												    <%=aceitem.getSource() %>
												    
													<div class="case-studies-form-clearing"></div>
												</li>
										 <%} %>
											
										</ul>
									</div>
								</div>
                              </div> <!-- end of case-studies-tabbed-content-review-column-left  -->
                              
							   <div class="case-studies-tabbed-content-review-column-right">
								
									<div class="case-studies-tabbed-content-review-column-right-section">
										<p><strong>Keywords</strong></p>
										<p><%= aceitem.getKeyword() %></p>
									</div>
									
									<div class="case-studies-tabbed-content-review-column-right-section">
										<p><strong>Climate impacts</strong></p>
										   <%
												    String[] climateImpactsAry = null;
												    if (Validator.isNotNull(aceitem.getClimateimpacts_()))
												    {
													    String climateImpacts = aceitem.getClimateimpacts_();
													    climateImpactsAry = climateImpacts.split(";");
												    }
												    
												    pageContext.setAttribute("climateImpactsForReview", climateImpactsAry);
											%>
									     <p>
										   <c:forEach var="climate" items="${climateImpactsForReview}">
												       <liferay-ui:message key="aceitem-climateimpacts-lbl-${climate}" /><br/>
									       </c:forEach>
									     </p>
									    
									</div>

									<div class="case-studies-tabbed-content-review-column-right-section">
										<p><strong>Sectors</strong></p>
										    <%
												    
												    String[] sectorAry = null;
												    if (Validator.isNotNull(aceitem.getSectors_()))
												    {
												    	String sectors = aceitem.getSectors_();
												    	sectorAry = sectors.split(";");
												    }
												    pageContext.setAttribute("sectorForReview", sectorAry);
												   
												%>
										    <p>
												<c:forEach var="sector" items="${sectorForReview}">
													  <liferay-ui:message key="acesearch-sectors-lbl-${sector}" /><br/>
											    </c:forEach>
										    </p>
									</div>

									<div class="case-studies-tabbed-content-review-column-right-section">
										<p><strong>Geographic Characterization</strong></p>
										<p>
										     <c:choose>
												     <c:when test="${geoElementSelected eq 'GLOBAL'}">
												          Global<br/>
												     </c:when>
												     
												     <c:when test="${geoElementSelected eq 'EUROPE'}">
												          Europe:<br/>
												          
												          <c:if test="${fn:length(macroTransSelected) gt 0}">
												               Macro-Transnational region:<br/>
												               <c:forEach var="macroTransElement" items="${macroTransSelected}" >
													                <liferay-ui:message key="acesearch-geochars-lbl-${macroTransElement}"/>,
													           </c:forEach>
													           <br/><br/>
												          </c:if>
												          
												          <c:if test="${fn:length(bioRegionSelected) gt 0}">
												               Biographical regions:<br/>
												               <c:forEach var="bioRegionElement" items="${bioRegionSelected}" >
													                <liferay-ui:message key="acesearch-geochars-lbl-${bioRegionElement}"/>,
													           </c:forEach>
													           <br/><br/>
												          </c:if>
												          
												          <c:if test="${fn:length(countriesSelected) gt 0}">
												               Countries:<br/>
												               <c:forEach var="countryElement" items="${countriesSelected}" >
													                <liferay-ui:message key="acesearch-country-lbl-${countryElement}"/>,
													           </c:forEach>
													           <br/><br/>
												          </c:if>
												          
												          <c:if test="${fn:length(subNationalsSelected) gt 0}">
												               Sub Nationals:<br/>
													           <c:forEach var="subNationalElement" items="${subnationals}" >
													                     <c:if test="${fn:contains(subNationalsSelected,subNationalElement) }">
														                       ${subNationalElement.description},
														                 </c:if>
														       </c:forEach>
														       <br/><br/>
												          </c:if>
												          
												          <c:if test="${fn:length(city) gt 0}">
												             City: ${city}<br/><br/>
												          </c:if>
												     </c:when>
												     <c:otherwise>
												         <!--  if it is old form -->
												         <%=aceitem.getSpatialLayer() %><br/><br/>
												     </c:otherwise>
											 </c:choose>
										</p>
									
										
										<%
												    String countriesForReview = aceitem.getSpatialValues();
										            if (Validator.isNotNull(countriesForReview) && Validator.isNull(aceitem.getGeochars()))
										            {
											            //System.out.println("countries for review is " + countriesForReview);
													    String[] countriesAry = countriesForReview.split(";");
													    pageContext.setAttribute("countryForReview", countriesAry);
										      
												   
										%>
										            <p>Countries:</p>
										            <c:forEach var="ctry" items="${countryForReview}">
												       <liferay-ui:message key="acesearch-country-lbl-${ctry}" /><br/><br/>
												    </c:forEach>
										        <%} %>
												   
								       </div>
                                 </div>
							<div class="case-studies-form-clearing"></div>
							<div class="case-studies-tabbed-content-button-row">
								<a href="#" class="case-studies-tabbed-content-button-green case-studies-tabbed-content-button-previous case-studies-tabbed-content-float-left">Back To Geographical Information</a>
								<a href="#" class="case-studies-tabbed-content-button-green" onClick="submitform('submit')">Submit for Review Process</a>
							</div>
			 
		</li>
	 <% } %>
   </ul>
	  </div> <!-- end of div case-studies-tabbed-content -->
	  </div> <!-- end of div case-studies-tabs-wrapper -->	
	 </div> <!-- end of div case-studies-form-wrapper -->
   </div> <!--  end of div wrapper -->
   </aui:fieldset>
</aui:form>
<% } %>