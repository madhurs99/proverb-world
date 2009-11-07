<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/struts-nested" prefix="nested"%>

<script language="JavaScript" src="/proverbs/javascripts/common.htm"></script>
<script language="JavaScript" src="/proverbs/javascripts/punjabi.js"></script>
<script language="Javascript">
function findElement() {
	
	for(i=0; i<document.forms[0].elements.length; i++){
		if(document.forms[0].elements[i].type == 'textarea') {
			var elName = document.forms[0].elements[i].name;
			var elValue = document.forms[0].elements[i].value;
			if(elValue !="" && elValue.charAt(0)=='&' && elValue.charAt(1)=='#'){
				var finals = "";
				var add = 0;
				
				while(elValue.length > 0){
					if(elValue.charAt(0)=='&' && elValue.charAt(1)=='#'){
						finals = finals.concat(String.fromCharCode(elValue.substr(2,4).valueOf()));
						
					}
					if(elValue.charAt(7)==' '){
						finals = finals.concat(" ");
						add = 1;
					}
					elValue = elValue.substr(7+add);
					add = 0;
				}
				document.getElementById(elName).innerHTML=finals;
			}
		}
	}
}


</script>
<body link="purple" alink="purple" vlink="purple"
	onload="javascript:findElement()">
<logic:equal name="posted" value="true">
Thanks for posting
</logic:equal>
<br>
<br>
<br>
Type in English and get it converted to Unicode Punjabi.
<br>
Use
<b>F12</b>
to toggle between English &amp; Unicode Punjabi
<br>
<br>
<br>
<html:form action="/post">
	<font color="red"><html:errors /></font>
	<html:hidden property="proverbID" />
	<table width="100%">
		<tr>
			<td width="10%" />
			<td width="20%"><bean:message key="show.keymap" /></td>
			<td width="70%"><input onclick="showMap(this)" type="checkbox"></td>
		</tr>
		<tr>
			<td width="10%" />
			<td width="20%"><bean:message key="proverb" />*</td>
			<td width="70%"><html:textarea property="proverb" rows="3"
				cols="50" onkeypress="javascript:convertThis(event)"
				onkeydown="toggleKBMode(event)">
			</html:textarea></td>
		</tr>
		<tr>
			<td width="10%" />
			<td width="20%"><bean:message key="description" /></td>
			<td width="70%"><html:textarea property="description" rows="5"
				cols="50" onkeypress="javascript:convertThis(event)"
				onkeydown="toggleKBMode(event)" /></td>
		</tr>
		<tr>
			<td width="10%" />
			<td width="20%"><bean:message key="your.name" /></td>
			<td width="70%"><html:text property="submittedBy" size="35"
				maxlength="35" /></td>
		</tr>
		<tr>
			<td width="10%" />
			<td width="20%"><bean:message key="place" /></td>
			<td width="70%"><html:text property="submitterPlace" size="35"
				maxlength="35" /></td>
		</tr>
	</table>
	<br>
	<div align="center"><html:submit /></div>
</html:form>
</body>















