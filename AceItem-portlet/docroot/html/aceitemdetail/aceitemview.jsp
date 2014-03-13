<%@include file="/html/init.jsp" %>

<%
	
	Long aceitem_id = 0l ;
	AceItem aceitem = null;
	String sharetype = null;
	String aceitemType = null;
	String url = null;
	String metadataurl = null;
	String[] urls = null;
	String websitelabel = "Website";
	String aceItemPageUrl = "";
	String aceItemSubmitText = "";
	

    String redirect = PortalUtil.getCurrentURL(renderRequest);
    
    if(request.getAttribute(Constants.ACEITEMID)!=null) {
		aceitem_id = Long.parseLong( (String) request.getAttribute(Constants.ACEITEMID) ) ;
	
		try {
			
			aceitem = AceItemLocalServiceUtil.getAceItem( aceitem_id ) ;
		}
		catch(Exception exc) {
			
			aceitem = null;
		}
    }		
	
	if (aceitem != null)
	{
		    sharetype = aceitem.getDatatype();

		
		    if (sharetype.equalsIgnoreCase(AceItemType.DOCUMENT.toString())) {
			 
			   aceitemType = "Publications and Reports";
			   aceItemSubmitText = "Submit a Publication and Report";
			   aceItemPageUrl = "/share-your-info/publications-and-reports";
			}
			else if (sharetype.equalsIgnoreCase(AceItemType.INFORMATIONSOURCE.toString())) {
			   aceitemType = "Information Portal";
			   aceItemSubmitText = "Submit an Information Portal";
			   aceItemPageUrl = "/share-your-info/information-portals";
			}
			else if (sharetype.equalsIgnoreCase(AceItemType.GUIDANCE.toString())) {
			   aceitemType = "Guidance Document";
			   aceItemSubmitText = "Submit a Guidance Document";
			   aceItemPageUrl = "/share-your-info/guidance-documents";
			   
			}
			else if (sharetype.equalsIgnoreCase(AceItemType.TOOL.toString())) {
			   aceitemType = "Tools";
			   aceItemSubmitText = "Submit a Tools";
			   aceItemPageUrl = "/share-your-info/tools";
			}
			else if (sharetype.equalsIgnoreCase(AceItemType.ORGANISATION.toString())) {
			   aceitemType = "Organisation";
			   aceItemSubmitText = "Submit an Organisation";
			   aceItemPageUrl = "/share-your-info/organisations";
			}
			else if (sharetype.equalsIgnoreCase(AceItemType.MAPGRAPHDATASET.toString())) {
				   aceitemType = "Map Graph Data Set";
			}	
			else if (sharetype.equalsIgnoreCase(AceItemType.ACTION.toString())) {
				   aceitemType = "Action";
			}
			else if (sharetype.equalsIgnoreCase(AceItemType.INDICATOR.toString())) {
				   aceitemType = "Indicator";
			}	
%>

  <body>
	<div id="wrapper">
	<!-- =========================== -->
	<!-- Portlet Content Starts Here -->
	<!-- =========================== -->
	<div id="case-studies-review-wrapper">
	<div class="case-studies-tabbed-content-header"><%= aceitemType %></div>
	
	
	<div class="case-studies-review-column-left">
                <div class="case-studies-tabbed-content-section">
					<p class="case-review-header"><%= aceitem.getName() %> (<%= aceitemType %>)</p>
					<p><b>Description:</b></p>
					<p><%= aceitem.getDescription() %></p>
				</div>

				<div class="case-studies-review-clearing"></div>

				<div class="case-studies-tabbed-content-section">
					<div class="case-studies-subheader"><%=aceitemType %> Information</div>
					<ul>
						<li>
							<p><b><em><%=aceitemType %> Description</em></b></p>
							<ul class="case-studies-tabbed-content-bullted-list">
								<li><a href="#climate_impacts_anchor">Climate Impacts</a></li>
							    <li><a href="#sector_policies_anchor">Sector Policies</a></li>
							</ul>
						</li>
						
						<li>
							<p><b><em>Reference Information</em></b></p>
							<ul class="case-studies-bullted-list">
								<li><a href="#website_anchor">Websites</a></li>
								<% if (Validator.isNotNull(aceitem.getSource())) { %>
									   <li><a href="#source_anchor">Source</a></li>
								<% } %>
							</ul>
						</li>
					</ul>
					<div class="case-studies-case-studies-review-clearing-clearing"></div>
				</div>
				

				<div class="case-studies-tabbed-content-section">
					<div class="case-studies-subheader"><%=aceitemType %> Information</div>
					<ul>
						<li>
							<a name="climate_impacts_anchor"><p><b><em>Climate Impacts</em></b></p></a>
							<p>This <%=aceitemType %> addresses the following climate impact areas:</p>
							
							<%
									String[] climateImpactsAry = null;
								    if (Validator.isNotNull(aceitem.getClimateimpacts_()))
								    {
									    String climateImpacts = aceitem.getClimateimpacts_();
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
						        <a name="sector_policies_anchor"><p><b><em>Relevant European Union Sector Policies:</em></b></p></a>
								<%	    
								    String[] sectorAry = null;
								    if (Validator.isNotNull(aceitem.getSectors_()))
								    {
								    	String sectors = aceitem.getSectors_();
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
					<div class="case-studies-subheader">Reference Information</div>
					<ul>
					   
						<li>
							<a name="website_anchor"><p><b><em>Websites</em></b></p></a>
								
								<%
										if(aceitem.getStoragetype().equalsIgnoreCase("MAPLAYER")) {
											// cswRecordFileIdentifier gets handled inside mapviewer-portlet
											url = "<a href='/map-viewer?cswRecordFileIdentifier=" + aceitem.getStoredAt() + "' >View map " + aceitem.getName() + "</a>" ; 
											//dev:	metadataurl = "<a href='http://dev.ace.geocat.net/geonetwork/srv/en/metadata.show?uuid=" + aceitem.getStoredAt() + "' target='_blank'>View metadata " + aceitem.getName() + "</a>" ; 
											metadataurl = "<a href='/geonetwork/srv/en/metadata.show?uuid=" + aceitem.getStoredAt() + "' target='_blank'>View metadata " + aceitem.getName() + "</a>" ; 
										}
										else if(aceitem.getStoragetype().equalsIgnoreCase("PLAINMETADATA")) {
											// mapViewerAppId gets handled inside mapviewer-portlet
											url = "<a href='/geonetwork/srv/en/metadata.show?uuid=" + aceitem.getStoredAt() + "' target='_blank'>View metadata " + aceitem.getName() + "</a>" ; 
										}
										else if(aceitem.getStoragetype().equalsIgnoreCase("SETOFMAPS")) {
											// mapViewerAppId gets handled inside mapviewer-portlet
											url = "<a href='/map-viewer?mapViewerAppId=" + aceitem.getStoredAt() + "' > " + aceitem.getName() + "</a>" ; 
										}
										else {	
		
											url = aceitem.getStoredAt();
											
											if(url != null && url.trim().length() > 0) {
								
												// Portlet code checks for splitter to be '; '
												urls = url.split(";");
												
												url = "" ;
												for(int i=0; i<urls.length; i++) {
													
													if(i==2) { websitelabel += "s" ;}
													
													urls[i] = urls[i].replace("<p>", "");
													urls[i] = urls[i].replace("</p>", "");
													urls[i] = urls[i].trim();
													
													
													if(urls[i].length() > 0) {
														if ( ! (urls[i].startsWith("http")  || urls[i].startsWith("/") ) ) {
															
															urls[i] = "http://" + urls[i];
														}
														
														url += "<a href='" + urls[i] + "' target='_blank'>" + urls[i] + "</a>&nbsp;&nbsp;" ;
													}
												} 
											}
										}
								%>
								
								<%  if(aceitem.getStoragetype().equalsIgnoreCase("MAPLAYER") ) { %>
										<b>Go to the service</b><br />
										 <%= url %><br /><br />
										 <%= metadataurl %><br /><br />
									<%	 }
										else if(aceitem.getStoragetype().equalsIgnoreCase("PLAINMETADATA") ) { %>
											<b>View metadata</b><br />
											 <%= url  %><br /><br />
									<%	 }
										 else if(aceitem.getStoragetype().equalsIgnoreCase("SETOFMAPS") ) { %>
											<b>View set of maps</b><br />
											 <%= url  %><br /><br />
										<%	 }
											 else{ %>
										 	<%= url %><br /><br />
										 <% } %>
								<div class="case-studies-form-clearing"></div>
						 </li>
											
						<% if (Validator.isNotNull(aceitem.getSource()))
						{%>	
								<li>
									<a name="source_anchor"><p><b><em>Source</em></b></p></a>
									<p><%=aceitem.getSource() %></p>
									<div class="case-studies-form-clearing"></div>
								</li>
						<%} %>
					</ul>
				</div>
				
				<div class="case-studies-review-clearing"></div>
					<!--  insert submit button which takes to the ace data type page -->
				  <% if ( !(aceitemType.equalsIgnoreCase("Map Graph Data Set") || aceitemType.equalsIgnoreCase("Action"))) {
					    // all blue button links now point to "Share your information" instead of aceitem specific links.
					    // Can be reverted to point to ace item specific links whenever required as the
					    // logic to get the ace item specific url is already implemented above.
					    aceItemPageUrl = "/share-your-info";
					    aceItemSubmitText = "Share your information";
				  %>
					<div class="bluebuttondiv">
			                 <a href="<%=aceItemPageUrl %>" class="bluebutton"><%=aceItemSubmitText %></a>
			        </div>
			     <% } %>
			</div>
	
	        <div class="case-studies-review-column-right">
	               <%
				    if (Validator.isNotNull(aceitem.getSupdocs())) { 
				    
					 String[] sdocsForReview = aceitem.getSupdocs().split(";"); %>	   
					 <div clas="case-studies-review-column-right-section">
						<p><b>Project Documents  (<%= sdocsForReview.length %>)</b></p>
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
					<p><%=aceitem.getKeyword() %></p>
				</div>

				<div class="case-studies-review-column-right-section">
					<p><b>Sectors</b></p>
					<c:forEach var="sector" items="${sectorForReview}">
						<p><liferay-ui:message key="acesearch-sectors-lbl-${sector}" /></p>
				    </c:forEach>
				</div>

				<div class="case-studies-review-column-right-section">
				     <p><b>Climate impacts</b></p>
					 <c:forEach var="climate" items="${climateImpactsForReview}">
						<p><liferay-ui:message key="aceitem-climateimpacts-lbl-${climate}" /></p>
					 </c:forEach>
				</div>
						   
						  <%        
			                        String elementSelected = "";
							        ArrayList macroTransElements = new ArrayList();
							        ArrayList biographicalElements = new ArrayList();
							        ArrayList subNationalElements = new ArrayList();
							        ArrayList countryElements = new ArrayList();
							        String city = "";
							        
							        if (Validator.isNotNull(aceitem.getGeochars()) || Validator.isNotNull(aceitem.getSpatialLayer()))
							        {
							          
							           if (Validator.isNotNull(aceitem.getGeochars()))	
							           {
							        		   
								        	try {
									        	Object obj=JSONValue.parse(aceitem.getGeochars());
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
												          Global:<br/>
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
													                <liferay-ui:message key="acesearch-country-lbl-${countryElement}"/>${not status.last ? ',' : ''}
													           </c:forEach>
													           <br/><br/>
												          </c:if>
												          
												          <c:if test="${fn:length(subNationalsSelected) gt 0}">
												               Sub Nationals:<br/>
												               
												              <c:forEach var="subNationalElement" items="${subnationals}" varStatus="status">
													                     <c:if test="${fn:contains(subNationalsSelected,subNationalElement) }">
														                      ${subNationalElement.description}
														                 </c:if>${not status.last ? ',' : ''}
														       </c:forEach>
														       <br/><br/>
												          </c:if>
												          
												          <c:if test="${fn:length(city) gt 0}">
												             City: ${city}<br/>
												          </c:if>
												     </c:when>
												     <c:otherwise>
												         <!--  if it is old form -->
												         <%=aceitem.getSpatialLayer() %><br/><br/>
												     </c:otherwise>
											 </c:choose>
						   
						   <% } 
			
				   
					    String countriesForReview = aceitem.getSpatialValues();
			            if (Validator.isNotNull(countriesForReview) && Validator.isNull(aceitem.getGeochars()))
			            {
				            //System.out.println("countries for review is " + countriesForReview);
						    String[] countriesAry = countriesForReview.split(";");
						    pageContext.setAttribute("countryForReview", countriesAry);
					%>
					     Countries:
					<%} %>
					<c:forEach var="ctry" items="${countryForReview}">
						<liferay-ui:message key="acesearch-country-lbl-${ctry}" /><br/><br/>
				    </c:forEach>

			</div>
			<div class="case-studies-review-clearing"></div>
		</div>
	</div> <!-- end of review wrapper -->
  </div> <!-- end of wrapper -->
  </body>
  <%} else { %>
      <div class="portlet-title">
 		<H6>No available Ace item selected</H6>
    </div>
 <% } %>
<div style="clear: both"> </div>
  
