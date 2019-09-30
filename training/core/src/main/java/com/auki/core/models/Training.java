package com.auki.core.models;


import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;

@Model(adaptables = Resource.class)
public class Training {
	@Inject @Optional
	private String searchRoot;

	public String getSearchRoot() {
		return searchRoot;
	}

	public void setSearchRoot(String searchRoot) {
		this.searchRoot = searchRoot;
	}
	
	
//	@PostConstruct
//	protected void init() {
//		this.searchRoot= "Construction done";
//	}

}
