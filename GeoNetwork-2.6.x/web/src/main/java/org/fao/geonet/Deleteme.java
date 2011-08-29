package org.fao.geonet;

import jeeves.utils.TransformerFactoryFactory;
import jeeves.utils.Xml;
import org.jdom.Element;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * Created by IntelliJ IDEA.
 * User: heikki
 * Date: 3/30/11
 * Time: 12:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class Deleteme {

    public static void main(String[] a) {
        Deleteme d = new Deleteme();
        try {
            d.x();
        }
        catch(Throwable x) {
            System.err.println(x.getMessage());
            x.printStackTrace();
        }

    }

    private void x() throws Exception {

        System.out.println("start");

        String xsl = "C:\\source\\gn26x\\2.6.x\\web\\src\\main\\webapp\\xml\\schemas\\iso19139\\update-fixed-info.xsl";
        String xml = "C:\\projects\\ngr\\gemeentegelderlandiso19139.xml";
        Element tr = Xml.loadFile(xml);
        TransformerFactoryFactory.init("net.sf.saxon.TransformerFactoryImpl");

        String text = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" xmlns:csw=\"http://www.opengis.net/cat/csw/2.0.2\" xmlns:gmd=\"http://www.isotc211.org/2005/gmd\" xmlns:gco=\"http://www.isotc211.org/2005/gco\" xmlns:srv=\"http://www.isotc211.org/2005/srv\" xmlns:ows=\"http://www.opengis.net/ows\" xmlns:geonet=\"http://www.fao.org/geonetwork\">\n" +
                "\t<xsl:output indent=\"yes\"/>\n" +
                "\t<xsl:param name=\"displayInfo\"/>\n" +
                "\t<!-- =================================================================== -->\n" +
                "\t<xsl:template match=\"gmd:MD_Metadata|*[@gco:isoType='gmd:MD_Metadata']\">\n" +
                "\t\t<xsl:variable name=\"info\" select=\"geonet:info\"/>\n" +
                "\t\t<xsl:copy>\n" +
                "\t\t\t<xsl:apply-templates select=\"/gmd:MD_Metadata/gmd:contact/gmd:CI_ResponsibleParty/gmd:contactInfo/gmd:CI_Contact/gmd:phone/gmd:CI_Telephone/gmd:voice\"/>\t\t\t\n" +
                "\t\t\t<xsl:apply-templates select=\"/gmd:MD_Metadata/gmd:contact/gmd:CI_ResponsibleParty/gmd:contactInfo/gmd:CI_Contact/gmd:phone/gmd:CI_Telephone/gmd:facsimile\"/>\n" +
                "\t\t\t<!-- GeoNetwork elements added when resultType is equal to results_with_summary -->\n" +
                "\t\t\t<xsl:if test=\"$displayInfo = 'true'\">\n" +
                "\t\t\t\t<xsl:copy-of select=\"$info\"/>\n" +
                "\t\t\t</xsl:if>\n" +
                "\t\t</xsl:copy>\n" +
                "\t</xsl:template>\n" +
                "\n" +
                "\t<xsl:template match=\"@*|node()\">\n" +
                "\t\t<xsl:copy>\n" +
                "\t\t\t<xsl:apply-templates select=\"@*|node()\"/>\n" +
                "\t\t</xsl:copy>\n" +
                "\t</xsl:template>\n" +
                "\t\n" +
                "</xsl:stylesheet>";
        InputStream is = new ByteArrayInputStream(text.getBytes("UTF-8"));
        Source ss = new StreamSource(is);


        Element r = Xml.transform(tr, ss);

        System.out.println(Xml.getString(r));

    }

}
