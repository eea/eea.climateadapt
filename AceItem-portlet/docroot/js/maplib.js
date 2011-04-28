
OpenLayers.DOTS_PER_INCH = 90.71;
OpenLayers.IMAGE_RELOAD_ATTEMPTS = 3;

// Remove pink background when a tile fails to load
OpenLayers.Util.onImageLoadErrorColor = "transparent";

OpenLayers.Util.onImageLoadError = function() {
    this._attempts = (this._attempts) ? (this._attempts + 1) : 1;
    if(this._attempts <= OpenLayers.IMAGE_RELOAD_ATTEMPTS) {
        this.src = this.src;
    } else {
        this.style.backgroundColor = OpenLayers.Util.onImageLoadErrorColor;
        this.style.display = "none";
    }
};


Ext.namespace('GeoNetwork', 'GeoNetwork.OGCUtil');

GeoNetwork.WMSList = []
GeoNetwork.WMSList.push(["Soil Threats","http://eusoils.jrc.ec.europa.eu/wrb/wms_Threats.asp?"]);
GeoNetwork.WMSList.push(["Soil Texture","http://eusoils.jrc.ec.europa.eu/wrb/wms_Texture.asp?"]);
GeoNetwork.WMSList.push(["Soil Classification WRB","http://eusoils.jrc.ec.europa.eu/wrb/wms_WRB.asp"]);
GeoNetwork.WMSList.push(["Parent Material","http://eusoils.jrc.ec.europa.eu/wrb/wms_Pmaterial.asp?"]);
GeoNetwork.WMSList.push(["FAO Soil Classification","http://eusoils.jrc.ec.europa.eu/wrb/wms_FAO.asp?"]);
GeoNetwork.WMSList.push(["Land Use","http://eusoils.jrc.ec.europa.eu/wrb/wms_Landuse.asp?"]);

GeoNetwork.WMSList.push(["Limitation to Agricultural use","http://eusoils.jrc.ec.europa.eu/WRB/WMS_Agriculture.asp?"]);
GeoNetwork.WMSList.push(["Obstacle - Impermeable - Soil Water Regime","http://eusoils.jrc.ec.europa.eu/WRB/WMS_Obstacle.asp?"]);	
GeoNetwork.WMSList.push(["Water Management System","http://eusoils.jrc.ec.europa.eu/WRB/WMS_Water.asp?"]);	
GeoNetwork.WMSList.push(["Altitude - Slope","http://eusoils.jrc.ec.europa.eu/WRB/WMS_Altitude.asp?"]);	 
GeoNetwork.WMSList.push(["Primary Properties","http://eusoils.jrc.ec.europa.eu/WRB/WMS_Primary.asp?"]);	
GeoNetwork.WMSList.push(["Chemical Properties","http://eusoils.jrc.ec.europa.eu/WRB/WMS_Chemical.asp?"]);	
GeoNetwork.WMSList.push(["Hydrological Properties","http://eusoils.jrc.ec.europa.eu/WRB/WMS_Hydrological.asp?"]);	
GeoNetwork.WMSList.push(["Mechanical properties","http://eusoils.jrc.ec.europa.eu/WRB/WMS_Mechanical.asp?"]);


GeoNetwork.OGCUtil.getProtocolVersion = function() {
    return "1.3.0"
};


GeoNetwork.OGCUtil.getLanguage = function() {
    return 'eng';
};


/**
 * APIFunction: GeoNetwork.OGCUtil.ensureProperUrlEnd
 * Function to make sure that the last char of the URL is either a ?
 * or a &, to make adding of parameters safe
 *
 * Parameters:
 * url - {String} the url to make safe
 *
 * Returns:
 * {String} the url made safe
*/
GeoNetwork.OGCUtil.ensureProperUrlEnd = function (url) {
    if (url.indexOf("?") == -1) {
        url += "?"; 
    }
    else { 
        // url can be like http://.../...?var=value, make sure that it will
        // end correctly
        var lastChar = url.substring(url.length-1);
        if (lastChar != "&" && lastChar !="?") {
            url+="&";
        }
    }
    return url;
};

