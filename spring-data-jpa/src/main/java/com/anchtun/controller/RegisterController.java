package com.anchtun.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.anchtun.model.Person;
import com.anchtun.service.PersonService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
// prefix: mean will handle all requests: /public/.. example: /public/register
@RequestMapping("public")
public class RegisterController {
	
	@Autowired
	private PersonService personService;

	@GetMapping("/register")
	public String registerPage(Model model) {
		Person person = new Person();
		model.addAttribute("person", person);
		return "register.html";
	}
	
	@RequestMapping(value = "/createuser", method = RequestMethod.POST)
	public String savePerson(@Valid @ModelAttribute("person") Person person, Errors errors) {
		if (errors.hasErrors()) {
			log.error("Register form validation failed due to: " + errors.toString());
			return ("register.html");
		}
		
		personService.savePerson(person);

		return ("redirect:/login?register=true");
	}
}
