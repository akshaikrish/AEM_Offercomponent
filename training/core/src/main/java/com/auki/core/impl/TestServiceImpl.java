package com.auki.core.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Reference;

import com.auki.core.services.TrainingIntf;

public class TestServiceImpl implements TrainingIntf{

	@Reference
	private ResourceResolverFactory resourceResolverFactory;
	
	@Override
	public String firstname() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String secondname() {
		final Map<String, Object> params = new HashMap();
		params.put(ResourceResolverFactory.SUBSERVICE, "test");
		
		ResourceResolver resourceResolver = null;
		
		try {
			resourceResolver = resourceResolverFactory.getServiceResourceResolver(params);
		}catch(LoginException e) {
			e.printStackTrace();
		}
		
		Resource resource = resourceResolver.getResource("/content/auki/CG");
		return resource.getResourceType();
	}
	
	

}
