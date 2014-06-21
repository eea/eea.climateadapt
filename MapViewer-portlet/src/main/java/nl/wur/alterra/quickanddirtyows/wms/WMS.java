package nl.wur.alterra.quickanddirtyows.wms;
import java.awt.Image;
import java.net.HttpURLConnection;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;

import nl.wur.alterra.quickanddirtyows.OWS;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author vanme002
 * @version 1.0
 * @created 08-Feb-2011 14:48:04
 */
public class WMS extends OWS {

    private String getMapOnlineResource;

    private LayerList layers;

    public WMS(String aOnlineResource, String aUsername, String aPassword, Boolean aParseGetCapabilities) throws Exception {
        super(aOnlineResource, aUsername, aPassword, aParseGetCapabilities);
    }

    @Override
    protected String createGetCapabilitiesRequest() {
        String result = super.createGetCapabilitiesRequest();

        result += "&service=wms";

        return result;
    }

    public Image getLegendGraphic(String aLayerName) throws Exception {
        HttpURLConnection connection = createConnection("request=GetLegendGraphic&service=wms&layer=" + aLayerName + "&format=image/png&scale=100000");

        return getImage(connection);
    }

    @Override
    protected void parseGetCapabilitiesDocument() throws Exception {
        if (getVersion().equals(OWS.WMS_1_3_0)) {
            XPath xpath = createXPath();

            setGetMapOnlineResource(getGetMapOnlineResource(xpath));

            setLayers(getLayers(xpath));
        } else {
            throw new Exception("Unsupported WMS version: " + getVersion());
        }
    }

    private LayerList getLayers(XPath aXPath) throws XPathExpressionException {
        LayerList result = new LayerList();

        XPathExpression layersexpr = aXPath.compile("//wms:Capability/wms:Layer/wms:Layer");

        NodeList layersnodelist = (NodeList) layersexpr.evaluate(getGetCapabilitiesDocument(), XPathConstants.NODESET);

        for (int i = 0; i < layersnodelist.getLength(); i ++) {
            Node layernode = layersnodelist.item(i);

            Layer layer = createLayer(aXPath, layernode);

            XPathExpression sublayersexpr = aXPath.compile("wms:Layer");

            NodeList sublayersnodelist = (NodeList) sublayersexpr.evaluate(layernode, XPathConstants.NODESET);

            for (int j = 0; j < sublayersnodelist.getLength(); j ++) {
                Node sublayernode = sublayersnodelist.item(j);

                Layer sublayer = createLayer(aXPath, sublayernode);

                layer.getLayerList().add(sublayer);
            }

            result.add(layer);
        }

        return result;
    }

    private Layer createLayer(XPath aXPath, Node aNode)
            throws XPathExpressionException {
        XPathExpression nameexpr = aXPath.compile("wms:Name");

        String name = (String) nameexpr.evaluate(aNode, XPathConstants.STRING);

        XPathExpression titleexpr = aXPath.compile("wms:Title");

        String title = (String) titleexpr.evaluate(aNode, XPathConstants.STRING);

        XPathExpression abstracttextexpr = aXPath.compile("wms:Abstract");

        String abstracttext = (String) abstracttextexpr.evaluate(aNode, XPathConstants.STRING);

        XPathExpression metadataurlonlineresourceexpr = aXPath.compile("wms:MetadataURL/wms:OnlineResource");

        Node metadataurlonlineresourcenode = (Node) metadataurlonlineresourceexpr.evaluate(aNode, XPathConstants.NODE);

        String metadataonlineresource = getHRef(aXPath, metadataurlonlineresourcenode);

        Layer layer = new Layer(name, title, abstracttext, metadataonlineresource);
        return layer;
    }

    private String getGetMapOnlineResource(XPath aXPath) throws XPathExpressionException {
        String getmaponlineresource = null;

        XPathExpression getmaponlineresourcehttpexpr = aXPath.compile("//wms:Capability/wms:Request/wms:GetMap/wms:DCPType/wms:HTTP/*/wms:OnlineResource");

        NodeList getmaponlineresourcenodelist = (NodeList) getmaponlineresourcehttpexpr.evaluate(getGetCapabilitiesDocument(), XPathConstants.NODESET);

        if (getmaponlineresourcenodelist.getLength() > 0) {
            Node getmaponlineresourcenode = getmaponlineresourcenodelist.item(0);

            getmaponlineresource = getHRef(aXPath, getmaponlineresourcenode);
        }

        return getmaponlineresource;
    }

    private String getHRef(XPath aXPath, Node aOnlineResourceNode) throws XPathExpressionException {
        String result = null;

        if (aOnlineResourceNode != null) {
            XPathExpression hrefexpr = aXPath.compile("@xlink:href");

            result = (String) hrefexpr.evaluate(aOnlineResourceNode, XPathConstants.STRING);
        }

        return result;
    }

    public String getGetMapOnlineResource() {
        return getMapOnlineResource;
    }

    public void setGetMapOnlineResource(String getMapOnlineResource) {
        this.getMapOnlineResource = getMapOnlineResource;
    }

    public LayerList getLayers() {
        return layers;
    }

    public void setLayers(LayerList layers) {
        this.layers = layers;
    }
}
