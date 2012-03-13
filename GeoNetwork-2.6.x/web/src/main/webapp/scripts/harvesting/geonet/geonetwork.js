//=====================================================================================
//===
//=== Geonetwork controller
//===
//=====================================================================================

ker.include('harvesting/geonet/model.js');
ker.include('harvesting/geonet/view.js');

var gn = new Object();

//=====================================================================================

function Geonetwork(xmlLoader)
{
	//--- call super constructor
	Harvester.call(this);
	
	var loader= xmlLoader;
	var model = new gn.Model(loader);
	var view  = new gn.View(loader);
	
	//--- public methods
	
	this.addSearchRow    = view.addEmptySearch;
	this.removeSearchRow = view.removeSearch;
	this.getResultTip    = view.getResultTip;
	this.retrieveSources = retrieveSources;
    this.addGroupRow    = addGroupRow;
    this.removeGroupRow = view.removeGroupRow;
	
	this.model = model;
	this.view  = view;
	
//=====================================================================================
//===
//=== API methods
//===
//=====================================================================================

this.getType      = function() { return "geonetwork"; }
this.getLabel     = function() { return loader.eval("info[@type='geonetwork']/long"); }
this.getEditPanel = function() { return "gn.editPanel"; }

//=====================================================================================

this.init = function()
{
	this.view.init();

    model.retrieveGroups    (ker.wrap(this, init_groups_OK));
	model.retrieveCategories(ker.wrap(this, init_categ_OK));
	model.retrieveImportXslts     (ker.wrap(this, init_importXslts_OK));
}

//-------------------------------------------------------------------------------------

function init_categ_OK(data)
{
	view.clearCategories();
		
	for (var i=0; i<data.length; i++)
		view.addCategory(data[i].id, data[i].label[Env.lang]);				
}

//-------------------------------------------------------------------------------------

function init_importXslts_OK(data)
{
	view.clearImportXslt();
	
	view.addImportXslt('none','--None--');
	for (var i=0; i<data.length; i++) {
		view.addImportXslt(data[i].id,data[i].name);				
	}
}

//=====================================================================================

function retrieveSources()
{
	var data = view.getHostData();
	
	if (data.HOST == '')
		alert(loader.getText('supplyHost'));
		
	else if (data.SERVLET == '')
		alert(loader.getText('supplyServlet'));
		
	else
		model.retrieveSources(data, ker.wrap(view, view.setSources));
}

//=====================================================================================

function init_groups_OK(data)
{
    view.clearGroups();

    for (var i=0; i<data.length; i++)
        view.addGroup(data[i].id, data[i].label[Env.lang]);
}


//-------------------------------------------------------------------------------------

function existsGroup(name, data)
{
	for (var i=0; i<data.length; i++)
		if (name == data[i].name)
			return true;
	
	return false;
}

//=====================================================================================

function addGroupRow()
{
    var groups = view.getSelectedGroups();

    if (groups.length == 0) alert(loader.getText('pleaseSelectGroup'));
    else						view.addEmptyGroupRows(groups);
}


//=====================================================================================
}


