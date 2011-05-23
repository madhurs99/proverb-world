<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<HEAD>
<title>Proverbs</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</HEAD>
<link rel="stylesheet" href="style/styles.css" type="text/css" />

<table width="100%" class="shade">
	<tr>
		
		<td width="40%"><font size="30" face="brush script mt">ProverbWorld.com</font></td>
		<td width="35%"></td>
		<td width="25%" valign="top">
						<table>
	<tr >
		<td>Select your language</td>
		<td>
			<select id="languageSelect" onchange="javascript:changeLanguage();">
				<option value="pa">Punjabi</option>
				<option value="hi">Hindi</option>
				<option value="mr">Marathi</option>
				<option value="en">English</option>
			</select>
		</td>
	</tr>
		</table>
			</td>
	</tr>
</table>
<div id="dolphincontainer">
  <div id="dolphinnav">
    <ul>
      <li><a href="welcome.do?command=home"><span><bean:message
			key="home" /></span></a></li>
      <li><a href="welcome.do?command=post"><span><bean:message
			key="post.a.proverb" /></span></a></li>
      <li><a href="welcome.do?command=contact"><span><bean:message
			key="contact.us" /></span></a></li>
      <li><a href="welcome.do?command=adminlogin"><span><bean:message
			key="admin.login" /></span></a></li>
    </ul>
  </div>
  </div>
<!-- <table width="100%" bgcolor="silver">
	<tr>
		<td width="10%"><a href="welcome.do?command=home"><bean:message
			key="home" /></a></td>
		<td width="15%"><a href="welcome.do?command=post"><bean:message
			key="post.a.proverb" /></a></td>
		<td><a href="welcome.do?command=contact"><bean:message
			key="contact.us" /></a></td>
		<td width="60%" align="right"><a
			href="welcome.do?command=adminlogin"> <bean:message
			key="admin.login" /></a></td>
			<td>

			</td>
	</tr>
</table> -->










