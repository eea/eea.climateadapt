CHM.Control.Options.OptionsControl = Ext.extend(Ext.Panel, {
	
	options: 'Display Options',
	
	optionsLabel: null,
	
	risk: 'Climate Impacts:',
	
	riskLabel: null,
	
	riskSelect: null,
	
	sector: 'Adaptation Sectors:',
	
	sectorLabel: null,
	
	sectorSelect: null,
	
    initComponent : function() {
    	this.layout = 'anchor';
    	
    	this.optionsLabel = new Ext.form.Label({html: '<h1 class="portlet-title"><span class="portlet-title-text">' + this.options + '</span></h1>'});
    	
    	this.riskLabel = new Ext.form.Label({text: this.risk});
    	
    	this.riskSelect = new Ext.form.ComboBox({
    	    typeAhead: true,
    	    triggerAction: 'all',
    	    transform:'riskSelect',
    	    forceSelection: true,
    	    anchor: '100%'
    	});
    	
    	this.riskSelect.addListener('select', this.handleRiskSelect, this);
    	
    	this.sectorLabel = new Ext.form.Label({text: this.sector});
    	
    	this.sectorSelect = new Ext.form.ComboBox({
    	    typeAhead: true,
    	    triggerAction: 'all',
    	    transform:'sectorSelect',
    	    forceSelection: true,
    	    anchor: '100%'    	
    	});
    	
    	this.sectorSelect.addListener('select', this.handleSectorSelect, this);
    	
    	this.border = false;
    	
    	this.items = [this.optionsLabel, this.riskLabel, this.riskSelect, this.sectorLabel, this.sectorSelect];
    	
    	CHM.Control.Options.OptionsControl.superclass.initComponent.call(this);
    },
    
    applicationInitialized: function() {
        this.handleRiskSelect(null, null, null);
    	
        this.handleSectorSelect(null, null, null);
    },
    
	handleRiskSelect: function(combo, record, index) {
		var risk = this.riskSelect.getValue();
		
		session.setRisk(risk);
    },
    
	handleSectorSelect: function(combo, record, index) {
		var sector = this.sectorSelect.getValue();
		
		session.setSector(sector);
	} 
});
