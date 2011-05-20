package com.proverbworld.form;

import com.proverbworld.beans.Proverb;

public class ProverbForm extends BaseForm {
	
	private int proverbID = 0;
	private String proverb = "";
	private String description = "";
	private boolean approved = false;
	private String submittedBy = "";
	private String submitterPlace = "";

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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
		proverbBean.setDescription(this.description);
		proverbBean.setSubmittedBy(this.submittedBy);
		proverbBean.setSubmitterPlace(this.submitterPlace);
		proverbBean.setApproved(this.approved);
				
		return proverbBean;
	}
	
	public void setProverbBean(Proverb proverbBean){
		
		setProverb(proverbBean.getProverb());
		setProverbID(proverbBean.getProverbID());
		setDescription(proverbBean.getDescription());
		setSubmittedBy(proverbBean.getSubmittedBy());
		setSubmitterPlace(proverbBean.getSubmitterPlace());
		setApproved(proverbBean.isApproved());
		
	}
	
	public void clearForm(){
		
		setProverb("");
		setProverbID(0);
		setDescription("");
		setSubmittedBy("");
		setSubmitterPlace("");
		setApproved(false);
		
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
}
