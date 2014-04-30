package nl.wur.alterra.quickanddirtyows.wcs;

import java.io.File;
import java.net.HttpURLConnection;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;

import nl.wur.alterra.quickanddirtyows.OWS;

import org.w3c.dom.Document;

public class WCS extends OWS {
	
	public WCS(String aOnlineResource, String aUsername, String aPassword, Boolean aParseGetCapabilities) throws Exception {
		super(aOnlineResource, aUsername, aPassword, aParseGetCapabilities);
	}
			
	@Override
	protected String createGetCapabilitiesRequest() {
		String result = super.createGetCapabilitiesRequest();
				
		result += "&service=wcs";
			
		return result;
	}

	public SourceCoverage getCoverage(String aIdentifier, String aOutputFormat, int aMaxResolution, String aFileName) throws Exception {
		String describecoveragerequest = "<wcs:DescribeCoverage service=\"WCS\" version=\"1.0.0\" xmlns:ogc=\"http://www.opengis.net/ogc\" xmlns:wcs=\"http://www.opengis.net/wcs\" xmlns:ows=\"http://www.opengis.net/ows/1.1\">"
				+ "<wcs:Coverage>" + aIdentifier + "</wcs:Coverage>"
				+ "</wcs:DescribeCoverage>";

		HttpURLConnection describecoverageconnection = createConnection();

		post(describecoverageconnection, describecoveragerequest, "text/xml");

		Document describecoveragedocument = getDocument(describecoverageconnection);

		Extent extent = createExtent(describecoveragedocument);
		
		Extent lonlatextent = createLonLatExtent(describecoveragedocument);
		
		Double xresolution = getXResolution(describecoveragedocument);

		Double yresolution = getYResolution(describecoveragedocument);
		
		Double xorigin = getXOrigin(describecoveragedocument);

		Double yorigin = getYOrigin(describecoveragedocument);
		
		String outputformat = aOutputFormat; // getOutputFormat(describecoveragedocument);

		String getcoveragerequest = "<wcs:GetCoverage service=\"WCS\" version=\"1.0.0\" xmlns:ogc=\"http://www.opengis.net/ogc\" xmlns:wcs=\"http://www.opengis.net/wcs\" xmlns:ows=\"http://www.opengis.net/ows/1.1\" xmlns:gml=\"http://www.opengis.net/gml\">"
				+ "<wcs:sourceCoverage>" + aIdentifier + "</wcs:sourceCoverage>"
				+ "<wcs:domainSubset>"
				+ "<wcs:spatialSubset>"
				+ "<gml:Envelope srsName=\"" + extent.getSrsCode() + "\">"
				+ "<gml:pos>" + extent.getxMin() + " " + extent.getyMin() + "</gml:pos>" 
				+ "<gml:pos>" + extent.getxMax() + " " + extent.getyMax() + "</gml:pos>"
				+ "</gml:Envelope>"
				+ "<gml:Grid dimension=\"2\">"
				+ "<gml:limits>"
				+ "<gml:GridEnvelope>"
				+ "<gml:low>" + getLow(describecoveragedocument)[0] + " " + getLow(describecoveragedocument)[1] + "</gml:low>"
				+ "<gml:high>" + getHigh(describecoveragedocument, aMaxResolution)[0] + " " + getHigh(describecoveragedocument, aMaxResolution)[1] + "</gml:high>"
				+ "</gml:GridEnvelope>"
				+ "</gml:limits>"
				+ "<gml:axisName>Raster_Pixel_Columns(X-axis)</gml:axisName>" // E
		        + "<gml:axisName>Raster_Pixel_Rows(Y-axis)</gml:axisName>" // N 
				+ "</gml:Grid>"
				+ "</wcs:spatialSubset>"
				+ "</wcs:domainSubset>"
				+ "<wcs:output>"
				+ "<wcs:crs>" + extent.getSrsCode() + "</wcs:crs>"
				+ "<wcs:format>" + outputformat + "</wcs:format>"
				+ "</wcs:output>"
				+ "</wcs:GetCoverage>";

		HttpURLConnection getcoverageconnection = createConnection();

		post(getcoverageconnection, getcoveragerequest, "text/xml");

		File file = writeResponse(getcoverageconnection, aFileName);
		
		SourceCoverage sourcecoverage = null; 
		
		if (file.exists()) {
			sourcecoverage = new SourceCoverage(aIdentifier, aOutputFormat, extent, lonlatextent, xresolution, yresolution, xorigin, yorigin, file);
		} 
		
		return sourcecoverage;
	}

