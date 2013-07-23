CHM.Control.Grid.GridControl = Ext.extend(Ext.Panel, {

	searchResults: 'Case Study Search Results',
	
	searchResultsLabel: null,
	
	searchResultsPanel: null,
	
	spacer: null,
	
	similarAreasGridPanel : null,

	dissimilarAreasGridPanel : null,

	initComponent : function() {
    	this.id = 'csst-grid';
    	
    	this.cls = 'csst-panel';
    	
		this.layout = 'anchor';

		this.frame = false;
		
    	this.border = false;
    	
		this.searchResultsLabel = new Ext.form.Label({
			html: '<h1 class="portlet-title"><span class="portlet-title-text">' + this.searchResults + '</span></h1>'
		});
		
		this.searchResultsPanel = new Ext.Panel({
			anchor : '100% 10%',
			border: false,
			items: [this.searchResultsLabel]
		});

		this.similarAreasGridPanel = new Ext.grid.GridPanel({
			ref : 'similarAreasFeatureGrid',
			frame : false,
	    	border: true,
			sm : new GeoExt.grid.FeatureSelectionModel(),
			cm : this.createSimilarAreaColumnModel(),
			store : this.createStore(),
			autoExpandColumn : 'itemname',
			anchor : '100% 45%',
			hideHeaders : true
		});
		
		this.spacer = new Ext.Spacer({anchor: '100% 1%'});

		this.dissimilarAreasGridPanel = new Ext.grid.GridPanel({
			ref : 'dissimilarAreasFeatureGrid',
			frame : false,
	    	border: true,
			sm : new GeoExt.grid.FeatureSelectionModel(),
			cm : this.createDissimilarAreaColumnModel(),
			store : this.createStore(),
			autoExpandColumn : 'itemname',
			anchor : '100% 44%',
			hideHeaders : true
		});

		this.items = [ this.searchResultsPanel, this.similarAreasGridPanel, this.spacer, this.dissimilarAreasGridPanel ];

		CHM.Control.Grid.GridControl.superclass.initComponent.call(this);
	},

	createSimilarAreaColumnModel : function() {
		var result = new Ext.grid.ColumnModel({
			defaults : {
				sortable : true
			},
			columns : [
					{
						id : 'measureid',
						name : 'measureid',
						header : '',
						dataIndex : 'measureid',
						width: 24,
						renderer : function(value, metaData, record, rowIndex,
								colIndex, store) {
							return '<img src="' + root
									+ 'js/chm/markers/similar_fit.png'
									+ '" alt="Case study in similar area"/>';
						}
					}, {
						id : 'itemname',
						name : 'itemname',
						header : 'Name',
						dataIndex : 'itemname'
					} ],
		});

		return result;
	},

	createDissimilarAreaColumnModel : function() {
		var result = new Ext.grid.ColumnModel({
			defaults : {
				sortable : true
			},
			columns : [
					{
						id : 'measureid',
						name : 'measureid',
						header : '',
						dataIndex : 'measureid',
						width: 24,
						renderer : function(value, metaData, record, rowIndex,
								colIndex, store) {
							return '<img src="' + root
									+ 'js/chm/markers/dissimilar_fit.png'
									+ '" alt="Case study in other area"/>';
						}
					}, {
						id : 'itemname',
						name : 'itemname',
						header : 'Name',
						dataIndex : 'itemname'
					} ],
		});

		return result;
	},

	createStore : function() {
		var result = new GeoExt.data.FeatureStore({
			fields : [ {
				id : 'measureid',
				name : 'measureid',
				type : 'string'
			}, {
				id : 'itemname',
				name : 'itemname',
				type : 'string'
			} ],
			proxy : new Ext.data.MemoryProxy(),
			autoLoad : false
		});

		return result;
	},

	format : function(value) {
		console.log(value);

		return value;
	},

	applicationInitialized : function() {
		this.similarAreasGridPanel.store
				.bind(session.similarAreasCasestudiesVector);

		this.similarAreasGridPanel.getSelectionModel().bind(
				session.selectFeatureControl);

		this.dissimilarAreasGridPanel.store
				.bind(session.dissimilarAreasCasestudiesVector);

		this.dissimilarAreasGridPanel.getSelectionModel().bind(
				session.selectFeatureControl);
	}
});
