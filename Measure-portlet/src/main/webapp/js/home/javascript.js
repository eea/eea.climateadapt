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
			
			var numBanners = $('#case-studies-homepage-slider-wrapper .case-studies-homepage-slider-content ul.blank').children().length; 
			
			var activeIndex=1; //Let's initialize from the second position
			var bannerTimer = setInterval(function(){
				if(activeIndex+1 > numBanners){
					activeIndex=1;
				}
				else{
					activeIndex++;
				}
				transition($('#case-studies-homepage-slider-wrapper .case-studies-homepage-slider-content ul.blank>li:nth-child(' + activeIndex + ')'));

			}, 20000);
		
			var fadeOutSpeed = 100;
			var fadeInSpeed = 200;

	function transition (that){
		$('#case-studies-homepage-slider-wrapper>.case-studies-homepage-slider-content>ul>li.active').fadeOut(fadeOutSpeed, function() {
			$('#case-studies-homepage-slider-wrapper>.case-studies-homepage-slider-content>ul>li.active').removeClass('active');
			$('#case-studies-homepage-slider-wrapper>.case-studies-homepage-slider-controls>ul>li.active').removeClass('active');
		});
		if ( !$(that).hasClass('active')  ) {			
			$('#case-studies-homepage-slider-wrapper .case-studies-homepage-slider-content ul').children().eq( $(that).index() ).fadeIn(fadeInSpeed, function() {
				$('#case-studies-homepage-slider-wrapper .case-studies-homepage-slider-content ul').children().eq( $(that).index() ).addClass('active');
				$('#case-studies-homepage-slider-wrapper .case-studies-homepage-slider-controls ul').children().eq( $(that).index() ).addClass('active');
			});
		}
	}
	
	function initHomepageSliderControls() {
		$('#case-studies-homepage-slider-wrapper .case-studies-homepage-slider-controls ul').children().each(function() {
				$(this).click(function() {
					transition(this);
					window.clearInterval(bannerTimer);
				});
			});
		}
});

		// ==================== //
		// Portlet JS Ends Here //
		// ==================== //
