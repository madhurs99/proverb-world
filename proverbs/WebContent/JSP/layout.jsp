<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>
<script src="javascript/jquery.js" type="text/javascript"></script>
<script src="javascript/jquery.cookie.js" type="text/javascript"></script>
<script src="javascript/pw.js" type="text/javascript"></script>
<link rel="stylesheet" href="style/pw.css" type="text/css" />
<link rel="icon" href="images/favicon.png" type="image/x-icon">
   	<div id="container">
		<div id="header">
             <tiles:insert attribute="header" />
			 <div class="clear_float"></div>
        </div>
        <div id="content">
             <tiles:insert attribute="body" />
		</div>
		<div id="footer">
             <tiles:insert attribute="footer" />
        </div>
    </div>







