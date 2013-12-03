CHM.Control.Legend.AbstractWindow = Ext.extend(Ext.Window, {
	
	tabPanel: null,
	
    initComponent : function() {
    	this.id = 'abstract-window';
    	
    	this.cls = 'csst-panel';
    	
    	this.tabPanel = new Ext.TabPanel();
    	
    	this.tabPanel.autoTabs = true;
    	
        this.tabPanel.activeTab = 0;
        
        this.tabPanel.enableTabScroll = true;
        
        this.tabPanel.deferredRender = false;
    	
    	this.tabPanel.border = false;
    	
    	this.items = [this.tabPanel];
    	
    	this.layout = 'fit';
    	
    	this.width = 500;
    	
    	this.height = 300;
    	
    	this.closeAction = 'hide';
    	
    	this.plain = true;
    	
    	this.buttons = [
        	{
        		text: 'Close', 
        		handler: function() {
        			this.hide();
        		},
        		scope: this
        	}
        ];
    	
    	CHM.Control.Legend.AbstractWindow.superclass.initComponent.call(this);
    },
    
    showAbstract: function(aLayer) {
		var cswurl = aLayer.metadataURL.split(showMetadata)[0] + csw;
		
		var fileidentifier = aLayer.metadataURL.split(showMetadata)[1];
		
		var tab = this.tabPanel.getItem(fileidentifier);
		
		if (tab != null) {
			this.tabPanel.setActiveTab(fileidentifier);
		} else {
			OpenLayers.Request.GET({
				url: cswServletUrl,
				callback: this.getHandler,
				params: 
		    	{
					cswUrl: cswurl,
					cswPassword: cswUsername,
		    		cswUserName: cswPassword,
		    		cswRecordFileIdentifier: fileidentifier
		    	},
		    	scope: this
			});
		}
    },
    
	getHandler: function (request) {
		if (request.status == 200) {
			var format = new CHM.Format.GetRecordByIdResponse();
			
            var metadata = format.read(request.responseText);
            
            this.tabPanel.add({
            	title: metadata.title,
            	html: '<h1>' + metadata.title + '</h1><p>' + metadata.abstractText + '</p>',
    	        closable: true,
    	        id: metadata.fileIdentifier
	        }).show();
		} else {

		};
	}
});
