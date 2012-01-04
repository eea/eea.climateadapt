<%@page import="nl.wur.alterra.cgi.ace.mapviewer.csw.FileIdentifiers"%>
<%@page import="java.util.ArrayList"%>
<%@include file="/html/init.jsp" %>

<div id="locator">
        <script type="text/javascript">
            function getKey (event) {
                var keyCode = ('which' in event) ? event.which : event.keyCode;
                if (keyCode == 13) {
                        locate(document.getElementById('location').value);
                }
            }
        </script>
        <input type="text" name="location" id="location" onkeydown="getKey(event)" />
        <input type="submit" value="Locate" onclick="locate(document.getElementById('location').value)"/>
</div>

<div id='locations_element'></div>

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
	
	var chmmap;
				
	var locator;
	
	var csw;
	
    Ext.onReady(function() {
    	chmmap = new CHM.CHMMap();
		
        mappanel = new GeoExt.MapPanel({
            renderTo: 'map_element',
            height: 500,
            width: 500,
            map: chmmap
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

        chmmap.addBingLayers();
        
    	locator = new CHM.Locator('locations_element', {});

    	locator.setOnLocationChanged(handleLocationChanged);
    	
    	csw = new CHM.CSW();
    	
        <%
        // Add layers from preferences
        String fileidentifierspref = prefs.getValue(Constants.cswRecordFileIdentifiersPreferenceName, "");

        if (fileidentifierspref != null && fileidentifierspref.length() > 0) {
                String[] fileidentifiers = fileidentifierspref.split(",");

                for (int i = 0; i < fileidentifiers.length; i ++) {
                        String fileidentifier = fileidentifiers[i];

                        out.println("getRecordByID('" + fileidentifier + "')");
                }
        }
        
        // Add layers from session
        HttpServletRequest httprequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
        
		HttpSession httpsession = httprequest.getSession(true);
		
		FileIdentifiers fileidentifiers = null;
		
		if (httpsession.isNew()) {
			fileidentifiers = new FileIdentifiers();
			
			httpsession.setAttribute("fileIdentifiers", fileidentifiers);
		} else {
			fileidentifiers = (FileIdentifiers) httpsession.getAttribute("fileIdentifiers");
		}
		
		for (int i = 0; i < fileidentifiers.size(); i ++) {
            String fileidentifier = fileidentifiers.get(i);

            out.println("getRecordByID('" + fileidentifier + "')");
    	}

        // Add layer from querystring
        String fileidentifier = httprequest.getParameter(Constants.cswRecordFileIdentifierParameterName);

        if (fileidentifier != null && fileidentifier.length() > 0) {
                out.println("getRecordByID('" + fileidentifier + "')");
                
                fileidentifiers.add(fileidentifier);
        }
        %>
    });

	function handleLocationChanged() {
		alert("Not implemented yet!");
	}
	
    function locate(aLocation) {
    	locator.locate(aLocation);
    }
	
    function getRecordByID(aID) {
    	csw.getRecordByID(aID);
    }
</script>