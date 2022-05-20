package com.anchtun.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	/*@RequestMapping(value = "/home")
	// Model in an interface inside spring mvc which will act as an container
	// between UI and backend code
	// old method
	public String homePage(Model model) {
		model.addAttribute("userName", "Brother/Sister");
		return "home.html";
	}*/
	
	@RequestMapping(value = "/home")
	public String homePage(Authentication auth, Model model) {
		model.addAttribute("userName", auth.getName());
		model.addAttribute("roles", auth.getAuthorities().toString());
		return "home.html";
	}
	
	@RequestMapping(value = "/nullPointerException")
	public String homeNullPointerPage() {
		throw new NullPointerException("NullPointerException happened! Please check your data!");
	}
	
	@RequestMapping(value = "/illegalArgumentException")
	public String homeIllegalArgsPage() {
		throw new IllegalArgumentException("IllegalArgumentException happened! Please check your data!");
	}

}
