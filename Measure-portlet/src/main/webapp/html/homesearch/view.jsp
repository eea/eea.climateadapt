<%@include file="/html/init.jsp" %>

<portlet:defineObjects />

<script type="text/javascript">



   function submitIfEnter(event)
   {
	   if (event && event.keyCode == 13)
	   {
		   submitform();
		   return false;
		   
	   }
	   else
	   {
		   return true;
	   }
   }
   
   
   function submitform()
   {
	   // base url
	   var url = "data-and-downloads?search_from_home=true";
	   
	   // handle search terms
	   var selectedText = $("#search-terms").val();
	   if (selectedText != "Keyword Search" && selectedText.length > 0)
	   {
		   url = url + "&searchtext=" + selectedText;
	   }
	   
	   
	   var andConditionSectorApplied = false;
	   // handle sectors
	   var firstTime = true;
	   var multiplicityFlag = false;
	   $('#sectors option:selected').each(function(){
				    	  var sectorValue = $(this).val();
				    	  if (firstTime == true)
				    	  {
				    		  url = url + "&searchsectors=" + sectorValue;
				    		  firstTime = false;
				    	  }
				    	  else
				    	  {
				    		  url = url + ";" +  sectorValue;
				    		  multiplicityFlag = true;
				    	  }
				    	  
		});
	   
	   if (multiplicityFlag == true)
	   {
		   url = url + "&conditionAdaptationSector=OR";
	   }
	  
	   
	   // handle countries
	   firstTime = true;
	   multiplicityFlag = false;
	   $('#countries option:selected').each(function(){
				    	  var countryValue = $(this).val();
				    	  
				    	  if (firstTime == true)
				    	  {
				    		  url = url + "&searchcountries=" + countryValue;
				    		  firstTime = false;
				    	  }
				    	  else
				    	  {
				    		  url = url + ";" +  countryValue;
				    		  multiplicityFlag = true;
				    	  }
				    	 
				    	
		});
	   
	   if (multiplicityFlag == true)
	   {
		   url = url + "&conditionAdaptationCountry=OR";
	   }
	   
	 
	   //document.<portlet:namespace />fm_search.submit();
	   document.location.href = url;
	   
   }
</script>
	
<portlet:actionURL name='processAndRedirect' var="processAndRedirectURL" />	
<aui:form name="fm_search" id="fm_search" >
<div id="case-studies-homepage-search-wrapper">
					<div class="case-studies-homepage-search-header">
						SEARCH THE CLIMATE ADAPTATION DATABASE
					</div>
					
					<dl>
						<dt>Search Term(s):</dt>
						<dd>
							<input type="text" name="search-terms" id="search-terms" maxlength="255" value="Keyword Search" onfocus="if (this.value == 'Keyword Search') { this.value = ''; }" onblur="if (this.value == '') { this.value = 'Keyword Search'; }" onkeypress="return submitIfEnter(event)" />
						</dd>

						<dt>Sectors:</dt>
						<dd>
							<select id="sectors" multiple>							  
							<c:forEach var="adaptationSector" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemSector.values() %>" >
								<option value="${adaptationSector}"><liferay-ui:message key="acesearch-sectors-lbl-${adaptationSector}" /></option>  
							  </c:forEach>
							</select>
						</dd>

						<dt>Country:</dt>
						<dd>
							<select id="countries" multiple>
							  <c:forEach var="countryElement" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemCountry.values() %>" >
									<option value="${countryElement}" ><liferay-ui:message key="acesearch-country-lbl-${countryElement}" /></option>
									                                              
							  </c:forEach>
							</select>
							<br><br>
							<a href="#" class="case-studies-homepage-button-green" onClick="submitform()">SEARCH</a>
							<div class="case-studies-homepage-clearing"></div>
						</dd>
					</dl>

					<div class="case-studies-homepage-search-footer">
						<a href="/data-and-downloads">Advanced Search</a>
					</div>
</div>
</aui:form>