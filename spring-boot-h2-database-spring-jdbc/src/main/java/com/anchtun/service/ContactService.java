package com.anchtun.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anchtun.constants.Constants;
import com.anchtun.model.Contact;
import com.anchtun.repository.ContactRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ContactService {

	@Autowired
	private ContactRepository contactRepository;

	public ContactService() {
		log.info("Contact service Bean initialized");
	}

	public boolean saveContact(Contact contact) {
		boolean isSaved = false;
		contact.setStatus(Constants.OPEN);
		contact.setCreatedBy(Constants.ANONYMOUS);
		contact.setCreatedAt(LocalDateTime.now());
		int result = contactRepository.saveContactMsg(contact);
		if (result > 0) {
			isSaved = true;
		}
		return isSaved;
	}

	public List<Contact> findMsgsByStatus(String status) {
		return contactRepository.findMsgsByStatus(status);
	}

	public boolean updateMsgStatus(int contactId, String updatedBy) {
		boolean isUpdated = false;
		int result = contactRepository.updateMsgStatus(contactId, updatedBy, Constants.CLOSE);
		if (result > 0) {
			isUpdated = true;
		}
		return isUpdated;
	}

}
