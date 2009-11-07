<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>


<%@page import="java.util.List"%>
<%@page import="com.proverbworld.beans.Proverb"%>
<%@page import="java.util.Iterator"%><br>
<br>
<br>


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
			<td width="70"><font color="purple"><b>${index+1}.&nbsp;<bean:write
				filter="false" name="pr" property="proverb" /></b></font><br>
			<i><bean:message key="description" /></i>:<bean:write filter="false"
				name="pr" property="description" /><br>
			</td>
			<td width="10%" />
		</tr>

	</logic:iterate>
</table>