CHM.Candidate = OpenLayers.Class({
	
	address: null,
	
	x: null,
	
    y: null,
    
	initialize : function(aAddress, aX, aY) {
		this.address = aAddress;
		
		this.x = aX;
		
		this.y = aY;
	},

	equals: function(aCandidate) {
		var result =  
			this.address == aCandidate.address && 
			Math.round(this.x * 1000) == Math.round(aCandidate.x * 1000) && 
			Math.round(this.y * 1000) == Math.round(aCandidate.y * 1000);
		
		return result;
	},
	
	toHtml: function() {
		return "<a onclick='locator.setLocation(" + this.x + ", " + this.y + ")'>" + this.address + "</a><br />";
	}
});