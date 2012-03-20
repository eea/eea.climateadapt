CHM.WMSLegend = Ext.extend(GeoExt.WMSLegend, {
	
    initComponent: function() {
        CHM.WMSLegend.superclass.initComponent.call(this);
    },
    
    update: function() {
        if (this.layerRecord != null && this.items.getCount() > 0) {
            var layer = this.layerRecord.getLayer();
            this.setVisible(layer.getVisibility() &&
                layer.calculateInRange() && layer.displayInLayerSwitcher &&
                !this.layerRecord.get('hideInLegend'));
        }
        CHM.WMSLegend.superclass.update.call(this);
    },
    
    getLegendUrl: function(layerName, layerNames) {
        var layer = this.layerRecord.getLayer();

        var url = layer.getFullRequestString({
            REQUEST: "GetLegendGraphic",
            EXCEPTIONS: "application/vnd.ogc.se_xml",
            LAYER: layer.params.LAYERS,
            FORMAT: "image/png"
        });
        
        console.log(url);
        
        return url;
    }
});

GeoExt.LayerLegend.types["chm_wmslegend"] = CHM.WMSLegend;

/** api: xtype = gx_wmslegend */
Ext.reg('chm_wmslegend', CHM.WMSLegend);

