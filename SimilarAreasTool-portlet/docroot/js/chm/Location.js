CHM.Location = OpenLayers.Class(OpenLayers.Geometry.Point, {
	_epsgcode : null, 
    
    initialize : function(x, y, aEPSGCode) {
        OpenLayers.Geometry.Point.prototype.initialize.apply(this, arguments);
        
        this._epsgcode = aEPSGCode;
    },
    
    getEPSGCode : function() {
    	return this._epsgcode;
    },  
    
    setEPSGCode : function(aEPSGCode) {
    	this._epsgcode = aEPSGCode;
    } 
});