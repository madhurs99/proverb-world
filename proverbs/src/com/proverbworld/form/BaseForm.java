package com.proverbworld.form;

import org.apache.struts.action.ActionForm;

public class BaseForm extends ActionForm {
	
	private String selectedLanguange = "en";

	public String getSelectedLanguange() {
		return selectedLanguange;
	}

	public void setSelectedLanguange(String selectedLanguange) {
		this.selectedLanguange = selectedLanguange;
	}
}