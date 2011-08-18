CHM.MeasureControl = OpenLayers.Class(OpenLayers.Control, {
	measureCHMMap: null, 
	
	defaultHandlerOptions : {
		'single' : true,
		'double' : false,
		'pixelTolerance' : 0,
		'stopSingle' : false,
		'stopDouble' : false
	},
	
	initialize : function(options) {
		OpenLayers.Control.prototype.initialize.apply(this, arguments);

		this.handlerOptions = OpenLayers.Util.extend({}, this.defaultHandlerOptions);
		
		this.handler = new OpenLayers.Handler.Click(this, {'click' : this.trigger}, this.handlerOptions);
	},
	
	trigger : function(e) {
		var lonlat = this.measureCHMMap.getLonLatFromViewPortPx(e.xy);
		
		this.measureCHMMap.setMeasure(new CHM.Measure(lonlat.lon, lonlat.lat, this.measureCHMMap.projection));
	},
});
