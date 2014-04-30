jQuery(document).ready(function() {

	var $j = jQuery.noConflict();

    $j("#clear-search-form-btn").click(function() {
       clearSearchForm();
    });

    $j("#adaptation_sectors_btn").click(function() {
       showAdaptationSectorsPanel();
    });	

    $j("#countries_btn").click(function() {
          showCountriesPanel();
       });
    showCountriesPanelOnLoad();
	
    $j("#adaptation_elements_btn").click(function() {
       showAdaptationElementsPanel();
    });	
	showAdaptationElementsPanelOnLoad();

    $j("#climate_impacts_btn").click(function() {
       showClimateImpactsPanel();
    });	
	showClimateImpactsPanelOnLoad();	
	
    $j("input[name=datainfo_type]:radio").change(function() {
        showDataInfoPanel();
    });


    $j("input[name=date_type]:radio").change(function() {
        showDatePanels();
    });
	
	if($j('.resultsgroup').length) {
		resizePagination();	
	}								
	
	
    $j(".expandedResultsGroup").hide();
	
    $j(".expandedResultsGroupTitle").click(function() {	
		var expId = this.id;
		// grab unique part, after dash
		var unique = expId.match(/-([0-9]+)/)[1];		
		// hide expandedResultsGroup with same unique id postfix
       $j("#expandedId-"+unique).hide();
		// show collapsedResultsGroup with same unique id postfix	   
	   $j("#collapsedId-"+unique).show(100);
    });	

    $j(".collapsedResultsGroupTitle").click(function() {
		var expId = this.id;
		// grab unique part, after dash
		var unique = expId.match(/-([0-9]+)/)[1];		
		// hide collapsedResultsGroup with same unique id postfix
       $j("#collapsedId-"+unique).hide();
		// show expandedResultsGroup with same unique id postfix	   
	   $j("#expandedId-"+unique).show(100);
    });	
	
	

    $j("input[name=sortBy]:radio").change(function() {
        sortedSearch(this);
    });
	
	
	$j.each($j(".expandedResultsGroup"), function(i,v){
		$j("#" + this.id).hide();
	});

    showDataInfoPanel();
});

/**
 * Resizes pagination for results groups according to how many page numbers are displayed.
 */ 
function resizePagination() {
	$j.each($j(".resultsgroup div.jPaginate"), function(index, value){
		var numbersListWidth = $j('#' + this.id + ' div:nth-child(2) .jPag-pages').width();
		var numbersListParentWidth = 550;																		
		if(numbersListWidth <= 550) {
			numbersListParentWidth = 20 + numbersListWidth;
		}									
		$j('#' + this.id + ' div:nth-child(2)').width(numbersListParentWidth);
		$j('#' + this.id + ' div:nth-child(3)').css("left", 60 + numbersListParentWidth);
	});				
}	


/**
 *
 * Shows/hides the adaptation sectors panel
 *
 */
function showAdaptationSectorsPanel() {
    $j("#adaptation_sectors_container").slideToggle();
    if ($j("#adaptation_sectors_btn").hasClass('collapsed_section')) {
        $j("#adaptation_sectors_btn").removeClass('collapsed_section');
        $j("#adaptation_sectors_btn").addClass('expanded_section');
    } else {
        $j("#adaptation_sectors_btn").removeClass('expanded_section');
        $j("#adaptation_sectors_btn").addClass('collapsed_section');
    }
}


/**
 *
 * Shows/hides the countries elements panel.
 *
 */
function showCountriesPanel() {
    $j("#countries_container").slideToggle();
    if ($j("#countries_btn").hasClass('collapsed_section')) {
        $j("#countries_btn").removeClass('collapsed_section');
        $j("#countries_btn").addClass('expanded_section');
    }
	else {
        $j("#countries_btn").removeClass('expanded_section');
        $j("#countries_btn").addClass('collapsed_section');
    }
}

/**
 *
 * Shows/hides the adaptation elements panel.
 *
 */
