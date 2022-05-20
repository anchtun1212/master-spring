package com.anchtun.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.anchtun.model.Contact;
import com.anchtun.service.ContactService;

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

	private final ContactService contactService;
	
	// no need to add @Autowired because there is only one constructor
	public ContactController(ContactService contactService) {
		this.contactService = contactService;
	}
	
	/**
	 * will be replaced by @Slf4j annotation
	 */
	//public static Logger log = LoggerFactory.getLogger(ContactController.class);

	@RequestMapping("/contact")
	public String homePage(Model model) {
		// add this line to use this attribute for validation
		Contact contact = new Contact();
		model.addAttribute("contact", contact);
		return "contact.html";
	}

	/**
	 * 
	 * send data using @RequestParam
	 */
	@RequestMapping(value = "/saveMsg", method = RequestMethod.POST)
	public ModelAndView saveMsg(@RequestParam String fullName, 
			@RequestParam String email,
			@RequestParam String mobile,
			@RequestParam String subject) {
		log.info("fullName=" + fullName);
		log.info("email=" + email);
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
	/**
	 * @Valid to tell spring that we need to validate Contact object based on the validation annotation configurations
	 * For any issues, spring populates the error details inside the Errors object
	 * @ModelAttribute("contact") to catch the error from the UI: error: ${#fields.errors('contact.*')}
	 */
	public String saveMsg2(@Valid @ModelAttribute("contact") Contact contact, Errors errors) {
		if (errors.hasErrors()) {
			log.error("Contact form validation failed due to: " + errors.toString());
			return ("contact.html");
		}
		
		contactService.saveContact(contact);

		return ("redirect:/contact");
	}
}
