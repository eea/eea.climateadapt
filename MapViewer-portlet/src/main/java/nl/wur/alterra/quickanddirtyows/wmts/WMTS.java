package nl.wur.alterra.quickanddirtyows.wmts;

import java.util.ArrayList;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;

import nl.wur.alterra.quickanddirtyows.OWS;

import org.w3c.dom.NodeList;

public class WMTS extends OWS {

	public WMTS(String aOnlineResource, Boolean aParseGetCapabilities) throws Exception {
		super(aOnlineResource, null, null, aParseGetCapabilities);
	}
	
	@Override
	protected String createGetCapabilitiesRequest() {
		String result = super.createGetCapabilitiesRequest();
		
		result += "&service=wmts";
		
		return result;
	}

	public ArrayList<String> getLayerNames() throws Exception {
		ArrayList<String> result = new ArrayList<String>();
		
		if (getGetCapabilitiesDocument() != null) {
			XPath xpath = createXPath();

			XPathExpression expr = xpath.compile("//wmts:Layer/ows:Identifier/text()");

			NodeList nodelist = (NodeList) expr.evaluate(getGetCapabilitiesDocument(), XPathConstants.NODESET);
			
			for (int i = 0; i < nodelist.getLength(); i++) {
			    result.add(nodelist.item(i).getNodeValue()); 
			}
		}
		
		return result;
	}
}
