CHM.CHMMap = OpenLayers.Class(OpenLayers.Map, {
	
	initialize : function(options) {
		OpenLayers.Map.prototype.initialize.apply(this, arguments);
		
		this.projection = 'EPSG:3035';
		
		this.maxExtent = new OpenLayers.Bounds(2555000, 1350000, 7405000, 5500000);
		 
		this.maxResolution = 156543.0339;
		
		this.units = 'm';
		
		var base_wms_layer = new OpenLayers.Layer.WMS('NUTS0 Base layer', 
			geoserverUrl + wms + '?', 
			{layers: 'nuts:nuts0', format: 'image/png', transparent: 'true'}, 
			{isBaseLayer: true}
		);

		this.addLayers([base_wms_layer]);
				
		this.addControl(new OpenLayers.Control.LayerSwitcher({}));
		
		if (! this.getCenter()) {
			this.zoomToMaxExtent();
		}
	}
});
