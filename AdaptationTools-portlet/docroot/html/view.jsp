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
    <div id="acemap_column" style="margin-right: 10px; margin-top: 50px; float:left;border:solid 1px red;width:850px;">
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
        height: 400,
        width: 400,
        map: map,
        center: new OpenLayers.LonLat(7, 44),
        zoom: 8,
        tbar: toolbarItems
    });
    
	
});		
				
            </script>
			
	<h1 id="adaptationtools-heading">
		Am I vulnerable to climate change and what are my risks
	</h1>
	
	<div id="adaptationtools-selectors-top">
		<div id="risks-selector" class="adaptationtools-selector">
			<select>
				<option>Water scarcity</option>
				<option>Droughts</option>
				<option>Flooding</option>
			</select>
			<div class="info-button">
				i
			</div>	
		</div>		
		<div id="sector-selector"  class="adaptationtools-selector">
			<span style="margin-right:30px;">
				Filter by sector
			</span>
			<select>
				<option>all</option>
				<option>Water management</option>
				<option>Agriculture & forest</option>
				<option>Health</option>
			</select>				
			<div class="info-button">
				i
			</div>
		</div>
	</div>
	
	<hr style="clear:both;display:block;visibility:hidden;"></hr>

	<div id="adaptationtools-map">
		<div id="tree" style="float:left;"></div>
		<div id="mappanel" style="float:left;"></div>
	</div>
			
	<div id="adaptationtools-indicators">
		<h2>
			Indicators
		</h2>
		
		<div id="indicator-climate-changes" class="indicator-category">
			<div class="info-button">
				i
			</div>
			<h3 class="indicator-category-title">
				Climate changes
			</h3>
		</div>
				
		<div id="indicator-exposure" class="indicator-category">
			<div class="info-button">
				i
			</div>
			<h3 class="indicator-category-title">
				Exposure
			</h3>
		</div>
				
		<div id="indicator-sensitivity" class="indicator-category">
			<div class="info-button">
				i
			</div>
			<h3 class="indicator-category-title">
				Sensitivity
			</h3>					
		</div>
		
		<div id="indicator-vulnerability" class="indicator-category">
			<div class="info-button">
				i
			</div>
			<h3 class="indicator-category-title">
				Vulnerability & risks
			</h3>					
		</div>
				
		<div id="indicator-human-causes" class="indicator-category">
			<div class="info-button">
				i
			</div>
			<h3 class="indicator-category-title">
				Underlying human causes
			</h3>					
		</div>
				
	</div>
						

	<!-- acemap_column -->
    </div>
<!-- outer div -->	
</div>	