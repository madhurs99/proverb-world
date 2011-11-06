$(document).ready(function(){
	
	var langCookie = $.cookie('proverbLanguage');
	if(langCookie == undefined){
		$.cookie('proverbLanguage', $('select option:selected').val(), { expires: 7 });
	} else {
		$('select option[value='+langCookie+']').attr("selected", "selected");
	}
	
	//Submit language on all link clicks
	$('a').click(function(event){
		var href = $(this).attr('href');
		$(this).attr('href', href+'&userLanguage='+langCookie);
	});
	
	$('form').submit(function(event){
		var action = $(this).attr('action');
		$(this).attr('action', action+'?userLanguage='+langCookie);
	});
	
	$('[name=descriptionImg]').mouseenter(function(){
		$(this).parent().parent().next().show('slow');
		$(this).attr('src', 'images/collapse.png');
	}).mouseleave(function(){
		//$(this).parent().parent().next().hide('slow');
	});
	
	$('[name=description]').hide();
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
	alert(sURL)
}
function onSelectToggle(){
	$('[name=selectProverbCB]').attr('checked', true);
}
function onModify(action){
	var idList = '';
	$('[name=selectProverbCB]:checked').each(function(){
		idList += $(this).attr('id')+",";
	});
	var listLength = idList.length;
	if(listLength>0){
		idList = idList.substring(0, listLength-1)
	}
	window.location.href = '/proverbs/admin.do?command='+action+'&idList='+idList;
}
