package nl.wur.alterra.quickanddirtyows.csw;

import java.net.HttpURLConnection;
import java.util.ArrayList;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;

import nl.wur.alterra.quickanddirtyows.OWS;
import nl.wur.alterra.quickanddirtyows.csw.digitaltransferoption.DigitalTransferOption;
import nl.wur.alterra.quickanddirtyows.csw.digitaltransferoption.DigitalTransferOptions;
import nl.wur.alterra.quickanddirtyows.csw.keyword.Keyword;
import nl.wur.alterra.quickanddirtyows.csw.keyword.Keywords;
import nl.wur.alterra.quickanddirtyows.urlparser.OnlineResourceParser;
import nl.wur.alterra.quickanddirtyows.urlparser.Parameter;
import nl.wur.alterra.quickanddirtyows.wms.Layer;
import nl.wur.alterra.quickanddirtyows.wms.WMS;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class CSW extends OWS {
	
	public CSW(String aOnlineResource, String aUsername, String aPassword, Boolean aParseGetCapabilities) throws Exception {
		super(aOnlineResource, aUsername, aPassword, aParseGetCapabilities);
	}
	
	@Override
	protected String createGetCapabilitiesRequest() {
		String result = super.createGetCapabilitiesRequest();
		
		result += "&service=CSW";
		
		return result;
	}
	
	public ArrayList<CSWRecord> getRecords(int aMaxRecords, String aSearchString) throws Exception {
		ArrayList<CSWRecord> result = new ArrayList<CSWRecord>();
		
		HttpURLConnection connection = createConnection("request=GetRecords" +
				"&service=CSW" +
				"&version=2.0.2" +
				"&namespace=xmlns(csw=http://www.opengis.net/cat/csw)" +
				"&resultType=results" +
				"&outputSchema=http://www.opengis.net/cat/csw/2.0.2" +
				"&outputFormat=application/xml" +
				"&maxRecords=" + aMaxRecords +
				"&typeNames=csw:Record" +
				"&elementSetName=full" +
				"&constraintLanguage=CQL_TEXT" +
				"&constraint_language_version=1.1.0" +
				"&constraint=AnyText+LIKE+%27%25" + aSearchString + "%25%27");
		
		Document getrecordsdocument = getDocument(connection);
		
		XPath xpath = createXPath();
		
		XPathExpression expr = xpath.compile("//csw:SearchResults/csw:Record");

		NodeList nodelist = (NodeList) expr.evaluate(getrecordsdocument, XPathConstants.NODESET);
		
		for (int i = 0; i < nodelist.getLength(); i ++) {
			Node node = nodelist.item(i);

			XPathExpression identifierexpr = xpath.compile("dc:identifier/text()");

			String identifier = (String) identifierexpr.evaluate(node, XPathConstants.STRING);
			
			CSWRecord cswrecord = getRecordByID(identifier);
			
			result.add(cswrecord);
		}
		
		return result;
	}
	
	public CSWRecord getRecordByID(String aMetadataRecordID) throws Exception {
		HttpURLConnection connection = createGetRecordByIdConnection(aMetadataRecordID);
		
		Document getrecordbyiddocument = getDocument(connection);
		
		CSWRecord cswrecord = new CSWRecord();
		
		cswrecord.setFileIdentifier(aMetadataRecordID);
		
		cswrecord.setTitle(getTitle(getrecordbyiddocument));
		
		cswrecord.setAbstractText(getAbstractText(getrecordbyiddocument));
		
		cswrecord.setKeywords(createKeywords(getrecordbyiddocument));
		
		cswrecord.setDigitalTransferOptions(createDigitalTransferOptions(getrecordbyiddocument, aMetadataRecordID));
		
		cswrecord.setAttribution(getAttribution(getrecordbyiddocument));
		
		return(cswrecord);
	}
	
	public String getRecordByIDString(String aMetadataRecordID) throws Exception {
		HttpURLConnection connection = createGetRecordByIdConnection(aMetadataRecordID);
		
		String result = getResponse(connection);

		return result;
	}

	private HttpURLConnection createGetRecordByIdConnection(
			String aMetadataRecordID) throws Exception {
		HttpURLConnection connection = createConnection("request=GetRecordById"
				+ "&service=CSW"
				+ "&outputSchema=http://www.isotc211.org/2005/gmd"
				+ "&elementSetName=full"
				+ "&id=" + aMetadataRecordID);
		return connection;
	}
	
	protected Keywords createKeywords(Document aGetRecordByIDDocument) throws Exception {
		Keywords result = new Keywords();
		
		XPath xpath = createXPath();
		
		XPathExpression expr = xpath.compile("//gmd:MD_Metadata/gmd:identificationInfo/gmd:MD_DataIdentification/gmd:descriptiveKeywords/gmd:MD_Keywords");

		NodeList nodelist = (NodeList) expr.evaluate(aGetRecordByIDDocument, XPathConstants.NODESET);
		
		for (int i = 0; i < nodelist.getLength(); i ++) {
			Node keywordnode = nodelist.item(i);

			XPathExpression keywordexpr = xpath.compile("gmd:keyword/text()");

			String keyword = (String) keywordexpr.evaluate(keywordnode, XPathConstants.STRING);
			
			result.add(new Keyword(keyword));
		}
		
		return result;
	}
	
	protected DigitalTransferOptions createDigitalTransferOptions(Document aGetRecordByIDDocument, String aMetadataRecordID) throws Exception {
		XPath xpath = createXPath();
		
		DigitalTransferOptions dtoGeoNetwork = new DigitalTransferOptions();
		
		DigitalTransferOptions dtoInspireGetCapabilities = new DigitalTransferOptions();
		
		DigitalTransferOptions dtoInspireGetMap = new DigitalTransferOptions();
		
		XPathExpression expr = xpath.compile("//gmd:MD_Metadata/gmd:distributionInfo/gmd:MD_Distribution/gmd:transferOptions/gmd:MD_DigitalTransferOptions/gmd:onLine");

		NodeList nodelist = (NodeList) expr.evaluate(aGetRecordByIDDocument, XPathConstants.NODESET);
		
		OnlineResourceParser onlineresourceparser = null;
		
		for (int i = 0; i < nodelist.getLength(); i ++) {
			Node digitaltransferoptionnode = nodelist.item(i);

			XPathExpression urlexpr = xpath.compile("gmd:CI_OnlineResource/gmd:linkage/gmd:URL/text()");

			String url = (String) urlexpr.evaluate(digitaltransferoptionnode, XPathConstants.STRING);

			XPathExpression nameexpr = xpath.compile("gmd:CI_OnlineResource/gmd:name/gco:CharacterString/text()");

			String name = (String) nameexpr.evaluate(digitaltransferoptionnode, XPathConstants.STRING);

			XPathExpression protocolexpr = xpath.compile("gmd:CI_OnlineResource/gmd:protocol/gco:CharacterString/text()");

			String protocol = (String) protocolexpr.evaluate(digitaltransferoptionnode, XPathConstants.STRING);

			XPathExpression functionexpr = xpath.compile("gmd:CI_OnlineResource/gmd:function/gmd:CI_OnLineFunctionCode/@codeListValue");

			String function = (String) functionexpr.evaluate(digitaltransferoptionnode, XPathConstants.STRING);
			
			if (protocol.indexOf("wms") != -1 || protocol.indexOf("WMS") != -1) {
				DigitalTransferOption digitaltransferoption = new DigitalTransferOption(url, name, null, protocol);
				
				dtoGeoNetwork.add(digitaltransferoption);
			} else if (function.equalsIgnoreCase("view")) {
				onlineresourceparser = new OnlineResourceParser(url);

				Parameter requestparameter = onlineresourceparser.findParameterByName("request");
				
				Parameter serviceparameter = onlineresourceparser.findParameterByName("service");
				
				if (requestparameter != null && serviceparameter != null) {
					if (requestparameter.getValue().equalsIgnoreCase("GetCapabilities") && serviceparameter.getValue().equalsIgnoreCase("wms")) {
						WMS wms = new WMS(onlineresourceparser.getUrl(), null, null, true);
						
						for (int j = 0; j < wms.getLayers().size(); j ++) {
							Layer layer = wms.getLayers().get(j);
							
							processLayer(aMetadataRecordID, dtoInspireGetCapabilities, wms, layer);
							
							for (int k = 0; k < layer.getLayerList().size(); k ++) {
								Layer sublayer = layer.getLayerList().get(k);
								
								processLayer(aMetadataRecordID, dtoInspireGetCapabilities, wms, sublayer);
							}
						}
					} else if (requestparameter.getValue().equalsIgnoreCase("GetMap") && serviceparameter.getValue().equalsIgnoreCase("wms")) {
						Parameter layerparameter = onlineresourceparser.findParameterByName("layers");
						
						if (layerparameter != null) {
							dtoInspireGetMap.add(new DigitalTransferOption(onlineresourceparser.getUrl(), layerparameter.getValue(), null, "OGC:WMS-1.3.0-http-get-map"));
						}
					}
				}
			}
		}
		
		DigitalTransferOptions result = new DigitalTransferOptions();
		
		if (dtoGeoNetwork.size() > 0) {
			result = dtoGeoNetwork;
		} else if (dtoInspireGetMap.size() > 0) {
			result = dtoInspireGetMap;
		} else if (dtoInspireGetCapabilities.size() > 0) {
			result = dtoInspireGetCapabilities;
		}
		
		return result;
	}

	private void processLayer(String aMetadataRecordID,
			DigitalTransferOptions aDTO, WMS aWMS, Layer aLayer) {
		String fileidentifier = getFileIdentifier(aLayer.getMetadataOnlineResource());
		
		if (fileidentifier != null && fileidentifier.equals(aMetadataRecordID)) {
			aDTO.add(new DigitalTransferOption(aWMS.getGetMapOnlineResource(), aLayer.getLayerName(), aLayer.getLayerTitle(), "OGC:WMS-1.3.0-http-get-map"));
		}
	}
	
	private String getFileIdentifier(String aOnlineResource) {
		String result = null;
		
		if (aOnlineResource != null) {
			String[] urlquerystring = aOnlineResource.split("\\?");
			
			if (urlquerystring.length > 1) {
				String querystring = urlquerystring[1];
				
				String[] parameters = querystring.split("&");

				for (int i = 0; i < parameters.length; i ++) {
					String parameter = parameters[i];
					
					String[] namevalue = parameter.split("=");
					
					String name = namevalue[0];
					
					if (name.equalsIgnoreCase("id")) {
						result = namevalue[1];
					}
				}
			}
		}
		
		return result;
	}
	
	protected String getTitle(Document aGetRecordByIDDocument) throws XPathExpressionException {
		return getText(aGetRecordByIDDocument, "//gmd:MD_Metadata/gmd:identificationInfo/gmd:MD_DataIdentification/gmd:citation/gmd:CI_Citation/gmd:title/gco:CharacterString");
	}
	
	protected String getAbstractText(Document aGetRecordByIDDocument) throws XPathExpressionException {
		return getText(aGetRecordByIDDocument, "//gmd:MD_Metadata/gmd:identificationInfo/gmd:MD_DataIdentification/gmd:abstract/gco:CharacterString");
	}
	
	protected String getResponsibleParty(Document aGetRecordByIDDocument) throws XPathExpressionException {
		String organisationname = "";
		
		XPath xpath = createXPath();
		
		XPathExpression expr = xpath.compile("//gmd:MD_Metadata/gmd:identificationInfo/gmd:MD_DataIdentification/gmd:pointOfContact");

		NodeList nodelist = (NodeList) expr.evaluate(aGetRecordByIDDocument, XPathConstants.NODESET);
			
		for (int i = 0; i < nodelist.getLength(); i ++) {
			Node node = nodelist.item(i);
			
			XPathExpression roleexpr = xpath.compile("gmd:CI_ResponsibleParty/gmd:role/gmd:CI_RoleCode/@codeListValue");
			
			String role = (String) roleexpr.evaluate(node, XPathConstants.STRING);
			
			if (role.equalsIgnoreCase("owner")) {
				XPathExpression organisationnameexpr = xpath.compile("gmd:CI_ResponsibleParty/gmd:organisationName/gco:CharacterString/text()");
				
				organisationname = (String) organisationnameexpr.evaluate(node, XPathConstants.STRING);
			}
		}
		
		return organisationname;
	}
	
	protected String getAttribution(Document aGetRecordByIDDocument) throws Exception {
		String result = null;
		
		if (isCopyright(aGetRecordByIDDocument)) {
			result = "&copy; " + getResponsibleParty(aGetRecordByIDDocument);
		}
		
		return result;
	}

	private String getText(Document aGetRecordByIDDocument, String aXPathString) throws XPathExpressionException {
		XPath xpath = createXPath();
		
		XPathExpression expr = xpath.compile(aXPathString);
		
		String result = (String) expr.evaluate(aGetRecordByIDDocument, XPathConstants.STRING);
		
		return result;
	}
	
	protected Boolean isCopyright(Document aGetRecordByIDDocument) throws Exception {
		Boolean result = false;
		
		XPath xpath = createXPath();

		XPathExpression expr = xpath.compile("//gmd:MD_RestrictionCode");

		NodeList nodelist = (NodeList) expr.evaluate(aGetRecordByIDDocument, XPathConstants.NODESET);
		
		for (int i = 0; i < nodelist.getLength(); i ++) {
			Node node = nodelist.item(i);
			
		    NamedNodeMap attributes = node.getAttributes();
		    
		    for (int j = 0 ; j < attributes.getLength(); j ++) {
		        Attr attribute = (Attr) attributes.item(j);
		        
		        if (attribute.getName().equalsIgnoreCase("codeListValue")) {
		        	result = attribute.getValue().equalsIgnoreCase("copyright");
		        }
		    }
		    
		    if (result) {
		    	break;
		    }
		}
		
		return result;
	}
}
