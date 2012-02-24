/* Copyright (c) 2006-2011 by OpenLayers Contributors (see authors.txt for 
 * full list of contributors). Published under the Clear BSD license.  
 * See http://svn.openlayers.org/trunk/openlayers/license.txt for the
 * full text of the license. */

/**
 * @requires OpenLayers/Format/WMC.js
 * @requires OpenLayers/Format/XML.js
 */

/**
 * Class: OpenLayers.Format.WMC.v1
 * Superclass for WMC version 1 parsers.
 *
 * Inherits from:
 *  - <OpenLayers.Format.XML>
 */
CHM.GetRecordByIdResponse = OpenLayers.Class(OpenLayers.Format.XML, {
    
    /**
     * Property: namespaces
     * {Object} Mapping of namespace aliases to namespace URIs.
     */
    namespaces: {
        sld: "http://www.opengis.net/sld",
        xlink: "http://www.w3.org/1999/xlink",
        xsi: "http://www.w3.org/2001/XMLSchema-instance",
        csw: "http://www.opengis.net/cat/csw/2.0.2",
        gmd: "http://www.isotc211.org/2005/gmd",
        gts: "http://www.isotc211.org/2005/gts",
        wms: "http://www.opengis.net/wms",
        gco: "http://www.isotc211.org/2005/gco",
        xlink: "http://www.w3.org/1999/xlink",
        xsi: "http://www.w3.org/2001/XMLSchema-instance",
        gml: "http://www.opengis.net/gml"
    },
    
    /**
     * Property: schemaLocation
     * {String} Schema location for a particular minor version.
     */
    schemaLocation: "",

    /**
     * Method: getNamespacePrefix
     * Get the namespace prefix for a given uri from the <namespaces> object.
     *
     * Returns:
     * {String} A namespace prefix or null if none found.
     */
    getNamespacePrefix: function(uri) {
        var prefix = null;
        if(uri == null) {
            prefix = this.namespaces[this.defaultPrefix];
        } else {
            for(prefix in this.namespaces) {
                if(this.namespaces[prefix] == uri) {
                    break;
                }
            }
        }
        return prefix;
    },
    
    /**
     * Property: defaultPrefix
     */
    defaultPrefix: "gmd",

    /**
     * Property: rootPrefix
     * {String} Prefix on the root node that maps to the context namespace URI.
     */
    rootPrefix: null,
    
    /**
     * Constructor: OpenLayers.Format.WMC.v1
     * Instances of this class are not created directly.  Use the
     *     <OpenLayers.Format.WMC> constructor instead.
     *
     * Parameters:
     * options - {Object} An optional object whose properties will be set on
     *     this instance.
     */
    initialize: function(options) {
        OpenLayers.Format.XML.prototype.initialize.apply(this, [options]);
    },

    /**
     * Method: read
     * Read capabilities data from a string, and return a list of layers. 
     * 
     * Parameters: 
     * data - {String} or {DOMElement} data to read/parse.
     *
     * Returns:
     * {Array} List of named layers.
     */
    read: function(data) {
        if (typeof data == "string") { 
            data = OpenLayers.Format.XML.prototype.read.apply(this, [data]);
        }
        
        if (data && data.nodeType == 9) {
            data = data.documentElement;
        }
        
        var metadata = {};
        
        this.readNode(data, metadata);
        
        return metadata;
    },
    
    /**
     * Method: runChildNodes
     */
    readNode: function(node, metadata) {
        var children = node.childNodes;

        var childNode, processor, prefix, local;

        for (var i = 0, len = children.length; i < len; ++ i) {
            childNode = children[i];

            if (childNode.nodeType == 1) {
                prefix = this.getNamespacePrefix(childNode.namespaceURI);

                local = childNode.nodeName.split(":").pop();

                processor = this["read_" + prefix + "_" + local];

                if (processor) {
                    processor.apply(this, [childNode, metadata]);
                }
            }
        }
    },
    
    /**
     * Method: read_wmc_General 
     */
    read_gmd_MD_Metadata: function(node, metadata) {
        this.readNode(node, metadata);
    },
    
    read_gmd_identificationInfo: function(node, metadata) {
        this.readNode(node, metadata);
    },
    
    read_gmd_MD_DataIdentification: function(node, metadata) {
        this.readNode(node, metadata);
    },
    
    read_gmd_citation: function(node, metadata) {
        this.readNode(node, metadata);
    },
    
    read_gmd_CI_Citation: function(node, metadata) {
        this.readNode(node, metadata);
    },
    
    read_gmd_fileIdentifier: function(node, metadata) {
    	metadata.fileIdentifier = this.readString(node);
    }, 
    
    read_gmd_title: function(node, metadata) {
    	metadata.title = this.readString(node);
    },
    
    read_gmd_abstract: function(node, metadata) {
    	metadata.abstractText = this.readString(node);
    },
    
    readString: function(node) {
    	var result = "";
    	
        var children = node.childNodes;

        var childNode;

        for(var i = 0, len = children.length; i < len; ++ i) {
            childNode = children[i];
            
            if (childNode.nodeType == 1) {
                result = this.getChildValue(childNode);
            }
        }
        
        return result;
    }, 

    /**
     * Method: read_wmc_BoundingBox
     */
    read_wmc_BoundingBox: function(context, node) {
        context.projection = node.getAttribute("SRS");
        context.bounds = new OpenLayers.Bounds(
            parseFloat(node.getAttribute("minx")),
            parseFloat(node.getAttribute("miny")),
            parseFloat(node.getAttribute("maxx")),
            parseFloat(node.getAttribute("maxy"))
        );
    },

    CLASS_NAME: "CHM.ISO19139" 

});
