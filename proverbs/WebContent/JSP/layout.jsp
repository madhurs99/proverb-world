<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML+RDFa 1.0//EN" "http://www.w3.org/MarkUp/DTD/xhtml-rdfa-1.dtd">
<html xmlns:og="http://ogp.me/ns#" xmlns:fb="https://www.facebook.com/2008/fbml">
<head>
	<title>Proverb World</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta property="og:title" content="Proverb World" />
		<meta property="og:type" content="website" />
		<meta property="og:url" content="http://www.proverbworld.com/welcome.do?command=home" />
		<meta property="og:image" content="http://www.proverbworld.com//images/pro1.png" />
		<meta property="og:site_name" content="proverbworld.com" />
		<meta property="og:description" content="The site aims at creating a comprehensive collection of proverbs in various languages - English, Punjabi, Hindi, Marathi, Telugu and Kannada."/>
		<meta property="fb:admins" content="100001629855783" />
	<%@ taglib uri="/tags/struts-html" prefix="html"%>
	<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
	<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
	<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>
	<script src="javascript/jquery.js" type="text/javascript"></script>
	<script src="javascript/jquery.cookie.js" type="text/javascript"></script>
	<script src="javascript/pw.js" type="text/javascript"></script>
	<link rel="stylesheet" href="style/pw.css" type="text/css" />
	<link rel="icon" href="images/favicon1.png" type="image/x-icon">
</head>
<body>
<div id="fb-root"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/en_US/all.js#xfbml=1&appId=352440801506295";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>
   	<div id="container">
		<div id="header">
             <tiles:insert attribute="header" />
			 <div class="clear_float"></div>
        </div>
        <div id="content">
             <tiles:insert attribute="body" />
		</div>
		<div id="footer">
             <tiles:insert attribute="footer" />
        </div>
    </div>
</body>
</html>







