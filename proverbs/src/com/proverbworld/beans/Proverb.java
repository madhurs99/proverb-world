package com.proverbworld.beans;



public class Proverb {
	
	private int proverbID;
	private String proverb;
	private String description;
	private boolean approved;
	private String submittedBy;
	private String submitterPlace;
	
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
}

