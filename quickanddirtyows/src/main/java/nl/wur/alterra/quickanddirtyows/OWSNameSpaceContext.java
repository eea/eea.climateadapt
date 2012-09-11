package nl.wur.alterra.quickanddirtyows;

import java.util.Iterator;

import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;

/**
 * @author vanme002
 * @version 1.0
 * @created 25-Nov-2010 12:59:34
 */
public class OWSNameSpaceContext implements NamespaceContext {

	public String getNamespaceURI(String prefix) {
		String result = XMLConstants.NULL_NS_URI;
		
		if (prefix == null) {
			throw new NullPointerException("Null prefix");
		} else if ("xsi".equals(prefix)) {
			result = "http://www.w3.org/2001/XMLSchema-instance";
		} else if ("csw".equals(prefix)) {
			result = "http://www.opengis.net/cat/csw/2.0.2";
		} else if ("dc".equals(prefix)) {
			result = "http://purl.org/dc/elements/1.1/";
		} else if ("dct".equals(prefix)) {
			result = "http://purl.org/dc/terms/";
		} else if ("wcs".equals(prefix)) {
			result = "http://www.opengis.net/wcs";
		} else if ("wfs".equals(prefix)) {
			result = "http://www.opengis.net/wfs";
		} else if ("wms".equals(prefix)) {
			result = "http://www.opengis.net/wms";
		} else if ("wmts".equals(prefix)) {
			result = "http://www.opengis.net/wmts/1.0";
		} else if ("ows".equals(prefix)) {
			result = "http://www.opengis.net/ows";
		} else if ("gco".equals(prefix)) {
			result = "http://www.isotc211.org/2005/gco";
		} else if ("gmd".equals(prefix)) {
			result = "http://www.isotc211.org/2005/gmd";
		} else if ("gml".equals(prefix)) {
			result = "http://www.opengis.net/gml";
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