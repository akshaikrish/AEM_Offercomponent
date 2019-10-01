package com.auki.core.impl;

import org.osgi.service.component.annotations.Component;
import com.auki.core.services.Secondinterface;

@Component( service = Secondinterface.class)
public class Secondserviceclass implements Secondinterface {

	
	
	@Override
	public String lastname() {
		// TODO Auto-generated method stub
		return "Krishna";
	}


}
