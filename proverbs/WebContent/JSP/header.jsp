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


<table width="100%" bgcolor="silver">
	<tr>
		<td width="25%"></td>
		<td width="40%"><font size="20">Proverb World</font></td>
		<td><img src="/proverbs/images/globe.png" height="30%"
			width="30%"></td>
	</tr>
</table>
<table width="100%" bgcolor="silver">
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
	</tr>
</table>










