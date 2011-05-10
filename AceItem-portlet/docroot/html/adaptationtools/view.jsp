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

		$j('.step2substep').hide();
		$j(hashedHeadingId).fadeIn();

		var substepOptionIds = ['#analyze-maps-options', '#analyze-nas-options'];
		var substepContentIds = ['#indicators-map', '#general-content'];
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
				<div id="what-is-it" style="margin:20px 10px;">
					<div id="what-is-it-heading" style="font-size:18px;">
						What is the Adaptation Support Tool?
					</div>
					<div style="font-size:12px;margin:20px 10px;">
						The aim of the Adaptation Support Tool is to assist users involved in development of climate change adaptation policies by providing guidance, links to relevant sources and the provision of dedicated tools.
					</div>
				</div>
				<div id="how-can-i-use-it" style="margin:20px 10px;">
					<div id="how-can-i-use-it-heading" style="font-size:18px;">
						How can I use it?
					</div>
					<div style="font-size:12px;margin:20px 10px;">
						The tool is based on the policy cycle. The cycle highlights that climate change adaptation is an iterative process. The steps of this cycle should be re-visited periodically in order to ensure that adaptation decisions are based on up-to-date data, knowledge and policies. This will also allow monitoring and in time assessment of successes and failures and encourage an adaptive learning process.
					</div>
				</div>
				<div id="where-can-i-find-more-information" style="margin:20px 10px;">
					<div id="where-can-i-find-more-information-heading" style="font-size:18px;">
						Where can I find more information?
					</div>
					<div style="font-size:12px;margin:20px 10px;">
						More information on designing and mainstreaming adaptation policies can be found in the following documents:
						<div style="margin:20px 0px;">
							<img src="<%=renderRequest.getContextPath()%>/images/arrow_green.png"/>
							<span style="margin-left:5px;">
								<a href="http://ec.europa.eu/clima/documentation/adaptation/docs/RAS%20Final%20Report.pdf" target="_blank">
									Design of guidelines for the elaboration of Regional Climate Change Adaptation Strategies
								</a>
							</span>
						</div>
						<div style="margin:20px 0px;">
							<img src="<%=renderRequest.getContextPath()%>/images/arrow_green.png"/>
							<span style="margin-left:5px;">
								<a href="http://eur-lex.europa.eu/LexUriServ/LexUriServ.do?uri=COM:2009:0147:FIN:EN:PDF" target="_blank">
									WHITE PAPER: Adapting to climate change: Towards a European framework for action
								</a>
							</span>
						</div>
					</div>
				</div>
				<hr style="clear:both;display:block;visibility:hidden;"/>
			</div>
			<!-- navigation in images -->
			<map name="navigation-map" id="navigation-map">
				<!-- the href="#" attributes are to make IE8 change the mouse cursor on hover. TODO add them by javascript only in case of IE, and remove the nohref attribute in that case. -->
				<area shape="poly" coords="151,17,148,56,242,61,243,16" nohref="nohref" href="#" onclick="displayStep(1);" class="clickable"/>
				<area shape="poly" coords="181,60,332,58,346,99,191,96,191,96,192,102" nohref="nohref" href="#" onclick="displayStep(2);" class="clickable" />
				<area shape="poly" coords="190,107,333,109,341,145,192,144" nohref="nohref" href="#" onclick="displayStep(3);" class="clickable" />
				<area shape="poly" coords="175,152,332,153,336,186,180,186,170,172" nohref="nohref" href="#" onclick="displayStep(4);showGeneral();" class="clickable" />
				<area shape="poly" coords="123,177,165,177,181,188,233,192,278,199,280,224,130,227,122,205" nohref="nohref" href="#" onclick="displayStep(5);" class="clickable" />
			</map>

		<!-- end step 1 -->
		</div>

		<!--

				step 2

		-->
		<div id="step-left-2" class="step-left">
			<div id="what-should-i-do" style="margin:5px;">
				<div id="what-should-i-do-heading" style="font-size:18px;line-height:20px;" onclick="step2substep(this.id);">
					What should I do?
				</div>
				<div id="what-should-i-do-options" style="">
					<ul class="menu-left">
						<li class="list-option">
							1. <a href="#" onclick="step2substep('2-1'); return false">
								General
							</a>
						</li>
						<li class="list-option">
							2. <a href="#" onclick="step2substep('2-2'); return false">
								How do I analyse impacts of past weather and recent climate trends?
							</a>
						</li>
						<li class="list-option">
							3. <a href="#" onclick="step2substep('2-3'); return false">
								How do I identify the impacts of climate change?
							</a>
						</li>
						<li class="list-option" id="analyze-in-nas">
							4. <a href="#" onclick="step2substep('2-4'); return false">
								Are there vulnerability assessments in my region?
							</a>
						</li>
						<li class="list-option" id="analyze-maps-heading">
							5. <a href="#" onclick="step2substep('analyze-maps-heading');showVulnerabilitiesAndRisks(); initMapViewerIndicators();">
								How do I analyse impacts from European scale vulnerability assessments?
							</a>
								<div id="analyze-maps-options" style="display:none;">
									<ul class="menu-left">
										<li class="list-option">
											5.1. <a href="#" onclick="showVulnerabilitiesAndRisks(); return false">What are the key vulnerabilities and risks?</a>
										</li>
										<li class="list-option">
											5.2. <a href="#" onclick="showUnderlyingCauses(); return false">What are the underlying causes?</a>
										</li>
										<li class="list-option">
											5.3. <a href="#" onclick="showUnderlyingNaturalCauses(); return false">How does the climate change?</a>
										</li>
										<li class="list-option">
											5.4. <a href="#" onclick="showUnderlyingHumanCauses(); return false">How does the socio-ecological system change?</a>
										</li>
										<li class="list-option">
											5.5. Uncertainties
										</li>
									</ul>
								</div>
						</li>

						<li class="list-option">
							6. <a href="#" onclick="step2substep('2-6'); return false">
								What are the risks?
							</a>
						</li>
						<li class="list-option">
							7. <a href="#" onclick="step2substep('2-7'); return false">
								Are there also opportunities?
							</a>
						</li>
						<li class="list-option">
							8. <a href="#" onclick="step2substep('2-8'); return false">
								What are the uncertainties?
							</a>
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
				<div id="what-should-i-do-4-heading" style="font-size:18px;line-height:20px;">
					What should I do?
				</div>

            </div>
			<div id="search-option-database" style="margin:5px;">
				<div id="search-option-database-heading" style="font-size:18px;line-height:20px;">
					Search the option database
				</div>
				<div id="search-option-database-options">
					<ul class="menu-left">
						<li class="list-option">
							1. <a href="#" onclick="showGeneral(); return false;">General</a>
						</li>
						<li class="list-option">
							2. <a href="#" onclick="showGenericMeasures(); return false;">What are possible measures?</a>
						</li>
						<li class="list-option">
							3. <a href="#" onclick="showGoodPractices(); return false;">What are possible good practices?</a>
						</li>
						<li class="list-option">
							4. <a href="#" onclick="showLocateRegion(); return false;">What good practices are available in regions similar to mine?</a>
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
                <div id="what-should-i-do-5-heading" style="font-size:18px;line-height:20px;">
                    How can I assess my adaptation options?
                </div>
                <div id="what-should-i-do-5-options" style="">
                    <ul class="menu-left">
                        <li class="list-option">
                            1. <a href="#" onclick="step5substep('5-1'); return false;">General</a>
                        </li>
                        <li class="list-option">
                            2. <a href="#" onclick="step5substep('5-2-1'); return false;">How much does adaptation cost?</a>
							<div id="what-should-i-do-5-options" style="">
								<ul class="menu-left">
                                    <li class="list-option">
                                        <a href="#" onclick="step5substep('5-2-1'); return false;">2.1 How can I determine my adaptation costs?</a>
                                    </li>
                                    <li class="list-option">
                                        <a href="#" onclick="step5substep('5-2-2'); return false;">2.2 Search the cost-benefit database</a>
                                    </li>
                                </ul>
                            </div>
                        </li>
                        <li class="list-option">
                            3. <a href="#" onclick="step5substep('5-3'); return false;">How do I decide which measures to include in my portfolio?</a>
                        </li>
                        <li class="list-option">
                            4. <a href="#" onclick="step5substep('5-4'); return false;">What is my Adaptive Capacity?</a>
                        </li>
                        <li class="list-option">
                            5. <a href="#" onclick="step5substep('5-5'); return false;">How to plan for adaptation?</a>
                        </li>
                    </ul>
                </div>
            </div>
        <!-- end step 5 -->
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
		<!-- the href="#" attributes are to make IE8 change the mouse cursor on hover. TODO add them by javascript only in case of IE, and remove the nohref attribute in that case. -->
		<map name="large-navigation" id="large-navigation">
		  <area shape="poly" coords="415,131,480,106,699,129,699,208,432,186,412,163" nohref="nohref" href="#" onclick="displayStep(2);" class="clickable" style="cursor:hand !important;z-index:999;"/>
		  <area shape="poly" coords="698,213,441,195,416,224,432,265,481,282,698,280" nohref="nohref" href="#" onclick="displayStep(3);" class="clickable"/>
		  <area shape="poly" coords="682,301,471,296,427,282,397,295,399,333,428,357,483,359,653,359,681,348" nohref="nohref" href="#" onclick="displayStep(4);showGeneral();" class="clickable"/>
		  <area shape="poly" coords="414,361,376,332,314,332,292,365,292,402,344,425,439,429,669,432,668,383,632,371" nohref="nohref" href="#" onclick="displayStep(5);" class="clickable"/>
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
			$j('#sector-selector-bubble').CreateBubblePopup({
					position : 'top',
                    selectable: true,
					align	 : 'center',
					innerHtml: '<div style="position:relative;z-index:9999;background:#fff;zoom:1;filter:alpha(opacity = 100);"> \
									<div style="background:green;color:#fff;height:15px;border:1px solid lime;padding:5px;">information</div> \
									<div style="height:35px;padding:5px;"> \
										EU policy sectors \
									</div> \
									<div style="height:15px;text-align:right;padding:5px;">read more &raquo;</div> \
								</div>',
					innerHtmlStyle: {
										color:'#000',
										'text-align':'left'
									},
					themeName: 	'green',
					themePath: 	'<%=renderRequest.getContextPath()%>/js/bubblepopup/jquerybubblepopup-theme'
			});
			// the zoom and opacity in the innerHtml's div is because IE renders the popups transparent otherwise
			$j('#risks-selector-bubble').CreateBubblePopup({
					position : 'top',
                    selectable: true,
					align	 : 'center',
					innerHtml: '<div style="position:relative;z-index:9999;background:#fff;zoom:1;filter:alpha(opacity = 100);"> \
									<div style="background:green;color:#fff;height:15px;border:1px solid lime;padding:5px;">information</div> \
									<div style="height:35px;padding:5px;"> \
										Climate hazards \
									</div> \
									<div style="height:15px;text-align:right;padding:5px;">read more &raquo;</div> \
								</div>',
					innerHtmlStyle: {
										color:'#000',
										'text-align':'left'
									},
					themeName: 	'green',
					themePath: 	'<%=renderRequest.getContextPath()%>/js/bubblepopup/jquerybubblepopup-theme'
			});
			// the zoom and opacity in the innerHtml's div is because IE renders the popups transparent otherwise
			$j('#scenario-selector-bubble').CreateBubblePopup({
					position : 'top',
                    selectable: true,
					align	 : 'center',
					innerHtml: '<div style="position:relative;z-index:9999;background:#fff;zoom:1;filter:alpha(opacity = 100);"> \
									<div style="background:green;color:#fff;height:15px;border:1px solid lime;padding:5px;">information</div> \
									<div id="scenario-selector-shorttext" style="height:35px;padding:5px;"> \
										SCENES project, Economy First \
									</div> \
									<div id="scenario-read-more" style="height:15px;text-align:right;padding:5px;cursor:pointer;" onclick="createBubble();">read more &raquo;</div> \
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

			function createBubble() {
				// the zoom and opacity in the innerHtml's div is because IE renders the popups transparent otherwise
				$j('#scenario-read-more').CreateBubblePopup({
						position : 'top',
						selectable: true,
						align	 : 'center',
						innerHtml: '<div style="position:relative;z-index:9999;background:#fff;zoom:1;filter:alpha(opacity = 100);"> \
										<div style="background:green;color:#fff;height:15px;border:1px solid lime;padding:5px;">information</div> \
										<div style="height:350px;padding:5px;"> \
											SCENES scenario "Economy First" (EcF) \
											<br/> \
											<br/>The economy develops towards globalisation and liberalisation so innovations spread but income \
											inequality, immigration and urban sprawl cause social tensions. All energy production alternatives \
											are considered, international consortia are financed to find high-tech alternatives to fossil fuels. \
											Global demand for food and biofuels drives the intensification of agriculture with increasing need \
											for irrigation and new cultivation area. As CAP is weakened farms are abandoned where crop production \
											is uneconomic. Slow adoption of water-efficient technologies due to peoples limited income, low \
											water-saving consciousness, more single-person households, increase in tourism and lack in training \
											using new irrigation technologies lead to higher water use. Only the higher water prices dampen this \
											trend. It is economic to treat and re-use irrigation return flows thus this practice also reducing \
											diffuse pollution is adopted. Water ecosystems providing ecological goods and services for economies \
											and society (e.g. tourism) are preserved and improved. Thus WFD changes its conceptual focus from the \
											good ecological status to preserving socio-economically worth ecological services. Pollution load \
											increases due to curtailed infrastructure, poor treatment and intensified agriculture. Poisoning \
											incidents catch the interest of media and public. Scientific findings and public protests are being \
											finally heard. Even if governments and European institutions are weak in EcF they are the last straw \
											after recession and social upheaval in 2040s to start working with NGOs, industries and other \
											representatives of civil society to restore economic prosperity and make ground for social coherence. \
										</div> \
									</div>',
						innerHtmlStyle: {
											color:'#000', 
											'text-align':'left'
										},
						themeName: 	'green',
						themePath: 	'<%=renderRequest.getContextPath()%>/js/bubblepopup/jquerybubblepopup-theme'
					});	
			}		

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

						});

					if(t === 'Water stress') {
					$j('<div id="waterstress-bubble" class="top-bubble" style="float:left;margin:0px 10px;"><img src="<%=renderRequest.getContextPath()%>/images/info.png" class="valigned"/></div>').appendTo(indicatortype);
					// the zoom and opacity in the innerHtml's div is because IE renders the popups transparent otherwise
					$j('#waterstress-bubble').CreateBubblePopup({
							position : 'right',
							selectable: true,
							align	 : 'center',
							innerHtml: '<div style="position:relative;z-index:9999;background:#fff;zoom:1;filter:alpha(opacity = 100);"> \
											<div style="background:green;color:#fff;height:15px;border:1px solid lime;padding:5px;">information</div> \
											<div style="height:300px;padding:5px;"> \
												<br/>Indicator: Water Stress \
												<br/>\
												<br/>Description: Water withdrawals to water availability ratio in summer (June, July, August) \
												<br/>\
												<br/>Source: ClimWatAdapt \
												<br/>\
												<br/>Spatial Resolution: 5x5 0, aggregated on NUTs-2 level \
												<br/>\
												<br/>Scenario: SCENES, Economy First \
												<br/>\
												<br/>Baseline: 2005 \
												<br/>\
												<br/>Year: 2050 \
												<br/>\
												<br/>Model: WaterGAP \
											</div> \
											<div style="height:15px;text-align:right;padding:5px;">read more &raquo;</div> \
										</div>',
							innerHtmlStyle: {
												color:'#000', 
												'text-align':'left'
											},
							themeName: 	'green',
							themePath: 	'<%=renderRequest.getContextPath()%>/js/bubblepopup/jquerybubblepopup-theme'
						});
					}					


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



	<div id="step-right-2" class="step-right step-2-right">
		<h1 id="adaptationtools-heading">
			Am I vulnerable to climate change and what are my risks
		</h1>

         <h2 id="header-vulnerability" class="heading step2heading" style="display: none">
             2.5.1 What are the key vulnerabilities and risks?
         </h2>

        <h2 id="header-underlying-causes" class="heading step2heading" style="display: none">
             2.5.2 What are the underlying causes?
        </h2>

        <h2 id="header-climate-change" class="heading step2heading" style="display: none">
             2.5.3 How does the climate change?
        </h2>

        <h2 id="header-socio-ecological" class="heading step2heading" style="display: none">
             2.5.4 How does the socio-ecological system change?
        </h2>

		<div id="general-content" class="what-should-i-do-content">
			<div id="general-content-text" style="display:block;float:left;margin-left:30px;">
				Next step after preparing the ground is vulnerability assessment. It is the analysis of the expected impacts, risks and the adaptive capacity of an area in the context of climate change.
				The objective of this step is to gain a better understanding of how and in what way climate change will affect the services, social groups, economic sectors and assets and to identify
				the priority areas for action. Vulnerability assessment is more than measuring potential harm using information about climate impacts. It includes an assessment of the area's ability
				to adapt.
			</div>
			<img src="<%=renderRequest.getContextPath()%>/images/step-2.jpg" style="float:right;margin-right:30px;"/>
		</div>

		<div id="2-1" class="what-should-i-do-content step2substep" style="display:none;">
			<h2 style="margin-left:30px;">
				2.1 General
			</h2>
			<div id="general-content-text" style="float:left;dispaly:block;margin-left:30px;">
				<p>
					Even if emissions of greenhouse gases stop today, these changes would continue for many decades and in the case of sea level for centuries. This is due to the historical build-up of the gases in the
					atmosphere and time lags in the response of climatic and oceanic systems to changes in the atmospheric concentration of the gases. Therefore, in addition to emission reduction (mitigation) measures, it
					is essential that natural as well as human systems also develop adequate adaptive responses to avoid the risks posed by, and to take advantage of the opportunities arising from global climate change.
				</p>
				<p>
					Observed temperature rises and changes in precipitation patterns already affect various areas in Europe, making them vulnerable to different weather events. Within the context of climate change, the
					IPCC defines vulnerability to climate change as the degree to which a system is susceptible to, or unable to cope with, adverse effects of climate change, including climate variability and extremes.
					Vulnerability is a function of the character, magnitude, and rate of climate variation to which a system is exposed, its sensitivity, and its adaptive capacity.
				</p>
				<p>
					In order to perform a sound vulnerability assessment, all available relevant information has to be collected and assessed. This includes analysis of past and current weather trends, future climate change
					projections and their uncertainty.
				</p>
			</div>
			<img src="<%=renderRequest.getContextPath()%>/images/step-2.jpg" style="float:right;margin-right:30px;"/>
			
		</div>

		<div id="2-2" class="what-should-i-do-content step2substep" style="display:none;">
			<h2 style="margin-left:30px;">
				2.2 How do I analyse impacts of past weather and recent climate trends?
			</h2>
			<div id="general-content-text" style="float:left;dispaly:block;margin-left:30px;">
			<p>
				The assessment of existing vulnerability to climate variability and extremes is a necessary starting point for any adaptation. Assessment of past weather events, for example heavy rain or extreme temperatures,
				and analysis of responses to them can help in gaining insights on which responses have been successful or ineffective. Lessons learned from this exercise can be used as a basis for designing climate change
				adaptation plans.
			</p>
			<p>
				<div style="font-weight:bold; font-size: 12px; padding-top:20px;">				
					Links
				</div>
				<ul>
					<li>
						<a href="/web/guest/observations-and-scenarios">
							Observations and Scenarios
						</a>
						section on Clearinghouse Mechanism on Adaptation
					</li>
					<li>
						<a href="http://www.emdat.be/" target="_blank">
							Emergency Events Database
						</a>
						EM-DAT
					</li>
					<li>
						<a href="http://ensembles-eu.metoffice.com/data.html" target="_blank">
							ENSEMBLES
						</a>
						. Daily, European gridded temperature and precipitation, at 25km resolution, 1950 to 2008
					</li>
					<li>
						<a href="http://www.ecmwf.int/research/era/do/get/index" target="_blank">
							ERA 40 / ERA-40-interim
						</a>
						. Six-hourly, global gridded variables (many) at resolutions of approximately 1° and 0.5°, 1958-2002 for ERA40, 1989 to present for ERA-interim
					</li>
					<li>
						<a href="http://badc.nerc.ac.uk/data/cru/" target="_blank">
							CRU
						</a>
						. Monthly, global gridded variables (ten) at 0.5° resolution, 1901 to present
					</li>
					<li>
						<a href="http://eca.knmi.nl/" target="_blank">
							European Climate Assessment & Dataset
						</a>
						 (ECA&D)
					</li>
				</ul>
				<div style="font-weight:bold; font-size: 12px; padding-top:20px;">				
					Links to tools
				</div>
				<ul>
					<li>
						JRC, AGRI4CAST
						<a href="/mars-viewer">
							MARS web data viewer
						</a>
						, providing access to observations of weather and agriculture indicators
					</li>
				</ul>
			</p>
			</div>
			<img src="<%=renderRequest.getContextPath()%>/images/step-2.jpg" style="float:right;margin-right:30px;"/>
			
		</div>

		<div id="2-3" class="what-should-i-do-content step2substep" style="display:none;">
			<h2 style="margin-left:30px;">
				2.3 How do I identify the impacts of climate change?
			</h2>
			<div id="general-content-text" style="float:left;dispaly:block;margin-left:30px;">
			<p>
				The extent to which climate change poses threats or opportunities will depend on how the climate, society and economy of the region of interest changes in coming years. These changes are studied with the help
				of different climate and socio-economic scenarios. Scenarios provide plausible descriptions of different possible future states of the world based on the choices society makes. (Read more)
			</p>
			</div>
			<img src="<%=renderRequest.getContextPath()%>/images/step-2.jpg" style="float:right;margin-right:30px;"/>
			
		</div>

		<div id="2-4" class="what-should-i-do-content step2substep" style="display:none;">
			<h2 style="margin-left:30px;">
				2.4. Are there vulnerability assessments in my region?
			</h2>
			<div id="general-content-text" style="float:left;dispaly:block;margin-left:30px;">
			<p>
				In many cases, the results of national or regional vulnerability assessments can be expected to better fit the goals of regional adaptation plans. Therefore a logical first step in assessing vulnerability to
				climate change is to look for existing (sub)national, regional or local assessments. Currently this section provides access to the section on National Adaptation Plans and Strategies, that includes among others
				references to national and regional vulnerability studies. (In a later stage this section will more specifically link to available vulnerability assessments)
				<br/><br/>
				<a href="/national-adaptation-strategies" target="_blank">
					Open National Adaptation Strategies
				</a>
			</p>
			</div>
			<img src="<%=renderRequest.getContextPath()%>/images/step-2.jpg" style="float:right;margin-right:30px;"/>
			
		</div>

		<div id="2-5" class="what-should-i-do-content step2substep" style="display:none;">
			<h2 class="heading step2heading">
				2.5 How do I analyse impacts from European scale vulnerability assessments?
			</h2>
			<div id="general-content-text" style="float:left;dispaly:block;margin-left:30px;">
				<p>
					There are a number of European-wide and national projects that have created different socio-economic and climate scenarios across a variety of sectors and made projections for different socio-economic and
					climate variables. These variables, when combined, produce indicators for climate impacts. Adaptation cannot be planned only on the basis of climate indicators, it needs impact indicators showing how climate
					interacts with socio-economic developments.
				</p>
				<p>
					The Adaptation Support Tool allows you to assess a variety of impact indicators, calculated within different projects. They can help you to assess whether you are vulnerable to climate change and whether
					there are opportunities arising from it. In order to identify whether the vulnerability arises due to changes in climate, in socio-economic development or both, these indicators are disaggregated to their
					components.
				</p>
				<p>
					For example the indicator for water stress, used as impact indicator for water scarcity and droughts, disaggregates to two indicators for water availability and water use (withdrawals). Their analysis will
					give an indication whether water scarcity is caused by climate change (manifested as decrease in water availability), socio-economic developments (increase in water use) or both.
				</p>
				<p>
					While the components of the aggregated impact indicators let you identify where the vulnerabilities come from, they do not allow to identify the root cause of the problem. Therefore you should go further back
					in the casual chain and look for the causes. In the case of a water stress indicator, causes for decrease in water availability can be decrease in precipitation, increase in evapo-transpiration, decrease in
					river flow, change in the timing of snow melting and/or precipitation. Water availability decreases also due to deterioration of water quality. Water use can increase due to introduction of different crops
					or cooling technologies, land use changes such as urbanisation, land erosion that decreases significantly water holding capacity of the soils. For some of these root causes European-wide data are available,
					but for most of them they still do not exist. When planning for adaptation it is of great importance to find local data on these sub-indicators and to analyse them within your vulnerability assessment in
					order to address the right causes and to design effective adaptation measure mix.
				</p>
				<p>
					<div style="font-style:italic">
						Links to European scale vulnerability assessments:
					</div>
					<ul>
						<li>
							<a href="http://www.climwatadapt.eu" target="_blank">
								ClimWatAdapt
							</a>
						</li>
						<li>
							<a href=" http://peseta.jrc.ec.europa.eu/" target="_blank">
								PESETA study
							</a>
						</li>
					</ul>
				</p>
				<p>
					<div style="font-style:italic">
						Links to tools:
					</div>
					<ul>
						<li>
							<a href="http://www.1stcellmedia.de/customer/uni/cms/index.php?option=com_frontpage&Itemid=1" target="_blank">
								SCENES WebService
							</a>
						</li>
						<li>
							<a href="http://adam-digital-compendium.pik-potsdam.de/macro-economic-analysis/direct-impacts-1/impacts-by-region/" target="_blank">
								ADAM Digital Compendium
							</a>
						</li>
					</ul>
				</p>
				<p>
					<div style="font-style:italic">
						Links to data generators, databases and meta-data platforms
					</div>
					<ul>
						<li>
							<a href="http://cera-www.dkrz.de/" target="_blank">
								The CERA database
							</a>
						</li>
						<li>
							<a href="http://www.espon-climate.eu/" target="_blank">
								ESPON CLIMATE
							</a>
						</li>
						<li>
							<a href="http://www.circeproject.eu/" target="_blank">
								CIRCE (Climate Change and Impact Research: the Mediterranean Environment
							</a>
						</li>
						<li>
							<a href="http://www-pcmdi.llnl.gov/" target="_blank">
								PCMDI (Project for Climate Model Diagnosis and Inter-comparison)
							</a>
						</li>
					</ul>
				</p>
			</div>
			<img src="<%=renderRequest.getContextPath()%>/images/step-2.jpg" style="float:right;margin-right:30px;"/>
			
		</div>

		<div id="2-6" class="what-should-i-do-content step2substep" style="display:none;">
			<h2 style="margin-left:30px;">
				2.6. What are the risks?
			</h2>
			<div id="general-content-text" style="float:left;dispaly:block;margin-left:30px;">
			<p>
				Current risk management approaches require knowledge of risk, calculated as
				<br/><br/>
				Risk = Expected damages x Probability
				<br/><br/>
				In the case of climate change projections considerable complexities arise in calculation of the risk function, associated with assigning probability to certain climate change scenarios and with making
				assumptions about impacts of future socioeconomic development.
			</p>
			</div>
			<img src="<%=renderRequest.getContextPath()%>/images/step-2.jpg" style="float:right;margin-right:30px;"/>
			
		</div>

		<div id="2-7" class="what-should-i-do-content step2substep" style="display:none;">
			<h2 style="margin-left:30px;">
				2.7. Are there also opportunities?
			</h2>
			<div id="general-content-text" style="float:left;dispaly:block;margin-left:30px;">
			<p>
				Content on adaptation opportunities to be included in a later stage
			</p>
			</div>
			<img src="<%=renderRequest.getContextPath()%>/images/step-2.jpg" style="float:right;margin-right:30px;"/>
		</div>

		<div id="2-8" class="what-should-i-do-content step2substep" style="display:none;">
			<h2 style="margin-left:30px;">
				8. What are the uncertainties?
			</h2>
			<div id="general-content-text" style="float:left;dispaly:block;margin-left:30px;">
			<p>
				This section will include the guidance to be developed on handling uncertainties in the frame of the Clearinghouse Mechanism for Adaptation
			</p>
			</div>
			<img src="<%=renderRequest.getContextPath()%>/images/step-2.jpg" style="float:right;margin-right:30px;"/>
			
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
					<div id="sector-selector-bubble" class="top-bubble" style="float:right;margin:0px 10px;">
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
					<div id="risks-selector-bubble" class="top-bubble" style="float:right;margin:0px 10px;">
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
					<div id="scenario-selector-bubble" class="top-bubble" style="float:right;margin:0px 10px;">
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
			What should be my strategy to adapt?
		</h1>

		<div id="strategy-adaptation-heading-text" style="float:left;margin-left:30px;">

		Climate Change Adaptation refers to policies, practices and projects which can either moderate damage and/or realise opportunities associated with climate change. This may include mainstreaming adaptation into existing strategies directly or undertaking isolated measures to reduce specific vulnerabilities.
		<br /><br />
		In this process existing relevant national and EU legislation, policies, plans and guidance have to be taken into account and integrated in your strategy.
		<br /><br />
		<a href="http://ec.europa.eu/clima/sites/change" target="_blank">EC DG Climate Action, Adaptation to climate change  </a>
		<br /><br />
		<a href="/eu-sector-policy/general" target="_blank">EU Sector policies  </a>
		<br /><br />
		<a href="/national-adaptation-strategies" target="_blank">Open National Adaptation Strategies  </a>
		<br /><br />
		<a href="http://eur-lex.europa.eu/LexUriServ/LexUriServ.do?uri=COM:2009:0147:FIN:EN:PDF" target="_blank">WHITE PAPER: Adapting to climate change: Towards a European framework for action  </a>
		</div>

        <hr style="clear:both;display:block;visibility:hidden;"/>
	</div>

    <!--

			step 4

	-->
    <script defer="defer" type="text/javascript">
		var $j = jQuery.noConflict();

        function showGeneral() {
            $j("#locate-region").hide()
            $j("#good-practices").hide()
            $j("#generic-measures").hide();
			$j("#general").fadeIn();
        }

        function showGenericMeasures() {
            $j("#locate-region").hide()
            $j("#good-practices").hide()
			$j("#general").hide();
            $j("#generic-measures").fadeIn();
        }

        function showLocateRegion() {
            $j("#good-practices").hide()
            $j("#generic-measures").hide();
			$j("#general").hide();
            $j("#locate-region").fadeIn()
        }

        function showGoodPractices() {
            $j("#generic-measures").hide();
            $j("#locate-region").hide()
			$j("#general").hide();
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
			How can identify my adaptation options?
		</h1>

		<div id="general" style="display: none; margin-left: 30px;">
			<h2>
				4.1 General
			</h2>
			This section provides tools that allow you to assess relevant adaptation measures and good practices. It provides tools to select measures and good practices from the Clearinghouse Mechanism on Adaptation's repository and allows you to assess which measures are implemented in your region and similar regions.
			<br /><br />
			Adaptation options may include the options to prevent  or accept losses (i.e. do nothing), to accommodate.  Multiple options for achieving the same result should be considered at the initial stage.
			<br /><br />
			There are various typologies of adaptation options. One of them classifies them in grey and green infrastructure measures and non-structural soft adaptation options:
			<br /><br />
			<b>Grey infrastructure</b> concerns physical interventions or construction measures that use engineering services to make buildings and infrastructure resilient to weather events;
			<br /><br />
			<b>Green infrastructure</b> concerns using ecosystem  functions and services to design more sustainable and cost-effective adaptation measures.
			<br /><br />
			<b>"Soft" non-structural approaches</b> relate to policy incentives such as land-use controls, information dissemination and economic incentives to reduce or prevent disaster vulnerability
		</div>

		<div id="generic-measures" style="display: none; margin-left: 20px;">
			<h2>
				4.2 What are possible measures?
			</h2>

			<p>
				Select feasible adaptation measures from the Clearinghouse Mechanism on Adaptations repository, based on your risk(s) and sector(s) of interest.
			</p>

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
				4.3 What are possible good practices?
			</h2>

			<p>
				Select feasible good practices for adaptation from the Clearinghouse Mechanism on Adaptations repository, based on your risk(s) and sector(s) of interest.
			</p>

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
				4.4 What good practices are available in regions similar to mine?
			</h2>

			<p>
				The specific characteristics of the region you are in highly determine which adaptation measures are feasible. Taking into account for instance bio-physical and socio-economic characteristics will allow for the identification of good practices that are implemented in your region and similar regions.
			</p>

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

    <script defer="defer" type="text/javascript">
		var $j = jQuery.noConflict();
		$j(document).ready(function(){
			// imageBlank is to make IE change cursor on hover
			$j('a.lightbox').lightBox({
				overlayBgColor: '#000',
				overlayOpacity: 0.6,
				imageLoading: '<%=renderRequest.getContextPath()%>/js/lightbox/images/lightbox-ico-loading.gif',
				imageBtnClose: '<%=renderRequest.getContextPath()%>/js/lightbox/images/lightbox-btn-close.gif',
				imageBlank: '<%=renderRequest.getContextPath()%>/js/lightbox/images/lightbox-blank.gif'
			});
			// handle change to risk selector
			$j('#cost-benefit-risks-selector').change(function() {
				if($j('#cost-benefit-risk-select').val() !== 'none') {
				$j('#cost-benefit-results').fadeIn();
				}
				else {
					$j('#cost-benefit-results').hide();
				}
			});
			// handle change to region selector
			$j('#cost-benefit-regions-selector').change(function() {
				$j('#cost-benefit-results').fadeIn();
			});
		});
		function step5substep(id) {
			// hide results
			if(id === '5-2-2') {
				$j('#cost-benefit-results').hide();
				$j('#cost-benefit-risk-select option[value="none"]').attr('selected', 'selected');
				$j('#cost-benefit-region-select option[value="EU"]').attr('selected', 'selected');
			}

			$j('.step-5-sub').hide();
			$j('#'+id).fadeIn();
		}
	</script>

	<div id="step-right-5" class="step-right" style="margin-left:30px;">
        <h1 id="assess-adaptation-options-heading">
			How can I assess my adaptation options?
		</h1>

		<div id="5-1" class="step-5-sub" style="">
			<h2>
				5.1 General
			</h2>
			<p>
				Once you made a portfolio of potential adaptation options, you need to assess them and determine which of them suit your specific context. You have to consider their effectiveness in reducing vulnerability (or enhancing
				resilience), their wider impact on sustainability and their costs. Assessment of feasible options helps avoiding decisions that lead to mal-adaptation. There is a set of criteria that you should consider when assessing
				adaptation options (Read more).
			</p>
			<p>
				Tools and guidance documents provided in this section will help you to select feasible options.
			</p>
		</div>

		<div id="5-2">
			<div id="5-2-1" class="step-5-sub" style="display:none;">
				<h2>
					5.2.1 How can I determine my adaptation costs?
				</h2>
				<p>
					When calculating adaptation costs, the following steps need to be considered:
					<ol id="adaptation-cost-list" style="">
						<li class="adaptation-cost-list-item" style="margin-top:5px;">
							Determine the applicable measures and their implementation feasibility;
						</li>
						<li class="adaptation-cost-list-item" style="margin-top:5px;">
							Calculate societal costs based on a pre-determined discount rate;
						</li>
						<li class="adaptation-cost-list-item" style="margin-top:5px;">
							Analyse what is the rate of penetration for a given measure and whether it is already being undertaken;
						</li>
						<li class="adaptation-cost-list-item" style="margin-top:5px;">
							Calculate the actual costs of each measure;
							<div style="margin:10px 0px;">
								This step requires to determine upfront investment costs, operating and lifetime implementation costs of the measure. This will help in determining the annualized cost per measure. Future
								costs can be extrapolated on the basis of locally verified estimates; a trajectory for the growth in cost can be based largely on inflation rates. Once a trajectory has been established for
								a business as usual scenario, calculate the potential loss averted for each measure on the basis of different scenarios;
							</div>
						</li>
						<li class="adaptation-cost-list-item" style="margin-top:5px;">
							Estimate the benefits of adaptation actions;
						</li>
						<li class="adaptation-cost-list-item" style="margin-top:5px;">
							Select the applicable valuation approach, e.g. Multi Criteria Analysis;
						</li>
					</ol>
					<div style="font-weight:bold; font-size: 12px; padding-top:20px;">
						Cost-benefit tools and methodologies
					</div>
					<div style="margin-top:10px;">
						<a href="" target="_blank">
							Identification and elaboration of methodology to be used in the classification and costing of projects and programmes for adaptation to climate change
						</a>
					</div>
					<div style="font-weight:bold; font-size: 12px; padding-top:20px;">
						Projects
					</div>
					<div style="margin-top:10px;">
						<a href="http://www.climatecost.cc/" target="_blank">
							ClimateCost project
						</a>
					</div>
				</p>
			<!-- end 5.2.1 -->
			</div>

			<div id="5-2-2" class="step-5-sub" style="display:none;">
				<h2>
					5.2.2 Search the cost-benefit database
				</h2>
				<p>
					Assess available information on adaptation costs and benefits from the Clearinghouse Mechanism on Adaptation's repository, based on your risk(s) and region of interest.
					<!-- added width because IE8 renders it at 100% width otherwise -->
					<div id="cost-benefit-risks-selector" class="adaptationtools-selector" style="float:left;width:212px;">
						<span style="margin-right:10px;">
							Risk
						</span>
						<!-- TODO load dynamically from enumeration nl.wur.alterra.cgi.ace.model.impl.AceItemClimateImpact -->
						<select id="cost-benefit-risk-select" style="">
							<option value="none" selected="selected">Choose a risk:</option>
							<option value="all" disabled="disabled">All risks</option>
							<!-- TODO this one is not present in enum AceItemClimateImpact -->
							<option value="SEALEVEL" disabled="disabled">Sea Level Rise</option>
							<option value="EXTREMETEMP" disabled="disabled">Extreme Temperatures</option>
							<option value="WATERSCARCE" disabled="disabled">Water Scarcity</option>
							<option value="FLOODING">Flooding</option>
							<option value="DROUGHT" disabled="disabled">Droughts</option>
							<option value="STORM" disabled="disabled">Storms</option>
							<option value="ICEANDSNOW" disabled="disabled">Ice and Snow</option>
						</select>
					</div>
					<div id="cost-benefit-regions-selector" class="adaptationtools-selector" style="float:left;width:212px;">
						<span style="margin-right:10px;">
							Region
						</span>
						<select id="cost-benefit-region-select" style="">
							<option id="all-regions" value="ALL" disabled="disabled">All regions</option>
							<option id="EU-option" value="EU" selected="selected">EU</option>
							<option id="AT-option" value="AT" disabled="disabled">Austria</option>
							<option id="CH-option" value="CH" disabled="disabled">Switzerland</option>
							<option id="CZ-option" value="CZ" disabled="disabled">Czech Republic</option>
							<option id="DE-option" value="DE" disabled="disabled">Germany</option>
							<option id="EE-option" value="EE" disabled="disabled">Estonia</option>
							<option id="ES-option" value="ES" disabled="disabled">Spain</option>
							<option id="FI-option" value="FI" disabled="disabled">Finland</option>
							<option id="FR-option" value="FR" disabled="disabled">France</option>
							<option id="GB-option" value="GB" disabled="disabled">Great Britain</option>
							<option id="GR-option" value="GR" disabled="disabled">Greece</option>
							<option id="HU-option" value="HU" disabled="disabled">Hungary</option>
							<option id="IR-option" value="IR" disabled="disabled">Ireland</option>
							<option id="IS-option" value="IS" disabled="disabled">Iceland</option>
							<option id="LT-option" value="LT" disabled="disabled">Lithuania</option>
							<option id="LV-option" value="LV" disabled="disabled">Latvia</option>
							<option id="NL-option" value="NL" disabled="disabled">Netherlands</option>
							<option id="NO-option" value="NO" disabled="disabled">Norvegia</option>
							<option id="PT-option" value="PT" disabled="disabled">Portugal</option>
							<option id="RO-option" value="RO" disabled="disabled">Romania</option>
							<option id="SE-option" value="SE" disabled="disabled">Sweden</option>
						</select>
					</div>
					<hr style="clear:both;display:block;visibility:hidden;"/>

					<div id="cost-benefit-results" style="display:none;padding-top:20px;">
						<table id="cost-benefit-table">
							<colgroup>
								<col style="width: 100px;border:solid #000 1px;" />
								<col style="width: 100px;margin-left:20px;border:solid #000 1px;" />
								<col style="width: 100px;border:solid #000 1px;" />
								<col style="width: 100px;border:solid #000 1px;" />
								<col style="width: 100px;border:solid #000 1px;" />
								<col style="width: 100px;border:solid #000 1px;" />
								<col style="width: 100px;border:solid #000 1px;" />
							</colgroup>
							<thead>
								<tr id="cost-benefit-table-header">
									<th style="background-color: #F1EDC2;border: 1px solid #000;padding: 5px 20px 0;">Adaptation Measure</th>
									<th style="background-color: #F1EDC2;border: 1px solid #000;padding: 5px 20px 0;">Level (EU, MS, regional)</th>
									<th style="background-color: #F1EDC2;border: 1px solid #000;padding: 5px 20px 0;">Impact addressed</th>
									<th style="background-color: #F1EDC2;border: 1px solid #000;padding: 5px 20px 0;">Expected direct damage Cost</th>
									<th style="background-color: #F1EDC2;border: 1px solid #000;padding: 5px 20px 0;">Expected Cost of Adaptation</th>
									<th style="background-color: #F1EDC2;border: 1px solid #000;padding: 5px 20px 0;">Expected benefits</th>
									<th style="background-color: #F1EDC2;border: 1px solid #000;padding: 5px 20px 0;">Source</th>
								</tr>
							</thead>
							<tbody>
								<tr class="cost-benefit-table-row">
									<td class="cost-benefit-table-column" valign="top" style="padding: 5px 5px;">
										River Flood protection
									</td>
									<td class="cost-benefit-table-column" valign="top" style="padding: 5px 5px;">
										EU
									</td>
									<td class="cost-benefit-table-column" valign="top" style="padding: 5px 5px;">
										Relative change in 100y return level flow
									</td>
									<td class="cost-benefit-table-column" valign="top" style="padding: 5px 5px;">
										Expected mean annual damages
										<br/>
										<div style="margin:10px;text-align:center;">
											<a class="lightbox" href="<%=renderRequest.getContextPath()%>/images/cost-benefit/1_1_Flood EU 27 Mean Annual Damages (bar graph).png">
												<img src="<%=renderRequest.getContextPath()%>/images/cost-benefit/thumb-1_1_Flood EU 27 Mean Annual Damages (bar graph).png" width="72" height="72" alt="" />
											</a>
										</div>
										<br/>
										Expected mean annual damages per RCM
										<br/>
										<div style="margin:10px;text-align:center;">
											<a class="lightbox" href="<%=renderRequest.getContextPath()%>/images/cost-benefit/1_2 Floods EU 27 Average Min Max Mean Annual Flood Damages (line graph).png">
												<img src="<%=renderRequest.getContextPath()%>/images/cost-benefit/thumb-1_2 Floods EU 27 Average Min Max Mean Annual Flood Damages (line graph).png" width="72" height="72" alt="" />
											</a>
										</div>
									</td>
									<td class="cost-benefit-table-column" valign="top" style="padding: 5px 5px;">
										Costs of Adaptation, in Billion Euro/year, to maintain 1 in 100 year levels of flood protection
										<br/>
										<div style="margin:10px;text-align:center;">
											<a class="lightbox" href="<%=renderRequest.getContextPath()%>/images/cost-benefit/2_1_Floods EU 27 Cost of Adaptation (line graph).png">
												<img src="<%=renderRequest.getContextPath()%>/images/cost-benefit/thumb-2_1_Floods EU 27 Cost of Adaptation (line graph).png" width="72" height="72" alt="" />
											</a>
										</div>
										Cost of Adaptation per RCM
										<br/>
										<div style="margin:10px;text-align:center;">
											<a class="lightbox" href="<%=renderRequest.getContextPath()%>/images/cost-benefit/2_2_Floods EU 27 Cost of Adaptation (line graph).png">
												<img src="<%=renderRequest.getContextPath()%>/images/cost-benefit/thumb-2_2_Floods EU 27 Cost of Adaptation (line graph).png" width="72" height="72" alt="" />
											</a>
										</div>
									</td>
									<td class="cost-benefit-table-column" valign="top" style="padding: 5px 5px;">
										Expected benefits from maintaining 1-in-100 y river protection
										<br/>
										<div style="margin:10px;text-align:center;">
											<a class="lightbox" href="<%=renderRequest.getContextPath()%>/images/cost-benefit/3_1_Floods EU 27 Benefits of Adaptation (table).png">
												<img src="<%=renderRequest.getContextPath()%>/images/cost-benefit/thumb-3_1_Floods EU 27 Benefits of Adaptation (table).png" width="72" height="72" alt="" />
											</a>
										</div>
									</td>
									<td class="cost-benefit-table-column" valign="top" style="padding: 5px 5px;">
										<a href="http://www.climatecost.cc/" target="_blank">
											ClimateCost
										</a>
										<br/>
										<a href="" target="_blank">
											Policy brief 6
										</a>
									</td>
								</tr>
								<tr class="cost-benefit-table-row" style="background-color: #FDFCDC;">
									<td class="cost-benefit-table-column" valign="top" style="padding: 5px 5px;">
										River Flood protection
									</td>
									<td class="cost-benefit-table-column" valign="top" style="padding: 5px 5px;">
										27 member states
									</td>
									<td class="cost-benefit-table-column" valign="top" style="padding: 5px 5px;">
										Relative change in 100y return level flow
									</td>
									<td class="cost-benefit-table-column" valign="top" style="padding: 5px 5px;">
										Expected mean annual damages
										<br/>
										<div style="margin:10px;text-align:center;">
											<a class="lightbox" href="<%=renderRequest.getContextPath()%>/images/cost-benefit/1_3_Flood EU 27 Mean Annual Damages per M S (bar graph).png">
												<img src="<%=renderRequest.getContextPath()%>/images/cost-benefit/thumb-1_3_Flood EU 27 Mean Annual Damages per M S (bar graph).png" width="72" height="72" alt="" />
											</a>
										</div>
									</td>
									<td class="cost-benefit-table-column" valign="top" style="padding: 5px 5px;">
										Costs of Adaptation to maintain 1 in 100 year levels of flood protection
										<br/>
										<div style="margin:10px;text-align:center;">
											<a class="lightbox" href="<%=renderRequest.getContextPath()%>/images/cost-benefit/2_3 Floods EU 27 Cost of Adaptation per MS (bar graph).png">
												<img src="<%=renderRequest.getContextPath()%>/images/cost-benefit/thumb-2_3 Floods EU 27 Cost of Adaptation per MS (bar graph).png" width="72" height="72" alt="" />
											</a>
										</div>
									</td>
									<td class="cost-benefit-table-column" valign="top" style="padding: 5px 5px;">
									</td>
									<td class="cost-benefit-table-column" valign="top" style="padding: 5px 5px;">
										<a href="http://www.climatecost.cc/" target="_blank">
											ClimateCost
										</a>
										<br/>
										<a href="" target="_blank">
											Policy brief 6
										</a>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</p>
			<!-- end 5.2.2 -->
			</div>

		<!-- end 5.2 -->
		</div>

		<div id="5-3" class="step-5-sub" style="display:none;">
			<h2>
				5.3 How do I decide which measures to include in my portfolio?
			</h2>
			<p>
				Adaptation options have to be effective and efficient in order to be considered for implementation. Effective options are options that reduce a certain vulnerability or number of vulnerabilities to a desired level.
				Efficient options are the options whose benefits exceed their costs and are more cost-effective than the alternatives. These benefits can be economic, social and environmental. In the feasibility assessment all these
				three aspects have to be taken into account.
				<div>
					(Read more)
				</div>
				<div style="font-weight:bold; font-size: 12px; padding-top:20px;">				
					Links
				</div>
					<ul>
						<li>
							Link to MCA tool of ClimWatAdapt
						</li>
					</ul>
					
			</p>
		<!-- end 5.3 -->	
		</div>				
		
		<div id="5-4" class="step-5-sub" style="display:none;">
		<h2>
				5.4 What is my Adaptive Capacity?
			</h2>
			<p>
				Adaptive capacity is "the ability of a (human) system to adjust to climate change (including climate variability and extremes) to moderate potential damages, to take advantage of opportunities, or to cope with the 
				consequences." Adaptive capacity is very much determined by available financial recourses, education level and available adaptation options. There are also a number of hidden costs associated with the implementation of 
				measures, related to adaptive capacity such as institutional capacity and the experience of an administration in implementing a specific adaptation measure. GDP, education statistics, lack of impact data, appropriate 
				emergency response scheme or overall adaptation strategy are all indicators that could be used to assess adaptive capacity.
				<div>
					(Read more)
				</div>
			</p>		
		<!-- end 5.4 -->	
		</div>	
		
		<div id="5-5" class="step-5-sub" style="display:none;">
			<h2>
				5.5 How to plan for adaptation
		</h2>
		<p>
				Climate change introduces a moving target to adaptation and therefore it requires new planning approaches. An example of such a novel approach is the adaptation plan for climate proofing of Thames estuary in 21st century.			
				<div>
					(Read more)
				</div>
				<div style="font-weight:bold; font-size: 12px; padding-top:20px;">				
					Links
				</div>
					<ul>					
						<li>
							<a href="http://www.environment-agency.gov.uk/research/planning/109030.aspx" target="_blank">
								Thames Estuary 2100 case
							</a>
						</li>
					</ul>
									
		</p>
		<!-- end 5.5 -->	
		</div>

        <hr style="clear:both;display:block;visibility:hidden;"/>
	</div>

    <hr style="clear:both;display:block;visibility:hidden;"/>


	<!-- acemap_column -->
    </div>
<!-- outer div -->	
</div>	
