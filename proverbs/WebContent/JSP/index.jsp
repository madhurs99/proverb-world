<script src="javascript/jquery.js" type="text/javascript"></script>
<script src="javascript/jquery.cookie.js" type="text/javascript"></script>
<script>
var langCookie = $.cookie('proverbLanguage');
if(langCookie === undefined || langCookie == ""){
	langCookie = 'pa';
}
/*alert(window.location.href)*/
window.location.href = window.location+'/welcome.do?command=home&userLanguage='+langCookie;
</script>

