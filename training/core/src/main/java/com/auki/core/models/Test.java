package com.auki.core.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.Required;

import com.auki.core.impl.Training_service;
import com.auki.core.services.TrainingIntf;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Test {
	
	
	@Inject
	private Training_service train;
	
	@Inject 
	private String text;
	
	@Inject 
	private String title;
	
	@Inject
	private String pathbrowser;
	
	private String imagename; 
	private String name;
	
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPathbrowser() {
		return pathbrowser;
	}
	public void setPathbrowser(String pathbrowser) {
		this.pathbrowser = pathbrowser;
	}
	
	
	
	
	public String getImagename() {
		return imagename;
	}
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	@PostConstruct
	protected void init() {
		train.secondname();
	}
	
	
	
	
}
