CHM.MapViewer = OpenLayers.Class({
	
	mapViewerInstance: null,
	
	map: null,
	
	mapElement: null,
	
	tocElement: null,
	
	statusElement: null,
	
	initialize : function(aMapElement, aTOCElement, aStatusElement) {
		Ext.namespace("GeoExt.tree");
			    
		mapViewerInstance = this;
		
		mapViewerInstance.mapElement = aMapElement;
		
		mapViewerInstance.tocElement = aTOCElement;
		
		mapViewerInstance.statusElement = aStatusElement;
		
		Ext.QuickTips.init();

		mapViewerInstance.map = new CHM.MapViewerCHMMap();
				
		mapViewerInstance.map.setOnStatusChanged(mapViewerInstance.handleStatusChanged);
				
		mapViewerInstance.map.setOnRestoreComplete(mapViewerInstance.handleRestoreComplete);
		
		var mappanel = new GeoExt.MapPanel({renderTo: aMapElement, height: 500, width: 500, map: mapViewerInstance.map});
		        
		// Use a custom layer node UI class
		var layernodeui = Ext.extend(GeoExt.tree.LayerNodeUI, new GeoExt.tree.TreeNodeUIEventMixin());

		// Create a tree panel
	    var treepanel = new Ext.tree.TreePanel({
	        renderTo: aTOCElement,
	        layerStore: mappanel.layers,
	        width: 600,
	        autoScroll: true,
	        enableDD: true,
	        // Apply the tree node component plugin to layer nodes
	        plugins: [
	        	{ptype: "gx_treenodecomponent"},
	        	{ptype: "gx_treenodeactions", listeners: {action: mapViewerInstance.treeAction}}
	        ],
	        loader: {
	            applyLoader: false,
	            uiProviders: {"custom_ui": layernodeui}
	        },
	        root: {
	            nodeType: "gx_layercontainer",
	            loader: {
	                baseAttrs: {
	                    uiProvider: "custom_ui", 
	                    actions: [{
	                        action: "delete",
	                        qtip: "delete",
	                        update: function(el) { 
	                            // "this" references the tree node 
	                            var layer = this.layer; 
	                            if (layer.name == foregroundlayername || layer.name == backgroundlayername) { 
	                                el.addClass('disabled'); 
	                            } else { 
	                                el.removeClass('disabled'); 
	                            } 
	                        } 
	                    }, {
	                        action: "metadata",
	                        qtip: "show metadata",
	                        update: function(el) { 
	                            // "this" references the tree node 
	                            var layer = this.layer; 
	                            if (layer.metadataURL == null) { 
	                                el.addClass('disabled'); 
	                            } else { 
	                                el.removeClass('disabled'); 
	                            } 
	                        } 
	                    }]
	                },
	                createNode: function(attr) {
	                    // add a WMS legend to each node created
	                    attr.component = {
	                        xtype: "gx_wmslegend",
	                        layerRecord: mappanel.layers.getByLayer(attr.layer),
	                        showTitle: false,
	                        // custom class for css positioning
	                        // see tree-legend.html
	                        cls: "legend"
	                    }
	                    return GeoExt.tree.LayerLoader.prototype.createNode.call(this, attr);
	                }
	            }
	        },
	        rootVisible: false,
	        lines: false
	    });
		    
	    mapViewerInstance.map.restore();		        
    },
    
    addLayer : function(aLayer) {
    	mapViewerInstance.map.addLayer(aLayer);
    }, 
		    
    handleStatusChanged : function() {
    	mapViewerInstance.statusElement.innerHTML = mapViewerInstance.map.getStatus();
	},
		    
    handleRestoreComplete : function() {
		test_layer = new OpenLayers.Layer.WMS('Test2', 
				geoserverUrl + wms + '?', 
				{layers: 'nuts:nuts3', format: 'image/png', transparent: 'true'}, 
				{visibility: true}, 
				{tileOptions: {maxGetUrlLength: 2048}}, 
				{isBaseLayer: false}
			);
			
		test_layer.metadataURL = 'http://www.nu.nl';
			
		mapViewerInstance.addLayer(test_layer);
	},
	
	// This function takes action based on the "action"
	// parameter, it is used as a listener to layer
	// nodes' "action" events
	treeAction : function(node, action, evt) {
		var layer = node.layer;
	
		switch(action) {
			case "metadata":
				window.open(layer.metadataURL);
	
				break;
			case "delete":
				layer.destroy();
	
				break;
		}
	}
});
