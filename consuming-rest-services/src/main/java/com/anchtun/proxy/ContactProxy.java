package com.anchtun.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.anchtun.configuration.AnchtunConfiguration;
import com.anchtun.model.Contact;

// like spring data jpa you simply need to declare abstract method then call it
// name :you can set anything
// url: base url to consume
// configuration: contains beans and configuration required by feign client
@FeignClient(name = "contact", url = "http://localhost:8080/api/contact", configuration = AnchtunConfiguration.class)
public interface ContactProxy {
	
	// same signature as the REST API you want to consume
	@GetMapping("/getMessageByStatus")
	// default by spring you can comment it
	//@Headers(value = "Content-Type: application/json")
	public List<Contact> getMessagesByStatus(@RequestHeader("Authorization") String header, 
			@RequestParam(name = "status") String status);

}
