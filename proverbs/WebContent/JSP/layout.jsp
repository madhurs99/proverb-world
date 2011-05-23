<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>
<script src="javascript/jquery.js" type="text/javascript"></script>
<script src="javascript/jquery.cookie.js" type="text/javascript"></script>
<script src="javascript/pw.js" type="text/javascript"></script>
<style>
<!--
#container{
	margin: 0 auto;
	width: 1024px;
}
.lower_border {
	border-style: solid;
	border-width: 0px 0px 1px 0px;
}
#content {
	min-height: 100px;
	height: auto !important;
	height: 430px;
	padding: 20px 0px 40px 0px;
}
-->
</style>
    	<div id="container">
			<div id="header" class="lower_border">
                    <tiles:insert attribute="header" />
            </div>
            <div id="content">
                    <tiles:insert attribute="body" />
			</div>
			<div id="footer">
                    <tiles:insert attribute="footer" />
            </div>
        </div>







