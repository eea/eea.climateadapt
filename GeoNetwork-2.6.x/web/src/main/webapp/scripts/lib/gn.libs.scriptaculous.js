String.prototype.parseColor=function(){var a="#";
if(this.slice(0,4)=="rgb("){var c=this.slice(4,this.length-1).split(",");
var b=0;
do{a+=parseInt(c[b]).toColorPart()
}while(++b<3)
}else{if(this.slice(0,1)=="#"){if(this.length==4){for(var b=1;
b<4;
b++){a+=(this.charAt(b)+this.charAt(b)).toLowerCase()
}}if(this.length==7){a=this.toLowerCase()
}}}return(a.length==7?a:(arguments[0]||this))
};
Element.collectTextNodes=function(a){return $A($(a).childNodes).collect(function(b){return(b.nodeType==3?b.nodeValue:(b.hasChildNodes()?Element.collectTextNodes(b):""))
}).flatten().join("")
};
Element.collectTextNodesIgnoreClass=function(a,b){return $A($(a).childNodes).collect(function(c){return(c.nodeType==3?c.nodeValue:((c.hasChildNodes()&&!Element.hasClassName(c,b))?Element.collectTextNodesIgnoreClass(c,b):""))
}).flatten().join("")
};
Element.setContentZoom=function(a,b){a=$(a);
a.setStyle({fontSize:(b/100)+"em"});
if(Prototype.Browser.WebKit){window.scrollBy(0,0)
}return a
};
Element.getInlineOpacity=function(a){return $(a).style.opacity||""
};
Element.forceRerendering=function(a){try{a=$(a);
var c=document.createTextNode(" ");
a.appendChild(c);
a.removeChild(c)
}catch(b){}};
Array.prototype.call=function(){var a=arguments;
this.each(function(b){b.apply(this,a)
})
};
var Effect={_elementDoesNotExistError:{name:"ElementDoesNotExistError",message:"The specified DOM element does not exist, but is required for this effect to operate"},tagifyText:function(a){if(typeof Builder=="undefined"){throw ("Effect.tagifyText requires including script.aculo.us' builder.js library")
}var b="position:relative";
if(Prototype.Browser.IE){b+=";zoom:1"
}a=$(a);
$A(a.childNodes).each(function(c){if(c.nodeType==3){c.nodeValue.toArray().each(function(d){a.insertBefore(Builder.node("span",{style:b},d==" "?String.fromCharCode(160):d),c)
});
Element.remove(c)
}})
},multiple:function(b,c){var e;
if(((typeof b=="object")||(typeof b=="function"))&&(b.length)){e=b
}else{e=$(b).childNodes
}var a=Object.extend({speed:0.1,delay:0},arguments[2]||{});
var d=a.delay;
$A(e).each(function(g,f){new c(g,Object.extend(a,{delay:f*a.speed+d}))
})
},PAIRS:{slide:["SlideDown","SlideUp"],blind:["BlindDown","BlindUp"],appear:["Appear","Fade"]},toggle:function(b,c){b=$(b);
c=(c||"appear").toLowerCase();
var a=Object.extend({queue:{position:"end",scope:(b.id||"global"),limit:1}},arguments[2]||{});
Effect[b.visible()?Effect.PAIRS[c][1]:Effect.PAIRS[c][0]](b,a)
}};
var Effect2=Effect;
Effect.Transitions={linear:Prototype.K,sinoidal:function(a){return(-Math.cos(a*Math.PI)/2)+0.5
},reverse:function(a){return 1-a
},flicker:function(a){var a=((-Math.cos(a*Math.PI)/4)+0.75)+Math.random()/4;
return(a>1?1:a)
},wobble:function(a){return(-Math.cos(a*Math.PI*(9*a))/2)+0.5
},pulse:function(b,a){a=a||5;
return(Math.round((b%(1/a))*a)==0?((b*a*2)-Math.floor(b*a*2)):1-((b*a*2)-Math.floor(b*a*2)))
},none:function(a){return 0
},full:function(a){return 1
}};
Effect.ScopedQueue=Class.create();
Object.extend(Object.extend(Effect.ScopedQueue.prototype,Enumerable),{initialize:function(){this.effects=[];
this.interval=null
},_each:function(a){this.effects._each(a)
},add:function(b){var c=new Date().getTime();
var a=(typeof b.options.queue=="string")?b.options.queue:b.options.queue.position;
switch(a){case"front":this.effects.findAll(function(d){return d.state=="idle"
}).each(function(d){d.startOn+=b.finishOn;
d.finishOn+=b.finishOn
});
break;
case"with-last":c=this.effects.pluck("startOn").max()||c;
break;
case"end":c=this.effects.pluck("finishOn").max()||c;
break
}b.startOn+=c;
b.finishOn+=c;
if(!b.options.queue.limit||(this.effects.length<b.options.queue.limit)){this.effects.push(b)
}if(!this.interval){this.interval=setInterval(this.loop.bind(this),15)
}},remove:function(a){this.effects=this.effects.reject(function(b){return b==a
});
if(this.effects.length==0){clearInterval(this.interval);
this.interval=null
}},loop:function(){var c=new Date().getTime();
for(var b=0,a=this.effects.length;
b<a;
b++){this.effects[b]&&this.effects[b].loop(c)
}}});
Effect.Queues={instances:$H(),get:function(a){if(typeof a!="string"){return a
}if(!this.instances[a]){this.instances[a]=new Effect.ScopedQueue()
}return this.instances[a]
}};
Effect.Queue=Effect.Queues.get("global");
Effect.DefaultOptions={transition:Effect.Transitions.sinoidal,duration:1,fps:100,sync:false,from:0,to:1,delay:0,queue:"parallel"};
Effect.Base=function(){};
Effect.Base.prototype={position:null,start:function(options){function codeForEvent(options,eventName){return((options[eventName+"Internal"]?"this.options."+eventName+"Internal(this);":"")+(options[eventName]?"this.options."+eventName+"(this);":""))
}if(options.transition===false){options.transition=Effect.Transitions.linear
}this.options=Object.extend(Object.extend({},Effect.DefaultOptions),options||{});
this.currentFrame=0;
this.state="idle";
this.startOn=this.options.delay*1000;
this.finishOn=this.startOn+(this.options.duration*1000);
this.fromToDelta=this.options.to-this.options.from;
this.totalTime=this.finishOn-this.startOn;
this.totalFrames=this.options.fps*this.options.duration;
eval('this.render = function(pos){ if(this.state=="idle"){this.state="running";'+codeForEvent(options,"beforeSetup")+(this.setup?"this.setup();":"")+codeForEvent(options,"afterSetup")+'};if(this.state=="running"){pos=this.options.transition(pos)*'+this.fromToDelta+"+"+this.options.from+";this.position=pos;"+codeForEvent(options,"beforeUpdate")+(this.update?"this.update(pos);":"")+codeForEvent(options,"afterUpdate")+"}}");
this.event("beforeStart");
if(!this.options.sync){Effect.Queues.get(typeof this.options.queue=="string"?"global":this.options.queue.scope).add(this)
}},loop:function(c){if(c>=this.startOn){if(c>=this.finishOn){this.render(1);
this.cancel();
this.event("beforeFinish");
if(this.finish){this.finish()
}this.event("afterFinish");
return
}var b=(c-this.startOn)/this.totalTime,a=Math.round(b*this.totalFrames);
if(a>this.currentFrame){this.render(b);
this.currentFrame=a
}}},cancel:function(){if(!this.options.sync){Effect.Queues.get(typeof this.options.queue=="string"?"global":this.options.queue.scope).remove(this)
}this.state="finished"
},event:function(a){if(this.options[a+"Internal"]){this.options[a+"Internal"](this)
}if(this.options[a]){this.options[a](this)
}},inspect:function(){var a=$H();
for(property in this){if(typeof this[property]!="function"){a[property]=this[property]
}}return"#<Effect:"+a.inspect()+",options:"+$H(this.options).inspect()+">"
}};
Effect.Parallel=Class.create();
Object.extend(Object.extend(Effect.Parallel.prototype,Effect.Base.prototype),{initialize:function(a){this.effects=a||[];
this.start(arguments[1])
},update:function(a){this.effects.invoke("render",a)
},finish:function(a){this.effects.each(function(b){b.render(1);
b.cancel();
b.event("beforeFinish");
if(b.finish){b.finish(a)
}b.event("afterFinish")
})
}});
Effect.Event=Class.create();
Object.extend(Object.extend(Effect.Event.prototype,Effect.Base.prototype),{initialize:function(){var a=Object.extend({duration:0},arguments[0]||{});
this.start(a)
},update:Prototype.emptyFunction});
Effect.Opacity=Class.create();
Object.extend(Object.extend(Effect.Opacity.prototype,Effect.Base.prototype),{initialize:function(b){this.element=$(b);
if(!this.element){throw (Effect._elementDoesNotExistError)
}if(Prototype.Browser.IE&&(!this.element.currentStyle.hasLayout)){this.element.setStyle({zoom:1})
}var a=Object.extend({from:this.element.getOpacity()||0,to:1},arguments[1]||{});
this.start(a)
},update:function(a){this.element.setOpacity(a)
}});
Effect.Move=Class.create();
Object.extend(Object.extend(Effect.Move.prototype,Effect.Base.prototype),{initialize:function(b){this.element=$(b);
if(!this.element){throw (Effect._elementDoesNotExistError)
}var a=Object.extend({x:0,y:0,mode:"relative"},arguments[1]||{});
this.start(a)
},setup:function(){this.element.makePositioned();
this.originalLeft=parseFloat(this.element.getStyle("left")||"0");
this.originalTop=parseFloat(this.element.getStyle("top")||"0");
if(this.options.mode=="absolute"){this.options.x=this.options.x-this.originalLeft;
this.options.y=this.options.y-this.originalTop
}},update:function(a){this.element.setStyle({left:Math.round(this.options.x*a+this.originalLeft)+"px",top:Math.round(this.options.y*a+this.originalTop)+"px"})
}});
Effect.MoveBy=function(b,a,c){return new Effect.Move(b,Object.extend({x:c,y:a},arguments[3]||{}))
};
Effect.Scale=Class.create();
Object.extend(Object.extend(Effect.Scale.prototype,Effect.Base.prototype),{initialize:function(b,c){this.element=$(b);
if(!this.element){throw (Effect._elementDoesNotExistError)
}var a=Object.extend({scaleX:true,scaleY:true,scaleContent:true,scaleFromCenter:false,scaleMode:"box",scaleFrom:100,scaleTo:c},arguments[2]||{});
this.start(a)
},setup:function(){this.restoreAfterFinish=this.options.restoreAfterFinish||false;
this.elementPositioning=this.element.getStyle("position");
this.originalStyle={};
["top","left","width","height","fontSize"].each(function(b){this.originalStyle[b]=this.element.style[b]
}.bind(this));
this.originalTop=this.element.offsetTop;
this.originalLeft=this.element.offsetLeft;
var a=this.element.getStyle("font-size")||"100%";
["em","px","%","pt"].each(function(b){if(a.indexOf(b)>0){this.fontSize=parseFloat(a);
this.fontSizeType=b
}}.bind(this));
this.factor=(this.options.scaleTo-this.options.scaleFrom)/100;
this.dims=null;
if(this.options.scaleMode=="box"){this.dims=[this.element.offsetHeight,this.element.offsetWidth]
}if(/^content/.test(this.options.scaleMode)){this.dims=[this.element.scrollHeight,this.element.scrollWidth]
}if(!this.dims){this.dims=[this.options.scaleMode.originalHeight,this.options.scaleMode.originalWidth]
}},update:function(a){var b=(this.options.scaleFrom/100)+(this.factor*a);
if(this.options.scaleContent&&this.fontSize){this.element.setStyle({fontSize:this.fontSize*b+this.fontSizeType})
}this.setDimensions(this.dims[0]*b,this.dims[1]*b)
},finish:function(a){if(this.restoreAfterFinish){this.element.setStyle(this.originalStyle)
}},setDimensions:function(a,e){var f={};
if(this.options.scaleX){f.width=Math.round(e)+"px"
}if(this.options.scaleY){f.height=Math.round(a)+"px"
}if(this.options.scaleFromCenter){var c=(a-this.dims[0])/2;
var b=(e-this.dims[1])/2;
if(this.elementPositioning=="absolute"){if(this.options.scaleY){f.top=this.originalTop-c+"px"
}if(this.options.scaleX){f.left=this.originalLeft-b+"px"
}}else{if(this.options.scaleY){f.top=-c+"px"
}if(this.options.scaleX){f.left=-b+"px"
}}}this.element.setStyle(f)
}});
Effect.Highlight=Class.create();
Object.extend(Object.extend(Effect.Highlight.prototype,Effect.Base.prototype),{initialize:function(b){this.element=$(b);
if(!this.element){throw (Effect._elementDoesNotExistError)
}var a=Object.extend({startcolor:"#ffff99"},arguments[1]||{});
this.start(a)
},setup:function(){if(this.element.getStyle("display")=="none"){this.cancel();
return
}this.oldStyle={};
if(!this.options.keepBackgroundImage){this.oldStyle.backgroundImage=this.element.getStyle("background-image");
this.element.setStyle({backgroundImage:"none"})
}if(!this.options.endcolor){this.options.endcolor=this.element.getStyle("background-color").parseColor("#ffffff")
}if(!this.options.restorecolor){this.options.restorecolor=this.element.getStyle("background-color")
}this._base=$R(0,2).map(function(a){return parseInt(this.options.startcolor.slice(a*2+1,a*2+3),16)
}.bind(this));
this._delta=$R(0,2).map(function(a){return parseInt(this.options.endcolor.slice(a*2+1,a*2+3),16)-this._base[a]
}.bind(this))
},update:function(a){this.element.setStyle({backgroundColor:$R(0,2).inject("#",function(b,c,d){return b+(Math.round(this._base[d]+(this._delta[d]*a)).toColorPart())
}.bind(this))})
},finish:function(){this.element.setStyle(Object.extend(this.oldStyle,{backgroundColor:this.options.restorecolor}))
}});
Effect.ScrollTo=Class.create();
Object.extend(Object.extend(Effect.ScrollTo.prototype,Effect.Base.prototype),{initialize:function(a){this.element=$(a);
this.start(arguments[1]||{})
},setup:function(){Position.prepare();
var b=Position.cumulativeOffset(this.element);
if(this.options.offset){b[1]+=this.options.offset
}var a=window.innerHeight?window.height-window.innerHeight:document.body.scrollHeight-(document.documentElement.clientHeight?document.documentElement.clientHeight:document.body.clientHeight);
this.scrollStart=Position.deltaY;
this.delta=(b[1]>a?a:b[1])-this.scrollStart
},update:function(a){Position.prepare();
window.scrollTo(Position.deltaX,this.scrollStart+(a*this.delta))
}});
Effect.Fade=function(c){c=$(c);
var a=c.getInlineOpacity();
var b=Object.extend({from:c.getOpacity()||1,to:0,afterFinishInternal:function(d){if(d.options.to!=0){return
}d.element.hide().setStyle({opacity:a})
}},arguments[1]||{});
return new Effect.Opacity(c,b)
};
Effect.Appear=function(b){b=$(b);
var a=Object.extend({from:(b.getStyle("display")=="none"?0:b.getOpacity()||0),to:1,afterFinishInternal:function(c){c.element.forceRerendering()
},beforeSetup:function(c){c.element.setOpacity(c.options.from).show()
}},arguments[1]||{});
return new Effect.Opacity(b,a)
};
Effect.Puff=function(b){b=$(b);
var a={opacity:b.getInlineOpacity(),position:b.getStyle("position"),top:b.style.top,left:b.style.left,width:b.style.width,height:b.style.height};
return new Effect.Parallel([new Effect.Scale(b,200,{sync:true,scaleFromCenter:true,scaleContent:true,restoreAfterFinish:true}),new Effect.Opacity(b,{sync:true,to:0})],Object.extend({duration:1,beforeSetupInternal:function(c){Position.absolutize(c.effects[0].element)
},afterFinishInternal:function(c){c.effects[0].element.hide().setStyle(a)
}},arguments[1]||{}))
};
Effect.BlindUp=function(a){a=$(a);
a.makeClipping();
return new Effect.Scale(a,0,Object.extend({scaleContent:false,scaleX:false,restoreAfterFinish:true,afterFinishInternal:function(b){b.element.hide().undoClipping()
}},arguments[1]||{}))
};
Effect.BlindDown=function(b){b=$(b);
var a=b.getDimensions();
return new Effect.Scale(b,100,Object.extend({scaleContent:false,scaleX:false,scaleFrom:0,scaleMode:{originalHeight:a.height,originalWidth:a.width},restoreAfterFinish:true,afterSetup:function(c){c.element.makeClipping().setStyle({height:"0px"}).show()
},afterFinishInternal:function(c){c.element.undoClipping()
}},arguments[1]||{}))
};
Effect.SwitchOff=function(b){b=$(b);
var a=b.getInlineOpacity();
return new Effect.Appear(b,Object.extend({duration:0.4,from:0,transition:Effect.Transitions.flicker,afterFinishInternal:function(c){new Effect.Scale(c.element,1,{duration:0.3,scaleFromCenter:true,scaleX:false,scaleContent:false,restoreAfterFinish:true,beforeSetup:function(d){d.element.makePositioned().makeClipping()
},afterFinishInternal:function(d){d.element.hide().undoClipping().undoPositioned().setStyle({opacity:a})
}})
}},arguments[1]||{}))
};
Effect.DropOut=function(b){b=$(b);
var a={top:b.getStyle("top"),left:b.getStyle("left"),opacity:b.getInlineOpacity()};
return new Effect.Parallel([new Effect.Move(b,{x:0,y:100,sync:true}),new Effect.Opacity(b,{sync:true,to:0})],Object.extend({duration:0.5,beforeSetup:function(c){c.effects[0].element.makePositioned()
},afterFinishInternal:function(c){c.effects[0].element.hide().undoPositioned().setStyle(a)
}},arguments[1]||{}))
};
Effect.Shake=function(b){b=$(b);
var a={top:b.getStyle("top"),left:b.getStyle("left")};
return new Effect.Move(b,{x:20,y:0,duration:0.05,afterFinishInternal:function(c){new Effect.Move(c.element,{x:-40,y:0,duration:0.1,afterFinishInternal:function(d){new Effect.Move(d.element,{x:40,y:0,duration:0.1,afterFinishInternal:function(e){new Effect.Move(e.element,{x:-40,y:0,duration:0.1,afterFinishInternal:function(f){new Effect.Move(f.element,{x:40,y:0,duration:0.1,afterFinishInternal:function(g){new Effect.Move(g.element,{x:-20,y:0,duration:0.05,afterFinishInternal:function(h){h.element.undoPositioned().setStyle(a)
}})
}})
}})
}})
}})
}})
};
Effect.SlideDown=function(c){c=$(c).cleanWhitespace();
var a=c.down().getStyle("bottom");
var b=c.getDimensions();
return new Effect.Scale(c,100,Object.extend({scaleContent:false,scaleX:false,scaleFrom:window.opera?0:1,scaleMode:{originalHeight:b.height,originalWidth:b.width},restoreAfterFinish:true,afterSetup:function(d){d.element.makePositioned();
d.element.down().makePositioned();
if(window.opera){d.element.setStyle({top:""})
}d.element.makeClipping().setStyle({height:"0px"}).show()
},afterUpdateInternal:function(d){d.element.down().setStyle({bottom:(d.dims[0]-d.element.clientHeight)+"px"})
},afterFinishInternal:function(d){d.element.undoClipping().undoPositioned();
d.element.down().undoPositioned().setStyle({bottom:a})
}},arguments[1]||{}))
};
Effect.SlideUp=function(b){b=$(b).cleanWhitespace();
var a=b.down().getStyle("bottom");
return new Effect.Scale(b,window.opera?0:1,Object.extend({scaleContent:false,scaleX:false,scaleMode:"box",scaleFrom:100,restoreAfterFinish:true,beforeStartInternal:function(c){c.element.makePositioned();
c.element.down().makePositioned();
if(window.opera){c.element.setStyle({top:""})
}c.element.makeClipping().show()
},afterUpdateInternal:function(c){c.element.down().setStyle({bottom:(c.dims[0]-c.element.clientHeight)+"px"})
},afterFinishInternal:function(c){c.element.hide().undoClipping().undoPositioned().setStyle({bottom:a});
c.element.down().undoPositioned()
}},arguments[1]||{}))
};
Effect.Squish=function(a){return new Effect.Scale(a,window.opera?1:0,{restoreAfterFinish:true,beforeSetup:function(b){b.element.makeClipping()
},afterFinishInternal:function(b){b.element.hide().undoClipping()
}})
};
Effect.Grow=function(c){c=$(c);
var b=Object.extend({direction:"center",moveTransition:Effect.Transitions.sinoidal,scaleTransition:Effect.Transitions.sinoidal,opacityTransition:Effect.Transitions.full},arguments[1]||{});
var a={top:c.style.top,left:c.style.left,height:c.style.height,width:c.style.width,opacity:c.getInlineOpacity()};
var g=c.getDimensions();
var h,f;
var e,d;
switch(b.direction){case"top-left":h=f=e=d=0;
break;
case"top-right":h=g.width;
f=d=0;
e=-g.width;
break;
case"bottom-left":h=e=0;
f=g.height;
d=-g.height;
break;
case"bottom-right":h=g.width;
f=g.height;
e=-g.width;
d=-g.height;
break;
case"center":h=g.width/2;
f=g.height/2;
e=-g.width/2;
d=-g.height/2;
break
}return new Effect.Move(c,{x:h,y:f,duration:0.01,beforeSetup:function(i){i.element.hide().makeClipping().makePositioned()
},afterFinishInternal:function(i){new Effect.Parallel([new Effect.Opacity(i.element,{sync:true,to:1,from:0,transition:b.opacityTransition}),new Effect.Move(i.element,{x:e,y:d,sync:true,transition:b.moveTransition}),new Effect.Scale(i.element,100,{scaleMode:{originalHeight:g.height,originalWidth:g.width},sync:true,scaleFrom:window.opera?1:0,transition:b.scaleTransition,restoreAfterFinish:true})],Object.extend({beforeSetup:function(j){j.effects[0].element.setStyle({height:"0px"}).show()
},afterFinishInternal:function(j){j.effects[0].element.undoClipping().undoPositioned().setStyle(a)
}},b))
}})
};
Effect.Shrink=function(c){c=$(c);
var b=Object.extend({direction:"center",moveTransition:Effect.Transitions.sinoidal,scaleTransition:Effect.Transitions.sinoidal,opacityTransition:Effect.Transitions.none},arguments[1]||{});
var a={top:c.style.top,left:c.style.left,height:c.style.height,width:c.style.width,opacity:c.getInlineOpacity()};
var f=c.getDimensions();
var e,d;
switch(b.direction){case"top-left":e=d=0;
break;
case"top-right":e=f.width;
d=0;
break;
case"bottom-left":e=0;
d=f.height;
break;
case"bottom-right":e=f.width;
d=f.height;
break;
case"center":e=f.width/2;
d=f.height/2;
break
}return new Effect.Parallel([new Effect.Opacity(c,{sync:true,to:0,from:1,transition:b.opacityTransition}),new Effect.Scale(c,window.opera?1:0,{sync:true,transition:b.scaleTransition,restoreAfterFinish:true}),new Effect.Move(c,{x:e,y:d,sync:true,transition:b.moveTransition})],Object.extend({beforeStartInternal:function(g){g.effects[0].element.makePositioned().makeClipping()
},afterFinishInternal:function(g){g.effects[0].element.hide().undoClipping().undoPositioned().setStyle(a)
}},b))
};
Effect.Pulsate=function(c){c=$(c);
var b=arguments[1]||{};
var a=c.getInlineOpacity();
var e=b.transition||Effect.Transitions.sinoidal;
var d=function(f){return e(1-Effect.Transitions.pulse(f,b.pulses))
};
d.bind(e);
return new Effect.Opacity(c,Object.extend(Object.extend({duration:2,from:0,afterFinishInternal:function(f){f.element.setStyle({opacity:a})
}},b),{transition:d}))
};
Effect.Fold=function(b){b=$(b);
var a={top:b.style.top,left:b.style.left,width:b.style.width,height:b.style.height};
b.makeClipping();
return new Effect.Scale(b,5,Object.extend({scaleContent:false,scaleX:false,afterFinishInternal:function(c){new Effect.Scale(b,1,{scaleContent:false,scaleY:false,afterFinishInternal:function(d){d.element.hide().undoClipping().setStyle(a)
}})
}},arguments[1]||{}))
};
Effect.Morph=Class.create();
Object.extend(Object.extend(Effect.Morph.prototype,Effect.Base.prototype),{initialize:function(c){this.element=$(c);
if(!this.element){throw (Effect._elementDoesNotExistError)
}var b=Object.extend({style:{}},arguments[1]||{});
if(typeof b.style=="string"){if(b.style.indexOf(":")==-1){var d="",a="."+b.style;
$A(document.styleSheets).reverse().each(function(e){if(e.cssRules){cssRules=e.cssRules
}else{if(e.rules){cssRules=e.rules
}}$A(cssRules).reverse().each(function(f){if(a==f.selectorText){d=f.style.cssText;
throw $break
}});
if(d){throw $break
}});
this.style=d.parseStyle();
b.afterFinishInternal=function(e){e.element.addClassName(e.options.style);
e.transforms.each(function(f){if(f.style!="opacity"){e.element.style[f.style]=""
}})
}
}else{this.style=b.style.parseStyle()
}}else{this.style=$H(b.style)
}this.start(b)
},setup:function(){function a(b){if(!b||["rgba(0, 0, 0, 0)","transparent"].include(b)){b="#ffffff"
}b=b.parseColor();
return $R(0,2).map(function(c){return parseInt(b.slice(c*2+1,c*2+3),16)
})
}this.transforms=this.style.map(function(g){var f=g[0],e=g[1],d=null;
if(e.parseColor("#zzzzzz")!="#zzzzzz"){e=e.parseColor();
d="color"
}else{if(f=="opacity"){e=parseFloat(e);
if(Prototype.Browser.IE&&(!this.element.currentStyle.hasLayout)){this.element.setStyle({zoom:1})
}}else{if(Element.CSS_LENGTH.test(e)){var c=e.match(/^([\+\-]?[0-9\.]+)(.*)$/);
e=parseFloat(c[1]);
d=(c.length==3)?c[2]:null
}}}var b=this.element.getStyle(f);
return{style:f.camelize(),originalValue:d=="color"?a(b):parseFloat(b||0),targetValue:d=="color"?a(e):e,unit:d}
}.bind(this)).reject(function(b){return((b.originalValue==b.targetValue)||(b.unit!="color"&&(isNaN(b.originalValue)||isNaN(b.targetValue))))
})
},update:function(a){var d={},b,c=this.transforms.length;
while(c--){d[(b=this.transforms[c]).style]=b.unit=="color"?"#"+(Math.round(b.originalValue[0]+(b.targetValue[0]-b.originalValue[0])*a)).toColorPart()+(Math.round(b.originalValue[1]+(b.targetValue[1]-b.originalValue[1])*a)).toColorPart()+(Math.round(b.originalValue[2]+(b.targetValue[2]-b.originalValue[2])*a)).toColorPart():b.originalValue+Math.round(((b.targetValue-b.originalValue)*a)*1000)/1000+b.unit
}this.element.setStyle(d,true)
}});
Effect.Transform=Class.create();
Object.extend(Effect.Transform.prototype,{initialize:function(a){this.tracks=[];
this.options=arguments[1]||{};
this.addTracks(a)
},addTracks:function(a){a.each(function(b){var c=$H(b).values().first();
this.tracks.push($H({ids:$H(b).keys().first(),effect:Effect.Morph,options:{style:c}}))
}.bind(this));
return this
},play:function(){return new Effect.Parallel(this.tracks.map(function(a){var b=[$(a.ids)||$$(a.ids)].flatten();
return b.map(function(c){return new a.effect(c,Object.extend({sync:true},a.options))
})
}).flatten(),this.options)
}});
Element.CSS_PROPERTIES=$w("backgroundColor backgroundPosition borderBottomColor borderBottomStyle borderBottomWidth borderLeftColor borderLeftStyle borderLeftWidth borderRightColor borderRightStyle borderRightWidth borderSpacing borderTopColor borderTopStyle borderTopWidth bottom clip color fontSize fontWeight height left letterSpacing lineHeight marginBottom marginLeft marginRight marginTop markerOffset maxHeight maxWidth minHeight minWidth opacity outlineColor outlineOffset outlineWidth paddingBottom paddingLeft paddingRight paddingTop right textIndent top width wordSpacing zIndex");
Element.CSS_LENGTH=/^(([\+\-]?[0-9\.]+)(em|ex|px|in|cm|mm|pt|pc|\%))|0$/;
String.prototype.parseStyle=function(){var b=document.createElement("div");
b.innerHTML='<div style="'+this+'"></div>';
var c=b.childNodes[0].style,a=$H();
Element.CSS_PROPERTIES.each(function(d){if(c[d]){a[d]=c[d]
}});
if(Prototype.Browser.IE&&this.indexOf("opacity")>-1){a.opacity=this.match(/opacity:\s*((?:0|1)?(?:\.\d*)?)/)[1]
}return a
};
Element.morph=function(a,b){new Effect.Morph(a,Object.extend({style:b},arguments[2]||{}));
return a
};
["getInlineOpacity","forceRerendering","setContentZoom","collectTextNodes","collectTextNodesIgnoreClass","morph"].each(function(a){Element.Methods[a]=Element[a]
});
Element.Methods.visualEffect=function(b,c,a){s=c.dasherize().camelize();
effect_class=s.charAt(0).toUpperCase()+s.substring(1);
new Effect[effect_class](b,a);
return $(b)
};
Element.addMethods();if(typeof Effect=="undefined"){throw ("dragdrop.js requires including script.aculo.us' effects.js library")
}var Droppables={drops:[],remove:function(a){this.drops=this.drops.reject(function(b){return b.element==$(a)
})
},add:function(b){b=$(b);
var a=Object.extend({greedy:true,hoverclass:null,tree:false},arguments[1]||{});
if(a.containment){a._containers=[];
var c=a.containment;
if((typeof c=="object")&&(c.constructor==Array)){c.each(function(d){a._containers.push($(d))
})
}else{a._containers.push($(c))
}}if(a.accept){a.accept=[a.accept].flatten()
}Element.makePositioned(b);
a.element=b;
this.drops.push(a)
},findDeepestChild:function(a){deepest=a[0];
for(i=1;
i<a.length;
++i){if(Element.isParent(a[i].element,deepest.element)){deepest=a[i]
}}return deepest
},isContained:function(b,a){var c;
if(a.tree){c=b.treeNode
}else{c=b.parentNode
}return a._containers.detect(function(d){return c==d
})
},isAffected:function(a,c,b){return((b.element!=c)&&((!b._containers)||this.isContained(c,b))&&((!b.accept)||(Element.classNames(c).detect(function(d){return b.accept.include(d)
})))&&Position.within(b.element,a[0],a[1]))
},deactivate:function(a){if(a.hoverclass){Element.removeClassName(a.element,a.hoverclass)
}this.last_active=null
},activate:function(a){if(a.hoverclass){Element.addClassName(a.element,a.hoverclass)
}this.last_active=a
},show:function(a,b){if(!this.drops.length){return
}var c=[];
if(this.last_active){this.deactivate(this.last_active)
}this.drops.each(function(d){if(Droppables.isAffected(a,b,d)){c.push(d)
}});
if(c.length>0){drop=Droppables.findDeepestChild(c);
Position.within(drop.element,a[0],a[1]);
if(drop.onHover){drop.onHover(b,drop.element,Position.overlap(drop.overlap,drop.element))
}Droppables.activate(drop)
}},fire:function(b,a){if(!this.last_active){return
}Position.prepare();
if(this.isAffected([Event.pointerX(b),Event.pointerY(b)],a,this.last_active)){if(this.last_active.onDrop){this.last_active.onDrop(a,this.last_active.element,b);
return true
}}},reset:function(){if(this.last_active){this.deactivate(this.last_active)
}}};
var Draggables={drags:[],observers:[],register:function(a){if(this.drags.length==0){this.eventMouseUp=this.endDrag.bindAsEventListener(this);
this.eventMouseMove=this.updateDrag.bindAsEventListener(this);
this.eventKeypress=this.keyPress.bindAsEventListener(this);
Event.observe(document,"mouseup",this.eventMouseUp);
Event.observe(document,"mousemove",this.eventMouseMove);
Event.observe(document,"keypress",this.eventKeypress)
}this.drags.push(a)
},unregister:function(a){this.drags=this.drags.reject(function(b){return b==a
});
if(this.drags.length==0){Event.stopObserving(document,"mouseup",this.eventMouseUp);
Event.stopObserving(document,"mousemove",this.eventMouseMove);
Event.stopObserving(document,"keypress",this.eventKeypress)
}},activate:function(a){if(a.options.delay){this._timeout=setTimeout(function(){Draggables._timeout=null;
window.focus();
Draggables.activeDraggable=a
}.bind(this),a.options.delay)
}else{window.focus();
this.activeDraggable=a
}},deactivate:function(){this.activeDraggable=null
},updateDrag:function(a){if(!this.activeDraggable){return
}var b=[Event.pointerX(a),Event.pointerY(a)];
if(this._lastPointer&&(this._lastPointer.inspect()==b.inspect())){return
}this._lastPointer=b;
this.activeDraggable.updateDrag(a,b)
},endDrag:function(a){if(this._timeout){clearTimeout(this._timeout);
this._timeout=null
}if(!this.activeDraggable){return
}this._lastPointer=null;
this.activeDraggable.endDrag(a);
this.activeDraggable=null
},keyPress:function(a){if(this.activeDraggable){this.activeDraggable.keyPress(a)
}},addObserver:function(a){this.observers.push(a);
this._cacheObserverCallbacks()
},removeObserver:function(a){this.observers=this.observers.reject(function(b){return b.element==a
});
this._cacheObserverCallbacks()
},notify:function(b,a,c){if(this[b+"Count"]>0){this.observers.each(function(d){if(d[b]){d[b](b,a,c)
}})
}if(a.options[b]){a.options[b](a,c)
}},_cacheObserverCallbacks:function(){["onStart","onEnd","onDrag"].each(function(a){Draggables[a+"Count"]=Draggables.observers.select(function(b){return b[a]
}).length
})
}};
var Draggable=Class.create();
Draggable._dragging={};
Draggable.prototype={initialize:function(b){var c={handle:false,reverteffect:function(f,e,d){var g=Math.sqrt(Math.abs(e^2)+Math.abs(d^2))*0.02;
new Effect.Move(f,{x:-d,y:-e,duration:g,queue:{scope:"_draggable",position:"end"}})
},endeffect:function(e){var d=typeof e._opacity=="number"?e._opacity:1;
new Effect.Opacity(e,{duration:0.2,from:0.7,to:d,queue:{scope:"_draggable",position:"end"},afterFinish:function(){Draggable._dragging[e]=false
}})
},zindex:1000,revert:false,quiet:false,scroll:false,scrollSensitivity:20,scrollSpeed:15,snap:false,delay:0};
if(!arguments[1]||typeof arguments[1].endeffect=="undefined"){Object.extend(c,{starteffect:function(d){d._opacity=Element.getOpacity(d);
Draggable._dragging[d]=true;
new Effect.Opacity(d,{duration:0.2,from:d._opacity,to:0.7})
}})
}var a=Object.extend(c,arguments[1]||{});
this.element=$(b);
if(a.handle&&(typeof a.handle=="string")){this.handle=this.element.down("."+a.handle,0)
}if(!this.handle){this.handle=$(a.handle)
}if(!this.handle){this.handle=this.element
}if(a.scroll&&!a.scroll.scrollTo&&!a.scroll.outerHTML){a.scroll=$(a.scroll);
this._isScrollChild=Element.childOf(this.element,a.scroll)
}Element.makePositioned(this.element);
this.delta=this.currentDelta();
this.options=a;
this.dragging=false;
this.eventMouseDown=this.initDrag.bindAsEventListener(this);
Event.observe(this.handle,"mousedown",this.eventMouseDown);
Draggables.register(this)
},destroy:function(){Event.stopObserving(this.handle,"mousedown",this.eventMouseDown);
Draggables.unregister(this)
},currentDelta:function(){return([parseInt(Element.getStyle(this.element,"left")||"0"),parseInt(Element.getStyle(this.element,"top")||"0")])
},initDrag:function(a){if(typeof Draggable._dragging[this.element]!="undefined"&&Draggable._dragging[this.element]){return
}if(Event.isLeftClick(a)){var c=Event.element(a);
if((tag_name=c.tagName.toUpperCase())&&(tag_name=="INPUT"||tag_name=="SELECT"||tag_name=="OPTION"||tag_name=="BUTTON"||tag_name=="TEXTAREA")){return
}var b=[Event.pointerX(a),Event.pointerY(a)];
var d=Position.cumulativeOffset(this.element);
this.offset=[0,1].map(function(e){return(b[e]-d[e])
});
Draggables.activate(this);
Event.stop(a)
}},startDrag:function(b){this.dragging=true;
if(this.options.zindex){this.originalZ=parseInt(Element.getStyle(this.element,"z-index")||0);
this.element.style.zIndex=this.options.zindex
}if(this.options.ghosting){this._clone=this.element.cloneNode(true);
Position.absolutize(this.element);
this.element.parentNode.insertBefore(this._clone,this.element)
}if(this.options.scroll){if(this.options.scroll==window){var a=this._getWindowScroll(this.options.scroll);
this.originalScrollLeft=a.left;
this.originalScrollTop=a.top
}else{this.originalScrollLeft=this.options.scroll.scrollLeft;
this.originalScrollTop=this.options.scroll.scrollTop
}}Draggables.notify("onStart",this,b);
if(this.options.starteffect){this.options.starteffect(this.element)
}},updateDrag:function(event,pointer){if(!this.dragging){this.startDrag(event)
}if(!this.options.quiet){Position.prepare();
Droppables.show(pointer,this.element)
}Draggables.notify("onDrag",this,event);
this.draw(pointer);
if(this.options.change){this.options.change(this)
}if(this.options.scroll){this.stopScrolling();
var p;
if(this.options.scroll==window){with(this._getWindowScroll(this.options.scroll)){p=[left,top,left+width,top+height]
}}else{p=Position.page(this.options.scroll);
p[0]+=this.options.scroll.scrollLeft+Position.deltaX;
p[1]+=this.options.scroll.scrollTop+Position.deltaY;
p.push(p[0]+this.options.scroll.offsetWidth);
p.push(p[1]+this.options.scroll.offsetHeight)
}var speed=[0,0];
if(pointer[0]<(p[0]+this.options.scrollSensitivity)){speed[0]=pointer[0]-(p[0]+this.options.scrollSensitivity)
}if(pointer[1]<(p[1]+this.options.scrollSensitivity)){speed[1]=pointer[1]-(p[1]+this.options.scrollSensitivity)
}if(pointer[0]>(p[2]-this.options.scrollSensitivity)){speed[0]=pointer[0]-(p[2]-this.options.scrollSensitivity)
}if(pointer[1]>(p[3]-this.options.scrollSensitivity)){speed[1]=pointer[1]-(p[3]-this.options.scrollSensitivity)
}this.startScrolling(speed)
}if(Prototype.Browser.WebKit){window.scrollBy(0,0)
}Event.stop(event)
},finishDrag:function(b,f){this.dragging=false;
if(this.options.quiet){Position.prepare();
var e=[Event.pointerX(b),Event.pointerY(b)];
Droppables.show(e,this.element)
}if(this.options.ghosting){Position.relativize(this.element);
Element.remove(this._clone);
this._clone=null
}var g=false;
if(f){g=Droppables.fire(b,this.element);
if(!g){g=false
}}if(g&&this.options.onDropped){this.options.onDropped(this.element)
}Draggables.notify("onEnd",this,b);
var a=this.options.revert;
if(a&&typeof a=="function"){a=a(this.element)
}var c=this.currentDelta();
if(a&&this.options.reverteffect){if(g==0||a!="failure"){this.options.reverteffect(this.element,c[1]-this.delta[1],c[0]-this.delta[0])
}}else{this.delta=c
}if(this.options.zindex){this.element.style.zIndex=this.originalZ
}if(this.options.endeffect){this.options.endeffect(this.element)
}Draggables.deactivate(this);
Droppables.reset()
},keyPress:function(a){if(a.keyCode!=Event.KEY_ESC){return
}this.finishDrag(a,false);
Event.stop(a)
},endDrag:function(a){if(!this.dragging){return
}this.stopScrolling();
this.finishDrag(a,true);
Event.stop(a)
},draw:function(a){var g=Position.cumulativeOffset(this.element);
if(this.options.ghosting){var c=Position.realOffset(this.element);
g[0]+=c[0]-Position.deltaX;
g[1]+=c[1]-Position.deltaY
}var f=this.currentDelta();
g[0]-=f[0];
g[1]-=f[1];
if(this.options.scroll&&(this.options.scroll!=window&&this._isScrollChild)){g[0]-=this.options.scroll.scrollLeft-this.originalScrollLeft;
g[1]-=this.options.scroll.scrollTop-this.originalScrollTop
}var e=[0,1].map(function(d){return(a[d]-g[d]-this.offset[d])
}.bind(this));
if(this.options.snap){if(typeof this.options.snap=="function"){e=this.options.snap(e[0],e[1],this)
}else{if(this.options.snap instanceof Array){e=e.map(function(d,h){return Math.round(d/this.options.snap[h])*this.options.snap[h]
}.bind(this))
}else{e=e.map(function(d){return Math.round(d/this.options.snap)*this.options.snap
}.bind(this))
}}}var b=this.element.style;
if((!this.options.constraint)||(this.options.constraint=="horizontal")){b.left=e[0]+"px"
}if((!this.options.constraint)||(this.options.constraint=="vertical")){b.top=e[1]+"px"
}if(b.visibility=="hidden"){b.visibility=""
}},stopScrolling:function(){if(this.scrollInterval){clearInterval(this.scrollInterval);
this.scrollInterval=null;
Draggables._lastScrollPointer=null
}},startScrolling:function(a){if(!(a[0]||a[1])){return
}this.scrollSpeed=[a[0]*this.options.scrollSpeed,a[1]*this.options.scrollSpeed];
this.lastScrolled=new Date();
this.scrollInterval=setInterval(this.scroll.bind(this),10)
},scroll:function(){var current=new Date();
var delta=current-this.lastScrolled;
this.lastScrolled=current;
if(this.options.scroll==window){with(this._getWindowScroll(this.options.scroll)){if(this.scrollSpeed[0]||this.scrollSpeed[1]){var d=delta/1000;
this.options.scroll.scrollTo(left+d*this.scrollSpeed[0],top+d*this.scrollSpeed[1])
}}}else{this.options.scroll.scrollLeft+=this.scrollSpeed[0]*delta/1000;
this.options.scroll.scrollTop+=this.scrollSpeed[1]*delta/1000
}Position.prepare();
Droppables.show(Draggables._lastPointer,this.element);
Draggables.notify("onDrag",this);
if(this._isScrollChild){Draggables._lastScrollPointer=Draggables._lastScrollPointer||$A(Draggables._lastPointer);
Draggables._lastScrollPointer[0]+=this.scrollSpeed[0]*delta/1000;
Draggables._lastScrollPointer[1]+=this.scrollSpeed[1]*delta/1000;
if(Draggables._lastScrollPointer[0]<0){Draggables._lastScrollPointer[0]=0
}if(Draggables._lastScrollPointer[1]<0){Draggables._lastScrollPointer[1]=0
}this.draw(Draggables._lastScrollPointer)
}if(this.options.change){this.options.change(this)
}},_getWindowScroll:function(w){var T,L,W,H;
with(w.document){if(w.document.documentElement&&documentElement.scrollTop){T=documentElement.scrollTop;
L=documentElement.scrollLeft
}else{if(w.document.body){T=body.scrollTop;
L=body.scrollLeft
}}if(w.innerWidth){W=w.innerWidth;
H=w.innerHeight
}else{if(w.document.documentElement&&documentElement.clientWidth){W=documentElement.clientWidth;
H=documentElement.clientHeight
}else{W=body.offsetWidth;
H=body.offsetHeight
}}}return{top:T,left:L,width:W,height:H}
}};
var SortableObserver=Class.create();
SortableObserver.prototype={initialize:function(b,a){this.element=$(b);
this.observer=a;
this.lastValue=Sortable.serialize(this.element)
},onStart:function(){this.lastValue=Sortable.serialize(this.element)
},onEnd:function(){Sortable.unmark();
if(this.lastValue!=Sortable.serialize(this.element)){this.observer(this.element)
}}};
var Sortable={SERIALIZE_RULE:/^[^_\-](?:[A-Za-z0-9\-\_]*)[_](.*)$/,sortables:{},_findRootElement:function(a){while(a.tagName.toUpperCase()!="BODY"){if(a.id&&Sortable.sortables[a.id]){return a
}a=a.parentNode
}},options:function(a){a=Sortable._findRootElement($(a));
if(!a){return
}return Sortable.sortables[a.id]
},destroy:function(a){var b=Sortable.options(a);
if(b){Draggables.removeObserver(b.element);
b.droppables.each(function(c){Droppables.remove(c)
});
b.draggables.invoke("destroy");
delete Sortable.sortables[b.element.id]
}},create:function(c){c=$(c);
var b=Object.extend({element:c,tag:"li",dropOnEmpty:false,tree:false,treeTag:"ul",overlap:"vertical",constraint:"vertical",containment:c,handle:false,only:false,delay:0,hoverclass:null,ghosting:false,quiet:false,scroll:false,scrollSensitivity:20,scrollSpeed:15,format:this.SERIALIZE_RULE,elements:false,handles:false,onChange:Prototype.emptyFunction,onUpdate:Prototype.emptyFunction},arguments[1]||{});
this.destroy(c);
var a={revert:true,quiet:b.quiet,scroll:b.scroll,scrollSpeed:b.scrollSpeed,scrollSensitivity:b.scrollSensitivity,delay:b.delay,ghosting:b.ghosting,constraint:b.constraint,handle:b.handle};
if(b.starteffect){a.starteffect=b.starteffect
}if(b.reverteffect){a.reverteffect=b.reverteffect
}else{if(b.ghosting){a.reverteffect=function(f){f.style.top=0;
f.style.left=0
}
}}if(b.endeffect){a.endeffect=b.endeffect
}if(b.zindex){a.zindex=b.zindex
}var d={overlap:b.overlap,containment:b.containment,tree:b.tree,hoverclass:b.hoverclass,onHover:Sortable.onHover};
var e={onHover:Sortable.onEmptyHover,overlap:b.overlap,containment:b.containment,hoverclass:b.hoverclass};
Element.cleanWhitespace(c);
b.draggables=[];
b.droppables=[];
if(b.dropOnEmpty||b.tree){Droppables.add(c,e);
b.droppables.push(c)
}(b.elements||this.findElements(c,b)||[]).each(function(h,f){var g=b.handles?$(b.handles[f]):(b.handle?$(h).getElementsByClassName(b.handle)[0]:h);
b.draggables.push(new Draggable(h,Object.extend(a,{handle:g})));
Droppables.add(h,d);
if(b.tree){h.treeNode=c
}b.droppables.push(h)
});
if(b.tree){(Sortable.findTreeElements(c,b)||[]).each(function(f){Droppables.add(f,e);
f.treeNode=c;
b.droppables.push(f)
})
}this.sortables[c.id]=b;
Draggables.addObserver(new SortableObserver(c,b.onUpdate))
},findElements:function(b,a){return Element.findChildren(b,a.only,a.tree?true:false,a.tag)
},findTreeElements:function(b,a){return Element.findChildren(b,a.only,a.tree?true:false,a.treeTag)
},onHover:function(e,d,a){if(Element.isParent(d,e)){return
}if(a>0.33&&a<0.66&&Sortable.options(d).tree){return
}else{if(a>0.5){Sortable.mark(d,"before");
if(d.previousSibling!=e){var b=e.parentNode;
e.style.visibility="hidden";
d.parentNode.insertBefore(e,d);
if(d.parentNode!=b){Sortable.options(b).onChange(e)
}Sortable.options(d.parentNode).onChange(e)
}}else{Sortable.mark(d,"after");
var c=d.nextSibling||null;
if(c!=e){var b=e.parentNode;
e.style.visibility="hidden";
d.parentNode.insertBefore(e,c);
if(d.parentNode!=b){Sortable.options(b).onChange(e)
}Sortable.options(d.parentNode).onChange(e)
}}}},onEmptyHover:function(e,g,h){var j=e.parentNode;
var a=Sortable.options(g);
if(!Element.isParent(g,e)){var f;
var c=Sortable.findElements(g,{tag:a.tag,only:a.only});
var b=null;
if(c){var d=Element.offsetSize(g,a.overlap)*(1-h);
for(f=0;
f<c.length;
f+=1){if(d-Element.offsetSize(c[f],a.overlap)>=0){d-=Element.offsetSize(c[f],a.overlap)
}else{if(d-(Element.offsetSize(c[f],a.overlap)/2)>=0){b=f+1<c.length?c[f+1]:null;
break
}else{b=c[f];
break
}}}}g.insertBefore(e,b);
Sortable.options(j).onChange(e);
a.onChange(e)
}},unmark:function(){if(Sortable._marker){Sortable._marker.hide()
}},mark:function(b,a){var d=Sortable.options(b.parentNode);
if(d&&!d.ghosting){return
}if(!Sortable._marker){Sortable._marker=($("dropmarker")||Element.extend(document.createElement("DIV"))).hide().addClassName("dropmarker").setStyle({position:"absolute"});
document.getElementsByTagName("body").item(0).appendChild(Sortable._marker)
}var c=Position.cumulativeOffset(b);
Sortable._marker.setStyle({left:c[0]+"px",top:c[1]+"px"});
if(a=="after"){if(d.overlap=="horizontal"){Sortable._marker.setStyle({left:(c[0]+b.clientWidth)+"px"})
}else{Sortable._marker.setStyle({top:(c[1]+b.clientHeight)+"px"})
}}Sortable._marker.show()
},_tree:function(e,b,f){var d=Sortable.findElements(e,b)||[];
for(var c=0;
c<d.length;
++c){var a=d[c].id.match(b.format);
if(!a){continue
}var g={id:encodeURIComponent(a?a[1]:null),element:e,parent:f,children:[],position:f.children.length,container:$(d[c]).down(b.treeTag)};
if(g.container){this._tree(g.container,b,g)
}f.children.push(g)
}return f
},tree:function(d){d=$(d);
var c=this.options(d);
var b=Object.extend({tag:c.tag,treeTag:c.treeTag,only:c.only,name:d.id,format:c.format},arguments[1]||{});
var a={id:null,parent:null,children:[],container:d,position:0};
return Sortable._tree(d,b,a)
},_constructIndex:function(b){var a="";
do{if(b.id){a="["+b.position+"]"+a
}}while((b=b.parent)!=null);
return a
},sequence:function(b){b=$(b);
var a=Object.extend(this.options(b),arguments[1]||{});
return $(this.findElements(b,a)||[]).map(function(c){return c.id.match(a.format)?c.id.match(a.format)[1]:""
})
},setSequence:function(b,c){b=$(b);
var a=Object.extend(this.options(b),arguments[2]||{});
var d={};
this.findElements(b,a).each(function(e){if(e.id.match(a.format)){d[e.id.match(a.format)[1]]=[e,e.parentNode]
}e.parentNode.removeChild(e)
});
c.each(function(e){var f=d[e];
if(f){f[1].appendChild(f[0]);
delete d[e]
}})
},serialize:function(c){c=$(c);
var b=Object.extend(Sortable.options(c),arguments[1]||{});
var a=encodeURIComponent((arguments[1]&&arguments[1].name)?arguments[1].name:c.id);
if(b.tree){return Sortable.tree(c,arguments[1]).children.map(function(d){return[a+Sortable._constructIndex(d)+"[id]="+encodeURIComponent(d.id)].concat(d.children.map(arguments.callee))
}).flatten().join("&")
}else{return Sortable.sequence(c,arguments[1]).map(function(d){return a+"[]="+encodeURIComponent(d)
}).join("&")
}}};
Element.isParent=function(b,a){if(!b.parentNode||b==a){return false
}if(b.parentNode==a){return true
}return Element.isParent(b.parentNode,a)
};
Element.findChildren=function(d,b,a,c){if(!d.hasChildNodes()){return null
}c=c.toUpperCase();
if(b){b=[b].flatten()
}var e=[];
$A(d.childNodes).each(function(g){if(g.tagName&&g.tagName.toUpperCase()==c&&(!b||(Element.classNames(g).detect(function(h){return b.include(h)
})))){e.push(g)
}if(a){var f=Element.findChildren(g,b,a,c);
if(f){e.push(f)
}}});
return(e.length>0?e.flatten():[])
};
Element.offsetSize=function(a,b){return a["offset"+((b=="vertical"||b=="height")?"Height":"Width")]
};if(typeof Effect=="undefined"){throw ("controls.js requires including script.aculo.us' effects.js library")
}var Autocompleter={};
Autocompleter.Base=function(){};
Autocompleter.Base.prototype={baseInitialize:function(b,c,a){b=$(b);
this.element=b;
this.update=$(c);
this.hasFocus=false;
this.changed=false;
this.active=false;
this.index=0;
this.entryCount=0;
if(this.setOptions){this.setOptions(a)
}else{this.options=a||{}
}this.options.paramName=this.options.paramName||this.element.name;
this.options.tokens=this.options.tokens||[];
this.options.frequency=this.options.frequency||0.4;
this.options.minChars=this.options.minChars||1;
this.options.onShow=this.options.onShow||function(d,e){if(!e.style.position||e.style.position=="absolute"){e.style.position="absolute";
Position.clone(d,e,{setHeight:false,offsetTop:d.offsetHeight})
}Effect.Appear(e,{duration:0.15})
};
this.options.onHide=this.options.onHide||function(d,e){new Effect.Fade(e,{duration:0.15})
};
if(typeof(this.options.tokens)=="string"){this.options.tokens=new Array(this.options.tokens)
}this.observer=null;
this.element.setAttribute("autocomplete","off");
Element.hide(this.update);
Event.observe(this.element,"blur",this.onBlur.bindAsEventListener(this));
Event.observe(this.element,"keypress",this.onKeyPress.bindAsEventListener(this));
Event.observe(window,"beforeunload",function(){b.setAttribute("autocomplete","on")
})
},show:function(){if(Element.getStyle(this.update,"display")=="none"){this.options.onShow(this.element,this.update)
}if(!this.iefix&&(Prototype.Browser.IE)&&(Element.getStyle(this.update,"position")=="absolute")){new Insertion.After(this.update,'<iframe id="'+this.update.id+'_iefix" style="display:none;position:absolute;filter:progid:DXImageTransform.Microsoft.Alpha(opacity=0);" src="javascript:false;" frameborder="0" scrolling="no"></iframe>');
this.iefix=$(this.update.id+"_iefix")
}if(this.iefix){setTimeout(this.fixIEOverlapping.bind(this),50)
}},fixIEOverlapping:function(){Position.clone(this.update,this.iefix,{setTop:(!this.update.style.height)});
this.iefix.style.zIndex=1;
this.update.style.zIndex=2;
Element.show(this.iefix)
},hide:function(){this.stopIndicator();
if(Element.getStyle(this.update,"display")!="none"){this.options.onHide(this.element,this.update)
}if(this.iefix){Element.hide(this.iefix)
}},startIndicator:function(){if(this.options.indicator){Element.show(this.options.indicator)
}},stopIndicator:function(){if(this.options.indicator){Element.hide(this.options.indicator)
}},onKeyPress:function(a){if(this.active){switch(a.keyCode){case Event.KEY_TAB:case Event.KEY_RETURN:this.selectEntry();
Event.stop(a);
case Event.KEY_ESC:this.hide();
this.active=false;
Event.stop(a);
return;
case Event.KEY_LEFT:case Event.KEY_RIGHT:return;
case Event.KEY_UP:this.markPrevious();
this.render();
if(Prototype.Browser.WebKit){Event.stop(a)
}return;
case Event.KEY_DOWN:this.markNext();
this.render();
if(Prototype.Browser.WebKit){Event.stop(a)
}return
}}else{if(a.keyCode==Event.KEY_TAB||a.keyCode==Event.KEY_RETURN||(Prototype.Browser.WebKit>0&&a.keyCode==0)){return
}}this.changed=true;
this.hasFocus=true;
if(this.observer){clearTimeout(this.observer)
}this.observer=setTimeout(this.onObserverEvent.bind(this),this.options.frequency*1000)
},activate:function(){this.changed=false;
this.hasFocus=true;
this.getUpdatedChoices()
},onHover:function(b){var a=Event.findElement(b,"LI");
if(this.index!=a.autocompleteIndex){this.index=a.autocompleteIndex;
this.render()
}Event.stop(b)
},onClick:function(b){var a=Event.findElement(b,"LI");
this.index=a.autocompleteIndex;
this.selectEntry();
this.hide()
},onBlur:function(a){setTimeout(this.hide.bind(this),250);
this.hasFocus=false;
this.active=false
},render:function(){if(this.entryCount>0){for(var a=0;
a<this.entryCount;
a++){this.index==a?Element.addClassName(this.getEntry(a),"selected"):Element.removeClassName(this.getEntry(a),"selected")
}if(this.hasFocus){this.show();
this.active=true
}}else{this.active=false;
this.hide()
}},markPrevious:function(){if(this.index>0){this.index--
}else{this.index=this.entryCount-1
}this.getEntry(this.index).scrollIntoView(true)
},markNext:function(){if(this.index<this.entryCount-1){this.index++
}else{this.index=0
}this.getEntry(this.index).scrollIntoView(false)
},getEntry:function(a){return this.update.firstChild.childNodes[a]
},getCurrentEntry:function(){return this.getEntry(this.index)
},selectEntry:function(){this.active=false;
this.updateElement(this.getCurrentEntry())
},updateElement:function(f){if(this.options.updateElement){this.options.updateElement(f);
return
}var c="";
if(this.options.select){var a=document.getElementsByClassName(this.options.select,f)||[];
if(a.length>0){c=Element.collectTextNodes(a[0],this.options.select)
}}else{c=Element.collectTextNodesIgnoreClass(f,"informal")
}var e=this.findLastToken();
if(e!=-1){var d=this.element.value.substr(0,e+1);
var b=this.element.value.substr(e+1).match(/^\s+/);
if(b){d+=b[0]
}this.element.value=d+c
}else{this.element.value=c
}this.element.focus();
if(this.options.afterUpdateElement){this.options.afterUpdateElement(this.element,f)
}},updateChoices:function(c){if(!this.changed&&this.hasFocus){this.update.innerHTML=c;
Element.cleanWhitespace(this.update);
Element.cleanWhitespace(this.update.down());
if(this.update.firstChild&&this.update.down().childNodes){this.entryCount=this.update.down().childNodes.length;
for(var a=0;
a<this.entryCount;
a++){var b=this.getEntry(a);
b.autocompleteIndex=a;
this.addObservers(b)
}}else{this.entryCount=0
}this.stopIndicator();
this.index=0;
if(this.entryCount==1&&this.options.autoSelect){this.selectEntry();
this.hide()
}else{this.render()
}}},addObservers:function(a){Event.observe(a,"mouseover",this.onHover.bindAsEventListener(this));
Event.observe(a,"click",this.onClick.bindAsEventListener(this))
},onObserverEvent:function(){this.changed=false;
if(this.getToken().length>=this.options.minChars){this.getUpdatedChoices()
}else{this.active=false;
this.hide()
}},getToken:function(){var b=this.findLastToken();
if(b!=-1){var a=this.element.value.substr(b+1).replace(/^\s+/,"").replace(/\s+$/,"")
}else{var a=this.element.value
}return/\n/.test(a)?"":a
},findLastToken:function(){var c=-1;
for(var b=0;
b<this.options.tokens.length;
b++){var a=this.element.value.lastIndexOf(this.options.tokens[b]);
if(a>c){c=a
}}return c
}};
Ajax.Autocompleter=Class.create();
Object.extend(Object.extend(Ajax.Autocompleter.prototype,Autocompleter.Base.prototype),{initialize:function(c,d,b,a){this.baseInitialize(c,d,a);
this.options.asynchronous=true;
this.options.onComplete=this.onComplete.bind(this);
this.options.defaultParams=this.options.parameters||null;
this.url=b
},getUpdatedChoices:function(){this.startIndicator();
var a=encodeURIComponent(this.options.paramName)+"="+encodeURIComponent(this.getToken());
this.options.parameters=this.options.callback?this.options.callback(this.element,a):a;
if(this.options.defaultParams){this.options.parameters+="&"+this.options.defaultParams
}new Ajax.Request(this.url,this.options)
},onComplete:function(a){this.updateChoices(a.responseText)
}});
Autocompleter.Local=Class.create();
Autocompleter.Local.prototype=Object.extend(new Autocompleter.Base(),{initialize:function(b,d,c,a){this.baseInitialize(b,d,a);
this.options.array=c
},getUpdatedChoices:function(){this.updateChoices(this.options.selector(this))
},setOptions:function(a){this.options=Object.extend({choices:10,partialSearch:true,partialChars:2,ignoreCase:true,fullSearch:false,selector:function(b){var d=[];
var c=[];
var h=b.getToken();
var g=0;
for(var e=0;
e<b.options.array.length&&d.length<b.options.choices;
e++){var f=b.options.array[e];
var j=b.options.ignoreCase?f.toLowerCase().indexOf(h.toLowerCase()):f.indexOf(h);
while(j!=-1){if(j==0&&f.length!=h.length){d.push("<li><strong>"+f.substr(0,h.length)+"</strong>"+f.substr(h.length)+"</li>");
break
}else{if(h.length>=b.options.partialChars&&b.options.partialSearch&&j!=-1){if(b.options.fullSearch||/\s/.test(f.substr(j-1,1))){c.push("<li>"+f.substr(0,j)+"<strong>"+f.substr(j,h.length)+"</strong>"+f.substr(j+h.length)+"</li>");
break
}}}j=b.options.ignoreCase?f.toLowerCase().indexOf(h.toLowerCase(),j+1):f.indexOf(h,j+1)
}}if(c.length){d=d.concat(c.slice(0,b.options.choices-d.length))
}return"<ul>"+d.join("")+"</ul>"
}},a||{})
}});
Field.scrollFreeActivate=function(a){setTimeout(function(){Field.activate(a)
},1)
};
Ajax.InPlaceEditor=Class.create();
Ajax.InPlaceEditor.defaultHighlightColor="#FFFF99";
Ajax.InPlaceEditor.prototype={initialize:function(c,b,a){this.url=b;
this.element=$(c);
this.options=Object.extend({paramName:"value",okButton:true,okLink:false,okText:"ok",cancelButton:false,cancelLink:true,cancelText:"cancel",textBeforeControls:"",textBetweenControls:"",textAfterControls:"",savingText:"Saving...",clickToEditText:"Click to edit",okText:"ok",rows:1,onComplete:function(e,d){new Effect.Highlight(d,{startcolor:this.options.highlightcolor})
},onFailure:function(d){alert("Error communicating with the server: "+d.responseText.stripTags())
},callback:function(d){return Form.serialize(d)
},handleLineBreaks:true,loadingText:"Loading...",savingClassName:"inplaceeditor-saving",loadingClassName:"inplaceeditor-loading",formClassName:"inplaceeditor-form",highlightcolor:Ajax.InPlaceEditor.defaultHighlightColor,highlightendcolor:"#FFFFFF",externalControl:null,submitOnBlur:false,ajaxOptions:{},evalScripts:false},a||{});
if(!this.options.formId&&this.element.id){this.options.formId=this.element.id+"-inplaceeditor";
if($(this.options.formId)){this.options.formId=null
}}if(this.options.externalControl){this.options.externalControl=$(this.options.externalControl)
}this.originalBackground=Element.getStyle(this.element,"background-color");
if(!this.originalBackground){this.originalBackground="transparent"
}this.element.title=this.options.clickToEditText;
this.onclickListener=this.enterEditMode.bindAsEventListener(this);
this.mouseoverListener=this.enterHover.bindAsEventListener(this);
this.mouseoutListener=this.leaveHover.bindAsEventListener(this);
Event.observe(this.element,"click",this.onclickListener);
Event.observe(this.element,"mouseover",this.mouseoverListener);
Event.observe(this.element,"mouseout",this.mouseoutListener);
if(this.options.externalControl){Event.observe(this.options.externalControl,"click",this.onclickListener);
Event.observe(this.options.externalControl,"mouseover",this.mouseoverListener);
Event.observe(this.options.externalControl,"mouseout",this.mouseoutListener)
}},enterEditMode:function(a){if(this.saving){return
}if(this.editing){return
}this.editing=true;
this.onEnterEditMode();
if(this.options.externalControl){Element.hide(this.options.externalControl)
}Element.hide(this.element);
this.createForm();
this.element.parentNode.insertBefore(this.form,this.element);
if(!this.options.loadTextURL){Field.scrollFreeActivate(this.editField)
}if(a){Event.stop(a)
}return false
},createForm:function(){this.form=document.createElement("form");
this.form.id=this.options.formId;
Element.addClassName(this.form,this.options.formClassName);
this.form.onsubmit=this.onSubmit.bind(this);
this.createEditField();
if(this.options.textarea){var b=document.createElement("br");
this.form.appendChild(b)
}if(this.options.textBeforeControls){this.form.appendChild(document.createTextNode(this.options.textBeforeControls))
}if(this.options.okButton){var e=document.createElement("input");
e.type="submit";
e.value=this.options.okText;
e.className="editor_ok_button";
this.form.appendChild(e)
}if(this.options.okLink){var c=document.createElement("a");
c.href="#";
c.appendChild(document.createTextNode(this.options.okText));
c.onclick=this.onSubmit.bind(this);
c.className="editor_ok_link";
this.form.appendChild(c)
}if(this.options.textBetweenControls&&(this.options.okLink||this.options.okButton)&&(this.options.cancelLink||this.options.cancelButton)){this.form.appendChild(document.createTextNode(this.options.textBetweenControls))
}if(this.options.cancelButton){var d=document.createElement("input");
d.type="submit";
d.value=this.options.cancelText;
d.onclick=this.onclickCancel.bind(this);
d.className="editor_cancel_button";
this.form.appendChild(d)
}if(this.options.cancelLink){var a=document.createElement("a");
a.href="#";
a.appendChild(document.createTextNode(this.options.cancelText));
a.onclick=this.onclickCancel.bind(this);
a.className="editor_cancel editor_cancel_link";
this.form.appendChild(a)
}if(this.options.textAfterControls){this.form.appendChild(document.createTextNode(this.options.textAfterControls))
}},hasHTMLLineBreaks:function(a){if(!this.options.handleLineBreaks){return false
}return a.match(/<br/i)||a.match(/<p>/i)
},convertHTMLLineBreaks:function(a){return a.replace(/<br>/gi,"\n").replace(/<br\/>/gi,"\n").replace(/<\/p>/gi,"\n").replace(/<p>/gi,"")
},createEditField:function(){var e;
if(this.options.loadTextURL){e=this.options.loadingText
}else{e=this.getText()
}var c=this;
if(this.options.rows==1&&!this.hasHTMLLineBreaks(e)){this.options.textarea=false;
var a=document.createElement("input");
a.obj=this;
a.type="text";
a.name=this.options.paramName;
a.value=e;
a.style.backgroundColor=this.options.highlightcolor;
a.className="editor_field";
var b=this.options.size||this.options.cols||0;
if(b!=0){a.size=b
}if(this.options.submitOnBlur){a.onblur=this.onSubmit.bind(this)
}this.editField=a
}else{this.options.textarea=true;
var d=document.createElement("textarea");
d.obj=this;
d.name=this.options.paramName;
d.value=this.convertHTMLLineBreaks(e);
d.rows=this.options.rows;
d.cols=this.options.cols||40;
d.className="editor_field";
if(this.options.submitOnBlur){d.onblur=this.onSubmit.bind(this)
}this.editField=d
}if(this.options.loadTextURL){this.loadExternalText()
}this.form.appendChild(this.editField)
},getText:function(){return this.element.innerHTML
},loadExternalText:function(){Element.addClassName(this.form,this.options.loadingClassName);
this.editField.disabled=true;
new Ajax.Request(this.options.loadTextURL,Object.extend({asynchronous:true,onComplete:this.onLoadedExternalText.bind(this)},this.options.ajaxOptions))
},onLoadedExternalText:function(a){Element.removeClassName(this.form,this.options.loadingClassName);
this.editField.disabled=false;
this.editField.value=a.responseText.stripTags();
Field.scrollFreeActivate(this.editField)
},onclickCancel:function(){this.onComplete();
this.leaveEditMode();
return false
},onFailure:function(a){this.options.onFailure(a);
if(this.oldInnerHTML){this.element.innerHTML=this.oldInnerHTML;
this.oldInnerHTML=null
}return false
},onSubmit:function(){var a=this.form;
var b=this.editField.value;
this.onLoading();
if(this.options.evalScripts){new Ajax.Request(this.url,Object.extend({parameters:this.options.callback(a,b),onComplete:this.onComplete.bind(this),onFailure:this.onFailure.bind(this),asynchronous:true,evalScripts:true},this.options.ajaxOptions))
}else{new Ajax.Updater({success:this.element,failure:null},this.url,Object.extend({parameters:this.options.callback(a,b),onComplete:this.onComplete.bind(this),onFailure:this.onFailure.bind(this)},this.options.ajaxOptions))
}if(arguments.length>1){Event.stop(arguments[0])
}return false
},onLoading:function(){this.saving=true;
this.removeForm();
this.leaveHover();
this.showSaving()
},showSaving:function(){this.oldInnerHTML=this.element.innerHTML;
this.element.innerHTML=this.options.savingText;
Element.addClassName(this.element,this.options.savingClassName);
this.element.style.backgroundColor=this.originalBackground;
Element.show(this.element)
},removeForm:function(){if(this.form){if(this.form.parentNode){Element.remove(this.form)
}this.form=null
}},enterHover:function(){if(this.saving){return
}this.element.style.backgroundColor=this.options.highlightcolor;
if(this.effect){this.effect.cancel()
}Element.addClassName(this.element,this.options.hoverClassName)
},leaveHover:function(){if(this.options.backgroundColor){this.element.style.backgroundColor=this.oldBackground
}Element.removeClassName(this.element,this.options.hoverClassName);
if(this.saving){return
}this.effect=new Effect.Highlight(this.element,{startcolor:this.options.highlightcolor,endcolor:this.options.highlightendcolor,restorecolor:this.originalBackground})
},leaveEditMode:function(){Element.removeClassName(this.element,this.options.savingClassName);
this.removeForm();
this.leaveHover();
this.element.style.backgroundColor=this.originalBackground;
Element.show(this.element);
if(this.options.externalControl){Element.show(this.options.externalControl)
}this.editing=false;
this.saving=false;
this.oldInnerHTML=null;
this.onLeaveEditMode()
},onComplete:function(a){this.leaveEditMode();
this.options.onComplete.bind(this)(a,this.element)
},onEnterEditMode:function(){},onLeaveEditMode:function(){},dispose:function(){if(this.oldInnerHTML){this.element.innerHTML=this.oldInnerHTML
}this.leaveEditMode();
Event.stopObserving(this.element,"click",this.onclickListener);
Event.stopObserving(this.element,"mouseover",this.mouseoverListener);
Event.stopObserving(this.element,"mouseout",this.mouseoutListener);
if(this.options.externalControl){Event.stopObserving(this.options.externalControl,"click",this.onclickListener);
Event.stopObserving(this.options.externalControl,"mouseover",this.mouseoverListener);
Event.stopObserving(this.options.externalControl,"mouseout",this.mouseoutListener)
}}};
Ajax.InPlaceCollectionEditor=Class.create();
Object.extend(Ajax.InPlaceCollectionEditor.prototype,Ajax.InPlaceEditor.prototype);
Object.extend(Ajax.InPlaceCollectionEditor.prototype,{createEditField:function(){if(!this.cached_selectTag){var a=document.createElement("select");
var c=this.options.collection||[];
var b;
c.each(function(f,d){b=document.createElement("option");
b.value=(f instanceof Array)?f[0]:f;
if((typeof this.options.value=="undefined")&&((f instanceof Array)?this.element.innerHTML==f[1]:f==b.value)){b.selected=true
}if(this.options.value==b.value){b.selected=true
}b.appendChild(document.createTextNode((f instanceof Array)?f[1]:f));
a.appendChild(b)
}.bind(this));
this.cached_selectTag=a
}this.editField=this.cached_selectTag;
if(this.options.loadTextURL){this.loadExternalText()
}this.form.appendChild(this.editField);
this.options.callback=function(d,e){return"value="+encodeURIComponent(e)
}
}});
Form.Element.DelayedObserver=Class.create();
Form.Element.DelayedObserver.prototype={initialize:function(b,a,c){this.delay=a||0.5;
this.element=$(b);
this.callback=c;
this.timer=null;
this.lastValue=$F(this.element);
Event.observe(this.element,"keyup",this.delayedListener.bindAsEventListener(this))
},delayedListener:function(a){if(this.lastValue==$F(this.element)){return
}if(this.timer){clearTimeout(this.timer)
}this.timer=setTimeout(this.onTimerEvent.bind(this),this.delay*1000);
this.lastValue=$F(this.element)
},onTimerEvent:function(){this.timer=null;
this.callback(this.element,$F(this.element))
}};var Builder={NODEMAP:{AREA:"map",CAPTION:"table",COL:"table",COLGROUP:"table",LEGEND:"fieldset",OPTGROUP:"select",OPTION:"select",PARAM:"object",TBODY:"table",TD:"table",TFOOT:"table",TH:"table",THEAD:"table",TR:"table"},node:function(a){a=a.toUpperCase();
var g=this.NODEMAP[a]||"div";
var b=document.createElement(g);
try{b.innerHTML="<"+a+"></"+a+">"
}catch(f){}var d=b.firstChild||null;
if(d&&(d.tagName.toUpperCase()!=a)){d=d.getElementsByTagName(a)[0]
}if(!d){d=document.createElement(a)
}if(!d){return
}if(arguments[1]){if(this._isStringOrNumber(arguments[1])||(arguments[1] instanceof Array)||arguments[1].tagName){this._children(d,arguments[1])
}else{var c=this._attributes(arguments[1]);
if(c.length){try{b.innerHTML="<"+a+" "+c+"></"+a+">"
}catch(f){}d=b.firstChild||null;
if(!d){d=document.createElement(a);
for(attr in arguments[1]){d[attr=="class"?"className":attr]=arguments[1][attr]
}}if(d.tagName.toUpperCase()!=a){d=b.getElementsByTagName(a)[0]
}}}}if(arguments[2]){this._children(d,arguments[2])
}return d
},_text:function(a){return document.createTextNode(a)
},ATTR_MAP:{className:"class",htmlFor:"for"},_attributes:function(a){var b=[];
for(attribute in a){b.push((attribute in this.ATTR_MAP?this.ATTR_MAP[attribute]:attribute)+'="'+a[attribute].toString().escapeHTML().gsub(/"/,"&quot;")+'"')
}return b.join(" ")
},_children:function(b,a){if(a.tagName){b.appendChild(a);
return
}if(typeof a=="object"){a.flatten().each(function(c){if(typeof c=="object"){b.appendChild(c)
}else{if(Builder._isStringOrNumber(c)){b.appendChild(Builder._text(c))
}}})
}else{if(Builder._isStringOrNumber(a)){b.appendChild(Builder._text(a))
}}},_isStringOrNumber:function(a){return(typeof a=="string"||typeof a=="number")
},build:function(b){var a=this.node("div");
$(a).update(b.strip());
return a.down()
},dump:function(b){if(typeof b!="object"&&typeof b!="function"){b=window
}var a=("A ABBR ACRONYM ADDRESS APPLET AREA B BASE BASEFONT BDO BIG BLOCKQUOTE BODY BR BUTTON CAPTION CENTER CITE CODE COL COLGROUP DD DEL DFN DIR DIV DL DT EM FIELDSET FONT FORM FRAME FRAMESET H1 H2 H3 H4 H5 H6 HEAD HR HTML I IFRAME IMG INPUT INS ISINDEX KBD LABEL LEGEND LI LINK MAP MENU META NOFRAMES NOSCRIPT OBJECT OL OPTGROUP OPTION P PARAM PRE Q S SAMP SCRIPT SELECT SMALL SPAN STRIKE STRONG STYLE SUB SUP TABLE TBODY TD TEXTAREA TFOOT TH THEAD TITLE TR TT U UL VAR").split(/\s+/);
a.each(function(c){b[c]=function(){return Builder.node.apply(Builder,[c].concat($A(arguments)))
}
})
}};