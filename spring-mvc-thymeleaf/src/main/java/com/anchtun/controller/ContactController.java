package com.anchtun.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController {

	Logger log = LoggerFactory.getLogger(ContactController.class);

	@RequestMapping("/contact")
	public String homePage(Model model) {
		return "contact.html";
	}

	@RequestMapping(value = "/saveMsg", method = RequestMethod.POST)
	public ModelAndView saveMsg(@RequestParam String fullName, @RequestParam String mobile,
			@RequestParam String subject) {
		log.info("fullName=" + fullName);
		log.info("mobile=" + mobile);
		log.info("subject=" + subject);
		return new ModelAndView("redirect:/contact");
	}
}
