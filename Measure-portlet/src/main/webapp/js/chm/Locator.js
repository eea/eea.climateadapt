CHM.Locator = OpenLayers.Class({
    
    div: null,
    
    location: null, 
    
    onlocationchanged: null, 
    
    initialize : function (div, options) {
        // If only one argument is provided, check if it is an object.
        if(arguments.length === 1 && typeof div === "object") {
            options = div;
            div = options && options.div;
        }
        
        this.div = OpenLayers.Util.getElement(div);
        
        if(!this.div) {
            this.div = document.createElement("div");
            
            this.div.style.height = "1px";
            
            this.div.style.width = "1px";
        }
    },

    locate : function(aName) {
		OpenLayers.Request.GET(
			{
		    	url: proxyUrl + locatorUrl + aName,
		    	params: 
		    	{
		    		output: 'json', 
		    		key: locatorKey,
		    		random: Math.random()
		    	},
		    callback: this.handler
		});				
	}, 
	
	handler : function(response) {
		locator.div.innerHTML = "";
		
		var resourceset = new CHM.ResourceSet();

		resourceset.read(response.responseText);
		
		for (var i = 0; i < resourceset.numResources(); i ++) {
			var resource = resourceset.getResource(i);
			
			locator.div.innerHTML = locator.div.innerHTML + "<a onclick='locator.setLocation(" + resource.point.x + ", " + resource.point.y + ")'>" + resource.name + "</a><br />";
		}
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