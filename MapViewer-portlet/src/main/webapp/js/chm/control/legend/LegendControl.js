CHM.Control.Legend.LegendControl = Ext.extend(Ext.tree.TreePanel, {
	
	mapControl: null,
	
	abstractWindow: null,
	
    initComponent : function() {
    	this.id = 'mapviewer-legend-control';
    	
    	this.border = false;
    	
        this.autoScroll = true;

        this.enableDD = true;
        
        this.rootVisible = false;
        
        this.lines = false;
        
        this.plugins = [
    	    {ptype: "gx_treenodecomponent"},
    	    {ptype: "gx_treenodeactions", listeners: {action: this.treeAction, scope: this}}
        ];
        
        var layernodeui = Ext.extend(GeoExt.tree.LayerNodeUI, new GeoExt.tree.TreeNodeUIEventMixin());
        
        this.loader = {
            applyLoader: false,
            uiProviders: {
                "custom_ui": layernodeui
            }
        };
        
        this.layerStore = this.mapControl.layers;
        
        this.root = {
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
                mapControl: this.mapControl,
                createNode: function(attr) {
                    attr.component = {
                        xtype: "chm_wmslegend",
                        layerRecord: this.mapControl.layers.getByLayer(attr.layer),
                        showTitle: false,
                        cls: "legend"
                    }
                    return GeoExt.tree.LayerLoader.prototype.createNode.call(this, attr);
                }
            }
        };
        
        this.abstractWindow = new CHM.Control.Legend.AbstractWindow();
    	
    	CHM.Control.Legend.LegendControl.superclass.initComponent.call(this);
    },
    
	// This function takes action based on the "action"
	// parameter, it is used as a listener to layer
	// nodes' "action" events
	treeAction : function(node, action, evt) {
		var layer = node.layer;
	
		switch(action) {
			case "abstract":
				this.showAbstract(layer);
	
				break;
			case "metadata":
				window.open(layer.metadataURL);
	
				break;
			case "delete":
				layer.destroy();
	
				break;
		}
	},
	
	showAbstract: function(aLayer) {
		this.abstractWindow.showAbstract(aLayer);
		this.abstractWindow.show();
	}, 
    
    applicationInitialized: function() {

    }
});
