Ext.onReady(function() {
	Ext.QuickTips.init();
	
	// Define layers
	var base = new OpenLayers.Layer.WMS(
        "Global Imagery",
        "http://maps.opengeo.org/geowebcache/service/wms",
        {layers: "bluemarble", format: 'image/png', transparent: 'true'}, {'isBaseLayer':true}
    );

	// Create application
	var app = new MapViewer({
		widgetConfig: {
			toolbar: false,
			renderTo: "map_container",
			width: 400, 
			height: 400
		},
	
		mapConfig: {
			layers: [base],
			numZoomLevels: 15,
			center: [7, 44],
			zoom: 4
		}
	});
});
		
		
var MapViewer = Ext.extend(Ext.util.Observable, {
    
    /** api: property[map]
     * :class:`OpenLayers.Map` The application's map.
     */
    map: null,
    
    /**
     * private: property[mapPanel]
     * the :class:`GeoExt.MapPanel` instance for the main viewport
     */
    mapPanel: null,
    
    constructor: function(config) {
    	this.initialConfig = Ext.apply({}, config);
        Ext.apply(this, this.initialConfig);
        
    	this.createLayout();    
    },
    
    createLayout: function() {
     	var mapConfig = this.initialConfig.mapConfig || {};
     	
     	this.map = new OpenLayers.Map({
				controls: [new OpenLayers.Control.Navigation()], 
			  	numZoomLevels: mapConfig.numZoomLevels || 20 
		});
		
		this.map.addControl(new OpenLayers.Control.PanZoomBar(), new OpenLayers.Pixel(175,5)); 
		
		// Load layers
		for (var i = 0; i < mapConfig.layers.length; i++) {
			this.map.addLayer(mapConfig.layers[i]);
		}

 		
 		// place map in panel
		this.mapPanel = new GeoExt.MapPanel({
			layout: "anchor",
			border: false,
			region: "center",
			map: this.map,
			center: mapConfig.center && new OpenLayers.LonLat(mapConfig.center[0], mapConfig.center[1]),
			zoom: mapConfig.zoom || 1
		});
		
        var widgetConfig = this.initialConfig.widgetConfig || {};
        
        // Toolbar
        var ctrl, toolbarItems = [], action, actions = {};
        var toolbar;
        
        if (widgetConfig.toolbar) {
			// ZoomToMaxExtent control, a "button" control
			action = new GeoExt.Action({
				control: new OpenLayers.Control.ZoomToMaxExtent(),
				map: this.map,
				text: "max extent",
				tooltip: "zoom to max extent"
			});
			actions["max_extent"] = action;
			toolbarItems.push(action);
			toolbarItems.push("-");
		
			// Navigation control and DrawFeature controls
			// in the same toggle group
			action = new GeoExt.Action({
				text: "nav",
				control: new OpenLayers.Control.Navigation(),
				map: this.map,
				// button options
				toggleGroup: "draw",
				allowDepress: false,
				pressed: true,
				tooltip: "navigate",
				// check item options
				group: "draw",
				checked: true
			});
			actions["nav"] = action;
			toolbarItems.push(action);
			
			// Navigation history - two "button" controls
			ctrl = new OpenLayers.Control.NavigationHistory();
			this.map.addControl(ctrl);
		
			action = new GeoExt.Action({
				text: "previous",
				control: ctrl.previous,
				disabled: true,
				tooltip: "previous in history"
			});
			actions["previous"] = action;
			toolbarItems.push(action);
		
			action = new GeoExt.Action({
				text: "next",
				control: ctrl.next,
				disabled: true,
				tooltip: "next in history"
			});
			actions["next"] = action;
			toolbarItems.push(action);
			toolbarItems.push("->");    
			
			toolbar = new Ext.Toolbar({
				xtype: "toolbar",
				autoHeight: true,
				region: "north",
				items: toolbarItems
			});
			
			var viewport = new Ext.Panel({
				layout: "fit",
				renderTo: widgetConfig.renderTo || "map",
				width: widgetConfig.width || 400,
				height: widgetConfig.height || 400,
				hideBorders: true,
				items: {
					layout: "border",
					deferredRender: false,
					items: [
						toolbar,
						this.mapPanel
					]
				}
			});    
        
		} else {
		
			var viewport = new Ext.Panel({
				layout: "fit",
				renderTo: widgetConfig.renderTo || "map",
				width: widgetConfig.width || 400,
				height: widgetConfig.height || 400,
				hideBorders: true,
				items: {
					layout: "border",
					deferredRender: false,
					items: [
						this.mapPanel
					]
				}
			});    
        }

    },

    addLayer: function(serverUrl, layerName, layerTitle) {

        var layer = new OpenLayers.Layer.WMS(
            layerTitle,
            serverUrl,
            {layers: layerName, format: 'image/png', transparent: 'true'}, {'isBaseLayer':false}
        );

        this.map.addLayer(layer);
    }
    
});