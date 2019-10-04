package com.auki.core.models;


import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Required;

import com.auki.core.impl.Training_service;
import com.auki.core.services.TrainingIntf;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Offercomponent {
	@Inject
	private TrainingIntf train;
	
	
	@Inject
	private String fileReference;
	
	@Inject
	private String validity;
	
	@Inject
	private String description;
	
	private String name;
	
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
	
//	@PostConstruct
//	protected void init() {
//		validity = train.firstname();
//		description = train.secondname();
//	}
	
	
}
