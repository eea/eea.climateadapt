CHM.MapViewerCHMMap = OpenLayers.Class(CHM.CHMMap, {
	
	instance: null,
    
    onrestorecomplete: null, 
	
    status: null, 
    
    onstatuschanged: null, 
    
	initialize : function(aOptions) {
		CHM.CHMMap.prototype.initialize.apply(this, arguments);
		
		instance = this;
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
			instance.saveMapState(event);
		});	
		
		instance.events.register('changelayer', this, function(event) {
			instance.saveMapState(event);
		});	
		
		instance.events.register('addlayer', this, function(event) {
			instance.saveMapState(event);
		});
		
		instance.events.register('changebaselayer', this, function(event) {
			instance.saveMapState(event);
		});
		
		instance.setStatus('events registered');
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
				callback: instance.postHandler
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
            
//            var bounds = format.context.bounds;
//            
//            bounds.left = bounds.left + 100;
//            
//            bounds.bottom = bounds.bottom + 100;
//            
//            bounds.right = bounds.right - 100;
//            
//            bounds.top = bounds.top - 100;

            instance.zoomToExtent(format.context.bounds.scale(0.99));
            
            var arraylength = map.layers.length;
            
            for (var i = 0, len = arraylength; i < len; ++ i) {
            	var layer = map.layers[i];
            	
            	var name = layer.name;
            	
           		var url = layer.url;
            		
           		var paramlayers = layer.params.LAYERS;
           		
       			var paramformat = layer.params.FORMAT;
           			
       			var paramtransparent = layer.params.TRANSPARENT;
           			
       			var visibility = layer.visibility;
           			
       			var isbaselayer = layer.isBaseLayer; 
           			
       			var clone = new OpenLayers.Layer.WMS(
       					name, 
       					url, 
       					{layers: paramlayers, format: paramformat, transparent: paramtransparent},
       					{visibility: visibility}, 
       					{isBaseLayer: isbaselayer}
       			);
         			
       			instance.addLayer(clone);
            }            
            
            instance.setStatus('map state restored');
            
            instance.handleOnRestoreComplete();
		} else {
			instance.setStatus('server side error restoring map state');
		};
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
	}
});