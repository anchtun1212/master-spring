package com.anchtun.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	// RequestMethod are GET & POST because this method will be used for login & logout
	@RequestMapping(value = { "", "/", "/login" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String loginPage(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout,
			@RequestParam(value = "register", required = false) boolean register
			, Model model) {
		String errorMessage = null;
		String successMessage = null;
		if (error != null) {
			errorMessage = "Wrong credentials - userName or password are incorrect!";
		}
		if (logout != null) {
			errorMessage = "You are logged out successfully!";
		}
		if (register) {
			successMessage = "Your account was created successfully!";
		}
		model.addAttribute("errorMessage", errorMessage);
		model.addAttribute("successMessage", successMessage);
		return "login.html";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout=true";
	}
}
