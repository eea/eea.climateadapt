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
* details.x
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
	
	var countries = ['AT', 'BE', 'BG', 'CH', 'CY', 'CZ', 'DE', 'DK', 'EE', 'ES', 'FI', 'FR', 'GB', 'GR', 'HU', 'IE', 'IT', 'IS', 'LT', 'LI', 'LV', 'LU', 'MT', 'NL', 'NO', 'PL', 'PT', 'RO', 'SE', 'SI', 'SK', 'TR'];
	
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

<div id="<portlet:namespace/>content">

    <!-- Map area; height = image height + 10 -->
    <div id="nas_left_column" class="nas_column" style="height: 385px">

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
		<img id="IE_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/IE.png" width="500" height="375" border="0" usemap="#Map" style="display:none;"/>
		<img id="IS_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/IS.png" width="500" height="375" border="0" usemap="#Map" style="display:none;"/>
		<img id="IT_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/IT.png" width="500" height="375" border="0" usemap="#Map" style="display:none;"/>
		<img id="LI_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/LI.png" width="500" height="375" border="0" usemap="#Map" style="display:none;"/>
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
		<img id="TR_selected" src="<%=renderRequest.getContextPath()%>/images/countryselectionmap/TR.png" width="500" height="375" border="0" usemap="#Map" style="display:none;"/>
	
		<!--  <p>
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
			<option id="IE-option" value="IE">Ireland</option>
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
		</p> -->
		<map name="Map" id="country-selection-map">
