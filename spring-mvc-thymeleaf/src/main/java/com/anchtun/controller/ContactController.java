package com.anchtun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.anchtun.model.Contact;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @Slf4j annotation will replace this line of code:
 * public static Logger log = LoggerFactory.getLogger(ContactController.class);
 *
 */
@Slf4j
@Controller
public class ContactController {

	/**
	 * will be replaced by @Slf4j annotation
	 */
	//public static Logger log = LoggerFactory.getLogger(ContactController.class);

	@RequestMapping("/contact")
	public String homePage(Model model) {
		return "contact.html";
	}

	/**
	 * 
	 * send data using @RequestParam
	 */
	@RequestMapping(value = "/saveMsg", method = RequestMethod.POST)
	public ModelAndView saveMsg(@RequestParam String fullName, @RequestParam String mobile,
			@RequestParam String subject) {
		log.info("fullName=" + fullName);
		log.info("mobile=" + mobile);
		log.info("subject=" + subject);
		return new ModelAndView("redirect:/contact");
	}

	/**
	 * 
	 * send data using POJO class
	 * Spring boot will map the name in html with the name of Contact's attributes automatically
	 */
	@RequestMapping(value = "/saveMsg2", method = RequestMethod.POST)
	public ModelAndView saveMsg2(Contact contact) {
		log.info(contact.toString());
		return new ModelAndView("redirect:/contact");
	}
}
