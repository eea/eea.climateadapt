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
    var proxyUrl = '<%= request.getContextPath() %>/proxy?url=';

    OpenLayers.ProxyHost = '<%= request.getContextPath() %>/proxy?url=';

    var $j = jQuery.noConflict();

	function displayStep(nr) {

        $j("#image_steps").attr("src", "<%=renderRequest.getContextPath()%>/images/AST_small" + nr + ".png");

		$j('.step-left').hide();
		$j('#step-left-'+nr).fadeIn();
		$j('.step-right').fadeOut();
		$j('#step-right-'+nr).fadeIn();
	}
</script>

<div id="adaptationtool_container">
	<!-- left panel -->
	<div style="border:solid 1px green;margin-right: 10px; margin-top: 50px; float:left;width:385px;background-color:#d2df92;">

        <!-- Steps selection image -->
        <div>
            <img id="image_steps" src="<%=renderRequest.getContextPath()%>/images/AST_small1.png" width="380px" height="236px" usemap="#navigation-map"/>
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
				<area shape="poly" coords="175,152,332,153,336,186,180,186,170,172" nohref="nohref" onclick="displayStep(4);" class="clickable" />
				<area shape="poly" coords="123,177,165,177,181,188,233,192,278,199,280,224,130,227,122,205" nohref="nohref" onclick="displayStep(5);" class="clickable" />
			</map>
		
		<!-- end step 1 -->	
		</div>

		<!--
		
				step 2
				
		-->
		<div id="step-left-2" class="step-left">
			<div id="what-should-i-do" style="margin:5px;">
				<div id="what-should-i-do-heading" style="font-size:24px;" onclick="$j('#analyze-maps-options').fadeOut();$j('#what-should-i-do-options').fadeIn();$j('#analyze-maps-heading').addClass('clickable');$j('#what-should-i-do-heading').removeClass('clickable');$j('#general-content').fadeIn();$j('#indicators-map').fadeOut();">
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
			<div id="analyze-maps" style="margin:5px;">
				<div id="analyze-maps-heading" class="clickable" style="font-size:24px;" onclick="$j('#what-should-i-do-options').fadeOut();$j('#analyze-maps-options').fadeIn();$j('#what-should-i-do-heading').addClass('clickable');$j('#analyze-maps-heading').removeClass('clickable');$j('.what-should-i-do-content').fadeOut();$j('#indicators-map').fadeIn(); showVulnerabilitiesAndRisks(); initMapViewerIndicators();">
					Compare my area to Europe
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
                            1. <a href="#" onclick="showLocateRegion(); return false;">Locate your region and find similar regions</a>
                        </li>
						<li class="list-option">
                            <img src="<%=renderRequest.getContextPath()%>/images/arrow_green.png" class="valigned"/>
							2. <a href="#" onclick="showGenericMeasures(); return false;">What are generic measures?</a>
						</li>
						<li class="list-option">
                            <img src="<%=renderRequest.getContextPath()%>/images/arrow_green.png" class="valigned"/>
							3. <a href="#" onclick="showLocateRegion(); return false;">What are potential good practices for your region based on experiences in similar regions?</a>
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
    <div id="acemap_column" style="margin-right: 10px; margin-top: 50px; float:left;border:solid 1px red;width:850px;background:#fff;">
	<!--
	
			step 1
			
	-->
	<div id="step-right-1" class="step-right">
		<img src="<%=renderRequest.getContextPath()%>/images/AST_large.png" />
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
		
			//
			// create information popups
			//
			$j('.top-bubble').CreateBubblePopup({
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
			$j('.right-bubble').CreateBubblePopup({
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
							// if this is a vulnerability type
							if(y === 'VULNERABILITY') {
								// enable underlying cause indicators
								showUnderlyingCauses();								
							}
							// if this is an underlying cause type
							else if(y === 'EXPOSURE') {
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
            $j("#header-climate-change").hide();
            $j("#text-climate-change").hide();

            $j("#header-socio-ecological").hide();
            $j("#text-socio-ecological").hide();

            $j("#header-underlying-causes").hide();
            $j("#text-underlying-causes").hide();

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
            $j("#header-socio-ecological").hide();
            $j("#text-socio-ecological").hide();

            $j("#header-underlying-causes").hide();
            $j("text-underlying-causes").hide();

            $j("#header-vulnerability").hide();
            $j("#text-vulnerability").hide();

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
            $j("#header-underlying-causes").hide();
            $j("#text-underlying-causes").hide();

            $j("#header-vulnerability").hide();
            $j("#text-vulnerability").hide();

            $j("#header-climate-change").hide();
            $j("#text-climate-change").hide();

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

         <h2 id="header-vulnerability" class="heading" style="display: none">
             1. What are the key vulnerabilities and risks?
         </h2>

        <h2 id="header-underlying-causes" class="heading" style="display: none">
             2. What are the underlying causes?
        </h2>

        <h2 id="header-climate-change" class="heading" style="display: none">
             3. How does the climate change?
        </h2>

        <h2 id="header-socio-ecological" class="heading" style="display: none">
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
		
		<div id="indicators-map" style="display: none">
            <div id="text-vulnerability" class="description" style="display: none">
                <p>Vulnerability and risks represent bla bla bla  lorum ipsum hardanger voda en joda krijgt het heen en weer...</p>
                <p>Choose a risk and (optionally) a sector to find out what corresponding vulnerabilities and risks are.</p>
            </div>

            <div id="text-underlying-causes" class="description" style="display: none">
                <p>Underlying causes can be both caused by the global system (exposure) and the human system (sensitivity) bla bla bla
                    lorum ipsum hardanger voda en joda krijgt het heen en weer...</p>
            </div>

            <div id="text-climate-change" class="description" style="display: none">
                <p>Climate changes bla bla bla  lorum ipsum hardanger voda en joda krijgt het heen en weer...</p>
            </div>

             <div id="text-socio-ecological" class="description" style="display: none">
                <p>Socio-ecological bla bla bla  lorum ipsum hardanger voda en joda krijgt het heen en weer...</p>
            </div>

			<div id="adaptationtools-selectors-top">
				<div id="risks-selector" class="adaptationtools-selector">
					<!-- TODO load dynamically from enumeration nl.wur.alterra.cgi.ace.model.impl.AceItemClimateImpact -- but aceitem model classes must be made available as a jar for that -->
					<select id="risk-select" style="float:left;" disabled="disabled">
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
					<select id="sector-select" style="float:left;" disabled="disabled">
						<option value="none" selected="selected">Choose a sector:</option>
						<option value="all">All sectors</option>
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
					<div class="top-bubble" style="float:left;margin-left:10px;">
						<img src="<%=renderRequest.getContextPath()%>/images/info.png" class="valigned"/>
					</div>
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
					Choose an indicator to view it's map
				</h2>
				
				<div id="indicator-vulnerability" class="indicator-category">

					<div class="right-bubble" style="float:left;margin-right:10px;">
						<img src="<%=renderRequest.getContextPath()%>/images/info.png" class="valigned"/>
					</div>
					<h3 class="indicator-category-title" onclick="showVulnerabilitiesAndRisks();" style="cursor:pointer;">
						Vulnerability & risks
					</h3>					
					<div class="indicator-category-list"></div>
				</div>

				<h2 id="underlying-causes-header" class="disabled">
					Underlying causes
				</h2>

				<div id="indicator-exposure" class="indicator-category disabled">
					<div class="right-bubble" style="float:left;margin-right:10px;">
						<img src="<%=renderRequest.getContextPath()%>/images/info.png" class="valigned"/>
					</div>
					<h3 class="indicator-category-title">
						Exposure
					</h3>
					<div class="indicator-category-list"></div>
				</div>

				<div id="indicator-sensitivity" class="indicator-category disabled">
					<div class="right-bubble" style="float:left;margin-right:10px;">
						<img src="<%=renderRequest.getContextPath()%>/images/info.png" class="valigned"/>
					</div>
					<h3 class="indicator-category-title">
						Sensitivity
					</h3>					
					<div class="indicator-category-list"></div>
				</div>
				
				<div id="indicator-climate-changes" class="indicator-category" style="display:none;">
					<div class="right-bubble" style="float:left;margin-right:10px;">
						<img src="<%=renderRequest.getContextPath()%>/images/info.png" class="valigned"/>
					</div>
					<h3 class="indicator-category-title">
						Climate changes
					</h3>
					<div class="indicator-category-list"></div>
				</div>
					
				<div id="indicator-human-causes" class="indicator-category"  style="display:none;">
					<div class="right-bubble" style="float:left;margin-right:10px;">
						<img src="<%=renderRequest.getContextPath()%>/images/info.png" class="valigned"/>
					</div>
					<h3 class="indicator-category-title">
						Resource efficiency
					</h3>					
					<div class="indicator-category-list"></div>
				</div>
					
			</div>
		
			<hr style="clear:both;display:block;visibility:hidden;"/>

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
					<div class="top-bubble" style="float:left;margin-left:10px;">
						<img src="<%=renderRequest.getContextPath()%>/images/info.png" class="valigned"/>
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
					<div class="top-bubble" style="float:left;margin-left:10px;">
						<img src="<%=renderRequest.getContextPath()%>/images/info.png" class="valigned"/>
					</div>		
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
            $j("#generic-measures").show();
        }

        function showLocateRegion() {
            $j("#locate-region").show()
            $j("#generic-measures").hide();
        }

    </script>

	<div id="step-right-4" class="step-right">
        <h1 id="aplication-options-heading">
			<img src="<%=renderRequest.getContextPath()%>/images/bullit4.png" class="valigned"/>
			How can identify my adaptation options?
		</h1>

        <div id="generic-measures" style="display: none">
			 <form>
                 <div id="risks-selector-step4" style="float: left;">
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

                 <div id="sector-selector-step4"  style="float: left;margin-left: 20px; ">
                     <span style="margin-right:30px;">
                         Filter by sector
                     </span>
                     <!-- TODO load dynamically from enumeration nl.wur.alterra.cgi.ace.model.impl.AceItemSector -- but aceitem model classes must be made available as a jar for that -->
                     <select id="sector-select-step4" style="float:left;">
                         <option value="none" selected="selected">Choose a sector:</option>
                         <option value="all">All sectors</option>
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
                     <div class="top-bubble" style="float:left;margin-left:10px;">
                         <img src="<%=renderRequest.getContextPath()%>/images/info.png" class="valigned"/>
                     </div>
                 </div>
            </form>
		</div>


        <div id="locate-region">
            <div style="margin-bottom: 10px">
                <form>
                    Region of interest: <input type="text" id="locate_region_input" name="locate_region_input" style="width:200px" />&nbsp;<button type="submit" onclick="gazeeteer.search($j('#locate_region_input').val()); return false;" >Search for similar regions</button>
                </form>
            </div>
            <div id="map-container-step4">
            </div>

            <div id="locate_region_results" style="float:right; width:190px; height: 300px;"></div>

            <hr style="clear:both;display:block;visibility:hidden;"/>

            <div id="specify-region-similarity-criteria" style="margin-top:10px;">
                Specify region similarity criteria &raquo;
            </div>
        </div>


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
