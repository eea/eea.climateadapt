$(document).ready(function() {
			$('#case-studies-homepage-slider-wrapper .case-studies-homepage-slider-content ul.blank').children().each(function(index,value){
				
				if ( $(this).hasClass('active') ) {
					$('#case-studies-homepage-slider-wrapper .case-studies-homepage-slider-controls').find('ul').append('<li class="active">' + (index+1) + '</li>');
				
				} else {
					$('#case-studies-homepage-slider-wrapper .case-studies-homepage-slider-controls').find('ul').append('<li>' + (index+1) + '</li>');
				}

				if ( $('#case-studies-homepage-slider-wrapper .case-studies-homepage-slider-content ul.blank').children().length == (index+1) ) {
					initHomepageSliderControls();
				}
			});
		});
		var aniSpeed = 500;

	function initHomepageSliderControls() {
		$('#case-studies-homepage-slider-wrapper .case-studies-homepage-slider-controls ul').children().each(function() {
			$(this).click(function() {
				if ( !$(this).hasClass('active')  ) {
					$('#case-studies-homepage-slider-wrapper .case-studies-homepage-slider-content ul.blank').children('.active').fadeOut(aniSpeed, function() {
						$('#case-studies-homepage-slider-wrapper .case-studies-homepage-slider-content ul.blank').children('.active').removeClass('active');
						$('#case-studies-homepage-slider-wrapper .case-studies-homepage-slider-controls ul').find('.active').removeClass('active');
					});

					$('#case-studies-homepage-slider-wrapper .case-studies-homepage-slider-content ul.blank').children().eq( $(this).index() ).fadeIn(aniSpeed, function() {
						$('#case-studies-homepage-slider-wrapper .case-studies-homepage-slider-content ul.blank').children().eq( $(this).index() ).addClass('active');
						$('#case-studies-homepage-slider-wrapper .case-studies-homepage-slider-controls ul').children().eq( $(this).index() ).addClass('active');
					});
				}
			});
		});
		
	}
	
	
		// ==================== //
		// Portlet JS Ends Here //
		// ==================== //
