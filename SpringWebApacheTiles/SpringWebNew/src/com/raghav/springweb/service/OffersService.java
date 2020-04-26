package com.raghav.springweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.raghav.springweb.dao.OfferDao;
import com.raghav.springweb.dao.Offers;

@Service("offersService")
public class OffersService {

	
	private OfferDao offerDao;

	@Autowired
	public void setOfferDao(OfferDao offerDao) {
		this.offerDao = offerDao;
	}

	public List<Offers> getCurrent() {
		return offerDao.getOffers();
	}

	@Secured({"ROLE_ADMIN" , "ROLE_USER"})
	public void create(Offers offer) {
		offerDao.createOffer(offer);
		
	}

	public Offers throwTestException() {
		return offerDao.getOffers(9999);
		
	}

}
