<%@include file="/html/init.jsp" %>

<portlet:defineObjects />
<!-- need the javascript for the glossary content tooltip -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/home/jquery.qtip.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/home/jquery_cycle.js"></script>
	<div id="case-studies-homepage-slider-wrapper">
						<div class="case-studies-homepage-slider-content">
							<ul class="blank" >
								<li class="active">
									<div class="case-studies-homepage-slider-image">
										<img src="<%=request.getContextPath()%>/assets/first_banner.jpg" alt="About Climate Change Adaptation in Europe" />
									</div>
									<div class="case-studies-homepage-slider-description">
										<h2>About Climate Change Adaptation in Europe</h2>
										<p>
											
											The European Climate Adaptation Platform (Climate-ADAPT) aims to support Europe in adapting to <a href="/glossary#linkClimateChange">climate change</a>. It is an initiative of the European Commission and helps users to access and share information on:</p>
											<ul>
												<li class="active-content">
													Expected climate change in Europe</li>
												<li class="active-content">
													Current and future <a href="/glossary#linkVulnerability">vulnerability</a> of regions and sectors</li>
												<li class="active-content">
													National and transnational adaptation strategies</li>
												<li class="active-content">
													<a href="/glossary#linkAdaptation">Adaptation</a> case studies and potential adaptation options</li>
												<li>
													Tools that support adaptation planning</li>
											</ul>
										<p>
											<a class="homepage-read-more" href="adaptation-information/general"><img src="<%=request.getContextPath()%>/assets/ico-arrow.png" alt="arrow" />Read more</a>
										</p>
										
										
										<!--  <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aliquam interdum pulvinar nibh. Maecenas eget nunc in justo rhoncus aliquam. Phasellus nisl mi.</p>
										<a href="#"><img src="/assets/ico-arrow.png" alt="arrow" /> Learn more about climate change in Europe</a> -->
									</div>
								</li>
								
							<%
							
							 String description = "";
							 if (Validator.isNotNull(renderRequest.getAttribute("casestudy")))
							 {	%>
									<li>
										<div class="case-studies-homepage-slider-image">
										    <% 
											        String primImageUrl = "";
												    Measure measure = (Measure) renderRequest.getAttribute("casestudy");
													if (Validator.isNotNull(measure.getPrimephoto()))
													{
													      IGImage primImage = IGImageServiceUtil.getImage(Long.parseLong(measure.getPrimephoto()));
													      primImageUrl = themeDisplay.getPathImage() + "/image_gallery?img_id=" + primImage.getLargeImageId() +  "&t=" + ImageServletTokenUtil.getToken(primImage.getLargeImageId());
													}
													else
													{
														// use generic image
														primImageUrl = request.getContextPath() + "/assets/slider_image-1.jpg";
													}
													
													description = measure.getDescription();
													
													// make it to first full stop if it is less than or equal to 420 else restrict to first 420 characters
													if (description.indexOf('.') > 0 && description.indexOf('.') <= 420)
													{
														description = description.substring(0, description.indexOf('.') + 1);
													}
											        else if (description.length() >= 420)
											        {
											        	description = description.substring(0,420);
											        }
											%>
											<img src="<%=primImageUrl%>" alt="Case Study"/>
										</div>
										<div class="case-studies-homepage-slider-description">
											<h2>${casestudy.name}</h2>
											<p><%=description %></p>
											
											<a class="homepage-read-more" href="viewmeasure?ace_measure_id=${casestudy.measureId}"><img src="<%=request.getContextPath()%>/assets/ico-arrow.png" alt="arrow" />Read more</a>
										</div>
									</li>
							 <% } %>
								
								<%
								 if (Validator.isNotNull(renderRequest.getAttribute("type")))
							     {	
							        String type = (String) renderRequest.getAttribute("type");
							        String name = null;
							        String url = null;
							        
							        if (type.equalsIgnoreCase("adaptationoption"))
							        {
							        	Measure adaptationOption = (Measure) renderRequest.getAttribute("aceadaptobject");
							        	name = adaptationOption.getName();
							        	description = adaptationOption.getDescription();
							        	url = "viewmeasure?ace_measure_id=" + String.valueOf(adaptationOption.getMeasureId());
							        }
							        else if (type.equalsIgnoreCase("aceitem"))
							        {
							        	AceItem aceItem = (AceItem) renderRequest.getAttribute("aceadaptobject");
							        	name = aceItem.getName();
							        	description = aceItem.getDescription();
							        	url = "viewaceitem?aceitem_id=" + String.valueOf(aceItem.getAceItemId());
							        }
							        
									// make it to first full stop if it is less than or equal to 420 else restrict to first 420 characters
									if (description.indexOf('.') > 0 && description.indexOf('.') <= 420)
									{
										description = description.substring(0, description.indexOf('.') + 1);
									}
							        else if (description.length() >= 420)
							        {
							        	description = description.substring(0,420);
							        }
							     
							     %>
										<li>
											<div class="case-studies-homepage-slider-image">
											    <% 
												   String primImageUrlForAdaptationOption = request.getContextPath() + "/assets/aceitem_picture.jpg";
												%>
												<img src="<%=primImageUrlForAdaptationOption %>" alt="Ace Item" />
											</div>
											
											<div class="case-studies-homepage-slider-description">
												<h2><%=name %></h2>
												<p><%=description%></p>
												<a class="homepage-read-more" href="<%=url%>"><img src="<%=request.getContextPath()%>/assets/ico-arrow.png" alt="arrow" />Read more</a>
											</div>
										</li>
							   <% } %>
								
								<%
								 if (Validator.isNotNull(renderRequest.getAttribute("event")))
							     {	
							        JournalEvent event = (JournalEvent) renderRequest.getAttribute("event");
							        description = event.getArticle().getDescription();
							        
							       
							        if (description.indexOf('.') > 0 && description.indexOf('.') <= 420)
									{
										description = description.substring(0, description.indexOf('.') + 1);
									}
							        else if (description.length() >= 420)
							        {
							        	description = description.substring(0,420);
							        }
							         
							     %>
										<li>
											<div class="case-studies-homepage-slider-image">
												<img src="<%=request.getContextPath()%>/assets/events.jpg" alt="Events" />
											</div>
											<div class="case-studies-homepage-slider-description">
												<h2>${event.article.title}</h2>
												<p><%=description%></p>
												<a class="homepage-read-more" href="${event.url}"><img src="<%=request.getContextPath()%>/assets/ico-arrow.png" alt="arrow" />Read more</a>
											</div>
										</li>
							  <% } %>
							</ul>
						  
						</div>
						
						  <div class="case-studies-homepage-slider-controls">
							<ul id="slidercontainer">
							</ul>
						</div>
	</div>
	<div class="case-studies-homepage-clearing">
	</div>