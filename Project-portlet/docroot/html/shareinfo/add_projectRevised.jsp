<%@include file="/html/init.jsp" %>
<%

	
	String typedescription = "Research / Knowledge project";

	Project projectItem = null;
	Project projectItemFromRequest = null;
	
	long projectId = ParamUtil.getLong(request, "projectId");
	
	// look for request attribute because this might be the result of edit
		if (projectId == 0)
		{
			Long project_id;
			if (request.getAttribute("projectId") != null)
			{
			    project_id = (Long) request.getAttribute("projectId");
			    projectId = project_id.longValue();
			}
		}
	
	String moderator = "";
	
	String justSaved = null;
	
	String newModerator = user.getFullName() + " (" + user.getEmailAddress() + ")" ; 

	

	if (projectId > 0) {
		
		try {
			projectItem = ProjectLocalServiceUtil.getProject(projectId);
			moderator = projectItem.getModerator();
		}
		catch(Exception e) {
			projectId = 0;
			projectItem = null;
		}
	}
	
	if (projectId == 0)
	{
		if (request.getAttribute("project") != null)
		{
		   projectItemFromRequest = (Project) request.getAttribute("project");
		}
	}
	
    boolean isReviewer = false;
	if (renderRequest.isUserInRole("Portal Content Reviewer") 
			|| renderRequest.isUserInRole("administrator")
			|| renderRequest.isUserInRole("Power User")) {
		isReviewer = true;
	}
	
	if ( ! renderRequest.isUserInRole("user") ) { 
%>
		Please <a href='/home?p_p_id=58&p_p_lifecycle=0&p_p_state=maximized&p_p_mode=view&saveLastPath=0&_58_struts_action=%2Flogin%2Flogin'>sign in with your EIONET account</a> to add a <%= typedescription %>.
<% }	
 else  if ( (projectItem != null)
		     && 
		     (! isReviewer && ((moderator.indexOf(newModerator) == -1 ) || (projectItem.getControlstatus() >= ACEIndexUtil.Status_APPROVED) ))
		    ) { 

		out.print("You are not allowed to edit the " + typedescription + " <b>" + '"' + projectItem.getAcronym() + '"' + "</b>" + 
				( moderator.indexOf(newModerator) > -1 ? " for it has already been approved." : "." ) );
 }
 else {

		String redirect = ParamUtil.getString(request, "redirect");
		
		if(projectItem==null) {
			typedescription = "Add a " + typedescription ;
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

<aui:model-context bean="<%= projectItem %>" model="<%= Project.class %>" />

<portlet:actionURL name='<%= projectItem == null ? "addProject" : "updateProject" %>' var="editAceItemURL" />

<aui:form action='<%= editAceItemURL %>' method="POST" enctype="multipart/form-data" name="fm">
   <liferay-ui:error key="invalid-form-data" message="invalid-form-data" />
	<aui:fieldset>

		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />

		<aui:input type="hidden" name="projectId" value='<%= projectItem == null ? "" : projectItem.getProjectId() %>'/>
		
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
						<li><a href="#">Documents</a></li>
						<li><a href="#">Geographic Information</a></li>
						
						<%
						   if (projectItem != null) { 
						    if (justSaved != null) {%>
						       <li class="active"><a href="#">Review &amp; Submit</a></li>
						    <%} else { %>
						       <li><a href="#">Review &amp; Submit</a></li>
						  <% } // end of else
						   } // end of aceitem != null
					   %>
					</ul>
		</div>
		
		
<% if (projectItem != null) { %>
		<liferay-ui:error key="aceitem-changed" message="aceitem-changed" />
		<aui:input type="hidden" name="checkcreationdate" value='<%= projectItem.getCreationdate().getTime() %>'/>
<% } %>

      <div class="case-studies-tabbed-content">
         <ul>
               <% if (justSaved != null) { %>
						<li>
						<% } else { %>
				 <li class="active">
						<% } %>
							<div class="case-studies-tabbed-content-header">Project - <em>Description</em></div>
							<p>To help other people find and use this project, please provide as much detail as possible about this project. We will e-mail you after we review the project.</p>
							

                           <% if (renderRequest.isUserInRole("Portal Content Reviewer") || renderRequest.isUserInRole("administrator") ) {  %>
							<div class="case-studies-tabbed-content-section">
								<div class="case-studies-tabbed-content-subheader">Content Administrator Area</div>
								<ul>
									
									    <!-- approved check box -->
									    <!-- show only if it was submitted -->
										 <% 
										     // show the approved checkbox only if the user is reviewer or administrator
										  String checked = "";
										  if (projectItem != null && projectItem.getControlstatus() >= ACEIndexUtil.Status_SUBMITTED && (renderRequest.isUserInRole("Portal Content Reviewer") || renderRequest.isUserInRole("administrator")) )
										  { 
										
											  if (projectItem.getControlstatus() == ACEIndexUtil.Status_APPROVED)
											  {
													  checked = "checked";
											  }
											  else
											  {
												  if (projectItemFromRequest != null)
												  {
													  if (projectItemFromRequest.getControlstatus() == ACEIndexUtil.Status_APPROVED)
													  {
														  checked = "checked";
													  }
												  }
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
									  <p><b><em>Featured project:</em></b></p>
									  
									  <%
									      String feature = "";
									      if (projectItem != null && Validator.isNotNull(projectItem.getFeature()))
									      {
									    	  feature = "checked";
									      }
									      else
										  {
											  if (projectItemFromRequest != null)
											  {
												  if (Validator.isNotNull(projectItemFromRequest.getFeature()))
												  {
													  feature = "checked";
												  }
											  }
										  }
									     
									      
									  %>
									  <input type="checkbox" name="feature" id="chk_adaptation_feature" value="CASESEARCH" <%=feature %>/>
									  <label for="Feature this project on search results page">Feature this project on search results page</label>
									
										<br /><br />
										
										<p><em>Content Administration Comments:</em> (500 character limit)</p> 
										<%
										    String adminComment = "";
										    if (projectItem != null && Validator.isNotNull(projectItem.getAdmincomment()))
										    {
										    	adminComment = projectItem.getAdmincomment(); 
										    }
										    else
											{
												  if (projectItemFromRequest != null)
												  {
													  if (Validator.isNotNull(projectItemFromRequest.getAdmincomment()))
													  {
														  adminComment = projectItemFromRequest.getAdmincomment();
													  }
												  }
											}
										%>
									
										<textarea id="ta_caa_contact" cols="40" name="admincomment" rows="10" class="WYSIWYG" data-maxlength="500"><%= adminComment %></textarea>
										<div class="case-studies-character-count"></div>
										
										<% 
											// show the special tagging 
											String specialTagging = ""; 
										    if (projectItem != null && Validator.isNotNull(projectItem.getSpecialtagging()))
										    {
										    	specialTagging = projectItem.getSpecialtagging();
										    }
										    else
											{
												  if (projectItemFromRequest != null)
												  {
													  if (Validator.isNotNull(projectItemFromRequest.getSpecialtagging()))
													  {
														  specialTagging = projectItemFromRequest.getSpecialtagging();
													  }
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
      <div class="case-studies-tabbed-content-subheader">Acronym</div>
        <liferay-ui:error key="projectacronym-required" message="Project acronym required" />
        <ul>
	        <li>
				<p><b><span class="red">*</span> <em>Acronym of the project (75 character limit)</em></b></p>
				<% if (projectItem != null) { %>
		           <input name="acronym" type="text" size="75" maxlength="75" value="<%= projectItem.getAcronym() %>" /><br /><br />
				<%} else {
							// preserve the render parameter already set
						    // String renderName = renderRequest.getParameter("name");
							if (projectItemFromRequest != null)
							{
								String renderName = projectItemFromRequest.getAcronym();
								pageContext.setAttribute("renderName", renderName);
							}
				%>
						
				<c:if test="${renderName ne null}">
				  <input name="acronym" type="text" size="75" maxlength="75" value="${renderName}" /> <br /><br />
				</c:if>
												
				<c:if test="${renderName eq null}">
					  <input name="acronym" type="text" size="75" maxlength="75" value="" /><br /><br />
					</c:if>
				<%} %>
			</li>
		</ul>
	 </div>
	 
	  <div class="case-studies-tabbed-content-section">
      <div class="case-studies-tabbed-content-subheader">Title</div>
        <liferay-ui:error key="projecttitle-required" message="Project title required" />
        <ul>
	        <li>
				<p><b><span class="red">*</span> <em>Project title or name (50 character limit)</em></b></p>
				<% if (projectItem != null) { %>
		           <input name="title" type="text" size="75" maxlength="50" value="<%= projectItem.getTitle() %>" /><br /><br />
				<%} else {
							// preserve the render parameter already set
						    // String renderName = renderRequest.getParameter("name");
							if (projectItemFromRequest != null)
							{
								String renderName = projectItemFromRequest.getTitle();
								pageContext.setAttribute("renderName", renderName);
							}
				%>
						
				<c:if test="${renderName ne null}">
				  <input name="title" type="text" size="75" maxlength="50" value="${renderName}" /> <br /><br />
				</c:if>
												
				<c:if test="${renderName eq null}">
					  <input name="title" type="text" size="75" maxlength="50" value="" /><br /><br />
					</c:if>
				<%} %>
			</li>
		</ul>
	 </div>
	 
	 <div class="case-studies-tabbed-content-section">
      <div class="case-studies-tabbed-content-subheader">Lead</div>
        <liferay-ui:error key="projectlead-required" message="Project lead required" />
        <ul>
	        <li>
				<p><b><span class="red">*</span> <em>Lead organisation or individual of the project  (100 character limit)</em></b></p>
				<% if (projectItem != null) { %>
		           <input name="lead" type="text" size="75" maxlength="100" value="<%= projectItem.getLead() %>" /><br /><br />
				<%} else {
							// preserve the render parameter already set
						    // String renderName = renderRequest.getParameter("name");
							if (projectItemFromRequest != null)
							{
								String renderName = projectItemFromRequest.getLead();
								pageContext.setAttribute("renderName", renderName);
							}
				%>
						
				<c:if test="${renderName ne null}">
				  <input name="lead" type="text" size="75" maxlength="100" value="${renderName}" /> <br /><br />
				</c:if>
												
				<c:if test="${renderName eq null}">
					  <input name="lead" type="text" size="75" maxlength="100" value="" /><br /><br />
					</c:if>
				<%} %>
			</li>
		</ul>
	 </div>
	 
	  <div class="case-studies-tabbed-content-section">
	   <div class="case-studies-tabbed-content-subheader">Description</div>
	      <liferay-ui:error key="project-acronym-required" message="Project acronym required" />
	   <ul>
		    <li>
				<p><b><span class="red">*</span> <em>Provide information focusing on project output. Possibly on specific Website features. (5,000 character limit)</em></b></p>
				
				<% if (projectItem != null && projectItem.getAbstracts() != null) { %>
					<textarea id="<portlet:namespace />descriptionField" cols="40" rows="10" class="WYSIWYG" name="abstracts" data-maxlength="1000"><%= projectItem.getAbstracts() %></textarea>
					<textarea id="descriptionId" name="abstracts" cols="40" rows="10" class="WYSIWYG" data-maxlength="5000"><%= projectItem.getAbstracts() %></textarea>
				<%} else {
							// preserve the render parameter already sent
							//String renderDescription = renderRequest.getParameter("description");
						    if (projectItemFromRequest != null)
							{
								String renderDescription = projectItemFromRequest.getAbstracts();
								pageContext.setAttribute("renderDescription", renderDescription);
							}
				%>
							<c:if test="${renderDescription ne null}">
							  <textarea id="descriptionId" name="abstracts" cols="40" rows="10" class="WYSIWYG" data-maxlength="5000">${renderDescription}</textarea>
							</c:if>
							
							<c:if test="${renderDescription eq null}">
							 <textarea id="descriptionId" name="abstracts" cols="40" rows="10" class="WYSIWYG" data-maxlength="5000"></textarea>
							</c:if>
			<%} %>
				<div class="case-studies-character-count"></div>
			</li>
	   </ul>
	  </div>
	  
	  <div class="case-studies-tabbed-content-section">
	   <div class="case-studies-tabbed-content-subheader">Partners</div>
	   <ul>
		    <li>
				<p><b><span class="red">*</span> <em>Provide information about project partners (organisation names). (5,000 character limit)</em></b></p>
				
				<% if (projectItem != null && projectItem.getPartners() != null) { %>
					<textarea id="<portlet:namespace />partnerField" cols="40" rows="10" class="WYSIWYG" name="partners" data-maxlength="1000"><%= projectItem.getPartners() %></textarea>
					<textarea id="partnerId" name="partners" cols="40" rows="10" class="WYSIWYG" data-maxlength="5000"><%= projectItem.getPartners() %></textarea>
				<%} else {
							// preserve the render parameter already sent
							//String renderDescription = renderRequest.getParameter("description");
						    if (projectItemFromRequest != null)
							{
								String renderPtnerDescription = projectItemFromRequest.getPartners();
								pageContext.setAttribute("renderPtnerDescription", renderPtnerDescription);
							}
				%>
							<c:if test="${renderPtnerDescription ne null}">
							  <textarea id="partnerId" name="partners" cols="40" rows="10" class="WYSIWYG" data-maxlength="5000">${renderPtnerDescription}</textarea>
							</c:if>
							
							<c:if test="${renderPtnerDescription eq null}">
							 <textarea id="partnerId" name="partners" cols="40" rows="10" class="WYSIWYG" data-maxlength="5000"></textarea>
							</c:if>
			<%} %>
				<div class="case-studies-character-count"></div>
			</li>
	   </ul>
	  </div>
	  
	 
	<div class="case-studies-tabbed-content-section">
	    <div class="case-studies-tabbed-content-subheader">Keywords</div>
	      <liferay-ui:error key="project-keywords-required" message="Project keywords required" />
	   <ul>
	     <li>
            <p><b><span class="red">*</span> <em>Provide Keywords related to the project. Separate each keyword with a comma. For example, keyword 1, keyword 2 etc. (1,000 character limit)</em></b></p>
            <% if (projectItem != null && Validator.isNotNull(projectItem.getKeywords())) { %>
				<textarea id="keywordId" name="keywords" cols="40" rows="10" class="WYSIWYG" data-maxlength="1000"><%=projectItem.getKeywords() %></textarea>
				<%} else {
					// preserve the render parameter already sent
					//String renderKeywords = renderRequest.getParameter("keywords");
					if (projectItemFromRequest != null)
					{
							String renderKeywords = projectItemFromRequest.getKeywords();
							pageContext.setAttribute("renderKeywords", renderKeywords);
					}
					//pageContext.setAttribute("renderKeywords", renderKeywords);
				%>
					<c:if test="${renderKeywords ne null}">
					  <textarea id="keywordId" name="keywords" cols="40" rows="10" class="WYSIWYG" data-maxlength="1000">${renderKeywords}</textarea>
					</c:if>
					
					<c:if test="${renderKeywords eq null}">
					 <textarea id="keywordId" name="keywords" cols="40" rows="10" class="WYSIWYG" data-maxlength="1000"></textarea>
					</c:if>
				<%}%>
		    <div class="case-studies-character-count"></div>
		 </li>
	  </ul>
   </div>
	  
	  
	 <div class="case-studies-tabbed-content-section">
	      <div class="case-studies-tabbed-content-subheader">Policy Sectors</div>
	      <liferay-ui:error key="project-sectors-required" message="Policy sectors required" />
	       <ul>
	        <li>
	        <p><b><span class="red">*</span> <em>Select one or more relevant sector policies that this item relates to.</em></b></p>
		     <ul class="three-col">
			<!--   input name="sectors_" type="text" size="65" value="< %= aceitem == null ? "" : aceitem.getSectors_() % >"><br /><br / -->
			 <%
				         String choosensectors = "";
				         if (projectItem == null )
				         {
				        	
				        	 if (projectItemFromRequest != null)
				             {
				            	 
				                 String adaptationSectors = projectItemFromRequest.getSectors();
					        	 for (nl.wur.alterra.cgi.ace.model.constants.AceItemSector sector : nl.wur.alterra.cgi.ace.model.constants.AceItemSector.values()) 
					        	 {
					        			 if (adaptationSectors != null && adaptationSectors.indexOf(sector.toString()) >= 0) {
					                         choosensectors += sector.toString() + ";";
					                     }
					        		 
					        	 }
				             }
				         }
				%>
				
		       <%-- note : i18n file should always be in sync with AceItemSector enum --%>	
				<c:forEach var="adaptationSector" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemSector.values() %>" >
					<div class="check">
						<c:set var="aceItemSectors" value='<%= projectItem == null ? choosensectors : projectItem.getSectors() %>' />
						<c:set var="adaptationSectorMustBeChecked" value="false" />
						<c:if test="${fn:indexOf(aceItemSectors, adaptationSector)>=0}">
							<c:set var="adaptationSectorMustBeChecked" value="true" />
						</c:if>	
						<c:choose>
							<c:when test="${adaptationSectorMustBeChecked}">
								<li><label for="sectors_${adaptationSector}"><input type="checkbox" name="chk_sectors_${adaptationSector}" id="chk_sectors_${adaptationSector}" value="${adaptationSector}" checked="checked" /><liferay-ui:message key="acesearch-sectors-lbl-${adaptationSector}" /></label></li>
							</c:when>
							<c:otherwise>
								<li><label for="sectors_${adaptationSector}"><input type="checkbox" name="chk_sectors_${adaptationSector}" id="chk_sectors_${adaptationSector}" value="${adaptationSector}" /><liferay-ui:message key="acesearch-sectors-lbl-${adaptationSector}" /></label></li>
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
      <liferay-ui:error key="project-climate-impacts-required" message="Project climate impacts required" />
	  <ul>
	    <%
	       String choosenclimateimpacts = "";
	       
	    if (projectItem == null )
        {
       	 
       	 if (projectItemFromRequest != null)
            {
           	 
	             String caseStudyClimate = projectItemFromRequest.getClimateimpacts();
	        	 for (nl.wur.alterra.cgi.ace.model.constants.AceItemClimateImpact aceitemclimateimpact : nl.wur.alterra.cgi.ace.model.constants.AceItemClimateImpact.values()) 
	        	 {
	        			 if (caseStudyClimate != null && caseStudyClimate.indexOf(aceitemclimateimpact.toString()) >= 0) {
	                         choosenclimateimpacts += aceitemclimateimpact.toString() + ";";
	                     }
	        		 
	        	 }
            }
       	 
       	
        }
	    %>
	  
	    <li>
	     <p><b><span class="red">*</span> <em>Select one or more climate change impact topics that this item relates to.</em></b></p>
	     <ul class="three-col">
		<%-- note : i18n file should always be in sync with AceItemClimateImpact enum --%>
		<c:forEach var="adaptationClimateImpact" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemClimateImpact.values() %>" >
			<div class="check">
				<c:set var="adaptationClimateImpactMustBeChecked" value="false" />
				<c:set var="aceItemClimateImpacts" value='<%= projectItem == null ? choosenclimateimpacts : projectItem.getClimateimpacts() %>' />
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
    
    <div class="case-studies-tabbed-content-section">
      <div class="case-studies-tabbed-content-subheader">Source of Funding</div>
        <ul>
	        <li>
				<p><b><em>Provide source of funding (100 character limit)</em></b></p>
				<% if (projectItem != null) { %>
		           <input name="funding" type="text" size="75" maxlength="100" value="<%= projectItem.getFunding() %>" /><br /><br />
				<%} else {
							// preserve the render parameter already set
						    // String renderName = renderRequest.getParameter("name");
							if (projectItemFromRequest != null)
							{
								String renderName = projectItemFromRequest.getFunding();
								pageContext.setAttribute("renderName", renderName);
							}
				%>
						
				<c:if test="${renderName ne null}">
				  <input name="funding" type="text" size="75" maxlength="100" value="${renderName}" /> <br /><br />
				</c:if>
												
				<c:if test="${renderName eq null}">
					  <input name="funding" type="text" size="75" maxlength="100" value="" /><br /><br />
					</c:if>
				<%} %>
			</li>
		</ul>
	</div>
	
	 <div class="case-studies-tabbed-content-section">
      <div class="case-studies-tabbed-content-subheader">Duration</div>
        <ul>
	        <li>
				<p><b><em>Provide duration of project -  Start and end date [yr](100 character limit)</em></b></p>
				<% if (projectItem != null) { %>
		           <input name="duration" type="text" size="75" maxlength="100" value="<%= projectItem.getDuration() %>" /><br /><br />
				<%} else {
							// preserve the render parameter already set
						    // String renderName = renderRequest.getParameter("name");
							if (projectItemFromRequest != null)
							{
								String renderName = projectItemFromRequest.getDuration();
								pageContext.setAttribute("renderName", renderName);
							}
				%>
						
				<c:if test="${renderName ne null}">
				  <input name="duration" type="text" size="75" maxlength="100" value="${renderName}" /> <br /><br />
				</c:if>
												
				<c:if test="${renderName eq null}">
					  <input name="duration" type="text" size="75" maxlength="100" value="" /><br /><br />
					</c:if>
				<%} %>
			</li>
		</ul>
	</div>
	    
    <div class="case-studies-tabbed-content-button-row">
			<a href="#" class="case-studies-tabbed-content-button-green" onClick="submitform('save')">Save as Draft</a>
			<a href="#" class="case-studies-tabbed-content-button-green case-studies-tabbed-content-button-next">Next - Reference Information</a>
	</div>
    
 </li>
	  
	<li>
	  <div class="case-studies-tabbed-content-header"><em>Reference Information</em></div>	
	  <br/>
	  <div class="case-studies-tabbed-content-section">
	   <div class="case-studies-tabbed-content-subheader">Project Website</div>
	   <ul>
	    <li>	
	        <p><b><em>List the Name and Website where the item can be found or is described. (500 character limit).Please separate each website with semicolon.</em></b></p>
	        <% 
					  String website = "";
					  if (projectItem == null || Validator.isNull(projectItem.getWebsite())) {
						  if (projectItemFromRequest != null && projectItemFromRequest.getWebsite() != null)
						  {
							        website = projectItemFromRequest.getWebsite();
						  }
					  }
			%>
			<textarea id="website" name="website" cols="40" rows="10" class="WYSIWYG" data-maxlength="500"><%= projectItem == null ? website : projectItem.getWebsite() %></textarea>
			<div class="case-studies-character-count"></div>
		</li>
	   </ul>
	  </div>
	  
	 <div class="case-studies-tabbed-content-section">
	  <div class="case-studies-tabbed-content-subheader">Source</div>
	   <ul>
	     <li>
	        <p><b><em>Provide source from which project was retrieved (e.g. specific DB) (250 character limit)</em></b></p>
	        <% 
				  String source = "";
				  if (projectItem == null || Validator.isNull(projectItem.getSource())) {
					  if (projectItemFromRequest != null && projectItemFromRequest.getSource() != null)
					  {
						        source = projectItemFromRequest.getSource();
					  }
				  }
			%>
				
	        
		    <textarea id="aceItemStore" name="source" cols="40" rows="10" class="WYSIWYG" data-maxlength="500"><%= projectItem == null ? source : projectItem.getSource() %></textarea>
		    <div class="case-studies-character-count"></div>
		 </li>
	   </ul>
	 </div>
		<div class="case-studies-tabbed-content-button-row">
		        <a href="#" class="case-studies-tabbed-content-button-green case-studies-tabbed-content-button-previous case-studies-tabbed-content-float-left">Back To Item Description</a>
				<a href="#" class="case-studies-tabbed-content-button-green" onClick="submitform('save')">Save as Draft</a>
				<a href="#" class="case-studies-tabbed-content-button-green case-studies-tabbed-content-button-next">Next - Documents</a>
		</div>
   </li>
   
   
   
   <li>
			<div class="case-studies-tabbed-content-header"><em>Documents</em></div>
				<div class="case-studies-tabbed-content-section">
					<div class="case-studies-tabbed-content-subheader">Document Files</div>
					<liferay-ui:error key="invalid-multiple-doc-upload" message="invalid-multiple-doc-upload" />
					<p>Upload relevant file documents. Acceptable formats include Adobe PDF and Word<need definition>. Up to 5 number of files.</p>
								
					<% 
						    // to get the supdocs stored
							String supDocs = "";
						    StringBuilder sdocsStr = new StringBuilder("");
						    //String array of sup documents
							String[] sdocs = null;
							String[] sdocNames = new String[5];
							String[] sdocDescriptions = new String[5];
							
																	
							 if (projectItem != null && Validator.isNotNull(projectItem.getSupdocs())) {
								 
								 // get the string array of doc ids
								 sdocs = projectItem.getSupdocs().split(";");
								 supDocs = projectItem.getSupdocs();
								
							 }
							 else if (projectItemFromRequest != null && Validator.isNotNull(projectItemFromRequest.getSupdocs()))
							 {
								 sdocs = projectItemFromRequest.getSupdocs().split(";");
								 supDocs =  projectItemFromRequest.getSupdocs();
								
							 }
							 
						    // we have atleast one supplementary document	 
						    if (sdocs != null)
						    {
						    	
						             int i = 0;
						             
						             for (String document:sdocs)
									 {
						            	 
						            	 DLFileEntry file = DLFileEntryLocalServiceUtil.getDLFileEntry(Long.parseLong(document));
										 String supFileName = file.getTitle();
										 String supFileDescription = file.getDescription();
										 sdocNames[i] = supFileName;
										 sdocDescriptions[i] = supFileDescription;
										 i = i + 1;
									 }
									
						            
						             pageContext.setAttribute("sdocnames", sdocNames);
						             pageContext.setAttribute("sdocdesc", sdocDescriptions);
						             pageContext.setAttribute("doccount", sdocs.length);    
						    }
						    else
						    {
						    	pageContext.setAttribute("doccount", 0); 
						    }
								
								 %>
								
								<input name="supdocs" type="hidden" value="<%=supDocs %>"/>
								
								<c:choose>
								<c:when test="${doccount gt 0 }">
								   <c:forEach begin="1" end="${doccount}" varStatus="loop">
									     <ul class="case-studies-tabbed-content-document-upload">
									      <li class="case-studies-tabbed-content-document-upload-header">
											<b>Document File<span class="case-studies-tabbed-content-document-upload-position">${loop.count}</span>:</b>
											<a href="#" class="case-studies-tabbed-content-button-remove-document-${loop.count}">[remove]</a>
										  </li>
										  
										  <li>
											<p><b><em>Upload Document File <span class="case-studies-tabbed-content-document-upload-position">${loop.count}</span>:</em></b></p>
											<div class="inputfile"><input name="supdocfiles${loop.count }" type="file" /></div>
										  </li>
										  
										  <li>
											<p><b><em>Additional Document Files <span class="case-studies-tabbed-content-document-upload-position">${loop.count}</span>:</em></b></p>
											<p>Brief name of file (required - 150 char limit)</p>
											<div class="inputfilename"><input type="text" name="sup_docs_names${loop.count}" size="30" maxlength="150" value="${sdocnames[loop.count - 1]}"></div>
										  </li>
										  
										  <li>
											<p><b><span class="red">*</span> <em>Description of Document File <span class="case-studies-tabbed-content-document-upload-position">${loop.count}</span>:</em></b></p>
											<p>This field is required if a file is included. Briefly describe the file (required - 250 char limit)</p>
											<div class="inputfiledescription"><textarea cols="40" rows="10" name="sup_docs_description${loop.count}" data-maxlength="250">${sdocdesc[loop.count - 1]}</textarea></div>
										  </li>
										 </ul>
								   </c:forEach>
								
								   <div class="case-studies-tabbed-content-single-button-row">
									   <a href="#" class="case-studies-tabbed-content-button-green case-studies-tabbed-content-button-add-document">Add Another Document File</a>
								   </div>
								    <input name="doccounter" type="hidden" id="doccounter" value="${doccount}" />
								</c:when>
								<c:otherwise>
								       <input name="doccounter" id="doccounter" type="hidden" value="1" />
									   <ul class="case-studies-tabbed-content-document-upload">
										<li class="case-studies-tabbed-content-document-upload-header">
											<b>Document File <span class="case-studies-tabbed-content-document-upload-position">1</span>:</b>
										</li>
										<li>
											<p><b><em>Upload Document File <span class="case-studies-tabbed-content-document-upload-position">1</span>:</em></b></p>
											<div class="inputfile"><input name="supdocfiles1" type="file" /></div>
										</li>
										<li>
											<p><b><em>Additional Document Files <span class="case-studies-tabbed-content-document-upload-position">1</span> Label:</em></b></p>
											<p>Brief name of file (required - 150 char limit)</p>
											<div class="inputfilename"><input type="text" name="sup_docs_names1" size="30" maxlength="150" value=""></div>
										</li>
										<li>
											<p><b><span class="red">*</span> <em>Description of Document File <span class="case-studies-tabbed-content-document-upload-position">1</span>:</em></b></p>
											<p>This field is required if a file is included. Briefly describe the file (required - 250 char limit) </p>
											<div class="inputfiledescription"><textarea cols="40" rows="10" name="sup_docs_description1" data-maxlength="250"></textarea></div>
										</li>
									</ul>
									<div class="case-studies-tabbed-content-single-button-row">
										<a href="#" class="case-studies-tabbed-content-button-green case-studies-tabbed-content-button-add-document">Add Another Document File</a>
									</div>
								</c:otherwise>
							 </c:choose>
							</div>

							<div class="case-studies-tabbed-content-button-row">
								<a href="#" class="case-studies-tabbed-content-button-green case-studies-tabbed-content-button-previous case-studies-tabbed-content-float-left">Back To Reference Information</a>
							
								<a href="#" class="case-studies-tabbed-content-button-green" onClick="submitform('save')">Save as Draft</a>

								<a href="#" class="case-studies-tabbed-content-button-green case-studies-tabbed-content-button-next">Next - Geographic Information</a>
							</div>
						</li>
	<li>
	<div class="case-studies-tabbed-content-header">Geographic Information</div>
	 <br/>
	 <div class="case-studies-tabbed-content-section"> 
	   <div class="case-studies-tabbed-content-subheader">Geographic Characterisation</div>
	   <liferay-ui:error key="geo-characterization-required" message="Geo Characterization Required" />
	   <ul>
			<li>
				<p><em>Select the characterisation for this case study</em></p>
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
										        if (projectItem != null)
										        {
										        	geoCharsStr = projectItem.getGeochars();
										        }
										        else if (projectItemFromRequest != null)
										        {
										        	geoCharsStr = projectItemFromRequest.getGeochars();
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
										
														if (jsonObject != null)
														{
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
														             <li><label for="rad_geochars_${geoCharElement}"><input type="radio" name="rad_geo_chars" id="europe_geo_chars" value="${geoCharElement}"  checked/><liferay-ui:message key="acesearch-geochars-lbl-${geoCharElement}" /> (If this project applies to the whole of Europe, please select all the Macro-Transnational Regions below)</label></li>
														        </c:when>
														        <c:otherwise>
														           <li><label for="rad_geochars_${geoCharElement}"><input type="radio" name="rad_geo_chars" id="europe_geo_chars" value="${geoCharElement}" /><liferay-ui:message key="acesearch-geochars-lbl-${geoCharElement}" /> (If this project applies to the whole of Europe, please select all the Macro-Transnational Regions below)</label></li>
														        </c:otherwise>
														     </c:choose>
														         <!--  <div class="europe_geochar_class">	important - starting div for europe_geochar_class -->
										               </c:when>
										             
											          <c:when test="${geoCharElement == 'MACRO_TRANSNATIONAL_REGION'}" >
											           <div class="europe_geochar_class" style="overflow:inherit">	<!-- important - starting div for europe_geochar_class -->
											               <label for="rad_geochars_${geoCharElement}"><b><liferay-ui:message key="acesearch-geochars-lbl-${geoCharElement}" /></b></label>
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
													      </div>
													    </c:when>
													    
												        <c:when test="${geoCharElement == 'BIOGRAPHICAL_REGION'}" >
												          <div class="europe_geochar_class">	<!-- important - starting div for europe_geochar_class -->
												           <label for="rad_geochars_${geoCharElement}"><b><liferay-ui:message key="acesearch-geochars-lbl-${geoCharElement}" /></b></label>
											               
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
												          </div>
										               </c:when>
										               
										              <c:when test="${geoCharElement ==  'COUNTRIES'}" >
										               <div class="europe_geochar_class">	<!-- important - starting div for europe_geochar_class -->
										                    <label for="rad_geochars_${geoCharElement}"><b><liferay-ui:message key="acesearch-geochars-lbl-${geoCharElement}" /></b></label>
											               
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
														</div>
										              </c:when>
										              
											           <c:when test="${geoCharElement == 'SUBNATIONAL'}" >
											            <div class="europe_geochar_class">	<!-- important - starting div for europe_geochar_class -->
											               <label for="rad_geochars_${geoCharElement}"><b><liferay-ui:message key="acesearch-geochars-lbl-${geoCharElement}" />:</b></label>
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
												         </div>
										               </c:when>
										               <c:when test="${geoCharElement == 'CITY'}" >
										                <div class="europe_geochar_class">	<!-- important - starting div for europe_geochar_class -->
										                 <label for="rad_geochars_${geoCharElement}"><b><liferay-ui:message key="acesearch-geochars-lbl-${geoCharElement}" /></b></label>
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
		   <br/><br/>
		   <div class="case-studies-tabbed-content-section">
		        <div class="case-studies-tabbed-content-header"><em>Comments</em></div>
						   <p><em>Comments about this database item <i>[information entered below will not be displayed on the public pages of climate-adapt]</i></em></p>
						   <%
						       String comments = "";
						      
						       if (projectItem != null && Validator.isNotNull(projectItem.getComments())) 
						       {
						    	   comments = projectItem.getComments();
						       }
						       else if (projectItemFromRequest != null && Validator.isNotNull(projectItemFromRequest.getComments()))
						       {
						    	   comments = projectItemFromRequest.getComments();
						       }
						       
						   %>
						   <textarea cols="100" rows="10" name="comments" style="border-color: blue; border-style: solid; border-width: thin;"><%=comments %></textarea>
			</div>
		   
		   <div class="case-studies-tabbed-content-button-row">
							 
					<a href="#" class="case-studies-tabbed-content-button-green case-studies-tabbed-content-button-previous case-studies-tabbed-content-float-left">Back To Reference Information</a>
					<a href="#" class="case-studies-tabbed-content-button-green" onClick="submitform('save')">Save as Draft</a>
					<% if (projectItem != null) { %>
					   <a href="#" class="case-studies-tabbed-content-button-green case-studies-tabbed-content-button-next">Next - Review &amp; Submit</a>
					<% } %>
		   </div>
		   
		</li>
	
	 <!-- REVIEW SECTION STARTS - show only if the form was already savedd -->
	 <% if (projectItem != null) { 
	   if (justSaved != null) {
	 %>
	     <li class="active">
	  <%} else { %>
			<li>
	<% } %>
     
		    <div class="case-studies-tabbed-content-header"><em>Review &amp; Submit for Review Process</em></div>	
			<p>Review the project and submit it for <a href="#">review</a> for inclusion in the Climate- ADAPT Database. <b>Note</b> This preview page may appear slightly more narrow than the actual display. After this project has been added to the database, the project page will display slightly wider than it appears below.</p>

			  <div class="case-studies-tabbed-content-button-row">
					<a href="#" class="case-studies-tabbed-content-button-green case-studies-tabbed-content-button-previous case-studies-tabbed-content-float-left">Back To Geographical Information</a>
					<a href="#" class="case-studies-tabbed-content-button-green" onClick="submitform('submit')">Submit for Review Process</a>
			 </div>
			 <br><br>
			 
			      <div class="case-studies-tabbed-content-review-wrapper">
								<div class="case-studies-tabbed-content-review-column-left">
								     <div class="case-studies-tabbed-content-section">
										<p class="case-studies-tabbed-content-review-header"><%= projectItem.getAcronym() %>: <%= projectItem.getTitle() %></p>
										<p><b>Description:</b></p>
										<p><%= projectItem.getAbstracts() %></p>
									</div>
									<div class="case-studies-form-clearing"></div>
									
									<div class="case-studies-tabbed-content-section">
										<div class="case-studies-subheader"><%=projectItem.getAcronym() %> Information</div>
										<ul>
											<li>
												<p><b><em><%=projectItem.getAcronym() %> Description</em></b></p>
												<ul class="case-studies-bullted-list">
													<li><a href="#climate_impacts_anchor">Climate Impacts</a></li>
												    <li><a href="#sector_policies_anchor">Sector Policies</a></li>
												</ul>
											</li>
											
										<% if (Validator.isNotNull(projectItem.getWebsite()) && Validator.isNotNull(projectItem.getSource())) { %>
											<li>
												<p><b><em>Reference Information</em></b></p>
												<ul class="case-studies-bullted-list">
												   <% if (Validator.isNotNull(projectItem.getWebsite())) { %>
													<li><a href="#website_anchor">Websites</a></li>
													<% } %>
													<% if (Validator.isNotNull(projectItem.getSource())) { %>
														   <li><a href="#source_anchor">Source</a></li>
													<% } %>
												</ul>
											</li>
										<% } %>
										</ul>
										<div class="case-studies-case-studies-review-clearing-clearing"></div>
				                    </div>
				
									
				<div class="case-studies-tabbed-content-section">
					<div class="case-studies-subheader"><%=projectItem.getAcronym()%> Information</div>
					<ul>
						<li>
							<p><a name="climate_impacts_anchor"><b><em>Climate Impacts</em></b></a></p>
							<p>This Project (<%=projectItem.getAcronym() %>) addresses the following climate impact areas:</p>
							
							<%
									String[] climateImpactsAry = null;
								    if (Validator.isNotNull(projectItem.getClimateimpacts()))
								    {
									    String climateImpacts = projectItem.getClimateimpacts();
									    climateImpactsAry = climateImpacts.split(";");
								    }
												    
								    pageContext.setAttribute("climateImpactsForReview", climateImpactsAry);
							%>
												
							  <c:if test="${climateImpactsForReview ne null }">
							    <c:forEach var="climate" items="${climateImpactsForReview}">
							           <p><liferay-ui:message key="aceitem-climateimpacts-lbl-${climate}" /></p>
							    </c:forEach>
							  </c:if>
							<div class="case-studies-review-clearing"></div>
						</li>
						
						<li>
						        <p><a name="sector_policies_anchor"><b><em>Relevant European Union Sector Policies:</em></b></a></p>
								<%	    
								    String[] sectorAry = null;
								    if (Validator.isNotNull(projectItem.getSectors()))
								    {
								    	String sectors = projectItem.getSectors();
								    	sectorAry = sectors.split(";");
								    }
								    pageContext.setAttribute("sectorForReview", sectorAry);
								   
								%>
								
							   <c:if test="${sectorForReview ne null }">
								    <c:forEach var="sector" items="${sectorForReview}">
								       <p><liferay-ui:message key="acesearch-sectors-lbl-${sector}" /></p>
								    </c:forEach>
							   </c:if>
							   <div class="case-studies-form-clearing"></div>
						</li>
					</ul>
				</div>
                              								
                                 <% if (Validator.isNotNull(projectItem.getWebsite()) && Validator.isNotNull(projectItem.getSource())) { %>
									<div class="case-studies-tabbed-content-section">
										<div class="case-studies-tabbed-content-subheader">Reference Information</div>
										<ul>
										 <% if (Validator.isNotNull(projectItem.getWebsite()))
										   {%>	
											<li>
												<a name="website_anchor"><b><em>Websites</em></b></a>
												<p><%= projectItem.getWebsite() %></p>
												<div class="case-studies-form-clearing"></div>
											</li>
										<% } %>
											
										<% if (Validator.isNotNull(projectItem.getSource()))
										   {%>	
												<li>
													<a name="source_anchor"><b><em>Source</em></b></a>
												
												    <%= projectItem.getSource() %>
												    
													<div class="case-studies-form-clearing"></div>
												</li>
										 <%} %>
											
										</ul>
									</div>
								<% } %>
								</div> <!-- end of case-studies-tabbed-content-review-column-left  -->
                          
                              
							   <div class="case-studies-tabbed-content-review-column-right">
								
								 <%
								   if (Validator.isNotNull(projectItem.getSupdocs())) { %>
								   
									    <div clas="case-studies-tabbed-content-review-column-right-section">
										<p><b>Documents</b></p>
										<ul class="case-studies-tabbed-content-bullted-list">
										 
								 <% 
										 String[] sdocsForReview = projectItem.getSupdocs().split(";");
									     for (String doc:sdocsForReview)
									     {
									    	 DLFileEntry uploadedFileEntry =  DLFileEntryLocalServiceUtil.getDLFileEntry(Long.parseLong(doc));
									 	     String title = uploadedFileEntry.getTitle();
									 	     String fileUrl = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + "/" + uploadedFileEntry.getFolderId() +  "/" + HttpUtil.encodeURL(HtmlUtil.unescape(title));
										
									
								 %>
											<li><a href="<%=fileUrl%>"><%=title %></a></li>
											
								        <%} // end of for  %>
								  
										</ul>
									</div>
									
								<% } // end of if %>
								
									<div class="case-studies-tabbed-content-review-column-right-section">
										<p><b>Keywords</b></p>
										<p><%= projectItem.getKeywords() %></p>
									</div>
									
										<div class="case-studies-tabbed-content-review-column-right-section">
											<p><b>Sectors</b></p>
											<c:forEach var="sector" items="${sectorForReview}">
												<p><liferay-ui:message key="acesearch-sectors-lbl-${sector}" /></p>
										    </c:forEach>
										</div>
						
										<div class="case-studies-tabbed-content-review-column-right-section">
										     <p><b>Climate impacts</b></p>
											 <c:forEach var="climate" items="${climateImpactsForReview}">
												<p><liferay-ui:message key="aceitem-climateimpacts-lbl-${climate}" /></p>
											 </c:forEach>
										</div>
									
									
									<div class="case-studies-tabbed-content-review-column-right-section">
										<p><b>Geographic Characterisation</b></p>
										<p>
										     <c:choose>
												     <c:when test="${geoElementSelected eq 'GLOBAL'}">
												          Global<br/>
												     </c:when>
												     
												     <c:when test="${geoElementSelected eq 'EUROPE'}">
												          Europe:<br/>
												          
												          <c:if test="${fn:length(macroTransSelected) gt 0}">
												               Macro-Transnational region:<br/>
												               <c:forEach var="macroTransElement" items="${macroTransSelected}" varStatus="status">
													                <liferay-ui:message key="acesearch-geochars-lbl-${macroTransElement}"/>${not status.last ? ',' : ''}
													           </c:forEach>
													           <br/><br/>
												          </c:if>
												          
												          <c:if test="${fn:length(bioRegionSelected) gt 0}">
												               Biographical regions:<br/>
												               <c:forEach var="bioRegionElement" items="${bioRegionSelected}" varStatus="status">
													                <liferay-ui:message key="acesearch-geochars-lbl-${bioRegionElement}"/>${not status.last ? ',' : ''}
													           </c:forEach>
													           <br/><br/>
												          </c:if>
												          
												          <c:if test="${fn:length(countriesSelected) gt 0}">
												               Countries:<br/>
												               <c:forEach var="countryElement" items="${countriesSelected}" varStatus="status">
													                <liferay-ui:message key="acesearch-country-lbl-${countryElement}"/>${not status.last ? ',' : ''}
													           </c:forEach>
													           <br/><br/>
												          </c:if>
												          
												          <c:if test="${fn:length(subNationalsSelected) gt 0}">
												               Sub Nationals:<br/>
													           <c:forEach var="subNationalElement" items="${subnationals}" varStatus="status">
													                     <c:if test="${fn:contains(subNationalsSelected,subNationalElement) }">
														                       ${subNationalElement.description}
														                 </c:if>
														                 ${not status.last ? ',' : ''}
														       </c:forEach>
														       <br/><br/>
												          </c:if>
												          
												          <c:if test="${fn:length(city) gt 0}">
												             City: ${city}<br/><br/>
												          </c:if>
												     </c:when>
												     <c:otherwise>
												         <!--  if it is old form -->
												     </c:otherwise>
											 </c:choose>
										</p>
									
										
										<%
												    String countriesForReview = projectItem.getSpatialvalues();
										            if (Validator.isNotNull(countriesForReview) && Validator.isNull(projectItem.getGeochars()))
										            {
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
							</div>
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