function showAdaptationElementsPanel() {
    $j("#adaptation_elements_container").slideToggle();
    if ($j("#adaptation_elements_btn").hasClass('collapsed_section')) {
        $j("#adaptation_elements_btn").removeClass('collapsed_section');
        $j("#adaptation_elements_btn").addClass('expanded_section');
    } 
	else {
        $j("#adaptation_elements_btn").removeClass('expanded_section');
        $j("#adaptation_elements_btn").addClass('collapsed_section');
    }
}

/**
 *
 * Shows/hides the climate impacts panel.
 *
 */
function showClimateImpactsPanel() {
    $j("#climate_impacts_container").slideToggle();
    if ($j("#climate_impacts_btn").hasClass('collapsed_section')) {
        $j("#climate_impacts_btn").removeClass('collapsed_section');
        $j("#climate_impacts_btn").addClass('expanded_section');
    } 
	else {
        $j("#climate_impacts_btn").removeClass('expanded_section');
        $j("#climate_impacts_btn").addClass('collapsed_section');
    }
}

/**
 * Expands elements panel if at least one of them is checked.
 */
function showAdaptationElementsPanelOnLoad() {
    if ($j("input[name=element]:checked").length > 0) {
        jQuery('#adaptation_elements_container').show(100);
        $j("#adaptation_elements_btn").removeClass('collapsed_section');
        $j("#adaptation_elements_btn").addClass('expanded_section');
	} 
	else {
        jQuery('#adaptation_elements_container').hide();
        $j("#adaptation_elements_btn").removeClass('expanded_section');
        $j("#adaptation_elements_btn").addClass('collapsed_section');    }
}

/**
 * Expands impacts panel if at least one of them is checked.
 */
function showClimateImpactsPanelOnLoad() {
    if ($j("input[name=impact]:checked").length > 0) {
        jQuery('#climate_impacts_container').show(100);
        $j("#climate_impacts_btn").removeClass('collapsed_section');
        $j("#climate_impacts_btn").addClass('expanded_section');
	} 
	else {
        jQuery('#climate_impacts_container').hide();
        $j("#climate_impacts_btn").removeClass('expanded_section');
        $j("#climate_impacts_btn").addClass('collapsed_section');    }
}

/**
 * Expands countries panel if at least one of them is checked.
 */
function showCountriesPanelOnLoad() {
    if ($j("input[name=countries]:checked").length > 0) {
        jQuery('#countries_container').show(100);
        $j("#countries_btn").removeClass('collapsed_section');
        $j("#countries_btn").addClass('expanded_section');
	}
	else {
        jQuery('#countries_container').hide();
        $j("#countries_btn").removeClass('expanded_section');
        $j("#countries_btn").addClass('collapsed_section');    }
}

/**
 *
 * Shows/hides the data info selection panel.
 *
 */
