package com.anchtun.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
/**
 * 
 * Please run the application then try to change the web scopes @RequestScope, @SessionScope, @ApplicationScope
 * and see the log: log.info("Number of contact submitted:" + contactService.getCounter()); in ContactController class
 * you will understand
 */
//@RequestScope
//@SessionScope
@ApplicationScope
@Data
public class ContactService {

	private int counter = 0;
	
	public ContactService() {
		log.info("Contact service Bean initialized");
	}
	
	public void saveContact() {
		log.info("Contact saved successfully");
	}

}
