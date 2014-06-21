package nl.wur.alterra.quickanddirtyows.wfs;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stax.StAXSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;

import nl.wur.alterra.quickanddirtyows.OWS;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 * @author vanme002
 * @version 1.0
 * @created 25-Nov-2010 12:34:28
 */
public class WFS extends OWS {

    private Document getFeatureDocument;

    private File getFeatureFile;

    private int selected;

    private int inserted;

    private int updated;

    private int deleted;

    public WFS(String aOnlineResource, String aUsername, String aPassword, Boolean aParseGetCapabilities) throws Exception {
        super(aOnlineResource, aUsername, aPassword, aParseGetCapabilities);
    }

    @Override
    protected String createGetCapabilitiesRequest() {
        String result = super.createGetCapabilitiesRequest();

        result += "&service=wfs";

        return result;
    }

    public void getFeatures(String aTypeName, String aFileName)
            throws Exception {
        HttpURLConnection connection = createConnection("request=GetFeature"
                + "&service=wfs" + "&version=" + getVersion() + "&typeName="
                + aTypeName + "&outputFormat=GML2");

        if (aFileName == null) {
            setGetFeatureDocument(getDocument(connection));
        } else {
            setGetFeatureFile(getFile(connection, aFileName));
        }
    }

    public void transaction(String aTransactionRequest) throws Exception {
        HttpURLConnection connection = createConnection();

        post(connection, aTransactionRequest, "text/xml");

        checkTransactionResponse(connection);
    }

    public void transaction(File aTransactionRequest) throws Exception {
        HttpURLConnection connection = createConnection();

        post(connection, aTransactionRequest, "text/xml");

        checkTransactionResponse(connection);
    }

    private void checkTransactionResponse(HttpURLConnection connection) throws Exception {
        TransactionResponse transactionresponse = createTransactionResponse(getDocument(connection));

        this.inserted += transactionresponse.inserted;

        this.updated += transactionresponse.updated;

        this.deleted += transactionresponse.deleted;

        if (transactionresponse.status.equalsIgnoreCase("FAILED")) {
            throw new Exception("WFS transaction failed: " + transactionresponse.message);
        }
    }

    public void transactions(File aTransactionsRequest) throws Exception {
        InputStream inputstream = new FileInputStream(aTransactionsRequest);

        XMLInputFactory xmlinputfactory = XMLInputFactory.newInstance();

        XMLStreamReader xmlstreamreader = xmlinputfactory.createXMLStreamReader(inputstream);

        TransformerFactory transformerfactory = TransformerFactory.newInstance();

        Transformer transformer = transformerfactory.newTransformer();

        this.selected = 0;

        this.inserted = 0;

        try {
            int event = xmlstreamreader.getEventType();

            while (true) {
                switch (event) {
                case XMLStreamConstants.START_ELEMENT:
                    if (xmlstreamreader.getLocalName().equals("Transaction")) {
                        this.selected += 1;

                        File file = new File(aTransactionsRequest.getAbsolutePath().replace(".xml", "_" + this.selected + ".xml"));

                        transformer.transform(new StAXSource(xmlstreamreader), new StreamResult(file));

                        try {
                            transaction(file);
                        } finally {
                            file.delete();
                        }
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
    }

    public Document getGetFeatureDocument() {
        return getFeatureDocument;
    }

    public void setGetFeatureDocument(Document getFeatureDocument) {
        this.getFeatureDocument = getFeatureDocument;
    }

    public File getGetFeatureFile() {
        return getFeatureFile;
    }

    public void setGetFeatureFile(File getFeatureFile) {
        this.getFeatureFile = getFeatureFile;
    }

    public int getFeatureCount() throws Exception {
        int result = -1;

        if (getGetFeatureDocument() != null) {
            XPath xpath = createXPath();

            XPathExpression expr = xpath.compile("count(//gml:featureMember)");

            double result_double = (Double) expr.evaluate(
                    getGetFeatureDocument(), XPathConstants.NUMBER);

            result = (int) result_double;
        }

        return result;
    }

//  public int getInsertResultCount() throws Exception {
//      int result = -1;
//
//      if (getTransactionResponseDocument() != null) {
//          XPath xpath = createXPath();
//
//          XPathExpression expr = xpath
//                  .compile("count(//wfs:InsertResult/ogc:FeatureId)");
//
//          double result_double = (Double) expr.evaluate(
//                  getTransactionResponseDocument(), XPathConstants.NUMBER);
//
//          result = (int) result_double;
//      }
//
//      return result;
//  }

    protected TransactionResponse createTransactionResponse(Document aDocument)
            throws Exception {
        XPath xpath = createXPath();

        // Status
        XPathExpression statusexpression = xpath.compile("//wfs:Status/*");

        Object statusnodeset = statusexpression.evaluate(aDocument, XPathConstants.NODESET);

        NodeList statusnodes = (NodeList) statusnodeset;

        String status = "";

        for (int i = 0; i < statusnodes.getLength();) {
            status = statusnodes.item(i).getLocalName();

            break;
        }

        // Message
        XPathExpression messageexpression = xpath.compile("//wfs:Message");

        String message = (String) messageexpression.evaluate(aDocument, XPathConstants.STRING);

        // Insert result count
        XPathExpression insertresultcountexpression = xpath.compile("count(//wfs:InsertResult/ogc:FeatureId)");

        double insertresultcountdouble = (Double) insertresultcountexpression.evaluate(aDocument, XPathConstants.NUMBER);

        int insertresultcount = (int) insertresultcountdouble;

        return new TransactionResponse(status, message, insertresultcount, 0, 0);
    }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }

    public int getInserted() {
        return inserted;
    }

    public void setInserted(int inserted) {
        this.inserted = inserted;
    }

    public int getUpdated() {
        return updated;
    }

    public void setUpdated(int updated) {
        this.updated = updated;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }
}
