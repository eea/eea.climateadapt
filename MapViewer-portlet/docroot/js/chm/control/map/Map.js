CHM.Control.Map.Map = OpenLayers.Class(OpenLayers.Map, {
    
    onrestorecomplete: null, 
	
    status: null, 
    
    onstatuschanged: null, 
	
	initialize : function(options) {
		OpenLayers.Map.prototype.initialize.apply(this, arguments);
		
		this.projection = new OpenLayers.Projection("EPSG:3035");
		
		this.units = "m";
		
		this.maxExtent = new OpenLayers.Bounds(600000, 766700, 8602904.426, 5961082.301);

		this.restrictedExtent = new OpenLayers.Bounds(1600000, 766700, 7602904.426, 5961082.301);
		
		this.maxResolution = (7602904.426 - 1600000) / 512;
        
		this.numZoomLevels = 13;
		
		this.events.addEventType('restoreComplete');
        
        this.addControl(new OpenLayers.Control.LayerSwitcher());
	},
	
	restore : function() {
		this.restoreMapState();
	},
	
	registerEvents : function() {
		this.setStatus('registering events');
		
		this.events.register('moveend', this, function(event) {
			this.handleEvent(event);
		});	
		
		this.events.register('changelayer', this, function(event) {
			this.handleEvent(event);
		});	
		
		this.events.register('addlayer', this, function(event) {
			this.handleEvent(event);
		});
		
		this.events.register('removelayer', this, function(event) {
			this.handleEvent(event);
		});
		
		this.events.register('changebaselayer', this, function(event) {
			this.handleEvent(event);
		});
		
		this.setStatus('events registered');
	},
	
	
	handleEvent : function(aEvent) {
		var foregroundlayer = this.findLayerByName(foregroundlayername); 
		
		if (foregroundlayer != null) {
			var foregroundlayerindex = this.getLayerIndex(foregroundlayer);
			
			if (foregroundlayerindex == this.layers.length - 1) {
				this.saveMapState();
			} else {
				this.setLayerIndex(foregroundlayer, this.layers.length - 1);
			}
		} else {
			this.saveMapState();
		}
	}, 
	
	
	// ********************
	// ** Save map state **
	// ********************
	
	saveMapState : function(aEvent) {
		this.setStatus('saving map state');
        
		var format = new OpenLayers.Format.WMC({'layerOptions': {buffer: 0}});

		try {
            var wmc = format.write(this);
				
			OpenLayers.Request.POST({
				url: mapViewerServletUrl,
				data: wmc,
				headers: {
					"Content-Type": "text/xml"
				},			
				callback: this.postHandler,
				params: 
		    	{
					mapViewerAppId: mapViewerAppId
		    	},
		    	scope: this
			});
        } catch (error) {
        	this.setStatus('client side error saving map state ' + error);
        };
	}, 

	postHandler : function (request) {
		if (request.status == 200) {
			this.setStatus('map state saved');
		} else {
			this.setStatus('server side error saving map state');
		};
	},
	
	setStatus: function(aStatus) {
		
	},
	
	// ***********************
	// ** Restore map state **
	// ***********************
	
	restoreMapState : function() {
        this.setStatus('restoring map state');
        
		try {
			OpenLayers.Request.GET({
				url: mapViewerServletUrl,
				callback: this.getHandler,
				params: 
		    	{
					mapViewerWmcDirectory: mapViewerWmcDirectory,
					mapViewerAppId: mapViewerAppId,
		    		random: Math.random()
		    	},
		    	scope: this
			});
        } catch (error) {
        	this.setStatus('client side error restoring map state ' + error);
        }
	},
	
	getHandler : function (request) {
		if (request.status == 200) {
			var format = new OpenLayers.Format.WMC({'layerOptions': {buffer: 0}});
			
			var map = new OpenLayers.Map();
			
            format.read(request.responseXML, {map: map});
            
            var arraylength = map.layers.length;
            
            for (var i = 0, len = arraylength; i < len; ++ i) {
            	var layer = map.layers[i];
            	
            	var name = layer.name;
            	
           		var url = layer.url;
            		
           		var paramlayers = layer.params.LAYERS;
           		
       			var paramformat = layer.params.FORMAT;
           			
       			var paramtransparent = layer.params.TRANSPARENT;
       			
       			var paramstyles = layer.params.STYLES;
       			
       			var visibility = layer.visibility;
           			
       			var isbaselayer = layer.isBaseLayer; 
           			
       			var clone = new OpenLayers.Layer.WMS(
       					name, 
       					url, 
       					{layers: paramlayers, format: paramformat, transparent: paramtransparent, styles: paramstyles},
       					{visibility: visibility}, 
       					{isBaseLayer: isbaselayer}
       			);
       			
       			clone.displayInLayerSwitcher = layer.displayInLayerSwitcher;
       			
       			clone.singleTile = layer.singleTile;
		
				clone.metadataURL = layer.metadataURL;
				
				clone.attribution = layer.attribution;
         			
       			this.addLayer(clone);
            }            
            
            this.zoomToExtent(format.context.bounds.scale(0.99));
            
            this.setStatus('map state restored');
            
	        this.registerEvents();
 		        
	        this.events.triggerEvent("restoreComplete", null);
		} else {
			this.setStatus('server side error restoring map state');
		};
	}, 
	
	findLayerByNameAndUrl : function(aName, aUrl, aLayersParam) {
		var result = null;
		
        var arraylength = this.layers.length;
        
        for (var i = 0, len = arraylength; i < len; ++ i) {
        	var layer = this.layers[i];
        	
        	if (layer.name == aName && layer.url == aUrl && layer.params.LAYERS == aLayersParam) {
        		result = layer;
        		
        		break;
        	}
        }
        	
        return result;	
	},
	
	findLayerByName : function(aName) {
		var result = null;
		
        var arraylength = this.layers.length;
        
        for (var i = 0, len = arraylength; i < len; ++ i) {
        	var layer = this.layers[i];
        	
        	if (layer.name == aName) {
        		result = layer;
        		
        		break;
        	}
        }
        	
        return result;	
	}
});
