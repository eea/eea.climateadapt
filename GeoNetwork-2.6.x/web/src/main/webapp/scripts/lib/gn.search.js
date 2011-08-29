var mainViewport;
function initSimpleSearch(b){}function gn_anyKeyObserver(b){if(b.keyCode==Event.KEY_RETURN){runSimpleSearch()
}}function runCsvSearch(){var b=getGNServiceURL("csv.search");
if($("advanced_search_pnl").visible()){b=b+"?"+fetchParam("template")
}window.open(b,"csv");
metadataselect(0,"remove-all")
}function runPdfSearch(b){if(b){var c=getGNServiceURL("pdf.selection.search");
if($("advanced_search_pnl").visible()){c=c+"?"+fetchParam("template")
}location.replace(c);
metadataselect(0,"remove-all")
}else{if(document.cookie.indexOf("search=advanced")!=-1){runAdvancedSearch("pdf")
}else{runSimpleSearch("pdf")
}}}function runSimpleSearch(c){if(c!="pdf"){preparePresent()
}setSort();
var b="any="+encodeURIComponent($("any").value);
var d=$("region_simple").value;
if(d!=""){b+="&"+im_mm_getURLselectedbbox();
b+=fetchParam("relation");
b+="&attrset=geo";
if(d!="userdefined"){b+=fetchParam("region")
}}b+=fetchParam("sortBy");
b+=fetchParam("sortOrder");
b+=fetchParam("hitsPerPage");
b+=fetchParam("output");
if(c=="pdf"){gn_searchpdf(b)
}else{gn_search(b)
}}function resetSimpleSearch(){setParam("any","");
setParam("relation","overlaps");
setParam("region_simple",null);
setParam("region",null);
$("northBL").value="90";
$("southBL").value="-90";
$("eastBL").value="180";
$("westBL").value="-180";
resetMinimaps();
setParam("sortBy","relevance");
setParam("sortBy_simple","relevance");
setParam("sortOrder","");
setParam("hitsPerPage","10");
setParam("hitsPerPage_simple","10");
setParam("output","full");
setParam("output_simple","full")
}function resetMinimaps(){GeoNetwork.minimapSimpleSearch.clearExtentBox();
var c=GeoNetwork.minimapSimpleSearch.getMap();
if(c){var b=Ext.getCmp("mini_mappanel_ol_minimap1");
b.map.setCenter(b.center,b.zoom)
}GeoNetwork.minimapAdvancedSearch.clearExtentBox();
c=GeoNetwork.minimapAdvancedSearch.getMap();
if(c){var b=Ext.getCmp("mini_mappanel_ol_minimap2");
b.map.setCenter(b.center,b.zoom)
}}function showAdvancedSearch(){closeSearch("simple_search_pnl");
openSearch("advanced_search_pnl");
document.cookie="search=advanced";
initAdvancedSearch()
}function showSimpleSearch(){closeSearch("advanced_search_pnl");
openSearch("simple_search_pnl");
document.cookie="search=default";
initSimpleSearch()
}function openSearch(b){$(b).show()
}function closeSearch(b){$(b).hide()
}function initAdvancedSearch(){new Ajax.Autocompleter("themekey","keywordList","portal.search.keywords?",{paramName:"keyword",updateElement:addQuote});
Calendar.setup({inputField:"dateFrom",ifFormat:"%Y-%m-%dT%H:%M:00",button:"from_trigger_c",showsTime:true,align:"Tl",singleClick:true});
Calendar.setup({inputField:"dateTo",ifFormat:"%Y-%m-%dT%H:%M:00",button:"to_trigger_c",showsTime:true,align:"Tl",singleClick:true});
Calendar.setup({inputField:"extFrom",ifFormat:"%Y-%m-%dT%H:%M:00",button:"extfrom_trigger_c",showsTime:true,align:"Tl",singleClick:true});
Calendar.setup({inputField:"extTo",ifFormat:"%Y-%m-%dT%H:%M:00",button:"extto_trigger_c",showsTime:true,align:"Tl",singleClick:true})
}function runAdvancedSearch(c){if(c!="pdf"){preparePresent()
}setSort();
var b=fetchParam("all");
b+=fetchParam("phrase");
b+=fetchParam("or");
b+=fetchParam("without");
b+=fetchParam("title");
b+=fetchParam("abstract");
b+=fetchParam("themekey");
b+=fetchRadioParam("similarity");
var e=$("region").value;
if(e!=""){b+="&attrset=geo";
b+="&"+im_mm_getURLselectedbbox();
b+=fetchParam("relation");
if(e!="userdefined"){b+=fetchParam("region")
}}if($("radfrom1").checked){b+=fetchParam("dateFrom");
b+=fetchParam("dateTo")
}if($("radfromext1").checked){b+=fetchParam("extFrom");
b+=fetchParam("extTo")
}b+=fetchParam("group");
b+=fetchParam("category");
b+=fetchParam("siteId");
b+=fetchBoolParam("digital");
b+=fetchBoolParam("paper");
b+=fetchBoolParam("dynamic");
b+=fetchBoolParam("download");
b+=fetchParam("protocol").toLowerCase();
b+=fetchParam("template");
b+=fetchParam("sortBy");
b+=fetchParam("sortOrder");
b+=fetchParam("hitsPerPage");
b+=fetchParam("output");
b+=fetchParam("inspireannex");
b+=addINSPIREThemes();
var d=$("inspire");
if(d){if(d.checked){b+="&inspire=true"
}}if(c=="pdf"){gn_searchpdf(b)
}else{gn_search(b)
}}function resetAdvancedSearch(){setParam("all","");
setParam("phrase","");
setParam("or","");
setParam("without","");
setParam("title","");
setParam("abstract","");
setParam("themekey","");
var b=document.getElementsByName("similarity");
b[1].checked=true;
setParam("relation","overlaps");
setParam("region",null);
setParam("region_simple",null);
$("northBL").value="90";
$("southBL").value="-90";
$("eastBL").value="180";
$("westBL").value="-180";
resetMinimaps();
setParam("dateFrom","");
setParam("dateTo","");
$("radfrom0").checked=true;
$("radfrom1").disabled="disabled";
setParam("extFrom","");
setParam("extTo","");
$("radfromext1").disabled="disabled";
setParam("group","");
setParam("category","");
setParam("siteId","");
$("digital").checked=false;
$("paper").checked=false;
$("dynamic").checked=false;
$("download").checked=false;
setParam("protocol","");
setParam("template","n");
setParam("sortBy","relevance");
setParam("sortBy_simple","relevance");
setParam("sortOrder","");
setParam("hitsPerPage","10");
setParam("hitsPerPage_simple","10");
setParam("output","full");
setParam("output_simple","full");
resetInspireOptions()
}function showFields(c,e){var c=$(c);
if(c){var d=c.getAttribute("src");
var b=d.lastIndexOf("/");
var e=$(e);
d=d.substring(0,b+1);
if(e.visible()){c.setAttribute("src",d+"plus.gif")
}else{c.setAttribute("src",d+"minus.png")
}e.toggle()
}}function setSort(){if($("sortBy").value=="title"){$("sortOrder").value="reverse"
}else{$("sortOrder").value=""
}}function setSortAndSearch(){$("sortBy").value=$F("sortBy.live");
setSort();
if(document.cookie.indexOf("search=advanced")!=-1){runAdvancedSearch()
}else{runSimpleSearch()
}}var ratingPopup=null;
function showRatingPopup(c){if(ratingPopup==null){ker.loadURL("rating.popup",ker.wrap(this,function(d){var e=document.createElement("div");
e.className="ratingBox";
e.innerHTML=d.responseText;
e.style.display="none";
e.style.zIndex=32000;
e.setAttribute("id","rating.popup");
$("content").appendChild(e);
ratingPopup=e;
setTimeout(ker.wrap(this,function(){showRatingPopup(c)
}),10)
}));
return
}var b=Position.positionedOffset($("rating.link."+c));
ratingPopup.style.left=b[0]-100+"px";
ratingPopup.style.top=b[1]+16+"px";
ratingPopup.setAttribute("mdid",c);
Element.show(ratingPopup)
}function hideRatingPopup(){var b=$("rating.popup");
if(b!=null){Element.hide(b);
Element.hide("rating.image")
}}function rateMetadata(b){var d=ratingPopup.getAttribute("mdid");
Element.show("rating.image");
var c="<request>   <id>"+d+"</id>   <rating>"+b+"</rating></request>";
ker.send("xml.metadata.rate",c,ker.wrap(this,rateMetadata_OK))
}function rateMetadata_OK(b){if(b.nodeName=="error"){ker.showError(translate("rateMetadataFailed"),b)
}else{hideRatingPopup()
}}function doRegionSearchSimple(){doRegionSearch("region_simple");
$("region").value=$("region_simple").value
}function doRegionSearchAdvanced(){doRegionSearch("region");
$("region_simple").value=$("region").value
}function doRegionSearch(b){var c=$(b).value;
if(c==""){c=null;
$("northBL").value="90";
$("southBL").value="-90";
$("eastBL").value="180";
$("westBL").value="-180";
GeoNetwork.minimapSimpleSearch.updateExtentBox();
GeoNetwork.minimapAdvancedSearch.updateExtentBox()
}else{if(c=="userdefined"){}else{getRegion(c)
}}}function getRegion(d){if(d){var b="id="+d
}var c=new Ajax.Request(getGNServiceURL("xml.region.get"),{method:"get",parameters:b,onSuccess:getRegion_complete,onFailure:getRegion_error})
}function getRegion_complete(e){var d=e.responseXML;
var g=xml.evalXPath(d,"response/record/north");
var b=xml.evalXPath(d,"response/record/south");
var c=xml.evalXPath(d,"response/record/east");
var f=xml.evalXPath(d,"response/record/west");
$("northBL").value=g;
$("southBL").value=b;
$("eastBL").value=c;
$("westBL").value=f;
GeoNetwork.minimapSimpleSearch.updateExtentBox();
GeoNetwork.minimapAdvancedSearch.updateExtentBox()
}function getRegion_error(){alert(translate("error"))
}function updateAoIFromForm(){var c=Number($("northBL").value);
var b=Number($("southBL").value);
var d=Number($("eastBL").value);
var e=Number($("westBL").value);
if(c<b){alert(translate("northSouth"))
}else{if(c>90){alert(translate("north90"))
}else{if(b<-90){alert(translate("south90"))
}else{if(d<e){alert(translate("eastWest"))
}else{if(d>180){alert(translate("east180"))
}else{if(e<-180){alert(translate("west180"))
}else{im_mm_redrawAoI();
im_mm_zoomToAoI();
$("updateBB").style.visibility="hidden"
}}}}}}}function AoIrefresh(){$("region").value="userdefined";
$("updateBB").style.visibility="visible"
}function im_mm_aoiUpdated(b){$("region").value="userdefined"
}function runRssSearch(){var b=new Ajax.Request(getGNServiceURL("metadata.latest.updated"),{method:"get",parameters:null,onSuccess:gn_search_rss_complete})
}function gn_search_rss_complete(b){var c=$("latest_updates");
c.innerHTML=b.responseText
}function preparePresent(){$("loadingMD").show()
}function gn_search(b){var c=new Ajax.Request(getGNServiceURL("main.search.embedded"),{method:"get",parameters:b,onSuccess:gn_search_complete,onFailure:gn_search_error})
}function gn_searchpdf(b){b=b.replace(/hitsPerPage=\d{2,3}/,"hitsPerPage=9999");
location.replace(getGNServiceURL("pdf.search")+"?"+b)
}function gn_present(b,e){preparePresent();
var c="from="+b+"&to="+e;
var d=new Ajax.Request(getGNServiceURL("main.present.embedded"),{method:"get",parameters:c,onSuccess:gn_search_complete,onFailure:gn_search_error})
}function gn_search_complete(b){var c=$("resultList");
c.innerHTML=b.responseText;
$("loadingMD").hide()
}function gn_showSingleMetadataUUID(c){var b="uuid="+c+"&control&currTab=simple";
gn_showSingleMet(b)
}function gn_showSingleMetadata(c){var b="id="+c+"&currTab=simple";
gn_showSingleMet(b)
}function gn_showSingleMet(b){if($("loadingMD")){$("loadingMD").show()
}var c=new Ajax.Request(getGNServiceURL("metadata.show.embedded"),{method:"get",parameters:b,onSuccess:function(f){if($("loadingMD")){$("loadingMD").hide()
}var e=$("resultList");
clearNode(e);
var g=document.createElement("div");
g.className="metadata_current";
g.style.display="none";
g.style.width="100%";
e.appendChild(g);
g.innerHTML=f.responseText;
Effect.BlindDown(g);
var d=new TooltipManager();
ker.loadMan.wait(d);
extentMap.initMapDiv()
},onFailure:gn_search_error})
}function gn_showMetadata(b){gn_showMetadataTab(b,"simple")
}function gn_showMetadataTab(e,b){var c="id="+e+"&currTab="+b;
$("gn_showmd_"+e).hide();
$("gn_loadmd_"+e).show();
var d=new Ajax.Request(getGNServiceURL("metadata.show.embedded"),{method:"get",parameters:c,onSuccess:function(h){var g=$("mdwhiteboard_"+e);
clearNode(g);
$("gn_loadmd_"+e).hide();
$("gn_hidemd_"+e).show();
var j=document.createElement("div");
j.className="metadata_current";
j.style.display="none";
j.style.width="100%";
g.appendChild(j);
j.innerHTML=h.responseText;
Effect.BlindDown(j);
var f=new TooltipManager();
ker.loadMan.wait(f);
extentMap.initMapDiv()
},onFailure:gn_search_error})
}function gn_hideMetadata(d){var b=$("mdwhiteboard_"+d);
var c=b.firstChild;
Effect.BlindUp(c,{afterFinish:function(e){clearNode(b);
$("gn_showmd_"+d).show();
$("gn_hidemd_"+d).hide()
}})
}function a(b){alert(b)
}function gn_search_error(b){alert("ERROR "+b.responseText);
$("loadingMD").hide();
return -1
}function gn_filteredSearch(){var c="";
if($("advanced_search_pnl").visible()){c=fetchParam("template")
}var b=new Ajax.Request(getGNServiceURL("selection.search"),{method:"get",parameters:c,onSuccess:gn_search_complete,onFailure:gn_search_error})
}function runCategorySearch(c){preparePresent();
var b="category="+c;
gn_search(b)
}function fetchParam(d){var c=$(d);
if(!c){return""
}else{var b=c.value;
if(b){return"&"+d+"="+encodeURIComponent(b)
}else{return""
}}}function fetchBoolParam(c){var b=$(c);
if(!b){return""
}else{if(b.checked){return"&"+c+"=on"
}else{return"&"+c+"=off"
}}}function fetchRadioParam(c){var b=document.getElementsByName(c);
var d=getCheckedValue(b);
return"&"+c+"="+d
}function getCheckedValue(c){if(!c){return""
}var d=c.length;
if(d==undefined){if(c.checked){return c.value
}else{return""
}}for(var b=0;
b<d;
b++){if(c[b].checked){return c[b].value
}}return""
}function setParam(c,d){var b=$(c);
if(b){b.value=d
}}var keyordsSelected=false;
function addQuote(b){$("themekey").value='"'+b.innerHTML+'"'
}function popKeyword(c,b){if(b.style.display=="block"){b.style.display="none";
return false
}b.style.width="250px";
b.style.display="block";
if(!keyordsSelected){new Ajax.Updater("keywordSelector","portal.search.keywords?mode=selector&keyword="+$("themekey").value);
keyordsSelected=true
}}function keywordCheck(c,b){c='"'+c+'"';
if(b){if($("themekey").value!=""){$("themekey").value+=" or "+c
}else{$("themekey").value=c
}}else{$("themekey").value=$("themekey").value.replace(" or "+c,"");
$("themekey").value=$("themekey").value.replace(c,"");
pos=$("themekey").value.indexOf(" or ");
if(pos==0){$("themekey").value=$("themekey").value.substring(4,$("themekey").value.length)
}}}function setDates(h){var d=$("dateFrom");
var c=$("dateTo");
var f=$("extFrom");
var b=$("extTo");
if(h==0){d.value="";
c.value="";
f.value="";
b.value="";
return
}today=new Date();
fday=today.getDate();
if(fday.toString().length==1){fday="0"+fday.toString()
}fmonth=today.getMonth()+1;
if(fmonth.toString().length==1){fmonth="0"+fmonth.toString()
}fyear=today.getYear();
if(fyear<1900){fyear=fyear+1900
}var e=fyear+"-"+fmonth+"-"+fday+"T23:59:59";
var g=(fyear-10)+"-"+fmonth+"-"+fday+"T00:00:00";
c.value=e;
d.value=g;
b.value=e;
f.value=g
}function check(c){var d=$("search-results-content").getElementsByTagName("INPUT");
var b=d.length;
for(var e=0;
e<b;
e++){d[e].checked=c
}}function metadataselect(e,c){if(c===true){c="add"
}else{if(c===false){c="remove"
}}var d="id="+e+"&selected="+c;
var b=new Ajax.Request(Env.locService+"/metadata.select",{method:"get",parameters:d,onComplete:function(f){},onLoaded:function(f){},onSuccess:function(g){var k=g.responseText;
var l=(new DOMParser()).parseFromString(k,"text/xml");
var f=l.getElementsByTagName("response")[0];
var j=f.getElementsByTagName("Selected")[0].firstChild.nodeValue;
var h=document.getElementById("nbselected");
h.innerHTML=j
},onFailure:function(f){alert(translate("metadataSelectionError"))
}});
if(c=="remove-all"){check(false)
}if(c=="add-all"){check(true)
}}function toggleMoreFields(){$("all_search_row").toggle();
$("phrase_search_row").toggle();
$("without_search_row").toggle();
var c=$("i_morefields").getAttribute("src");
var b=c.lastIndexOf("/");
c=c.substring(0,b+1);
if($("all_search_row").visible()==true){$("i_morefields").setAttribute("src",c+"minus.png")
}else{$("i_morefields").setAttribute("src",c+"plus.gif")
}}function toggleInspire(){$("inspiresearchfields").toggle();
var c=$("i_inspire").getAttribute("src");
var b=c.lastIndexOf("/");
c=c.substring(0,b+1);
if($("inspiresearchfields").visible()==true){$("i_inspire").setAttribute("src",c+"minus.png")
}else{$("i_inspire").setAttribute("src",c+"plus.gif")
}}function toggleWhen(){$("whensearchfields").toggle();
var c=$("i_when").getAttribute("src");
var b=c.lastIndexOf("/");
c=c.substring(0,b+1);
if($("whensearchfields").visible()==true){$("i_when").setAttribute("src",c+"minus.png")
}else{$("i_when").setAttribute("src",c+"plus.gif")
}}function addWMSLayer(b){Ext.getCmp("north-map-panel").expand();
mainViewport.doLayout();
GeoNetwork.mapViewer.addWMSLayer(b)
}function addWMSServerLayers(b){Ext.getCmp("north-map-panel").expand();
mainViewport.doLayout();
GeoNetwork.mapViewer.addWMSServerLayers(b)
}function addSelectedWMSLayers(d){var b=$$("#"+d+" input");
var e=new Array();
for(var c=0;
c<b.length;
c++){if(b[c].checked){e.push(b[c].value.split(","))
}}addWMSLayer(e)
}function gn_showInterList(d){var b="id="+d+"&currTab=distribution";
$("gn_showinterlist_"+d).hide();
$("gn_loadinterlist_"+d).show();
var c=new Ajax.Request(getGNServiceURL("metadata.show.embedded"),{method:"get",parameters:b,onSuccess:function(g){var f=$("ilwhiteboard_"+d);
clearNode(f);
f.show();
$("gn_loadinterlist_"+d).hide();
$("gn_hideinterlist_"+d).show();
var h=document.createElement("div");
h.className="metadata_current";
h.style.width="100%";
$(h).hide();
f.appendChild(h);
h.innerHTML=g.responseText;
Effect.BlindDown(h);
var e=new TooltipManager();
ker.loadMan.wait(e)
},onFailure:gn_search_error})
}function gn_hideInterList(d){var b=$("ilwhiteboard_"+d);
var c=b.firstChild;
Effect.BlindUp(c,{afterFinish:function(e){clearNode(b);
$("gn_showinterlist_"+d).show();
$("gn_hideinterlist_"+d).hide()
}})
}function showInspireSearch(){var b=$("inspire");
if(b.checked){b.value="true"
}else{b.value=""
}}function inspireAnnexChanged(b){var c=$("inspire");
if(b!=""){if(c){c.checked=true
}}else{if(c){c.checked=false
}}}function inspireOrganisationChanged(b){setParam("group",b)
}function inspireBrontypeChanged(b){setParam("type",b)
}function inspireServiceTypeChanged(b){setParam("protocol",b)
}function taggleVisibility(b){var c=$(b);
if(c!=null){if(c.style.display=="none"){c.style.display="block"
}else{c.style.display="none"
}}else{return
}}function addINSPIREThemes(){var d="";
var b="&inspiretheme=";
var c=$$('#inspirethemesdiv input[type="checkbox"]');
for(i=0;
i<c.length;
i++){if(c[i].checked){d+=b+c[i].value+"*"
}}return d
}function resetInspireOptions(){if(!$("inspire")){return
}$("inspire").checked=false;
setParam("title","");
setParam("inspireannex","");
setParam("inspirebrontype","");
setParam("protocol","");
setParam("orgselect_inspire","");
$("inspire_GeographicalNames").checked=false;
$("inspire_AdministrativeUnits").checked=false;
$("inspire_Addresses").checked=false;
$("inspire_CadastralParcels").checked=false;
$("inspire_TransportNetworks").checked=false;
$("inspire_Hydrography").checked=false;
$("inspire_ProtectedSites").checked=false;
$("inspire_Elevation").checked=false;
$("inspire_LandCover").checked=false;
$("inspire_Orthoimagery").checked=false;
$("inspire_Geology").checked=false;
$("inspire_StatisticalUnits").checked=false;
$("inspire_Buildings").checked=false;
$("inspire_Soil").checked=false;
$("inspire_LandUse").checked=false;
$("inspire_HumanHealthAndSafety").checked=false;
$("inspire_UtilityAndGovernmentServices").checked=false;
$("inspire_EnvironmentalMonitoringFacilities").checked=false;
$("inspire_ProductionAndIndustrialFacilities").checked=false;
$("inspire_AgriculturalAndAquacultureFacilities").checked=false;
$("inspire_PopulationDistribution-Demography").checked=false;
$("inspire_AreaManagementRestrictionRegulationZonesAndReportingUnits").checked=false;
$("inspire_NaturalRiskZones").checked=false;
$("inspire_AtmosphericConditions").checked=false;
$("inspire_MeteorologicalGeographicalFeatures").checked=false;
$("inspire_OceanographicGeographicalFeatures").checked=false;
$("inspire_SeaRegions").checked=false;
$("inspire_Bio-geographicalRegions").checked=false;
$("inspire_HabitatsAndBiotopes").checked=false;
$("inspire_SpeciesDistribution").checked=false;
$("inspire_EnergyResources").checked=false;
$("inspire_MineralResources").checked=false;
$("inspire_MineralResources").checked=false;
$("inspire_MineralResources").checked=false
}function clearNode(b){var c=$(b);
while(c.firstChild){c.removeChild(c.firstChild)
}}function im_mm_getURLselectedbbox(){return"geometry=POLYGON(( "+$("westBL").value+" "+$("northBL").value+", "+$("eastBL").value+" "+$("northBL").value+", "+$("eastBL").value+" "+$("southBL").value+", "+$("westBL").value+" "+$("southBL").value+", "+$("westBL").value+" "+$("northBL").value+"))"
};