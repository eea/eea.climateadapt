var getGNServiceURL=function(a){return Env.locService+"/"+a
};
function init(){}function translate(a){return translations[a]||a
}function replaceStringParams(d,c){var b=d;
for(var a=0;
a<c.length;
a++){b=b.replace("$"+(a+1),c[a])
}return b
}function get_cookie(b){var a=document.cookie.match(b+"=(.*?)(;|$)");
if(a){return(unescape(a[1]))
}else{return null
}}function popNew(b){msgWindow=window.open(b,"displayWindow","location=no, toolbar=no, directories=no, status=no, menubar=no, scrollbars=yes, resizable=yes, width=800, height=600");
msgWindow.focus()
}function openPage(b,a){msgWindow=window.open(b,a,"location=yes, toolbar=yes, directories=yes, status=yes, menubar=yes, scrollbars=yes, resizable=yes, width=800, height=600");
msgWindow.focus()
}function popFeedback(b){msgWindow=window.open(b,"feedbackWindow","location=no, toolbar=no, directories=no, status=no, menubar=no, scrollbars=yes, resizable=yes, width=800, height=600");
msgWindow.focus()
}function popWindow(b){msgWindow=window.open(b,"popWindow","location=no, toolbar=no, directories=no, status=no, menubar=no, scrollbars=yes, resizable=yes, width=800, height=600");
msgWindow.focus()
}function popInterMap(b){msgWindow=window.open(b,"InterMap","location=no, toolbar=no, directories=no, status=no, menubar=no, scrollbars=yes, resizable=yes, width=800, height=600");
msgWindow.focus()
}function goSubmit(a){document.forms[a].submit()
}function goReset(a){document.forms[a].reset()
}function entSub(a){if(window.event&&window.event.keyCode==13){goSubmit(a)
}else{return true
}}function goBack(){history.back()
}function processCancel(){document.close()
}function load(a){document.location.href=a
}function doConfirm(a,b){if(confirm(b)){load(a);
return true
}return false
}function feedbackSubmit(){var a=$("feedbackf");
if(isWhitespace(a.comments.value)){a.comments.value=translate("noComment")
}if(isWhitespace(a.name.value)||isWhitespace(a.org.value)){alert(translate("addName"));
return
}else{if(!isEmail(a.email.value)){alert(translate("checkEmail"));
return
}}Modalbox.show(getGNServiceURL("file.download"),{height:400,width:600,params:a.serialize(true)})
}function doDownload(g,e){var f=$("downloadlist").getElementsByTagName("INPUT");
var c="&id="+g+"&access=private";
var d=false;
for(var b=0;
b<f.length;
b++){if(f[b].checked||e!=null){d=true;
var a=f[b].getAttribute("name");
c+="&fname="+a
}}if(!d){alert(translate("selectOneFile"));
return
}Modalbox.show(getGNServiceURL("file.disclaimer")+"?"+c,{height:400,width:600})
}function massiveOperation(a,e,c,d){if(d!=null){if(!confirm(d)){return
}}var b=Env.locService+"/"+a;
Modalbox.show(b,{title:e,width:c,afterHide:function(){if($("simple_search_pnl").visible()){runSimpleSearch()
}else{if($("advanced_search_pnl").visible()){runAdvancedSearch()
}else{$("search-results-content").hide()
}}runRssSearch()
}})
}function oActionsInit(a,b){if(b===undefined){b=""
}$(a+"Ele"+b).style.width=$(a+b).getWidth();
$(a+"Ele"+b).style.top=$(a+b).positionedOffset().top+$(a+b).getHeight()+"px";
$(a+"Ele"+b).style.left=$(a+b).positionedOffset().left+"px"
}function oActions(b,d){var a="../../images/plus.gif";
var c="../../images/minus.png";
if(d===undefined){d=""
}oActionsInit(b,d);
if($(b+"Ele"+d).style.display=="none"){$(b+"Ele"+d).style.display="block";
$(b+"Img"+d).src=c
}else{$(b+"Ele"+d).style.display="none";
$(b+"Img"+d).src=a
}}function actionOnSelect(a){if($("nbselected").innerHTML==0&&$("oAcOsEle").style.display=="none"){alert(a)
}else{oActions("oAcOs")
}}function checkMassiveNewOwner(a,b){if($("user").value==""){alert(translate("selectNewOwner"));
return false
}if($("group").value==""){alert(translate("selectOwnerGroup"));
return false
}Modalbox.show(getGNServiceURL(a),{title:b,params:$("massivenewowner").serialize(true),afterHide:function(){if($("simple_search_pnl").visible()){runSimpleSearch()
}else{if($("advanced_search_pnl").visible()){runAdvancedSearch()
}else{$("search-results-content").hide()
}}runRssSearch()
}})
}function addGroups(b){var e=xml.children(b,"group");
$("group").options.length=0;
for(var d=0;
d<e.length;
d++){var f=xml.evalXPath(e[d],"id");
var a=xml.evalXPath(e[d],"name");
var c=document.createElement("option");
c.text=a;
c.value=f;
if(e.length==1){c.selected=true
}$("group").options.add(c)
}}function addGroupsCallback_OK(b){if(b.nodeName=="error"){ker.showError(translate("cannotRetrieveGroup"),b);
$("group").options.length=0;
$("group").value="";
var a=$("user");
for(i=0;
i<a.options.length;
i++){a.options[i].selected=false
}}else{addGroups(b)
}}function doGroups(a){var b=ker.createRequest("id",a);
ker.send("xml.usergroups.list",b,addGroupsCallback_OK)
}function processRegSub(b){var d=" ";
var a=6;
if(document.userregisterform.name.value.length==0){alert(translate("firstNameMandatory"));
return
}if(isWhitespace(document.userregisterform.name.value)){alert(translate("firstNameMandatory"));
return
}if(document.userregisterform.name.value.indexOf(d)>-1){alert(translate("spacesNot"));
return
}if(document.userregisterform.surname.value.length==0){alert(translate("lastNameMandatory"));
return
}if(isWhitespace(document.userregisterform.surname.value)){alert(translate("lastNameMandatory"));
return
}if(document.userregisterform.surname.value.indexOf(d)>-1){alert(translate("spacesNot"));
return
}if(!isEmail(document.userregisterform.email.value)){alert(translate("emailAddressInvalid"));
return
}var c=new Ajax.Request(getGNServiceURL(b),{method:"post",parameters:$("userregisterform").serialize(true),onSuccess:function(f){var e=f.responseText;
var g=translate("yourRegistration");
Modalbox.show(e,{title:g,width:300})
},onFailure:function(e){alert(translate("registrationFailed")+" "+e.responseText+" status: "+e.status+" - "+translate("tryAgain"))
}})
}function displayBox(c,d,b){var e=d+"Box";
var a=Ext.getCmp(e);
if(a==undefined){a=new Ext.Window({title:translate(d),id:e,layout:"fit",modal:b,constrain:true,width:400,collapsible:(b?false:true),autoScroll:true,iconCls:d+"Icon",closeAction:"hide",onEsc:"hide",listeners:{hide:function(){this.hide()
}},contentEl:d})
}if(a){if(c!=null){$(d).innerHTML="";
$(d).innerHTML=c;
$(d).style.display="block"
}a.show();
a.setHeight(345);
a.anchorTo(Ext.getBody(),(b?"c-c":"tr-tr"))
}};if(!window.Modalbox){var Modalbox=new Object()
}Modalbox.Methods={overrideAlert:false,focusableElements:new Array,currFocused:0,initialized:false,active:true,options:{title:"ModalBox Window",overlayClose:true,width:500,height:90,overlayOpacity:0.65,overlayDuration:0.25,slideDownDuration:0.5,slideUpDuration:0.5,resizeDuration:0.25,inactiveFade:true,transitions:false,loadingString:"Please wait. Loading...",closeString:"Close window",closeValue:"&times;",params:{},method:"get",autoFocusing:true,aspnet:false},_options:new Object,setOptions:function(a){Object.extend(this.options,a||{})
},_init:function(b){Object.extend(this._options,this.options);
this.setOptions(b);
this.MBoverlay=new Element("div",{id:"MB_overlay",opacity:"0"});
this.MBwindow=new Element("div",{id:"MB_window",style:"display: none"}).update(this.MBframe=new Element("div",{id:"MB_frame"}).update(this.MBheader=new Element("div",{id:"MB_header"}).update(this.MBcaption=new Element("div",{id:"MB_caption"}))));
this.MBclose=new Element("a",{id:"MB_close",title:this.options.closeString,href:"#"}).update("<span>"+this.options.closeValue+"</span>");
this.MBheader.insert({bottom:this.MBclose});
this.MBcontent=new Element("div",{id:"MB_content"}).update(this.MBloading=new Element("div",{id:"MB_loading"}).update(this.options.loadingString));
this.MBframe.insert({bottom:this.MBcontent});
var a=this.options.aspnet?$(document.body).down("form"):$(document.body);
a.insert({top:this.MBwindow});
a.insert({top:this.MBoverlay});
this.initScrollX=window.pageXOffset||document.body.scrollLeft||document.documentElement.scrollLeft;
this.initScrollY=window.pageYOffset||document.body.scrollTop||document.documentElement.scrollTop;
this.hideObserver=this._hide.bindAsEventListener(this);
this.kbdObserver=this._kbdHandler.bindAsEventListener(this);
this._initObservers();
this.initialized=true
},show:function(b,a){if(!this.initialized){this._init(a)
}this.content=b;
this.setOptions(a);
if(this.options.title){$(this.MBcaption).update(this.options.title)
}else{$(this.MBheader).hide();
$(this.MBcaption).hide()
}if(this.MBwindow.style.display=="none"){this._appear();
this.event("onShow")
}else{this._update();
this.event("onUpdate")
}},hide:function(a){if(this.initialized){if(a&&typeof a.element!="function"){Object.extend(this.options,a)
}this.event("beforeHide");
if(this.options.transitions){Effect.SlideUp(this.MBwindow,{duration:this.options.slideUpDuration,transition:Effect.Transitions.sinoidal,afterFinish:this._deinit.bind(this)})
}else{$(this.MBwindow).hide();
this._deinit()
}}else{throw ("Modalbox is not initialized.")
}},_hide:function(a){a.stop();
if(a.element().id=="MB_overlay"&&!this.options.overlayClose){return false
}this.hide()
},alert:function(b){var a='<div class="MB_alert"><p>'+b+'</p><input type="button" onclick="Modalbox.hide()" value="OK" /></div>';
Modalbox.show(a,{title:"Alert: "+document.title,width:300})
},_appear:function(){if(Prototype.Browser.IE&&!navigator.appVersion.match(/\b7.0\b/)){window.scrollTo(0,0);
this._prepareIE("100%","hidden")
}this._setWidth();
this._setPosition();
if(this.options.transitions){$(this.MBoverlay).setStyle({opacity:0});
new Effect.Fade(this.MBoverlay,{from:0,to:this.options.overlayOpacity,duration:this.options.overlayDuration,afterFinish:function(){new Effect.SlideDown(this.MBwindow,{duration:this.options.slideDownDuration,transition:Effect.Transitions.sinoidal,afterFinish:function(){this._setPosition();
this.loadContent()
}.bind(this)})
}.bind(this)})
}else{$(this.MBoverlay).setStyle({opacity:this.options.overlayOpacity});
$(this.MBwindow).show();
this._setPosition();
this.loadContent()
}this._setWidthAndPosition=this._setWidthAndPosition.bindAsEventListener(this);
Event.observe(window,"resize",this._setWidthAndPosition)
},resize:function(g,h,c){var f=$(this.MBwindow).getHeight();
var d=$(this.MBwindow).getWidth();
var e=$(this.MBheader).getHeight();
var b=$(this.MBcontent).getHeight();
var a=((f-e+h)<b)?(b+e-f):h;
if(c){this.setOptions(c)
}if(this.options.transitions){new Effect.ScaleBy(this.MBwindow,g,a,{duration:this.options.resizeDuration,afterFinish:function(){this.event("_afterResize");
this.event("afterResize")
}.bind(this)})
}else{this.MBwindow.setStyle({width:d+g+"px",height:f+a+"px"});
if(Prototype.Browser.Gecko){this.MBwindow.setStyle({overflow:"hidden"})
}setTimeout(function(){this.event("_afterResize");
this.event("afterResize")
}.bind(this),1)
}},resizeToContent:function(a){var b=this.options.height-this.MBwindow.offsetHeight;
if(b!=0){if(a){this.setOptions(a)
}Modalbox.resize(0,b)
}},resizeToInclude:function(c,b){var d=$(c);
var a=d.getHeight()+parseInt(d.getStyle("margin-top"))+parseInt(d.getStyle("margin-bottom"))+parseInt(d.getStyle("border-top-width"))+parseInt(d.getStyle("border-bottom-width"));
if(a>0){if(b){this.setOptions(b)
}Modalbox.resize(0,a)
}},_update:function(){$(this.MBcontent).update("");
this.MBcontent.appendChild(this.MBloading);
$(this.MBloading).update(this.options.loadingString);
this.currentDims=[this.MBwindow.offsetWidth,this.MBwindow.offsetHeight];
Modalbox.resize((this.options.width-this.currentDims[0]),(this.options.height-this.currentDims[1]),{_afterResize:this._loadAfterResize.bind(this)})
},loadContent:function(){if(this.event("beforeLoad")!=false){if(typeof this.content=="string"){var htmlRegExp=new RegExp(/<\/?[^>]+>/gi);
if(htmlRegExp.test(this.content)){this._insertContent(this.content.stripScripts());
this._putContent(function(){this.content.extractScripts().map(function(script){return eval(script.replace("<!--","").replace("// -->",""))
}.bind(window))
}.bind(this))
}else{new Ajax.Request(this.content,{method:this.options.method.toLowerCase(),parameters:this.options.params,onSuccess:function(transport){var response=new String(transport.responseText);
this._insertContent(transport.responseText.stripScripts());
this._putContent(function(){response.extractScripts().map(function(script){return eval(script.replace("<!--","").replace("// -->",""))
}.bind(window))
})
}.bind(this),onException:function(instance,exception){Modalbox.hide();
throw ("Modalbox Loading Error: "+exception)
}})
}}else{if(typeof this.content=="object"){this._insertContent(this.content);
this._putContent()
}else{Modalbox.hide();
throw ("Modalbox Parameters Error: Please specify correct URL or HTML element (plain HTML or object)")
}}}},_insertContent:function(b){$(this.MBcontent).hide().update("");
if(typeof b=="string"){setTimeout(function(){this.MBcontent.update(b)
}.bind(this),1)
}else{if(typeof b=="object"){var a=b.cloneNode(true);
if(b.id){b.id="MB_"+b.id
}$(b).select("*[id]").each(function(c){c.id="MB_"+c.id
});
this.MBcontent.appendChild(a);
this.MBcontent.down().show();
if(Prototype.Browser.IE){$$("#MB_content select").invoke("setStyle",{visibility:""})
}}}},_putContent:function(a){if(this.options.height==this._options.height){setTimeout(function(){Modalbox.resize(0,$(this.MBcontent).getHeight()-$(this.MBwindow).getHeight()+$(this.MBheader).getHeight(),{afterResize:function(){this.MBcontent.show().makePositioned();
this.focusableElements=this._findFocusableElements();
this._setFocus();
setTimeout(function(){if(a!=undefined){a()
}this.event("afterLoad")
}.bind(this),1)
}.bind(this)})
}.bind(this),1)
}else{setTimeout(function(){this._setWidth();
if(Prototype.Browser.Gecko){this.MBwindow.setStyle({overflow:"hidden"})
}this.MBcontent.setStyle({overflow:"auto",height:$(this.MBwindow).getHeight()-$(this.MBheader).getHeight()-20+"px"});
this.MBcontent.show();
this.focusableElements=this._findFocusableElements();
this._setFocus();
if(a!=undefined){a()
}this.event("afterLoad")
}.bind(this),1)
}},activate:function(a){this.setOptions(a);
this.active=true;
$(this.MBclose).observe("click",this.hideObserver);
if(this.options.overlayClose){$(this.MBoverlay).observe("click",this.hideObserver)
}$(this.MBclose).show();
if(this.options.transitions&&this.options.inactiveFade){new Effect.Appear(this.MBwindow,{duration:this.options.slideUpDuration})
}},deactivate:function(a){this.setOptions(a);
this.active=false;
$(this.MBclose).stopObserving("click",this.hideObserver);
if(this.options.overlayClose){$(this.MBoverlay).stopObserving("click",this.hideObserver)
}$(this.MBclose).hide();
if(this.options.transitions&&this.options.inactiveFade){new Effect.Fade(this.MBwindow,{duration:this.options.slideUpDuration,to:0.75})
}},_initObservers:function(){$(this.MBclose).observe("click",this.hideObserver);
if(this.options.overlayClose){$(this.MBoverlay).observe("click",this.hideObserver)
}if(Prototype.Browser.IE){Event.observe(document,"keydown",this.kbdObserver)
}else{Event.observe(document,"keypress",this.kbdObserver)
}},_removeObservers:function(){$(this.MBclose).stopObserving("click",this.hideObserver);
if(this.options.overlayClose){$(this.MBoverlay).stopObserving("click",this.hideObserver)
}if(Prototype.Browser.IE){Event.stopObserving(document,"keydown",this.kbdObserver)
}else{Event.stopObserving(document,"keypress",this.kbdObserver)
}},_loadAfterResize:function(){this._setWidth();
this._setPosition();
this.loadContent()
},_setFocus:function(){if(this.focusableElements.length>0&&this.options.autoFocusing==true){var a=this.focusableElements.find(function(b){return b.tabIndex==1
})||this.focusableElements.first();
this.currFocused=this.focusableElements.toArray().indexOf(a);
a.focus()
}else{if($(this.MBclose).visible()){$(this.MBclose).focus()
}}},_findFocusableElements:function(){var e=[];
var d=this.MBcontent.descendants();
for(var b=0,a=d.length;
b<a;
++b){var c=d[b];
if(["textarea","select","button"].include(c.tagName.toLowerCase())){e.push(c)
}else{if(c.tagName.toLowerCase()=="input"&&c.visible()&&c.type!="hidden"){e.push(c)
}else{if(c.tagName.toLowerCase()=="a"&&c.href){e.push(c)
}}}}e.invoke("addClassName","MB_focusable");
return e
},_kbdHandler:function(b){var a=b.element();
switch(b.keyCode){case Event.KEY_TAB:b.stop();
if(a!=this.focusableElements[this.currFocused]){this.currFocused=this.focusableElements.toArray().indexOf(a)
}if(!b.shiftKey){if(this.currFocused==this.focusableElements.length-1){if(this.focusableElements.first()!=null){this.focusableElements.first().focus()
}this.currFocused=0
}else{this.currFocused++;
this.focusableElements[this.currFocused].focus()
}}else{if(this.currFocused==0){this.focusableElements.last().focus();
this.currFocused=this.focusableElements.length-1
}else{this.currFocused--;
this.focusableElements[this.currFocused].focus()
}}break;
case Event.KEY_ESC:if(this.active){this._hide(b)
}break;
case 32:this._preventScroll(b);
break;
case 0:if(b.which==32){this._preventScroll(b)
}break;
case Event.KEY_UP:case Event.KEY_DOWN:case Event.KEY_PAGEDOWN:case Event.KEY_PAGEUP:case Event.KEY_HOME:case Event.KEY_END:if(Prototype.Browser.WebKit&&!["textarea","select"].include(a.tagName.toLowerCase())){b.stop()
}else{if((a.tagName.toLowerCase()=="input"&&["submit","button"].include(a.type))||(a.tagName.toLowerCase()=="a")){b.stop()
}}break
}},_preventScroll:function(a){if(!["input","textarea","select","button"].include(a.element().tagName.toLowerCase())){a.stop()
}},_deinit:function(){this._removeObservers();
Event.stopObserving(window,"resize",this._setWidthAndPosition);
if(this.options.transitions){Effect.toggle(this.MBoverlay,"appear",{duration:this.options.overlayDuration,afterFinish:this._removeElements.bind(this)})
}else{this.MBoverlay.hide();
this._removeElements()
}$(this.MBcontent).setStyle({overflow:"",height:""})
},_removeElements:function(){$(this.MBoverlay).remove();
$(this.MBwindow).remove();
if(Prototype.Browser.IE&&!navigator.appVersion.match(/\b7.0\b/)){this._prepareIE("","");
window.scrollTo(this.initScrollX,this.initScrollY)
}if(typeof this.content=="object"){if(this.content.id&&this.content.id.match(/MB_/)){this.content.id=this.content.id.replace(/MB_/,"")
}this.content.select("*[id]").each(function(a){a.id=a.id.replace(/MB_/,"")
})
}this.initialized=false;
this.event("afterHide");
this.setOptions(this._options)
},_setWidth:function(){$(this.MBwindow).setStyle({width:this.options.width+"px",height:this.options.height+"px"})
},_setPosition:function(){$(this.MBwindow).setStyle({left:Math.round((Element.getWidth(document.body)-Element.getWidth(this.MBwindow))/2)+"px"})
},_setWidthAndPosition:function(){$(this.MBwindow).setStyle({width:this.options.width+"px"});
this._setPosition()
},_getScrollTop:function(){var a;
if(document.documentElement&&document.documentElement.scrollTop){a=document.documentElement.scrollTop
}else{if(document.body){a=document.body.scrollTop
}}return a
},_prepareIE:function(a,b){$$("html, body").invoke("setStyle",{width:a,height:a,overflow:b});
$$("select").invoke("setStyle",{visibility:b})
},event:function(a){if(this.options[a]){var b=this.options[a]();
this.options[a]=null;
if(b!=undefined){return b
}else{return true
}}return true
}};
Object.extend(Modalbox,Modalbox.Methods);
if(Modalbox.overrideAlert){window.alert=Modalbox.alert
}Effect.ScaleBy=Class.create();
Object.extend(Object.extend(Effect.ScaleBy.prototype,Effect.Base.prototype),{initialize:function(b,c,d,a){this.element=$(b);
var a=Object.extend({scaleFromTop:true,scaleMode:"box",scaleByWidth:c,scaleByHeight:d},arguments[3]||{});
this.start(a)
},setup:function(){this.elementPositioning=this.element.getStyle("position");
this.originalTop=this.element.offsetTop;
this.originalLeft=this.element.offsetLeft;
this.dims=null;
if(this.options.scaleMode=="box"){this.dims=[this.element.offsetHeight,this.element.offsetWidth]
}if(/^content/.test(this.options.scaleMode)){this.dims=[this.element.scrollHeight,this.element.scrollWidth]
}if(!this.dims){this.dims=[this.options.scaleMode.originalHeight,this.options.scaleMode.originalWidth]
}this.deltaY=this.options.scaleByHeight;
this.deltaX=this.options.scaleByWidth
},update:function(a){var c=this.dims[0]+(this.deltaY*a);
var b=this.dims[1]+(this.deltaX*a);
c=(c>0)?c:0;
b=(b>0)?b:0;
this.setDimensions(c,b)
},setDimensions:function(a,e){var f={};
f.width=e+"px";
f.height=a+"px";
var c=Math.round((a-this.dims[0])/2);
var b=Math.round((e-this.dims[1])/2);
if(this.elementPositioning=="absolute"||this.elementPositioning=="fixed"){if(!this.options.scaleFromTop){f.top=this.originalTop-c+"px"
}f.left=this.originalLeft-b+"px"
}else{if(!this.options.scaleFromTop){f.top=-c+"px"
}f.left=-b+"px"
}this.element.setStyle(f)
}});var digits="0123456789";
var lowercaseLetters="abcdefghijklmnopqrstuvwxyz";
var uppercaseLetters="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
var whitespace=" \t\n\r";
var decimalPointDelimiter=".";
var phoneNumberDelimiters="()- ";
var validUSPhoneChars=digits+phoneNumberDelimiters;
var validWorldPhoneChars=digits+phoneNumberDelimiters+"+";
var SSNDelimiters="- ";
var validSSNChars=digits+SSNDelimiters;
var digitsInSocialSecurityNumber=9;
var digitsInUSPhoneNumber=10;
var ZIPCodeDelimiters="-";
var ZIPCodeDelimeter="-";
var validZIPCodeChars=digits+ZIPCodeDelimiters;
var digitsInZIPCode1=5;
var digitsInZIPCode2=9;
var creditCardDelimiters=" ";
var mPrefix="You did not enter a value into the ";
var mSuffix=" field. This is a required field. Please enter it now.";
var sUSLastName="Last Name";
var sUSFirstName="First Name";
var sWorldLastName="Family Name";
var sWorldFirstName="Given Name";
var sTitle="Title";
var sCompanyName="Company Name";
var sUSAddress="Street Address";
var sWorldAddress="Address";
var sCity="City";
var sStateCode="State Code";
var sWorldState="State, Province, or Prefecture";
var sCountry="Country";
var sZIPCode="ZIP Code";
var sWorldPostalCode="Postal Code";
var sPhone="Phone Number";
var sFax="Fax Number";
var sDateOfBirth="Date of Birth";
var sExpirationDate="Expiration Date";
var sEmail="Email";
var sSSN="Social Security Number";
var sCreditCardNumber="Credit Card Number";
var sOtherInfo="Other Information";
var iStateCode="This field must be a valid two character U.S. state abbreviation (like CA for California). Please reenter it now.";
var iZIPCode="This field must be a 5 or 9 digit U.S. ZIP Code (like 94043). Please reenter it now.";
var iUSPhone="This field must be a 10 digit U.S. phone number (like 415 555 1212). Please reenter it now.";
var iWorldPhone="This field must be a valid international phone number. Please reenter it now.";
var iSSN="This field must be a 9 digit U.S. social security number (like 123 45 6789). Please reenter it now.";
var iEmail="This field must be a valid email address (like foo@bar.com). Please reenter it now.";
var iCreditCardPrefix="This is not a valid ";
var iCreditCardSuffix=" credit card number. (Click the link on this form to see a list of sample numbers.) Please reenter it now.";
var iDay="This field must be a day number between 1 and 31.  Please reenter it now.";
var iMonth="This field must be a month number between 1 and 12.  Please reenter it now.";
var iYear="This field must be a 2 or 4 digit year number.  Please reenter it now.";
var iDatePrefix="The Day, Month, and Year for ";
var iDateSuffix=" do not form a valid date.  Please reenter them now.";
var pEntryPrompt="Please enter a ";
var pStateCode="2 character code (like CA).";
var pZIPCode="5 or 9 digit U.S. ZIP Code (like 94043).";
var pUSPhone="10 digit U.S. phone number (like 415 555 1212).";
var pWorldPhone="international phone number.";
var pSSN="9 digit U.S. social security number (like 123 45 6789).";
var pEmail="valid email address (like foo@bar.com).";
var pCreditCard="valid credit card number.";
var pDay="day number between 1 and 31.";
var pMonth="month number between 1 and 12.";
var pYear="2 or 4 digit year number.";
var defaultEmptyOK=false;
function makeArray(b){for(var a=1;
a<=b;
a++){this[a]=0
}return this
}var daysInMonth=makeArray(12);
daysInMonth[1]=31;
daysInMonth[2]=29;
daysInMonth[3]=31;
daysInMonth[4]=30;
daysInMonth[5]=31;
daysInMonth[6]=30;
daysInMonth[7]=31;
daysInMonth[8]=31;
daysInMonth[9]=30;
daysInMonth[10]=31;
daysInMonth[11]=30;
daysInMonth[12]=31;
var USStateCodeDelimiter="|";
var USStateCodes="AL|AK|AS|AZ|AR|CA|CO|CT|DE|DC|FM|FL|GA|GU|HI|ID|IL|IN|IA|KS|KY|LA|ME|MH|MD|MA|MI|MN|MS|MO|MT|NE|NV|NH|NJ|NM|NY|NC|ND|MP|OH|OK|OR|PW|PA|PR|RI|SC|SD|TN|TX|UT|VT|VI|VA|WA|WV|WI|WY|AE|AA|AE|AE|AP";
function isEmpty(a){return((a==null)||(a.length==0))
}function isWhitespace(b){var a;
if(isEmpty(b)){return true
}for(a=0;
a<b.length;
a++){var d=b.charAt(a);
if(whitespace.indexOf(d)==-1){return false
}}return true
}function stripCharsInBag(d,e){var b;
var a="";
for(b=0;
b<d.length;
b++){var f=d.charAt(b);
if(e.indexOf(f)==-1){a+=f
}}return a
}function stripCharsNotInBag(d,e){var b;
var a="";
for(b=0;
b<d.length;
b++){var f=d.charAt(b);
if(e.indexOf(f)!=-1){a+=f
}}return a
}function stripWhitespace(a){return stripCharsInBag(a,whitespace)
}function charInString(b,a){for(i=0;
i<a.length;
i++){if(a.charAt(i)==b){return true
}}return false
}function stripInitialWhitespace(b){var a=0;
while((a<b.length)&&charInString(b.charAt(a),whitespace)){a++
}return b.substring(a,b.length)
}function isLetter(a){return(((a>="a")&&(a<="z"))||((a>="A")&&(a<="Z")))
}function isDigit(a){return((a>="0")&&(a<="9"))
}function isLetterOrDigit(a){return(isLetter(a)||isDigit(a))
}function isInteger(b){var a;
if(isEmpty(b)){if(isInteger.arguments.length==1){return defaultEmptyOK
}else{return(isInteger.arguments[1]==true)
}}for(a=0;
a<b.length;
a++){var d=b.charAt(a);
if(!isDigit(d)){return false
}}return true
}function isSignedInteger(c){if(isEmpty(c)){if(isSignedInteger.arguments.length==1){return defaultEmptyOK
}else{return(isSignedInteger.arguments[1]==true)
}}else{var b=0;
var a=defaultEmptyOK;
if(isSignedInteger.arguments.length>1){a=isSignedInteger.arguments[1]
}if((c.charAt(0)=="-")||(c.charAt(0)=="+")){b=1
}return(isInteger(c.substring(b,c.length),a))
}}function isPositiveInteger(b){var a=defaultEmptyOK;
if(isPositiveInteger.arguments.length>1){a=isPositiveInteger.arguments[1]
}return(isSignedInteger(b,a)&&((isEmpty(b)&&a)||(parseInt(b)>0)))
}function isNonnegativeInteger(b){var a=defaultEmptyOK;
if(isNonnegativeInteger.arguments.length>1){a=isNonnegativeInteger.arguments[1]
}return(isSignedInteger(b,a)&&((isEmpty(b)&&a)||(parseInt(b)>=0)))
}function isNegativeInteger(b){var a=defaultEmptyOK;
if(isNegativeInteger.arguments.length>1){a=isNegativeInteger.arguments[1]
}return(isSignedInteger(b,a)&&((isEmpty(b)&&a)||(parseInt(b)<0)))
}function isNonpositiveInteger(b){var a=defaultEmptyOK;
if(isNonpositiveInteger.arguments.length>1){a=isNonpositiveInteger.arguments[1]
}return(isSignedInteger(b,a)&&((isEmpty(b)&&a)||(parseInt(b)<=0)))
}function isFloat(d){var b;
var a=false;
if(isEmpty(d)){if(isFloat.arguments.length==1){return defaultEmptyOK
}else{return(isFloat.arguments[1]==true)
}}if(d==decimalPointDelimiter){return false
}for(b=0;
b<d.length;
b++){var e=d.charAt(b);
if((e==decimalPointDelimiter)&&!a){a=true
}else{if(!isDigit(e)){return false
}}}return true
}function isSignedFloat(c){if(isEmpty(c)){if(isSignedFloat.arguments.length==1){return defaultEmptyOK
}else{return(isSignedFloat.arguments[1]==true)
}}else{var b=0;
var a=defaultEmptyOK;
if(isSignedFloat.arguments.length>1){a=isSignedFloat.arguments[1]
}if((c.charAt(0)=="-")||(c.charAt(0)=="+")){b=1
}return(isFloat(c.substring(b,c.length),a))
}}function isAlphabetic(b){var a;
if(isEmpty(b)){if(isAlphabetic.arguments.length==1){return defaultEmptyOK
}else{return(isAlphabetic.arguments[1]==true)
}}for(a=0;
a<b.length;
a++){var d=b.charAt(a);
if(!isLetter(d)){return false
}}return true
}function isAlphanumeric(b){var a;
if(isEmpty(b)){if(isAlphanumeric.arguments.length==1){return defaultEmptyOK
}else{return(isAlphanumeric.arguments[1]==true)
}}for(a=0;
a<b.length;
a++){var d=b.charAt(a);
if(!(isLetter(d)||isDigit(d))){return false
}}return true
}function reformat(d){var a;
var b=0;
var e="";
for(var c=1;
c<reformat.arguments.length;
c++){a=reformat.arguments[c];
if(c%2==1){e+=a
}else{e+=d.substring(b,b+a);
b+=a
}}return e
}function isSSN(a){if(isEmpty(a)){if(isSSN.arguments.length==1){return defaultEmptyOK
}else{return(isSSN.arguments[1]==true)
}}return(isInteger(a)&&a.length==digitsInSocialSecurityNumber)
}function isUSPhoneNumber(a){if(isEmpty(a)){if(isUSPhoneNumber.arguments.length==1){return defaultEmptyOK
}else{return(isUSPhoneNumber.arguments[1]==true)
}}return(isInteger(a)&&a.length==digitsInUSPhoneNumber)
}function isInternationalPhoneNumber(a){if(isEmpty(a)){if(isInternationalPhoneNumber.arguments.length==1){return defaultEmptyOK
}else{return(isInternationalPhoneNumber.arguments[1]==true)
}}return(isPositiveInteger(a))
}function isZIPCode(a){if(isEmpty(a)){if(isZIPCode.arguments.length==1){return defaultEmptyOK
}else{return(isZIPCode.arguments[1]==true)
}}return(isInteger(a)&&((a.length==digitsInZIPCode1)||(a.length==digitsInZIPCode2)))
}function isStateCode(a){if(isEmpty(a)){if(isStateCode.arguments.length==1){return defaultEmptyOK
}else{return(isStateCode.arguments[1]==true)
}}return((USStateCodes.indexOf(a)!=-1)&&(a.indexOf(USStateCodeDelimiter)==-1))
}function isEmail(b){if(isEmpty(b)){if(isEmail.arguments.length==1){return defaultEmptyOK
}else{return(isEmail.arguments[1]==true)
}}if(isWhitespace(b)){return false
}var a=1;
var c=b.length;
while((a<c)&&(b.charAt(a)!="@")){a++
}if((a>=c)||(b.charAt(a)!="@")){return false
}else{a+=2
}while((a<c)&&(b.charAt(a)!=".")){a++
}if((a>=c-1)||(b.charAt(a)!=".")){return false
}else{return true
}}function isYear(a){if(isEmpty(a)){if(isYear.arguments.length==1){return defaultEmptyOK
}else{return(isYear.arguments[1]==true)
}}if(!isNonnegativeInteger(a)){return false
}return((a.length==2)||(a.length==4))
}function isIntegerInRange(f,d,c){if(isEmpty(f)){if(isIntegerInRange.arguments.length==3){return defaultEmptyOK
}else{return(isIntegerInRange.arguments[3]==true)
}}if(!isInteger(f,false)){return false
}var e=parseInt(f);
return((e>=d)&&(e<=c))
}function isMonth(a){if(isEmpty(a)){if(isMonth.arguments.length==1){return defaultEmptyOK
}else{return(isMonth.arguments[1]==true)
}}return isIntegerInRange(a,1,12)
}function isDay(a){if(isEmpty(a)){if(isDay.arguments.length==1){return defaultEmptyOK
}else{return(isDay.arguments[1]==true)
}}return isIntegerInRange(a,1,31)
}function daysInFebruary(a){return(((a%4==0)&&((!(a%100==0))||(a%400==0)))?29:28)
}function isDate(b,e,a){if(!(isYear(b,false)&&isMonth(e,false)&&isDay(a,false))){return false
}var c=parseInt(b);
var d=parseInt(e);
var f=parseInt(a);
if(f>daysInMonth[d]){return false
}if((d==2)&&(f>daysInFebruary(c))){return false
}return true
}function prompt(a){window.status=a
}function promptEntry(a){window.status=pEntryPrompt+a
}function warnEmpty(a,b){a.focus();
alert(mPrefix+b+mSuffix);
return false
}function warnInvalid(a,b){a.focus();
a.select();
alert(b);
return false
}function checkString(a,c,b){if(checkString.arguments.length==2){b=defaultEmptyOK
}if((b==true)&&(isEmpty(a.value))){return true
}if(isWhitespace(a.value)){return warnEmpty(a,c)
}else{return true
}}function checkStateCode(a,b){if(checkStateCode.arguments.length==1){b=defaultEmptyOK
}if((b==true)&&(isEmpty(a.value))){return true
}else{a.value=a.value.toUpperCase();
if(!isStateCode(a.value,false)){return warnInvalid(a,iStateCode)
}else{return true
}}}function reformatZIPCode(a){if(a.length==5){return a
}else{return(reformat(a,"",5,"-",4))
}}function checkZIPCode(a,b){if(checkZIPCode.arguments.length==1){b=defaultEmptyOK
}if((b==true)&&(isEmpty(a.value))){return true
}else{var c=stripCharsInBag(a.value,ZIPCodeDelimiters);
if(!isZIPCode(c,false)){return warnInvalid(a,iZIPCode)
}else{a.value=reformatZIPCode(c);
return true
}}}function reformatUSPhone(a){return(reformat(a,"(",3,") ",3,"-",4))
}function checkUSPhone(a,c){if(checkUSPhone.arguments.length==1){c=defaultEmptyOK
}if((c==true)&&(isEmpty(a.value))){return true
}else{var b=stripCharsInBag(a.value,phoneNumberDelimiters);
if(!isUSPhoneNumber(b,false)){return warnInvalid(a,iUSPhone)
}else{a.value=reformatUSPhone(b);
return true
}}}function checkInternationalPhone(a,b){if(checkInternationalPhone.arguments.length==1){b=defaultEmptyOK
}if((b==true)&&(isEmpty(a.value))){return true
}else{if(!isInternationalPhoneNumber(a.value,false)){return warnInvalid(a,iWorldPhone)
}else{return true
}}}function checkEmail(a,b){if(checkEmail.arguments.length==1){b=defaultEmptyOK
}if((b==true)&&(isEmpty(a.value))){return true
}else{if(!isEmail(a.value,false)){return warnInvalid(a,iEmail)
}else{return true
}}}function reformatSSN(a){return(reformat(a,"",3,"-",2,"-",4))
}function checkSSN(a,b){if(checkSSN.arguments.length==1){b=defaultEmptyOK
}if((b==true)&&(isEmpty(a.value))){return true
}else{var c=stripCharsInBag(a.value,SSNDelimiters);
if(!isSSN(c,false)){return warnInvalid(a,iSSN)
}else{a.value=reformatSSN(c);
return true
}}}function checkYear(a,b){if(checkYear.arguments.length==1){b=defaultEmptyOK
}if((b==true)&&(isEmpty(a.value))){return true
}if(!isYear(a.value,false)){return warnInvalid(a,iYear)
}else{return true
}}function checkMonth(a,b){if(checkMonth.arguments.length==1){b=defaultEmptyOK
}if((b==true)&&(isEmpty(a.value))){return true
}if(!isMonth(a.value,false)){return warnInvalid(a,iMonth)
}else{return true
}}function checkDay(a,b){if(checkDay.arguments.length==1){b=defaultEmptyOK
}if((b==true)&&(isEmpty(a.value))){return true
}if(!isDay(a.value,false)){return warnInvalid(a,iDay)
}else{return true
}}function checkDate(a,c,e,b,d){if(checkDate.arguments.length==4){d=false
}if(!isYear(a.value)){return warnInvalid(a,iYear)
}if(!isMonth(c.value)){return warnInvalid(c,iMonth)
}if((d==true)&&isEmpty(e.value)){return true
}else{if(!isDay(e.value)){return warnInvalid(e,iDay)
}}if(isDate(a.value,c.value,e.value)){return true
}alert(iDatePrefix+b+iDateSuffix);
return false
}function getRadioButtonValue(a){for(var b=0;
b<a.length;
b++){if(a[b].checked){break
}}return a[b].value
}function checkCreditCard(d,b){var a=getRadioButtonValue(d);
var c=stripCharsInBag(b.value,creditCardDelimiters);
if(!isCardMatch(a,c)){return warnInvalid(b,iCreditCardPrefix+a+iCreditCardSuffix)
}else{b.value=c;
return true
}}function isCreditCard(a){if(a.length>19){return(false)
}sum=0;
mul=1;
l=a.length;
for(i=0;
i<l;
i++){digit=a.substring(l-i-1,l-i);
tproduct=parseInt(digit,10)*mul;
if(tproduct>=10){sum+=(tproduct%10)+1
}else{sum+=tproduct
}if(mul==1){mul++
}else{mul--
}}if((sum%10)==0){return(true)
}else{return(false)
}}function isVisa(a){if(((a.length==16)||(a.length==13))&&(a.substring(0,1)==4)){return isCreditCard(a)
}return false
}function isMasterCard(a){firstdig=a.substring(0,1);
seconddig=a.substring(1,2);
if((a.length==16)&&(firstdig==5)&&((seconddig>=1)&&(seconddig<=5))){return isCreditCard(a)
}return false
}function isAmericanExpress(a){firstdig=a.substring(0,1);
seconddig=a.substring(1,2);
if((a.length==15)&&(firstdig==3)&&((seconddig==4)||(seconddig==7))){return isCreditCard(a)
}return false
}function isDinersClub(a){firstdig=a.substring(0,1);
seconddig=a.substring(1,2);
if((a.length==14)&&(firstdig==3)&&((seconddig==0)||(seconddig==6)||(seconddig==8))){return isCreditCard(a)
}return false
}function isCarteBlanche(a){return isDinersClub(a)
}function isDiscover(a){first4digs=a.substring(0,4);
if((a.length==16)&&(first4digs=="6011")){return isCreditCard(a)
}return false
}function isEnRoute(a){first4digs=a.substring(0,4);
if((a.length==15)&&((first4digs=="2014")||(first4digs=="2149"))){return isCreditCard(a)
}return false
}function isJCB(a){first4digs=a.substring(0,4);
if((a.length==16)&&((first4digs=="3088")||(first4digs=="3096")||(first4digs=="3112")||(first4digs=="3158")||(first4digs=="3337")||(first4digs=="3528"))){return isCreditCard(a)
}return false
}function isAnyCard(a){if(!isCreditCard(a)){return false
}if(!isMasterCard(a)&&!isVisa(a)&&!isAmericanExpress(a)&&!isDinersClub(a)&&!isDiscover(a)&&!isEnRoute(a)&&!isJCB(a)){return false
}return true
}function isCardMatch(a,c){a=a.toUpperCase();
var b=true;
if((a=="VISA")&&(!isVisa(c))){b=false
}if((a=="MASTERCARD")&&(!isMasterCard(c))){b=false
}if(((a=="AMERICANEXPRESS")||(a=="AMEX"))&&(!isAmericanExpress(c))){b=false
}if((a=="DISCOVER")&&(!isDiscover(c))){b=false
}if((a=="JCB")&&(!isJCB(c))){b=false
}if((a=="DINERS")&&(!isDinersClub(c))){b=false
}if((a=="CARTEBLANCHE")&&(!isCarteBlanche(c))){b=false
}if((a=="ENROUTE")&&(!isEnRoute(c))){b=false
}return b
}function IsCC(a){return isCreditCard(a)
}function IsVisa(a){return isVisa(a)
}function IsVISA(a){return isVisa(a)
}function IsMasterCard(a){return isMasterCard(a)
}function IsMastercard(a){return isMasterCard(a)
}function IsMC(a){return isMasterCard(a)
}function IsAmericanExpress(a){return isAmericanExpress(a)
}function IsAmEx(a){return isAmericanExpress(a)
}function IsDinersClub(a){return isDinersClub(a)
}function IsDC(a){return isDinersClub(a)
}function IsDiners(a){return isDinersClub(a)
}function IsCarteBlanche(a){return isCarteBlanche(a)
}function IsCB(a){return isCarteBlanche(a)
}function IsDiscover(a){return isDiscover(a)
}function IsEnRoute(a){return isEnRoute(a)
}function IsenRoute(a){return isEnRoute(a)
}function IsJCB(a){return isJCB(a)
}function IsAnyCard(a){return isAnyCard(a)
}function IsCardMatch(a,b){return isCardMatch(a,b)
};