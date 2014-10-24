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
			
			var activeIndex=0;
			var numBanners = $('#case-studies-homepage-slider-wrapper .case-studies-homepage-slider-content ul.blank').children().length; 
			
			var bannerTimer = setInterval(function(){
				var nextIndex=activeIndex+1;
				if(activeIndex >= numBanners-1){
					activeIndex=0;
					nextIndex=0;
				}
				else{
					activeIndex++;
				}
				nextIndex = nextIndex + 1;
				transition($('#case-studies-homepage-slider-wrapper .case-studies-homepage-slider-content ul.blank>li:nth-child(' + nextIndex + ')'));

			}, 20000);
		
			var fadeSpeed = 200;

	function transition (that){
		$('#case-studies-homepage-slider-wrapper>.case-studies-homepage-slider-content>ul>li.active').fadeOut(fadeSpeed, function() {
			$('#case-studies-homepage-slider-wrapper>.case-studies-homepage-slider-content>ul>li.active').removeClass('active');
			$('#case-studies-homepage-slider-wrapper>.case-studies-homepage-slider-controls>ul>li.active').removeClass('active');
		});
		if ( !$(that).hasClass('active')  ) {			
			$('#case-studies-homepage-slider-wrapper .case-studies-homepage-slider-content ul').children().eq( $(that).index() ).fadeIn(fadeSpeed, function() {
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
