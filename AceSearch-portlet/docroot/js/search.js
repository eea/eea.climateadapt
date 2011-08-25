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
	
	
    //$j(".expandedResultsGroup").hide();
	
    $j(".expandedResultsGroupTitle").click(function() {	
		var expId = this.id;
		// grab unique part, after dash
		var unique = expId.match(/-([0-9]+)/)[1];		
		// hide expandedResultsGroup with same unique id postfix
       //$j("#expandedId-"+unique).hide();
		// show collapsedResultsGroup with same unique id postfix	   
	   //$j("#collapsedId-"+unique).show(100);
	   
	   // hide expandedResultsGroup with same unique id postfix
	   $j("#expandedId-"+unique).removeClass("toggleshow");
	   $j("#expandedId-"+unique).addClass("togglehide");
	       
	   // show collapsedResultsGroup with same unique id postfix	   
	   $j("#collapsedId-"+unique).removeClass("togglehide");
	   $j("#collapsedId-"+unique).addClass("toggleshow");
    });	

    $j(".collapsedResultsGroupTitle").click(function() {
		var expId = this.id;
		// grab unique part, after dash
		var unique = expId.match(/-([0-9]+)/)[1];		
		// hide collapsedResultsGroup with same unique id postfix
       //$j("#collapsedId-"+unique).hide();
		// show expandedResultsGroup with same unique id postfix	   
	   //$j("#expandedId-"+unique).show(100);
	   
	   // hide collapsedResultsGroup with same unique id postfix
       $j("#collapsedId-"+unique).removeClass("toggleshow");
	   $j("#collapsedId-"+unique).addClass("togglehide");

		// show expandedResultsGroup with same unique id postfix	   
       $j("#expandedId-"+unique).removeClass("togglehide");
	   $j("#expandedId-"+unique).addClass("toggleshow");

    });	
	
	

    $j("input[name=sortBy]:radio").change(function() {
        sortedSearch(this);
    });
	
	
	// If only one section, show opened
	if ($j(".expandedResultsGroup").length == 1) {
		$j.each($j(".collapsedResultsGroup"), function(i,v){
			//$j("#" + this.id).hide();			
			$j("#" + this.id).removeClass("toggleshow");
			$j("#" + this.id).addClass("togglehide");
			
		});
		
		$j.each($j(".expandedResultsGroup"), function(i,v){
			//$j("#" + this.id).show();
			
			$j("#" + this.id).removeClass("togglehide");
			$j("#" + this.id).addClass("toggleshow");
		});
		
	} else {
		$j.each($j(".expandedResultsGroup"), function(i,v){
			//$j("#" + this.id).hide();

			$j("#" + this.id).removeClass("toggleshow");
			$j("#" + this.id).addClass("togglehide");

		});
		
	}
	

    showDataInfoPanel();
    
});

function removeHTMLTags(inStrRemoveTags){
            var strInputCode = inStrRemoveTags;
            /*
                    This line is optional, it replaces escaped brackets with real ones,
                    i.e. &lt; is replaced with < and &gt; is replaced with >
            */
            strInputCode = strInputCode.replace(/&(lt|gt);/g, function (strMatch, p1){
                    return (p1 == "lt")? "<" : ">";
            });
            return strInputCode.replace(/<\/?[^>]+(>|$)/g, "");
}

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
			resultlist += '<div class="searchresult" style="border: 1px solid;margin: 5px 0px;">';
		
			var descriptionText = aceitem.shortdescription ;

			// add name and description
            if ((aceitem.aceItem._storedAt != "") && (aceitem.aceItem._storagetype.substr(0, 3) == "URL")) {
                   resultlist += '<div><span class="bolder">&#187; <a href="/viewaceitem?aceitem_id=' +  aceitem.aceItem._aceItemId  + '" >' + aceitem.aceItem._name + ' </a></span> - ' + descriptionText + '</div>';

           } else if (aceitem.aceItem._storedAt.substr(0, 14) == "ace_project_id") {
                   resultlist += '<div><span class="bolder">&#187; <a href="/projects1?' + aceitem.aceItem._storedAt + '" >' + aceitem.aceItem._name + '</a></span>&nbsp;';
                   resultlist += ' - ' + descriptionText + '</div>';

            } else if (aceitem.aceItem._storedAt.substr(0, 14) == "ace_measure_id") {
                               resultlist += '<div><span class="bolder">&#187; <a href="/viewmeasure?' + aceitem.aceItem._storedAt + '" >' + aceitem.aceItem._name + '</a></span>&nbsp;';
                               resultlist += ' - ' + descriptionText + '</div>';

           } else {
                   resultlist += '<div><span class="bolder">&#187; <a href="/viewaceitem?aceitem_id=' +  aceitem.aceItem._aceItemId + '" >' + aceitem.aceItem._name + ' </a></span> - ' + descriptionText + '</div>';

           }
            // add relevance
            //resultlist += '<div class="relevance">relevance: ' + aceitem.relevance + '%</div>';

            resultlist += '<div class="relevance">relevance: ';
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
            resultlist +=  '%</div>';

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
