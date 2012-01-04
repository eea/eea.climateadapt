package nl.wur.alterra.cgi.ace.mapviewer.csw;

import java.net.HttpURLConnection;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;

import nl.wur.alterra.acg.integrator.helpers.ows.OWS;
import nl.wur.alterra.cgi.ace.mapviewer.csw.digitaltransferoption.DigitalTransferOption;
import nl.wur.alterra.cgi.ace.mapviewer.csw.digitaltransferoption.DigitalTransferOptions;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class CSW extends OWS {

	public CSW(String aOnlineResource, String aUsername, String aPassword) throws Exception {
		super(aOnlineResource, aUsername, aPassword);
		
		getCapabilities();
	}

	protected void getCapabilities() throws Exception {
		HttpURLConnection connection = createConnection("request=GetCapabilities&service=CSW");

		setGetCapabilitiesDocument(getDocument(connection));
	}
	
	public CSWRecord getRecordByID(String aMetadataRecordID) throws Exception {
		HttpURLConnection connection = createConnection("request=GetRecordById"
				+ "&service=CSW"
				+ "&version=" + getVersion()
				+ "&outputSchema=http://www.isotc211.org/2005/gmd&"
				+ "&elementSetName=full"
				+ "&id=" + aMetadataRecordID);
		
		Document getrecordbyiddocument = getDocument(connection);
		
		CSWRecord cswrecord = new CSWRecord();
		
		cswrecord.setTitle(getTitle(getrecordbyiddocument));
		
		cswrecord.setDigitalTransferOptions(createDigitalTransferOptions(getrecordbyiddocument));
		
		return(cswrecord);
	}
	
	protected DigitalTransferOptions createDigitalTransferOptions(Document aGetRecordByIDDocument) throws XPathExpressionException {
		XPath xpath = createXPath();
		
		DigitalTransferOptions result = new DigitalTransferOptions();
		
		XPathExpression expr = xpath.compile("//gmd:MD_Metadata/gmd:distributionInfo/gmd:MD_Distribution/gmd:transferOptions/gmd:MD_DigitalTransferOptions/gmd:onLine");

		NodeList nodelist = (NodeList) expr.evaluate(aGetRecordByIDDocument, XPathConstants.NODESET);
			
		for (int i = 0; i < nodelist.getLength(); i ++) {
			result.add(createDigitalTransferOption(nodelist.item(i)));
		}
		
		return result;
	}
	
	protected String getTitle(Document aGetRecordByIDDocument) throws XPathExpressionException {
		XPath xpath = createXPath();
		
		XPathExpression titlexpr = xpath.compile("//gmd:MD_Metadata/gmd:identificationInfo/gmd:MD_DataIdentification/gmd:citation/gmd:CI_Citation/gmd:title/gco:CharacterString");
		
		String title = (String) titlexpr.evaluate(aGetRecordByIDDocument, XPathConstants.STRING);
		
		return title;
	}
	
	protected DigitalTransferOption createDigitalTransferOption(Node aDigitalTransferOptionNode) throws XPathExpressionException {
		XPath xpath = createXPath();

		XPathExpression urlexpr = xpath.compile("gmd:CI_OnlineResource/gmd:linkage/gmd:URL/text()");

		String url = (String) urlexpr.evaluate(aDigitalTransferOptionNode, XPathConstants.STRING);

		XPathExpression nameexpr = xpath.compile("gmd:CI_OnlineResource/gmd:name/gco:CharacterString/text()");

		String layername = (String) nameexpr.evaluate(aDigitalTransferOptionNode, XPathConstants.STRING);

		XPathExpression protocolexpr = xpath.compile("gmd:CI_OnlineResource/gmd:protocol/gco:CharacterString/text()");

		String protocol = (String) protocolexpr.evaluate(aDigitalTransferOptionNode, XPathConstants.STRING);
		
		DigitalTransferOption result = new DigitalTransferOption(url, layername, protocol);
			
		return result;
	}
}