<!-- austria -->
<area shape="poly" coords="228,245,228,248,235,251,234,253,237,253,246,250,248,254,255,255,260,255,264,254,274,250,275,240,277,240,278,240,276,235,276,231,272,231,266,229,265,230,264,232,261,234,257,233,255,234,251,238,250,242,251,245,250,246,247,244,237,247,234,245,232,246,229,245,228,245"  href="#AT" alt="austria"  onclick="return select('AT')" onmouseover="highlight('AT');" onmouseout="unhighlight('AT');" />
<!-- belgium -->
<area shape="poly" coords="185,206,193,203,195,206,199,205,206,209,205,212,207,213,209,217,205,219,204,220,203,225,199,222,199,218,195,221,194,217,186,210,184,206" href="#BE" alt="belgium" onclick="return select('BE')" onmouseover="highlight('BE');" onmouseout="unhighlight('BE');"/>
<!-- bulgaria -->
<area shape="poly" coords="363,267,357,265,348,265,344,270,342,272,333,272,329,274,323,273,321,270,318,272,321,280,324,281,322,284,322,290,326,295,326,299,337,295,339,293,347,295,351,293,350,289,356,284,359,285,361,286,363,283,359,279,361,277,360,270,364,270,363,267"href="#BG" alt="bulgaria" onclick="return select('BG')" onmouseover="highlight('BG');" onmouseout="unhighlight('BG');"/>
<!-- cyprus -->
<area shape="poly" coords="427,328,420,334,411,337,409,344,415,348,422,344,426,339,425,334,428,331,427,328" onclick="return select('CY')" onmouseover="highlight('CY');" onmouseout="unhighlight('CY');" />
<!-- czech republic -->
<area shape="poly" coords="261,210,272,213,271,215,274,219,275,215,283,218,289,222,284,225,282,230,277,231,272,232,267,230,265,230,264,233,261,235,257,233,249,226,246,221,245,218,251,215,259,211,262,209" href="#CZ" alt="czech republic"  onclick="return select('CZ')" onmouseover="highlight('CZ');" onmouseout="unhighlight('CZ');"/>
<!-- denmark -->
<area shape="poly" coords="235,143,227,147,226,149,222,149,219,166,222,173,231,173,235,175,243,176,247,171,246,164,245,157,239,161,234,161,237,158,243,154,237,153,239,148,235,147" href="#DK" alt="denmark"  onclick="return select('DK')" onmouseover="highlight('DK');" onmouseout="unhighlight('DK');"/>
<!-- estonia -->
<area shape="poly" coords="304,133,301,130,299,132,294,138,292,138,292,130,293,129,293,126,295,124,298,124,307,116,324,115,322,120,320,124,324,130,324,134,318,136,311,131,307,133,304,133" href="#EE"  alt="estonia"  onclick="return select('EE')" onmouseover="highlight('EE');" onmouseout="unhighlight('EE');"/>
<!-- finland -->
<area shape="poly" coords="270,30,275,35,278,35,281,40,287,50,286,54,288,59,292,61,293,64,292,68,282,84,280,86,281,89,282,97,284,103,286,115,298,119,319,106,328,85,327,77,320,73,320,69,317,66,317,62,313,61,313,53,305,42,306,36,301,30,299,25,301,20,297,17,289,18,288,28,287,31,278,33,274,28,269,30" href="FI" alt="finland"  onclick="return select('FI')" onmouseover="highlight('FI');" onmouseout="unhighlight('FI');"/>
<!-- france -->
<area shape="poly" coords="182,294,172,292,171,289,169,289,166,288,158,288,153,286,146,279,149,275,153,257,151,252,149,248,147,248,147,244,146,240,143,242,142,237,132,233,132,225,147,222,149,226,155,226,148,220,150,217,154,222,154,216,161,217,161,219,166,222,166,218,176,216,178,208,184,207,186,211,194,217,194,221,200,218,199,222,204,225,208,226,212,230,220,231,216,238,215,244,211,247,205,254,206,257,208,255,209,261,212,266,207,269,208,272,210,272,209,277,213,279,211,283,208,289,200,289,197,286,188,284,184,285,181,289,182,292" href="#FR" alt="france"  onclick="return select('FR')" onmouseover="highlight('FR');" onmouseout="unhighlight('FR');"/>
<area shape="poly" coords="228,289,222,293,219,297,223,306,228,307,229,301,230,293,228,288" href="#FR" alt="france"  onclick="return select('FR')" onmouseover="highlight('FR');" onmouseout="unhighlight('FR');"/>
<!-- germany -->
<area shape="poly" coords="214,184,221,182,225,182,222,175,222,172,232,173,233,176,236,177,239,176,239,178,237,181,239,181,251,173,257,180,258,193,256,194,258,196,260,206,262,207,262,210,245,217,249,227,256,234,251,238,251,240,250,243,252,244,251,246,247,244,237,246,235,245,232,246,229,245,223,244,222,242,218,243,214,244,215,237,220,230,212,229,208,225,210,223,208,218,209,216,205,211,205,208,208,207,208,202,213,201,215,198,214,195,216,186,214,183" href="#DE"  alt="germany"  onclick="return select('DE')" onmouseover="highlight('DE');" onmouseout="unhighlight('DE');"/>
<!-- great britain -->
<area shape="poly" coords="178,109,172,114,173,119,167,122,163,121,161,128,156,126,144,126,134,130,135,141,137,144,136,158,135,161,129,163,131,168,133,167,133,165,136,167,136,168,138,169,137,171,138,171,143,167,145,166,146,170,148,173,151,170,150,167,152,167,153,177,152,179,145,178,142,184,145,187,146,188,137,192,138,198,142,198,138,201,140,202,126,211,127,212,137,212,140,210,146,213,149,208,155,211,172,211,180,206,178,202,176,202,177,200,183,195,181,187,177,186,176,183,172,169,168,167,168,163,169,159,164,155,164,150,171,140,166,137,161,136,166,130,168,126,172,122,177,119,181,110,180,109" href="#GB" alt="great britain"  onclick="return select('GB')" onmouseover="highlight('GB');" onmouseout="unhighlight('GB');"/>
<!-- greece -->
<area shape="poly" coords="325,299,314,305,310,313,305,317,312,325,311,332,317,339,319,336,322,339,322,344,327,346,328,345,331,348,333,345,341,359,349,361,365,352,377,344,377,335,367,333,359,321,359,314,351,309,353,301,352,298,353,294,355,290,351,290,351,293,346,294,340,293,337,295,325,299" href="#GR"  alt="greece"  onclick="return select('GR')" onmouseover="highlight('GR');" onmouseout="unhighlight('GR');"/>
<!-- hungary -->
<area shape="poly" coords="280,239,277,241,275,240,274,249,275,254,284,260,291,260,295,257,301,255,307,252,309,248,312,236,317,233,314,231,312,229,310,230,303,229,299,232,299,235,297,235,293,235,292,236,290,239,285,241,284,241,279,240,277,241,275,240" href="#HU" alt="hungary"  onclick="return select('HU')" onmouseover="highlight('HU');" onmouseout="unhighlight('HU');"/>
<!-- iceland -->
<area shape="poly" coords="107,26,93,32,97,38,100,38,99,39,93,37,91,41,97,44,96,48,91,49,92,53,97,55,103,63,114,65,130,62,138,54,135,46,136,40,128,36,125,38,117,35,111,33,108,27" href="#IS" alt="iceland"  onclick="return select('IS')" onmouseover="highlight('IS');" onmouseout="unhighlight('IS');"/>
<!-- ireland -->
<area shape="poly" coords="137,156,135,160,129,163,131,168,133,167,134,166,135,166,136,169,138,170,137,173,137,176,138,182,135,186,133,189,127,189,120,191,109,193,107,181,111,178,115,176,112,170,116,161,122,161,125,163,126,157,131,155" href="#IE" alt="ireland"  onclick="return select('IE')" onmouseover="highlight('IE');" onmouseout="unhighlight('IE');"/>
<!-- italy -->
<area shape="poly" coords="211,283,218,281,223,276,232,281,235,290,231,292,232,295,234,298,235,296,233,294,236,292,239,295,237,297,242,298,253,307,253,311,255,312,255,308,258,307,260,310,259,312,264,315,266,313,273,320,277,328,270,329,271,332,268,331,267,336,260,337,258,335,257,329,255,331,256,335,246,338,248,342,250,343,266,351,273,353,275,347,273,343,273,339,280,339,286,332,284,329,287,328,287,321,281,319,284,313,291,315,291,318,296,319,297,313,290,307,277,303,277,299,276,297,271,298,261,291,256,281,249,277,248,273,251,272,248,268,251,264,255,264,255,255,248,254,246,250,238,252,234,254,232,255,232,258,228,258,226,258,225,261,225,262,223,263,220,256,217,260,210,260,210,261,211,266,208,269,208,272,210,272,209,277,213,278,212,280,211,281,211,283" href="#IT" alt="italy"  onclick="return select('IT')" onmouseover="highlight('IT');" onmouseout="unhighlight('IT');"/>
<area shape="poly" coords="219,307,219,307,229,308,232,315,229,327,227,330,223,329,218,331,216,329,218,325,218,315,217,313,217,306" href="#IT" alt="italy"  onclick="return select('IT')" onmouseover="highlight('IT');" onmouseout="unhighlight('IT');"/>
<!-- lithuania -->
<area shape="poly" coords="293,155,301,151,310,150,312,148,316,151,324,155,326,158,321,164,323,170,317,171,316,175,312,175,310,175,307,171,302,171,303,167,300,165,295,163,292,159,292,156" href="#LT" alt="lithuania"  onclick="return select('LT')" onmouseover="highlight('LT');" onmouseout="unhighlight('LT');"/>
<!-- latvia -->
<area shape="poly" coords="291,153,291,147,291,144,294,141,298,137,300,140,304,145,307,142,306,134,311,132,317,136,321,136,324,135,327,138,331,147,327,152,324,154,315,151,313,148,309,150,301,151,293,155,290,156,290,155" href="#LV" alt="latvia"  onclick="return select('LV')" onmouseover="highlight('LV');" onmouseout="unhighlight('LV');"/>
<!-- liechtenstein -->
<area shape="poly" coords="228,249,232,254,236,254,234,250,229,249"  href="#LI" alt="liechtenstein"  onclick="return select('LI')" onmouseover="highlight('LI');" onmouseout="unhighlight('LI');"/>					
<!-- luxembourg -->
<area shape="poly" coords="207,218,205,219,203,224,205,226,208,226,210,223,208,219,207,218" href="#LU" alt="luxembourg"  onclick="return select('LU')" onmouseover="highlight('LU');" onmouseout="unhighlight('LU');"/>					
<!-- malta -->
<area shape="poly" coords="263,354,264,359,269,362,271,359,268,356,263,354" href="#MT" alt="malta"  onclick="return select('MT')" onmouseover="highlight('MT');" onmouseout="unhighlight('MT');"/>					
<!-- netherlands -->
<area shape="poly" coords="193,200,195,206,199,205,206,209,208,207,208,202,212,201,215,198,213,195,214,191,215,186,214,183,205,187,201,185,199,188,198,193,198,197,193,200" href="#NL" alt="netherlands"  onclick="return select('NL')" onmouseover="highlight('NL');" onmouseout="unhighlight('NL');"/>
<!-- norway -->
<area shape="poly" coords="240,132,241,123,245,120,242,111,244,110,245,107,242,103,242,99,240,88,245,81,248,82,250,80,247,76,250,70,251,60,256,51,257,47,259,41,262,41,262,38,269,38,269,31,273,27,277,33,286,32,289,26,288,18,297,17,301,20,300,13,303,10,299,7,288,3,275,8,267,17,261,18,259,24,245,35,246,38,238,43,241,46,249,42,246,48,239,61,239,64,236,66,239,70,236,71,233,73,233,77,227,84,223,83,218,89,212,95,206,98,205,135,216,143,222,142,230,136,233,132,236,131,239,133,239,132" href="#NO" alt="norway"  onclick="return select('NO')" onmouseover="highlight('NO');" onmouseout="unhighlight('NO');"/>
<!-- poland -->
<area shape="poly" coords="257,179,257,192,256,194,259,196,259,200,260,206,263,207,262,210,272,213,271,216,274,218,275,214,280,216,284,218,287,221,289,223,293,220,294,224,302,222,310,221,310,223,315,223,312,217,321,206,318,201,315,197,314,190,311,190,313,188,316,185,310,175,307,172,304,171,299,172,288,172,284,174,281,174,281,171,279,169,266,175,263,177" href="#PL" alt="poland"  onclick="return select('PL')" onmouseover="highlight('PL');" onmouseout="unhighlight('PL');"/>		
<!-- portugal -->
<area shape="poly" coords="93,282,97,282,100,286,112,287,113,290,107,296,104,309,100,310,101,317,100,318,99,325,96,327,94,332,89,333,80,330,85,317,82,315,80,312,85,305,92,292,92,282" href="#PT" alt="portugal" onclick="return select('PT')" onmouseover="highlight('PT');" onmouseout="unhighlight('PT');"/>
<area shape="poly" coords="6,347,11,350,15,347,17,350,9,354,4,349,6,346" href="#PT" alt="portugal" onclick="return select('PT')" onmouseover="highlight('PT');" onmouseout="unhighlight('PT');"/>
<!-- romania -->
<area shape="poly" coords="318,233,312,236,308,251,301,255,305,258,307,261,312,263,310,265,317,268,319,266,321,269,324,273,332,273,335,272,342,272,345,271,345,267,351,265,357,265,363,267,363,257,364,254,366,255,368,253,368,247,360,252,357,251,354,244,355,240,344,229,345,226,341,224,337,228,330,234,328,231,317,233" href="#RO" alt="romania"  onclick="return select('RO')" onmouseover="highlight('RO');" onmouseout="unhighlight('RO');"/>
<!-- spain -->
<area shape="poly" coords="93,282,91,271,94,269,100,269,104,265,111,270,120,271,128,275,137,276,145,279,148,282,154,286,160,288,165,288,167,288,169,294,172,293,181,294,182,297,180,301,175,304,173,306,165,306,164,309,153,319,154,323,158,328,150,332,148,338,142,339,135,346,120,343,112,345,108,347,102,344,100,336,94,331,95,327,100,324,99,318,102,316,100,309,103,309,108,296,113,291,112,287,105,286,100,285,97,282" href="#ES" alt="spain"  onclick="return select('ES')" onmouseover="highlight('ES');" onmouseout="unhighlight('ES');"/>
<area shape="poly" coords="162,324,162,324,176,316,188,316,190,320,187,322,184,319,179,325,174,324,173,322,167,327,167,331,162,330,162,324" href="#ES" alt="spain"  onclick="return select('ES')" onmouseover="highlight('ES');" onmouseout="unhighlight('ES');"/>
<!-- slovakia -->
<area shape="poly" coords="276,231,276,235,279,239,283,241,290,239,293,235,296,235,299,234,300,231,302,229,308,230,312,230,314,222,310,222,310,221,299,222,294,224,293,220,290,222,288,223,282,228,280,230,275,231" href="#SK" alt="slovakia"  onclick="return select('SK')" onmouseover="highlight('SK');" onmouseout="unhighlight('SK');"/>
<!-- slovenia -->
<area shape="poly" coords="256,255,255,260,255,265,264,265,269,265,269,262,271,261,271,258,275,255,274,250,271,252,263,254,260,256,258,255" alt="slovenia"  onclick="return select('SI')" onmouseover="highlight('SI');" onmouseout="unhighlight('SI');"/>
<!-- sweden -->
<area shape="poly" coords="237,134,238,141,246,155,247,160,247,168,255,167,258,163,262,159,270,157,270,150,277,150,281,137,274,142,270,147,268,144,268,135,275,130,278,120,272,114,267,111,267,95,278,82,282,74,282,71,280,71,283,61,289,60,287,56,286,54,286,49,282,41,280,37,278,35,274,35,270,31,269,30,268,38,263,38,261,41,259,41,256,51,255,54,251,60,250,72,248,75,247,76,249,79,248,81,245,82,241,86,241,89,242,105,244,107,245,109,243,111,242,112,245,120,241,124,241,130,238,133,236,132" href="#SE" alt="sweden"  onclick="return select('SE')" onmouseover="highlight('SE');" onmouseout="unhighlight('SE');"/>
<!-- switzerland -->
<area shape="poly" coords="208,255,206,257,205,253,211,245,218,243,222,241,223,244,227,245,228,246,229,249,231,253,235,254,232,256,232,258,228,257,226,258,225,262,223,262,220,256,219,258,217,260,214,261,210,261,208,257,206,255,206,257" href="#CH"alt="switzerland"  onclick="return select('CH')" onmouseover="highlight('CH');" onmouseout="unhighlight('CH');" />
<!-- turkey -->
<area shape="poly" coords="363,283,360,286,356,284,350,289,355,290,355,293,353,295,352,300,354,301,352,307,355,311,359,312,360,317,361,320,363,324,368,332,379,335,393,337,394,327,407,328,412,332,422,327,427,319,430,319,435,314,436,316,433,321,438,324,440,325,442,319,439,314,443,314,445,315,453,308,456,309,464,305,470,298,476,296,481,293,489,289,494,287,495,289,497,284,494,281,492,280,491,275,485,267,487,262,484,260,479,261,477,258,470,252,467,251,460,255,458,255,451,264,441,266,438,270,424,272,419,268,418,270,410,267,410,270,393,277,387,285,383,287,371,289,365,287" href="#TR"alt="turkey"  onclick="return select('TR')" onmouseover="highlight('TR');" onmouseout="unhighlight('TR');" />

		</map>
	
    </div>
    <div>
		<select id="country-selection-list"  style="margin-top:5px;">
			<option id="no-selection-option" value="" selected="selected">Choose a country </option>
			<c:forEach var="countryElement" items="<%= nl.wur.alterra.cgi.ace.model.constants.AceItemCountry.values() %>" >
				<option id="${countryElement}-option" value="${countryElement}"><liferay-ui:message key="acesearch-country-lbl-${countryElement}" /></option>				
			</c:forEach>
		</select>
		</p>
    </div>
</div>