package com.anchtun.controller;

import java.util.Objects;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.anchtun.model.Address;
import com.anchtun.model.Person;
import com.anchtun.model.Profile;
import com.anchtun.service.PersonService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// rename it to: "userProfileController" to not confuse with profileController provided by spring data REST
@Controller(value = "userProfileController")
public class ProfileController {
	
	@Autowired
	private PersonService personService;

	@GetMapping("/userProfile")
	public String goToProfile(Model model, HttpSession httpSession) {
		Person person = (Person) httpSession.getAttribute("personLoggedIn");
		Profile profile = Profile.builder().name(person.getName()).mobileNumber(person.getMobileNumber())
				.email(person.getEmail()).build();
		if (Objects.nonNull(person.getAddress())) {
			profile.setAddress1(person.getAddress().getAddress1());
			profile.setAddress2(person.getAddress().getAddress2());
			profile.setCity(person.getAddress().getCity());
			profile.setState(person.getAddress().getState());
			profile.setZipCode(person.getAddress().getZipCode());
		}
		model.addAttribute("profile", profile);
		return "profile.html";
	}
	
	@PostMapping(value = "/updateprofile")
	public String savePerson(@Valid @ModelAttribute("profile") Profile profile, Errors errors, HttpSession httpSession) {
		if (errors.hasErrors()) {
			log.error("Error occured during update profile: " + errors.toString());
			return ("profile.html");
		}

		Person person = (Person) httpSession.getAttribute("personLoggedIn");
		person.setName(profile.getName());
		person.setEmail(profile.getEmail());
		person.setMobileNumber(profile.getMobileNumber());
		if (Objects.isNull(person.getAddress())) {
			person.setAddress(new Address());
		}
		person.getAddress().setAddress1(profile.getAddress1());
		person.getAddress().setAddress2(profile.getAddress2());
		person.getAddress().setCity(profile.getCity());
		person.getAddress().setState(profile.getState());
		person.getAddress().setZipCode(profile.getZipCode());
		
		personService.savePersonDefault(person);

		return ("redirect:/userProfile");
	}

}
