package com.anchtun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping(value = { "", "/", "home" })
	// Model in an interface inside spring mvc which will act as an container
	// between UI and backend code
	public String homePage(Model model) {
		model.addAttribute("userName", "Anchtun");
		return "home.html";
	}

}
