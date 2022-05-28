package com.anchtun.rest;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anchtun.model.Contact;
import com.anchtun.model.Response;
import com.anchtun.service.ContactService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
//use Spring MVC style: @Controller + @ResponseBody
//@Controller
// @RestController = @Controller + @ResponseBody
@RestController
// path prefix for rall contract endpoints
@RequestMapping(path = "/api/contact")
public class ContractRestController {

	@Autowired
	private ContactService contactService;

	@GetMapping("/getMessageByStatus")
	//@ResponseBody
	public List<Contact> getMessagesByStatus(@RequestParam(name = "status") String status) {
		return contactService.findMsgsByStatus(status);
	};

	@GetMapping("/getAllMessageByStatus")
	//@ResponseBody
	public List<Contact> getAllMessageByStatus(@RequestBody Contact contact) {
		if (Objects.nonNull(contact)) {
			return contactService.findMsgsByStatus(contact.getStatus());
		} else {
			return List.of();
		}

	};
	
	@PostMapping("/saveMessage")
	// add header: callerApp so you need to add this header when you call this endpoint
	public ResponseEntity<Response> saveMessage(@RequestHeader("callerApp") String callerApp,
											    @Valid @RequestBody Contact contact) {
		// you can write you business logic related to the request header
		log.info("callerApp= " + callerApp);
		contactService.saveContactDefault(contact);
		Response response = new Response();
		response.setCode(HttpStatus.OK.value());
		response.setMessage("Message saved successfully");
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.header("isSaved", "true")
				.body(response);
	}

	@DeleteMapping("/deleteMessage")
	// RequestEntity allow as to receive the request body, header in a HTTP request
	public ResponseEntity<Response> saveMessage(RequestEntity<Contact> requestEntity) {
		// get all headers
		HttpHeaders headers = requestEntity.getHeaders();
		headers.forEach((key, value) -> {
			log.info(String.format("Header '%s' = '%s'", 
					key,
					value.stream().collect(Collectors.joining("|"))
					));
		});
		Contact contact = requestEntity.getBody();
		contactService.deleteById(contact.getContactId());
		Response response = new Response();
		response.setCode(HttpStatus.OK.value());
		response.setMessage("Message deleted successfully");
		return ResponseEntity
				.status(HttpStatus.OK)
				.header("isDeleted", "true")
				.body(response);
	}
	
	// use @PatchMapping because we will update only one field
	@PatchMapping("/closeMessage")
	public ResponseEntity<Response> closeMessage(@RequestBody Contact contactReq) {
		Response response = new Response();
		Optional<Contact> contact = contactService.findById(contactReq.getContactId());
		if (contact.isPresent()) {
			contact.get().setStatus("CLOSE");
			contactService.saveContactDefault(contact.get());
		} else {
			response.setCode(HttpStatus.BAD_REQUEST.value());
			response.setMessage("Contact id invalid!");
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(response);
		}
		response.setCode(HttpStatus.OK.value());
		response.setMessage("Message closed successfully");
		return ResponseEntity
				.status(HttpStatus.OK)
				.header("isUpdated", "true")
				.body(response);
	}
	
}
