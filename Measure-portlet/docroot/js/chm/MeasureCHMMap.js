CHM.MeasureCHMMap = OpenLayers.Class(CHM.CHMMap, {

	measure : null,
	
	onmeasurechanged : null,

	area : null,
	
	onareachanged : null,
	
	feature : null,
	
	measurecontrol : null, 
	
	measurevectorlayer : null,
	
	similarareasvectorlayer : null, 
	
	initialize: function(options) {
		CHM.CHMMap.prototype.initialize.apply(this, arguments);

		measurevectorlayer = new OpenLayers.Layer.Vector('Measure');
		
		similarareasvectorlayer = new OpenLayers.Layer.Vector("WFS", {
		    strategies: [new OpenLayers.Strategy.BBOX()],
		    protocol: new OpenLayers.Protocol.WFS({
		      	version: '1.1.0',
		        url: proxyUrl + geoserverUrl + wfs + '?', 
		        featureType: 'biogeo_2005',
		        featureNS: 'http://ace.geocat.net',
		        geometryName: 'geom',
		        srsName: 'EPSG:3035'
		    })
		});
		
		similarareasvectorlayer.events.register("featureadded", this, function(e) {
			this.setArea(e.feature.attributes.biogeo);
		});
        
		this.addLayers([measurevectorlayer, similarareasvectorlayer]);
				
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
	
	transform : function(aMeasure, aEPSGCode) {
		var sourceprojection = new OpenLayers.Projection(aMeasure.getEPSGCode());

		var targetprojection = new OpenLayers.Projection(aEPSGCode);

		var result = new CHM.Measure(aMeasure.x, aMeasure.y, aEPSGCode);

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
	}
});
