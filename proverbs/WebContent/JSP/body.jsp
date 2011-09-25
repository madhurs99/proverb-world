<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<META http-equiv="Content-Type" content="text/html; charset="utf-8">
<%@page import="java.util.List"%>
<%@page import="com.proverbworld.beans.Proverb"%>
<%@page import="java.util.Iterator"%><br>
<div style='float:right; width:35%'>
<table>
<tr>
<td>
<script src="http://www.gmodules.com/ig/ifr?url=http://www.google.com/cse/api/010198639056244782038/cse/4zh6xttlk_e/gadget&amp;synd=open&amp;w=320&amp;h=75&amp;title=&amp;border=%23ffffff%7C3px%2C1px+solid+%23999999&amp;output=js"></script>
</td>
</tr>
</table>
</div>
<div style='float:left; width:65%'>
<table width="100%">
<tr>
<td width="100%">
<table width="100%">
	
		
	<logic:iterate id="pr" name="plist" indexId="index">

		<tr>
			<%
if(index.intValue()%2==0){%>
		
		<tr>
			<%}else{ %>
		
		<tr bgcolor="f0f0f0">
			<% }%>
			<td width="10%" />
			<td width="80%"><font color="#000080"><b>${index+1}.&nbsp;<bean:write
				filter="false" name="pr" property="proverb" /></b></font><br>
			<i><bean:message key="description" /></i>:<bean:write filter="false"
				name="pr" property="description" /><br>
			</td>
			<td width="10%" />
		</tr>

	</logic:iterate>
</table>
</td>
</tr>
</table>
</div>
<input id="highlight" value="home" type="hidden">