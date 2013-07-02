<%@page import="com.liferay.portlet.imagegallery.service.IGImageLocalServiceUtil"%>
<%@include file="/html/init.jsp" %>

<%
	Long measure_id = 0l ;
	Measure measure = null;
	String type = "Adaptation option";
	
	String redirect = PortalUtil.getCurrentURL(renderRequest);
	
	if(request.getAttribute(Constants.MEASUREID)!=null) {
		measure_id = Long.parseLong( (String) request.getAttribute(Constants.MEASUREID) ) ;
		
		try {
			measure = MeasureLocalServiceUtil.getMeasure( measure_id ) ;
		}
		catch(Exception exc) {
			
			measure = null;
		}
		
		if(measure != null) {
			
			if( measure.getMao_type().equalsIgnoreCase("A")) {
				type = "Case study" ;
			}
		}
		else {
			
			measure_id = 0l;
		}
	}
	
	if(measure != null) {
%>


	<!-- For Photo Slideshow -->
	<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js" type="text/javascript"></script>
	<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" media="all" />
	<!-- End Photo Slideshow -->
	
	<script type="text/javascript">
		$(document).ready(function() {
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
     </script>

   <body>
	<div id="wrapper">
	<!-- =========================== -->
	<!-- Portlet Content Starts Here -->
	<!-- =========================== -->
	<div id="case-studies-review-wrapper">
	<div class="case-studies-tabbed-content-header"><%= type %> - <em>Review</em></div>
	
	<div class="case-studies-review-column-left">
		<div id="" class="case-studies-review-image-wrapper ">
		      <% 
		          String primImageUrl = "";
		          if (Validator.isNotNull(measure.getPrimephoto()))
		          {
					IGImage primImage = IGImageServiceUtil.getImage(Long.parseLong(measure.getPrimephoto()));
					primImageUrl = themeDisplay.getPathImage() + "/image_gallery?img_id=" + primImage.getLargeImageId() +  "&t=" + ImageServletTokenUtil.getToken(primImage.getLargeImageId());
		          }
			 %>
			<img src="<%=primImageUrl %>" class="case-studies-review-image" />
		</div>

				<div id="" class="case-studies-review-description-wrapper">				
					<p class="case-review-header"><%= measure.getName() %> (<%= type %>)</p>
					<p><strong>Description:</strong></p>
					<p><%= measure.getDescription() %></p>
				</div>

				<div class="case-studies-review-clearing"></div>

				<div class="case-studies-tabbed-content-section">
					<div class="case-studies-subheader">Case Study Information</div>
					<ul>
						<li>
							<p><strong><em>Case Study Description</em></strong></p>
							<ul class="case-studies-tabbed-content-bullted-list">
								<li><a href="#climate_impacts_anchor">Climate Impacts</a></li>
								<li><a href="#challenges_anchor">Challenges</a></li>
								<li><a href="#objectives_anchor">Objectives</a></li>
								<li><a href="#adapt_options_anchor">Adaptation Options Implemented In This Case</a></li>
								<li><a href="#solutions_anchor">Solutions</a></li>
								<li><a href="#relevance_anchor">Importance and Relevance of Adaptation</a></li>
							    <li><a href="#sector_policies_anchor">Sector Policies</a></li>
							</ul>
						</li>
						
						<li>
							<p><strong><em>Additional Details</em></strong></p>
							<ul class="case-studies-bullted-list">
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
						
						<li>
							<p><strong><em>Reference Information</em></strong></p>
							<ul class="case-studies-bullted-list">
								<li><a href="#contact_anchor">Contact</a></li>
								<li><a href="#website_anchor">Websites</a></li>
								<%  if (Validator.isNotNull(measure.getSource())) { %>
									   <li><a href="#source_anchor">Source</a></li>
								<% } %>
							</ul>
						</li>
					</ul>
					<div class="case-studies-case-studies-review-clearing-clearing"></div>
				</div>

				<div class="case-studies-tabbed-content-section">
					<div class="case-studies-subheader">Case Study Information</div>
					<ul>
						<li>
							<a name="climate_impacts_anchor"><p><strong><em>Climate Impacts</em></strong></p></a>
							<p>This case study addresses the following climate impact areas:</p>
							
							<%
									String[] climateImpactsAry = null;
								    if (Validator.isNotNull(measure.getClimateimpacts_()))
								    {
									    String climateImpacts = measure.getClimateimpacts_();
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
							<a name="challenges_anchor"><p><strong><em>Challenges</em></strong></p></a>
							<p>Description of how this case study addresses climate change impacts/risks and related challenges:</p>
							<p><%=measure.getChallenges() %></p>
							<div class="case-studies-review-clearing"></div>
						</li>
						
						<li>
							<a name="objectives_anchor"><p><strong><em>Objectives</em></strong></p></a>
							<p>Description of the objectives which triggered the adaptation measures.</p>
							<p><%=measure.getObjectives()%></p>
							<div class="case-studies-form-clearing"></div>
						</li>
											
						<li>
								<a name="adapt_options_anchor"><p><strong><em>Adaptation Options</em></strong></p></a>
								 <%
								    String[] adaptOptionsAry = null;
								 
								    if (Validator.isNotNull(measure.getAdaptationoptions()))
								    {
									   String adaptOptions = measure.getAdaptationoptions();
									   adaptOptionsAry = adaptOptions.split(";");
								    }
								   pageContext.setAttribute("adaptationOptionsForReview", adaptOptionsAry);
								%>
								   <c:if test="${adaptoptionsForReview ne null }">
								    <c:forEach var="adaptoption" items="${adaptationOptionsForReview}">
								       <p><liferay-ui:message key="aceitem-adaptoptions-lbl-${adaptoption}" /></p>
								    </c:forEach>
								   </c:if>
								 <div class="case-studies-form-clearing"></div>
						</li>
											
						<li>
								<a name="solutions_anchor"><p><strong><em>Solutions</em></strong></p></a>
								<p><%=measure.getSolutions() %></p>
								<div class="case-studies-form-clearing"></div>
						</li>
											
						<li>
								<a name="relevance_anchor"><p><strong><em>Relevance</em></strong></p></a>
								<%
												    
								    String[] relevanceAry = null;
								    if (Validator.isNotNull(measure.getRelevance()))
								    {
								    	String relevance = measure.getRelevance();
								    	relevanceAry = relevance.split(";");
								    }
								    pageContext.setAttribute("relevanceForReview", relevanceAry);
								  
								%>
								    <c:forEach var="relevance" items="${relevanceForReview}">
								     <c:if test="${relevanceForReview ne null}">
								       <p><liferay-ui:message key="aceitem-relevance-lbl-${relevance}" /></p>
								     </c:if>
								    </c:forEach>
							
								<div class="case-studies-form-clearing"></div>
						</li>
										   
						<li>
						        <a name="sector_policies_anchor"><p><strong><em>Relevant European Union Sector Policies:</em></strong></p></a>
								<%
												    
								    String[] sectorAry = null;
								    if (Validator.isNotNull(measure.getSectors_()))
								    {
								    	String sectors = measure.getSectors_();
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

				<div class="case-studies-tabbed-content-section">
					<div class="case-studies-subheader">Additional Details</div>
					<ul>
						 <% if (Validator.isNotNull(measure.getStakeholderparticipation()))
							{%>
								<li>
									<a name="stake_holder_anchor"><p><strong><em>Stakeholder Participation</em></strong></p></a>
								    <p><%=measure.getStakeholderparticipation() %></p>
								    <div class="case-studies-form-clearing"></div>
							    </li>
						   <%} %>
											
										   
						   <% if (Validator.isNotNull(measure.getSucceslimitations()))
							{%>
									<li>
										<a name="success_limitations_anchor"><p><strong><em>Success and Limiting Factors</em></strong></p></a>
											<p><%=measure.getSucceslimitations() %></p>
										    <div class="case-studies-form-clearing"></div>
									</li>
						   <%} %>
										
						  <% if (Validator.isNotNull(measure.getCostbenefit()))
						    {%>	
								<li>
									<a name="cost_benefit_anchor"><p><strong><em>Costs and Benefits</em></strong></p></a>
									<p><%=measure.getCostbenefit() %></p>
									<div class="case-studies-form-clearing"></div>
								</li>
							<%} %>
										
							<% if (Validator.isNotNull(measure.getLegalaspects()))
							   {%>	
									<li>
										<a name="legal_aspect_anchor"><p><strong><em>Legal Aspects</em></strong></p></a>
									    <p><%=measure.getLegalaspects() %></p>
										<div class="case-studies-form-clearing"></div>
									</li>
							 <%} %>
										  
							<% if (Validator.isNotNull(measure.getImplementationtime()))
							   {%>	
									<li>
										<a name="implementation_time_anchor"><p><strong><em>Implementation Time</em></strong></p></a>
										<p><%=measure.getImplementationtime() %></p>
										<div class="case-studies-form-clearing"></div>
									</li>
							  <%} %>
										  
							<% if (Validator.isNotNull(measure.getLifetime()))
							   {%>	
									<li>
										<a name="life_time_anchor"><p><strong><em>Life Time</em></strong></p></a>
										<p><%=measure.getLifetime() %></p>
										<div class="case-studies-form-clearing"></div>
								    </li>
						     <%} %>
					</ul>
				</div>

				<div class="case-studies-tabbed-content-section">
					<div class="case-studies-subheader">Reference Information</div>
					<ul>
						<li>
							<p><strong><em>Contact</em></strong></p>
							<a name="contact_anchor"><p><%=measure.getContact() %></p></a>
							<div class="case-studies-form-clearing"></div>
						</li>
											
						<li>
								<p><strong><em>Websites</em></strong></p>
								<a name="website_anchor"><p><%=measure.getWebsite() %></p></a>
								<div class="case-studies-form-clearing"></div>
						</li>
											
						<% if (Validator.isNotNull(measure.getSource()))
						{%>	
								<li>
									<p><strong><em>Source</em></strong></p>
									<a name="source_anchor"><p><%=measure.getSource() %></p></a>
									<div class="case-studies-form-clearing"></div>
								</li>
						<%} %>
					</ul>
				</div>
			</div>
	
	        <div class="case-studies-review-column-right">
				 <%
			          if (Validator.isNotNull(measure.getSupphotos())) { %>
								   
						<div class="case-studies-review-column-right-section">
					    <% 
										 String[] sphotosInReview = measure.getSupphotos().split(";");
						 %>
							<p><a href="#" id="case-studies-modal-link">Case Study Photos (<%= sphotosInReview.length %>)</a></p>
					        <div id="case-studies-modal" title="Case Study Photos">
						    <div id="case-studies-modal-image-gallery">	 
						<% 
							
						    int photoCounter = 1;
						    for (String photo:sphotosInReview)
						    {
								  IGImage image = IGImageServiceUtil.getImage(Long.parseLong(photo)); 
								  String supPhotoName = image.getName(); 
								  String supPhotoDescription = image.getDescription();
								  String imageUrl = themeDisplay.getPathImage() + "/image_gallery?img_id=" + image.getLargeImageId() +  "&t=" + ImageServletTokenUtil.getToken(image.getLargeImageId());
						 %>
								 
						<!-- =========================== -->
					    <!-- Slideshow Modal Starts Here -->
					    <!-- =========================== -->
					   
						
						<ul>
							<% if (photoCounter == 1) { %>
								 <li class="active">
						    <%} else { %>
								  <li>
							<%} %>
							<h3 class="case-studies-modal-image-gallery-slide-label"><%=supPhotoName %></h3>
							<center>
								<img src="<%=imageUrl%>" alt="<%=supPhotoName %>" />
							</center>
							<p><%=supPhotoDescription %></p>
							</li>
								
						    <% photoCounter ++;} // end of for  %>
								  
							</ul>
							     <div class="case-studies-modal-image-gallery-navigation">
								       <a href="#" class="prev"><span>&lt;</span></a>
								       <a href="#" class="next"><span>&gt;</span></a>
							     </div>
								 </div>
							     </div>
							     </div>
				<% } // end of if %>
				
				
				
				 <%
				    if (Validator.isNotNull(measure.getSupdocs())) { 
				    
					 String[] sdocsForReview = measure.getSupdocs().split(";"); %>	   
					 <div clas="case-studies-review-column-right-section">
						<p><strong>Case Study Documents  (<%= sdocsForReview.length %>)</strong></p>
										<ul class="case-studies-bullted-list">
								 <% 
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
			
				
				<div class="case-studies-review-column-right-section">
					<p><strong>Keywords</strong></p>
					<p><%=measure.getKeywords() %></p>
				</div>

				<div class="case-studies-review-column-right-section">
					<p><strong>Sectors</strong></p>
					<c:forEach var="sector" items="${sectorForReview}">
						<p><liferay-ui:message key="acesearch-sectors-lbl-${sector}" /></p>
				    </c:forEach>
				</div>

				<div class="case-studies-review-column-right-section">
				     <p><strong>Climate impacts</strong></p>
					 <c:forEach var="climate" items="${climateImpactsForReview}">
						<p><liferay-ui:message key="aceitem-climateimpacts-lbl-${climate}" /></p>
					 </c:forEach>
				</div>
				
				
				<%   
						        // getting the selected value
						        // define radio option
						        String geoCharSelected = "";
						        ArrayList geoCharsSubNatlSelected = new ArrayList();
						        String geoTrans1Selected = "";
						        String geoTrans2Selected = "";
						        String cityText = "";
						        String OldGeoSpatialValue = "";
						        boolean newForm = true;
						    
						        
						        Measure measureForGeoChars = null;
						        if (measure != null)
						        {
						        	measureForGeoChars = measure;
						        }
						        
						       
						        // if we have old GeoCharacterization value or the new GeoCharacterization value
						        if ((measureForGeoChars != null && Validator.isNotNull(measureForGeoChars.getGeochars())) || Validator.isNotNull(measureForGeoChars.getSpatiallayer()))
						        {
						        	// check for new value
						        	if (Validator.isNotNull(measureForGeoChars.getGeochars()))
						        	{
								        	if (measureForGeoChars.getGeochars().contains("SUBNATIONAL"))
								        	{
								        		geoCharSelected = "SUBNATIONAL";
								        		
								        		
								        		String[] snationals = measureForGeoChars.getGeochars().split("\\^");
								        		
								        		boolean skippedFirstOne = false;
								        		for (String snat:snationals)
								        		{
								        		    if (skippedFirstOne)
								        		    {
								        			    geoCharsSubNatlSelected.add(snat);
								        		    }
								        		    else
								        		    {
								        		    	skippedFirstOne = true;
								        		    }
								        			
								        		}        
								        	}
								        	else if (measureForGeoChars.getGeochars().contains("TRANSNATIONAL"))
								        	{
								        		geoCharSelected = "TRANSNATIONAL";
								        
								        		String[] transnationals = measureForGeoChars.getGeochars().split("\\^");
								        		geoTrans1Selected = transnationals[1];
								        		geoTrans2Selected = transnationals[2];
								        	}
								        	else if (measureForGeoChars.getGeochars().contains("CITY"))
								        	{
								        		geoCharSelected = "CITY";
								        	
								        		String[] city = measureForGeoChars.getGeochars().split("\\^");
								        		cityText = city[1];
								        	}
								        	else
								        	{
								        		geoCharSelected = measureForGeoChars.getGeochars();
								        	}
						            }
						        	// check for old value
						        	else if (Validator.isNotNull(measureForGeoChars.getSpatiallayer()))
						            {
						        	newForm = false;
						        	geoCharSelected = measureForGeoChars.getSpatiallayer();
						        	
						            }
						        }
						        
						        
						        pageContext.setAttribute("geoCharSelected", geoCharSelected);
						        pageContext.setAttribute("geoCharsSubNatlSelected", geoCharsSubNatlSelected);
						        pageContext.setAttribute("geoTrans1Selected", geoTrans1Selected);
						        pageContext.setAttribute("geoTrans2Selected", geoTrans2Selected);
						        pageContext.setAttribute("cityText", cityText);
						        pageContext.setAttribute("newForm", newForm);
						   %>
						   
						   <c:if test="${geoCharSelected}">
					       	<div class="case-studies-review-column-right-section">
						        <p><strong>Geographic characterisation</strong></p>
						        <p>
					                 <c:choose>
									     <c:when test="${geoCharSelected eq 'TRANSNATIONAL' && newForm eq true}">
												 Macro-transnational region: <liferay-ui:message key="acesearch-geochars-lbl-${geoTrans1Selected}"/>
												 Bio-transnational region: <liferay-ui:message key="acesearch-geochars-lbl-${geoTrans2Selected}"/>
									     </c:when>
									     <c:when test="${geoCharSelected eq 'SUBNATIONAL' && newForm eq true}">
												   Sub Nationals: <br/>
												<c:forEach var="subNationalElement" items="${geoCharsSubNatlSelected}" >
												    <liferay-ui:message key="acesearch-geochars-lbl-${subNationalElement}"/> <br/>
												</c:forEach>
										 </c:when>
										 <c:when test="${geoCharSelected eq 'CITY' && newForm eq true}">
												 Cities and Towns: ${cityText}
										 </c:when>
										 <c:when test="${newForm eq true}">
												 <liferay-ui:message key="acesearch-geochars-lbl-${geoCharSelected}"/> <br/>
										 </c:when>
									     <c:otherwise>
												 ${geoCharSelected}"/>
										</c:otherwise>
						            </c:choose>
						      </p>
				          </div>
				        </c:if>
				<div class="case-studies-review-column-right-section">
				   <%
					    String countriesForReview = measure.getSpatialvalues();
			            if (Validator.isNotNull(countriesForReview))
			            {
				            //System.out.println("countries for review is " + countriesForReview);
						    String[] countriesAry = countriesForReview.split(";");
						    pageContext.setAttribute("countryForReview", countriesAry);
					%>
					 <p><strong>Countries</strong></p>
					<%} %>
					<c:forEach var="ctry" items="${countryForReview}">
						<p><liferay-ui:message key="acesearch-country-lbl-${ctry}" /></p>
				    </c:forEach>
				</div>
			</div>
			<div class="case-studies-review-clearing"></div>
	</div> <!-- end of review wrapper -->
  </div> <!-- end of wrapper -->
  </body>
  <%} else { %>
      <div class="portlet-title">
 		<H6>No available measure selected</H6>
    </div>
 <% } %>
<div style="clear: both"> </div>
  