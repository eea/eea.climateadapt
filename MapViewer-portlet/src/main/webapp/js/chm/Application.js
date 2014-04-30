CHM.Application = Ext.extend(Ext.Panel,  {
	
	margin: 20,
	
	titleControl: null,
	
	mapControl: null,
	
	tocControl: null,
	
	help: 'The map viewer contains projections of climate change impacts, vulnerability and risks from the following projects and organisations:  <a href="http://www.climwatadapt.eu/">ClimWatAdapt</a>, <a href="http://www.espon.eu/main/Menu_Projects/Menu_AppliedResearch/climate.html">ESPON Climate</a>, <a href="http://ies.jrc.ec.europa.eu/">JRC-IES</a> and <a href="http://ensembles-eu.metoffice.com/">ENSEMBLES</a>. Please note that there are differences in the climate change scenarios and models used across these projects and organisations. It is important to read the abstract and the detailed metadata for each of map and for more details to access documents of the data providers. See also the pages on \'<a href="/observations-and-scenarios">observations and scenarios</a>\' and \'<a href="/vulnerabilities-and-risks">vulnerabilities and risks</a>\'.',
	
	helpButton: null,
	
    initComponent : function() {
    	Ext.QuickTips.init();
    	
    	this.renderTo = 'mapviewer_element';
		
		this.height = document.getElementById(this.renderTo).offsetHeight;
		
		this.width = document.getElementById(this.renderTo).offsetWidth;
		
		this.border = false;
    	
		this.layout = 'absolute';
		
		this.addEvents('creationComplete');
    	
		this.titleControl = new Ext.form.Label();
		
		this.titleControl.html = '<h1 class="portlet-title"><span class="portlet-title-text">Map Viewer</span></h1>';
		
		var helptooltip = new Ext.ToolTip({   
			title: 'About this map viewer',
			id: '',
            anchor: 'left',
            text: this.help,
            width: 415,
            autoHide: false,
            closable: true,
            listeners: {
                'render': function(){
                    this.header.on('click', function(e){
                        e.stopEvent();
                    }, this, {delegate:'a'});
                }
            }
		});
		
    	this.helpButton = new Ext.Button({iconCls: 'x-help', tooltip: helptooltip, id: 'help-button', disabled: false});
    	
    	var panel = new Ext.Panel({x: this.margin, y: this.margin, border: false, id: 'mapviewer-title-help', items: [this.titleControl, {xtype: 'label', html: '&nbsp;'}, this.helpButton], layout: 'column'});
		
    	this.mapControl = new CHM.Control.Map.MapControl({layers: [], width: this.width / 4 * 3 - (this.margin * 1.5), height: this.height / 8 * 4 - (this.margin / 2) - (this.margin / 2), x: this.margin, y: this.height / 8 * 1 + (this.margin / 2)});
    	
    	this.tocControl = new CHM.Control.TOC.TOCControl({mapControl: this.mapControl, width: this.width / 4 * 1 - (this.margin / 2) - this.margin, x: this.width / 4 * 3 + (this.margin / 2), y: this.height / 8 * 1 + (this.margin / 2)});
    	
		this.defaults = {collapsible : false, split : true};

		this.items = [panel, this.mapControl, this.tocControl];
    	
    	CHM.Application.superclass.initComponent.call(this);
    	
    	this.addListener('afterrender', this.handleAfterRender, this);
    }, 

	handleAfterRender: function() {
		this.removeListener('afterrender', this.handleAfterRender, this);
		
		this.mapControl.addListener('creationComplete', this.handleMapControlCreationComplete, this);
		
		this.mapControl.applicationInitialized();
		
		this.helpButton.x = this.margin + this.titleControl.getWidth() + this.margin;
	},
	
	handleMapControlCreationComplete: function() {
		this.mapControl.removeListener('creationComplete', this.handleMapControlCreationComplete, this);
		
		this.fireEvent('creationComplete');
	},
	
	addLayer: function(aLayer) {
		this.mapControl.addLayer(aLayer);
	}
});
Ext.reg('application', CHM.Application);
