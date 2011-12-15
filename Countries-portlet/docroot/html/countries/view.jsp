<%@ page import="java.util.Arrays" %>

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

<%@include file="/html/init.jsp" %>

<div id="countries_container">

<%-- TODO move to js file --%>
<script type="text/javascript">

	// ENABLE THIS WHEN RUNNING STANDALONE (WITHOUT REST OF ACE)
	var $j = jQuery.noConflict();
	
	$j(document).ready(function() {
		sortCountries();
		$j('#country-selection-list').change(function() {select(this.value);});	
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
	
	var countries = ['AT', 'BE', 'BG', 'CH', 'CY', 'CZ', 'DE', 'DK', 'EE', 'ES', 'FI', 'FR', 'GB', 'GR', 'HU', 'IR', 'IT', 'IS', 'LT', 'LI', 'LV', 'LU', 'MT', 'NL', 'NO', 'PL', 'PT', 'RO', 'SE', 'SI', 'SK', 'TR'];
	
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
			$j('#country-selection-list').value = area;
			$j('#' + area + '-option').attr("selected", true);

			document.location.href = '/countries/' + document.getElementById(area + '-option').innerHTML.toLowerCase().replace(' ','-') ;
		}		
		return false;
	}
	
	
</script>

<div id="<portlet:namespace/>content"></div>

    <!-- Map colum -->
    <div id="nas_left_column" class="nas_column">

		<img id="europe_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/europe.png" width="500" height="375" border="0" usemap="#Map" style="display:block;"/>
		<img id="AT_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/AT.png" width="500" height="375" border="0" usemap="#Map" style="display:none;"/>
		<img id="BE_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/BE.png" width="500" height="375" border="0" usemap="#Map" style="display:none;" />
		<img id="BG_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/BG.png" width="500" height="375" border="0" usemap="#Map" style="display:none;" />
		<img id="CH_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/CH.png" width="500" height="375" border="0" usemap="#Map" style="display:none;" />
		<img id="CY_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/CY.png" width="500" height="375" border="0" usemap="#Map" style="display:none;" />
		<img id="CZ_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/CZ.png" width="500" height="375" border="0" usemap="#Map" style="display:none;" />
		<img id="DE_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/DE.png" width="500" height="375" border="0" usemap="#Map" style="display:none;"/>
		<img id="DK_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/DK.png" width="500" height="375" border="0" usemap="#Map" style="display:none;"/>
		<img id="EE_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/EE.png" width="500" height="375" border="0" usemap="#Map" style="display:none;"/>
		<img id="ES_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/ES.png" width="500" height="375" border="0" usemap="#Map" style="display:none;"/>
		<img id="FI_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/FI.png" width="500" height="375" border="0" usemap="#Map" style="display:none;"/>
		<img id="FR_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/FR.png" width="500" height="375" border="0" usemap="#Map" style="display:none;"/>
		<img id="GB_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/GB.png" width="500" height="375" border="0" usemap="#Map" style="display:none;"/>
		<img id="GR_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/GR.png" width="500" height="375" border="0" usemap="#Map" style="display:none;"/>
		<img id="HU_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/HU.png" width="500" height="375" border="0" usemap="#Map" style="display:none;"/>
		<img id="IR_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/IR.png" width="500" height="375" border="0" usemap="#Map" style="display:none;"/>
		<img id="IS_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/IS.png" width="500" height="375" border="0" usemap="#Map" style="display:none;"/>
		<img id="IT_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/IT.png" width="500" height="375" border="0" usemap="#Map" style="display:none;"/>
		<img id="LT_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/LT.png" width="500" height="375" border="0" usemap="#Map" style="display:none;"/>
		<img id="LU_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/LU.png" width="500" height="375" border="0" usemap="#Map" style="display:none;"/>
		<img id="LV_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/LV.png" width="500" height="375" border="0" usemap="#Map" style="display:none;"/>
		<img id="MT_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/MT.png" width="500" height="375" border="0" usemap="#Map" style="display:none;"/>
		<img id="NL_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/NL.png" width="500" height="375" border="0" usemap="#Map" style="display:none;"/>
		<img id="NO_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/NO.png" width="500" height="375" border="0" usemap="#Map" style="display:none;"/>
		<img id="PL_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/PL.png" width="500" height="375" border="0" usemap="#Map" style="display:none;"/>
		<img id="PT_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/PT.png" width="500" height="375" border="0" usemap="#Map" style="display:none;"/>
		<img id="RO_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/RO.png" width="500" height="375" border="0" usemap="#Map" style="display:none;"/>
		<img id="SE_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/SE.png" width="500" height="375" border="0" usemap="#Map" style="display:none;"/>
		<img id="SI_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/SI.png" width="500" height="375" border="0" usemap="#Map" style="display:none;"/>
		<img id="SK_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/SK.png" width="500" height="375" border="0" usemap="#Map" style="display:none;"/>
	
		<p>
		<select id="country-selection-list"  style="margin-top:5px;">
			<option id="no-selection-option" value="" selected="selected">Choose a country </option>
			<option id="AT-option" value="AT">Austria</option>
			<option id="BE-option" value="BE">Belgium</option>
			<option id="BG-option" value="BG">Bulgaria</option>
			<option id="CH-option" value="CH">Switzerland</option>
			<option id="CY-option" value="CY">Cyprus</option>
			<option id="CZ-option" value="CZ">Czech Republic</option>
			<option id="DE-option" value="DE">Germany</option>
			<option id="DK-option" value="DK">Denmark</option>
			<option id="EE-option" value="EE">Estonia</option>
			<option id="ES-option" value="ES">Spain</option>
			<option id="FI-option" value="FI">Finland</option>
			<option id="FR-option" value="FR">France</option>
			<option id="GB-option" value="GB">United Kingdom</option>
			<option id="GR-option" value="GR">Greece</option>
			<option id="HU-option" value="HU">Hungary</option>
			<option id="IR-option" value="IR">Ireland</option>
			<option id="IS-option" value="IS">Iceland</option>
			<option id="IT-option" value="IT">Italy</option>
			<option id="LI-option" value="LI">Liechtenstein</option>
			<option id="LT-option" value="LT">Lithuania</option>
			<option id="LV-option" value="LV">Latvia</option>
			<option id="LU-option" value="LU">Luxembourg</option>
			<option id="MT-option" value="MT">Malta</option>
			<option id="NL-option" value="NL">Netherlands</option>
			<option id="NO-option" value="NO">Norway</option>
			<option id="PL-option" value="PL">Poland</option>
			<option id="PT-option" value="PT">Portugal</option>
			<option id="RO-option" value="RO">Romania</option>
			<option id="SE-option" value="SE">Sweden</option>
			<option id="SI-option" value="SI">Slovenia</option>
			<option id="SK-option" value="SK">Slovakia</option>
			<option id="TR-option" value="TR">Turkey</option>
		</select>
		</p>
		<map name="Map" id="country-selection-map">
