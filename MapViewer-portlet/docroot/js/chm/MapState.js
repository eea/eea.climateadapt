CHM.MapState = OpenLayers.Class(OpenLayers.Format.JSON, {
	
	layers: null,
    
	initialize : function(aMapViewerCHMMap) {
		OpenLayers.Format.prototype.initialize.apply(this, arguments);
		
		var arraylength = aMapViewerCHMMap.layers.length;
        
		layers = new Array(arraylength);
		
        for (var i = 0, len = arraylength; i < len; ++ i) {
        	var layer = aMapViewerCHMMap.layers[i];
        	
        	layers[i] = layer;
        }		
	},

	read : function(json) {
	    var obj = null;
	    
	    if (typeof json == "string") {
	        obj = OpenLayers.Format.JSON.prototype.read.apply(this, [json, null]);
	    } else { 
	        obj = json;
	    }    
	    
	    if (! obj) {
	    	console.log("Bad JSON: " + json);
	    } else {
	    	for (var i = 0; i < obj.layers.length; i ++) {
	    		try {
	    			var layer = obj.layers[i];
	    			
	    			var title = layer.title;
	    			
	    			var url = layer.url;
	    			
	    			var layername = layer.layerName;
	    			
	    			var protocol = layer.protocol;
	    			
	    			if (protocol.indexOf("WMS", 0) != -1) {
	    				var wmslayer = new OpenLayers.Layer.WMS(title, 
	    						url, 
	    						{layers: layername, format: 'image/png', transparent: 'true'}, 
	    						{visibility: true}, 
	    						{isBaseLayer: false}
	    					);
	    				
	    				layers.add(wmslayer);
	    			}
	    		} catch(err) {
	    			console.log(err);
	    		};
	    	};
	    }
	}, 
	
	write : function(obj, pretty) {
		blub = new Object();
		
		blub.title = 'test';
		
		blub.url = 'test';
		
		blub.layername = 'test';
		
		blub.protocol = 'test';
		
		return OpenLayers.Format.JSON.prototype.write.apply(this, [blub, pretty]);	
	}
});