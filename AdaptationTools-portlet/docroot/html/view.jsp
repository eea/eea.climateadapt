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
		var $j = jQuery.noConflict();
		$j(document).ready(function(){			
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
		
			
		});
            </script>
			
	<h1 id="adaptationtools-heading">
		Am I vulnerable to climate change and what are my risks
	</h1>
	
	<div id="adaptationtools-selectors-top">
		<div id="risks-selector" class="adaptationtools-selector">
			<select>
				<option>choose a risk</option>
				<option>Water scarcity</option>
				<option>Droughts</option>
				<option>Flooding</option>
			</select>
			<div class="info-button top-bubble">
				i
			</div>	
		</div>		
		<div id="sector-selector"  class="adaptationtools-selector">
			<span style="margin-right:30px;">
				Filter by sector
			</span>
			<!-- TODO load dynamically from enumeration -- but aceitem model classes must be made available as a jar for that -->
			<select>
				<option disabled="disabled" value="all">
					all
				</option>
				<option value="AGRICULTURE">
					Agriculture and Forest
				</option>
				<option disabled="disabled" value="BIODIVERSITY">
					Biodiversity
				</option>
				<option disabled="disabled" value="COASTAL">
					Coastal areas
				</option>
				<option disabled="disabled" value="DISASTERRISKREDUCTION">
					Disaster Risk Reduction
				</option>
				<option disabled="disabled" value="FINANCIAL"">
					Financial
				</option>
				<option disabled="disabled" value="HEALTH">
					Health
				</option>
				<option disabled="disabled" value="INFRASTRUCTURE">
					Infrastructure
				</option>
				<option disabled="disabled" value="MARINE">
					Marine and Fisheries
				</option>
				<option value="WATERMANAGEMENT">
					Water management
				</option>
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
		</div>
				
		<div id="indicator-exposure" class="indicator-category">
			<div class="info-button right-bubble">
				i
			</div>
			<h3 class="indicator-category-title">
				Exposure
			</h3>
		</div>
				
		<div id="indicator-sensitivity" class="indicator-category">
			<div class="info-button right-bubble">
				i
			</div>
			<h3 class="indicator-category-title">
				Sensitivity
			</h3>					
		</div>
		
		<div id="indicator-vulnerability" class="indicator-category">
			<div class="info-button right-bubble">
				i
			</div>
			<h3 class="indicator-category-title">
				Vulnerability & risks
			</h3>					
		</div>
				
		<div id="indicator-human-causes" class="indicator-category">
			<div class="info-button right-bubble">
				i
			</div>
			<h3 class="indicator-category-title">
				Underlying human causes
			</h3>					
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