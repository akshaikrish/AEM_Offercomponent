package com.auki.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.osgi.framework.Constants;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.auki.core.services.OfferServletIntf;

@Component(service=Servlet.class,
property= {
		Constants.SERVICE_DESCRIPTION + "= Demo Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_POST ,
        "sling.servlet.paths=" + "/bin/offer",
        "sling.servlet.extensions=" + "json"
}
	)
public class DemoServlet extends SlingAllMethodsServlet{

	private static final long serialVersionUID = 1L;
	
	@Reference
	private OfferServletIntf offerServlet;

//	@Override
//    protected void doGet(final SlingHttpServletRequest req,
//            final SlingHttpServletResponse resp) throws ServletException, IOException {
//		JSONObject obj=new JSONObject();
//		try {
//			obj.put("test","testValue");
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		resp.setContentType("application/json");
//		resp.setCharacterEncoding("utf-8");	
//		if(req.getParameter("q").equalsIgnoreCase("testing")) {
//
//			resp.getWriter().write(obj.toString());
//		}
//
//	}
	
	protected void doPost(final SlingHttpServletRequest req,
            final SlingHttpServletResponse resp) throws ServletException, IOException {
		String pageName = req.getParameter("pagename");
		String validity = req.getParameter("validity");
		String description = req.getParameter("description");
		String fileReference = req.getParameter("fileReference");
		offerServlet.createPage(pageName,validity,description,fileReference);
		
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		
		JSONObject obj=new JSONObject();
		try {
			obj.put("pageName", pageName);
			obj.put("validity", validity);
			obj.put("description", description);
//			obj.put("date", fileReference);
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.getWriter().write(obj.toString());

		  	  

	}
	
}
