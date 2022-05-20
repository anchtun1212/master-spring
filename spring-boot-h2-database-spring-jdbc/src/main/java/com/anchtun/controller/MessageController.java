package com.anchtun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.anchtun.constants.Constants;
import com.anchtun.model.Contact;
import com.anchtun.service.ContactService;

@Controller
public class MessageController {

	@Autowired
	private ContactService contactService;

	@RequestMapping("/messages")
	public ModelAndView mesagesPage(Model model) {
		List<Contact> contactMsgs = contactService.findMsgsByStatus(Constants.OPEN);
		ModelAndView modelAndView = new ModelAndView("messages.html");
		modelAndView.addObject("contactMsgs", contactMsgs);
		return modelAndView;
	}

	@GetMapping("/closeMsg")
	public String closeMsg(@RequestParam int id, Authentication authentication) {
		contactService.updateMsgStatus(id, authentication.getName());
		return ("redirect:/messages");
	}
}
