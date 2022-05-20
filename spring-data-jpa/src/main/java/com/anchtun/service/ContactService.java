package com.anchtun.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

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
		contact.setCreatedBy(Constants.ANONYMOUS);
		contact.setCreatedAt(LocalDateTime.now());
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
	public boolean updateMsgStatus(int contactId, String updatedBy) {
		boolean isUpdated = false;
		int result = contactRepository.updateStatus(Constants.CLOSE, updatedBy, contactId);
		if (result > 0) {
			isUpdated = true;
			log.info("Contact updated !!!");
		}
		return isUpdated;
	}

}
