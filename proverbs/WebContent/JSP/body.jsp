<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="displaytag"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>



<%@page import="java.util.List"%>
<%@page import="com.proverbworld.beans.Proverb"%>
<%@page import="java.util.Iterator"%>
<!-- <div id="gSearch">
    <script	src="http://www.gmodules.com/ig/ifr?url=http://www.google.com/cse/api/010198639056244782038/cse/4zh6xttlk_e/gadget&amp;synd=open&amp;w=320&amp;h=75&amp;title=&amp;border=%23ffffff%7C3px%2C1px+solid+%23999999&amp;output=js">
    </script>
</div> -->
<br>
<div style='float: right; width: 40%'>

</div>
<div style='float: left; width: 60%'>
<table width="100%">
	<tr>
		<td width="100%">
		<table >
			<displaytag:table id="pr1" name="sessionScope.plist" pagesize="4" requestURI="welcome.do" >
				<displaytag:column>
					<tr>
						<td width="600px">
							<div name="proverb">
								<font color="#696969"><b>
								<img src="images/expand.png" name="descriptionImg">&nbsp;<c:out value="${pr1.proverb}"></c:out></b></font>
							
								<div name="description" style="background-color: #e8e8e8">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font><c:out value="${pr1.description}"></c:out></font>
								</div>
							</div>
						</td>
					</tr>
				</displaytag:column>
			</displaytag:table>
		</table>

		</td>
	</tr>
</table>
</div>
<input id="highlight" value="home" type="hidden">