/**
 * APIFunction: GeoNetwork.OGCUtil.layerExistsInMap
 * Check if the layer already exists in the map, using the SERVICE,
 * LAYERS params and url
 *
 * Parameters:
 * layer - {<OpenLayers.Layer.WMS>} the layer to be checked
 * map - {<OpenLayers.Map>} the map object
 *
 * Returns:
 * {Boolean} false if the layer does not exist
 * {<OpenLayers.Layer.WMS>} the layer which has been found
*/
GeoNetwork.OGCUtil.layerExistsInMap = function (layer, map) {
    var layerExists = false;
    for (var i=0, len=map.layers.length; i<len; i++) {
        if (map.layers) {
            var lr = map.layers[i];
            if (lr.params) {
                try {
                    var layers = lr.params.LAYERS.split(",");
                    if ((layers.indexOf(layer.params.LAYERS) != -1) &&
                      lr.params.SERVICE == layer.params.SERVICE &&
                        lr.url == layer.url) {
                        layerExists = lr;
                        break;
                    }
                } catch(e) {}
            }
        }
    }
    return layerExists;
};


Ext.namespace('GeoNetwork', 'GeoNetwork.tree');

/**
 * Class: GeoNetwork.tree.WMSListGenerator
 *      WMSListGenerator generates an Ext.tree.TreeNode representing multiple
 *      Web Mapping Services and their layer lists.
 */

/**
 * Constructor: GeoNetwork.tree.WMSListGenerator
 * Create an instance of GeoNetwork.tree.WMSListGenerator
 *
 * Parameters:
 * config - {Object} A config object used to set the properties
 */
GeoNetwork.tree.WMSListGenerator = function(config){
    Ext.apply(this, config);
    if (this.node && this.wmsStore) {
        this.createWMSList();
    }
};

GeoNetwork.tree.WMSListGenerator.prototype = {

    /**
     * APIProperty: node
     * {<Ext.tree.TreeNode>} the node to which the WMS list will be appended
     */
    node: null,

    /**
     * APIProperty: wmsStore
     * {<Ext.data.Store>} a store of WMS services, which have a title and a 
     *     url property
     */
    wmsStore: null,

    /**
     * APIProperty: click
     * {Function} click function to use when clicked on the child nodes
     */
    click: null,

    /**
     * APIProperty: scope
     * {Object} scope to use for the click function
     */
    scope: null,

    /**
     * APIMethod: createWMSList
     * create a tree node per WMS and on click of that node load the layers
     *     thorugh the loadWMS API method.
     */
    createWMSList: function() {
        this.wmsStore.each(this.appendRecord, this);
    },

    /**
     * Method: appendRecord
     * Append an Ext.data.Record from the wmsStore to the treeview
     *
     * Parameters:
     * record - {<Ext.data.Record>} a record with a url and title property
     */
    appendRecord: function(record) {
        var wmsNode = new Ext.tree.TreeNode({url: record.get('url'),
            text: record.get('title'), cls: 'folder', leaf: false});
        // append a dummy child so that it will appear as a directory
        wmsNode.appendChild(new Ext.tree.TreeNode({text: '', dummy: true}));
        wmsNode.addListener("beforeexpand", this.addNodesFromWMS, this);
        this.node.appendChild(wmsNode);
    },

    /**
     * Method: replaceNode
     * Replace the node with the WMS title with the one extracted from the
     *     GetCapabilities response
     *
     * Parameters:
     * node - {<Ext.tree.TreeNode>} the node extracted from the GetCapabilities
     */
    replaceNode: function(node) {
        this.currentNode.parentNode.replaceChild(node, this.currentNode);
        node.ui.afterLoad();
        node.expand();
    },

    /**
     * Method: addNodesFromWMS
     * Before the node is expanded, load a new TreeNode from the
     *     GetCapabilities and when it is done replace the current node
     *     with the newly created one.
     *
     * Parameters:
     * node - {<Ext.tree.TreeNode>} the WMS node with only a title and url
     */
    addNodesFromWMS: function(node) {
        // first remove the dummy child
        if (node.firstChild && node.firstChild.attributes.dummy) {
            node.removeChild(node.firstChild);
            node.ui.beforeLoad();
            this.scope.currentNode = node;
            // start loading the actual layer tree, when done replace
            var treeGenerator = new GeoNetwork.tree.WMSTreeGenerator(
                {click: this.click, callback: this.replaceNode, 
                    scope: this.scope});
            treeGenerator.loadWMS(node.attributes.url);
        }
    }

};

