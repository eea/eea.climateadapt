<%@ page import="java.util.Arrays" %>
<%--
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
--%>

<%@include file="/html/init.jsp" %>

<portlet:actionURL name="searchAceitem" var="searchAceitemURL"/>

<div id="nas_container">

<%-- TODO move to js file --%>
<script type="text/javascript">

	// ENABLE THIS WHEN RUNNING STANDALONE (WITHOUT REST OF ACE)
	var $j = jQuery.noConflict();
	
	$j(document).ready(function() {
		sortCountries();
		$j('#country-selection-list').change(function() {select(this.value);});	
		sortNasTable();
	});
	
	// sort countries select by their i18n name
	function sortCountries() {
		var options = $j('#country-selection-list > option');
		countryNames = new Array();
		countryValues = new Array();
		for(i = 0; i < options.length; i++)  {
			countryNames[i] = [options[i].text, options[i].value, options[i].id];
		}
		countryNames.sort(sortByFirstElement);
		for(i = 0; i < options.length; i++)  {
			options[i].text = countryNames[i][0];
			options[i].value = countryNames[i][1];
			options[i].id = countryNames[i][2];
		}	
	}
	
	// sort NAS table by country (to put regions under their country)
	function sortNasTable() {
		var allNAS = $j('.nas-row');
		var countriesNAS = $j('.nas-row').not('.nas-region-row');
		countriesNAS.sort(function(a, b) {
		   var compA = $(a).text().toUpperCase();
		   var compB = $(b).text().toUpperCase();
		   return (compA < compB) ? -1 : (compA > compB) ? 1 : 0;
		});	
		var regionsNAS = $j('.nas-region-row');	
		var sorted = new Array();

		$j.each(countriesNAS, function(index, value) {
            $j(value).removeClass("nas-row-even");
            $j(value).removeClass("nas-row-odd");

            if (index % 2 == 0) {
                $j(value).addClass("nas-row-odd")
            } else {
                $j(value).addClass("nas-row-even")
            }

			sorted.push(value);
			$j.each(regionsNAS, function(index2, value2) {
				if(value.id == value2.id) {

                    if (index % 2 == 0) {
                        $j(value2).addClass("nas-row-odd")
                    } else {
                        $j(value2).addClass("nas-row-even")
                    }

					sorted.push(value2);
				}
			});
		});				
		allNAS.remove();
		$j('#nas-header').after(sorted);	
		$j('.nas-row').hover(function(){ $j(this).addClass("nas-row-selected");},function(){$j(this).removeClass("nas-row-selected") });
	}
	
	// sorts arrays by natural order of their first element
	// except special id 'no-selection-option' which always comes first
	function sortByFirstElement(array1, array2){
		var id = array1[2];
		if(id == 'no-selection-option') {
			return -1;
		}
		var a = array1[0];
		var b = array2[0];
		if ( a < b ) return -1;
		else if( a > b ) return 1;
		else return 0;		
	}

	
	var actual_image = "europe";
	var selectedCountry = '';
	
	var countries = ['AT', 'CH', 'CZ', 'DE', 'DK', 'EE', 'ES', 'FI', 'FR', 'GB', 'GR', 'HU', 'IR', 'IS', 'LT', 'LV', 'NL', 'NO', 'PT', 'RO', 'SE'];
	
	function highlight(area) {
		$j("#"+ actual_image+'_selected').hide();
		
		$j.each(countries, function(country) {
			$j('#' + country+ '_selected').hide();
		});
		
		$j("#"+ area+'_selected').show();
	}
	
	function unhighlight(area) {
		$j("#"+ actual_image+'_selected').show();
		if (area != actual_image) {
			$j("#"+ area+'_selected').hide();
		}
	}

	function clearSelection() {
		$j("#"+ actual_image+'_selected').hide();
		actual_image = "europe";
		$j("#"+ actual_image+'_selected').show();
		
		$j('.nas-row').fadeIn(200);
		
		$j('#country-selection-list').value = '';
		$j('#no-selection-option').attr('selected', true);	
	}
	
	function select(area) {
		// deselect
		if (actual_image == area) {
			$j("#"+ actual_image+'_selected').hide();
			actual_image = "europe";
			$j("#"+ actual_image+'_selected').show();
			
			selectedCountry = '';
			$j('.nas-row').fadeIn(200);
		} 
		// select
		else {
			if(area == null || area == "") {
				clearSelection();
				return false;
			}
			$j("#"+ actual_image+'_selected').hide();
			$j.each(countries, function(country) {
				$j('#' + country+ '_selected').hide();
			});
			
			actual_image = area;
			$j("#"+ actual_image+'_selected').show();
			
			selectedCountry = area;		
			$j('.nas-row').fadeOut(200);
			$j('.' + area + '-row').fadeIn(200);
			$j('#country-selection-list').value = area;
			$j('#' + area + '-option').attr("selected", true);
			
		}		
		return false;
	}
	
	
