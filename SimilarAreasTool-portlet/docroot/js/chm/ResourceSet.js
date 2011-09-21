CHM.ResourceSet = OpenLayers.Class(OpenLayers.Format.JSON, {
	
	resources : null, 
	
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
        	this.resources = new Array();
        	
        	for (var i = 0; i < obj.resourceSets.length; i ++) {
        		try {
        			var resourceset = obj.resourceSets[i];
        			
        			for (var j = 0; j < resourceset.resources.length; j ++) {
        				var resource = this.parseResource(resourceset.resources[j]);
        				
        				this.resources.push(resource);
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