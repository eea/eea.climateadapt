<%@page import="nl.wur.alterra.cgi.ace.mapviewer.csw.FileIdentifiers"%>
<%@page import="java.util.ArrayList"%>
<%@include file="/html/init.jsp" %>

<div id='status_element'>Status</div>

<div id='map_element'></div>

<div id='legend_element'><h3 id="legend-title">Legend</h3></div>

<div id='toc_element'><h3 id="toc-title">Table of contents</h3></div>

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
				
	var locator;
	
	var csw;
	
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
        
        legendpanel = new GeoExt.LegendPanel({
            layerStore: mappanel.layers,
            renderTo: "legend_element",
            border: false
        });

        tocpanel = new Ext.tree.TreePanel({
            renderTo: "toc_element",
            root: new GeoExt.tree.LayerContainer({
                text: 'Map Layers',
                layerStore: mappanel.layers,
                leaf: false,
                expanded: true
            }),
            rootVisible: false,
            lines: false,
            enableDD: true
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
%>
	}
</script>