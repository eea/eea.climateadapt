AUI().ready(
	'liferay-hudcrumbs',
	function(A) {
		if (Liferay.Browser.isIe() && Liferay.Browser.getMajorVersion() < 7) {
			var navigation = A.one('#navigation > ul');

			if (navigation) {
				navigation.delegate(
					'mouseenter',
					function(event) {
						event.currentTarget.addClass('hover');
					},
					'> li'
				);

				navigation.delegate(
					'mouseleave',
					function(event) {
						event.currentTarget.removeClass('hover');
					},
					'> li'
				);
			}
		}

		var siteBreadcrumbs = A.one('.site-breadcrumbs');

		if (siteBreadcrumbs) {
			siteBreadcrumbs.plug(A.Hudcrumbs);
		}
	}
);

//All JQuery stuff after this point

$(document).ready(function(){
	
	//Several classes for the main menu
	$("ul li:first-child").addClass("first");
    $("ul li:last-child").addClass("last");
    $('li').has('ul').addClass('submenu');
    
    //Elements for the db search speedbutton on the frontpage
    $(".db-search-fp img").attr("src","/ace-theme/images/vergroot_blauw.png");
    $('.db-search-fp .portlet-body').prepend('<p id="db-search-fp-info-text">Search the database</p>');
    $('.db-search-fp .portlet-body').prepend('<a id="db-search-fp-link" href="/data-and-downloads"></a>');
    
    //Fixes to main and sec. menu
    if ($("#sec-menu ul").length == 0){
    	  $("#navigation .selected").css({"background":"none","border":"none", "margin-top":"7px"});
    	  $("#topnav").css({"border-bottom":"1px solid #a5bf26"});
    	  $("ul#topnav li.selected a").css({"color":"#FFF"});
    }
    
});
