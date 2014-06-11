<%@page import="com.liferay.portlet.imagegallery.service.IGImageLocalServiceUtil"%>
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
                    <% String yearDisplay = aceitem.getYear().length() > 0 ? "("+aceitem.getYear() + ")" : "";%>
					<p class="case-review-header"><%= HtmlUtil.escapeAttribute(aceitem.getName()) %> <%= yearDisplay %></p>
					<p><b>Description:</b></p>
					<p><%= aceitem.getDescription().replaceAll("<p>","").replaceAll("</p>","") %></p>
				</div>

				<div class="case-studies-review-clearing"></div>
				
				<div class="case-studies-tabbed-content-section">
					<div class="case-studies-subheader">Reference Information</div>
							<br/><p><b>Websites:</b></p>
								
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
		
											url = HtmlUtil.extractText(aceitem.getStoredAt()).replaceAll("<p>","").replaceAll("</p>","");
											
											if(url != null && url.trim().length() > 0) {
								
												// Portlet code checks for splitter to be '; '
												urls = url.split(";");
												
												url = "" ;
												for(int i=0; i<urls.length; i++) {
													
													if(i==2) { websitelabel += "s" ;}
													
													urls[i] = urls[i].replaceAll("<p>", "");
													urls[i] = urls[i].replaceAll("</p>", "");
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
								
						
											
						<% if (Validator.isNotNull(aceitem.getSource()))
						{%>	
								
									<p><b>Source:</b></p>
									<p><%=aceitem.getSource().replaceAll("<p>","").replaceAll("</p>","") %></p>
									<div class="case-studies-form-clearing"></div>
								
						<%} %>
					
				</div>
				
				<div class="case-studies-review-clearing"></div>
					<!--  insert submit button which takes to the ace data type page -->
				  <% if ( !(aceitemType.equalsIgnoreCase("Map Graph Data Set") || aceitemType.equalsIgnoreCase("Action") || aceitemType.equalsIgnoreCase("Indicator"))) {
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
					<%=aceitem.getKeyword().replaceAll("<p>","").replaceAll("</p>","") %><br/>
				</div>

				

				<div class="case-studies-review-column-right-section">
					<%
							String[] climateImpactsAry = null;
							if (Validator.isNotNull(aceitem.getClimateimpacts_()))
							{
									String climateImpacts = aceitem.getClimateimpacts_();
									climateImpactsAry = climateImpacts.split(";");
							}
													    
						    pageContext.setAttribute("climateImpactsForReview", climateImpactsAry);
				     %>
				     <p><b>Climate impacts</b></p>
					 <c:forEach var="climate" items="${climateImpactsForReview}">
					     <liferay-ui:message key="aceitem-climateimpacts-lbl-${climate}" /><br/>
					 </c:forEach>
				</div>
				
				           <%
									String[] climateElementsAry = null;
								    if (Validator.isNotNull(aceitem.getElements_()))
								    {
									    String climateElements = aceitem.getElements_();
									    climateElementsAry = climateElements.split(";");
								    }
												    
								    pageContext.setAttribute("climateElementsForReview", climateElementsAry);
							%>
							  <c:if test="${climateElementsForReview ne null }">
								<div class="case-studies-review-column-right-section">
							      	<p><b>Elements</b></p>
										    <c:forEach var="climate" items="${climateElementsForReview}">
										           <liferay-ui:message key="acesearch-elements-lbl-${climate}" /><br/>
										    </c:forEach>
						        </div>
				             </c:if>
				             
						    <div class="case-studies-review-column-right-section">
						      <%
														    
								    String[] sectorAry = null;
								    if (Validator.isNotNull(aceitem.getSectors_()))
								    {
								    	String sectors = aceitem.getSectors_();
								    	sectorAry = sectors.split(";");
								    }
								    pageContext.setAttribute("sectorForReview", sectorAry);
														   
							  %>
								<p><b>Sectors</b></p>
								<c:forEach var="sector" items="${sectorForReview}">
									<liferay-ui:message key="acesearch-sectors-lbl-${sector}" /><br/>
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
												               <c:forEach var="countryElement" items="${countriesSelected}" varStatus="status">
													                ${countryElement}${not status.last ? ',' : ''}
													           </c:forEach>
													           <br/><br/>
												          </c:if>
												          
												          <c:if test="${fn:length(subNationalsSelected) gt 0}">
												               Sub Nationals:<br/>
												               
												          <c:forEach var="subNationalElement" items="${subnationals}" varStatus="status">
													                     <c:if test="${fn:contains(subNationalsSelected,subNationalElement) }">
														                      ${subNationalElement.description},
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
						${ctry}<br/>
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
  