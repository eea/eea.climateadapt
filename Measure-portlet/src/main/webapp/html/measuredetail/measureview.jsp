<%@include file="/html/init.jsp" %>

<%
	Long measure_id = 0l ;
	Measure measure = null;
	String type = "Adaptation option";
	String nameOfClimateEntityShortText = "Adaptation Option";

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
				nameOfClimateEntityShortText = "Case Study";

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
	<div class="case-studies-tabbed-content-header"><%= type %></div>


	<div class="case-studies-review-column-left">
	  <% String yearDisplay = measure.getYear().length() > 0 ? "("+measure.getYear() + ")" : "";%>
	  <%if (type.equalsIgnoreCase("case study")) { %>
		<div id="" class="case-studies-review-image-wrapper ">
		      <%
		          String primImageUrl = "";
		          if (Validator.isNotNull(measure.getPrimephoto()))
		          {
					DLFileEntry primImage = DLFileEntryLocalServiceUtil.getFileEntry(Long.parseLong(measure.getPrimephoto()));					
					//primImageUrl = themeDisplay.getPathImage() + "/image_gallery?uuid=" + primImage.getUuid() +  "&t=" + WebServerServletTokenUtil.getToken(primImage.getLargeImageId()) + "&groupId=" + primImage.getGroupId();
		          	primImageUrl = PortalUtil.getPortalURL(request) + "/documents/" + primImage.getGroupId() + "/" + primImage.getFolderId() + "/" +primImage.getTitle() + "/" +primImage.getUuid() + "?t=" + System.currentTimeMillis();
		          }
			 %>
			<img src="<%=primImageUrl %>" class="case-studies-review-image" />
		</div>
		 	<div style="padding-right: 3px;">
				<p class="case-review-header"><%= HtmlUtil.escapeAttribute(measure.getName()) %> <%=yearDisplay %></p>
				<p class="normalStyle"><%= measure.getDescription()%></p>
			</div>
     <% } else { %>
             <div class="case-studies-tabbed-content-section">
                <p class="case-review-header"><%= HtmlUtil.escapeAttribute(measure.getName()) %> <%= yearDisplay %></p>
				<p class="normalStyle"><%= measure.getDescription()%></p>
			</div>

     <% } %>

				<div class="case-studies-review-clearing"></div>

				<div class="case-studies-tabbed-content-section">
					<ul>
						<li>
							<p><b><em><%=nameOfClimateEntityShortText %> Description</em></b></p>
							<ul class="case-studies-tabbed-content-bullted-list">
								<% if (type.equalsIgnoreCase("case study")) { %>
									<li><a href="#challenges_anchor">Challenges</a></li>
									<li><a href="#objectives_anchor">Objectives</a></li>
									<li><a href="#adapt_options_anchor">Adaptation Options Implemented In This Case</a></li>
									<li><a href="#solutions_anchor">Solutions</a></li>
									<li><a href="#relevance_anchor">Importance and Relevance of Adaptation</a></li>
								<% } %>
							</ul>
						</li>

						<li>
							<p><b><em>Additional Details</em></b></p>
							<ul class="case-studies-bullted-list">
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

						<li>
							<p><b><em>Reference Information</em></b></p>
							<ul class="case-studies-bullted-list">
							   <% if (type.equalsIgnoreCase("case study")) { %>
								<li><a href="#contact_anchor">Contact</a></li>
							   <% } %>
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
					<div class="case-studies-subheader"><%=nameOfClimateEntityShortText %> Description</div>
					<ul class="normalStyle">

						<% if (type.equalsIgnoreCase("case study")) { %> <%-- beginning of condition type is case study --%>
						<li>
							<a name="challenges_anchor"><b><em>Challenges</em></b></a>
							<%=measure.getChallenges() %>
							<div class="case-studies-review-clearing"></div>
						</li>

						<li>
							<a name="objectives_anchor"><b><em>Objectives</em></b></a>
							<%=measure.getObjectives()%>
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
										
										listOfSelectedMeasure = MeasureUtil.getFilteredItems(listOfSelectedMeasure);
										pageContext.setAttribute("listOfSelectedMeasure", listOfSelectedMeasure);
								    }
								    pageContext.setAttribute("adaptationOptionsForReview", adaptOptionsAry);
								%>
								   <c:if test="${adaptationOptionsForReview ne null }">
									   <p>
									      <p>
										    <c:forEach var="adaptoption" items="${listOfSelectedMeasure}">
										       &nbsp;&nbsp;&nbsp;<a href='/viewmeasure?ace_measure_id=${adaptoption.measureId}' target="view adaptation">${adaptoption.name}</a>
										    </c:forEach>
										  </p>
									   </p>
								   </c:if>
								 <div class="case-studies-form-clearing"></div>
						</li>

						<li>
								<a name="solutions_anchor"><b><em>Solutions</em></b></a>
								   <%=measure.getSolutions()%>
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
								   <p>
								    <p>
									    <c:forEach var="relevance" items="${relevanceForReview}">
									     <c:if test="${relevanceForReview ne null}">
									        &nbsp;&nbsp;&nbsp;<liferay-ui:message key="aceitem-relevance-lbl-${relevance}" />
									     </c:if>
									    </c:forEach>
								    </p>
								  </p>

								<div class="case-studies-form-clearing"></div>
						</li>
						<% } %>	<%-- end of condition type is case study --%>
					</ul>
				</div>

				<div class="case-studies-tabbed-content-section">
					<div class="case-studies-subheader">Additional Details</div>
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

								    <p>
								       <c:forEach var="category" items="${categoryList}">
								          ${category} <br/>
								       </c:forEach>
								    </p>

									<div class="case-studies-form-clearing"></div>
								</li>
						<%} %>

						 <% if (Validator.isNotNull(measure.getStakeholderparticipation()))
							{%>
								<li>
									<a name="stake_holder_anchor"><b><em>Stakeholder Participation</em></b></a>
								    <%=measure.getStakeholderparticipation() %>
								    <div class="case-studies-form-clearing"></div>
							    </li>
						   <%} %>


						   <% if (Validator.isNotNull(measure.getSucceslimitations()))
							{%>
									<li>
										<a name="success_limitations_anchor"><b><em>Success and Limiting Factors</em></b></a>
										<%=measure.getSucceslimitations() %>
									    <div class="case-studies-form-clearing"></div>
									</li>
						   <%} %>

						  <% if (Validator.isNotNull(measure.getCostbenefit()))
						    {%>
								<li>
									<a name="cost_benefit_anchor"><b><em>Costs and Benefits</em></b></a>
									<%=measure.getCostbenefit() %>
									<div class="case-studies-form-clearing"></div>
								</li>
							<%} %>

							<% if (Validator.isNotNull(measure.getLegalaspects()))
							   {%>
									<li>
										<a name="legal_aspect_anchor"><b><em>Legal Aspects</em></b></a>
									    <%=measure.getLegalaspects() %>
										<div class="case-studies-form-clearing"></div>
									</li>
							 <%} %>

							<% if (Validator.isNotNull(measure.getImplementationtime()))
							   {%>
									<li>
										<a name="implementation_time_anchor"><b><em>Implementation Time</em></b></a>
										<%=measure.getImplementationtime() %>
										<div class="case-studies-form-clearing"></div>
									</li>
							  <%} %>

							<% if (Validator.isNotNull(measure.getLifetime()))
							   {%>
									<li>
										<a name="life_time_anchor"><b><em>Life Time</em></b></a>
										<%=measure.getLifetime() %>
										<div class="case-studies-form-clearing"></div>
								    </li>
						     <%} %>
					</ul>
				</div>

				<div class="case-studies-tabbed-content-section">
					<div class="case-studies-subheader">Reference Information</div>
					<ul>
					   <% if (type.equalsIgnoreCase("case study")) { %>
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
                                                                            String websiteUrl = wsite.trim();
                                                                            if (websiteUrl.length() > 0) {
                                                                            if( ! websiteUrl.startsWith("http")  ){
                                                                                websiteUrl = "http://" + websiteUrl;
                                                                              }
								   %>
								   <a href="<%=websiteUrl%>" target="_blank"><%=websiteUrl%></a><br/><% }} %>
								</p>

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

				<div class="case-studies-review-clearing"></div>
					<%
						    String url = "/share-your-info";
						    String submitText = "Share your information";

						    /* if (nameOfClimateEntityShortText.equalsIgnoreCase("Case Study"))
						    {
						    	submitText = "Submit a Case Study";
						    	url = "/share-your-info/case-studies";
						    }
						    else
						    {
						    	submitText = "Submit an Adaptation Option";
						    	url = "/share-your-info/adaptation-options";
						    } */
					%>
				    <!--  insert submit button which takes to the ace data type page -->
					<div class="bluebuttondiv">
				          <a href="<%=url %>" class="bluebutton"><%=submitText %></a>
				    </div>
			</div>


	        <div class="case-studies-review-column-right">
				 <%
			          if (Validator.isNotNull(measure.getSupphotos())) { %>

						<div class="case-studies-review-column-right-section">
					    <%
										 String[] sphotosInReview = measure.getSupphotos().split(";");
						 %>
							<p><a href="#" id="case-studies-modal-link" class="bluebutton">Case Study Illustrations(<%= sphotosInReview.length %>)</a></p>
					        <div id="case-studies-modal" title="Case Study Illustrations">
						    <div id="case-studies-modal-image-gallery">
						<%

						    int photoCounter = 1;
						    String firstImageURL = null;
						    String firstImageAlt = null;
						    for (String photo:sphotosInReview)
						    {

								  DLFileEntry image = DLFileEntryLocalServiceUtil.getFileEntry(Long.parseLong(photo));
								  String supPhotoName = image.getName();
								  String supPhotoTitle = image.getTitle();
								  String supPhotoDescription = image.getDescription().replaceAll("<p>","").replaceAll("</p>","");
								  //String imageUrl = themeDisplay.getPathImage() + "/image_gallery?uuid=" + image.getUuid() +  "&t=" + WebServerServletTokenUtil.getToken(image.getLargeImageId())  + "&groupId=" + image.getGroupId();
								  String imageUrl = PortalUtil.getPortalURL(request) + "/documents/" + image.getGroupId() + "/" + image.getFolderId() + "/" +image.getTitle() + "/" +image.getUuid() + "?t=" + System.currentTimeMillis(); 								 			
						 %>

						<!-- =========================== -->
					    <!-- Slideshow Modal Starts Here -->
					    <!-- =========================== -->


						<ul>
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
							     <% if (photoCounter >= 1) { %>
									<div class="firstImage">
									  <img src="<%=firstImageURL %>" alt="<%=firstImageAlt %>" width="160px" height="100px" />
									</div>
								 <% } %>
							     </div>
				<% } // end of if %>



				 <%
				    if (Validator.isNotNull(measure.getSupdocs())) {

					 String[] sdocsForReview = measure.getSupdocs().split(";"); %>
					 <div class="case-studies-review-column-right-section">
						<p><b>Case Study Documents  (<%= sdocsForReview.length %>)</b></p>
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
					<p><b>Keywords</b></p>
					<%=measure.getKeywords().replaceAll("<p>","").replaceAll("</p>","") %><br/>
				</div>

				<div class="case-studies-review-column-right-section">
					<p><b>Sectors</b></p>
					<%

					    String[] sectorAry = null;
					    if (Validator.isNotNull(measure.getSectors_()))
					    {
					    	String sectors = measure.getSectors_();
					    	sectorAry = sectors.split(";");
					    }
					    pageContext.setAttribute("sectorForReview", sectorAry);

					%>
					<c:forEach var="sector" items="${sectorForReview}">
						<liferay-ui:message key="acesearch-sectors-lbl-${sector}" /><br/>
				    </c:forEach>
				</div>

				<div class="case-studies-review-column-right-section">
				     <p><b>Climate impacts</b></p>

					<%
						String[] climateImpactsAry = null;
					    if (Validator.isNotNull(measure.getClimateimpacts_()))
					    {
						    String climateImpacts = measure.getClimateimpacts_();
						    climateImpactsAry = climateImpacts.split(";");
					    }

					    pageContext.setAttribute("climateImpactsForReview", climateImpactsAry);
					%>
					 <c:forEach var="climate" items="${climateImpactsForReview}">
						<liferay-ui:message key="aceitem-climateimpacts-lbl-${climate}" /><br/>
					 </c:forEach>
				</div>

						  <%


						                        String elementSelected = "";
										        ArrayList macroTransElements = new ArrayList();
										        ArrayList biographicalElements = new ArrayList();
										        ArrayList subNationalElements = new ArrayList();
										        ArrayList countryElements = new ArrayList();
										        String city = "";

										        if (Validator.isNotNull(measure.getGeochars()) || Validator.isNotNull(measure.getSpatiallayer()))
										        {

										           if (Validator.isNotNull(measure.getGeochars()))
										           {

											        	try {
												        	Object obj=JSONValue.parse(measure.getGeochars());
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

											        pageContext.setAttribute("geoElementSelected", elementSelected);
											        pageContext.setAttribute("macroTransSelected", macroTransElements);
											        pageContext.setAttribute("bioRegionSelected", biographicalElements);
											        pageContext.setAttribute("subNationalsSelected", subNationalElements);
											        pageContext.setAttribute("countriesSelected", countryElements);
											        pageContext.setAttribute("city", city);


											        ArrayList subnationalRegions = new ArrayList();
											        // get the subnational elements and store it in page context
											        for (nl.wur.alterra.cgi.ace.model.constants.AceItemGeoChars geoCharElement : nl.wur.alterra.cgi.ace.model.constants.AceItemGeoChars.values())
											        {

											        	if (geoCharElement.toString().contains("SUBN_"))
											        	{
											        		subnationalRegions.add(geoCharElement);
											        	}
											        }
											        pageContext.setAttribute("subnationals", subnationalRegions);
										          }
										   %>

								<div class="case-studies-review-column-right-section">
						                       <p><b>Geographic characterisation</b></p>
						                       <p>
						                       <c:choose>
												     <c:when test="${geoElementSelected eq 'GLOBAL'}">
												          Global<br/>
												     </c:when>

												     <c:when test="${geoElementSelected eq 'EUROPE'}">
												          Europe:<br/>

												          <c:if test="${fn:length(macroTransSelected) gt 0}">
												               Macro-Transnational region:
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
												               <c:forEach var="countryElement" items="${countriessSelected}" varStatus="status">
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
												             City:<br/>${city}<br/>
												          </c:if>
												     </c:when>
												     <c:otherwise>
												         <!--  if it is old form -->
												         <%=measure.getSpatiallayer() %><br/><br/>
												     </c:otherwise>
											 </c:choose>

						   <% }


					    String countriesForReview = measure.getSpatialvalues();
			            if (Validator.isNotNull(countriesForReview) && Validator.isNull(measure.getGeochars()))
			            {
				            //System.out.println("countries for review is " + countriesForReview);
						    String[] countriesAry = countriesForReview.split(";");
						    pageContext.setAttribute("countryForReview", countriesAry);
					%>
					 Countries:
					<%} %>
					<c:forEach var="ctry" items="${countryForReview}">
						${ctry}<br/>
				    </c:forEach>

			</div>
			<div class="case-studies-review-clearing"></div>
		</div> <!--  end of right column -->
	</div> <!-- end of review wrapper -->
  </div> <!-- end of wrapper -->

  </body>
  <%} else { %>
      <div class="portlet-title">
 		<H6>No available measure selected</H6>
    </div>
 <% } %>
<div style="clear: both"> </div>

