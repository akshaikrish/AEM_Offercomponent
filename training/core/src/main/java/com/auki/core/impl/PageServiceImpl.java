package com.auki.core.impl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import java.util.HashMap;
import java.util.Map;

import javax.jcr.Node;
import javax.jcr.Session;

import org.apache.jackrabbit.commons.JcrUtils;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;

import com.auki.core.services.OfferServletIntf;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
 
 
@Component(service = OfferServletIntf.class, immediate=true)
public class PageServiceImpl implements OfferServletIntf {
     
	private String user = "";
	
	private Session session;
	
    //Inject a Sling ResourceResolverFactory
    @Reference
    private ResourceResolverFactory resourceResolverFactory;
     
     
    public String createPage(String pageName, String validity, String description, String fileReference) 
    {
    String pagePath = "/content/auki/cg";
    String templatePath = "/conf/auki/settings/wcm/templates/offer-template";
    String pageTitle = pageName;
    PageManager pageManager;
    Page newPage;
    
    final Map<String, Object> params = new HashMap();
	params.put(ResourceResolverFactory.SUBSERVICE, "test");
	
	ResourceResolver resourceResolver = null;
	
	try {
		resourceResolver = resourceResolverFactory.getServiceResourceResolver(params);
	}catch(LoginException e) {
		e.printStackTrace();
	}
    
     
    
       
    try {
                  
        //Invoke the adaptTo method to create a Session 
//        resolver = resolverFactory.getAdministrativeResourceResolver(null);
         
    	session = resourceResolver.adaptTo(Session.class);
                 
        //create a page manager instance
        pageManager = resourceResolver.adaptTo(PageManager.class); 
         
        newPage = pageManager.create(pagePath, pageName, templatePath, pageTitle);
      
         
        if (newPage != null) {
        	Node newNode = newPage.adaptTo(Node.class);
        	Node cont = newNode.getNode("jcr:content");
        	Node offerNode = JcrUtils.getNodeIfExists(cont, "root/offerLayout");
        	offerNode.setProperty("validity", validity);
        	offerNode.setProperty("description", description);
        	offerNode.setProperty("fileReference", fileReference);
        	session.save();
        }
        return pageName;
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
     
    return ""  ; 
 
}
 
}
