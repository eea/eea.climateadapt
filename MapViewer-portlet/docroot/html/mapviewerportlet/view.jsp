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
	
	// Custom layer node UI class for the table of contents
	var LayerNodeUI = Ext.extend(
	    GeoExt.tree.LayerNodeUI,
	    new GeoExt.tree.TreeNodeUIEventMixin()
	);
	
    Ext.onReady(function() {
    	mapviewerchmmap = new CHM.MapViewerCHMMap();
		
    	mapviewerchmmap.setOnStatusChanged(handleStatusChanged);
		
    	mapviewerchmmap.setOnRestoreComplete(handleRestoreComplete);
		
        mappanel = new GeoExt.MapPanel({
            renderTo: 'map_element',
            height: 350,
            width: 675,
            map: mapviewerchmmap
        });

        tocpanel = new Ext.tree.TreePanel({
            layerStore: mappanel.layers,
            renderTo: "toc_element",
            width: 250,
            autoScroll: true,
            enableDD: true,
            // apply the tree node component plugin to layer nodes
            plugins: [{
                ptype: "gx_treenodecomponent"
            }],
            loader: {
                applyLoader: false,
                uiProviders: {
                    "custom_ui": LayerNodeUI
                }
            },
            root: {
                nodeType: "gx_layercontainer",
                loader: {
                    baseAttrs: {
                        uiProvider: "custom_ui"
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