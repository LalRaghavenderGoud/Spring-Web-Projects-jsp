
package com.raghav.springweb.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.raghav.springweb.dao.Offers;
import com.raghav.springweb.dao.User;
import com.raghav.springweb.service.OffersService;
import com.raghav.springweb.service.UsersService;

@Controller
public class LoginController {

	@Autowired
	private UsersService usersService;
	
	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private OffersService offersService;

	@RequestMapping("/login")
	public String showLogin() {
		return "login";
	}

	@RequestMapping("/logout")
	public String showLoggedOut() {
		return "logout";
	}

	@RequestMapping("/denied")
	public String showDenied() {
		return "denied";
	}
	@RequestMapping("/offerRefresh")
	public String showOfferRefresh() {
		return "offerRefresh";
	}
	
	@RequestMapping("/admin")
	public String showAdmin(Model model) {

		List<User> users = usersService.getAllUsers();

		model.addAttribute("users", users);

		return "admin";
	}

	@RequestMapping("/newaccount")
	public String showNewAccount(Model model) {
		model.addAttribute("user", new User());
		return "newaccount";
	}

	@RequestMapping("/createaccount")
	public String createAccount() {
		return "accountcreated";
	}

	@RequestMapping(value = "/createaccount", method = RequestMethod.POST)
	public String doCreate(@Validated User user, BindingResult result) {

		if (result.hasErrors()) {

			return "newaccount";
		}

		user.setAuthority("ROLE_USER");
		user.setEnabled(true);

		if (usersService.exists(user.getUsername())) {
			result.rejectValue("username", "DuplicateKey.user.username");
			return "newaccount";
		}

		try {
			usersService.create(user);
		} catch (DuplicateKeyException e) {
			result.rejectValue("username", "DuplicateKey.user.username");
			return "newaccount";
		}
		return "accountcreated";
	}
	
	@RequestMapping(value = "/getoffers",method = RequestMethod.GET,produces = "application/json")
	@ResponseBody
	public Map<String,Object> getOffers(Principal principal){
		
		List<Offers> offers = new ArrayList<Offers>();
		
		if(principal == null) {
			offers = new ArrayList<Offers>();
		}else {
			String username = principal.getName();
			
			offers = offersService.getOffers(username);

		}
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("offers", offers);
		data.put("number",offers.size());
		return data;
	}
	
	@RequestMapping("/sendemail")
	public String sendEmail() {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setFrom("raghavenderlal@gmail.com");
		mail.setTo("raghavenderlal@gmail.com");
		//mail.setTo("venki255@gmail.com");
		mail.setSubject("Raghav's Spring Project");
		mail.setText("Hi There!"+ "\n \n" + "This is test email from Raghav Spring Project"+"\n \n \n"+"Regards," +"\n"+"Raghav.");
		
		try {
			mailSender.send(mail);
			System.out.println("Mail Successfully Sent To"+ mail.getTo());
		} catch (MailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "mailsent";
	}
}
