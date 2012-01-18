CHM.MapViewerCHMMap = OpenLayers.Class(CHM.CHMMap, {
	
	self: null,
    
    onrestorecomplete: null, 
	
    status: null, 
    
    onstatuschanged: null, 
    
	initialize : function(aOptions) {
		CHM.CHMMap.prototype.initialize.apply(this, arguments);
		
		self = this;
	},
	
	restore : function() {
		self.restoreMapState();
	},
	
	registerEvents : function() {
		self.setStatus('registering events');
		
		self.events.register('moveend', this, function(event) {
			self.saveMapState(event);
		});	
		
		self.events.register('changelayer', this, function(event) {
			self.saveMapState(event);
		});	
		
		self.events.register('addlayer', this, function(event) {
			self.saveMapState(event);
		});
		
		self.events.register('changebaselayer', this, function(event) {
			self.saveMapState(event);
		});
		
		self.setStatus('events registered');
	},
	
	
	// ********************
	// ** Save map state **
	// ********************
	
	saveMapState : function(aEvent) {
		self.setStatus('saving map state');
        
		var format = new OpenLayers.Format.WMC({'layerOptions': {buffer: 0}});

		try {
            var wmc = format.write(self);
				
			OpenLayers.Request.POST({
				url: mapViewerServletUrl,
				data: wmc,
				headers: {
					"Content-Type": "text/xml"
				},			
				callback: self.postHandler
			});
        } catch (error) {
        	self.setStatus('client side error saving map state ' + error);
        };
	}, 

	postHandler : function (request) {
		if (request.status == 200) {
			self.setStatus('map state saved');
		} else {
			self.setStatus('server side error saving map state');
		};
	},
	
	
	// ***********************
	// ** Restore map state **
	// ***********************
	
	restoreMapState : function() {
        self.setStatus('restoring map state');
        
		try {
			OpenLayers.Request.GET({
				url: mapViewerServletUrl,
				callback: self.getHandler
			});
        } catch (error) {
        	self.setStatus('client side error restoring map state ' + error);
        }
	},
	
	getHandler : function (request) {
		if (request.status == 200) {
			var format = new OpenLayers.Format.WMC({'layerOptions': {buffer: 0}});
			
			var map = new OpenLayers.Map();
			
            format.read(request.responseXML, {map: map});
//            
//            self.zoom = map.zoom;
//            
//            self.center = map.center;
//            
//            self.maxExtent = map.maxExtent;
//          
            
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
            	
            	self.addLayer(clone);
            }            
            
            self.setStatus('map state restored');
            
            self.handleOnRestoreComplete();
		} else {
			self.setStatus('server side error restoring map state');
		};
	}, 
	
	getOnRestoreComplete : function() {
		return self.onrestorecomplete;
	},
	
	setOnRestoreComplete : function(aFunction) {
		self.onrestorecomplete = aFunction;
	},
	
	handleOnRestoreComplete : function() {
		if (self.onrestorecomplete != null) {
			self.onrestorecomplete();
		}
	},

	
	// ************
	// ** Status **
	// ************
	
	getStatus : function() {
		return self.status;
	},
	
	setStatus : function(aStatus) {
		self.status = aStatus;
		
		self.handleOnStatusChanged();
	},
	
	getOnStatusChanged : function() {
		return self.onstatuschanged;
	},
	
	setOnStatusChanged : function(aFunction) {
		self.onstatuschanged = aFunction;
	},
	
	handleOnStatusChanged : function() {
		if (self.onstatuschanged != null) {
			self.onstatuschanged();
		}
	}
});