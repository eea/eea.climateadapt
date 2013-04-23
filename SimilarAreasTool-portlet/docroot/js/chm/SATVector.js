CHM.SATVector = OpenLayers.Class(OpenLayers.Layer.Vector, {
	
	protocol: null,
	
	type: null, 
	
	marker: null, 
	
	radius: null,
	
	area: null,
	
	risk: null,
	
	sector: null,
	
	initialize: function(options) {
		OpenLayers.Layer.Vector.prototype.initialize.apply(this, arguments);
		
        protocol = new OpenLayers.Protocol.WFS({
	       	version: '1.1.0',
			url:  proxyUrl + geoserverUrl + wfs + '?', 
	        featureType: caseStudiesFeatureType,
	        featureNS: featureNamespace,
	        geometryName: geometryColumn,
	        srsName: 'EPSG:900913'
        });
        
        this.styleMap = new OpenLayers.StyleMap({
	        "default": new OpenLayers.Style({
		        pointRadius: this.radius, 
		        graphicZIndex: 1,
		        externalGraphic: this.marker
	        }),
	        "select": new OpenLayers.Style({
		        pointRadius: this.radius, 
		        graphicZIndex: 1,
		        externalGraphic: this.marker
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
        this.removeAllFeatures();
     	
		var filters = new Array();
		
		if (this.area != null) {
			var area_filter = this.createFilter(this.type, areaColumn, this.area);
			
			filters.push(area_filter);
		}
			
		if (this.risk != "ALL" && this.risk != null) {
			var risk_filter = this.createFilter(OpenLayers.Filter.Comparison.LIKE, 'risks', '*' + this.risk + '*');
				
			filters.push(risk_filter);
		}
			
		if (this.sector != "ALL" && this.sector != null) {
			var sector_filter = this.createFilter(OpenLayers.Filter.Comparison.LIKE, 'sectors', '*' + this.sector + '*');
				
			filters.push(sector_filter);
		}
			
		if (filters.length > 0) {
		    var filter = new OpenLayers.Filter.Logical({
			    type: OpenLayers.Filter.Logical.AND,
			    filters: filters
		    });
				    
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
			if (this.type == OpenLayers.Filter.Comparison.NOT_EQUAL_TO) {
				protocol.read({
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
