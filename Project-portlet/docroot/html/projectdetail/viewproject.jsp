<%
/**
* Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
*
* This library is free software; you can redistribute it and/or modify it under
* the terms of the GNU Lesser General Public License as published by the Free
* Software Foundation; either version 2.1 of the License, or (at your option)
* any later version.
*
* This library is distributed in the hope that it will be useful, but WITHOUT
* ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
* FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
* details.
*/
%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@include file="/html/init.jsp" %>

<%
	Long project_id = 0l ;
	Project project = null;
	String[] urls = null;
	String url = null;
	String websitelabel = "Website";

	String redirect = PortalUtil.getCurrentURL(renderRequest);
	
	if(request.getAttribute(Constants.PROJECTID)!=null) {
		 
		project_id = Long.parseLong( (String) request.getAttribute(Constants.PROJECTID) ) ;
		
		try {
			
			project = ProjectLocalServiceUtil.getProject( project_id ) ;
		}
		catch(Exception exc) {
			
			project = null;
		}
		
		if(project != null) {
				
			url = project.getWebsite();
			
			if(url != null && url.trim().length() > 0) {
	
				// Portlet code checks for splitter to be '; '
				urls = url.split(";");
				
				url = "" ;
				for(int i=0; i<urls.length; i++) {
					
					if(i==2) { websitelabel += "s" ;}
					
					urls[i] = urls[i].trim();
					
					if(urls[i].length() > 0) {
						if ( ! (urls[i].startsWith("http://")  || urls[i].startsWith("/") ) ) {
							
							urls[i] = "http://" + urls[i];
						}
						
						url += "<a href='" + urls[i] + "' target='_blank'>" + urls[i] + "</a>&nbsp;&nbsp;" ;
					}
				} 
			}
		}		
	}

	if(project != null) {
	
%>
  <body>
	<div id="wrapper">
	<!-- =========================== -->
	<!-- Portlet Content Starts Here -->
	<!-- =========================== -->
	<div id="case-studies-review-wrapper">
	 <div class="case-studies-tabbed-content-header">Project</div>
	
	
	<div class="case-studies-review-column-left">
                <div class="case-studies-tabbed-content-section">
                   <p class="case-review-header"><%=HtmlUtil.escapeAttribute(project.getAcronym()) %>: <%=HtmlUtil.escapeAttribute(project.getTitle()) %></p>  
					<p><b>Description:</b></p>
					<p><%= project.getAbstracts().replaceAll("<p>","").replaceAll("</p>","") %></p>
				</div>

				<div class="case-studies-review-clearing"></div>
				
				<% if (Validator.isNotNull(project.getWebsite()) && Validator.isNotNull(project.getSource())) { %>
				<div class="case-studies-tabbed-content-section">
					<div class="case-studies-subheader">Reference Information</div>
					
							<br/><p><b>Websites:</b></p>
								
								<%
											url = project.getWebsite().replaceAll("<p>","").replaceAll("</p>","");
											
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
											
								%>
								
								<%= url %><br/><br/>
						
											
						<% if (Validator.isNotNull(project.getSource()))
						{%>	
								
									<p><a name="source_anchor"><b><em>Source</em></b></a></p>
									<p><%=project.getSource().replaceAll("<p>","").replaceAll("</p>","") %></p>
									<div class="case-studies-form-clearing"></div>
						
						<%} %>
				</div>
			    <% } %>
				
				<div class="case-studies-review-clearing"></div>
					<!--  insert submit button which takes to the ace data type page -->
				  <% 
					    // String projectUrl = prefs.getValue(Constants.SHAREINFOEDITURL,"/web/guest/share-your-info/research-and-knowledge-projects?p_p_id=shareprojectportlet_WAR_Projectportlet&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-2&p_p_col_count=1&_shareprojectportlet_WAR_Projectportlet_jspPage=%2Fhtml%2Fshareinfo%2Fadd_project.jsp&_shareprojectportlet_WAR_Projectportlet_redirect=%2Fen%2Fshare-your-info%2Fresearch-and-knowledge-projects&_shareprojectportlet_WAR_Projectportlet");
					    String submitText = "Share your information";
				  %>
					<div class="bluebuttondiv">
			                 <a href="/share-your-info" class="bluebutton"><%=submitText %></a>
			        </div>
		
			</div>
	
	        <div class="case-studies-review-column-right">
	        
				 <%
				    if (Validator.isNotNull(project.getSupdocs())) { 
				    
					 String[] sdocsForReview = project.getSupdocs().split(";"); %>	   
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
					<%=project.getKeywords().replaceAll("<p>","").replaceAll("</p>","") %><br/>
				</div>


				<div class="case-studies-review-column-right-section">
				   	<%
						String[] climateImpactsAry = null;
					    if (Validator.isNotNull(project.getClimateimpacts()))
					    {
						    String climateImpacts = project.getClimateimpacts();
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
								    if (Validator.isNotNull(project.getElement()))
								    {
									    String climateElements = project.getElement();
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
					    if (Validator.isNotNull(project.getSectors()))
					    {
					    	String sectors = project.getSectors();
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
							        
							        if (Validator.isNotNull(project.getGeochars()) || Validator.isNotNull(project.getSpatiallayer()))
							        {
							          
							           if (Validator.isNotNull(project.getGeochars()))	
							           {
							        		   
								        	try {
									        	Object obj=JSONValue.parse(project.getGeochars());
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
												               <c:forEach var="bioRegionElement" items="${bioRegionSelected}" varStatus="status" >
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
												             City: ${city}<br/>
												          </c:if>
												     </c:when>
												     <c:otherwise>
												         <!--  if it is old form -->
												         <%=project.getSpatiallayer() %><br/><br/>
												     </c:otherwise>
											 </c:choose>
						   
						   <% } 
			
				   
					    String countriesForReview = project.getSpatialvalues();
			            if (Validator.isNotNull(countriesForReview) && Validator.isNull(project.getGeochars()))
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
	</div>
	</div>
	</body>
 <%} else { %>
      <div class="portlet-title">
 		<H6>No available project selected</H6>
    </div>
 <% } %>
<div style="clear: both"> </div>