Ext.namespace('GeoNetwork', 'GeoNetwork.tree');

/**
 * Class: GeoNetwork.tree.WMSTreeGenerator
 *      WMSTreeGenerator generates an Ext.tree.TreeNode representing the layer
 *      list of a OGC:WMS Web Mapping Service.
 */

/**
 * Constructor: GeoNetwork.tree.WMSTreeGenerator
 * Create an instance of GeoNetwork.tree.WMSTreeGenerator
 *
 * Parameters:
 * config - {Object} A config object used to set the properties
 */
GeoNetwork.tree.WMSTreeGenerator = function(config){
    Ext.apply(this, config);
};

GeoNetwork.tree.WMSTreeGenerator.prototype = {

    /**
     * APIProperty: layerParams
     * {Object} - a set of URL parameters to use on the OpenLayers.Layer.WMS
     *     layers
     */
    layerParams: {format:'image/png', transparent:'TRUE'},

    /**
     * APIProperty: layerOptions
     * {Object} - a set of options to use on the OpenLayers.Layer.WMS
     *     layers
     */
    layerOptions: {ratio:1, singleTile: true, isBaseLayer: false},

    /**
     * APIProperty: click
     * {Function} click function to use when clicked on the child nodes
     */
    click: null,

    /**
     * APIProperty: callback
     * {Function} callback function to use when the TreeNode is ready
     */
    callback: null,

    /**
     * APIProperty: scope
     * {Object} scope to use for the click and the callback function
     */
    scope: null,

    /**
     * APIMethod: loadWMS
     * load a WMS layer list and return a TreeNode through a callback
     * function
     *
     * Parameters:
     * onlineResource - {String} the online resource / base url of the WMS
     */
    loadWMS: function(onlineResource) {    
        var containsVersion = (onlineResource.indexOf('version=') > -1);

        var params = {'service': 'WMS', 'request': 'GetCapabilities',
                      'language': GeoNetwork.OGCUtil.getLanguage()};

        if (!containsVersion) {
            params['version'] = "1.3.0";
        }

        var paramString = OpenLayers.Util.getParameterString(params);
        var separator = (onlineResource.indexOf('?') > -1) ? '&' : '?';
        onlineResource += separator + paramString;
    
        var req = Ext.Ajax.request({
            url: OpenLayers.Util.removeTail(OpenLayers.ProxyHost),
            method: 'GET',
            params: {url: onlineResource},
            failure: this.processFailure,
            success: this.processSuccess,
            disableCaching: false,
            scope: this
        });
    },

    /**
     * Method: processSuccess
     * Process the WMS GetCapabilities response
     *
     * Parameters:
     * response - {Object} The XHR object which contains the parsed XML doc
     */
    processSuccess: function(response) {
        if (!this.parser) {
            this.parser = new OpenLayers.Format.WMSCapabilities();
        }
        var caps = this.parser.read(response.responseXML || response.responseText);
        this.layerParams.VERSION = caps.version;
        var node;
        if (caps.capability) {
            for(var i=0, len = caps.capability.nestedLayers.length; i<len; ++i) {
                var layer = caps.capability.nestedLayers[i];

                node = this.addLayer(layer, caps.capability.request.getmap.href, null);
                this.processLayer(layer, caps.capability.request.getmap.href, node);
            }
        }
        // return the newly created TreeNode through a callback function
        Ext.callback(this.callback, this.scope, [node,caps]);
    },

    /**
     * Method: processFailure
     * Process the WMS GetCapabilities response when failed
     *
     * Parameters:
     * response - {Object} The XHR object which contains the parsed XML doc
     */
    processFailure: function(response) {
    alert(response);
    
       // Ext.callback(this.callback, this.scope, null);
    },

    /**
     * APIMethod: createWMSLayer
     * create a OpenLayers.Layer.WMS from parameters
     *
     * Parameters:
     * layer - {Object} an object with the layer's properties
     * url - {String} the url at which the layer is available
     *
     * Returns: {<OpenLayers.Layer.WMS>} the layer created
     */
    createWMSLayer: function(layer, url) {
        return new OpenLayers.Layer.WMS( layer.title, url,
            OpenLayers.Util.extend({layers: layer.name, language: GeoNetwork.OGCUtil.getLanguage()}, this.layerParams),
            OpenLayers.Util.extend({minScale: layer.minScale,
                queryable: layer.queryable, maxScale: layer.maxScale,
                metadataURL: layer.metadataURL,
                dimensions: layer.dimensions,
                styles: layer.styles,
                llbbox: layer.llbbox},
                    this.layerOptions));
    },

    /**
     * Method: addLayer
     * Add a layer to the TreeNode
     *
     * Parameters:
     * layer - {Object} layer object from the WMSCapabilities parser
     * url - {String} the OnlineResource of the WMS
     * parentNode - {<Ext.tree.TreeNode>} if there is a parentNode, the newly
     *     created node will be appended to the parentNode
     *
     * Returns: {<Ext.tree.TreeNode>}
     */
    addLayer: function(layer, url, parentNode) {
        var wmsLayer = null;
        if (layer.name) {
            wmsLayer = this.createWMSLayer(layer, url);
            if (layer.styles && layer.styles.length > 0) {
                var style = layer.styles[0];
                if (style.legend && style.legend.href) {
                    wmsLayer.legendURL = style.legend.href;
                }
            }
        }
        var node = new Ext.tree.TreeNode({wmsLayer: wmsLayer, text:
            layer.title});
        node.addListener("click", this.click, this.scope);
        if (parentNode) {
            parentNode.appendChild(node);
        }
        return node;
    },

    /**
     * Method: processLayer
     * Recursive function to process a layer and their childLayers
     *
     * Parameters:
     * layer - {Object} layer object from the WMSCapabilities parser
     * url - {String} the OnlineResource of the WMS
     * node - {<Ext.tree.TreeNode>}
     */
    processLayer: function(layer, url, node) {
        Ext.each(layer.nestedLayers, function(el) {
            var node2 = this.addLayer(el, url, node);
            if (el.nestedLayers) {
                this.processLayer(el, url, node2);
            }
        }, this);
    }

};

