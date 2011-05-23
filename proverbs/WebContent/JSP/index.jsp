<script src="javascript/jquery.js" type="text/javascript"></script>
<script src="javascript/jquery.cookie.js" type="text/javascript"></script>
<script>
var langCookie = $.cookie('proverbLanguage');
window.location = window.location.href+'&userLanguage='+langCookie;
</script>

