package com.anchtun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anchtun.model.Contact;
import com.anchtun.proxy.ContactProxy;

@RestController
public class ContactController {

	@Autowired
	private ContactProxy contactProxy;

	@GetMapping("/getMessages")
	public List<Contact> listContacts(@RequestParam String status) {
		String username = "anchtun@gmail.com";
		String password = "pass12345678";

		byte[] encodedBytes = Base64Utils.encode((username + ":" + password).getBytes());

		String authHeader = "Basic " + new String(encodedBytes);
		return contactProxy.getMessagesByStatus(authHeader, status);
	}

}
