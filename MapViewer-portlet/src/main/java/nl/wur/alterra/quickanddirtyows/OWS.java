package nl.wur.alterra.quickanddirtyows;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import nl.wur.alterra.restclient.RestClient;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 * @author vanme002
 * @version 1.0
 * @created 25-Nov-2010 12:34:13
 */
public class OWS extends RestClient {
	
	public static String WMS_1_3_0 = "1.3.0"; 

	private String getCapabilitiesOnlineResource;
	
	private Document getCapabilitiesDocument;

	public OWS(String aOnlineResource, String aUsername, String aPassword, Boolean aParseGetCapabilities) throws Exception {
		super(new URL(aOnlineResource), aUsername, aPassword);
		
		setGetCapabilitiesOnlineResource(aOnlineResource);
		
		if (aParseGetCapabilities) {
			getCapabilities();
		}
	}

	protected void getCapabilities() throws Exception {
		HttpURLConnection connection = createConnection(createGetCapabilitiesRequest());

		setGetCapabilitiesDocument(getDocument(connection));
	}
	
	protected String createGetCapabilitiesRequest() {
		String result = "request=GetCapabilities";
		
		return result;
	}

	protected String getVersion() {
		return getCapabilitiesDocument.getDocumentElement().getAttribute("version");
	}

	protected Document getDocument(HttpURLConnection aURLConnection) throws Exception {
		String response = getResponse(aURLConnection);

		return getDocument(response);
	}

	protected Document getDocument(String aXMLString)
			throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		factory.setNamespaceAware(true);

		DocumentBuilder builder = factory.newDocumentBuilder();

		factory.setNamespaceAware(true);

		InputSource inputsource = new InputSource();
		
		inputsource.setCharacterStream(new StringReader(aXMLString));

		Document document = builder.parse(inputsource);

		document.getDocumentElement().normalize();

		OWSExceptionReport owsexceptionreport = createOWSExceptionReport(document);

		if (owsexceptionreport != null) {
			throw new OWSException(owsexceptionreport);
		}

		return document;
	}
	
	protected File getFile(HttpURLConnection aURLConnection, String aFileName) throws Exception {
		File response = writeResponse(aURLConnection, aFileName);
		
		return getFile(response);
	}
	
	protected File getFile(File aFile) throws Exception {
		InputStream inputstream = new FileInputStream(aFile);

		XMLInputFactory xmlinputfactory = XMLInputFactory.newInstance();
		
		XMLStreamReader xmlstreamreader = xmlinputfactory.createXMLStreamReader(inputstream);
        
		String exceptioncode = null;
		
		String exceptiontext = null;
		
		String locator = null;

		try {
			
			int event = xmlstreamreader.getEventType();
			
			while (true) {
				switch (event) {
				case XMLStreamConstants.START_ELEMENT:
					if (xmlstreamreader.getLocalName().equals("Exception")) {
						exceptioncode = xmlstreamreader.getAttributeValue("http://www.opengis.net/ows", "exceptionCode");
						
						locator = xmlstreamreader.getAttributeValue("http://www.opengis.net/ows", "locator");
					} else if (xmlstreamreader.getLocalName().equals("ExceptionText")) {
						exceptiontext = xmlstreamreader.getElementText();
					} 
				}

				if (!xmlstreamreader.hasNext()) {
					break;
				}

				event = xmlstreamreader.next();
			}
		} finally {
			xmlstreamreader.close();
		}
		
		if (exceptiontext != null) {
			OWSExceptionReport report = new OWSExceptionReport(exceptioncode, exceptiontext, locator);
			
			throw(new OWSException(report));
		}
		
		return aFile;
	}

	protected OWSExceptionReport createOWSExceptionReport(Document aDocument) throws Exception {
		OWSExceptionReport result = null;

		String nodename = aDocument.getDocumentElement().getNodeName();

		if (nodename.equalsIgnoreCase("ServiceExceptionReport")) {
			result = createOWSExceptionReportFromServiceExceptionReport(aDocument);
		} else if (nodename.equalsIgnoreCase("ows:ExceptionReport")) {
			result = createOWSExceptionReportFromExceptionReport(aDocument);
		}

		return result;
	}

	protected OWSExceptionReport createOWSExceptionReport(File aFile) throws Exception {
		OWSExceptionReport result = null;

		FileReader input = new FileReader(aFile);
		
		BufferedReader reader = new BufferedReader(input);
		
		try {
			String line = reader.readLine();
			
			while (line != null){
				line += reader.readLine();
			}
			
			Document document = getDocument(line);
			
			result = createOWSExceptionReport(document);
		} finally {
			reader.close();
		}
		
		return result;
	}

	private OWSExceptionReport createOWSExceptionReportFromServiceExceptionReport(
			Document aDocument) throws XPathExpressionException {
		XPath xpath = createXPath();

		String exceptioncode = "";

		String locator = "";

		String exceptiontext = extractExceptionTextFromServiceExceptionReport(
				aDocument, xpath);

		return new OWSExceptionReport(exceptioncode, exceptiontext, locator);
	}

	protected XPath createXPath() {
		XPathFactory factory = XPathFactory.newInstance();

		XPath xpath = factory.newXPath();

		xpath.setNamespaceContext(new OWSNameSpaceContext());
		
		return xpath;
	}

	private OWSExceptionReport createOWSExceptionReportFromExceptionReport(
			Document aDocument) throws XPathExpressionException {
		XPath xpath = createXPath();

		String exceptioncode = "";

		String locator = "";

		String exceptiontext = extractExceptionTextFromExceptionReport(aDocument, xpath);

		return new OWSExceptionReport(exceptioncode, exceptiontext, locator);
	}

	private String extractExceptionTextFromExceptionReport(Document aDocument,
			XPath xpath) throws XPathExpressionException {
		XPathExpression expr = xpath
				.compile("//ows:Exception/ows:ExceptionText/text()");

		Object result = expr.evaluate(aDocument, XPathConstants.NODESET);

		NodeList nodes = (NodeList) result;

		String exceptiontext = "";

		for (int i = 0; i < nodes.getLength();) {
			exceptiontext = nodes.item(i).getNodeValue();

			break;
		}

		return exceptiontext;
	}

	private String extractExceptionTextFromServiceExceptionReport(Document aDocument,
			XPath xpath) throws XPathExpressionException {
		XPathExpression expr = xpath
				.compile("//ogc:ServiceException/text()");

		Object result = expr.evaluate(aDocument, XPathConstants.NODESET);

		NodeList nodes = (NodeList) result;

		String exceptiontext = "";

		for (int i = 0; i < nodes.getLength();) {
			exceptiontext = nodes.item(i).getNodeValue();

			break;
		}

		return exceptiontext;
	}

	public Document getGetCapabilitiesDocument() {
		return getCapabilitiesDocument;
	}

	public void setGetCapabilitiesDocument(Document getCapabilitiesDocument) throws Exception {
		this.getCapabilitiesDocument = getCapabilitiesDocument;
		
		if (this.getCapabilitiesDocument != null) {
			parseGetCapabilitiesDocument();
		}
	}
	
	protected void parseGetCapabilitiesDocument() throws Exception {
		
	}

	public String getGetCapabilitiesOnlineResource() {
		return getCapabilitiesOnlineResource;
	}

	public void setGetCapabilitiesOnlineResource(String aGetCapabilitiesOnlineResource) {
		this.getCapabilitiesOnlineResource = aGetCapabilitiesOnlineResource;
	}
}