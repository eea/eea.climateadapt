CHM.SATVector = OpenLayers.Class(OpenLayers.Layer.Vector, {
	
	protocol: null,
	
	type: null, 
	
	fill_color: null,
	
	stroke_color: null,
	
	radius: null,
	
	area: null,
	
	risk: null,
	
	sector: null,
	
	initialize: function(options) {
		OpenLayers.Layer.Vector.prototype.initialize.apply(this, arguments);
		
        protocol = new OpenLayers.Protocol.WFS({
	       	version: '1.1.0',
			url:  proxyUrl + geoserverUrl + wfs + '?', 
	        featureType: 'casestudies',
	        featureNS: 'http://ace.geocat.net',
	        geometryName: 'geom',
	        maxFeatures: 1000,
	        srsName: 'EPSG:900913'
        });
        
        this.styleMap = new OpenLayers.StyleMap({
	        "default": new OpenLayers.Style({
		        pointRadius: this.radius, 
		        fillColor: this.fill_color,
		        strokeColor: this.stroke_color,
		        strokeWidth: 2,
		        graphicZIndex: 1
	        }),
	        "select": new OpenLayers.Style({
		        pointRadius: this.radius, 
		        fillColor: this.fill_color,
		        strokeColor: this.stroke_color,
		        strokeWidth: 2,
		        graphicZIndex: 1
	        })
        });
	},
	
	setArea : function(aArea) {
		this.area = aArea;
		
		this.applyFilters();
	},
	
	setRisk : function(aRisk) {
		this.risk = aRisk;
		
		this.applyFilters();
	},
	
	setSector : function(aSector) {
		this.sector = aSector;
		
		this.applyFilters();
	},
	
	applyFilters : function() {
		var filters = new Array();
		
		if (this.area != null) {
			var area_filter = this.createFilter(this.type, 'area', this.area);
			
			filters.push(area_filter);
			
			if (this.risk != "ALL") {
				var risk_filter = this.createFilter(OpenLayers.Filter.Comparison.LIKE, 'risks', '*' + this.risk + '*');
				
				filters.push(risk_filter);
			}
			
			if (this.sector != "ALL") {
				var sector_filter = this.createFilter(OpenLayers.Filter.Comparison.LIKE, 'sectors', '*' + this.sector + '*');
				
				filters.push(sector_filter);
			}
			
		    var filter = new OpenLayers.Filter.Logical({
			    type: OpenLayers.Filter.Logical.AND,
			    filters: filters
		    });
		    
	        this.removeAllFeatures();
	         	
	        protocol.read({
	            filter: filter,
	            callback: function(result) {
	                if(result.success()) {
	                    if(result.features.length) {
	                    	this.addFeatures(result.features);
	                    }
	                }
	            },
	            scope: this
	        });
		} else {
			this.removeAllFeatures();
		}
	}, 
		
	createFilter : function(aType, aProperty, aValue) {
		var filter = new OpenLayers.Filter.Comparison({
       		type: aType,
           	property: aProperty,
       		value: aValue
       	});
       	
       	return filter;
	}
});
