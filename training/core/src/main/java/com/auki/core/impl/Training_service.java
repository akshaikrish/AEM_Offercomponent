package com.auki.core.impl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.auki.core.services.Secondinterface;
import com.auki.core.services.TrainingIntf;


@Component( service = TrainingIntf.class)
public class Training_service implements TrainingIntf{

	@Reference
	private Secondinterface second;
	
	public String firstname() {
		// TODO Auto-generated method stub
		return "Akshai";
	}
	
	public String secondname() {
		return second.lastname();
	}
}
