var app, appMapStep4;

var gazeeteerStep2, gazeeteer;

var infoMapMessages = {
    "vulnerability": "<p>Vulnerability and risks represent bla bla bla  lorum ipsum hardanger voda en joda krijgt het heen en weer...</p>" +
        "<p>Choose a risk and (optionally) a sector to find out what corresponding vulnerabilities and risks are.</p>",

    "underlying_causes": "<p>Underlying causes can be both caused by the global system (exposure) and the human system (sensitivity) bla bla bla  " +
            "lorum ipsum hardanger voda en joda krijgt het heen en weer...</p>",

    "climate_change": "<p>Climate changes bla bla bla  lorum ipsum hardanger voda en joda krijgt het heen en weer...</p>",

    "socio_ecological": "<p>Socio-ecological bla bla bla  lorum ipsum hardanger voda en joda krijgt het heen en weer...</p>"

};

function initMapViewerIndicators() {
    if (app) return;
	
    // Create application
	app = new MapViewer({
		widgetConfig: {
			toolbar: false,
            legend: false,
			renderTo: "map_container",
            infoPanelId: "map_info",
			width: 500,
			height: 400
		},

		mapConfig: {
			layers: [],
			numZoomLevels: 15,
			center: [9, 50],
			zoom: 2
		},

        legendConfig: {
            renderTo: "map_legend",
			width: 400,
			height: 400
        }
	});
	
    //app.showMapInfoPanel(infoMapMessages["vulnerability"]);

    var base = new OpenLayers.Layer.WMS(
       "NUTS0",
       "http://ace.geocat.net:8080/geoserver/wms",
       {layers: "nuts:nuts0", format: 'image/png', transparent: 'true'}, {'isBaseLayer':false}
    );
	
    app.addBaseLayer(base);
	
    gazeeteerStep2 = new Gazeeteer({url: "http://137.224.11.5/arcgis/rest/services/Nuts/GeocodeServer/findAddressCandidates",
                               wfsUrl: "http://ace.geocat.net:8080/geoserver/wfs",
                               resultsDiv: "locate_region_step2_results",
                               mapWidget: app});							   
}

Ext.onReady(function() {
	Ext.QuickTips.init();

    displayStep(1);

	
    appMapStep4 = new MapViewer({
		widgetConfig: {
			toolbar: false,
            legend: false,
			renderTo: "map-container-step4",
			width: 650,
			height: 400
		},

		mapConfig: {
			layers: [],
			numZoomLevels: 15,
			center: [9, 50],
			zoom: 2
		}
	});

	/* disabled because map in step 4 is disabled 
	
    gazeeteer = new Gazeeteer({url: "http://137.224.11.5/arcgis/rest/services/Nuts/GeocodeServer/findAddressCandidates",
                               wfsUrl: "http://ace.geocat.net:8080/geoserver/wfs",
                               resultsDiv: "locate_region_results",
                               mapWidget: appMapStep4});

	*/
	
    /*var serverUrl = "http://hrz-vm130.hrz.uni-kassel.de/cgi-bin/mapserv?map=/var/www/html/maps/mapfiles/wg3_drivers2/prec2_pch_cell_0ann_2050ipcm4a2.map&";
    var layerName = "prec2_pch_cell_0ann_2050ipcm4a2";
    var layerTitle = "Precipitation";

    app.addLayer(serverUrl, layerName, layerTitle);*/
});

var $j = jQuery.noConflict();


