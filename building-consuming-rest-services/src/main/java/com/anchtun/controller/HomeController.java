package com.anchtun.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anchtun.model.Person;
import com.anchtun.service.PersonService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
	
	@Autowired
	private PersonService personService;
	
	@RequestMapping(value = "/home")
	public String homePage(Authentication auth, Model model, HttpSession httpSession) {
		// we set the email in the name in AnchtunUsernamePasswordAuthenticationProvider.authenticate
		Person person = personService.findPersonByEmail(auth.getName());
		model.addAttribute("userName", auth.getName());
		model.addAttribute("roles", auth.getAuthorities().toString());
		httpSession.setAttribute("personLoggedIn", person);
		
		// to check logging
		logMessages();
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
	
	// test logging
	private void logMessages() {
		log.error("Error message from Home page");
		log.warn("Warn message from Home page");
		log.info("Info message from Home page");
		log.debug("Debug message from Home page");
		log.trace("Trace message from Home page");
	}

}
