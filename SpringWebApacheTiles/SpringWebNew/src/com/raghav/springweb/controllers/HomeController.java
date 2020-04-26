package com.raghav.springweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String showHome(Model model) {

		return "home";
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String showtest(Model model, @RequestParam("id") String id) {
		System.out.println("Id Is:" + id);
		return "home";
	}
}
