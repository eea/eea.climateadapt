<%
/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ page import="com.liferay.portal.util.PortalUtil" %>

<portlet:defineObjects />

<%
HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(request);
%>
This is the <b>Ace map portlet</b> portlet.

<div>
    <div id="acemap_column" style="margin-right: 10px; margin-top: 50px; float:left">
    <script defer="defer" type="text/javascript">
    
    
Ext.onReady(function() {
    Ext.QuickTips.init();

	OpenLayers.ProxyHost = '<%= request.getContextPath() %>/proxy?url=';

    var map = new OpenLayers.Map();
    var base = new OpenLayers.Layer.WMS(
        "Global Imagery",
        "http://maps.opengeo.org/geowebcache/service/wms",
        {layers: "bluemarble", format: 'image/png', transparent: 'true'}, {'isBaseLayer':true}
    );
    var dominantLandUse = new OpenLayers.Layer.WMS(
        "Dominant Land Use",
        "http://eusoils.jrc.ec.europa.eu/wrb/wms_Landuse.asp?",
        {layers: "USEDO", format: 'image/png', transparent: 'true'}
    );
    var waterManagementPresence = new OpenLayers.Layer.WMS(
        "Presence of Water Management System",
        "http://eusoils.jrc.ec.europa.eu/WRB/WMS_Water.asp?",
        {layers: "WM1", format: 'image/png', transparent: 'true'}
    );
	var vector = new OpenLayers.Layer.Vector("vector", {'displayInLayerSwitcher':false});	
	map.addLayers([base, dominantLandUse, waterManagementPresence, vector]);
	//map.addControl(new OpenLayers.Control.LayerSwitcher());
    
    var ctrl, toolbarItems = [], action, actions = {};

    // ZoomToMaxExtent control, a "button" control
    action = new GeoExt.Action({
        control: new OpenLayers.Control.ZoomToMaxExtent(),
        map: map,
        text: "max extent",
        tooltip: "zoom to max extent"
    });
    actions["max_extent"] = action;
    toolbarItems.push(action);
    toolbarItems.push("-");

    // Navigation control and DrawFeature controls
    // in the same toggle group
    action = new GeoExt.Action({
        text: "nav",
        control: new OpenLayers.Control.Navigation(),
        map: map,
        // button options
        toggleGroup: "draw",
        allowDepress: false,
        pressed: true,
        tooltip: "navigate",
        // check item options
        group: "draw",
        checked: true
    });
    actions["nav"] = action;
    toolbarItems.push(action);

	/* 
		draw polygon menu 
    action = new GeoExt.Action({
        text: "draw poly",
        control: new OpenLayers.Control.DrawFeature(
            vector, OpenLayers.Handler.Polygon
        ),
        map: map,
        // button options
        toggleGroup: "draw",
        allowDepress: false,
        tooltip: "draw polygon",
        // check item options
        group: "draw"
    });
    actions["draw_poly"] = action;
    toolbarItems.push(action);
    */
	
	/*
	  draw line menu
	  
    action = new GeoExt.Action({
        text: "draw line",
        control: new OpenLayers.Control.DrawFeature(
            vector, OpenLayers.Handler.Path
        ),
        map: map,
        // button options
        toggleGroup: "draw",
        allowDepress: false,
        tooltip: "draw line",
        // check item options
        group: "draw"
    });
    actions["draw_line"] = action;
    toolbarItems.push(action);
    toolbarItems.push("-");
	*/
	
    /*
   	   SelectFeature control, a "toggle" control
    
	action = new GeoExt.Action({
        text: "select",
        control: new OpenLayers.Control.SelectFeature(vector, {
            type: OpenLayers.Control.TYPE_TOGGLE,
            hover: true
        }),
        map: map,
        // button options
        enableToggle: true,
        tooltip: "select feature"
    });
    actions["select"] = action;
    toolbarItems.push(action);
    toolbarItems.push("-");
	
	*/

    // Navigation history - two "button" controls
    ctrl = new OpenLayers.Control.NavigationHistory();
    map.addControl(ctrl);

    action = new GeoExt.Action({
        text: "previous",
        control: ctrl.previous,
        disabled: true,
        tooltip: "previous in history"
    });
    actions["previous"] = action;
    toolbarItems.push(action);

    action = new GeoExt.Action({
        text: "next",
        control: ctrl.next,
        disabled: true,
        tooltip: "next in history"
    });
    actions["next"] = action;
    toolbarItems.push(action);
    toolbarItems.push("->");

	/*
    // Reuse the GeoExt.Action objects created above
    // as menu items
    toolbarItems.push({
        text: "menu",
        menu: new Ext.menu.Menu({
            items: [
                // ZoomToMaxExtent
                actions["max_extent"],
                // Nav
                new Ext.menu.CheckItem(actions["nav"]),
                // Draw poly
                new Ext.menu.CheckItem(actions["draw_poly"]),
                // Draw line
                new Ext.menu.CheckItem(actions["draw_line"]),
                // Select control
                new Ext.menu.CheckItem(actions["select"]),
                // Navigation history control
                actions["previous"],
                actions["next"]
            ]
        })
    });
	*/

    var mapPanel = new GeoExt.MapPanel({
        renderTo: "mappanel",
        height: 500,
        width: 900,
        map: map,
        center: new OpenLayers.LonLat(10, 52),
        zoom: 4,
        tbar: toolbarItems
    });
	
    // create our own layer node UI class, using the TreeNodeUIEventMixin
    var LayerNodeUI = Ext.extend(GeoExt.tree.LayerNodeUI, new GeoExt.tree.TreeNodeUIEventMixin());
        
    // using OpenLayers.Format.JSON to create a nice formatted string of the
    // configuration for editing it in the UI
    var treeConfig = new OpenLayers.Format.JSON().write([{
        nodeType: "gx_baselayercontainer"
    }, {
        nodeType: "gx_overlaylayercontainer",
        expanded: true,
        // render the nodes inside this container with a radio button,
        // and assign them the group "foo".
        loader: {
            baseAttrs: {
                radioGroup: "foo",
                uiProvider: "layernodeui"
            }
        }
    }], true);

    // create the tree with the configuration from above
    tree = new Ext.tree.TreePanel({
		renderTo: 'tree',
        border: true,
        region: "west",
        title: "Layers",
        width: 200,
		height: 500,
        split: true,
        collapsible: false,
        collapseMode: "mini",
        autoScroll: true,
        /*
		  plugins: [
           new GeoExt.plugins.TreeNodeRadioButton({
                listeners: {
                    "radiochange": function(node) {
                        alert(node.text + " is now the active layer.");
                    }
                }
            })
        ],
		*/
        loader: new Ext.tree.TreeLoader({
            // applyLoader has to be set to false to not interfer with loaders
            // of nodes further down the tree hierarchy
            applyLoader: false,
            uiProviders: {
                "layernodeui": LayerNodeUI
            }
        }),
		
        root: {
            nodeType: "async",
            // the children property of an Ext.tree.AsyncTreeNode is used to
            // provide an initial set of layer nodes. We use the treeConfig
            // from above, that we created with OpenLayers.Format.JSON.write.
            children: Ext.decode(treeConfig)
        },
        listeners: {
            "radiochange": function(node){
                alert(node.layer.name + " is now the the active layer.");
            }
        },
        rootVisible: false,
        lines: false,
        bbar: [{
            text: "Add layers",
            handler: function() {
            	
            	 GeoNetwork.WindowManager.showWindow("addwms");    
            }
        }]
    });
    
    GeoNetwork.WindowManager.registerWindow("addwms", GeoNetwork.AddWmsLayerWindow, {map: map, id:"addwms"});
	
});		
				
            </script>
			<div style="width: 1100px; overflow-x: scroll">
				<div id="tree" style="float:left;"></div>
				<div id="mappanel" style="float:left;"></div>
			</div>
			
            </div>
    </div>
	
</div>	