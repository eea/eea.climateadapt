CHM.LocationInputControl = OpenLayers.Class(OpenLayers.Control, {
	_location : null,
	
	_onlocationchanged : null,
	
	defaultHandlerOptions : {
		'single' : true,
		'double' : false,
		'pixelTolerance' : 0,
		'stopSingle' : false,
		'stopDouble' : false
	},
	
	initialize : function(options) {
		this.handlerOptions = OpenLayers.Util.extend({}, this.defaultHandlerOptions);

		OpenLayers.Control.prototype.initialize.apply(this, arguments);

		this.handler = new OpenLayers.Handler.Click(this, {'click' : this.trigger}, this.handlerOptions);
	},
	
	trigger : function(e) {
		var lonlat = locationinput.getLonLatFromViewPortPx(e.xy);
		
		locationinput.setLocation(new CHM.Location(lonlat.lon, lonlat.lat, locationinput.projection));
	},
});
