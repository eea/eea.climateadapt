package nl.wur.alterra.cgi.ace.mapviewer.mapstate;

import java.util.Iterator;

import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;

public class WMCNamespaceContext implements NamespaceContext {

	public String getNamespaceURI(String prefix) {
		String result = XMLConstants.NULL_NS_URI;
		
		if (prefix == null) {
			throw new NullPointerException("Null prefix");
		} else if ("xsi".equals(prefix)) {
			result = "http://www.w3.org/2001/XMLSchema-instance";
		} else if ("context".equals(prefix)) {
			result = "http://www.opengis.net/context";
		} else if ("ogc".equals(prefix)) {
			result = "http://www.opengis.net/ogc";
		} else if ("xlink".equals(prefix)) {
			result = "http://www.w3.org/1999/xlink";
		} else if ("xml".equals(prefix)) {
			result = XMLConstants.XML_NS_URI;
		}
		
		return result;
	}

	public String getPrefix(String arg0) {
		throw new UnsupportedOperationException();
	}

	@SuppressWarnings({ "rawtypes" })
	public Iterator getPrefixes(String arg0) {
		throw new UnsupportedOperationException();
	}
}
