CHM.Candidates = OpenLayers.Class({
	
	candidates: null,
	
	initialize : function() {
		this.candidates = new Array();
	},

	addCandidate: function(aCandidate) {
		var candidate = this.findCandidate(aCandidate);
		
		if (candidate == null) {
			this.candidates.push(aCandidate);
		}
	},
	
	findCandidate: function(aCandidate) {
		var result = null;
		
		for (var i = 0; i < this.candidates.length; i++) {
			var candidate = this.candidates[i];
			
			if (candidate.equals(aCandidate)) {
				result = candidate;
			}
		}
		
		return result;
	},
	
	toHtml: function() {
		var result = "";
		
		for (var i = 0; i < this.candidates.length ; i ++) {
			var candidate = this.candidates[i];
			
			result += candidate.toHtml();
		}
		
		return result;
	}
});