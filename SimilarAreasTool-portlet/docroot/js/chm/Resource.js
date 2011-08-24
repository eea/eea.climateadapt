CHM.Resource = OpenLayers.Class(OpenLayers.Format.JSON, {
	
	name: null,
	
	boundingBox: null,
	
    point: null,
    
	initialize : function(options) {
		OpenLayers.Format.prototype.initialize.apply(this, arguments);
	}
});