jQuery(document).ready(function() {

	//var $ = jQuery.noConflict();

    $("#clear-search-form-btn").click(function() {
       clearSearchForm();
    });

    $("#adaptation_sectors_btn").click(function() {
       showAdaptationSectorsPanel();
    });	

    $("#countries_btn").click(function() {
          showCountriesPanel();
       });
    showCountriesPanelOnLoad();
	
    $("#adaptation_elements_btn").click(function() {
       showAdaptationElementsPanel();
    });	
	showAdaptationElementsPanelOnLoad();

    $("#climate_impacts_btn").click(function() {
       showClimateImpactsPanel();
    });	
	showClimateImpactsPanelOnLoad();	
	
	if($('.resultsgroup').length) {
		resizePagination();	
	}						
    
    $(".minus").click(function() {	
		var expId = this.id;
		// grab unique part, after dash
		var unique = expId.match(/-([0-9]+)/)[1];		
		// hide expandedResultsGroup with same unique id postfix
	       $("#descriptionId-"+unique).removeClass("toggleshow");
	       $("#descriptionId-"+unique).addClass("togglehide");
	       $("#minusId-"+unique).removeClass("toggleshow");
	       $("#minusId-"+unique).addClass("togglehide");
	       $("#plusId-"+unique).removeClass("togglehide");
	       $("#plusId-"+unique).addClass("toggleshow");
    });	

    $(".plus").click(function() {
		var expId = this.id;
		// grab unique part, after dash
		var unique = expId.match(/-([0-9]+)/)[1];		
		// hide collapsedResultsGroup with same unique id postfix   
		   $("#descriptionId-"+unique).removeClass("togglehide");  
		   $("#descriptionId-"+unique).addClass("toggleshow");
	       $("#minusId-"+unique).removeClass("togglehide");
	       $("#minusId-"+unique).addClass("toggleshow");
	       $("#plusId-"+unique).removeClass("toggleshow");
	       $("#plusId-"+unique).addClass("togglehide");
    });
    
  
    showDataInfoPanel();
});

/**
 *
 * Shows/hides the adaptation sectors panel
 *
 */
function showAdaptationSectorsPanel() {
    $("#adaptation_sectors_container").slideToggle();
    if ($("#adaptation_sectors_btn").hasClass('collapsed_section')) {
        $("#adaptation_sectors_btn").removeClass('collapsed_section');
        $("#adaptation_sectors_btn").addClass('expanded_section');
    } else {
        $("#adaptation_sectors_btn").removeClass('expanded_section');
        $("#adaptation_sectors_btn").addClass('collapsed_section');
    }
}


/**
 *
 * Shows/hides the countries elements panel.
 *
 */
function showCountriesPanel() {
    $("#countries_container").slideToggle();
    if ($("#countries_btn").hasClass('collapsed_section')) {
        $("#countries_btn").removeClass('collapsed_section');
        $("#countries_btn").addClass('expanded_section');
    }
	else {
        $("#countries_btn").removeClass('expanded_section');
        $("#countries_btn").addClass('collapsed_section');
    }
}

/**
 *
 * Shows/hides the adaptation elements panel.
 *
 */
function showAdaptationElementsPanel() {
    $("#adaptation_elements_container").slideToggle();
    if ($("#adaptation_elements_btn").hasClass('collapsed_section')) {
        $("#adaptation_elements_btn").removeClass('collapsed_section');
        $("#adaptation_elements_btn").addClass('expanded_section');
    } 
	else {
        $("#adaptation_elements_btn").removeClass('expanded_section');
        $("#adaptation_elements_btn").addClass('collapsed_section');
    }
}

/**
 *
 * Shows/hides the climate impacts panel.
 *
 */
function showClimateImpactsPanel() {
    $("#climate_impacts_container").slideToggle();
    if ($("#climate_impacts_btn").hasClass('collapsed_section')) {
        $("#climate_impacts_btn").removeClass('collapsed_section');
        $("#climate_impacts_btn").addClass('expanded_section');
    } 
	else {
        $("#climate_impacts_btn").removeClass('expanded_section');
        $("#climate_impacts_btn").addClass('collapsed_section');
    }
}

/**
 * Expands elements panel if at least one of them is checked.
 */
function showAdaptationElementsPanelOnLoad() {
    if ($("input[name=element]:checked").length > 0) {
        jQuery('#adaptation_elements_container').show(100);
        $("#adaptation_elements_btn").removeClass('collapsed_section');
        $("#adaptation_elements_btn").addClass('expanded_section');
	} 
	else {
        jQuery('#adaptation_elements_container').hide();
        $("#adaptation_elements_btn").removeClass('expanded_section');
        $("#adaptation_elements_btn").addClass('collapsed_section');    }
}

/**
 * Expands impacts panel if at least one of them is checked.
 */
function showClimateImpactsPanelOnLoad() {
    if ($("input[name=impact]:checked").length > 0) {
        jQuery('#climate_impacts_container').show(100);
        $("#climate_impacts_btn").removeClass('collapsed_section');
        $("#climate_impacts_btn").addClass('expanded_section');
	} 
	else {
        jQuery('#climate_impacts_container').hide();
        $("#climate_impacts_btn").removeClass('expanded_section');
        $("#climate_impacts_btn").addClass('collapsed_section');    }
}

/**
 * Expands countries panel if at least one of them is checked.
 */
