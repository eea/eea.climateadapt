CHM.MapControl = Ext.extend(GeoExt.MapPanel, {
	
	map: null,
	
	mapLoadingPanel: null,
	
    initComponent : function() {
    	this.border = true;
    	
    	this.map = new CHM.SATCHMMap();
    	
    	this.renderTo = 'map_element';
		
		this.height = document.getElementById(this.renderTo).offsetHeight;
		
		this.width = document.getElementById(this.renderTo).offsetWidth;
		
		// this.mapLoadingPanel = new Geoportal.Components.MapLoadingPanel();
		
		// this.mapLoadingPanel.setMap(this.map);
    	
    	this.addListener('resize', this.handleResize, this);
    	
    	CHM.MapControl.superclass.initComponent.call(this);
    },
    
    addLayers: function() {
		this.map.addBingLayers();

		this.map.addSATLayers();
    },
    
    handleResize: function() {
    	this.map.setOffsetX(this.getPosition()[0]);
    	
    	this.map.setOffsetY(this.getPosition()[1]);
    }
});
