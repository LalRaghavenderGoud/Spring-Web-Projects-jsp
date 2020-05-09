package com.raghav.springweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

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

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	public void create(Offers offer) {
		offerDao.createOffer(offer);

	}

	public Offers throwTestException() {
		return offerDao.getOffers(9999);

	}

	public boolean hasOffer(String username) {
		if (username == null) {
			return false;
		}
		List<Offers> offers = offerDao.getOffers(username);
		if (offers.size() == 0) {
			return false;
		}
		return true;
	}

	public Offers getOffer(String username) {
		if (username == null) {
			return null;
		}
		List<Offers> offers = offerDao.getOffers(username);
		if (offers.size() == 0) {
			return null;
		}
		return offers.get(0);
	}

	public void saveOrUpdate(Offers offer) {
		if (offer.getId() != 0) {
			offerDao.updateOffer(offer);
		} else {
			offerDao.createOffer(offer);
		}

	}

	public void deleteOffer(int id) {
		offerDao.deleteOffer(id);

	}

	public List<Offers> getOffers(String username) {
		List<Offers> offers = offerDao.getOffers(username);
		return offers;
	}

}
