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

<%@include file="/html/init.jsp" %>

<portlet:defineObjects />

<%
HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(request);
%>

<script defer="defer" type="text/javascript">
    var proxyUrl = '<%= request.getContextPath() %>/proxy?url=';

    OpenLayers.ProxyHost = '<%= request.getContextPath() %>/proxy?url=';

    var $j = jQuery.noConflict();
	
	

	function displayStep(nr) {

        if(nr !== 1) {
			$j("#image_steps").attr("src", "<%=renderRequest.getContextPath()%>/images/AST_small" + nr + ".png").fadeIn();
		}
        if(nr === 1) {
			$j("#image_steps").attr("src", "<%=renderRequest.getContextPath()%>/images/AST_small" + nr + ".png").hide();
		}

		$j('.step-left').hide();
		$j('#step-left-'+nr).fadeIn();
		$j('.step-right').hide();
		$j('#step-right-'+nr).fadeIn();
	}
	
	
	function step2substep(headingId) {
		
		var hashedHeadingId = '#' + headingId;

		var substepOptionIds = ['#analyze-maps-options', '#analyze-nas-options', '#what-should-i-do-options']
		var substepContentIds = ['#indicators-map', '#analyze-nas-content', '#general-content'];
		var substepHeadingIds = ['#analyze-maps-heading', '#analyze-nas-heading', '#what-should-i-do-heading'];
	
		$j.each(substepOptionIds, function(index, value){
				$j(value).hide();
			});
		$j.each(substepContentIds, function(index, value){
				$j(value).hide();
			});	
			
		$j('.step2heading').hide();
		$j('.step2description').hide();
			
		$j.each(substepHeadingIds, function(index, value){
				$j(value).addClass('clickable');
				if(hashedHeadingId === value) {
					$j(substepOptionIds[index]).fadeIn();
					$j(substepContentIds[index]).fadeIn();
				}
			});
		$j(hashedHeadingId).removeClass('clickable');

		
			
	}
	
</script>

