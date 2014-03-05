CHM.Control.Legend.WMSLegend = Ext.extend(GeoExt.WMSLegend, {
	
    initComponent: function() {
        CHM.Control.Legend.WMSLegend.superclass.initComponent.call(this);
    },
    
    update: function() {
        if (this.layerRecord != null && this.items.getCount() > 0) {
            var layer = this.layerRecord.getLayer();
            this.setVisible(layer.getVisibility() &&
                layer.calculateInRange() && layer.displayInLayerSwitcher &&
                !this.layerRecord.get('hideInLegend'));
        }
        CHM.Control.Legend.WMSLegend.superclass.update.call(this);
    },
});

GeoExt.LayerLegend.types["chm_wmslegend"] = CHM.Control.Legend.WMSLegend;

/** api: xtype = gx_wmslegend */
Ext.reg('chm_wmslegend', CHM.Control.Legend.WMSLegend);