	protected Extent createExtent(Document aDescribeCoverageDocument) throws Exception {
		XPath xpath = createXPath();

		XPathExpression srscodeexpression = xpath.compile("//wcs:CoverageOffering/wcs:domainSet/wcs:spatialDomain/gml:Envelope/@srsName");

		String srscode = (String) srscodeexpression.evaluate(aDescribeCoverageDocument, XPathConstants.STRING);

		XPathExpression lowercornerexpression = xpath.compile("//wcs:CoverageOffering/wcs:domainSet/wcs:spatialDomain/gml:Envelope/gml:pos[1]/text()");

		String lowercorner = (String) lowercornerexpression.evaluate(aDescribeCoverageDocument, XPathConstants.STRING);

		XPathExpression uppercornerexpression = xpath.compile("//wcs:CoverageOffering/wcs:domainSet/wcs:spatialDomain/gml:Envelope/gml:pos[2]/text()");

		String uppercorner = (String) uppercornerexpression.evaluate(aDescribeCoverageDocument, XPathConstants.STRING);

		Double xmin = Double.parseDouble(lowercorner.split(" ")[0]);

		Double ymin = Double.parseDouble(lowercorner.split(" ")[1]);

		Double xmax = Double.parseDouble(uppercorner.split(" ")[0]);

		Double ymax = Double.parseDouble(uppercorner.split(" ")[1]);

		return new Extent(xmin, ymin, xmax, ymax, srscode);
	}

	protected Extent createLonLatExtent(Document aDescribeCoverageDocument) throws Exception {
		XPath xpath = createXPath();

		String srscode = "EPSG:4326";

		XPathExpression lowercornerexpression = xpath.compile("//wcs:CoverageOffering/wcs:lonLatEnvelope/gml:pos[1]/text()");

		String lowercorner = (String) lowercornerexpression.evaluate(aDescribeCoverageDocument, XPathConstants.STRING);

		XPathExpression uppercornerexpression = xpath.compile("//wcs:CoverageOffering/wcs:lonLatEnvelope/gml:pos[2]/text()");

		String uppercorner = (String) uppercornerexpression.evaluate(aDescribeCoverageDocument, XPathConstants.STRING);

		Double xmin = Double.parseDouble(lowercorner.split(" ")[0]);

		Double ymin = Double.parseDouble(lowercorner.split(" ")[1]);

		Double xmax = Double.parseDouble(uppercorner.split(" ")[0]);

		Double ymax = Double.parseDouble(uppercorner.split(" ")[1]);

		return new Extent(xmin, ymin, xmax, ymax, srscode);
	}

	protected int[] getLow(Document aDescribeCoverageDocument) throws XPathExpressionException {
		XPath xpath = createXPath();

		XPathExpression lowexpression = xpath.compile("//wcs:CoverageOffering/wcs:domainSet/wcs:spatialDomain/gml:RectifiedGrid/gml:limits/gml:GridEnvelope/gml:low");

		String low = (String) lowexpression.evaluate(aDescribeCoverageDocument, XPathConstants.STRING);
		
		String[] lows = low.split(" ");
		
		int[] result = {Integer.parseInt(lows[0]), Integer.parseInt(lows[1])};
		
		return result;
	}
	
