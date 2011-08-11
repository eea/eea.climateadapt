CHM.SATMap = OpenLayers.Class(CHM.CHMMap, {
	
	casestudy_layer : null,
	
	strategy: null, 
	
	initialize : function(options) {
		CHM.CHMMap.prototype.initialize.apply(this, arguments);
		
		var biogeo_layer = new OpenLayers.Layer.WMS('Biogeographical regions 2005', 
			'../geoserver/wms?', 
			{layers: 'chm:biogeo_2005', format: 'image/png', transparent: 'true'}, 
			{isBaseLayer: false}
		);
		
		strategy = new OpenLayers.Strategy.BBOX();
		
		casestudy_layer = new OpenLayers.Layer.Vector('Case studies', 
			{
                strategies: [strategy],
                protocol: new OpenLayers.Protocol.WFS({
                	version: '1.1.0',
                    url:  '../geoserver/wfs', 
                    featureType: 'casestudies_intersect',
                    featureNS: 'http://ace.geocat.net',
                    geometryName: 'geom',
                    srsName: 'EPSG:3035'
                })
            })
		
        select = new OpenLayers.Layer.Vector("Selection", {styleMap: 
        	new OpenLayers.Style(OpenLayers.Feature.Vector.style["select"])
        });

		this.addLayers([biogeo_layer, casestudy_layer, select]);
            
		var control = new OpenLayers.Control.GetFeature({
                protocol: new OpenLayers.Protocol.WFS({
                	version: '1.1.0',
                    url:  '../geoserver/wfs', 
                    featureType: 'biogeo_2005',
                    featureNS: 'http://ace.geocat.net',
                    geometryName: 'geom',
                    srsName: 'EPSG:3035'
                }),
                box: false,
                hover: false,
                multipleKey: "shiftKey",
                toggleKey: "ctrlKey"
            });
            
            control.events.register("featureselected", this, function(e) {
            	select.removeAllFeatures();
            	
                select.addFeatures([e.feature]);

				var filter = new OpenLayers.Filter.Comparison({
            		type: OpenLayers.Filter.Comparison.EQUAL_TO,
                	property: "biogeo",
               		value: e.feature.attributes.biogeo
            	});
            	
		        var response = casestudy_layer.protocol.read({
		            maxFeatures: 100,
		            filter: filter,
		            callback: function(result) {
		                if(result.success()) {
		                    if(result.features.length) {
		                    	console.log(result.features.length);
		                    	select.addFeatures(result.features);
		                    }
		                }
		            },
		            scope: this
		        });
            });
            
            this.addControl(control);
     
            control.activate();
     }
});
