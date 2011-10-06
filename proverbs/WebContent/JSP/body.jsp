<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="displaytag"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@page import="java.util.List"%>
<%@page import="com.proverbworld.beans.Proverb"%>
<%@page import="java.util.Iterator"%>
<br>
<div style='float: right; width: 40%'>
<table>
	<tr>
		<td><script
			src="http://www.gmodules.com/ig/ifr?url=http://www.google.com/cse/api/010198639056244782038/cse/4zh6xttlk_e/gadget&amp;synd=open&amp;w=320&amp;h=75&amp;title=&amp;border=%23ffffff%7C3px%2C1px+solid+%23999999&amp;output=js"></script>
		</td>
	</tr>
</table>
</div>
<div style='float: left; width: 60%'>
<table width="100%">
	<tr>
		<td width="100%">
		<table width="100%">
			<displaytag:table id="pr1" name="sessionScope.plist" pagesize="4" requestURI="welcome.do">
				<displaytag:column>
					<c:choose>
						<c:when test="${(pr1_rowNum %2) == 0}">
							<tr>
						</c:when>
						<c:otherwise>
							<tr bgcolor="f0f0f0">
						</c:otherwise>
					</c:choose>
					<!-- <td width="10%" /> -->
					<td width="80%"><font color="#000080"><b><c:out
						value="${pr1_rowNum}" />&nbsp;<c:out value="${pr1.proverb}"></c:out></b></font>
					<br>
					<i><bean:message key="description" />: </i> <c:out
						value="${pr1.description}"></c:out></td>
					<!-- <td width="10%" /> -->
					</tr>
				</displaytag:column>

			</displaytag:table>
		</table>

		</td>
	</tr>
</table>
</div>
<input id="highlight" value="home" type="hidden">