function showDataInfoPanel() {
    if ($j("input[name=datainfo_type]:checked").val() == '1') {
        jQuery('#all_selection_types').hide();
    } 
	else if ($j("input[name=datainfo_type]:checked").val() == '2') {
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
    $j("input[name=anyOfThese]").val("");

    var radiosConditionAdaptationSector = $j("input[name=conditionAdaptationSector]:radio");
    radiosConditionAdaptationSector.each(function() {
        $j(this).attr('checked', false);
    });
    radiosConditionAdaptationSector.filter('[value=AND]').attr('checked', true);

    var radiosConditionAdaptationElement = $j("input[name=conditionAdaptationElement]:radio");
    radiosConditionAdaptationElement.each(function() {
        $j(this).attr('checked', false);
    });
    radiosConditionAdaptationElement.filter('[value=AND]').attr('checked', true);

    var radiosConditionClimateImpact = $j("input[name=conditionClimateImpact]:radio");
    radiosConditionClimateImpact.each(function() {
        $j(this).attr('checked', false);
    });
    radiosConditionClimateImpact.filter('[value=AND]').attr('checked', true);
	
    $j("input[name=aceitemtype]:checkbox").each(function() {
        $j(this).attr('checked', false);
    });

    $j("input[name=sector]:checkbox").each(function() {
        $j(this).attr('checked', false);
    });

    $j("input[name=countries]:checkbox").each(function() {
        $j(this).attr('checked', false);
    });
	
    $j("input[name=element]:checkbox").each(function() {
        $j(this).attr('checked', false);
    });
	
    $j("input[name=impact]:checkbox").each(function() {
        $j(this).attr('checked', false);
    });	
	
    showDataInfoPanel();
}
/**
 * Creates filtered results HTML from list of JSON AceItems from FilterAceItemPortlet.
 *
 */
function displayJSONFilterResults(unique, aceitemResults) {
	var resultlist = '<div id="resultsListId-'+unique+'">';
	jQuery.each(aceitemResults, function(idx, aceitem){ 
		if (aceitem) {
			// add searchresult
			resultlist += '<div class="searchresultFilter">';
			
			// add name 
            if ((aceitem._storedAt != "") && (aceitem._storagetype.substr(0, 3) == "URL")) {
                   resultlist += '<div><span class="bolder">&#187; <a href="/viewaceitem?aceitem_id=' +  aceitem._aceItemId  + '" >' + aceitem._name + ' </a></span></div>';

           } else if (aceitem._storedAt.substr(0, 14) == "ace_project_id") {
                   resultlist += '<div><span class="bolder">&#187; <a href="/projects1?' + aceitem._storedAt + '" >' + aceitem._name + '</a></span></div>';

            } else if (aceitem._storedAt.substr(0, 14) == "ace_measure_id") {
                               resultlist += '<div><span class="bolder">&#187; <a href="/viewmeasure?' + aceitem._storedAt + '" >' + aceitem._name + '</a></span></div>';

           } else {
                   resultlist += '<div><span class="bolder">&#187; <a href="/viewaceitem?aceitem_id=' +  aceitem._aceItemId + '" >' + aceitem._name + ' </a></span></div>';

           }


			// add result footer 
			// TODO use actual date from aceitem, if available
//			resultlist += '<div class="resultfooter" style="display:none"><hr class="clearer"/></div>';
			// close searchresult
			resultlist += '</div>';					
		}
	});
	// close searchresultlist
	resultlist += '</div>';
	jQuery('#expandedId-'+unique).append(resultlist);
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
		
			var descriptionText = aceitem._description.length > 400 ? aceitem._description.substring(0, 396) + " ..." : aceitem._description;
			
			// add name and description
            if ((aceitem._storedAt != "") && (aceitem._storagetype.substr(0, 3) == "URL")) {
                   resultlist += '<div><span class="bolder">&#187; <a href="/viewaceitem?aceitem_id=' +  aceitem._aceItemId  + '" >' + aceitem._name + ' </a></span> - ' + descriptionText + '</div>';

           } else if (aceitem._storedAt.substr(0, 14) == "ace_project_id") {
                   resultlist += '<div><span class="bolder">&#187; <a href="/projects1?' + aceitem._storedAt + '" >' + aceitem._name + '</a></span>&nbsp;';
                   resultlist += ' - ' + descriptionText + '</div>';

            } else if (aceitem._storedAt.substr(0, 14) == "ace_measure_id") {
                               resultlist += '<div><span class="bolder">&#187; <a href="/viewmeasure?' + aceitem._storedAt + '" >' + aceitem._name + '</a></span>&nbsp;';
                               resultlist += ' - ' + descriptionText + '</div>';

           } else {
                   resultlist += '<div><span class="bolder">&#187; <a href="/viewaceitem?aceitem_id=' +  aceitem._aceItemId + '" >' + aceitem._name + ' </a></span> - ' + descriptionText + '</div>';

           }


			// add result footer 
			// TODO use actual date from aceitem, if available
//			resultlist += '<div class="resultfooter"><hr class="clearer"/></div>';
			// close searchresult
			resultlist += '</div>';					
		}
	});
	// close searchresultlist
	resultlist += '</div>';
	jQuery('#expandedId-'+unique).append(resultlist);
}