function showCountriesPanelOnLoad() {
    if ($("input[name=countries]:checked").length > 0) {
        jQuery('#countries_container').show(100);
        $("#countries_btn").removeClass('collapsed_section');
        $("#countries_btn").addClass('expanded_section');
	}
	else {
        jQuery('#countries_container').hide();
        $("#countries_btn").removeClass('expanded_section');
        $("#countries_btn").addClass('collapsed_section');    }
}

/**
 *
 * Shows/hides the data info selection panel.
 *
 */
function showDataInfoPanel() {
    if ($("input[name=datainfo_type]:checked").val() == '1') {
        jQuery('#all_selection_types').hide();
    } 
	else if ($("input[name=datainfo_type]:checked").val() == '2') {
        jQuery('#all_selection_types').show(100);
    }
}


/**
 *
 * Clear search form controls
 *
 *
 */
function clearSearchForm() {
    $("input[name=anyOfThese]").val("");

    var radiosConditionAdaptationSector = $("input[name=conditionAdaptationSector]:radio");
    radiosConditionAdaptationSector.each(function() {
        $(this).attr('checked', false);
    });
    radiosConditionAdaptationSector.filter('[value=AND]').attr('checked', true);

    var radiosConditionAdaptationElement = $("input[name=conditionAdaptationElement]:radio");
    radiosConditionAdaptationElement.each(function() {
        $(this).attr('checked', false);
    });
    radiosConditionAdaptationElement.filter('[value=AND]').attr('checked', true);

    var radiosConditionClimateImpact = $("input[name=conditionClimateImpact]:radio");
    radiosConditionClimateImpact.each(function() {
        $(this).attr('checked', false);
    });
    radiosConditionClimateImpact.filter('[value=AND]').attr('checked', true);
	
    $("input[name=aceitemtype]:checkbox").each(function() {
        $(this).attr('checked', false);
    });

    $("input[name=sector]:checkbox").each(function() {
        $(this).attr('checked', false);
    });

    $("input[name=countries]:checkbox").each(function() {
        $(this).attr('checked', false);
    });
	
    $("input[name=element]:checkbox").each(function() {
        $(this).attr('checked', false);
    });
	
    $("input[name=impact]:checkbox").each(function() {
        $(this).attr('checked', false);
    });	
	
    showDataInfoPanel();
}

/**
 * Creates search results HTML from list of JSON AceItems.
 *
 */
function displayJSONResults(unique, aceitemResults) {
	var resultlist = '<div id="resultsListId-'+unique+'">';
	jQuery.each(aceitemResults, function(idx, aceitem){ 
		if (aceitem) {
			// add searchresult
			resultlist += '<div class="searchresult">';
		
			var descriptionText = aceitem.shortdescription ;

			// add name and description
            if ((aceitem.storedAt != "") && (aceitem.storagetype.substr(0, 3) == "URL")) {
                   resultlist += '<div><span class="bolder">&#187; <a href="/viewaceitem?aceitem_id=' +  aceitem.aceItemId  + '" >' + aceitem.name + ' </a></span> - ' + descriptionText + '</div>';

           } else if (aceitem.storedAt.substr(0, 14) == "ace_project_id") {
                   resultlist += '<div><span class="bolder">&#187; <a href="/projects1?' + aceitem.storedAt + '" >' + aceitem.name + '</a></span>&nbsp;';
                   resultlist += ' - ' + descriptionText + '</div>';

            } else if (aceitem.storedAt.substr(0, 14) == "ace_measure_id") {
                               resultlist += '<div><span class="bolder">&#187; <a href="/viewmeasure?' + aceitem.storedAt + '" >' + aceitem.name + '</a></span>&nbsp;';
                               resultlist += ' - ' + descriptionText + '</div>';

           } else {
                   resultlist += '<div><span class="bolder">&#187; <a href="/viewaceitem?aceitem_id=' +  aceitem.aceItemId + '" >' + aceitem.name + ' </a></span> - ' + descriptionText + '</div>';

           }
            // add relevance
            //resultlist += '<div class="relevance">relevance: ' + aceitem.relevance + '%</div>';

            resultlist += '<div class="relevance-title">relevance: </div>';
            if(aceitem.relevance > 80) {
                resultlist += '<div class="relevance-marker"></div>';
                resultlist += '<div class="relevance-marker"></div>';
                resultlist += '<div class="relevance-marker"></div>';
                resultlist += '<div class="relevance-marker"></div>';
                resultlist += '<div class="relevance-marker"></div>';
            }
            else if(aceitem.relevance > 60) {
                resultlist += '<div class="relevance-marker"></div>';
                resultlist += '<div class="relevance-marker"></div>';
                resultlist += '<div class="relevance-marker"></div>';
                resultlist += '<div class="relevance-marker"></div>';
            }
            else if(aceitem.relevance > 40) {
                resultlist += '<div class="relevance-marker"></div>';
                resultlist += '<div class="relevance-marker"></div>';
                resultlist += '<div class="relevance-marker"></div>';
            }
            else if(aceitem.relevance > 20) {
                resultlist += '<div class="relevance-marker"></div>';
                resultlist += '<div class="relevance-marker"></div>';
            }
            else {
                resultlist += '<div class="relevance-marker"></div>';
            } 

			// add result footer 
			// TODO use actual date from aceitem, if available
//			resultlist += '<div class="resultfooter"><hr class="clearer"/></div>';
			// close searchresult
			resultlist += '<hr class="clearer"/></div>';					
		}
	});
	// close searchresultlist
	resultlist += '</div>';
	jQuery('#expandedId-'+unique).append(resultlist);
}
