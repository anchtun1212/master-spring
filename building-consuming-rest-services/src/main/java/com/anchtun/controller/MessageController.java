package com.anchtun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	// updatedBy will be handled by spring data jpa -auditing
	// public String closeMsg(@RequestParam int id, Authentication authentication) {
	public String closeMsg(@RequestParam int id) {
		// contactService.updateMsgStatus(id, authentication.getName());
		contactService.updateMsgStatus(id);
		return ("redirect:/messages");
	}
	
	@RequestMapping("/displayMessages/page/{pageNum}")
	public ModelAndView displayMessages(Model model, @PathVariable("pageNum") int pageNum) {
		// use pagination and dynamic sorting
		Page<Contact> contactMsgsPage = contactService.findByStatusPagination(pageNum, Constants.OPEN);
		List<Contact> contactMsgs = contactMsgsPage.getContent();
		ModelAndView modelAndView = new ModelAndView("messagespagination.html");
		modelAndView.addObject("contactMsgs", contactMsgs);
		modelAndView.addObject("currentPage", pageNum);
		modelAndView.addObject("totalPages", contactMsgsPage.getTotalPages());
		return modelAndView;
	}
	
	@GetMapping("/closeMsgPage")
	public String closeMsgPage(@RequestParam int id) {
		contactService.updateMsgStatus(id);
		// return first page
		return ("redirect:/displayMessages/page/1");
	}
}