Ext.namespace('GeoNetwork', 'GeoNetwork.wms');

/**
 * Class: GeoNetwork.wms.PreviewPanel
 * A panel to show a preview image of a WMS layer before it gets added to
 *     the map. It uses a BoxComponent for the image itself.
 *
 * Inherits from:
 *  - {Ext.Panel}
 */

/**
 * Constructor: GeoNetwork.wms.PreviewPanel
 * Create an instance of GeoNetwork.wms.PreviewPanel
 *
 * Parameters:
 * config - {Object} A config object used to set the WMS preview
 *     panel's properties.
 */
GeoNetwork.wms.PreviewPanel = function(config){
    Ext.apply(this, config);
    GeoNetwork.wms.PreviewPanel.superclass.constructor.call(this);
};

Ext.extend(GeoNetwork.wms.PreviewPanel, Ext.Panel, {

    /**
     * APIProperty: title
     * {String} The title to use in the header of the preview panel
     */
    title: "Preview",

    /**
     * APIProperty: baseCls
     * {String} The base CSS class to apply to this panel's element 
     *     (defaults to 'x-plain'). 
     */
    baseCls: 'x-plain',

    /**
     * APIProperty: cls
     * {String} An optional extra CSS class that will be added to this 
     *     component's Element (defaults to 'x-panel-title-variant1').
     */
    cls: 'x-panel-title-variant1',

    /**
     * APIProperty: imgCls
     * {String} css class to put on the <img> (defaults to 'preview-image')
     */
    imgCls: 'preview-image',

    /**
     * APIProperty: width
     * {Integer} the width of this panel (defaults to 250)
     */
    width: 250,

    /**
     * APIProperty: height
     * {Integer} the height of this panel (defaults to 250)
     */
    height: 250,

    /**
     * APIProperty: currentLayer
     * {<OpenLayers.Layer.WMS>} the current layer being previewed
     */
    currentLayer: null,

    /**
     * Method: initComponent
     * Initializes this component
     */
    initComponent: function() {
        GeoNetwork.wms.PreviewPanel.superclass.initComponent.call(this);
        this.image = new Ext.BoxComponent({autoEl: {tag: 'img',
            'class': this.imgCls, src: Ext.BLANK_IMAGE_URL, 
            width: this.width, height: this.height}});
        this.add(this.image);
    },

    /**
     * Method: hideMask
     * Hides the Ext.LoadMask
     */
    hideMask: function() {
        if (this.mask) {
            this.mask.hide();
        }
    },

    /**
     * Method: showMask
     * Shows the Ext.LoadMask
     */
    showMask: function() {
        if (!this.mask) {
            this.mask = new Ext.LoadMask(this.getEl(), {
                msg:  "Loading"});
            Ext.EventManager.addListener(this.image.getEl(), 'load', 
                this.hideMask, this);
            Ext.EventManager.addListener(this.image.getEl(), 'error', 
                this.hideMask, this);
        }
        this.mask.show();
    },

    /**
     * Method: calculateBBOX
     * Calculate the BBOX to use for the preview, based on scales etc.
     *
     * Parameters:
     * layer - {<OpenLayers.Layer.WMS>}
     *
     * Returns:
     * {String} the BBOX parameter as a string
     */
    calculateBBOX: function(layer) {
        var bbox;
        if (layer.llbbox) {
            if (this.map.getProjection() !== 'EPSG:4326') {
                // reproject the latlon boundingbox to the map projection
                var llbounds = OpenLayers.Bounds.fromArray(layer.llbbox);
                llbounds = llbounds.transform(new OpenLayers.Projection('EPSG:4326'),
                    this.map.getProjectionObject() );
                bbox = llbounds.toArray();
            } else {
                bbox = layer.llbbox;
            }
        } else {
            bbox = this.map.maxExtent.toArray();
        }
        var center = OpenLayers.Bounds.fromArray(bbox).getCenterLonLat();
        // change the bbox so that the WMS returns an image that is inside
        // the scale-range of the layer
        if (layer.minScale > 0) {
            var midScale;
            if (layer.maxScale > 0) {
                midScale = (layer.maxScale + layer.minScale) / 2;
            }
            else {
                // take less than 100%, because of small differences in
                // calculating WMS scales
                midScale = 0.9 * layer.minScale;
            }
            // determine the new bbox based on the center
            // and scale range of the WMS Layer
            var res = OpenLayers.Util.getResolutionFromScale(midScale, 
                this.map.units);
            var dX = Math.round(res * this.width);
            var dY = Math.round(res * this.height);
            var cX = center.lon;
            var cY = center.lat;
            if (dX !== 0 && dY !== 0) {
                bbox = [cX - 0.5*dX, cY - 0.5*dY, cX + 0.5*dX, cY + 0.5*dY];
            }
        }
        return bbox.join(",");
    },

    /**
     * APIMethod: showPreview
     * Shows a preview image of the WMS layer
     *
     * Parameters:
     * layer - {<OpenLayers.Layer.WMS>}
     */
    showPreview : function (layer){
        if (!layer) {
            return;
        }
        this.showMask();
        
        // if the layer has not been added to the map yet, we need to set its
        // map property otherwise getFullRequestString will not work.
        var previousMap = layer.map;
        if (previousMap === null) {
            layer.map = this.map;
        }

        var url = layer.getFullRequestString({
            BBOX: this.calculateBBOX(layer),
            WIDTH: this.width,
            HEIGHT: this.height
        });

        if (previousMap === null) {
            layer.map = previousMap;
        }

        this.currentLayer = layer;
        this.image.getEl().dom.src = url;
    },

    showPreviewLegend : function (urlLegend) {
        this.remove(this.image);
        this.image = null;

        this.image = new Ext.BoxComponent({autoEl: {tag: 'img',
            'class': this.imgCls, src: urlLegend}});
        this.add(this.image);
        
        this.doLayout();
    }
});

