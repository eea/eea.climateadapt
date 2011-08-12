CHM.SATVector = OpenLayers.Class(OpenLayers.Layer.Vector, {
	
	protocol: null,
	
	type: null, 
	
	fill_color: null,
	
	stroke_color: null,
	
	area: null,
	
	risk: null,
	
	sector: null,
	
	initialize: function(options) {
		OpenLayers.Layer.Vector.prototype.initialize.apply(this, arguments);
		
        protocol = new OpenLayers.Protocol.WFS({
	       	version: '1.1.0',
			url:  proxyUrl + geoserverUrl + wfs + '?', 
	        featureType: 'casestudies_intersect',
	        featureNS: 'http://ace.geocat.net',
	        geometryName: 'geom',
	        srsName: 'EPSG:3035'
        });
        
        this.styleMap = new OpenLayers.StyleMap({
	        "default": new OpenLayers.Style({
		        pointRadius: 6, 
		        fillColor: this.fill_color,
		        strokeColor: this.stroke_color,
		        strokeWidth: 2,
		        graphicZIndex: 1
	        }),
	        "select": new OpenLayers.Style({
		        pointRadius: 6, 
		        fillColor: "#66ccff",
		        strokeColor: "#3399ff",
		        graphicZIndex: 2
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
			
			if (this.risk != null) {
				var risk_filter = this.createFilter(OpenLayers.Filter.Comparison.EQUAL_TO, 'risk', this.risk);
				
				filters.push(risk_filter);
			}
			
			if (this.sector != null) {
				var sector_filter = this.createFilter(OpenLayers.Filter.Comparison.EQUAL_TO, 'sector', this.sector);
				
				filters.push(sector_filter);
			}
			
		    var filter = new OpenLayers.Filter.Logical({
			    type: OpenLayers.Filter.Logical.AND,
			    filters: filters
		    });
		    
	        this.removeAllFeatures();
	         	
	        var response = protocol.read({
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