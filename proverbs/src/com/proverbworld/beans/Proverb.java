package com.proverbworld.beans;

import java.io.UnsupportedEncodingException;



public class Proverb {
	
	private int proverbID;
	private String proverb;
	private String description;
	private boolean approved;
	private String submittedBy;
	private String submitterPlace;
	private String language;
	
	public int getProverbID() {
		return proverbID;
	}
	public void setProverbID(int proverbID) {
		this.proverbID = proverbID;
	}
	public String getProverb() {
//		try {
//			this.proverb = new String(proverb.getBytes("ISO-8859-1"),"ISO-8859-1");
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return proverb;
	}
	public void setProverb(String proverb) {
		
		try {
			this.proverb = new String(proverb.getBytes("UTF8"),"UTF8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.proverb = proverb;
	}
	public String getDescription() {
//		try {
//			this.description = new String(description.getBytes("ISO-8859-1"),"ISO-8859-1");
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return description;
	}
	public void setDescription(String description) {
//		try {
//			this.description = new String(description.getBytes("UTF8"),"UTF8");
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
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
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
}



