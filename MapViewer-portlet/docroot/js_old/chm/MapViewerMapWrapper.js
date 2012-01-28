CHM.MapViewerMapWrapper = OpenLayers.Class({

	// http://docs.openlayers.org/library/request.html
	// http://openlayers.org/dev/examples/wmc.html

	map: null, 
	
    onSaveSucces: null, 
	
	onSaveError: null,
    
	initialize : function(options) {
		this.map = new OpenLayers.Map();
        
        this.map.addControl(new OpenLayers.Control.LayerSwitcher());
        
        this.addBingLayers();
		
		this.map.events.register('moveend', this, function(event) {
			this.save(event.type);
		});	
		
		this.map.events.register('changelayer', this, function(event) {
			this.save(event.type + " " + event.layer.name + " " + event.property);
		});	
		
		this.map.events.register('changebaselayer', this, function(event) {
			this.save(event.type + " " + event.layer.name);
		});	
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

        this.map.addLayers([road, shaded, hybrid, aerial]);
        
		similar_areas_image_layer = new OpenLayers.Layer.WMS('Biogeographical regions 2005', 
				geoserverUrl + wms + '?', 
				{layers: 'chm:biogeo_2005', format: 'image/png', transparent: 'true'}, 
				{visibility: false}, 
				{tileOptions: {maxGetUrlLength: 2048}}, 
				{isBaseLayer: false}
			);
		
		this.map.addLayers([similar_areas_image_layer]);
		
        this.map.setCenter(new OpenLayers.LonLat(9.150066, 50.17437).transform(
        	    new OpenLayers.Projection("EPSG:4326"),
        	    this.map.getProjectionObject()
        	), zoomLevel);
	}, 
	
	getMap : function () {
		return this.map;
	}, 
	
	load : function() {
		try {
			var request = OpenLayers.Request.GET({
				url: "http://localhost/mapviewerservlet",
				callback: this.getHandler
			});
        } catch(err) {
            alert(err);
        }
	},
	
	save : function(s) {
		var format = new OpenLayers.Format.WMC({'layerOptions': {buffer: 0}});

		try {
            var wmc = format.write(this);
				
			var request = OpenLayers.Request.POST({
				url: "http://localhost/mapviewerservlet",
				data: wmc,
				headers: {
					"Content-Type": "text/xml"
				},			
				callback: this.postHandler
			});
        } catch(err) {
            alert(err);
        }
	},

	getHandler: function (request) {
		if (request.status == 200) {
			var format = new OpenLayers.Format.WMC({'layerOptions': {buffer: 0}});
			
            var context = format.read(request.responseXML, {map: this.map});
		} else {
			if (this.onSaveError != null) {
				this.onSaveError();
			}
		};
	}, 

	postHandler: function (request) {
		if (request.status == 200) {
			if (this.onSaveSucces != null) {
				this.onSaveSucces();
			}
		} else {
			if (this.onSaveError != null) {
				this.onSaveError();
			}
		};
	}, 
	
	setOnSaveSucces : function(aFunction) {
	 	this.onSaveSucces = aFunction;
	},
	
	handleSaveSucces : function() {
	}, 
	
	handleSaveError : function() {
	}
});