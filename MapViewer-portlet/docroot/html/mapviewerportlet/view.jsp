<%@page import="nl.wur.alterra.cgi.ace.mapviewer.csw.FileIdentifiers"%>
<%@page import="java.util.ArrayList"%>
<%@include file="/html/init.jsp" %>

<div id='map_element'></div>

<div id='toc_element'><h3 id="toc-title">Table of contents</h3></div>

<div id='status_element' style='display:none'>map status</div>

<script>
	var proxyUrl = '<%= prefs.getValue(Constants.proxyUrlPreferenceName, "") %>';
	
	var cswUrl = '<%= prefs.getValue(Constants.cswURLPreferenceName, "http://dev.ace.geocat.net/geonetwork/srv/") %>';

	var csw = '<%= prefs.getValue(Constants.cswCswPreferenceName, "en/csw?") %>'; 

	var showMetadata = '<%= prefs.getValue(Constants.cswShowMetadataPreferenceName, "en/metadata.show?uuid=") %>'; 
	
	var cswUsername = '<%= prefs.getValue(Constants.cswUserNamePreferenceName, "") %>';
	
	var cswPassword = '<%= prefs.getValue(Constants.cswPassWordPreferenceName, "") %>';

	var mapViewerServletUrl = '<%= prefs.getValue(Constants.mapViewerServletURLPreferenceName, "/MapViewer-portlet/mapviewerservlet") %>';

	var foregroundlayername = "Foreground";
	
	var backgroundlayername = "Background";
	
	var mapviewer;
	
	Ext.onReady(function() {
		mapviewer = new CHM.MapViewer(document.getElementById('map_element'), document.getElementById('toc_element'), document.getElementById('status_element'));
		
		mapviewer.setOnCreationComplete(handleMapViewerCreationComplete);
	});
	
    function handleMapViewerCreationComplete() {
<%
		// Add layer from querystring
       	String cswurl = prefs.getValue(Constants.cswURLPreferenceName, "http://ace.geocat.net/geonetwork/") + prefs.getValue(Constants.cswCswPreferenceName, "en/csw?");
        	
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
					
			       	String showmetadataurl = prefs.getValue(Constants.cswURLPreferenceName, "http://ace.geocat.net/geonetwork/") + prefs.getValue(Constants.cswShowMetadataPreferenceName, "en/metadata.show?uuid=") + metadatarecordid;

			       	if (digitaltransferoption.getProtocol().indexOf("WMS") != -1) {
						String javascript = "var layer = new OpenLayers.Layer.WMS('" 
							+ cswrecord.getTitle() + "', '" 
							+ digitaltransferoption.getUrl() + "', "  
							+ "{layers: '" + digitaltransferoption.getLayerName() + "', format: 'image/png', transparent: 'true'}, {visibility: true}, {tileOptions: {maxGetUrlLength: 2048}}, {isBaseLayer: false});";
					
							javascript += "layer.metadataURL = '" + showmetadataurl + "';";
							
							javascript += "mapviewer.addLayer(layer);";
							
							out.println(javascript);
					}
				}
			}
       	} catch (Exception e) {
       		out.println("document.getElementById('status_element').innerHTML = 'Error in communication with catalogue server: '" + e.getMessage() + ";");
       	}
%>
	}
</script>