CHM.CHMMap = OpenLayers.Class(OpenLayers.Map, {
	
	feature : null,
	
	initialize : function(options) {
		OpenLayers.Map.prototype.initialize.apply(this, arguments);
		
		this.projection = new OpenLayers.Projection("EPSG:900913");
		
		this.units = "m";
		
		this.maxResolution = 156543.0339;
		
		this.maxExtent = new OpenLayers.Bounds(-2680799.4555375, 4050551.002161, 5244191.63565, 11799431.180210993);
        
		this.restrictedExtent = new OpenLayers.Bounds(-2680799.4555375, 4050551.002161, 5253975.5752687, 11799431.180210993);
        
        this.addControl(new OpenLayers.Control.LayerSwitcher());
	},
	
	addBingLayers : function() {
        var road = new OpenLayers.Layer.VirtualEarth("Road", {
            sphericalMercator: true,
            maxExtent: new OpenLayers.Bounds(-20037508.34,-20037508.34,20037508.34,20037508.34),
            type: VEMapStyle.Road
        });
        
        var shaded = new OpenLayers.Layer.VirtualEarth("Shaded", {
            sphericalMercator: true,
            maxExtent: new OpenLayers.Bounds(-20037508.34,-20037508.34,20037508.34,20037508.34),
            type: VEMapStyle.Shaded
        });
        
        var hybrid = new OpenLayers.Layer.VirtualEarth("Hybrid", {
            sphericalMercator: true,
            maxExtent: new OpenLayers.Bounds(-20037508.34,-20037508.34,20037508.34,20037508.34),
            type: VEMapStyle.Hybrid
        });
        
        var aerial = new OpenLayers.Layer.VirtualEarth("Aerial", {
            sphericalMercator: true,
            maxExtent: new OpenLayers.Bounds(-20037508.34,-20037508.34,20037508.34,20037508.34),
            type: VEMapStyle.Aerial
        });

        this.addLayers([road, shaded, hybrid, aerial]);
        
		if (! this.getCenter()) {
			this.zoomToMaxExtent();
		}
	} 
});
