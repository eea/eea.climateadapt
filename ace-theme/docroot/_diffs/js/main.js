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
	$("ul li:first-child").addClass("first");
	
    $("ul li:last-child").addClass("last");
    
    if ($("#sec-menu ul").length == 0){
    	  $("#navigation .selected").css("background","none");
    }
});
