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
    
    //Add a bottom line to the search results windows on the Search and Discover page
    $(".search-discover .resultlist:last-child").css({"border-bottom":"2px solid #d7e3ef"});
    
});
