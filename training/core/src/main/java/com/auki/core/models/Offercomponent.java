package com.auki.core.models;


import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Required;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Offercomponent {
	@Inject
	private String fileReference;
	@Inject
	private String validity;
	@Inject
	private String description;
	
	
	
	
	public String getFileReference() {
		return fileReference;
	}
	public void setFileReference(String fileReference) {
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
	
	
}
