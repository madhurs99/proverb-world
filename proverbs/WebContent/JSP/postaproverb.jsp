<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/struts-nested" prefix="nested"%>
<head>
	<script type="text/javascript" src="https://www.google.com/jsapi?key=INSERT-YOUR-KEY"></script>
    <script type="text/javascript">

      // Load the Google Transliterate API
      google.load("elements", "1", {
            packages: "transliteration"
      });
      var control;
      var control1;
      var selectedLang

      function onLoad() {
    	selectedLang = $('select option:selected').val();
        var options = {
        	sourceLanguage:google.elements.transliteration.LanguageCode.ENGLISH,
            destinationLanguage:[selectedLang],
            shortcutKey: 'ctrl+g',
            transliterationEnabled: true
        };

        // Create an instance on TransliterationControl with the required
        // options.
        control = new google.elements.transliteration.TransliterationControl(options);
        control1 = new google.elements.transliteration.TransliterationControl(options);

        // Enable transliteration in the textbox with id
        // 'transliterateTextarea'.
        control.makeTransliteratable(['proverbDescription']);
        control1.makeTransliteratable(['proverb']);
        
      }
      google.setOnLoadCallback(onLoad);
      function changeLanguage(){
    	  selectedLang = $('select option:selected').val();
    	  control.setLanguagePair(
    			    google.elements.transliteration.LanguageCode.ENGLISH,
    			    selectedLang);
    	  control1.setLanguagePair(
  			    google.elements.transliteration.LanguageCode.ENGLISH,
  			    selectedLang);
      }
   </script>
  </head>
<!--   <body>
    Type in Hindi (Press Ctrl+g to toggle between English and Hindi)<br>
    <textarea id="transliterateTextarea" style="width:600px;height:200px"></textarea>
  </body> -->


<body link="purple" alink="purple" vlink="purple">
<input id="highlight" value="post" type="hidden">
<logic:equal name="posted" value="true">
<center><strong>
Thanks for posting
</strong>
</center>
</logic:equal>
<br>
<br>
<br>
<html:form action="/post">
	<font color="red"><html:errors /></font>
	<html:hidden property="proverbID" />
	<html:hidden property="selectedLanguange" />
	<table width="100%">
		<tr>
			<td width="10%" />
			<td width="20%"><bean:message key="proverb" />*</td>
			<td width="70%"><html:textarea styleId="proverb" property="proverb" rows="3"
				cols="50"></html:textarea>
			</td>
		</tr>
		<tr>
			<td width="10%" />
			<td width="20%"><bean:message key="description" /></td>
			<td width="70%"><html:textarea rows="3" cols="50" styleId="proverbDescription" property ="proverbDescription"></html:textarea>
			</td>
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















