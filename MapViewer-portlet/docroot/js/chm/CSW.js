CHM.CSW = OpenLayers.Class({

	initialize : function(options) {
		
	},
	
    getRecordByID : function(aID) {
		OpenLayers.Request.GET(
			{
		    	url: proxyUrl + cswServletUrl,
		    	params: 
		    	{
		    		metadataRecordID: aID, 
		    		random: Math.random()
		    	},
		    callback: this.handler
		});				
	}, 
	
	handler : function(response) {
		console.log(response);
		
		var digitaltransferoptions = new CHM.DigitalTransferOptions();

		digitaltransferoptions.read(response.responseText);
    },
    
    getLocation : function() {
    	return this.location;
    },
	
	setLocation : function(x, y) {
		this.location = new CHM.Location(x, y, new OpenLayers.Projection("EPSG:4326"));
		
		this.handleOnLocationChanged();
	},
	
	setOnLocationChanged : function(aFunction) {
		this.onlocationchanged = aFunction;
	},
	
	handleOnLocationChanged : function() {
		if (this.onlocationchanged != null) {
			this.onlocationchanged();
		}
	}
});