jQuery(document).ready(function() {

    $j("#clear-search-form-btn").click(function() {
       clearSearchForm();
    });

    $j("#adaptation_sectors_btn").click(function() {
       showAdaptationSectorsPanel();
    });

    $j("input[name=datainfo_type]:radio").change(function() {
        showDataInfoPanel();
    });


    $j("input[name=date_type]:radio").change(function() {
        showDatePanels();
    });
	
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
	
	// expand first resultgroup
	var firstResultsGroup = $j(".collapsedResultsGroupTitle").first();
	if(firstResultsGroup) {
		//alert('firstResultsGroup: ' + firstResultsGroup);
		firstResultsGroup.click();
	}
	else {
		//alert('No firstResultsGroup');	
	}
	
    showDataInfoPanel();
    showDatePanels();
});




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
 * Shows/hides the data info selection panel
 *
 */
function showDataInfoPanel() {
    if ($j("input[name=datainfo_type]:checked").val() == '1') {
        jQuery('#all_selection_types').hide();

    } else if ($j("input[name=datainfo_type]:checked").val() == '2') {
        jQuery('#all_selection_types').show(100);

    }
}

/**
 *
 * Shows the date panels on date type selection
 *
 *   - No date panel
 *   - Date range panel
 *   - Simple date panel
 *
 */
function showDatePanels() {
        if ($j("input[name=date_type]:checked").val() == '1') {
            $j("input[name=initial_date]").val("");
            $j("input[name=final_date]").val("");
            $j("input[name=simple_date]").val("");

            jQuery('#range_dates').hide();
            jQuery('#specific_date').hide();

        } else if ($("input[name=date_type]:checked").val() == '2') {
            $j("input[name=simple_date]").val("");

            jQuery('#specific_date').hide();
            jQuery('#range_dates').show(100);

        } else {
            $j("input[name=initial_date]").val("");
            $j("input[name=final_date]").val("");

            jQuery('#range_dates').hide();
            jQuery('#specific_date').show(100);
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
    $j("input[name=initial_date]").val("");
    $j("input[name=final_date]").val("");
    $j("input[name=simple_date]").val("");

    $j("input[name=aceitemtype]:checkbox").each(function() {
        $j(this).attr('checked', false);
    });

    $j("input[name=sector]:checkbox").each(function() {
        $j(this).attr('checked', false);
    });
    showDataInfoPanel();
    showDatePanels();
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
			if (aceitem._storedAt.substr(0, 4) == "http") {
				resultlist += '<div><span class="bolder">&#187; <a href="' + aceitem._storedAt + '">' + aceitem._name + '</a></span>&nbsp;';

				if (aceitem._storedAt.substr(0, 21) == "http://www.tatenbank.") {
					resultlist += '<span class="bolder">&#187; <a href="http://babelfish.yahoo.com/translate_url?doit=done&tt=url&intl=1&fr=bf-home&lp=de_en&btnTrUrl=Translate&&trurl='+ aceitem._storedAt + '" target="_blank">(machine translate to english)</a></span>&nbsp;';					
				}
				
				resultlist += ' - ' + descriptionText + '</div>';

			} else if (aceitem._storedAt.substr(0, 14) == "ace_project_id") {
				resultlist += '<div><span class="bolder">&#187; <a href="/projects1?' + aceitem._storedAt + '" target="_blank">' + aceitem._name + '</a></span>&nbsp;';
				resultlist += ' - ' + descriptionText + '</div>';

			} else {
				resultlist += '<div><span class="bolder">&#187; ' + aceitem._name + ' </span> - ' + descriptionText + '</div>';
			}
			// add result footer 
			// TODO use actual date from aceitem, if available
			resultlist += '<div class="resultfooter"><hr class="clearer"/></div>';
			// close searchresult
			resultlist += '</div>';					
		}
	});
	// close searchresultlist
	resultlist += '</div>';
	$j('#expandedId-'+unique).append(resultlist);
}	
		