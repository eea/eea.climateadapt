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

<%@ page import="com.liferay.portal.util.PortalUtil" %>

<portlet:defineObjects />

<%
HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(request);
%>
This is the <b>Ace Adaptation Tools portlet</b> portlet.

<script defer="defer" type="text/javascript">
	function displayStep(nr) {
		$('.step-left').fadeOut();
		$('#step-left-'+nr).fadeIn();
		$('.step-right').fadeOut();
		$('#step-right-'+nr).fadeIn();		
	}
</script>

<div>
	<!-- left panel -->
	<div style="border:solid 1px green;margin-right: 10px; margin-top: 50px; float:left;width:400px;height:600px;background-color:#d2df92;">
		<!--
		
				step 1
				
		-->
		<div id="step-left-1" class="step-left">
			<div style="margin:5px;cursor:pointer;" onclick="displayStep(2);">
				<img src="<%=renderRequest.getContextPath()%>/images/AST_small1.png"/>
			</div>
			<div id="adaptation-support-tool" style="margin:5px;background:#d2df92;">
				<div id="adaptation-support-tool-heading" style="font-size:24px;padding:20px 10px;">
					Adaptation support tool
				</div>
				<div id="what-is-it" style="margin:20px 10px;">
					<div id="what-is-it-heading" style="font-size:18px;">
						What is it?
					</div>
					<div style="font-size:12px;margin:20px 10px;">
						It is a tool for users involved in development of the climate change adaptation policies who search for information on climate change.
					</div>
				</div>
				<div id="how-can-i-use-it" style="margin:20px 10px;">
					<div id="how-can-i-use-it-heading" style="font-size:18px;">
						How can I use it?
					</div>
					<div style="font-size:12px;margin:20px 10px;">
						The tool is based on policy cycle. Resources relevant for four stages of policy-making process are grouped together. Simply choose relevant policy state to
						access resources that might be relevant to you.
					</div>				
				</div>
				<div id="where-can-i-find-more-information" style="margin:20px 10px;">
					<div id="where-can-i-find-more-information-heading" style="font-size:18px;">
						Where can I find more information?
					</div>
					<div style="font-size:12px;margin:20px 10px;">
						You can find more about designing and mainstreaming adaptation policies in these documents:
						<div style="margin:20px 0px;">
							<img src="<%=renderRequest.getContextPath()%>/images/arrow_green.png"/ class="valigned"/>
							<span style="margin-left:5px;">
								Design of guidelines for the elaboration of Regional Climate Change Adaptation Strategies
							</span>
						</div>
						<div style="margin:20px 0px;">
							<img src="<%=renderRequest.getContextPath()%>/images/arrow_green.png"/ class="valigned"/>
							<span style="margin-left:5px;">
								Integrating Climate Change Adaptation into Development Co-operation
							</span>
						</div>					
					</div>				
				</div>			
				<hr style="clear:both;display:block;visibility:hidden;"></hr>
			</div>
		<!-- end step 1 -->	
		</div>

		<!--
		
				step 2
				
		-->
		<div id="step-left-2" class="step-left">
			<div style="margin:5px;cursor:pointer;" onclick="displayStep(3);">
				<img src="<%=renderRequest.getContextPath()%>/images/AST_small2.png"/>
			</div>
			<div id="what-should-i-do" style="margin:5px;">
				<div id="what-should-i-do-heading" style="font-size:24px;" onclick="$j('#analyze-maps-options').fadeOut();$j('#what-should-i-do-options').fadeIn();$j('#analyze-maps-heading').addClass('clickable');$j('#what-should-i-do-heading').removeClass('clickable');$('#general-content').fadeIn();$('#indicators-map').fadeOut();">
					What should I do?
				</div>
				<div id="what-should-i-do-options" style="">
					<ul style="list-style:none;">
						<li class="list-option">
							<img src="<%=renderRequest.getContextPath()%>/images/arrow_green.png"/ class="valigned"/>
							2.1 General
						</li>
						<li class="list-option">
							<img src="<%=renderRequest.getContextPath()%>/images/arrow_green.png"/ class="valigned"/>					
							2.2 What are key systems?
						</li>
						<li class="list-option">
							<img src="<%=renderRequest.getContextPath()%>/images/arrow_green.png"/ class="valigned"/>					
							2.3 How do I analyze impacts of past weather?
						</li>
						<li class="list-option">
							<img src="<%=renderRequest.getContextPath()%>/images/arrow_green.png"/ class="valigned"/>					
							2.4 How do I analyze recent climate trends?
						</li>
						<li class="list-option">
							<img src="<%=renderRequest.getContextPath()%>/images/arrow_green.png"/ class="valigned"/>						
							2.5 Where do I find possible scenarios?
						</li>
						<li class="list-option">
							<img src="<%=renderRequest.getContextPath()%>/images/arrow_green.png"/ class="valigned"/>					
							2.6 How do I identify impacts of climate change?
						</li>
						<li class="list-option">
							<img src="<%=renderRequest.getContextPath()%>/images/arrow_green.png"/ class="valigned"/>					
							2.7 How do I assess vulnerability?
						</li>
						<li class="list-option">
							<img src="<%=renderRequest.getContextPath()%>/images/arrow_green.png"/ class="valigned"/>					
							2.8 What about risks and opportunities?
						</li>
					</ul>
				</div>
			</div>
			<div id="analyze-maps" style="margin:5px;">
				<div id="analyze-maps-heading" class="clickable" style="font-size:24px;" onclick="$j('#what-should-i-do-options').fadeOut();$j('#analyze-maps-options').fadeIn();$j('#what-should-i-do-heading').addClass('clickable');$j('#analyze-maps-heading').removeClass('clickable');$('.what-should-i-do-content').fadeOut();$('#indicators-map').fadeIn();">
					Analyze pan-European maps
				</div>
				<div id="analyze-maps-options" style="display:none;">
					<ul style="list-style:none;">
						<li class="list-option">
							<img src="<%=renderRequest.getContextPath()%>/images/arrow_green.png"/ class="valigned"/>					
							What are the key vulnerabilities and risks?
						</li>
						<li class="list-option">
							<img src="<%=renderRequest.getContextPath()%>/images/arrow_green.png"/ class="valigned"/>					
							What are the underlying causes?
						</li>
						<li class="list-option">
							<img src="<%=renderRequest.getContextPath()%>/images/arrow_green.png"/ class="valigned"/>					
							How does the climate change?
						</li>
						<li class="list-option">
							<img src="<%=renderRequest.getContextPath()%>/images/arrow_green.png"/ class="valigned"/>					
							How does the socio-ecological system change?
						</li>
						<li class="list-option">
							<img src="<%=renderRequest.getContextPath()%>/images/arrow_green.png"/ class="valigned"/>					
							Uncertainties
						</li>
					</ul>			
				</div>
			</div>

		<!-- end step 2 -->
		</div>


        <!--

				step 4

		-->
		<div id="step-left-4" class="step-left">
			<div style="margin:5px;cursor:pointer;">
				<img src="<%=renderRequest.getContextPath()%>/images/AST_small4.png"/>
			</div>
            <div id="what-should-i-do-4" style="margin:5px;">
				<div id="what-should-i-do-4-heading" style="font-size:24px;">
					What should I do?
				</div>

            </div>
			<div id="search-option-database" style="margin:5px;">
				<div id="search-option-database-heading" style="font-size:24px;">
					Search the option database
				</div>
				<div id="search-option-database-options">
					<ul>
						<li>
							What are generic measures?
						</li>
						<li>
							Locate your region and find similar regions
						</li>
						<li>
							What are potential good practices for your region based on experiences in similar regions?
						</li>
					</ul>
				</div>
			</div>

		<!-- end step 4 -->
		</div>

	<!-- end left panel -->
	</div>
	
	<!-- right panel -->
    <div id="acemap_column" style="margin-right: 10px; margin-top: 50px; float:left;border:solid 1px red;width:850px;height:600px;background:#fff;">
	<!--
	
			step 1
			
	-->
	<div id="step-right-1" class="step-right">
		<img src="<%=renderRequest.getContextPath()%>/images/AST_large.png" />
		<hr style="clear:both;display:block;visibility:hidden;"></hr>
	</div>
	
	<!--
	
			step 2 
			
	-->
    <script defer="defer" type="text/javascript">
		var indicators = new Array();
		var $j = jQuery.noConflict();
		$j(document).ready(function(){	
		
			//
			// create information popups
			//
			$j('.info-button.top-bubble').CreateBubblePopup({
					position : 'top',
                    selectable: true,
					align	 : 'center',
					innerHtml: '<div style="position:relative;z-index:9999;"> \
									<div style="background:green;color:#fff;height:15px;border:1px solid lime;padding:5px;">information</div> \
									<div style="height:35px;padding:5px;">short description</div> \
									<div style="height:15px;text-align:right;padding:5px;">read more &raquo;</div> \
								</div>',
					innerHtmlStyle: {
										color:'#000', 
										'text-align':'left'
									},
					themeName: 	'green',
					themePath: 	'<%=renderRequest.getContextPath()%>/js/bubblepopup/jquerybubblepopup-theme'					
			});
			$j('.info-button.right-bubble').CreateBubblePopup({
					position : 'right',
                    selectable: true,
					align	 : 'center',
					innerHtml: '<div style="position:relative;z-index:9999;"> \
									<div style="background:#ff6347;color:#fff;height:15px;border:1px solid #ffd700;padding:5px;">information</div> \
									<div style="height:35px;padding:5px;">short description</div> \
									<div style="height:15px;text-align:right;padding:5px;">read more &raquo;</div> \
								</div>',
					innerHtmlStyle: {
										color:'#000', 
										'text-align':'center'
									},
					themeName: 	'orange',
					themePath: 	'<%=renderRequest.getContextPath()%>/js/bubblepopup/jquerybubblepopup-theme'
			});
			
			//
			// load indicators data
			//
			$j.getJSON('<%=request.getContextPath()%>/prototype-data/indicators.json',
				function(json) {
					indicators = json.indicators.indicator;
				})
				.success(function() {})
				.error(function() {})
				.complete(function() {});	

			// handle change to sector selector
			$('#sector-select').change(function() {
				displayIndicators(filterIndicators('sector', $(this).attr('value')));
			});
				
		});
		
		$j.jQueryRandom = 0;
		$j.extend($j.expr[":"], {
			random: function(a, i, m, r) {
						if (i == 0) {
							$j.jQueryRandom = Math.floor(Math.random() * r.length);
						};
						return i == $j.jQueryRandom;
					}
			});
						
		function displayIndicators(indicators) {
			$j('.indicator-category-list').fadeOut();
			$j('.indicator-category-list').empty();
			$j.each(indicators, function() {
				var indicator;
				if(this.url != null && this.url.length > 0) {
					var u = this.url;
					var ln = this.layername;
					var t = this.title;
					var randomIndicatorType = $j('.indicator-category-list:random');
					indicator = $j(document.createElement("div"))
						.addClass("indicator-category-list-item")
						.addClass("clickable")
						.attr({ style: 'float:left;' })
						.append(t)
						.appendTo(randomIndicatorType)
						.click(function() {
							app.addLayer(u, ln, t);
						});
						$j(document.createElement("img"))
							.attr({ src: '<%=renderRequest.getContextPath()%>/images/map_icon.gif', title: 'show map' })
							.attr({ style: 'float:left;margin-left:5px;' })
							.appendTo(randomIndicatorType);
						$j(document.createElement("hr"))
							.attr({ style: 'clear:both;display:block;visibility:hidden;' })
							.appendTo(randomIndicatorType);															
				}
				else {
					indicator = '<div class="indicator-category-list-item">' + this.title + '</div>';				
					$j('.indicator-category-list:random').append(indicator);			
				}
			}); 
			$j('.indicator-category-list').fadeIn();
		}	
		
		function filterIndicators(filterproperty, filtervalue) {
			var indicatorsDisplayed = new Array();
			if(filtervalue === 'all') {
				return indicators;
			}
			if(filtervalue === 'none') {
				return indicatorsDisplayed;
			}			
			$j.each(indicators, function(idx, indicator){
				$j.each(indicator, function(property, value){
					if(property === filterproperty) {
						if($j.isArray(value)) {
							$j.each(value, function(ix, v){
								if(v === filtervalue) {
									indicatorsDisplayed.push(indicator);
								}
							});
						}
						else {
							if(value === filtervalue) {
								indicatorsDisplayed.push(indicator);
							}
						}
					}
				});
			});
			return indicatorsDisplayed;
		}
		
            </script>
		
	<div id="step-right-2" class="step-right">		
		<h1 id="adaptationtools-heading">
			<img src="<%=renderRequest.getContextPath()%>/images/bullit2.png" class="valigned"/>	
			Am I vulnerable to climate change and what are my risks
		</h1>
		
		<div id="general-content" class="what-should-i-do-content">
			<img src="<%=renderRequest.getContextPath()%>/images/step-2.jpg" style="float:right;margin-right:30px;"/>
			<div id="general-content-text" style="float:left;width:50%;margin-left:30px;">
				Next step after preparing the ground is vulnerability assessment. It is the analysis of the expected impacts, risks and the adaptive capacity of an area in the context of climate change.
				The objective of this step is to gain a better understanding of how and in what way climate change will affect the services, social groups, economic sectors and assets and to identify
				the priority areas for action. Vulnerability assessment is more than measuring potential harm using information about climate impacts. It includes an assessment of the area's ability
				to adapt.
			</div>
		</div>
		
		<div id="indicators-map" style="display:none;">
		
			<div id="adaptationtools-selectors-top">
				<div id="risks-selector" class="adaptationtools-selector">
					<!-- TODO load dynamically from enumeration nl.wur.alterra.cgi.ace.model.impl.AceItemClimateImpact -- but aceitem model classes must be made available as a jar for that -->
					<select  style="float:left;">
						<option value="none" selected="selected">Choose a risk:</option>
						<option value="all">All risks</option>
						<option value="EXTREMETEMP">Extreme Temperatures</option>
						<option value="WATERSCARCE">Water Scarcity</option>
						<option value="FLOODING">Flooding</option>
						<option value="DROUGHT">Droughts</option>
						<option value="STORM">Storms</option>
						<option value="ICEANDSNOW">Ice and Snow</option>
					</select>
					<div class="top-bubble" style="float:left;margin-left:10px;">
						<img src="<%=renderRequest.getContextPath()%>/images/info.png" class="valigned"/>
					</div>	
				</div>		
			
				<div id="sector-selector"  class="adaptationtools-selector">
					<span style="margin-right:30px;">
						Filter by sector
					</span>
					<!-- TODO load dynamically from enumeration nl.wur.alterra.cgi.ace.model.impl.AceItemSector -- but aceitem model classes must be made available as a jar for that -->
					<select id="sector-select" style="float:left;">
						<option value="none" selected="selected">Choose a sector:</option>
						<option value="all">All sectors</option>
						<option value="AGRICULTURE">Agriculture and Forest</option>
						<option value="BIODIVERSITY" disabled="disabled">Biodiversity</option>
						<option value="COASTAL" disabled="disabled">Coastal areas</option>
						<option value="DISASTERRISKREDUCTION" disabled="disabled">Disaster Risk Reduction</option>
						<option value="FINANCIAL" disabled="disabled">Financial</option>
						<option value="HEALTH" disabled="disabled">Health</option>
						<option value="INFRASTRUCTURE" disabled="disabled">Infrastructure</option>
						<option value="MARINE" disabled="disabled">Marine and Fisheries</option>
						<option value="WATERMANAGEMENT">Water management</option>
					</select>				
					<div class="top-bubble" style="float:left;margin-left:10px;">
						<img src="<%=renderRequest.getContextPath()%>/images/info.png" class="valigned"/>
					</div>
				</div>			
			</div>
			
			<hr style="clear:both;display:block;visibility:hidden;"></hr>

			<div id="map_container">
				<div id="map_info">This is a map info panel</div>
				<div class="map-overlay">
					<form>
					Locate: <input type="text" name="locate" />&nbsp;<button type="submit">Find</button>
					</form>
				</div>
			</div>
			<div id="map_legend"></div>
				
			<div id="adaptationtools-indicators">
				<h2>
					Indicators
				</h2>
				
				<div id="indicator-vulnerability" class="indicator-category">

					<div class="right-bubble" style="float:left;margin-right:10px;">
						<img src="<%=renderRequest.getContextPath()%>/images/info.png" class="valigned"/>
					</div>
					<h3 class="indicator-category-title">
						Vulnerability & risks
					</h3>					
					<div class="indicator-category-list"></div>
				</div>

				<h2 class="disabled">
					Underlying causes
				</h2>

				<div id="indicator-exposure" class="indicator-category disabled">
					<div class="info-button right-bubble">
						i
					</div>
					<h3 class="indicator-category-title">
						Exposure
					</h3>
					<div class="indicator-category-list"></div>
				</div>

				<div id="indicator-sensitivity" class="indicator-category disabled">
					<div class="info-button right-bubble">
						i
					</div>
					<h3 class="indicator-category-title">
						Sensitivity
					</h3>					
					<div class="indicator-category-list"></div>
				</div>
				
				<div id="indicator-climate-changes" class="xindicator-category" style="display:none;">
					<div class="info-button right-bubble">
						i
					</div>
					<h3 class="indicator-category-title">
						Climate changes
					</h3>
					<div class="indicator-category-list"></div>
				</div>
					
				<div id="indicator-human-causes" class="xindicator-category"  style="display:none;">
					<div class="info-button right-bubble">
						i
					</div>
					<h3 class="indicator-category-title">
						Underlying human causes
					</h3>					
					<div class="indicator-category-list"></div>
				</div>
					
			</div>
		
			<hr style="clear:both;display:block;visibility:hidden;"></hr>

			<div style="padding:10px;margin:10px;">
				<div id="read-more-on-the-approach" style="float:left;">
					Read more on the approach &raquo;
				</div>
				<div id="time-selector" style="float:right;">
					<span style="margin-right:30px;">
						Time
					</span>
					<select disabled="disabled">
						<option>
							2050
						</option>	
					</select>
					<div class="info-button top-bubble">
						i
					</div>			
				</div>
				<div id="scenario-selector" style="float:right;margin-right:60px;">
					<span style="margin-right:30px;">
						Scenario
					</span>
					<select disabled="disabled">
						<option>
							Economy first
						</option>	
					</select>
					<div class="info-button top-bubble">
						i
					</div>			
				</div>
			</div>
		<!-- end of indicators map page -->
		</div>
		
	<!-- end of step2 -->
	</div>
	
	<hr style="clear:both;display:block;visibility:hidden;"></hr>
	
    <!--

			step 4

	-->
	<div id="step-right-4" class="step-right">

		<hr style="clear:both;display:block;visibility:hidden;"></hr>
        <div id="map-container-step4">
        </div>
	</div>

	<!-- acemap_column -->
    </div>
<!-- outer div -->	
</div>	
