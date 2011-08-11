CHM.LocationInput = OpenLayers.Class(OpenLayers.Map, {
	_location : null,
	
	_feature : null,
	
	_locationinputcontrol : null, 
			
	_onlocationchanged : null,
	
	_vectorlayer : null,
	
	initialize : function(options) {
		OpenLayers.Map.prototype.initialize.apply(this, arguments);

		var wms_layer = new OpenLayers.Layer.WMS('OpenLayers WMS', 
			'http://vmap0.tiles.osgeo.org/wms/vmap0', 
			{layers : 'basic'}, 
			{isBaseLayer: true}
		);
				
		_vectorlayer = new OpenLayers.Layer.Vector('Editable Vectors');
		
		this.addLayers([wms_layer, _vectorlayer]);
				
		this.addControl(new OpenLayers.Control.LayerSwitcher({}));
		
		_locationinputcontrol = new CHM.LocationInputControl();
				
		this.addControl(_locationinputcontrol);
				
		_locationinputcontrol.activate();
				
		if (! this.getCenter()) {
			this.zoomToMaxExtent();
		}
	},
	
	locationChanged : function() {
		setLocation(_locationinputcontrol.getLocation());
	},
	
	getLocation : function(aEPSGCode) {
		return this.transform(this._location, aEPSGCode);
	}, 
	
	setLocation : function(aLocation) {
		this._location = this.transform(aLocation, this.projection);
		
        if (this._location != null) {
	        this.setFeature(new OpenLayers.Feature.Vector(this._location));
        } else {
        	this.setFeature(null);
        }
        
		this.handleOnLocationChanged();
	},
	
	transform : function(aLocation, aEPSGCode) {
		var sourceprojection = new OpenLayers.Projection(aLocation.getEPSGCode());

		var targetprojection = new OpenLayers.Projection(aEPSGCode);

		var result = new CHM.Location(aLocation.x, aLocation.y, aEPSGCode);

		result.transform(sourceprojection, targetprojection);
		
		return result;
	},
	
	getFeature : function() {
		return this._location;
	}, 
	
	setFeature : function(aFeature) {
		if (this._feature != null) {
			_vectorlayer.removeFeatures([this._feature]); 
		}
		
		this._feature = aFeature;		
		
		if (this._feature != null) {
			_vectorlayer.addFeatures([this._feature]); 
		}
	}, 
	
	setOnLocationChanged : function(aFunction) {
		this._onlocationchanged = aFunction;
	},
	
	handleOnLocationChanged : function() {
		if (this._onlocationchanged != null) {
			this._onlocationchanged();
		}
	}
});
