$(document).ready(function() {
			// Tab Control
			$('#case-studies-form-wrapper .case-studies-tabs ul').find('li').each(function() {
				$(this).find('a').click(function(e) {
					e.preventDefault();

					// Change active tab to currently selected
					$(this).closest('ul').find('.active').removeClass('active');
					$(this).parent().addClass('active');

					// Change content to corresponding selected tab
					$('#case-studies-form-wrapper .case-studies-tabbed-content ul').find('.active').removeClass('active');
					$('#case-studies-form-wrapper .case-studies-tabbed-content ul').children().eq( $(this).parent().index() ).addClass('active');
				});
			});

			// Next & Previous Buttons
			$('#case-studies-form-wrapper').find('.case-studies-tabbed-content-button-next').click(function(e) {
				e.preventDefault();

				// Change active tab to currently selected
				$('#case-studies-form-wrapper .case-studies-tabs ul').find('.active').removeClass('active');
				$('#case-studies-form-wrapper .case-studies-tabs ul').children().eq( $(this).closest('li').index() + 1 ).addClass('active');

				// Change content to corresponding selected tab
				$('#case-studies-form-wrapper .case-studies-tabbed-content ul').find('.active').removeClass('active');
				$('#case-studies-form-wrapper .case-studies-tabbed-content ul').children().eq( $(this).closest('li').index() + 1 ).addClass('active');
			});
			$('#case-studies-form-wrapper').find('.case-studies-tabbed-content-button-previous').click(function(e) {
				e.preventDefault();

				// Change active tab to currently selected
				$('#case-studies-form-wrapper .case-studies-tabs ul').find('.active').removeClass('active');
				$('#case-studies-form-wrapper .case-studies-tabs ul').children().eq( $(this).closest('li').index() - 1 ).addClass('active');

				// Change content to corresponding selected tab
				$('#case-studies-form-wrapper .case-studies-tabbed-content ul').find('.active').removeClass('active');
				$('#case-studies-form-wrapper .case-studies-tabbed-content ul').children().eq( $(this).closest('li').index() - 1 ).addClass('active');
			});

			
			// toggle for Europe
			if ( $('#case-studies-form-wrapper').find('#europe_geo_chars').is(':checked') ) {
				$('#case-studies-form-wrapper').find('.europe_geochar_class').show();
			} else {
				$('#case-studies-form-wrapper').find('.europe_geochar_class').hide();
			}
			
			$('#case-studies-form-wrapper').find('#europe_geo_chars').change(function() {
				if ( $(this).is(':checked') ) {
					$('#case-studies-form-wrapper').find('.europe_geochar_class').show();
				}
			});
			
			$('#case-studies-form-wrapper').find('#global_geo_chars').change(function() {
				if ( $(this).is(':checked') ) {
					$('#case-studies-form-wrapper').find('.europe_geochar_class').hide();
				} 
			});
			
			initWYSIWYG();
			textAreaMaxLength();
			
			 var options = {
						box1View: 'subnationals',
						box2View: 'subnationals_selected',
			            transferMode: 'copy',
			            useFilters: false,
			            useCounters: false,
			            useSorting: false,
						selectOnSubmit: false
			  };
			    
			  $.configureBoxes(options);
		});

		function initWYSIWYG() {
			$('.WYSIWYG').each(function(){	
				// per-element configuration
				var tmpID = '#' + $(this).attr('id');
				$(tmpID).next('.case-studies-character-count').html( $(this).text().length + '/' + $(tmpID).attr('data-maxlength') );

				tinymce.init({
					plugins: "contextmenu",
					contextmenu: "bold italic underline",
					selector: tmpID,
					menubar: false,
					statusbar: false,
					toolbar: "bold italic underline | numlist bullist | alignleft aligncenter alignright",
					width: parseInt( $(this).attr('cols') ) * parseInt( $(this).css('font-size') ),
					height: parseInt( $(this).attr('rows') ) * parseInt( $(this).css('font-size') ),
					setup: function(editor) {
						editor.on('keyup', function(e) {
							var tmpContent = editor.getContent({format: 'text'});
							if ( tmpContent.length >= $(tmpID).attr('data-maxlength') ) {
								editor.setContent( '' );
								editor.insertContent( tmpContent.substr(0, $(tmpID).attr('data-maxlength')), {format: 'text'} );
							}

							$(tmpID).next('.case-studies-character-count').html( editor.getContent({format: 'text'}).length + '/' + $(tmpID).attr('data-maxlength') );
						});
					}
				});
			});
		}
		
	
		function textAreaMaxLength() {
			$('textarea').each(function() {
				if ( !$(this).hasClass('WYSIWYG') ) {
					$(this).keyup(function() {
						var tmpContent = $(this).val();
						if ( tmpContent.length >= $(this).attr('data-maxLength') ) {
							$(this).val( tmpContent.substr(0, $(this).attr('data-maxLength')) );
						}
					});
				}
			});
		}