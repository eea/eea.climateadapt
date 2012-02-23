CHM.MapViewer = OpenLayers.Class({
	
	mapViewerInstance: null,
	
	map: null,
	
	mapElement: null,
	
	tocElement: null,
	
	statusElement: null,
	
	abstractElement: null,
	
    oncreationcomplete: null, 
	
	initialize : function(aMapElement, aTOCElement, aStatusElement, aAbstractElement) {
		Ext.namespace("GeoExt.tree");
			    
		mapViewerInstance = this;
		
		mapViewerInstance.mapElement = aMapElement;
		
		mapViewerInstance.tocElement = aTOCElement;
		
		mapViewerInstance.statusElement = aStatusElement;
		
		mapViewerInstance.abstractElement = aAbstractElement;
		
		Ext.QuickTips.init();

		mapViewerInstance.map = new CHM.MapViewerCHMMap();
				
		mapViewerInstance.map.setOnStatusChanged(mapViewerInstance.handleStatusChanged);
				
		mapViewerInstance.map.setOnRestoreComplete(mapViewerInstance.handleRestoreComplete);
		
		var mappanel = new GeoExt.MapPanel({renderTo: aMapElement, height: 350, width: 675, map: mapViewerInstance.map});
		        
		// Use a custom layer node UI class
		var layernodeui = Ext.extend(GeoExt.tree.LayerNodeUI, new GeoExt.tree.TreeNodeUIEventMixin());

		// Create a tree panel
	    new Ext.tree.TreePanel({
	        renderTo: aTOCElement,
	        layerStore: mappanel.layers,
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
	                        action: "abstract",
	                        qtip: "show abstract",
	                        update: function(el) { 
	                            // "this" references the tree node 
	                            var layer = this.layer; 
	                            if (layer.metadataURL == null) { 
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
                        if (attr.layer.name != foregroundlayername && attr.layer.name != backgroundlayername) { 
		                    // add a WMS legend to each node created
		                    attr.component = {
		                        xtype: "chm_wmslegend",
		                        layerRecord: mappanel.layers.getByLayer(attr.layer),
		                        showTitle: false,
		                        // custom class for css positioning
		                        // see tree-legend.html
		                        cls: "legend"
		                    };
                        };
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
    	mapViewerInstance.handleOnCreationComplete();
	},
	
	// This function takes action based on the "action"
	// parameter, it is used as a listener to layer
	// nodes' "action" events
	treeAction : function(node, action, evt) {
		var layer = node.layer;
	
		switch(action) {
			case "abstract":
				mapViewerInstance.showAbstract(layer);
	
				break;
			case "metadata":
				window.open(layer.metadataURL);
	
				break;
			case "delete":
				layer.destroy();
	
				break;
		}
	},
	
	showAbstract : function (aLayer) {
		mapViewerInstance.setStatus('downloading abstract');
		
		var cswurl = aLayer.metadataURL.split(showMetadata)[0] + csw;
		
		var fileidentifier = aLayer.metadataURL.split(showMetadata)[1];
		
		OpenLayers.Request.GET({
			url: cswServletUrl,
			callback: mapViewerInstance.getHandler,
			params: 
	    	{
				cswUrl: cswurl,
				cswPassword: cswUsername,
	    		cswUserName: cswPassword,
	    		cswRecordFileIdentifier: fileidentifier
	    	}
		});
	},
	
	getHandler : function (request) {
		if (request.status == 200) {
			var format = new CHM.GetRecordByIdResponse();
			
            var obj = format.read(request.responseXML);
            
            mapViewerInstance.abstractElement.innerHTML = obj.abstract;
		
			mapViewerInstance.setStatus('abstract downloaded');
		} else {
			mapViewerInstance.setStatus('error downloading abstract');
		};
	}, 
	
	getOnCreationComplete : function() {
		return mapViewerInstance.oncreationcomplete;
	},
	
	setOnCreationComplete : function(aFunction) {
		mapViewerInstance.oncreationcomplete = aFunction;
	},
	
	handleOnCreationComplete : function() {
		if (mapViewerInstance.oncreationcomplete != null) {
			mapViewerInstance.oncreationcomplete();
		}
	},
		    
    setStatus : function(aStatus) {
    	mapViewerInstance.statusElement.innerHTML = aStatus;
	}
});
