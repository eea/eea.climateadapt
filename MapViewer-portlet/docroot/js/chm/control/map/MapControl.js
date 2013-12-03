CHM.Control.Map.MapControl = Ext.extend(GeoExt.MapPanel, {
	
	map: null,
	
    initComponent : function() {
    	this.id = 'mapviewer-map';
    	
    	this.cls = 'mapviewer-panel';
    	
    	this.border = false;
    	
    	this.addEvents('creationComplete');
    	
    	this.map = new CHM.Control.Map.Map();
    	
    	CHM.Control.Map.MapControl.superclass.initComponent.call(this);
    },
    
    applicationInitialized: function() {
    	this.map.events.register('restoreComplete', this, this.handleMapOnRestoreComplete);
    	
    	this.map.restoreMapState();
    },
    
    handleMapOnRestoreComplete: function(event) {
    	this.map.events.unregister('restoreComplete', this, this.handleMapOnRestoreComplete);
    	
		this.fireEvent('creationComplete');
    },
	
    addLayer: function(aLayer) {
    	this.map.addLayer(aLayer);
    }
});
