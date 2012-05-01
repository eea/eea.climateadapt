CHM.SATCHMMap = OpenLayers.Class(CHM.CHMMap, {

	location : null,
	
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
			        externalGraphic: '/SimilarAreasTool-portlet/js/chm/markers/location.png'
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
		
        case_studies_similar_areas = new CHM.SATVector(
        	'Case studies in similar areas', 
        	{
    			displayInLayerSwitcher: true,
        		type: OpenLayers.Filter.Comparison.EQUAL_TO, 
        		radius: 20,
        		marker: '/SimilarAreasTool-portlet/js/chm/markers/similar.png'
        	});
        
        case_studies_dissimilar_areas = new CHM.SATVector(
        	'Case studies in other areas', 
        	{
    			displayInLayerSwitcher: true,
        		type: OpenLayers.Filter.Comparison.NOT_EQUAL_TO, 
        		radius: 16,
        		marker: '/SimilarAreasTool-portlet/js/chm/markers/dissimilar.png'
        	});
        
        select = new OpenLayers.Layer.Vector(
        	"Selection", 
        	{
        		styleMap: new OpenLayers.Style(OpenLayers.Feature.Vector.style["select"]),
        		displayInLayerSwitcher: false
        	}
        );

		this.addLayers([similar_areas_image_layer, similar_areas_vector_layer, select, case_studies_dissimilar_areas, case_studies_similar_areas, location_vector_layer]);
            
		locationcontrol = new CHM.LocationControl({satCHMMap: this});
		
		this.addControl(locationcontrol);
				
		locationcontrol.activate();
		
		var selectfeaturescontrol = new OpenLayers.Control.SelectFeature(
			[case_studies_similar_areas, case_studies_dissimilar_areas], 
			{
				multiple: false, 
				hover: false,
				onSelect: this.onFeatureSelect, 
				onUnselect: this.onFeatureUnselect
			});
     
     	this.addControl(selectfeaturescontrol);
	        
        selectfeaturescontrol.activate();
	}, 
	
	onFeatureSelect : function(feature) {
		var description = feature.attributes.desc;
		
		if (description == undefined) {
			description = '';
		}
		
		popup = new OpenLayers.Popup.Anchored(null, 
        	feature.geometry.getBounds().getCenterLonLat(),
        	new OpenLayers.Size(250,100),
            "<table width='100%' border='0'>" +
            "<tr><th>" + feature.attributes.itemname + "</th></tr>" + 
            "<tr><td>" + description + "</td></tr>" + 
            "<tr><td><a href='/viewmeasure?ace_measure_id=" + feature.attributes.measureid + "' target='_blank'>read more</a></td></tr>" + 
            "</table>",
            null, true, null);
            
        feature.popup = popup;
        
        this.map.addPopup(popup);
	},
        
    onFeatureUnselect : function(feature) {
		this.map.removePopup(feature.popup);
		
		feature.popup.destroy();
		
		feature.popup = null;
	},
	
	setArea : function(aArea) {
		similar_areas_image_layer.mergeNewParams({'CQL_FILTER': "biogeo = '" + aArea + "' "});
		
		case_studies_similar_areas.setArea(aArea);
			
		case_studies_dissimilar_areas.setArea(aArea);
	},
	
	setRisk : function(aRisk) {
		case_studies_similar_areas.setRisk(aRisk);
			
		case_studies_dissimilar_areas.setRisk(aRisk);
	},
	
	setSector : function(aSector) {
		case_studies_similar_areas.setSector(aSector);
			
		case_studies_dissimilar_areas.setSector(aSector);
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
	}
});
