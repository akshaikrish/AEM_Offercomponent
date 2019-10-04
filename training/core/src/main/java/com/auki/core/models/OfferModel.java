package com.auki.core.models;


public class OfferModel {
	
	
	private String validity;
	
	
	private String description;
	
	
	private String fileReference;
	
	
	
	
	public OfferModel(String fileReference, String validity, String description) {
		super();
		this.validity = validity;
		this.description = description;
		this.fileReference = fileReference;
	}

	public String getValidity() {
		return validity;
	}

	public void setValidity(String validity) {
		this.validity = validity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFileReference() {
		return fileReference;
	}

	public void setFileReference(String fileReference) {
		this.fileReference = fileReference;
	}
	
		
	
	
}
