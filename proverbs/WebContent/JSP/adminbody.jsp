<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<input id="highlight" value="admin" type="hidden">
<table width="100%">
	<tr>
		<td><logic:equal name="showApproved" value="true">
			<a href="admin.do?command=showProverbs"><bean:message
				key="show.un.approved" /></a>
		</logic:equal> <logic:equal name="showApproved" value="false">
			<a href="admin.do?command=showProverbs"><bean:message
				key="show.approved" /></a>
		</logic:equal></td>
		<td align="right"><a href="admin.do?command=logout"><bean:message
			key="logout" /></a><br>
		<br>
		</td>
	</tr>
</table>
<br>
<table width="100%">
	<logic:iterate id="pr" name="plist" indexId="index">
		<tr>
			<td width="20%" />
			<td width="70%"><font color="purple"><b>${index+1}.&nbsp;<bean:write
				filter="false" name="pr" property="proverb" /></b></font><br>
			<i><bean:message key="description" /></i>:<bean:write filter="false"
				name="pr" property="description" /><br>
			<a
				href="admin.do?command=edit&id=<bean:write name="pr" property="proverbID" />"><bean:message
				key="edit" /></a>&nbsp; <a
				href="admin.do?command=delete&id=<bean:write name="pr" property="proverbID" />"><bean:message
				key="delete" /></a> <a
				href="admin.do?command=approve&id=<bean:write name="pr" property="proverbID" />"><bean:message
				key="approve" /></a><br>
			<br>
			</td>
			<td width="10%" />
		</tr>

	</logic:iterate>
</table>