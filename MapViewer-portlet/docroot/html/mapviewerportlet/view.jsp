<%@include file="/html/init.jsp" %>

<div id="getRecordByID">
	<input type="text" name="recordID" id="recordID" value="66dc6023-fece-4044-ab8b-49ac6379da35" />
	<input type="submit" value="GetRecordByID" onclick="getRecordByID(document.getElementById('recordID').value)"/>
</div>

<div id="locator">
	<input type="text" name="location" id="location" />
	<input type="submit" value="Locate" onclick="locate(document.getElementById('location').value)"/>
</div>

<div id='locations_element'></div>

<div id='map_element'></div>

<div id='legend_element'></div>

<script>
	var proxyUrl = '<%= prefs.getValue(Constants.proxyUrlPreferenceName, "") %>';
	
	var locatorUrl = '<%= prefs.getValue(Constants.locatorUrlPreferenceName, "http://dev.virtualearth.net/REST/v1/Locations/") %>';
	
	var locatorKey = '<%= prefs.getValue(Constants.locatorKeyPreferenceName, "Ao9qujBzDtg-nFiusTjt5VQ9x2NJB2wAD7YCRjaPz7hQQjxdFcl24tyhOwCDCIrw") %>';
	
	var cswServletUrl = '<%= prefs.getValue(Constants.cswServletURLPreferenceName, "/MapViewer-portlet/cswservlet?") %>';
	
	var cswUrl = '<%= prefs.getValue(Constants.cswURLPreferenceName, "http://dev.ace.geocat.net/geonetwork/srv/en/csw?") %>';
	
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

        chmmap.addBingLayers();
        
    	locator = new CHM.Locator('locations_element', {});

    	locator.setOnLocationChanged(handleLocationChanged);
    	
    	csw = new CHM.CSW();
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