Ext.reg('gn_wmspreview', GeoNetwork.wms.PreviewPanel);

Ext.namespace('GeoNetwork', 'GeoNetwork.wms');

/**
 * Class: GeoNetwork.wms.BrowserPanel
 *      WMSBrowserPanel groups together a TreePanel and a WMSPreviewPanel
 *      as well as the button to add layers to the map.
 */

/**
 * Constructor: GeoNetwork.wms.BrowserPanel
 * Create an instance of GeoNetwork.wms.BrowserPanel
 *
 * Parameters:
 * config - {Object} A config object used to set the properties
 */
GeoNetwork.wms.BrowserPanel = function(config){
    Ext.apply(this, config);
    GeoNetwork.wms.BrowserPanel.superclass.constructor.call(this);
};

GeoNetwork.wms.BrowserPanel.ADDWMS = 0;
GeoNetwork.wms.BrowserPanel.WMSLIST = 1;

Ext.extend(GeoNetwork.wms.BrowserPanel, Ext.Panel, {

    /**
     * APIProperty: previewPanel
     * {<GeoNetwork.WMSPreviewPanel>} the panel used for previewing
     *     WMS layers
     */
    previewPanel: null,

    /**
     * APIProperty: treePanel
     * {<Ext.tree.TreePanel>} the panel used for the treeview
     */
    treePanel: null,

    /**
     * APIProperty: map
     * {<OpenLayers.Map>} the map object
     */
    map: null,

    /**
     * APIProperty: previewCenterPoint
     * {<OpenLayers.Geometry.Point>} it preview can be centered on this point,
     *     but defaults to the map center
    */
    previewCenterPoint: null,

    /**
     * APIProperty: mode
     * {Integer} what mode should the wms browser panel operate in?
     *     One of: ADDWMS or WMSLIST. Default is WMSLIST
     */
    mode: GeoNetwork.wms.BrowserPanel.WMSLIST,

    /**
     * APIProperty: wmsStore
     * {<Ext.data.Store>} a store of wms servers, which have a title and a
     *     url property. Only needed for mode = WMSLIST
     */
    wmsStore: null,

    /**
     * APIProperty: url
     * {<Ext.data.Store>} default url to show
     *     url property. Only needed for mode = WMSLIST
     */
    url: '',


    /**
     * initComponent
     * Initialize this component
    */
    initComponent: function() {
        GeoNetwork.wms.BrowserPanel.superclass.initComponent.call(this);

        this.layout = 'border';

        this.previewPanel = new GeoNetwork.wms.PreviewPanel(
            {map: this.map, previewCenterPoint: this.previewCenterPoint});

        var root;
        this.treePanel = new Ext.tree.TreePanel({rootVisible: false,
            autoScroll: true});
        root = new Ext.tree.TreeNode({text: '', draggable:false,
            cls: 'folder'});
        this.treePanel.setRootNode(root);

        var centerItems;
        if (this.mode == GeoNetwork.wms.BrowserPanel.ADDWMS) {
            this.form = new Ext.form.FormPanel({labelWidth: 25});

            var url = new Ext.form.TextField({
                fieldLabel: 'URL',
                name: 'wmsurl',
                value: this.url,
                width: 250, autoHeight: true
            });

            /*var protocol = new Ext.form.ComboBox({
                mode:           'local',
                value:          '1.1.1',
                triggerAction:  'all',
                forceSelection: true,
                editable:       false,
                fieldLabel:     'Protocol',
                name:           'wmsprotocol',
                hiddenName:     'wmsprotocol',
                displayField:   'name',
                valueField:     'value',
                store:          new Ext.data.JsonStore({
                    fields : ['name', 'value'],
                    data   : [
                        {name : '1.1.1', value: '1.1.1'},
                        {name : '1.3.0', value: '1.3.0'}
                    ]
                }),
                width: 100
            });*/

            this.form.add(url);
            //this.form.add(protocol);

            this.form.add(new Ext.Button({id: 'parse', text:
                "Connect",
                scope: this, handler: this.getWMSCaps}));

            this.form.add(this.treePanel);
            centerItems = [this.form];
        } else {
            centerItems = [this.treePanel];
        }

        var center = {autoScroll: true, region: 'center', items: centerItems,
            split: true, width: 300, minWidth: 300, border: false};

        var east = {region: 'east', border: false, items: [this.previewPanel], split: true,
            plain: true, cls: 'popup-variant1', width:250, maxSize: 250,
            minSize: 250};

        this.add(center);
        this.add(east);

        if (this.mode == GeoNetwork.wms.BrowserPanel.WMSLIST) {
            this.treeGen = new GeoNetwork.tree.WMSListGenerator(
                {click: this.nodeClick, scope: this,
                node: this.treePanel.getRootNode(), wmsStore: this.wmsStore});
        } else if (this.mode == GeoNetwork.wms.BrowserPanel.ADDWMS) {
	    
            new GeoNetwork.tree.WMSListGenerator(
                {click: this.nodeClick, scope: this,
                node: this.treePanel.getRootNode(), wmsStore: this.wmsStore});

            this.treeGen = new GeoNetwork.tree.WMSTreeGenerator(
                {click: this.nodeClick, callback: this.showTree, scope: this});
        }

        this.addButton("Add layer",
            this.addLayerToMap, this);

        this.doLayout();

        if (this.url != '') this.getWMSCaps();
    },

    /**
     * Method: showTree
     * Show the treeview of 1 WMS when the layer structure has been loaded
     *
     * Parameters:
     * node - {<Ext.tree.TreeNode>} the newly created node
     */
    showTree: function(node, capability) {
        if (!node) {
            Ext.MessageBox.alert("Error",
                "Connection error");
            this.body.dom.style.cursor = 'default';
        }

        var accessContraints = capability.service.accessContraints;

        /*if ((accessContraints) && (accessContraints.toLowerCase() != "none") && 
          (accessContraints != "-")) {
            var disclaimerWindow = new GeoNetwork.DisclaimerWindow({
                disclaimer: accessContraints
            });
            disclaimerWindow.show();
            disclaimerWindow = null;
        }*/

        var root = this.treePanel.getRootNode();
        // remove previous WMS node
        /*while(root.firstChild){
          root.removeChild(root.firstChild);
        }*/
        if (node) {
            this.treePanel.getRootNode().appendChild(node);
            node.expand(true);
        }
        this.treePanel.show();
        this.body.dom.style.cursor = 'default';
    },


    loadUrl: function(url) {
         this.form.getForm().findField('wmsurl').setValue(url);
         this.getWMSCaps();
    },

    /**
     * Method: getWMSCaps
     * Load the WMS Capabilities through the tree generator
     *
     * Parameters:
     * btn - {<Ext.Button>} the button pressed
     */
    getWMSCaps: function(btn) {
        var url = this.form.getForm().findField('wmsurl').getValue();
        //var protocol = this.form.getForm().findField('wmsprotocol').getValue();
        // trim the string
        alert(url);
        url = url.replace(/^\s+|\s+$/g, '');
        if (url != '') {
            this.body.dom.style.cursor = 'wait';
            this.treeGen.loadWMS(url);
        }
    },

    /**
     * Method: nodeClick
     * When a node is clicked on, its preview needs to be shown
     *
     * Parameters:
     * node - {<Ext.tree.TreeNode>} the node clicked on
     */
    nodeClick: function(node) {
        this.previewPanel.showPreview(node.attributes.wmsLayer);
    },

    /**
     * Method: addLayerToMap
     * Add the WMS layer to the main map
     */
    addLayerToMap: function () {
        if (this.previewPanel.currentLayer) {
            var layerExists = GeoNetwork.OGCUtil.layerExistsInMap(
                this.previewPanel.currentLayer, this.map);
            if (!layerExists) {
                this.previewPanel.currentLayer.events.on({"loadstart": function() {
                    this.isLoading = true;
                }});

                this.previewPanel.currentLayer.events.on({"loadend": function() {
                    this.isLoading = false;
                }});

                this.map.addLayers([this.previewPanel.currentLayer]);
            } else {
                Ext.MessageBox.alert("Information",
                   "Layer exists in map");
            }
        }
    }

});

