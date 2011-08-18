CHM.Measure = OpenLayers.Class(OpenLayers.Geometry.Point, {
	epsgcode : null, 
    
    initialize : function(x, y, aEPSGCode) {
        OpenLayers.Geometry.Point.prototype.initialize.apply(this, arguments);
        
        this.epsgcode = aEPSGCode;
    },
    
    getEPSGCode : function() {
    	return this.epsgcode;
    },  
    
    setEPSGCode : function(aEPSGCode) {
    	this.epsgcode = aEPSGCode;
    } 
});