package com.raghav.springweb.controllers;

import java.security.Principal;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.raghav.springweb.dao.Offers;
import com.raghav.springweb.service.OffersService;

@Controller
public class HomeController {

	private static Logger logger = Logger.getLogger(HomeController.class);
	@Autowired
	private OffersService offersService;

	@RequestMapping("/")
	public String showHome(Model model, Principal principal) {
		logger.info("Raghav:: Logging Home controller");

		List<Offers> offers = offersService.getCurrent();
		model.addAttribute("offers", offers);
		boolean hasOffers = false;

		if (principal != null) {
			hasOffers = offersService.hasOffer(principal.getName());
		}
		model.addAttribute("hasOffers", hasOffers);
		
		return "home";
	}

}
