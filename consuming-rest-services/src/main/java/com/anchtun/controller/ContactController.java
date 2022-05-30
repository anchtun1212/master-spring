package com.anchtun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.anchtun.model.Contact;
import com.anchtun.model.Response;
import com.anchtun.proxy.ContactProxy;

import reactor.core.publisher.Mono;

@RestController
public class ContactController {

	@Autowired
	private ContactProxy contactProxy;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient webClient;

	@GetMapping("/getMessages")
	public List<Contact> listContacts(@RequestParam String status) {
		String username = "anchtun@gmail.com";
		String password = "pass12345678";

		byte[] encodedBytes = Base64Utils.encode((username + ":" + password).getBytes());

		String authHeader = "Basic " + new String(encodedBytes);
		return contactProxy.getMessagesByStatus(authHeader, status);
	}
	
	@PostMapping("/saveMessage")
	public ResponseEntity<Response> saveMessage(@RequestBody Contact contact) {
		String uri = "http://localhost:8080/api/contact/saveMessage";
		HttpHeaders headers = new HttpHeaders();
		headers.add("callerApp", "RestTemplate");
		HttpEntity<Contact> httpEntity = new HttpEntity<>(contact, headers);
		ResponseEntity<Response> responseEntity = restTemplate.exchange(uri, HttpMethod.POST, httpEntity, Response.class);
		return responseEntity;
	}
	
	@PostMapping("/saveMessageWC")
	// Mono is a class inside reactive module which can be use whenever we want to store a single element
	public Mono<Response> saveMessageWC(@RequestBody Contact contact) {
		String uri = "http://localhost:8080/api/contact/saveMessage";
		return webClient.post().uri(uri)
				.header("callerApp", "RestTemplate")
				.body(Mono.just(contact), Contact.class)
				.retrieve()
				.bodyToMono(Response.class);
	}

}
