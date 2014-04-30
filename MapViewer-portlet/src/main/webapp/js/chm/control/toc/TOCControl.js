CHM.Control.TOC.TOCControl = Ext.extend(Ext.Panel, {
	
	mapControl: null, 
	
	titleControl: null,
	
	legendControl: null,

	initComponent : function() {
		this.id = 'mapviewer-toc-control';
		
    	this.border = false;
    	
		this.titleControl = new Ext.form.Label();
		
		this.titleControl.html = '<h3 id="toc-title">Table of contents</h3>';
		
    	this.legendControl = new CHM.Control.Legend.LegendControl({mapControl: this.mapControl});
    	
    	this.items = [this.titleControl, this.legendControl];
    	
    	CHM.Control.TOC.TOCControl.superclass.initComponent.call(this);
    },
    
    applicationInitialized: function() {
    	
    }
});
