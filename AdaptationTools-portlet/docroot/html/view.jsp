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

<div>
    <div id="acemap_column" style="margin-right: 10px; margin-top: 50px; float:left;border:solid 1px red;width:850px;">
    <script defer="defer" type="text/javascript">
		var indicators = new Array();
		var $j = jQuery.noConflict();
		$j(document).ready(function(){	
		
			//
			// create information popups
			//
			$j('.info-button.top-bubble').CreateBubblePopup({
					position : 'top',
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
			$j.getJSON('http://<%=request.getContextPath()%>/AdaptationTools-portlet/prototype-data/indicators.json',
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
			$j('.indicator-category-list').empty();
			$j('.indicator-category-list').hide();
			$j.each(indicators, function() {
				var indicator = '<div class="indicator-category-list-item">' + this.title + '</div>';
				$j('.indicator-category-list:random').append(indicator);			
			}); 
			$j('.indicator-category-list').fadeIn();
		}
		
		function filterIndicators(filterproperty, filtervalue) {
			var indicatorsDisplayed = new Array();
			if(filtervalue === 'all') {
				return indicators;
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
			
	<h1 id="adaptationtools-heading">
		Am I vulnerable to climate change and what are my risks
	</h1>
	
	<div id="adaptationtools-selectors-top">
		<div id="risks-selector" class="adaptationtools-selector">
			<!-- TODO load dynamically from enumeration nl.wur.alterra.cgi.ace.model.impl.AceItemClimateImpact -- but aceitem model classes must be made available as a jar for that -->
			<select>
				<option value="none" selected="selected">Choose a risk:</option>
				<option value="all">All risks</option>
				<option value="EXTREMETEMP">Extreme Temperatures</option>
				<option value="WATERSCARCE">Water Scarcity</option>
				<option value="FLOODING">Flooding</option>
				<option value="DROUGHT">Droughts</option>
				<option value="STORM">Storms</option>
				<option value="ICEANDSNOW">Ice and Snow</option>
			</select>
			<div class="info-button top-bubble">
				i
			</div>	
		</div>		
		
		<div id="sector-selector"  class="adaptationtools-selector">
			<span style="margin-right:30px;">
				Filter by sector
			</span>
			<!-- TODO load dynamically from enumeration nl.wur.alterra.cgi.ace.model.impl.AceItemSector -- but aceitem model classes must be made available as a jar for that -->
			<select id="sector-select">
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
			<div class="info-button top-bubble">
				i
			</div>
		</div>
	</div>
    	
	
	<hr style="clear:both;display:block;visibility:hidden;"></hr>

	<div id="map_container">
		<div class="map-overlay">
			<form>
			Locate: <input type="text" name="locate" />&nbsp;<button type="submit">Find</button>
			</form>
		</div>
	</div>
			
	<div id="adaptationtools-indicators">
		<h2>
			Indicators
		</h2>
		
		<div id="indicator-climate-changes" class="indicator-category">
			<div class="info-button right-bubble">
				i
			</div>
			<h3 class="indicator-category-title">
				Climate changes
			</h3>
			<div class="indicator-category-list"></div>
		</div>
				
		<div id="indicator-exposure" class="indicator-category">
			<div class="info-button right-bubble">
				i
			</div>
			<h3 class="indicator-category-title">
				Exposure
			</h3>
			<div class="indicator-category-list"></div>
		</div>
				
		<div id="indicator-sensitivity" class="indicator-category">
			<div class="info-button right-bubble">
				i
			</div>
			<h3 class="indicator-category-title">
				Sensitivity
			</h3>					
			<div class="indicator-category-list"></div>
		</div>
		
		<div id="indicator-vulnerability" class="indicator-category">
			<div class="info-button right-bubble">
				i
			</div>
			<h3 class="indicator-category-title">
				Vulnerability & risks
			</h3>					
			<div class="indicator-category-list"></div>
		</div>
				
		<div id="indicator-human-causes" class="indicator-category">
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
	
	<hr style="clear:both;display:block;visibility:hidden;"></hr>
	

	<!-- acemap_column -->
    </div>
<!-- outer div -->	
</div>	
