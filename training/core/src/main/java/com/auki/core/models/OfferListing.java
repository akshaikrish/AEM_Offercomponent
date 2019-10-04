package com.auki.core.models;

import java.util.ArrayList;
import java.util.Iterator;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import com.day.cq.wcm.api.Page;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)	
public class OfferListing {
	 @Inject
	 private ResourceResolver resourceResolver; 
	 
	 private String child;
	 
	 private ArrayList<OfferModel> offerList = new ArrayList<>();

	

	public String getChild() {
		return child;
	}

	public void setChild(String child) {
		this.child = child;
	}
	 
	@PostConstruct
	 protected void init() {
		
		try {
			String pagePath = "/content/auki/cg";
		    Resource resource = resourceResolver.getResource(pagePath);
		    Page parentPage = resource.adaptTo(Page.class);
		    Iterator<Page> children = parentPage.listChildren();
		    while(children.hasNext()) {
		    	Page childPage = children.next();
		    	child= childPage.getName();
			    try {
			    
	
			    	Resource getResource = resourceResolver.getResource("/content/auki/cg/"+child+"/jcr:content/root/offerlayout");
			 	    ValueMap properties = getResource.adaptTo(ValueMap.class);
			 	    String imagePath = properties.get("fileReference", String.class);
			 	    String validity = properties.get("validity", String.class);
			 	    String description = properties.get("description", String.class);
			 	    OfferModel newOffer = new OfferModel(imagePath, validity, description);
			 	    offerList.add(newOffer);
			 	   
			    
			    }
			    catch(Exception e) {}
		    }
		      
			
		}
		catch(Exception e) {}
	 }

	public ArrayList<OfferModel> getOfferList() {
		return offerList;
	}
	
	 
	 

}
