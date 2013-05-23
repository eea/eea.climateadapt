CHM.SATCHMMap = OpenLayers.Class(CHM.CHMMap, {

	location : null,
	
	feature: null,
	
	tooltip: null,
	
	caseStudiesSimilarAreasVectorLayer: null,
	
	caseStudiesDissimilarAreasVectorLayer: null,
	
	offsetX: null,
	
	offsetY: null,
	
    selectionSymbolizer: {
        'Polygon': {fillColor: '#FF0000', stroke: false},
        'Line': {strokeColor: '#FF0000', strokeWidth: 2},
        'Point': {graphicName: 'square', fillColor: '#FF0000', pointRadius: 5}
    },

    initialize: function(options) {
		CHM.CHMMap.prototype.initialize.apply(this, arguments);
	},
	
	addSATLayers : function() {
		location_vector_layer = new OpenLayers.Layer.Vector('Location',	{
	    	displayInLayerSwitcher: true,
	    	styleMap: new OpenLayers.StyleMap({
	    	    "default": new OpenLayers.Style({
	    	        pointRadius: 24,
	    	        graphicZIndex: 1,
			        externalGraphic: root + 'js/chm/markers/location.png'
	    	    }),
	    	})
	    });
		
		similar_areas_image_layer = new OpenLayers.Layer.WMS('Biogeographical regions', 
			geoserverUrl + wms + '?', 
			{layers: areasLayer, format: 'image/png', transparent: 'true'}, 
			{visibility: true}, 
			{tileOptions: {maxGetUrlLength: 2048}}, 
			{isBaseLayer: false}
		);
		
		similar_areas_vector_layer = new OpenLayers.Layer.Vector("Selected area", {
		    strategies: [new OpenLayers.Strategy.BBOX()],
		    protocol: new OpenLayers.Protocol.WFS({
		      	version: '1.1.0',
		        url: proxyUrl + geoserverUrl + wfs + '?', 
		        featureType: areasFeatureType,
		        featureNS: featureNamespace,
		        geometryName: geometryColumn,
		        maxFeatures: 1,
		        srsName: this.projection,
		        propertyNames: ["biogeo"]
		    })
		});
		
		similar_areas_vector_layer.events.register("featureadded", this, function(e) {
			this.setArea(e.feature.attributes.biogeo);
		});
		
        this.caseStudiesSimilarAreasVectorLayer = new CHM.SATVector(
        	'Case studies in similar areas', 
        	{
    			displayInLayerSwitcher: true,
        		type: OpenLayers.Filter.Comparison.EQUAL_TO, 
        		radius: 20,
        		marker: root + 'js/chm/markers/similar.png'
        	});
        
        this.caseStudiesSimilarAreasVectorLayer.offsetX = this.offsetX;
        
        this.caseStudiesSimilarAreasVectorLayer.offsetY = this.offsetY;
        
        this.caseStudiesDissimilarAreasVectorLayer = new CHM.SATVector(
        	'Case studies in other areas', 
        	{
    			displayInLayerSwitcher: true,
        		type: OpenLayers.Filter.Comparison.NOT_EQUAL_TO, 
        		radius: 16,
        		marker: root + 'js/chm/markers/dissimilar.png'
        	});
        
        this.caseStudiesDissimilarAreasVectorLayer.offsetX = this.offsetX;
        
        this.caseStudiesDissimilarAreasVectorLayer.offsetY = this.offsetY;
        
        select = new OpenLayers.Layer.Vector(
        	"Selection", 
        	{
        		styleMap: new OpenLayers.Style(OpenLayers.Feature.Vector.style["select"]),
        		displayInLayerSwitcher: false
        	}
        );

		similar_areas_image_layer.mergeNewParams({'CQL_FILTER': "biogeo = 'JustToMakeSureThatNoAreasAreShownAtStartUp' "});
		
		this.addLayers([similar_areas_image_layer, similar_areas_vector_layer, select, this.caseStudiesDissimilarAreasVectorLayer, this.caseStudiesSimilarAreasVectorLayer, location_vector_layer]);
            
		locationcontrol = new CHM.LocationControl({satCHMMap: this});
		
		this.addControl(locationcontrol);
				
		locationcontrol.activate();
		
		var selectfeaturescontrol = new OpenLayers.Control.SelectFeature(
			[this.caseStudiesSimilarAreasVectorLayer, this.caseStudiesDissimilarAreasVectorLayer], 
			{
				multiple: false, 
				hover: false,
			});
     
     	this.addControl(selectfeaturescontrol);
	        
        selectfeaturescontrol.activate();
	}, 
	
	setArea : function(aArea) {
		similar_areas_image_layer.mergeNewParams({'CQL_FILTER': "biogeo = '" + aArea + "' "});
		
		this.caseStudiesSimilarAreasVectorLayer.setArea(aArea);
			
		this.caseStudiesDissimilarAreasVectorLayer.setArea(aArea);
	},
	
	setRisk : function(aRisk) {
		this.caseStudiesSimilarAreasVectorLayer.setRisk(aRisk);
			
		this.caseStudiesDissimilarAreasVectorLayer.setRisk(aRisk);
	},
	
	setSector : function(aSector) {
		this.caseStudiesSimilarAreasVectorLayer.setSector(aSector);
			
		this.caseStudiesDissimilarAreasVectorLayer.setSector(aSector);
	},
	
	setLocation : function(aLocation) {
		this.location = this.transform(aLocation, this.projection);
		
        if (this.location != null) {
        	this.setFeature(new OpenLayers.Feature.Vector(this.location));
        	
            this.setCenter(new OpenLayers.LonLat(this.location.x, this.location.y));
        } else {
        	this.setFeature(null);
        }
	},
	
	transform : function(aLocation, aProjection) {
		var sourceprojection = aLocation.getProjection();

		var targetprojection = aProjection;

		var result = new CHM.Location(aLocation.x, aLocation.y, targetprojection);

		result.transform(sourceprojection, targetprojection);
		
		return result;
	},
	
	getFeature : function() {
		return this.feature;
	}, 
	
	setFeature : function(aFeature) {
		if (this.feature != null) {
			location_vector_layer.removeFeatures([this.feature]); 
		}
		
		this.feature = aFeature;		
		
		if (this.feature != null) {
			location_vector_layer.addFeatures([this.feature]); 
			
			this.setArea(null);
			
			similar_areas_vector_layer.filter = new OpenLayers.Filter.Spatial({
		        type: OpenLayers.Filter.Spatial.INTERSECTS,
		        value: this.feature.geometry
		    });
			
			similar_areas_vector_layer.refresh({force: true});
		}
	},
	
	setOffsetX: function(aOffsetX) {
		this.offsetX = aOffsetX;
		
		if (this.caseStudiesSimilarAreasVectorLayer != null) {
			this.caseStudiesSimilarAreasVectorLayer.offsetX = aOffsetX;
		}

		if (this.caseStudiesDissimilarAreasVectorLayer != null) {
			this.caseStudiesDissimilarAreasVectorLayer.offsetX = aOffsetX;
		}
	},
	
	setOffsetY: function(aOffsetY) {
		this.offsetY = aOffsetY;
		
		if (this.caseStudiesSimilarAreasVectorLayer != null) {
			this.caseStudiesSimilarAreasVectorLayer.offsetY = aOffsetY;
		}

		if (this.caseStudiesDissimilarAreasVectorLayer != null) {
			this.caseStudiesDissimilarAreasVectorLayer.offsetY = aOffsetY;
		}
	}
});