</script>

<div id="<portlet:namespace/>content"></div>

	<!-- Introduction -->
	<div id="nas_intro">
	
		<h1>
			National adaptation strategies
		</h1>
		<div>
			EEA member countries are at different stages of preparing, developing and implementing national adaptation strategies. The development depends on the magnitude and nature of the observed impacts, assessments of current and future vulnerability and the capacity to adapt. All countries have also submitted information on their adaptation plans in their 5th National Communication to the United Nations Framework Convention on Climate Change due on 1 January 2010. In addition, some actions and measures are increasingly being taken at regional and local levels.		
		</div>
		<div id="intro-link">
			<span class="link-external">
				<a href="http://unfccc.int/national_reports/annex_i_natcom/submitted_natcom/items/4903.php" class="external-link">
					5<sup>th</sup> National Communication to the United Nations Framework Convention on Climate Change
				</a>			
			</span>
		</div>
	
	</div>

    <!-- Map colum -->
    <div id="nas_left_column" class="nas_column">

		<img id="europe_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/europe.png" width="458" height="515" border="0" usemap="#Map" style="display:block;"/>
		<img id="AT_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/AT.png" width="458" height="515" border="0" usemap="#Map" style="display:none;"/>
		<img id="CH_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/CH.png" width="458" height="515" border="0" usemap="#Map" style="display:none;" />
		<img id="CZ_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/CZ.png" width="458" height="515" border="0" usemap="#Map" style="display:none;" />
		<img id="DE_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/DE.png" width="458" height="515" border="0" usemap="#Map" style="display:none;"/>
		<img id="DK_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/DK.png" width="458" height="515" border="0" usemap="#Map" style="display:none;"/>
		<img id="EE_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/EE.png" width="458" height="515" border="0" usemap="#Map" style="display:none;"/>
		<img id="ES_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/ES.png" width="458" height="515" border="0" usemap="#Map" style="display:none;"/>
		<img id="FI_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/FI.png" width="458" height="515" border="0" usemap="#Map" style="display:none;"/>
		<img id="FR_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/FR.png" width="458" height="515" border="0" usemap="#Map" style="display:none;"/>
		<img id="GB_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/GB.png" width="458" height="515" border="0" usemap="#Map" style="display:none;"/>
		<img id="GR_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/GR.png" width="458" height="515" border="0" usemap="#Map" style="display:none;"/>
		<img id="HU_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/HU.png" width="458" height="515" border="0" usemap="#Map" style="display:none;"/>
		<img id="IR_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/IR.png" width="458" height="515" border="0" usemap="#Map" style="display:none;"/>
		<img id="IS_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/IS.png" width="458" height="515" border="0" usemap="#Map" style="display:none;"/>
		<img id="LT_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/LT.png" width="458" height="515" border="0" usemap="#Map" style="display:none;"/>
		<img id="LV_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/LV.png" width="458" height="515" border="0" usemap="#Map" style="display:none;"/>
		<img id="NL_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/NL.png" width="458" height="515" border="0" usemap="#Map" style="display:none;"/>
		<img id="NO_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/NO.png" width="458" height="515" border="0" usemap="#Map" style="display:none;"/>
		<img id="PT_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/PT.png" width="458" height="515" border="0" usemap="#Map" style="display:none;"/>
		<img id="RO_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/RO.png" width="458" height="515" border="0" usemap="#Map" style="display:none;"/>
		<img id="SE_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/SE.png" width="458" height="515" border="0" usemap="#Map" style="display:none;"/>
	
		<select id="country-selection-list"  style="margin-top:5px;">
			<option id="no-selection-option" value="" selected="selected">No country selected</option>
			<option id="AT-option" value="AT">Austria</option>
			<option id="CH-option" value="CH">Switzerland</option>
			<option id="CZ-option" value="CZ">Czech Republic</option>
			<option id="DE-option" value="DE">Germany</option>
			<option id="EE-option" value="EE">Estonia</option>
			<option id="ES-option" value="ES">Spain</option>
			<option id="FI-option" value="FI">Finland</option>
			<option id="FR-option" value="FR">France</option>
			<option id="GB-option" value="GB">Great Britain</option>
			<option id="GR-option" value="GR">Greece</option>
			<option id="HU-option" value="HU">Hungary</option>
			<option id="IR-option" value="IR">Ireland</option>
			<option id="IS-option" value="IS">Iceland</option>
			<option id="LT-option" value="LT">Lithuania</option>
			<option id="LV-option" value="LV">Latvia</option>
			<option id="NL-option" value="NL">Netherlands</option>
			<option id="NO-option" value="NO">Norvegia</option>
			<option id="PT-option" value="PT">Portugal</option>
			<option id="RO-option" value="RO">Romania</option>
			<option id="SE-option" value="SE">Sweden</option>
		</select>
		<button style="margin-top:5px;" onclick="clearSelection();">clear</button>

		<map name="Map" id="country-selection-map">
			<!-- portugal -->
			<area shape="poly" coords="32,412,17,437,23,446,17,462,34,465,41,453,39,445,44,441,40,431,46,431,49,423,51,413,59,408,53,400,40,399,39,394,33,396,30,410" href="#PT" alt="portugal" onclick="return select('PT')" onmouseover="highlight('PT');" onmouseout="unhighlight('PT');"/>
			<!-- spain -->
			<area shape="poly" coords="34,393,41,396,50,399,60,407,52,414,47,431,41,431,44,441,39,445,42,452,35,465,44,472,45,480,51,485,58,480,64,482,68,479,83,481,86,482,89,481,91,483,99,474,109,473,109,467,121,459,116,452,117,446,131,432,130,428,145,426,156,419,159,412,157,409,151,410,144,407,136,403,131,403,123,401,114,398,112,393,107,392,99,389,94,389,90,386,81,385,72,382,64,380,55,378,47,374,43,378,37,377,33,379,33,384" href="#ES" alt="spain"  onclick="return select('ES')" onmouseover="highlight('ES');" onmouseout="unhighlight('ES');"/>
			<area shape="poly" coords="145,450,154,456,159,450,153,445" href="#ES" alt="spain"  onclick="return select('ES')" onmouseover="highlight('ES');" onmouseout="unhighlight('ES');"/>
			<area shape="poly" coords="136,454,132,458,134,461,137,461,137,455" href="#ES" alt="spain"  onclick="return select('ES')" onmouseover="highlight('ES');" onmouseout="unhighlight('ES');"/>
			<area shape="poly" coords="162,448,167,449,168,444,163,443,161,445" href="#ES" alt="spain"  onclick="return select('ES')" onmouseover="highlight('ES');" onmouseout="unhighlight('ES');"/>
			<!-- france -->
			<area shape="poly" coords="157,408,151,410,138,403,128,402,115,398,111,392,106,391,113,388,119,364,116,352,110,344,110,336,104,335,104,331,94,327,89,316,108,313,112,318,120,317,123,319,121,312,120,303,127,304,128,309,136,311,139,306,145,303,153,301,153,291,161,289,164,294,167,295,169,299,173,301,176,302,176,307,180,307,182,310,188,314,191,316,196,316,200,320,203,322,206,319,212,322,206,335,206,341,201,341,195,348,191,352,189,356,188,361,192,362,195,358,197,358,197,362,197,365,201,373,196,375,195,377,198,380,196,387,204,391,204,395,195,402,187,405,178,400,169,397,162,398,157,403" href="#FR" alt="france"  onclick="return select('FR')" onmouseover="highlight('FR');" onmouseout="unhighlight('FR');"/>
			<area shape="poly" coords="220,430,225,419,223,406,221,409,215,411,213,416,214,422,217,428" href="#FR" alt="france"  onclick="return select('FR')" onmouseover="highlight('FR');" onmouseout="unhighlight('FR');"/>
			<!-- netherlands -->
			<area shape="poly" coords="170,286,174,280,179,276,182,271,182,264,187,259,199,258,203,261,206,263,203,271,203,274,201,280,194,282,196,286,196,290,194,296,190,297,190,293,189,287,181,288" href="#NL" alt="netherlands"  onclick="return select('NL')" onmouseover="highlight('NL');" onmouseout="unhighlight('NL');"/>
			<!-- ireland -->
			<area shape="poly" coords="58,266,54,258,55,252,61,251,68,243,62,237,66,232,64,228,68,224,74,226,79,226,78,222,84,217,92,216,94,219,87,223,82,226,82,231,87,234,91,230,92,235,96,238,94,251,90,258,88,263" href="#IR" alt="ireland"  onclick="return select('IR')" onmouseover="highlight('IR');" onmouseout="unhighlight('IR');"/>
			<!-- great britain -->
			<area shape="poly" coords="83,226,83,231,87,233,92,230,93,235,97,238,100,235,105,232,103,227,100,219,94,219" href="#GB" alt="great britain"  onclick="return select('GB')" onmouseover="highlight('GB');" onmouseout="unhighlight('GB');"/>
			<area shape="poly" coords="88,293,93,296,96,292,102,291,105,295,111,289,116,289,118,292,131,292,148,292,154,288,154,284,147,283,153,280,158,271,159,265,150,261,145,263,147,259,146,251,145,243,139,236,138,223,135,218,130,214,128,209,138,202,140,194,134,191,125,190,133,181,136,174,140,171,135,169,131,177,121,175,111,175,102,180,97,187,95,194,103,194,99,200,106,207,102,205,99,213,102,216,104,220,110,218,108,225,110,230,118,230,118,236,122,242,117,250,109,248,105,255,109,256,109,263,103,264,98,267,98,272,105,275,114,278,104,279" href="#GB" alt="great britain"  onclick="return select('GB')" onmouseover="highlight('GB');" onmouseout="unhighlight('GB');"/>
			<!-- iceland -->
			<area shape="poly" coords="33,68,42,72,51,83,60,85,65,82,72,82,83,81,89,78,93,73,94,67,91,63,92,54,87,54,88,49,83,48,81,52,76,52,73,49,66,48,62,45,60,49,53,50,56,46,53,36,47,35,40,39,36,42,40,46,46,48,43,50,34,51,40,56,40,63,39,65" href="#IS" alt="iceland"  onclick="return select('IS')" onmouseover="highlight('IS');" onmouseout="unhighlight('IS');"/>
			<!-- switzerland -->
			<area shape="poly" coords="189,360,193,362,197,358,198,365,205,365,210,363,213,358,218,367,222,358,229,362,234,352,225,350,225,343,220,341,214,339,207,342,201,342,195,350,190,354" href="#CH"alt="switzerland"  onclick="return select('CH')" onmouseover="highlight('CH');" onmouseout="unhighlight('CH');" />
			<!-- austria -->
			<area shape="poly" coords="225,349,232,350,236,354,240,351,249,350,252,355,262,357,274,357,277,353,285,352,289,346,289,338,295,337,294,331,292,323,284,323,275,321,272,326,266,327,261,329,258,333,259,340,251,342,246,343,235,343,228,343" href="#AT" alt="austria"  onclick="return select('AT')" onmouseover="highlight('AT');" onmouseout="unhighlight('AT');"/>
			<!-- czech republic -->
			<area shape="poly" coords="265,326,273,326,276,321,283,323,293,323,299,321,304,317,303,314,309,310,306,305,302,303,299,304,297,301,292,300,291,303,286,300,286,296,275,293,268,293,262,298,252,303,248,307,252,314,258,317" href="#CZ" alt="czech republic"  onclick="return select('CZ')" onmouseover="highlight('CZ');" onmouseout="unhighlight('CZ');"/>
			<!-- denmark -->
			<area shape="poly" coords="216,241,228,242,235,242,241,244,245,245,249,239,248,232,250,230,249,223,244,223,240,224,237,227,232,229,232,223,237,218,232,215,233,209,238,207,233,199,228,202,225,207,217,208,215,214,213,222,213,230" href="#DK" alt="denmark"  onclick="return select('DK')" onmouseover="highlight('DK');" onmouseout="unhighlight('DK');"/>
			<!-- hungary -->
			<area shape="poly" coords="295,332,296,337,290,339,290,346,288,350,292,354,298,359,303,363,312,363,316,360,321,357,323,355,330,355,335,352,338,346,340,340,342,333,350,327,343,322,337,321,328,321,325,326,314,330,307,334" href="#HU" alt="hungary"  onclick="return select('HU')" onmouseover="highlight('HU');" onmouseout="unhighlight('HU');"/>
			<!-- romania -->
			<area shape="poly" coords="351,325,343,333,340,344,335,353,329,355,334,360,336,365,341,367,343,371,349,376,356,374,355,378,360,384,365,382,373,383,385,381,390,375,396,373,408,371,416,375,416,368,415,363,417,358,422,356,421,351,419,347,415,350,409,353,406,348,403,343,403,334,400,330,384,315,380,320,374,322,372,324,369,327,365,324" href="#RO" alt="romania"  onclick="return select('RO')" onmouseover="highlight('RO');" onmouseout="unhighlight('RO');"/>
			<!-- germany -->
			<area shape="poly" coords="201,258,207,263,205,269,204,276,202,281,195,282,197,287,195,297,197,302,194,305,197,310,196,315,203,321,207,318,213,321,207,335,207,341,213,339,222,340,226,343,248,342,257,340,258,331,264,326,248,306,267,293,272,292,272,285,269,274,263,266,265,259,265,252,258,243,253,244,248,247,240,251,238,245,233,246,229,243,218,242,218,249,218,254" href="#DE"  alt="germany"  onclick="return select('DE')" onmouseover="highlight('DE');" onmouseout="unhighlight('DE');"/>
			<!-- greece -->
			<area shape="poly" coords="400,405,404,411,400,418,397,425,394,433,403,437,409,442,405,449,406,455,416,457,420,468,427,470,434,472,433,480,424,475,408,465,415,473,412,479,403,481,391,480,386,468,380,471,374,475,379,483,378,490,386,492,392,495,414,494,420,490,424,483,426,491,416,496,415,499,401,503,386,501,384,494,375,488,370,487,361,483,358,474,350,473,344,466,345,455,339,452,329,444,339,446,341,439,344,434,347,432,344,427,351,427,355,422,363,422,365,417,377,413,381,412" href="#GR"  alt="greece"  onclick="return select('GR')" onmouseover="highlight('GR');" onmouseout="unhighlight('GR');"/>
			<!-- lithuania -->
			<area shape="poly" coords="314,216,317,225,322,230,330,229,331,235,334,239,338,240,338,244,347,243,352,237,356,237,355,226,361,219,360,214,352,210,345,209,344,206,341,209,329,209,322,210,317,213" href="#LT" alt="lithuania"  onclick="return select('LT')" onmouseover="highlight('LT');" onmouseout="unhighlight('LT');"/>
			<!-- latvia -->
			<area shape="poly" coords="314,214,322,210,329,208,341,208,344,206,348,209,354,210,359,213,363,211,370,203,363,190,354,186,350,187,342,184,334,188,337,192,338,195,332,200,329,199,323,192,317,194,315,199,313,205" href="#LV" alt="latvia"  onclick="return select('LV')" onmouseover="highlight('LV');" onmouseout="unhighlight('LV');"/>
			<!-- estonia -->
			<area shape="poly" coords="318,191,321,186,327,182,334,187,340,184,345,184,350,186,355,185,359,187,361,182,356,172,355,167,358,161,351,160,339,160,333,163,327,167,319,174,315,176,315,182" href="#EE"  alt="estonia"  onclick="return select('EE')" onmouseover="highlight('EE');" onmouseout="unhighlight('EE');"/>
			<!-- finland -->
			<area shape="poly" coords="320,163,351,147,365,112,365,107,360,102,352,98,354,94,352,90,348,84,345,83,345,78,344,73,343,68,334,58,333,51,336,46,330,41,326,41,323,37,323,33,322,30,322,20,315,17,310,19,308,23,307,28,308,33,305,38,300,38,297,41,291,39,286,34,284,38,286,40,289,44,295,44,299,49,302,57,306,63,306,71,309,78,317,81,315,88,315,96,308,106,304,116,299,116,302,120,300,128,302,135,305,148,305,154,308,160" href="#FI" alt="finland"  onclick="return select('FI')" onmouseover="highlight('FI');" onmouseout="unhighlight('FI');"/>
			<area shape="poly" coords="300,164,295,159,298,156,302,159,304,163" href="FI" alt="finland"  onclick="return select('FI')" onmouseover="highlight('FI');" onmouseout="unhighlight('FI');"/>
			<!-- sweden -->
			<area shape="poly" coords="284,37,280,39,281,45,272,47,272,54,266,55,262,62,264,68,259,79,254,83,256,93,252,101,254,109,248,111,243,117,241,126,242,143,248,149,245,153,247,160,246,166,242,170,242,181,236,181,237,190,241,200,245,210,250,216,247,219,249,222,252,228,254,233,262,233,262,229,264,223,270,221,276,219,280,219,282,202,279,197,278,188,284,182,289,178,293,169,287,157,279,156,277,145,280,131,284,120,295,111,299,100,295,96,298,89,300,85,302,80,309,80,306,67,302,58,296,46,289,45" href="#SE"  alt="sweden"  onclick="return select('SE')" onmouseover="highlight('SE');" onmouseout="unhighlight('SE');"/>
			<area shape="poly" coords="290,209,288,198,297,192,296,197,296,202" href="#SE" alt="sweden"  onclick="return select('SE')" onmouseover="highlight('SE');" onmouseout="unhighlight('SE');"/>
			<!-- norway -->
			<area shape="poly" coords="208,196,218,194,233,180,241,180,240,170,245,166,244,153,246,149,241,144,240,123,245,111,253,107,250,101,253,94,253,82,262,70,262,60,266,53,271,47,280,44,279,38,285,33,295,38,303,36,306,24,314,16,323,19,324,27,331,16,327,7,312,3,300,4,289,12,282,21,273,22,266,31,261,40,257,37,252,43,243,57,256,53,250,66,242,82,241,93,233,98,236,104,227,111,225,118,219,116,216,122,196,137,193,145,193,160,192,180,198,190" href="#NO" alt="norway"  onclick="return select('NO')" onmouseover="highlight('NO');" onmouseout="unhighlight('NO');"/>
		</map>
	
    </div>

	<!-- Results column  -->
	<div id="nas_results" class="nas_column">
		
		<h2 style="margin-top:0px;">
			Progress towards national adaptation strategies (NAS)
		</h2>
		
		<table id="nas-table">
			<colgroup>
				<col style="width: 150px;border:solid #000 1px;" />
				<col style="width: 100px;margin-left:20px;border:solid #000 1px;" />
				<col style="width: 300px;border:solid #000 1px;" />
				<col style="width: 350px;border:solid #000 1px;" />
			</colgroup>
			<thead> 
				<tr id="nas-header"> 
					<th>Countries</th> 
					<th>NAS adopted</th> 
					<th>Assessments</th> 
					<th>Links</th> 
				</tr> 
			</thead> 
			<tbody> 
				<c:forEach var="searchResult" items="${nasResults}" varStatus="loopStatus">
					<c:choose>
						<c:when test="${searchResult.parentNasId > 0}">
							<tr id="country-${searchResult.parentNasId}"class="nas-row ${searchResult.isoCountry}-row nas-region-row">
								<td valign="top">
									<c:out value="${searchResult.name}"/>
								</td> 
								<td valign="top">
									<c:out value="${searchResult.adoptedDescription}"/>
								</td> 
								<td valign="top">
									<c:forEach var="nasSource" items="${nasSourceResults}">
										<ul>
											<c:if test="${nasSource.nasId == searchResult.nasId}">
												<li style="">
													<c:out value="${nasSource.name}"/>
												</li>
											</c:if>
										</ul>
									</c:forEach>
								</td>								
								<td valign="top">
									<c:forEach var="aceItem" items="${aceItemResults}">
										<ul>
											<c:if test="${aceItem.nasId == searchResult.nasId}">
												<li style="">
													<c:choose>
														<c:when test="${aceItem.storagetype == 'PDF-URL'}">
															<img src="<%=renderRequest.getContextPath()%>/images/icons/pdf2.png" alt="PDF document link" title="PDF document link"/>
														</c:when>
														<c:when test="${aceItem.storagetype == 'DOC-URL'}">
															<img src="<%=renderRequest.getContextPath()%>/images/icons/doc.png" alt="Office document link" title="Office document link"/>
														</c:when>
														<c:otherwise>
															<img src="<%=renderRequest.getContextPath()%>/images/icons/link_icon.gif" alt="External link" title="External link"/>
														</c:otherwise>
													</c:choose>												
													<a href="${aceItem.storedAt}" target="_blank">
														<c:out value="${aceItem.name}"/>
													</a>	
												</li>
											</c:if>
										</ul>
									</c:forEach>
								</td>
							</tr>	
						</c:when>
						<c:otherwise>
							<tr id="country-${searchResult.nasId}" class="nas-row ${searchResult.isoCountry}-row">
								<td valign="top">
									<c:out value="${searchResult.name}"/>
								</td> 
								<td valign="top">
									<c:out value="${searchResult.adoptedDescription}"/>
								</td> 
								<td valign="top">
									<c:forEach var="nasSource" items="${nasSourceResults}">
										<ul>
											<c:if test="${nasSource.nasId == searchResult.nasId}">
												<li style="">
													<c:out value="${nasSource.name}"/>
												</li>
											</c:if>
										</ul>
									</c:forEach>
								</td>								
								<td valign="top">
									<c:forEach var="aceItem" items="${aceItemResults}">
										<ul>
											<c:if test="${aceItem.nasId == searchResult.nasId}">
												<li style="">
													<c:choose>
														<c:when test="${aceItem.storagetype == 'PDF-URL'}">
															<img src="<%=renderRequest.getContextPath()%>/images/icons/pdf2.png" alt="PDF document link" title="PDF document link"/>
														</c:when>
														<c:when test="${aceItem.storagetype == 'DOC-URL'}">
															<img src="<%=renderRequest.getContextPath()%>/images/icons/doc.png" alt="Office document link" title="Office document link"/>
														</c:when>
														<c:otherwise>
															<img src="<%=renderRequest.getContextPath()%>/images/icons/link_icon.gif" alt="External link" title="External link"/>
														</c:otherwise>
													</c:choose>	
													<a href="${aceItem.storedAt}" target="_blank">
														<c:out value="${aceItem.name}"/>
													</a>														
												</li>
											</c:if>
										</ul>
									</c:forEach>
								</td>								
							</tr>							
						</c:otherwise>
					</c:choose>			
				</c:forEach>
			</tbody> 
		</table>	
		
	</div>
	
	<hr class="clearer"/>

</div>