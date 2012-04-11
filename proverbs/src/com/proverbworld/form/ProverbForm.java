package com.proverbworld.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.proverbworld.beans.Proverb;
import com.proverbworld.common.Language;

public class ProverbForm extends BaseForm {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int proverbID = 0;
	private String proverb = "";
	private String proverbDescription = "";
	private boolean approved = false;
	private String submittedBy = "";
	private String submitterPlace = "";
	private String language="";

	public int getProverbID() {
		return proverbID;
	}
	public void setProverbID(int proverbID) {
		this.proverbID = proverbID;
	}
	public String getProverb() {
		return proverb;
	}
	public void setProverb(String proverb) {
		this.proverb = proverb;
	}

	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	public String getSubmittedBy() {
		return submittedBy;
	}
	public void setSubmittedBy(String submittedBy) {
		this.submittedBy = submittedBy;
	}
	public String getSubmitterPlace() {
		return submitterPlace;
	}
	public void setSubmitterPlace(String submitterPlace) {
		this.submitterPlace = submitterPlace;
	}
	
	public Proverb getProverbBean(){
		
		Proverb proverbBean = new Proverb();
		proverbBean.setProverb(this.proverb);
		proverbBean.setProverbID(this.proverbID);
		proverbBean.setDescription(this.proverbDescription);
		proverbBean.setSubmittedBy(this.submittedBy);
		proverbBean.setSubmitterPlace(this.submitterPlace);
		proverbBean.setApproved(this.approved);
		proverbBean.setLanguage(this.language);		
		return proverbBean;
	}
	
	public void setProverbBean(Proverb proverbBean){
		
		setProverb(proverbBean.getProverb());
		setProverbID(proverbBean.getProverbID());
		setProverbDescription(proverbBean.getDescription());
		setSubmittedBy(proverbBean.getSubmittedBy());
		setSubmitterPlace(proverbBean.getSubmitterPlace());
		setApproved(proverbBean.isApproved());
		setLanguage(proverbBean.getLanguage());
		
	}
	
	public void clearForm(){
		
		setProverb("");
		setProverbID(0);
		setProverbDescription("");
		setSubmittedBy("");
		setSubmitterPlace("");
		setApproved(false);
		setLanguage(Language.PUNJABI);
		
	}	
//	public ActionErrors validate(ActionMapping mapping,	HttpServletRequest request) {
//		ActionErrors actionErrors = new ActionErrors();
//
//		if(getProverb()== null || getProverb().equals("")){
//			actionErrors.add("proverb", new ActionMessage("proverb"));
//
//		}
//		return actionErrors;
//	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public void reset(ActionMapping mapping, HttpServletRequest request){
		clearForm();
	}
	public String getProverbDescription() {
		return proverbDescription;
	}
	public void setProverbDescription(String proverbDescription) {
		this.proverbDescription = proverbDescription;
	}
}