<!-- austria -->
<area shape="poly" coords="273,249,278,250,280,249,282,250,294,246,294,243,299,239,302,237,306,237,309,233,311,233,315,235,320,235,320,237,324,243,320,244,319,249,319,255,308,259,302,259,292,258,284,255,283,256,278,256,273,254,271,251" href="#AT" alt="austria"  onclick="return select('AT')" onmouseover="highlight('AT');" onmouseout="unhighlight('AT');" />
<!-- belgium -->
<area shape="poly" coords="227,210,235,206,243,208,249,214,252,220,248,224,249,229,244,229,236,223,231,217" href="#BE" alt="belgium" onclick="return select('BE')" onmouseover="highlight('BE');" onmouseout="unhighlight('BE');"/>
<!-- bulgaria -->
<area shape="poly" coords="367,276,368,283,371,286,369,289,369,295,373,301,382,298,395,297,396,293,399,294,403,291,407,290,411,290,407,284,408,277,412,271,399,269,390,276,385,277,369,278" href="#BG" alt="bulgaria" onclick="return select('BG')" onmouseover="highlight('BG');" onmouseout="unhighlight('BG');"/>
<!-- cyprus -->
<area shape="poly" coords="458,347,465,342,469,341,476,336,479,338,475,343,476,348,471,350,466,353,459,351" onclick="return select('CY')" onmouseover="highlight('CY');" onmouseout="unhighlight('CY');" />
<!-- czech republic -->
<area shape="poly" coords="304,212,317,215,316,217,319,220,320,216,325,218,327,221,336,225,320,235,312,234,310,232,306,237,302,236,293,229,292,224,290,221" href="#CZ" alt="czech republic"  onclick="return select('CZ')" onmouseover="highlight('CZ');" onmouseout="unhighlight('CZ');"/>
<!-- denmark -->
<area shape="poly" coords="264,177,274,173,278,176,288,177,288,176,289,168,288,161,282,162,279,165,275,165,281,158,277,152,282,151,278,144,273,148,264,151,263,159,264,169" href="#DK" alt="denmark"  onclick="return select('DK')" onmouseover="highlight('DK');" onmouseout="unhighlight('DK');"/>
<!-- estonia -->
<area shape="poly" coords="366,116,353,117,342,124,336,126,338,132,340,138,347,132,355,134,359,133,367,135,371,131,369,119" href="#EE"  alt="estonia"  onclick="return select('EE')" onmouseover="highlight('EE');" onmouseout="unhighlight('EE');"/>
<!-- finland -->
<area shape="poly" coords="315,28,322,32,327,37,331,45,331,51,334,57,339,58,339,64,337,71,329,84,326,84,327,88,330,102,331,115,337,117,348,116,364,105,376,76,366,71,366,65,359,57,358,50,352,40,354,34,348,30,343,27,344,21,349,11,343,12,343,13,339,13,337,11,331,16,333,19,333,25,328,29,320,30,317,25" href="FI" alt="finland"  onclick="return select('FI')" onmouseover="highlight('FI');" onmouseout="unhighlight('FI');"/>
<!-- france -->
<area shape="poly" coords="188,283,200,294,209,293,212,296,214,297,223,298,224,293,232,288,237,290,244,293,251,293,256,289,257,284,253,276,251,273,254,272,254,265,250,260,247,262,247,259,255,249,261,247,259,245,260,241,262,236,256,231,250,229,243,228,239,223,234,218,227,212,224,211,220,214,219,219,215,220,208,223,209,226,202,224,202,220,195,220,195,225,197,230,190,228,185,227,174,228,177,236,183,241,187,244,190,249,193,258,193,267,192,276" href="#FR" alt="france"  onclick="return select('FR')" onmouseover="highlight('FR');" onmouseout="unhighlight('FR');"/>
<area shape="poly" coords="269,295,264,299,264,308,267,312,270,311,273,301,271,294" href="#FR" alt="france"  onclick="return select('FR')" onmouseover="highlight('FR');" onmouseout="unhighlight('FR');"/>
<!-- germany -->
<area shape="poly" coords="250,222,252,230,257,231,262,236,258,246,263,247,269,247,273,248,284,249,294,246,295,242,301,236,293,229,291,221,304,211,301,194,301,186,295,176,289,179,283,181,283,178,277,178,273,174,268,174,268,180,266,185,260,185,255,186,259,190,254,205,251,205,251,210,248,212,251,216" href="#DE"  alt="germany"  onclick="return select('DE')" onmouseover="highlight('DE');" onmouseout="unhighlight('DE');"/>
<!-- great britain -->
<area shape="poly" coords="174,130,177,141,179,146,180,154,180,159,169,166,174,169,178,172,184,170,186,168,187,175,194,174,194,178,193,182,189,179,185,181,184,186,186,191,180,193,179,198,187,202,169,211,180,215,189,213,219,212,220,208,219,203,225,197,225,190,217,189,216,178,210,168,209,161,205,153,212,142,201,137,209,130,220,118,221,109,215,116,211,123,201,128,190,127,179,130" href="#GB" alt="great britain"  onclick="return select('GB')" onmouseover="highlight('GB');" onmouseout="unhighlight('GB');"/>
<!-- greece -->
<area shape="poly" coords="348,321,355,321,359,310,366,306,372,305,375,301,384,298,396,298,396,294,400,295,403,299,399,306,398,312,405,317,407,322,406,330,412,332,413,339,427,342,423,351,419,358,412,363,400,367,392,368,376,356,368,353,366,345,361,344,355,337,357,331" href="#GR"  alt="greece"  onclick="return select('GR')" onmouseover="highlight('GR');" onmouseout="unhighlight('GR');"/>
<!-- hungary -->
<area shape="poly" coords="321,245,320,255,329,265,338,265,344,259,349,258,356,252,359,242,363,236,357,234,348,233,345,237,337,240,335,243,327,242,324,244" href="#HU" alt="hungary"  onclick="return select('HU')" onmouseover="highlight('HU');" onmouseout="unhighlight('HU');"/>
<!-- iceland -->
<area shape="poly" coords="133,27,146,22,152,31,166,34,175,35,177,43,180,49,178,56,169,63,144,63,138,55,131,51,132,43,131,33" href="#IS" alt="iceland"  onclick="return select('IS')" onmouseover="highlight('IS');" onmouseout="unhighlight('IS');"/>
<!-- ireland -->
<area shape="poly" coords="180,159,174,157,165,160,167,164,165,165,157,163,155,168,154,172,159,178,153,180,147,182,149,193,154,194,176,190,179,178,178,171,175,168,173,169,168,166,174,162" href="#IR" alt="ireland"  onclick="return select('IR')" onmouseover="highlight('IR');" onmouseout="unhighlight('IR');"/>
<!-- italy -->
<area shape="poly" coords="253,266,261,267,265,260,268,268,270,260,276,263,276,259,280,259,279,256,295,258,300,264,300,268,292,272,294,275,292,279,303,289,306,298,316,303,322,304,321,309,344,319,342,324,329,319,328,324,332,328,332,336,324,347,319,347,320,359,308,355,299,351,292,348,299,343,304,343,312,343,317,339,321,334,320,328,300,313,294,314,284,304,278,296,276,288,267,283,265,285,260,288,256,284,254,280,254,276,252,273,255,273" href="#IT" alt="italy"  onclick="return select('IT')" onmouseover="highlight('IT');" onmouseout="unhighlight('IT');"/>
<area shape="poly" coords="262,312,272,313,274,322,274,334,267,338,262,336,259,318" href="#IT" alt="italy"  onclick="return select('IT')" onmouseover="highlight('IT');" onmouseout="unhighlight('IT');"/>
<!-- lithuania -->
<area shape="poly" coords="337,157,339,167,347,166,350,168,350,173,353,173,356,177,361,176,366,172,369,171,366,164,373,160,370,155,359,149,347,152,340,153" href="#LT" alt="lithuania"  onclick="return select('LT')" onmouseover="highlight('LT');" onmouseout="unhighlight('LT');"/>
<!-- latvia -->
<area shape="poly" coords="352,134,357,133,363,135,366,136,370,135,377,147,376,152,371,155,359,150,350,151,341,154,338,154,334,145,336,142,342,139,345,141,351,145,353,143" href="#LV" alt="latvia"  onclick="return select('LV')" onmouseover="highlight('LV');" onmouseout="unhighlight('LV');"/>
<!-- luxembourg -->
<area shape="poly" coords="247,222,251,222,252,226,253,230,248,229,245,225"  href="#LU" alt="luxembourg"  onclick="return select('LU')" onmouseover="highlight('LU');" onmouseout="unhighlight('LU');"/>					
<!-- malta -->
<area shape="poly" coords="309,362,313,363,315,368,310,368,308,365" href="#MT" alt="malta"  onclick="return select('MT')" onmouseover="highlight('MT');" onmouseout="unhighlight('MT');"/>					
<!-- netherlands -->
<area shape="poly" coords="235,205,241,207,248,213,251,210,250,205,255,205,257,200,257,196,259,190,245,187"  href="#NL" alt="netherlands"  onclick="return select('NL')" onmouseover="highlight('NL');" onmouseout="unhighlight('NL');"/>
<!-- norway -->
<area shape="poly" coords="284,133,284,123,288,122,288,114,286,110,289,110,287,105,285,97,286,84,290,81,294,81,294,77,292,75,296,63,294,60,298,58,300,47,301,41,305,39,306,35,312,34,314,27,316,24,320,28,326,29,330,28,333,24,332,15,338,12,343,15,344,10,348,6,332,2,324,3,316,10,305,18,295,26,287,39,291,41,294,40,290,48,283,63,279,70,272,84,267,84,263,90,251,98,249,103,249,130,250,135,257,143,264,143,273,134,278,131" href="#NO" alt="norway"  onclick="return select('NO')" onmouseover="highlight('NO');" onmouseout="unhighlight('NO');"/>
<!-- poland -->
<area shape="poly" coords="302,182,301,194,305,208,307,213,317,215,316,218,319,221,321,216,327,218,327,221,331,222,335,225,337,225,339,226,343,226,349,224,353,223,358,226,360,226,359,220,366,211,366,206,360,200,361,195,357,192,361,188,356,176,353,173,350,173,332,175,328,173,322,171,312,176" href="#PL" alt="poland"  onclick="return select('PL')" onmouseover="highlight('PL');" onmouseout="unhighlight('PL');"/>		
<!-- portugal -->
<area shape="poly" coords="131,288,138,287,139,291,150,291,152,296,147,302,144,315,139,314,140,318,142,321,138,326,140,329,135,334,134,339,119,338,123,323,119,319,125,310,130,300" href="#PT" alt="portugal" onclick="return select('PT')" onmouseover="highlight('PT');" onmouseout="unhighlight('PT');"/>
<area shape="poly" coords="43,355,43,360,48,364,55,356" href="#PT" alt="portugal" onclick="return select('PT')" onmouseover="highlight('PT');" onmouseout="unhighlight('PT');"/>
<!-- romania -->
<area shape="poly" coords="364,235,378,234,388,228,392,231,403,243,404,252,406,255,409,254,413,250,416,251,416,256,412,262,411,272,399,269,390,276,382,278,370,278,366,272,357,271,356,266,352,263,348,258,350,258,355,252,359,240" href="#RO" alt="romania"  onclick="return select('RO')" onmouseover="highlight('RO');" onmouseout="unhighlight('RO');"/>
<!-- spain -->
<area shape="poly" coords="133,287,132,280,132,275,142,271,148,271,152,274,167,278,176,279,185,283,189,285,196,291,201,294,206,294,210,295,211,298,215,299,220,299,225,298,226,304,216,310,207,311,205,315,195,325,195,328,199,332,197,336,190,343,190,345,183,345,179,348,176,352,158,349,152,350,149,353,144,353,141,345,137,339,135,338,137,329,138,329,143,321,140,314,144,315,148,300,153,296,151,291,141,290,136,288" href="#ES" alt="spain"  onclick="return select('ES')" onmouseover="highlight('ES');" onmouseout="unhighlight('ES');"/>
<area shape="poly" coords="229,321,218,322,204,330,204,336,207,338,222,332,231,327,231,323" href="#ES" alt="spain"  onclick="return select('ES')" onmouseover="highlight('ES');" onmouseout="unhighlight('ES');"/>
<!-- slovakia -->
<area shape="poly" coords="324,242,320,237,324,233,330,229,338,225,341,227,347,225,355,223,359,226,362,227,358,229,357,234,350,233,346,235,343,238,335,240,334,243,324,242" href="#SK" alt="slovakia"  onclick="return select('SK')" onmouseover="highlight('SK');" onmouseout="unhighlight('SK');"/>
<!-- slovenia -->
<area shape="poly" coords="299,259,301,269,313,270,317,263,323,258,319,256,310,258" href="#SI" alt="slovenia"  onclick="return select('SI')" onmouseover="highlight('SI');" onmouseout="unhighlight('SI');"/>
<!-- sweden -->
<area shape="poly" coords="282,133,283,143,289,156,289,162,292,168,297,168,304,172,301,163,310,159,321,152,326,139,319,145,314,147,312,138,315,132,322,122,319,114,313,112,313,95,323,81,327,72,325,67,327,60,334,57,331,51,330,42,320,31,314,29,312,34,307,36,304,39,301,41,295,59,296,63,293,74,294,82,289,83,286,85,286,100,289,109,288,121,285,123" href="#SE" alt="sweden"  onclick="return select('SE')" onmouseover="highlight('SE');" onmouseout="unhighlight('SE');"/>
<!-- switzerland -->
<area shape="poly" coords="254,249,247,261,247,262,250,260,252,262,253,265,260,266,264,260,268,268,271,261,276,263,276,258,279,259,278,256,272,253,271,248,265,247,257,248" href="#CH"alt="switzerland"  onclick="return select('CH')" onmouseover="highlight('CH');" onmouseout="unhighlight('CH');" />
		</map>
	
    </div>
</div>