Ext.reg('gn_wmsbrowserpanel', GeoNetwork.wms.BrowserPanel);


Ext.namespace('GeoNetwork');
GeoNetwork.BaseWindow = function(config) {
	Ext.apply(this, config);
	GeoNetwork.BaseWindow.superclass.constructor.call(this);
};

Ext.extend(GeoNetwork.BaseWindow, Ext.Window, {

	/**
	 * APIProperty: map
	 * {<OpenLayers.Map>}
	 */
	map: null,

	/**
	 * Method: init
	 *     Initialize this component.
	 */
	initComponent: function() {
		GeoNetwork.BaseWindow.superclass.initComponent.call(this);

		this.constrainHeader = true;
		this.collapsible = true;
		this.layout = 'fit';
		this.plain = true;
		this.stateful = false;
	}
});

GeoNetwork.AddWmsLayerWindow = function(config) {
	Ext.apply(this, config);
	GeoNetwork.AddWmsLayerWindow.superclass.constructor.call(this);
};

Ext.extend(GeoNetwork.AddWmsLayerWindow, GeoNetwork.BaseWindow, {

	/**
	 * Method: init
	 *     Initialize this component.
	 */
	initComponent: function() {
		GeoNetwork.AddWmsLayerWindow.superclass.initComponent.call(this);

		this.title = "Add WMS layer"
		
		
		this.width = 600;
		this.height = 500;

		var ds = new Ext.data.Store({
			data: GeoNetwork.WMSList,
			reader: new Ext.data.ArrayReader({}, [
				{name: 'title'},
				{name: 'url'}
			])
		});

		var tabs = new Ext.Panel({
			border: false,
			deferredRender: false,
			layout: 'fit',
		items: [	
			   {id: 'gn_wmsbrowserpanel', xtype: 'gn_wmsbrowserpanel', mode: GeoNetwork.wms.BrowserPanel.ADDWMS, wmsStore: ds, map: this.map}

		] }) ;

		this.add(tabs);

		this.doLayout();
	},

	setUrl: function(url) {
		Ext.getCmp("gn_wmsbrowserpanel").loadUrl(url);
	}
});

