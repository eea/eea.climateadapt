CHM.Control.Locator.LocatorControl = Ext.extend(Ext.Panel, {
	
	address: 'Address',
	
	location: 'Enter location...',
	
	locate: 'Locate',
	
	panel: null,
	
	button: null,
	
	locationTextField: null,
	
	spacer: null,
	
	candidatesColumnModel: null,
	
	candidatesSelectionModel: null,
	
	candidatesPanel: null,
	
    initComponent : function() {
    	this.layout = 'anchor';
    	
    	this.border = false;
    	
    	this.locationTextField = new Ext.form.TextField({anchor: '100%', enableKeyEvents: true, value: this.location});
    	
    	this.locationTextField.addListener('keyup', this.handleLocationTextFieldKeyUp, this);
    	
    	this.locationTextField.addListener('focus', this.focus, this);
    	
    	this.button = new Ext.Button({text: this.locate});
    	
    	this.panel = new Ext.Panel({anchor: '100%', items: [this.locationTextField, this.button], layout: 'absolute'});
    	
    	this.panel.addListener('resize', this.resize, this);
    	
    	this.spacer = new Ext.Spacer({height: 2});
    	
	    this.candidatesColumnModel = new Ext.grid.ColumnModel({
	        defaults: {sortable: true},
	        columns: [
  	            {id: 'address', header: this.address, dataIndex: 'address'}
	        ]
	    });
	    
	    this.candidatesSelectionModel = new Ext.grid.RowSelectionModel();
	    
	    this.candidatesSelectionModel.addListener('rowselect', this.handleRowSelect, this);
	    
    	this.candidatesPanel = new Ext.grid.GridPanel({
    		anchor: '100%',
   	    	border: false,
   	    	cm: this.candidatesColumnModel,
   	    	store: session.candidatesStore,
            sm: this.candidatesSelectionModel,
            autoExpandColumn: 'address',
            border: true,
            hideHeaders: true
   	    });
    	
    	this.locator = new CHM.Control.Locator.Locator();
    	
    	this.items = [this.panel, this.spacer, this.candidatesPanel];
    	
    	CHM.Control.Locator.LocatorControl.superclass.initComponent.call(this);
    },
    
    resize: function() {
    	var h = this.getHeight();
    	
    	h = h - this.panel.getHeight() - this.spacer.getHeight();
    	
    	this.candidatesPanel.setHeight(h);
    	
    	var buttonx = this.panel.getWidth() - this.button.getHeight();
    	
    	var buttony = 0;
    	
    	this.button.setPosition(buttonx, buttony);
    }, 
    
    focus: function() {
    	this.locationTextField.setValue("");
    }, 
    
    handleRowSelect: function(aSelectionModel, aRowIndex, aRecord) {
    	session.setLocation(new CHM.Location(aRecord.get('x'), aRecord.get('y'), new OpenLayers.Projection('EPSG:4326')));
    }, 
    
    applicationInitialized: function() {

    },
    
    handleLocationTextFieldKeyUp: function(field, e) {
        var k = e.getKey();
        
        if (k == e.RETURN) {
            e.stopEvent();
            
            this.locator.locate(this.locationTextField.getValue());
        } 
	} 
});
