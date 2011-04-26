var app;
Ext.onReady(function() {
	Ext.QuickTips.init();
	
	// Define layers
	var base = new OpenLayers.Layer.WMS(
        "Global Imagery",
        "http://maps.opengeo.org/geowebcache/service/wms",
        {layers: "bluemarble", format: 'image/png', transparent: 'true'}, {'isBaseLayer':true}
    );

	// Create application
	app = new MapViewer({
		widgetConfig: {
			toolbar: false,
            legend: false,
			renderTo: "map_container",
			width: 500,
			height: 400
		},
	
		mapConfig: {
			layers: [base],
			numZoomLevels: 15,
			center: [7, 50],
			zoom: 4
		},

        legendConfig: {
            renderTo: "map_legend",
			width: 400,
			height: 400
        }
	});



    /*var serverUrl = "http://hrz-vm130.hrz.uni-kassel.de/cgi-bin/mapserv?map=/var/www/html/maps/mapfiles/wg3_drivers2/prec2_pch_cell_0ann_2050ipcm4a2.map&";
    var layerName = "prec2_pch_cell_0ann_2050ipcm4a2";
    var layerTitle = "Precipitation";

    app.addLayer(serverUrl, layerName, layerTitle);*/
});
		

/** api: constructor
 *  .. class:: MapViewer(config)
 *     Create a new ACE MapViewer application.
 *
 *     Parameters:
 *     config - {Object} Optional application configuration properties.
 *
 *     Valid config properties:
 *     widgetConfig - {Object} Map widget configuration object.
 *     mapConfig - {Object} Map configuration object.
 *     legendConfig - {Object} Legend configuration object
 *
 *     Valid widget config properties:
 *         toolbar - {Boolean} Optional show/hide map toolbar. Default to false.
 *         legend - {Boolean} Optioncal show/hide layers legend. Default to false.
 *         renderTo - {String} Id of dom element to render the map widget.
 *         width - {Integer} Optional map widget width (pixels)
 *         height - {Integer} Optional map widget height (pixels)
 *
 *     Valid map config properties:
 *     layers - {Array} List of {OpenLayers.Layer} to add to map.
 *     numZoomLevels - {Integer} Optional default number of zoom levels.
 *     center - {Array} Default center map point.
 *     zoom - {Integer} Optional default initial zoom level.
 *
 *     Valid legend config properties:
 *     renderTo - {String} Id of dom element to render the map legend.
 *     width - {Integer} Optional map legend width (pixels)
 *     height - {Integer} Optional map legend height (pixels)

 */
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
		
		this.map.addControl(new OpenLayers.Control.PanZoomBar(), new OpenLayers.Pixel(225,5));
		
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


        // Map legend panel
        if (widgetConfig.legend) {
            var legendConfig = this.initialConfig.legendConfig || {
                renderTo: "map_legend",
			    width: 300,
			    height: 400
            };

            this.legendPanel = new GeoExt.LegendPanel({
                defaults: {
                    style: 'padding:5px'
                },
                // Don't show base layer legend
                filter: function(record) {
                    return !record.getLayer().isBaseLayer;
                },
                bodyStyle: 'padding:5px',
                width: legendConfig.width,
                height: legendConfig.height,
                autoScroll: true,
                renderTo: legendConfig.renderTo
            });

        }

    },

    addLayer: function(serverUrl, layerName, layerTitle) {

        var layer = new OpenLayers.Layer.WMS(
            layerTitle,
            serverUrl,
            {layers: layerName, format: 'image/png', transparent: 'true'}, {'isBaseLayer':false, 'singleTile': true}
        );

        this.map.addLayer(layer);
    }
    
});