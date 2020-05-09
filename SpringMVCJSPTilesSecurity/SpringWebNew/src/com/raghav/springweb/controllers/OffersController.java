package com.raghav.springweb.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.raghav.springweb.dao.Offers;
import com.raghav.springweb.service.OffersService;

@Controller
public class OffersController {

	private OffersService offersService;

	@Autowired
	public void setOffersService(OffersService offersService) {
		this.offersService = offersService;
	}

	@RequestMapping("/offers")
	public String showHome(Model model) {

		// offersService.throwTestException();
		List<Offers> offers = offersService.getCurrent();

		model.addAttribute("offers", offers);

		return "offers";
	}

	@RequestMapping("/createoffer")
	public String createOffer(Model model, Principal principal) {
		Offers offer = null;
		if (principal != null) {
			String username = principal.getName();
			offer = offersService.getOffer(username);
		}
		if (ObjectUtils.isEmpty(offer)) {
			model.addAttribute("offers", new Offers());
		} else {
			model.addAttribute("offers", offer);
		}

		return "createoffer";
	}

	@RequestMapping(value = "/docreate", method = RequestMethod.POST)
	public String doCreate(Model model, @Validated Offers offer, BindingResult result, Principal principal,
			@RequestParam(value = "delete", required = false) String delete) {

		if (result.hasErrors()) {
			return "createoffer";

			/*
			 * System.out.println("Form has errors"); List<ObjectError> objectError =
			 * result.getAllErrors(); for (ObjectError error : objectError) {
			 * System.out.println(error.getDefaultMessage()); }
			 */
		}
		if (delete == null) {
			String username = principal.getName();
			offer.getUser().setUsername(username);
			offersService.saveOrUpdate(offer);

			return "offercreated";
		} else {
			offersService.deleteOffer(offer.getId());
			return "offerdeleted";
		}

	}

	/*
	 * @ExceptionHandler(DataAccessException.class) public String
	 * handleDataAccesExceptions(DataAccessException ex) { return "error"; }
	 */

	/*
	 * @RequestMapping("/") public ModelAndView showHome() {
	 * 
	 * ModelAndView mv = new ModelAndView("home");
	 * 
	 * Map<String, Object> model = mv.getModel();
	 * 
	 * model.put("name", "<b>Lal</b>");
	 * 
	 * return mv;
	 * 
	 * }
	 */
	/*
	 * public String showHome(HttpSession session) {
	 * 
	 * session.setAttribute("name", "Raghav"); return "home"; }
	 */

}