Ext.namespace('GeoNetwork');

/**
 * Class: GeoNetwork.SingletonWindowManager
 *      Singleton window manager for windows
 *
 */
GeoNetwork.SingletonWindowManager = function() {
    // private
    var windowsList = new Object();    // Associative array 
    var hiddenWindows = new Array();

    // public
    return {
        registerWindow: function(id, classz, configz) {
            var window1 = new classz(configz);

            windowsList[id] = {windowz: window1, classz: classz, configz: configz};
        },

        getWindow: function(id) {
            if (windowsList[id]) {
                return windowsList[id].windowz;
            } else {
                return null;
            }
        },

        showWindow: function(id) {
            if (windowsList[id]) {
                if (Ext.isEmpty(Ext.getCmp(id))) {
                	var w =  windowsList[id];

                    var ww = new w.classz(w.configz);

                    windowsList[id] = {windowz: ww, classz: w.classz, configz: w.configz};
                }
                windowsList[id].windowz.show();
                return true;
            } else {
                return false;
            }
        },

        hideAllWindows: function() {
            for(key in windowsList) {
                if (windowsList[key].windowz.isVisible()) {
                    windowsList[key].windowz.setVisible(false);
                    hiddenWindows[hiddenWindows.length] = key;
                }
            }                 
        },

        restoreHiddenWindows: function() {
			for (var index = 0, len = hiddenWindows.length; index < len; ++index) {
          		windowsList[hiddenWindows[index]].windowz.setVisible(true);
          	}
          	hiddenWindows = new Array();
        }


    };
};

GeoNetwork.WindowManager = new GeoNetwork.SingletonWindowManager();