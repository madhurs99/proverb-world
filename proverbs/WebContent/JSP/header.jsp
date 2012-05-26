<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<HEAD>
<title>Proverbs</title>
</HEAD>
<div id="header">
	<div class="floatLeft">
		<img src="images/pro.png" width="120" height="120">
	</div>
	<div class="button">
		<a href="welcome.do?command=home"><bean:message key="home" /></a>
	</div>
	<div class="button">
		<a href="welcome.do?command=post"><bean:message	key="post.a.proverb" /></a>
	</div>

	<div class="floatRight">
		<div class="floatRight">
			Select your language
			<select id="languageSelect" name ="language" onchange="javascript:changeLanguage();">
				<option value="pa">Punjabi</option>
				<option value="hi">Hindi</option>
				<option value="mr">Marathi</option>
				<option value="en">English</option>
			</select>
		</div>
	</div>
	<div class="clear_float"></div>
</div>
