CHM.SATVector = OpenLayers.Class(OpenLayers.Layer.Vector, {
	
	protocol: null,
	
	type: null, 
	
	marker: null, 
	
	radius: null,
	
	area: null,
	
	risk: null,
	
	sector: null,
	
	tooltip: null,
	
	offsetX: null,
	
	offsetY: null,
	
	initialize: function(options) {
		OpenLayers.Layer.Vector.prototype.initialize.apply(this, arguments);
		
        protocol = new OpenLayers.Protocol.WFS({
	       	version: '1.1.0',
			url:  proxyUrl + geoserverUrl + wfs + '?', 
	        featureType: caseStudiesFeatureType,
	        featureNS: featureNamespace,
	        geometryName: geometryColumn,
	        srsName: 'EPSG:900913'
        });
        
        this.styleMap = new OpenLayers.StyleMap({
	        "default": new OpenLayers.Style({
		        pointRadius: this.radius, 
		        graphicZIndex: 1,
		        externalGraphic: this.marker
	        }),
	        "select": new OpenLayers.Style({
		        pointRadius: this.radius, 
		        graphicZIndex: 1,
		        externalGraphic: this.marker
	        })
        });
        
        this.events.register('featureselected', this, this.handleFeatureSelected);
        
        if ((typeof Range !== "undefined") && !Range.prototype.createContextualFragment)
        {
        	Range.prototype.createContextualFragment = function(html)
        	{
        		var frag = document.createDocumentFragment(), 
        		div = document.createElement("div");
        		frag.appendChild(div);
        		div.outerHTML = html;
        		return frag;
        	};
        }        
	},
	
	handleFeatureSelected: function(event) {
	    Ext.QuickTips.init();
	    
		if (this.tooltip != null) {
			this.tooltip.destroy();
		}
		
	    var description = event.feature.attributes.desc;
		
		if (description == undefined) {
			description = '';
		}
		
		pixel = this.map.getViewPortPxFromLonLat(event.feature.geometry.getBounds().getCenterLonLat());
        
		this.tooltip = new Ext.ToolTip({        
            title: '<a href="#">' + event.feature.attributes.itemname + '</a>',
            anchor: 'left',
            html: "<table width='100%' border='0'>" +
            "<tr><th>" + event.feature.attributes.itemname + "</th></tr>" + 
            "<tr><td>" + description + "</td></tr>" + 
            "<tr><td><a href='/viewmeasure?ace_measure_id=" + event.feature.attributes.measureid + "' target='_blank'>read more</a></td></tr>" + 
            "</table>",
            width: 415,
            autoHide: false,
            closable: true,
            listeners: {
                'render': function(){
                    this.header.on('click', function(e){
                        e.stopEvent();
                        // Ext.Msg.alert('Link', 'Link to something interesting.');
                        // Ext.getCmp('content-anchor-tip').hide();
                    }, this, {delegate:'a'});
                }
            }
        });
        
		this.tooltip.showAt([pixel.x + this.offsetX, pixel.y + this.offsetY]);
        
		return true;
	},
	
	setArea : function(aArea) {
		this.area = aArea;
		
		this.applyFilters();
	},
	
	setRisk : function(aRisk) {
		this.risk = aRisk;
		
		this.applyFilters();
	},
	
	setSector : function(aSector) {
		this.sector = aSector;
		
		this.applyFilters();
	},
	
	applyFilters : function() {
        this.removeAllFeatures();
     	
		var filters = new Array();
		
		var areafilter = null;
		
		if (this.area != null) {
			areafilter = this.createFilter(this.type, areaColumn, this.area);
			
			filters.push(areafilter);
		}
		
		var riskfilter = null;
			
		if (this.risk != "ALL" && this.risk != null) {
			riskfilter = this.createFilter(OpenLayers.Filter.Comparison.LIKE, 'risks', '*' + this.risk + '*');
				
			filters.push(riskfilter);
		}
		
		var sectorfilter = null;
			
		if (this.sector != "ALL" && this.sector != null) {
			sectorfilter = this.createFilter(OpenLayers.Filter.Comparison.LIKE, 'sectors', '*' + this.sector + '*');
				
			filters.push(sectorfilter);
		}
		
		var filter = new OpenLayers.Filter.Logical({
			type: OpenLayers.Filter.Logical.AND,
			filters: filters
		});
			
		if (areafilter != null) {
		    this.read(filter);
		} else if (areafilter == null && (riskfilter != null || sectorfilter != null)) {
			if (this.type == OpenLayers.Filter.Comparison.NOT_EQUAL_TO) {
				this.read(filter);
			}
		} else {
			if (this.type == OpenLayers.Filter.Comparison.NOT_EQUAL_TO) {
				this.read(null);
			}
		}
	}, 
	
	read: function(aFilter) {
		if (aFilter == null) {
			protocol.read({
				callback: function(result) {
					if(result.success()) {
						if(result.features.length) {
							this.addFeatures(result.features);
						}
					}
				},
				scope: this
			});
		} else {
	        protocol.read({
	            filter: aFilter,
	            callback: function(result) {
	                if(result.success()) {
	                    if(result.features.length) {
	                    	this.addFeatures(result.features);
	                    }
	                }
	            },
	            scope: this
	        });
		}
	},
		
	createFilter : function(aType, aProperty, aValue) {
		var filter = new OpenLayers.Filter.Comparison({
       		type: aType,
           	property: aProperty,
       		value: aValue
       	});
       	
       	return filter;
	}
});
