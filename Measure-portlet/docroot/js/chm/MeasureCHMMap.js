CHM.MeasureCHMMap = OpenLayers.Class(CHM.CHMMap, {

	feature : null,
	
	measure : null,
	
	onmeasurechanged : null,

	area : null,
	
	onareachanged : null,
	
	measurecontrol : null, 
	
	measurevectorlayer : null,
	
	similarareasvectorlayer : null, 
	
	initialize: function(options) {
		CHM.CHMMap.prototype.initialize.apply(this, arguments);
	},
	
	addMeasureLayers : function() {
		measurevectorlayer = new OpenLayers.Layer.Vector('Measure',	{
	    	displayInLayerSwitcher: true,
	    	styleMap: new OpenLayers.StyleMap({
	    	    "default": new OpenLayers.Style({
	    	        pointRadius: 8, 
	    	        fillColor: "#0070c0",
	    	        strokeColor: "#002060",
	    	        strokeWidth: 2,
	    	        graphicZIndex: 1
	    	    }),
	    	    "default": new OpenLayers.Style({
	    	        pointRadius: 8, 
	    	        fillColor: "#0070c0",
	    	        strokeColor: "#002060",
	    	        strokeWidth: 2,
	    	        graphicZIndex: 1
	    	    }),
	    	})
	    });
		
		similarareasvectorlayer = new OpenLayers.Layer.Vector("WFS", {
		    strategies: [new OpenLayers.Strategy.BBOX()],
		    protocol: new OpenLayers.Protocol.WFS({
		      	version: '1.1.0',
		        url: proxyUrl + geoserverUrl + wfs + '?', 
		        featureType: 'biogeo_2005',
		        featureNS: 'http://ace.geocat.net',
		        geometryName: 'geom',
		        maxFeatures: 1,
		        srsName: this.projection
		    })
		});
		
		similarareasvectorlayer.events.register("featureadded", this, function(e) {
			this.setArea(e.feature.attributes.biogeo);
		});
        
		this.addLayers([similarareasvectorlayer, measurevectorlayer]);
				
		measurecontrol = new CHM.MeasureControl({measureCHMMap: this});
				
		this.addControl(measurecontrol);
				
		measurecontrol.activate();
	},
	
	getArea : function() {
		return this.area;
	},
	
	setArea : function(aArea) {
		this.area = aArea;
		
		this.handleOnAreaChanged();
	},
	
	setOnAreaChanged : function(aFunction) {
		this.onareachanged = aFunction;
	},
	
	handleOnAreaChanged : function() {
		if (this.onareachanged != null) {
			this.onareachanged();
		}
	},
	
	getMeasure : function(aEPSGCode) {
		return this.transform(this.measure, aEPSGCode);
	}, 
	
	setMeasure : function(aMeasure) {
		this.measure = this.transform(aMeasure, this.projection);
		
        if (this.measure != null) {
        	this.setFeature(new OpenLayers.Feature.Vector(this.measure));
        } else {
        	this.setFeature(null);
        }
        
		this.handleOnMeasureChanged();
	},
	
	setOnMeasureChanged : function(aFunction) {
		this.onmeasurechanged = aFunction;
	},
	
	handleOnMeasureChanged : function() {
		if (this.onmeasurechanged != null) {
			this.onmeasurechanged();
		}
	},
	
	transform : function(aMeasure, aProjection) {
		var sourceprojection = aMeasure.getProjection();

		var targetprojection = aProjection;

		var result = new CHM.Measure(aMeasure.x, aMeasure.y, targetprojection);

		result.transform(sourceprojection, targetprojection);
		
		return result;
	},
	
	getFeature : function() {
		return this.feature;
	}, 
	
	setFeature : function(aFeature) {
		if (this.feature != null) {
			measurevectorlayer.removeFeatures([this.feature]); 
		}
		
		this.feature = aFeature;		
		
		if (this.feature != null) {
			measurevectorlayer.addFeatures([this.feature]); 
			
			this.setArea('');
			
			similarareasvectorlayer.filter = new OpenLayers.Filter.Spatial({
		        type: OpenLayers.Filter.Spatial.INTERSECTS,
		        value: this.feature.geometry
		    });
			
			similarareasvectorlayer.refresh({force: true});
		}
	}
});
