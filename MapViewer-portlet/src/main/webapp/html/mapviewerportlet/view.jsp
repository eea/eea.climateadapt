<%@page import="java.util.ArrayList"%>
<%@include file="/html/init.jsp" %>

<%
HttpServletRequest httprequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));

String mapviewerappid = httprequest.getParameter(Constants.mapViewerAppIdParameterName);

if (mapviewerappid == null || mapviewerappid.length() == 0) {
	mapviewerappid = prefs.getValue(Constants.mapViewerAppIdPreferenceName, "default");
}
%>

<div><br/><br/></div>

<div id='mapviewer_element'></div>

<script>
	var proxyUrl = '<%= prefs.getValue(Constants.proxyUrlPreferenceName, "") %>';

	var cswUrl = '<%= prefs.getValue(Constants.cswURLPreferenceName, "http://dev.ace.geocat.net/geonetwork/srv/") %>';

	var csw = '<%= prefs.getValue(Constants.cswCswPreferenceName, "en/csw?") %>';

	var showMetadata = '<%= prefs.getValue(Constants.cswShowMetadataPreferenceName, "en/metadata.show?uuid=") %>';

	var cswUsername = '<%= prefs.getValue(Constants.cswUserNamePreferenceName, "") %>';

	var cswPassword = '<%= prefs.getValue(Constants.cswPassWordPreferenceName, "") %>';

	var mapViewerServletUrl = '<%= prefs.getValue(Constants.mapViewerServletURLPreferenceName, "/MapViewer-portlet/mapviewerservlet") %>';

	var mapViewerWmcDirectory = '<%= prefs.getValue(Constants.mapViewerWmcDirectoryPreferenceName, "/home/mapviewer") %>';

	var cswServletUrl = '<%= prefs.getValue(Constants.cswServletURLPreferenceName, "/MapViewer-portlet/cswservlet") %>';

	var mapViewerAppId = '<%= mapviewerappid %>';

	var foregroundlayername = "Topography";

	var backgroundlayername = "Background";

	var application;

	Ext.onReady(function() {
		application = new CHM.Application();
		
		application.addListener('creationComplete', this.handleApplicationCreationComplete, this);
	});

    function handleApplicationCreationComplete() {
    	console.log('Creation complete!');
<%
		// Add layer(s) from querystring
		String cswrecordfileidentifiersparameter = httprequest.getParameter(Constants.cswRecordFileIdentifierParameterName);

		if (cswrecordfileidentifiersparameter == null) {
			cswrecordfileidentifiersparameter = httprequest.getParameter(Constants.cswRecordFileIdentifiersParameterName);
		}

		if (cswrecordfileidentifiersparameter != null && cswrecordfileidentifiersparameter.length() > 0) {
	       	String cswurl = prefs.getValue(Constants.cswURLPreferenceName, "http://ace.geocat.net/geonetwork/") + prefs.getValue(Constants.cswCswPreferenceName, "en/csw?");

	       	String cswusername = prefs.getValue(Constants.cswUserNamePreferenceName, "");

	       	String cswpassword = prefs.getValue(Constants.cswPassWordPreferenceName, "");

	       	try {
		        String[] metadatarecordids = cswrecordfileidentifiersparameter.split(";");

		   		CSW csw = new CSW(cswurl, cswusername, cswpassword, false);

		        for (int i = 0; i < metadatarecordids.length; i ++) {
		        	String metadatarecordid = metadatarecordids[i];

		        	metadatarecordid = metadatarecordid.replace(" ", "%20");

					CSWRecord cswrecord = csw.getRecordByID(metadatarecordid);

					for (int j = 0; j < cswrecord.getDigitalTransferOptions().size(); j ++) {
						DigitalTransferOption digitaltransferoption = cswrecord.getDigitalTransferOptions().get(j);

				       	String showmetadataurl = prefs.getValue(Constants.cswURLPreferenceName, "http://climate-adapt.eea.europa.eu/geonetwork/") + prefs.getValue(Constants.cswShowMetadataPreferenceName, "en/metadata.show?uuid=") + metadatarecordid;

				       	String protocol = digitaltransferoption.getProtocol();
				       	
				       	String protocolUpperCase = protocol == null ? "" : protocol.toUpperCase();

				       	String url = digitaltransferoption.getUrl();
				       	
				       	String urlUpperCase = url == null ? "" : url.toUpperCase();

				       	if (protocolUpperCase.indexOf("WMS") >= 0 || urlUpperCase.indexOf("SERVICE=WMS") >= 0) {
							String javascript = "var layer = new OpenLayers.Layer.WMS('" + cswrecord.getTitle();

							if (cswrecord.getDigitalTransferOptions().size() > 1 && digitaltransferoption.getLayerTitle() != null) {
								javascript += " - " + digitaltransferoption.getLayerTitle();
							}

							javascript += "', '" + digitaltransferoption.getUrl() + "', "
								+ "{layers: '" + digitaltransferoption.getLayerName() + "', format: 'image/png', transparent: 'true'}, {visibility: true}, {tileOptions: {maxGetUrlLength: 2048}}, {isBaseLayer: false});";

							javascript += "layer.metadataURL = '" + showmetadataurl + "';";

							if (cswrecord.getAttribution() != null) {
								javascript += "layer.attribution = '" + cswrecord.getAttribution() + "';";
							}

							javascript += "application.addLayer(layer);";

							out.println(javascript);
						}
					}
		        }
	       	} catch (Exception e) {
	       		out.println("document.getElementById('status_element').innerHTML = Error in communication with catalogue server: " + e.getMessage() + ";");
	       	}
    	}
%>
	}
</script>