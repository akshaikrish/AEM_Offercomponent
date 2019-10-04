package com.auki.core.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.inject.Inject;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.resource.ValueMap;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.auki.core.models.OfferModel;
import com.auki.core.services.OfferInterface;
import com.day.cq.wcm.api.Page;

@Component(service = OfferInterface.class, immediate = true)
public class OfferService implements OfferInterface {
	
	@Reference
	private ResourceResolverFactory resourceResolverFactory;
	
	
	
	
	private String child;

	public String getChild() {
		return child;
	}

	public void setChild(String child) {
		this.child = child;
	}

	@Override
	public ArrayList<OfferModel> offerlisting() {
		ArrayList<OfferModel> offerList = new ArrayList<>();
		final Map<String, Object> params = new HashMap();
		params.put(ResourceResolverFactory.SUBSERVICE, "test");
		
		ResourceResolver resourceResolver = null;
		
		try {
			resourceResolver = resourceResolverFactory.getServiceResourceResolver(params);
		}catch(LoginException e) {
			e.printStackTrace();
		}
		
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
	 return offerList;
		
	}

	

}
