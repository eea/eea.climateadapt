jQuery(document).ready(function() {

    $("#adaptation_sectors_btn").click(function() {
       showAdaptationInfoPanel();
    });

    $("input[name=datainfo_type]:radio").change(function() {
        showDataInfoPanel();
    });


    $("input[name=date_type]:radio").change(function() {
        showDatePanels();
    });


    showDataInfoPanel();
    showDatePanels();
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
 * Shows/hides the data info selection panel
 *
 */
function showDataInfoPanel() {
    if ($("input[name=datainfo_type]:checked").val() == '1') {
        jQuery('#all_selection_types').hide();

    } else if ($("input[name=datainfo_type]:checked").val() == '2') {
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
        if ($("input[name=date_type]:checked").val() == '1') {
            jQuery('#range_dates').hide();
            jQuery('#specific_date').hide();

        } else if ($("input[name=date_type]:checked").val() == '2') {
            jQuery('#specific_date').hide();
            jQuery('#range_dates').show(100);

        } else {
            jQuery('#range_dates').hide();
            jQuery('#specific_date').show(100);
        }
}