CHM.SATCHMMap = OpenLayers.Class(CHM.CHMMap, {

	initialize: function(options) {
		CHM.CHMMap.prototype.initialize.apply(this, arguments);
		
		var biogeo_layer = new OpenLayers.Layer.WMS('Biogeographical regions 2005', 
			'http://dev.ace.geocat.net/geoserver/wms?', 
			{layers: 'chm:biogeo_2005', format: 'image/png', transparent: 'true'}, 
			{isBaseLayer: false}
		);
		
        similar_areas = new CHM.SATVector(
        	'Case studies in similar areas', 
        	{
        		type: OpenLayers.Filter.Comparison.EQUAL_TO, 
        		fill_color: '#93ff93', 
        		stroke_color: '#00ff00'
        	});
        
        dissimilar_areas = new CHM.SATVector(
        	'Case studies in other areas', 
        	{
        		type: OpenLayers.Filter.Comparison.NOT_EQUAL_TO, 
        		fill_color: '#ff9393', 
        		stroke_color: '#ff0000'
        	});
        
        select = new OpenLayers.Layer.Vector("Selection", {styleMap: 
        	new OpenLayers.Style(OpenLayers.Feature.Vector.style["select"])
        });

		this.addLayers([biogeo_layer, select, similar_areas, dissimilar_areas]);
            
		var control = new OpenLayers.Control.GetFeature({
	        protocol: new OpenLayers.Protocol.WFS({
		      	version: '1.1.0',
		        url:  'http://dev.ace.geocat.net/geoserver/wfs', 
		        featureType: 'biogeo_2005',
		        featureNS: 'http://ace.geocat.net',
		        geometryName: 'geom',
		        srsName: 'EPSG:3035'
	        }),
	        box: false,
	        hover: false,
        });
        
        control.events.register("featureselected", this, function(e) {
         	select.removeAllFeatures();
            	
            select.addFeatures([e.feature]);

			this.setArea(e.feature.attributes.biogeo);
		});
		    
		this.addControl(control);
     
		control.activate();
		
		var selectfeaturescontrol = new OpenLayers.Control.SelectFeature(
			[similar_areas, dissimilar_areas], 
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
		popup = new OpenLayers.Popup.Anchored("chicken", 
        	feature.geometry.getBounds().getCenterLonLat(),
            null,
            "<table width='100%' border='0'>" +
            "<tr><td>Area</td><td>" + feature.attributes.area + "</td></tr>" + 
            "<tr><td>Sector</td><td>" + feature.attributes.sector + "</td></tr>" + 
            "<tr><td>Risk</td><td>" + feature.attributes.risk + "</td></tr>" + 
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
		similar_areas.setArea(aArea);
			
		dissimilar_areas.setArea(aArea);
	},
	
	setRisk : function(aRisk) {
		similar_areas.setRisk(aRisk);
			
		dissimilar_areas.setRisk(aRisk);
	},
	
	setSector : function(aSector) {
		similar_areas.setSector(aSector);
			
		dissimilar_areas.setSector(aSector);
	}
});
