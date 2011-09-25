$(document).ready(function(){
	var langCookie = $.cookie('proverbLanguage');
	if(langCookie == undefined){
		$.cookie('proverbLanguage', $('select option:selected').val(), { expires: 7 });
	} else {
		$('select option[value='+langCookie+']').attr("selected", "selected");
	}
	$('a').click(function(event){
		var href = $(this).attr('href');
		$(this).attr('href', href+'&userLanguage='+langCookie);
	});
	$('form').submit(function(event){
		var action = $(this).attr('action');
		$(this).attr('action', action+'?userLanguage='+langCookie);
	});
	/* For highlighting menu */
	var page = $('#highlight').val();
	if(page == 'home'){
		$('#dolphinnav a:eq(0)').addClass('current');
	}else if(page == 'post'){
		$('#dolphinnav a:eq(1)').addClass('current');
	}else if(page == 'contact'){
		$('#dolphinnav a:eq(2)').addClass('current');
	}else if(page == 'admin'){
		$('#dolphinnav a:eq(3)').addClass('current');
	}
});

function changeLanguage(){
	$.cookie('proverbLanguage', $('select option:selected').val());
	var sURL = window.location.pathname;
	window.location.href = sURL+'?command=home&userLanguage='+$('select option:selected').val();
}

