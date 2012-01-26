<%@page import="nl.wur.alterra.cgi.ace.mapviewer.csw.FileIdentifiers"%>
<%@page import="java.util.ArrayList"%>
<%@include file="/html/init.jsp" %>

<div id='map_element'></div>

<div id='toc_element'><h3 id="toc-title">Table of contents</h3></div>

<div id='status_element' style='display:none'>map status</div>

<script>
	var proxyUrl = '<%= prefs.getValue(Constants.proxyUrlPreferenceName, "") %>';
	
	var locatorUrl = '<%= prefs.getValue(Constants.locatorUrlPreferenceName, "http://dev.virtualearth.net/REST/v1/Locations/") %>';
	
	var locatorKey = '<%= prefs.getValue(Constants.locatorKeyPreferenceName, "Ao9qujBzDtg-nFiusTjt5VQ9x2NJB2wAD7YCRjaPz7hQQjxdFcl24tyhOwCDCIrw") %>';
	
	var zoomLevel = '<%= prefs.getValue(Constants.zoomLevelPreferenceName, "2") %>';
	
	var cswServletUrl = '<%= prefs.getValue(Constants.cswServletURLPreferenceName, "/MapViewer-portlet/cswservlet?") %>';
	
	var cswUrl = '<%= prefs.getValue(Constants.cswURLPreferenceName, "http://dev.ace.geocat.net/geonetwork/srv/en/csw?") %>';
	
	var cswUsername = '<%= prefs.getValue(Constants.cswUserNamePreferenceName, "") %>';
	
	var cswPassword = '<%= prefs.getValue(Constants.cswPassWordPreferenceName, "") %>';

	var mapViewerServletUrl = '<%= prefs.getValue(Constants.mapViewerServletURLPreferenceName, "/MapViewer-portlet/mapviewerservlet") %>';
	
	var mapviewerchmmap;
	
	Ext.namespace("GeoExt.tree");

	// this function takes action based on the "action"
	// parameter, it is used as a listener to layer
	// nodes' "action" events
	GeoExt.tree.onAction = function(node, action, evt) {
	    var layer = node.layer;
	    switch(action) {
	    case "down":
	        layer.map.raiseLayer(layer, -1);
	        break;
	    case "up":
	        layer.map.raiseLayer(layer, +1);
	        break;
	    case "delete":
	        layer.destroy();
	        break;
	    }
	};

	// Custom layer node UI class for the table of contents
	var ui = Ext.extend (
	    GeoExt.tree.LayerNodeUI,
	    new GeoExt.tree.TreeNodeUIEventMixin()
	);
	
    Ext.onReady(function() {
        Ext.QuickTips.init();

		mapviewerchmmap = new CHM.MapViewerCHMMap();
		
		mapviewerchmmap.setOnStatusChanged(handleStatusChanged);
		
		mapviewerchmmap.setOnRestoreComplete(handleRestoreComplete);
		
        mappanel = new GeoExt.MapPanel({
            renderTo: 'map_element',
			height: 350,
			width: 675,
            map: mapviewerchmmap
        });
        
        var tree = new Ext.tree.TreePanel({
            renderTo: "toc_element",
            layerStore: mappanel.layers,
            title: "Layer Tree",
            loader: {
                applyLoader: false,
                uiProviders: {
                    "ui": ui
                }
            },
            // apply the tree node actions plugin to layer nodes
            plugins: [{
                ptype: "gx_treenodeactions",
                listeners: {
                    action: GeoExt.tree.onAction
                }		                
            },
            {
                ptype: "gx_treenodecomponent"
            }],
            root: {
                nodeType: "gx_layercontainer",
                loader: {
                    baseAttrs: {
                        radioGroup: "radiogroup",
                        uiProvider: "ui",
                        actions: [{
                            action: "delete",
                            qtip: "delete"
                        }, {
                            action: "up",
                            qtip: "move up",
                            update: function(el) { 
                                // "this" references the tree node 
                                var layer = this.layer, map = layer.map; 
                                if (map.getLayerIndex(layer) == map.layers.length - 1) { 
                                    el.addClass('disabled'); 
                                } else { 
                                    el.removeClass('disabled'); 
                                } 
                            } 
                        }, { 
                            action: "down", 
                            qtip: "move down", 
                            update: function(el) { 
                                // "this" references the tree node 
                                var layer = this.layer, map = layer.map; 
                                if (map.getLayerIndex(layer) == 1) { 
                                    el.addClass('disabled'); 
                                } else { 
                                    el.removeClass('disabled'); 
                                } 
                            } 
                        }]
                    },
                    createNode: function(attr) {
                    	if (attr.layer instanceof OpenLayers.Layer.WMS) {
	                        // Add a WMS legend to each WMS node created
	                        attr.component = {
	                            xtype: "gx_wmslegend",
	                            layerRecord: mappanel.layers.getByLayer(attr.layer),
	                            showTitle: false,
	                            // custom class for css positioning
	                            // see tree-legend.html
	                            cls: "legend"
                    		}
                        }
                        return GeoExt.tree.LayerLoader.prototype.createNode.call(this, attr);
                    }
                }
            },
            rootVisible: false,
            lines: false
        });
        
        mapviewerchmmap.addBingLayers();
	        
        mapviewerchmmap.restore();
    });
    
    function handleStatusChanged() {
    	document.getElementById('status_element').innerHTML = mapviewerchmmap.getStatus();
	}
    
    function handleRestoreComplete() {
    	mapviewerchmmap.registerEvents();
	        
<%
		// Add layer from querystring
       	String cswurl = prefs.getValue(Constants.cswURLPreferenceName, "http://ace.geocat.net/geonetwork/en/csw?");
        	
       	String cswusername = prefs.getValue(Constants.cswUserNamePreferenceName, "");
        	
       	String cswpassword = prefs.getValue(Constants.cswPassWordPreferenceName, "");
        	
       	try {
	   		CSW csw = new CSW(cswurl, cswusername, cswpassword);
				
			HttpServletRequest httprequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
	        
	        String metadatarecordid = httprequest.getParameter(Constants.cswRecordFileIdentifierParameterName);
				
			if (metadatarecordid != null && metadatarecordid.length() > 0) {
				CSWRecord cswrecord = csw.getRecordByID(metadatarecordid);
				
				for (int i = 0; i < cswrecord.getDigitalTransferOptions().size(); i ++) {
					DigitalTransferOption digitaltransferoption = cswrecord.getDigitalTransferOptions().get(i);
					
					if (digitaltransferoption.getProtocol().indexOf("WMS") != -1) {
						String javascript = "mapviewerchmmap.addLayer(new OpenLayers.Layer.WMS('" 
							+ cswrecord.getTitle() + "', '" 
							+ digitaltransferoption.getUrl() + "', {layers: '" 
							+ digitaltransferoption.getLayerName() + "', format: 'image/png', transparent: 'true'}, {visibility: true}, {tileOptions: {maxGetUrlLength: 2048}}, {isBaseLayer: false}));";
					
						out.println(javascript);
					}
				}
			}
       	} catch (Exception e) {
       		out.println("document.getElementById('status_element').innerHTML = 'Error in communication with catalogue server';");
       	}
%>
	}
</script>