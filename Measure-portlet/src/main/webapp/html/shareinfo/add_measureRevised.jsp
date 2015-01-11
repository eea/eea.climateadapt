<%@include file="/html/init.jsp" %>

<%
   String mao_type = prefs.getValue(Constants.mao_typePreferenceName, "A");

	Measure measure = null;
	Measure measureFromRequest = null;

	long measureId = ParamUtil.getLong(request, "measureId");

	// look for request attribute because this might be the result of edit
	if (measureId == 0)
	{
		Long measure_id;
		if (request.getAttribute("measureId") != null)
		{
		    measure_id = (Long) request.getAttribute("measureId");
		    measureId = measure_id.longValue();
		}
	}

	String moderator = "";

	String newModerator = user.getFullName() + " (" + user.getEmailAddress() + ")" ;

	if (measureId > 0) {

		try {
			if (request.getAttribute("measure") != null)
			{
			   measure = (Measure) request.getAttribute("measure");
			}
			else {
				measure = MeasureLocalServiceUtil.getMeasure(measureId);
			}
			moderator = measure.getModerator();
		}
		catch(Exception e) {
			measureId = 0;
			measure = null;
		}
	}

	if (measureId == 0)
	{
		if (request.getAttribute("measure") != null)
		{
		   measureFromRequest = (Measure) request.getAttribute("measure");
		}
	}

	boolean isReviewer = false;

	if (renderRequest.isUserInRole("Portal Content Reviewer")
			|| renderRequest.isUserInRole("administrator")
			|| renderRequest.isUserInRole("Power User")) {
		isReviewer = true;
	}

   if ( ! renderRequest.isUserInRole("user") ) { // || renderRequest.isUserInRole("portal-content-reviewer") ) {
	    // if approved only administrator can delete; otherwise also power user can delete %>
		Please <a href='/home?p_p_id=58&p_p_lifecycle=0&p_p_state=maximized&p_p_mode=view&saveLastPath=0&_58_struts_action=%2Flogin%2Flogin'>sign in with your EIONET account</a> to <%= mao_type.equalsIgnoreCase("A") ? "add a case study" : "add an adaptation option" %>.
<% }
   else  if ( (measure != null)
		     &&
		     (! isReviewer &&  ((moderator.indexOf(newModerator) == -1 ) || (measure.getControlstatus() >= ACEIndexUtil.Status_APPROVED)) )
		    ) {

		out.print("You are not allowed to edit the " + (mao_type.equalsIgnoreCase("A") ? "case study" : "adaptation option") + " <b>" + '"' + measure.getName() + '"' + "</b>" +
				( moderator.indexOf(newModerator) > -1 ? " for it has already been approved." : "." ) );
	}
   else {

	String redirect = ParamUtil.getString(request, "redirect");

	String typedescription = "";
	String justSaved = null;

	if(measure==null) {
		typedescription = "Add " + (mao_type.equalsIgnoreCase("A") ? "a case study" : "an adaptation option") ;
	}
	else {

		typedescription = "Edit the " + (mao_type.equalsIgnoreCase("A") ? "case study" : "adaptation option") ;

		// get the justSaved status
		if (request.getAttribute("justsaved") != null)
		{
			justSaved = (String) request.getAttribute("justsaved");
		}
			//System.out.println("just saved is " + justSaved);
	}
%>

	<!-- ==================== -->
	<!-- FOR WYSIWYG :: Begin -->
	<!-- ==================== -->

	<script src="http://tinymce.cachefly.net/4.0/tinymce.min.js"></script>
	<!-- ================== -->
	<!-- FOR WYSIWYG :: End -->
	<!-- ================== -->

	<!-- For Photo Slideshow -->
	<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/jquery.dualListBox-1.3.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/jquery.dualListBox-1.3.min.js" type="text/javascript"></script>

	<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" media="all" />
	<!-- End Photo Slideshow -->

	<script type="text/javascript">

		// ====================== //
		// Portlet JS Starts Here //
		// ====================== //

		$(document).ready(function() {

		    $("#all_countries").click(function() {
			<%
				nl.wur.alterra.cgi.ace.model.constants.AceItemCountry[] country = nl.wur.alterra.cgi.ace.model.constants.AceItemCountry.values();
				for(int i=0; i < country.length; i++) {
					out.print("document.getElementById('chk_countries_" +  country[i]  + "').checked = true;");
				}
			%>
		    });

		    $("#no_countries").click(function() {
		    <%
		    	for(int i=0; i < country.length; i++) {
		    		out.print("document.getElementById('chk_countries_" +  country[i]  + "').checked = false;");
		    	}
		    %>
		    });

		    var options = {
					box1View: 'subnationals',
					box2View: 'subnationals_selected',
		            transferMode: 'copy',
		            useFilters: false,
		            useCounters: false,
		            useSorting: false,
					selectOnSubmit: false
		        };

		   $.configureBoxes(options);


		    $('#case-studies-modal-link').click(function(e) {
				e.preventDefault();

				$('#case-studies-modal').dialog({
					modal: true,
					width: 890,
					height: ( $(window).height() - ($(window).height()*.20) ),
					resizable: false
				});

				$('.case-studies-modal-close').click(function(e){
					e.preventDefault();
				});

				customSldieShow();
			});
		});


		function customSldieShow() {
			$('#case-studies-modal-image-gallery').height( $('#case-studies-modal').height() - $('#case-studies-modal .case-studies-modal-buttons').height() );
			$('#case-studies-modal-image-gallery ul li').height( $('#case-studies-modal-image-gallery').height() );

			$('#case-studies-modal-image-gallery > ul > li').each(function(){
				var tmpParagraphHeightCalc = 0;

				$(this).find('p').each(function(){
					tmpParagraphHeightCalc += $(this).outerHeight( true );
				});

				$(this).find('img').css('max-height', ($(this).height() - $(this).find('h3').outerHeight( true ) - tmpParagraphHeightCalc) );

				$(this).css({
					display: 'none',
					left: 0
				});
			});

			$('#case-studies-modal-image-gallery .case-studies-modal-image-gallery-navigation > a').click(function(e){
				e.preventDefault();

				var tmpPos = $('#case-studies-modal-image-gallery ul li.active').index('#case-studies-modal-image-gallery ul li');
				$('#case-studies-modal-image-gallery ul li.active').removeClass('active');

				if ( $(this).hasClass('next') ) {
					if ( tmpPos + 1 < $('#case-studies-modal-image-gallery ul li').length ) {
						$('#case-studies-modal-image-gallery ul li').eq( tmpPos + 1 ).addClass('active');
					} else {
						$('#case-studies-modal-image-gallery ul li').eq( 0 ).addClass('active');
					}
				} else if ( $(this).hasClass('prev') ) {
					if ( tmpPos - 1 >= 0 ) {
						$('#case-studies-modal-image-gallery ul li').eq( tmpPos - 1 ).addClass('active');
					} else {
						$('#case-studies-modal-image-gallery ul li').eq( $('#case-studies-modal-image-gallery ul li').length - 1 ).addClass('active');
					}
				}
			});
		}

		function submitform(saveType)
		{
			if (saveType == 'save')
			{
			    document.<portlet:namespace />fm.<portlet:namespace />chk_controlstatus.value = "-1";
			}
			else
			{
				// it must be submit
				if (document.<portlet:namespace />fm.chk_controlstatus_for_approved != null && document.<portlet:namespace />fm.chk_controlstatus_for_approved.checked)
			    {
				   document.<portlet:namespace />fm.<portlet:namespace />chk_controlstatus.value = "1";
			    }
				else
				{
					 document.<portlet:namespace />fm.<portlet:namespace />chk_controlstatus.value = "0";
				}
			}
			//alert("chk_controlstatus value is " + document.<portlet:namespace />fm.<portlet:namespace />chk_controlstatus.value);

			//alert("Geo Characterization value is " + $('input:radio[name=rad_geo_chars]:checked').val());

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

			//return;
			$('input:radio[name=rad_geo_chars]:checked').val(result);

		   // adaptation options processing
		   var adaptoptions = "";
		   $('.adaptoptionsfromdb:checked').each(function(){
			   if (adaptoptions.length == 0)
			   {
			      adaptoptions = $(this).val();
			   }
			   else
			   {
				   adaptoptions = adaptoptions + ";" + $(this).val();
			   }
		   });

		   $('input:checkbox[name=chk_adaptoptions]:checked').val(adaptoptions);

		   // categories processing
		   var categories = "";
		   $('input:checkbox[name=chk_categories]:checked').each(function() {
			   if (categories.length == 0)
			   {
				   categories = $(this).val();
			   }
			   else
			   {
				   categories = categories + ";" + $(this).val();
			   }
		   });

		   $('input:checkbox[name=chk_categories]:checked').val(categories);


		   // governance level processing for adaptation option
		   var governancelevels = "";
		   $('.governanceForAdaptation:checked').each(function(){
			   if (governancelevels.length == 0)
			   {
			      governancelevels = $(this).val();
			   }
			   else
			   {
				   governancelevels = governancelevels + ";" + $(this).val();
			   }
		   });

		   $('input:checkbox[name=chk_geos_trans]:checked').val(governancelevels);



		   document.<portlet:namespace />fm.submit();
		}

     </script>

    <portlet:renderURL var="viewURL">
		<portlet:param name="jspPage" value="/html/shareinfo/view.jsp" />
	</portlet:renderURL>

<liferay-ui:header
	backURL="<%=viewURL.toString()%>" title="<%= typedescription %>"
/>

<aui:model-context bean="<%= measure %>" model="<%= Measure.class %>" />

<portlet:actionURL name='<%= measure == null ? "addMeasure" : "updateMeasure" %>' var="editMeasureURL" />

<aui:form action="<%= editMeasureURL %>" method="POST" name="fm" enctype="multipart/form-data" id="fm">
    <liferay-ui:error key="invalid-form-data" message="invalid-form-data" />
	<aui:input type="hidden" name="mao_type" value="<%= mao_type %>" />
	<aui:input type="hidden" name="redirect" value="<%= redirect %>" />
	<aui:input type="hidden" name="measureId" value='<%= measure == null ? "" : measure.getMeasureId() %>'/>
	<aui:input type="hidden" name="chk_controlstatus" value="" />

<body>
	<div id="wrapper">

		<!-- =========================== -->
		<!-- Portlet Content Starts Here -->
		<!-- =========================== -->

		<div id="case-studies-form-wrapper">
		    <% if (measure != null) { %>
		         <liferay-ui:error key="measure-changed" message="measure-changed" />
		         <aui:input type="hidden" name="checkcreationdate" value='<%= measure.getCreationdate().getTime() %>'/>
             <%
             } %>

			<div class="case-studies-tabs-wrapper">
				<div class="case-studies-tabs">
					<ul>
					    <%
					        String nameOfClimateEntityText = "";
					        String nameOfClimateEntityShortText = "";
					        String descriptionOfClimateEntityShortText = "";
					        String descriptionOfClimateEntityText = "";
					        String toggleclass = "";
					        String localDescription = "";
					        String uploadText = "";

					        if (mao_type.equalsIgnoreCase("A"))
					        {
					        	nameOfClimateEntityText = "Case Study Name";
					        	nameOfClimateEntityShortText = "Case Study";
					        	descriptionOfClimateEntityShortText = "Case Description";
					        	descriptionOfClimateEntityText = "Case Study Description";
					        	toggleclass = "toggleshow";
					        	uploadText = "Illustrations and Documents";
					        }
					        else
					        {
					        	nameOfClimateEntityText = "Adaptation Option Name";
					        	nameOfClimateEntityShortText = "Adaptation Option";
					        	descriptionOfClimateEntityShortText = "Adaptation Description";
					        	descriptionOfClimateEntityText = "Adaptation Option Description";
					        	toggleclass = "togglehide";
					        	uploadText = "Documents";
					        }
					    %>
					    <% if (justSaved ==  null) {%>
						<li class="active"><a href="#"><%=descriptionOfClimateEntityText%></a></li>
						<% } else { %>
						<li><a href="#"><%=descriptionOfClimateEntityText%></a></li>
						<% } %>
						<li><a href="#">Additional Details</a></li>
						<li><a href="#">Reference Information</a></li>
						<li><a href="#"><%=uploadText %></a></li>
						<li><a href="#">Geographic Information</a></li>
						<% if (measure != null) {
						      if (justSaved != null) {%>
						               <li class="active"><a href="#">Review &amp; Submit</a></li>
						      <%} else { %>
						       <li><a href="#">Review &amp; Submit</a></li>
						     <% } // end of else
						      } // end of if measure != null
						     %>
					</ul>
				</div>
				<div class="case-studies-tabbed-content">
					<ul>
					    <% if (justSaved != null) { %>
						<li>
						<% } else { %>
						<li class="active">
						<% } %>
							<div class="case-studies-tabbed-content-header"><%=nameOfClimateEntityShortText %> - <em>Description</em></div>
							<p>To help other people find and use this <%=nameOfClimateEntityShortText.toLowerCase() %>, please provide as much detail as possible about this <%=nameOfClimateEntityShortText.toLowerCase() %>. We will e-mail you after we review the <%=nameOfClimateEntityShortText.toLowerCase() %>.</p>


                           <% if (renderRequest.isUserInRole("Portal Content Reviewer") || renderRequest.isUserInRole("administrator") ) {  %>
							<div class="case-studies-tabbed-content-section">
								<div class="case-studies-tabbed-content-subheader">Content Administrator Area</div>
								<ul>

									    <!-- approved check box -->
									    <!-- show only if it was submitted -->
										 <% if (measure != null && measure.getControlstatus() >= ACEIndexUtil.Status_SUBMITTED && (renderRequest.isUserInRole("Portal Content Reviewer") || renderRequest.isUserInRole("administrator")) ) {

											  // show the approved checkbox only if the user is reviewer or administrator
											  String checked = "";

											  if (measure != null)
											  {
												  if (measure.getControlstatus() == ACEIndexUtil.Status_APPROVED)
												  {
													  checked = "checked";
												  }

											  }
											  else
											  {
												  if (measureFromRequest != null)
												  {
													  if (measureFromRequest.getControlstatus() == ACEIndexUtil.Status_APPROVED)
													  {
														  checked = "checked";
													  }
												  }
											  }
											  pageContext.setAttribute("checked", checked);

											  %>

										           <li>
			                                         <input type="checkbox" name="chk_controlstatus_for_approved" id="chk_controlstatus_for_approved" value="1" ${checked} />

			                                         <b>Approved</b>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
			                                       </li>
		                                  <% } %>
									  <!-- end of approved check box -->

									  <li>
									  <p><b><em>Featured <%=nameOfClimateEntityShortText %>:</em></b></p>
										<%
										         String choosenfeature = "";
										         if (measure == null )
										         {

										             if (measureFromRequest != null)
										             {

										                 String caseStudyFeature = measureFromRequest.getCasestudyfeature();
											        	 for (nl.wur.alterra.cgi.ace.model.constants.MeasureCaseStudyFeature feature : nl.wur.alterra.cgi.ace.model.constants.MeasureCaseStudyFeature.values())
											        	 {

											        			 if (caseStudyFeature != null && caseStudyFeature.indexOf(feature.toString()) >= 0) {
											                         choosenfeature += feature.toString() + ";";
											                     }

											        	 }
										             }


										         }
										    %>

										<%
										   ArrayList featureList = new ArrayList();
										   for (nl.wur.alterra.cgi.ace.model.constants.MeasureCaseStudyFeature f : nl.wur.alterra.cgi.ace.model.constants.MeasureCaseStudyFeature.values())
										   {
											   if ( !mao_type.equalsIgnoreCase("A") && f.toString().equalsIgnoreCase("CASEHOME"))
											   {
												   continue;
											   }
											   else
											   {
												   featureList.add(f.toString());
											   }
										   }
										   pageContext.setAttribute("featureList", featureList);

										%>
										       <c:forEach var="feature" items="${featureList}">
													<c:set var="caseFeaturesMustBeChecked" value="false" />
													<c:set var="caseFeature" value='<%= measure == null ? choosenfeature : measure.getCasestudyfeature() %>' />
													<c:set var="caseFeatureMustBeChecked" value="false" />
													<c:if test="${fn:indexOf(caseFeature, feature)>=0}">
														<c:set var="caseFeatureMustBeChecked" value="true" />
													</c:if>
													<c:choose>
														<c:when test="${caseFeatureMustBeChecked}">
															<input type="checkbox" name="chk_casestudyfeature_${feature}" id="chk_casestudyfeature_${feature}" value="${feature}" checked="checked" />
														</c:when>
														<c:otherwise>
															<input type="checkbox" name="chk_casestudyfeature_${feature}" id="chk_casestudyfeature_${feature}" value="${feature}" />
														</c:otherwise>
													</c:choose>
													<%if (mao_type.equalsIgnoreCase("A")) { %>
													      <label for="chk_casestudyfeature_${feature}"><liferay-ui:message key="measure-casestudyfeature-lbl-${feature}" /></label>
													 <% } else { %>
													      <label for="chk_casestudyfeature_${feature}"><liferay-ui:message key="measure-adaptation-option-feature-lbl-${feature}" /></label>
													 <%} %>
											  </c:forEach>

										<br /><br />
										<p><em>Content Administration Comments:</em> (500 character limit)</p>
										<% if (measure != null && measure.getAdmincomment() != null) { %>
										      <textarea id="ta_caa_contact" cols="40" name="admincomment" rows="10" class="WYSIWYG" data-maxlength="500"><%= HtmlUtil.escapeAttribute(measure.getAdmincomment()) %></textarea>
										<%} else {
											// preserve the render parameter already sent
											//String renderAdminComment = renderRequest.getParameter("admincomment");
											if (measureFromRequest != null)
											{
												String renderAdminComment = HtmlUtil.escapeAttribute(measureFromRequest.getAdmincomment());
												pageContext.setAttribute("renderAdminComment", renderAdminComment);
											}
											//pageContext.setAttribute("renderAdminComment", renderAdminComment);
										%>
											<c:if test="${renderAdminComment ne null}">
											  <textarea id="ta_caa_contact" cols="40" name="admincomment" rows="10" class="WYSIWYG" data-maxlength="500">${renderAdminComment}</textarea>
											</c:if>

											<c:if test="${renderAdminComment eq null}">
											 <textarea id="ta_caa_contact" cols="40" name="admincomment" rows="10" class="WYSIWYG" data-maxlength="500"></textarea>
											</c:if>
										<%} %>
										<div class="case-studies-character-count"></div>

										<%
											  // show the special tagging
											  String specialTagging = "";
											  if (measure != null)
											  {

												  if (Validator.isNotNull(measure.getSpecialtagging()))
												  {
													  specialTagging = HtmlUtil.escapeAttribute(measure.getSpecialtagging());
												  }

											  }
											  else
											  {
												  if (measureFromRequest != null)
												  {
													  if (Validator.isNotNull(measureFromRequest.getSpecialtagging()))
													  {
														  specialTagging = HtmlUtil.escapeAttribute(measureFromRequest.getSpecialtagging());
													  }
												  }
											  }
										%>

											 <br/>
	                                         <p><em>Special Tagging</em></p>
	                                      	 <input name="specialtagging" type="text" size="65" maxlength="75" value="<%= specialTagging %>"><br /><br />

	                                         <% if (measure != null && measure.getControlstatus() >= 0) { %>
	                                            <p><em><b>Submitted by:&nbsp;&nbsp;</b></em><%=measure.getModerator()%></p>
	                                         <% } %>
									</li>
								</ul>
							</div>
							<% } // end of if content reviewer or administrator%>

							<div class="case-studies-tabbed-content-section">
								<div class="case-studies-tabbed-content-subheader"><%=nameOfClimateEntityText%></div>

								<div>
									<liferay-ui:error key="measurename-required" message="measurename-required" />
								</div>

								<ul>
									<li>
									    <%
									         String textSize = "";
									         if (mao_type.equalsIgnoreCase("A"))
									         {
									        	 localDescription = "Provide a name that clearly identifies the context and location of the case study (100 char limit)";
									        	 textSize = "100";
									         }
									         else
									         {
									        	 localDescription = "Adaptation Option Name (50 char limit)";
									        	 textSize = "50";
									         }
									    %>
										<p><b><span class="red">*</span> <em><%=localDescription%></em></b></p>
										<% if (measure != null) { %>
		                                      <input name="name" type="text" size="75" maxlength="<%=textSize %>" value="<%= HtmlUtil.escapeAttribute(measure.getName()) %>" /><br /><br />
										<%} else {
											// preserve the render parameter already set
										    // String renderName = renderRequest.getParameter("name");
											if (measureFromRequest != null)
											{
												String renderName = HtmlUtil.escapeAttribute(measureFromRequest.getName());
												pageContext.setAttribute("renderName", renderName);
											}
										%>

										<c:if test="${renderName ne null}">
										  <input name="name" type="text" size="75" maxlength="<%=textSize%>" value="${renderName}" /> <br /><br />
										</c:if>

										<c:if test="${renderName eq null}">
											  <input name="name" type="text" size="75" maxlength="<%=textSize%>" value="" /><br /><br />
											</c:if>
										<%} %>
									</li>
								</ul>
							</div>

							<div class="case-studies-tabbed-content-section">
								<div class="case-studies-tabbed-content-subheader"><%=descriptionOfClimateEntityText%></div>
								<ul>
									<li>
									    <%
									         if (mao_type.equalsIgnoreCase("A"))
									         {
									        	 localDescription = "Provide a brief introductory summary description about this case study and how it works (1000 character limit).";
									         }
									         else
									         {
									        	 localDescription = "Provide a description of the climate change impacts/risks, related challenges and specific objectives addressed by the adaptation option, " +
									                                " including  also key environmental and socio-economic issues and geographical characterisation," +
									        	                    " e.g. 'mountain area' or 'coastal area' etc. (5,000 character limit).";
									         }
									    %>
									    <liferay-ui:error key="description-required" message="description-required" />
										<p><b><span class="red">*</span> <em>Brief Description:</em></b></p>
										<p><%=localDescription%></p>

										<% if (measure != null && measure.getDescription() != null) { %>
										       <textarea id="<portlet:namespace />descriptionField" cols="40" rows="10" class="WYSIWYG" name="description" data-maxlength="1000"><%= HtmlUtil.escapeAttribute(measure.getDescription()) %></textarea>
										<%} else {
											// preserve the render parameter already sent
											//String renderDescription = renderRequest.getParameter("description");
										    if (measureFromRequest != null)
											{
												String renderDescription = HtmlUtil.escapeAttribute(measureFromRequest.getDescription());
												pageContext.setAttribute("renderDescription", renderDescription);
											}
										%>
											<c:if test="${renderDescription ne null}">
											  <textarea id="<portlet:namespace />descriptionField" cols="40" rows="10" class="WYSIWYG" name="description" data-maxlength="1000">${renderDescription}</textarea>
											</c:if>

											<c:if test="${renderDescription eq null}">
											 <textarea id="<portlet:namespace />descriptionField" cols="40" rows="10" class="WYSIWYG" name="description" data-maxlength="5000"></textarea>
											</c:if>
										<%} %>
										<div class="case-studies-character-count"></div>
									</li>
									<li>
									    <liferay-ui:error key="climateImpacts-required" message="climateImpacts-required" />
										<p><b><span class="red">*</span> <em>Climate Impacts:</em></b></p>
										<% if (mao_type.equalsIgnoreCase("A")) { %>
										   <p>Select one or more climate change impact topics that this case study covers.</p>
										<%} else { %>
										   <p>Select one or more climate change impact topics that this adaptation option relates to.</p>
										<% } %>
										<ul class="three-col">
										    <%
										         String choosenclimateimpacts = "";
										         if (measure == null )
										         {

										        	 if (measureFromRequest != null)
										             {

											             String caseStudyClimate = measureFromRequest.getClimateimpacts_();
											        	 for (nl.wur.alterra.cgi.ace.model.constants.AceItemClimateImpact aceitemclimateimpact : nl.wur.alterra.cgi.ace.model.constants.AceItemClimateImpact.values())
											        	 {
											        			 if (caseStudyClimate != null && caseStudyClimate.indexOf(aceitemclimateimpact.toString()) >= 0) {
											                         choosenclimateimpacts += aceitemclimateimpact.toString() + ";";
											                     }

											        	 }
										             }


										         }
										    %>
										    <c:forEach var="adaptationClimateImpact" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemClimateImpact.values() %>" >
												<div class="check">
													<c:set var="adaptationClimateImpactMustBeChecked" value="false" />
													<c:set var="aceItemClimateImpacts" value='<%= measure == null ? choosenclimateimpacts : measure.getClimateimpacts_() %>' />
													<c:set var="adaptationClimateImpactMustBeChecked" value="false" />
													<c:if test="${fn:indexOf(aceItemClimateImpacts, adaptationClimateImpact)>=0}">
														<c:set var="adaptationClimateImpactMustBeChecked" value="true" />
													</c:if>
													<c:choose>
														<c:when test="${adaptationClimateImpactMustBeChecked}">
															<li><label for="chk_climateimpacts_${adaptationClimateImpact}"><input type="checkbox" name="chk_climateimpacts_${adaptationClimateImpact}" id="chk_climateimpacts_${adaptationClimateImpact}" value="${adaptationClimateImpact}" checked="checked" /><liferay-ui:message key="aceitem-climateimpacts-lbl-${adaptationClimateImpact}" /></label></li>
														</c:when>
														<c:otherwise>
															<li><label for="chk_climateimpacts_${adaptationClimateImpact}"><input type="checkbox" name="chk_climateimpacts_${adaptationClimateImpact}" id="chk_climateimpacts_${adaptationClimateImpact}" value="${adaptationClimateImpact}" /><liferay-ui:message key="aceitem-climateimpacts-lbl-${adaptationClimateImpact}" /></label></li>
														</c:otherwise>
													</c:choose>
												</div>
											</c:forEach>
										</ul>
										<div class="case-studies-form-clearing"></div>
									</li>

								    <% if (mao_type.equalsIgnoreCase("A")) { %> <!-- if measure -->
									<li>
									    <liferay-ui:error key="challenges-required" message="challenges-required" />
										<p><b><span class="red">*</span> <em>Challenges:</em></b></p>
										<p>Describe how this case study addresses climate change impacts/risks and related challenges,.
										   including  also key environmental and socio-economic issues and geographical characterisation, e.g. &apos;mountain area&apos; or &apos;coastal area&apos; etc (5,000 char limit).</p>

										<% if (measure != null && measure.getChallenges() != null) { %>
										      <textarea id="<portlet:namespace />challengesField" cols="40" rows="10" class="WYSIWYG" name="challenges" data-maxlength="5000"><%= HtmlUtil.escapeAttribute(measure.getChallenges()) %></textarea>
										<%} else {
											// preserve the render parameter already set
											//String renderChallenges = renderRequest.getParameter("challenges");
											if (measureFromRequest != null)
											{
												String renderChallenges = HtmlUtil.escapeAttribute(measureFromRequest.getChallenges());
												pageContext.setAttribute("renderChallenges", renderChallenges);
											}

										%>
											<c:if test="${renderChallenges ne null}">
											  <textarea id="<portlet:namespace />challengesField" cols="40" rows="10" class="WYSIWYG" name="challenges" data-maxlength="5000">${renderChallenges}</textarea>
											</c:if>

											<c:if test="${renderChallenges eq null}">
											 <textarea id="<portlet:namespace />challengesField" cols="40" rows="10" class="WYSIWYG" name="challenges" data-maxlength="5000"></textarea>
											</c:if>
										<%} %>
										<div class="case-studies-character-count"></div>
									</li>

									<li>
									    <liferay-ui:error key="objectives-required" message="objectives-required" />
										<p><b><span class="red">*</span> <em>Objectives:</em></b></p>
										<p>Describe the objectives which triggered the adaptation measures (1000 char limit).</p>
											<% if (measure != null && measure.getObjectives() != null) { %>
											     <textarea id="<portlet:namespace />objectivesField" cols="40" rows="10" class="WYSIWYG" name="objectives" data-maxlength="1000"><%= HtmlUtil.escapeAttribute(measure.getObjectives())%></textarea>
											<%} else {
												// preserve the render parameter already set
												//String renderObjectives = renderRequest.getParameter("objectives");
												if (measureFromRequest != null)
											    {
													String renderObjectives = HtmlUtil.escapeAttribute(measureFromRequest.getObjectives());
													pageContext.setAttribute("renderObjectives", renderObjectives);
											    }
											%>
												<c:if test="${renderObjectives ne null}">
												  <textarea id="<portlet:namespace />objectivesField" cols="40" rows="10" class="WYSIWYG" name="objectives" data-maxlength="1000">${renderObjectives}</textarea>
												</c:if>

												<c:if test="${renderObjectives eq null}">
												 <textarea id="<portlet:namespace />objectivesField" cols="40" rows="10" class="WYSIWYG" name="objectives" data-maxlength="1000"></textarea>
												</c:if>
											<%} %>
										<div class="case-studies-character-count"></div>
									</li>

									<li>
									    <liferay-ui:error key="adaptationOptions-required" message="adaptationOptions-required" />
										<p><b><span class="red">*</span> <em>Adaptation Options Implemented In The Case:</em></b></p>
										<p>Select one or more adaptation options that this case study addresses.</p>
										<div class="scrolling-container">
											<ul class="two-col">
											    <%

												    DynamicQuery query = DynamicQueryFactoryUtil.forClass(Measure.class);
													query.add(PropertyFactoryUtil.forName("mao_type").eq("M"));
													query.add(PropertyFactoryUtil.forName("controlstatus").eq(new Short((short)1)));
													List results = MeasureLocalServiceUtil.dynamicQuery(query);
													List<Measure> listOfMeasure = (List<Measure>) results;

													// look for the selected values
													String chosenAdaptOptions = "";
													if (measure != null && Validator.isNotNull(measure.getAdaptationoptions()))
													{
														chosenAdaptOptions = measure.getAdaptationoptions();
													}
													else if (measureFromRequest != null)
													{
														chosenAdaptOptions = measureFromRequest.getAdaptationoptions();
													}
													String[] adaptOptionsArray = chosenAdaptOptions.split(";");

													// store the adaptoptions and the selected adapt options in page scope
													pageContext.setAttribute("adaptoptions", listOfMeasure);
													pageContext.setAttribute("chosenAdaptOptions", chosenAdaptOptions);
													pageContext.setAttribute("adaptOptionsArray", adaptOptionsArray);
											    %>

												<c:forEach var="option" items="${adaptoptions}" >
														<c:set var="chosenOption" value="false" />
														<c:forEach var="adaptOption" items="${adaptOptionsArray}">
															<c:choose>
																<c:when test="${adaptOption eq option.measureId}">
																	<c:set var="chosenOption" value="true" />
																</c:when>
															</c:choose>
														</c:forEach>
														<div class="check">
														  <c:choose>
														    <c:when test="${chosenOption}">
															   <li><label for="chk_adaptoption_${option.name}"><input type="checkbox" class="adaptoptionsfromdb" name="chk_adaptoptions" id="chk_adaptoption_${option.name}" value="${option.measureId}" checked/><a href='/viewmeasure?ace_measure_id=${option.measureId}' target="view adaptation">${option.name}</a></label></li>
															</c:when>
															<c:otherwise>
															   <li><label for="chk_adaptoption_${option.name}"><input type="checkbox" class="adaptoptionsfromdb" name="chk_adaptoptions" id="chk_adaptoption_${option.name}" value="${option.measureId}" /><a href='/viewmeasure?ace_measure_id=${option.measureId}' target="view adaptation">${option.name}</a></label></li>
															</c:otherwise>
														  </c:choose>
														</div>
												</c:forEach>
											</ul>
										</div>
										<div class="case-studies-form-clearing"></div>

									</li>


									<li>
									    <liferay-ui:error key="solutions-required" message="solutions-required" />
										<p><b><span class="red">*</span> <em>Solutions:</em></b></p>
										<p>Describe the climate change adaptation solution(s) implemented (5,000 char limit).</p>

										<% if (measure != null && Validator.isNotNull(measure.getSolutions())) { %>
										      <textarea id="<portlet:namespace />solutionsField" cols="40" rows="10" class="WYSIWYG" name="solutions" data-maxlength="5000"><%= HtmlUtil.escapeAttribute(measure.getSolutions()) %></textarea>
										<%} else {
											// preserve the render parameter already set
											// String renderSolutions = renderRequest.getParameter("solutions");
											if (measureFromRequest != null)
											{
													String renderSolutions = HtmlUtil.escapeAttribute(measureFromRequest.getSolutions());
													pageContext.setAttribute("renderSolutions", renderSolutions);
											}
											//pageContext.setAttribute("renderSolutions", renderSolutions);
										%>
											<c:if test="${renderSolutions ne null}">
											  <textarea id="<portlet:namespace />solutionsField" cols="40" rows="10" class="WYSIWYG" name="solutions" data-maxlength="5000">${renderSolutions}</textarea>
											</c:if>

											<c:if test="${renderSolutions eq null}">
											  <textarea id="<portlet:namespace />solutionsField" cols="40" rows="10" class="WYSIWYG" name="solutions" data-maxlength="5000"></textarea>
											</c:if>
										<%} %>
										<div class="case-studies-character-count"></div>
									</li>
									<li>
									    <liferay-ui:error key="relevance-required" message="relevance-required" />
										<p><b><span class="red">*</span> <em>Importance and Relevance of Adaptation :</em></b></p>
										<p>Select one or more descriptions below that best describes how relevant this case study is to Climate Adaptation.</p>
										<ul class="one-col">
										    <%
										         String choosenrelevance = "";
										         if (measure == null )
										         {

										             if (measureFromRequest != null)
										             {

										                 String relevanceOptions = measureFromRequest.getRelevance();
											        	 for (nl.wur.alterra.cgi.ace.model.constants.AceItemRelevance relevance : nl.wur.alterra.cgi.ace.model.constants.AceItemRelevance.values())
											        	 {

											        			 if (relevanceOptions != null && relevanceOptions.indexOf(relevance.toString()) >= 0) {
											                         choosenrelevance += relevance.toString() + ";";
											                     }

											        	 }
										             }
										         }
										    %>
											<c:forEach var="adaptationRelevance" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemRelevance.values() %>" >
												<div class="check">
													<c:set var="adaptationRelevanceMustBeChecked" value="false" />
													<c:set var="aceItemRelevance" value='<%= measure == null ? choosenrelevance : measure.getRelevance() %>' />
													<c:set var="adaptationRelevanceMustBeChecked" value="false" />
													<c:if test="${fn:indexOf(aceItemRelevance, adaptationRelevance)>=0}">
														<c:set var="adaptationRelevanceMustBeChecked" value="true" />
													</c:if>
													<c:choose>
														<c:when test="${adaptationRelevanceMustBeChecked}">
															<li><label for="chk_relevance_${adaptationRelevance}"><input type="checkbox" name="chk_relevance_${adaptationRelevance}" id="chk_relevance_${adaptationRelevance}" value="${adaptationRelevance}" checked="checked" /><liferay-ui:message key="aceitem-relevance-lbl-${adaptationRelevance}" /></label></li>
														</c:when>
														<c:otherwise>
															<li><label for="chk_relevance_${adaptationRelevance}"><input type="checkbox" name="chk_relevance_${adaptationRelevance}" id="chk_relevance_${adaptationRelevance}" value="${adaptationRelevance}" /><liferay-ui:message key="aceitem-relevance-lbl-${adaptationRelevance}" /></label></li>
														</c:otherwise>
													</c:choose>
												</div>
											</c:forEach>
										</ul>
										<div class="case-studies-form-clearing"></div>
									</li>
								     <% } %> <!--  end of if measure -->

									<li>
									    <liferay-ui:error key="keywords-required" message="keywords-required" />
										<p><b><span class="red">*</span> <em>Keywords:</em></b></p>
										<p>Describe and tag this <%=nameOfClimateEntityShortText.toLowerCase() %> with relevant keywords. Separate each keyword with a comma. For example, example keyword 1, example keyword 2  (1,000 char limit).</p>

										<% if (measure != null && Validator.isNotNull(measure.getKeywords())) { %>
										      <textarea id="<portlet:namespace />keywordsField" cols="40" rows="10" class="WYSIWYG" name="keywords" data-maxlength="1000"><%= HtmlUtil.escapeAttribute(measure.getKeywords()) %></textarea>
										<%} else {
											// preserve the render parameter already sent
											//String renderKeywords = renderRequest.getParameter("keywords");
											if (measureFromRequest != null)
											{
													String renderKeywords = HtmlUtil.escapeAttribute(measureFromRequest.getKeywords());
													pageContext.setAttribute("renderKeywords", renderKeywords);
											}
											//pageContext.setAttribute("renderKeywords", renderKeywords);
										%>
											<c:if test="${renderKeywords ne null}">
											  <textarea id="<portlet:namespace />keywordsField" cols="40" rows="10" class="WYSIWYG" name="keywords" data-maxlength="1000">${renderKeywords}</textarea>
											</c:if>

											<c:if test="${renderKeywords eq null}">
											 <textarea id="<portlet:namespace />keywordsField" cols="40" rows="10" class="WYSIWYG" name="keywords" data-maxlength="1000"></textarea>
											</c:if>
										<%} %>
										<div class="case-studies-character-count"></div>
									</li>

									<li>
									    <liferay-ui:error key="adaptationSector-required" message="adaptationSector-required" />
										<p><b><span class="red">*</span> <em>Relevant policy sectors</em></b></p>
										<% if (mao_type.equalsIgnoreCase("A")) { %>
										   <p>Select one or more relevant sector policies that this case study explicitly covers.</p>
										<% } else { %>
										   <p>Select one or more relevant sector policies that this adaptation option relates to.</p>
										<% } %>
										<ul class="three-col">
										     <%
										         String choosensectors = "";
										         if (measure == null )
										         {

										             if (measureFromRequest != null)
										             {

										                 String adaptationSectors = measureFromRequest.getSectors_();
											        	 for (nl.wur.alterra.cgi.ace.model.constants.AceItemSector sector : nl.wur.alterra.cgi.ace.model.constants.AceItemSector.values())
											        	 {
											        			 if (adaptationSectors != null && adaptationSectors.indexOf(sector.toString()) >= 0) {
											                         choosensectors += sector.toString() + ";";
											                     }

											        	 }
										             }


										         }
										    %>
											<c:forEach var="adaptationSector" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemSector.values() %>" >
												<div class="check">
													<c:set var="aceItemSectors" value='<%= measure == null ? choosensectors : measure.getSectors_() %>' />
													<c:set var="adaptationSectorMustBeChecked" value="false" />
													<c:if test="${fn:indexOf(aceItemSectors, adaptationSector)>=0}">
														<c:set var="adaptationSectorMustBeChecked" value="true" />
													</c:if>
													<c:choose>
														<c:when test="${adaptationSectorMustBeChecked}">
															<li><label for="chk_sectors_${adaptationSector}"><input type="checkbox" name="chk_sectors_${adaptationSector}" id="chk_sectors_${adaptationSector}" value="${adaptationSector}" checked="checked" /><liferay-ui:message key="acesearch-sectors-lbl-${adaptationSector}" /></label></li>
														</c:when>
														<c:otherwise>
															<li><label for="chk_sectors_${adaptationSector}"><input type="checkbox" name="chk_sectors_${adaptationSector}" id="chk_sectors_${adaptationSector}" value="${adaptationSector}" /><liferay-ui:message key="acesearch-sectors-lbl-${adaptationSector}" /></label></li>
														</c:otherwise>
													</c:choose>
												</div>
											</c:forEach>
										</ul>
										<div class="case-studies-form-clearing"></div>
									</li>


									<li>
									    <%
										     if (mao_type.equalsIgnoreCase("A"))
										     {
									        	 localDescription = "Date of case study publication or update";
									         }
									         else
									         {
									        	 localDescription = "Date of publication of Adaptation option's related source (e.g. Report, Publication, Guidance, Project, etc.)";
									         }
									   %>
									    <liferay-ui:error key="year-required" message="year-required" />
										<p><b><%if (mao_type.equalsIgnoreCase("A")) { %><span class="red">*</span><%} %> <em>Year:</em></b></p>
										<p><%=localDescription%></p>

										<% if (measure != null && Validator.isNotNull(measure.getYear())) { %>
										      <input name="year" type="text" size="5" maxlength="4" value="<%= measure.getYear() %>" /><br /><br />
										<%} else {
											// preserve the render parameter already sent
											//String renderKeywords = renderRequest.getParameter("keywords");
											if (measureFromRequest != null)
											{
													String year = measureFromRequest.getYear();
													pageContext.setAttribute("year", year);
											}

										%>
											<c:if test="${year ne null}">
											  <input name="year" type="text" size="5" maxlength="4" value="<%= measureFromRequest.getYear() %>" /><br /><br />
											</c:if>

											<c:if test="${year eq null}">
											  <input name="year" type="text" size="5" maxlength="4" value="" /><br /><br />
											</c:if>
										<%} %>
									</li>



								</ul>
							</div>

							<div class="case-studies-tabbed-content-button-row">
							    <a href="#" class="case-studies-tabbed-content-button-green" onClick="submitform('save')">Save as Draft</a>
								<a href="#" class="case-studies-tabbed-content-button-green case-studies-tabbed-content-button-next">Next - Additional Details</a>
							</div>
						</li>

						<li>
							<div class="case-studies-tabbed-content-header"><%=nameOfClimateEntityShortText %> - <em>Additional Details</em></div>

							<% if (mao_type.equalsIgnoreCase("M")) {

								    ArrayList categorySelList = new ArrayList();
								    String[] categoryList = {"Grey","Green","Soft"};

								    Measure tempMeasure = null;
								    if (measure != null )
								    {
								    	tempMeasure = measure;
								    }
								    else if (measureFromRequest != null)
								    {
								    	tempMeasure = measureFromRequest;
								    }

								    if (tempMeasure != null && Validator.isNotNull(tempMeasure))
								    {
								    	for (String s: tempMeasure.getCategory().split(";"))
								    	{
								    		categorySelList.add(s);
								    	}
								    }

								    pageContext.setAttribute("categoryList", categoryList);
								    pageContext.setAttribute("categoryListSelected", categorySelList);

								%>

							<div class="case-studies-tabbed-content-section">
								<div class="case-studies-tabbed-content-subheader">Category</div>
								  <ul>
								     <li>
									   <p><em>Select one or more categories of adaptation options: The 3 options are:</em>
									   <ul class="case-studies-tabbed-content-bullted-list">
		                                    <li>Grey: technological and engineering solutions aiming mainly at the protection of infrastructures or people.</li><br/>
		                                    <li>Green: ecosystem-based approaches that use the multiple services of nature aiming at raising the resilience of ecosystems and their services.</li><br/>
		                                    <li>Soft: managerial, legal and policy approaches that alter human behavior and styles of governance (e.g. spatial planning and policies),
		                                        including financial/fiscal instruments, such as insurance</li><br/>
	                                    </ul>

									   <ul class="three-col">
									      <c:forEach var="category" items="${categoryList}">
									         <c:choose>
									              <c:when test="${fn:contains(categoryListSelected, fn:toLowerCase(category))}">
									                 <li><label for="${category}"><input type="checkbox" name="chk_categories" id="chk_category_${fn:toLowerCase(category)}" value="${fn:toLowerCase(category)}" checked />${category}</label></li>
									              </c:when>
									              <c:otherwise>
									                 <li><label for="${category}"><input type="checkbox" name="chk_categories" id="chk_category_${fn:toLowerCase(category)}" value="${fn:toLowerCase(category)}" />${category}</label></li>
									              </c:otherwise>
									         </c:choose>
									      </c:forEach>

									   </ul>
									  </p>
									</li>
								  </ul>

							</div>
						   <% } %>

							<div class="case-studies-tabbed-content-section">
								<div class="case-studies-tabbed-content-subheader">Stakeholder Participation</div>
								<ul>
									<li>
									    <%
									         if (mao_type.equalsIgnoreCase("A"))
										     {
									        	 localDescription = "Date of case study publication or update";
									         }
									         else
									         {
									        	 localDescription = "Describe the Information about actors involved, the form of participation and the participation process. Focus should be on the level of participation needed and/or adopted already (from information, to full commitment in the deliberation/implementation process), with useful notes e.g. regarding motivations. (5,000 character limit)";
									         }
									    %>
										<p><em><%=localDescription %></em>
											<% if (mao_type.equalsIgnoreCase("A")) {  %>
											<ul class="case-studies-tabbed-content-bullted-list">
												<li>The actors involved</li>
												<li>The form of participation</li>
												<li>The participation process</li>
												<li>Notes regarding motivations, etc.</li>
											</ul>
											(5,000 char limit)
										   <% } %>
										</p>

										<% if (measure != null && Validator.isNotNull(measure.getStakeholderparticipation())) { %>
										      <textarea id="<portlet:namespace />stakeField" cols="40" rows="10" class="WYSIWYG" name="stakeholderparticipation" data-maxlength="5000"><%= HtmlUtil.escapeAttribute(measure.getStakeholderparticipation()) %></textarea>
										<%} else {
											// preserve the render parameter already sent
											//String renderStake = renderRequest.getParameter("stakeholderparticipation");
											if (measureFromRequest != null)
											{
													String renderStake = HtmlUtil.escapeAttribute(measureFromRequest.getStakeholderparticipation());
													pageContext.setAttribute("renderStake", renderStake);
											}
											//pageContext.setAttribute("renderStake", renderStake);
										%>
											<c:if test="${renderStake ne null}">
											  <textarea id="<portlet:namespace />stakeField" cols="40" rows="10" class="WYSIWYG" name="stakeholderparticipation" data-maxlength="5000">${renderStake}</textarea>
											</c:if>

											<c:if test="${renderStake eq null}">
											 <textarea id="<portlet:namespace />stakeField" cols="40" rows="10" class="WYSIWYG" name="stakeholderparticipation" data-maxlength="5000">${renderStake}</textarea>
											</c:if>
										<%} %>
										<div class="case-studies-character-count"></div>
									</li>
								</ul>
							</div>

							<div class="case-studies-tabbed-content-section">
								<div class="case-studies-tabbed-content-subheader">Success and Limiting Factors</div>
								<ul>
									<li>
									     <%
									         if (mao_type.equalsIgnoreCase("A"))
										     {
									        	 localDescription = "Describe";
									         }
									         else
									         {
									        	 localDescription = "Describe factors that are decisive for a successful implementation and expected challenges or limiting factors which may hinder the process and need to be considered (5,000 character limit)";
									         }
									    %>
										<p><em><%=localDescription %></em>

										<%
									    if (mao_type.equalsIgnoreCase("A"))
										{ %>
											<ul class="case-studies-tabbed-content-bullted-list">
												<li>The factors that were decisive for a successful implementation</li>
												<li>The factors that hindered in the process and needed to be overcome.</li>
											</ul>
											(5,000 char limit)</p>
										<%
										}
										%>

										<% if (measure != null && Validator.isNotNull(measure.getSucceslimitations())) { %>
										      <textarea id="<portlet:namespace />successField" cols="40" rows="10" class="WYSIWYG" name="succeslimitations" data-maxlength="5000"><%= HtmlUtil.escapeAttribute(measure.getSucceslimitations()) %></textarea>
										<%} else {
											// preserve the render parameter already sent
											//String renderSuccess = renderRequest.getParameter("succeslimitations");
											if (measureFromRequest != null)
											{
													String renderSuccess = HtmlUtil.escapeAttribute(measureFromRequest.getSucceslimitations());
													pageContext.setAttribute("renderSuccess", renderSuccess);
											}
											//pageContext.setAttribute("renderSuccess", renderSuccess);
										%>
											<c:if test="${renderSuccess ne null}">
											  <textarea id="<portlet:namespace />successField" cols="40" rows="10" class="WYSIWYG" name="succeslimitations" data-maxlength="5000">${renderSuccess}</textarea>
											</c:if>

											<c:if test="${renderSuccess eq null}">
											 <textarea id="<portlet:namespace />successField" cols="40" rows="10" class="WYSIWYG" name="succeslimitations" data-maxlength="5000"></textarea>
											</c:if>
										<%} %>
										<div class="case-studies-character-count"></div>
									</li>
								</ul>
							</div>

							<div class="case-studies-tabbed-content-section">
								<div class="case-studies-tabbed-content-subheader">Costs and Benefits</div>
								<ul>
								  	<li>
								   <% if (mao_type.equalsIgnoreCase("A")) { %>
										<p><em>Describe <b>costs</b> of this case study. Include:</em>
										<ul class="case-studies-tabbed-content-bullted-list">
											<li>Cost Estimates</li>
											<li>Funding source (national/EU, name of source, e.g. Life+)</li>
										</ul>
										<p>Describe the <b>benefits</b> of the case study:</p>
										<ul class="case-studies-tabbed-content-bullted-list">
											<li>List all positive outcomes in relation to climate change adaptation</li>
											<li>Co-benefits in other areas</li>
											<li>How they have been estimated (not only monetization of benefits for cost benefit analysis, but general indicators of effectiveness of actions implemented.</li>
										</ul>
										(5,000 char limit)
										</p>
									<% } else { %>
									    <p><em>Describe (5,000 character limit):</em>
										<ul class="case-studies-tabbed-content-bullted-list">
											<li>Costs: Focus should be on the typical main costs (with estimation per unit of intervention if possible).</li>
											<li>Benefits: Description of all the positive outcomes - in relation to climate change adaptation or as co-benefits - and how they can be estimated: not only monetisation of benefits for cost/benefit </li>
										</ul>
										</p>

								       <% } %>

										<% if (measure != null && Validator.isNotNull(measure.getCostbenefit())) { %>
										      <textarea id="<portlet:namespace />costField" cols="40" rows="10" class="WYSIWYG" name="costbenefit" data-maxlength="5000"><%= HtmlUtil.escapeAttribute(measure.getCostbenefit()) %></textarea>
										<%} else {
											// preserve the render parameter already sent
											//String renderCost = renderRequest.getParameter("costbenefit");
											if (measureFromRequest != null)
											{
													String renderCost = HtmlUtil.escapeAttribute(measureFromRequest.getCostbenefit());
													pageContext.setAttribute("renderCost", renderCost);
											}
											//pageContext.setAttribute("renderCost", renderCost);
										%>
											<c:if test="${renderCost ne null}">
											  <textarea id="<portlet:namespace />costField" cols="40" rows="10" class="WYSIWYG" name="costbenefit" data-maxlength="5000">${renderCost}</textarea>
											</c:if>

											<c:if test="${renderCost eq null}">
											 <textarea id="<portlet:namespace />costField" cols="40" rows="10" class="WYSIWYG" name="costbenefit" data-maxlength="5000"></textarea>
											</c:if>
										<%} %>

										<div class="case-studies-character-count"></div>
									</li>
								</ul>
							</div>

							<div class="case-studies-tabbed-content-section">
							    <%
							         if (mao_type.equalsIgnoreCase("A"))
								     {
							        	 localDescription = "Describe";
							         }
							         else
							         {
							        	 localDescription = "Describe the Legislation framework from which the case originated, relevant institutional opportunities and constrains, which determined the case as it is (5000 character limit)";
							         }
								%>
								<div class="case-studies-tabbed-content-subheader">Legal Aspects</div>
								<ul>
									<li>
										<p><em><%=localDescription %>:</em>
										<% if (mao_type.equalsIgnoreCase("A")) { %>
											<ul class="case-studies-tabbed-content-bullted-list">
												<li>The legislation framework from which the case originated.</li>
												<li>The relevant institutional opportunities.</li>
											</ul>
											(5,000 char limit)
										<% } %>
										</p>

										<% if (measure != null && Validator.isNotNull(measure.getLegalaspects())) { %>
										      <textarea id="<portlet:namespace />legalField" cols="40" rows="10" class="WYSIWYG" name="legalaspects" data-maxlength="5000"><%= HtmlUtil.escapeAttribute(measure.getLegalaspects()) %></textarea>
										  <%} else {
											// preserve the render parameter already sent
											//String renderLegal = renderRequest.getParameter("legalaspects");
											if (measureFromRequest != null)
											{
													String renderLegal = HtmlUtil.escapeAttribute(measureFromRequest.getLegalaspects());
													pageContext.setAttribute("renderLegal", renderLegal);
											}
											//pageContext.setAttribute("renderLegal", renderLegal);
										%>
											<c:if test="${renderLegal ne null}">
											  <textarea id="<portlet:namespace />legalField" cols="40" rows="10" class="WYSIWYG" name="legalaspects" data-maxlength="5000">${renderLegal}</textarea>
											</c:if>

											<c:if test="${renderLegal eq null}">
											  <textarea id="<portlet:namespace />legalField" cols="40" rows="10" class="WYSIWYG" name="legalaspects" data-maxlength="5000"></textarea>
											</c:if>
										<%} %>

										<div class="case-studies-character-count"></div>
									</li>
								</ul>
							</div>

							<div class="case-studies-tabbed-content-section">
								<div class="case-studies-tabbed-content-subheader">Implementation Time</div>
								<ul>
									<li>
										<p><em>Describe the time needed to implement the measure. Include:</em>
										<ul class="case-studies-tabbed-content-bullted-list">
											<li>Time frame, e.g. 5-10 years</li>
											<li>Brief explanation</li>
										</ul>
										(250 char limit)</p>
										<%
										  String implTime = "";
										  if (measure == null || Validator.isNull(measure.getImplementationtime())) {

											  if (measureFromRequest != null && measureFromRequest.getImplementationtime() != null)
											  {
												        implTime = HtmlUtil.escapeAttribute(measureFromRequest.getImplementationtime());
											  }

										  }
										%>
										<textarea name="implementationtime" id="<portlet:namespace />implField" rows="10" cols="40" class="WYSIWYG" data-maxLength="250"><%= measure == null ? implTime : HtmlUtil.escapeAttribute(measure.getImplementationtime()) %></textarea>
										<div class="case-studies-character-count"></div>
									</li>
								</ul>
							</div>

							<div class="case-studies-tabbed-content-section">
								<div class="case-studies-tabbed-content-subheader">Lifetime</div>
								<ul>
									<li>
										<p><em>Describe the lifetime of the measure:</em>
										<ul class="case-studies-tabbed-content-bullted-list">
											<li>Time frame, e.g. 5-10 years</li>
											<li>Brief explanation</li>
										</ul>
										(250 char limit)</p>
										<%
										  String lifeTime = "";
										  if (measure == null || Validator.isNull(measure.getLifetime())) {

											  if (measureFromRequest != null && measureFromRequest.getLifetime() != null)
											  {
												        lifeTime = HtmlUtil.escapeAttribute(measureFromRequest.getLifetime());
											  }
										  }
										%>

										<textarea name="lifetime"  id="<portlet:namespace />lifeTimeField" rows="10" cols="40" class="WYSIWYG" data-maxLength="250"><%= measure == null ? lifeTime : HtmlUtil.escapeAttribute(measure.getLifetime()) %></textarea>
										<div class="case-studies-character-count"></div>
									</li>
								</ul>
							</div>

							<div class="case-studies-tabbed-content-button-row">
								<a href="#" class="case-studies-tabbed-content-button-green case-studies-tabbed-content-button-previous case-studies-tabbed-content-float-left">Back To <%= descriptionOfClimateEntityText %></a>
								<a href="#" class="case-studies-tabbed-content-button-green" onClick="submitform('save')">Save as Draft</a>
								<a href="#" class="case-studies-tabbed-content-button-green case-studies-tabbed-content-button-next">Next - Reference Information</a>
							</div>
						</li>

						<li>
							<div class="case-studies-tabbed-content-header"><%=nameOfClimateEntityShortText %>  - <em>Reference Information</em></div>
							<p>Please provide the contact and reference information below so that other people interested in this case study may obtain more information about this case study.</p>

                            <% if (mao_type.equalsIgnoreCase("A")) { %>
							<div class="case-studies-tabbed-content-section">
								<div class="case-studies-tabbed-content-subheader"><span class="red">*</span> Contact</div>

                                <liferay-ui:error key="contact-required" message="contact-required" />
								<ul>
									<li>
										<p><em>Contact of reference (institution and persons) who is directly involved in the development and implementation of the case.</em> (500 char limit)</p>
										<%
										  String caseContact="";
										  if (measure == null || Validator.isNull(measure.getContact())) {
											  if (measureFromRequest != null && measureFromRequest.getContact() != null)
											  {
												  caseContact = HtmlUtil.escapeAttribute(measureFromRequest.getContact());
											  }
										  }
										%>
										<textarea name="contact"  id="<portlet:namespace />contactField" rows="10" cols="40" class="WYSIWYG" data-maxlength="500"><%= measure == null ? caseContact : HtmlUtil.escapeAttribute(measure.getContact()) %></textarea>
										<div class="case-studies-character-count"></div>
									</li>
								</ul>
							</div>
						  <% } %>

							<div class="case-studies-tabbed-content-section">
							    <div class="case-studies-tabbed-content-subheader"><span class="red">*</span>Website</div>
								<liferay-ui:error key="website-required" message="website-required" />

								<ul>
									<li>
											<%
										         if (mao_type.equalsIgnoreCase("A"))
											     {
										        	 localDescription = "List the Name and Website that refers to the original documents directly related to the case implementation process and its responsible actors (500 char limit). Please separate each website with semicolon.";
										         }
										         else
										         {
										        	 localDescription = "List the Name and Website where the option can be found or is described. Note: may refer to the original document describing a measure and does not have to refer back to the project e.g. collected measures (500 character limit). Please separate each website with semicolon.";
										         }
											%>
										<p><em><%=localDescription %></em></p>
										<%
										  String website = "";
										  if (measure == null || Validator.isNull(measure.getWebsite())) {
											  if (measureFromRequest != null && measureFromRequest.getWebsite() != null)
											  {
												        website = HtmlUtil.escapeAttribute(measureFromRequest.getWebsite());
											  }
										  }
										%>

										<textarea name="website" id="<portlet:namespace />websitefield" rows="10" cols="40" class="WYSIWYG" data-maxlength="500"><%= measure == null ? website : HtmlUtil.escapeAttribute(measure.getWebsite()) %></textarea>
										<div class="case-studies-character-count"></div>
									</li>
								</ul>
							</div>
							<div class="case-studies-tabbed-content-section">
							    <div class="case-studies-tabbed-content-subheader">Source</div>
							    <ul>
									<li>
									    <%
									         if (mao_type.equalsIgnoreCase("A"))
										     {
									        	 localDescription = "Original source of the case study description. For example, the name of the project, if the case study was taken from there.";
									         }
									         else
									         {
									        	 localDescription = "Describe the original source (like name of a certain project) of the adaptation option description (250 character limit)";
									         }
										%>
										<p><em><%=localDescription %></em></p>
										<%
										  String source = "";
										  if (measure == null || Validator.isNull(measure.getSource())) {
											  if (measureFromRequest != null && measureFromRequest.getSource() != null)
											  {
												        source = HtmlUtil.escapeAttribute(measureFromRequest.getSource());
											  }
										  }
										%>

										<textarea name="source"  id="<portlet:namespace />sourcefield" rows="10" cols="40" class="WYSIWYG" data-maxLength="250"><%= (measure == null || Validator.isNull(measure.getSource())) ? source : HtmlUtil.escapeAttribute(measure.getSource()) %></textarea>
										<div class="case-studies-character-count"></div>
									</li>
								</ul>
							</div>

							<div class="case-studies-tabbed-content-button-row">
								<a href="#" class="case-studies-tabbed-content-button-green case-studies-tabbed-content-button-previous case-studies-tabbed-content-float-left">Back To Additional Details</a>
								<a href="#" class="case-studies-tabbed-content-button-green" onClick="submitform('save')">Save as Draft</a>
								<a href="#" class="case-studies-tabbed-content-button-green case-studies-tabbed-content-button-next">Next - <%=uploadText %></a>
							</div>
						</li>


						<li>
						   <% if (mao_type.equalsIgnoreCase("A")) {  // the upload of illustrations only applies to case studies %>
							<div class="case-studies-tabbed-content-header">Case Study - <em><%=uploadText %></em></div>

							<div class="case-studies-tabbed-content-section">
							<liferay-ui:error key="photo-required" message="photo-required" />
								<div class="case-studies-tabbed-content-subheader"><span class="red">*</span> Primary Case Study Illustration</div>
								<p>Acceptable illustration formats include jpg,jpeg,png,bmp,gif</p>

								<ul>
									<li>
										<p><em>This illustration will be displayed on the page as a generic case study illustration. For more detailed and explanatory illustrations which can be enlarged use Additional Illustrations below.</em></p>
										<%
										  String primePhoto = "";
										  String primePhotoId = "";
										  if (measure == null ) {
											  if (measureFromRequest != null && Validator.isNotNull(measureFromRequest.getPrimephoto()))
											  {
												  DLFileEntry image = DLFileEntryLocalServiceUtil.getFileEntry(Long.parseLong(measureFromRequest.getPrimephoto()));
												  primePhoto = image.getName();
												  pageContext.setAttribute("primephotoname", primePhoto);
												  primePhotoId = measureFromRequest.getPrimephoto();
											  }
										  }
										  else if (Validator.isNotNull(measure.getPrimephoto()))
										  {
											  DLFileEntry image = DLFileEntryLocalServiceUtil.getFileEntry( Long.parseLong(measure.getPrimephoto()) );
											  primePhoto = HtmlUtil.escapeAttribute(image.getTitle());
											  pageContext.setAttribute("primephotoname", primePhoto);
										  }
										%>
										<p><em>Uploaded illustration: ${primephotoname}</em></p>
										<input name="primePhotoName" type="file"/>
										<input name="primephoto" type="hidden" value="<%= measure == null ? primePhotoId : measure.getPrimephoto() %>" />
									</li>
								</ul>
							</div>

							<div class="case-studies-tabbed-content-section">
							   <liferay-ui:error key="invalid-multiple-photo-upload" message="invalid-multiple-photo-upload" />
								<div class="case-studies-tabbed-content-subheader">Additional case study Illustrations</div>
								<p>Up to 5 additional illustrations can be added.</p>
								<%
									String supPhotos = "";
								   // String supPhotonames = "";
								    StringBuilder sphotosStr = new StringBuilder("");
									String[] sphotos = null;
									String[] sphotoNames = new String[5];
									String[] sphotoDescriptions = new String[5];
									String[] imageNames = new String[5];
									Long[] sphotoIds = new Long[5];


									 if (measure != null && Validator.isNotNull(measure.getSupphotos())) {

										 sphotos = measure.getSupphotos().split(";");
										 supPhotos = measure.getSupphotos();

									 }
									 else if (measureFromRequest != null && Validator.isNotNull(measureFromRequest.getSupphotos()))
									 {
										 sphotos = measureFromRequest.getSupphotos().split(";");
										 supPhotos =  measureFromRequest.getSupphotos();

									 }


									    if (sphotos != null)
									    {
									    	     int i = 0;
									             for (String photo:sphotos)
												 {
													 DLFileEntry image = DLFileEntryLocalServiceUtil.getFileEntry(Long.parseLong(photo));
													 String supPhotoName = image.getTitle();
													 String imageName = image.getName();
													 String supPhotoDescription = image.getDescription();
													 sphotoNames[i] = HtmlUtil.escapeAttribute(supPhotoName);
													 sphotoDescriptions[i] = HtmlUtil.escapeAttribute(supPhotoDescription);
													 imageNames[i] = imageName;
													 sphotoIds[i] = image.getFileEntryId();
													 i = i + 1;
												 }


									             pageContext.setAttribute("sphotonames", sphotoNames);
									             pageContext.setAttribute("sphotodesc", sphotoDescriptions);
									             pageContext.setAttribute("photocount", sphotos.length);
									             pageContext.setAttribute("imageNames", imageNames);
									             pageContext.setAttribute("sphotoids", sphotoIds);
									    }
									    else
									    {
									    	pageContext.setAttribute("photocount", 0);
									    }
								 %>

								<input name="supphotos" type="hidden" value="<%=supPhotos %>"/>

								<c:choose>
								<c:when test="${photocount gt 0 }">

								   <c:forEach begin="1" end="${photocount}" varStatus="loop">
								     <input name="sup_photos_ids${loop.count}" id="supPhotoId${loop.count}" type="hidden" value="${sphotoids[loop.count - 1]}" />
								     <ul class="case-studies-tabbed-content-photo-upload">
								      <li class="case-studies-tabbed-content-photo-upload-header">
										<b>Case Study Illustration <span class="case-studies-tabbed-content-photo-upload-position">${loop.count}</span>:</b>
										<a href="#" class="case-studies-tabbed-content-button-remove-photo-${loop.count}">[remove]</a>
									  </li>

									  <li>
										<p><b><em>Upload Case Study Illustration <span class="case-studies-tabbed-content-photo-upload-position">${loop.count}</span>:</em></b></p>
										<p><em>Uploaded illustration: ${sphotonames[loop.count - 1]}</em></p>
										<div class="inputfile"><input name="supphotofiles${loop.count }" type="file" /></div>
									  </li>

									  <li>
										<p><b><span class="red">*</span> <em>Case Study Illustration <span class="case-studies-tabbed-content-photo-upload-position">${loop.count}</span> Label:</em></b></p>
										<p>Brief name of illustration (required - 150 char limit)</p>
										<div class="inputfilename"><input type="text" name="sup_photos_names${loop.count}" size="30" maxlength="150" value="${sphotonames[loop.count - 1]}"></div>
									  </li>

									  <li>
										<p><b><span class="red">*</span> <em>Case Study Illustration <span class="case-studies-tabbed-content-photo-upload-position">${loop.count}</span> - Description of Illustration:</em></b></p>
										<div class="inputfiledescription"><textarea cols="40" rows="10" name="sup_photos_description${loop.count}" data-maxlength="250">${sphotodesc[loop.count - 1]}</textarea></div>

									  </li>
									 </ul>
								   </c:forEach>

									     <div class="case-studies-tabbed-content-single-button-row">
									       <a href="#" class="case-studies-tabbed-content-button-green case-studies-tabbed-content-button-add-photo">Add Another Illustration</a>
								         </div>

								    <input name="photocounter" type="hidden" id="photocounter" value="${photocount}" />
								</c:when>
								<c:otherwise>
								       <input name="sup_photos_id1" id="supPhotoId1" type="hidden" />
								       <input name="photocounter" id="photocounter" type="hidden" value="1" />
									   <ul class="case-studies-tabbed-content-photo-upload">
										<li class="case-studies-tabbed-content-photo-upload-header">
											<b>Case Study Illustration <span class="case-studies-tabbed-content-photo-upload-position">1</span>:</b>
										</li>
										<li>

											<p><b><em>Upload Case Study Illustration <span class="case-studies-tabbed-content-photo-upload-position">1</span>:</em></b></p>
											<div class="inputfile"><input name="supphotofiles1" type="file" /></div>

										</li>
										<li>
											<p><b><em>Additional Case Study Illustration <span class="case-studies-tabbed-content-photo-upload-position">1</span> Label:</em></b></p>
											<p>Brief name of illustration (required - 150 char limit)</p>
											<div class="inputfilename"><input type="text" name="sup_photos_names1" size="30" maxlength="150" value=""></div>
										</li>
										<li>
											<p><b><em>Case Study Illustration <span class="case-studies-tabbed-content-photo-upload-position">1</span> - Description of Illustration:</em></b></p>
											<div class="inputfiledescription"><textarea cols="40" rows="10" name="sup_photos_description1" data-maxlength="250"></textarea></div>
										</li>
									</ul>
									<div class="case-studies-tabbed-content-single-button-row">
										<a href="#" class="case-studies-tabbed-content-button-green case-studies-tabbed-content-button-add-photo">Add Another Illustration</a>
									</div>
								</c:otherwise>
							 </c:choose>
							</div>
						<% } // the upload of illustrations only applies to case studies %>

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
									String[] sdocDates = new String[5];
									String[] sdocSizes = new String[5];
								    String[] sdocDescriptions = new String[5];
									Long[] sdocIds = new Long[5];


									 if (measure != null && Validator.isNotNull(measure.getSupdocs())) {

										 // get the string array of doc ids
										 sdocs = measure.getSupdocs().split(";");
										 supDocs = measure.getSupdocs();

									 }
									 else if (measureFromRequest != null && Validator.isNotNull(measureFromRequest.getSupdocs()))
									 {
										 sdocs = measureFromRequest.getSupdocs().split(";");
										 supDocs =  measureFromRequest.getSupdocs();

									 }

									    // we have atleast one supplementary document
									    if (sdocs != null)
									    {

									             int i = 0;

									             for (String document:sdocs)
												 {

									            	 DLFileEntry file = DLFileEntryLocalServiceUtil.getDLFileEntry(Long.parseLong(document));
													 String supFileName = HtmlUtil.escapeAttribute(file.getTitle());
													 String supFileDescription = HtmlUtil.escapeAttribute(file.getDescription());
													 sdocNames[i] = supFileName;
													 Date supFileDate = file.getCreateDate();
													 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
													 long fileSizeInKB = file.getSize() / 1024;
													 sdocNames[i] = supFileName;
													 sdocDates[i] = dateFormat.format(supFileDate);
													 sdocSizes[i] = fileSizeInKB + " KB";
													 sdocDescriptions[i] = supFileDescription;
													 sdocIds[i] = file.getFileEntryId();
													 i = i + 1;
												 }


									             pageContext.setAttribute("sdocnames", sdocNames);
									             pageContext.setAttribute("sdocdates", sdocDates);
									             pageContext.setAttribute("sdocsizes", sdocSizes);
									             pageContext.setAttribute("sdocdesc", sdocDescriptions);
									             pageContext.setAttribute("sdocids", sdocIds);
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
								     	<input name="sup_docs_ids${loop.count}" id="supDocId${loop.count}" type="hidden" value="${sdocids[loop.count - 1]}" />
									     <ul class="case-studies-tabbed-content-document-upload">
									      <li class="case-studies-tabbed-content-document-upload-header">
											<b><span class="case-studies-tabbed-content-document-name">Document File - ${sdocnames[loop.count - 1]} ${sdocsizes[loop.count - 1]} (${sdocdates[loop.count - 1]})</span></b>
											<a href="#" class="case-studies-tabbed-content-button-remove-document-${loop.count}">[remove]</a>
										  </li>

										  <li>
											<p><b><em>Upload Document File <span class="case-studies-tabbed-content-document-upload-position">${loop.count}</span>:</em></b></p>
											<div class="inputfile"><input name="supdocfiles${loop.count }" type="file" /></div>
										  </li>

										  <li>
											<p><b><span class="red">*</span> <em>Additional Document Files <span class="case-studies-tabbed-content-document-upload-position">${loop.count}</span>:</em></b></p>
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
								       <input name="sup_docs_ids1" id="supDocId1" type="hidden"  />
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
											<p><b><span class="red">*</span> <em>Additional Document Files <span class="case-studies-tabbed-content-document-upload-position">1</span> Label:</em></b></p>
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

								<a href="#" class="case-studies-tabbed-content-button-green case-studies-tabbed-content-button-next">Next  - Geographic Information</a>
							</div>
						</li>

					<% if (mao_type.equalsIgnoreCase("A")) { %>
						<li id="liforgeo" class="active">
					<% } else { %>
					   <li>
					<%} %>
							<div class="case-studies-tabbed-content-header"><%=nameOfClimateEntityShortText %>  - <em>Geographic Information</em></div>

							<div class="case-studies-tabbed-content-section">
								<div class="case-studies-tabbed-content-subheader">Governance Level</div>
								<ul>
									<li>
										<p><em>Select the one governance level that relates to this <%=nameOfClimateEntityShortText.toLowerCase() %></em></p>
										<ul class="one-col">

											   <%
											         ArrayList trans = new ArrayList();
										        	 Measure measureStructure = null;
										        	 if (measure == null || Validator.isNull(measure.getGeos_()))
									        	     {
									        	    	 if (measureFromRequest != null)
									        	    	 {
									        	    		 measureStructure = measureFromRequest;
									        	    	 }
									        	     }
									        	     else
									        	     {
									        	    	 measureStructure = measure;
									        	     }

									        		 String geoValues = "";
									        		 if (measureStructure != null && Validator.isNotNull(measureStructure.getGeos_()))
									        		 {
									        			 geoValues = measureStructure.getGeos_();
									        		 }


										        	 for (nl.wur.alterra.cgi.ace.model.constants.AceItemGeos geo : nl.wur.alterra.cgi.ace.model.constants.AceItemGeos.values())
										        	 {
										        		 trans.add(geo.toString());

										        	 }
										    %>

										    <%-- Case study deas the governance level as radios whereas the adaptation option deals the governance level as check boxes --%>
										    <% if (mao_type.equalsIgnoreCase("A")) { %>
														<c:forEach var="geo" items="<%= trans  %>" >
																<c:set var="aceItemGeos" value='<%= geoValues %>' />
																<c:set var="adaptationGeoMustBeChecked" value="false" />
																<c:if test="${aceItemGeos eq geo}">
																	<c:set var="adaptationGeoMustBeChecked" value="true" />
																</c:if>
																<c:choose>
																	<c:when test="${adaptationGeoMustBeChecked}">
																		<li><label for="chk_geos_${geo}"><input type="radio" name="chk_geos_trans" id="chk_geos_trans" value="${geo}" checked="checked" /><liferay-ui:message key="aceitem-geos-lbl-${geo}" /></label></li>
																	</c:when>
																	<c:otherwise>
																		<li><label for="chk_geos_${geo}"><input type="radio" name="chk_geos_trans" id="chk_geos_trans" value="${geo}" /><liferay-ui:message key="aceitem-geos-lbl-${geo}" /></label></li>
																	</c:otherwise>
																</c:choose>
														</c:forEach>
											<% } else { %>
											        <c:forEach var="geo" items="<%= trans  %>" >
																<c:set var="aceItemGeos" value='<%= geoValues %>' />
																<c:set var="adaptationGeoMustBeChecked" value="false" />
																<c:if test="${fn:contains(aceItemGeos, geo)}">
																	<c:set var="adaptationGeoMustBeChecked" value="true" />
																</c:if>
																<c:choose>
																	<c:when test="${adaptationGeoMustBeChecked}">
																		<li><label for="chk_geos_${geo}"><input type="checkbox" class="governanceForAdaptation" name="chk_geos_trans" id="chk_geos_trans" value="${geo}" checked="checked" /><liferay-ui:message key="aceitem-geos-lbl-${geo}" /></label></li>
																	</c:when>
																	<c:otherwise>
																		<li><label for="chk_geos_${geo}"><input type="checkbox" class="governanceForAdaptation" name="chk_geos_trans" id="chk_geos_trans" value="${geo}" /><liferay-ui:message key="aceitem-geos-lbl-${geo}" /></label></li>
																	</c:otherwise>
																</c:choose>
													</c:forEach>
											<% } %>
										</ul>
									</li>
								</ul>
								<div class="case-studies-form-clearing"></div>
							</div>


							<div class="case-studies-tabbed-content-section">
								<div class="case-studies-tabbed-content-subheader">Geographic Characterisation</div>
								<liferay-ui:error key="geo-characterization-required" message="geo-characterization-required" />
								<ul>
									<li>
										<p><b><span class="red">* </span><em>Select the characterisation for this case study</em></b></p>
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




										        Measure measureForGeoChars = null;
										        if (measure != null)
										        {
										        	measureForGeoChars = measure;
										        }
										        else if (measureFromRequest != null)
										        {
										        	measureForGeoChars = measureFromRequest;
										        }

										        String elementSelected = "";
										        ArrayList macroTransElements = new ArrayList();
										        ArrayList biographicalElements = new ArrayList();
										        ArrayList subNationalElements = new ArrayList();
										        ArrayList countryElements = new ArrayList();
										        String city = "";

										        if (measureForGeoChars != null && Validator.isNotNull(measureForGeoChars.getGeochars()))
										        {

										        	try {
											        	Object obj=JSONValue.parse(measureForGeoChars.getGeochars());
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
														             <li><label for="rad_geochars_${geoCharElement}"><input type="radio" name="rad_geo_chars" id="europe_geo_chars" value="${geoCharElement}"  checked/><liferay-ui:message key="acesearch-geochars-lbl-${geoCharElement}" /> (If this <%=nameOfClimateEntityShortText.toLowerCase() %> applies to the whole of Europe, please select all the Macro-Transnational Regions below)</label></li>
														        </c:when>
														        <c:otherwise>
														           <li><label for="rad_geochars_${geoCharElement}"><input type="radio" name="rad_geo_chars" id="europe_geo_chars" value="${geoCharElement}" /><liferay-ui:message key="acesearch-geochars-lbl-${geoCharElement}" /> (If this <%=nameOfClimateEntityShortText.toLowerCase() %> applies to the whole of Europe, please select all the Macro-Transnational Regions below)</label></li>
														        </c:otherwise>
														     </c:choose>
														            <!-- <div class="europe_geochar_class">	 important - starting div for europe_geochar_class -->
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
										                 <span class="case-studies-tabbed-content-text-for-geochars"><input class="shared_form_city" type="text" size="50" maxlength="250" value="${city}" /></span>
										                </div>  <!-- important - closing div for europe_geochar_class -->
										               </c:when>
										               <c:otherwise>
										                 <!-- do nothing -->
										              </c:otherwise>
											        </c:choose>
										   </c:forEach>
										</ul>
									</li>
								</ul>
							   <div class="case-studies-form-clearing"></div>
							</div>

						  <% if (mao_type.equalsIgnoreCase("A")) { %>
							<div class="case-studies-tabbed-content-section">
								<div class="case-studies-tabbed-content-subheader">Map</div>
								<ul>
									<li>
										<p><em></em></p>

										<!--  <div class="case-studies-inline-errors">
											<img alt="error" src="<%=request.getContextPath()%>/assets/ico-error.jpg">
											<p>{ Field } Required - Enter Instructions Here</p>
											<div class="case-studies-form-clearing"></div>
										</div> -->

								   <%
										String m_checked = "";
										String a_checked = "";

								  %>

									<div id="locationselection">
										<div id="locator">
											<input type="text" name="location" id="location" />
											<a onclick="locate(document.getElementById('location').value)">Locate</a>
										</div>

										<div id='locations_element'></div>

										<div id="map_element" style='width: 500px; height: 500px;'></div>

										<b>lon</b><br />
										<input name="lon" id="lon" type="text" size="10" value='<%= measure == null ? "" : measure.getLon() %>'><br /><br />

										<b>lat</b><br />
										<input name="lat" id="lat" type="text" size="10" value='<%= measure == null ? "" : measure.getLat() %>'><br /><br />

										<a onclick="handleClick(event)">Apply</a><br /><br />

										<!--  <b>bio-geographical region</b><br />	-->
										<input name="satarea" id="satarea" type="hidden" size="50" maxlength="254" value='<%= measure == null ? "" : measure.getSatarea() %>'>
									  </div>

										<div id='map_element'></div>
											 <script>
												var proxyUrl = '<%= prefs.getValue(Constants.proxyUrlPreferenceName, "") %>';

												var geoserverUrl = '<%= prefs.getValue(Constants.geoserverUrlPreferenceName, "http://climate-adapt.eea.europa.eu/geoserver/") %>';

												var wms = '<%= prefs.getValue(Constants.wmsPreferenceName, "wms") %>';

												var wfs = '<%= prefs.getValue(Constants.wfsPreferenceName, "wfs") %>';

												var featureNamespace = '<%= prefs.getValue(Constants.featureNamespacePreferenceName, "http://climate-adapt.eea.europa.eu") %>';

												var areasFeatureType = '<%= prefs.getValue(Constants.areasFeatureTypePreferenceName, "biogeo_2008") %>';

												var areasLayer = '<%= prefs.getValue(Constants.areasLayerPreferenceName, "chm:biogeo_2008") %>';

												var caseStudiesFeatureType = '<%= prefs.getValue(Constants.caseStudiesFeatureTypePreferenceName, "casestudies") %>';

												var geometryColumn = '<%= prefs.getValue(Constants.geometryColumnPreferenceName, "geom") %>';

												var areaColumn = '<%= prefs.getValue(Constants.areaColumnPreferenceName, "area") %>';

												var locatorUrl = '<%= prefs.getValue(Constants.locatorUrlPreferenceName, "http://dev.virtualearth.net/REST/v1/Locations/") %>';

												var locatorKey = '<%= prefs.getValue(Constants.locatorKeyPreferenceName, "Ao9qujBzDtg-nFiusTjt5VQ9x2NJB2wAD7YCRjaPz7hQQjxdFcl24tyhOwCDCIrw") %>';

												var zoomLevel = '<%= prefs.getValue(Constants.zoomLevelPreferenceName, "2") %>';

												var measurechmmap;

												var locator;

											    Ext.onReady(function() {
											        measurechmmap = new CHM.MeasureCHMMap();

											        mappanel = new GeoExt.MapPanel({
											            renderTo: 'map_element',
											            height: 350,
											            width: 675,
											            map: measurechmmap
											        });

											        measurechmmap.addBingLayers();

											        measurechmmap.addMeasureLayers();

											    	measurechmmap.setOnMeasureChanged(this.measureChanged);

											    	measurechmmap.setOnAreaChanged(this.areaChanged);

											    	locator = new CHM.Locator('locations_element', {});

											    	locator.setOnLocationChanged(handleLocationChanged);

											    	handleClick(null);
											    	var el = Ext.get('liforgeo');
											    	el.removeClass('active');
											    });

												function handleLocationChanged() {
													measurechmmap.setMeasure(new CHM.Measure(locator.getLocation().x, locator.getLocation().y, new OpenLayers.Projection('EPSG:4326')));
												}

											    function handleClick(e) {
													measurechmmap.setMeasure(new CHM.Measure(document.getElementById('lon').value, document.getElementById('lat').value, new OpenLayers.Projection('EPSG:4326')));
												}

												function measureChanged() {
													var measure = measurechmmap.getMeasure(new OpenLayers.Projection('EPSG:4326'));

													document.getElementById('lon').value = measure.x;

													document.getElementById('lat').value = measure.y;
												}

												function areaChanged() {
													document.getElementById('satarea').value = measurechmmap.getArea();
												}

											    function locate(aLocation) {
											    	locator.locate(aLocation);
											    }
											</script>
									</li>
								</ul>
								<div class="case-studies-form-clearing"></div>
							</div>
						<%} %>

						<div class="case-studies-tabbed-content-section">
						 <div class="case-studies-tabbed-content-header"><em>Comments</em></div>
						   <p><em>Comments about this database item <i>[information entered below will not be displayed on the public pages of climate-adapt]</i></em></p>
						   <%
						       String comments = "";

						       if (measure != null && Validator.isNotNull(measure.getComments()) )
						       {
						    	   comments = HtmlUtil.escapeAttribute(measure.getComments());
						       }
						       else if (measureFromRequest != null && Validator.isNotNull(measureFromRequest.getComments()))
						       {
						    	   comments = HtmlUtil.escapeAttribute(measureFromRequest.getComments());
						       }

						   %>
						   <textarea rows="10" name="comments" style="border-color: blue; width:100%; border-style: solid; border-width: thin;"><%=comments %></textarea>
						</div>

							<div class="case-studies-tabbed-content-button-row">

								<a href="#" class="case-studies-tabbed-content-button-green case-studies-tabbed-content-button-previous case-studies-tabbed-content-float-left">Back To <%=uploadText %></a>

								<a href="#" class="case-studies-tabbed-content-button-green" onClick="submitform('save')">Save as Draft</a>
							    <% if (measure != null) { %>
							       <a href="#" class="case-studies-tabbed-content-button-green case-studies-tabbed-content-button-next">Next  - Review &amp Submit</a>
							    <%} %>
							</div>
						</li>

					<!-- REVIEW SECTION STARTS - show only if the form was already savedd -->
					<% if (measure != null) {
						if (justSaved != null) {
						%>
						      <li class="active">
						<%} else { %>
						      <li>
						 <% } %>

							<div class="case-studies-tabbed-content-header"><%=nameOfClimateEntityShortText %> - <em>Review &amp; Submit for Review Process</em></div>
							<p>Review the <%=nameOfClimateEntityShortText.toLowerCase() %> and submit the <%=nameOfClimateEntityShortText.toLowerCase() %> for <a href="#">review</a> for inclusion in the Climate- ADAPT Database. <b>Note</b> This preview page may appear slightly more narrow than the actual display. After this <%=nameOfClimateEntityShortText.toLowerCase() %> has been added to the database, the <%=nameOfClimateEntityShortText.toLowerCase() %> page will display slightly wider than it appears below.</p>

							<div class="case-studies-tabbed-content-button-row">
								<a href="#" class="case-studies-tabbed-content-button-green case-studies-tabbed-content-button-previous case-studies-tabbed-content-float-left">Back To Geographical Information</a>
								<a href="#" class="case-studies-tabbed-content-button-green" onClick="submitform('submit')">Submit for Review Process</a>
							</div>
							<br><br>

                            <% String yearDisplay = measure.getYear().length() > 0 ? "("+measure.getYear() + ")" : "";%>
							<div class="case-studies-tabbed-content-review-wrapper">
								<div class="case-studies-tabbed-content-review-column-left">
								 <% if (mao_type.equalsIgnoreCase("A")) { %>
									<div class="case-studies-tabbed-content-review-image-wrapper">
										<div class="case-studies-tabbed-content-review-image-label"></div>
										 <%
										    String primImageUrl = "";

										    if (Validator.isNotNull(measure.getPrimephoto()))
										    {
										      DLFileEntry image = DLFileEntryLocalServiceUtil.getFileEntry(Long.parseLong(measure.getPrimephoto()));
										      primImageUrl = themeDisplay.getPathImage() + "/image_gallery?uuid=" + image.getUuid() +  "&t=" + WebServerServletTokenUtil.getToken(image.getLargeImageId()) + "&groupId=" + image.getGroupId();
										    }
										 %>
										<img src="<%=primImageUrl %>" class="case-studies-tabbed-content-review-image"/>
									</div>

									<div style="padding-right: 10px;">
										<p class="case-studies-tabbed-content-review-header"><%= HtmlUtil.escapeAttribute(measure.getName()) %> <%=yearDisplay %></p>
										<p><%= measure.getDescription().replaceAll("<p>","").replaceAll("</p>","") %></p>
									</div>
							<% } else { %>
										 <div class="case-studies-tabbed-content-section">
										         <p class="case-studies-tabbed-content-review-header"><%=  HtmlUtil.escapeAttribute(measure.getName()) %> <%=yearDisplay %></p>
											     <p><%=  measure.getDescription().replaceAll("<p>","").replaceAll("</p>","") %></p>
										</div>
							<% } %>


									<div class="case-studies-form-clearing"></div>

									<div class="case-studies-tabbed-content-section">
										<ul>
										    <% if (mao_type.equalsIgnoreCase("A")) { %>
											<li>
												<p><b><em><%=nameOfClimateEntityShortText %> Description</em></b></p>
												<ul class="case-studies-tabbed-content-bullted-list">
												    <li><a href="#challenges_anchor">Challenges</a></li>
													<li><a href="#objectives_anchor">Objectives</a></li>
													<li><a href="#adapt_options_anchor">Adaptation Options Implemented In This Case</a></li>
													<li><a href="#solutions_anchor">Solutions</a></li>
													<li><a href="#relevance_anchor">Importance and Relevance of Adaptation</a></li>

												</ul>
											</li>
											<% } %>

										  <% if (Validator.isNotNull(measure.getCategory()) || Validator.isNotNull(measure.getStakeholderparticipation()) || Validator.isNotNull(measure.getSucceslimitations())
												    || Validator.isNotNull(measure.getCostbenefit()) || Validator.isNotNull(measure.getLegalaspects()) || Validator.isNotNull(measure.getImplementationtime())
												    || Validator.isNotNull(measure.getLifetime()) ) {  %>
											<li>
												<p><b><em>Additional Details</em></b></p>
												<ul class="case-studies-tabbed-content-bullted-list">
												  <%  if (Validator.isNotNull(measure.getCategory())) { %>
													<li><a href="#category_anchor">Category</a></li>
												  <% } %>
												  <%  if (Validator.isNotNull(measure.getStakeholderparticipation())) { %>
													<li><a href="#stake_holder_anchor">Stakeholder Participation</a></li>
												  <% } %>

												  <%  if (Validator.isNotNull(measure.getSucceslimitations())) { %>
													<li><a href="#success_limitations_anchor">Success and Limiting Factors</a></li>
												  <% } %>

												 <%  if (Validator.isNotNull(measure.getCostbenefit())) { %>
													<li><a href="#cost_benefit_anchor">Costs and Benefits</a></li>
												  <% } %>


												 <%  if (Validator.isNotNull(measure.getLegalaspects())) { %>
													<li><a href="#legal_aspect_anchor">Legal Aspects</a></li>
												  <% } %>

												  <%  if (Validator.isNotNull(measure.getImplementationtime())) { %>
													<li><a href="#implementation_time_anchor">Implementation Time</a></li>
												  <% } %>

												   <%  if (Validator.isNotNull(measure.getLifetime())) { %>
													<li><a href="#life_time_anchor">Life Time</a></li>
												  <% } %>
												</ul>
											</li>
										   <% } %>

											<li>
												<p><b><em>Reference Information</em></b></p>
												<ul class="case-studies-tabbed-content-bullted-list">
												   	<% if (mao_type.equalsIgnoreCase("A")) { %>
													<li><a href="#contact_anchor">Contact</a></li>
													<% } %>
													<li><a href="#website_anchor">Websites</a></li>
												   <%  if (Validator.isNotNull(measure.getSource())) { %>
													<li><a href="#source_anchor">Source</a></li>
												  <% } %>
												</ul>
											</li>
										</ul>
										<div class="case-studies-form-clearing"></div>
									</div>

                                 <% if (mao_type.equalsIgnoreCase("A")) { %>
									<div class="case-studies-tabbed-content-section">
									  <div class="case-studies-tabbed-content-subheader"><%=nameOfClimateEntityShortText %> Description</div>
										<ul>
										<% if (mao_type.equalsIgnoreCase("A")) { %>
											<li>
												<a name="challenges_anchor"><b><em>Challenges</em></b></a>
												   <p><%=measure.getChallenges().replaceAll("<p>","").replaceAll("</p>","") %></p>
												<div class="case-studies-form-clearing"></div>
											</li>

											<li>
												<a name="objectives_anchor"><b><em>Objectives</em></b></a>
												   <p><%=measure.getObjectives().replaceAll("<p>","").replaceAll("</p>","")%></p>
												<div class="case-studies-form-clearing"></div>
											</li>

											<li>
												<a name="adapt_options_anchor"><b><em>Adaptation Options</em></b></a>
												<%
												  //Listing all adaptation options
											      String[] adaptOptionsAry = null;

												  if (Validator.isNotNull(measure.getAdaptationoptions()))
												  {
													   String adaptOptions = measure.getAdaptationoptions();
													   adaptOptionsAry = adaptOptions.split(";");
													   Long selMeasuresInLong[] = new Long[adaptOptionsAry.length];
													         int ctr = 0;
													         for (String selMeasure : adaptOptionsAry)
													         {
													         	selMeasuresInLong[ctr] = Long.parseLong(selMeasure);
													         	ctr ++;
													         }

													    DynamicQuery query = DynamicQueryFactoryUtil.forClass(Measure.class);
														query.add(PropertyFactoryUtil.forName("measureId").in(selMeasuresInLong));
														List resultsForSelected = MeasureLocalServiceUtil.dynamicQuery(query);
														List<Measure> listOfSelectedMeasure = (List<Measure>) resultsForSelected;
														pageContext.setAttribute("listOfSelectedMeasure", listOfSelectedMeasure);
												   }
											       pageContext.setAttribute("adaptationOptionsForReview", adaptOptionsAry);

											%>
											   <c:if test="${adaptationOptionsForReview ne null }">
												   <p><p>
													    <c:forEach var="adaptoption" items="${listOfSelectedMeasure}">
													       &nbsp;&nbsp;&nbsp;<a href='/viewmeasure?ace_measure_id=${adaptoption.measureId}' target="view adaptation">${adaptoption.name}</a><br/>
													    </c:forEach>
													  </p>
												   </p>
											   </c:if>

													<div class="case-studies-form-clearing"></div>
											</li>

											<li>
												<a name="solutions_anchor"><b><em>Solutions</em></b></a>
												<p><%=measure.getSolutions().replaceAll("<p>","").replaceAll("</p>","") %></p>
												<div class="case-studies-form-clearing"></div>
											</li>

											<li>
												<a name="relevance_anchor"><b><em>Relevance</em></b></a>
												<%

												    String[] relevanceAry = null;
												    if (Validator.isNotNull(measure.getRelevance()))
												    {
												    	String relevance = measure.getRelevance();
												    	relevanceAry = relevance.split(";");
												    }
												    pageContext.setAttribute("relevanceForReview", relevanceAry);

												%>
												    <p><p>
													    <c:forEach var="relevance" items="${relevanceForReview}">
													     <c:if test="${relevanceForReview ne null}">
													       &nbsp;&nbsp;&nbsp;<liferay-ui:message key="aceitem-relevance-lbl-${relevance}" /><br/>
													     </c:if>
													    </c:forEach>
													  </p>
												   </p>
													<div class="case-studies-form-clearing"></div>
										   </li>
										   <% } %>
										</ul>
									</div>
								<% } %>

                                 <% if (Validator.isNotNull(measure.getCategory()) || Validator.isNotNull(measure.getStakeholderparticipation()) || Validator.isNotNull(measure.getSucceslimitations())
												    || Validator.isNotNull(measure.getCostbenefit()) || Validator.isNotNull(measure.getLegalaspects()) || Validator.isNotNull(measure.getImplementationtime())
												    || Validator.isNotNull(measure.getLifetime()) ) {  %>
									<div class="case-studies-tabbed-content-section">
										<div class="case-studies-tabbed-content-subheader">Additional Details</div>
										<ul>

										<% if (Validator.isNotNull(measure.getCategory()))
										{%>
											<li>
												<a name="category_anchor"><b><em>Category</em></b></a>

												<%
												   ArrayList catSelected = new ArrayList();

												   for(String s:  measure.getCategory().split(";"))
												   {
													   String temp = Character.toUpperCase(s.charAt(0)) + s.substring(1);
													   catSelected.add(temp);
												   }
												   pageContext.setAttribute("categories", catSelected);

												%>

											    <p><p>
											       <c:forEach var="category" items="${categories}">
											          ${category} <br/>
											       </c:forEach>
											      </p>
											    </p>

												<div class="case-studies-form-clearing"></div>
											</li>
										<%} %>


										 <% if (Validator.isNotNull(measure.getStakeholderparticipation()))
											{%>
												<li>
													<a name="stake_holder_anchor"><b><em>Stakeholder Participation</em></b></a>

												    <p><%=measure.getStakeholderparticipation().replaceAll("<p>","").replaceAll("</p>","") %></p>

													<div class="case-studies-form-clearing"></div>
												</li>
											<%} %>


									 <% if (Validator.isNotNull(measure.getSucceslimitations()))
										{%>
											<li>
												<a name="success_limitations_anchor"><b><em>Success and Limiting Factors</em></b></a>

											    <p><%=measure.getSucceslimitations().replaceAll("<p>","").replaceAll("</p>","") %></p>

												<div class="case-studies-form-clearing"></div>
											</li>
										<%} %>

									 <% if (Validator.isNotNull(measure.getCostbenefit()))
										{%>
											<li>
												<a name="cost_benefit_anchor"><b><em>Costs and Benefits</em></b></a>

											    <p><%=measure.getCostbenefit().replaceAll("<p>","").replaceAll("</p>","") %></p>

												<div class="case-studies-form-clearing"></div>
											</li>
										<%} %>

										<% if (Validator.isNotNull(measure.getLegalaspects()))
										   {%>
												<li>
													<a name="legal_aspect_anchor"><b><em>Legal Aspects</em></b></a>

												    <p><%=measure.getLegalaspects().replaceAll("<p>","").replaceAll("</p>","") %></p>

													<div class="case-studies-form-clearing"></div>
												</li>
										  <%} %>

										<% if (Validator.isNotNull(measure.getImplementationtime()))
										   {%>
												<li>
													<a name="implementation_time_anchor"><b><em>Implementation Time</em></b></a>

												    <p><%=measure.getImplementationtime().replaceAll("<p>","").replaceAll("</p>","") %></p>

													<div class="case-studies-form-clearing"></div>
												</li>
										  <%} %>

										  <% if (Validator.isNotNull(measure.getLifetime()))
										   {%>
												<li>
													<a name="life_time_anchor"><b><em>Life Time</em></b></a>

												    <p><%=measure.getLifetime().replaceAll("<p>","").replaceAll("</p>","") %></p>

													<div class="case-studies-form-clearing"></div>
												</li>
										  <%} %>
										</ul>
									</div>
								<% } %>

									<div class="case-studies-tabbed-content-section">
										<div class="case-studies-tabbed-content-subheader">Reference Information</div>
										<ul>
										   	<% if (mao_type.equalsIgnoreCase("A")) { %>
												<li>
													<a name="contact_anchor"><b><em>Contact</em></b></a>
													<p><%=measure.getContact().replaceAll("<p>","").replaceAll("</p>","") %></p>
													<div class="case-studies-form-clearing"></div>
												</li>
										    <% } %>

											<li>
												<a name="website_anchor"><b><em>Websites</em></b></a>
												<%
												   // replacing the <p> tag
												   String websiteForReview = HtmlUtil.extractText(measure.getWebsite());
												   String webSites[] = websiteForReview.split(";");
												%>
												<p>
												   <% for (String wsite: webSites) {
													   if (wsite.trim().length() > 0) {
												   %>
												   <a href="<%=wsite.trim()%>"><%=wsite.trim()%></a><br/><% }} %></p>
												<div class="case-studies-form-clearing"></div>
											</li>

										<% if (Validator.isNotNull(measure.getSource()))
										   {%>
												<li>
													<a name="source_anchor"><b><em>Source</em></b></a>

												    <p><%=measure.getSource().replaceAll("<p>","").replaceAll("</p>","") %></p>

													<div class="case-studies-form-clearing"></div>
												</li>
										 <%} %>

										</ul>
									</div>
                              </div> <!-- end of case-studies-tabbed-content-review-column-left  -->

							   <div class="case-studies-tabbed-content-review-column-right">
								 <%
								   if (Validator.isNotNull(measure.getSupphotos())) { %>

									    <div class="case-studies-tabbed-content-review-column-right-section">

								 <%
										 String[] sphotosInReview = measure.getSupphotos().split(";");
								 %>
								              <a href="#" id="case-studies-modal-link" class="bluebutton">Case Study Illustrations (<%= sphotosInReview.length %>)</a>
								              <div id="case-studies-modal" title="Case Study Illustrations">
						                        <div id="case-studies-modal-image-gallery">
						                          <ul>
								 <%      int photoCounter = 1;
										  String firstImageURL = null;
										  String firstImageAlt = null;
									     for (String photo:sphotosInReview)
									     {
													 DLFileEntry image = DLFileEntryLocalServiceUtil.getFileEntry(Long.parseLong(photo));
													 String supPhotoName = image.getName();
													 String supPhotoTitle = image.getTitle();
													 String supPhotoDescription = image.getDescription().replaceAll("<p>","").replaceAll("</p>","");
													 String imageUrl = themeDisplay.getPathImage() + "/image_gallery?uuid=" + image.getUuid() +  "&t=" + WebServerServletTokenUtil.getToken(image.getLargeImageId())  + "&groupId=" + image.getGroupId();
								 %>

								 <!-- =========================== -->
					             <!-- Slideshow Modal Starts Here -->
					             <!-- =========================== -->



							   <% if (photoCounter == 1) {
								     firstImageURL = imageUrl;
								     firstImageAlt = supPhotoName;
							    %>
								 <li class="active">
								<%} else { %>
								  <li>
								 <%} %>
									<h3 class="case-studies-modal-image-gallery-slide-label"><%=supPhotoTitle %></h3>
									<center>
										<img src="<%=imageUrl%>" alt="<%=supPhotoTitle %>" />
									</center>
									<p><%=supPhotoDescription.replaceAll("<p>","").replaceAll("</p>","") %></p>

								</li>

								 <% photoCounter ++;} // end of for  %>

										   </ul>
							                 <div class="case-studies-modal-image-gallery-navigation">
								                <a href="#" class="prev"><span>&lt;</span></a>
								                <a href="#" class="next"><span>&gt;</span></a>
							                </div>
									</div>
									</div>
									<% if (photoCounter >= 1) { %>
									<div class="firstImage">
									  <img src="<%=firstImageURL %>" alt="<%=firstImageAlt %>" width="160px" height="100px" />
									</div>
									 <% } %>
									</div>
								<% } // end of if %>

								 <%
								   if (Validator.isNotNull(measure.getSupdocs())) { %>

									    <div clas="case-studies-tabbed-content-review-column-right-section">
										<p><b>Documents</b></p>
										<ul class="case-studies-tabbed-content-bullted-list">

								 <%
										 String[] sdocsForReview = measure.getSupdocs().split(";");
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
										<%=measure.getKeywords().replaceAll("<p>","").replaceAll("</p>","") %><br/>
									</div>

									<div class="case-studies-tabbed-content-review-column-right-section">
										<%
										String[] climateImpactsAry = null;
									    if (Validator.isNotNull(measure.getClimateimpacts_()))
									    {
										    String climateImpacts = measure.getClimateimpacts_();
										    climateImpactsAry = climateImpacts.split(";");
									    }

									    pageContext.setAttribute("climateImpactsForReview", climateImpactsAry);

										%>
											<p><b>Climate impacts</b></p>
											   <c:forEach var="climate" items="${climateImpactsForReview}">
													       <liferay-ui:message key="aceitem-climateimpacts-lbl-${climate}" /><br/>
										       </c:forEach>
									</div>

									<div class="case-studies-tabbed-content-review-column-right-section">
									  <%

												    String[] sectorAry = null;
												    if (Validator.isNotNull(measure.getSectors_()))
												    {
												    	String sectors = measure.getSectors_();
												    	sectorAry = sectors.split(";");
												    }
												    pageContext.setAttribute("sectorForReview", sectorAry);

										%>

										<p><b>Sectors</b></p>
											<c:forEach var="sector" items="${sectorForReview}">
												  <liferay-ui:message key="acesearch-sectors-lbl-${sector}" /><br/>
										    </c:forEach>
									</div>

									<div class="case-studies-tabbed-content-review-column-right-section">
										<p><b>Geographic characterisation</b></p>
										<p>
										     <c:choose>
												     <c:when test="${geoElementSelected eq 'GLOBAL'}">
												          Global<br/>
												     </c:when>

												     <c:when test="${geoElementSelected eq 'EUROPE'}">
												          Europe:<br/>

												          <c:if test="${fn:length(macroTransSelected) gt 0}">
												               Macro-Transnational region:<br/>
												               <c:forEach var="macroTransElement" items="${macroTransSelected}" varStatus="status" >
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
													                ${countryElement}${not status.last ? ',' : ''}
													           </c:forEach>
													           <br/><br/>
												          </c:if>

												          <c:if test="${fn:length(subNationalsSelected) gt 0}">
												               Sub Nationals:<br/>
													           <c:forEach var="subNationalElement" items="${subnationals}" varStatus="status">
													                     <c:if test="${fn:contains(subNationalsSelected,subNationalElement) }">
														                       ${subNationalElement.description}${not status.last ? ',' : ''}
														                 </c:if>
														       </c:forEach>
														       <br/><br/>
												          </c:if>

												          <c:if test="${fn:length(city) gt 0}">
												             City:<br/> ${city}<br/>
												          </c:if>
												     </c:when>
												     <c:otherwise>
												         <!--  if it is old form -->
												         <%=measure.getSpatiallayer() %><br/><br/>
												     </c:otherwise>
											 </c:choose>
										</p>


										<%
												    String countriesForReview = measure.getSpatialvalues();
										            if (Validator.isNotNull(countriesForReview) && Validator.isNull(measure.getGeochars()))
										            {
											            //System.out.println("countries for review is " + countriesForReview);
													    String[] countriesAry = countriesForReview.split(";");
													    pageContext.setAttribute("countryForReview", countriesAry);


										%>
										            <p>Countries:</p>
										        <%} %>
												    <c:forEach var="ctry" items="${countryForReview}">
												       ${ctry}<br/>
												    </c:forEach>
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
				</div>
				<div class="case-studies-form-clearing"></div>
			</div>
		</div>

		<!-- ========================= -->
		<!-- Portlet Content Ends Here -->
		<!-- ========================= -->

	</div>
</body>
</aui:form>
<% }  %>
