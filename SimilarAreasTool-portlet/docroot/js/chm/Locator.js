CHM.Locator = OpenLayers.Class({

	div : null,

	location : null,

	onlocationchanged : null,

	geocodeservice : null,

	initialize : function(div, options) {
		// If only one argument is provided, check if it is an object.
		if (arguments.length === 1 && typeof div === "object") {
			options = div;
			div = options && options.div;
		}

		this.div = OpenLayers.Util.getElement(div);

		if (!this.div) {
			this.div = document.createElement("div");

			this.div.style.height = "1px";

			this.div.style.width = "1px";
		}

		this.geocodeservice = new esri.tasks.Locator(locatorUrl); // "http://geocode.arcgis.com/arcgis/rest/services/World/GeocodeServer");

		dojo.connect(this.geocodeservice, "onAddressToLocationsComplete",
				this.handleGeocodeResult);

		dojo.connect(this.geocodeservice, "onError", this.handleGeocodeError);
	},

	locate : function(aName) {
		var extent = new esri.geometry.Extent(-31.289030, 27.637496, 44.820546,
				71.154709, new esri.SpatialReference({
					wkid : 4326
				}));

		var options = {
			address : {
				"Address" : aName
			},
			outFields : [ "Loc_name" ],
			searchExtent : extent
		};

		this.geocodeservice.addressToLocations(options);
	},

	handleGeocodeResult : function(places) {
		locator.div.innerHTML = "";

		if (places.length > 0) {
			var candidates = new CHM.Candidates();

			var place;

			for ( var i = 0; i < places.length; i++) {
				place = places[i];

				locname = place.attributes.Loc_name;

				if (locname == "Gaz.WorldGazetteer.POI1") {
					var candidate = new CHM.Candidate(place.address, place.location.x, place.location.y);

					candidates.addCandidate(candidate);
				}
			}

			locator.div.innerHTML = candidates.toHtml();
		} else {
			locator.div.innerHTML = "Sorry, address or place not found.";
		}
	},

	handleGeocodeError : function(errorInfo) {
		locator.div.innerHTML = "";

		locator.div.innerHTML = "Sorry, place or address not found.";
	},

	getLocation : function() {
		return this.location;
	},

	setLocation : function(x, y) {
		this.location = new CHM.Location(x, y, new OpenLayers.Projection(
				"EPSG:4326"));

		this.handleOnLocationChanged();
	},

	setOnLocationChanged : function(aFunction) {
		this.onlocationchanged = aFunction;
	},

	handleOnLocationChanged : function() {
		if (this.onlocationchanged != null) {
			this.onlocationchanged();
		}
	}
});