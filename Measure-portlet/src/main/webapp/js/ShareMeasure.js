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
			
			
			/*// Toggle SubOptions for Geographic Level Transnational Checkbox
			if ( $('#case-studies-form-wrapper').find('#transnational').is(':checked') ) {
				$('#case-studies-form-wrapper').find('.case-studies-tabbed-content-sub-options').show();
			} else {
				$('#case-studies-form-wrapper').find('.case-studies-tabbed-content-sub-options').hide();
				$('#case-studies-form-wrapper .case-studies-tabbed-content-sub-options').find('input[type=radio]').each(function() {
					$(this).removeAttr('checked');
				});

			}
			$('#case-studies-form-wrapper').find('#transnational').change(function() {
				if ( $(this).is(':checked') ) {
					$('#case-studies-form-wrapper').find('.case-studies-tabbed-content-sub-options').show();
				} else {
					$('#case-studies-form-wrapper').find('.case-studies-tabbed-content-sub-options').hide();
					$('#case-studies-form-wrapper .case-studies-tabbed-content-sub-options').find('input[type=radio]').each(function() {
					$(this).removeAttr('checked');
				});
				}
			});
			
			
			// Toggle SubNationals for Geographic Characterisation
			// for subnational
			if ( $('#case-studies-form-wrapper').find('#chk_geo_chars_subnational').is(':checked') ) {
				$('#case-studies-form-wrapper').find('.case-studies-tabbed-content-table-for-lists').show();
			} else {
				$('#case-studies-form-wrapper').find('.case-studies-tabbed-content-table-for-lists').hide();
				
			}
			
			// Toggle for city text
			if ( $('#case-studies-form-wrapper').find('#geochars_id_for_text').is(':checked') ) {
				$('#case-studies-form-wrapper').find('.case-studies-tabbed-content-text-for-geochars').show();
			} else {
				$('#case-studies-form-wrapper').find('.case-studies-tabbed-content-text-for-geochars').hide();
			}
			

			// Toggle for transnational
			if ( $('#case-studies-form-wrapper').find('#chk_geo_chars_transnational').is(':checked') ) {
				$('#case-studies-form-wrapper').find('.case-studies-tabbed-content-table-for-translists').show();
			} else {
				$('#case-studies-form-wrapper').find('.case-studies-tabbed-content-table-for-translists').hide();
			}
			
			$('#case-studies-form-wrapper').find("input[name='rad_geo_chars']").change(function() {
				// test for subnational
				if ( $(this).is(':checked') && $(this).attr("id") == "chk_geo_chars_subnational" ) {
					$('#case-studies-form-wrapper').find('.case-studies-tabbed-content-table-for-lists').show();
				}
				else {
					$('#case-studies-form-wrapper').find('.case-studies-tabbed-content-table-for-lists').hide();
					
				}
				
				// test for city
				if ( $(this).is(':checked') && $(this).attr("id") == "geochars_id_for_text" ) {
					$('#case-studies-form-wrapper').find('.case-studies-tabbed-content-text-for-geochars').show();
				}
				else {
					$('#case-studies-form-wrapper').find('.case-studies-tabbed-content-text-for-geochars').hide();
				}
				
				// test for transnational
				if ( $(this).is(':checked') && $(this).attr("id") == "chk_geo_chars_transnational" ) {
					$('#case-studies-form-wrapper').find('.case-studies-tabbed-content-table-for-translists').show();
				}
				else {
					$('#case-studies-form-wrapper').find('.case-studies-tabbed-content-table-for-translists').hide();
					
				}
			});*/
			
			
			initWYSIWYG();
			addPhotoUpload();
			removePhotoUploadWrapper();
			addDocumentUpload();
			removeDocumentUploadWrapper();
			textAreaMaxLength();
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
		
		
		function removePhotoUploadWrapper(){
			var indexIncrement = 1;
			$('.case-studies-tabbed-content-photo-upload').each(function() {
				removePhotoUpload($(this).find('.case-studies-tabbed-content-button-remove-photo-' + indexIncrement));
				if (indexIncrement == 5)
				{
					$('.case-studies-tabbed-content-button-add-photo').unbind('click');
					$('.case-studies-tabbed-content-button-add-photo').click(function(e) {
						//alert("unbinding");
						e.preventDefault();
					});
					$('.case-studies-tabbed-content-button-add-photo').css({
						cursor: 'default',
						opacity: .25
					});
				}
				indexIncrement ++;
			});
		}
		
		
		function removeDocumentUploadWrapper(){
			var indexIncrement = 1;
			$('.case-studies-tabbed-content-document-upload').each(function() {
				removeDocumentUpload($(this).find('.case-studies-tabbed-content-button-remove-document-' + indexIncrement));
				if (indexIncrement == 5)
				{
					$('.case-studies-tabbed-content-button-add-document').unbind('click');
					$('.case-studies-tabbed-content-button-add-document').click(function(e) {
						//alert("unbinding");
						e.preventDefault();
					});
					$('.case-studies-tabbed-content-button-add-document').css({
						cursor: 'default',
						opacity: .25
					});
				}
				indexIncrement ++;
			});
		}

		function addPhotoUpload() {
			$('.case-studies-tabbed-content-button-add-photo').click(function(e) {
				e.preventDefault();
				
				var tmpPos = $(this).parent().parent().find('ul.case-studies-tabbed-content-photo-upload').length + 1;
				var tmpHTML = $('.case-studies-tabbed-content-photo-upload').first().clone();
				tmpHTML.find('.case-studies-tabbed-content-photo-upload-position').text( tmpPos );
				//alert("tmpPos is " + tmpPos);
				tmpHTML.find('.inputfile').html('<input name="supphotofiles' + tmpPos +'"' +  ' type="file" />');
				tmpHTML.find('.inputfilename').html('<input type="text" name="sup_photos_names' + tmpPos + '"' + ' size="30" maxlength="255" value="" />');
				tmpHTML.find('.inputfiledescription').html('<textarea cols="40" rows="10" name="sup_photos_description' + tmpPos + '"' + ' data-maxlength="250"></textarea>');
				//alert("tmpHTML is " + tmpHTML.html());
				if (tmpHTML.find('a').length > 0)
				{
				   //alert("anchor exists");	
				   tmpHTML.find('a').replaceWith( '<a href="#" class="case-studies-tabbed-content-button-remove-photo-' + tmpPos + '">[remove]</a>' );
				}
				else
				{
				   tmpHTML.find('.case-studies-tabbed-content-photo-upload-header').append( '<a href="#" class="case-studies-tabbed-content-button-remove-photo-' + tmpPos + '">[remove]</a>' );
				}
			
                //alert(tmpHTML.html());
				if ( tmpPos <= 5 ) {
					$(this).parent().before( tmpHTML );
					$("#photocounter").val(tmpPos);
		
					// add functionality to remove photo upload
					removePhotoUpload( '.case-studies-tabbed-content-button-remove-photo-' + tmpPos );

					// disable the add photo button
					if ( tmpPos == 5 ) {
						$(this).unbind('click');

						$(this).click(function(e) {
							e.preventDefault();
						});

						$(this).css({
							cursor: 'default',
							opacity: .25
						});
					}
				}
				//alert("photcounter is " + $("#photocounter").val());
			});
		}
		
		function addDocumentUpload() {
			$('.case-studies-tabbed-content-button-add-document').click(function(e) {
				e.preventDefault();
				
				var tmpPos = $(this).parent().parent().find('ul.case-studies-tabbed-content-document-upload').length + 1;
				var tmpHTML = $('.case-studies-tabbed-content-document-upload').first().clone();
				tmpHTML.find('.case-studies-tabbed-content-document-upload-position').text( tmpPos );
				tmpHTML.find('.case-studies-tabbed-content-document-name').text( 'Document File ' + tmpPos + ':' );
				//alert("tmpPos is " + tmpPos);
				tmpHTML.find('.inputfile').html('<input name="supdocfiles' + tmpPos +'"' +  ' type="file" />');
				tmpHTML.find('.inputfilename').html('<input type="text" name="sup_docs_names' + tmpPos + '"' + ' size="30" maxlength="255" value="" />');
				tmpHTML.find('.inputfiledescription').html('<textarea cols="40" rows="10" name="sup_docs_description' + tmpPos + '"' + ' data-maxlength="150"></textarea>');
				//alert("tmpHTML is " + tmpHTML.html());
				
				if (tmpHTML.find('a').length > 0)
				{
				   //alert("anchor exists");	
				   tmpHTML.find('a').replaceWith( '<a href="#" class="case-studies-tabbed-content-button-remove-document-' + tmpPos + '">[remove]</a>' );
				}
				else
				{
				   tmpHTML.find('.case-studies-tabbed-content-document-upload-header').append( '<a href="#" class="case-studies-tabbed-content-button-remove-document-' + tmpPos + '">[remove]</a>' );
				}
				
			    //alert(tmpHTML.html());
				
				//tmpHTML.find('.case-studies-tabbed-content-document-upload-header').append( '<a href="#" class="case-studies-tabbed-content-button-remove-document-' + tmpPos + '">[remove]</a>' );

				if ( tmpPos <= 5 ) {
					$(this).parent().before( tmpHTML );
					$("#doccounter").val(tmpPos);

					// add functionality to remove documet upload
					removeDocumentUpload( '.case-studies-tabbed-content-button-remove-document-' + tmpPos );

					// disable the add photo button
					if ( tmpPos == 5 ) {
						$(this).unbind('click');

						$(this).click(function(e) {
							e.preventDefault();
						});

						$(this).css({
							cursor: 'default',
							opacity: .25
						});
					}
				}
				//alert("doccounter is " + $("#doccounter").val());
			});
		}

		function removePhotoUpload( btn_selector ) {
			$( btn_selector ).click(function(e) {
				e.preventDefault();
				//alert("removing");
				var htmlContainer = $(this).parent().parent().html();
				//alert(htmlContainer);
				$(this).parent().parent().remove();
				

				if ( $('ul.case-studies-tabbed-content-photo-upload').length < 5) {
					$('.case-studies-tabbed-content-button-add-photo').css({
						cursor: '',
						opacity: 1
					});

					$('.case-studies-tabbed-content-button-add-photo').unbind('click');
					addPhotoUpload();
				}

				$('ul.case-studies-tabbed-content-photo-upload').each(function() {
					$(this).find('.case-studies-tabbed-content-photo-upload-position').text( $(this).index('ul.case-studies-tabbed-content-photo-upload') + 1 );
				});
				var indexIncrement = 1;
				$('.case-studies-tabbed-content-photo-upload').each(function(){
					$(this).find('.inputfile').children('input[type="file"]').attr('name', 'supphotofiles' + indexIncrement);
					$(this).find('.inputfilename').children('input[type="text"]').attr('name', 'sup_photos_names' + indexIncrement);
					$(this).find('.inputfiledescription').children('textarea').attr('name', 'sup_photos_description' + indexIncrement);
					indexIncrement++;

				});
				var photoCounterVar = indexIncrement - 1;
				$("#photocounter").val(photoCounterVar);
				//alert("photcounter is " + $("#photocounter").val());
				// remove the add photo button 
				if (photoCounterVar == 0)
				{
					//alert("tabbed content section is " + $('.case-studies-tabbed-content-section:eq(1)'));
					//alert("removable section is " + $('.case-studies-tabbed-content > ul:nth-child(1) > li:nth-child(4) > div:nth-child(3)').html());
					//$('.case-studies-tabbed-content > ul:first > li:eq[3]').children('.case-studies-tabbed-content-section:eq(1)').remove();
					$('.case-studies-tabbed-content > ul:nth-child(1) > li:nth-child(4) > div:nth-child(3)').remove();
				
				}
			});
		}

		function removeDocumentUpload( btn_selector ) {
			$( btn_selector ).click(function(e) {
				e.preventDefault();
				$(this).parent().parent().remove();

				if ( $('ul.case-studies-tabbed-content-document-upload').length < 5) {
					$('.case-studies-tabbed-content-button-add-document').css({
						cursor: '',
						opacity: 1
					});

					$('.case-studies-tabbed-content-button-add-document').unbind('click');
					addDocumentUpload();
				}

				$('ul.case-studies-tabbed-content-document-upload').each(function() {
					$(this).find('.case-studies-tabbed-content-document-upload-position').text( $(this).index('ul.case-studies-tabbed-content-document-upload') + 1 );
				});
				
				var indexIncrement = 1;
				$('.case-studies-tabbed-content-document-upload').each(function(){
					$(this).find('.inputfile').children('input[type="file"]').attr('name', 'supdocfiles' + indexIncrement);
					$(this).find('.inputfilename').children('input[type="text"]').attr('name', 'sup_docs_names' + indexIncrement);
					$(this).find('.inputfiledescription').children('textarea').attr('name', 'sup_docs_description' + indexIncrement);
					indexIncrement++;
				});
				
				var docCounterVar = indexIncrement - 1;
				$("#doccounter").val(docCounterVar);
				//alert("doccounter is " + $("#doccounter").val());
				// remove the add photo button 
				if (docCounterVar == 0)
				{
					// remove the header text
					//alert("to remove " + $('.case-studies-tabbed-content > ul:nth-child(1) > li:nth-child(4) > div:nth-child(4)').html());
					$('.case-studies-tabbed-content > ul:nth-child(1) > li:nth-child(4) > div:nth-child(4)').remove();
					//$('.case-studies-tabbed-content > ul:nth-child(1) > li:nth-child(4) > div:nth-child(4) > div:nth-child(1)').remove();
					//$('	.case-studies-tabbed-content > ul:nth-child(1) > li:nth-child(4) > div:nth-child(4) > p:nth-child(2)').remove();
				}
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

		// ==================== //
		// Portlet JS Ends Here //
		// ==================== //