var OpenLayers={singleFile:true};(function(){var j=(typeof OpenLayers=="object"&&OpenLayers.singleFile);
var a;
window.OpenLayers={_scriptName:(!j)?"lib/OpenLayers.js":"OpenLayers.js",_getScriptLocation:function(){if(a!=undefined){return a
}a="";
var r=new RegExp("(^|(.*?\\/))("+OpenLayers._scriptName+")(\\?|$)");
var n=document.getElementsByTagName("script");
for(var p=0,h=n.length;
p<h;
p++){var q=n[p].getAttribute("src");
if(q){var o=q.match(r);
if(o){a=o[1];
break
}}}return a
}};
if(!j){var k=new Array("OpenLayers/Util.js","OpenLayers/BaseTypes.js","OpenLayers/BaseTypes/Class.js","OpenLayers/BaseTypes/Bounds.js","OpenLayers/BaseTypes/Element.js","OpenLayers/BaseTypes/LonLat.js","OpenLayers/BaseTypes/Pixel.js","OpenLayers/BaseTypes/Size.js","OpenLayers/Console.js","OpenLayers/Tween.js","Rico/Corner.js","Rico/Color.js","OpenLayers/Ajax.js","OpenLayers/Events.js","OpenLayers/Request.js","OpenLayers/Request/XMLHttpRequest.js","OpenLayers/Projection.js","OpenLayers/Map.js","OpenLayers/Layer.js","OpenLayers/Icon.js","OpenLayers/Marker.js","OpenLayers/Marker/Box.js","OpenLayers/Popup.js","OpenLayers/Tile.js","OpenLayers/Tile/Image.js","OpenLayers/Tile/Image/IFrame.js","OpenLayers/Tile/WFS.js","OpenLayers/Layer/Image.js","OpenLayers/Layer/SphericalMercator.js","OpenLayers/Layer/EventPane.js","OpenLayers/Layer/FixedZoomLevels.js","OpenLayers/Layer/Google.js","OpenLayers/Layer/Google/v3.js","OpenLayers/Layer/VirtualEarth.js","OpenLayers/Layer/Yahoo.js","OpenLayers/Layer/HTTPRequest.js","OpenLayers/Layer/Grid.js","OpenLayers/Layer/MapGuide.js","OpenLayers/Layer/MapServer.js","OpenLayers/Layer/MapServer/Untiled.js","OpenLayers/Layer/KaMap.js","OpenLayers/Layer/KaMapCache.js","OpenLayers/Layer/MultiMap.js","OpenLayers/Layer/Markers.js","OpenLayers/Layer/Text.js","OpenLayers/Layer/WorldWind.js","OpenLayers/Layer/ArcGIS93Rest.js","OpenLayers/Layer/WMS.js","OpenLayers/Layer/WMS/Untiled.js","OpenLayers/Layer/WMS/Post.js","OpenLayers/Layer/WMTS.js","OpenLayers/Layer/ArcIMS.js","OpenLayers/Layer/GeoRSS.js","OpenLayers/Layer/Boxes.js","OpenLayers/Layer/XYZ.js","OpenLayers/Layer/TMS.js","OpenLayers/Layer/TileCache.js","OpenLayers/Layer/Zoomify.js","OpenLayers/Popup/Anchored.js","OpenLayers/Popup/AnchoredBubble.js","OpenLayers/Popup/Framed.js","OpenLayers/Popup/FramedCloud.js","OpenLayers/Feature.js","OpenLayers/Feature/Vector.js","OpenLayers/Feature/WFS.js","OpenLayers/Handler.js","OpenLayers/Handler/Click.js","OpenLayers/Handler/Hover.js","OpenLayers/Handler/Point.js","OpenLayers/Handler/Path.js","OpenLayers/Handler/Polygon.js","OpenLayers/Handler/Feature.js","OpenLayers/Handler/Drag.js","OpenLayers/Handler/RegularPolygon.js","OpenLayers/Handler/Box.js","OpenLayers/Handler/MouseWheel.js","OpenLayers/Handler/Keyboard.js","OpenLayers/Control.js","OpenLayers/Control/Attribution.js","OpenLayers/Control/Button.js","OpenLayers/Control/ZoomBox.js","OpenLayers/Control/ZoomToMaxExtent.js","OpenLayers/Control/DragPan.js","OpenLayers/Control/Navigation.js","OpenLayers/Control/MouseDefaults.js","OpenLayers/Control/MousePosition.js","OpenLayers/Control/OverviewMap.js","OpenLayers/Control/KeyboardDefaults.js","OpenLayers/Control/PanZoom.js","OpenLayers/Control/PanZoomBar.js","OpenLayers/Control/ArgParser.js","OpenLayers/Control/Permalink.js","OpenLayers/Control/Scale.js","OpenLayers/Control/ScaleLine.js","OpenLayers/Control/Snapping.js","OpenLayers/Control/Split.js","OpenLayers/Control/LayerSwitcher.js","OpenLayers/Control/DrawFeature.js","OpenLayers/Control/DragFeature.js","OpenLayers/Control/ModifyFeature.js","OpenLayers/Control/Panel.js","OpenLayers/Control/SelectFeature.js","OpenLayers/Control/NavigationHistory.js","OpenLayers/Control/Measure.js","OpenLayers/Control/WMSGetFeatureInfo.js","OpenLayers/Control/WMTSGetFeatureInfo.js","OpenLayers/Control/Graticule.js","OpenLayers/Control/TransformFeature.js","OpenLayers/Control/SLDSelect.js","OpenLayers/Geometry.js","OpenLayers/Geometry/Rectangle.js","OpenLayers/Geometry/Collection.js","OpenLayers/Geometry/Point.js","OpenLayers/Geometry/MultiPoint.js","OpenLayers/Geometry/Curve.js","OpenLayers/Geometry/LineString.js","OpenLayers/Geometry/LinearRing.js","OpenLayers/Geometry/Polygon.js","OpenLayers/Geometry/MultiLineString.js","OpenLayers/Geometry/MultiPolygon.js","OpenLayers/Geometry/Surface.js","OpenLayers/Renderer.js","OpenLayers/Renderer/Elements.js","OpenLayers/Renderer/SVG.js","OpenLayers/Renderer/Canvas.js","OpenLayers/Renderer/VML.js","OpenLayers/Layer/Vector.js","OpenLayers/Layer/Vector/RootContainer.js","OpenLayers/Strategy.js","OpenLayers/Strategy/Filter.js","OpenLayers/Strategy/Fixed.js","OpenLayers/Strategy/Cluster.js","OpenLayers/Strategy/Paging.js","OpenLayers/Strategy/BBOX.js","OpenLayers/Strategy/Save.js","OpenLayers/Strategy/Refresh.js","OpenLayers/Filter.js","OpenLayers/Filter/FeatureId.js","OpenLayers/Filter/Logical.js","OpenLayers/Filter/Comparison.js","OpenLayers/Filter/Spatial.js","OpenLayers/Protocol.js","OpenLayers/Protocol/HTTP.js","OpenLayers/Protocol/SQL.js","OpenLayers/Protocol/SQL/Gears.js","OpenLayers/Protocol/WFS.js","OpenLayers/Protocol/WFS/v1.js","OpenLayers/Protocol/WFS/v1_0_0.js","OpenLayers/Protocol/WFS/v1_1_0.js","OpenLayers/Protocol/SOS.js","OpenLayers/Protocol/SOS/v1_0_0.js","OpenLayers/Layer/PointTrack.js","OpenLayers/Layer/GML.js","OpenLayers/Style.js","OpenLayers/Style2.js","OpenLayers/StyleMap.js","OpenLayers/Rule.js","OpenLayers/Format.js","OpenLayers/Format/XML.js","OpenLayers/Format/Context.js","OpenLayers/Format/ArcXML.js","OpenLayers/Format/ArcXML/Features.js","OpenLayers/Format/GML.js","OpenLayers/Format/GML/Base.js","OpenLayers/Format/GML/v2.js","OpenLayers/Format/GML/v3.js","OpenLayers/Format/Atom.js","OpenLayers/Format/KML.js","OpenLayers/Format/GeoRSS.js","OpenLayers/Format/WFS.js","OpenLayers/Format/WFSCapabilities.js","OpenLayers/Format/WFSCapabilities/v1.js","OpenLayers/Format/WFSCapabilities/v1_0_0.js","OpenLayers/Format/WFSCapabilities/v1_1_0.js","OpenLayers/Format/WFSDescribeFeatureType.js","OpenLayers/Format/WMSDescribeLayer.js","OpenLayers/Format/WMSDescribeLayer/v1_1.js","OpenLayers/Format/WKT.js","OpenLayers/Format/OSM.js","OpenLayers/Format/GPX.js","OpenLayers/Format/Filter.js","OpenLayers/Format/Filter/v1.js","OpenLayers/Format/Filter/v1_0_0.js","OpenLayers/Format/Filter/v1_1_0.js","OpenLayers/Format/SLD.js","OpenLayers/Format/SLD/v1.js","OpenLayers/Format/SLD/v1_0_0.js","OpenLayers/Format/OWSCommon/v1.js","OpenLayers/Format/OWSCommon/v1_0_0.js","OpenLayers/Format/OWSCommon/v1_1_0.js","OpenLayers/Format/CSWGetDomain.js","OpenLayers/Format/CSWGetDomain/v2_0_2.js","OpenLayers/Format/CSWGetRecords.js","OpenLayers/Format/CSWGetRecords/v2_0_2.js","OpenLayers/Format/WFST.js","OpenLayers/Format/WFST/v1.js","OpenLayers/Format/WFST/v1_0_0.js","OpenLayers/Format/WFST/v1_1_0.js","OpenLayers/Format/Text.js","OpenLayers/Format/JSON.js","OpenLayers/Format/GeoJSON.js","OpenLayers/Format/WMC.js","OpenLayers/Format/WMC/v1.js","OpenLayers/Format/WMC/v1_0_0.js","OpenLayers/Format/WMC/v1_1_0.js","OpenLayers/Format/WMSCapabilities.js","OpenLayers/Format/WMSCapabilities/v1.js","OpenLayers/Format/WMSCapabilities/v1_1.js","OpenLayers/Format/WMSCapabilities/v1_1_0.js","OpenLayers/Format/WMSCapabilities/v1_1_1.js","OpenLayers/Format/WMSCapabilities/v1_3.js","OpenLayers/Format/WMSCapabilities/v1_3_0.js","OpenLayers/Format/WMSGetFeatureInfo.js","OpenLayers/Format/SOSCapabilities.js","OpenLayers/Format/SOSCapabilities/v1_0_0.js","OpenLayers/Format/SOSGetObservation.js","OpenLayers/Format/SOSGetFeatureOfInterest.js","OpenLayers/Format/OWSContext.js","OpenLayers/Format/OWSContext/v0_3_1.js","OpenLayers/Format/WMTSCapabilities.js","OpenLayers/Format/WMTSCapabilities/v1_0_0.js","OpenLayers/Layer/WFS.js","OpenLayers/Control/GetFeature.js","OpenLayers/Control/MouseToolbar.js","OpenLayers/Control/NavToolbar.js","OpenLayers/Control/PanPanel.js","OpenLayers/Control/Pan.js","OpenLayers/Control/ZoomIn.js","OpenLayers/Control/ZoomOut.js","OpenLayers/Control/ZoomPanel.js","OpenLayers/Control/EditingToolbar.js","OpenLayers/Symbolizer.js","OpenLayers/Symbolizer/Point.js","OpenLayers/Symbolizer/Line.js","OpenLayers/Symbolizer/Polygon.js","OpenLayers/Symbolizer/Text.js","OpenLayers/Symbolizer/Raster.js","OpenLayers/Lang.js","OpenLayers/Lang/en.js");
var c=navigator.userAgent;
var e=(c.match("MSIE")||c.match("Safari"));
if(e){var b=new Array(k.length)
}var l=OpenLayers._getScriptLocation()+"lib/";
for(var d=0,g=k.length;
d<g;
d++){if(e){b[d]="<script src='"+l+k[d]+"'><\/script>"
}else{var m=document.createElement("script");
m.src=l+k[d];
var f=document.getElementsByTagName("head").length?document.getElementsByTagName("head")[0]:document.body;
f.appendChild(m)
}}if(e){document.write(b.join(""))
}}})();
OpenLayers.VERSION_NUMBER="OpenLayers 2.10 -- $Revision: 10721 $";OpenLayers.Util={};
OpenLayers.Util.getElement=function(){var d=[];
for(var c=0,a=arguments.length;
c<a;
c++){var b=arguments[c];
if(typeof b=="string"){b=document.getElementById(b)
}if(arguments.length==1){return b
}d.push(b)
}return d
};
OpenLayers.Util.isElement=function(a){return !!(a&&a.nodeType===1)
};
if(typeof window.$==="undefined"){window.$=OpenLayers.Util.getElement
}OpenLayers.Util.extend=function(a,e){a=a||{};
if(e){for(var d in e){var c=e[d];
if(c!==undefined){a[d]=c
}}var b=typeof window.Event=="function"&&e instanceof window.Event;
if(!b&&e.hasOwnProperty&&e.hasOwnProperty("toString")){a.toString=e.toString
}}return a
};
OpenLayers.Util.removeItem=function(c,b){for(var a=c.length-1;
a>=0;
a--){if(c[a]==b){c.splice(a,1)
}}return c
};
OpenLayers.Util.clearArray=function(a){OpenLayers.Console.warn(OpenLayers.i18n("methodDeprecated",{newMethod:"array = []"}));
a.length=0
};
OpenLayers.Util.indexOf=function(d,c){if(typeof d.indexOf=="function"){return d.indexOf(c)
}else{for(var b=0,a=d.length;
b<a;
b++){if(d[b]==c){return b
}}return -1
}};
OpenLayers.Util.modifyDOMElement=function(e,h,d,f,a,c,g,b){if(h){e.id=h
}if(d){e.style.left=d.x+"px";
e.style.top=d.y+"px"
}if(f){e.style.width=f.w+"px";
e.style.height=f.h+"px"
}if(a){e.style.position=a
}if(c){e.style.border=c
}if(g){e.style.overflow=g
}if(parseFloat(b)>=0&&parseFloat(b)<1){e.style.filter="alpha(opacity="+(b*100)+")";
e.style.opacity=b
}else{if(parseFloat(b)==1){e.style.filter="";
e.style.opacity=""
}}};
OpenLayers.Util.createDiv=function(a,i,h,f,e,c,b,g){var d=document.createElement("div");
if(f){d.style.backgroundImage="url("+f+")"
}if(!a){a=OpenLayers.Util.createUniqueID("OpenLayersDiv")
}if(!e){e="absolute"
}OpenLayers.Util.modifyDOMElement(d,a,i,h,e,c,b,g);
return d
};
OpenLayers.Util.createImage=function(a,h,g,e,d,c,f,i){var b=document.createElement("img");
if(!a){a=OpenLayers.Util.createUniqueID("OpenLayersDiv")
}if(!d){d="relative"
}OpenLayers.Util.modifyDOMElement(b,a,h,g,d,c,null,f);
if(i){b.style.display="none";
OpenLayers.Event.observe(b,"load",OpenLayers.Function.bind(OpenLayers.Util.onImageLoad,b));
OpenLayers.Event.observe(b,"error",OpenLayers.Function.bind(OpenLayers.Util.onImageLoadError,b))
}b.style.alt=a;
b.galleryImg="no";
if(e){b.src=e
}return b
};
OpenLayers.Util.setOpacity=function(b,a){OpenLayers.Util.modifyDOMElement(b,null,null,null,null,null,null,a)
};
OpenLayers.Util.onImageLoad=function(){if(!this.viewRequestID||(this.map&&this.viewRequestID==this.map.viewRequestID)){this.style.display=""
}OpenLayers.Element.removeClass(this,"olImageLoadError")
};
OpenLayers.IMAGE_RELOAD_ATTEMPTS=0;
OpenLayers.Util.onImageLoadError=function(){this._attempts=(this._attempts)?(this._attempts+1):1;
if(this._attempts<=OpenLayers.IMAGE_RELOAD_ATTEMPTS){var d=this.urls;
if(d&&d instanceof Array&&d.length>1){var e=this.src.toString();
var c,a;
for(a=0;
c=d[a];
a++){if(e.indexOf(c)!=-1){break
}}var f=Math.floor(d.length*Math.random());
var b=d[f];
a=0;
while(b==c&&a++<4){f=Math.floor(d.length*Math.random());
b=d[f]
}this.src=e.replace(c,b)
}else{this.src=this.src
}}else{OpenLayers.Element.addClass(this,"olImageLoadError")
}this.style.display=""
};
OpenLayers.Util.alphaHackNeeded=null;
OpenLayers.Util.alphaHack=function(){if(OpenLayers.Util.alphaHackNeeded==null){var d=navigator.appVersion.split("MSIE");
var a=parseFloat(d[1]);
var b=false;
try{b=!!(document.body.filters)
}catch(c){}OpenLayers.Util.alphaHackNeeded=(b&&(a>=5.5)&&(a<7))
}return OpenLayers.Util.alphaHackNeeded
};
OpenLayers.Util.modifyAlphaImageDiv=function(a,b,j,i,g,f,c,d,h){OpenLayers.Util.modifyDOMElement(a,b,j,i,f,null,null,h);
var e=a.childNodes[0];
if(g){e.src=g
}OpenLayers.Util.modifyDOMElement(e,a.id+"_innerImage",null,i,"relative",c);
if(OpenLayers.Util.alphaHack()){if(a.style.display!="none"){a.style.display="inline-block"
}if(d==null){d="scale"
}a.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"+e.src+"', sizingMethod='"+d+"')";
if(parseFloat(a.style.opacity)>=0&&parseFloat(a.style.opacity)<1){a.style.filter+=" alpha(opacity="+a.style.opacity*100+")"
}e.style.filter="alpha(opacity=0)"
}};
OpenLayers.Util.createAlphaImageDiv=function(b,j,i,g,f,c,d,h,k){var a=OpenLayers.Util.createDiv();
var e=OpenLayers.Util.createImage(null,null,null,null,null,null,null,false);
a.appendChild(e);
if(k){e.style.display="none";
OpenLayers.Event.observe(e,"load",OpenLayers.Function.bind(OpenLayers.Util.onImageLoad,a));
OpenLayers.Event.observe(e,"error",OpenLayers.Function.bind(OpenLayers.Util.onImageLoadError,a))
}OpenLayers.Util.modifyAlphaImageDiv(a,b,j,i,g,f,c,d,h);
return a
};
OpenLayers.Util.upperCaseObject=function(b){var a={};
for(var c in b){a[c.toUpperCase()]=b[c]
}return a
};
OpenLayers.Util.applyDefaults=function(d,c){d=d||{};
var b=typeof window.Event=="function"&&c instanceof window.Event;
for(var a in c){if(d[a]===undefined||(!b&&c.hasOwnProperty&&c.hasOwnProperty(a)&&!d.hasOwnProperty(a))){d[a]=c[a]
}}if(!b&&c&&c.hasOwnProperty&&c.hasOwnProperty("toString")&&!d.hasOwnProperty("toString")){d.toString=c.toString
}return d
};
OpenLayers.Util.getParameterString=function(c){var b=[];
for(var h in c){var g=c[h];
if((g!=null)&&(typeof g!="function")){var d;
if(typeof g=="object"&&g.constructor==Array){var e=[];
var i;
for(var a=0,f=g.length;
a<f;
a++){i=g[a];
e.push(encodeURIComponent((i===null||i===undefined)?"":i))
}d=e.join(",")
}else{d=encodeURIComponent(g)
}b.push(encodeURIComponent(h)+"="+d)
}}return b.join("&")
};
OpenLayers.Util.urlAppend=function(a,b){var d=a;
if(b){var c=(a+" ").split(/[?&]/);
d+=(c.pop()===" "?b:c.length?"&"+b:"?"+b)
}return d
};
OpenLayers.ImgPath="";
OpenLayers.Util.getImagesLocation=function(){return OpenLayers.ImgPath||(OpenLayers._getScriptLocation()+"img/")
};
OpenLayers.Util.Try=function(){var d=null;
for(var c=0,a=arguments.length;
c<a;
c++){var b=arguments[c];
try{d=b();
break
}catch(f){}}return d
};
OpenLayers.Util.getNodes=function(c,b){var a=OpenLayers.Util.Try(function(){return OpenLayers.Util._getNodes(c.documentElement.childNodes,b)
},function(){return OpenLayers.Util._getNodes(c.childNodes,b)
});
return a
};
OpenLayers.Util._getNodes=function(c,e){var b=[];
for(var d=0,a=c.length;
d<a;
d++){if(c[d].nodeName==e){b.push(c[d])
}}return b
};
OpenLayers.Util.getTagText=function(c,d,b){var a=OpenLayers.Util.getNodes(c,d);
if(a&&(a.length>0)){if(!b){b=0
}if(a[b].childNodes.length>1){return a.childNodes[1].nodeValue
}else{if(a[b].childNodes.length==1){return a[b].firstChild.nodeValue
}}}else{return""
}};
OpenLayers.Util.getXmlNodeValue=function(a){var b=null;
OpenLayers.Util.Try(function(){b=a.text;
if(!b){b=a.textContent
}if(!b){b=a.firstChild.nodeValue
}},function(){b=a.textContent
});
return b
};
OpenLayers.Util.mouseLeft=function(a,c){var b=(a.relatedTarget)?a.relatedTarget:a.toElement;
while(b!=c&&b!=null){b=b.parentNode
}return(b!=c)
};
OpenLayers.Util.DEFAULT_PRECISION=14;
OpenLayers.Util.toFloat=function(b,a){if(a==null){a=OpenLayers.Util.DEFAULT_PRECISION
}var b;
if(a==0){b=parseFloat(b)
}else{b=parseFloat(parseFloat(b).toPrecision(a))
}return b
};
OpenLayers.Util.rad=function(a){return a*Math.PI/180
};
OpenLayers.Util.deg=function(a){return a*180/Math.PI
};
OpenLayers.Util.VincentyConstants={a:6378137,b:6356752.3142,f:1/298.257223563};
OpenLayers.Util.distVincenty=function(g,e){var k=OpenLayers.Util.VincentyConstants;
var M=k.a,K=k.b,G=k.f;
var n=OpenLayers.Util.rad(e.lon-g.lon);
var J=Math.atan((1-G)*Math.tan(OpenLayers.Util.rad(g.lat)));
var I=Math.atan((1-G)*Math.tan(OpenLayers.Util.rad(e.lat)));
var m=Math.sin(J),i=Math.cos(J);
var l=Math.sin(I),h=Math.cos(I);
var r=n,o=2*Math.PI;
var q=20;
while(Math.abs(r-o)>1e-12&&--q>0){var z=Math.sin(r),c=Math.cos(r);
var N=Math.sqrt((h*z)*(h*z)+(i*l-m*h*c)*(i*l-m*h*c));
if(N==0){return 0
}var E=m*l+i*h*c;
var y=Math.atan2(N,E);
var j=Math.asin(i*h*z/N);
var F=Math.cos(j)*Math.cos(j);
var p=E-2*m*l/F;
var v=G/16*F*(4+G*(4-3*F));
o=r;
r=n+(1-v)*G*Math.sin(j)*(y+v*N*(p+v*E*(-1+2*p*p)))
}if(q==0){return NaN
}var u=F*(M*M-K*K)/(K*K);
var x=1+u/16384*(4096+u*(-768+u*(320-175*u)));
var w=u/1024*(256+u*(-128+u*(74-47*u)));
var D=w*N*(p+w/4*(E*(-1+2*p*p)-w/6*p*(-3+4*N*N)*(-3+4*p*p)));
var t=K*x*(y-D);
var H=t.toFixed(3)/1000;
return H
};
OpenLayers.Util.destinationVincenty=function(l,P,E){var o=OpenLayers.Util;
var i=o.VincentyConstants;
var Q=i.a,O=i.b,J=i.f;
var N=l.lon;
var g=l.lat;
var q=E;
var D=o.rad(P);
var G=Math.sin(D);
var h=Math.cos(D);
var F=(1-J)*Math.tan(o.rad(g));
var c=1/Math.sqrt((1+F*F)),j=F*c;
var p=Math.atan2(F,h);
var y=c*G;
var I=1-y*y;
var t=I*(Q*Q-O*O)/(O*O);
var x=1+t/16384*(4096+t*(-768+t*(320-175*t)));
var v=t/1024*(256+t*(-128+t*(74-47*t)));
var w=q/(O*x),K=2*Math.PI;
while(Math.abs(w-K)>1e-12){var m=Math.cos(2*p+w);
var R=Math.sin(w);
var H=Math.cos(w);
var z=v*R*(m+v/4*(H*(-1+2*m*m)-v/6*m*(-3+4*R*R)*(-3+4*m*m)));
K=w;
w=q/(O*x)+z
}var M=j*R-c*H*h;
var d=Math.atan2(j*H+c*R*h,(1-J)*Math.sqrt(y*y+M*M));
var n=Math.atan2(R*G,c*H-j*R*h);
var r=J/16*I*(4+J*(4-3*I));
var k=n-(1-r)*J*y*(w+r*R*(m+r*H*(-1+2*m*m)));
var e=Math.atan2(y,-M);
return new OpenLayers.LonLat(N+o.deg(k),o.deg(d))
};
OpenLayers.Util.getParameters=function(b){b=b||window.location.href;
var a="";
if(OpenLayers.String.contains(b,"?")){var c=b.indexOf("?")+1;
var e=OpenLayers.String.contains(b,"#")?b.indexOf("#"):b.length;
a=b.substring(c,e)
}var l={};
var d=a.split(/[&;]/);
for(var g=0,h=d.length;
g<h;
++g){var f=d[g].split("=");
if(f[0]){var k=decodeURIComponent(f[0]);
var j=f[1]||"";
j=decodeURIComponent(j.replace(/\+/g," ")).split(",");
if(j.length==1){j=j[0]
}l[k]=j
}}return l
};
OpenLayers.Util.getArgs=function(a){OpenLayers.Console.warn(OpenLayers.i18n("methodDeprecated",{newMethod:"OpenLayers.Util.getParameters"}));
return OpenLayers.Util.getParameters(a)
};
OpenLayers.Util.lastSeqID=0;
OpenLayers.Util.createUniqueID=function(a){if(a==null){a="id_"
}OpenLayers.Util.lastSeqID+=1;
return a+OpenLayers.Util.lastSeqID
};
OpenLayers.INCHES_PER_UNIT={inches:1,ft:12,mi:63360,m:39.3701,km:39370.1,dd:4374754,yd:36};
OpenLayers.INCHES_PER_UNIT["in"]=OpenLayers.INCHES_PER_UNIT.inches;
OpenLayers.INCHES_PER_UNIT.degrees=OpenLayers.INCHES_PER_UNIT.dd;
OpenLayers.INCHES_PER_UNIT.nmi=1852*OpenLayers.INCHES_PER_UNIT.m;
OpenLayers.METERS_PER_INCH=0.0254000508001016;
OpenLayers.Util.extend(OpenLayers.INCHES_PER_UNIT,{Inch:OpenLayers.INCHES_PER_UNIT.inches,Meter:1/OpenLayers.METERS_PER_INCH,Foot:0.3048006096012192/OpenLayers.METERS_PER_INCH,IFoot:0.3048/OpenLayers.METERS_PER_INCH,ClarkeFoot:0.3047972651151/OpenLayers.METERS_PER_INCH,SearsFoot:0.30479947153867626/OpenLayers.METERS_PER_INCH,GoldCoastFoot:0.3047997101815088/OpenLayers.METERS_PER_INCH,IInch:0.0254/OpenLayers.METERS_PER_INCH,MicroInch:0.0000254/OpenLayers.METERS_PER_INCH,Mil:2.54e-8/OpenLayers.METERS_PER_INCH,Centimeter:0.01/OpenLayers.METERS_PER_INCH,Kilometer:1000/OpenLayers.METERS_PER_INCH,Yard:0.9144018288036576/OpenLayers.METERS_PER_INCH,SearsYard:0.914398414616029/OpenLayers.METERS_PER_INCH,IndianYard:0.9143985307444408/OpenLayers.METERS_PER_INCH,IndianYd37:0.91439523/OpenLayers.METERS_PER_INCH,IndianYd62:0.9143988/OpenLayers.METERS_PER_INCH,IndianYd75:0.9143985/OpenLayers.METERS_PER_INCH,IndianFoot:0.30479951/OpenLayers.METERS_PER_INCH,IndianFt37:0.30479841/OpenLayers.METERS_PER_INCH,IndianFt62:0.3047996/OpenLayers.METERS_PER_INCH,IndianFt75:0.3047995/OpenLayers.METERS_PER_INCH,Mile:1609.3472186944373/OpenLayers.METERS_PER_INCH,IYard:0.9144/OpenLayers.METERS_PER_INCH,IMile:1609.344/OpenLayers.METERS_PER_INCH,NautM:1852/OpenLayers.METERS_PER_INCH,"Lat-66":110943.31648893273/OpenLayers.METERS_PER_INCH,"Lat-83":110946.25736872235/OpenLayers.METERS_PER_INCH,Decimeter:0.1/OpenLayers.METERS_PER_INCH,Millimeter:0.001/OpenLayers.METERS_PER_INCH,Dekameter:10/OpenLayers.METERS_PER_INCH,Decameter:10/OpenLayers.METERS_PER_INCH,Hectometer:100/OpenLayers.METERS_PER_INCH,GermanMeter:1.0000135965/OpenLayers.METERS_PER_INCH,CaGrid:0.999738/OpenLayers.METERS_PER_INCH,ClarkeChain:20.1166194976/OpenLayers.METERS_PER_INCH,GunterChain:20.11684023368047/OpenLayers.METERS_PER_INCH,BenoitChain:20.116782494375872/OpenLayers.METERS_PER_INCH,SearsChain:20.11676512155/OpenLayers.METERS_PER_INCH,ClarkeLink:0.201166194976/OpenLayers.METERS_PER_INCH,GunterLink:0.2011684023368047/OpenLayers.METERS_PER_INCH,BenoitLink:0.20116782494375873/OpenLayers.METERS_PER_INCH,SearsLink:0.2011676512155/OpenLayers.METERS_PER_INCH,Rod:5.02921005842012/OpenLayers.METERS_PER_INCH,IntnlChain:20.1168/OpenLayers.METERS_PER_INCH,IntnlLink:0.201168/OpenLayers.METERS_PER_INCH,Perch:5.02921005842012/OpenLayers.METERS_PER_INCH,Pole:5.02921005842012/OpenLayers.METERS_PER_INCH,Furlong:201.1684023368046/OpenLayers.METERS_PER_INCH,Rood:3.778266898/OpenLayers.METERS_PER_INCH,CapeFoot:0.3047972615/OpenLayers.METERS_PER_INCH,Brealey:375/OpenLayers.METERS_PER_INCH,ModAmFt:0.304812252984506/OpenLayers.METERS_PER_INCH,Fathom:1.8288/OpenLayers.METERS_PER_INCH,"NautM-UK":1853.184/OpenLayers.METERS_PER_INCH,"50kilometers":50000/OpenLayers.METERS_PER_INCH,"150kilometers":150000/OpenLayers.METERS_PER_INCH});
OpenLayers.Util.extend(OpenLayers.INCHES_PER_UNIT,{mm:OpenLayers.INCHES_PER_UNIT.Meter/1000,cm:OpenLayers.INCHES_PER_UNIT.Meter/100,dm:OpenLayers.INCHES_PER_UNIT.Meter*100,km:OpenLayers.INCHES_PER_UNIT.Meter*1000,kmi:OpenLayers.INCHES_PER_UNIT.nmi,fath:OpenLayers.INCHES_PER_UNIT.Fathom,ch:OpenLayers.INCHES_PER_UNIT.IntnlChain,link:OpenLayers.INCHES_PER_UNIT.IntnlLink,"us-in":OpenLayers.INCHES_PER_UNIT.inches,"us-ft":OpenLayers.INCHES_PER_UNIT.Foot,"us-yd":OpenLayers.INCHES_PER_UNIT.Yard,"us-ch":OpenLayers.INCHES_PER_UNIT.GunterChain,"us-mi":OpenLayers.INCHES_PER_UNIT.Mile,"ind-yd":OpenLayers.INCHES_PER_UNIT.IndianYd37,"ind-ft":OpenLayers.INCHES_PER_UNIT.IndianFt37,"ind-ch":20.11669506/OpenLayers.METERS_PER_INCH});
OpenLayers.DOTS_PER_INCH=72;
OpenLayers.Util.normalizeScale=function(b){var a=(b>1)?(1/b):b;
return a
};
OpenLayers.Util.getResolutionFromScale=function(d,a){var b;
if(d){if(a==null){a="degrees"
}var c=OpenLayers.Util.normalizeScale(d);
b=1/(c*OpenLayers.INCHES_PER_UNIT[a]*OpenLayers.DOTS_PER_INCH)
}return b
};
OpenLayers.Util.getScaleFromResolution=function(b,a){if(a==null){a="degrees"
}var c=b*OpenLayers.INCHES_PER_UNIT[a]*OpenLayers.DOTS_PER_INCH;
return c
};
OpenLayers.Util.safeStopPropagation=function(a){OpenLayers.Event.stop(a,true)
};
OpenLayers.Util.pagePosition=function(f){var a=0,d=0;
var b=f;
var g=f;
while(b){if(b==document.body){if(OpenLayers.Element.getStyle(g,"position")=="absolute"){break
}}a+=b.offsetTop||0;
d+=b.offsetLeft||0;
g=b;
try{b=b.offsetParent
}catch(c){OpenLayers.Console.error(OpenLayers.i18n("pagePositionFailed",{elemId:b.id}));
break
}}b=f;
while(b){a-=b.scrollTop||0;
d-=b.scrollLeft||0;
b=b.parentNode
}return[d,a]
};
OpenLayers.Util.isEquivalentUrl=function(f,e,c){c=c||{};
OpenLayers.Util.applyDefaults(c,{ignoreCase:true,ignorePort80:true,ignoreHash:true});
var b=OpenLayers.Util.createUrlObject(f,c);
var a=OpenLayers.Util.createUrlObject(e,c);
for(var d in b){if(d!=="args"){if(b[d]!=a[d]){return false
}}}for(var d in b.args){if(b.args[d]!=a.args[d]){return false
}delete a.args[d]
}for(var d in a.args){return false
}return true
};
OpenLayers.Util.createUrlObject=function(c,k){k=k||{};
if(!(/^\w+:\/\//).test(c)){var g=window.location;
var e=g.port?":"+g.port:"";
var h=g.protocol+"//"+g.host.split(":").shift()+e;
if(c.indexOf("/")===0){c=h+c
}else{var f=g.pathname.split("/");
f.pop();
c=h+f.join("/")+"/"+c
}}if(k.ignoreCase){c=c.toLowerCase()
}var i=document.createElement("a");
i.href=c;
var d={};
d.host=i.host.split(":").shift();
d.protocol=i.protocol;
if(k.ignorePort80){d.port=(i.port=="80"||i.port=="0")?"":i.port
}else{d.port=(i.port==""||i.port=="0")?"80":i.port
}d.hash=(k.ignoreHash||i.hash==="#")?"":i.hash;
var b=i.search;
if(!b){var j=c.indexOf("?");
b=(j!=-1)?c.substr(j):""
}d.args=OpenLayers.Util.getParameters(b);
d.pathname=(i.pathname.charAt(0)=="/")?i.pathname:"/"+i.pathname;
return d
};
OpenLayers.Util.removeTail=function(b){var c=null;
var a=b.indexOf("?");
var d=b.indexOf("#");
if(a==-1){c=(d!=-1)?b.substr(0,d):b
}else{c=(d!=-1)?b.substr(0,Math.min(a,d)):b.substr(0,a)
}return c
};
OpenLayers.Util.getBrowserName=function(){var b="";
var a=navigator.userAgent.toLowerCase();
if(a.indexOf("opera")!=-1){b="opera"
}else{if(a.indexOf("msie")!=-1){b="msie"
}else{if(a.indexOf("safari")!=-1){b="safari"
}else{if(a.indexOf("mozilla")!=-1){if(a.indexOf("firefox")!=-1){b="firefox"
}else{b="mozilla"
}}}}}return b
};
OpenLayers.Util.getRenderedDimensions=function(b,o,p){var k,e;
var a=document.createElement("div");
a.style.visibility="hidden";
var n=(p&&p.containerElement)?p.containerElement:document.body;
if(o){if(o.w){k=o.w;
a.style.width=k+"px"
}else{if(o.h){e=o.h;
a.style.height=e+"px"
}}}if(p&&p.displayClass){a.className=p.displayClass
}var f=document.createElement("div");
f.innerHTML=b;
f.style.overflow="visible";
if(f.childNodes){for(var d=0,c=f.childNodes.length;
d<c;
d++){if(!f.childNodes[d].style){continue
}f.childNodes[d].style.overflow="visible"
}}a.appendChild(f);
n.appendChild(a);
var m=false;
var j=a.parentNode;
while(j&&j.tagName.toLowerCase()!="body"){var g=OpenLayers.Element.getStyle(j,"position");
if(g=="absolute"){m=true;
break
}else{if(g&&g!="static"){break
}}j=j.parentNode
}if(!m){a.style.position="absolute"
}if(!k){k=parseInt(f.scrollWidth);
a.style.width=k+"px"
}if(!e){e=parseInt(f.scrollHeight)
}a.removeChild(f);
n.removeChild(a);
return new OpenLayers.Size(k,e)
};
OpenLayers.Util.getScrollbarWidth=function(){var c=OpenLayers.Util._scrollbarWidth;
if(c==null){var e=null;
var d=null;
var a=0;
var b=0;
e=document.createElement("div");
e.style.position="absolute";
e.style.top="-1000px";
e.style.left="-1000px";
e.style.width="100px";
e.style.height="50px";
e.style.overflow="hidden";
d=document.createElement("div");
d.style.width="100%";
d.style.height="200px";
e.appendChild(d);
document.body.appendChild(e);
a=d.offsetWidth;
e.style.overflow="scroll";
b=d.offsetWidth;
document.body.removeChild(document.body.lastChild);
OpenLayers.Util._scrollbarWidth=(a-b);
c=OpenLayers.Util._scrollbarWidth
}return c
};
OpenLayers.Util.getFormattedLonLat=function(h,b,e){if(!e){e="dms"
}var d=Math.abs(h);
var i=Math.floor(d);
var a=(d-i)/(1/60);
var c=a;
a=Math.floor(a);
var g=(c-a)/(1/60);
g=Math.round(g*10);
g/=10;
if(i<10){i="0"+i
}var f=i+"\u00B0";
if(e.indexOf("dm")>=0){if(a<10){a="0"+a
}f+=a+"'";
if(e.indexOf("dms")>=0){if(g<10){g="0"+g
}f+=g+'"'
}}if(b=="lon"){f+=h<0?OpenLayers.i18n("W"):OpenLayers.i18n("E")
}else{f+=h<0?OpenLayers.i18n("S"):OpenLayers.i18n("N")
}return f
};OpenLayers.String={startsWith:function(b,a){return(b.indexOf(a)==0)
},contains:function(b,a){return(b.indexOf(a)!=-1)
},trim:function(a){return a.replace(/^\s\s*/,"").replace(/\s\s*$/,"")
},camelize:function(f){var d=f.split("-");
var b=d[0];
for(var c=1,a=d.length;
c<a;
c++){var e=d[c];
b+=e.charAt(0).toUpperCase()+e.substring(1)
}return b
},format:function(d,c,a){if(!c){c=window
}var b=function(j,e){var h;
var g=e.split(/\.+/);
for(var f=0;
f<g.length;
f++){if(f==0){h=c
}h=h[g[f]]
}if(typeof h=="function"){h=a?h.apply(null,a):h()
}if(typeof h=="undefined"){return"undefined"
}else{return h
}};
return d.replace(OpenLayers.String.tokenRegEx,b)
},tokenRegEx:/\$\{([\w.]+?)\}/g,numberRegEx:/^([+-]?)(?=\d|\.\d)\d*(\.\d*)?([Ee]([+-]?\d+))?$/,isNumeric:function(a){return OpenLayers.String.numberRegEx.test(a)
},numericIf:function(a){return OpenLayers.String.isNumeric(a)?parseFloat(a):a
}};
if(!String.prototype.startsWith){String.prototype.startsWith=function(a){OpenLayers.Console.warn(OpenLayers.i18n("methodDeprecated",{newMethod:"OpenLayers.String.startsWith"}));
return OpenLayers.String.startsWith(this,a)
}
}if(!String.prototype.contains){String.prototype.contains=function(a){OpenLayers.Console.warn(OpenLayers.i18n("methodDeprecated",{newMethod:"OpenLayers.String.contains"}));
return OpenLayers.String.contains(this,a)
}
}if(!String.prototype.trim){String.prototype.trim=function(){OpenLayers.Console.warn(OpenLayers.i18n("methodDeprecated",{newMethod:"OpenLayers.String.trim"}));
return OpenLayers.String.trim(this)
}
}if(!String.prototype.camelize){String.prototype.camelize=function(){OpenLayers.Console.warn(OpenLayers.i18n("methodDeprecated",{newMethod:"OpenLayers.String.camelize"}));
return OpenLayers.String.camelize(this)
}
}OpenLayers.Number={decimalSeparator:".",thousandsSeparator:",",limitSigDigs:function(a,c){var b=0;
if(c>0){b=parseFloat(a.toPrecision(c))
}return b
},format:function(c,a,g,i){a=(typeof a!="undefined")?a:0;
g=(typeof g!="undefined")?g:OpenLayers.Number.thousandsSeparator;
i=(typeof i!="undefined")?i:OpenLayers.Number.decimalSeparator;
if(a!=null){c=parseFloat(c.toFixed(a))
}var b=c.toString().split(".");
if(b.length==1&&a==null){a=0
}var d=b[0];
if(g){var e=/(-?[0-9]+)([0-9]{3})/;
while(e.test(d)){d=d.replace(e,"$1"+g+"$2")
}}var f;
if(a==0){f=d
}else{var h=b.length>1?b[1]:"0";
if(a!=null){h=h+new Array(a-h.length+1).join("0")
}f=d+i+h
}return f
}};
if(!Number.prototype.limitSigDigs){Number.prototype.limitSigDigs=function(a){OpenLayers.Console.warn(OpenLayers.i18n("methodDeprecated",{newMethod:"OpenLayers.Number.limitSigDigs"}));
return OpenLayers.Number.limitSigDigs(this,a)
}
}OpenLayers.Function={bind:function(c,b){var a=Array.prototype.slice.apply(arguments,[2]);
return function(){var d=a.concat(Array.prototype.slice.apply(arguments,[0]));
return c.apply(b,d)
}
},bindAsEventListener:function(b,a){return function(c){return b.call(a,c||window.event)
}
},False:function(){return false
},True:function(){return true
}};
if(!Function.prototype.bind){Function.prototype.bind=function(){OpenLayers.Console.warn(OpenLayers.i18n("methodDeprecated",{newMethod:"OpenLayers.Function.bind"}));
Array.prototype.unshift.apply(arguments,[this]);
return OpenLayers.Function.bind.apply(null,arguments)
}
}if(!Function.prototype.bindAsEventListener){Function.prototype.bindAsEventListener=function(a){OpenLayers.Console.warn(OpenLayers.i18n("methodDeprecated",{newMethod:"OpenLayers.Function.bindAsEventListener"}));
return OpenLayers.Function.bindAsEventListener(this,a)
}
}OpenLayers.Array={filter:function(g,f,b){var d=[];
if(Array.prototype.filter){d=g.filter(f,b)
}else{var a=g.length;
if(typeof f!="function"){throw new TypeError()
}for(var c=0;
c<a;
c++){if(c in g){var e=g[c];
if(f.call(b,e,c,g)){d.push(e)
}}}}return d
}};
OpenLayers.Date={toISOString:(function(){if("toISOString" in Date.prototype){return function(b){return b.toISOString()
}
}else{function a(c,b){var d=c+"";
while(d.length<b){d="0"+d
}return d
}return function(b){var c;
if(isNaN(b.getTime())){c="Invalid Date"
}else{c=b.getUTCFullYear()+"-"+a(b.getUTCMonth()+1,2)+"-"+a(b.getUTCDate(),2)+"T"+a(b.getUTCHours(),2)+":"+a(b.getUTCMinutes(),2)+":"+a(b.getUTCSeconds(),2)+"."+a(b.getUTCMilliseconds(),3)+"Z"
}return c
}
}})(),parse:function(j){var b;
var p=Date.parse(j);
if(!isNaN(p)){b=new Date(p)
}else{var h=j.match(/^(?:(\d{4})(?:-(\d{2})(?:-(\d{2}))?)?)?(?:T(\d{1,2}):(\d{2}):(\d{2}(?:\.\d+)?)(Z|(?:[+-]\d{1,2}(?::(\d{2}))?)))?$/);
var b;
if(h&&(h[1]||h[7])){var k=parseInt(h[1],10)||0;
var i=(parseInt(h[2],10)-1)||0;
var m=parseInt(h[3],10)||1;
b=new Date(Date.UTC(k,i,m));
var l=h[7];
if(l){var n=parseInt(h[4],10);
var d=parseInt(h[5],10);
var a=parseFloat(h[6]);
var o=a|0;
var c=Math.round(1000*(a-o));
b.setUTCHours(n,d,o,c);
if(l!=="Z"){var g=parseInt(l,10);
var f=parseInt(h[8])||0;
var e=-1000*(60*(g*60)+f*60);
b=new Date(b.getTime()+e)
}}}else{b=new Date("invalid")
}}return b
}};OpenLayers.Class=function(){var e=function(){if(arguments&&arguments[0]!=OpenLayers.Class.isPrototype){this.initialize.apply(this,arguments)
}};
var c={};
var g,b,d;
for(var f=0,a=arguments.length;
f<a;
++f){d=arguments[f];
if(typeof d=="function"){if(f==0&&a>1){b=d.prototype.initialize;
d.prototype.initialize=function(){};
c=new d();
if(b===undefined){delete d.prototype.initialize
}else{d.prototype.initialize=b
}}g=d.prototype
}else{g=d
}OpenLayers.Util.extend(c,g)
}e.prototype=c;
return e
};
OpenLayers.Class.isPrototype=function(){};
OpenLayers.Class.create=function(){return function(){if(arguments&&arguments[0]!=OpenLayers.Class.isPrototype){this.initialize.apply(this,arguments)
}}
};
OpenLayers.Class.inherit=function(){var d=arguments[0];
var e=new d(OpenLayers.Class.isPrototype);
for(var c=1,a=arguments.length;
c<a;
c++){if(typeof arguments[c]=="function"){var b=arguments[c];
arguments[c]=new b(OpenLayers.Class.isPrototype)
}OpenLayers.Util.extend(e,arguments[c])
}return e
};OpenLayers.Bounds=OpenLayers.Class({left:null,bottom:null,right:null,top:null,centerLonLat:null,initialize:function(d,a,b,c){if(d!=null){this.left=OpenLayers.Util.toFloat(d)
}if(a!=null){this.bottom=OpenLayers.Util.toFloat(a)
}if(b!=null){this.right=OpenLayers.Util.toFloat(b)
}if(c!=null){this.top=OpenLayers.Util.toFloat(c)
}},clone:function(){return new OpenLayers.Bounds(this.left,this.bottom,this.right,this.top)
},equals:function(b){var a=false;
if(b!=null){a=((this.left==b.left)&&(this.right==b.right)&&(this.top==b.top)&&(this.bottom==b.bottom))
}return a
},toString:function(){return("left-bottom=("+this.left+","+this.bottom+") right-top=("+this.right+","+this.top+")")
},toArray:function(a){if(a===true){return[this.bottom,this.left,this.top,this.right]
}else{return[this.left,this.bottom,this.right,this.top]
}},toBBOX:function(b,e){if(b==null){b=6
}var g=Math.pow(10,b);
var f=Math.round(this.left*g)/g;
var d=Math.round(this.bottom*g)/g;
var c=Math.round(this.right*g)/g;
var a=Math.round(this.top*g)/g;
if(e===true){return d+","+f+","+a+","+c
}else{return f+","+d+","+c+","+a
}},toGeometry:function(){return new OpenLayers.Geometry.Polygon([new OpenLayers.Geometry.LinearRing([new OpenLayers.Geometry.Point(this.left,this.bottom),new OpenLayers.Geometry.Point(this.right,this.bottom),new OpenLayers.Geometry.Point(this.right,this.top),new OpenLayers.Geometry.Point(this.left,this.top)])])
},getWidth:function(){return(this.right-this.left)
},getHeight:function(){return(this.top-this.bottom)
},getSize:function(){return new OpenLayers.Size(this.getWidth(),this.getHeight())
},getCenterPixel:function(){return new OpenLayers.Pixel((this.left+this.right)/2,(this.bottom+this.top)/2)
},getCenterLonLat:function(){if(!this.centerLonLat){this.centerLonLat=new OpenLayers.LonLat((this.left+this.right)/2,(this.bottom+this.top)/2)
}return this.centerLonLat
},scale:function(e,c){if(c==null){c=this.getCenterLonLat()
}var a,h;
if(c.CLASS_NAME=="OpenLayers.LonLat"){a=c.lon;
h=c.lat
}else{a=c.x;
h=c.y
}var g=(this.left-a)*e+a;
var b=(this.bottom-h)*e+h;
var d=(this.right-a)*e+a;
var f=(this.top-h)*e+h;
return new OpenLayers.Bounds(g,b,d,f)
},add:function(a,c){if((a==null)||(c==null)){var b=OpenLayers.i18n("boundsAddError");
OpenLayers.Console.error(b);
return null
}return new OpenLayers.Bounds(this.left+a,this.bottom+c,this.right+a,this.top+c)
},extend:function(a){var b=null;
if(a){switch(a.CLASS_NAME){case"OpenLayers.LonLat":b=new OpenLayers.Bounds(a.lon,a.lat,a.lon,a.lat);
break;
case"OpenLayers.Geometry.Point":b=new OpenLayers.Bounds(a.x,a.y,a.x,a.y);
break;
case"OpenLayers.Bounds":b=a;
break
}if(b){this.centerLonLat=null;
if((this.left==null)||(b.left<this.left)){this.left=b.left
}if((this.bottom==null)||(b.bottom<this.bottom)){this.bottom=b.bottom
}if((this.right==null)||(b.right>this.right)){this.right=b.right
}if((this.top==null)||(b.top>this.top)){this.top=b.top
}}}},containsLonLat:function(b,a){return this.contains(b.lon,b.lat,a)
},containsPixel:function(b,a){return this.contains(b.x,b.y,a)
},contains:function(b,d,a){if(a==null){a=true
}if(b==null||d==null){return false
}b=OpenLayers.Util.toFloat(b);
d=OpenLayers.Util.toFloat(d);
var c=false;
if(a){c=((b>=this.left)&&(b<=this.right)&&(d>=this.bottom)&&(d<=this.top))
}else{c=((b>this.left)&&(b<this.right)&&(d>this.bottom)&&(d<this.top))
}return c
},intersectsBounds:function(e,b){if(b==null){b=true
}var d=false;
var h=(this.left==e.right||this.right==e.left||this.top==e.bottom||this.bottom==e.top);
if(b||!h){var g=(((e.bottom>=this.bottom)&&(e.bottom<=this.top))||((this.bottom>=e.bottom)&&(this.bottom<=e.top)));
var f=(((e.top>=this.bottom)&&(e.top<=this.top))||((this.top>e.bottom)&&(this.top<e.top)));
var c=(((e.left>=this.left)&&(e.left<=this.right))||((this.left>=e.left)&&(this.left<=e.right)));
var a=(((e.right>=this.left)&&(e.right<=this.right))||((this.right>=e.left)&&(this.right<=e.right)));
d=((g||f)&&(c||a))
}return d
},containsBounds:function(g,b,a){if(b==null){b=false
}if(a==null){a=true
}var c=this.contains(g.left,g.bottom,a);
var d=this.contains(g.right,g.bottom,a);
var f=this.contains(g.left,g.top,a);
var e=this.contains(g.right,g.top,a);
return(b)?(c||d||f||e):(c&&d&&f&&e)
},determineQuadrant:function(c){var b="";
var a=this.getCenterLonLat();
b+=(c.lat<a.lat)?"b":"t";
b+=(c.lon<a.lon)?"l":"r";
return b
},transform:function(d,b){this.centerLonLat=null;
var e=OpenLayers.Projection.transform({x:this.left,y:this.bottom},d,b);
var a=OpenLayers.Projection.transform({x:this.right,y:this.bottom},d,b);
var c=OpenLayers.Projection.transform({x:this.left,y:this.top},d,b);
var f=OpenLayers.Projection.transform({x:this.right,y:this.top},d,b);
this.left=Math.min(e.x,c.x);
this.bottom=Math.min(e.y,a.y);
this.right=Math.max(a.x,f.x);
this.top=Math.max(c.y,f.y);
return this
},wrapDateLine:function(a,c){c=c||{};
var d=c.leftTolerance||0;
var b=c.rightTolerance||0;
var e=this.clone();
if(a){while(e.left<a.left&&(e.right-b)<=a.left){e=e.add(a.getWidth(),0)
}while((e.left+d)>=a.right&&e.right>a.right){e=e.add(-a.getWidth(),0)
}}return e
},CLASS_NAME:"OpenLayers.Bounds"});
OpenLayers.Bounds.fromString=function(b){var a=b.split(",");
return OpenLayers.Bounds.fromArray(a)
};
OpenLayers.Bounds.fromArray=function(a){return new OpenLayers.Bounds(parseFloat(a[0]),parseFloat(a[1]),parseFloat(a[2]),parseFloat(a[3]))
};
OpenLayers.Bounds.fromSize=function(a){return new OpenLayers.Bounds(0,a.h,a.w,0)
};
OpenLayers.Bounds.oppositeQuadrant=function(a){var b="";
b+=(a.charAt(0)=="t")?"b":"t";
b+=(a.charAt(1)=="l")?"r":"l";
return b
};OpenLayers.Rico=new Object();
OpenLayers.Rico.Corner={round:function(d,b){d=OpenLayers.Util.getElement(d);
this._setOptions(b);
var a=this.options.color;
if(this.options.color=="fromElement"){a=this._background(d)
}var c=this.options.bgColor;
if(this.options.bgColor=="fromParent"){c=this._background(d.offsetParent)
}this._roundCornersImpl(d,a,c)
},changeColor:function(c,b){c.style.backgroundColor=b;
var a=c.parentNode.getElementsByTagName("span");
for(var d=0;
d<a.length;
d++){a[d].style.backgroundColor=b
}},changeOpacity:function(c,f){var d=f;
var a="alpha(opacity="+f*100+")";
c.style.opacity=d;
c.style.filter=a;
var b=c.parentNode.getElementsByTagName("span");
for(var e=0;
e<b.length;
e++){b[e].style.opacity=d;
b[e].style.filter=a
}},reRound:function(d,c){var b=d.parentNode.childNodes[0];
var a=d.parentNode.childNodes[2];
d.parentNode.removeChild(b);
d.parentNode.removeChild(a);
this.round(d.parentNode,c)
},_roundCornersImpl:function(c,a,b){if(this.options.border){this._renderBorder(c,b)
}if(this._isTopRounded()){this._roundTopCorners(c,a,b)
}if(this._isBottomRounded()){this._roundBottomCorners(c,a,b)
}},_renderBorder:function(d,e){var b="1px solid "+this._borderColor(e);
var a="border-left: "+b;
var f="border-right: "+b;
var c="style='"+a+";"+f+"'";
d.innerHTML="<div "+c+">"+d.innerHTML+"</div>"
},_roundTopCorners:function(c,a,e){var d=this._createCorner(e);
for(var b=0;
b<this.options.numSlices;
b++){d.appendChild(this._createCornerSlice(a,e,b,"top"))
}c.style.paddingTop=0;
c.insertBefore(d,c.firstChild)
},_roundBottomCorners:function(c,a,e){var d=this._createCorner(e);
for(var b=(this.options.numSlices-1);
b>=0;
b--){d.appendChild(this._createCornerSlice(a,e,b,"bottom"))
}c.style.paddingBottom=0;
c.appendChild(d)
},_createCorner:function(b){var a=document.createElement("div");
a.style.backgroundColor=(this._isTransparent()?"transparent":b);
return a
},_createCornerSlice:function(c,d,g,a){var e=document.createElement("span");
var b=e.style;
b.backgroundColor=c;
b.display="block";
b.height="1px";
b.overflow="hidden";
b.fontSize="1px";
var f=this._borderColor(c,d);
if(this.options.border&&g==0){b.borderTopStyle="solid";
b.borderTopWidth="1px";
b.borderLeftWidth="0px";
b.borderRightWidth="0px";
b.borderBottomWidth="0px";
b.height="0px";
b.borderColor=f
}else{if(f){b.borderColor=f;
b.borderStyle="solid";
b.borderWidth="0px 1px"
}}if(!this.options.compact&&(g==(this.options.numSlices-1))){b.height="2px"
}this._setMargin(e,g,a);
this._setBorder(e,g,a);
return e
},_setOptions:function(a){this.options={corners:"all",color:"fromElement",bgColor:"fromParent",blend:true,border:false,compact:false};
OpenLayers.Util.extend(this.options,a||{});
this.options.numSlices=this.options.compact?2:4;
if(this._isTransparent()){this.options.blend=false
}},_whichSideTop:function(){if(this._hasString(this.options.corners,"all","top")){return""
}if(this.options.corners.indexOf("tl")>=0&&this.options.corners.indexOf("tr")>=0){return""
}if(this.options.corners.indexOf("tl")>=0){return"left"
}else{if(this.options.corners.indexOf("tr")>=0){return"right"
}}return""
},_whichSideBottom:function(){if(this._hasString(this.options.corners,"all","bottom")){return""
}if(this.options.corners.indexOf("bl")>=0&&this.options.corners.indexOf("br")>=0){return""
}if(this.options.corners.indexOf("bl")>=0){return"left"
}else{if(this.options.corners.indexOf("br")>=0){return"right"
}}return""
},_borderColor:function(a,b){if(a=="transparent"){return b
}else{if(this.options.border){return this.options.border
}else{if(this.options.blend){return this._blend(b,a)
}else{return""
}}}},_setMargin:function(d,e,b){var c=this._marginSize(e);
var a=b=="top"?this._whichSideTop():this._whichSideBottom();
if(a=="left"){d.style.marginLeft=c+"px";
d.style.marginRight="0px"
}else{if(a=="right"){d.style.marginRight=c+"px";
d.style.marginLeft="0px"
}else{d.style.marginLeft=c+"px";
d.style.marginRight=c+"px"
}}},_setBorder:function(d,e,b){var c=this._borderSize(e);
var a=b=="top"?this._whichSideTop():this._whichSideBottom();
if(a=="left"){d.style.borderLeftWidth=c+"px";
d.style.borderRightWidth="0px"
}else{if(a=="right"){d.style.borderRightWidth=c+"px";
d.style.borderLeftWidth="0px"
}else{d.style.borderLeftWidth=c+"px";
d.style.borderRightWidth=c+"px"
}}if(this.options.border!=false){d.style.borderLeftWidth=c+"px";
d.style.borderRightWidth=c+"px"
}},_marginSize:function(e){if(this._isTransparent()){return 0
}var d=[5,3,2,1];
var a=[3,2,1,0];
var c=[2,1];
var b=[1,0];
if(this.options.compact&&this.options.blend){return b[e]
}else{if(this.options.compact){return c[e]
}else{if(this.options.blend){return a[e]
}else{return d[e]
}}}},_borderSize:function(e){var d=[5,3,2,1];
var b=[2,1,1,1];
var a=[1,0];
var c=[0,2,0,0];
if(this.options.compact&&(this.options.blend||this._isTransparent())){return 1
}else{if(this.options.compact){return a[e]
}else{if(this.options.blend){return b[e]
}else{if(this.options.border){return c[e]
}else{if(this._isTransparent()){return d[e]
}}}}}return 0
},_hasString:function(b){for(var a=1;
a<arguments.length;
a++){if(b.indexOf(arguments[a])>=0){return true
}}return false
},_blend:function(c,a){var b=OpenLayers.Rico.Color.createFromHex(c);
b.blend(OpenLayers.Rico.Color.createFromHex(a));
return b
},_background:function(a){try{return OpenLayers.Rico.Color.createColorFromBackground(a).asHex()
}catch(b){return"#ffffff"
}},_isTransparent:function(){return this.options.color=="transparent"
},_isTopRounded:function(){return this._hasString(this.options.corners,"all","top","tl","tr")
},_isBottomRounded:function(){return this._hasString(this.options.corners,"all","bottom","bl","br")
},_hasSingleTextChild:function(a){return a.childNodes.length==1&&a.childNodes[0].nodeType==3
}};Ext.namespace("GeoExt");
GeoExt.singleFile=true;(function(){var j=(typeof GeoExt=="object"&&GeoExt.singleFile);
var a=j?"GeoExt.js":"lib/GeoExt.js";
var k=function(){var s="";
var o=document.documentElement.getElementsByTagName("script");
for(var q=0,h=o.length;
q<h;
q++){var t=o[q].getAttribute("src");
if(t){var p=t.lastIndexOf(a);
var r=t.lastIndexOf("?");
if(r<0){r=t.length
}if((p>-1)&&(p+a.length==r)){s=t.slice(0,r-a.length);
break
}}}return s
};
if(!j){var l=new Array("GeoExt/data/AttributeReader.js","GeoExt/data/AttributeStore.js","GeoExt/data/FeatureRecord.js","GeoExt/data/FeatureReader.js","GeoExt/data/FeatureStore.js","GeoExt/data/LayerRecord.js","GeoExt/data/LayerReader.js","GeoExt/data/LayerStore.js","GeoExt/data/ScaleStore.js","GeoExt/data/WMSCapabilitiesReader.js","GeoExt/data/WMSCapabilitiesStore.js","GeoExt/data/WFSCapabilitiesReader.js","GeoExt/data/WFSCapabilitiesStore.js","GeoExt/data/WMSDescribeLayerReader.js","GeoExt/data/WMSDescribeLayerStore.js","GeoExt/data/WMCReader.js","GeoExt/widgets/Action.js","GeoExt/data/ProtocolProxy.js","GeoExt/widgets/MapPanel.js","GeoExt/widgets/Popup.js","GeoExt/widgets/form.js","GeoExt/widgets/form/SearchAction.js","GeoExt/widgets/form/BasicForm.js","GeoExt/widgets/form/FormPanel.js","GeoExt/widgets/tips/SliderTip.js","GeoExt/widgets/tips/LayerOpacitySliderTip.js","GeoExt/widgets/tips/ZoomSliderTip.js","GeoExt/widgets/tree/LayerNode.js","GeoExt/widgets/tree/LayerLoader.js","GeoExt/widgets/tree/LayerContainer.js","GeoExt/widgets/tree/BaseLayerContainer.js","GeoExt/widgets/tree/OverlayLayerContainer.js","GeoExt/widgets/tree/LayerParamNode.js","GeoExt/widgets/tree/LayerParamLoader.js","GeoExt/widgets/LayerOpacitySlider.js","GeoExt/widgets/LegendImage.js","GeoExt/widgets/LegendWMS.js","GeoExt/widgets/LegendPanel.js","GeoExt/widgets/ZoomSlider.js","GeoExt/widgets/grid/FeatureSelectionModel.js");
var c=navigator.userAgent;
var e=(c.match("MSIE")||c.match("Safari"));
if(e){var b=new Array(l.length)
}var m=k()+"lib/";
for(var d=0,g=l.length;
d<g;
d++){if(e){b[d]="<script src='"+m+l[d]+"'><\/script>"
}else{var n=document.createElement("script");
n.src=m+l[d];
var f=document.getElementsByTagName("head").length?document.getElementsByTagName("head")[0]:document.body;
f.appendChild(n)
}}if(e){document.write(b.join(""))
}}})();OpenLayers.Console={log:function(){},debug:function(){},info:function(){},warn:function(){},error:function(){},userError:function(a){alert(a)
},assert:function(){},dir:function(){},dirxml:function(){},trace:function(){},group:function(){},groupEnd:function(){},time:function(){},timeEnd:function(){},profile:function(){},profileEnd:function(){},count:function(){},CLASS_NAME:"OpenLayers.Console"};
(function(){var b=document.getElementsByTagName("script");
for(var c=0,a=b.length;
c<a;
++c){if(b[c].src.indexOf("firebug.js")!=-1){if(console){OpenLayers.Util.extend(OpenLayers.Console,console);
break
}}}})();OpenLayers.Format=OpenLayers.Class({options:null,externalProjection:null,internalProjection:null,data:null,keepData:false,initialize:function(a){OpenLayers.Util.extend(this,a);
this.options=a
},destroy:function(){},read:function(a){OpenLayers.Console.userError(OpenLayers.i18n("readNotImplemented"))
},write:function(a){OpenLayers.Console.userError(OpenLayers.i18n("writeNotImplemented"))
},CLASS_NAME:"OpenLayers.Format"});OpenLayers.Format.CSWGetRecords=function(b){b=OpenLayers.Util.applyDefaults(b,OpenLayers.Format.CSWGetRecords.DEFAULTS);
var a=OpenLayers.Format.CSWGetRecords["v"+b.version.replace(/\./g,"_")];
if(!a){throw"Unsupported CSWGetRecords version: "+b.version
}return new a(b)
};
OpenLayers.Format.CSWGetRecords.DEFAULTS={version:"2.0.2"};Ext.namespace("GeoExt.data");
GeoExt.data.WMSCapabilitiesReader=function(a,b){a=a||{};
if(!a.format){a.format=new OpenLayers.Format.WMSCapabilities()
}if(typeof b!=="function"){b=GeoExt.data.LayerRecord.create(b||a.fields||[{name:"name",type:"string"},{name:"title",type:"string"},{name:"abstract",type:"string"},{name:"queryable",type:"boolean"},{name:"opaque",type:"boolean"},{name:"noSubsets",type:"boolean"},{name:"cascaded",type:"int"},{name:"fixedWidth",type:"int"},{name:"fixedHeight",type:"int"},{name:"minScale",type:"float"},{name:"maxScale",type:"float"},{name:"prefix",type:"string"},{name:"formats"},{name:"styles"},{name:"srs"},{name:"dimensions"},{name:"bbox"},{name:"llbbox"},{name:"attribution"},{name:"keywords"},{name:"identifiers"},{name:"authorityURLs"},{name:"metadataURLs"}])
}GeoExt.data.WMSCapabilitiesReader.superclass.constructor.call(this,a,b)
};
Ext.extend(GeoExt.data.WMSCapabilitiesReader,Ext.data.DataReader,{attributionCls:"gx-attribution",read:function(a){var b=a.responseXML;
if(!b||!b.documentElement){b=a.responseText
}return this.readRecords(b)
},serviceExceptionFormat:function(a){if(OpenLayers.Util.indexOf(a,"application/vnd.ogc.se_inimage")>-1){return"application/vnd.ogc.se_inimage"
}if(OpenLayers.Util.indexOf(a,"application/vnd.ogc.se_xml")>-1){return"application/vnd.ogc.se_xml"
}return a[0]
},imageFormat:function(b){var a=b.formats;
if(b.opaque&&OpenLayers.Util.indexOf(a,"image/jpeg")>-1){return"image/jpeg"
}if(OpenLayers.Util.indexOf(a,"image/png")>-1){return"image/png"
}if(OpenLayers.Util.indexOf(a,"image/png; mode=24bit")>-1){return"image/png; mode=24bit"
}if(OpenLayers.Util.indexOf(a,"image/gif")>-1){return"image/gif"
}return a[0]
},imageTransparent:function(a){return a.opaque==undefined||!a.opaque
},readRecords:function(t){if(typeof t==="string"||t.nodeType){t=this.meta.format.read(t)
}var e=t.version;
var c=t.capability||{};
var f=c.request&&c.request.getmap&&c.request.getmap.href;
var h=c.layers;
var g=c.exception?c.exception.formats:[];
var p=this.serviceExceptionFormat(g);
var o=[];
if(f&&h){var l=this.recordType.prototype.fields;
var s,b,d,a,k;
for(var n=0,r=h.length;
n<r;
n++){s=h[n];
if(s.name){b={};
for(var m=0,q=l.length;
m<q;
m++){a=l.items[m];
k=s[a.mapping||a.name]||a.defaultValue;
k=a.convert(k);
b[a.name]=k
}d={attribution:s.attribution?this.attributionMarkup(s.attribution):undefined,minScale:s.minScale,maxScale:s.maxScale};
if(this.meta.layerOptions){Ext.apply(d,this.meta.layerOptions)
}b.layer=new OpenLayers.Layer.WMS(s.title||s.name,f,{layers:s.name,exceptions:p,format:this.imageFormat(s),transparent:this.imageTransparent(s),version:e},d);
o.push(new this.recordType(b,b.layer.id))
}}}return{totalRecords:o.length,success:true,records:o}
},attributionMarkup:function(a){var b=[];
if(a.logo){b.push("<img class='"+this.attributionCls+"-image' src='"+a.logo.href+"' />")
}if(a.title){b.push("<span class='"+this.attributionCls+"-title'>"+a.title+"</span>")
}if(a.href){for(var c=0;
c<b.length;
c++){b[c]="<a class='"+this.attributionCls+"-link' href="+a.href+">"+b[c]+"</a>"
}}return b.join(" ")
}});Ext.namespace("GeoExt.data");
GeoExt.data.LayerStoreMixin={map:null,reader:null,constructor:function(b){b=b||{};
b.reader=b.reader||new GeoExt.data.LayerReader({},b.fields);
delete b.fields;
var c=b.map instanceof GeoExt.MapPanel?b.map.map:b.map;
delete b.map;
if(b.layers){b.data=b.layers
}delete b.layers;
var a={initDir:b.initDir};
delete b.initDir;
arguments.callee.superclass.constructor.call(this,b);
if(c){this.bind(c,a)
}},bind:function(d,a){if(this.map){return
}this.map=d;
a=a||{};
var b=a.initDir;
if(a.initDir==undefined){b=GeoExt.data.LayerStore.MAP_TO_STORE|GeoExt.data.LayerStore.STORE_TO_MAP
}var c=d.layers.slice(0);
if(b&GeoExt.data.LayerStore.STORE_TO_MAP){this.each(function(e){this.map.addLayer(e.get("layer"))
},this)
}if(b&GeoExt.data.LayerStore.MAP_TO_STORE){this.loadData(c,true)
}d.events.on({changelayer:this.onChangeLayer,addlayer:this.onAddLayer,removelayer:this.onRemoveLayer,scope:this});
this.on({load:this.onLoad,clear:this.onClear,add:this.onAdd,remove:this.onRemove,update:this.onUpdate,scope:this});
this.data.on({replace:this.onReplace,scope:this})
},unbind:function(){if(this.map){this.map.events.un({changelayer:this.onChangeLayer,addlayer:this.onAddLayer,removelayer:this.onRemoveLayer,scope:this});
this.un("load",this.onLoad,this);
this.un("clear",this.onClear,this);
this.un("add",this.onAdd,this);
this.un("remove",this.onRemove,this);
this.data.un("replace",this.onReplace,this);
this.map=null
}},onChangeLayer:function(b){var e=b.layer;
var c=this.findBy(function(f,g){return f.get("layer")===e
});
if(c>-1){var a=this.getAt(c);
if(b.property==="order"){if(!this._adding&&!this._removing){var d=this.map.getLayerIndex(e);
if(d!==c){this._removing=true;
this.remove(a);
delete this._removing;
this._adding=true;
this.insert(d,[a]);
delete this._adding
}}}else{if(b.property==="name"){a.set("title",e.name)
}else{this.fireEvent("update",this,a,Ext.data.Record.EDIT)
}}}},onAddLayer:function(a){if(!this._adding){var b=a.layer;
this._adding=true;
this.loadData([b],true);
delete this._adding
}},onRemoveLayer:function(a){if(this.map.unloadDestroy){if(!this._removing){var b=a.layer;
this._removing=true;
this.remove(this.getById(b.id));
delete this._removing
}}else{this.unbind()
}},onLoad:function(c,b,e){if(!Ext.isArray(b)){b=[b]
}if(e&&!e.add){this._removing=true;
for(var f=this.map.layers.length-1;
f>=0;
f--){this.map.removeLayer(this.map.layers[f])
}delete this._removing;
var a=b.length;
if(a>0){var g=new Array(a);
for(var d=0;
d<a;
d++){g[d]=b[d].get("layer")
}this._adding=true;
this.map.addLayers(g);
delete this._adding
}}},onClear:function(a){this._removing=true;
for(var b=this.map.layers.length-1;
b>=0;
b--){this.map.removeLayer(this.map.layers[b])
}delete this._removing
},onAdd:function(b,a,c){if(!this._adding){this._adding=true;
var e;
for(var d=a.length-1;
d>=0;
--d){e=a[d].get("layer");
this.map.addLayer(e);
if(c!==this.map.layers.length-1){this.map.setLayerIndex(e,c)
}}delete this._adding
}},onRemove:function(b,a,c){if(!this._removing){var d=a.get("layer");
if(this.map.getLayer(d.id)!=null){this._removing=true;
this.removeMapLayer(a);
delete this._removing
}}},onUpdate:function(c,a,b){if(b===Ext.data.Record.EDIT){var d=a.get("layer");
var e=a.get("title");
if(e!==d.name){d.setName(e)
}}},removeMapLayer:function(a){this.map.removeLayer(a.get("layer"))
},onReplace:function(c,a,b){this.removeMapLayer(a)
},destroy:function(){this.unbind();
GeoExt.data.LayerStore.superclass.destroy.call(this)
}};
GeoExt.data.LayerStore=Ext.extend(Ext.data.Store,GeoExt.data.LayerStoreMixin);
GeoExt.data.LayerStore.MAP_TO_STORE=1;
GeoExt.data.LayerStore.STORE_TO_MAP=2;OpenLayers.Event={observers:false,KEY_BACKSPACE:8,KEY_TAB:9,KEY_RETURN:13,KEY_ESC:27,KEY_LEFT:37,KEY_UP:38,KEY_RIGHT:39,KEY_DOWN:40,KEY_DELETE:46,element:function(a){return a.target||a.srcElement
},isLeftClick:function(a){return(((a.which)&&(a.which==1))||((a.button)&&(a.button==1)))
},isRightClick:function(a){return(((a.which)&&(a.which==3))||((a.button)&&(a.button==2)))
},stop:function(b,a){if(!a){if(b.preventDefault){b.preventDefault()
}else{b.returnValue=false
}}if(b.stopPropagation){b.stopPropagation()
}else{b.cancelBubble=true
}},findElement:function(c,b){var a=OpenLayers.Event.element(c);
while(a.parentNode&&(!a.tagName||(a.tagName.toUpperCase()!=b.toUpperCase()))){a=a.parentNode
}return a
},observe:function(b,d,c,a){var e=OpenLayers.Util.getElement(b);
a=a||false;
if(d=="keypress"&&(navigator.appVersion.match(/Konqueror|Safari|KHTML/)||e.attachEvent)){d="keydown"
}if(!this.observers){this.observers={}
}if(!e._eventCacheID){var f="eventCacheID_";
if(e.id){f=e.id+"_"+f
}e._eventCacheID=OpenLayers.Util.createUniqueID(f)
}var g=e._eventCacheID;
if(!this.observers[g]){this.observers[g]=[]
}this.observers[g].push({element:e,name:d,observer:c,useCapture:a});
if(e.addEventListener){e.addEventListener(d,c,a)
}else{if(e.attachEvent){e.attachEvent("on"+d,c)
}}},stopObservingElement:function(a){var b=OpenLayers.Util.getElement(a);
var c=b._eventCacheID;
this._removeElementObservers(OpenLayers.Event.observers[c])
},_removeElementObservers:function(e){if(e){for(var b=e.length-1;
b>=0;
b--){var c=e[b];
var a=new Array(c.element,c.name,c.observer,c.useCapture);
var d=OpenLayers.Event.stopObserving.apply(this,a)
}}},stopObserving:function(h,a,g,b){b=b||false;
var f=OpenLayers.Util.getElement(h);
var d=f._eventCacheID;
if(a=="keypress"){if(navigator.appVersion.match(/Konqueror|Safari|KHTML/)||f.detachEvent){a="keydown"
}}var k=false;
var c=OpenLayers.Event.observers[d];
if(c){var e=0;
while(!k&&e<c.length){var j=c[e];
if((j.name==a)&&(j.observer==g)&&(j.useCapture==b)){c.splice(e,1);
if(c.length==0){delete OpenLayers.Event.observers[d]
}k=true;
break
}e++
}}if(k){if(f.removeEventListener){f.removeEventListener(a,g,b)
}else{if(f&&f.detachEvent){f.detachEvent("on"+a,g)
}}}return k
},unloadCache:function(){if(OpenLayers.Event&&OpenLayers.Event.observers){for(var a in OpenLayers.Event.observers){var b=OpenLayers.Event.observers[a];
OpenLayers.Event._removeElementObservers.apply(this,[b])
}OpenLayers.Event.observers=false
}},CLASS_NAME:"OpenLayers.Event"};
OpenLayers.Event.observe(window,"unload",OpenLayers.Event.unloadCache,false);
if(window.Event){OpenLayers.Util.applyDefaults(window.Event,OpenLayers.Event)
}else{var Event=OpenLayers.Event
}OpenLayers.Events=OpenLayers.Class({BROWSER_EVENTS:["mouseover","mouseout","mousedown","mouseup","mousemove","click","dblclick","rightclick","dblrightclick","resize","focus","blur"],listeners:null,object:null,element:null,eventTypes:null,eventHandler:null,fallThrough:null,includeXY:false,clearMouseListener:null,initialize:function(c,e,g,f,b){OpenLayers.Util.extend(this,b);
this.object=c;
this.fallThrough=f;
this.listeners={};
this.eventHandler=OpenLayers.Function.bindAsEventListener(this.handleBrowserEvent,this);
this.clearMouseListener=OpenLayers.Function.bind(this.clearMouseCache,this);
this.eventTypes=[];
if(g!=null){for(var d=0,a=g.length;
d<a;
d++){this.addEventType(g[d])
}}if(e!=null){this.attachToElement(e)
}},destroy:function(){if(this.element){OpenLayers.Event.stopObservingElement(this.element);
if(this.element.hasScrollEvent){OpenLayers.Event.stopObserving(window,"scroll",this.clearMouseListener)
}}this.element=null;
this.listeners=null;
this.object=null;
this.eventTypes=null;
this.fallThrough=null;
this.eventHandler=null
},addEventType:function(a){if(!this.listeners[a]){this.eventTypes.push(a);
this.listeners[a]=[]
}},attachToElement:function(d){if(this.element){OpenLayers.Event.stopObservingElement(this.element)
}this.element=d;
for(var c=0,a=this.BROWSER_EVENTS.length;
c<a;
c++){var b=this.BROWSER_EVENTS[c];
this.addEventType(b);
OpenLayers.Event.observe(d,b,this.eventHandler)
}OpenLayers.Event.observe(d,"dragstart",OpenLayers.Event.stop)
},on:function(a){for(var b in a){if(b!="scope"){this.register(b,a.scope,a[b])
}}},register:function(b,d,c){if((c!=null)&&(OpenLayers.Util.indexOf(this.eventTypes,b)!=-1)){if(d==null){d=this.object
}var a=this.listeners[b];
a.push({obj:d,func:c})
}},registerPriority:function(b,d,c){if(c!=null){if(d==null){d=this.object
}var a=this.listeners[b];
if(a!=null){a.unshift({obj:d,func:c})
}}},un:function(a){for(var b in a){if(b!="scope"){this.unregister(b,a.scope,a[b])
}}},unregister:function(d,f,e){if(f==null){f=this.object
}var c=this.listeners[d];
if(c!=null){for(var b=0,a=c.length;
b<a;
b++){if(c[b].obj==f&&c[b].func==e){c.splice(b,1);
break
}}}},remove:function(a){if(this.listeners[a]!=null){this.listeners[a]=[]
}},triggerEvent:function(e,b){var d=this.listeners[e];
if(!d||d.length==0){return
}if(b==null){b={}
}b.object=this.object;
b.element=this.element;
if(!b.type){b.type=e
}var d=d.slice(),f;
for(var c=0,a=d.length;
c<a;
c++){var g=d[c];
f=g.func.apply(g.obj,[b]);
if((f!=undefined)&&(f==false)){break
}}if(!this.fallThrough){OpenLayers.Event.stop(b,true)
}return f
},handleBrowserEvent:function(a){if(this.includeXY){a.xy=this.getMousePosition(a)
}this.triggerEvent(a.type,a)
},clearMouseCache:function(){this.element.scrolls=null;
this.element.lefttop=null;
this.element.offsets=null
},getMousePosition:function(a){if(!this.includeXY){this.clearMouseCache()
}else{if(!this.element.hasScrollEvent){OpenLayers.Event.observe(window,"scroll",this.clearMouseListener);
this.element.hasScrollEvent=true
}}if(!this.element.scrolls){this.element.scrolls=[(document.documentElement.scrollLeft||document.body.scrollLeft),(document.documentElement.scrollTop||document.body.scrollTop)]
}if(!this.element.lefttop){this.element.lefttop=[(document.documentElement.clientLeft||0),(document.documentElement.clientTop||0)]
}if(!this.element.offsets){this.element.offsets=OpenLayers.Util.pagePosition(this.element);
this.element.offsets[0]+=this.element.scrolls[0];
this.element.offsets[1]+=this.element.scrolls[1]
}return new OpenLayers.Pixel((a.clientX+this.element.scrolls[0])-this.element.offsets[0]-this.element.lefttop[0],(a.clientY+this.element.scrolls[1])-this.element.offsets[1]-this.element.lefttop[1])
},CLASS_NAME:"OpenLayers.Events"});OpenLayers.Icon=OpenLayers.Class({url:null,size:null,offset:null,calculateOffset:null,imageDiv:null,px:null,initialize:function(a,b,d,c){this.url=a;
this.size=(b)?b:new OpenLayers.Size(20,20);
this.offset=d?d:new OpenLayers.Pixel(-(this.size.w/2),-(this.size.h/2));
this.calculateOffset=c;
var e=OpenLayers.Util.createUniqueID("OL_Icon_");
this.imageDiv=OpenLayers.Util.createAlphaImageDiv(e)
},destroy:function(){this.erase();
OpenLayers.Event.stopObservingElement(this.imageDiv.firstChild);
this.imageDiv.innerHTML="";
this.imageDiv=null
},clone:function(){return new OpenLayers.Icon(this.url,this.size,this.offset,this.calculateOffset)
},setSize:function(a){if(a!=null){this.size=a
}this.draw()
},setUrl:function(a){if(a!=null){this.url=a
}this.draw()
},draw:function(a){OpenLayers.Util.modifyAlphaImageDiv(this.imageDiv,null,null,this.size,this.url,"absolute");
this.moveTo(a);
return this.imageDiv
},erase:function(){if(this.imageDiv!=null&&this.imageDiv.parentNode!=null){OpenLayers.Element.remove(this.imageDiv)
}},setOpacity:function(a){OpenLayers.Util.modifyAlphaImageDiv(this.imageDiv,null,null,null,null,null,null,null,a)
},moveTo:function(a){if(a!=null){this.px=a
}if(this.imageDiv!=null){if(this.px==null){this.display(false)
}else{if(this.calculateOffset){this.offset=this.calculateOffset(this.size)
}var b=this.px.offset(this.offset);
OpenLayers.Util.modifyAlphaImageDiv(this.imageDiv,null,b)
}}},display:function(a){this.imageDiv.style.display=(a)?"":"none"
},isDrawn:function(){var a=(this.imageDiv&&this.imageDiv.parentNode&&(this.imageDiv.parentNode.nodeType!=11));
return a
},CLASS_NAME:"OpenLayers.Icon"});OpenLayers.Marker=OpenLayers.Class({icon:null,lonlat:null,events:null,map:null,initialize:function(c,b){this.lonlat=c;
var a=(b)?b:OpenLayers.Marker.defaultIcon();
if(this.icon==null){this.icon=a
}else{this.icon.url=a.url;
this.icon.size=a.size;
this.icon.offset=a.offset;
this.icon.calculateOffset=a.calculateOffset
}this.events=new OpenLayers.Events(this,this.icon.imageDiv,null)
},destroy:function(){this.erase();
this.map=null;
this.events.destroy();
this.events=null;
if(this.icon!=null){this.icon.destroy();
this.icon=null
}},draw:function(a){return this.icon.draw(a)
},erase:function(){if(this.icon!=null){this.icon.erase()
}},moveTo:function(a){if((a!=null)&&(this.icon!=null)){this.icon.moveTo(a)
}this.lonlat=this.map.getLonLatFromLayerPx(a)
},isDrawn:function(){var a=(this.icon&&this.icon.isDrawn());
return a
},onScreen:function(){var b=false;
if(this.map){var a=this.map.getExtent();
b=a.containsLonLat(this.lonlat)
}return b
},inflate:function(b){if(this.icon){var a=new OpenLayers.Size(this.icon.size.w*b,this.icon.size.h*b);
this.icon.setSize(a)
}},setOpacity:function(a){this.icon.setOpacity(a)
},setUrl:function(a){this.icon.setUrl(a)
},display:function(a){this.icon.display(a)
},CLASS_NAME:"OpenLayers.Marker"});
OpenLayers.Marker.defaultIcon=function(){var a=OpenLayers.Util.getImagesLocation()+"marker.png";
var b=new OpenLayers.Size(21,25);
var c=function(d){return new OpenLayers.Pixel(-(d.w/2),-d.h)
};
return new OpenLayers.Icon(a,b,null,c)
};OpenLayers.Popup=OpenLayers.Class({events:null,id:"",lonlat:null,div:null,contentSize:null,size:null,contentHTML:null,backgroundColor:"",opacity:"",border:"",contentDiv:null,groupDiv:null,closeDiv:null,autoSize:false,minSize:null,maxSize:null,displayClass:"olPopup",contentDisplayClass:"olPopupContent",padding:0,disableFirefoxOverflowHack:false,fixPadding:function(){if(typeof this.padding=="number"){this.padding=new OpenLayers.Bounds(this.padding,this.padding,this.padding,this.padding)
}},panMapIfOutOfView:false,keepInMap:false,closeOnMove:false,map:null,initialize:function(g,c,f,b,e,d){if(g==null){g=OpenLayers.Util.createUniqueID(this.CLASS_NAME+"_")
}this.id=g;
this.lonlat=c;
this.contentSize=(f!=null)?f:new OpenLayers.Size(OpenLayers.Popup.WIDTH,OpenLayers.Popup.HEIGHT);
if(b!=null){this.contentHTML=b
}this.backgroundColor=OpenLayers.Popup.COLOR;
this.opacity=OpenLayers.Popup.OPACITY;
this.border=OpenLayers.Popup.BORDER;
this.div=OpenLayers.Util.createDiv(this.id,null,null,null,null,null,"hidden");
this.div.className=this.displayClass;
var a=this.id+"_GroupDiv";
this.groupDiv=OpenLayers.Util.createDiv(a,null,null,null,"relative",null,"hidden");
var g=this.div.id+"_contentDiv";
this.contentDiv=OpenLayers.Util.createDiv(g,null,this.contentSize.clone(),null,"relative");
this.contentDiv.className=this.contentDisplayClass;
this.groupDiv.appendChild(this.contentDiv);
this.div.appendChild(this.groupDiv);
if(e){this.addCloseBox(d)
}this.registerEvents()
},destroy:function(){this.id=null;
this.lonlat=null;
this.size=null;
this.contentHTML=null;
this.backgroundColor=null;
this.opacity=null;
this.border=null;
if(this.closeOnMove&&this.map){this.map.events.unregister("movestart",this,this.hide)
}this.events.destroy();
this.events=null;
if(this.closeDiv){OpenLayers.Event.stopObservingElement(this.closeDiv);
this.groupDiv.removeChild(this.closeDiv)
}this.closeDiv=null;
this.div.removeChild(this.groupDiv);
this.groupDiv=null;
if(this.map!=null){this.map.removePopup(this)
}this.map=null;
this.div=null;
this.autoSize=null;
this.minSize=null;
this.maxSize=null;
this.padding=null;
this.panMapIfOutOfView=null
},draw:function(a){if(a==null){if((this.lonlat!=null)&&(this.map!=null)){a=this.map.getLayerPxFromLonLat(this.lonlat)
}}if(this.closeOnMove){this.map.events.register("movestart",this,this.hide)
}if(!this.disableFirefoxOverflowHack&&OpenLayers.Util.getBrowserName()=="firefox"){this.map.events.register("movestart",this,function(){var b=document.defaultView.getComputedStyle(this.contentDiv,null);
var c=b.getPropertyValue("overflow");
if(c!="hidden"){this.contentDiv._oldOverflow=c;
this.contentDiv.style.overflow="hidden"
}});
this.map.events.register("moveend",this,function(){var b=this.contentDiv._oldOverflow;
if(b){this.contentDiv.style.overflow=b;
this.contentDiv._oldOverflow=null
}})
}this.moveTo(a);
if(!this.autoSize&&!this.size){this.setSize(this.contentSize)
}this.setBackgroundColor();
this.setOpacity();
this.setBorder();
this.setContentHTML();
if(this.panMapIfOutOfView){this.panIntoView()
}return this.div
},updatePosition:function(){if((this.lonlat)&&(this.map)){var a=this.map.getLayerPxFromLonLat(this.lonlat);
if(a){this.moveTo(a)
}}},moveTo:function(a){if((a!=null)&&(this.div!=null)){this.div.style.left=a.x+"px";
this.div.style.top=a.y+"px"
}},visible:function(){return OpenLayers.Element.visible(this.div)
},toggle:function(){if(this.visible()){this.hide()
}else{this.show()
}},show:function(){OpenLayers.Element.show(this.div);
if(this.panMapIfOutOfView){this.panIntoView()
}},hide:function(){OpenLayers.Element.hide(this.div)
},setSize:function(c){this.size=c.clone();
var b=this.getContentDivPadding();
var a=b.left+b.right;
var e=b.top+b.bottom;
this.fixPadding();
a+=this.padding.left+this.padding.right;
e+=this.padding.top+this.padding.bottom;
if(this.closeDiv){var d=parseInt(this.closeDiv.style.width);
a+=d+b.right
}this.size.w+=a;
this.size.h+=e;
if(OpenLayers.Util.getBrowserName()=="msie"){this.contentSize.w+=b.left+b.right;
this.contentSize.h+=b.bottom+b.top
}if(this.div!=null){this.div.style.width=this.size.w+"px";
this.div.style.height=this.size.h+"px"
}if(this.contentDiv!=null){this.contentDiv.style.width=c.w+"px";
this.contentDiv.style.height=c.h+"px"
}},updateSize:function(){var e="<div class='"+this.contentDisplayClass+"'>"+this.contentDiv.innerHTML+"</div>";
var h=(this.map)?this.map.layerContainerDiv:document.body;
var i=OpenLayers.Util.getRenderedDimensions(e,null,{displayClass:this.displayClass,containerElement:h});
var g=this.getSafeContentSize(i);
var f=null;
if(g.equals(i)){f=i
}else{var b=new OpenLayers.Size();
b.w=(g.w<i.w)?g.w:null;
b.h=(g.h<i.h)?g.h:null;
if(b.w&&b.h){f=g
}else{var d=OpenLayers.Util.getRenderedDimensions(e,b,{displayClass:this.contentDisplayClass,containerElement:h});
var c=OpenLayers.Element.getStyle(this.contentDiv,"overflow");
if((c!="hidden")&&(d.equals(g))){var a=OpenLayers.Util.getScrollbarWidth();
if(b.w){d.h+=a
}else{d.w+=a
}}f=this.getSafeContentSize(d)
}}this.setSize(f)
},setBackgroundColor:function(a){if(a!=undefined){this.backgroundColor=a
}if(this.div!=null){this.div.style.backgroundColor=this.backgroundColor
}},setOpacity:function(a){if(a!=undefined){this.opacity=a
}if(this.div!=null){this.div.style.opacity=this.opacity;
this.div.style.filter="alpha(opacity="+this.opacity*100+")"
}},setBorder:function(a){if(a!=undefined){this.border=a
}if(this.div!=null){this.div.style.border=this.border
}},setContentHTML:function(a){if(a!=null){this.contentHTML=a
}if((this.contentDiv!=null)&&(this.contentHTML!=null)&&(this.contentHTML!=this.contentDiv.innerHTML)){this.contentDiv.innerHTML=this.contentHTML;
if(this.autoSize){this.registerImageListeners();
this.updateSize()
}}},registerImageListeners:function(){var f=function(){this.popup.updateSize();
if(this.popup.visible()&&this.popup.panMapIfOutOfView){this.popup.panIntoView()
}OpenLayers.Event.stopObserving(this.img,"load",this.img._onImageLoad)
};
var b=this.contentDiv.getElementsByTagName("img");
for(var e=0,a=b.length;
e<a;
e++){var c=b[e];
if(c.width==0||c.height==0){var d={popup:this,img:c};
c._onImgLoad=OpenLayers.Function.bind(f,d);
OpenLayers.Event.observe(c,"load",c._onImgLoad)
}}},getSafeContentSize:function(k){var d=k.clone();
var i=this.getContentDivPadding();
var j=i.left+i.right;
var g=i.top+i.bottom;
this.fixPadding();
j+=this.padding.left+this.padding.right;
g+=this.padding.top+this.padding.bottom;
if(this.closeDiv){var c=parseInt(this.closeDiv.style.width);
j+=c+i.right
}if(this.minSize){d.w=Math.max(d.w,(this.minSize.w-j));
d.h=Math.max(d.h,(this.minSize.h-g))
}if(this.maxSize){d.w=Math.min(d.w,(this.maxSize.w-j));
d.h=Math.min(d.h,(this.maxSize.h-g))
}if(this.map&&this.map.size){var f=0,e=0;
if(this.keepInMap&&!this.panMapIfOutOfView){var h=this.map.getPixelFromLonLat(this.lonlat);
switch(this.relativePosition){case"tr":f=h.x;
e=this.map.size.h-h.y;
break;
case"tl":f=this.map.size.w-h.x;
e=this.map.size.h-h.y;
break;
case"bl":f=this.map.size.w-h.x;
e=h.y;
break;
case"br":f=h.x;
e=h.y;
break;
default:f=h.x;
e=this.map.size.h-h.y;
break
}}var a=this.map.size.h-this.map.paddingForPopups.top-this.map.paddingForPopups.bottom-g-e;
var b=this.map.size.w-this.map.paddingForPopups.left-this.map.paddingForPopups.right-j-f;
d.w=Math.min(d.w,b);
d.h=Math.min(d.h,a)
}return d
},getContentDivPadding:function(){var a=this._contentDivPadding;
if(!a){if(this.div.parentNode==null){this.div.style.display="none";
document.body.appendChild(this.div)
}a=new OpenLayers.Bounds(OpenLayers.Element.getStyle(this.contentDiv,"padding-left"),OpenLayers.Element.getStyle(this.contentDiv,"padding-bottom"),OpenLayers.Element.getStyle(this.contentDiv,"padding-right"),OpenLayers.Element.getStyle(this.contentDiv,"padding-top"));
this._contentDivPadding=a;
if(this.div.parentNode==document.body){document.body.removeChild(this.div);
this.div.style.display=""
}}return a
},addCloseBox:function(c){this.closeDiv=OpenLayers.Util.createDiv(this.id+"_close",null,new OpenLayers.Size(17,17));
this.closeDiv.className="olPopupCloseBox";
var b=this.getContentDivPadding();
this.closeDiv.style.right=b.right+"px";
this.closeDiv.style.top=b.top+"px";
this.groupDiv.appendChild(this.closeDiv);
var a=c||function(d){this.hide();
OpenLayers.Event.stop(d)
};
OpenLayers.Event.observe(this.closeDiv,"click",OpenLayers.Function.bindAsEventListener(a,this))
},panIntoView:function(){var e=this.map.getSize();
var d=this.map.getViewPortPxFromLayerPx(new OpenLayers.Pixel(parseInt(this.div.style.left),parseInt(this.div.style.top)));
var c=d.clone();
if(d.x<this.map.paddingForPopups.left){c.x=this.map.paddingForPopups.left
}else{if((d.x+this.size.w)>(e.w-this.map.paddingForPopups.right)){c.x=e.w-this.map.paddingForPopups.right-this.size.w
}}if(d.y<this.map.paddingForPopups.top){c.y=this.map.paddingForPopups.top
}else{if((d.y+this.size.h)>(e.h-this.map.paddingForPopups.bottom)){c.y=e.h-this.map.paddingForPopups.bottom-this.size.h
}}var b=d.x-c.x;
var a=d.y-c.y;
this.map.pan(b,a)
},registerEvents:function(){this.events=new OpenLayers.Events(this,this.div,null,true);
this.events.on({mousedown:this.onmousedown,mousemove:this.onmousemove,mouseup:this.onmouseup,click:this.onclick,mouseout:this.onmouseout,dblclick:this.ondblclick,scope:this})
},onmousedown:function(a){this.mousedown=true;
OpenLayers.Event.stop(a,true)
},onmousemove:function(a){if(this.mousedown){OpenLayers.Event.stop(a,true)
}},onmouseup:function(a){if(this.mousedown){this.mousedown=false;
OpenLayers.Event.stop(a,true)
}},onclick:function(a){OpenLayers.Event.stop(a,true)
},onmouseout:function(a){this.mousedown=false
},ondblclick:function(a){OpenLayers.Event.stop(a,true)
},CLASS_NAME:"OpenLayers.Popup"});
OpenLayers.Popup.WIDTH=200;
OpenLayers.Popup.HEIGHT=200;
OpenLayers.Popup.COLOR="white";
OpenLayers.Popup.OPACITY=1;
OpenLayers.Popup.BORDER="0px";OpenLayers.Popup.Anchored=OpenLayers.Class(OpenLayers.Popup,{relativePosition:null,keepInMap:true,anchor:null,initialize:function(h,d,g,c,b,f,e){var a=[h,d,g,c,f,e];
OpenLayers.Popup.prototype.initialize.apply(this,a);
this.anchor=(b!=null)?b:{size:new OpenLayers.Size(0,0),offset:new OpenLayers.Pixel(0,0)}
},destroy:function(){this.anchor=null;
this.relativePosition=null;
OpenLayers.Popup.prototype.destroy.apply(this,arguments)
},show:function(){this.updatePosition();
OpenLayers.Popup.prototype.show.apply(this,arguments)
},moveTo:function(c){var b=this.relativePosition;
this.relativePosition=this.calculateRelativePosition(c);
var d=this.calculateNewPx(c);
var a=new Array(d);
OpenLayers.Popup.prototype.moveTo.apply(this,a);
if(this.relativePosition!=b){this.updateRelativePosition()
}},setSize:function(b){OpenLayers.Popup.prototype.setSize.apply(this,arguments);
if((this.lonlat)&&(this.map)){var a=this.map.getLayerPxFromLonLat(this.lonlat);
this.moveTo(a)
}},calculateRelativePosition:function(b){var d=this.map.getLonLatFromLayerPx(b);
var c=this.map.getExtent();
var a=c.determineQuadrant(d);
return OpenLayers.Bounds.oppositeQuadrant(a)
},updateRelativePosition:function(){},calculateNewPx:function(b){var e=b.offset(this.anchor.offset);
var a=this.size||this.contentSize;
var d=(this.relativePosition.charAt(0)=="t");
e.y+=(d)?-(a.h+this.anchor.size.h):this.anchor.size.h;
var c=(this.relativePosition.charAt(1)=="l");
e.x+=(c)?-(a.w+this.anchor.size.w):this.anchor.size.w;
return e
},CLASS_NAME:"OpenLayers.Popup.Anchored"});OpenLayers.Popup.AnchoredBubble=OpenLayers.Class(OpenLayers.Popup.Anchored,{rounded:false,initialize:function(g,c,f,b,a,e,d){this.padding=new OpenLayers.Bounds(0,OpenLayers.Popup.AnchoredBubble.CORNER_SIZE,0,OpenLayers.Popup.AnchoredBubble.CORNER_SIZE);
OpenLayers.Popup.Anchored.prototype.initialize.apply(this,arguments)
},draw:function(a){OpenLayers.Popup.Anchored.prototype.draw.apply(this,arguments);
this.setContentHTML();
this.setBackgroundColor();
this.setOpacity();
return this.div
},updateRelativePosition:function(){this.setRicoCorners()
},setSize:function(a){OpenLayers.Popup.Anchored.prototype.setSize.apply(this,arguments);
this.setRicoCorners()
},setBackgroundColor:function(a){if(a!=undefined){this.backgroundColor=a
}if(this.div!=null){if(this.contentDiv!=null){this.div.style.background="transparent";
OpenLayers.Rico.Corner.changeColor(this.groupDiv,this.backgroundColor)
}}},setOpacity:function(a){OpenLayers.Popup.Anchored.prototype.setOpacity.call(this,a);
if(this.div!=null){if(this.groupDiv!=null){OpenLayers.Rico.Corner.changeOpacity(this.groupDiv,this.opacity)
}}},setBorder:function(a){this.border=0
},setRicoCorners:function(){var a=this.getCornersToRound(this.relativePosition);
var b={corners:a,color:this.backgroundColor,bgColor:"transparent",blend:false};
if(!this.rounded){OpenLayers.Rico.Corner.round(this.div,b);
this.rounded=true
}else{OpenLayers.Rico.Corner.reRound(this.groupDiv,b);
this.setBackgroundColor();
this.setOpacity()
}},getCornersToRound:function(){var a=["tl","tr","bl","br"];
var b=OpenLayers.Bounds.oppositeQuadrant(this.relativePosition);
OpenLayers.Util.removeItem(a,b);
return a.join(" ")
},CLASS_NAME:"OpenLayers.Popup.AnchoredBubble"});
OpenLayers.Popup.AnchoredBubble.CORNER_SIZE=5;OpenLayers.Feature=OpenLayers.Class({layer:null,id:null,lonlat:null,data:null,marker:null,popupClass:OpenLayers.Popup.AnchoredBubble,popup:null,initialize:function(a,c,b){this.layer=a;
this.lonlat=c;
this.data=(b!=null)?b:{};
this.id=OpenLayers.Util.createUniqueID(this.CLASS_NAME+"_")
},destroy:function(){if((this.layer!=null)&&(this.layer.map!=null)){if(this.popup!=null){this.layer.map.removePopup(this.popup)
}}if(this.layer!=null&&this.marker!=null){this.layer.removeMarker(this.marker)
}this.layer=null;
this.id=null;
this.lonlat=null;
this.data=null;
if(this.marker!=null){this.destroyMarker(this.marker);
this.marker=null
}if(this.popup!=null){this.destroyPopup(this.popup);
this.popup=null
}},onScreen:function(){var b=false;
if((this.layer!=null)&&(this.layer.map!=null)){var a=this.layer.map.getExtent();
b=a.containsLonLat(this.lonlat)
}return b
},createMarker:function(){if(this.lonlat!=null){this.marker=new OpenLayers.Marker(this.lonlat,this.data.icon)
}return this.marker
},destroyMarker:function(){this.marker.destroy()
},createPopup:function(b){if(this.lonlat!=null){var c=this.id+"_popup";
var a=(this.marker)?this.marker.icon:null;
if(!this.popup){this.popup=new this.popupClass(c,this.lonlat,this.data.popupSize,this.data.popupContentHTML,a,b)
}if(this.data.overflow!=null){this.popup.contentDiv.style.overflow=this.data.overflow
}this.popup.feature=this
}return this.popup
},destroyPopup:function(){if(this.popup){this.popup.feature=null;
this.popup.destroy();
this.popup=null
}},CLASS_NAME:"OpenLayers.Feature"});OpenLayers.State={UNKNOWN:"Unknown",INSERT:"Insert",UPDATE:"Update",DELETE:"Delete"};
OpenLayers.Feature.Vector=OpenLayers.Class(OpenLayers.Feature,{fid:null,geometry:null,attributes:null,bounds:null,state:null,style:null,url:null,renderIntent:"default",initialize:function(c,a,b){OpenLayers.Feature.prototype.initialize.apply(this,[null,null,a]);
this.lonlat=null;
this.geometry=c?c:null;
this.state=null;
this.attributes={};
if(a){this.attributes=OpenLayers.Util.extend(this.attributes,a)
}this.style=b?b:null
},destroy:function(){if(this.layer){this.layer.removeFeatures(this);
this.layer=null
}this.geometry=null;
OpenLayers.Feature.prototype.destroy.apply(this,arguments)
},clone:function(){return new OpenLayers.Feature.Vector(this.geometry?this.geometry.clone():null,this.attributes,this.style)
},onScreen:function(d){var c=false;
if(this.layer&&this.layer.map){var a=this.layer.map.getExtent();
if(d){var b=this.geometry.getBounds();
c=a.intersectsBounds(b)
}else{var e=a.toGeometry();
c=e.intersects(this.geometry)
}}return c
},getVisibility:function(){return !(this.style&&this.style.display=="none"||!this.layer||this.layer&&this.layer.styleMap&&this.layer.styleMap.createSymbolizer(this,this.renderIntent).display=="none"||this.layer&&!this.layer.getVisibility())
},createMarker:function(){return null
},destroyMarker:function(){},createPopup:function(){return null
},atPoint:function(b,d,c){var a=false;
if(this.geometry){a=this.geometry.atPoint(b,d,c)
}return a
},destroyPopup:function(){},move:function(a){if(!this.layer||!this.geometry.move){return
}var b;
if(a.CLASS_NAME=="OpenLayers.LonLat"){b=this.layer.getViewPortPxFromLonLat(a)
}else{b=a
}var d=this.layer.getViewPortPxFromLonLat(this.geometry.getBounds().getCenterLonLat());
var c=this.layer.map.getResolution();
this.geometry.move(c*(b.x-d.x),c*(d.y-b.y));
this.layer.drawFeature(this);
return d
},toState:function(a){if(a==OpenLayers.State.UPDATE){switch(this.state){case OpenLayers.State.UNKNOWN:case OpenLayers.State.DELETE:this.state=a;
break;
case OpenLayers.State.UPDATE:case OpenLayers.State.INSERT:break
}}else{if(a==OpenLayers.State.INSERT){switch(this.state){case OpenLayers.State.UNKNOWN:break;
default:this.state=a;
break
}}else{if(a==OpenLayers.State.DELETE){switch(this.state){case OpenLayers.State.INSERT:break;
case OpenLayers.State.DELETE:break;
case OpenLayers.State.UNKNOWN:case OpenLayers.State.UPDATE:this.state=a;
break
}}else{if(a==OpenLayers.State.UNKNOWN){this.state=a
}}}}},CLASS_NAME:"OpenLayers.Feature.Vector"});
OpenLayers.Feature.Vector.style={"default":{fillColor:"#ee9900",fillOpacity:0.4,hoverFillColor:"white",hoverFillOpacity:0.8,strokeColor:"#ee9900",strokeOpacity:1,strokeWidth:1,strokeLinecap:"round",strokeDashstyle:"solid",hoverStrokeColor:"red",hoverStrokeOpacity:1,hoverStrokeWidth:0.2,pointRadius:6,hoverPointRadius:1,hoverPointUnit:"%",pointerEvents:"visiblePainted",cursor:"inherit"},select:{fillColor:"blue",fillOpacity:0.4,hoverFillColor:"white",hoverFillOpacity:0.8,strokeColor:"blue",strokeOpacity:1,strokeWidth:2,strokeLinecap:"round",strokeDashstyle:"solid",hoverStrokeColor:"red",hoverStrokeOpacity:1,hoverStrokeWidth:0.2,pointRadius:6,hoverPointRadius:1,hoverPointUnit:"%",pointerEvents:"visiblePainted",cursor:"pointer"},temporary:{fillColor:"#66cccc",fillOpacity:0.2,hoverFillColor:"white",hoverFillOpacity:0.8,strokeColor:"#66cccc",strokeOpacity:1,strokeLinecap:"round",strokeWidth:2,strokeDashstyle:"solid",hoverStrokeColor:"red",hoverStrokeOpacity:1,hoverStrokeWidth:0.2,pointRadius:6,hoverPointRadius:1,hoverPointUnit:"%",pointerEvents:"visiblePainted",cursor:"inherit"},"delete":{display:"none"}};OpenLayers.Format.WKT=OpenLayers.Class(OpenLayers.Format,{initialize:function(a){this.regExes={typeStr:/^\s*(\w+)\s*\(\s*(.*)\s*\)\s*$/,spaces:/\s+/,parenComma:/\)\s*,\s*\(/,doubleParenComma:/\)\s*\)\s*,\s*\(\s*\(/,trimParens:/^\s*\(?(.*?)\)?\s*$/};
OpenLayers.Format.prototype.initialize.apply(this,[a])
},read:function(f){var e,d,h;
var g=this.regExes.typeStr.exec(f);
if(g){d=g[1].toLowerCase();
h=g[2];
if(this.parse[d]){e=this.parse[d].apply(this,[h])
}if(this.internalProjection&&this.externalProjection){if(e&&e.CLASS_NAME=="OpenLayers.Feature.Vector"){e.geometry.transform(this.externalProjection,this.internalProjection)
}else{if(e&&d!="geometrycollection"&&typeof e=="object"){for(var c=0,a=e.length;
c<a;
c++){var b=e[c];
b.geometry.transform(this.externalProjection,this.internalProjection)
}}}}}return e
},write:function(a){var f,j,h,d,b;
if(a.constructor==Array){f=a;
b=true
}else{f=[a];
b=false
}var c=[];
if(b){c.push("GEOMETRYCOLLECTION(")
}for(var e=0,g=f.length;
e<g;
++e){if(b&&e>0){c.push(",")
}j=f[e].geometry;
h=j.CLASS_NAME.split(".")[2].toLowerCase();
if(!this.extract[h]){return null
}if(this.internalProjection&&this.externalProjection){j=j.clone();
j.transform(this.internalProjection,this.externalProjection)
}d=this.extract[h].apply(this,[j]);
c.push(h.toUpperCase()+"("+d+")")
}if(b){c.push(")")
}return c.join("")
},extract:{point:function(a){return a.x+" "+a.y
},multipoint:function(c){var d=[];
for(var b=0,a=c.components.length;
b<a;
++b){d.push("("+this.extract.point.apply(this,[c.components[b]])+")")
}return d.join(",")
},linestring:function(b){var d=[];
for(var c=0,a=b.components.length;
c<a;
++c){d.push(this.extract.point.apply(this,[b.components[c]]))
}return d.join(",")
},multilinestring:function(c){var d=[];
for(var b=0,a=c.components.length;
b<a;
++b){d.push("("+this.extract.linestring.apply(this,[c.components[b]])+")")
}return d.join(",")
},polygon:function(c){var d=[];
for(var b=0,a=c.components.length;
b<a;
++b){d.push("("+this.extract.linestring.apply(this,[c.components[b]])+")")
}return d.join(",")
},multipolygon:function(d){var c=[];
for(var b=0,a=d.components.length;
b<a;
++b){c.push("("+this.extract.polygon.apply(this,[d.components[b]])+")")
}return c.join(",")
}},parse:{point:function(b){var a=OpenLayers.String.trim(b).split(this.regExes.spaces);
return new OpenLayers.Feature.Vector(new OpenLayers.Geometry.Point(a[0],a[1]))
},multipoint:function(f){var b;
var d=OpenLayers.String.trim(f).split(this.regExes.parenComma);
var e=[];
for(var c=0,a=d.length;
c<a;
++c){b=d[c].replace(this.regExes.trimParens,"$1");
e.push(this.parse.point.apply(this,[b]).geometry)
}return new OpenLayers.Feature.Vector(new OpenLayers.Geometry.MultiPoint(e))
},linestring:function(e){var c=OpenLayers.String.trim(e).split(",");
var d=[];
for(var b=0,a=c.length;
b<a;
++b){d.push(this.parse.point.apply(this,[c[b]]).geometry)
}return new OpenLayers.Feature.Vector(new OpenLayers.Geometry.LineString(d))
},multilinestring:function(f){var c;
var b=OpenLayers.String.trim(f).split(this.regExes.parenComma);
var e=[];
for(var d=0,a=b.length;
d<a;
++d){c=b[d].replace(this.regExes.trimParens,"$1");
e.push(this.parse.linestring.apply(this,[c]).geometry)
}return new OpenLayers.Feature.Vector(new OpenLayers.Geometry.MultiLineString(e))
},polygon:function(h){var c,b,f;
var g=OpenLayers.String.trim(h).split(this.regExes.parenComma);
var e=[];
for(var d=0,a=g.length;
d<a;
++d){c=g[d].replace(this.regExes.trimParens,"$1");
b=this.parse.linestring.apply(this,[c]).geometry;
f=new OpenLayers.Geometry.LinearRing(b.components);
e.push(f)
}return new OpenLayers.Feature.Vector(new OpenLayers.Geometry.Polygon(e))
},multipolygon:function(f){var d;
var b=OpenLayers.String.trim(f).split(this.regExes.doubleParenComma);
var e=[];
for(var c=0,a=b.length;
c<a;
++c){d=b[c].replace(this.regExes.trimParens,"$1");
e.push(this.parse.polygon.apply(this,[d]).geometry)
}return new OpenLayers.Feature.Vector(new OpenLayers.Geometry.MultiPolygon(e))
},geometrycollection:function(e){e=e.replace(/,\s*([A-Za-z])/g,"|$1");
var d=OpenLayers.String.trim(e).split("|");
var c=[];
for(var b=0,a=d.length;
b<a;
++b){c.push(OpenLayers.Format.WKT.prototype.read.apply(this,[d[b]]))
}return c
}},CLASS_NAME:"OpenLayers.Format.WKT"});OpenLayers.Format.XML=OpenLayers.Class(OpenLayers.Format,{namespaces:null,namespaceAlias:null,defaultPrefix:null,readers:{},writers:{},xmldom:null,initialize:function(a){if(window.ActiveXObject){this.xmldom=new ActiveXObject("Microsoft.XMLDOM")
}OpenLayers.Format.prototype.initialize.apply(this,[a]);
this.namespaces=OpenLayers.Util.extend({},this.namespaces);
this.namespaceAlias={};
for(var b in this.namespaces){this.namespaceAlias[this.namespaces[b]]=b
}},destroy:function(){this.xmldom=null;
OpenLayers.Format.prototype.destroy.apply(this,arguments)
},setNamespace:function(a,b){this.namespaces[a]=b;
this.namespaceAlias[b]=a
},read:function(c){var a=c.indexOf("<");
if(a>0){c=c.substring(a)
}var b=OpenLayers.Util.Try(OpenLayers.Function.bind((function(){var d;
if(window.ActiveXObject&&!this.xmldom){d=new ActiveXObject("Microsoft.XMLDOM")
}else{d=this.xmldom
}d.loadXML(c);
return d
}),this),function(){return new DOMParser().parseFromString(c,"text/xml")
},function(){var d=new XMLHttpRequest();
d.open("GET","data:text/xml;charset=utf-8,"+encodeURIComponent(c),false);
if(d.overrideMimeType){d.overrideMimeType("text/xml")
}d.send(null);
return d.responseXML
});
if(this.keepData){this.data=b
}return b
},write:function(b){var c;
if(this.xmldom){c=b.xml
}else{var a=new XMLSerializer();
if(b.nodeType==1){var d=document.implementation.createDocument("","",null);
if(d.importNode){b=d.importNode(b,true)
}d.appendChild(b);
c=a.serializeToString(d)
}else{c=a.serializeToString(b)
}}return c
},createElementNS:function(c,a){var b;
if(this.xmldom){if(typeof c=="string"){b=this.xmldom.createNode(1,a,c)
}else{b=this.xmldom.createNode(1,a,"")
}}else{b=document.createElementNS(c,a)
}return b
},createTextNode:function(b){var a;
if(typeof b!=="string"){b=String(b)
}if(this.xmldom){a=this.xmldom.createTextNode(b)
}else{a=document.createTextNode(b)
}return a
},getElementsByTagNameNS:function(e,d,c){var a=[];
if(e.getElementsByTagNameNS){a=e.getElementsByTagNameNS(d,c)
}else{var b=e.getElementsByTagName("*");
var j,f;
for(var g=0,h=b.length;
g<h;
++g){j=b[g];
f=(j.prefix)?(j.prefix+":"+c):c;
if((c=="*")||(f==j.nodeName)){if((d=="*")||(d==j.namespaceURI)){a.push(j)
}}}}return a
},getAttributeNodeNS:function(c,b,a){var j=null;
if(c.getAttributeNodeNS){j=c.getAttributeNodeNS(b,a)
}else{var e=c.attributes;
var h,d;
for(var f=0,g=e.length;
f<g;
++f){h=e[f];
if(h.namespaceURI==b){d=(h.prefix)?(h.prefix+":"+a):a;
if(d==h.nodeName){j=h;
break
}}}}return j
},getAttributeNS:function(e,d,a){var b="";
if(e.getAttributeNS){b=e.getAttributeNS(d,a)||""
}else{var c=this.getAttributeNodeNS(e,d,a);
if(c){b=c.nodeValue
}}return b
},getChildValue:function(a,c){var b=c||"";
if(a){for(var d=a.firstChild;
d;
d=d.nextSibling){switch(d.nodeType){case 3:case 4:b+=d.nodeValue
}}}return b
},concatChildValues:function(b,d){var c="";
var e=b.firstChild;
var a;
while(e){a=e.nodeValue;
if(a){c+=a
}e=e.nextSibling
}if(c==""&&d!=undefined){c=d
}return c
},isSimpleContent:function(a){var c=true;
for(var b=a.firstChild;
b;
b=b.nextSibling){if(b.nodeType===1){c=false;
break
}}return c
},contentType:function(c){var e=false,b=false;
var a=OpenLayers.Format.XML.CONTENT_TYPE.EMPTY;
for(var d=c.firstChild;
d;
d=d.nextSibling){switch(d.nodeType){case 1:b=true;
break;
case 8:break;
default:e=true
}if(b&&e){break
}}if(b&&e){a=OpenLayers.Format.XML.CONTENT_TYPE.MIXED
}else{if(b){return OpenLayers.Format.XML.CONTENT_TYPE.COMPLEX
}else{if(e){return OpenLayers.Format.XML.CONTENT_TYPE.SIMPLE
}}}return a
},hasAttributeNS:function(c,b,a){var d=false;
if(c.hasAttributeNS){d=c.hasAttributeNS(b,a)
}else{d=!!this.getAttributeNodeNS(c,b,a)
}return d
},setAttributeNS:function(d,c,a,e){if(d.setAttributeNS){d.setAttributeNS(c,a,e)
}else{if(this.xmldom){if(c){var b=d.ownerDocument.createNode(2,a,c);
b.nodeValue=e;
d.setAttributeNode(b)
}else{d.setAttribute(a,e)
}}else{throw"setAttributeNS not implemented"
}}},createElementNSPlus:function(b,a){a=a||{};
var d=a.uri||this.namespaces[a.prefix];
if(!d){var f=b.indexOf(":");
d=this.namespaces[b.substring(0,f)]
}if(!d){d=this.namespaces[this.defaultPrefix]
}var c=this.createElementNS(d,b);
if(a.attributes){this.setAttributes(c,a.attributes)
}var e=a.value;
if(e!=null){c.appendChild(this.createTextNode(e))
}return c
},setAttributes:function(c,e){var d,b;
for(var a in e){if(e[a]!=null&&e[a].toString){d=e[a].toString();
b=this.namespaces[a.substring(0,a.indexOf(":"))]||null;
this.setAttributeNS(c,b,a,d)
}}},readNode:function(c,e){if(!e){e={}
}var d=this.readers[c.namespaceURI?this.namespaceAlias[c.namespaceURI]:this.defaultPrefix];
if(d){var b=c.localName||c.nodeName.split(":").pop();
var a=d[b]||d["*"];
if(a){a.apply(this,[c,e])
}}return e
},readChildNodes:function(d,e){if(!e){e={}
}var c=d.childNodes;
var f;
for(var b=0,a=c.length;
b<a;
++b){f=c[b];
if(f.nodeType==1){this.readNode(f,e)
}}return e
},writeNode:function(a,f,d){var e,c;
var b=a.indexOf(":");
if(b>0){e=a.substring(0,b);
c=a.substring(b+1)
}else{if(d){e=this.namespaceAlias[d.namespaceURI]
}else{e=this.defaultPrefix
}c=a
}var g=this.writers[e][c].apply(this,[f]);
if(d){d.appendChild(g)
}return g
},getChildEl:function(c,a,b){return c&&this.getThisOrNextEl(c.firstChild,a,b)
},getNextEl:function(c,a,b){return c&&this.getThisOrNextEl(c.nextSibling,a,b)
},getThisOrNextEl:function(d,a,c){outer:for(var b=d;
b;
b=b.nextSibling){switch(b.nodeType){case 1:if((!a||a===(b.localName||b.nodeName.split(":").pop()))&&(!c||c===b.namespaceURI)){break outer
}b=null;
break outer;
case 3:if(/^\s*$/.test(b.nodeValue)){break
}case 4:case 6:case 12:case 10:case 11:b=null;
break outer
}}return b||null
},lookupNamespaceURI:function(e,f){var d=null;
if(e){if(e.lookupNamespaceURI){d=e.lookupNamespaceURI(f)
}else{outer:switch(e.nodeType){case 1:if(e.namespaceURI!==null&&e.prefix===f){d=e.namespaceURI;
break outer
}var b=e.attributes.length;
if(b){var a;
for(var c=0;
c<b;
++c){a=e.attributes[c];
if(a.prefix==="xmlns"&&a.name==="xmlns:"+f){d=a.value||null;
break outer
}else{if(a.name==="xmlns"&&f===null){d=a.value||null;
break outer
}}}}d=this.lookupNamespaceURI(e.parentNode,f);
break outer;
case 2:d=this.lookupNamespaceURI(e.ownerElement,f);
break outer;
case 9:d=this.lookupNamespaceURI(e.documentElement,f);
break outer;
case 6:case 12:case 10:case 11:break outer;
default:d=this.lookupNamespaceURI(e.parentNode,f);
break outer
}}}return d
},CLASS_NAME:"OpenLayers.Format.XML"});
OpenLayers.Format.XML.CONTENT_TYPE={EMPTY:0,SIMPLE:1,COMPLEX:2,MIXED:3};
OpenLayers.Format.XML.lookupNamespaceURI=OpenLayers.Function.bind(OpenLayers.Format.XML.prototype.lookupNamespaceURI,OpenLayers.Format.XML.prototype);OpenLayers.Format.WMSGetFeatureInfo=OpenLayers.Class(OpenLayers.Format.XML,{layerIdentifier:"_layer",featureIdentifier:"_feature",regExes:{trimSpace:(/^\s*|\s*$/g),removeSpace:(/\s*/g),splitSpace:(/\s+/),trimComma:(/\s*,\s*/g)},gmlFormat:null,initialize:function(a){OpenLayers.Format.XML.prototype.initialize.apply(this,arguments);
OpenLayers.Util.extend(this,a);
this.options=a
},read:function(e){var a;
if(typeof e=="string"){e=OpenLayers.Format.XML.prototype.read.apply(this,[e])
}var b=e.documentElement;
if(b){var c=this;
var d=this["read_"+b.nodeName];
if(d){a=d.call(this,b)
}else{a=new OpenLayers.Format.GML((this.options?this.options:{})).read(e)
}}else{a=e
}return a
},read_msGMLOutput:function(h){var e=[];
var b=this.getSiblingNodesByTagCriteria(h,this.layerIdentifier);
if(b){for(var k=0,n=b.length;
k<n;
++k){var c=b[k];
var l=c.nodeName;
if(c.prefix){l=l.split(":")[1]
}var l=l.replace(this.layerIdentifier,"");
var m=this.getSiblingNodesByTagCriteria(c,this.featureIdentifier);
if(m){for(var g=0;
g<m.length;
g++){var a=m[g];
var d=this.parseGeometry(a);
var f=this.parseAttributes(a);
var o=new OpenLayers.Feature.Vector(d.geometry,f,null);
o.bounds=d.bounds;
o.type=l;
e.push(o)
}}}}return e
},read_FeatureInfoResponse:function(f){var c=[];
var h=this.getElementsByTagNameNS(f,"*","FIELDS");
for(var g=0,k=h.length;
g<k;
g++){var a=h[g];
var l=null;
var e={};
for(var d=0,m=a.attributes.length;
d<m;
d++){var b=a.attributes[d];
e[b.nodeName]=b.nodeValue
}c.push(new OpenLayers.Feature.Vector(l,e,null))
}return c
},getSiblingNodesByTagCriteria:function(f,i){var a=[];
var c,e,d,g,b;
if(f&&f.hasChildNodes()){c=f.childNodes;
d=c.length;
for(var h=0;
h<d;
h++){b=c[h];
while(b&&b.nodeType!=1){b=b.nextSibling;
h++
}e=(b?b.nodeName:"");
if(e.length>0&&e.indexOf(i)>-1){a.push(b)
}else{g=this.getSiblingNodesByTagCriteria(b,i);
if(g.length>0){(a.length==0)?a=g:a.push(g)
}}}}return a
},parseAttributes:function(e){var f={};
if(e.nodeType==1){var c=e.childNodes;
var d=c.length;
for(var g=0;
g<d;
++g){var b=c[g];
if(b.nodeType==1){var k=b.childNodes;
if(k.length==1){var j=k[0];
if(j.nodeType==3||j.nodeType==4){var a=(b.prefix)?b.nodeName.split(":")[1]:b.nodeName;
var h=j.nodeValue.replace(this.regExes.trimSpace,"");
f[a]=h
}}}}}return f
},parseGeometry:function(c){if(!this.gmlFormat){this.gmlFormat=new OpenLayers.Format.GML()
}var a=this.gmlFormat.parseFeature(c);
var d,b=null;
if(a){d=a.geometry&&a.geometry.clone();
b=a.bounds&&a.bounds.clone();
a.destroy()
}return{geometry:d,bounds:b}
},CLASS_NAME:"OpenLayers.Format.WMSGetFeatureInfo"});OpenLayers.Geometry=OpenLayers.Class({id:null,parent:null,bounds:null,initialize:function(){this.id=OpenLayers.Util.createUniqueID(this.CLASS_NAME+"_")
},destroy:function(){this.id=null;
this.bounds=null
},clone:function(){return new OpenLayers.Geometry()
},setBounds:function(a){if(a){this.bounds=a.clone()
}},clearBounds:function(){this.bounds=null;
if(this.parent){this.parent.clearBounds()
}},extendBounds:function(b){var a=this.getBounds();
if(!a){this.setBounds(b)
}else{this.bounds.extend(b)
}},getBounds:function(){if(this.bounds==null){this.calculateBounds()
}return this.bounds
},calculateBounds:function(){},distanceTo:function(b,a){},getVertices:function(a){},atPoint:function(e,h,f){var c=false;
var d=this.getBounds();
if((d!=null)&&(e!=null)){var b=(h!=null)?h:0;
var a=(f!=null)?f:0;
var g=new OpenLayers.Bounds(this.bounds.left-b,this.bounds.bottom-a,this.bounds.right+b,this.bounds.top+a);
c=g.containsLonLat(e)
}return c
},getLength:function(){return 0
},getArea:function(){return 0
},getCentroid:function(){return null
},toString:function(){return OpenLayers.Format.WKT.prototype.write(new OpenLayers.Feature.Vector(this))
},CLASS_NAME:"OpenLayers.Geometry"});
OpenLayers.Geometry.fromWKT=function(f){var g=arguments.callee.format;
if(!g){g=new OpenLayers.Format.WKT();
arguments.callee.format=g
}var d;
var b=g.read(f);
if(b instanceof OpenLayers.Feature.Vector){d=b.geometry
}else{if(b instanceof Array){var a=b.length;
var e=new Array(a);
for(var c=0;
c<a;
++c){e[c]=b[c].geometry
}d=new OpenLayers.Geometry.Collection(e)
}}return d
};
OpenLayers.Geometry.segmentsIntersect=function(a,H,b){var s=b&&b.point;
var z=b&&b.tolerance;
var f=false;
var B=a.x1-H.x1;
var F=a.y1-H.y1;
var o=a.x2-a.x1;
var w=a.y2-a.y1;
var t=H.y2-H.y1;
var l=H.x2-H.x1;
var D=(t*o)-(l*w);
var e=(l*F)-(t*B);
var c=(o*F)-(w*B);
if(D==0){if(e==0&&c==0){f=true
}}else{var E=e/D;
var C=c/D;
if(E>=0&&E<=1&&C>=0&&C<=1){if(!s){f=true
}else{var h=a.x1+(E*o);
var g=a.y1+(E*w);
f=new OpenLayers.Geometry.Point(h,g)
}}}if(z){var r;
if(f){if(s){var n=[a,H];
var A,h,g;
outer:for(var v=0;
v<2;
++v){A=n[v];
for(var u=1;
u<3;
++u){h=A["x"+u];
g=A["y"+u];
r=Math.sqrt(Math.pow(h-f.x,2)+Math.pow(g-f.y,2));
if(r<z){f.x=h;
f.y=g;
break outer
}}}}}else{var n=[a,H];
var q,G,h,g,m,k;
outer:for(var v=0;
v<2;
++v){q=n[v];
G=n[(v+1)%2];
for(var u=1;
u<3;
++u){m={x:q["x"+u],y:q["y"+u]};
k=OpenLayers.Geometry.distanceToSegment(m,G);
if(k.distance<z){if(s){f=new OpenLayers.Geometry.Point(m.x,m.y)
}else{f=true
}break outer
}}}}}return f
};
OpenLayers.Geometry.distanceToSegment=function(k,d){var c=k.x;
var j=k.y;
var b=d.x1;
var i=d.y1;
var a=d.x2;
var f=d.y2;
var m=a-b;
var l=f-i;
var h=((m*(c-b))+(l*(j-i)))/(Math.pow(m,2)+Math.pow(l,2));
var g,e;
if(h<=0){g=b;
e=i
}else{if(h>=1){g=a;
e=f
}else{g=b+h*m;
e=i+h*l
}}return{distance:Math.sqrt(Math.pow(g-c,2)+Math.pow(e-j,2)),x:g,y:e}
};OpenLayers.Control=OpenLayers.Class({id:null,map:null,div:null,type:null,allowSelection:false,displayClass:"",title:"",autoActivate:false,active:null,handler:null,eventListeners:null,events:null,EVENT_TYPES:["activate","deactivate"],initialize:function(a){this.displayClass=this.CLASS_NAME.replace("OpenLayers.","ol").replace(/\./g,"");
OpenLayers.Util.extend(this,a);
this.events=new OpenLayers.Events(this,null,this.EVENT_TYPES);
if(this.eventListeners instanceof Object){this.events.on(this.eventListeners)
}if(this.id==null){this.id=OpenLayers.Util.createUniqueID(this.CLASS_NAME+"_")
}},destroy:function(){if(this.events){if(this.eventListeners){this.events.un(this.eventListeners)
}this.events.destroy();
this.events=null
}this.eventListeners=null;
if(this.handler){this.handler.destroy();
this.handler=null
}if(this.handlers){for(var a in this.handlers){if(this.handlers.hasOwnProperty(a)&&typeof this.handlers[a].destroy=="function"){this.handlers[a].destroy()
}}this.handlers=null
}if(this.map){this.map.removeControl(this);
this.map=null
}},setMap:function(a){this.map=a;
if(this.handler){this.handler.setMap(a)
}},draw:function(a){if(this.div==null){this.div=OpenLayers.Util.createDiv(this.id);
this.div.className=this.displayClass;
if(!this.allowSelection){this.div.className+=" olControlNoSelect";
this.div.setAttribute("unselectable","on",0);
this.div.onselectstart=OpenLayers.Function.False
}if(this.title!=""){this.div.title=this.title
}}if(a!=null){this.position=a.clone()
}this.moveTo(this.position);
return this.div
},moveTo:function(a){if((a!=null)&&(this.div!=null)){this.div.style.left=a.x+"px";
this.div.style.top=a.y+"px"
}},activate:function(){if(this.active){return false
}if(this.handler){this.handler.activate()
}this.active=true;
if(this.map){OpenLayers.Element.addClass(this.map.viewPortDiv,this.displayClass.replace(/ /g,"")+"Active")
}this.events.triggerEvent("activate");
return true
},deactivate:function(){if(this.active){if(this.handler){this.handler.deactivate()
}this.active=false;
if(this.map){OpenLayers.Element.removeClass(this.map.viewPortDiv,this.displayClass.replace(/ /g,"")+"Active")
}this.events.triggerEvent("deactivate");
return true
}return false
},CLASS_NAME:"OpenLayers.Control"});
OpenLayers.Control.TYPE_BUTTON=1;
OpenLayers.Control.TYPE_TOGGLE=2;
OpenLayers.Control.TYPE_TOOL=3;OpenLayers.Control.PanZoom=OpenLayers.Class(OpenLayers.Control,{slideFactor:50,slideRatio:null,buttons:null,position:null,initialize:function(a){this.position=new OpenLayers.Pixel(OpenLayers.Control.PanZoom.X,OpenLayers.Control.PanZoom.Y);
OpenLayers.Control.prototype.initialize.apply(this,arguments)
},destroy:function(){OpenLayers.Control.prototype.destroy.apply(this,arguments);
this.removeButtons();
this.buttons=null;
this.position=null
},draw:function(b){OpenLayers.Control.prototype.draw.apply(this,arguments);
b=this.position;
this.buttons=[];
var c=new OpenLayers.Size(18,18);
var a=new OpenLayers.Pixel(b.x+c.w/2,b.y);
this._addButton("panup","north-mini.png",a,c);
b.y=a.y+c.h;
this._addButton("panleft","west-mini.png",b,c);
this._addButton("panright","east-mini.png",b.add(c.w,0),c);
this._addButton("pandown","south-mini.png",a.add(0,c.h*2),c);
this._addButton("zoomin","zoom-plus-mini.png",a.add(0,c.h*3+5),c);
this._addButton("zoomworld","zoom-world-mini.png",a.add(0,c.h*4+5),c);
this._addButton("zoomout","zoom-minus-mini.png",a.add(0,c.h*5+5),c);
return this.div
},_addButton:function(a,d,i,g){var f=OpenLayers.Util.getImagesLocation()+d;
var b=OpenLayers.Util.createAlphaImageDiv(this.id+"_"+a,i,g,f,"absolute");
this.div.appendChild(b);
OpenLayers.Event.observe(b,"mousedown",OpenLayers.Function.bindAsEventListener(this.buttonDown,b));
OpenLayers.Event.observe(b,"dblclick",OpenLayers.Function.bindAsEventListener(this.doubleClick,b));
OpenLayers.Event.observe(b,"click",OpenLayers.Function.bindAsEventListener(this.doubleClick,b));
b.action=a;
b.map=this.map;
if(!this.slideRatio){var c=this.slideFactor;
var e=function(){return c
}
}else{var h=this.slideRatio;
var e=function(j){return this.map.getSize()[j]*h
}
}b.getSlideFactor=e;
this.buttons.push(b);
return b
},_removeButton:function(a){OpenLayers.Event.stopObservingElement(a);
a.map=null;
a.getSlideFactor=null;
this.div.removeChild(a);
OpenLayers.Util.removeItem(this.buttons,a)
},removeButtons:function(){for(var a=this.buttons.length-1;
a>=0;
--a){this._removeButton(this.buttons[a])
}},doubleClick:function(a){OpenLayers.Event.stop(a);
return false
},buttonDown:function(a){if(!OpenLayers.Event.isLeftClick(a)){return
}switch(this.action){case"panup":this.map.pan(0,-this.getSlideFactor("h"));
break;
case"pandown":this.map.pan(0,this.getSlideFactor("h"));
break;
case"panleft":this.map.pan(-this.getSlideFactor("w"),0);
break;
case"panright":this.map.pan(this.getSlideFactor("w"),0);
break;
case"zoomin":this.map.zoomIn();
break;
case"zoomout":this.map.zoomOut();
break;
case"zoomworld":this.map.zoomToMaxExtent();
break
}OpenLayers.Event.stop(a)
},CLASS_NAME:"OpenLayers.Control.PanZoom"});
OpenLayers.Control.PanZoom.X=4;
OpenLayers.Control.PanZoom.Y=4;OpenLayers.Control.PanZoomBar=OpenLayers.Class(OpenLayers.Control.PanZoom,{zoomStopWidth:18,zoomStopHeight:11,slider:null,sliderEvents:null,zoombarDiv:null,divEvents:null,zoomWorldIcon:false,forceFixedZoomLevel:false,mouseDragStart:null,zoomStart:null,initialize:function(){OpenLayers.Control.PanZoom.prototype.initialize.apply(this,arguments)
},destroy:function(){this._removeZoomBar();
this.map.events.un({changebaselayer:this.redraw,scope:this});
OpenLayers.Control.PanZoom.prototype.destroy.apply(this,arguments);
delete this.mouseDragStart;
delete this.zoomStart
},setMap:function(a){OpenLayers.Control.PanZoom.prototype.setMap.apply(this,arguments);
this.map.events.register("changebaselayer",this,this.redraw)
},redraw:function(){if(this.div!=null){this.removeButtons();
this._removeZoomBar()
}this.draw()
},draw:function(b){OpenLayers.Control.prototype.draw.apply(this,arguments);
b=this.position.clone();
this.buttons=[];
var d=new OpenLayers.Size(18,18);
var a=new OpenLayers.Pixel(b.x+d.w/2,b.y);
var c=d.w;
if(this.zoomWorldIcon){a=new OpenLayers.Pixel(b.x+d.w,b.y)
}this._addButton("panup","north-mini.png",a,d);
b.y=a.y+d.h;
this._addButton("panleft","west-mini.png",b,d);
if(this.zoomWorldIcon){this._addButton("zoomworld","zoom-world-mini.png",b.add(d.w,0),d);
c*=2
}this._addButton("panright","east-mini.png",b.add(c,0),d);
this._addButton("pandown","south-mini.png",a.add(0,d.h*2),d);
this._addButton("zoomin","zoom-plus-mini.png",a.add(0,d.h*3+5),d);
a=this._addZoomBar(a.add(0,d.h*4+5));
this._addButton("zoomout","zoom-minus-mini.png",a,d);
return this.div
},_addZoomBar:function(a){var e=OpenLayers.Util.getImagesLocation();
var g=this.id+"_"+this.map.id;
var b=this.map.getNumZoomLevels()-1-this.map.getZoom();
var c=OpenLayers.Util.createAlphaImageDiv(g,a.add(-1,b*this.zoomStopHeight),new OpenLayers.Size(20,9),e+"slider.png","absolute");
this.slider=c;
this.sliderEvents=new OpenLayers.Events(this,c,null,true,{includeXY:true});
this.sliderEvents.on({mousedown:this.zoomBarDown,mousemove:this.zoomBarDrag,mouseup:this.zoomBarUp,dblclick:this.doubleClick,click:this.doubleClick});
var d=new OpenLayers.Size();
d.h=this.zoomStopHeight*this.map.getNumZoomLevels();
d.w=this.zoomStopWidth;
var f=null;
if(OpenLayers.Util.alphaHack()){var g=this.id+"_"+this.map.id;
f=OpenLayers.Util.createAlphaImageDiv(g,a,new OpenLayers.Size(d.w,this.zoomStopHeight),e+"zoombar.png","absolute",null,"crop");
f.style.height=d.h+"px"
}else{f=OpenLayers.Util.createDiv("OpenLayers_Control_PanZoomBar_Zoombar"+this.map.id,a,d,e+"zoombar.png")
}this.zoombarDiv=f;
this.divEvents=new OpenLayers.Events(this,f,null,true,{includeXY:true});
this.divEvents.on({mousedown:this.divClick,mousemove:this.passEventToSlider,dblclick:this.doubleClick,click:this.doubleClick});
this.div.appendChild(f);
this.startTop=parseInt(f.style.top);
this.div.appendChild(c);
this.map.events.register("zoomend",this,this.moveZoomBar);
a=a.add(0,this.zoomStopHeight*this.map.getNumZoomLevels());
return a
},_removeZoomBar:function(){this.sliderEvents.un({mousedown:this.zoomBarDown,mousemove:this.zoomBarDrag,mouseup:this.zoomBarUp,dblclick:this.doubleClick,click:this.doubleClick});
this.sliderEvents.destroy();
this.divEvents.un({mousedown:this.divClick,mousemove:this.passEventToSlider,dblclick:this.doubleClick,click:this.doubleClick});
this.divEvents.destroy();
this.div.removeChild(this.zoombarDiv);
this.zoombarDiv=null;
this.div.removeChild(this.slider);
this.slider=null;
this.map.events.unregister("zoomend",this,this.moveZoomBar)
},passEventToSlider:function(a){this.sliderEvents.handleBrowserEvent(a)
},divClick:function(a){if(!OpenLayers.Event.isLeftClick(a)){return
}var e=a.xy.y;
var d=OpenLayers.Util.pagePosition(a.object)[1];
var c=(e-d)/this.zoomStopHeight;
if(this.forceFixedZoomLevel||!this.map.fractionalZoom){c=Math.floor(c)
}var b=(this.map.getNumZoomLevels()-1)-c;
b=Math.min(Math.max(b,0),this.map.getNumZoomLevels()-1);
this.map.zoomTo(b);
OpenLayers.Event.stop(a)
},zoomBarDown:function(a){if(!OpenLayers.Event.isLeftClick(a)){return
}this.map.events.on({mousemove:this.passEventToSlider,mouseup:this.passEventToSlider,scope:this});
this.mouseDragStart=a.xy.clone();
this.zoomStart=a.xy.clone();
this.div.style.cursor="move";
this.zoombarDiv.offsets=null;
OpenLayers.Event.stop(a)
},zoomBarDrag:function(b){if(this.mouseDragStart!=null){var a=this.mouseDragStart.y-b.xy.y;
var d=OpenLayers.Util.pagePosition(this.zoombarDiv);
if((b.clientY-d[1])>0&&(b.clientY-d[1])<parseInt(this.zoombarDiv.style.height)-2){var c=parseInt(this.slider.style.top)-a;
this.slider.style.top=c+"px";
this.mouseDragStart=b.xy.clone()
}OpenLayers.Event.stop(b)
}},zoomBarUp:function(b){if(!OpenLayers.Event.isLeftClick(b)){return
}if(this.mouseDragStart){this.div.style.cursor="";
this.map.events.un({mouseup:this.passEventToSlider,mousemove:this.passEventToSlider,scope:this});
var a=this.zoomStart.y-b.xy.y;
var c=this.map.zoom;
if(!this.forceFixedZoomLevel&&this.map.fractionalZoom){c+=a/this.zoomStopHeight;
c=Math.min(Math.max(c,0),this.map.getNumZoomLevels()-1)
}else{c+=Math.round(a/this.zoomStopHeight)
}this.map.zoomTo(c);
this.mouseDragStart=null;
this.zoomStart=null;
OpenLayers.Event.stop(b)
}},moveZoomBar:function(){var a=((this.map.getNumZoomLevels()-1)-this.map.getZoom())*this.zoomStopHeight+this.startTop+1;
this.slider.style.top=a+"px"
},CLASS_NAME:"OpenLayers.Control.PanZoomBar"});OpenLayers.Tween=OpenLayers.Class({INTERVAL:10,easing:null,begin:null,finish:null,duration:null,callbacks:null,time:null,interval:null,playing:false,initialize:function(a){this.easing=(a)?a:OpenLayers.Easing.Expo.easeOut
},start:function(c,b,d,a){this.playing=true;
this.begin=c;
this.finish=b;
this.duration=d;
this.callbacks=a.callbacks;
this.time=0;
if(this.interval){window.clearInterval(this.interval);
this.interval=null
}if(this.callbacks&&this.callbacks.start){this.callbacks.start.call(this,this.begin)
}this.interval=window.setInterval(OpenLayers.Function.bind(this.play,this),this.INTERVAL)
},stop:function(){if(!this.playing){return
}if(this.callbacks&&this.callbacks.done){this.callbacks.done.call(this,this.finish)
}window.clearInterval(this.interval);
this.interval=null;
this.playing=false
},play:function(){var g={};
for(var d in this.begin){var a=this.begin[d];
var e=this.finish[d];
if(a==null||e==null||isNaN(a)||isNaN(e)){OpenLayers.Console.error("invalid value for Tween")
}var h=e-a;
g[d]=this.easing.apply(this,[this.time,a,h,this.duration])
}this.time++;
if(this.callbacks&&this.callbacks.eachStep){this.callbacks.eachStep.call(this,g)
}if(this.time>this.duration){this.stop()
}},CLASS_NAME:"OpenLayers.Tween"});
OpenLayers.Easing={CLASS_NAME:"OpenLayers.Easing"};
OpenLayers.Easing.Linear={easeIn:function(e,a,g,f){return g*e/f+a
},easeOut:function(e,a,g,f){return g*e/f+a
},easeInOut:function(e,a,g,f){return g*e/f+a
},CLASS_NAME:"OpenLayers.Easing.Linear"};
OpenLayers.Easing.Expo={easeIn:function(e,a,g,f){return(e==0)?a:g*Math.pow(2,10*(e/f-1))+a
},easeOut:function(e,a,g,f){return(e==f)?a+g:g*(-Math.pow(2,-10*e/f)+1)+a
},easeInOut:function(e,a,g,f){if(e==0){return a
}if(e==f){return a+g
}if((e/=f/2)<1){return g/2*Math.pow(2,10*(e-1))+a
}return g/2*(-Math.pow(2,-10*--e)+2)+a
},CLASS_NAME:"OpenLayers.Easing.Expo"};
OpenLayers.Easing.Quad={easeIn:function(e,a,g,f){return g*(e/=f)*e+a
},easeOut:function(e,a,g,f){return -g*(e/=f)*(e-2)+a
},easeInOut:function(e,a,g,f){if((e/=f/2)<1){return g/2*e*e+a
}return -g/2*((--e)*(e-2)-1)+a
},CLASS_NAME:"OpenLayers.Easing.Quad"};OpenLayers.Map=OpenLayers.Class({Z_INDEX_BASE:{BaseLayer:100,Overlay:325,Feature:725,Popup:750,Control:1000},EVENT_TYPES:["preaddlayer","addlayer","removelayer","changelayer","movestart","move","moveend","zoomend","popupopen","popupclose","addmarker","removemarker","clearmarkers","mouseover","mouseout","mousemove","dragstart","drag","dragend","changebaselayer"],id:null,fractionalZoom:false,events:null,allOverlays:false,div:null,dragging:false,size:null,viewPortDiv:null,layerContainerOrigin:null,layerContainerDiv:null,layers:null,controls:null,popups:null,baseLayer:null,center:null,resolution:null,zoom:0,panRatio:1.5,viewRequestID:0,tileSize:null,projection:"EPSG:4326",units:"degrees",resolutions:null,maxResolution:1.40625,minResolution:null,maxScale:null,minScale:null,maxExtent:null,minExtent:null,restrictedExtent:null,numZoomLevels:16,theme:null,displayProjection:null,fallThrough:true,panTween:null,eventListeners:null,panMethod:OpenLayers.Easing.Expo.easeOut,panDuration:50,paddingForPopups:null,initialize:function(h,d){if(arguments.length===1&&typeof h==="object"){d=h;
h=d&&d.div
}this.tileSize=new OpenLayers.Size(OpenLayers.Map.TILE_WIDTH,OpenLayers.Map.TILE_HEIGHT);
this.maxExtent=new OpenLayers.Bounds(-180,-90,180,90);
this.paddingForPopups=new OpenLayers.Bounds(15,15,15,15);
this.theme=OpenLayers._getScriptLocation()+"theme/default/style.css";
OpenLayers.Util.extend(this,d);
this.layers=[];
this.id=OpenLayers.Util.createUniqueID("OpenLayers.Map_");
this.div=OpenLayers.Util.getElement(h);
if(!this.div){this.div=document.createElement("div");
this.div.style.height="1px";
this.div.style.width="1px"
}OpenLayers.Element.addClass(this.div,"olMap");
var g=this.id+"_OpenLayers_ViewPort";
this.viewPortDiv=OpenLayers.Util.createDiv(g,null,null,null,"relative",null,"hidden");
this.viewPortDiv.style.width="100%";
this.viewPortDiv.style.height="100%";
this.viewPortDiv.className="olMapViewport";
this.div.appendChild(this.viewPortDiv);
g=this.id+"_OpenLayers_Container";
this.layerContainerDiv=OpenLayers.Util.createDiv(g);
this.layerContainerDiv.style.zIndex=this.Z_INDEX_BASE.Popup-1;
this.viewPortDiv.appendChild(this.layerContainerDiv);
this.events=new OpenLayers.Events(this,this.div,this.EVENT_TYPES,this.fallThrough,{includeXY:true});
this.updateSize();
if(this.eventListeners instanceof Object){this.events.on(this.eventListeners)
}this.events.register("movestart",this,this.updateSize);
if(OpenLayers.String.contains(navigator.appName,"Microsoft")){this.events.register("resize",this,this.updateSize)
}else{this.updateSizeDestroy=OpenLayers.Function.bind(this.updateSize,this);
OpenLayers.Event.observe(window,"resize",this.updateSizeDestroy)
}if(this.theme){var f=true;
var c=document.getElementsByTagName("link");
for(var e=0,a=c.length;
e<a;
++e){if(OpenLayers.Util.isEquivalentUrl(c.item(e).href,this.theme)){f=false;
break
}}if(f){var b=document.createElement("link");
b.setAttribute("rel","stylesheet");
b.setAttribute("type","text/css");
b.setAttribute("href",this.theme);
document.getElementsByTagName("head")[0].appendChild(b)
}}if(this.controls==null){if(OpenLayers.Control!=null){this.controls=[new OpenLayers.Control.Navigation(),new OpenLayers.Control.PanZoom(),new OpenLayers.Control.ArgParser(),new OpenLayers.Control.Attribution()]
}else{this.controls=[]
}}for(var e=0,a=this.controls.length;
e<a;
e++){this.addControlToMap(this.controls[e])
}this.popups=[];
this.unloadDestroy=OpenLayers.Function.bind(this.destroy,this);
OpenLayers.Event.observe(window,"unload",this.unloadDestroy);
if(d&&d.layers){this.addLayers(d.layers);
if(d.center){this.setCenter(d.center,d.zoom)
}}},render:function(a){this.div=OpenLayers.Util.getElement(a);
OpenLayers.Element.addClass(this.div,"olMap");
this.events.attachToElement(this.div);
this.viewPortDiv.parentNode.removeChild(this.viewPortDiv);
this.div.appendChild(this.viewPortDiv);
this.updateSize()
},unloadDestroy:null,updateSizeDestroy:null,destroy:function(){if(!this.unloadDestroy){return false
}if(this.panTween){this.panTween.stop();
this.panTween=null
}OpenLayers.Event.stopObserving(window,"unload",this.unloadDestroy);
this.unloadDestroy=null;
if(this.updateSizeDestroy){OpenLayers.Event.stopObserving(window,"resize",this.updateSizeDestroy)
}else{this.events.unregister("resize",this,this.updateSize)
}this.paddingForPopups=null;
if(this.controls!=null){for(var a=this.controls.length-1;
a>=0;
--a){this.controls[a].destroy()
}this.controls=null
}if(this.layers!=null){for(var a=this.layers.length-1;
a>=0;
--a){this.layers[a].destroy(false)
}this.layers=null
}if(this.viewPortDiv){this.div.removeChild(this.viewPortDiv)
}this.viewPortDiv=null;
if(this.eventListeners){this.events.un(this.eventListeners);
this.eventListeners=null
}this.events.destroy();
this.events=null
},setOptions:function(a){OpenLayers.Util.extend(this,a)
},getTileSize:function(){return this.tileSize
},getBy:function(e,c,a){var d=(typeof a.test=="function");
var b=OpenLayers.Array.filter(this[e],function(f){return f[c]==a||(d&&a.test(f[c]))
});
return b
},getLayersBy:function(b,a){return this.getBy("layers",b,a)
},getLayersByName:function(a){return this.getLayersBy("name",a)
},getLayersByClass:function(a){return this.getLayersBy("CLASS_NAME",a)
},getControlsBy:function(b,a){return this.getBy("controls",b,a)
},getControlsByClass:function(a){return this.getControlsBy("CLASS_NAME",a)
},getLayer:function(e){var b=null;
for(var d=0,a=this.layers.length;
d<a;
d++){var c=this.layers[d];
if(c.id==e){b=c;
break
}}return b
},setLayerZIndex:function(b,a){b.setZIndex(this.Z_INDEX_BASE[b.isBaseLayer?"BaseLayer":"Overlay"]+a*5)
},resetLayersZIndex:function(){for(var c=0,a=this.layers.length;
c<a;
c++){var b=this.layers[c];
this.setLayerZIndex(b,c)
}},addLayer:function(c){for(var b=0,a=this.layers.length;
b<a;
b++){if(this.layers[b]==c){var d=OpenLayers.i18n("layerAlreadyAdded",{layerName:c.name});
OpenLayers.Console.warn(d);
return false
}}if(this.allOverlays){c.isBaseLayer=false
}if(this.events.triggerEvent("preaddlayer",{layer:c})===false){return
}c.div.className="olLayerDiv";
c.div.style.overflow="";
this.setLayerZIndex(c,this.layers.length);
if(c.isFixed){this.viewPortDiv.appendChild(c.div)
}else{this.layerContainerDiv.appendChild(c.div)
}this.layers.push(c);
c.setMap(this);
if(c.isBaseLayer||(this.allOverlays&&!this.baseLayer)){if(this.baseLayer==null){this.setBaseLayer(c)
}else{c.setVisibility(false)
}}else{c.redraw()
}this.events.triggerEvent("addlayer",{layer:c});
c.afterAdd()
},addLayers:function(c){for(var b=0,a=c.length;
b<a;
b++){this.addLayer(c[b])
}},removeLayer:function(c,e){if(e==null){e=true
}if(c.isFixed){this.viewPortDiv.removeChild(c.div)
}else{this.layerContainerDiv.removeChild(c.div)
}OpenLayers.Util.removeItem(this.layers,c);
c.removeMap(this);
c.map=null;
if(this.baseLayer==c){this.baseLayer=null;
if(e){for(var b=0,a=this.layers.length;
b<a;
b++){var d=this.layers[b];
if(d.isBaseLayer||this.allOverlays){this.setBaseLayer(d);
break
}}}}this.resetLayersZIndex();
this.events.triggerEvent("removelayer",{layer:c})
},getNumLayers:function(){return this.layers.length
},getLayerIndex:function(a){return OpenLayers.Util.indexOf(this.layers,a)
},setLayerIndex:function(d,b){var e=this.getLayerIndex(d);
if(b<0){b=0
}else{if(b>this.layers.length){b=this.layers.length
}}if(e!=b){this.layers.splice(e,1);
this.layers.splice(b,0,d);
for(var c=0,a=this.layers.length;
c<a;
c++){this.setLayerZIndex(this.layers[c],c)
}this.events.triggerEvent("changelayer",{layer:d,property:"order"});
if(this.allOverlays){if(b===0){this.setBaseLayer(d)
}else{if(this.baseLayer!==this.layers[0]){this.setBaseLayer(this.layers[0])
}}}}},raiseLayer:function(b,c){var a=this.getLayerIndex(b)+c;
this.setLayerIndex(b,a)
},setBaseLayer:function(c){if(c!=this.baseLayer){if(OpenLayers.Util.indexOf(this.layers,c)!=-1){var a=this.getCenter();
var d=OpenLayers.Util.getResolutionFromScale(this.getScale(),c.units);
if(this.baseLayer!=null&&!this.allOverlays){this.baseLayer.setVisibility(false)
}this.baseLayer=c;
this.viewRequestID++;
if(!this.allOverlays||this.baseLayer.visibility){this.baseLayer.setVisibility(true)
}if(a!=null){var b=this.getZoomForResolution(d||this.resolution,true);
this.setCenter(a,b,false,true)
}this.events.triggerEvent("changebaselayer",{layer:this.baseLayer})
}}},addControl:function(b,a){this.controls.push(b);
this.addControlToMap(b,a)
},addControls:function(b,g){var e=(arguments.length===1)?[]:g;
for(var d=0,a=b.length;
d<a;
d++){var f=b[d];
var c=(e[d])?e[d]:null;
this.addControl(f,c)
}},addControlToMap:function(b,a){b.outsideViewport=(b.div!=null);
if(this.displayProjection&&!b.displayProjection){b.displayProjection=this.displayProjection
}b.setMap(this);
var c=b.draw(a);
if(c){if(!b.outsideViewport){c.style.zIndex=this.Z_INDEX_BASE.Control+this.controls.length;
this.viewPortDiv.appendChild(c)
}}if(b.autoActivate){b.activate()
}},getControl:function(e){var b=null;
for(var c=0,a=this.controls.length;
c<a;
c++){var d=this.controls[c];
if(d.id==e){b=d;
break
}}return b
},removeControl:function(a){if((a)&&(a==this.getControl(a.id))){if(a.div&&(a.div.parentNode==this.viewPortDiv)){this.viewPortDiv.removeChild(a.div)
}OpenLayers.Util.removeItem(this.controls,a)
}},addPopup:function(a,d){if(d){for(var b=this.popups.length-1;
b>=0;
--b){this.removePopup(this.popups[b])
}}a.map=this;
this.popups.push(a);
var c=a.draw();
if(c){c.style.zIndex=this.Z_INDEX_BASE.Popup+this.popups.length;
this.layerContainerDiv.appendChild(c)
}},removePopup:function(a){OpenLayers.Util.removeItem(this.popups,a);
if(a.div){try{this.layerContainerDiv.removeChild(a.div)
}catch(b){}}a.map=null
},getSize:function(){var a=null;
if(this.size!=null){a=this.size.clone()
}return a
},updateSize:function(){var c=this.getCurrentSize();
if(c&&!isNaN(c.h)&&!isNaN(c.w)){this.events.clearMouseCache();
var f=this.getSize();
if(f==null){this.size=f=c
}if(!c.equals(f)){this.size=c;
for(var d=0,b=this.layers.length;
d<b;
d++){this.layers[d].onMapResize()
}var a=this.getCenter();
if(this.baseLayer!=null&&a!=null){var e=this.getZoom();
this.zoom=null;
this.setCenter(a,e)
}}}},getCurrentSize:function(){var a=new OpenLayers.Size(this.div.clientWidth,this.div.clientHeight);
if(a.w==0&&a.h==0||isNaN(a.w)&&isNaN(a.h)){a.w=this.div.offsetWidth;
a.h=this.div.offsetHeight
}if(a.w==0&&a.h==0||isNaN(a.w)&&isNaN(a.h)){a.w=parseInt(this.div.style.width);
a.h=parseInt(this.div.style.height)
}return a
},calculateBounds:function(a,b){var e=null;
if(a==null){a=this.getCenter()
}if(b==null){b=this.getResolution()
}if((a!=null)&&(b!=null)){var d=this.getSize();
var f=d.w*b;
var c=d.h*b;
e=new OpenLayers.Bounds(a.lon-f/2,a.lat-c/2,a.lon+f/2,a.lat+c/2)
}return e
},getCenter:function(){var a=null;
if(this.center){a=this.center.clone()
}return a
},getZoom:function(){return this.zoom
},pan:function(d,c,e){e=OpenLayers.Util.applyDefaults(e,{animate:true,dragging:false});
var f=this.getViewPortPxFromLonLat(this.getCenter());
var b=f.add(d,c);
if(!e.dragging||!b.equals(f)){var a=this.getLonLatFromViewPortPx(b);
if(e.animate){this.panTo(a)
}else{this.setCenter(a,null,e.dragging)
}}},panTo:function(b){if(this.panMethod&&this.getExtent().scale(this.panRatio).containsLonLat(b)){if(!this.panTween){this.panTween=new OpenLayers.Tween(this.panMethod)
}var a=this.getCenter();
if(b.lon==a.lon&&b.lat==a.lat){return
}var d={lon:a.lon,lat:a.lat};
var c={lon:b.lon,lat:b.lat};
this.panTween.start(d,c,this.panDuration,{callbacks:{start:OpenLayers.Function.bind(function(e){this.events.triggerEvent("movestart")
},this),eachStep:OpenLayers.Function.bind(function(e){e=new OpenLayers.LonLat(e.lon,e.lat);
this.moveTo(e,this.zoom,{dragging:true,noEvent:true})
},this),done:OpenLayers.Function.bind(function(e){e=new OpenLayers.LonLat(e.lon,e.lat);
this.moveTo(e,this.zoom,{noEvent:true});
this.events.triggerEvent("moveend")
},this)}})
}else{this.setCenter(b)
}},setCenter:function(c,a,b,d){this.moveTo(c,a,{dragging:b,forceZoomChange:d,caller:"setCenter"})
},moveTo:function(g,n,q){if(!q){q={}
}if(n!=null){n=parseFloat(n);
if(!this.fractionalZoom){n=Math.round(n)
}}var m=q.dragging;
var c=q.forceZoomChange;
var h=q.noEvent;
if(this.panTween&&q.caller=="setCenter"){this.panTween.stop()
}if(!this.center&&!this.isValidLonLat(g)){g=this.maxExtent.getCenterLonLat()
}if(this.restrictedExtent!=null){if(g==null){g=this.getCenter()
}if(n==null){n=this.getZoom()
}var d=this.getResolutionForZoom(n);
var o=this.calculateBounds(g,d);
if(!this.restrictedExtent.containsBounds(o)){var p=this.restrictedExtent.getCenterLonLat();
if(o.getWidth()>this.restrictedExtent.getWidth()){g=new OpenLayers.LonLat(p.lon,g.lat)
}else{if(o.left<this.restrictedExtent.left){g=g.add(this.restrictedExtent.left-o.left,0)
}else{if(o.right>this.restrictedExtent.right){g=g.add(this.restrictedExtent.right-o.right,0)
}}}if(o.getHeight()>this.restrictedExtent.getHeight()){g=new OpenLayers.LonLat(g.lon,p.lat)
}else{if(o.bottom<this.restrictedExtent.bottom){g=g.add(0,this.restrictedExtent.bottom-o.bottom)
}else{if(o.top>this.restrictedExtent.top){g=g.add(0,this.restrictedExtent.top-o.top)
}}}}}var b=c||((this.isValidZoomLevel(n))&&(n!=this.getZoom()));
var e=(this.isValidLonLat(g))&&(!g.equals(this.center));
if(b||e||!m){if(!this.dragging&&!h){this.events.triggerEvent("movestart")
}if(e){if((!b)&&(this.center)){this.centerLayerContainer(g)
}this.center=g.clone()
}if((b)||(this.layerContainerOrigin==null)){this.layerContainerOrigin=this.center.clone();
this.layerContainerDiv.style.left="0px";
this.layerContainerDiv.style.top="0px"
}if(b){this.zoom=n;
this.resolution=this.getResolutionForZoom(n);
this.viewRequestID++
}var a=this.getExtent();
if(this.baseLayer.visibility){this.baseLayer.moveTo(a,b,m);
if(m){this.baseLayer.events.triggerEvent("move")
}else{this.baseLayer.events.triggerEvent("moveend",{zoomChanged:b})
}}a=this.baseLayer.getExtent();
for(var f=0,k=this.layers.length;
f<k;
f++){var j=this.layers[f];
if(j!==this.baseLayer&&!j.isBaseLayer){var l=j.calculateInRange();
if(j.inRange!=l){j.inRange=l;
if(!l){j.display(false)
}this.events.triggerEvent("changelayer",{layer:j,property:"visibility"})
}if(l&&j.visibility){j.moveTo(a,b,m);
if(m){j.events.triggerEvent("move")
}else{j.events.triggerEvent("moveend",{zoomChanged:b})
}}}}if(b){for(var f=0,k=this.popups.length;
f<k;
f++){this.popups[f].updatePosition()
}}this.events.triggerEvent("move");
if(b){this.events.triggerEvent("zoomend")
}}if(!m&&!h){this.events.triggerEvent("moveend")
}this.dragging=!!m
},centerLayerContainer:function(b){var a=this.getViewPortPxFromLonLat(this.layerContainerOrigin);
var c=this.getViewPortPxFromLonLat(b);
if((a!=null)&&(c!=null)){this.layerContainerDiv.style.left=Math.round(a.x-c.x)+"px";
this.layerContainerDiv.style.top=Math.round(a.y-c.y)+"px"
}},isValidZoomLevel:function(a){return((a!=null)&&(a>=0)&&(a<this.getNumZoomLevels()))
},isValidLonLat:function(c){var b=false;
if(c!=null){var a=this.getMaxExtent();
b=a.containsLonLat(c)
}return b
},getProjection:function(){var a=this.getProjectionObject();
return a?a.getCode():null
},getProjectionObject:function(){var a=null;
if(this.baseLayer!=null){a=this.baseLayer.projection
}return a
},getMaxResolution:function(){var a=null;
if(this.baseLayer!=null){a=this.baseLayer.maxResolution
}return a
},getMaxExtent:function(b){var a=null;
if(b&&b.restricted&&this.restrictedExtent){a=this.restrictedExtent
}else{if(this.baseLayer!=null){a=this.baseLayer.maxExtent
}}return a
},getNumZoomLevels:function(){var a=null;
if(this.baseLayer!=null){a=this.baseLayer.numZoomLevels
}return a
},getExtent:function(){var a=null;
if(this.baseLayer!=null){a=this.baseLayer.getExtent()
}return a
},getResolution:function(){var a=null;
if(this.baseLayer!=null){a=this.baseLayer.getResolution()
}else{if(this.allOverlays===true&&this.layers.length>0){a=this.layers[0].getResolution()
}}return a
},getUnits:function(){var a=null;
if(this.baseLayer!=null){a=this.baseLayer.units
}return a
},getScale:function(){var c=null;
if(this.baseLayer!=null){var b=this.getResolution();
var a=this.baseLayer.units;
c=OpenLayers.Util.getScaleFromResolution(b,a)
}return c
},getZoomForExtent:function(c,b){var a=null;
if(this.baseLayer!=null){a=this.baseLayer.getZoomForExtent(c,b)
}return a
},getResolutionForZoom:function(b){var a=null;
if(this.baseLayer){a=this.baseLayer.getResolutionForZoom(b)
}return a
},getZoomForResolution:function(a,c){var b=null;
if(this.baseLayer!=null){b=this.baseLayer.getZoomForResolution(a,c)
}return b
},zoomTo:function(a){if(this.isValidZoomLevel(a)){this.setCenter(null,a)
}},zoomIn:function(){this.zoomTo(this.getZoom()+1)
},zoomOut:function(){this.zoomTo(this.getZoom()-1)
},zoomToExtent:function(d,c){var b=d.getCenterLonLat();
if(this.baseLayer.wrapDateLine){var a=this.getMaxExtent();
d=d.clone();
while(d.right<d.left){d.right+=a.getWidth()
}b=d.getCenterLonLat().wrapDateLine(a)
}this.setCenter(b,this.getZoomForExtent(d,c))
},zoomToMaxExtent:function(c){var b=(c)?c.restricted:true;
var a=this.getMaxExtent({restricted:b});
this.zoomToExtent(a)
},zoomToScale:function(h,g){var d=OpenLayers.Util.getResolutionFromScale(h,this.baseLayer.units);
var c=this.getSize();
var f=c.w*d;
var b=c.h*d;
var a=this.getCenter();
var e=new OpenLayers.Bounds(a.lon-f/2,a.lat-b/2,a.lon+f/2,a.lat+b/2);
this.zoomToExtent(e,g)
},getLonLatFromViewPortPx:function(a){var b=null;
if(this.baseLayer!=null){b=this.baseLayer.getLonLatFromViewPortPx(a)
}return b
},getViewPortPxFromLonLat:function(b){var a=null;
if(this.baseLayer!=null){a=this.baseLayer.getViewPortPxFromLonLat(b)
}return a
},getLonLatFromPixel:function(a){return this.getLonLatFromViewPortPx(a)
},getPixelFromLonLat:function(b){var a=this.getViewPortPxFromLonLat(b);
a.x=Math.round(a.x);
a.y=Math.round(a.y);
return a
},getGeodesicPixelSize:function(g){var d=g?this.getLonLatFromPixel(g):(this.getCenter()||new OpenLayers.LonLat(0,0));
var e=this.getResolution();
var c=d.add(-e/2,0);
var i=d.add(e/2,0);
var b=d.add(0,-e/2);
var f=d.add(0,e/2);
var h=new OpenLayers.Projection("EPSG:4326");
var a=this.getProjectionObject()||h;
if(!a.equals(h)){c.transform(a,h);
i.transform(a,h);
b.transform(a,h);
f.transform(a,h)
}return new OpenLayers.Size(OpenLayers.Util.distVincenty(c,i),OpenLayers.Util.distVincenty(b,f))
},getViewPortPxFromLayerPx:function(d){var c=null;
if(d!=null){var b=parseInt(this.layerContainerDiv.style.left);
var a=parseInt(this.layerContainerDiv.style.top);
c=d.add(b,a)
}return c
},getLayerPxFromViewPortPx:function(c){var d=null;
if(c!=null){var b=-parseInt(this.layerContainerDiv.style.left);
var a=-parseInt(this.layerContainerDiv.style.top);
d=c.add(b,a);
if(isNaN(d.x)||isNaN(d.y)){d=null
}}return d
},getLonLatFromLayerPx:function(a){a=this.getViewPortPxFromLayerPx(a);
return this.getLonLatFromViewPortPx(a)
},getLayerPxFromLonLat:function(b){var a=this.getPixelFromLonLat(b);
return this.getLayerPxFromViewPortPx(a)
},CLASS_NAME:"OpenLayers.Map"});
OpenLayers.Map.TILE_WIDTH=256;
OpenLayers.Map.TILE_HEIGHT=256;OpenLayers.Projection=OpenLayers.Class({proj:null,projCode:null,initialize:function(b,a){OpenLayers.Util.extend(this,a);
this.projCode=b;
if(window.Proj4js){this.proj=new Proj4js.Proj(b)
}},getCode:function(){return this.proj?this.proj.srsCode:this.projCode
},getUnits:function(){return this.proj?this.proj.units:null
},toString:function(){return this.getCode()
},equals:function(a){if(a&&a.getCode){return this.getCode()==a.getCode()
}else{return false
}},destroy:function(){delete this.proj;
delete this.projCode
},CLASS_NAME:"OpenLayers.Projection"});
OpenLayers.Projection.transforms={};
OpenLayers.Projection.addTransform=function(c,b,a){if(!OpenLayers.Projection.transforms[c]){OpenLayers.Projection.transforms[c]={}
}OpenLayers.Projection.transforms[c][b]=a
};
OpenLayers.Projection.transform=function(a,c,b){if(c.proj&&b.proj){a=Proj4js.transform(c.proj,b.proj,a)
}else{if(c&&b&&OpenLayers.Projection.transforms[c.getCode()]&&OpenLayers.Projection.transforms[c.getCode()][b.getCode()]){OpenLayers.Projection.transforms[c.getCode()][b.getCode()](a)
}}return a
};OpenLayers.Layer=OpenLayers.Class({id:null,name:null,div:null,opacity:null,alwaysInRange:null,EVENT_TYPES:["loadstart","loadend","loadcancel","visibilitychanged","move","moveend"],RESOLUTION_PROPERTIES:["scales","resolutions","maxScale","minScale","maxResolution","minResolution","numZoomLevels","maxZoomLevel"],events:null,map:null,isBaseLayer:false,alpha:false,displayInLayerSwitcher:true,visibility:true,attribution:null,inRange:false,imageSize:null,imageOffset:null,options:null,eventListeners:null,gutter:0,projection:null,units:null,scales:null,resolutions:null,maxExtent:null,minExtent:null,maxResolution:null,minResolution:null,numZoomLevels:null,minScale:null,maxScale:null,displayOutsideMaxExtent:false,wrapDateLine:false,transitionEffect:null,SUPPORTED_TRANSITIONS:["resize"],metadata:{},initialize:function(b,a){this.addOptions(a);
this.name=b;
if(this.id==null){this.id=OpenLayers.Util.createUniqueID(this.CLASS_NAME+"_");
this.div=OpenLayers.Util.createDiv(this.id);
this.div.style.width="100%";
this.div.style.height="100%";
this.div.dir="ltr";
this.events=new OpenLayers.Events(this,this.div,this.EVENT_TYPES);
if(this.eventListeners instanceof Object){this.events.on(this.eventListeners)
}}if(this.wrapDateLine){this.displayOutsideMaxExtent=true
}},destroy:function(a){if(a==null){a=true
}if(this.map!=null){this.map.removeLayer(this,a)
}this.projection=null;
this.map=null;
this.name=null;
this.div=null;
this.options=null;
if(this.events){if(this.eventListeners){this.events.un(this.eventListeners)
}this.events.destroy()
}this.eventListeners=null;
this.events=null
},clone:function(a){if(a==null){a=new OpenLayers.Layer(this.name,this.getOptions())
}OpenLayers.Util.applyDefaults(a,this);
a.map=null;
return a
},getOptions:function(){var a={};
for(var b in this.options){a[b]=this[b]
}return a
},setName:function(a){if(a!=this.name){this.name=a;
if(this.map!=null){this.map.events.triggerEvent("changelayer",{layer:this,property:"name"})
}}},addOptions:function(c){if(this.options==null){this.options={}
}OpenLayers.Util.extend(this.options,c);
OpenLayers.Util.extend(this,c);
if(typeof this.projection=="string"){this.projection=new OpenLayers.Projection(this.projection)
}if(this.projection&&this.projection.getUnits()){this.units=this.projection.getUnits()
}if(this.map){var a=this.RESOLUTION_PROPERTIES.concat(["projection","units","minExtent","maxExtent"]);
for(var b in c){if(c.hasOwnProperty(b)&&OpenLayers.Util.indexOf(a,b)>=0){this.initResolutions();
break
}}}},onMapResize:function(){},redraw:function(){var b=false;
if(this.map){this.inRange=this.calculateInRange();
var c=this.getExtent();
if(c&&this.inRange&&this.visibility){var a=true;
this.moveTo(c,a,false);
this.events.triggerEvent("moveend",{zoomChanged:a});
b=true
}}return b
},moveTo:function(b,a,c){var d=this.visibility;
if(!this.isBaseLayer){d=d&&this.inRange
}this.display(d)
},setMap:function(b){if(this.map==null){this.map=b;
this.maxExtent=this.maxExtent||this.map.maxExtent;
this.minExtent=this.minExtent||this.map.minExtent;
this.projection=this.projection||this.map.projection;
if(typeof this.projection=="string"){this.projection=new OpenLayers.Projection(this.projection)
}this.units=this.projection.getUnits()||this.units||this.map.units;
this.initResolutions();
if(!this.isBaseLayer){this.inRange=this.calculateInRange();
var a=((this.visibility)&&(this.inRange));
this.div.style.display=a?"":"none"
}this.setTileSize()
}},afterAdd:function(){},removeMap:function(a){},getImageSize:function(a){return(this.imageSize||this.tileSize)
},setTileSize:function(a){var b=(a)?a:((this.tileSize)?this.tileSize:this.map.getTileSize());
this.tileSize=b;
if(this.gutter){this.imageOffset=new OpenLayers.Pixel(-this.gutter,-this.gutter);
this.imageSize=new OpenLayers.Size(b.w+(2*this.gutter),b.h+(2*this.gutter))
}},getVisibility:function(){return this.visibility
},setVisibility:function(a){if(a!=this.visibility){this.visibility=a;
this.display(a);
this.redraw();
if(this.map!=null){this.map.events.triggerEvent("changelayer",{layer:this,property:"visibility"})
}this.events.triggerEvent("visibilitychanged")
}},display:function(a){if(a!=(this.div.style.display!="none")){this.div.style.display=(a&&this.calculateInRange())?"block":"none"
}},calculateInRange:function(){var b=false;
if(this.alwaysInRange){b=true
}else{if(this.map){var a=this.map.getResolution();
b=((a>=this.minResolution)&&(a<=this.maxResolution))
}}return b
},setIsBaseLayer:function(a){if(a!=this.isBaseLayer){this.isBaseLayer=a;
if(this.map!=null){this.map.events.triggerEvent("changebaselayer",{layer:this})
}}},initResolutions:function(){var e,a;
var f={},d=true;
for(e=0,a=this.RESOLUTION_PROPERTIES.length;
e<a;
e++){var h=this.RESOLUTION_PROPERTIES[e];
f[h]=this.options[h];
if(d&&this.options[h]){d=false
}}if(this.alwaysInRange==null){this.alwaysInRange=d
}if(f.resolutions==null){f.resolutions=this.resolutionsFromScales(f.scales)
}if(f.resolutions==null){f.resolutions=this.calculateResolutions(f)
}if(f.resolutions==null){for(e=0,a=this.RESOLUTION_PROPERTIES.length;
e<a;
e++){var h=this.RESOLUTION_PROPERTIES[e];
f[h]=this.options[h]!=null?this.options[h]:this.map[h]
}if(f.resolutions==null){f.resolutions=this.resolutionsFromScales(f.scales)
}if(f.resolutions==null){f.resolutions=this.calculateResolutions(f)
}}var c;
if(this.options.maxResolution&&this.options.maxResolution!=="auto"){c=this.options.maxResolution
}if(this.options.minScale){c=OpenLayers.Util.getResolutionFromScale(this.options.minScale,this.units)
}var b;
if(this.options.minResolution&&this.options.minResolution!=="auto"){b=this.options.minResolution
}if(this.options.maxScale){b=OpenLayers.Util.getResolutionFromScale(this.options.maxScale,this.units)
}if(f.resolutions){f.resolutions.sort(function(j,i){return(i-j)
});
if(!c){c=f.resolutions[0]
}if(!b){var g=f.resolutions.length-1;
b=f.resolutions[g]
}}this.resolutions=f.resolutions;
if(this.resolutions){a=this.resolutions.length;
this.scales=new Array(a);
for(e=0;
e<a;
e++){this.scales[e]=OpenLayers.Util.getScaleFromResolution(this.resolutions[e],this.units)
}this.numZoomLevels=a
}this.minResolution=b;
if(b){this.maxScale=OpenLayers.Util.getScaleFromResolution(b,this.units)
}this.maxResolution=c;
if(c){this.minScale=OpenLayers.Util.getScaleFromResolution(c,this.units)
}},resolutionsFromScales:function(d){if(d==null){return
}var b,c,a;
a=d.length;
b=new Array(a);
for(c=0;
c<a;
c++){b[c]=OpenLayers.Util.getResolutionFromScale(d[c],this.units)
}return b
},calculateResolutions:function(k){var m=k.maxResolution;
if(k.minScale!=null){m=OpenLayers.Util.getResolutionFromScale(k.minScale,this.units)
}else{if(m=="auto"&&this.maxExtent!=null){var l=this.map.getSize();
var j=this.maxExtent.getWidth()/l.w;
var g=this.maxExtent.getHeight()/l.h;
m=Math.max(j,g)
}}var f=k.minResolution;
if(k.maxScale!=null){f=OpenLayers.Util.getResolutionFromScale(k.maxScale,this.units)
}else{if(k.minResolution=="auto"&&this.minExtent!=null){var l=this.map.getSize();
var j=this.minExtent.getWidth()/l.w;
var g=this.minExtent.getHeight()/l.h;
f=Math.max(j,g)
}}var a=k.maxZoomLevel;
var b=k.numZoomLevels;
if(typeof f==="number"&&typeof m==="number"&&b===undefined){var h=m/f;
b=Math.floor(Math.log(h)/Math.log(2))+1
}else{if(b===undefined&&a!=null){b=a+1
}}if(typeof b!=="number"||b<=0||(typeof m!=="number"&&typeof f!=="number")){return
}var d=new Array(b);
var c=2;
if(typeof f=="number"&&typeof m=="number"){c=Math.pow((m/f),(1/(b-1)))
}var e;
if(typeof m==="number"){for(e=0;
e<b;
e++){d[e]=m/Math.pow(c,e)
}}else{for(e=0;
e<b;
e++){d[b-1-e]=f*Math.pow(c,e)
}}return d
},getResolution:function(){var a=this.map.getZoom();
return this.getResolutionForZoom(a)
},getExtent:function(){return this.map.calculateBounds()
},getZoomForExtent:function(b,c){var d=this.map.getSize();
var a=Math.max(b.getWidth()/d.w,b.getHeight()/d.h);
return this.getZoomForResolution(a,c)
},getDataExtent:function(){},getResolutionForZoom:function(c){c=Math.max(0,Math.min(c,this.resolutions.length-1));
var b;
if(this.map.fractionalZoom){var a=Math.floor(c);
var d=Math.ceil(c);
b=this.resolutions[a]-((c-a)*(this.resolutions[a]-this.resolutions[d]))
}else{b=this.resolutions[Math.round(c)]
}return b
},getZoomForResolution:function(e,a){var n;
if(this.map.fractionalZoom){var k=0;
var c=this.resolutions.length-1;
var d=this.resolutions[k];
var b=this.resolutions[c];
var j;
for(var f=0,g=this.resolutions.length;
f<g;
++f){j=this.resolutions[f];
if(j>=e){d=j;
k=f
}if(j<=e){b=j;
c=f;
break
}}var h=d-b;
if(h>0){n=k+((d-e)/h)
}else{n=k
}}else{var l;
var m=Number.POSITIVE_INFINITY;
for(var f=0,g=this.resolutions.length;
f<g;
f++){if(a){l=Math.abs(this.resolutions[f]-e);
if(l>m){break
}m=l
}else{if(this.resolutions[f]<e){break
}}}n=Math.max(0,f-1)
}return n
},getLonLatFromViewPortPx:function(b){var e=null;
if(b!=null){var d=this.map.getSize();
var a=this.map.getCenter();
if(a){var c=this.map.getResolution();
var g=b.x-(d.w/2);
var f=b.y-(d.h/2);
e=new OpenLayers.LonLat(a.lon+g*c,a.lat-f*c);
if(this.wrapDateLine){e=e.wrapDateLine(this.maxExtent)
}}}return e
},getViewPortPxFromLonLat:function(d){var b=null;
if(d!=null){var a=this.map.getResolution();
var c=this.map.getExtent();
b=new OpenLayers.Pixel((1/a*(d.lon-c.left)),(1/a*(c.top-d.lat)))
}return b
},setOpacity:function(b){if(b!=this.opacity){this.opacity=b;
for(var d=0,a=this.div.childNodes.length;
d<a;
++d){var c=this.div.childNodes[d].firstChild;
OpenLayers.Util.modifyDOMElement(c,null,null,null,null,null,null,b)
}if(this.map!=null){this.map.events.triggerEvent("changelayer",{layer:this,property:"opacity"})
}}},getZIndex:function(){return this.div.style.zIndex
},setZIndex:function(a){this.div.style.zIndex=a
},adjustBounds:function(b){if(this.gutter){var a=this.gutter*this.map.getResolution();
b=new OpenLayers.Bounds(b.left-a,b.bottom-a,b.right+a,b.top+a)
}if(this.wrapDateLine){var c={rightTolerance:this.getResolution()};
b=b.wrapDateLine(this.maxExtent,c)
}return b
},CLASS_NAME:"OpenLayers.Layer"});OpenLayers.Tile=OpenLayers.Class({EVENT_TYPES:["loadstart","loadend","reload","unload"],events:null,id:null,layer:null,url:null,bounds:null,size:null,position:null,isLoading:false,initialize:function(d,a,e,b,c){this.layer=d;
this.position=a.clone();
this.bounds=e.clone();
this.url=b;
this.size=c.clone();
this.id=OpenLayers.Util.createUniqueID("Tile_");
this.events=new OpenLayers.Events(this,null,this.EVENT_TYPES)
},unload:function(){if(this.isLoading){this.isLoading=false;
this.events.triggerEvent("unload")
}},destroy:function(){this.layer=null;
this.bounds=null;
this.size=null;
this.position=null;
this.events.destroy();
this.events=null
},clone:function(a){if(a==null){a=new OpenLayers.Tile(this.layer,this.position,this.bounds,this.url,this.size)
}OpenLayers.Util.applyDefaults(a,this);
return a
},draw:function(){var a=this.layer.maxExtent;
var b=(a&&this.bounds.intersectsBounds(a,false));
this.shouldDraw=(b||this.layer.displayOutsideMaxExtent);
this.clear();
return this.shouldDraw
},moveTo:function(b,a,c){if(c==null){c=true
}this.bounds=b.clone();
this.position=a.clone();
if(c){this.draw()
}},clear:function(){},getBoundsFromBaseLayer:function(a){var f=OpenLayers.i18n("reprojectDeprecated",{layerName:this.layer.name});
OpenLayers.Console.warn(f);
var d=this.layer.map.getLonLatFromLayerPx(a);
var c=a.clone();
c.x+=this.size.w;
c.y+=this.size.h;
var b=this.layer.map.getLonLatFromLayerPx(c);
if(d.lon>b.lon){if(d.lon<0){d.lon=-180-(d.lon+180)
}else{b.lon=180+b.lon+180
}}var e=new OpenLayers.Bounds(d.lon,b.lat,b.lon,d.lat);
return e
},showTile:function(){if(this.shouldDraw){this.show()
}},show:function(){},hide:function(){},CLASS_NAME:"OpenLayers.Tile"});OpenLayers.Tile.Image=OpenLayers.Class(OpenLayers.Tile,{url:null,imgDiv:null,frame:null,layerAlphaHack:null,isBackBuffer:false,lastRatio:1,isFirstDraw:true,backBufferTile:null,initialize:function(d,a,e,b,c){OpenLayers.Tile.prototype.initialize.apply(this,arguments);
this.url=b;
this.frame=document.createElement("div");
this.frame.style.overflow="hidden";
this.frame.style.position="absolute";
this.layerAlphaHack=this.layer.alpha&&OpenLayers.Util.alphaHack()
},destroy:function(){if(this.imgDiv!=null){if(this.layerAlphaHack){OpenLayers.Event.stopObservingElement(this.imgDiv.childNodes[0])
}OpenLayers.Event.stopObservingElement(this.imgDiv);
if(this.imgDiv.parentNode==this.frame){this.frame.removeChild(this.imgDiv);
this.imgDiv.map=null
}this.imgDiv.urls=null;
this.imgDiv.src=OpenLayers.Util.getImagesLocation()+"blank.gif"
}this.imgDiv=null;
if((this.frame!=null)&&(this.frame.parentNode==this.layer.div)){this.layer.div.removeChild(this.frame)
}this.frame=null;
if(this.backBufferTile){this.backBufferTile.destroy();
this.backBufferTile=null
}this.layer.events.unregister("loadend",this,this.resetBackBuffer);
OpenLayers.Tile.prototype.destroy.apply(this,arguments)
},clone:function(a){if(a==null){a=new OpenLayers.Tile.Image(this.layer,this.position,this.bounds,this.url,this.size)
}a=OpenLayers.Tile.prototype.clone.apply(this,[a]);
a.imgDiv=null;
return a
},draw:function(){if(this.layer!=this.layer.map.baseLayer&&this.layer.reproject){this.bounds=this.getBoundsFromBaseLayer(this.position)
}var a=OpenLayers.Tile.prototype.draw.apply(this,arguments);
if((OpenLayers.Util.indexOf(this.layer.SUPPORTED_TRANSITIONS,this.layer.transitionEffect)!=-1)||this.layer.singleTile){if(a){if(!this.backBufferTile){this.backBufferTile=this.clone();
this.backBufferTile.hide();
this.backBufferTile.isBackBuffer=true;
this.events.register("loadend",this,this.resetBackBuffer);
this.layer.events.register("loadend",this,this.resetBackBuffer)
}this.startTransition()
}else{if(this.backBufferTile){this.backBufferTile.clear()
}}}else{if(a&&this.isFirstDraw){this.events.register("loadend",this,this.showTile);
this.isFirstDraw=false
}}if(!a){return false
}if(this.isLoading){this.events.triggerEvent("reload")
}else{this.isLoading=true;
this.events.triggerEvent("loadstart")
}return this.renderTile()
},resetBackBuffer:function(){this.showTile();
if(this.backBufferTile&&(this.isFirstDraw||!this.layer.numLoadingTiles)){this.isFirstDraw=false;
var a=this.layer.maxExtent;
var b=(a&&this.bounds.intersectsBounds(a,false));
if(b){this.backBufferTile.position=this.position;
this.backBufferTile.bounds=this.bounds;
this.backBufferTile.size=this.size;
this.backBufferTile.imageSize=this.layer.getImageSize(this.bounds)||this.size;
this.backBufferTile.imageOffset=this.layer.imageOffset;
this.backBufferTile.resolution=this.layer.getResolution();
this.backBufferTile.renderTile()
}this.backBufferTile.hide()
}},renderTile:function(){if(this.imgDiv==null){this.initImgDiv()
}this.imgDiv.viewRequestID=this.layer.map.viewRequestID;
if(this.layer.async){this.layer.getURLasync(this.bounds,this,"url",this.positionImage)
}else{if(this.layer.url instanceof Array){this.imgDiv.urls=this.layer.url.slice()
}this.url=this.layer.getURL(this.bounds);
this.positionImage()
}return true
},positionImage:function(){if(this.layer===null){return
}OpenLayers.Util.modifyDOMElement(this.frame,null,this.position,this.size);
var a=this.layer.getImageSize(this.bounds);
if(this.layerAlphaHack){OpenLayers.Util.modifyAlphaImageDiv(this.imgDiv,null,null,a,this.url)
}else{OpenLayers.Util.modifyDOMElement(this.imgDiv,null,null,a);
this.imgDiv.src=this.url
}},clear:function(){if(this.imgDiv){this.hide();
if(OpenLayers.Tile.Image.useBlankTile){this.imgDiv.src=OpenLayers.Util.getImagesLocation()+"blank.gif"
}}},initImgDiv:function(){var d=this.layer.imageOffset;
var b=this.layer.getImageSize(this.bounds);
if(this.layerAlphaHack){this.imgDiv=OpenLayers.Util.createAlphaImageDiv(null,d,b,null,"relative",null,null,null,true)
}else{this.imgDiv=OpenLayers.Util.createImage(null,d,b,null,"relative",null,null,true)
}this.imgDiv.className="olTileImage";
this.frame.style.zIndex=this.isBackBuffer?0:1;
this.frame.appendChild(this.imgDiv);
this.layer.div.appendChild(this.frame);
if(this.layer.opacity!=null){OpenLayers.Util.modifyDOMElement(this.imgDiv,null,null,null,null,null,null,this.layer.opacity)
}this.imgDiv.map=this.layer.map;
var c=function(){if(this.isLoading){this.isLoading=false;
this.events.triggerEvent("loadend")
}};
if(this.layerAlphaHack){OpenLayers.Event.observe(this.imgDiv.childNodes[0],"load",OpenLayers.Function.bind(c,this))
}else{OpenLayers.Event.observe(this.imgDiv,"load",OpenLayers.Function.bind(c,this))
}var a=function(){if(this.imgDiv._attempts>OpenLayers.IMAGE_RELOAD_ATTEMPTS){c.call(this)
}};
OpenLayers.Event.observe(this.imgDiv,"error",OpenLayers.Function.bind(a,this))
},checkImgURL:function(){if(this.layer){var a=this.layerAlphaHack?this.imgDiv.firstChild.src:this.imgDiv.src;
if(!OpenLayers.Util.isEquivalentUrl(a,this.url)){this.hide()
}}},startTransition:function(){if(!this.backBufferTile||!this.backBufferTile.imgDiv){return
}var d=1;
if(this.backBufferTile.resolution){d=this.backBufferTile.resolution/this.layer.getResolution()
}if(d!=this.lastRatio){if(this.layer.transitionEffect=="resize"){var c=new OpenLayers.LonLat(this.backBufferTile.bounds.left,this.backBufferTile.bounds.top);
var b=new OpenLayers.Size(this.backBufferTile.size.w*d,this.backBufferTile.size.h*d);
var a=this.layer.map.getLayerPxFromLonLat(c);
OpenLayers.Util.modifyDOMElement(this.backBufferTile.frame,null,a,b);
var e=this.backBufferTile.imageSize;
e=new OpenLayers.Size(e.w*d,e.h*d);
var f=this.backBufferTile.imageOffset;
if(f){f=new OpenLayers.Pixel(f.x*d,f.y*d)
}OpenLayers.Util.modifyDOMElement(this.backBufferTile.imgDiv,null,f,e);
this.backBufferTile.show()
}}else{if(this.layer.singleTile){this.backBufferTile.show()
}else{this.backBufferTile.hide()
}}this.lastRatio=d
},show:function(){this.frame.style.display="";
if(OpenLayers.Util.indexOf(this.layer.SUPPORTED_TRANSITIONS,this.layer.transitionEffect)!=-1){if(navigator.userAgent.toLowerCase().indexOf("gecko")!=-1){this.frame.scrollLeft=this.frame.scrollLeft
}}},hide:function(){this.frame.style.display="none"
},CLASS_NAME:"OpenLayers.Tile.Image"});
OpenLayers.Tile.Image.useBlankTile=(OpenLayers.Util.getBrowserName()=="safari"||OpenLayers.Util.getBrowserName()=="opera");OpenLayers.Layer.Image=OpenLayers.Class(OpenLayers.Layer,{isBaseLayer:true,url:null,extent:null,size:null,tile:null,aspectRatio:null,initialize:function(c,b,e,d,a){this.url=b;
this.extent=e;
this.maxExtent=e;
this.size=d;
OpenLayers.Layer.prototype.initialize.apply(this,[c,a]);
this.aspectRatio=(this.extent.getHeight()/this.size.h)/(this.extent.getWidth()/this.size.w)
},destroy:function(){if(this.tile){this.removeTileMonitoringHooks(this.tile);
this.tile.destroy();
this.tile=null
}OpenLayers.Layer.prototype.destroy.apply(this,arguments)
},clone:function(a){if(a==null){a=new OpenLayers.Layer.Image(this.name,this.url,this.extent,this.size,this.getOptions())
}a=OpenLayers.Layer.prototype.clone.apply(this,[a]);
return a
},setMap:function(a){if(this.options.maxResolution==null){this.options.maxResolution=this.aspectRatio*this.extent.getWidth()/this.size.w
}OpenLayers.Layer.prototype.setMap.apply(this,arguments)
},moveTo:function(e,a,f){OpenLayers.Layer.prototype.moveTo.apply(this,arguments);
var b=(this.tile==null);
if(a||b){this.setTileSize();
var d=new OpenLayers.LonLat(this.extent.left,this.extent.top);
var c=this.map.getLayerPxFromLonLat(d);
if(b){this.tile=new OpenLayers.Tile.Image(this,c,this.extent,null,this.tileSize);
this.addTileMonitoringHooks(this.tile)
}else{this.tile.size=this.tileSize.clone();
this.tile.position=c.clone()
}this.tile.draw()
}},setTileSize:function(){var b=this.extent.getWidth()/this.map.getResolution();
var a=this.extent.getHeight()/this.map.getResolution();
this.tileSize=new OpenLayers.Size(b,a)
},addTileMonitoringHooks:function(a){a.onLoadStart=function(){this.events.triggerEvent("loadstart")
};
a.events.register("loadstart",this,a.onLoadStart);
a.onLoadEnd=function(){this.events.triggerEvent("loadend")
};
a.events.register("loadend",this,a.onLoadEnd);
a.events.register("unload",this,a.onLoadEnd)
},removeTileMonitoringHooks:function(a){a.unload();
a.events.un({loadstart:a.onLoadStart,loadend:a.onLoadEnd,unload:a.onLoadEnd,scope:this})
},setUrl:function(a){this.url=a;
this.tile.draw()
},getURL:function(a){return this.url
},CLASS_NAME:"OpenLayers.Layer.Image"});OpenLayers.Geometry.Collection=OpenLayers.Class(OpenLayers.Geometry,{components:null,componentTypes:null,initialize:function(a){OpenLayers.Geometry.prototype.initialize.apply(this,arguments);
this.components=[];
if(a!=null){this.addComponents(a)
}},destroy:function(){this.components.length=0;
this.components=null;
OpenLayers.Geometry.prototype.destroy.apply(this,arguments)
},clone:function(){var geometry=eval("new "+this.CLASS_NAME+"()");
for(var i=0,len=this.components.length;
i<len;
i++){geometry.addComponent(this.components[i].clone())
}OpenLayers.Util.applyDefaults(geometry,this);
return geometry
},getComponentsString:function(){var b=[];
for(var c=0,a=this.components.length;
c<a;
c++){b.push(this.components[c].toShortString())
}return b.join(",")
},calculateBounds:function(){this.bounds=null;
if(this.components&&this.components.length>0){this.setBounds(this.components[0].getBounds());
for(var b=1,a=this.components.length;
b<a;
b++){this.extendBounds(this.components[b].getBounds())
}}},addComponents:function(c){if(!(c instanceof Array)){c=[c]
}for(var b=0,a=c.length;
b<a;
b++){this.addComponent(c[b])
}},addComponent:function(b,a){var d=false;
if(b){if(this.componentTypes==null||(OpenLayers.Util.indexOf(this.componentTypes,b.CLASS_NAME)>-1)){if(a!=null&&(a<this.components.length)){var e=this.components.slice(0,a);
var c=this.components.slice(a,this.components.length);
e.push(b);
this.components=e.concat(c)
}else{this.components.push(b)
}b.parent=this;
this.clearBounds();
d=true
}}return d
},removeComponents:function(b){if(!(b instanceof Array)){b=[b]
}for(var a=b.length-1;
a>=0;
--a){this.removeComponent(b[a])
}},removeComponent:function(a){OpenLayers.Util.removeItem(this.components,a);
this.clearBounds()
},getLength:function(){var c=0;
for(var b=0,a=this.components.length;
b<a;
b++){c+=this.components[b].getLength()
}return c
},getArea:function(){var c=0;
for(var b=0,a=this.components.length;
b<a;
b++){c+=this.components[b].getArea()
}return c
},getGeodesicArea:function(b){var d=0;
for(var c=0,a=this.components.length;
c<a;
c++){d+=this.components[c].getGeodesicArea(b)
}return d
},getCentroid:function(g){if(!g){return this.components.length&&this.components[0].getCentroid()
}var l=this.components.length;
if(!l){return false
}var b=[];
var c=[];
var d=0;
var h=Number.MAX_VALUE;
var m;
for(var k=0;
k<l;
++k){m=this.components[k];
var e=m.getArea();
var f=m.getCentroid(true);
if(isNaN(e)||isNaN(f.x)||isNaN(f.y)){continue
}b.push(e);
d+=e;
h=(e<h&&e>0)?e:h;
c.push(f)
}l=b.length;
if(d===0){for(var k=0;
k<l;
++k){b[k]=1
}d=b.length
}else{for(var k=0;
k<l;
++k){b[k]/=h
}d/=h
}var j=0,a=0,f,e;
for(var k=0;
k<l;
++k){f=c[k];
e=b[k];
j+=f.x*e;
a+=f.y*e
}return new OpenLayers.Geometry.Point(j/d,a/d)
},getGeodesicLength:function(b){var d=0;
for(var c=0,a=this.components.length;
c<a;
c++){d+=this.components[c].getGeodesicLength(b)
}return d
},move:function(b,d){for(var c=0,a=this.components.length;
c<a;
c++){this.components[c].move(b,d)
}},rotate:function(d,b){for(var c=0,a=this.components.length;
c<a;
++c){this.components[c].rotate(d,b)
}},resize:function(d,a,c){for(var b=0;
b<this.components.length;
++b){this.components[b].resize(d,a,c)
}return this
},distanceTo:function(h,j){var c=!(j&&j.edge===false);
var a=c&&j&&j.details;
var k,d,b;
var e=Number.POSITIVE_INFINITY;
for(var f=0,g=this.components.length;
f<g;
++f){k=this.components[f].distanceTo(h,j);
b=a?k.distance:k;
if(b<e){e=b;
d=k;
if(e==0){break
}}}return d
},equals:function(d){var b=true;
if(!d||!d.CLASS_NAME||(this.CLASS_NAME!=d.CLASS_NAME)){b=false
}else{if(!(d.components instanceof Array)||(d.components.length!=this.components.length)){b=false
}else{for(var c=0,a=this.components.length;
c<a;
++c){if(!this.components[c].equals(d.components[c])){b=false;
break
}}}}return b
},transform:function(e,c){if(e&&c){for(var d=0,a=this.components.length;
d<a;
d++){var b=this.components[d];
b.transform(e,c)
}this.bounds=null
}return this
},intersects:function(d){var b=false;
for(var c=0,a=this.components.length;
c<a;
++c){b=d.intersects(this.components[c]);
if(b){break
}}return b
},getVertices:function(b){var c=[];
for(var d=0,a=this.components.length;
d<a;
++d){Array.prototype.push.apply(c,this.components[d].getVertices(b))
}return c
},CLASS_NAME:"OpenLayers.Geometry.Collection"});OpenLayers.Geometry.Point=OpenLayers.Class(OpenLayers.Geometry,{x:null,y:null,initialize:function(a,b){OpenLayers.Geometry.prototype.initialize.apply(this,arguments);
this.x=parseFloat(a);
this.y=parseFloat(b)
},clone:function(a){if(a==null){a=new OpenLayers.Geometry.Point(this.x,this.y)
}OpenLayers.Util.applyDefaults(a,this);
return a
},calculateBounds:function(){this.bounds=new OpenLayers.Bounds(this.x,this.y,this.x,this.y)
},distanceTo:function(f,j){var d=!(j&&j.edge===false);
var a=d&&j&&j.details;
var b,e,h,c,g,i;
if(f instanceof OpenLayers.Geometry.Point){e=this.x;
h=this.y;
c=f.x;
g=f.y;
b=Math.sqrt(Math.pow(e-c,2)+Math.pow(h-g,2));
i=!a?b:{x0:e,y0:h,x1:c,y1:g,distance:b}
}else{i=f.distanceTo(this,j);
if(a){i={x0:i.x1,y0:i.y1,x1:i.x0,y1:i.y0,distance:i.distance}
}}return i
},equals:function(a){var b=false;
if(a!=null){b=((this.x==a.x&&this.y==a.y)||(isNaN(this.x)&&isNaN(this.y)&&isNaN(a.x)&&isNaN(a.y)))
}return b
},toShortString:function(){return(this.x+", "+this.y)
},move:function(a,b){this.x=this.x+a;
this.y=this.y+b;
this.clearBounds()
},rotate:function(d,b){d*=Math.PI/180;
var a=this.distanceTo(b);
var c=d+Math.atan2(this.y-b.y,this.x-b.x);
this.x=b.x+(a*Math.cos(c));
this.y=b.y+(a*Math.sin(c));
this.clearBounds()
},getCentroid:function(){return new OpenLayers.Geometry.Point(this.x,this.y)
},resize:function(c,a,b){b=(b==undefined)?1:b;
this.x=a.x+(c*b*(this.x-a.x));
this.y=a.y+(c*(this.y-a.y));
this.clearBounds();
return this
},intersects:function(b){var a=false;
if(b.CLASS_NAME=="OpenLayers.Geometry.Point"){a=this.equals(b)
}else{a=b.intersects(this)
}return a
},transform:function(b,a){if((b&&a)){OpenLayers.Projection.transform(this,b,a);
this.bounds=null
}return this
},getVertices:function(a){return[this]
},CLASS_NAME:"OpenLayers.Geometry.Point"});OpenLayers.Geometry.MultiPoint=OpenLayers.Class(OpenLayers.Geometry.Collection,{componentTypes:["OpenLayers.Geometry.Point"],initialize:function(a){OpenLayers.Geometry.Collection.prototype.initialize.apply(this,arguments)
},addPoint:function(a,b){this.addComponent(a,b)
},removePoint:function(a){this.removeComponent(a)
},CLASS_NAME:"OpenLayers.Geometry.MultiPoint"});OpenLayers.Geometry.Curve=OpenLayers.Class(OpenLayers.Geometry.MultiPoint,{componentTypes:["OpenLayers.Geometry.Point"],initialize:function(a){OpenLayers.Geometry.MultiPoint.prototype.initialize.apply(this,arguments)
},getLength:function(){var c=0;
if(this.components&&(this.components.length>1)){for(var b=1,a=this.components.length;
b<a;
b++){c+=this.components[b-1].distanceTo(this.components[b])
}}return c
},getGeodesicLength:function(b){var e=this;
if(b){var c=new OpenLayers.Projection("EPSG:4326");
if(!c.equals(b)){e=this.clone().transform(b,c)
}}var f=0;
if(e.components&&(e.components.length>1)){var h,g;
for(var d=1,a=e.components.length;
d<a;
d++){h=e.components[d-1];
g=e.components[d];
f+=OpenLayers.Util.distVincenty({lon:h.x,lat:h.y},{lon:g.x,lat:g.y})
}}return f*1000
},CLASS_NAME:"OpenLayers.Geometry.Curve"});OpenLayers.Geometry.LineString=OpenLayers.Class(OpenLayers.Geometry.Curve,{initialize:function(a){OpenLayers.Geometry.Curve.prototype.initialize.apply(this,arguments)
},removeComponent:function(a){if(this.components&&(this.components.length>2)){OpenLayers.Geometry.Collection.prototype.removeComponent.apply(this,arguments)
}},intersects:function(m){var c=false;
var l=m.CLASS_NAME;
if(l=="OpenLayers.Geometry.LineString"||l=="OpenLayers.Geometry.LinearRing"||l=="OpenLayers.Geometry.Point"){var p=this.getSortedSegments();
var n;
if(l=="OpenLayers.Geometry.Point"){n=[{x1:m.x,y1:m.y,x2:m.x,y2:m.y}]
}else{n=m.getSortedSegments()
}var s,g,e,a,r,q,d,b;
outer:for(var h=0,k=p.length;
h<k;
++h){s=p[h];
g=s.x1;
e=s.x2;
a=s.y1;
r=s.y2;
inner:for(var f=0,o=n.length;
f<o;
++f){q=n[f];
if(q.x1>e){break
}if(q.x2<g){continue
}d=q.y1;
b=q.y2;
if(Math.min(d,b)>Math.max(a,r)){continue
}if(Math.max(d,b)<Math.min(a,r)){continue
}if(OpenLayers.Geometry.segmentsIntersect(s,q)){c=true;
break outer
}}}}else{c=m.intersects(this)
}return c
},getSortedSegments:function(){var a=this.components.length-1;
var b=new Array(a),e,d;
for(var c=0;
c<a;
++c){e=this.components[c];
d=this.components[c+1];
if(e.x<d.x){b[c]={x1:e.x,y1:e.y,x2:d.x,y2:d.y}
}else{b[c]={x1:d.x,y1:d.y,x2:e.x,y2:e.y}
}}function f(h,g){return h.x1-g.x1
}return b.sort(f)
},splitWithSegment:function(r,b){var c=!(b&&b.edge===false);
var o=b&&b.tolerance;
var a=[];
var t=this.getVertices();
var n=[];
var v=[];
var h=false;
var e,d,l;
var j,q,u;
var f={point:true,tolerance:o};
var g=null;
for(var m=0,k=t.length-2;
m<=k;
++m){e=t[m];
n.push(e.clone());
d=t[m+1];
u={x1:e.x,y1:e.y,x2:d.x,y2:d.y};
l=OpenLayers.Geometry.segmentsIntersect(r,u,f);
if(l instanceof OpenLayers.Geometry.Point){if((l.x===r.x1&&l.y===r.y1)||(l.x===r.x2&&l.y===r.y2)||l.equals(e)||l.equals(d)){q=true
}else{q=false
}if(q||c){if(!l.equals(v[v.length-1])){v.push(l.clone())
}if(m===0){if(l.equals(e)){continue
}}if(l.equals(d)){continue
}h=true;
if(!l.equals(e)){n.push(l)
}a.push(new OpenLayers.Geometry.LineString(n));
n=[l.clone()]
}}}if(h){n.push(d.clone());
a.push(new OpenLayers.Geometry.LineString(n))
}if(v.length>0){var p=r.x1<r.x2?1:-1;
var s=r.y1<r.y2?1:-1;
g={lines:a,points:v.sort(function(w,i){return(p*w.x-p*i.x)||(s*w.y-s*i.y)
})}
}return g
},split:function(x,b){var n=null;
var d=b&&b.mutual;
var l,e,m,c;
if(x instanceof OpenLayers.Geometry.LineString){var w=this.getVertices();
var g,f,v,h,a,p;
var s=[];
m=[];
for(var t=0,o=w.length-2;
t<=o;
++t){g=w[t];
f=w[t+1];
v={x1:g.x,y1:g.y,x2:f.x,y2:f.y};
c=c||[x];
if(d){s.push(g.clone())
}for(var r=0;
r<c.length;
++r){h=c[r].splitWithSegment(v,b);
if(h){a=h.lines;
if(a.length>0){a.unshift(r,1);
Array.prototype.splice.apply(c,a);
r+=a.length-2
}if(d){for(var q=0,u=h.points.length;
q<u;
++q){p=h.points[q];
if(!p.equals(g)){s.push(p);
m.push(new OpenLayers.Geometry.LineString(s));
if(p.equals(f)){s=[]
}else{s=[p.clone()]
}}}}}}}if(d&&m.length>0&&s.length>0){s.push(f.clone());
m.push(new OpenLayers.Geometry.LineString(s))
}}else{n=x.splitWith(this,b)
}if(c&&c.length>1){e=true
}else{c=[]
}if(m&&m.length>1){l=true
}else{m=[]
}if(e||l){if(d){n=[m,c]
}else{n=c
}}return n
},splitWith:function(b,a){return b.split(this,a)
},getVertices:function(a){var b;
if(a===true){b=[this.components[0],this.components[this.components.length-1]]
}else{if(a===false){b=this.components.slice(1,this.components.length-1)
}else{b=this.components.slice()
}}return b
},distanceTo:function(h,g){var k=!(g&&g.edge===false);
var B=k&&g&&g.details;
var q,e={};
var t=Number.POSITIVE_INFINITY;
if(h instanceof OpenLayers.Geometry.Point){var r=this.getSortedSegments();
var p=h.x;
var o=h.y;
var z;
for(var v=0,w=r.length;
v<w;
++v){z=r[v];
q=OpenLayers.Geometry.distanceToSegment(h,z);
if(q.distance<t){t=q.distance;
e=q;
if(t===0){break
}}else{if(z.x2>p&&((o>z.y1&&o<z.y2)||(o<z.y1&&o>z.y2))){break
}}}if(B){e={distance:e.distance,x0:e.x,y0:e.y,x1:p,y1:o}
}else{e=e.distance
}}else{if(h instanceof OpenLayers.Geometry.LineString){var d=this.getSortedSegments();
var c=h.getSortedSegments();
var b,a,n,A,f;
var m=c.length;
var l={point:true};
outer:for(var v=0,w=d.length;
v<w;
++v){b=d[v];
A=b.x1;
f=b.y1;
for(var u=0;
u<m;
++u){a=c[u];
n=OpenLayers.Geometry.segmentsIntersect(b,a,l);
if(n){t=0;
e={distance:0,x0:n.x,y0:n.y,x1:n.x,y1:n.y};
break outer
}else{q=OpenLayers.Geometry.distanceToSegment({x:A,y:f},a);
if(q.distance<t){t=q.distance;
e={distance:t,x0:A,y0:f,x1:q.x,y1:q.y}
}}}}if(!B){e=e.distance
}if(t!==0){if(b){q=h.distanceTo(new OpenLayers.Geometry.Point(b.x2,b.y2),g);
var s=B?q.distance:q;
if(s<t){if(B){e={distance:t,x0:q.x1,y0:q.y1,x1:q.x0,y1:q.y0}
}else{e=s
}}}}}else{e=h.distanceTo(this,g);
if(B){e={distance:e.distance,x0:e.x1,y0:e.y1,x1:e.x0,y1:e.y0}
}}}return e
},CLASS_NAME:"OpenLayers.Geometry.LineString"});OpenLayers.Geometry.LinearRing=OpenLayers.Class(OpenLayers.Geometry.LineString,{componentTypes:["OpenLayers.Geometry.Point"],initialize:function(a){OpenLayers.Geometry.LineString.prototype.initialize.apply(this,arguments)
},addComponent:function(a,b){var c=false;
var d=this.components.pop();
if(b!=null||!a.equals(d)){c=OpenLayers.Geometry.Collection.prototype.addComponent.apply(this,arguments)
}var e=this.components[0];
OpenLayers.Geometry.Collection.prototype.addComponent.apply(this,[e]);
return c
},removeComponent:function(a){if(this.components.length>4){this.components.pop();
OpenLayers.Geometry.Collection.prototype.removeComponent.apply(this,arguments);
var b=this.components[0];
OpenLayers.Geometry.Collection.prototype.addComponent.apply(this,[b])
}},move:function(b,d){for(var c=0,a=this.components.length;
c<a-1;
c++){this.components[c].move(b,d)
}},rotate:function(d,b){for(var c=0,a=this.components.length;
c<a-1;
++c){this.components[c].rotate(d,b)
}},resize:function(e,b,d){for(var c=0,a=this.components.length;
c<a-1;
++c){this.components[c].resize(e,b,d)
}return this
},transform:function(e,c){if(e&&c){for(var d=0,a=this.components.length;
d<a-1;
d++){var b=this.components[d];
b.transform(e,c)
}this.bounds=null
}return this
},getCentroid:function(){if(this.components&&(this.components.length>2)){var h=0;
var g=0;
for(var e=0;
e<this.components.length-1;
e++){var d=this.components[e];
var k=this.components[e+1];
h+=(d.x+k.x)*(d.x*k.y-k.x*d.y);
g+=(d.y+k.y)*(d.x*k.y-k.x*d.y)
}var f=-1*this.getArea();
var a=h/(6*f);
var j=g/(6*f);
return new OpenLayers.Geometry.Point(a,j)
}else{return null
}},getArea:function(){var g=0;
if(this.components&&(this.components.length>2)){var f=0;
for(var e=0,d=this.components.length;
e<d-1;
e++){var a=this.components[e];
var h=this.components[e+1];
f+=(a.x+h.x)*(h.y-a.y)
}g=-f/2
}return g
},getGeodesicArea:function(b){var d=this;
if(b){var c=new OpenLayers.Projection("EPSG:4326");
if(!c.equals(b)){d=this.clone().transform(b,c)
}}var f=0;
var a=d.components&&d.components.length;
if(a>2){var h,g;
for(var e=0;
e<a-1;
e++){h=d.components[e];
g=d.components[e+1];
f+=OpenLayers.Util.rad(g.x-h.x)*(2+Math.sin(OpenLayers.Util.rad(h.y))+Math.sin(OpenLayers.Util.rad(g.y)))
}f=f*6378137*6378137/2
}return f
},containsPoint:function(m){var s=OpenLayers.Number.limitSigDigs;
var l=14;
var k=s(m.x,l);
var j=s(m.y,l);
function r(w,t,v,i,u){return(((t-i)*w)+((i*v)-(t*u)))/(v-u)
}var a=this.components.length-1;
var g,f,q,d,o,b,e,c;
var h=0;
for(var n=0;
n<a;
++n){g=this.components[n];
q=s(g.x,l);
d=s(g.y,l);
f=this.components[n+1];
o=s(f.x,l);
b=s(f.y,l);
if(d==b){if(j==d){if(q<=o&&(k>=q&&k<=o)||q>=o&&(k<=q&&k>=o)){h=-1;
break
}}continue
}e=s(r(j,q,d,o,b),l);
if(e==k){if(d<b&&(j>=d&&j<=b)||d>b&&(j<=d&&j>=b)){h=-1;
break
}}if(e<=k){continue
}if(q!=o&&(e<Math.min(q,o)||e>Math.max(q,o))){continue
}if(d<b&&(j>=d&&j<b)||d>b&&(j<d&&j>=b)){++h
}}var p=(h==-1)?1:!!(h&1);
return p
},intersects:function(d){var b=false;
if(d.CLASS_NAME=="OpenLayers.Geometry.Point"){b=this.containsPoint(d)
}else{if(d.CLASS_NAME=="OpenLayers.Geometry.LineString"){b=d.intersects(this)
}else{if(d.CLASS_NAME=="OpenLayers.Geometry.LinearRing"){b=OpenLayers.Geometry.LineString.prototype.intersects.apply(this,[d])
}else{for(var c=0,a=d.components.length;
c<a;
++c){b=d.components[c].intersects(this);
if(b){break
}}}}}return b
},getVertices:function(a){return(a===true)?[]:this.components.slice(0,this.components.length-1)
},CLASS_NAME:"OpenLayers.Geometry.LinearRing"});OpenLayers.Handler=OpenLayers.Class({id:null,control:null,map:null,keyMask:null,active:false,evt:null,initialize:function(d,b,a){OpenLayers.Util.extend(this,a);
this.control=d;
this.callbacks=b;
var c=this.map||d.map;
if(c){this.setMap(c)
}this.id=OpenLayers.Util.createUniqueID(this.CLASS_NAME+"_")
},setMap:function(a){this.map=a
},checkModifiers:function(a){if(this.keyMask==null){return true
}var b=(a.shiftKey?OpenLayers.Handler.MOD_SHIFT:0)|(a.ctrlKey?OpenLayers.Handler.MOD_CTRL:0)|(a.altKey?OpenLayers.Handler.MOD_ALT:0);
return(b==this.keyMask)
},activate:function(){if(this.active){return false
}var c=OpenLayers.Events.prototype.BROWSER_EVENTS;
for(var b=0,a=c.length;
b<a;
b++){if(this[c[b]]){this.register(c[b],this[c[b]])
}}this.active=true;
return true
},deactivate:function(){if(!this.active){return false
}var c=OpenLayers.Events.prototype.BROWSER_EVENTS;
for(var b=0,a=c.length;
b<a;
b++){if(this[c[b]]){this.unregister(c[b],this[c[b]])
}}this.active=false;
return true
},callback:function(b,a){if(b&&this.callbacks[b]){this.callbacks[b].apply(this.control,a)
}},register:function(a,b){this.map.events.registerPriority(a,this,b);
this.map.events.registerPriority(a,this,this.setEvent)
},unregister:function(a,b){this.map.events.unregister(a,this,b);
this.map.events.unregister(a,this,this.setEvent)
},setEvent:function(a){this.evt=a;
return true
},destroy:function(){this.deactivate();
this.control=this.map=null
},CLASS_NAME:"OpenLayers.Handler"});
OpenLayers.Handler.MOD_NONE=0;
OpenLayers.Handler.MOD_SHIFT=1;
OpenLayers.Handler.MOD_CTRL=2;
OpenLayers.Handler.MOD_ALT=4;OpenLayers.Handler.Point=OpenLayers.Class(OpenLayers.Handler,{point:null,layer:null,multi:false,drawing:false,mouseDown:false,lastDown:null,lastUp:null,persist:false,layerOptions:null,initialize:function(c,b,a){if(!(a&&a.layerOptions&&a.layerOptions.styleMap)){this.style=OpenLayers.Util.extend(OpenLayers.Feature.Vector.style["default"],{})
}OpenLayers.Handler.prototype.initialize.apply(this,arguments)
},activate:function(){if(!OpenLayers.Handler.prototype.activate.apply(this,arguments)){return false
}var a=OpenLayers.Util.extend({displayInLayerSwitcher:false,calculateInRange:OpenLayers.Function.True},this.layerOptions);
this.layer=new OpenLayers.Layer.Vector(this.CLASS_NAME,a);
this.map.addLayer(this.layer);
return true
},createFeature:function(a){var b=this.map.getLonLatFromPixel(a);
this.point=new OpenLayers.Feature.Vector(new OpenLayers.Geometry.Point(b.lon,b.lat));
this.callback("create",[this.point.geometry,this.point]);
this.point.geometry.clearBounds();
this.layer.addFeatures([this.point],{silent:true})
},deactivate:function(){if(!OpenLayers.Handler.prototype.deactivate.apply(this,arguments)){return false
}if(this.drawing){this.cancel()
}this.destroyFeature();
if(this.layer.map!=null){this.layer.destroy(false)
}this.layer=null;
return true
},destroyFeature:function(){if(this.layer){this.layer.destroyFeatures()
}this.point=null
},finalize:function(b){var a=b?"cancel":"done";
this.drawing=false;
this.mouseDown=false;
this.lastDown=null;
this.lastUp=null;
this.callback(a,[this.geometryClone()]);
if(b||!this.persist){this.destroyFeature()
}},cancel:function(){this.finalize(true)
},click:function(a){OpenLayers.Event.stop(a);
return false
},dblclick:function(a){OpenLayers.Event.stop(a);
return false
},modifyFeature:function(a){var b=this.map.getLonLatFromPixel(a);
this.point.geometry.x=b.lon;
this.point.geometry.y=b.lat;
this.callback("modify",[this.point.geometry,this.point]);
this.point.geometry.clearBounds();
this.drawFeature()
},drawFeature:function(){this.layer.drawFeature(this.point,this.style)
},getGeometry:function(){var a=this.point&&this.point.geometry;
if(a&&this.multi){a=new OpenLayers.Geometry.MultiPoint([a])
}return a
},geometryClone:function(){var a=this.getGeometry();
return a&&a.clone()
},mousedown:function(a){if(!this.checkModifiers(a)){return true
}if(this.lastDown&&this.lastDown.equals(a.xy)){return true
}this.drawing=true;
if(this.lastDown==null){if(this.persist){this.destroyFeature()
}this.createFeature(a.xy)
}else{this.modifyFeature(a.xy)
}this.lastDown=a.xy;
return false
},mousemove:function(a){if(this.drawing){this.modifyFeature(a.xy)
}return true
},mouseup:function(a){if(this.drawing){this.finalize();
return false
}else{return true
}},CLASS_NAME:"OpenLayers.Handler.Point"});OpenLayers.Handler.Path=OpenLayers.Class(OpenLayers.Handler.Point,{line:null,freehand:false,freehandToggle:"shiftKey",initialize:function(c,b,a){OpenLayers.Handler.Point.prototype.initialize.apply(this,arguments)
},createFeature:function(a){var b=this.control.map.getLonLatFromPixel(a);
this.point=new OpenLayers.Feature.Vector(new OpenLayers.Geometry.Point(b.lon,b.lat));
this.line=new OpenLayers.Feature.Vector(new OpenLayers.Geometry.LineString([this.point.geometry]));
this.callback("create",[this.point.geometry,this.getSketch()]);
this.point.geometry.clearBounds();
this.layer.addFeatures([this.line,this.point],{silent:true})
},destroyFeature:function(){OpenLayers.Handler.Point.prototype.destroyFeature.apply(this);
this.line=null
},removePoint:function(){if(this.point){this.layer.removeFeatures([this.point])
}},addPoint:function(a){this.layer.removeFeatures([this.point]);
var b=this.control.map.getLonLatFromPixel(a);
this.point=new OpenLayers.Feature.Vector(new OpenLayers.Geometry.Point(b.lon,b.lat));
this.line.geometry.addComponent(this.point.geometry,this.line.geometry.components.length);
this.callback("point",[this.point.geometry,this.getGeometry()]);
this.callback("modify",[this.point.geometry,this.getSketch()]);
this.drawFeature()
},freehandMode:function(a){return(this.freehandToggle&&a[this.freehandToggle])?!this.freehand:this.freehand
},modifyFeature:function(a){var b=this.control.map.getLonLatFromPixel(a);
this.point.geometry.x=b.lon;
this.point.geometry.y=b.lat;
this.callback("modify",[this.point.geometry,this.getSketch()]);
this.point.geometry.clearBounds();
this.drawFeature()
},drawFeature:function(){this.layer.drawFeature(this.line,this.style);
this.layer.drawFeature(this.point,this.style)
},getSketch:function(){return this.line
},getGeometry:function(){var a=this.line&&this.line.geometry;
if(a&&this.multi){a=new OpenLayers.Geometry.MultiLineString([a])
}return a
},mousedown:function(a){if(this.lastDown&&this.lastDown.equals(a.xy)){return false
}if(this.lastDown==null){if(this.persist){this.destroyFeature()
}this.createFeature(a.xy)
}else{if((this.lastUp==null)||!this.lastUp.equals(a.xy)){this.addPoint(a.xy)
}}this.mouseDown=true;
this.lastDown=a.xy;
this.drawing=true;
return false
},mousemove:function(a){if(this.drawing){if(this.mouseDown&&this.freehandMode(a)){this.addPoint(a.xy)
}else{this.modifyFeature(a.xy)
}}return true
},mouseup:function(a){this.mouseDown=false;
if(this.drawing){if(this.freehandMode(a)){this.removePoint();
this.finalize()
}else{if(this.lastUp==null){this.addPoint(a.xy)
}this.lastUp=a.xy
}return false
}return true
},dblclick:function(a){if(!this.freehandMode(a)){var b=this.line.geometry.components.length-1;
this.line.geometry.removeComponent(this.line.geometry.components[b]);
this.removePoint();
this.finalize()
}return false
},CLASS_NAME:"OpenLayers.Handler.Path"});OpenLayers.Geometry.Polygon=OpenLayers.Class(OpenLayers.Geometry.Collection,{componentTypes:["OpenLayers.Geometry.LinearRing"],initialize:function(a){OpenLayers.Geometry.Collection.prototype.initialize.apply(this,arguments)
},getArea:function(){var c=0;
if(this.components&&(this.components.length>0)){c+=Math.abs(this.components[0].getArea());
for(var b=1,a=this.components.length;
b<a;
b++){c-=Math.abs(this.components[b].getArea())
}}return c
},getGeodesicArea:function(b){var d=0;
if(this.components&&(this.components.length>0)){d+=Math.abs(this.components[0].getGeodesicArea(b));
for(var c=1,a=this.components.length;
c<a;
c++){d-=Math.abs(this.components[c].getGeodesicArea(b))
}}return d
},containsPoint:function(a){var e=this.components.length;
var c=false;
if(e>0){c=this.components[0].containsPoint(a);
if(c!==1){if(c&&e>1){var d;
for(var b=1;
b<e;
++b){d=this.components[b].containsPoint(a);
if(d){if(d===1){c=1
}else{c=false
}break
}}}}}return c
},intersects:function(e){var b=false;
var d,a;
if(e.CLASS_NAME=="OpenLayers.Geometry.Point"){b=this.containsPoint(e)
}else{if(e.CLASS_NAME=="OpenLayers.Geometry.LineString"||e.CLASS_NAME=="OpenLayers.Geometry.LinearRing"){for(d=0,a=this.components.length;
d<a;
++d){b=e.intersects(this.components[d]);
if(b){break
}}if(!b){for(d=0,a=e.components.length;
d<a;
++d){b=this.containsPoint(e.components[d]);
if(b){break
}}}}else{for(d=0,a=e.components.length;
d<a;
++d){b=this.intersects(e.components[d]);
if(b){break
}}}}if(!b&&e.CLASS_NAME=="OpenLayers.Geometry.Polygon"){var c=this.components[0];
for(d=0,a=c.components.length;
d<a;
++d){b=e.containsPoint(c.components[d]);
if(b){break
}}}return b
},distanceTo:function(d,b){var c=!(b&&b.edge===false);
var a;
if(!c&&this.intersects(d)){a=0
}else{a=OpenLayers.Geometry.Collection.prototype.distanceTo.apply(this,[d,b])
}return a
},CLASS_NAME:"OpenLayers.Geometry.Polygon"});
OpenLayers.Geometry.Polygon.createRegularPolygon=function(j,f,b,l){var c=Math.PI*((1/b)-(1/2));
if(l){c+=(l/180)*Math.PI
}var a,h,g;
var k=[];
for(var e=0;
e<b;
++e){a=c+(e*2*Math.PI/b);
h=j.x+(f*Math.cos(a));
g=j.y+(f*Math.sin(a));
k.push(new OpenLayers.Geometry.Point(h,g))
}var d=new OpenLayers.Geometry.LinearRing(k);
return new OpenLayers.Geometry.Polygon([d])
};OpenLayers.Handler.Polygon=OpenLayers.Class(OpenLayers.Handler.Path,{polygon:null,initialize:function(c,b,a){OpenLayers.Handler.Path.prototype.initialize.apply(this,arguments)
},createFeature:function(a){var b=this.control.map.getLonLatFromPixel(a);
this.point=new OpenLayers.Feature.Vector(new OpenLayers.Geometry.Point(b.lon,b.lat));
this.line=new OpenLayers.Feature.Vector(new OpenLayers.Geometry.LinearRing([this.point.geometry]));
this.polygon=new OpenLayers.Feature.Vector(new OpenLayers.Geometry.Polygon([this.line.geometry]));
this.callback("create",[this.point.geometry,this.getSketch()]);
this.point.geometry.clearBounds();
this.layer.addFeatures([this.polygon,this.point],{silent:true})
},destroyFeature:function(){OpenLayers.Handler.Path.prototype.destroyFeature.apply(this);
this.polygon=null
},drawFeature:function(){this.layer.drawFeature(this.polygon,this.style);
this.layer.drawFeature(this.point,this.style)
},getSketch:function(){return this.polygon
},getGeometry:function(){var a=this.polygon&&this.polygon.geometry;
if(a&&this.multi){a=new OpenLayers.Geometry.MultiPolygon([a])
}return a
},dblclick:function(a){if(!this.freehandMode(a)){var b=this.line.geometry.components.length-2;
this.line.geometry.removeComponent(this.line.geometry.components[b]);
this.removePoint();
this.finalize()
}return false
},CLASS_NAME:"OpenLayers.Handler.Polygon"});OpenLayers.Geometry.MultiLineString=OpenLayers.Class(OpenLayers.Geometry.Collection,{componentTypes:["OpenLayers.Geometry.LineString"],initialize:function(a){OpenLayers.Geometry.Collection.prototype.initialize.apply(this,arguments)
},split:function(n,s){var g=null;
var r=s&&s.mutual;
var o,a,q,m,b;
var e=[];
var p=[n];
for(var f=0,h=this.components.length;
f<h;
++f){a=this.components[f];
m=false;
for(var d=0;
d<p.length;
++d){o=a.split(p[d],s);
if(o){if(r){q=o[0];
for(var c=0,l=q.length;
c<l;
++c){if(c===0&&e.length){e[e.length-1].addComponent(q[c])
}else{e.push(new OpenLayers.Geometry.MultiLineString([q[c]]))
}}m=true;
o=o[1]
}if(o.length){o.unshift(d,1);
Array.prototype.splice.apply(p,o);
break
}}}if(!m){if(e.length){e[e.length-1].addComponent(a.clone())
}else{e=[new OpenLayers.Geometry.MultiLineString(a.clone())]
}}}if(e&&e.length>1){m=true
}else{e=[]
}if(p&&p.length>1){b=true
}else{p=[]
}if(m||b){if(r){g=[e,p]
}else{g=p
}}return g
},splitWith:function(n,s){var g=null;
var r=s&&s.mutual;
var o,c,q,m,a,e,p;
if(n instanceof OpenLayers.Geometry.LineString){p=[];
e=[n];
for(var f=0,h=this.components.length;
f<h;
++f){a=false;
c=this.components[f];
for(var d=0;
d<e.length;
++d){o=e[d].split(c,s);
if(o){if(r){q=o[0];
if(q.length){q.unshift(d,1);
Array.prototype.splice.apply(e,q);
d+=q.length-2
}o=o[1];
if(o.length===0){o=[c.clone()]
}}for(var b=0,l=o.length;
b<l;
++b){if(b===0&&p.length){p[p.length-1].addComponent(o[b])
}else{p.push(new OpenLayers.Geometry.MultiLineString([o[b]]))
}}a=true
}}if(!a){if(p.length){p[p.length-1].addComponent(c.clone())
}else{p=[new OpenLayers.Geometry.MultiLineString([c.clone()])]
}}}}else{g=n.split(this)
}if(e&&e.length>1){m=true
}else{e=[]
}if(p&&p.length>1){a=true
}else{p=[]
}if(m||a){if(r){g=[e,p]
}else{g=p
}}return g
},CLASS_NAME:"OpenLayers.Geometry.MultiLineString"});OpenLayers.Geometry.MultiPolygon=OpenLayers.Class(OpenLayers.Geometry.Collection,{componentTypes:["OpenLayers.Geometry.Polygon"],initialize:function(a){OpenLayers.Geometry.Collection.prototype.initialize.apply(this,arguments)
},CLASS_NAME:"OpenLayers.Geometry.MultiPolygon"});OpenLayers.Format.GML=OpenLayers.Class(OpenLayers.Format.XML,{featureNS:"http://mapserver.gis.umn.edu/mapserver",featurePrefix:"feature",featureName:"featureMember",layerName:"features",geometryName:"geometry",collectionName:"FeatureCollection",gmlns:"http://www.opengis.net/gml",extractAttributes:true,xy:true,initialize:function(a){this.regExes={trimSpace:(/^\s*|\s*$/g),removeSpace:(/\s*/g),splitSpace:(/\s+/),trimComma:(/\s*,\s*/g)};
OpenLayers.Format.XML.prototype.initialize.apply(this,[a])
},read:function(d){if(typeof d=="string"){d=OpenLayers.Format.XML.prototype.read.apply(this,[d])
}var e=this.getElementsByTagNameNS(d.documentElement,this.gmlns,this.featureName);
var c=[];
for(var b=0;
b<e.length;
b++){var a=this.parseFeature(e[b]);
if(a){c.push(a)
}}return c
},parseFeature:function(d){var e=["MultiPolygon","Polygon","MultiLineString","LineString","MultiPoint","Point","Envelope"];
var p,h,q,c;
for(var l=0;
l<e.length;
++l){p=e[l];
h=this.getElementsByTagNameNS(d,this.gmlns,p);
if(h.length>0){c=this.parseGeometry[p.toLowerCase()];
if(c){q=c.apply(this,[h[0]]);
if(this.internalProjection&&this.externalProjection){q.transform(this.externalProjection,this.internalProjection)
}}else{OpenLayers.Console.error(OpenLayers.i18n("unsupportedGeometryType",{geomType:p}))
}break
}}var b;
var k=this.getElementsByTagNameNS(d,this.gmlns,"Box");
for(l=0;
l<k.length;
++l){var o=k[l];
var n=this.parseGeometry.box.apply(this,[o]);
var m=o.parentNode;
var g=m.localName||m.nodeName.split(":").pop();
if(g==="boundedBy"){b=n
}else{q=n.toGeometry()
}}var j;
if(this.extractAttributes){j=this.parseAttributes(d)
}var r=new OpenLayers.Feature.Vector(q,j);
r.bounds=b;
r.gml={featureType:d.firstChild.nodeName.split(":")[1],featureNS:d.firstChild.namespaceURI,featureNSPrefix:d.firstChild.prefix};
var a=d.firstChild;
var f;
while(a){if(a.nodeType==1){f=a.getAttribute("fid")||a.getAttribute("id");
if(f){break
}}a=a.nextSibling
}r.fid=f;
return r
},parseGeometry:{point:function(d){var b,a;
var e=[];
var b=this.getElementsByTagNameNS(d,this.gmlns,"pos");
if(b.length>0){a=b[0].firstChild.nodeValue;
a=a.replace(this.regExes.trimSpace,"");
e=a.split(this.regExes.splitSpace)
}if(e.length==0){b=this.getElementsByTagNameNS(d,this.gmlns,"coordinates");
if(b.length>0){a=b[0].firstChild.nodeValue;
a=a.replace(this.regExes.removeSpace,"");
e=a.split(",")
}}if(e.length==0){b=this.getElementsByTagNameNS(d,this.gmlns,"coord");
if(b.length>0){var f=this.getElementsByTagNameNS(b[0],this.gmlns,"X");
var c=this.getElementsByTagNameNS(b[0],this.gmlns,"Y");
if(f.length>0&&c.length>0){e=[f[0].firstChild.nodeValue,c[0].firstChild.nodeValue]
}}}if(e.length==2){e[2]=null
}if(this.xy){return new OpenLayers.Geometry.Point(e[0],e[1],e[2])
}else{return new OpenLayers.Geometry.Point(e[1],e[0],e[2])
}},multipoint:function(e){var b=this.getElementsByTagNameNS(e,this.gmlns,"Point");
var d=[];
if(b.length>0){var a;
for(var c=0;
c<b.length;
++c){a=this.parseGeometry.point.apply(this,[b[c]]);
if(a){d.push(a)
}}}return new OpenLayers.Geometry.MultiPoint(d)
},linestring:function(c,e){var d,b;
var n=[];
var o=[];
d=this.getElementsByTagNameNS(c,this.gmlns,"posList");
if(d.length>0){b=this.getChildValue(d[0]);
b=b.replace(this.regExes.trimSpace,"");
n=b.split(this.regExes.splitSpace);
var h=parseInt(d[0].getAttribute("dimension"));
var f,m,l,k;
for(var g=0;
g<n.length/h;
++g){f=g*h;
m=n[f];
l=n[f+1];
k=(h==2)?null:n[f+2];
if(this.xy){o.push(new OpenLayers.Geometry.Point(m,l,k))
}else{o.push(new OpenLayers.Geometry.Point(l,m,k))
}}}if(n.length==0){d=this.getElementsByTagNameNS(c,this.gmlns,"coordinates");
if(d.length>0){b=this.getChildValue(d[0]);
b=b.replace(this.regExes.trimSpace,"");
b=b.replace(this.regExes.trimComma,",");
var a=b.split(this.regExes.splitSpace);
for(var g=0;
g<a.length;
++g){n=a[g].split(",");
if(n.length==2){n[2]=null
}if(this.xy){o.push(new OpenLayers.Geometry.Point(n[0],n[1],n[2]))
}else{o.push(new OpenLayers.Geometry.Point(n[1],n[0],n[2]))
}}}}var p=null;
if(o.length!=0){if(e){p=new OpenLayers.Geometry.LinearRing(o)
}else{p=new OpenLayers.Geometry.LineString(o)
}}return p
},multilinestring:function(e){var b=this.getElementsByTagNameNS(e,this.gmlns,"LineString");
var d=[];
if(b.length>0){var a;
for(var c=0;
c<b.length;
++c){a=this.parseGeometry.linestring.apply(this,[b[c]]);
if(a){d.push(a)
}}}return new OpenLayers.Geometry.MultiLineString(d)
},polygon:function(e){var b=this.getElementsByTagNameNS(e,this.gmlns,"LinearRing");
var d=[];
if(b.length>0){var a;
for(var c=0;
c<b.length;
++c){a=this.parseGeometry.linestring.apply(this,[b[c],true]);
if(a){d.push(a)
}}}return new OpenLayers.Geometry.Polygon(d)
},multipolygon:function(e){var a=this.getElementsByTagNameNS(e,this.gmlns,"Polygon");
var d=[];
if(a.length>0){var c;
for(var b=0;
b<a.length;
++b){c=this.parseGeometry.polygon.apply(this,[a[b]]);
if(c){d.push(c)
}}}return new OpenLayers.Geometry.MultiPolygon(d)
},envelope:function(b){var e=[];
var a;
var f;
var j=this.getElementsByTagNameNS(b,this.gmlns,"lowerCorner");
if(j.length>0){var h=[];
if(j.length>0){a=j[0].firstChild.nodeValue;
a=a.replace(this.regExes.trimSpace,"");
h=a.split(this.regExes.splitSpace)
}if(h.length==2){h[2]=null
}if(this.xy){var d=new OpenLayers.Geometry.Point(h[0],h[1],h[2])
}else{var d=new OpenLayers.Geometry.Point(h[1],h[0],h[2])
}}var g=this.getElementsByTagNameNS(b,this.gmlns,"upperCorner");
if(g.length>0){var h=[];
if(g.length>0){a=g[0].firstChild.nodeValue;
a=a.replace(this.regExes.trimSpace,"");
h=a.split(this.regExes.splitSpace)
}if(h.length==2){h[2]=null
}if(this.xy){var i=new OpenLayers.Geometry.Point(h[0],h[1],h[2])
}else{var i=new OpenLayers.Geometry.Point(h[1],h[0],h[2])
}}if(d&&i){e.push(new OpenLayers.Geometry.Point(d.x,d.y));
e.push(new OpenLayers.Geometry.Point(i.x,d.y));
e.push(new OpenLayers.Geometry.Point(i.x,i.y));
e.push(new OpenLayers.Geometry.Point(d.x,i.y));
e.push(new OpenLayers.Geometry.Point(d.x,d.y));
var c=new OpenLayers.Geometry.LinearRing(e);
f=new OpenLayers.Geometry.Polygon([c])
}return f
},box:function(e){var c=this.getElementsByTagNameNS(e,this.gmlns,"coordinates");
var b;
var f,a=null,d=null;
if(c.length>0){b=c[0].firstChild.nodeValue;
f=b.split(" ");
if(f.length==2){a=f[0].split(",");
d=f[1].split(",")
}}if(a!==null&&d!==null){return new OpenLayers.Bounds(parseFloat(a[0]),parseFloat(a[1]),parseFloat(d[0]),parseFloat(d[1]))
}}},parseAttributes:function(e){var f={};
var a=e.firstChild;
var d,g,c,k,j,b,h;
while(a){if(a.nodeType==1){d=a.childNodes;
for(g=0;
g<d.length;
++g){c=d[g];
if(c.nodeType==1){k=c.childNodes;
if(k.length==1){j=k[0];
if(j.nodeType==3||j.nodeType==4){b=(c.prefix)?c.nodeName.split(":")[1]:c.nodeName;
h=j.nodeValue.replace(this.regExes.trimSpace,"");
f[b]=h
}}else{f[c.nodeName.split(":").pop()]=null
}}}break
}a=a.nextSibling
}return f
},write:function(c){if(!(c instanceof Array)){c=[c]
}var b=this.createElementNS("http://www.opengis.net/wfs","wfs:"+this.collectionName);
for(var a=0;
a<c.length;
a++){b.appendChild(this.createFeatureXML(c[a]))
}return OpenLayers.Format.XML.prototype.write.apply(this,[b])
},createFeatureXML:function(j){var h=j.geometry;
var e=this.buildGeometryNode(h);
var i=this.createElementNS(this.featureNS,this.featurePrefix+":"+this.geometryName);
i.appendChild(e);
var a=this.createElementNS(this.gmlns,"gml:"+this.featureName);
var k=this.createElementNS(this.featureNS,this.featurePrefix+":"+this.layerName);
var c=j.fid||j.id;
k.setAttribute("fid",c);
k.appendChild(i);
for(var g in j.attributes){var f=this.createTextNode(j.attributes[g]);
var d=g.substring(g.lastIndexOf(":")+1);
var b=this.createElementNS(this.featureNS,this.featurePrefix+":"+d);
b.appendChild(f);
k.appendChild(b)
}a.appendChild(k);
return a
},buildGeometryNode:function(d){if(this.externalProjection&&this.internalProjection){d=d.clone();
d.transform(this.internalProjection,this.externalProjection)
}var c=d.CLASS_NAME;
var b=c.substring(c.lastIndexOf(".")+1);
var a=this.buildGeometry[b.toLowerCase()];
return a.apply(this,[d])
},buildGeometry:{point:function(b){var a=this.createElementNS(this.gmlns,"gml:Point");
a.appendChild(this.buildCoordinatesNode(b));
return a
},multipoint:function(f){var d=this.createElementNS(this.gmlns,"gml:MultiPoint");
var c=f.components;
var b,e;
for(var a=0;
a<c.length;
a++){b=this.createElementNS(this.gmlns,"gml:pointMember");
e=this.buildGeometry.point.apply(this,[c[a]]);
b.appendChild(e);
d.appendChild(b)
}return d
},linestring:function(b){var a=this.createElementNS(this.gmlns,"gml:LineString");
a.appendChild(this.buildCoordinatesNode(b));
return a
},multilinestring:function(f){var d=this.createElementNS(this.gmlns,"gml:MultiLineString");
var a=f.components;
var c,e;
for(var b=0;
b<a.length;
++b){c=this.createElementNS(this.gmlns,"gml:lineStringMember");
e=this.buildGeometry.linestring.apply(this,[a[b]]);
c.appendChild(e);
d.appendChild(c)
}return d
},linearring:function(b){var a=this.createElementNS(this.gmlns,"gml:LinearRing");
a.appendChild(this.buildCoordinatesNode(b));
return a
},polygon:function(g){var d=this.createElementNS(this.gmlns,"gml:Polygon");
var f=g.components;
var c,e,b;
for(var a=0;
a<f.length;
++a){b=(a==0)?"outerBoundaryIs":"innerBoundaryIs";
c=this.createElementNS(this.gmlns,"gml:"+b);
e=this.buildGeometry.linearring.apply(this,[f[a]]);
c.appendChild(e);
d.appendChild(c)
}return d
},multipolygon:function(f){var d=this.createElementNS(this.gmlns,"gml:MultiPolygon");
var a=f.components;
var e,b;
for(var c=0;
c<a.length;
++c){e=this.createElementNS(this.gmlns,"gml:polygonMember");
b=this.buildGeometry.polygon.apply(this,[a[c]]);
e.appendChild(b);
d.appendChild(e)
}return d
},bounds:function(b){var a=this.createElementNS(this.gmlns,"gml:Box");
a.appendChild(this.buildCoordinatesNode(b));
return a
}},buildCoordinatesNode:function(f){var a=this.createElementNS(this.gmlns,"gml:coordinates");
a.setAttribute("decimal",".");
a.setAttribute("cs",",");
a.setAttribute("ts"," ");
var e=[];
if(f instanceof OpenLayers.Bounds){e.push(f.left+","+f.bottom);
e.push(f.right+","+f.top)
}else{var c=(f.components)?f.components:[f];
for(var b=0;
b<c.length;
b++){e.push(c[b].x+","+c[b].y)
}}var d=this.createTextNode(e.join(" "));
a.appendChild(d);
return a
},CLASS_NAME:"OpenLayers.Format.GML"});if(!OpenLayers.Format.GML){OpenLayers.Format.GML={}
}OpenLayers.Format.GML.Base=OpenLayers.Class(OpenLayers.Format.XML,{namespaces:{gml:"http://www.opengis.net/gml",xlink:"http://www.w3.org/1999/xlink",xsi:"http://www.w3.org/2001/XMLSchema-instance",wfs:"http://www.opengis.net/wfs"},defaultPrefix:"gml",schemaLocation:null,featureType:null,featureNS:null,geometryName:"geometry",extractAttributes:true,srsName:null,xy:true,geometryTypes:null,singleFeatureType:null,regExes:{trimSpace:(/^\s*|\s*$/g),removeSpace:(/\s*/g),splitSpace:(/\s+/),trimComma:(/\s*,\s*/g)},initialize:function(a){OpenLayers.Format.XML.prototype.initialize.apply(this,[a]);
this.setGeometryTypes();
if(a&&a.featureNS){this.setNamespace("feature",a.featureNS)
}this.singleFeatureType=!a||(typeof a.featureType==="string")
},read:function(e){if(typeof e=="string"){e=OpenLayers.Format.XML.prototype.read.apply(this,[e])
}if(e&&e.nodeType==9){e=e.documentElement
}var c=[];
this.readNode(e,{features:c});
if(c.length==0){var d=this.getElementsByTagNameNS(e,this.namespaces.gml,"featureMember");
if(d.length){for(var b=0,a=d.length;
b<a;
++b){this.readNode(d[b],{features:c})
}}else{var d=this.getElementsByTagNameNS(e,this.namespaces.gml,"featureMembers");
if(d.length){this.readNode(d[0],{features:c})
}}}return c
},readers:{gml:{featureMember:function(a,b){this.readChildNodes(a,b)
},featureMembers:function(a,b){this.readChildNodes(a,b)
},name:function(a,b){b.name=this.getChildValue(a)
},boundedBy:function(b,c){var a={};
this.readChildNodes(b,a);
if(a.components&&a.components.length>0){c.bounds=a.components[0]
}},Point:function(b,a){var c={points:[]};
this.readChildNodes(b,c);
if(!a.components){a.components=[]
}a.components.push(c.points[0])
},coordinates:function(e,g){var h=this.getChildValue(e).replace(this.regExes.trimSpace,"");
h=h.replace(this.regExes.trimComma,",");
var a=h.split(this.regExes.splitSpace);
var f;
var d=a.length;
var c=new Array(d);
for(var b=0;
b<d;
++b){f=a[b].split(",");
if(this.xy){c[b]=new OpenLayers.Geometry.Point(f[0],f[1],f[2])
}else{c[b]=new OpenLayers.Geometry.Point(f[1],f[0],f[2])
}}g.points=c
},coord:function(a,b){var c={};
this.readChildNodes(a,c);
if(!b.points){b.points=[]
}b.points.push(new OpenLayers.Geometry.Point(c.x,c.y,c.z))
},X:function(a,b){b.x=this.getChildValue(a)
},Y:function(a,b){b.y=this.getChildValue(a)
},Z:function(a,b){b.z=this.getChildValue(a)
},MultiPoint:function(b,a){var c={components:[]};
this.readChildNodes(b,c);
a.components=[new OpenLayers.Geometry.MultiPoint(c.components)]
},pointMember:function(a,b){this.readChildNodes(a,b)
},LineString:function(b,a){var c={};
this.readChildNodes(b,c);
if(!a.components){a.components=[]
}a.components.push(new OpenLayers.Geometry.LineString(c.points))
},MultiLineString:function(b,a){var c={components:[]};
this.readChildNodes(b,c);
a.components=[new OpenLayers.Geometry.MultiLineString(c.components)]
},lineStringMember:function(a,b){this.readChildNodes(a,b)
},Polygon:function(b,a){var c={outer:null,inner:[]};
this.readChildNodes(b,c);
c.inner.unshift(c.outer);
if(!a.components){a.components=[]
}a.components.push(new OpenLayers.Geometry.Polygon(c.inner))
},LinearRing:function(b,c){var a={};
this.readChildNodes(b,a);
c.components=[new OpenLayers.Geometry.LinearRing(a.points)]
},MultiPolygon:function(b,a){var c={components:[]};
this.readChildNodes(b,c);
a.components=[new OpenLayers.Geometry.MultiPolygon(c.components)]
},polygonMember:function(a,b){this.readChildNodes(a,b)
},GeometryCollection:function(b,a){var c={components:[]};
this.readChildNodes(b,c);
a.components=[new OpenLayers.Geometry.Collection(c.components)]
},geometryMember:function(a,b){this.readChildNodes(a,b)
}},feature:{"*":function(c,d){var a;
var b=c.localName||c.nodeName.split(":").pop();
if(d.features){if(!this.singleFeatureType&&(OpenLayers.Util.indexOf(this.featureType,b)!==-1)){a="_typeName"
}else{if(b===this.featureType){a="_typeName"
}}}else{if(c.childNodes.length==0||(c.childNodes.length==1&&c.firstChild.nodeType==3)){if(this.extractAttributes){a="_attribute"
}}else{a="_geometry"
}}if(a){this.readers.feature[a].apply(this,[c,d])
}},_typeName:function(c,d){var a={components:[],attributes:{}};
this.readChildNodes(c,a);
if(a.name){a.attributes.name=a.name
}var b=new OpenLayers.Feature.Vector(a.components[0],a.attributes);
if(!this.singleFeatureType){b.type=c.nodeName.split(":").pop();
b.namespace=c.namespaceURI
}var e=c.getAttribute("fid")||this.getAttributeNS(c,this.namespaces.gml,"id");
if(e){b.fid=e
}if(this.internalProjection&&this.externalProjection&&b.geometry){b.geometry.transform(this.externalProjection,this.internalProjection)
}if(a.bounds){b.bounds=a.bounds
}d.features.push(b)
},_geometry:function(a,b){this.readChildNodes(a,b)
},_attribute:function(b,d){var a=b.localName||b.nodeName.split(":").pop();
var c=this.getChildValue(b);
d.attributes[a]=c
}},wfs:{FeatureCollection:function(a,b){this.readChildNodes(a,b)
}}},write:function(c){var b;
if(c instanceof Array){b="featureMembers"
}else{b="featureMember"
}var a=this.writeNode("gml:"+b,c);
this.setAttributeNS(a,this.namespaces.xsi,"xsi:schemaLocation",this.schemaLocation);
return OpenLayers.Format.XML.prototype.write.apply(this,[a])
},writers:{gml:{featureMember:function(a){var b=this.createElementNSPlus("gml:featureMember");
this.writeNode("feature:_typeName",a,b);
return b
},MultiPoint:function(c){var b=this.createElementNSPlus("gml:MultiPoint");
for(var a=0;
a<c.components.length;
++a){this.writeNode("pointMember",c.components[a],b)
}return b
},pointMember:function(b){var a=this.createElementNSPlus("gml:pointMember");
this.writeNode("Point",b,a);
return a
},MultiLineString:function(c){var b=this.createElementNSPlus("gml:MultiLineString");
for(var a=0;
a<c.components.length;
++a){this.writeNode("lineStringMember",c.components[a],b)
}return b
},lineStringMember:function(b){var a=this.createElementNSPlus("gml:lineStringMember");
this.writeNode("LineString",b,a);
return a
},MultiPolygon:function(c){var b=this.createElementNSPlus("gml:MultiPolygon");
for(var a=0;
a<c.components.length;
++a){this.writeNode("polygonMember",c.components[a],b)
}return b
},polygonMember:function(b){var a=this.createElementNSPlus("gml:polygonMember");
this.writeNode("Polygon",b,a);
return a
},GeometryCollection:function(d){var c=this.createElementNSPlus("gml:GeometryCollection");
for(var b=0,a=d.components.length;
b<a;
++b){this.writeNode("geometryMember",d.components[b],c)
}return c
},geometryMember:function(b){var a=this.createElementNSPlus("gml:geometryMember");
var c=this.writeNode("feature:_geometry",b);
a.appendChild(c.firstChild);
return a
}},feature:{_typeName:function(b){var c=this.createElementNSPlus("feature:"+this.featureType,{attributes:{fid:b.fid}});
if(b.geometry){this.writeNode("feature:_geometry",b.geometry,c)
}for(var a in b.attributes){var d=b.attributes[a];
if(d!=null){this.writeNode("feature:_attribute",{name:a,value:d},c)
}}return c
},_geometry:function(c){if(this.externalProjection&&this.internalProjection){c=c.clone().transform(this.internalProjection,this.externalProjection)
}var b=this.createElementNSPlus("feature:"+this.geometryName);
var a=this.geometryTypes[c.CLASS_NAME];
var d=this.writeNode("gml:"+a,c,b);
if(this.srsName){d.setAttribute("srsName",this.srsName)
}return b
},_attribute:function(a){return this.createElementNSPlus("feature:"+a.name,{value:a.value})
}},wfs:{FeatureCollection:function(c){var d=this.createElementNSPlus("wfs:FeatureCollection");
for(var b=0,a=c.length;
b<a;
++b){this.writeNode("gml:featureMember",c[b],d)
}return d
}}},setGeometryTypes:function(){this.geometryTypes={"OpenLayers.Geometry.Point":"Point","OpenLayers.Geometry.MultiPoint":"MultiPoint","OpenLayers.Geometry.LineString":"LineString","OpenLayers.Geometry.MultiLineString":"MultiLineString","OpenLayers.Geometry.Polygon":"Polygon","OpenLayers.Geometry.MultiPolygon":"MultiPolygon","OpenLayers.Geometry.Collection":"GeometryCollection"}
},CLASS_NAME:"OpenLayers.Format.GML.Base"});OpenLayers.Format.GML.v3=OpenLayers.Class(OpenLayers.Format.GML.Base,{schemaLocation:"http://www.opengis.net/gml http://schemas.opengis.net/gml/3.1.1/profiles/gmlsfProfile/1.0.0/gmlsf.xsd",curve:false,multiCurve:true,surface:false,multiSurface:true,initialize:function(a){OpenLayers.Format.GML.Base.prototype.initialize.apply(this,[a])
},readers:{gml:OpenLayers.Util.applyDefaults({featureMembers:function(a,b){this.readChildNodes(a,b)
},Curve:function(b,a){var c={points:[]};
this.readChildNodes(b,c);
if(!a.components){a.components=[]
}a.components.push(new OpenLayers.Geometry.LineString(c.points))
},segments:function(a,b){this.readChildNodes(a,b)
},LineStringSegment:function(b,a){var c={};
this.readChildNodes(b,c);
if(c.points){Array.prototype.push.apply(a.points,c.points)
}},pos:function(b,d){var e=this.getChildValue(b).replace(this.regExes.trimSpace,"");
var c=e.split(this.regExes.splitSpace);
var a;
if(this.xy){a=new OpenLayers.Geometry.Point(c[0],c[1],c[2])
}else{a=new OpenLayers.Geometry.Point(c[1],c[0],c[2])
}d.points=[a]
},posList:function(a,d){var h=this.getChildValue(a).replace(this.regExes.trimSpace,"");
var m=h.split(this.regExes.splitSpace);
var e=parseInt(a.getAttribute("dimension"))||2;
var b,n,l,g;
var k=m.length/e;
var o=new Array(k);
for(var c=0,f=m.length;
c<f;
c+=e){n=m[c];
l=m[c+1];
g=(e==2)?undefined:m[c+2];
if(this.xy){o[c/e]=new OpenLayers.Geometry.Point(n,l,g)
}else{o[c/e]=new OpenLayers.Geometry.Point(l,n,g)
}}d.points=o
},Surface:function(a,b){this.readChildNodes(a,b)
},patches:function(a,b){this.readChildNodes(a,b)
},PolygonPatch:function(a,b){this.readers.gml.Polygon.apply(this,[a,b])
},exterior:function(b,a){var c={};
this.readChildNodes(b,c);
a.outer=c.components[0]
},interior:function(b,a){var c={};
this.readChildNodes(b,c);
a.inner.push(c.components[0])
},MultiCurve:function(b,a){var c={components:[]};
this.readChildNodes(b,c);
if(c.components.length>0){a.components=[new OpenLayers.Geometry.MultiLineString(c.components)]
}},curveMember:function(a,b){this.readChildNodes(a,b)
},MultiSurface:function(b,a){var c={components:[]};
this.readChildNodes(b,c);
if(c.components.length>0){a.components=[new OpenLayers.Geometry.MultiPolygon(c.components)]
}},surfaceMember:function(a,b){this.readChildNodes(a,b)
},surfaceMembers:function(a,b){this.readChildNodes(a,b)
},pointMembers:function(a,b){this.readChildNodes(a,b)
},lineStringMembers:function(a,b){this.readChildNodes(a,b)
},polygonMembers:function(a,b){this.readChildNodes(a,b)
},geometryMembers:function(a,b){this.readChildNodes(a,b)
},Envelope:function(d,b){var e={points:new Array(2)};
this.readChildNodes(d,e);
if(!b.components){b.components=[]
}var c=e.points[0];
var a=e.points[1];
b.components.push(new OpenLayers.Bounds(c.x,c.y,a.x,a.y))
},lowerCorner:function(b,a){var c={};
this.readers.gml.pos.apply(this,[b,c]);
a.points[0]=c.points[0]
},upperCorner:function(b,a){var c={};
this.readers.gml.pos.apply(this,[b,c]);
a.points[1]=c.points[0]
}},OpenLayers.Format.GML.Base.prototype.readers.gml),feature:OpenLayers.Format.GML.Base.prototype.readers.feature,wfs:OpenLayers.Format.GML.Base.prototype.readers.wfs},write:function(c){var b;
if(c instanceof Array){b="featureMembers"
}else{b="featureMember"
}var a=this.writeNode("gml:"+b,c);
this.setAttributeNS(a,this.namespaces.xsi,"xsi:schemaLocation",this.schemaLocation);
return OpenLayers.Format.XML.prototype.write.apply(this,[a])
},writers:{gml:OpenLayers.Util.applyDefaults({featureMembers:function(c){var d=this.createElementNSPlus("gml:featureMembers");
for(var b=0,a=c.length;
b<a;
++b){this.writeNode("feature:_typeName",c[b],d)
}return d
},Point:function(b){var a=this.createElementNSPlus("gml:Point");
this.writeNode("pos",b,a);
return a
},pos:function(a){var b=(this.xy)?(a.x+" "+a.y):(a.y+" "+a.x);
return this.createElementNSPlus("gml:pos",{value:b})
},LineString:function(b){var a=this.createElementNSPlus("gml:LineString");
this.writeNode("posList",b.components,a);
return a
},Curve:function(b){var a=this.createElementNSPlus("gml:Curve");
this.writeNode("segments",b,a);
return a
},segments:function(b){var a=this.createElementNSPlus("gml:segments");
this.writeNode("LineStringSegment",b,a);
return a
},LineStringSegment:function(b){var a=this.createElementNSPlus("gml:LineStringSegment");
this.writeNode("posList",b.components,a);
return a
},posList:function(d){var b=d.length;
var e=new Array(b);
var a;
for(var c=0;
c<b;
++c){a=d[c];
if(this.xy){e[c]=a.x+" "+a.y
}else{e[c]=a.y+" "+a.x
}}return this.createElementNSPlus("gml:posList",{value:e.join(" ")})
},Surface:function(b){var a=this.createElementNSPlus("gml:Surface");
this.writeNode("patches",b,a);
return a
},patches:function(b){var a=this.createElementNSPlus("gml:patches");
this.writeNode("PolygonPatch",b,a);
return a
},PolygonPatch:function(d){var c=this.createElementNSPlus("gml:PolygonPatch",{attributes:{interpolation:"planar"}});
this.writeNode("exterior",d.components[0],c);
for(var b=1,a=d.components.length;
b<a;
++b){this.writeNode("interior",d.components[b],c)
}return c
},Polygon:function(d){var c=this.createElementNSPlus("gml:Polygon");
this.writeNode("exterior",d.components[0],c);
for(var b=1,a=d.components.length;
b<a;
++b){this.writeNode("interior",d.components[b],c)
}return c
},exterior:function(a){var b=this.createElementNSPlus("gml:exterior");
this.writeNode("LinearRing",a,b);
return b
},interior:function(a){var b=this.createElementNSPlus("gml:interior");
this.writeNode("LinearRing",a,b);
return b
},LinearRing:function(a){var b=this.createElementNSPlus("gml:LinearRing");
this.writeNode("posList",a.components,b);
return b
},MultiCurve:function(d){var c=this.createElementNSPlus("gml:MultiCurve");
for(var b=0,a=d.components.length;
b<a;
++b){this.writeNode("curveMember",d.components[b],c)
}return c
},curveMember:function(b){var a=this.createElementNSPlus("gml:curveMember");
if(this.curve){this.writeNode("Curve",b,a)
}else{this.writeNode("LineString",b,a)
}return a
},MultiSurface:function(d){var c=this.createElementNSPlus("gml:MultiSurface");
for(var b=0,a=d.components.length;
b<a;
++b){this.writeNode("surfaceMember",d.components[b],c)
}return c
},surfaceMember:function(a){var b=this.createElementNSPlus("gml:surfaceMember");
if(this.surface){this.writeNode("Surface",a,b)
}else{this.writeNode("Polygon",a,b)
}return b
},Envelope:function(b){var a=this.createElementNSPlus("gml:Envelope");
this.writeNode("lowerCorner",b,a);
this.writeNode("upperCorner",b,a);
if(this.srsName){a.setAttribute("srsName",this.srsName)
}return a
},lowerCorner:function(a){var b=(this.xy)?(a.left+" "+a.bottom):(a.bottom+" "+a.left);
return this.createElementNSPlus("gml:lowerCorner",{value:b})
},upperCorner:function(a){var b=(this.xy)?(a.right+" "+a.top):(a.top+" "+a.right);
return this.createElementNSPlus("gml:upperCorner",{value:b})
}},OpenLayers.Format.GML.Base.prototype.writers.gml),feature:OpenLayers.Format.GML.Base.prototype.writers.feature,wfs:OpenLayers.Format.GML.Base.prototype.writers.wfs},setGeometryTypes:function(){this.geometryTypes={"OpenLayers.Geometry.Point":"Point","OpenLayers.Geometry.MultiPoint":"MultiPoint","OpenLayers.Geometry.LineString":(this.curve===true)?"Curve":"LineString","OpenLayers.Geometry.MultiLineString":(this.multiCurve===false)?"MultiLineString":"MultiCurve","OpenLayers.Geometry.Polygon":(this.surface===true)?"Surface":"Polygon","OpenLayers.Geometry.MultiPolygon":(this.multiSurface===false)?"MultiPolygon":"MultiSurface","OpenLayers.Geometry.Collection":"GeometryCollection"}
},CLASS_NAME:"OpenLayers.Format.GML.v3"});OpenLayers.Element={visible:function(a){return OpenLayers.Util.getElement(a).style.display!="none"
},toggle:function(){for(var c=0,a=arguments.length;
c<a;
c++){var b=OpenLayers.Util.getElement(arguments[c]);
var d=OpenLayers.Element.visible(b)?"hide":"show";
OpenLayers.Element[d](b)
}},hide:function(){for(var c=0,a=arguments.length;
c<a;
c++){var b=OpenLayers.Util.getElement(arguments[c]);
if(b){b.style.display="none"
}}},show:function(){for(var c=0,a=arguments.length;
c<a;
c++){var b=OpenLayers.Util.getElement(arguments[c]);
if(b){b.style.display=""
}}},remove:function(a){a=OpenLayers.Util.getElement(a);
a.parentNode.removeChild(a)
},getHeight:function(a){a=OpenLayers.Util.getElement(a);
return a.offsetHeight
},getDimensions:function(c){c=OpenLayers.Util.getElement(c);
if(OpenLayers.Element.getStyle(c,"display")!="none"){return{width:c.offsetWidth,height:c.offsetHeight}
}var b=c.style;
var f=b.visibility;
var d=b.position;
var a=b.display;
b.visibility="hidden";
b.position="absolute";
b.display="";
var g=c.clientWidth;
var e=c.clientHeight;
b.display=a;
b.position=d;
b.visibility=f;
return{width:g,height:e}
},hasClass:function(b,a){var c=b.className;
return(!!c&&new RegExp("(^|\\s)"+a+"(\\s|$)").test(c))
},addClass:function(b,a){if(!OpenLayers.Element.hasClass(b,a)){b.className+=(b.className?" ":"")+a
}return b
},removeClass:function(b,a){var c=b.className;
if(c){b.className=OpenLayers.String.trim(c.replace(new RegExp("(^|\\s+)"+a+"(\\s+|$)")," "))
}return b
},toggleClass:function(b,a){if(OpenLayers.Element.hasClass(b,a)){OpenLayers.Element.removeClass(b,a)
}else{OpenLayers.Element.addClass(b,a)
}return b
},getStyle:function(c,d){c=OpenLayers.Util.getElement(c);
var e=null;
if(c&&c.style){e=c.style[OpenLayers.String.camelize(d)];
if(!e){if(document.defaultView&&document.defaultView.getComputedStyle){var b=document.defaultView.getComputedStyle(c,null);
e=b?b.getPropertyValue(d):null
}else{if(c.currentStyle){e=c.currentStyle[OpenLayers.String.camelize(d)]
}}}var a=["left","top","right","bottom"];
if(window.opera&&(OpenLayers.Util.indexOf(a,d)!=-1)&&(OpenLayers.Element.getStyle(c,"position")=="static")){e="auto"
}}return e=="auto"?null:e
}};OpenLayers.Handler.MouseWheel=OpenLayers.Class(OpenLayers.Handler,{wheelListener:null,mousePosition:null,interval:0,delta:0,cumulative:true,initialize:function(c,b,a){OpenLayers.Handler.prototype.initialize.apply(this,arguments);
this.wheelListener=OpenLayers.Function.bindAsEventListener(this.onWheelEvent,this)
},destroy:function(){OpenLayers.Handler.prototype.destroy.apply(this,arguments);
this.wheelListener=null
},onWheelEvent:function(k){if(!this.map||!this.checkModifiers(k)){return
}var g=false;
var m=false;
var f=false;
var b=OpenLayers.Event.element(k);
while((b!=null)&&!f&&!g){if(!g){try{if(b.currentStyle){c=b.currentStyle.overflow
}else{var a=document.defaultView.getComputedStyle(b,null);
var c=a.getPropertyValue("overflow")
}g=(c&&(c=="auto")||(c=="scroll"))
}catch(d){}}if(!m){for(var h=0,j=this.map.layers.length;
h<j;
h++){if(b==this.map.layers[h].div||b==this.map.layers[h].pane){m=true;
break
}}}f=(b==this.map.div);
b=b.parentNode
}if(!g&&f){if(m){var l=0;
if(!k){k=window.event
}if(k.wheelDelta){l=k.wheelDelta/120;
if(window.opera&&window.opera.version()<9.2){l=-l
}}else{if(k.detail){l=-k.detail/3
}}this.delta=this.delta+l;
if(this.interval){window.clearTimeout(this._timeoutId);
this._timeoutId=window.setTimeout(OpenLayers.Function.bind(function(){this.wheelZoom(k)
},this),this.interval)
}else{this.wheelZoom(k)
}}OpenLayers.Event.stop(k)
}},wheelZoom:function(a){var b=this.delta;
this.delta=0;
if(b){if(this.mousePosition){a.xy=this.mousePosition
}if(!a.xy){a.xy=this.map.getPixelFromLonLat(this.map.getCenter())
}if(b<0){this.callback("down",[a,this.cumulative?b:-1])
}else{this.callback("up",[a,this.cumulative?b:1])
}}},mousemove:function(a){this.mousePosition=a.xy
},activate:function(a){if(OpenLayers.Handler.prototype.activate.apply(this,arguments)){var b=this.wheelListener;
OpenLayers.Event.observe(window,"DOMMouseScroll",b);
OpenLayers.Event.observe(window,"mousewheel",b);
OpenLayers.Event.observe(document,"mousewheel",b);
return true
}else{return false
}},deactivate:function(a){if(OpenLayers.Handler.prototype.deactivate.apply(this,arguments)){var b=this.wheelListener;
OpenLayers.Event.stopObserving(window,"DOMMouseScroll",b);
OpenLayers.Event.stopObserving(window,"mousewheel",b);
OpenLayers.Event.stopObserving(document,"mousewheel",b);
return true
}else{return false
}},CLASS_NAME:"OpenLayers.Handler.MouseWheel"});OpenLayers.Control.ZoomToMaxExtent=OpenLayers.Class(OpenLayers.Control,{type:OpenLayers.Control.TYPE_BUTTON,trigger:function(){if(this.map){this.map.zoomToMaxExtent()
}},CLASS_NAME:"OpenLayers.Control.ZoomToMaxExtent"});OpenLayers.Style=OpenLayers.Class({id:null,name:null,title:null,description:null,layerName:null,isDefault:false,rules:null,context:null,defaultStyle:null,defaultsPerSymbolizer:false,propertyStyles:null,initialize:function(b,a){OpenLayers.Util.extend(this,a);
this.rules=[];
if(a&&a.rules){this.addRules(a.rules)
}this.setDefaultStyle(b||OpenLayers.Feature.Vector.style["default"]);
this.id=OpenLayers.Util.createUniqueID(this.CLASS_NAME+"_")
},destroy:function(){for(var b=0,a=this.rules.length;
b<a;
b++){this.rules[b].destroy();
this.rules[b]=null
}this.rules=null;
this.defaultStyle=null
},createSymbolizer:function(k){var a=this.defaultsPerSymbolizer?{}:this.createLiterals(OpenLayers.Util.extend({},this.defaultStyle),k);
var j=this.rules;
var h,b;
var c=[];
var f=false;
for(var d=0,e=j.length;
d<e;
d++){h=j[d];
var g=h.evaluate(k);
if(g){if(h instanceof OpenLayers.Rule&&h.elseFilter){c.push(h)
}else{f=true;
this.applySymbolizer(h,a,k)
}}}if(f==false&&c.length>0){f=true;
for(var d=0,e=c.length;
d<e;
d++){this.applySymbolizer(c[d],a,k)
}}if(j.length>0&&f==false){a.display="none"
}return a
},applySymbolizer:function(f,d,b){var a=b.geometry?this.getSymbolizerPrefix(b.geometry):OpenLayers.Style.SYMBOLIZER_PREFIXES[0];
var c=f.symbolizer[a]||f.symbolizer;
if(this.defaultsPerSymbolizer===true){var e=this.defaultStyle;
OpenLayers.Util.applyDefaults(c,{pointRadius:e.pointRadius});
if(c.stroke===true||c.graphic===true){OpenLayers.Util.applyDefaults(c,{strokeWidth:e.strokeWidth,strokeColor:e.strokeColor,strokeOpacity:e.strokeOpacity,strokeDashstyle:e.strokeDashstyle,strokeLinecap:e.strokeLinecap})
}if(c.fill===true||c.graphic===true){OpenLayers.Util.applyDefaults(c,{fillColor:e.fillColor,fillOpacity:e.fillOpacity})
}if(c.graphic===true){OpenLayers.Util.applyDefaults(c,{pointRadius:this.defaultStyle.pointRadius,externalGraphic:this.defaultStyle.externalGraphic,graphicName:this.defaultStyle.graphicName,graphicOpacity:this.defaultStyle.graphicOpacity,graphicWidth:this.defaultStyle.graphicWidth,graphicHeight:this.defaultStyle.graphicHeight,graphicXOffset:this.defaultStyle.graphicXOffset,graphicYOffset:this.defaultStyle.graphicYOffset})
}}return this.createLiterals(OpenLayers.Util.extend(d,c),b)
},createLiterals:function(d,c){var b=OpenLayers.Util.extend({},c.attributes||c.data);
OpenLayers.Util.extend(b,this.context);
for(var a in this.propertyStyles){d[a]=OpenLayers.Style.createLiteral(d[a],b,c,a)
}return d
},findPropertyStyles:function(){var d={};
var f=this.defaultStyle;
this.addPropertyStyles(d,f);
var h=this.rules;
var e,g;
for(var c=0,a=h.length;
c<a;
c++){e=h[c].symbolizer;
for(var b in e){g=e[b];
if(typeof g=="object"){this.addPropertyStyles(d,g)
}else{this.addPropertyStyles(d,e);
break
}}}return d
},addPropertyStyles:function(b,c){var d;
for(var a in c){d=c[a];
if(typeof d=="string"&&d.match(/\$\{\w+\}/)){b[a]=true
}}return b
},addRules:function(a){Array.prototype.push.apply(this.rules,a);
this.propertyStyles=this.findPropertyStyles()
},setDefaultStyle:function(a){this.defaultStyle=a;
this.propertyStyles=this.findPropertyStyles()
},getSymbolizerPrefix:function(d){var c=OpenLayers.Style.SYMBOLIZER_PREFIXES;
for(var b=0,a=c.length;
b<a;
b++){if(d.CLASS_NAME.indexOf(c[b])!=-1){return c[b]
}}},clone:function(){var b=OpenLayers.Util.extend({},this);
if(this.rules){b.rules=[];
for(var c=0,a=this.rules.length;
c<a;
++c){b.rules.push(this.rules[c].clone())
}}b.context=this.context&&OpenLayers.Util.extend({},this.context);
var d=OpenLayers.Util.extend({},this.defaultStyle);
return new OpenLayers.Style(d,b)
},CLASS_NAME:"OpenLayers.Style"});
OpenLayers.Style.createLiteral=function(d,b,a,c){if(typeof d=="string"&&d.indexOf("${")!=-1){d=OpenLayers.String.format(d,b,[a,c]);
d=(isNaN(d)||!d)?d:parseFloat(d)
}return d
};
OpenLayers.Style.SYMBOLIZER_PREFIXES=["Point","Line","Polygon","Text","Raster"];OpenLayers.Filter=OpenLayers.Class({initialize:function(a){OpenLayers.Util.extend(this,a)
},destroy:function(){},evaluate:function(a){return true
},clone:function(){return null
},CLASS_NAME:"OpenLayers.Filter"});OpenLayers.Filter.FeatureId=OpenLayers.Class(OpenLayers.Filter,{fids:null,initialize:function(a){this.fids=[];
OpenLayers.Filter.prototype.initialize.apply(this,[a])
},evaluate:function(c){for(var b=0,a=this.fids.length;
b<a;
b++){var d=c.fid||c.id;
if(d==this.fids[b]){return true
}}return false
},clone:function(){var a=new OpenLayers.Filter.FeatureId();
OpenLayers.Util.extend(a,this);
a.fids=this.fids.slice();
return a
},CLASS_NAME:"OpenLayers.Filter.FeatureId"});OpenLayers.Filter.Logical=OpenLayers.Class(OpenLayers.Filter,{filters:null,type:null,initialize:function(a){this.filters=[];
OpenLayers.Filter.prototype.initialize.apply(this,[a])
},destroy:function(){this.filters=null;
OpenLayers.Filter.prototype.destroy.apply(this)
},evaluate:function(c){switch(this.type){case OpenLayers.Filter.Logical.AND:for(var b=0,a=this.filters.length;
b<a;
b++){if(this.filters[b].evaluate(c)==false){return false
}}return true;
case OpenLayers.Filter.Logical.OR:for(var b=0,a=this.filters.length;
b<a;
b++){if(this.filters[b].evaluate(c)==true){return true
}}return false;
case OpenLayers.Filter.Logical.NOT:return(!this.filters[0].evaluate(c))
}},clone:function(){var c=[];
for(var b=0,a=this.filters.length;
b<a;
++b){c.push(this.filters[b].clone())
}return new OpenLayers.Filter.Logical({type:this.type,filters:c})
},CLASS_NAME:"OpenLayers.Filter.Logical"});
OpenLayers.Filter.Logical.AND="&&";
OpenLayers.Filter.Logical.OR="||";
OpenLayers.Filter.Logical.NOT="!";OpenLayers.Filter.Comparison=OpenLayers.Class(OpenLayers.Filter,{type:null,property:null,value:null,matchCase:true,lowerBoundary:null,upperBoundary:null,initialize:function(a){OpenLayers.Filter.prototype.initialize.apply(this,[a])
},evaluate:function(c){if(c instanceof OpenLayers.Feature.Vector){c=c.attributes
}var a=false;
var b=c[this.property];
switch(this.type){case OpenLayers.Filter.Comparison.EQUAL_TO:var e=this.value;
if(!this.matchCase&&typeof b=="string"&&typeof e=="string"){a=(b.toUpperCase()==e.toUpperCase())
}else{a=(b==e)
}break;
case OpenLayers.Filter.Comparison.NOT_EQUAL_TO:var e=this.value;
if(!this.matchCase&&typeof b=="string"&&typeof e=="string"){a=(b.toUpperCase()!=e.toUpperCase())
}else{a=(b!=e)
}break;
case OpenLayers.Filter.Comparison.LESS_THAN:a=b<this.value;
break;
case OpenLayers.Filter.Comparison.GREATER_THAN:a=b>this.value;
break;
case OpenLayers.Filter.Comparison.LESS_THAN_OR_EQUAL_TO:a=b<=this.value;
break;
case OpenLayers.Filter.Comparison.GREATER_THAN_OR_EQUAL_TO:a=b>=this.value;
break;
case OpenLayers.Filter.Comparison.BETWEEN:a=(b>=this.lowerBoundary)&&(b<=this.upperBoundary);
break;
case OpenLayers.Filter.Comparison.LIKE:var d=new RegExp(this.value,"gi");
a=d.test(b);
break
}return a
},value2regex:function(d,b,a){if(d=="."){var c="'.' is an unsupported wildCard character for OpenLayers.Filter.Comparison";
OpenLayers.Console.error(c);
return null
}d=d?d:"*";
b=b?b:".";
a=a?a:"!";
this.value=this.value.replace(new RegExp("\\"+a+"(.|$)","g"),"\\$1");
this.value=this.value.replace(new RegExp("\\"+b,"g"),".");
this.value=this.value.replace(new RegExp("\\"+d,"g"),".*");
this.value=this.value.replace(new RegExp("\\\\.\\*","g"),"\\"+d);
this.value=this.value.replace(new RegExp("\\\\\\.","g"),"\\"+b);
return this.value
},regex2value:function(){var a=this.value;
a=a.replace(/!/g,"!!");
a=a.replace(/(\\)?\\\./g,function(c,b){return b?c:"!."
});
a=a.replace(/(\\)?\\\*/g,function(c,b){return b?c:"!*"
});
a=a.replace(/\\\\/g,"\\");
a=a.replace(/\.\*/g,"*");
return a
},clone:function(){return OpenLayers.Util.extend(new OpenLayers.Filter.Comparison(),this)
},CLASS_NAME:"OpenLayers.Filter.Comparison"});
OpenLayers.Filter.Comparison.EQUAL_TO="==";
OpenLayers.Filter.Comparison.NOT_EQUAL_TO="!=";
OpenLayers.Filter.Comparison.LESS_THAN="<";
OpenLayers.Filter.Comparison.GREATER_THAN=">";
OpenLayers.Filter.Comparison.LESS_THAN_OR_EQUAL_TO="<=";
OpenLayers.Filter.Comparison.GREATER_THAN_OR_EQUAL_TO=">=";
OpenLayers.Filter.Comparison.BETWEEN="..";
OpenLayers.Filter.Comparison.LIKE="~";OpenLayers.Format.Filter=OpenLayers.Class(OpenLayers.Format.XML,{defaultVersion:"1.0.0",version:null,parser:null,initialize:function(a){OpenLayers.Format.XML.prototype.initialize.apply(this,[a])
},write:function(c,b){var a=(b&&b.version)||this.version||this.defaultVersion;
if(!this.parser||this.parser.VERSION!=a){var d=OpenLayers.Format.Filter["v"+a.replace(/\./g,"_")];
if(!d){throw"Can't find a Filter parser for version "+a
}this.parser=new d(this.options)
}return this.parser.write(c)
},read:function(c){if(typeof c=="string"){c=OpenLayers.Format.XML.prototype.read.apply(this,[c])
}var a=this.version;
if(!a){a=this.defaultVersion
}if(!this.parser||this.parser.VERSION!=a){var d=OpenLayers.Format.Filter["v"+a.replace(/\./g,"_")];
if(!d){throw"Can't find a Filter parser for version "+a
}this.parser=new d(this.options)
}var b=this.parser.read(c);
return b
},CLASS_NAME:"OpenLayers.Format.Filter"});OpenLayers.Protocol=OpenLayers.Class({format:null,options:null,autoDestroy:true,defaultFilter:null,initialize:function(a){a=a||{};
OpenLayers.Util.extend(this,a);
this.options=a
},mergeWithDefaultFilter:function(b){var a;
if(b&&this.defaultFilter){a=new OpenLayers.Filter.Logical({type:OpenLayers.Filter.Logical.AND,filters:[this.defaultFilter,b]})
}else{a=b||this.defaultFilter||undefined
}return a
},destroy:function(){this.options=null;
this.format=null
},read:function(a){a=a||{};
a.filter=this.mergeWithDefaultFilter(a.filter)
},create:function(){},update:function(){},"delete":function(){},commit:function(){},abort:function(a){},createCallback:function(c,a,b){return OpenLayers.Function.bind(function(){c.apply(this,[a,b])
},this)
},CLASS_NAME:"OpenLayers.Protocol"});
OpenLayers.Protocol.Response=OpenLayers.Class({code:null,requestType:null,last:true,features:null,reqFeatures:null,priv:null,initialize:function(a){OpenLayers.Util.extend(this,a)
},success:function(){return this.code>0
},CLASS_NAME:"OpenLayers.Protocol.Response"});
OpenLayers.Protocol.Response.SUCCESS=1;
OpenLayers.Protocol.Response.FAILURE=0;OpenLayers.Protocol.HTTP=OpenLayers.Class(OpenLayers.Protocol,{url:null,headers:null,params:null,callback:null,scope:null,readWithPOST:false,wildcarded:false,initialize:function(a){a=a||{};
this.params={};
this.headers={};
OpenLayers.Protocol.prototype.initialize.apply(this,arguments)
},destroy:function(){this.params=null;
this.headers=null;
OpenLayers.Protocol.prototype.destroy.apply(this)
},read:function(a){OpenLayers.Protocol.prototype.read.apply(this,arguments);
a=OpenLayers.Util.applyDefaults(a,this.options);
a.params=OpenLayers.Util.applyDefaults(a.params,this.options.params);
if(a.filter){a.params=this.filterToParams(a.filter,a.params)
}var b=(a.readWithPOST!==undefined)?a.readWithPOST:this.readWithPOST;
var c=new OpenLayers.Protocol.Response({requestType:"read"});
if(b){c.priv=OpenLayers.Request.POST({url:a.url,callback:this.createCallback(this.handleRead,c,a),data:OpenLayers.Util.getParameterString(a.params),headers:{"Content-Type":"application/x-www-form-urlencoded"}})
}else{c.priv=OpenLayers.Request.GET({url:a.url,callback:this.createCallback(this.handleRead,c,a),params:a.params,headers:a.headers})
}return c
},handleRead:function(b,a){this.handleResponse(b,a)
},filterToParams:function(d,g){g=g||{};
var c=d.CLASS_NAME;
var e=c.substring(c.lastIndexOf(".")+1);
switch(e){case"Spatial":switch(d.type){case OpenLayers.Filter.Spatial.BBOX:g.bbox=d.value.toArray();
break;
case OpenLayers.Filter.Spatial.DWITHIN:g.tolerance=d.distance;
case OpenLayers.Filter.Spatial.WITHIN:g.lon=d.value.x;
g.lat=d.value.y;
break;
default:OpenLayers.Console.warn("Unknown spatial filter type "+d.type)
}break;
case"Comparison":var h=OpenLayers.Protocol.HTTP.COMP_TYPE_TO_OP_STR[d.type];
if(h!==undefined){var f=d.value;
if(d.type==OpenLayers.Filter.Comparison.LIKE){f=this.regex2value(f);
if(this.wildcarded){f="%"+f+"%"
}}g[d.property+"__"+h]=f;
g.queryable=g.queryable||[];
g.queryable.push(d.property)
}else{OpenLayers.Console.warn("Unknown comparison filter type "+d.type)
}break;
case"Logical":if(d.type===OpenLayers.Filter.Logical.AND){for(var b=0,a=d.filters.length;
b<a;
b++){g=this.filterToParams(d.filters[b],g)
}}else{OpenLayers.Console.warn("Unsupported logical filter type "+d.type)
}break;
default:OpenLayers.Console.warn("Unknown filter type "+e)
}return g
},regex2value:function(a){a=a.replace(/%/g,"\\%");
a=a.replace(/\\\\\.(\*)?/g,function(c,b){return b?c:"\\\\_"
});
a=a.replace(/\\\\\.\*/g,"\\\\%");
a=a.replace(/(\\)?\.(\*)?/g,function(c,b,d){return b||d?c:"_"
});
a=a.replace(/(\\)?\.\*/g,function(c,b){return b?c:"%"
});
a=a.replace(/\\\./g,".");
a=a.replace(/(\\)?\\\*/g,function(c,b){return b?c:"*"
});
return a
},create:function(b,a){a=OpenLayers.Util.applyDefaults(a,this.options);
var c=new OpenLayers.Protocol.Response({reqFeatures:b,requestType:"create"});
c.priv=OpenLayers.Request.POST({url:a.url,callback:this.createCallback(this.handleCreate,c,a),headers:a.headers,data:this.format.write(b)});
return c
},handleCreate:function(b,a){this.handleResponse(b,a)
},update:function(c,b){b=b||{};
var a=b.url||c.url||this.options.url+"/"+c.fid;
b=OpenLayers.Util.applyDefaults(b,this.options);
var d=new OpenLayers.Protocol.Response({reqFeatures:c,requestType:"update"});
d.priv=OpenLayers.Request.PUT({url:a,callback:this.createCallback(this.handleUpdate,d,b),headers:b.headers,data:this.format.write(c)});
return d
},handleUpdate:function(b,a){this.handleResponse(b,a)
},"delete":function(c,b){b=b||{};
var a=b.url||c.url||this.options.url+"/"+c.fid;
b=OpenLayers.Util.applyDefaults(b,this.options);
var d=new OpenLayers.Protocol.Response({reqFeatures:c,requestType:"delete"});
d.priv=OpenLayers.Request.DELETE({url:a,callback:this.createCallback(this.handleDelete,d,b),headers:b.headers});
return d
},handleDelete:function(b,a){this.handleResponse(b,a)
},handleResponse:function(c,a){var b=c.priv;
if(a.callback){if(b.status>=200&&b.status<300){if(c.requestType!="delete"){c.features=this.parseFeatures(b)
}c.code=OpenLayers.Protocol.Response.SUCCESS
}else{c.code=OpenLayers.Protocol.Response.FAILURE
}a.callback.call(a.scope,c)
}},parseFeatures:function(a){var b=a.responseXML;
if(!b||!b.documentElement){b=a.responseText
}if(!b||b.length<=0){return null
}return this.format.read(b)
},commit:function(b,q){q=OpenLayers.Util.applyDefaults(q,this.options);
var d=[],m=0;
var k={};
k[OpenLayers.State.INSERT]=[];
k[OpenLayers.State.UPDATE]=[];
k[OpenLayers.State.DELETE]=[];
var p,l,c=[];
for(var e=0,j=b.length;
e<j;
++e){p=b[e];
l=k[p.state];
if(l){l.push(p);
c.push(p)
}}var g=(k[OpenLayers.State.INSERT].length>0?1:0)+k[OpenLayers.State.UPDATE].length+k[OpenLayers.State.DELETE].length;
var o=true;
var a=new OpenLayers.Protocol.Response({reqFeatures:c});
function h(s){var r=s.features?s.features.length:0;
var u=new Array(r);
for(var t=0;
t<r;
++t){u[t]=s.features[t].fid
}a.insertIds=u;
n.apply(this,[s])
}function n(i){this.callUserCallback(i,q);
o=o&&i.success();
m++;
if(m>=g){if(q.callback){a.code=o?OpenLayers.Protocol.Response.SUCCESS:OpenLayers.Protocol.Response.FAILURE;
q.callback.apply(q.scope,[a])
}}}var f=k[OpenLayers.State.INSERT];
if(f.length>0){d.push(this.create(f,OpenLayers.Util.applyDefaults({callback:h,scope:this},q.create)))
}f=k[OpenLayers.State.UPDATE];
for(var e=f.length-1;
e>=0;
--e){d.push(this.update(f[e],OpenLayers.Util.applyDefaults({callback:n,scope:this},q.update)))
}f=k[OpenLayers.State.DELETE];
for(var e=f.length-1;
e>=0;
--e){d.push(this["delete"](f[e],OpenLayers.Util.applyDefaults({callback:n,scope:this},q["delete"])))
}return d
},abort:function(a){if(a){a.priv.abort()
}},callUserCallback:function(c,a){var b=a[c.requestType];
if(b&&b.callback){b.callback.call(b.scope,c)
}},CLASS_NAME:"OpenLayers.Protocol.HTTP"});
(function(){var a=OpenLayers.Protocol.HTTP.COMP_TYPE_TO_OP_STR={};
a[OpenLayers.Filter.Comparison.EQUAL_TO]="eq";
a[OpenLayers.Filter.Comparison.NOT_EQUAL_TO]="ne";
a[OpenLayers.Filter.Comparison.LESS_THAN]="lt";
a[OpenLayers.Filter.Comparison.LESS_THAN_OR_EQUAL_TO]="lte";
a[OpenLayers.Filter.Comparison.GREATER_THAN]="gt";
a[OpenLayers.Filter.Comparison.GREATER_THAN_OR_EQUAL_TO]="gte";
a[OpenLayers.Filter.Comparison.LIKE]="ilike"
})();OpenLayers.Renderer=OpenLayers.Class({container:null,root:null,extent:null,locked:false,size:null,resolution:null,map:null,initialize:function(a,b){this.container=OpenLayers.Util.getElement(a)
},destroy:function(){this.container=null;
this.extent=null;
this.size=null;
this.resolution=null;
this.map=null
},supported:function(){return false
},setExtent:function(a,b){this.extent=a.clone();
if(b){this.resolution=null
}},setSize:function(a){this.size=a.clone();
this.resolution=null
},getResolution:function(){this.resolution=this.resolution||this.map.getResolution();
return this.resolution
},drawFeature:function(c,d){if(d==null){d=c.style
}if(c.geometry){var e=c.geometry.getBounds();
if(e){if(!e.intersectsBounds(this.extent)){d={display:"none"}
}var f=this.drawGeometry(c.geometry,d,c.id);
if(d.display!="none"&&d.label&&f!==false){var a=c.geometry.getCentroid();
if(d.labelXOffset||d.labelYOffset){xOffset=isNaN(d.labelXOffset)?0:d.labelXOffset;
yOffset=isNaN(d.labelYOffset)?0:d.labelYOffset;
var b=this.getResolution();
a.move(xOffset*b,yOffset*b)
}this.drawText(c.id,d,a)
}else{this.removeText(c.id)
}return f
}}},drawGeometry:function(c,a,b){},drawText:function(c,b,a){},removeText:function(a){},clear:function(){},getFeatureIdFromEvent:function(a){},eraseFeatures:function(d){if(!(d instanceof Array)){d=[d]
}for(var c=0,a=d.length;
c<a;
++c){var b=d[c];
this.eraseGeometry(b.geometry,b.id);
this.removeText(b.id)
}},eraseGeometry:function(b,a){},moveRoot:function(a){},getRenderLayerId:function(){return this.container.id
},applyDefaultSymbolizer:function(b){var a=OpenLayers.Util.extend({},OpenLayers.Renderer.defaultSymbolizer);
if(b.stroke===false){delete a.strokeWidth;
delete a.strokeColor
}if(b.fill===false){delete a.fillColor
}OpenLayers.Util.extend(a,b);
return a
},CLASS_NAME:"OpenLayers.Renderer"});
OpenLayers.Renderer.defaultSymbolizer={fillColor:"#000000",strokeColor:"#000000",strokeWidth:2,fillOpacity:1,strokeOpacity:1,pointRadius:0};OpenLayers.ElementsIndexer=OpenLayers.Class({maxZIndex:null,order:null,indices:null,compare:null,initialize:function(a){this.compare=a?OpenLayers.ElementsIndexer.IndexingMethods.Z_ORDER_Y_ORDER:OpenLayers.ElementsIndexer.IndexingMethods.Z_ORDER_DRAWING_ORDER;
this.order=[];
this.indices={};
this.maxZIndex=0
},insert:function(c){if(this.exists(c)){this.remove(c)
}var f=c.id;
this.determineZIndex(c);
var d=-1;
var e=this.order.length;
var a;
while(e-d>1){a=parseInt((d+e)/2);
var b=this.compare(this,c,OpenLayers.Util.getElement(this.order[a]));
if(b>0){d=a
}else{e=a
}}this.order.splice(e,0,f);
this.indices[f]=this.getZIndex(c);
return this.getNextElement(e)
},remove:function(b){var d=b.id;
var a=OpenLayers.Util.indexOf(this.order,d);
if(a>=0){this.order.splice(a,1);
delete this.indices[d];
if(this.order.length>0){var c=this.order[this.order.length-1];
this.maxZIndex=this.indices[c]
}else{this.maxZIndex=0
}}},clear:function(){this.order=[];
this.indices={};
this.maxZIndex=0
},exists:function(a){return(this.indices[a.id]!=null)
},getZIndex:function(a){return a._style.graphicZIndex
},determineZIndex:function(a){var b=a._style.graphicZIndex;
if(b==null){b=this.maxZIndex;
a._style.graphicZIndex=b
}else{if(b>this.maxZIndex){this.maxZIndex=b
}}},getNextElement:function(b){var a=b+1;
if(a<this.order.length){var c=OpenLayers.Util.getElement(this.order[a]);
if(c==undefined){c=this.getNextElement(a)
}return c
}else{return null
}},CLASS_NAME:"OpenLayers.ElementsIndexer"});
OpenLayers.ElementsIndexer.IndexingMethods={Z_ORDER:function(e,d,b){var a=e.getZIndex(d);
var f=0;
if(b){var c=e.getZIndex(b);
f=a-c
}return f
},Z_ORDER_DRAWING_ORDER:function(c,b,a){var d=OpenLayers.ElementsIndexer.IndexingMethods.Z_ORDER(c,b,a);
if(a&&d==0){d=1
}return d
},Z_ORDER_Y_ORDER:function(d,c,b){var e=OpenLayers.ElementsIndexer.IndexingMethods.Z_ORDER(d,c,b);
if(b&&e===0){var a=b._boundsBottom-c._boundsBottom;
e=(a===0)?1:a
}return e
}};
OpenLayers.Renderer.Elements=OpenLayers.Class(OpenLayers.Renderer,{rendererRoot:null,root:null,vectorRoot:null,textRoot:null,xmlns:null,indexer:null,BACKGROUND_ID_SUFFIX:"_background",LABEL_ID_SUFFIX:"_label",initialize:function(a,b){OpenLayers.Renderer.prototype.initialize.apply(this,arguments);
this.rendererRoot=this.createRenderRoot();
this.root=this.createRoot("_root");
this.vectorRoot=this.createRoot("_vroot");
this.textRoot=this.createRoot("_troot");
this.root.appendChild(this.vectorRoot);
this.root.appendChild(this.textRoot);
this.rendererRoot.appendChild(this.root);
this.container.appendChild(this.rendererRoot);
if(b&&(b.zIndexing||b.yOrdering)){this.indexer=new OpenLayers.ElementsIndexer(b.yOrdering)
}},destroy:function(){this.clear();
this.rendererRoot=null;
this.root=null;
this.xmlns=null;
OpenLayers.Renderer.prototype.destroy.apply(this,arguments)
},clear:function(){var b;
var a=this.vectorRoot;
if(a){while(b=a.firstChild){a.removeChild(b)
}}a=this.textRoot;
if(a){while(b=a.firstChild){a.removeChild(b)
}}if(this.indexer){this.indexer.clear()
}},getNodeType:function(b,a){},drawGeometry:function(g,d,f){var c=g.CLASS_NAME;
var h=true;
if((c=="OpenLayers.Geometry.Collection")||(c=="OpenLayers.Geometry.MultiPoint")||(c=="OpenLayers.Geometry.MultiLineString")||(c=="OpenLayers.Geometry.MultiPolygon")){for(var b=0,a=g.components.length;
b<a;
b++){h=this.drawGeometry(g.components[b],d,f)&&h
}return h
}h=false;
if(d.display!="none"){if(d.backgroundGraphic){this.redrawBackgroundNode(g.id,g,d,f)
}h=this.redrawNode(g.id,g,d,f)
}if(h==false){var e=document.getElementById(g.id);
if(e){if(e._style.backgroundGraphic){e.parentNode.removeChild(document.getElementById(g.id+this.BACKGROUND_ID_SUFFIX))
}e.parentNode.removeChild(e)
}}return h
},redrawNode:function(g,f,b,e){b=this.applyDefaultSymbolizer(b);
var c=this.nodeFactory(g,this.getNodeType(f,b));
c._featureId=e;
c._boundsBottom=f.getBounds().bottom;
c._geometryClass=f.CLASS_NAME;
c._style=b;
var a=this.drawGeometryNode(c,f,b);
if(a===false){return false
}c=a.node;
if(this.indexer){var d=this.indexer.insert(c);
if(d){this.vectorRoot.insertBefore(c,d)
}else{this.vectorRoot.appendChild(c)
}}else{if(c.parentNode!==this.vectorRoot){this.vectorRoot.appendChild(c)
}}this.postDraw(c);
return a.complete
},redrawBackgroundNode:function(e,d,b,c){var a=OpenLayers.Util.extend({},b);
a.externalGraphic=a.backgroundGraphic;
a.graphicXOffset=a.backgroundXOffset;
a.graphicYOffset=a.backgroundYOffset;
a.graphicZIndex=a.backgroundGraphicZIndex;
a.graphicWidth=a.backgroundWidth||a.graphicWidth;
a.graphicHeight=a.backgroundHeight||a.graphicHeight;
a.backgroundGraphic=null;
a.backgroundXOffset=null;
a.backgroundYOffset=null;
a.backgroundGraphicZIndex=null;
return this.redrawNode(e+this.BACKGROUND_ID_SUFFIX,d,a,null)
},drawGeometryNode:function(c,e,b){b=b||c._style;
var a={isFilled:b.fill===undefined?true:b.fill,isStroked:b.stroke===undefined?!!b.strokeWidth:b.stroke};
var d;
switch(e.CLASS_NAME){case"OpenLayers.Geometry.Point":if(b.graphic===false){a.isFilled=false;
a.isStroked=false
}d=this.drawPoint(c,e);
break;
case"OpenLayers.Geometry.LineString":a.isFilled=false;
d=this.drawLineString(c,e);
break;
case"OpenLayers.Geometry.LinearRing":d=this.drawLinearRing(c,e);
break;
case"OpenLayers.Geometry.Polygon":d=this.drawPolygon(c,e);
break;
case"OpenLayers.Geometry.Surface":d=this.drawSurface(c,e);
break;
case"OpenLayers.Geometry.Rectangle":d=this.drawRectangle(c,e);
break;
default:break
}c._options=a;
if(d!=false){return{node:this.setStyle(c,b,a,e),complete:d}
}else{return false
}},postDraw:function(a){},drawPoint:function(a,b){},drawLineString:function(a,b){},drawLinearRing:function(a,b){},drawPolygon:function(a,b){},drawRectangle:function(a,b){},drawCircle:function(a,b){},drawSurface:function(a,b){},removeText:function(b){var a=document.getElementById(b+this.LABEL_ID_SUFFIX);
if(a){this.textRoot.removeChild(a)
}},getFeatureIdFromEvent:function(a){var d=a.target;
var b=d&&d.correspondingUseElement;
var c=b?b:(d||a.srcElement);
var e=c._featureId;
return e
},eraseGeometry:function(g,f){if((g.CLASS_NAME=="OpenLayers.Geometry.MultiPoint")||(g.CLASS_NAME=="OpenLayers.Geometry.MultiLineString")||(g.CLASS_NAME=="OpenLayers.Geometry.MultiPolygon")||(g.CLASS_NAME=="OpenLayers.Geometry.Collection")){for(var d=0,a=g.components.length;
d<a;
d++){this.eraseGeometry(g.components[d],f)
}}else{var c=OpenLayers.Util.getElement(g.id);
if(c&&c.parentNode){if(c.geometry){c.geometry.destroy();
c.geometry=null
}c.parentNode.removeChild(c);
if(this.indexer){this.indexer.remove(c)
}if(c._style.backgroundGraphic){var b=g.id+this.BACKGROUND_ID_SUFFIX;
var e=OpenLayers.Util.getElement(b);
if(e&&e.parentNode){e.parentNode.removeChild(e)
}}}}},nodeFactory:function(c,a){var b=OpenLayers.Util.getElement(c);
if(b){if(!this.nodeTypeCompare(b,a)){b.parentNode.removeChild(b);
b=this.nodeFactory(c,a)
}}else{b=this.createNode(a,c)
}return b
},nodeTypeCompare:function(b,a){},createNode:function(a,b){},moveRoot:function(b){var a=this.root;
if(b.root.parentNode==this.rendererRoot){a=b.root
}a.parentNode.removeChild(a);
b.rendererRoot.appendChild(a)
},getRenderLayerId:function(){return this.root.parentNode.parentNode.id
},isComplexSymbol:function(a){return(a!="circle")&&!!a
},CLASS_NAME:"OpenLayers.Renderer.Elements"});
OpenLayers.Renderer.symbol={star:[350,75,379,161,469,161,397,215,423,301,350,250,277,301,303,215,231,161,321,161,350,75],cross:[4,0,6,0,6,4,10,4,10,6,6,6,6,10,4,10,4,6,0,6,0,4,4,4,4,0],x:[0,0,25,0,50,35,75,0,100,0,65,50,100,100,75,100,50,65,25,100,0,100,35,50,0,0],square:[0,0,0,1,1,1,1,0,0,0],triangle:[0,10,10,10,5,0,0,10]};Ext.namespace("GeoExt");
GeoExt.MapPanel=Ext.extend(Ext.Panel,{map:null,layers:null,center:null,zoom:null,extent:null,initComponent:function(){if(!(this.map instanceof OpenLayers.Map)){this.map=new OpenLayers.Map(Ext.applyIf(this.map||{},{allOverlays:true}))
}var a=this.layers;
if(!a||a instanceof Array){this.layers=new GeoExt.data.LayerStore({layers:a,map:this.map})
}if(typeof this.center=="string"){this.center=OpenLayers.LonLat.fromString(this.center)
}else{if(this.center instanceof Array){this.center=new OpenLayers.LonLat(this.center[0],this.center[1])
}}if(typeof this.extent=="string"){this.extent=OpenLayers.Bounds.fromString(this.extent)
}else{if(this.extent instanceof Array){this.extent=OpenLayers.Bounds.fromArray(this.extent)
}}GeoExt.MapPanel.superclass.initComponent.call(this)
},updateMapSize:function(){if(this.map){this.map.updateSize()
}},renderMap:function(){var a=this.map;
a.render(this.body.dom);
if(a.layers.length>0){if(this.center||this.zoom!=null){a.setCenter(this.center,this.zoom)
}else{if(this.extent){a.zoomToExtent(this.extent)
}else{a.zoomToMaxExtent()
}}}},afterRender:function(){GeoExt.MapPanel.superclass.afterRender.apply(this,arguments);
if(!this.ownerCt){this.renderMap()
}else{this.ownerCt.on("move",this.updateMapSize,this);
this.ownerCt.on({afterlayout:{fn:this.renderMap,scope:this,single:true}})
}},onResize:function(){GeoExt.MapPanel.superclass.onResize.apply(this,arguments);
this.updateMapSize()
},onBeforeAdd:function(a){if(typeof a.addToMapPanel==="function"){a.addToMapPanel(this)
}GeoExt.MapPanel.superclass.onBeforeAdd.apply(this,arguments)
},remove:function(b,a){if(typeof b.removeFromMapPanel==="function"){b.removeFromMapPanel(this)
}GeoExt.MapPanel.superclass.remove.apply(this,arguments)
},beforeDestroy:function(){if(this.ownerCt){this.ownerCt.un("move",this.updateMapSize,this)
}if(!this.initialConfig.map||!(this.initialConfig.map instanceof OpenLayers.Map)){if(this.map&&this.map.destroy){this.map.destroy()
}}delete this.map;
GeoExt.MapPanel.superclass.beforeDestroy.apply(this,arguments)
}});
GeoExt.MapPanel.guess=function(){return Ext.ComponentMgr.all.find(function(a){return a instanceof GeoExt.MapPanel
})
};
Ext.reg("gx_mappanel",GeoExt.MapPanel);OpenLayers.Handler.Feature=OpenLayers.Class(OpenLayers.Handler,{EVENTMAP:{click:{"in":"click",out:"clickout"},mousemove:{"in":"over",out:"out"},dblclick:{"in":"dblclick",out:null},mousedown:{"in":null,out:null},mouseup:{"in":null,out:null}},feature:null,lastFeature:null,down:null,up:null,clickTolerance:4,geometryTypes:null,stopClick:true,stopDown:true,stopUp:false,initialize:function(d,b,c,a){OpenLayers.Handler.prototype.initialize.apply(this,[d,c,a]);
this.layer=b
},mousedown:function(a){this.down=a.xy;
return this.handle(a)?!this.stopDown:true
},mouseup:function(a){this.up=a.xy;
return this.handle(a)?!this.stopUp:true
},click:function(a){return this.handle(a)?!this.stopClick:true
},mousemove:function(a){if(!this.callbacks.over&&!this.callbacks.out){return true
}this.handle(a);
return true
},dblclick:function(a){return !this.handle(a)
},geometryTypeMatches:function(a){return this.geometryTypes==null||OpenLayers.Util.indexOf(this.geometryTypes,a.geometry.CLASS_NAME)>-1
},handle:function(a){if(this.feature&&!this.feature.layer){this.feature=null
}var c=a.type;
var f=false;
var e=!!(this.feature);
var d=(c=="click"||c=="dblclick");
this.feature=this.layer.getFeatureFromEvent(a);
if(this.feature&&!this.feature.layer){this.feature=null
}if(this.lastFeature&&!this.lastFeature.layer){this.lastFeature=null
}if(this.feature){var b=(this.feature!=this.lastFeature);
if(this.geometryTypeMatches(this.feature)){if(e&&b){if(this.lastFeature){this.triggerCallback(c,"out",[this.lastFeature])
}this.triggerCallback(c,"in",[this.feature])
}else{if(!e||d){this.triggerCallback(c,"in",[this.feature])
}}this.lastFeature=this.feature;
f=true
}else{if(this.lastFeature&&(e&&b||d)){this.triggerCallback(c,"out",[this.lastFeature])
}this.feature=null
}}else{if(this.lastFeature&&(e||d)){this.triggerCallback(c,"out",[this.lastFeature])
}}return f
},triggerCallback:function(d,e,b){var c=this.EVENTMAP[d][e];
if(c){if(d=="click"&&this.up&&this.down){var a=Math.sqrt(Math.pow(this.up.x-this.down.x,2)+Math.pow(this.up.y-this.down.y,2));
if(a<=this.clickTolerance){this.callback(c,b)
}}else{this.callback(c,b)
}}},activate:function(){var a=false;
if(OpenLayers.Handler.prototype.activate.apply(this,arguments)){this.moveLayerToTop();
this.map.events.on({removelayer:this.handleMapEvents,changelayer:this.handleMapEvents,scope:this});
a=true
}return a
},deactivate:function(){var a=false;
if(OpenLayers.Handler.prototype.deactivate.apply(this,arguments)){this.moveLayerBack();
this.feature=null;
this.lastFeature=null;
this.down=null;
this.up=null;
this.map.events.un({removelayer:this.handleMapEvents,changelayer:this.handleMapEvents,scope:this});
a=true
}return a
},handleMapEvents:function(a){if(!a.property||a.property=="order"){this.moveLayerToTop()
}},moveLayerToTop:function(){var a=Math.max(this.map.Z_INDEX_BASE.Feature-1,this.layer.getZIndex())+1;
this.layer.setZIndex(a)
},moveLayerBack:function(){var a=this.layer.getZIndex()-1;
if(a>=this.map.Z_INDEX_BASE.Feature){this.layer.setZIndex(a)
}else{this.map.setLayerZIndex(this.layer,this.map.getLayerIndex(this.layer))
}},CLASS_NAME:"OpenLayers.Handler.Feature"});OpenLayers.StyleMap=OpenLayers.Class({styles:null,extendDefault:true,initialize:function(c,a){this.styles={"default":new OpenLayers.Style(OpenLayers.Feature.Vector.style["default"]),select:new OpenLayers.Style(OpenLayers.Feature.Vector.style.select),temporary:new OpenLayers.Style(OpenLayers.Feature.Vector.style.temporary),"delete":new OpenLayers.Style(OpenLayers.Feature.Vector.style["delete"])};
if(c instanceof OpenLayers.Style){this.styles["default"]=c;
this.styles.select=c;
this.styles.temporary=c;
this.styles["delete"]=c
}else{if(typeof c=="object"){for(var b in c){if(c[b] instanceof OpenLayers.Style){this.styles[b]=c[b]
}else{if(typeof c[b]=="object"){this.styles[b]=new OpenLayers.Style(c[b])
}else{this.styles["default"]=new OpenLayers.Style(c);
this.styles.select=new OpenLayers.Style(c);
this.styles.temporary=new OpenLayers.Style(c);
this.styles["delete"]=new OpenLayers.Style(c);
break
}}}}}OpenLayers.Util.extend(this,a)
},destroy:function(){for(var a in this.styles){this.styles[a].destroy()
}this.styles=null
},createSymbolizer:function(b,c){if(!b){b=new OpenLayers.Feature.Vector()
}if(!this.styles[c]){c="default"
}b.renderIntent=c;
var a={};
if(this.extendDefault&&c!="default"){a=this.styles["default"].createSymbolizer(b)
}return OpenLayers.Util.extend(a,this.styles[c].createSymbolizer(b))
},addUniqueValueRules:function(b,d,f,a){var e=[];
for(var c in f){e.push(new OpenLayers.Rule({symbolizer:f[c],context:a,filter:new OpenLayers.Filter.Comparison({type:OpenLayers.Filter.Comparison.EQUAL_TO,property:d,value:c})}))
}this.styles[b].addRules(e)
},CLASS_NAME:"OpenLayers.StyleMap"});OpenLayers.Layer.Vector=OpenLayers.Class(OpenLayers.Layer,{EVENT_TYPES:["beforefeatureadded","beforefeaturesadded","featureadded","featuresadded","beforefeatureremoved","beforefeaturesremoved","featureremoved","featuresremoved","beforefeatureselected","featureselected","featureunselected","beforefeaturemodified","featuremodified","afterfeaturemodified","vertexmodified","sketchstarted","sketchmodified","sketchcomplete","refresh"],isBaseLayer:false,isFixed:false,isVector:true,features:null,filter:null,selectedFeatures:null,unrenderedFeatures:null,reportError:true,style:null,styleMap:null,strategies:null,protocol:null,renderers:["SVG","VML","Canvas"],renderer:null,rendererOptions:null,geometryType:null,drawn:false,initialize:function(c,b){this.EVENT_TYPES=OpenLayers.Layer.Vector.prototype.EVENT_TYPES.concat(OpenLayers.Layer.prototype.EVENT_TYPES);
OpenLayers.Layer.prototype.initialize.apply(this,arguments);
if(!this.renderer||!this.renderer.supported()){this.assignRenderer()
}if(!this.renderer||!this.renderer.supported()){this.renderer=null;
this.displayError()
}if(!this.styleMap){this.styleMap=new OpenLayers.StyleMap()
}this.features=[];
this.selectedFeatures=[];
this.unrenderedFeatures={};
if(this.strategies){for(var d=0,a=this.strategies.length;
d<a;
d++){this.strategies[d].setLayer(this)
}}},destroy:function(){if(this.strategies){var c,b,a;
for(b=0,a=this.strategies.length;
b<a;
b++){c=this.strategies[b];
if(c.autoDestroy){c.destroy()
}}this.strategies=null
}if(this.protocol){if(this.protocol.autoDestroy){this.protocol.destroy()
}this.protocol=null
}this.destroyFeatures();
this.features=null;
this.selectedFeatures=null;
this.unrenderedFeatures=null;
if(this.renderer){this.renderer.destroy()
}this.renderer=null;
this.geometryType=null;
this.drawn=null;
OpenLayers.Layer.prototype.destroy.apply(this,arguments)
},clone:function(e){if(e==null){e=new OpenLayers.Layer.Vector(this.name,this.getOptions())
}e=OpenLayers.Layer.prototype.clone.apply(this,[e]);
var c=this.features;
var a=c.length;
var d=new Array(a);
for(var b=0;
b<a;
++b){d[b]=c[b].clone()
}e.features=d;
return e
},refresh:function(a){if(this.calculateInRange()&&this.visibility){this.events.triggerEvent("refresh",a)
}},assignRenderer:function(){for(var c=0,a=this.renderers.length;
c<a;
c++){var b=this.renderers[c];
var d=(typeof b=="function")?b:OpenLayers.Renderer[b];
if(d&&d.prototype.supported()){this.renderer=new d(this.div,this.rendererOptions);
break
}}},displayError:function(){if(this.reportError){OpenLayers.Console.userError(OpenLayers.i18n("browserNotSupported",{renderers:this.renderers.join("\n")}))
}},setMap:function(a){OpenLayers.Layer.prototype.setMap.apply(this,arguments);
if(!this.renderer){this.map.removeLayer(this)
}else{this.renderer.map=this.map;
this.renderer.setSize(this.map.getSize())
}},afterAdd:function(){if(this.strategies){var c,b,a;
for(b=0,a=this.strategies.length;
b<a;
b++){c=this.strategies[b];
if(c.autoActivate){c.activate()
}}}},removeMap:function(c){this.drawn=false;
if(this.strategies){var d,b,a;
for(b=0,a=this.strategies.length;
b<a;
b++){d=this.strategies[b];
if(d.autoActivate){d.deactivate()
}}}},onMapResize:function(){OpenLayers.Layer.prototype.onMapResize.apply(this,arguments);
this.renderer.setSize(this.map.getSize())
},moveTo:function(g,b,h){OpenLayers.Layer.prototype.moveTo.apply(this,arguments);
var e=true;
if(!h){this.renderer.root.style.visibility="hidden";
this.div.style.left=-parseInt(this.map.layerContainerDiv.style.left)+"px";
this.div.style.top=-parseInt(this.map.layerContainerDiv.style.top)+"px";
var f=this.map.getExtent();
e=this.renderer.setExtent(f,b);
this.renderer.root.style.visibility="visible";
if(navigator.userAgent.toLowerCase().indexOf("gecko")!=-1){this.div.scrollLeft=this.div.scrollLeft
}if(!b&&e){for(var d in this.unrenderedFeatures){var c=this.unrenderedFeatures[d];
this.drawFeature(c)
}}}if(!this.drawn||b||!e){this.drawn=true;
var c;
for(var d=0,a=this.features.length;
d<a;
d++){this.renderer.locked=(d!==(a-1));
c=this.features[d];
this.drawFeature(c)
}}},display:function(a){OpenLayers.Layer.prototype.display.apply(this,arguments);
var b=this.div.style.display;
if(b!=this.renderer.root.style.display){this.renderer.root.style.display=b
}},addFeatures:function(b,k){if(!(b instanceof Array)){b=[b]
}var h=!k||!k.silent;
if(h){var a={features:b};
var g=this.events.triggerEvent("beforefeaturesadded",a);
if(g===false){return
}b=a.features
}var d=[];
for(var c=0,f=b.length;
c<f;
c++){if(c!=(b.length-1)){this.renderer.locked=true
}else{this.renderer.locked=false
}var j=b[c];
if(this.geometryType&&!(j.geometry instanceof this.geometryType)){var e=OpenLayers.i18n("componentShouldBe",{geomType:this.geometryType.prototype.CLASS_NAME});
throw e
}j.layer=this;
if(!j.style&&this.style){j.style=OpenLayers.Util.extend({},this.style)
}if(h){if(this.events.triggerEvent("beforefeatureadded",{feature:j})===false){continue
}this.preFeatureInsert(j)
}d.push(j);
this.features.push(j);
this.drawFeature(j);
if(h){this.events.triggerEvent("featureadded",{feature:j});
this.onFeatureInsert(j)
}}if(h){this.events.triggerEvent("featuresadded",{features:d})
}},removeFeatures:function(e,a){if(!e||e.length===0){return
}if(e===this.features){return this.removeAllFeatures(a)
}if(!(e instanceof Array)){e=[e]
}if(e===this.selectedFeatures){e=e.slice()
}var d=!a||!a.silent;
if(d){this.events.triggerEvent("beforefeaturesremoved",{features:e})
}for(var c=e.length-1;
c>=0;
c--){if(c!=0&&e[c-1].geometry){this.renderer.locked=true
}else{this.renderer.locked=false
}var b=e[c];
delete this.unrenderedFeatures[b.id];
if(d){this.events.triggerEvent("beforefeatureremoved",{feature:b})
}this.features=OpenLayers.Util.removeItem(this.features,b);
b.layer=null;
if(b.geometry){this.renderer.eraseFeatures(b)
}if(OpenLayers.Util.indexOf(this.selectedFeatures,b)!=-1){OpenLayers.Util.removeItem(this.selectedFeatures,b)
}if(d){this.events.triggerEvent("featureremoved",{feature:b})
}}if(d){this.events.triggerEvent("featuresremoved",{features:e})
}},removeAllFeatures:function(a){var d=!a||!a.silent;
var e=this.features;
if(d){this.events.triggerEvent("beforefeaturesremoved",{features:e})
}var c;
for(var b=e.length-1;
b>=0;
b--){c=e[b];
if(d){this.events.triggerEvent("beforefeatureremoved",{feature:c})
}c.layer=null;
if(d){this.events.triggerEvent("featureremoved",{feature:c})
}}this.renderer.clear();
this.features=[];
this.unrenderedFeatures={};
this.selectedFeatures=[];
if(d){this.events.triggerEvent("featuresremoved",{features:e})
}},destroyFeatures:function(d,a){var c=(d==undefined);
if(c){d=this.features
}if(d){this.removeFeatures(d,a);
for(var b=d.length-1;
b>=0;
b--){d[b].destroy()
}}},drawFeature:function(a,b){if(!this.drawn){return
}if(typeof b!="object"){if(!b&&a.state===OpenLayers.State.DELETE){b="delete"
}var c=b||a.renderIntent;
b=a.style||this.style;
if(!b){b=this.styleMap.createSymbolizer(a,c)
}}if(!this.renderer.drawFeature(a,b)){this.unrenderedFeatures[a.id]=a
}else{delete this.unrenderedFeatures[a.id]
}},eraseFeatures:function(a){this.renderer.eraseFeatures(a)
},getFeatureFromEvent:function(a){if(!this.renderer){OpenLayers.Console.error(OpenLayers.i18n("getFeatureError"));
return null
}var b=this.renderer.getFeatureIdFromEvent(a);
return this.getFeatureById(b)
},getFeatureBy:function(e,d){var c=null;
for(var b=0,a=this.features.length;
b<a;
++b){if(this.features[b][e]==d){c=this.features[b];
break
}}return c
},getFeatureById:function(a){return this.getFeatureBy("id",a)
},getFeatureByFid:function(a){return this.getFeatureBy("fid",a)
},onFeatureInsert:function(a){},preFeatureInsert:function(a){},getDataExtent:function(){var b=null;
var d=this.features;
if(d&&(d.length>0)){b=new OpenLayers.Bounds();
var e=null;
for(var c=0,a=d.length;
c<a;
c++){e=d[c].geometry;
if(e){b.extend(e.getBounds())
}}}return b
},CLASS_NAME:"OpenLayers.Layer.Vector"});OpenLayers.Layer.Vector.RootContainer=OpenLayers.Class(OpenLayers.Layer.Vector,{displayInLayerSwitcher:false,layers:null,initialize:function(b,a){OpenLayers.Layer.Vector.prototype.initialize.apply(this,arguments)
},display:function(){},getFeatureFromEvent:function(a){var d=this.layers;
var c;
for(var b=0;
b<d.length;
b++){c=d[b].getFeatureFromEvent(a);
if(c){return c
}}},setMap:function(a){OpenLayers.Layer.Vector.prototype.setMap.apply(this,arguments);
this.collectRoots();
a.events.register("changelayer",this,this.handleChangeLayer)
},removeMap:function(a){a.events.unregister("changelayer",this,this.handleChangeLayer);
this.resetRoots();
OpenLayers.Layer.Vector.prototype.removeMap.apply(this,arguments)
},collectRoots:function(){var b;
for(var a=0;
a<this.map.layers.length;
++a){b=this.map.layers[a];
if(OpenLayers.Util.indexOf(this.layers,b)!=-1){b.renderer.moveRoot(this.renderer)
}}},resetRoots:function(){var b;
for(var a=0;
a<this.layers.length;
++a){b=this.layers[a];
if(this.renderer&&b.renderer.getRenderLayerId()==this.id){this.renderer.moveRoot(b.renderer)
}}},handleChangeLayer:function(a){var b=a.layer;
if(a.property=="order"&&OpenLayers.Util.indexOf(this.layers,b)!=-1){this.resetRoots();
this.collectRoots()
}},CLASS_NAME:"OpenLayers.Layer.Vector.RootContainer"});OpenLayers.Control.SelectFeature=OpenLayers.Class(OpenLayers.Control,{EVENT_TYPES:["beforefeaturehighlighted","featurehighlighted","featureunhighlighted"],multipleKey:null,toggleKey:null,multiple:false,clickout:true,toggle:false,hover:false,highlightOnly:false,box:false,onBeforeSelect:function(){},onSelect:function(){},onUnselect:function(){},scope:null,geometryTypes:null,layer:null,layers:null,callbacks:null,selectStyle:null,renderIntent:"select",handlers:null,initialize:function(c,a){this.EVENT_TYPES=OpenLayers.Control.SelectFeature.prototype.EVENT_TYPES.concat(OpenLayers.Control.prototype.EVENT_TYPES);
OpenLayers.Control.prototype.initialize.apply(this,[a]);
if(this.scope===null){this.scope=this
}this.initLayer(c);
var b={click:this.clickFeature,clickout:this.clickoutFeature};
if(this.hover){b.over=this.overFeature;
b.out=this.outFeature
}this.callbacks=OpenLayers.Util.extend(b,this.callbacks);
this.handlers={feature:new OpenLayers.Handler.Feature(this,this.layer,this.callbacks,{geometryTypes:this.geometryTypes})};
if(this.box){this.handlers.box=new OpenLayers.Handler.Box(this,{done:this.selectBox},{boxDivClassName:"olHandlerBoxSelectFeature"})
}},initLayer:function(a){if(a instanceof Array){this.layers=a;
this.layer=new OpenLayers.Layer.Vector.RootContainer(this.id+"_container",{layers:a})
}else{this.layer=a
}},destroy:function(){if(this.active&&this.layers){this.map.removeLayer(this.layer)
}OpenLayers.Control.prototype.destroy.apply(this,arguments);
if(this.layers){this.layer.destroy()
}},activate:function(){if(!this.active){if(this.layers){this.map.addLayer(this.layer)
}this.handlers.feature.activate();
if(this.box&&this.handlers.box){this.handlers.box.activate()
}}return OpenLayers.Control.prototype.activate.apply(this,arguments)
},deactivate:function(){if(this.active){this.handlers.feature.deactivate();
if(this.handlers.box){this.handlers.box.deactivate()
}if(this.layers){this.map.removeLayer(this.layer)
}}return OpenLayers.Control.prototype.deactivate.apply(this,arguments)
},unselectAll:function(b){var f=this.layers||[this.layer];
var e,d;
for(var a=0;
a<f.length;
++a){e=f[a];
for(var c=e.selectedFeatures.length-1;
c>=0;
--c){d=e.selectedFeatures[c];
if(!b||b.except!=d){this.unselect(d)
}}}},clickFeature:function(a){if(!this.hover){var b=(OpenLayers.Util.indexOf(a.layer.selectedFeatures,a)>-1);
if(b){if(this.toggleSelect()){this.unselect(a)
}else{if(!this.multipleSelect()){this.unselectAll({except:a})
}}}else{if(!this.multipleSelect()){this.unselectAll({except:a})
}this.select(a)
}}},multipleSelect:function(){return this.multiple||(this.handlers.feature.evt&&this.handlers.feature.evt[this.multipleKey])
},toggleSelect:function(){return this.toggle||(this.handlers.feature.evt&&this.handlers.feature.evt[this.toggleKey])
},clickoutFeature:function(a){if(!this.hover&&this.clickout){this.unselectAll()
}},overFeature:function(b){var a=b.layer;
if(this.hover){if(this.highlightOnly){this.highlight(b)
}else{if(OpenLayers.Util.indexOf(a.selectedFeatures,b)==-1){this.select(b)
}}}},outFeature:function(a){if(this.hover){if(this.highlightOnly){if(a._lastHighlighter==this.id){if(a._prevHighlighter&&a._prevHighlighter!=this.id){delete a._lastHighlighter;
var b=this.map.getControl(a._prevHighlighter);
if(b){b.highlight(a)
}}else{this.unhighlight(a)
}}}else{this.unselect(a)
}}},highlight:function(c){var b=c.layer;
var a=this.events.triggerEvent("beforefeaturehighlighted",{feature:c});
if(a!==false){c._prevHighlighter=c._lastHighlighter;
c._lastHighlighter=this.id;
var d=this.selectStyle||this.renderIntent;
b.drawFeature(c,d);
this.events.triggerEvent("featurehighlighted",{feature:c})
}},unhighlight:function(b){var a=b.layer;
b._lastHighlighter=b._prevHighlighter;
delete b._prevHighlighter;
a.drawFeature(b,b.style||b.layer.style||"default");
this.events.triggerEvent("featureunhighlighted",{feature:b})
},select:function(c){var a=this.onBeforeSelect.call(this.scope,c);
var b=c.layer;
if(a!==false){a=b.events.triggerEvent("beforefeatureselected",{feature:c});
if(a!==false){b.selectedFeatures.push(c);
this.highlight(c);
if(!this.handlers.feature.lastFeature){this.handlers.feature.lastFeature=b.selectedFeatures[0]
}b.events.triggerEvent("featureselected",{feature:c});
this.onSelect.call(this.scope,c)
}}},unselect:function(b){var a=b.layer;
this.unhighlight(b);
OpenLayers.Util.removeItem(a.selectedFeatures,b);
a.events.triggerEvent("featureunselected",{feature:b});
this.onUnselect.call(this.scope,b)
},selectBox:function(e){if(e instanceof OpenLayers.Bounds){var h=this.map.getLonLatFromPixel(new OpenLayers.Pixel(e.left,e.bottom));
var k=this.map.getLonLatFromPixel(new OpenLayers.Pixel(e.right,e.top));
var a=new OpenLayers.Bounds(h.lon,h.lat,k.lon,k.lat);
if(!this.multipleSelect()){this.unselectAll()
}var j=this.multiple;
this.multiple=true;
var d=this.layers||[this.layer];
var f;
for(var b=0;
b<d.length;
++b){f=d[b];
for(var c=0,g=f.features.length;
c<g;
++c){var m=f.features[c];
if(!m.getVisibility()){continue
}if(this.geometryTypes==null||OpenLayers.Util.indexOf(this.geometryTypes,m.geometry.CLASS_NAME)>-1){if(a.toGeometry().intersects(m.geometry)){if(OpenLayers.Util.indexOf(f.selectedFeatures,m)==-1){this.select(m)
}}}}}this.multiple=j
}},setMap:function(a){this.handlers.feature.setMap(a);
if(this.box){this.handlers.box.setMap(a)
}OpenLayers.Control.prototype.setMap.apply(this,arguments)
},setLayer:function(b){var a=this.active;
this.unselectAll();
this.deactivate();
if(this.layers){this.layer.destroy();
this.layers=null
}this.initLayer(b);
this.handlers.feature.layer=this.layer;
if(a){this.activate()
}},CLASS_NAME:"OpenLayers.Control.SelectFeature"});Ext.namespace("GeoExt.data");
GeoExt.data.WMSCapabilitiesStore=function(a){a=a||{};
GeoExt.data.WMSCapabilitiesStore.superclass.constructor.call(this,Ext.apply(a,{proxy:a.proxy||(!a.data?new Ext.data.HttpProxy({url:a.url,disableCaching:false,method:"GET"}):undefined),reader:new GeoExt.data.WMSCapabilitiesReader(a,a.fields)}))
};
Ext.extend(GeoExt.data.WMSCapabilitiesStore,Ext.data.Store);OpenLayers.Control.Attribution=OpenLayers.Class(OpenLayers.Control,{separator:", ",initialize:function(a){OpenLayers.Control.prototype.initialize.apply(this,arguments)
},destroy:function(){this.map.events.un({removelayer:this.updateAttribution,addlayer:this.updateAttribution,changelayer:this.updateAttribution,changebaselayer:this.updateAttribution,scope:this});
OpenLayers.Control.prototype.destroy.apply(this,arguments)
},draw:function(){OpenLayers.Control.prototype.draw.apply(this,arguments);
this.map.events.on({changebaselayer:this.updateAttribution,changelayer:this.updateAttribution,addlayer:this.updateAttribution,removelayer:this.updateAttribution,scope:this});
this.updateAttribution();
return this.div
},updateAttribution:function(){var d=[];
if(this.map&&this.map.layers){for(var c=0,a=this.map.layers.length;
c<a;
c++){var b=this.map.layers[c];
if(b.attribution&&b.getVisibility()){if(OpenLayers.Util.indexOf(d,b.attribution)===-1){d.push(b.attribution)
}}}this.div.innerHTML=d.join(this.separator)
}},CLASS_NAME:"OpenLayers.Control.Attribution"});OpenLayers.Request={DEFAULT_CONFIG:{method:"GET",url:window.location.href,async:true,user:undefined,password:undefined,params:null,proxy:OpenLayers.ProxyHost,headers:{},data:null,callback:function(){},success:null,failure:null,scope:null},events:new OpenLayers.Events(this,null,["complete","success","failure"]),issue:function(b){var e=OpenLayers.Util.extend(this.DEFAULT_CONFIG,{proxy:OpenLayers.ProxyHost});
b=OpenLayers.Util.applyDefaults(b,e);
var d=new OpenLayers.Request.XMLHttpRequest();
var a=b.url;
if(b.params){var c=OpenLayers.Util.getParameterString(b.params);
if(c.length>0){var g=(a.indexOf("?")>-1)?"&":"?";
a+=g+c
}}if(b.proxy&&(a.indexOf("http")==0)){if(typeof b.proxy=="function"){a=b.proxy(a)
}else{a=b.proxy+encodeURIComponent(a)
}}d.open(b.method,a,b.async,b.user,b.password);
for(var f in b.headers){d.setRequestHeader(f,b.headers[f])
}var i=this.events;
var h=this;
d.onreadystatechange=function(){if(d.readyState==OpenLayers.Request.XMLHttpRequest.DONE){var j=i.triggerEvent("complete",{request:d,config:b,requestUrl:a});
if(j!==false){h.runCallbacks({request:d,config:b,requestUrl:a})
}}};
if(b.async===false){d.send(b.data)
}else{window.setTimeout(function(){if(d._aborted!==true){d.send(b.data)
}},0)
}return d
},runCallbacks:function(d){var e=d.request;
var c=d.config;
var a=(c.scope)?OpenLayers.Function.bind(c.callback,c.scope):c.callback;
var f;
if(c.success){f=(c.scope)?OpenLayers.Function.bind(c.success,c.scope):c.success
}var b;
if(c.failure){b=(c.scope)?OpenLayers.Function.bind(c.failure,c.scope):c.failure
}a(e);
if(!e.status||(e.status>=200&&e.status<300)){this.events.triggerEvent("success",d);
if(f){f(e)
}}if(e.status&&(e.status<200||e.status>=300)){this.events.triggerEvent("failure",d);
if(b){b(e)
}}},GET:function(a){a=OpenLayers.Util.extend(a,{method:"GET"});
return OpenLayers.Request.issue(a)
},POST:function(a){a=OpenLayers.Util.extend(a,{method:"POST"});
a.headers=a.headers?a.headers:{};
if(!("CONTENT-TYPE" in OpenLayers.Util.upperCaseObject(a.headers))){a.headers["Content-Type"]="application/xml"
}return OpenLayers.Request.issue(a)
},PUT:function(a){a=OpenLayers.Util.extend(a,{method:"PUT"});
a.headers=a.headers?a.headers:{};
if(!("CONTENT-TYPE" in OpenLayers.Util.upperCaseObject(a.headers))){a.headers["Content-Type"]="application/xml"
}return OpenLayers.Request.issue(a)
},DELETE:function(a){a=OpenLayers.Util.extend(a,{method:"DELETE"});
return OpenLayers.Request.issue(a)
},HEAD:function(a){a=OpenLayers.Util.extend(a,{method:"HEAD"});
return OpenLayers.Request.issue(a)
},OPTIONS:function(a){a=OpenLayers.Util.extend(a,{method:"OPTIONS"});
return OpenLayers.Request.issue(a)
}};(function(){var e=window.XMLHttpRequest;
var a=!!window.controllers,h=window.document.all&&!window.opera,i=h&&window.navigator.userAgent.match(/MSIE ([\.0-9]+)/)&&RegExp.$1==7;
function c(){this._object=e&&!i?new e:new window.ActiveXObject("Microsoft.XMLHTTP");
this._listeners=[]
}if(a&&e.wrapped){c.wrapped=e.wrapped
}c.UNSENT=0;
c.OPENED=1;
c.HEADERS_RECEIVED=2;
c.LOADING=3;
c.DONE=4;
c.prototype.readyState=c.UNSENT;
c.prototype.responseText="";
c.prototype.responseXML=null;
c.prototype.status=0;
c.prototype.statusText="";
c.prototype.onreadystatechange=null;
c.onreadystatechange=null;
c.onopen=null;
c.onsend=null;
c.onabort=null;
c.prototype.open=function(m,p,l,q,k){delete this._headers;
if(arguments.length<3){l=true
}this._async=l;
var o=this,n=this.readyState,j;
if(h&&l){j=function(){if(n!=c.DONE){d(o);
o.abort()
}};
window.attachEvent("onunload",j)
}if(c.onopen){c.onopen.apply(this,arguments)
}if(arguments.length>4){this._object.open(m,p,l,q,k)
}else{if(arguments.length>3){this._object.open(m,p,l,q)
}else{this._object.open(m,p,l)
}}if(!a&&!h){this.readyState=c.OPENED;
b(this)
}this._object.onreadystatechange=function(){if(a&&!l){return
}o.readyState=o._object.readyState;
f(o);
if(o._aborted){o.readyState=c.UNSENT;
return
}if(o.readyState==c.DONE){d(o);
if(h&&l){window.detachEvent("onunload",j)
}}if(n!=o.readyState){b(o)
}n=o.readyState
}
};
c.prototype.send=function(j){if(c.onsend){c.onsend.apply(this,arguments)
}if(j&&j.nodeType){j=window.XMLSerializer?new window.XMLSerializer().serializeToString(j):j.xml;
if(!this._headers["Content-Type"]){this._object.setRequestHeader("Content-Type","application/xml")
}}this._object.send(j);
if(a&&!this._async){this.readyState=c.OPENED;
f(this);
while(this.readyState<c.DONE){this.readyState++;
b(this);
if(this._aborted){return
}}}};
c.prototype.abort=function(){if(c.onabort){c.onabort.apply(this,arguments)
}if(this.readyState>c.UNSENT){this._aborted=true
}this._object.abort();
d(this)
};
c.prototype.getAllResponseHeaders=function(){return this._object.getAllResponseHeaders()
};
c.prototype.getResponseHeader=function(j){return this._object.getResponseHeader(j)
};
c.prototype.setRequestHeader=function(j,k){if(!this._headers){this._headers={}
}this._headers[j]=k;
return this._object.setRequestHeader(j,k)
};
c.prototype.addEventListener=function(m,l,k){for(var j=0,n;
n=this._listeners[j];
j++){if(n[0]==m&&n[1]==l&&n[2]==k){return
}}this._listeners.push([m,l,k])
};
c.prototype.removeEventListener=function(m,l,k){for(var j=0,n;
n=this._listeners[j];
j++){if(n[0]==m&&n[1]==l&&n[2]==k){break
}}if(n){this._listeners.splice(j,1)
}};
c.prototype.dispatchEvent=function(k){var l={type:k.type,target:this,currentTarget:this,eventPhase:2,bubbles:k.bubbles,cancelable:k.cancelable,timeStamp:k.timeStamp,stopPropagation:function(){},preventDefault:function(){},initEvent:function(){}};
if(l.type=="readystatechange"&&this.onreadystatechange){(this.onreadystatechange.handleEvent||this.onreadystatechange).apply(this,[l])
}for(var j=0,m;
m=this._listeners[j];
j++){if(m[0]==l.type&&!m[2]){(m[1].handleEvent||m[1]).apply(this,[l])
}}};
c.prototype.toString=function(){return"[object XMLHttpRequest]"
};
c.toString=function(){return"[XMLHttpRequest]"
};
function b(j){if(c.onreadystatechange){c.onreadystatechange.apply(j)
}j.dispatchEvent({type:"readystatechange",bubbles:false,cancelable:false,timeStamp:new Date+0})
}function g(l){var k=l.responseXML,j=l.responseText;
if(h&&j&&k&&!k.documentElement&&l.getResponseHeader("Content-Type").match(/[^\/]+\/[^\+]+\+xml/)){k=new window.ActiveXObject("Microsoft.XMLDOM");
k.async=false;
k.validateOnParse=false;
k.loadXML(j)
}if(k){if((h&&k.parseError!=0)||!k.documentElement||(k.documentElement&&k.documentElement.tagName=="parsererror")){return null
}}return k
}function f(j){try{j.responseText=j._object.responseText
}catch(k){}try{j.responseXML=g(j._object)
}catch(k){}try{j.status=j._object.status
}catch(k){}try{j.statusText=j._object.statusText
}catch(k){}}function d(j){j._object.onreadystatechange=new window.Function
}if(!window.Function.prototype.apply){window.Function.prototype.apply=function(j,k){if(!k){k=[]
}j.__func=this;
j.__func(k[0],k[1],k[2],k[3],k[4]);
delete j.__func
}
}OpenLayers.Request.XMLHttpRequest=c
})();OpenLayers.ProxyHost="";
OpenLayers.nullHandler=function(a){OpenLayers.Console.userError(OpenLayers.i18n("unhandledRequest",{statusText:a.statusText}))
};
OpenLayers.loadURL=function(d,g,b,e,c){if(typeof g=="string"){g=OpenLayers.Util.getParameters(g)
}var f=(e)?e:OpenLayers.nullHandler;
var a=(c)?c:OpenLayers.nullHandler;
return OpenLayers.Request.GET({url:d,params:g,success:f,failure:a,scope:b})
};
OpenLayers.parseXMLString=function(c){var a=c.indexOf("<");
if(a>0){c=c.substring(a)
}var b=OpenLayers.Util.Try(function(){var d=new ActiveXObject("Microsoft.XMLDOM");
d.loadXML(c);
return d
},function(){return new DOMParser().parseFromString(c,"text/xml")
},function(){var d=new XMLHttpRequest();
d.open("GET","data:text/xml;charset=utf-8,"+encodeURIComponent(c),false);
if(d.overrideMimeType){d.overrideMimeType("text/xml")
}d.send(null);
return d.responseXML
});
return b
};
OpenLayers.Ajax={emptyFunction:function(){},getTransport:function(){return OpenLayers.Util.Try(function(){return new XMLHttpRequest()
},function(){return new ActiveXObject("Msxml2.XMLHTTP")
},function(){return new ActiveXObject("Microsoft.XMLHTTP")
})||false
},activeRequestCount:0};
OpenLayers.Ajax.Responders={responders:[],register:function(b){for(var a=0;
a<this.responders.length;
a++){if(b==this.responders[a]){return
}}this.responders.push(b)
},unregister:function(a){OpenLayers.Util.removeItem(this.reponders,a)
},dispatch:function(g,c,f){var a;
for(var b=0;
b<this.responders.length;
b++){a=this.responders[b];
if(a[g]&&typeof a[g]=="function"){try{a[g].apply(a,[c,f])
}catch(d){}}}}};
OpenLayers.Ajax.Responders.register({onCreate:function(){OpenLayers.Ajax.activeRequestCount++
},onComplete:function(){OpenLayers.Ajax.activeRequestCount--
}});
OpenLayers.Ajax.Base=OpenLayers.Class({initialize:function(a){this.options={method:"post",asynchronous:true,contentType:"application/xml",parameters:""};
OpenLayers.Util.extend(this.options,a||{});
this.options.method=this.options.method.toLowerCase();
if(typeof this.options.parameters=="string"){this.options.parameters=OpenLayers.Util.getParameters(this.options.parameters)
}}});
OpenLayers.Ajax.Request=OpenLayers.Class(OpenLayers.Ajax.Base,{_complete:false,initialize:function(b,a){OpenLayers.Ajax.Base.prototype.initialize.apply(this,[a]);
if(OpenLayers.ProxyHost&&OpenLayers.String.startsWith(b,"http")){b=OpenLayers.ProxyHost+encodeURIComponent(b)
}this.transport=OpenLayers.Ajax.getTransport();
this.request(b)
},request:function(b){this.url=b;
this.method=this.options.method;
var d=OpenLayers.Util.extend({},this.options.parameters);
if(this.method!="get"&&this.method!="post"){d._method=this.method;
this.method="post"
}this.parameters=d;
if(d=OpenLayers.Util.getParameterString(d)){if(this.method=="get"){this.url+=((this.url.indexOf("?")>-1)?"&":"?")+d
}else{if(/Konqueror|Safari|KHTML/.test(navigator.userAgent)){d+="&_="
}}}try{var a=new OpenLayers.Ajax.Response(this);
if(this.options.onCreate){this.options.onCreate(a)
}OpenLayers.Ajax.Responders.dispatch("onCreate",this,a);
this.transport.open(this.method.toUpperCase(),this.url,this.options.asynchronous);
if(this.options.asynchronous){window.setTimeout(OpenLayers.Function.bind(this.respondToReadyState,this,1),10)
}this.transport.onreadystatechange=OpenLayers.Function.bind(this.onStateChange,this);
this.setRequestHeaders();
this.body=this.method=="post"?(this.options.postBody||d):null;
this.transport.send(this.body);
if(!this.options.asynchronous&&this.transport.overrideMimeType){this.onStateChange()
}}catch(c){this.dispatchException(c)
}},onStateChange:function(){var a=this.transport.readyState;
if(a>1&&!((a==4)&&this._complete)){this.respondToReadyState(this.transport.readyState)
}},setRequestHeaders:function(){var e={"X-Requested-With":"XMLHttpRequest",Accept:"text/javascript, text/html, application/xml, text/xml, */*",OpenLayers:true};
if(this.method=="post"){e["Content-type"]=this.options.contentType+(this.options.encoding?"; charset="+this.options.encoding:"");
if(this.transport.overrideMimeType&&(navigator.userAgent.match(/Gecko\/(\d{4})/)||[0,2005])[1]<2005){e.Connection="close"
}}if(typeof this.options.requestHeaders=="object"){var c=this.options.requestHeaders;
if(typeof c.push=="function"){for(var b=0,d=c.length;
b<d;
b+=2){e[c[b]]=c[b+1]
}}else{for(var b in c){e[b]=c[b]
}}}for(var a in e){this.transport.setRequestHeader(a,e[a])
}},success:function(){var a=this.getStatus();
return !a||(a>=200&&a<300)
},getStatus:function(){try{return this.transport.status||0
}catch(a){return 0
}},respondToReadyState:function(a){var c=OpenLayers.Ajax.Request.Events[a];
var b=new OpenLayers.Ajax.Response(this);
if(c=="Complete"){try{this._complete=true;
(this.options["on"+b.status]||this.options["on"+(this.success()?"Success":"Failure")]||OpenLayers.Ajax.emptyFunction)(b)
}catch(d){this.dispatchException(d)
}var f=b.getHeader("Content-type")
}try{(this.options["on"+c]||OpenLayers.Ajax.emptyFunction)(b);
OpenLayers.Ajax.Responders.dispatch("on"+c,this,b)
}catch(d){this.dispatchException(d)
}if(c=="Complete"){this.transport.onreadystatechange=OpenLayers.Ajax.emptyFunction
}},getHeader:function(a){try{return this.transport.getResponseHeader(a)
}catch(b){return null
}},dispatchException:function(c){var d=this.options.onException;
if(d){d(this,c);
OpenLayers.Ajax.Responders.dispatch("onException",this,c)
}else{var e=false;
var a=OpenLayers.Ajax.Responders.responders;
for(var b=0;
b<a.length;
b++){if(a[b].onException){e=true;
break
}}if(e){OpenLayers.Ajax.Responders.dispatch("onException",this,c)
}else{throw c
}}}});
OpenLayers.Ajax.Request.Events=["Uninitialized","Loading","Loaded","Interactive","Complete"];
OpenLayers.Ajax.Response=OpenLayers.Class({status:0,statusText:"",initialize:function(c){this.request=c;
var d=this.transport=c.transport,a=this.readyState=d.readyState;
if((a>2&&!(!!(window.attachEvent&&!window.opera)))||a==4){this.status=this.getStatus();
this.statusText=this.getStatusText();
this.responseText=d.responseText==null?"":String(d.responseText)
}if(a==4){var b=d.responseXML;
this.responseXML=b===undefined?null:b
}},getStatus:OpenLayers.Ajax.Request.prototype.getStatus,getStatusText:function(){try{return this.transport.statusText||""
}catch(a){return""
}},getHeader:OpenLayers.Ajax.Request.prototype.getHeader,getResponseHeader:function(a){return this.transport.getResponseHeader(a)
}});
OpenLayers.Ajax.getElementsByTagNameNS=function(b,a,c,e){var d=null;
if(b.getElementsByTagNameNS){d=b.getElementsByTagNameNS(a,e)
}else{d=b.getElementsByTagName(c+":"+e)
}return d
};
OpenLayers.Ajax.serializeXMLToString=function(a){var b=new XMLSerializer();
var c=b.serializeToString(a);
return c
};OpenLayers.LonLat=OpenLayers.Class({lon:0,lat:0,initialize:function(b,a){this.lon=OpenLayers.Util.toFloat(b);
this.lat=OpenLayers.Util.toFloat(a)
},toString:function(){return("lon="+this.lon+",lat="+this.lat)
},toShortString:function(){return(this.lon+", "+this.lat)
},clone:function(){return new OpenLayers.LonLat(this.lon,this.lat)
},add:function(c,a){if((c==null)||(a==null)){var b=OpenLayers.i18n("lonlatAddError");
OpenLayers.Console.error(b);
return null
}return new OpenLayers.LonLat(this.lon+OpenLayers.Util.toFloat(c),this.lat+OpenLayers.Util.toFloat(a))
},equals:function(b){var a=false;
if(b!=null){a=((this.lon==b.lon&&this.lat==b.lat)||(isNaN(this.lon)&&isNaN(this.lat)&&isNaN(b.lon)&&isNaN(b.lat)))
}return a
},transform:function(c,b){var a=OpenLayers.Projection.transform({x:this.lon,y:this.lat},c,b);
this.lon=a.x;
this.lat=a.y;
return this
},wrapDateLine:function(a){var b=this.clone();
if(a){while(b.lon<a.left){b.lon+=a.getWidth()
}while(b.lon>a.right){b.lon-=a.getWidth()
}}return b
},CLASS_NAME:"OpenLayers.LonLat"});
OpenLayers.LonLat.fromString=function(b){var a=b.split(",");
return new OpenLayers.LonLat(a[0],a[1])
};OpenLayers.Size=OpenLayers.Class({w:0,h:0,initialize:function(a,b){this.w=parseFloat(a);
this.h=parseFloat(b)
},toString:function(){return("w="+this.w+",h="+this.h)
},clone:function(){return new OpenLayers.Size(this.w,this.h)
},equals:function(b){var a=false;
if(b!=null){a=((this.w==b.w&&this.h==b.h)||(isNaN(this.w)&&isNaN(this.h)&&isNaN(b.w)&&isNaN(b.h)))
}return a
},CLASS_NAME:"OpenLayers.Size"});OpenLayers.Pixel=OpenLayers.Class({x:0,y:0,initialize:function(a,b){this.x=parseFloat(a);
this.y=parseFloat(b)
},toString:function(){return("x="+this.x+",y="+this.y)
},clone:function(){return new OpenLayers.Pixel(this.x,this.y)
},equals:function(a){var b=false;
if(a!=null){b=((this.x==a.x&&this.y==a.y)||(isNaN(this.x)&&isNaN(this.y)&&isNaN(a.x)&&isNaN(a.y)))
}return b
},add:function(a,c){if((a==null)||(c==null)){var b=OpenLayers.i18n("pixelAddError");
OpenLayers.Console.error(b);
return null
}return new OpenLayers.Pixel(this.x+a,this.y+c)
},offset:function(a){var b=this.clone();
if(a){b=this.add(a.x,a.y)
}return b
},CLASS_NAME:"OpenLayers.Pixel"});OpenLayers.Lang={code:null,defaultCode:"en",getCode:function(){if(!OpenLayers.Lang.code){OpenLayers.Lang.setCode()
}return OpenLayers.Lang.code
},setCode:function(b){var d;
if(!b){b=(OpenLayers.Util.getBrowserName()=="msie")?navigator.userLanguage:navigator.language
}var c=b.split("-");
c[0]=c[0].toLowerCase();
if(typeof OpenLayers.Lang[c[0]]=="object"){d=c[0]
}if(c[1]){var a=c[0]+"-"+c[1].toUpperCase();
if(typeof OpenLayers.Lang[a]=="object"){d=a
}}if(!d){OpenLayers.Console.warn("Failed to find OpenLayers.Lang."+c.join("-")+" dictionary, falling back to default language");
d=OpenLayers.Lang.defaultCode
}OpenLayers.Lang.code=d
},translate:function(b,a){var d=OpenLayers.Lang[OpenLayers.Lang.getCode()];
var c=d[b];
if(!c){c=b
}if(a){c=OpenLayers.String.format(c,a)
}return c
}};
OpenLayers.i18n=OpenLayers.Lang.translate;OpenLayers.Lang.en={unhandledRequest:"Unhandled request return ${statusText}",permalink:"Permalink",overlays:"Overlays",baseLayer:"Base Layer",sameProjection:"The overview map only works when it is in the same projection as the main map",readNotImplemented:"Read not implemented.",writeNotImplemented:"Write not implemented.",noFID:"Can't update a feature for which there is no FID.",errorLoadingGML:"Error in loading GML file ${url}",browserNotSupported:"Your browser does not support vector rendering. Currently supported renderers are:\n${renderers}",componentShouldBe:"addFeatures : component should be an ${geomType}",getFeatureError:"getFeatureFromEvent called on layer with no renderer. This usually means you destroyed a layer, but not some handler which is associated with it.",minZoomLevelError:"The minZoomLevel property is only intended for use with the FixedZoomLevels-descendent layers. That this wfs layer checks for minZoomLevel is a relic of thepast. We cannot, however, remove it without possibly breaking OL based applications that may depend on it. Therefore we are deprecating it -- the minZoomLevel check below will be removed at 3.0. Please instead use min/max resolution setting as described here: http://trac.openlayers.org/wiki/SettingZoomLevels",commitSuccess:"WFS Transaction: SUCCESS ${response}",commitFailed:"WFS Transaction: FAILED ${response}",googleWarning:"The Google Layer was unable to load correctly.<br><br>To get rid of this message, select a new BaseLayer in the layer switcher in the upper-right corner.<br><br>Most likely, this is because the Google Maps library script was either not included, or does not contain the correct API key for your site.<br><br>Developers: For help getting this working correctly, <a href='http://trac.openlayers.org/wiki/Google' target='_blank'>click here</a>",getLayerWarning:"The ${layerType} Layer was unable to load correctly.<br><br>To get rid of this message, select a new BaseLayer in the layer switcher in the upper-right corner.<br><br>Most likely, this is because the ${layerLib} library script was not correctly included.<br><br>Developers: For help getting this working correctly, <a href='http://trac.openlayers.org/wiki/${layerLib}' target='_blank'>click here</a>",scale:"Scale = 1 : ${scaleDenom}",W:"W",E:"E",N:"N",S:"S",graticule:"Graticule",layerAlreadyAdded:"You tried to add the layer: ${layerName} to the map, but it has already been added",reprojectDeprecated:"You are using the 'reproject' option on the ${layerName} layer. This option is deprecated: its use was designed to support displaying data over commercial basemaps, but that functionality should now be achieved by using Spherical Mercator support. More information is available from http://trac.openlayers.org/wiki/SphericalMercator.",methodDeprecated:"This method has been deprecated and will be removed in 3.0. Please use ${newMethod} instead.",boundsAddError:"You must pass both x and y values to the add function.",lonlatAddError:"You must pass both lon and lat values to the add function.",pixelAddError:"You must pass both x and y values to the add function.",unsupportedGeometryType:"Unsupported geometry type: ${geomType}",pagePositionFailed:"OpenLayers.Util.pagePosition failed: element with id ${elemId} may be misplaced.",filterEvaluateNotImplemented:"evaluate is not implemented for this filter type.",end:""};OpenLayers.Handler.Drag=OpenLayers.Class(OpenLayers.Handler,{started:false,stopDown:true,dragging:false,last:null,start:null,oldOnselectstart:null,interval:0,timeoutId:null,documentDrag:false,documentEvents:null,initialize:function(c,b,a){OpenLayers.Handler.prototype.initialize.apply(this,arguments)
},down:function(a){},move:function(a){},up:function(a){},out:function(a){},mousedown:function(b){var a=true;
this.dragging=false;
if(this.checkModifiers(b)&&OpenLayers.Event.isLeftClick(b)){this.started=true;
this.start=b.xy;
this.last=b.xy;
OpenLayers.Element.addClass(this.map.viewPortDiv,"olDragDown");
this.down(b);
this.callback("down",[b.xy]);
OpenLayers.Event.stop(b);
if(!this.oldOnselectstart){this.oldOnselectstart=(document.onselectstart)?document.onselectstart:OpenLayers.Function.True
}document.onselectstart=OpenLayers.Function.False;
a=!this.stopDown
}else{this.started=false;
this.start=null;
this.last=null
}return a
},mousemove:function(a){if(this.started&&!this.timeoutId&&(a.xy.x!=this.last.x||a.xy.y!=this.last.y)){if(this.documentDrag===true&&this.documentEvents){if(a.element===document){this.adjustXY(a);
this.setEvent(a)
}else{this.destroyDocumentEvents()
}}if(this.interval>0){this.timeoutId=setTimeout(OpenLayers.Function.bind(this.removeTimeout,this),this.interval)
}this.dragging=true;
this.move(a);
this.callback("move",[a.xy]);
if(!this.oldOnselectstart){this.oldOnselectstart=document.onselectstart;
document.onselectstart=OpenLayers.Function.False
}this.last=this.evt.xy
}return true
},removeTimeout:function(){this.timeoutId=null
},mouseup:function(b){if(this.started){if(this.documentDrag===true&&this.documentEvents){this.adjustXY(b);
this.destroyDocumentEvents()
}var a=(this.start!=this.last);
this.started=false;
this.dragging=false;
OpenLayers.Element.removeClass(this.map.viewPortDiv,"olDragDown");
this.up(b);
this.callback("up",[b.xy]);
if(a){this.callback("done",[b.xy])
}document.onselectstart=this.oldOnselectstart
}return true
},mouseout:function(b){if(this.started&&OpenLayers.Util.mouseLeft(b,this.map.div)){if(this.documentDrag===true){this.documentEvents=new OpenLayers.Events(this,document,null,null,{includeXY:true});
this.documentEvents.on({mousemove:this.mousemove,mouseup:this.mouseup});
OpenLayers.Element.addClass(document.body,"olDragDown")
}else{var a=(this.start!=this.last);
this.started=false;
this.dragging=false;
OpenLayers.Element.removeClass(this.map.viewPortDiv,"olDragDown");
this.out(b);
this.callback("out",[]);
if(a){this.callback("done",[b.xy])
}if(document.onselectstart){document.onselectstart=this.oldOnselectstart
}}}return true
},click:function(a){return(this.start==this.last)
},activate:function(){var a=false;
if(OpenLayers.Handler.prototype.activate.apply(this,arguments)){this.dragging=false;
a=true
}return a
},deactivate:function(){var a=false;
if(OpenLayers.Handler.prototype.deactivate.apply(this,arguments)){this.started=false;
this.dragging=false;
this.start=null;
this.last=null;
a=true;
OpenLayers.Element.removeClass(this.map.viewPortDiv,"olDragDown")
}return a
},adjustXY:function(a){var b=OpenLayers.Util.pagePosition(this.map.div);
a.xy.x-=b[0];
a.xy.y-=b[1]
},destroyDocumentEvents:function(){OpenLayers.Element.removeClass(document.body,"olDragDown");
this.documentEvents.destroy();
this.documentEvents=null
},CLASS_NAME:"OpenLayers.Handler.Drag"});OpenLayers.Handler.Box=OpenLayers.Class(OpenLayers.Handler,{dragHandler:null,boxDivClassName:"olHandlerBoxZoomBox",boxCharacteristics:null,initialize:function(c,b,a){OpenLayers.Handler.prototype.initialize.apply(this,arguments);
var b={down:this.startBox,move:this.moveBox,out:this.removeBox,up:this.endBox};
this.dragHandler=new OpenLayers.Handler.Drag(this,b,{keyMask:this.keyMask})
},destroy:function(){if(this.dragHandler){this.dragHandler.destroy();
this.dragHandler=null
}OpenLayers.Handler.prototype.destroy.apply(this,arguments)
},setMap:function(a){OpenLayers.Handler.prototype.setMap.apply(this,arguments);
if(this.dragHandler){this.dragHandler.setMap(a)
}},startBox:function(a){this.zoomBox=OpenLayers.Util.createDiv("zoomBox",this.dragHandler.start);
this.zoomBox.className=this.boxDivClassName;
this.zoomBox.style.zIndex=this.map.Z_INDEX_BASE.Popup-1;
this.map.viewPortDiv.appendChild(this.zoomBox);
OpenLayers.Element.addClass(this.map.viewPortDiv,"olDrawBox")
},moveBox:function(f){var d=this.dragHandler.start.x;
var b=this.dragHandler.start.y;
var c=Math.abs(d-f.x);
var a=Math.abs(b-f.y);
this.zoomBox.style.width=Math.max(1,c)+"px";
this.zoomBox.style.height=Math.max(1,a)+"px";
this.zoomBox.style.left=f.x<d?f.x+"px":d+"px";
this.zoomBox.style.top=f.y<b?f.y+"px":b+"px";
var e=this.getBoxCharacteristics();
if(e.newBoxModel){if(f.x>d){this.zoomBox.style.width=Math.max(1,c-e.xOffset)+"px"
}if(f.y>b){this.zoomBox.style.height=Math.max(1,a-e.yOffset)+"px"
}}},endBox:function(b){var a;
if(Math.abs(this.dragHandler.start.x-b.x)>5||Math.abs(this.dragHandler.start.y-b.y)>5){var g=this.dragHandler.start;
var f=Math.min(g.y,b.y);
var c=Math.max(g.y,b.y);
var e=Math.min(g.x,b.x);
var d=Math.max(g.x,b.x);
a=new OpenLayers.Bounds(e,c,d,f)
}else{a=this.dragHandler.start.clone()
}this.removeBox();
this.callback("done",[a])
},removeBox:function(){this.map.viewPortDiv.removeChild(this.zoomBox);
this.zoomBox=null;
this.boxCharacteristics=null;
OpenLayers.Element.removeClass(this.map.viewPortDiv,"olDrawBox")
},activate:function(){if(OpenLayers.Handler.prototype.activate.apply(this,arguments)){this.dragHandler.activate();
return true
}else{return false
}},deactivate:function(){if(OpenLayers.Handler.prototype.deactivate.apply(this,arguments)){this.dragHandler.deactivate();
return true
}else{return false
}},getBoxCharacteristics:function(){if(!this.boxCharacteristics){var a=parseInt(OpenLayers.Element.getStyle(this.zoomBox,"border-left-width"))+parseInt(OpenLayers.Element.getStyle(this.zoomBox,"border-right-width"))+1;
var c=parseInt(OpenLayers.Element.getStyle(this.zoomBox,"border-top-width"))+parseInt(OpenLayers.Element.getStyle(this.zoomBox,"border-bottom-width"))+1;
var b=OpenLayers.Util.getBrowserName()=="msie"?document.compatMode!="BackCompat":true;
this.boxCharacteristics={xOffset:a,yOffset:c,newBoxModel:b}
}return this.boxCharacteristics
},CLASS_NAME:"OpenLayers.Handler.Box"});OpenLayers.Control.ZoomBox=OpenLayers.Class(OpenLayers.Control,{type:OpenLayers.Control.TYPE_TOOL,out:false,alwaysZoom:false,draw:function(){this.handler=new OpenLayers.Handler.Box(this,{done:this.zoomBox},{keyMask:this.keyMask})
},zoomBox:function(h){if(h instanceof OpenLayers.Bounds){var b;
if(!this.out){var i=this.map.getLonLatFromPixel(new OpenLayers.Pixel(h.left,h.bottom));
var m=this.map.getLonLatFromPixel(new OpenLayers.Pixel(h.right,h.top));
b=new OpenLayers.Bounds(i.lon,i.lat,m.lon,m.lat)
}else{var g=Math.abs(h.right-h.left);
var j=Math.abs(h.top-h.bottom);
var e=Math.min((this.map.size.h/j),(this.map.size.w/g));
var n=this.map.getExtent();
var a=this.map.getLonLatFromPixel(h.getCenterPixel());
var c=a.lon-(n.getWidth()/2)*e;
var f=a.lon+(n.getWidth()/2)*e;
var l=a.lat-(n.getHeight()/2)*e;
var d=a.lat+(n.getHeight()/2)*e;
b=new OpenLayers.Bounds(c,l,f,d)
}var k=this.map.getZoom();
this.map.zoomToExtent(b);
if(k==this.map.getZoom()&&this.alwaysZoom==true){this.map.zoomTo(k+(this.out?-1:1))
}}else{if(!this.out){this.map.setCenter(this.map.getLonLatFromPixel(h),this.map.getZoom()+1)
}else{this.map.setCenter(this.map.getLonLatFromPixel(h),this.map.getZoom()-1)
}}},CLASS_NAME:"OpenLayers.Control.ZoomBox"});OpenLayers.Control.DragPan=OpenLayers.Class(OpenLayers.Control,{type:OpenLayers.Control.TYPE_TOOL,panned:false,interval:25,documentDrag:false,draw:function(){this.handler=new OpenLayers.Handler.Drag(this,{move:this.panMap,done:this.panMapDone},{interval:this.interval,documentDrag:this.documentDrag})
},panMap:function(a){this.panned=true;
this.map.pan(this.handler.last.x-a.x,this.handler.last.y-a.y,{dragging:this.handler.dragging,animate:false})
},panMapDone:function(a){if(this.panned){this.panMap(a);
this.panned=false
}},CLASS_NAME:"OpenLayers.Control.DragPan"});OpenLayers.Handler.Click=OpenLayers.Class(OpenLayers.Handler,{delay:300,single:true,"double":false,pixelTolerance:0,stopSingle:false,stopDouble:false,timerId:null,down:null,rightclickTimerId:null,initialize:function(c,b,a){OpenLayers.Handler.prototype.initialize.apply(this,arguments);
if(this.pixelTolerance!=null){this.mousedown=function(d){this.down=d.xy;
return true
}
}},mousedown:null,mouseup:function(b){var a=true;
if(this.checkModifiers(b)&&this.control.handleRightClicks&&OpenLayers.Event.isRightClick(b)){a=this.rightclick(b)
}return a
},rightclick:function(b){if(this.passesTolerance(b)){if(this.rightclickTimerId!=null){this.clearTimer();
this.callback("dblrightclick",[b]);
return !this.stopDouble
}else{var a=this["double"]?OpenLayers.Util.extend({},b):this.callback("rightclick",[b]);
var c=OpenLayers.Function.bind(this.delayedRightCall,this,a);
this.rightclickTimerId=window.setTimeout(c,this.delay)
}}return !this.stopSingle
},delayedRightCall:function(a){this.rightclickTimerId=null;
if(a){this.callback("rightclick",[a])
}return !this.stopSingle
},dblclick:function(a){if(this.passesTolerance(a)){if(this["double"]){this.callback("dblclick",[a])
}this.clearTimer()
}return !this.stopDouble
},click:function(b){if(this.passesTolerance(b)){if(this.timerId!=null){this.clearTimer()
}else{var a=this.single?OpenLayers.Util.extend({},b):null;
this.timerId=window.setTimeout(OpenLayers.Function.bind(this.delayedCall,this,a),this.delay)
}}return !this.stopSingle
},passesTolerance:function(b){var c=true;
if(this.pixelTolerance!=null&&this.down){var a=Math.sqrt(Math.pow(this.down.x-b.xy.x,2)+Math.pow(this.down.y-b.xy.y,2));
if(a>this.pixelTolerance){c=false
}}return c
},clearTimer:function(){if(this.timerId!=null){window.clearTimeout(this.timerId);
this.timerId=null
}if(this.rightclickTimerId!=null){window.clearTimeout(this.rightclickTimerId);
this.rightclickTimerId=null
}},delayedCall:function(a){this.timerId=null;
if(a){this.callback("click",[a])
}},deactivate:function(){var a=false;
if(OpenLayers.Handler.prototype.deactivate.apply(this,arguments)){this.clearTimer();
this.down=null;
a=true
}return a
},CLASS_NAME:"OpenLayers.Handler.Click"});OpenLayers.Control.Navigation=OpenLayers.Class(OpenLayers.Control,{dragPan:null,dragPanOptions:null,documentDrag:false,zoomBox:null,zoomBoxEnabled:true,zoomWheelEnabled:true,mouseWheelOptions:null,handleRightClicks:false,zoomBoxKeyMask:OpenLayers.Handler.MOD_SHIFT,autoActivate:true,initialize:function(a){this.handlers={};
OpenLayers.Control.prototype.initialize.apply(this,arguments)
},destroy:function(){this.deactivate();
if(this.dragPan){this.dragPan.destroy()
}this.dragPan=null;
if(this.zoomBox){this.zoomBox.destroy()
}this.zoomBox=null;
OpenLayers.Control.prototype.destroy.apply(this,arguments)
},activate:function(){this.dragPan.activate();
if(this.zoomWheelEnabled){this.handlers.wheel.activate()
}this.handlers.click.activate();
if(this.zoomBoxEnabled){this.zoomBox.activate()
}return OpenLayers.Control.prototype.activate.apply(this,arguments)
},deactivate:function(){this.zoomBox.deactivate();
this.dragPan.deactivate();
this.handlers.click.deactivate();
this.handlers.wheel.deactivate();
return OpenLayers.Control.prototype.deactivate.apply(this,arguments)
},draw:function(){if(this.handleRightClicks){this.map.viewPortDiv.oncontextmenu=OpenLayers.Function.False
}var a={dblclick:this.defaultDblClick,dblrightclick:this.defaultDblRightClick};
var b={"double":true,stopDouble:true};
this.handlers.click=new OpenLayers.Handler.Click(this,a,b);
this.dragPan=new OpenLayers.Control.DragPan(OpenLayers.Util.extend({map:this.map,documentDrag:this.documentDrag},this.dragPanOptions));
this.zoomBox=new OpenLayers.Control.ZoomBox({map:this.map,keyMask:this.zoomBoxKeyMask});
this.dragPan.draw();
this.zoomBox.draw();
this.handlers.wheel=new OpenLayers.Handler.MouseWheel(this,{up:this.wheelUp,down:this.wheelDown},this.mouseWheelOptions)
},defaultDblClick:function(b){var a=this.map.getLonLatFromViewPortPx(b.xy);
this.map.setCenter(a,this.map.zoom+1)
},defaultDblRightClick:function(b){var a=this.map.getLonLatFromViewPortPx(b.xy);
this.map.setCenter(a,this.map.zoom-1)
},wheelChange:function(i,c){var h=this.map.getZoom();
var f=this.map.getZoom()+Math.round(c);
f=Math.max(f,0);
f=Math.min(f,this.map.getNumZoomLevels());
if(f===h){return
}var j=this.map.getSize();
var e=j.w/2-i.xy.x;
var d=i.xy.y-j.h/2;
var g=this.map.baseLayer.getResolutionForZoom(f);
var a=this.map.getLonLatFromPixel(i.xy);
var b=new OpenLayers.LonLat(a.lon+e*g,a.lat+d*g);
this.map.setCenter(b,f)
},wheelUp:function(a,b){this.wheelChange(a,b||1)
},wheelDown:function(a,b){this.wheelChange(a,b||-1)
},disableZoomBox:function(){this.zoomBoxEnabled=false;
this.zoomBox.deactivate()
},enableZoomBox:function(){this.zoomBoxEnabled=true;
if(this.active){this.zoomBox.activate()
}},disableZoomWheel:function(){this.zoomWheelEnabled=false;
this.handlers.wheel.deactivate()
},enableZoomWheel:function(){this.zoomWheelEnabled=true;
if(this.active){this.handlers.wheel.activate()
}},CLASS_NAME:"OpenLayers.Control.Navigation"});OpenLayers.Layer.HTTPRequest=OpenLayers.Class(OpenLayers.Layer,{URL_HASH_FACTOR:(Math.sqrt(5)-1)/2,url:null,params:null,reproject:false,initialize:function(d,c,e,b){var a=arguments;
a=[d,b];
OpenLayers.Layer.prototype.initialize.apply(this,a);
this.url=c;
this.params=OpenLayers.Util.extend({},e)
},destroy:function(){this.url=null;
this.params=null;
OpenLayers.Layer.prototype.destroy.apply(this,arguments)
},clone:function(a){if(a==null){a=new OpenLayers.Layer.HTTPRequest(this.name,this.url,this.params,this.getOptions())
}a=OpenLayers.Layer.prototype.clone.apply(this,[a]);
return a
},setUrl:function(a){this.url=a
},mergeNewParams:function(b){this.params=OpenLayers.Util.extend(this.params,b);
var a=this.redraw();
if(this.map!=null){this.map.events.triggerEvent("changelayer",{layer:this,property:"params"})
}return a
},redraw:function(a){if(a){return this.mergeNewParams({_olSalt:Math.random()})
}else{return OpenLayers.Layer.prototype.redraw.apply(this,[])
}},selectUrl:function(e,d){var c=1;
for(var b=0,a=e.length;
b<a;
b++){c*=e.charCodeAt(b)*this.URL_HASH_FACTOR;
c-=Math.floor(c)
}return d[Math.floor(c*d.length)]
},getFullRequestString:function(g,d){var b=d||this.url;
var f=OpenLayers.Util.extend({},this.params);
f=OpenLayers.Util.extend(f,g);
var e=OpenLayers.Util.getParameterString(f);
if(b instanceof Array){b=this.selectUrl(e,b)
}var a=OpenLayers.Util.upperCaseObject(OpenLayers.Util.getParameters(b));
for(var c in f){if(c.toUpperCase() in a){delete f[c]
}}e=OpenLayers.Util.getParameterString(f);
return OpenLayers.Util.urlAppend(b,e)
},CLASS_NAME:"OpenLayers.Layer.HTTPRequest"});OpenLayers.Layer.Grid=OpenLayers.Class(OpenLayers.Layer.HTTPRequest,{tileSize:null,grid:null,singleTile:false,ratio:1.5,buffer:2,numLoadingTiles:0,initialize:function(c,b,d,a){OpenLayers.Layer.HTTPRequest.prototype.initialize.apply(this,arguments);
this.events.addEventType("tileloaded");
this.grid=[]
},destroy:function(){this.clearGrid();
this.grid=null;
this.tileSize=null;
OpenLayers.Layer.HTTPRequest.prototype.destroy.apply(this,arguments)
},clearGrid:function(){if(this.grid){for(var f=0,b=this.grid.length;
f<b;
f++){var e=this.grid[f];
for(var c=0,a=e.length;
c<a;
c++){var d=e[c];
this.removeTileMonitoringHooks(d);
d.destroy()
}}this.grid=[]
}},clone:function(a){if(a==null){a=new OpenLayers.Layer.Grid(this.name,this.url,this.params,this.getOptions())
}a=OpenLayers.Layer.HTTPRequest.prototype.clone.apply(this,[a]);
if(this.tileSize!=null){a.tileSize=this.tileSize.clone()
}a.grid=[];
return a
},moveTo:function(d,a,e){OpenLayers.Layer.HTTPRequest.prototype.moveTo.apply(this,arguments);
d=d||this.map.getExtent();
if(d!=null){var c=!this.grid.length||a;
var b=this.getTilesBounds();
if(this.singleTile){if(c||(!e&&!b.containsBounds(d))){this.initSingleTile(d)
}}else{if(c||!b.containsBounds(d,true)){this.initGriddedTiles(d)
}else{this.moveGriddedTiles(d)
}}}},setTileSize:function(a){if(this.singleTile){a=this.map.getSize();
a.h=parseInt(a.h*this.ratio);
a.w=parseInt(a.w*this.ratio)
}OpenLayers.Layer.HTTPRequest.prototype.setTileSize.apply(this,[a])
},getGridBounds:function(){var a="The getGridBounds() function is deprecated. It will be removed in 3.0. Please use getTilesBounds() instead.";
OpenLayers.Console.warn(a);
return this.getTilesBounds()
},getTilesBounds:function(){var e=null;
if(this.grid.length){var a=this.grid.length-1;
var d=this.grid[a][0];
var b=this.grid[0].length-1;
var c=this.grid[0][b];
e=new OpenLayers.Bounds(d.bounds.left,d.bounds.bottom,c.bounds.right,c.bounds.top)
}return e
},initSingleTile:function(f){var a=f.getCenterLonLat();
var h=f.getWidth()*this.ratio;
var b=f.getHeight()*this.ratio;
var g=new OpenLayers.Bounds(a.lon-(h/2),a.lat-(b/2),a.lon+(h/2),a.lat+(b/2));
var d=new OpenLayers.LonLat(g.left,g.top);
var c=this.map.getLayerPxFromLonLat(d);
if(!this.grid.length){this.grid[0]=[]
}var e=this.grid[0][0];
if(!e){e=this.addTile(g,c);
this.addTileMonitoringHooks(e);
e.draw();
this.grid[0][0]=e
}else{e.moveTo(g,c)
}this.removeExcessTiles(1,1)
},calculateGridLayout:function(a,o,e){var k=e*this.tileSize.w;
var c=e*this.tileSize.h;
var i=a.left-o.left;
var l=Math.floor(i/k)-this.buffer;
var j=i/k-l;
var f=-j*this.tileSize.w;
var m=o.left+l*k;
var b=a.top-(o.bottom+c);
var h=Math.ceil(b/c)+this.buffer;
var n=h-b/c;
var d=-n*this.tileSize.h;
var g=o.bottom+h*c;
return{tilelon:k,tilelat:c,tileoffsetlon:m,tileoffsetlat:g,tileoffsetx:f,tileoffsety:d}
},initGriddedTiles:function(i){var g=this.map.getSize();
var v=Math.ceil(g.h/this.tileSize.h)+Math.max(1,2*this.buffer);
var z=Math.ceil(g.w/this.tileSize.w)+Math.max(1,2*this.buffer);
var o=this.getMaxExtent();
var r=this.map.getResolution();
var q=this.calculateGridLayout(i,o,r);
var f=Math.round(q.tileoffsetx);
var c=Math.round(q.tileoffsety);
var k=q.tileoffsetlon;
var n=q.tileoffsetlat;
var e=q.tilelon;
var j=q.tilelat;
this.origin=new OpenLayers.Pixel(f,c);
var u=f;
var w=k;
var t=0;
var a=parseInt(this.map.layerContainerDiv.style.left);
var s=parseInt(this.map.layerContainerDiv.style.top);
do{var h=this.grid[t++];
if(!h){h=[];
this.grid.push(h)
}k=w;
f=u;
var d=0;
do{var b=new OpenLayers.Bounds(k,n,k+e,n+j);
var m=f;
m-=a;
var l=c;
l-=s;
var p=new OpenLayers.Pixel(m,l);
var A=h[d++];
if(!A){A=this.addTile(b,p);
this.addTileMonitoringHooks(A);
h.push(A)
}else{A.moveTo(b,p,false)
}k+=e;
f+=this.tileSize.w
}while((k<=i.right+e*this.buffer)||d<z);
n-=j;
c+=this.tileSize.h
}while((n>=i.bottom-j*this.buffer)||t<v);
this.removeExcessTiles(t,d);
this.spiralTileLoad()
},getMaxExtent:function(){return this.maxExtent
},spiralTileLoad:function(){var b=[];
var h=["right","down","left","up"];
var g=0;
var a=-1;
var k=OpenLayers.Util.indexOf(h,"right");
var l=0;
while(l<h.length){var j=g;
var c=a;
switch(h[k]){case"right":c++;
break;
case"down":j++;
break;
case"left":c--;
break;
case"up":j--;
break
}var f=null;
if((j<this.grid.length)&&(j>=0)&&(c<this.grid[0].length)&&(c>=0)){f=this.grid[j][c]
}if((f!=null)&&(!f.queued)){b.unshift(f);
f.queued=true;
l=0;
g=j;
a=c
}else{k=(k+1)%4;
l++
}}for(var d=0,e=b.length;
d<e;
d++){var f=b[d];
f.draw();
f.queued=false
}},addTile:function(b,a){},addTileMonitoringHooks:function(a){a.onLoadStart=function(){if(this.numLoadingTiles==0){this.events.triggerEvent("loadstart")
}this.numLoadingTiles++
};
a.events.register("loadstart",this,a.onLoadStart);
a.onLoadEnd=function(){this.numLoadingTiles--;
this.events.triggerEvent("tileloaded");
if(this.numLoadingTiles==0){this.events.triggerEvent("loadend")
}};
a.events.register("loadend",this,a.onLoadEnd);
a.events.register("unload",this,a.onLoadEnd)
},removeTileMonitoringHooks:function(a){a.unload();
a.events.un({loadstart:a.onLoadStart,loadend:a.onLoadEnd,unload:a.onLoadEnd,scope:this})
},moveGriddedTiles:function(c){var b=this.buffer||1;
while(true){var a=this.grid[0][0].position;
var d=this.map.getViewPortPxFromLayerPx(a);
if(d.x>-this.tileSize.w*(b-1)){this.shiftColumn(true)
}else{if(d.x<-this.tileSize.w*b){this.shiftColumn(false)
}else{if(d.y>-this.tileSize.h*(b-1)){this.shiftRow(true)
}else{if(d.y<-this.tileSize.h*b){this.shiftRow(false)
}else{break
}}}}}},shiftRow:function(n){var c=(n)?0:(this.grid.length-1);
var b=this.grid;
var f=b[c];
var e=this.map.getResolution();
var h=(n)?-this.tileSize.h:this.tileSize.h;
var g=e*-h;
var m=(n)?b.pop():b.shift();
for(var j=0,l=f.length;
j<l;
j++){var d=f[j];
var a=d.bounds.clone();
var k=d.position.clone();
a.bottom=a.bottom+g;
a.top=a.top+g;
k.y=k.y+h;
m[j].moveTo(a,k)
}if(n){b.unshift(m)
}else{b.push(m)
}},shiftColumn:function(m){var d=(m)?-this.tileSize.w:this.tileSize.w;
var c=this.map.getResolution();
var k=c*d;
for(var e=0,g=this.grid.length;
e<g;
e++){var l=this.grid[e];
var j=(m)?0:(l.length-1);
var b=l[j];
var a=b.bounds.clone();
var f=b.position.clone();
a.left=a.left+k;
a.right=a.right+k;
f.x=f.x+d;
var h=m?this.grid[e].pop():this.grid[e].shift();
h.moveTo(a,f);
if(m){l.unshift(h)
}else{l.push(h)
}}},removeExcessTiles:function(e,c){while(this.grid.length>e){var f=this.grid.pop();
for(var b=0,a=f.length;
b<a;
b++){var d=f[b];
this.removeTileMonitoringHooks(d);
d.destroy()
}}while(this.grid[0].length>c){for(var b=0,a=this.grid.length;
b<a;
b++){var f=this.grid[b];
var d=f.pop();
this.removeTileMonitoringHooks(d);
d.destroy()
}}},onMapResize:function(){if(this.singleTile){this.clearGrid();
this.setTileSize()
}},getTileBounds:function(d){var c=this.maxExtent;
var f=this.getResolution();
var e=f*this.tileSize.w;
var b=f*this.tileSize.h;
var h=this.getLonLatFromViewPortPx(d);
var a=c.left+(e*Math.floor((h.lon-c.left)/e));
var g=c.bottom+(b*Math.floor((h.lat-c.bottom)/b));
return new OpenLayers.Bounds(a,g,a+e,g+b)
},CLASS_NAME:"OpenLayers.Layer.Grid"});OpenLayers.Layer.WMS=OpenLayers.Class(OpenLayers.Layer.Grid,{DEFAULT_PARAMS:{service:"WMS",version:"1.1.1",request:"GetMap",styles:"",exceptions:"application/vnd.ogc.se_inimage",format:"image/jpeg"},reproject:false,isBaseLayer:true,encodeBBOX:false,noMagic:false,yx:{"EPSG:4326":true},initialize:function(d,c,e,b){var a=[];
e=OpenLayers.Util.upperCaseObject(e);
if(parseFloat(e.VERSION)>=1.3&&!e.EXCEPTIONS){e.EXCEPTIONS="INIMAGE"
}a.push(d,c,e,b);
OpenLayers.Layer.Grid.prototype.initialize.apply(this,a);
OpenLayers.Util.applyDefaults(this.params,OpenLayers.Util.upperCaseObject(this.DEFAULT_PARAMS));
if(!this.noMagic&&this.params.TRANSPARENT&&this.params.TRANSPARENT.toString().toLowerCase()=="true"){if((b==null)||(!b.isBaseLayer)){this.isBaseLayer=false
}if(this.params.FORMAT=="image/jpeg"){this.params.FORMAT=OpenLayers.Util.alphaHack()?"image/gif":"image/png"
}}},destroy:function(){OpenLayers.Layer.Grid.prototype.destroy.apply(this,arguments)
},clone:function(a){if(a==null){a=new OpenLayers.Layer.WMS(this.name,this.url,this.params,this.getOptions())
}a=OpenLayers.Layer.Grid.prototype.clone.apply(this,[a]);
return a
},reverseAxisOrder:function(){return(parseFloat(this.params.VERSION)>=1.3&&!!this.yx[this.map.getProjectionObject().getCode()])
},getURL:function(c){c=this.adjustBounds(c);
var d=this.getImageSize();
var e={};
var b=this.reverseAxisOrder();
e.BBOX=this.encodeBBOX?c.toBBOX(null,b):c.toArray(b);
e.WIDTH=d.w;
e.HEIGHT=d.h;
var a=this.getFullRequestString(e);
return a
},addTile:function(b,a){return new OpenLayers.Tile.Image(this,a,b,null,this.tileSize)
},mergeNewParams:function(c){var b=OpenLayers.Util.upperCaseObject(c);
var a=[b];
return OpenLayers.Layer.Grid.prototype.mergeNewParams.apply(this,a)
},getFullRequestString:function(d,b){var a=this.map.getProjection();
var c=(a=="none")?null:a;
if(parseFloat(this.params.VERSION)>=1.3){this.params.CRS=c
}else{this.params.SRS=c
}return OpenLayers.Layer.Grid.prototype.getFullRequestString.apply(this,arguments)
},CLASS_NAME:"OpenLayers.Layer.WMS"});Ext.namespace("GeoExt.data");
GeoExt.data.LayerRecord=Ext.data.Record.create([{name:"layer"},{name:"title",type:"string",mapping:"name"}]);
GeoExt.data.LayerRecord.prototype.clone=function(b){var a=this.get("layer")&&this.get("layer").clone();
return new this.constructor(Ext.applyIf({layer:a},this.data),b||a.id)
};
GeoExt.data.LayerRecord.create=function(e){var c=Ext.extend(GeoExt.data.LayerRecord,{});
var d=c.prototype;
d.fields=new Ext.util.MixedCollection(false,function(f){return f.name
});
GeoExt.data.LayerRecord.prototype.fields.each(function(g){d.fields.add(g)
});
if(e){for(var b=0,a=e.length;
b<a;
b++){d.fields.add(new Ext.data.Field(e[b]))
}}c.getField=function(f){return d.fields.get(f)
};
return c
};OpenLayers.Renderer.SVG=OpenLayers.Class(OpenLayers.Renderer.Elements,{xmlns:"http://www.w3.org/2000/svg",xlinkns:"http://www.w3.org/1999/xlink",MAX_PIXEL:15000,translationParameters:null,symbolMetrics:null,isGecko:null,supportUse:null,initialize:function(a){if(!this.supported()){return
}OpenLayers.Renderer.Elements.prototype.initialize.apply(this,arguments);
this.translationParameters={x:0,y:0};
this.supportUse=(navigator.userAgent.toLowerCase().indexOf("applewebkit/5")==-1);
this.isGecko=(navigator.userAgent.toLowerCase().indexOf("gecko/")!=-1);
this.symbolMetrics={}
},destroy:function(){OpenLayers.Renderer.Elements.prototype.destroy.apply(this,arguments)
},supported:function(){var a="http://www.w3.org/TR/SVG11/feature#";
return(document.implementation&&(document.implementation.hasFeature("org.w3c.svg","1.0")||document.implementation.hasFeature(a+"SVG","1.1")||document.implementation.hasFeature(a+"BasicStructure","1.1")))
},inValidRange:function(a,e,b){var d=a+(b?0:this.translationParameters.x);
var c=e+(b?0:this.translationParameters.y);
return(d>=-this.MAX_PIXEL&&d<=this.MAX_PIXEL&&c>=-this.MAX_PIXEL&&c<=this.MAX_PIXEL)
},setExtent:function(b,d){OpenLayers.Renderer.Elements.prototype.setExtent.apply(this,arguments);
var a=this.getResolution();
var f=-b.left/a;
var e=b.top/a;
if(d){this.left=f;
this.top=e;
var c="0 0 "+this.size.w+" "+this.size.h;
this.rendererRoot.setAttributeNS(null,"viewBox",c);
this.translate(0,0);
return true
}else{var g=this.translate(f-this.left,e-this.top);
if(!g){this.setExtent(b,true)
}return g
}},translate:function(a,c){if(!this.inValidRange(a,c,true)){return false
}else{var b="";
if(a||c){b="translate("+a+","+c+")"
}this.root.setAttributeNS(null,"transform",b);
this.translationParameters={x:a,y:c};
return true
}},setSize:function(a){OpenLayers.Renderer.prototype.setSize.apply(this,arguments);
this.rendererRoot.setAttributeNS(null,"width",this.size.w);
this.rendererRoot.setAttributeNS(null,"height",this.size.h)
},getNodeType:function(c,b){var a=null;
switch(c.CLASS_NAME){case"OpenLayers.Geometry.Point":if(b.externalGraphic){a="image"
}else{if(this.isComplexSymbol(b.graphicName)){a=this.supportUse===false?"svg":"use"
}else{a="circle"
}}break;
case"OpenLayers.Geometry.Rectangle":a="rect";
break;
case"OpenLayers.Geometry.LineString":a="polyline";
break;
case"OpenLayers.Geometry.LinearRing":a="polygon";
break;
case"OpenLayers.Geometry.Polygon":case"OpenLayers.Geometry.Curve":case"OpenLayers.Geometry.Surface":a="path";
break;
default:break
}return a
},setStyle:function(o,s,b){s=s||o._style;
b=b||o._options;
var j=parseFloat(o.getAttributeNS(null,"r"));
var i=1;
var d;
if(o._geometryClass=="OpenLayers.Geometry.Point"&&j){o.style.visibility="";
if(s.graphic===false){o.style.visibility="hidden"
}else{if(s.externalGraphic){d=this.getPosition(o);
if(s.graphicTitle){o.setAttributeNS(null,"title",s.graphicTitle)
}if(s.graphicWidth&&s.graphicHeight){o.setAttributeNS(null,"preserveAspectRatio","none")
}var n=s.graphicWidth||s.graphicHeight;
var l=s.graphicHeight||s.graphicWidth;
n=n?n:s.pointRadius*2;
l=l?l:s.pointRadius*2;
var t=(s.graphicXOffset!=undefined)?s.graphicXOffset:-(0.5*n);
var f=(s.graphicYOffset!=undefined)?s.graphicYOffset:-(0.5*l);
var a=s.graphicOpacity||s.fillOpacity;
o.setAttributeNS(null,"x",(d.x+t).toFixed());
o.setAttributeNS(null,"y",(d.y+f).toFixed());
o.setAttributeNS(null,"width",n);
o.setAttributeNS(null,"height",l);
o.setAttributeNS(this.xlinkns,"href",s.externalGraphic);
o.setAttributeNS(null,"style","opacity: "+a)
}else{if(this.isComplexSymbol(s.graphicName)){var c=s.pointRadius*3;
var k=c*2;
var m=this.importSymbol(s.graphicName);
d=this.getPosition(o);
i=this.symbolMetrics[m][0]*3/k;
var g=o.parentNode;
var h=o.nextSibling;
if(g){g.removeChild(o)
}if(this.supportUse===false){var e=document.getElementById(m);
o.firstChild&&o.removeChild(o.firstChild);
o.appendChild(e.firstChild.cloneNode(true));
o.setAttributeNS(null,"viewBox",e.getAttributeNS(null,"viewBox"))
}else{o.setAttributeNS(this.xlinkns,"href","#"+m)
}o.setAttributeNS(null,"width",k);
o.setAttributeNS(null,"height",k);
o.setAttributeNS(null,"x",d.x-c);
o.setAttributeNS(null,"y",d.y-c);
if(h){g.insertBefore(o,h)
}else{if(g){g.appendChild(o)
}}}else{o.setAttributeNS(null,"r",s.pointRadius)
}}}var q=s.rotation;
if((q!==undefined||o._rotation!==undefined)&&d){o._rotation=q;
q|=0;
if(o.nodeName!=="svg"){o.setAttributeNS(null,"transform","rotate("+q+" "+d.x+" "+d.y+")")
}else{var p=this.symbolMetrics[m];
o.firstChild.setAttributeNS(null,"transform","rotate("+s.rotation+" "+p[1]+" "+p[2]+")")
}}}if(b.isFilled){o.setAttributeNS(null,"fill",s.fillColor);
o.setAttributeNS(null,"fill-opacity",s.fillOpacity)
}else{o.setAttributeNS(null,"fill","none")
}if(b.isStroked){o.setAttributeNS(null,"stroke",s.strokeColor);
o.setAttributeNS(null,"stroke-opacity",s.strokeOpacity);
o.setAttributeNS(null,"stroke-width",s.strokeWidth*i);
o.setAttributeNS(null,"stroke-linecap",s.strokeLinecap||"round");
o.setAttributeNS(null,"stroke-linejoin","round");
s.strokeDashstyle&&o.setAttributeNS(null,"stroke-dasharray",this.dashStyle(s,i))
}else{o.setAttributeNS(null,"stroke","none")
}if(s.pointerEvents){o.setAttributeNS(null,"pointer-events",s.pointerEvents)
}if(s.cursor!=null){o.setAttributeNS(null,"cursor",s.cursor)
}return o
},dashStyle:function(c,b){var a=c.strokeWidth*b;
var d=c.strokeDashstyle;
switch(d){case"solid":return"none";
case"dot":return[1,4*a].join();
case"dash":return[4*a,4*a].join();
case"dashdot":return[4*a,4*a,1,4*a].join();
case"longdash":return[8*a,4*a].join();
case"longdashdot":return[8*a,4*a,1,4*a].join();
default:return OpenLayers.String.trim(d).replace(/\s+/g,",")
}},createNode:function(a,c){var b=document.createElementNS(this.xmlns,a);
if(c){b.setAttributeNS(null,"id",c)
}return b
},nodeTypeCompare:function(b,a){return(a==b.nodeName)
},createRenderRoot:function(){return this.nodeFactory(this.container.id+"_svgRoot","svg")
},createRoot:function(a){return this.nodeFactory(this.container.id+a,"g")
},createDefs:function(){var a=this.nodeFactory(this.container.id+"_defs","defs");
this.rendererRoot.appendChild(a);
return a
},drawPoint:function(a,b){return this.drawCircle(a,b,1)
},drawCircle:function(d,e,b){var c=this.getResolution();
var a=(e.x/c+this.left);
var f=(this.top-e.y/c);
if(this.inValidRange(a,f)){d.setAttributeNS(null,"cx",a);
d.setAttributeNS(null,"cy",f);
d.setAttributeNS(null,"r",b);
return d
}else{return false
}},drawLineString:function(b,c){var a=this.getComponentsString(c.components);
if(a.path){b.setAttributeNS(null,"points",a.path);
return(a.complete?b:null)
}else{return false
}},drawLinearRing:function(b,c){var a=this.getComponentsString(c.components);
if(a.path){b.setAttributeNS(null,"points",a.path);
return(a.complete?b:null)
}else{return false
}},drawPolygon:function(b,h){var g="";
var i=true;
var a=true;
var c,k;
for(var e=0,f=h.components.length;
e<f;
e++){g+=" M";
c=this.getComponentsString(h.components[e].components," ");
k=c.path;
if(k){g+=" "+k;
a=c.complete&&a
}else{i=false
}}g+=" z";
if(i){b.setAttributeNS(null,"d",g);
b.setAttributeNS(null,"fill-rule","evenodd");
return a?b:null
}else{return false
}},drawRectangle:function(c,d){var b=this.getResolution();
var a=(d.x/b+this.left);
var e=(this.top-d.y/b);
if(this.inValidRange(a,e)){c.setAttributeNS(null,"x",a);
c.setAttributeNS(null,"y",e);
c.setAttributeNS(null,"width",d.width/b);
c.setAttributeNS(null,"height",d.height/b);
return c
}else{return false
}},drawSurface:function(f,h){var g=null;
var b=true;
for(var e=0,a=h.components.length;
e<a;
e++){if((e%3)==0&&(e/3)==0){var c=this.getShortString(h.components[e]);
if(!c){b=false
}g="M "+c
}else{if((e%3)==1){var c=this.getShortString(h.components[e]);
if(!c){b=false
}g+=" C "+c
}else{var c=this.getShortString(h.components[e]);
if(!c){b=false
}g+=" "+c
}}}g+=" Z";
if(b){f.setAttributeNS(null,"d",g);
return f
}else{return false
}},drawText:function(c,a,i){var b=this.getResolution();
var h=(i.x/b+this.left);
var e=(i.y/b-this.top);
var g=this.nodeFactory(c+this.LABEL_ID_SUFFIX,"text");
var f=this.nodeFactory(c+this.LABEL_ID_SUFFIX+"_tspan","tspan");
g.setAttributeNS(null,"x",h);
g.setAttributeNS(null,"y",-e);
if(a.fontColor){g.setAttributeNS(null,"fill",a.fontColor)
}if(a.fontOpacity){g.setAttributeNS(null,"opacity",a.fontOpacity)
}if(a.fontFamily){g.setAttributeNS(null,"font-family",a.fontFamily)
}if(a.fontSize){g.setAttributeNS(null,"font-size",a.fontSize)
}if(a.fontWeight){g.setAttributeNS(null,"font-weight",a.fontWeight)
}if(a.labelSelect===true){g.setAttributeNS(null,"pointer-events","visible");
g._featureId=c;
f._featureId=c;
f._geometry=i;
f._geometryClass=i.CLASS_NAME
}else{g.setAttributeNS(null,"pointer-events","none")
}var d=a.labelAlign||"cm";
g.setAttributeNS(null,"text-anchor",OpenLayers.Renderer.SVG.LABEL_ALIGN[d[0]]||"middle");
if(this.isGecko){g.setAttributeNS(null,"dominant-baseline",OpenLayers.Renderer.SVG.LABEL_ALIGN[d[1]]||"central")
}else{f.setAttributeNS(null,"baseline-shift",OpenLayers.Renderer.SVG.LABEL_VSHIFT[d[1]]||"-35%")
}f.textContent=a.label;
if(!g.parentNode){g.appendChild(f);
this.textRoot.appendChild(g)
}},getComponentsString:function(d,c){var f=[];
var a=true;
var e=d.length;
var j=[];
var g,h;
for(var b=0;
b<e;
b++){h=d[b];
f.push(h);
g=this.getShortString(h);
if(g){j.push(g)
}else{if(b>0){if(this.getShortString(d[b-1])){j.push(this.clipLine(d[b],d[b-1]))
}}if(b<e-1){if(this.getShortString(d[b+1])){j.push(this.clipLine(d[b],d[b+1]))
}}a=false
}}return{path:j.join(c||","),complete:a}
},clipLine:function(e,h){if(h.equals(e)){return""
}var f=this.getResolution();
var b=this.MAX_PIXEL-this.translationParameters.x;
var a=this.MAX_PIXEL-this.translationParameters.y;
var d=h.x/f+this.left;
var j=this.top-h.y/f;
var c=e.x/f+this.left;
var i=this.top-e.y/f;
var g;
if(c<-b||c>b){g=(i-j)/(c-d);
c=c<0?-b:b;
i=j+(c-d)*g
}if(i<-a||i>a){g=(c-d)/(i-j);
i=i<0?-a:a;
c=d+(i-j)*g
}return c+","+i
},getShortString:function(b){var c=this.getResolution();
var a=(b.x/c+this.left);
var d=(this.top-b.y/c);
if(this.inValidRange(a,d)){return a+","+d
}else{return false
}},getPosition:function(a){return({x:parseFloat(a.getAttributeNS(null,"cx")),y:parseFloat(a.getAttributeNS(null,"cy"))})
},importSymbol:function(e){if(!this.defs){this.defs=this.createDefs()
}var b=this.container.id+"-"+e;
if(document.getElementById(b)!=null){return b
}var d=OpenLayers.Renderer.symbol[e];
if(!d){throw new Error(e+" is not a valid symbol name")
}var g=this.nodeFactory(b,"symbol");
var c=this.nodeFactory(null,"polygon");
g.appendChild(c);
var m=new OpenLayers.Bounds(Number.MAX_VALUE,Number.MAX_VALUE,0,0);
var k=[];
var j,h;
for(var f=0;
f<d.length;
f=f+2){j=d[f];
h=d[f+1];
m.left=Math.min(m.left,j);
m.bottom=Math.min(m.bottom,h);
m.right=Math.max(m.right,j);
m.top=Math.max(m.top,h);
k.push(j,",",h)
}c.setAttributeNS(null,"points",k.join(" "));
var a=m.getWidth();
var l=m.getHeight();
var n=[m.left-a,m.bottom-l,a*3,l*3];
g.setAttributeNS(null,"viewBox",n.join(" "));
this.symbolMetrics[b]=[Math.max(a,l),m.getCenterLonLat().lon,m.getCenterLonLat().lat];
this.defs.appendChild(g);
return g.id
},getFeatureIdFromEvent:function(a){var c=OpenLayers.Renderer.Elements.prototype.getFeatureIdFromEvent.apply(this,arguments);
if(this.supportUse===false&&!c){var b=a.target;
c=b.parentNode&&b!=this.rendererRoot&&b.parentNode._featureId
}return c
},CLASS_NAME:"OpenLayers.Renderer.SVG"});
OpenLayers.Renderer.SVG.LABEL_ALIGN={l:"start",r:"end",b:"bottom",t:"hanging"};
OpenLayers.Renderer.SVG.LABEL_VSHIFT={t:"-70%",b:"0"};OpenLayers.Layer.TileCache=OpenLayers.Class(OpenLayers.Layer.Grid,{isBaseLayer:true,format:"image/png",serverResolutions:null,initialize:function(c,b,d,a){this.layername=d;
OpenLayers.Layer.Grid.prototype.initialize.apply(this,[c,b,{},a]);
this.extension=this.format.split("/")[1].toLowerCase();
this.extension=(this.extension=="jpg")?"jpeg":this.extension
},clone:function(a){if(a==null){a=new OpenLayers.Layer.TileCache(this.name,this.url,this.layername,this.getOptions())
}a=OpenLayers.Layer.Grid.prototype.clone.apply(this,[a]);
return a
},getURL:function(b){var f=this.map.getResolution();
var g=this.maxExtent;
var k=this.tileSize;
var a=Math.round((b.left-g.left)/(f*k.w));
var j=Math.round((b.bottom-g.bottom)/(f*k.h));
var h=this.serverResolutions!=null?OpenLayers.Util.indexOf(this.serverResolutions,f):this.map.getZoom();
function e(o,n){o=String(o);
var l=[];
for(var m=0;
m<n;
++m){l.push("0")
}return l.join("").substring(0,n-o.length)+o
}var d=[this.layername,e(h,2),e(parseInt(a/1000000),3),e((parseInt(a/1000)%1000),3),e((parseInt(a)%1000),3),e(parseInt(j/1000000),3),e((parseInt(j/1000)%1000),3),e((parseInt(j)%1000),3)+"."+this.extension];
var i=d.join("/");
var c=this.url;
if(c instanceof Array){c=this.selectUrl(i,c)
}c=(c.charAt(c.length-1)=="/")?c:c+"/";
return c+i
},addTile:function(c,a){var b=this.getURL(c);
return new OpenLayers.Tile.Image(this,a,c,b,this.tileSize)
},CLASS_NAME:"OpenLayers.Layer.TileCache"});OpenLayers.Control.Button=OpenLayers.Class(OpenLayers.Control,{type:OpenLayers.Control.TYPE_BUTTON,trigger:function(){},CLASS_NAME:"OpenLayers.Control.Button"});OpenLayers.Format.GML.v2=OpenLayers.Class(OpenLayers.Format.GML.Base,{schemaLocation:"http://www.opengis.net/gml http://schemas.opengis.net/gml/2.1.2/feature.xsd",initialize:function(a){OpenLayers.Format.GML.Base.prototype.initialize.apply(this,[a])
},readers:{gml:OpenLayers.Util.applyDefaults({outerBoundaryIs:function(b,a){var c={};
this.readChildNodes(b,c);
a.outer=c.components[0]
},innerBoundaryIs:function(b,a){var c={};
this.readChildNodes(b,c);
a.inner.push(c.components[0])
},Box:function(d,b){var e={};
this.readChildNodes(d,e);
if(!b.components){b.components=[]
}var c=e.points[0];
var a=e.points[1];
b.components.push(new OpenLayers.Bounds(c.x,c.y,a.x,a.y))
}},OpenLayers.Format.GML.Base.prototype.readers.gml),feature:OpenLayers.Format.GML.Base.prototype.readers.feature,wfs:OpenLayers.Format.GML.Base.prototype.readers.wfs},write:function(c){var b;
if(c instanceof Array){b="wfs:FeatureCollection"
}else{b="gml:featureMember"
}var a=this.writeNode(b,c);
this.setAttributeNS(a,this.namespaces.xsi,"xsi:schemaLocation",this.schemaLocation);
return OpenLayers.Format.XML.prototype.write.apply(this,[a])
},writers:{gml:OpenLayers.Util.applyDefaults({Point:function(b){var a=this.createElementNSPlus("gml:Point");
this.writeNode("coordinates",[b],a);
return a
},coordinates:function(d){var c=d.length;
var e=new Array(c);
var a;
for(var b=0;
b<c;
++b){a=d[b];
if(this.xy){e[b]=a.x+","+a.y
}else{e[b]=a.y+","+a.x
}if(a.z!=undefined){e[b]+=","+a.z
}}return this.createElementNSPlus("gml:coordinates",{attributes:{decimal:".",cs:",",ts:" "},value:(c==1)?e[0]:e.join(" ")})
},LineString:function(b){var a=this.createElementNSPlus("gml:LineString");
this.writeNode("coordinates",b.components,a);
return a
},Polygon:function(c){var b=this.createElementNSPlus("gml:Polygon");
this.writeNode("outerBoundaryIs",c.components[0],b);
for(var a=1;
a<c.components.length;
++a){this.writeNode("innerBoundaryIs",c.components[a],b)
}return b
},outerBoundaryIs:function(a){var b=this.createElementNSPlus("gml:outerBoundaryIs");
this.writeNode("LinearRing",a,b);
return b
},innerBoundaryIs:function(a){var b=this.createElementNSPlus("gml:innerBoundaryIs");
this.writeNode("LinearRing",a,b);
return b
},LinearRing:function(a){var b=this.createElementNSPlus("gml:LinearRing");
this.writeNode("coordinates",a.components,b);
return b
},Box:function(b){var a=this.createElementNSPlus("gml:Box");
this.writeNode("coordinates",[{x:b.left,y:b.bottom},{x:b.right,y:b.top}],a);
if(this.srsName){a.setAttribute("srsName",this.srsName)
}return a
}},OpenLayers.Format.GML.Base.prototype.writers.gml),feature:OpenLayers.Format.GML.Base.prototype.writers.feature,wfs:OpenLayers.Format.GML.Base.prototype.writers.wfs},CLASS_NAME:"OpenLayers.Format.GML.v2"});OpenLayers.Format.Filter.v1=OpenLayers.Class(OpenLayers.Format.XML,{namespaces:{ogc:"http://www.opengis.net/ogc",gml:"http://www.opengis.net/gml",xlink:"http://www.w3.org/1999/xlink",xsi:"http://www.w3.org/2001/XMLSchema-instance"},defaultPrefix:"ogc",schemaLocation:null,initialize:function(a){OpenLayers.Format.XML.prototype.initialize.apply(this,[a])
},read:function(a){var b={};
this.readers.ogc.Filter.apply(this,[a,b]);
return b.filter
},readers:{ogc:{Filter:function(b,a){var c={fids:[],filters:[]};
this.readChildNodes(b,c);
if(c.fids.length>0){a.filter=new OpenLayers.Filter.FeatureId({fids:c.fids})
}else{if(c.filters.length>0){a.filter=c.filters[0]
}}},FeatureId:function(a,b){var c=a.getAttribute("fid");
if(c){b.fids.push(c)
}},And:function(b,c){var a=new OpenLayers.Filter.Logical({type:OpenLayers.Filter.Logical.AND});
this.readChildNodes(b,a);
c.filters.push(a)
},Or:function(b,c){var a=new OpenLayers.Filter.Logical({type:OpenLayers.Filter.Logical.OR});
this.readChildNodes(b,a);
c.filters.push(a)
},Not:function(b,c){var a=new OpenLayers.Filter.Logical({type:OpenLayers.Filter.Logical.NOT});
this.readChildNodes(b,a);
c.filters.push(a)
},PropertyIsLessThan:function(b,c){var a=new OpenLayers.Filter.Comparison({type:OpenLayers.Filter.Comparison.LESS_THAN});
this.readChildNodes(b,a);
c.filters.push(a)
},PropertyIsGreaterThan:function(b,c){var a=new OpenLayers.Filter.Comparison({type:OpenLayers.Filter.Comparison.GREATER_THAN});
this.readChildNodes(b,a);
c.filters.push(a)
},PropertyIsLessThanOrEqualTo:function(b,c){var a=new OpenLayers.Filter.Comparison({type:OpenLayers.Filter.Comparison.LESS_THAN_OR_EQUAL_TO});
this.readChildNodes(b,a);
c.filters.push(a)
},PropertyIsGreaterThanOrEqualTo:function(b,c){var a=new OpenLayers.Filter.Comparison({type:OpenLayers.Filter.Comparison.GREATER_THAN_OR_EQUAL_TO});
this.readChildNodes(b,a);
c.filters.push(a)
},PropertyIsBetween:function(b,c){var a=new OpenLayers.Filter.Comparison({type:OpenLayers.Filter.Comparison.BETWEEN});
this.readChildNodes(b,a);
c.filters.push(a)
},Literal:function(a,b){b.value=OpenLayers.String.numericIf(this.getChildValue(a))
},PropertyName:function(b,a){a.property=this.getChildValue(b)
},LowerBoundary:function(b,a){a.lowerBoundary=OpenLayers.String.numericIf(this.readOgcExpression(b))
},UpperBoundary:function(b,a){a.upperBoundary=OpenLayers.String.numericIf(this.readOgcExpression(b))
},Intersects:function(a,b){this.readSpatial(a,b,OpenLayers.Filter.Spatial.INTERSECTS)
},Within:function(a,b){this.readSpatial(a,b,OpenLayers.Filter.Spatial.WITHIN)
},Contains:function(a,b){this.readSpatial(a,b,OpenLayers.Filter.Spatial.CONTAINS)
},DWithin:function(a,b){this.readSpatial(a,b,OpenLayers.Filter.Spatial.DWITHIN)
},Distance:function(a,b){b.distance=parseInt(this.getChildValue(a));
b.distanceUnits=a.getAttribute("units")
}}},readSpatial:function(c,d,b){var a=new OpenLayers.Filter.Spatial({type:b});
this.readChildNodes(c,a);
a.value=a.components[0];
delete a.components;
d.filters.push(a)
},readOgcExpression:function(a){var c={};
this.readChildNodes(a,c);
var b=c.value;
if(b===undefined){b=this.getChildValue(a)
}return b
},write:function(a){return this.writers.ogc.Filter.apply(this,[a])
},writers:{ogc:{Filter:function(c){var d=this.createElementNSPlus("ogc:Filter");
var b=c.CLASS_NAME.split(".").pop();
if(b=="FeatureId"){for(var a=0;
a<c.fids.length;
++a){this.writeNode("FeatureId",c.fids[a],d)
}}else{this.writeNode(this.getFilterType(c),c,d)
}return d
},FeatureId:function(a){return this.createElementNSPlus("ogc:FeatureId",{attributes:{fid:a}})
},And:function(c){var d=this.createElementNSPlus("ogc:And");
var b;
for(var a=0;
a<c.filters.length;
++a){b=c.filters[a];
this.writeNode(this.getFilterType(b),b,d)
}return d
},Or:function(c){var d=this.createElementNSPlus("ogc:Or");
var b;
for(var a=0;
a<c.filters.length;
++a){b=c.filters[a];
this.writeNode(this.getFilterType(b),b,d)
}return d
},Not:function(b){var c=this.createElementNSPlus("ogc:Not");
var a=b.filters[0];
this.writeNode(this.getFilterType(a),a,c);
return c
},PropertyIsLessThan:function(a){var b=this.createElementNSPlus("ogc:PropertyIsLessThan");
this.writeNode("PropertyName",a,b);
this.writeNode("Literal",a.value,b);
return b
},PropertyIsGreaterThan:function(a){var b=this.createElementNSPlus("ogc:PropertyIsGreaterThan");
this.writeNode("PropertyName",a,b);
this.writeNode("Literal",a.value,b);
return b
},PropertyIsLessThanOrEqualTo:function(a){var b=this.createElementNSPlus("ogc:PropertyIsLessThanOrEqualTo");
this.writeNode("PropertyName",a,b);
this.writeNode("Literal",a.value,b);
return b
},PropertyIsGreaterThanOrEqualTo:function(a){var b=this.createElementNSPlus("ogc:PropertyIsGreaterThanOrEqualTo");
this.writeNode("PropertyName",a,b);
this.writeNode("Literal",a.value,b);
return b
},PropertyIsBetween:function(a){var b=this.createElementNSPlus("ogc:PropertyIsBetween");
this.writeNode("PropertyName",a,b);
this.writeNode("LowerBoundary",a,b);
this.writeNode("UpperBoundary",a,b);
return b
},PropertyName:function(a){return this.createElementNSPlus("ogc:PropertyName",{value:a.property})
},Literal:function(a){return this.createElementNSPlus("ogc:Literal",{value:a})
},LowerBoundary:function(a){var b=this.createElementNSPlus("ogc:LowerBoundary");
this.writeNode("Literal",a.lowerBoundary,b);
return b
},UpperBoundary:function(a){var b=this.createElementNSPlus("ogc:UpperBoundary");
this.writeNode("Literal",a.upperBoundary,b);
return b
},INTERSECTS:function(a){return this.writeSpatial(a,"Intersects")
},WITHIN:function(a){return this.writeSpatial(a,"Within")
},CONTAINS:function(a){return this.writeSpatial(a,"Contains")
},DWITHIN:function(a){var b=this.writeSpatial(a,"DWithin");
this.writeNode("Distance",a,b);
return b
},Distance:function(a){return this.createElementNSPlus("ogc:Distance",{attributes:{units:a.distanceUnits},value:a.distance})
}}},getFilterType:function(a){var b=this.filterMap[a.type];
if(!b){throw"Filter writing not supported for rule type: "+a.type
}return b
},filterMap:{"&&":"And","||":"Or","!":"Not","==":"PropertyIsEqualTo","!=":"PropertyIsNotEqualTo","<":"PropertyIsLessThan",">":"PropertyIsGreaterThan","<=":"PropertyIsLessThanOrEqualTo",">=":"PropertyIsGreaterThanOrEqualTo","..":"PropertyIsBetween","~":"PropertyIsLike",BBOX:"BBOX",DWITHIN:"DWITHIN",WITHIN:"WITHIN",CONTAINS:"CONTAINS",INTERSECTS:"INTERSECTS"},CLASS_NAME:"OpenLayers.Format.Filter.v1"});OpenLayers.Format.Filter.v1_0_0=OpenLayers.Class(OpenLayers.Format.GML.v2,OpenLayers.Format.Filter.v1,{VERSION:"1.0.0",schemaLocation:"http://www.opengis.net/ogc/filter/1.0.0/filter.xsd",initialize:function(a){OpenLayers.Format.GML.v2.prototype.initialize.apply(this,[a])
},readers:{ogc:OpenLayers.Util.applyDefaults({PropertyIsEqualTo:function(b,c){var a=new OpenLayers.Filter.Comparison({type:OpenLayers.Filter.Comparison.EQUAL_TO});
this.readChildNodes(b,a);
c.filters.push(a)
},PropertyIsNotEqualTo:function(b,c){var a=new OpenLayers.Filter.Comparison({type:OpenLayers.Filter.Comparison.NOT_EQUAL_TO});
this.readChildNodes(b,a);
c.filters.push(a)
},PropertyIsLike:function(d,e){var c=new OpenLayers.Filter.Comparison({type:OpenLayers.Filter.Comparison.LIKE});
this.readChildNodes(d,c);
var f=d.getAttribute("wildCard");
var b=d.getAttribute("singleChar");
var a=d.getAttribute("escape");
c.value2regex(f,b,a);
e.filters.push(c)
}},OpenLayers.Format.Filter.v1.prototype.readers.ogc),gml:OpenLayers.Format.GML.v2.prototype.readers.gml,feature:OpenLayers.Format.GML.v2.prototype.readers.feature},writers:{ogc:OpenLayers.Util.applyDefaults({PropertyIsEqualTo:function(a){var b=this.createElementNSPlus("ogc:PropertyIsEqualTo");
this.writeNode("PropertyName",a,b);
this.writeNode("Literal",a.value,b);
return b
},PropertyIsNotEqualTo:function(a){var b=this.createElementNSPlus("ogc:PropertyIsNotEqualTo");
this.writeNode("PropertyName",a,b);
this.writeNode("Literal",a.value,b);
return b
},PropertyIsLike:function(a){var b=this.createElementNSPlus("ogc:PropertyIsLike",{attributes:{wildCard:"*",singleChar:".",escape:"!"}});
this.writeNode("PropertyName",a,b);
this.writeNode("Literal",a.regex2value(),b);
return b
},BBOX:function(a){var c=this.createElementNSPlus("ogc:BBOX");
this.writeNode("PropertyName",a,c);
var b=this.writeNode("gml:Box",a.value,c);
if(a.projection){b.setAttribute("srsName",a.projection)
}return c
}},OpenLayers.Format.Filter.v1.prototype.writers.ogc),gml:OpenLayers.Format.GML.v2.prototype.writers.gml,feature:OpenLayers.Format.GML.v2.prototype.writers.feature},writeSpatial:function(b,a){var c=this.createElementNSPlus("ogc:"+a);
this.writeNode("PropertyName",b,c);
var d;
if(b.value instanceof OpenLayers.Geometry){d=this.writeNode("feature:_geometry",b.value).firstChild
}else{d=this.writeNode("gml:Box",b.value)
}if(b.projection){d.setAttribute("srsName",b.projection)
}c.appendChild(d);
return c
},CLASS_NAME:"OpenLayers.Format.Filter.v1_0_0"});OpenLayers.Format.Filter.v1_1_0=OpenLayers.Class(OpenLayers.Format.GML.v3,OpenLayers.Format.Filter.v1,{VERSION:"1.1.0",schemaLocation:"http://www.opengis.net/ogc/filter/1.1.0/filter.xsd",initialize:function(a){OpenLayers.Format.GML.v3.prototype.initialize.apply(this,[a])
},readers:{ogc:OpenLayers.Util.applyDefaults({PropertyIsEqualTo:function(b,d){var c=b.getAttribute("matchCase");
var a=new OpenLayers.Filter.Comparison({type:OpenLayers.Filter.Comparison.EQUAL_TO,matchCase:!(c==="false"||c==="0")});
this.readChildNodes(b,a);
d.filters.push(a)
},PropertyIsNotEqualTo:function(b,d){var c=b.getAttribute("matchCase");
var a=new OpenLayers.Filter.Comparison({type:OpenLayers.Filter.Comparison.NOT_EQUAL_TO,matchCase:!(c==="false"||c==="0")});
this.readChildNodes(b,a);
d.filters.push(a)
},PropertyIsLike:function(d,e){var c=new OpenLayers.Filter.Comparison({type:OpenLayers.Filter.Comparison.LIKE});
this.readChildNodes(d,c);
var f=d.getAttribute("wildCard");
var b=d.getAttribute("singleChar");
var a=d.getAttribute("escapeChar");
c.value2regex(f,b,a);
e.filters.push(c)
}},OpenLayers.Format.Filter.v1.prototype.readers.ogc),gml:OpenLayers.Format.GML.v3.prototype.readers.gml,feature:OpenLayers.Format.GML.v3.prototype.readers.feature},writers:{ogc:OpenLayers.Util.applyDefaults({PropertyIsEqualTo:function(a){var b=this.createElementNSPlus("ogc:PropertyIsEqualTo",{attributes:{matchCase:a.matchCase}});
this.writeNode("PropertyName",a,b);
this.writeNode("Literal",a.value,b);
return b
},PropertyIsNotEqualTo:function(a){var b=this.createElementNSPlus("ogc:PropertyIsNotEqualTo",{attributes:{matchCase:a.matchCase}});
this.writeNode("PropertyName",a,b);
this.writeNode("Literal",a.value,b);
return b
},PropertyIsLike:function(a){var b=this.createElementNSPlus("ogc:PropertyIsLike",{attributes:{wildCard:"*",singleChar:".",escapeChar:"!"}});
this.writeNode("PropertyName",a,b);
this.writeNode("Literal",a.regex2value(),b);
return b
},BBOX:function(a){var c=this.createElementNSPlus("ogc:BBOX");
this.writeNode("PropertyName",a,c);
var b=this.writeNode("gml:Envelope",a.value);
if(a.projection){b.setAttribute("srsName",a.projection)
}c.appendChild(b);
return c
}},OpenLayers.Format.Filter.v1.prototype.writers.ogc),gml:OpenLayers.Format.GML.v3.prototype.writers.gml,feature:OpenLayers.Format.GML.v3.prototype.writers.feature},writeSpatial:function(b,a){var c=this.createElementNSPlus("ogc:"+a);
this.writeNode("PropertyName",b,c);
var d;
if(b.value instanceof OpenLayers.Geometry){d=this.writeNode("feature:_geometry",b.value).firstChild
}else{d=this.writeNode("gml:Envelope",b.value)
}if(b.projection){d.setAttribute("srsName",b.projection)
}c.appendChild(d);
return c
},CLASS_NAME:"OpenLayers.Format.Filter.v1_1_0"});OpenLayers.Format.CSWGetRecords.v2_0_2=OpenLayers.Class(OpenLayers.Format.XML,{namespaces:{xlink:"http://www.w3.org/1999/xlink",xsi:"http://www.w3.org/2001/XMLSchema-instance",csw:"http://www.opengis.net/cat/csw/2.0.2",dc:"http://purl.org/dc/elements/1.1/",dct:"http://purl.org/dc/terms/",ows:"http://www.opengis.net/ows"},defaultPrefix:"csw",version:"2.0.2",schemaLocation:"http://www.opengis.net/cat/csw/2.0.2 http://schemas.opengis.net/csw/2.0.2/CSW-discovery.xsd",requestId:null,resultType:null,outputFormat:null,outputSchema:null,startPosition:null,maxRecords:null,DistributedSearch:null,ResponseHandler:null,Query:null,regExes:{trimSpace:(/^\s*|\s*$/g),removeSpace:(/\s*/g),splitSpace:(/\s+/),trimComma:(/\s*,\s*/g)},initialize:function(a){OpenLayers.Format.XML.prototype.initialize.apply(this,[a])
},read:function(a){if(typeof a=="string"){a=OpenLayers.Format.XML.prototype.read.apply(this,[a])
}if(a&&a.nodeType==9){a=a.documentElement
}var b={};
this.readNode(a,b);
return b
},readers:{csw:{GetRecordsResponse:function(b,c){c.records=[];
this.readChildNodes(b,c);
var a=this.getAttributeNS(b,"","version");
if(a!=""){c.version=a
}},RequestId:function(a,b){b.RequestId=this.getChildValue(a)
},SearchStatus:function(a,c){c.SearchStatus={};
var b=this.getAttributeNS(a,"","timestamp");
if(b!=""){c.SearchStatus.timestamp=b
}},SearchResults:function(d,e){this.readChildNodes(d,e);
var b=d.attributes;
var f={};
for(var c=0,a=b.length;
c<a;
++c){if((b[c].name=="numberOfRecordsMatched")||(b[c].name=="numberOfRecordsReturned")||(b[c].name=="nextRecord")){f[b[c].name]=parseInt(b[c].nodeValue)
}else{f[b[c].name]=b[c].nodeValue
}}e.SearchResults=f
},SummaryRecord:function(b,c){var a={type:"SummaryRecord"};
this.readChildNodes(b,a);
c.records.push(a)
},BriefRecord:function(b,c){var a={type:"BriefRecord"};
this.readChildNodes(b,a);
c.records.push(a)
},DCMIRecord:function(b,c){var a={type:"DCMIRecord"};
this.readChildNodes(b,a);
c.records.push(a)
},Record:function(b,c){var a={type:"Record"};
this.readChildNodes(b,a);
c.records.push(a)
}},dc:{"*":function(f,g){var d=f.localName||f.nodeName.split(":").pop();
if(!(g[d] instanceof Array)){g[d]=new Array()
}var c={};
var b=f.attributes;
for(var e=0,a=b.length;
e<a;
++e){c[b[e].name]=b[e].nodeValue
}c.value=this.getChildValue(f);
g[d].push(c)
}},dct:{"*":function(b,c){var a=b.localName||b.nodeName.split(":").pop();
if(!(c[a] instanceof Array)){c[a]=new Array()
}c[a].push(this.getChildValue(b))
}},ows:OpenLayers.Util.applyDefaults({BoundingBox:function(a,b){if(b.bounds){b.BoundingBox=[{crs:b.projection,value:[b.bounds.left,b.bounds.bottom,b.bounds.right,b.bounds.top]}];
delete b.projection;
delete b.bounds
}OpenLayers.Format.OWSCommon.v1_0_0.prototype.readers.ows["BoundingBox"].apply(this,arguments)
}},OpenLayers.Format.OWSCommon.v1_0_0.prototype.readers.ows)},write:function(a){var b=this.writeNode("csw:GetRecords",a);
return OpenLayers.Format.XML.prototype.write.apply(this,[b])
},writers:{csw:{GetRecords:function(b){if(!b){b={}
}var e=this.createElementNSPlus("csw:GetRecords",{attributes:{service:"CSW",version:this.version,requestId:b.requestId||this.requestId,resultType:b.resultType||this.resultType,outputFormat:b.outputFormat||this.outputFormat,outputSchema:b.outputSchema||this.outputSchema,startPosition:b.startPosition||this.startPosition,maxRecords:b.maxRecords||this.maxRecords}});
if(b.DistributedSearch||this.DistributedSearch){this.writeNode("csw:DistributedSearch",b.DistributedSearch||this.DistributedSearch,e)
}var d=b.ResponseHandler||this.ResponseHandler;
if(d instanceof Array&&d.length>0){for(var c=0,a=d.length;
c<a;
c++){this.writeNode("csw:ResponseHandler",d[c],e)
}}this.writeNode("Query",b.Query||this.Query,e);
return e
},DistributedSearch:function(a){var b=this.createElementNSPlus("csw:DistributedSearch",{attributes:{hopCount:a.hopCount}});
return b
},ResponseHandler:function(a){var b=this.createElementNSPlus("csw:ResponseHandler",{value:a.value});
return b
},Query:function(b){if(!b){b={}
}var e=this.createElementNSPlus("csw:Query",{attributes:{typeNames:b.typeNames||"csw:Record"}});
var d=b.ElementName;
if(d instanceof Array&&d.length>0){for(var c=0,a=d.length;
c<a;
c++){this.writeNode("csw:ElementName",d[c],e)
}}else{this.writeNode("csw:ElementSetName",b.ElementSetName||{value:"summary"},e)
}if(b.Constraint){this.writeNode("csw:Constraint",b.Constraint,e)
}return e
},ElementName:function(a){var b=this.createElementNSPlus("csw:ElementName",{value:a.value});
return b
},ElementSetName:function(a){var b=this.createElementNSPlus("csw:ElementSetName",{attributes:{typeNames:a.typeNames},value:a.value});
return b
},Constraint:function(a){var b=this.createElementNSPlus("csw:Constraint",{attributes:{version:a.version}});
if(a.Filter){var c=new OpenLayers.Format.Filter({version:a.version});
b.appendChild(c.write(a.Filter))
}else{if(a.CqlText){var d=this.createElementNSPlus("CqlText",{value:a.CqlText.value});
b.appendChild(d)
}}return b
}}},CLASS_NAME:"OpenLayers.Format.CSWGetRecords.v2_0_2"});OpenLayers.Format.WMSCapabilities=OpenLayers.Class(OpenLayers.Format.XML,{defaultVersion:"1.1.1",version:null,parser:null,initialize:function(a){OpenLayers.Format.XML.prototype.initialize.apply(this,[a]);
this.options=a
},read:function(e){if(typeof e=="string"){e=OpenLayers.Format.XML.prototype.read.apply(this,[e])
}var c=e.documentElement;
var b=this.version||c.getAttribute("version")||this.defaultVersion;
if(!this.parser||this.parser.version!==b){var d=OpenLayers.Format.WMSCapabilities["v"+b.replace(/\./g,"_")];
if(!d){throw"Can't find a WMS capabilities parser for version "+b
}this.parser=new d(this.options)
}var a=this.parser.read(e);
a.version=b;
return a
},CLASS_NAME:"OpenLayers.Format.WMSCapabilities"});OpenLayers.Format.WMSCapabilities.v1_1=OpenLayers.Class(OpenLayers.Format.WMSCapabilities.v1,{readers:{wms:OpenLayers.Util.applyDefaults({WMT_MS_Capabilities:function(a,b){this.readChildNodes(a,b)
},Keyword:function(a,b){if(b.keywords){b.keywords.push(this.getChildValue(a))
}},DescribeLayer:function(a,b){b.describelayer={formats:[]};
this.readChildNodes(a,b.describelayer)
},GetLegendGraphic:function(a,b){b.getlegendgraphic={formats:[]};
this.readChildNodes(a,b.getlegendgraphic)
},GetStyles:function(a,b){b.getstyles={formats:[]};
this.readChildNodes(a,b.getstyles)
},PutStyles:function(a,b){b.putstyles={formats:[]};
this.readChildNodes(a,b.putstyles)
},UserDefinedSymbolization:function(a,b){var c={supportSLD:parseInt(a.getAttribute("SupportSLD"))==1,userLayer:parseInt(a.getAttribute("UserLayer"))==1,userStyle:parseInt(a.getAttribute("UserStyle"))==1,remoteWFS:parseInt(a.getAttribute("RemoteWFS"))==1};
b.userSymbols=c
},LatLonBoundingBox:function(a,b){b.llbbox=[parseFloat(a.getAttribute("minx")),parseFloat(a.getAttribute("miny")),parseFloat(a.getAttribute("maxx")),parseFloat(a.getAttribute("maxy"))]
},BoundingBox:function(a,b){var c=OpenLayers.Format.WMSCapabilities.v1.prototype.readers.wms.BoundingBox.apply(this,[a,b]);
c.srs=a.getAttribute("SRS");
b.bbox[c.srs]=c
},ScaleHint:function(e,f){var d=e.getAttribute("min");
var a=e.getAttribute("max");
var c=Math.pow(2,0.5);
var b=OpenLayers.INCHES_PER_UNIT.m;
f.maxScale=parseFloat(((d/c)*b*OpenLayers.DOTS_PER_INCH).toPrecision(13));
f.minScale=parseFloat(((a/c)*b*OpenLayers.DOTS_PER_INCH).toPrecision(13))
},Dimension:function(b,d){var a=b.getAttribute("name").toLowerCase();
var c={name:a,units:b.getAttribute("units"),unitsymbol:b.getAttribute("unitSymbol")};
d.dimensions[c.name]=c
},Extent:function(d,e){var b=d.getAttribute("name").toLowerCase();
if(b in e.dimensions){var c=e.dimensions[b];
c.nearestVal=d.getAttribute("nearestValue")==="1";
c.multipleVal=d.getAttribute("multipleValues")==="1";
c.current=d.getAttribute("current")==="1";
c["default"]=d.getAttribute("default")||"";
var a=this.getChildValue(d);
c.values=a.split(",")
}}},OpenLayers.Format.WMSCapabilities.v1.prototype.readers.wms)},CLASS_NAME:"OpenLayers.Format.WMSCapabilities.v1_1"});OpenLayers.Control.Scale=OpenLayers.Class(OpenLayers.Control,{element:null,geodesic:false,initialize:function(b,a){OpenLayers.Control.prototype.initialize.apply(this,[a]);
this.element=OpenLayers.Util.getElement(b)
},draw:function(){OpenLayers.Control.prototype.draw.apply(this,arguments);
if(!this.element){this.element=document.createElement("div");
this.div.appendChild(this.element)
}this.map.events.register("moveend",this,this.updateScale);
this.updateScale();
return this.div
},updateScale:function(){var c;
if(this.geodesic===true){var a=this.map.getUnits();
if(!a){return
}var b=OpenLayers.INCHES_PER_UNIT;
c=(this.map.getGeodesicPixelSize().w||0.000001)*b.km*OpenLayers.DOTS_PER_INCH
}else{c=this.map.getScale()
}if(!c){return
}if(c>=9500&&c<=950000){c=Math.round(c/1000)+"K"
}else{if(c>=950000){c=Math.round(c/1000000)+"M"
}else{c=Math.round(c)
}}this.element.innerHTML=OpenLayers.i18n("scale",{scaleDenom:c})
},CLASS_NAME:"OpenLayers.Control.Scale"});Ext.namespace("GeoExt");
GeoExt.Action=Ext.extend(Ext.Action,{control:null,map:null,uScope:null,uHandler:null,uToggleHandler:null,uCheckHandler:null,constructor:function(a){this.uScope=a.scope;
this.uHandler=a.handler;
this.uToggleHandler=a.toggleHandler;
this.uCheckHandler=a.checkHandler;
a.scope=this;
a.handler=this.pHandler;
a.toggleHandler=this.pToggleHandler;
a.checkHandler=this.pCheckHandler;
var b=this.control=a.control;
delete a.control;
if(b){if(a.map){a.map.addControl(b);
delete a.map
}if((a.pressed||a.checked)&&b.map){b.activate()
}b.events.on({activate:this.onCtrlActivate,deactivate:this.onCtrlDeactivate,scope:this})
}arguments.callee.superclass.constructor.call(this,a)
},pHandler:function(a){var b=this.control;
if(b&&b.type==OpenLayers.Control.TYPE_BUTTON){b.trigger()
}if(this.uHandler){this.uHandler.apply(this.uScope,arguments)
}},pToggleHandler:function(a,b){this.changeControlState(b);
if(this.uToggleHandler){this.uToggleHandler.apply(this.uScope,arguments)
}},pCheckHandler:function(a,b){this.changeControlState(b);
if(this.uCheckHandler){this.uCheckHandler.apply(this.uScope,arguments)
}},changeControlState:function(a){if(a){if(!this._activating){this._activating=true;
this.control.activate();
this._activating=false
}}else{if(!this._deactivating){this._deactivating=true;
this.control.deactivate();
this._deactivating=false
}}},onCtrlActivate:function(){var a=this.control;
if(a.type==OpenLayers.Control.TYPE_BUTTON){this.enable()
}else{this.safeCallEach("toggle",[true]);
this.safeCallEach("setChecked",[true])
}},onCtrlDeactivate:function(){var a=this.control;
if(a.type==OpenLayers.Control.TYPE_BUTTON){this.disable()
}else{this.safeCallEach("toggle",[false]);
this.safeCallEach("setChecked",[false])
}},safeCallEach:function(e,b){var d=this.items;
for(var c=0,a=d.length;
c<a;
c++){if(d[c][e]){d[c][e].apply(d[c],b)
}}}});OpenLayers.Control.DrawFeature=OpenLayers.Class(OpenLayers.Control,{layer:null,callbacks:null,EVENT_TYPES:["featureadded"],multi:false,featureAdded:function(){},handlerOptions:null,initialize:function(b,c,a){this.EVENT_TYPES=OpenLayers.Control.DrawFeature.prototype.EVENT_TYPES.concat(OpenLayers.Control.prototype.EVENT_TYPES);
OpenLayers.Control.prototype.initialize.apply(this,[a]);
this.callbacks=OpenLayers.Util.extend({done:this.drawFeature,modify:function(f,e){this.layer.events.triggerEvent("sketchmodified",{vertex:f,feature:e})
},create:function(f,e){this.layer.events.triggerEvent("sketchstarted",{vertex:f,feature:e})
}},this.callbacks);
this.layer=b;
this.handlerOptions=this.handlerOptions||{};
if(!("multi" in this.handlerOptions)){this.handlerOptions.multi=this.multi
}var d=this.layer.styleMap&&this.layer.styleMap.styles.temporary;
if(d){this.handlerOptions.layerOptions=OpenLayers.Util.applyDefaults(this.handlerOptions.layerOptions,{styleMap:new OpenLayers.StyleMap({"default":d})})
}this.handler=new c(this,this.callbacks,this.handlerOptions)
},drawFeature:function(c){var a=new OpenLayers.Feature.Vector(c);
var b=this.layer.events.triggerEvent("sketchcomplete",{feature:a});
if(b!==false){a.state=OpenLayers.State.INSERT;
this.layer.addFeatures([a]);
this.featureAdded(a);
this.events.triggerEvent("featureadded",{feature:a})
}},CLASS_NAME:"OpenLayers.Control.DrawFeature"});OpenLayers.Rule=OpenLayers.Class({id:null,name:null,title:null,description:null,context:null,filter:null,elseFilter:false,symbolizer:null,symbolizers:null,minScaleDenominator:null,maxScaleDenominator:null,initialize:function(a){this.symbolizer={};
OpenLayers.Util.extend(this,a);
if(this.symbolizers){delete this.symbolizer
}this.id=OpenLayers.Util.createUniqueID(this.CLASS_NAME+"_")
},destroy:function(){for(var a in this.symbolizer){this.symbolizer[a]=null
}this.symbolizer=null;
delete this.symbolizers
},evaluate:function(c){var b=this.getContext(c);
var a=true;
if(this.minScaleDenominator||this.maxScaleDenominator){var d=c.layer.map.getScale()
}if(this.minScaleDenominator){a=d>=OpenLayers.Style.createLiteral(this.minScaleDenominator,b)
}if(a&&this.maxScaleDenominator){a=d<OpenLayers.Style.createLiteral(this.maxScaleDenominator,b)
}if(a&&this.filter){if(this.filter.CLASS_NAME=="OpenLayers.Filter.FeatureId"){a=this.filter.evaluate(c)
}else{a=this.filter.evaluate(b)
}}return a
},getContext:function(b){var a=this.context;
if(!a){a=b.attributes||b.data
}if(typeof this.context=="function"){a=this.context(b)
}return a
},clone:function(){var b=OpenLayers.Util.extend({},this);
if(this.symbolizers){var a=this.symbolizers.length;
b.symbolizers=new Array(a);
for(var d=0;
d<a;
++d){b.symbolizers[d]=this.symbolizers[d].clone()
}}else{b.symbolizer={};
var f,e;
for(var c in this.symbolizer){f=this.symbolizer[c];
e=typeof f;
if(e==="object"){b.symbolizer[c]=OpenLayers.Util.extend({},f)
}else{if(e==="string"){b.symbolizer[c]=f
}}}}b.filter=this.filter&&this.filter.clone();
b.context=this.context&&OpenLayers.Util.extend({},this.context);
return new OpenLayers.Rule(b)
},CLASS_NAME:"OpenLayers.Rule"});OpenLayers.Handler.Hover=OpenLayers.Class(OpenLayers.Handler,{delay:500,pixelTolerance:null,stopMove:false,px:null,timerId:null,initialize:function(c,b,a){OpenLayers.Handler.prototype.initialize.apply(this,arguments)
},mousemove:function(a){if(this.passesTolerance(a.xy)){this.clearTimer();
this.callback("move",[a]);
this.px=a.xy;
a=OpenLayers.Util.extend({},a);
this.timerId=window.setTimeout(OpenLayers.Function.bind(this.delayedCall,this,a),this.delay)
}return !this.stopMove
},mouseout:function(a){if(OpenLayers.Util.mouseLeft(a,this.map.div)){this.clearTimer();
this.callback("move",[a])
}return true
},passesTolerance:function(b){var c=true;
if(this.pixelTolerance&&this.px){var a=Math.sqrt(Math.pow(this.px.x-b.x,2)+Math.pow(this.px.y-b.y,2));
if(a<this.pixelTolerance){c=false
}}return c
},clearTimer:function(){if(this.timerId!=null){window.clearTimeout(this.timerId);
this.timerId=null
}},delayedCall:function(a){this.callback("pause",[a])
},deactivate:function(){var a=false;
if(OpenLayers.Handler.prototype.deactivate.apply(this,arguments)){this.clearTimer();
a=true
}return a
},CLASS_NAME:"OpenLayers.Handler.Hover"});OpenLayers.Control.MouseDefaults=OpenLayers.Class(OpenLayers.Control,{performedDrag:false,wheelObserver:null,initialize:function(){OpenLayers.Control.prototype.initialize.apply(this,arguments)
},destroy:function(){if(this.handler){this.handler.destroy()
}this.handler=null;
this.map.events.un({click:this.defaultClick,dblclick:this.defaultDblClick,mousedown:this.defaultMouseDown,mouseup:this.defaultMouseUp,mousemove:this.defaultMouseMove,mouseout:this.defaultMouseOut,scope:this});
OpenLayers.Event.stopObserving(window,"DOMMouseScroll",this.wheelObserver);
OpenLayers.Event.stopObserving(window,"mousewheel",this.wheelObserver);
OpenLayers.Event.stopObserving(document,"mousewheel",this.wheelObserver);
this.wheelObserver=null;
OpenLayers.Control.prototype.destroy.apply(this,arguments)
},draw:function(){this.map.events.on({click:this.defaultClick,dblclick:this.defaultDblClick,mousedown:this.defaultMouseDown,mouseup:this.defaultMouseUp,mousemove:this.defaultMouseMove,mouseout:this.defaultMouseOut,scope:this});
this.registerWheelEvents()
},registerWheelEvents:function(){this.wheelObserver=OpenLayers.Function.bindAsEventListener(this.onWheelEvent,this);
OpenLayers.Event.observe(window,"DOMMouseScroll",this.wheelObserver);
OpenLayers.Event.observe(window,"mousewheel",this.wheelObserver);
OpenLayers.Event.observe(document,"mousewheel",this.wheelObserver)
},defaultClick:function(b){if(!OpenLayers.Event.isLeftClick(b)){return
}var a=!this.performedDrag;
this.performedDrag=false;
return a
},defaultDblClick:function(b){var a=this.map.getLonLatFromViewPortPx(b.xy);
this.map.setCenter(a,this.map.zoom+1);
OpenLayers.Event.stop(b);
return false
},defaultMouseDown:function(a){if(!OpenLayers.Event.isLeftClick(a)){return
}this.mouseDragStart=a.xy.clone();
this.performedDrag=false;
if(a.shiftKey){this.map.div.style.cursor="crosshair";
this.zoomBox=OpenLayers.Util.createDiv("zoomBox",this.mouseDragStart,null,null,"absolute","2px solid red");
this.zoomBox.style.backgroundColor="white";
this.zoomBox.style.filter="alpha(opacity=50)";
this.zoomBox.style.opacity="0.50";
this.zoomBox.style.fontSize="1px";
this.zoomBox.style.zIndex=this.map.Z_INDEX_BASE.Popup-1;
this.map.viewPortDiv.appendChild(this.zoomBox)
}document.onselectstart=OpenLayers.Function.False;
OpenLayers.Event.stop(a)
},defaultMouseMove:function(e){this.mousePosition=e.xy.clone();
if(this.mouseDragStart!=null){if(this.zoomBox){var d=Math.abs(this.mouseDragStart.x-e.xy.x);
var b=Math.abs(this.mouseDragStart.y-e.xy.y);
this.zoomBox.style.width=Math.max(1,d)+"px";
this.zoomBox.style.height=Math.max(1,b)+"px";
if(e.xy.x<this.mouseDragStart.x){this.zoomBox.style.left=e.xy.x+"px"
}if(e.xy.y<this.mouseDragStart.y){this.zoomBox.style.top=e.xy.y+"px"
}}else{var d=this.mouseDragStart.x-e.xy.x;
var b=this.mouseDragStart.y-e.xy.y;
var f=this.map.getSize();
var a=new OpenLayers.Pixel(f.w/2+d,f.h/2+b);
var c=this.map.getLonLatFromViewPortPx(a);
this.map.setCenter(c,null,true);
this.mouseDragStart=e.xy.clone();
this.map.div.style.cursor="move"
}this.performedDrag=true
}},defaultMouseUp:function(a){if(!OpenLayers.Event.isLeftClick(a)){return
}if(this.zoomBox){this.zoomBoxEnd(a)
}else{if(this.performedDrag){this.map.setCenter(this.map.center)
}}document.onselectstart=null;
this.mouseDragStart=null;
this.map.div.style.cursor=""
},defaultMouseOut:function(a){if(this.mouseDragStart!=null&&OpenLayers.Util.mouseLeft(a,this.map.div)){if(this.zoomBox){this.removeZoomBox()
}this.mouseDragStart=null
}},defaultWheelUp:function(a){if(this.map.getZoom()<=this.map.getNumZoomLevels()){this.map.setCenter(this.map.getLonLatFromPixel(a.xy),this.map.getZoom()+1)
}},defaultWheelDown:function(a){if(this.map.getZoom()>0){this.map.setCenter(this.map.getLonLatFromPixel(a.xy),this.map.getZoom()-1)
}},zoomBoxEnd:function(b){if(this.mouseDragStart!=null){if(Math.abs(this.mouseDragStart.x-b.xy.x)>5||Math.abs(this.mouseDragStart.y-b.xy.y)>5){var h=this.map.getLonLatFromViewPortPx(this.mouseDragStart);
var a=this.map.getLonLatFromViewPortPx(b.xy);
var g=Math.max(h.lat,a.lat);
var c=Math.min(h.lat,a.lat);
var f=Math.min(h.lon,a.lon);
var d=Math.max(h.lon,a.lon);
var e=new OpenLayers.Bounds(f,c,d,g);
this.map.zoomToExtent(e)
}else{var a=this.map.getLonLatFromViewPortPx(b.xy);
this.map.setCenter(new OpenLayers.LonLat((a.lon),(a.lat)),this.map.getZoom()+1)
}this.removeZoomBox()
}},removeZoomBox:function(){this.map.viewPortDiv.removeChild(this.zoomBox);
this.zoomBox=null
},onWheelEvent:function(c){var b=false;
var a=OpenLayers.Event.element(c);
while(a!=null){if(this.map&&a==this.map.div){b=true;
break
}a=a.parentNode
}if(b){var d=0;
if(!c){c=window.event
}if(c.wheelDelta){d=c.wheelDelta/120;
if(window.opera&&window.opera.version()<9.2){d=-d
}}else{if(c.detail){d=-c.detail/3
}}if(d){c.xy=this.mousePosition;
if(d<0){this.defaultWheelDown(c)
}else{this.defaultWheelUp(c)
}}OpenLayers.Event.stop(c)
}},CLASS_NAME:"OpenLayers.Control.MouseDefaults"});OpenLayers.Control.MousePosition=OpenLayers.Class(OpenLayers.Control,{autoActivate:true,element:null,prefix:"",separator:", ",suffix:"",numDigits:5,granularity:10,emptyString:null,lastXy:null,displayProjection:null,initialize:function(a){OpenLayers.Control.prototype.initialize.apply(this,arguments)
},destroy:function(){this.deactivate();
OpenLayers.Control.prototype.destroy.apply(this,arguments)
},activate:function(){if(OpenLayers.Control.prototype.activate.apply(this,arguments)){this.map.events.register("mousemove",this,this.redraw);
this.map.events.register("mouseout",this,this.reset);
this.redraw();
return true
}else{return false
}},deactivate:function(){if(OpenLayers.Control.prototype.deactivate.apply(this,arguments)){this.map.events.unregister("mousemove",this,this.redraw);
this.map.events.unregister("mouseout",this,this.reset);
this.element.innerHTML="";
return true
}else{return false
}},draw:function(){OpenLayers.Control.prototype.draw.apply(this,arguments);
if(!this.element){this.div.left="";
this.div.top="";
this.element=this.div
}return this.div
},redraw:function(a){var c;
if(a==null){this.reset();
return
}else{if(this.lastXy==null||Math.abs(a.xy.x-this.lastXy.x)>this.granularity||Math.abs(a.xy.y-this.lastXy.y)>this.granularity){this.lastXy=a.xy;
return
}c=this.map.getLonLatFromPixel(a.xy);
if(!c){return
}if(this.displayProjection){c.transform(this.map.getProjectionObject(),this.displayProjection)
}this.lastXy=a.xy
}var b=this.formatOutput(c);
if(b!=this.element.innerHTML){this.element.innerHTML=b
}},reset:function(a){if(this.emptyString!=null){this.element.innerHTML=this.emptyString
}},formatOutput:function(b){var c=parseInt(this.numDigits);
var a=this.prefix+b.lon.toFixed(c)+this.separator+b.lat.toFixed(c)+this.suffix;
return a
},CLASS_NAME:"OpenLayers.Control.MousePosition"});OpenLayers.Handler.RegularPolygon=OpenLayers.Class(OpenLayers.Handler.Drag,{sides:4,radius:null,snapAngle:null,snapToggle:"shiftKey",layerOptions:null,persist:false,irregular:false,angle:null,fixedRadius:false,feature:null,layer:null,origin:null,initialize:function(c,b,a){if(!(a&&a.layerOptions&&a.layerOptions.styleMap)){this.style=OpenLayers.Util.extend(OpenLayers.Feature.Vector.style["default"],{})
}OpenLayers.Handler.prototype.initialize.apply(this,[c,b,a]);
this.options=(a)?a:{}
},setOptions:function(a){OpenLayers.Util.extend(this.options,a);
OpenLayers.Util.extend(this,a)
},activate:function(){var a=false;
if(OpenLayers.Handler.prototype.activate.apply(this,arguments)){var b=OpenLayers.Util.extend({displayInLayerSwitcher:false,calculateInRange:OpenLayers.Function.True},this.layerOptions);
this.layer=new OpenLayers.Layer.Vector(this.CLASS_NAME,b);
this.map.addLayer(this.layer);
a=true
}return a
},deactivate:function(){var a=false;
if(OpenLayers.Handler.Drag.prototype.deactivate.apply(this,arguments)){if(this.dragging){this.cancel()
}if(this.layer.map!=null){this.layer.destroy(false);
if(this.feature){this.feature.destroy()
}}this.layer=null;
this.feature=null;
a=true
}return a
},down:function(a){this.fixedRadius=!!(this.radius);
var b=this.map.getLonLatFromPixel(a.xy);
this.origin=new OpenLayers.Geometry.Point(b.lon,b.lat);
if(!this.fixedRadius||this.irregular){this.radius=this.map.getResolution()
}if(this.persist){this.clear()
}this.feature=new OpenLayers.Feature.Vector();
this.createGeometry();
this.callback("create",[this.origin,this.feature]);
this.layer.addFeatures([this.feature],{silent:true});
this.layer.drawFeature(this.feature,this.style)
},move:function(c){var f=this.map.getLonLatFromPixel(c.xy);
var a=new OpenLayers.Geometry.Point(f.lon,f.lat);
if(this.irregular){var g=Math.sqrt(2)*Math.abs(a.y-this.origin.y)/2;
this.radius=Math.max(this.map.getResolution()/2,g)
}else{if(this.fixedRadius){this.origin=a
}else{this.calculateAngle(a,c);
this.radius=Math.max(this.map.getResolution()/2,a.distanceTo(this.origin))
}}this.modifyGeometry();
if(this.irregular){var d=a.x-this.origin.x;
var b=a.y-this.origin.y;
var e;
if(b==0){e=d/(this.radius*Math.sqrt(2))
}else{e=d/b
}this.feature.geometry.resize(1,this.origin,e);
this.feature.geometry.move(d/2,b/2)
}this.layer.drawFeature(this.feature,this.style)
},up:function(a){this.finalize();
if(this.start==this.last){this.callback("done",[a.xy])
}},out:function(a){this.finalize()
},createGeometry:function(){this.angle=Math.PI*((1/this.sides)-(1/2));
if(this.snapAngle){this.angle+=this.snapAngle*(Math.PI/180)
}this.feature.geometry=OpenLayers.Geometry.Polygon.createRegularPolygon(this.origin,this.radius,this.sides,this.snapAngle)
},modifyGeometry:function(){var d,a;
var b=this.feature.geometry.components[0];
if(b.components.length!=(this.sides+1)){this.createGeometry();
b=this.feature.geometry.components[0]
}for(var c=0;
c<this.sides;
++c){a=b.components[c];
d=this.angle+(c*2*Math.PI/this.sides);
a.x=this.origin.x+(this.radius*Math.cos(d));
a.y=this.origin.y+(this.radius*Math.sin(d));
a.clearBounds()
}},calculateAngle:function(a,b){var d=Math.atan2(a.y-this.origin.y,a.x-this.origin.x);
if(this.snapAngle&&(this.snapToggle&&!b[this.snapToggle])){var c=(Math.PI/180)*this.snapAngle;
this.angle=Math.round(d/c)*c
}else{this.angle=d
}},cancel:function(){this.callback("cancel",null);
this.finalize()
},finalize:function(){this.origin=null;
this.radius=this.options.radius
},clear:function(){if(this.layer){this.layer.renderer.clear();
this.layer.destroyFeatures()
}},callback:function(b,a){if(this.callbacks[b]){this.callbacks[b].apply(this.control,[this.feature.geometry.clone()])
}if(!this.persist&&(b=="done"||b=="cancel")){this.clear()
}},CLASS_NAME:"OpenLayers.Handler.RegularPolygon"});OpenLayers.Renderer.VML=OpenLayers.Class(OpenLayers.Renderer.Elements,{xmlns:"urn:schemas-microsoft-com:vml",symbolCache:{},offset:null,initialize:function(b){if(!this.supported()){return
}if(!document.namespaces.olv){document.namespaces.add("olv",this.xmlns);
var e=document.createStyleSheet();
var c=["shape","rect","oval","fill","stroke","imagedata","group","textbox"];
for(var d=0,a=c.length;
d<a;
d++){e.addRule("olv\\:"+c[d],"behavior: url(#default#VML); position: absolute; display: inline-block;")
}}OpenLayers.Renderer.Elements.prototype.initialize.apply(this,arguments)
},destroy:function(){OpenLayers.Renderer.Elements.prototype.destroy.apply(this,arguments)
},supported:function(){return !!(document.namespaces)
},setExtent:function(j,a){OpenLayers.Renderer.Elements.prototype.setExtent.apply(this,arguments);
var c=this.getResolution();
var b=(j.left/c)|0;
var f=(j.top/c-this.size.h)|0;
if(a||!this.offset){this.offset={x:b,y:f};
b=0;
f=0
}else{b=b-this.offset.x;
f=f-this.offset.y
}var l=b+" "+f;
this.root.coordorigin=l;
var h=[this.root,this.vectorRoot,this.textRoot];
var g;
for(var d=0,e=h.length;
d<e;
++d){g=h[d];
var k=this.size.w+" "+this.size.h;
g.coordsize=k
}this.root.style.flip="y";
return true
},setSize:function(f){OpenLayers.Renderer.prototype.setSize.apply(this,arguments);
var d=[this.rendererRoot,this.root,this.vectorRoot,this.textRoot];
var c=this.size.w+"px";
var g=this.size.h+"px";
var b;
for(var e=0,a=d.length;
e<a;
++e){b=d[e];
b.style.width=c;
b.style.height=g
}},getNodeType:function(c,b){var a=null;
switch(c.CLASS_NAME){case"OpenLayers.Geometry.Point":if(b.externalGraphic){a="olv:rect"
}else{if(this.isComplexSymbol(b.graphicName)){a="olv:shape"
}else{a="olv:oval"
}}break;
case"OpenLayers.Geometry.Rectangle":a="olv:rect";
break;
case"OpenLayers.Geometry.LineString":case"OpenLayers.Geometry.LinearRing":case"OpenLayers.Geometry.Polygon":case"OpenLayers.Geometry.Curve":case"OpenLayers.Geometry.Surface":a="olv:shape";
break;
default:break
}return a
},setStyle:function(e,b,q,k){b=b||e._style;
q=q||e._options;
var c=b.fillColor;
if(e._geometryClass==="OpenLayers.Geometry.Point"){if(b.externalGraphic){if(b.graphicTitle){e.title=b.graphicTitle
}var d=b.graphicWidth||b.graphicHeight;
var l=b.graphicHeight||b.graphicWidth;
d=d?d:b.pointRadius*2;
l=l?l:b.pointRadius*2;
var g=this.getResolution();
var i=(b.graphicXOffset!=undefined)?b.graphicXOffset:-(0.5*d);
var f=(b.graphicYOffset!=undefined)?b.graphicYOffset:-(0.5*l);
e.style.left=(((k.x/g-this.offset.x)+i)|0)+"px";
e.style.top=(((k.y/g-this.offset.y)-(f+l))|0)+"px";
e.style.width=d+"px";
e.style.height=l+"px";
e.style.flip="y";
c="none";
q.isStroked=false
}else{if(this.isComplexSymbol(b.graphicName)){var a=this.importSymbol(b.graphicName);
e.path=a.path;
e.coordorigin=a.left+","+a.bottom;
var p=a.size;
e.coordsize=p+","+p;
this.drawCircle(e,k,b.pointRadius);
e.style.flip="y"
}else{this.drawCircle(e,k,b.pointRadius)
}}}if(q.isFilled){e.fillcolor=c
}else{e.filled="false"
}var j=e.getElementsByTagName("fill");
var o=(j.length==0)?null:j[0];
if(!q.isFilled){if(o){e.removeChild(o)
}}else{if(!o){o=this.createNode("olv:fill",e.id+"_fill")
}o.opacity=b.fillOpacity;
if(e._geometryClass==="OpenLayers.Geometry.Point"&&b.externalGraphic){if(b.graphicOpacity){o.opacity=b.graphicOpacity
}o.src=b.externalGraphic;
o.type="frame";
if(!(b.graphicWidth&&b.graphicHeight)){o.aspect="atmost"
}}if(o.parentNode!=e){e.appendChild(o)
}}var n=b.rotation;
if((n!==undefined||e._rotation!==undefined)){e._rotation=n;
if(b.externalGraphic){this.graphicRotate(e,i,f,b);
o.opacity=0
}else{if(e._geometryClass==="OpenLayers.Geometry.Point"){e.style.rotation=n||0
}}}var h=e.getElementsByTagName("stroke");
var m=(h.length==0)?null:h[0];
if(!q.isStroked){e.stroked=false;
if(m){m.on=false
}}else{if(!m){m=this.createNode("olv:stroke",e.id+"_stroke");
e.appendChild(m)
}m.on=true;
m.color=b.strokeColor;
m.weight=b.strokeWidth+"px";
m.opacity=b.strokeOpacity;
m.endcap=b.strokeLinecap=="butt"?"flat":(b.strokeLinecap||"round");
if(b.strokeDashstyle){m.dashstyle=this.dashStyle(b)
}}if(b.cursor!="inherit"&&b.cursor!=null){e.style.cursor=b.cursor
}return e
},graphicRotate:function(n,r,e,q){var q=q||n._style;
var o=q.rotation||0;
var a,j;
if(!(q.graphicWidth&&q.graphicHeight)){var s=new Image();
s.onreadystatechange=OpenLayers.Function.bind(function(){if(s.readyState=="complete"||s.readyState=="interactive"){a=s.width/s.height;
j=Math.max(q.pointRadius*2,q.graphicWidth||0,q.graphicHeight||0);
r=r*a;
q.graphicWidth=j*a;
q.graphicHeight=j;
this.graphicRotate(n,r,e,q)
}},this);
s.src=q.externalGraphic;
return
}else{j=Math.max(q.graphicWidth,q.graphicHeight);
a=q.graphicWidth/q.graphicHeight
}var m=Math.round(q.graphicWidth||j*a);
var k=Math.round(q.graphicHeight||j);
n.style.width=m+"px";
n.style.height=k+"px";
var l=document.getElementById(n.id+"_image");
if(!l){l=this.createNode("olv:imagedata",n.id+"_image");
n.appendChild(l)
}l.style.width=m+"px";
l.style.height=k+"px";
l.src=q.externalGraphic;
l.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(src='', sizingMethod='scale')";
var f=o*Math.PI/180;
var h=Math.sin(f);
var d=Math.cos(f);
var g="progid:DXImageTransform.Microsoft.Matrix(M11="+d+",M12="+(-h)+",M21="+h+",M22="+d+",SizingMethod='auto expand')\n";
var b=q.graphicOpacity||q.fillOpacity;
if(b&&b!=1){g+="progid:DXImageTransform.Microsoft.BasicImage(opacity="+b+")\n"
}n.style.filter=g;
var p=new OpenLayers.Geometry.Point(-r,-e);
var c=new OpenLayers.Bounds(0,0,m,k).toGeometry();
c.rotate(q.rotation,p);
var i=c.getBounds();
n.style.left=Math.round(parseInt(n.style.left)+i.left)+"px";
n.style.top=Math.round(parseInt(n.style.top)-i.bottom)+"px"
},postDraw:function(a){a.style.visibility="visible";
var c=a._style.fillColor;
var b=a._style.strokeColor;
if(c=="none"&&a.fillcolor!=c){a.fillcolor=c
}if(b=="none"&&a.strokecolor!=b){a.strokecolor=b
}},setNodeDimension:function(b,e){var d=e.getBounds();
if(d){var a=this.getResolution();
var c=new OpenLayers.Bounds((d.left/a-this.offset.x)|0,(d.bottom/a-this.offset.y)|0,(d.right/a-this.offset.x)|0,(d.top/a-this.offset.y)|0);
b.style.left=c.left+"px";
b.style.top=c.top+"px";
b.style.width=c.getWidth()+"px";
b.style.height=c.getHeight()+"px";
b.coordorigin=c.left+" "+c.top;
b.coordsize=c.getWidth()+" "+c.getHeight()
}},dashStyle:function(a){var c=a.strokeDashstyle;
switch(c){case"solid":case"dot":case"dash":case"dashdot":case"longdash":case"longdashdot":return c;
default:var b=c.split(/[ ,]/);
if(b.length==2){if(1*b[0]>=2*b[1]){return"longdash"
}return(b[0]==1||b[1]==1)?"dot":"dash"
}else{if(b.length==4){return(1*b[0]>=2*b[1])?"longdashdot":"dashdot"
}}return"solid"
}},createNode:function(a,c){var b=document.createElement(a);
if(c){b.id=c
}b.unselectable="on";
b.onselectstart=OpenLayers.Function.False;
return b
},nodeTypeCompare:function(c,b){var d=b;
var a=d.indexOf(":");
if(a!=-1){d=d.substr(a+1)
}var e=c.nodeName;
a=e.indexOf(":");
if(a!=-1){e=e.substr(a+1)
}return(d==e)
},createRenderRoot:function(){return this.nodeFactory(this.container.id+"_vmlRoot","div")
},createRoot:function(a){return this.nodeFactory(this.container.id+a,"olv:group")
},drawPoint:function(a,b){return this.drawCircle(a,b,1)
},drawCircle:function(d,e,a){if(!isNaN(e.x)&&!isNaN(e.y)){var b=this.getResolution();
d.style.left=(((e.x/b-this.offset.x)|0)-a)+"px";
d.style.top=(((e.y/b-this.offset.y)|0)-a)+"px";
var c=a*2;
d.style.width=c+"px";
d.style.height=c+"px";
return d
}return false
},drawLineString:function(a,b){return this.drawLine(a,b,false)
},drawLinearRing:function(a,b){return this.drawLine(a,b,true)
},drawLine:function(b,k,g){this.setNodeDimension(b,k);
var c=this.getResolution();
var a=k.components.length;
var e=new Array(a);
var h,l,j;
for(var f=0;
f<a;
f++){h=k.components[f];
l=(h.x/c-this.offset.x)|0;
j=(h.y/c-this.offset.y)|0;
e[f]=" "+l+","+j+" l "
}var d=(g)?" x e":" e";
b.path="m"+e.join("")+d;
return b
},drawPolygon:function(b,l){this.setNodeDimension(b,l);
var c=this.getResolution();
var n=[];
var f,e,d,h,a,g,m,k;
for(d=0,h=l.components.length;
d<h;
d++){f=l.components[d];
n.push("m");
for(e=0,a=f.components.length;
e<a;
e++){g=f.components[e];
m=(g.x/c-this.offset.x)|0;
k=(g.y/c-this.offset.y)|0;
n.push(" "+m+","+k);
if(e==0){n.push(" l")
}}n.push(" x ")
}n.push("e");
b.path=n.join("");
return b
},drawRectangle:function(b,c){var a=this.getResolution();
b.style.left=((c.x/a-this.offset.x)|0)+"px";
b.style.top=((c.y/a-this.offset.y)|0)+"px";
b.style.width=((c.width/a)|0)+"px";
b.style.height=((c.height/a)|0)+"px";
return b
},drawText:function(d,a,h){var g=this.nodeFactory(d+this.LABEL_ID_SUFFIX,"olv:rect");
var f=this.nodeFactory(d+this.LABEL_ID_SUFFIX+"_textbox","olv:textbox");
var c=this.getResolution();
g.style.left=((h.x/c-this.offset.x)|0)+"px";
g.style.top=((h.y/c-this.offset.y)|0)+"px";
g.style.flip="y";
f.innerText=a.label;
if(a.fontColor){f.style.color=a.fontColor
}if(a.fontOpacity){f.style.filter="alpha(opacity="+(a.fontOpacity*100)+")"
}if(a.fontFamily){f.style.fontFamily=a.fontFamily
}if(a.fontSize){f.style.fontSize=a.fontSize
}if(a.fontWeight){f.style.fontWeight=a.fontWeight
}if(a.labelSelect===true){g._featureId=d;
f._featureId=d;
f._geometry=h;
f._geometryClass=h.CLASS_NAME
}f.style.whiteSpace="nowrap";
f.inset="1px,0px,0px,0px";
if(!g.parentNode){g.appendChild(f);
this.textRoot.appendChild(g)
}var e=a.labelAlign||"cm";
if(e.length==1){e+="m"
}var i=f.clientWidth*(OpenLayers.Renderer.VML.LABEL_SHIFT[e.substr(0,1)]);
var b=f.clientHeight*(OpenLayers.Renderer.VML.LABEL_SHIFT[e.substr(1,1)]);
g.style.left=parseInt(g.style.left)-i-1+"px";
g.style.top=parseInt(g.style.top)+b+"px"
},drawSurface:function(a,g){this.setNodeDimension(a,g);
var b=this.getResolution();
var j=[];
var d,h,f;
for(var c=0,e=g.components.length;
c<e;
c++){d=g.components[c];
h=(d.x/b-this.offset.x)|0;
f=(d.y/b-this.offset.y)|0;
if((c%3)==0&&(c/3)==0){j.push("m")
}else{if((c%3)==1){j.push(" c")
}}j.push(" "+h+","+f)
}j.push(" x e");
a.path=j.join("");
return a
},moveRoot:function(b){var a=this.map.getLayer(b.container.id);
if(a instanceof OpenLayers.Layer.Vector.RootContainer){a=this.map.getLayer(this.container.id)
}a&&a.renderer.clear();
OpenLayers.Renderer.Elements.prototype.moveRoot.apply(this,arguments);
a&&a.redraw()
},importSymbol:function(d){var b=this.container.id+"-"+d;
var a=this.symbolCache[b];
if(a){return a
}var c=OpenLayers.Renderer.symbol[d];
if(!c){throw new Error(d+" is not a valid symbol name")
}var k=new OpenLayers.Bounds(Number.MAX_VALUE,Number.MAX_VALUE,0,0);
var e=["m"];
for(var f=0;
f<c.length;
f=f+2){var h=c[f];
var g=c[f+1];
k.left=Math.min(k.left,h);
k.bottom=Math.min(k.bottom,g);
k.right=Math.max(k.right,h);
k.top=Math.max(k.top,g);
e.push(h);
e.push(g);
if(f==0){e.push("l")
}}e.push("x e");
var l=e.join(" ");
var j=(k.getWidth()-k.getHeight())/2;
if(j>0){k.bottom=k.bottom-j;
k.top=k.top+j
}else{k.left=k.left+j;
k.right=k.right-j
}a={path:l,size:k.getWidth(),left:k.left,bottom:k.bottom};
this.symbolCache[b]=a;
return a
},CLASS_NAME:"OpenLayers.Renderer.VML"});
OpenLayers.Renderer.VML.LABEL_SHIFT={l:0,c:0.5,r:1,t:0,m:0.5,b:1};Ext.namespace("GeoExt","GeoExt.data");
GeoExt.data.LayerReader=function(a,b){a=a||{};
if(!(b instanceof Function)){b=GeoExt.data.LayerRecord.create(b||a.fields||{})
}GeoExt.data.LayerReader.superclass.constructor.call(this,a,b)
};
Ext.extend(GeoExt.data.LayerReader,Ext.data.DataReader,{totalRecords:null,readRecords:function(f){var a=[];
if(f){var c=this.recordType,k=c.prototype.fields;
var g,d,e,b,h,n,l,m;
for(g=0,d=f.length;
g<d;
g++){h=f[g];
n={};
for(e=0,b=k.length;
e<b;
e++){l=k.items[e];
m=h[l.mapping||l.name]||l.defaultValue;
m=l.convert(m);
n[l.name]=m
}n.layer=h;
a[a.length]=new c(n,h.id)
}}return{records:a,totalRecords:this.totalRecords!=null?this.totalRecords:a.length}
}});OpenLayers.Format.WMSCapabilities.v1_1_0=OpenLayers.Class(OpenLayers.Format.WMSCapabilities.v1_1,{version:"1.1.0",initialize:function(a){OpenLayers.Format.WMSCapabilities.v1_1.prototype.initialize.apply(this,[a])
},readers:{wms:OpenLayers.Util.applyDefaults({SRS:function(e,f){var d=this.getChildValue(e);
var b=d.split(/ +/);
for(var c=0,a=b.length;
c<a;
c++){f.srs[b[c]]=true
}}},OpenLayers.Format.WMSCapabilities.v1_1.prototype.readers.wms)},CLASS_NAME:"OpenLayers.Format.WMSCapabilities.v1_1_0"});OpenLayers.Format.WMSCapabilities.v1_1_1=OpenLayers.Class(OpenLayers.Format.WMSCapabilities.v1_1,{version:"1.1.1",initialize:function(a){OpenLayers.Format.WMSCapabilities.v1_1.prototype.initialize.apply(this,[a])
},readers:{wms:OpenLayers.Util.applyDefaults({SRS:function(a,b){b.srs[this.getChildValue(a)]=true
}},OpenLayers.Format.WMSCapabilities.v1_1.prototype.readers.wms)},CLASS_NAME:"OpenLayers.Format.WMSCapabilities.v1_1_1"});OpenLayers.Control.ArgParser=OpenLayers.Class(OpenLayers.Control,{center:null,zoom:null,layers:null,displayProjection:null,initialize:function(a){OpenLayers.Control.prototype.initialize.apply(this,arguments)
},setMap:function(e){OpenLayers.Control.prototype.setMap.apply(this,arguments);
for(var c=0,a=this.map.controls.length;
c<a;
c++){var d=this.map.controls[c];
if((d!=this)&&(d.CLASS_NAME=="OpenLayers.Control.ArgParser")){if(d.displayProjection!=this.displayProjection){this.displayProjection=d.displayProjection
}break
}}if(c==this.map.controls.length){var b=OpenLayers.Util.getParameters();
if(b.layers){this.layers=b.layers;
this.map.events.register("addlayer",this,this.configureLayers);
this.configureLayers()
}if(b.lat&&b.lon){this.center=new OpenLayers.LonLat(parseFloat(b.lon),parseFloat(b.lat));
if(b.zoom){this.zoom=parseInt(b.zoom)
}this.map.events.register("changebaselayer",this,this.setCenter);
this.setCenter()
}}},setCenter:function(){if(this.map.baseLayer){this.map.events.unregister("changebaselayer",this,this.setCenter);
if(this.displayProjection){this.center.transform(this.displayProjection,this.map.getProjectionObject())
}this.map.setCenter(this.center,this.zoom)
}},configureLayers:function(){if(this.layers.length==this.map.layers.length){this.map.events.unregister("addlayer",this,this.configureLayers);
for(var d=0,a=this.layers.length;
d<a;
d++){var b=this.map.layers[d];
var e=this.layers.charAt(d);
if(e=="B"){this.map.setBaseLayer(b)
}else{if((e=="T")||(e=="F")){b.setVisibility(e=="T")
}}}}},CLASS_NAME:"OpenLayers.Control.ArgParser"});OpenLayers.Control.LoadingPanel=OpenLayers.Class(OpenLayers.Control,{counter:0,maximized:false,visible:true,initialize:function(a){OpenLayers.Control.prototype.initialize.apply(this,[a])
},setVisible:function(a){this.visible=a;
if(a){OpenLayers.Element.show(this.div)
}else{OpenLayers.Element.hide(this.div)
}},getVisible:function(){return this.visible
},hide:function(){this.setVisible(false)
},show:function(){this.setVisible(true)
},toggle:function(){this.setVisible(!this.getVisible())
},addLayer:function(a){if(a.layer){a.layer.events.register("loadstart",this,this.increaseCounter);
a.layer.events.register("loadend",this,this.decreaseCounter)
}},setMap:function(c){OpenLayers.Control.prototype.setMap.apply(this,arguments);
this.map.events.register("preaddlayer",this,this.addLayer);
for(var b=0;
b<this.map.layers.length;
b++){var a=this.map.layers[b];
a.events.register("loadstart",this,this.increaseCounter);
a.events.register("loadend",this,this.decreaseCounter)
}},increaseCounter:function(){this.counter++;
if(this.counter>0){if(!this.maximized&&this.visible){this.maximizeControl()
}}},decreaseCounter:function(){if(this.counter>0){this.counter--
}if(this.counter==0){if(this.maximized&&this.visible){this.minimizeControl()
}}},draw:function(){OpenLayers.Control.prototype.draw.apply(this,arguments);
return this.div
},minimizeControl:function(a){this.div.style.display="none";
this.div.style.width="0px";
this.div.style.height="0px";
this.maximized=false;
if(a!=null){OpenLayers.Event.stop(a)
}},maximizeControl:function(a){var d=this.map.getSize();
var b=d.w;
var c=d.h;
this.div.style.width=b+"px";
this.div.style.height=c+"px";
this.div.style.display="block";
this.maximized=true;
if(a!=null){OpenLayers.Event.stop(a)
}},destroy:function(){if(this.map){this.map.events.unregister("preaddlayer",this,this.addLayer);
if(this.map.layers){for(var b=0;
b<this.map.layers.length;
b++){var a=this.map.layers[b];
a.events.unregister("loadstart",this,this.increaseCounter);
a.events.unregister("loadend",this,this.decreaseCounter)
}}}OpenLayers.Control.prototype.destroy.apply(this,arguments)
},CLASS_NAME:"OpenLayers.Control.LoadingPanel"});OpenLayers.Control.ScaleBar=OpenLayers.Class(OpenLayers.Control,{element:null,scale:1,displaySystem:"metric",minWidth:100,maxWidth:200,divisions:2,subdivisions:2,showMinorMeasures:false,abbreviateLabel:false,singleLine:false,align:"left",div:null,scaleText:"scale 1:",thousandsSeparator:"",measurementProperties:{english:{units:["miles","feet","inches"],abbr:["mi","ft","in"],inches:[63360,12,1]},metric:{units:["kilometers","meters","centimeters"],abbr:["km","m","cm"],inches:[39370.07874,39.370079,0.393701]}},limitedStyle:false,customStyles:null,defaultStyles:{Bar:{height:11,top:12,borderLeftWidth:0,borderRightWidth:0},BarAlt:{height:11,top:12,borderLeftWidth:0,borderRightWidth:0},MarkerMajor:{height:13,width:13,top:12,borderLeftWidth:0,borderRightWidth:0},MarkerMinor:{height:13,width:13,top:12,borderLeftWidth:0,borderRightWidth:0},NumbersBox:{height:13,width:40,top:24},LabelBox:{height:15,top:-2},LabelBoxSingleLine:{height:15,width:35,top:5,left:10}},appliedStyles:null,initialize:function(a){OpenLayers.Control.prototype.initialize.apply(this,[a]);
if(!document.styleSheets){this.limitedStyle=true
}if(this.limitedStyle){this.appliedStyles=OpenLayers.Util.extend({},this.defaultStyles);
OpenLayers.Util.extend(this.appliedStyles,this.customStyles)
}this.element=document.createElement("div");
this.element.style.position="relative";
this.element.className=this.displayClass+"Wrapper";
this.labelContainer=document.createElement("div");
this.labelContainer.className=this.displayClass+"Units";
this.labelContainer.style.position="absolute";
this.graphicsContainer=document.createElement("div");
this.graphicsContainer.style.position="absolute";
this.graphicsContainer.className=this.displayClass+"Graphics";
this.numbersContainer=document.createElement("div");
this.numbersContainer.style.position="absolute";
this.numbersContainer.className=this.displayClass+"Numbers";
this.element.appendChild(this.graphicsContainer);
this.element.appendChild(this.labelContainer);
this.element.appendChild(this.numbersContainer)
},destroy:function(){this.map.events.unregister("moveend",this,this.onMoveend);
this.div.innerHTML="";
OpenLayers.Control.prototype.destroy.apply(this)
},draw:function(){OpenLayers.Control.prototype.draw.apply(this,arguments);
this.dxMarkerMajor=(this.styleValue("MarkerMajor","borderLeftWidth")+this.styleValue("MarkerMajor","width")+this.styleValue("MarkerMajor","borderRightWidth"))/2;
this.dxMarkerMinor=(this.styleValue("MarkerMinor","borderLeftWidth")+this.styleValue("MarkerMinor","width")+this.styleValue("MarkerMinor","borderRightWidth"))/2;
this.dxBar=(this.styleValue("Bar","borderLeftWidth")+this.styleValue("Bar","borderRightWidth"))/2;
this.dxBarAlt=(this.styleValue("BarAlt","borderLeftWidth")+this.styleValue("BarAlt","borderRightWidth"))/2;
this.dxNumbersBox=this.styleValue("NumbersBox","width")/2;
var d=["Bar","BarAlt","MarkerMajor","MarkerMinor"];
if(this.singleLine){d.push("LabelBoxSingleLine")
}else{d.push("NumbersBox","LabelBox")
}var a=0;
for(var c=0;
c<d.length;
++c){var b=d[c];
a=Math.max(a,this.styleValue(b,"top")+this.styleValue(b,"height"))
}this.element.style.height=a+"px";
this.xOffsetSingleLine=this.styleValue("LabelBoxSingleLine","width")+this.styleValue("LabelBoxSingleLine","left");
this.div.appendChild(this.element);
this.map.events.register("moveend",this,this.onMoveend);
this.update();
return this.div
},onMoveend:function(){this.update()
},update:function(e){if(this.map.baseLayer==null||!this.map.getScale()){return
}this.scale=(e!=undefined)?e:this.map.getScale();
this.element.title=this.scaleText+OpenLayers.Number.format(this.scale);
this.element.style.width=this.maxWidth+"px";
var i=this.getComp();
this.setSubProps(i);
this.labelContainer.innerHTML="";
this.graphicsContainer.innerHTML="";
this.numbersContainer.innerHTML="";
var d=this.divisions*this.subdivisions;
var j={left:0+(this.singleLine?0:this.dxNumbersBox),center:(this.maxWidth/2)-(d*this.subProps.pixels/2)-(this.singleLine?this.xOffsetSingleLine/2:0),right:this.maxWidth-(d*this.subProps.pixels)-(this.singleLine?this.xOffsetSingleLine:this.dxNumbersBox)};
var h,a,f,m,c;
for(var k=0;
k<this.divisions;
++k){h=k*this.subdivisions*this.subProps.pixels+j[this.align];
this.graphicsContainer.appendChild(this.createElement("MarkerMajor"," ",h-this.dxMarkerMajor));
if(!this.singleLine){a=(k==0)?0:OpenLayers.Number.format((k*this.subdivisions)*this.subProps.length,this.subProps.dec,this.thousandsSeparator);
this.numbersContainer.appendChild(this.createElement("NumbersBox",a,h-this.dxNumbersBox))
}for(var g=0;
g<this.subdivisions;
++g){if((g%2)==0){m="Bar";
c=h-this.dxBar
}else{m="BarAlt";
c=h-this.dxBarAlt
}this.graphicsContainer.appendChild(this.createElement(m," ",c,this.subProps.pixels));
if(g<this.subdivisions-1){f=(k*this.subdivisions)+g+1;
h=f*this.subProps.pixels+j[this.align];
this.graphicsContainer.appendChild(this.createElement("MarkerMinor"," ",h-this.dxMarkerMinor));
if(this.showMinorMeasures&&!this.singleLine){a=f*this.subProps.length;
this.numbersContainer.appendChild(this.createElement("NumbersBox",a,h-this.dxNumbersBox))
}}}}h=d*this.subProps.pixels;
h+=j[this.align];
this.graphicsContainer.appendChild(this.createElement("MarkerMajor"," ",h-this.dxMarkerMajor));
a=OpenLayers.Number.format(d*this.subProps.length,this.subProps.dec,this.thousandsSeparator);
if(!this.singleLine){this.numbersContainer.appendChild(this.createElement("NumbersBox",a,h-this.dxNumbersBox))
}var l=document.createElement("div");
l.style.position="absolute";
var b;
if(this.singleLine){b=a;
l.className=this.displayClass+"LabelBoxSingleLine";
l.style.left=Math.round(h+this.styleValue("LabelBoxSingleLine","left"))+"px"
}else{b="";
l.className=this.displayClass+"LabelBox";
l.style.textAlign="center";
l.style.width=Math.round(d*this.subProps.pixels)+"px";
l.style.left=Math.round(j[this.align])+"px";
l.style.overflow="hidden"
}if(this.abbreviateLabel){b+=" "+this.subProps.abbr
}else{b+=" "+this.subProps.units
}l.appendChild(document.createTextNode(b));
this.labelContainer.appendChild(l)
},createElement:function(a,e,d,c){var b=document.createElement("div");
b.className=this.displayClass+a;
OpenLayers.Util.extend(b.style,{position:"absolute",textAlign:"center",overflow:"hidden",left:Math.round(d)+"px"});
b.appendChild(document.createTextNode(e));
if(c){b.style.width=Math.round(c)+"px"
}return b
},getComp:function(){var d=this.measurementProperties[this.displaySystem];
var j=d.units.length;
var n=new Array(j);
var m=this.divisions*this.subdivisions;
for(var l=0;
l<j;
++l){n[l]={};
var e=OpenLayers.DOTS_PER_INCH*d.inches[l]/this.scale;
var o=((this.minWidth-this.dxNumbersBox)/e)/m;
var a=((this.maxWidth-this.dxNumbersBox)/e)/m;
for(var p=0;
p<m;
++p){var f=o*(p+1);
var c=a*(p+1);
var h=this.getHandsomeNumber(f,c);
var g={value:(h.value/(p+1)),score:0,tie:0,dec:0,displayed:0};
for(var q=0;
q<m;
++q){var r=h.value*(q+1)/(p+1);
var b=this.getHandsomeNumber(r,r);
var k=((q+1)%this.subdivisions==0);
var i=((q+1)==m);
if((this.singleLine&&i)||(!this.singleLine&&(k||this.showMinorMeasures))){g.score+=b.score;
g.tie+=b.tie;
g.dec=Math.max(g.dec,b.dec);
g.displayed+=1
}else{g.score+=b.score/this.subdivisions;
g.tie+=b.tie/this.subdivisions
}}g.score*=(l+1)*g.tie/g.displayed;
n[l][p]=g
}}return n
},setSubProps:function(b){var e=this.measurementProperties[this.displaySystem];
var h=Number.POSITIVE_INFINITY;
var f=Number.POSITIVE_INFINITY;
for(var d=0;
d<b.length;
++d){var a=OpenLayers.DOTS_PER_INCH*e.inches[d]/this.scale;
for(var g in b[d]){var c=b[d][g];
if((c.score<h)||((c.score==h)&&(c.tie<f))){this.subProps={length:c.value,pixels:a*c.value,units:e.units[d],abbr:e.abbr[d],dec:c.dec};
h=c.score;
f=c.tie
}}}},styleValue:function(a,h){var g=0;
if(this.limitedStyle){g=this.appliedStyles[a][h]
}else{a="."+this.displayClass+a;
rules:for(var d=document.styleSheets.length-1;
d>=0;
--d){var e=document.styleSheets[d];
if(!e.disabled){var j;
try{if(typeof(e.cssRules)=="undefined"){if(typeof(e.rules)=="undefined"){continue
}else{j=e.rules
}}else{j=e.cssRules
}}catch(b){continue
}for(var c=0;
c<j.length;
++c){var f=j[c];
if(f.selectorText&&(f.selectorText.toLowerCase()==a.toLowerCase())){if(f.style[h]!=""){g=parseInt(f.style[h]);
break rules
}}}}}}return g?g:0
},getHandsomeNumber:function(i,g,d){d=(d==null)?10:d;
var j={value:i,score:Number.POSITIVE_INFINITY,tie:Number.POSITIVE_INFINITY,dec:3};
var l,k,f,h,m,c,e;
for(var b=0;
b<3;
++b){l=Math.pow(2,(-1*b));
k=Math.floor(Math.log(g/l)/Math.LN10);
for(var a=k;
a>(k-d+1);
--a){f=Math.max(b-a,0);
h=l*Math.pow(10,a);
if((h*Math.floor(g/h))>=i){if(i%h==0){m=i/h
}else{m=Math.floor(i/h)+1
}c=m+(2*b);
e=(a<0)?(Math.abs(a)+1):a;
if((c<j.score)||((c==j.score)&&(e<j.tie))){j.value=parseFloat((h*m).toFixed(f));
j.score=c;
j.tie=e;
j.dec=f
}}}}return j
},CLASS_NAME:"OpenLayers.Control.ScaleBar"});