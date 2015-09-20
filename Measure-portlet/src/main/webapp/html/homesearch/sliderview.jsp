<%@include file="/html/init.jsp" %>

<portlet:defineObjects />
<!-- need the javascript for the glossary content tooltip -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/home/jquery.qtip.min.js"></script>
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
													long filteredMeasureId = MeasureUtil.filterAdaptationOptionIds(measure.getMeasureId());
												    
												    if (filteredMeasureId != measure.getMeasureId()) {
												    	measure = MeasureLocalServiceUtil.getMeasure(filteredMeasureId);	
												    }
												    
												    if (Validator.isNotNull(measure.getPrimephoto()))
													{
													      DLFileEntry image = DLFileEntryLocalServiceUtil.getFileEntry(Long.parseLong(measure.getPrimephoto())); 
													      primImageUrl = themeDisplay.getPathImage() + "/image_gallery?img_id=" + image.getLargeImageId() +  "&t=" + WebServerServletTokenUtil.getToken(image.getLargeImageId());
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
													String name = measure.getName();
													long measureId = measure.getMeasureId();
											%>
											<img src="<%=primImageUrl%>" alt="Case Study"/>
										</div>
										<div class="case-studies-homepage-slider-description">
											<!-- <h2>${casestudy.name}</h2> -->
											<h2><%=name %></h2>
											<p><%=description %></p>
											
											<!-- <a class="homepage-read-more" href="viewmeasure?ace_measure_id=${casestudy.measureId}"><img src="<%=request.getContextPath()%>/assets/ico-arrow.png" alt="arrow" />Read more</a> -->
											<a class="homepage-read-more" href="viewmeasure?ace_measure_id=<%=measureId %>"><img src="<%=request.getContextPath()%>/assets/ico-arrow.png" alt="arrow" />Read more</a>
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
										long filteredMeasureId = MeasureUtil.filterAdaptationOptionIds(adaptationOption.getMeasureId());
							        	
							        	if (filteredMeasureId != adaptationOption.getMeasureId()) {							        		
							        		adaptationOption = MeasureLocalServiceUtil.getMeasure(filteredMeasureId);
							        	}
							        	name = adaptationOption.getName();
							        	description = adaptationOption.getDescription();
							        	url = "viewmeasure?ace_measure_id=" + String.valueOf(adaptationOption.getMeasureId());
							        }
							        else if (type.equalsIgnoreCase("aceitem"))
							        {
							        	AceItem aceItem = (AceItem) renderRequest.getAttribute("aceadaptobject");
							        	name = aceItem.getName();
							        	description = aceItem.getDescription();
							        	if (! (aceItem.getDatatype().equalsIgnoreCase("RESEARCHPROJECT")) )
							        	{
							        	   url = "viewaceitem?aceitem_id=" + String.valueOf(aceItem.getAceItemId());
							        	}
							        	else
							        	{
							        		String projectId = aceItem.getStoredAt();
							        		projectId = projectId.substring(projectId.indexOf('=')+1);
							        		url = "projects1?ace_project_id=" + String.valueOf(projectId);
							        	}
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
							        description = event.getArticle().getDescriptionCurrentValue();
							        
							       
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
												<h2>${event.article.titleCurrentValue}</h2>
												<p><%=description%></p>
												<a class="homepage-read-more" href="${event.url}"><img src="<%=request.getContextPath()%>/assets/ico-arrow.png" alt="arrow" />Read more</a>
											</div>
										</li>
							  <% } %>
                                                                                <li>
                                                                                        <div class="case-studies-homepage-slider-image">
                                                                                                <img src="<%=request.getContextPath()%>/assets/mayors_adapt.jpg" alt="Mayors Adapt" />
                                                                                        </div>
                                                                                        <div class="case-studies-homepage-slider-description">
                                                                                                <h2 style="margin-bottom: 10px">Mayors Adapt: Promoting urban leadership in adaptation to climate change</h2>
                                                                                                <div style="float:right; margin: 0 8px 0 10px;"><img alt="" src="/image/image_gallery?uuid=0f1ea9c7-e3e5-4bee-b14b-5243a9b25bcb&amp;groupId=18&amp;t=1395392839192" style="height: 60px; width: 126px;border: 1px solid #aebe20"></div>
                                                                                                <p>The Covenant of Mayors Initiative on Climate Change Adaptation has been set up by the European Commission to engage cities in taking action on climate change adaptation. </p>
                                                                                                <p>The initiative, provides a platform for supporting adaptation, networking and public awareness at the local level  where the impacts of climate change will be felt the most. </p>
                                                                                          <a class="homepage-read-more" href="http://www.mayors-adapt.eu" target="_blank"><img src="<%=request.getContextPath()%>/assets/ico-arrow.png" alt="arrow" />Want to join the initiative?</a>
                                                                                        </div>
                                                                                </li>
							</ul>
						  
						</div>
						
						  <div class="case-studies-homepage-slider-controls">
							<ul id="slidercontainer">
							</ul>
						</div>
	</div>
	<div class="case-studies-homepage-clearing">
	</div>