$j(window).load(function() {
    // Define layers
    /*var baseMapStep4 = new OpenLayers.Layer.WMS(
       "NUTS0",
       "http://ace.geocat.net:8080/geoserver/wms",
       {layers: "nuts:nuts0", format: 'image/png', transparent: 'true'}, {'isBaseLayer':false}
    );*/

	/* disabled because map in step 4 is disabled 
	
    var baseMapStep4 = new OpenLayers.Layer.WMS(
        "Global Imagery",
        "http://maps.opengeo.org/geowebcache/service/wms",
        {layers: "bluemarble", format: 'image/png', transparent: 'true'}, {'isBaseLayer':true}
    );

    appMapStep4.addBaseLayer(baseMapStep4);
	
	*/
	
	// in IE, pressing <ENTER> in the gazetteer input in step 2, reloads the page (thus makes step 2 disappear) if not handled explicitly:	
	$j('#locate_region_step2_input').bind('keydown',function(e){ 
		// jQuery.which normalizes keycodes for all browsers; 13 is <ENTER>
		if(e.which === 13) {
			gazeeteerStep2.search($j('#locate_region_step2_input').val()); 
			return false;
		}
	});	
	
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

        var widgetConfig = this.initialConfig.widgetConfig || {};

        this.mapInfoPanelId = widgetConfig.infoPanelId;

     	this.map = new OpenLayers.Map({
				controls: [new OpenLayers.Control.Navigation()], 
			  	numZoomLevels: mapConfig.numZoomLevels || 20
		});

		this.map.addControl(new OpenLayers.Control.PanZoomBar(), new OpenLayers.Pixel(((widgetConfig.width || 400) /2) - 25 ,5));
        
		// do not put loading panel if IE, it never disappears
		if(! $.browser.msie) {
			this.map.addControl(new OpenLayers.Control.LoadingPanel());
		}
        var base = new OpenLayers.Layer.Image('base', '../images/blank.gif', new OpenLayers.Bounds(-180,-90,180,90),
                    new OpenLayers.Size(widgetConfig.width || 400, widgetConfig.height || 400), {isBaseLayer: true, displayInLayerSwitcher: false});

        this.map.addLayer(base);

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
                    return ((!record.getLayer().isBaseLayer) && (record.getLayer().name != "NUTS0"));
                },
                bodyStyle: 'padding:5px',
                width: legendConfig.width,
                height: legendConfig.height,
                autoScroll: true,
                renderTo: legendConfig.renderTo
            });

        }

    },

    addBaseLayer: function(layer) {
        this.map.addLayer(layer);

        this.map.setBaseLayer(layer);
    },

    addLayer: function(serverUrl, layerName, layerTitle) {
        $j("#map_info").hide();

        var layer = new OpenLayers.Layer.WMS(
            layerTitle,
            serverUrl,
            {layers: layerName, format: 'image/png', transparent: 'true'}, {'isBaseLayer':false, 'singleTile': true}
        );

        for(var i = 0; i < this.map.layers.length; i++) {
            if (this.mapPanel.map.layers[i].name != "NUTS0") {
                this.mapPanel.map.removeLayer(this.map.layers[i]);
            }
        }

        this.mapPanel.map.addLayer(layer);


        this.mapPanel.map.raiseLayer(layer, -1);

    },

    zoomTo: function(bbox) {
        //alert(bbox[0] + " "+ bbox[1] + " "+ bbox[2] + " "+ bbox[3]);
        var bounds = new OpenLayers.Bounds(bbox[0], bbox[1], bbox[2], bbox[3]);

        var ml = this.mapPanel.map.getLayersByName("Markers");
        var markers;

        if (ml.length ==0) {
          markers = new OpenLayers.Layer.Markers( "Markers" );
          this.mapPanel.map.addLayer(markers);
        } else {
            markers = ml[0];
        }

        markers.clearMarkers();
        markers.addMarker(new OpenLayers.Marker(bounds.getCenterLonLat()));


        //alert(bounds.toBBOX());
        //this.map.panTo(bounds.getCenterLonLat());
        this.map.zoomToExtent(bounds);
    },

    addMark: function(bbox) {
        //alert(bbox[0] + " "+ bbox[1] + " "+ bbox[2] + " "+ bbox[3]);
        var bounds = new OpenLayers.Bounds(bbox[0], bbox[1], bbox[2], bbox[3]);

        var ml = this.mapPanel.map.getLayersByName("Markers");
        var markers;

        if (ml.length ==0) {
          markers = new OpenLayers.Layer.Markers( "Markers" );
          this.mapPanel.map.addLayer(markers);
        } else {
            markers = ml[0];
        }

        markers.clearMarkers();
        markers.addMarker(new OpenLayers.Marker(bounds.getCenterLonLat()));


        //alert(bounds.toBBOX());
        //this.map.panTo(bounds.getCenterLonLat());

        this.map.panTo(bounds.getCenterLonLat());
    },

    showLegendWindow: function() {
        var legendPanel = new GeoExt.LegendPanel({
            defaults: {
                style: 'padding:5px'
            },
            layerStore: this.mapPanel.layers,
            // Don't show base layer legend
            filter: function(record) {
                return ((!record.getLayer().isBaseLayer) && (record.getLayer().name != "NUTS0"));
            },
            dynamic: true,
            bodyStyle: 'padding:5px',
            width: 500,
            height: 350,
            autoScroll: true
        });


        new Ext.Window({
            title: "Map legend",
            width: 500,
            height: 350,
            layout: "fit",
            items: [legendPanel]
        }).show();
    },

    showMapInfoPanel: function(content) {
        var viewSize = this.map.getSize();
        var msgW = viewSize.w +2;
        var msgH = viewSize.h + 2;

        var infoPanel = $j("#" + this.mapInfoPanelId);

        infoPanel.css("width", msgW + "px");
        infoPanel.css("height", msgH + "px");

        infoPanel.html(content);
        infoPanel.show();

    },

    drawPoints: function() {


    }
    
});


