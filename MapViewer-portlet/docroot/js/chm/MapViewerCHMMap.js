CHM.MapViewerCHMMap = OpenLayers.Class(OpenLayers.Map, {
	
	instance: null,
    
    onrestorecomplete: null, 
	
    status: null, 
    
    onstatuschanged: null, 
	
	initialize : function(options) {
		OpenLayers.Map.prototype.initialize.apply(this, arguments);
		
		instance = this;
		
		this.projection = new OpenLayers.Projection("EPSG:3035");
		
		this.units = "m";
		
		this.maxExtent = new OpenLayers.Bounds(600000, 766700, 8602904.426, 5961082.301);

		this.restrictedExtent = new OpenLayers.Bounds(1600000, 766700, 7602904.426, 5961082.301);
		
		this.maxResolution = (7602904.426 - 1600000) / 512;
		
		this.numZoomLevels = 13;
	},
	
	restore : function() {
		instance.restoreMapState();
	},
	
	addLayer : function(aLayer) {
		if (aLayer instanceof OpenLayers.Layer.WMS) {
			var name = aLayer.name;
			
			var url = aLayer.url;
			
			var paramlayers = aLayer.params.LAYERS;
			
			if (instance.findLayerByNameAndUrl(name, url, paramlayers) == null) {
				CHM.CHMMap.prototype.addLayer.apply(this, arguments);
			}
		} else {
			CHM.CHMMap.prototype.addLayer.apply(this, arguments);
		}
	}, 
	
	registerEvents : function() {
		instance.setStatus('registering events');
		
		instance.events.register('moveend', this, function(event) {
			instance.handleEvent(event);
		});	
		
		instance.events.register('changelayer', this, function(event) {
			instance.handleEvent(event);
		});	
		
		instance.events.register('addlayer', this, function(event) {
			instance.handleEvent(event);
		});
		
		instance.events.register('removelayer', this, function(event) {
			instance.handleEvent(event);
		});
		
		instance.events.register('changebaselayer', this, function(event) {
			instance.handleEvent(event);
		});
		
		instance.setStatus('events registered');
	},
	
	
	handleEvent : function(aEvent) {
		var foregroundlayer = instance.findLayerByName(foregroundlayername); 
		
		if (foregroundlayer != null) {
			var foregroundlayerindex = instance.getLayerIndex(foregroundlayer);
			
			if (foregroundlayerindex == instance.layers.length - 1) {
				instance.saveMapState();
			} else {
				instance.setLayerIndex(foregroundlayer, instance.layers.length - 1);
			}
		} else {
			instance.saveMapState();
		}
	}, 
	
	
	// ********************
	// ** Save map state **
	// ********************
	
	saveMapState : function(aEvent) {
		instance.setStatus('saving map state');
        
		var format = new OpenLayers.Format.WMC({'layerOptions': {buffer: 0}});

		try {
            var wmc = format.write(instance);
				
			OpenLayers.Request.POST({
				url: mapViewerServletUrl,
				data: wmc,
				headers: {
					"Content-Type": "text/xml"
				},			
				callback: instance.postHandler,
				params: 
		    	{
					mapViewerAppId: mapViewerAppId
		    	}
			});
        } catch (error) {
        	instance.setStatus('client side error saving map state ' + error);
        };
	}, 

	postHandler : function (request) {
		if (request.status == 200) {
			instance.setStatus('map state saved');
		} else {
			instance.setStatus('server side error saving map state');
		};
	},
	
	
	// ***********************
	// ** Restore map state **
	// ***********************
	
	restoreMapState : function() {
        instance.setStatus('restoring map state');
        
		try {
			OpenLayers.Request.GET({
				url: mapViewerServletUrl,
				callback: instance.getHandler,
				params: 
		    	{
					mapViewerWmcDirectory: mapViewerWmcDirectory,
					mapViewerAppId: mapViewerAppId,
		    		random: Math.random()
		    	}
			});
        } catch (error) {
        	instance.setStatus('client side error restoring map state ' + error);
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
         			
       			instance.addLayer(clone);
            }            
            
            instance.zoomToExtent(format.context.bounds.scale(0.99));
            
            instance.setStatus('map state restored');
            
	        instance.registerEvents();
 		        
            instance.handleOnRestoreComplete();
		} else {
			instance.setStatus('server side error restoring map state');
		};
	}, 
	
	getOnRestoreComplete : function() {
		return instance.onrestorecomplete;
	},
	
	setOnRestoreComplete : function(aFunction) {
		instance.onrestorecomplete = aFunction;
	},
	
	handleOnRestoreComplete : function() {
		if (instance.onrestorecomplete != null) {
			instance.onrestorecomplete();
		}
	},

	
	// ************
	// ** Status **
	// ************
	
	getStatus : function() {
		return instance.status;
	},
	
	setStatus : function(aStatus) {
		instance.status = aStatus;
		
		instance.handleOnStatusChanged();
	},
	
	getOnStatusChanged : function() {
		return instance.onstatuschanged;
	},
	
	setOnStatusChanged : function(aFunction) {
		instance.onstatuschanged = aFunction;
	},
	
	handleOnStatusChanged : function() {
		if (instance.onstatuschanged != null) {
			instance.onstatuschanged();
		}
	}, 
	
	findLayerByNameAndUrl : function(aName, aUrl, aLayersParam) {
		var result = null;
		
        var arraylength = instance.layers.length;
        
        for (var i = 0, len = arraylength; i < len; ++ i) {
        	var layer = instance.layers[i];
        	
        	if (layer.name == aName && layer.url == aUrl && layer.params.LAYERS == aLayersParam) {
        		result = layer;
        		
        		break;
        	}
        }
        	
        return result;	
	},
	
	findLayerByName : function(aName) {
		var result = null;
		
        var arraylength = instance.layers.length;
        
        for (var i = 0, len = arraylength; i < len; ++ i) {
        	var layer = instance.layers[i];
        	
        	if (layer.name == aName) {
        		result = layer;
        		
        		break;
        	}
        }
        	
        return result;	
	}
});