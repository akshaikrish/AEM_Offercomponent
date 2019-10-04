package com.auki.core.models;


import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import com.auki.core.services.OfferInterface;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class OfferListWithService {
	
	@Inject
	private OfferInterface offer;
	
	private ArrayList<OfferModel> offers = new ArrayList<>();
	
	@PostConstruct
	protected void init() {
		
		offers = offer.offerlisting();
		
	}

	public ArrayList<OfferModel> getOffers() {
		return offers;
	}

	public void setOffers(ArrayList<OfferModel> offers) {
		this.offers = offers;
	}
	

	
}
