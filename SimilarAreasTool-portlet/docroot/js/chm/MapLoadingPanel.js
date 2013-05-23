CHM.MapLoadingPanel = Ext.extend(Ext.Panel, {
	map: null,
	
	count: null,
	
	// layers: null,
	
	progressBar: null,
	
	initComponent: function() {
    	Ext.QuickTips.init();
    	
    	// this.layers = new Array();
    	
    	this.layout = 'absolute';
		
		this.width = 150;
		
		this.height = 60;
		
		this.title = 'Loading...';
		
		this.progressBar = new Ext.ProgressBar({});
		
		this.items = [];
    	
    	this.setCount(0);
    	
		Geoportal.Components.MapLoadingPanel.superclass.initComponent.call(this);
	}, 
	
    addToMapPanel: function(panel) {
        this.on({
            render: function() {
                var el = this.getEl();
                el.setStyle({
                    position: "absolute",
                    zIndex: panel.map.Z_INDEX_BASE.Control
                });
                el.on({
                    mousedown: this.stopMouseEvents,
                    click: this.stopMouseEvents
                });
            },
            scope: this
        });
    },
    
    removeFromMapPanel: function(panel) {
        var el = this.getEl();
        el.un({
            mousedown: this.stopMouseEvents,
            click: this.stopMouseEvents,
            scope: this
        });
    },
    
	setMap: function(aMap) {
		this.map = aMap;

		this.map.events.register('preaddlayer', this, this.handlePreAddLayer);
		
		this.map.events.register('removelayer', this, this.handleRemoveLayer);
		
		for (var i = 0; i < this.map.layers.length; i++) {
			var layer = this.map.layers[i];
			
			layer.events.register('loadstart', this, this.increaseCounter);
			
			layer.events.register('loadend', this, this.decreaseCounter);
		}
	},

	handlePreAddLayer: function(aEvent) {
		if (aEvent.layer) {
			aEvent.layer.events.register('loadstart', this, this.handleLoadStart);
			
			aEvent.layer.events.register('loadend', this, this.handleLoadEnd);
		}
	},

	handleRemoveLayer: function(aEvent) {
		if (aEvent.layer) {
			aEvent.layer.events.unregister('loadstart', this, this.handleLoadStart);
			
			aEvent.layer.events.unregister('loadend', this, this.handleLoadEnd);
		}
	},
	
	handleLoadStart: function(aEvent) {
//		if (aEvent.layer) {
//			this.layers.push(aEvent.layer);
//		}
		
		this.setCount(this.count + 1);
	},
	
	handleLoadEnd: function(aEvent) {
//		if (aEvent.layer) {
//			var index = array.indexOf(aEvent.layer);
//			
//			if (index != -1) {
//				array.splice(index, 1);
//			}
//		}
		
		this.setCount(this.count - 1);
	},

	setCount: function(aCount) {
		this.count = aCount;
		
		if (this.count == 0) {
			this.progressBar.reset();
			
			this.hide();
		} else {
			this.progressBar.wait({text: 'Loading...'});
			
			this.show();
		}
	}
});