<div id="adaptationtool_container">
	<!-- left panel -->
	<div class="adaptationtool-column" style="float:left;width:385px;background-color:#d2df92;">

        <!-- Steps selection image -->
        <div>
            <img id="image_steps" src="<%=renderRequest.getContextPath()%>/images/AST_small1.png" width="380px" height="236px" usemap="#navigation-map" style="display:none;"/>
        </div>

		<!--
		
				step 1
				
		-->


		<div id="step-left-1" class="step-left">
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
							<img src="<%=renderRequest.getContextPath()%>/images/arrow_green.png" class="valigned"/>
							<span style="margin-left:5px;">
								Design of guidelines for the elaboration of Regional Climate Change Adaptation Strategies
							</span>
						</div>
						<div style="margin:20px 0px;">
							<img src="<%=renderRequest.getContextPath()%>/images/arrow_green.png" class="valigned"/>
							<span style="margin-left:5px;">
								Integrating Climate Change Adaptation into Development Co-operation
							</span>
						</div>					
					</div>				
				</div>			
				<hr style="clear:both;display:block;visibility:hidden;"/>
			</div>
			<!-- navigation in images -->
			<map name="navigation-map" id="navigation-map">
				<area shape="poly" coords="151,17,148,56,242,61,243,16" nohref="nohref" onclick="displayStep(1);" class="clickable"/>
				<area shape="poly" coords="181,60,332,58,346,99,191,96,191,96,192,102" nohref="nohref" onclick="displayStep(2);" class="clickable" />
				<area shape="poly" coords="190,107,333,109,341,145,192,144" nohref="nohref" onclick="displayStep(3);" class="clickable" />
				<area shape="poly" coords="175,152,332,153,336,186,180,186,170,172" nohref="nohref" onclick="displayStep(4);showGenericMeasures();" class="clickable" />
				<area shape="poly" coords="123,177,165,177,181,188,233,192,278,199,280,224,130,227,122,205" nohref="nohref" onclick="displayStep(5);" class="clickable" />
			</map>
		
		<!-- end step 1 -->	
		</div>

		<!--
		
				step 2
				
		-->
		<div id="step-left-2" class="step-left">
			<div id="what-should-i-do" style="margin:5px;">
				<div id="what-should-i-do-heading" style="font-size:24px;" onclick="step2substep(this.id);">
					What should I do?
				</div>
				<div id="what-should-i-do-options" style="">
					<ul style="list-style:none;">
						<li class="list-option">
							<img src="<%=renderRequest.getContextPath()%>/images/arrow_green.png" class="valigned"/>
							1. General
						</li>
						<li class="list-option">
							<img src="<%=renderRequest.getContextPath()%>/images/arrow_green.png" class="valigned"/>
							2. What are key systems?
						</li>
						<li class="list-option">
							<img src="<%=renderRequest.getContextPath()%>/images/arrow_green.png" class="valigned"/>
							3. How do I analyze impacts of past weather?
						</li>
						<li class="list-option">
							<img src="<%=renderRequest.getContextPath()%>/images/arrow_green.png" class="valigned"/>
							4. How do I analyze recent climate trends?
						</li>
						<li class="list-option">
							<img src="<%=renderRequest.getContextPath()%>/images/arrow_green.png" class="valigned"/>
							5. Where do I find possible scenarios?
						</li>
						<li class="list-option">
							<img src="<%=renderRequest.getContextPath()%>/images/arrow_green.png" class="valigned"/>
							6. How do I identify impacts of climate change?
						</li>
						<li class="list-option">
							<img src="<%=renderRequest.getContextPath()%>/images/arrow_green.png" class="valigned"/>
							7. How do I assess vulnerability?
						</li>
						<li class="list-option">
							<img src="<%=renderRequest.getContextPath()%>/images/arrow_green.png" class="valigned"/>
							8. What about risks and opportunities?
						</li>
					</ul>
				</div>
			</div>
			<div id="analyze-in-nas" style="margin:5px;">
				<div id="analyze-nas-heading" class="clickable" style="font-size:24px;" onclick="step2substep(this.id);">
					Assessments	in my region
				</div>
				<div id="analyze-nas-options" style="display:none;">
					<ul style="list-style:none;">
						<li class="list-option">
							<img src="<%=renderRequest.getContextPath()%>/images/arrow_green.png" class="valigned"/>
							1. <a href="#" onclick="showGoToNAS(); return false">National adaptation strategies</a>
						</li>
					</ul>	
				</div>
			</div>
			
			
			<div id="analyze-maps" style="margin:5px;">
				<div id="analyze-maps-heading" class="clickable" style="font-size:24px;" onclick="step2substep(this.id);showVulnerabilitiesAndRisks(); initMapViewerIndicators();">
					Compare my region to Europe
				</div>
				<div id="analyze-maps-options" style="display:none;">
					<ul style="list-style:none;">
						<li class="list-option">
							<img src="<%=renderRequest.getContextPath()%>/images/arrow_green.png" class="valigned"/>
							1. <a href="#" onclick="showVulnerabilitiesAndRisks(); return false">What are the key vulnerabilities and risks?</a>
						</li>
						<li class="list-option">
							<img src="<%=renderRequest.getContextPath()%>/images/arrow_green.png" class="valigned"/>
							2. <a href="#" onclick="showUnderlyingCauses(); return false">What are the underlying causes?</a>
						</li>
						<li class="list-option">
							<img src="<%=renderRequest.getContextPath()%>/images/arrow_green.png" class="valigned"/>
							3. <a href="#" onclick="showUnderlyingNaturalCauses(); return false">How does the climate change?</a>
						</li>
						<li class="list-option">
							<img src="<%=renderRequest.getContextPath()%>/images/arrow_green.png" class="valigned"/>
							4. <a href="#" onclick="showUnderlyingHumanCauses(); return false">How does the socio-ecological system change?</a>
						</li>
						<li class="list-option">
							<img src="<%=renderRequest.getContextPath()%>/images/arrow_green.png" class="valigned"/>
							5. Uncertainties
						</li>
					</ul>			
				</div>
			</div>

		<!-- end step 2 -->
		</div>

        <!--

               step 3

        -->
        <div id="step-left-3" class="step-left">

        <!-- end step 3 -->
        </div>


        <!--

				step 4

		-->
		<div id="step-left-4" class="step-left">
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
					<ul style="list-style:none;">
						<li class="list-option">
                            <img src="<%=renderRequest.getContextPath()%>/images/arrow_green.png" class="valigned"/>
							1. <a href="#" onclick="showGenericMeasures(); return false;">What are possible measures?</a>
						</li>
						<li class="list-option">
                            <img src="<%=renderRequest.getContextPath()%>/images/arrow_green.png" class="valigned"/>
							2. <a href="#" onclick="showGoodPractices(); return false;">What are possible good practices?</a>
						</li>						
						<li class="list-option">
                            <img src="<%=renderRequest.getContextPath()%>/images/arrow_green.png" class="valigned"/>
							3. <a href="#" onclick="showLocateRegion(); return false;">What good practices are available in regions similar to mine?</a>
						</li>
					</ul>
				</div>
			</div>

		<!-- end step 4 -->
		</div>

        <!--

                step 5

        -->
        <div id="step-left-5" class="step-left">
            <div id="what-should-i-do-5" style="margin:5px;">
                <div id="what-should-i-do-5-heading" style="font-size:24px;">
                    What should I do?
                </div>
                <div id="what-should-i-do-5-options" style="">
                    <ul style="list-style:none;">
                        <li>
                            <img src="<%=renderRequest.getContextPath()%>/images/arrow_green.png" class="green-arrow"/>
                            1. General
                        </li>
                        <li>
                            <img src="<%=renderRequest.getContextPath()%>/images/arrow_green.png" class="green-arrow"/>
                            2. What are the feasible adaptation options?
                        </li>
                        <li>
                            <img src="<%=renderRequest.getContextPath()%>/images/arrow_green.png" class="green-arrow"/>
                            3. How can I agree to set adaptation measures?
                        </li>
                        <li>
                            <img src="<%=renderRequest.getContextPath()%>/images/arrow_green.png" class="green-arrow"/>
                            4. How can I design implementation plan?
                        </li>
                    </ul>
                </div>
            </div>
            <div id="search-cost-benefir-db" style="margin:5px;">
                <div id="search-cost-benefir-db-heading" style="font-size:24px;">
                    Search the cost benefit database
                </div>
            </div>

        <!-- end step 2 -->
        </div>

	<!-- end left panel -->
	</div>
	
	<!-- right panel -->
    <div  class="adaptationtool-column" id="acemap_column" style="margin-right: 10px; float:left;width:850px;background:#fff;">
	<!--
	
			step 1
			
	-->
	<div id="step-right-1" class="step-right">
		<img src="<%=renderRequest.getContextPath()%>/images/AST_large.png" usemap="#large-navigation"/>
		<map name="large-navigation" id="large-navigation">
		  <area shape="poly" coords="415,131,480,106,699,129,699,208,432,186,412,163" nohref="nohref" onclick="displayStep(2);" class="clickable" style="cursor:hand !important;z-index:999;"/>
		  <area shape="poly" coords="698,213,441,195,416,224,432,265,481,282,698,280" nohref="nohref" onclick="displayStep(3);" class="clickable"/>
		  <area shape="poly" coords="682,301,471,296,427,282,397,295,399,333,428,357,483,359,653,359,681,348" nohref="nohref" onclick="displayStep(4);showGenericMeasures();" class="clickable"/>
		  <area shape="poly" coords="414,361,376,332,314,332,292,365,292,402,344,425,439,429,669,432,668,383,632,371" nohref="nohref" onclick="displayStep(5);" class="clickable"/>
		</map>		
		<hr style="clear:both;display:block;visibility:hidden;" />
	</div>
	
	<!--
	
			step 2 
			
	-->
    <script defer="defer" type="text/javascript">
		var indicators = new Array();
		var $j = jQuery.noConflict();
		$j(document).ready(function(){	
				
			// force risk and sector selectors to defaults
			$j('#risk-select option[value="none"]').attr('selected', 'selected');
			$j('#sector-select option[value="none"]').attr('selected', 'selected');

			$j('.adaptationtool-column').equalHeights();			
			
			//
			// create information popups
			//
			// the zoom and opacity in the innerHtml's div is because IE renders the popups transparent otherwise
			$j('.top-bubble').CreateBubblePopup({
					position : 'top',
                    selectable: true,
					align	 : 'center',
					innerHtml: '<div style="position:relative;z-index:9999;background:#fff;zoom:1;filter:alpha(opacity = 100);"> \
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
			
			//
			// load indicators data
			//
			$j.getJSON('<%=request.getContextPath()%>/prototype-data/indicators.json',
				function(json) {
					indicators = json.indicators.indicator;
				})
				.success(function() {
						$j('#risk-select').removeAttr("disabled");
						$j('#sector-select').removeAttr("disabled");
					})
				.error(function() {})
				.complete(function() {});	

			// handle change to sector selector
			$j('#sector-select').change(function() {
				displayIndicators(filterIndicators($j('#risk-select').attr('value'), $j(this).attr('value')));
				showVulnerabilitiesAndRisks();
			});
			// handle change to risk selector
			$j('#risk-select').change(function() {
				displayIndicators(filterIndicators($j(this).attr('value'), $j('#sector-select').attr('value')));
				showVulnerabilitiesAndRisks();
			});			
				
		});
		
		// utility to select random children -- TODO move to utilities file
		$j.jQueryRandom = 0;
		$j.extend($j.expr[":"], {
			random: function(a, i, m, r) {
						if (i == 0) {
							$j.jQueryRandom = Math.floor(Math.random() * r.length);
						};
						return i == $j.jQueryRandom;
					}
			});
						
						
		// displays indicators, based on their indicator-type.				
		function displayIndicators(indicators) {
			$j('.indicator-category-list').fadeOut();
			$j('.indicator-category-list').empty();
			$j.each(indicators, function() {
				var indicator;
				if(this.riskandsector.url != null && this.riskandsector.url.length > 0) {
					var u = this.riskandsector.url;
					var ln = this.riskandsector.layername;
					var t = this.title;
					var y = this.riskandsector.indicatortype;
					
					// var randomIndicatorType = $j('.indicator-category-list:random');
					
					var indicatortype ;
					
					if(y === 'VULNERABILITY') {
						indicatortype = $j('#indicator-vulnerability .indicator-category-list');
					}
					else if(y === 'CLIMATECHANGES') {
						indicatortype = $j('#indicator-climate-changes .indicator-category-list');					
					}
					else if(y === 'EXPOSURE') {
						indicatortype = $j('#indicator-exposure .indicator-category-list');					
					}					
					else if(y === 'SENSITIVITY') {
						indicatortype = $j('#indicator-sensitivity .indicator-category-list');					
					}
					else if(y === 'RESOURCEEFFICIENCY') {
						indicatortype = $j('#indicator-human-causes .indicator-category-list');					
					}
					
					indicator = $j(document.createElement("div"))
						.addClass("indicator-category-list-item")
						.addClass("clickable")
						.attr({ style: 'float:left;' })
						.append(t)
						.appendTo(indicatortype)
						.click(function() {
							app.addLayer(u, ln, t);
							
							/* do not do this anymore; user must use steps in left panel
							// if this is a vulnerability type
							if(y === 'VULNERABILITY') {
								// enable underlying cause indicators
								showUnderlyingCauses();								
							}
							*/
							
							// if this is an underlying cause type
							if(y === 'EXPOSURE') {
								// enable climate changes
								showUnderlyingNaturalCauses();
							}
							else if(y === 'SENSITIVITY') {
								// enable resource efficiency
								showUnderlyingHumanCauses();
							}
						});
				
					// no map icon	
					//$j(document.createElement("img"))
					//		.attr({ src: '<%=renderRequest.getContextPath()%>/images/map_icon.gif', title: 'show map' })
					//		.attr({ style: 'float:left;margin-left:5px;' })
					//		.appendTo(indicatortype);
					
						$j(document.createElement("hr"))
							.attr({ style: 'clear:both;display:block;visibility:hidden;' })
							.appendTo(indicatortype);															
				}
				
				// no url ? no display
				//else {
				//	indicator = '<div class="indicator-category-list-item">' + this.riskandsector.title + '</div>';				
				//	$j('.indicator-category-list:random').append(indicator);			
				//}
				
			}); 
			$j('.indicator-category-list').fadeIn();
		}	
		
		// filters indicators. They are filtered by a combination of values for RISK and SECTOR.
		function filterIndicators(riskvalue, sectorvalue) {
			// both filters set to 'all'
			if(riskvalue === 'all' && sectorvalue === 'all') {
				// use global variable holding all indicators
				return indicators;
			}
			var indicatorsDisplayed = new Array();
			// either one or both filters set to 'none'
			if(riskvalue === 'none' || sectorvalue === 'none') {
				// use empty array of indicators
				return indicatorsDisplayed;
			}			
			// loop all indicators
			$j.each(indicators, function(idx, indicator){
				// loop all riskandsectors
				$j.each(indicator, function(idx2, riskandsector){
					if(idx2 === 'riskandsector') {
						var riskFilterOK = false;
						var sectorFilterOK = false;
						// loop all riskandsector children
						$j.each(riskandsector, function(idx3, child){
								// the risk defined for this riskandsector
								if(idx3 === 'risk') {
									// is equal to the user's filter risk 
									if(child === riskvalue || riskvalue === 'all') {
										riskFilterOK = true;
								}
						}
								// the sector defined for this riskandsector
								if(idx3 === 'sector') {
									// is equal to the user's filter sector 
									if(child === sectorvalue || sectorvalue === 'all') {
										sectorFilterOK = true;
							}
						}
							});
						if(riskFilterOK && sectorFilterOK) {
							indicatorsDisplayed.push(indicator);
						}						
					}
				});
			});
			return indicatorsDisplayed;
		}

        function showVulnerabilitiesAndRisks() {

			$j('.step2heading').hide();
			$j('.step2description').hide();

            $j("#header-vulnerability").fadeIn();
            $j("#text-vulnerability").fadeIn();

            $j("#underlying-causes-header").text("Underlying causes");

            $j("#underlying-causes-header").addClass("disabled");
            $j("#indicator-exposure").addClass("disabled");
            $j("#indicator-sensitivity").addClass("disabled");

            $j("#indicator-sensitivity").fadeIn();
            $j("#indicator-exposure").fadeIn();
            $j("#indicator-climate-changes").hide();
            $j("#indicator-human-causes").hide();
        }

        function showUnderlyingCauses() {
            $j("#header-vulnerability").hide();
            $j("#text-vulnerability").hide();

            $j("#header-climate-change").hide();
            $j("#text-climate-change").hide();

            $j("#header-socio-ecological").hide();
            $j("#text-socio-ecological").hide();

            $j("#header-underlying-causes").fadeIn();
            $j("#text-underlying-causes").fadeIn();

            $j("#underlying-causes-header").text("Underlying causes");

            $j("#underlying-causes-header").removeClass("disabled");
            $j("#indicator-exposure").removeClass("disabled");
            $j("#indicator-sensitivity").removeClass("disabled");

            $j("#indicator-sensitivity").fadeIn();
            $j("#indicator-exposure").fadeIn();
            $j("#indicator-climate-changes").hide();


        }

        function showUnderlyingNaturalCauses() {

			$j('.step2heading').hide();
			$j('.step2description').hide();

            $j("#header-climate-change").fadeIn();
            $j("#text-climate-change").fadeIn();

            $j("#underlying-causes-header").text("Underlying natural causes");

            $j("#indicator-changes").hide();
            $j("#indicator-human-causes").hide();
            $j("#indicator-climate-changes").fadeIn();

            $j("#underlying-causes-header").removeClass("disabled");
            $j("#indicator-exposure").removeClass("disabled");
            $j("#indicator-sensitivity").hide();
            $j("#indicator-exposure").fadeIn();
        }

		function showGoToNAS() {

			$j('.step2heading').hide();
			$j('.step2description').hide();

			$j("#analyze-nas-content").fadeIn();
		}

         function showUnderlyingHumanCauses() {
		 
			$j('.step2heading').hide();
			$j('.step2description').hide();

            $j("#header-socio-ecological").fadeIn();
            $j("#text-socio-ecological").fadeIn();

            $j("#underlying-causes-header").text("Underlying human causes");

            $j("#indicator-changes").hide();
            $j("#indicator-climate-changes").hide();
            $j("#indicator-human-causes").fadeIn();

            $j("#underlying-causes-header").removeClass("disabled");
            $j("#indicator-sensitivity").removeClass("disabled");
            $j("#indicator-exposure").hide();
            $j("#indicator-climate-changes").hide();
            $j("#indicator-sensitivity").fadeIn();
        }
            </script>
		
	<div id="step-right-2" class="step-right">		
		<h1 id="adaptationtools-heading">
			<img src="<%=renderRequest.getContextPath()%>/images/bullit2.png" class="valigned"/>	
			Am I vulnerable to climate change and what are my risks
		</h1>

         <h2 id="header-vulnerability" class="heading step2heading" style="display: none">
             1. What are the key vulnerabilities and risks?
         </h2>

        <h2 id="header-underlying-causes" class="heading step2heading" style="display: none">
             2. What are the underlying causes?
        </h2>

        <h2 id="header-climate-change" class="heading step2heading" style="display: none">
             3. How does the climate change?
        </h2>

        <h2 id="header-socio-ecological" class="heading step2heading" style="display: none">
             4. How does the socio-ecological system change?
        </h2>

		<div id="general-content" class="what-should-i-do-content">
			<img src="<%=renderRequest.getContextPath()%>/images/step-2.jpg" style="float:right;margin-right:30px;"/>
			<div id="general-content-text" style="float:left;width:50%;margin-left:30px;">
				Next step after preparing the ground is vulnerability assessment. It is the analysis of the expected impacts, risks and the adaptive capacity of an area in the context of climate change.
				The objective of this step is to gain a better understanding of how and in what way climate change will affect the services, social groups, economic sectors and assets and to identify
				the priority areas for action. Vulnerability assessment is more than measuring potential harm using information about climate impacts. It includes an assessment of the area's ability
				to adapt.
			</div>
		</div>
		
		<div id="analyze-nas-content">
			<div id="analyze-nas-content-text" style="float:left;width:50%;margin-left:30px;">
				<a href="/national-adaptation-strategies" target="_blank">Open National Adaptation Strategies (new window)</a>
			</div>
		</div>
		
		<div id="indicators-map" style="display: none">
            <div id="text-vulnerability" class="description step2description" style="display: none">
                <p>
					Vulnerability is the degree to which a system is susceptible to, and unable to cope with, adverse effects of climate change, including climate variability and extremes. Vulnerability is a 
					function of the character, magnitude, and rate of climate change and variation to which a system is exposed, its sensitivity, and its adaptive capacity. (IPCC, 2007) There are many vulnerability 
					indicators, but most of them do not follow strictly the definition above, because adaptive capacity is ha highly controversial issue. Most of vulnerability  indicators are impact indicators, or 
					indicators, measuring the effect of climate change on the socio-ecological system.
                </p>
                <p>				
					Risk here denotes climate hazards, e.g., floods, droughts, water scarcity, heat waves, etc.				
				</p>
            </div>

            <div id="text-underlying-causes" class="description step2description" style="display: none">
                <p>
					Climate impacts arise from the interrelations between climate and socio-ecological systems. Climate impact indicators allow to identify vulnerable areas and sectors. As they are aggregated 
					indicators, they can not give information on what are the causes of the identified vulnerability and whether this vulnerability arises due to changes in physical system (exposure),  in 
					socio-ecological system (sensitivity) or in both. Therefore separate examination of the constituents of impact indicators is needed in order to understand the underlying causes of vulnerability.				
				</p>
            </div>

            <div id="text-climate-change" class="description step2description" style="display: none">
                <p>
					Current climate variables such as temperature, precipitation, river flow are characterized by  variability of their magnitudes (severity or intensity)  duration and timing. This variability is 
					studied on the basis of the statistics of past events. Current global climate change models indicate that climate change will modify some of these statistics.  Climate projections can help to 
					identify future trends, which are of great importance for contingency planning.				
				</p>
            </div>

             <div id="text-socio-ecological" class="description step2description" style="display: none">
                <p>
					Changes in climate are mostly not the only causes of vulnerability. Humans increase their vulnerability due to land use changes such as urbanization of flood (coastal)  plains, deforestation, land 
					degradation due to unsustainable agricultural practices. Resource use efficiency also has significant impact on vulnerability, especially in the case of water scarcity and droughts, as reduced water 
					use can counteract to some extend decreasing water availability.				
				</p>
            </div>

			<div id="adaptationtools-selectors-top" style="">
	
				<!-- added width because IE8 renders it at 100% width otherwise -->
				<div id="sector-selector"  class="adaptationtools-selector"  style="float:right;width:229px;">
					<div class="top-bubble" style="float:right;margin:0px 10px;">
						<img src="<%=renderRequest.getContextPath()%>/images/info.png" class="valigned"/>
					</div>	
					<span style="margin-right:10px;">
						Sector
					</span>
					<!-- TODO load dynamically from enumeration nl.wur.alterra.cgi.ace.model.impl.AceItemSector -->
					<select id="sector-select" style="" disabled="disabled">
						<option value="none" selected="selected">Choose a sector:</option>
						<option value="all" disabled="disabled">All sectors</option>
						<option value="AGRICULTURE">Agriculture and Forest</option>
						<option value="BIODIVERSITY" disabled="disabled">Biodiversity</option>
						<option value="COASTAL" disabled="disabled">Coastal Areas</option>
						<option value="DISASTERRISKREDUCTION" disabled="disabled">Disaster Risk Reduction</option>
						<option value="FINANCIAL" disabled="disabled">Financial</option>
						<option value="HEALTH" disabled="disabled">Health</option>
						<option value="INFRASTRUCTURE" disabled="disabled">Infrastructure</option>
						<option value="MARINE" disabled="disabled">Marine and Fisheries</option>
						<option value="WATERMANAGEMENT">Water Management</option>
					</select>				
				</div>			

				<!-- added width because IE8 renders it at 100% width otherwise -->				
				<div id="risks-selector" class="adaptationtools-selector" style="float:right;width:212px;">
					<div class="top-bubble" style="float:right;margin:0px 10px;">
						<img src="<%=renderRequest.getContextPath()%>/images/info.png" class="valigned"/>
					</div>	
					<span style="margin-right:10px;">
						Risk
					</span>
					<!-- TODO load dynamically from enumeration nl.wur.alterra.cgi.ace.model.impl.AceItemClimateImpact -->
					<select id="risk-select" style="" disabled="disabled">
						<option value="none" selected="selected">Choose a risk:</option>
						<option value="all" disabled="disabled">All risks</option>
						<!-- TODO this one is not present in enum AceItemClimateImpact -->
						<option value="SEALEVEL" disabled="disabled">Sea Level Rise</option>
						<option value="EXTREMETEMP" disabled="disabled">Extreme Temperatures</option>
						<option value="WATERSCARCE">Water Scarcity</option>
						<option value="FLOODING" disabled="disabled">Flooding</option>
						<option value="DROUGHT" disabled="disabled">Droughts</option>
						<option value="STORM" disabled="disabled">Storms</option>
						<option value="ICEANDSNOW" disabled="disabled">Ice and Snow</option>
					</select>
				</div>	
			
			</div>

            <div id="map_legend" style="float: right"><a href="#" onclick="app.showLegendWindow(); return false;">Show Legend</a></div>

			<hr style="clear:both;display:block;visibility:hidden;"/>


			<div id="map_container">
				<div id="map_info">This is a map info panel</div>

                <div id="locate_region_step2_results"></div>
                <div class="map-overlay">
                    <form>
					Locate: <input type="text" id="locate_region_step2_input" name="locate_region_step2_input" style="width:150px"/>&nbsp;<button type="submit" onclick="gazeeteerStep2.search($j('#locate_region_step2_input').val()); return false;" >Find</button>
					</form>
				</div>
			</div>


			<div id="adaptationtools-indicators">
				<h2>
					Select an indicator to view map
				</h2>
				
				<div id="indicator-vulnerability" class="indicator-category">
					<h3 class="indicator-category-title">
						Vulnerability & risks
					</h3>					
					<div class="indicator-category-list"></div>
				</div>

				<h2 id="underlying-causes-header" class="disabled">
					Underlying causes
				</h2>

				<div id="indicator-exposure" class="indicator-category disabled">
					<h3 class="indicator-category-title">
						Exposure
					</h3>
					<div class="indicator-category-list"></div>
				</div>

				<div id="indicator-sensitivity" class="indicator-category disabled">
					<h3 class="indicator-category-title">
						Sensitivity
					</h3>					
					<div class="indicator-category-list"></div>
				</div>
				
				<div id="indicator-climate-changes" class="indicator-category" style="display:none;">
					<h3 class="indicator-category-title">
						Climate changes
					</h3>
					<div class="indicator-category-list"></div>
				</div>
					
				<div id="indicator-human-causes" class="indicator-category"  style="display:none;">
					<h3 class="indicator-category-title">
						Resource efficiency
					</h3>					
					<div class="indicator-category-list"></div>
				</div>
					
			</div>
		
			<hr style="clear:both;display:block;visibility:hidden;"/>

			<div style="padding:10px;margin:10px;">
				<div id="read-more-on-the-approach" style="float:left;width:200px;">					
					<a href="/explain-ast-vul">Read more on the approach &raquo;</a>
				</div>
				<!-- added width because IE8 renders it at 100% width otherwise -->								
				<div id="model-selector" style="float:right;width:169px;">
					<div class="top-bubble" style="float:right;margin:0px 10px;">
						<img src="<%=renderRequest.getContextPath()%>/images/info.png" class="valigned"/>
					</div>
					<span style="margin-right:10px;">
						Model
					</span>
					<select disabled="disabled">
						<option>
							WATERGAP
						</option>	
					</select>		
				</div>
				<!-- added width because IE8 renders it at 100% width otherwise -->								
				<div id="time-selector" style="float:right;width:129px;">
					<div class="top-bubble" style="float:right;margin:0px 10px;">
						<img src="<%=renderRequest.getContextPath()%>/images/info.png" class="valigned"/>
					</div>		
					<span style="margin-right:10px;">
						Time
					</span>
					<select disabled="disabled">
						<option>
							2050
						</option>	
					</select>
					</div>		
				<!-- added width because IE8 renders it at 100% width otherwise -->									
				<div id="scenario-selector" style="float:right;width:192px;">
					<div class="top-bubble" style="float:right;margin:0px 10px;">
						<img src="<%=renderRequest.getContextPath()%>/images/info.png" class="valigned"/>
				</div>
					<span style="margin-right:10px;">
						Scenario
					</span>
					<select disabled="disabled">
						<option>
							Economy first
						</option>	
					</select>
				</div>
			</div>
		<!-- end of indicators map page -->
		</div>
		
	<!-- end of step2 -->
	</div>
	

    <!--

			step 3

	-->
	<div id="step-right-3" class="step-right">
        <h1 id="strategy-adaptation-heading">
			<img src="<%=renderRequest.getContextPath()%>/images/bullit3.png" class="valigned"/>
			What should be my strategy to adapt?
		</h1>

        <hr style="clear:both;display:block;visibility:hidden;"/>
	</div>

    <!--

			step 4

	-->
    <script defer="defer" type="text/javascript">
		var $j = jQuery.noConflict();

        function showGenericMeasures() {
            $j("#locate-region").hide()
            $j("#good-practices").hide()
            $j("#generic-measures").fadeIn();
        }

        function showLocateRegion() {
            $j("#good-practices").hide()
            $j("#generic-measures").hide();
            $j("#locate-region").fadeIn()
        }
		
        function showGoodPractices() {
            $j("#generic-measures").hide();
            $j("#locate-region").hide()
            $j("#good-practices").fadeIn()
        }
		
        function filterMeasures() {
            var risk = $j("#risk-selector-step4").val();
            var sector = $j("#sector-select-step4").val();

            $j("div.dr_ag").hide();
            $j("div.dr_wm").hide();

            if ((risk === 'none' || (sector === 'none'))) {
                $j("#measures-step4").hide();
                return;
            }

            var filter = '';
            if (risk === "DROUGHT") {
                filter = "dr_";
            } 
			else if (risk === 'all') {
                 filter = "dr_";
            }

            if (sector === 'AGRICULTURE') {
                filter = filter + "ag";
                $j("div." + filter).show();
            } 
			else if (sector === 'WATERMANAGEMENT') {
                filter = filter + "wm";
                $j("div." + filter).show();
            }
			else if (sector === 'all') {
                $j("div.dr_ag").show();
                $j("div.dr_wm").show();
            }
            $j("#measures-step4").show();
        }
		
        function filterGoodPractices() {
            var risk = $j("#risk-selector-step4-gp").val();
            var sector = $j("#sector-select-step4-gp").val();

            $j("div.dr_ag").hide();
            $j("div.dr_wm").hide();

            if ((risk === 'none' || (sector === 'none'))) {
                $j("#good-practices-step4").hide();
                return;
            }

            var filter = '';
            if (risk === "DROUGHT") {
                filter = "dr_";
            } 
			else if (risk === 'all') {
                 filter = "dr_";
            }

            if (sector === 'AGRICULTURE') {
                filter = filter + "ag";
                $j("div." + filter).show();
            } 
			else if (sector === 'WATERMANAGEMENT') {
                filter = filter + "wm";
                $j("div." + filter).show();
            } 
			else if (sector === 'all') {
                $j("div.dr_ag").show();
                $j("div.dr_wm").show();
            }

            $j("#good-practices-step4").show();
        }		

    </script>

	<div id="step-right-4" class="step-right">
        <h1 id="aplication-options-heading">
			<img src="<%=renderRequest.getContextPath()%>/images/bullit4.png" class="valigned"/>
			How can identify my adaptation options?
		</h1>

		<div id="generic-measures" style="display: none; margin-left: 20px;">
			<h2>
				What are possible measures?
			</h2>	
			<form>
				<div id="selectors-step4" style="margin-left: 20px; float:left;">
					<!-- added width because IE8 renders a 100% width otherwise -->				
					<div id="risks-selector-step4" class="adaptationtools-selector" style="float:left;width:208px;">
						<span style="margin-right:10px;float:left;" >
							Risk
						</span>
						<!-- TODO load dynamically from enumeration nl.wur.alterra.cgi.ace.model.impl.AceItemClimateImpact -->
						<select id="risk-selector-step4" style="float:left;" onchange="filterMeasures();">
							<option value="none" selected="selected">Choose a risk:</option>
							<option value="all" disabled="disabled">All risks</option>
							<!-- TODO this one is not present in enum AceItemClimateImpact -->
							<option value="SEALEVEL" disabled="disabled">Sea Level Rise</option>
							<option value="EXTREMETEMP" disabled="disabled">Extreme Temperatures</option>
							<option value="WATERSCARCE" disabled="disabled">Water Scarcity</option>
							<option value="FLOODING" disabled="disabled">Flooding</option>
							<option value="DROUGHT">Droughts</option>
							<option value="STORM" disabled="disabled">Storms</option>
							<option value="ICEANDSNOW" disabled="disabled">Ice and Snow</option>
						</select>
						<div class="top-bubble" style="float:right;margin:0px 10px;">
							<img src="<%=renderRequest.getContextPath()%>/images/info.png" class="valigned"/>
						</div>
					</div>
					<!-- added width because IE8 renders a 100% width otherwise -->
					<div id="sector-selector-step4" class="adaptationtools-selector" style="float:left;width:226px;">
						<span style="margin-right:10px;float:left;">
							Sector
						</span>
						<!-- TODO load dynamically from enumeration nl.wur.alterra.cgi.ace.model.impl.AceItemSector -->
						<select id="sector-select-step4" style="float:left;" onchange="filterMeasures();" >
							<option value="none" selected="selected">Choose a sector:</option>
							<option value="all" disabled="disabled">All sectors</option>
							<option value="AGRICULTURE">Agriculture and Forest</option>
							<option value="BIODIVERSITY" disabled="disabled">Biodiversity</option>
							<option value="COASTAL" disabled="disabled">Coastal Areas</option>
							<option value="DISASTERRISKREDUCTION" disabled="disabled">Disaster Risk Reduction</option>
							<option value="FINANCIAL" disabled="disabled">Financial</option>
							<option value="HEALTH" disabled="disabled">Health</option>
							<option value="INFRASTRUCTURE" disabled="disabled">Infrastructure</option>
							<option value="MARINE" disabled="disabled">Marine and Fisheries</option>
							<option value="WATERMANAGEMENT">Water Management</option>
						</select>
						<div class="top-bubble" style="float:right;margin:0px 10px;">
							<img src="<%=renderRequest.getContextPath()%>/images/info.png" class="valigned"/>
						</div>
					</div>
				</div>
		
				<hr style="clear:both;display:block;visibility:hidden;"/>

				<div id ="measures-step4" style="float: left;margin-left: 20px; display:none;">
					<c:set var="groupedResults" scope="page" value="${MEASURE_searchResults}"/>
					<c:set var="groupedJSONResults" scope="page" value="${MEASURE_JSONsearchResults}"/>
					<c:set var="aceitemtype" scope="page" value="MEASURE"/>
					<c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-MEASURE" /></c:set>
					<%@ include file="searchresultsbytype.jspf" %>
				</div>
			</form>
		<!-- end generic measures -->
		</div>

		<div id="good-practices" style="display: none; margin-left: 20px;">
			<h2>
				What are possible good practices?
			</h2>		
			<form>
				<div id="selectors-step4-gp" style="margin-left: 20px; float:left;">
					<!-- added width because IE8 renders a 100% width otherwise -->
					<div id="risks-selector-step4-gp" class="adaptationtools-selector" style="float:left;width:208px;">
						<span style="margin-right:10px;float:left;" >
							Risk
						</span>
						<!-- TODO load dynamically from enumeration nl.wur.alterra.cgi.ace.model.impl.AceItemClimateImpact -->
						<select id="risk-selector-step4-gp" style="float:left;" onchange="filterGoodPractices();">
							<option value="none" selected="selected">Choose a risk:</option>
							<option value="all" disabled="disabled">All risks</option>
							<!-- TODO this one is not present in enum AceItemClimateImpact -->
							<option value="SEALEVEL" disabled="disabled">Sea Level Rise</option>
							<option value="EXTREMETEMP" disabled="disabled">Extreme Temperatures</option>
							<option value="WATERSCARCE" disabled="disabled">Water Scarcity</option>
							<option value="FLOODING" disabled="disabled">Flooding</option>
							<option value="DROUGHT">Droughts</option>
							<option value="STORM" disabled="disabled">Storms</option>
							<option value="ICEANDSNOW" disabled="disabled">Ice and Snow</option>
						</select>
						<div class="top-bubble" style="float:right;margin:0px 10px;">
							<img src="<%=renderRequest.getContextPath()%>/images/info.png" class="valigned"/>
						</div>
					</div>
					<!-- added width because IE8 renders a 100% width otherwise -->
					<div id="sector-selector-step4-gp" class="adaptationtools-selector" style="float:left;width:226px;">
						<span style="margin-right:10px;float:left;">
							Sector
						</span>
						<!-- TODO load dynamically from enumeration nl.wur.alterra.cgi.ace.model.impl.AceItemSector -->
						<select id="sector-select-step4-gp" style="float:left;" onchange="filterGoodPractices();" >
							<option value="none" selected="selected">Choose a sector:</option>
							<option value="all" disabled="disabled">All sectors</option>
							<option value="AGRICULTURE">Agriculture and Forest</option>
							<option value="BIODIVERSITY" disabled="disabled">Biodiversity</option>
							<option value="COASTAL" disabled="disabled">Coastal Areas</option>
							<option value="DISASTERRISKREDUCTION" disabled="disabled">Disaster Risk Reduction</option>
							<option value="FINANCIAL" disabled="disabled">Financial</option>
							<option value="HEALTH" disabled="disabled">Health</option>
							<option value="INFRASTRUCTURE" disabled="disabled">Infrastructure</option>
							<option value="MARINE" disabled="disabled">Marine and Fisheries</option>
							<option value="WATERMANAGEMENT">Water Management</option>
						</select>
						<div class="top-bubble" style="float:right;margin:0px 10px;">
							<img src="<%=renderRequest.getContextPath()%>/images/info.png" class="valigned"/>
						</div>
					</div>
				</div>
		
				<hr style="clear:both;display:block;visibility:hidden;"/>

				<div id ="good-practices-step4" style="float: left;margin-left: 20px; display:none;">
					<c:set var="groupedResults" scope="page" value="${ACTION_searchResults}"/>
					<c:set var="groupedJSONResults" scope="page" value="${ACTION_JSONsearchResults}"/>
					<c:set var="aceitemtype" scope="page" value="ACTION"/>
					<c:set var="groupTitle" scope="page"><liferay-ui:message key="acesearch-datainfotype-lbl-ACTION" /></c:set>
					<%@ include file="searchresultsbytype.jspf" %>
				</div>
			</form>
		<!-- end good practices -->
		</div>
		
        <div id="locate-region" style="margin-left: 20px;display:none;">
			<h2>
				What good practices are available in regions similar to mine?
			</h2>		
			<img src="<%=renderRequest.getContextPath()%>/images/step-4.jpg"/>
			
			<!-- gazetteer map removed by not displaying anything -->
            
			<div style="float:left; margin-bottom: 10px; display:none;">
                <form>
                    Region of interest:
                    <input type="text" autocomplete="off" id="locate_region_input" name="locate_region_input"
                           onkeyup="gazeeteer.search2($j('#locate_region_input').val());" style="width:200px" />&nbsp;
                    <button type="submit" >Search for similar regions</button>

                </form>
                <div id="locate_region_results"></div>
            </div>
            <div id="map-container-step4" style="display:none;"></div>

            <hr style="clear:both;display:block;visibility:hidden; display:none;"/>

            <div id="specify-region-similarity-criteria" style="margin-top:10px; display:none;">
                Specify region similarity criteria &raquo;
            </div>
			
			<!-- end of gazetteer map removed -->
			
        </div>
		<!-- end locate-region -->

        <hr style="clear:both;display:block;visibility:hidden;"/>
	</div>

    <!--

			step 5

	-->
	<div id="step-right-5" class="step-right">
        <h1 id="assess-adaptation-options-heading">
			<img src="<%=renderRequest.getContextPath()%>/images/bullit5.png" class="valigned"/>
			How can I assess my adaptation options?
		</h1>
		<h2>
			5.2 What are feasible adaptation options?			
		</h2>
		<p>
			Once you made a portfolio of potential adaptation options, you need to assess them ad determine which of them suit your specific context. You have to consider their effectiveness
			in reducing vulnerability (or enhancing resilience) and their wider impact on sustainabilty. Assessment of feasible options helps avoiding decisions that lead to mal-adaptation.
			There is a set of criteria that you should onsider when assessing adaptation options (read more). Tools and guidance documents provided in this section will help you to select feasible options.
		</p>

        <hr style="clear:both;display:block;visibility:hidden;"/>
	</div>

    <hr style="clear:both;display:block;visibility:hidden;"/>


	<!-- acemap_column -->
    </div>
<!-- outer div -->	
</div>	