var Gazeeteer = Ext.extend(Object, {

    /** api: property[url]
     * :class:`String` Gazeeteer url.
     */
    url: null,

    /** api: property[wfsUrl]
     * :class:`String` WFS server url.
     */
    wfsUrl: null,

    /** api: property[wfsUrl]
     * :class:`String` WFS server url.
     */
    wfsUrl: null,

    /** api: property[resultsDiv]
     * :class:`String` Identifier of div container to show the search results.
     */
    resultsDiv: null,

    /** api: property[mapWidget]
     * :class:`MapViewer` Mapviewer widget associated with Gazeeteer.
     */
    mapWidget: null,

    constructor: function(config) {
    	this.initialConfig = Ext.apply({}, config);
        Ext.apply(this, this.initialConfig);
    },

    search: function(name) {
        var $j = jQuery.noConflict();

        var resultsContainerName = this.resultsDiv;

        var gazeeteer = this;

        $j.ajaxSetup({ scriptCharset: "utf-8" , contentType: "application/json; charset=utf-8"});
        $j.getJSON(proxyUrl + this.url + '&Name='+ name + '&outFields=Ref_id,Loc_name&f=json' ,
            function(data){

                var resultsContainer = $j("#" + resultsContainerName);
                resultsContainer.html("");
                resultsContainer.show();


                var location;
                var list, listElement;

                $j(document.createElement("div"))
                       .addClass("clickable")
                       .attr({ style: 'float:right; margin: 5px; font-size: 1.2em' })
                       .append("Close")
                       .appendTo(resultsContainer)
                       .click(function() {
                           resultsContainer.hide();
                       });


                $j(document.createElement("h2"))
                        .attr({ style: 'margin: 5px;' })
                        .appendTo(resultsContainer)
                        .append("Results")

                list = $j(document.createElement("ul"))
                        .attr({ style: 'margin-top: 15px; margin-left: 25px; font-size: 1.2em' })
						.appendTo(resultsContainer)

                $.each(data.candidates, function(i,item){
                    listElement = $j(document.createElement("li"))
						.appendTo(list)

                    var layerInfo = '';
                    var loc_name = item.attributes.Loc_name;

                    if (loc_name == 'Nuts0AddressLo') {
                        layerInfo = 'nuts0';
                    } else if (loc_name == 'Nuts1AddressLo') {
                        layerInfo = 'nuts1';
                    } else if (loc_name == 'Nuts2AddressLo') {
                        layerInfo = 'nuts2';
                    } else if (loc_name == 'Nuts3AddressLo') {
                        layerInfo = 'nuts3';
                    } else if (loc_name == 'CitiesAddressL') {
                        layerInfo = 'Cities'
                    }

                    var text = item.address + "(" + layerInfo + ")";

                    location = $j(document.createElement("div"))
						.addClass("clickable")
						.attr({ style: 'float:left;' })
                        .append(text)
						.appendTo(listElement)
						.click(function() {
                            gazeeteer.zoomToLocation(item.attributes.Ref_ID, item.attributes.Loc_name, item.location.x, item.location.y);
                            resultsContainer.hide();
						});
                });
        });

    },

    search2: function(name) {
        var $j = jQuery.noConflict();

        var resultsContainerName = this.resultsDiv;

        var gazeeteer = this;

        $j.ajaxSetup({ scriptCharset: "utf-8" , contentType: "application/json; charset=utf-8"});
        $j.getJSON(proxyUrl + this.url + '&Name='+ name + '&outFields=Ref_id,Loc_name&f=json' ,
            function(data){



                var resultsContainer = $j("#" + resultsContainerName);
                resultsContainer.html("");

                if (data.candidates.length == 0) {
                    resultsContainer.hide();
                    return;
                }
                resultsContainer.show();


                var location;
                var list, listElement;

                $j(document.createElement("div"))
                       .addClass("clickable")
                       .attr({ style: 'float:right; margin: 5px; font-size: 1.2em' })
                       .append("Close")
                       .appendTo(resultsContainer)
                       .click(function() {
                           resultsContainer.hide();
                       });

                list = $j(document.createElement("ul"))
                        .attr({ style: 'margin-top: 15px; margin-left: 25px; font-size: 1.2em' })
						.appendTo(resultsContainer)

                $.each(data.candidates, function(i,item){
                    listElement = $j(document.createElement("li"))
						.appendTo(list)

                    var layerInfo = '';
                    var loc_name = item.attributes.Loc_name;

                    if (loc_name == 'Nuts0AddressLo') {
                        layerInfo = 'nuts0';
                    } else if (loc_name == 'Nuts1AddressLo') {
                        layerInfo = 'nuts1';
                    } else if (loc_name == 'Nuts2AddressLo') {
                        layerInfo = 'nuts2';
                    } else if (loc_name == 'Nuts3AddressLo') {
                        layerInfo = 'nuts3';
                    } else if (loc_name == 'CitiesAddressL') {
                        layerInfo = 'Cities'
                    }

                    var text = item.address + "(" + layerInfo + ")";

                    location = $j(document.createElement("div"))
						.addClass("clickable")
						.attr({ style: 'float:left;' })
                        .append(text)
						.appendTo(listElement)
						.click(function() {
                            gazeeteer.markLocation(item.attributes.Ref_ID, item.attributes.Loc_name, item.location.x, item.location.y);
                            resultsContainer.hide();
						});
                });
        });

    },

    zoomToLocation: function(fid, loc_name, x, y) {
        //alert(loc_name);

        var $j = jQuery.noConflict();

        var layer = '';

        if (loc_name == 'Nuts0AddressLo') {
            layer = 'nuts0';
        } else if (loc_name == 'Nuts1AddressLo') {
            layer = 'nuts1';
        } else if (loc_name == 'Nuts2AddressLo') {
            layer = 'nuts2';
        } else if (loc_name == 'Nuts3AddressLo') {
            layer = 'nuts3';
        } else if (loc_name == 'CitiesAddressL') {
            //alert("x: " + x + ", y: " + y);
            var bbox = [x-2, y-2, x+2, y+2];
            this.mapWidget.zoomTo(bbox);
            return;
        }

        $j.getJSON(proxyUrl + this.wfsUrl + '&request=GetFeature&version=1.1.0&typeName=nuts:'+ layer + '&srsName=EPSG:4326&outputFormat=json&FEATUREID=' + layer + '.' + (fid +1) ,
            function(data){
                //alert("result Gazeeteer")
                $.each(data.features, function(i,item){
                    //alert(item.id + " " + item.properties.bbox);

                    this.mapWidget.zoomTo(item.properties.bbox);
            });
        });
    },

    markLocation: function(fid, loc_name, x, y) {
        //alert(loc_name);

        var $j = jQuery.noConflict();

        var layer = '';

        var mapWidget = this.mapWidget;

        if (loc_name == 'Nuts0AddressLo') {
            layer = 'nuts0';
        } else if (loc_name == 'Nuts1AddressLo') {
            layer = 'nuts1';
        } else if (loc_name == 'Nuts2AddressLo') {
            layer = 'nuts2';
        } else if (loc_name == 'Nuts3AddressLo') {
            layer = 'nuts3';
        } else if (loc_name == 'CitiesAddressL') {
            //alert("x: " + x + ", y: " + y);
            var bbox = [x-2, y-2, x+2, y+2];
            mapWidget.addMark(bbox);
            return;
        }

        $j.getJSON(proxyUrl + this.wfsUrl + '&request=GetFeature&version=1.1.0&typeName=nuts:'+ layer + '&srsName=EPSG:4326&outputFormat=json&FEATUREID=' + layer + '.' + (fid +1) ,
            function(data){


                //alert("result Gazeeteer")
                $.each(data.features, function(i,item){
                    //alert(item.id + " " + item.properties.bbox);

                    mapWidget.addMark(item.properties.bbox);
            });
        });
    }



});