	protected int[] getHigh(Document aDescribeCoverageDocument, int aMaxResolution) throws Exception {
		XPath xpath = createXPath();

		XPathExpression highexpression = xpath.compile("//wcs:CoverageOffering/wcs:domainSet/wcs:spatialDomain/gml:RectifiedGrid/gml:limits/gml:GridEnvelope/gml:high");

		String high = (String) highexpression.evaluate(aDescribeCoverageDocument, XPathConstants.STRING);
		
		String[] highs = high.split(" ");
		
		int x = Integer.parseInt(highs[0]);
		
		int y = Integer.parseInt(highs[1]);
		
		if (aMaxResolution != -1 && y > aMaxResolution) {
			double b = y / aMaxResolution;
			
			y = 1000;
			
			x = (int) Math.round(x / b);
		}
		
		int[] result = {x, y};
		
		return result;
	}
	
	protected Double getXResolution(Document aDescribeCoverageDocument) throws Exception {
		XPath xpath = createXPath();

		XPathExpression offsetvectorexpression = xpath.compile("//wcs:CoverageOffering/wcs:domainSet/wcs:spatialDomain/gml:RectifiedGrid/gml:offsetVector[1]/text()");

		String offsetvector = (String) offsetvectorexpression.evaluate(aDescribeCoverageDocument, XPathConstants.STRING);
		
		String[] offsetvectors = offsetvector.split(" ");
		
		return Double.parseDouble(offsetvectors[0]);
	}
	
	protected Double getYResolution(Document aDescribeCoverageDocument) throws Exception {
		XPath xpath = createXPath();

		XPathExpression offsetvectorexpression = xpath.compile("//wcs:CoverageOffering/wcs:domainSet/wcs:spatialDomain/gml:RectifiedGrid/gml:offsetVector[2]/text()");

		String offsetvector = (String) offsetvectorexpression.evaluate(aDescribeCoverageDocument, XPathConstants.STRING);
		
		String[] offsetvectors = offsetvector.split(" ");
		
		return Double.parseDouble(offsetvectors[1]);
	}
	
	protected Double getXOrigin(Document aDescribeCoverageDocument) throws Exception {
		String[] origins = getOrigin(aDescribeCoverageDocument);
		
		return Double.parseDouble(origins[0]);
	}
	
	protected Double getYOrigin(Document aDescribeCoverageDocument) throws Exception {
		String[] origins = getOrigin(aDescribeCoverageDocument);
		
		return Double.parseDouble(origins[1]);
	}

	private String[] getOrigin(Document aDescribeCoverageDocument) throws XPathExpressionException {
		XPath xpath = createXPath();

		XPathExpression originexpression = xpath.compile("//wcs:CoverageOffering/wcs:domainSet/wcs:spatialDomain/gml:RectifiedGrid/gml:origin/gml:pos");

		String origin = (String) originexpression.evaluate(aDescribeCoverageDocument, XPathConstants.STRING);
		
		String[] origins = origin.split(" ");
		
		return origins;
	}
	
	protected String getOutputFormat(Document aDescribeCoverageDocument) throws Exception {
		XPath xpath = createXPath();

		XPathExpression nativeoutputformatexpression = xpath.compile("//wcs:CoverageOffering/wcs:supportedFormats/@nativeFormat");

		String nativeoutputformat = (String) nativeoutputformatexpression.evaluate(aDescribeCoverageDocument, XPathConstants.STRING);
		
		return nativeoutputformat;
	}

//	protected ByteArrayOutputStream getOutputStream(HttpURLConnection aConnection) throws Exception {
//		ByteArrayOutputStream outputstream = null;
//		
//		String contenttype = aConnection.getContentType();
//		
//		if (contenttype.indexOf("text/xml") != -1) {
//			getDocument(aConnection);
//		} else {
//			BufferedInputStream inputstream = new BufferedInputStream(aConnection.getInputStream());
//			
//			outputstream = new ByteArrayOutputStream();
//			
//			int length;
//			
//			while ((length = inputstream.read()) != -1) {
//				outputstream.write(length);
//			}
//		}
//		
//		return outputstream;
//	}

//	public SourceCoverage getSourceCoverage() {
//		return sourceCoverage;
//	}
//
//	public void setSourceCoverage(SourceCoverage sourceCoverage) {
//		this.sourceCoverage = sourceCoverage;
//	}
}
