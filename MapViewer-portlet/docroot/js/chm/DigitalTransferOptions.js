CHM.DigitalTransferOptions = OpenLayers.Class(OpenLayers.Format.JSON, {
	
	digitaltransferoprions: [], 
	
    read : function(json) {
        var obj = null;
        
        if (typeof json == "string") {
            obj = OpenLayers.Format.JSON.prototype.read.apply(this, [json, null]);
        } else { 
            obj = json;
        }    
        
        if(! obj) {
        	console.log("Bad JSON: " + json);
        } else {
        	for (var i = 0; i < obj.digitalTransferOptions.length; i ++) {
        		try {
        			var digitaltransferoption = obj.digitalTransferOptions[i];
        			
        			var url = digitaltransferoption.url;
        			
        			var layername = digitaltransferoption.layerName;
        			
        			var protocol = digitaltransferoption.protocol;
        			
        			if (protocol.indexOf("WMS", 0) != -1) {
        				var wmslayer = new OpenLayers.Layer.WMS(layername, 
        						url, 
        						{layers: layername, format: 'image/png', transparent: 'true'}, 
        						{visibility: true}, 
        						{isBaseLayer: false}
        					);
        				
        				chmmap.addLayer(wmslayer);
        			}
        		} catch(err) {
        			console.log(err);
        		};
        	};
        }
    },
    
    parseResource : function(obj) {
    	var name = obj.name;
    	
    	var bbox = new OpenLayers.Bounds(obj.bbox[0], obj.bbox[1], obj.bbox[2], obj.bbox[3]);
    	
    	var point = new OpenLayers.Geometry.Point(obj.point.coordinates[1], obj.point.coordinates[0]);
    	
    	var resource = new CHM.Resource({name: name, boundingBox: bbox, point: point});
    	
    	return resource;
    },
    
    numResources : function() {
    	return this.resources.length;
    },
    
    getResource : function(aIndex) {
    	return this.resources[aIndex];
    }
});