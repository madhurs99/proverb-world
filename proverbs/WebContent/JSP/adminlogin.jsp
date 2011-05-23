<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<input id="highlight" value="admin" type="hidden">
<br>
<br>
<br>
<br>
<br>
<html:form action="/login" focus="username">
	<bean:message key="username" />
	<html:text property="username" size="35" maxlength="35" />
	<br>
	<br>
	<bean:message key="password" />
	<html:password property="password" size="35" maxlength="35" />
	<br>
	<br>
	<html:submit />
</html:form>