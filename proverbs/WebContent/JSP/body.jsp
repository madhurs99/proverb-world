<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<META http-equiv="Content-Type" content="text/html; charset="utf-8">
<%@page import="java.util.List"%>
<%@page import="com.proverbworld.beans.Proverb"%>
<%@page import="java.util.Iterator"%><br>
<br>
<br>
<div id="cse" style="width: 100%;">Loading</div>
<script src="http://www.google.com/jsapi" type="text/javascript"></script>
<script type="text/javascript"> 
  google.load('search', '1', {language : 'en'});
  google.setOnLoadCallback(function() {
    var customSearchControl = new google.search.CustomSearchControl('010198639056244782038:4zh6xttlk_e');
    customSearchControl.setResultSetSize(google.search.Search.SMALL_RESULTSET);
    customSearchControl.draw('cse');
  }, true);
</script>
      
<input id="highlight" value="home" type="hidden">
<table width="100%">
<tr>
			<td width="10%" />
			<td width="10%"><bean:message key="language" /></td>
			<td width="80%">
				<select id ="language" onchange="javascript:changeLanguage();">
				<option value="pa">Punjabi</option>
				<option value="hi">Hindi</option>
				<option value="mr">Marathi</option>
				<option value="en">English</option>
			</select>
			</td>
		</tr>
		</table>
<table width="100%">
	
		
	<logic:iterate id="pr" name="plist" indexId="index">

		<tr>
			<%
if(index.intValue()%2==0){%>
		
		<tr>
			<%}else{ %>
		
		<tr bgcolor="f0f0f0">
			<% }%>
			<td width="20%" />
			<td width="70"><font color="#000080"><b>${index+1}.&nbsp;<bean:write
				filter="false" name="pr" property="proverb" /></b></font><br>
			<i><bean:message key="description" /></i>:<bean:write filter="false"
				name="pr" property="description" /><br>
			</td>
			<td width="10%" />
		</tr>

	</logic:iterate>
</table>