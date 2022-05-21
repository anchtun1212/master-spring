package com.anchtun.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import com.anchtun.constants.Constants;
import com.anchtun.model.Contact;
import com.anchtun.repository.ContactRepository;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@ApplicationScope
@Data
public class ContactService {

	@Autowired
	private ContactRepository contactRepository;

	public ContactService() {
		log.info("Contact service Bean initialized");
	}

	public boolean saveContact(Contact contact) {
		boolean isSaved = false;
		contact.setStatus(Constants.OPEN);
		// will be handled by spring data jpa -auditing
		// contact.setCreatedBy(Constants.ANONYMOUS);
		// will be handled by spring data jpa -auditing
		// contact.setCreatedAt(LocalDateTime.now());
		Contact result = contactRepository.save(contact);
		if (Objects.nonNull(result) && result.getContactId() > 0) {
			isSaved = true;
		}
		return isSaved;
	}

	public List<Contact> findMsgsByStatus(String status) {
		return contactRepository.findByStatus(status);
	}

	@Transactional
	// updatedBy will be handled by spring data jpa -auditing
	//public boolean updateMsgStatus(int contactId, String updatedBy) {
	public boolean updateMsgStatus(int contactId) {
		boolean isUpdated = false;
		// updatedBy will be handled by spring data jpa -auditing
		// int result = contactRepository.updateStatus(Constants.CLOSE, updatedBy, contactId);
		
		Contact result = null;
		Optional<Contact> contact = contactRepository.findById(contactId);
		contact.ifPresent(c -> {
			contact.get().setStatus(Constants.CLOSE);
			contactRepository.save(contact.get());
		});

		if (Objects.nonNull(result)) {
			isUpdated = true;
			log.info("Contact updated !!!");
		}
		return isUpdated;
	}

}
