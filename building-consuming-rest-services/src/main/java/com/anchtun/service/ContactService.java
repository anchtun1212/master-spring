package com.anchtun.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.anchtun.config.AnchtunProps;
import com.anchtun.constants.Constants;
import com.anchtun.model.Contact;
import com.anchtun.repository.ContactRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ContactService {

	@Autowired
	private ContactRepository contactRepository;
	
	// inject AnchtunProps bean
	@Autowired
	private AnchtunProps anchtunProps;

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
	
	// will get properties from AnchtunProps
	public Page<Contact> findByStatusPagination(int pageNum, String status) {
		// pageNum - 1: mean which page, first page = 0, 2: mean number row per page
		int pageSize = Integer.parseInt(anchtunProps.getContact().get("pageSize"));
		return contactRepository.findByStatus(status, PageRequest.of(pageNum - 1, pageSize, Sort.by("status").ascending()));
		// use native query 
		//return contactRepository.findByStatusNative(status, PageRequest.of(pageNum - 1, 3, Sort.by("status").ascending()));
	}
	
	// use pagination and dynamic sorting
	/*public Page<Contact> findByStatusPagination(int pageNum, String status) {
		// pageNum - 1: mean which page, first page = 0, 2: mean number row per page
		return contactRepository.findByStatus(status, PageRequest.of(pageNum - 1, 2, Sort.by("status").ascending()));
		// use native query 
		//return contactRepository.findByStatusNative(status, PageRequest.of(pageNum - 1, 3, Sort.by("status").ascending()));
	}*/

	//@Transactional: added on repository
	// updatedBy will be handled by spring data jpa -auditing
	//public boolean updateMsgStatus(int contactId, String updatedBy) {
	public boolean updateMsgStatus(int contactId) {
		boolean isUpdated = false;
		
		String connectedUser = SecurityContextHolder.getContext().getAuthentication().getName();
		int result = contactRepository.updateStatus(Constants.CLOSE, connectedUser, LocalDateTime.now(), contactId);
		
		// updatedBy will be handled by spring data jpa -auditing
		// this will use save method that auto use auditing
		//Contact result = null;
		//Optional<Contact> contact = contactRepository.findById(contactId);
		//contact.ifPresent(c -> {
		//	contact.get().setStatus(Constants.CLOSE);
		//	contactRepository.save(contact.get());
		//});
		
		if (result > 0) {
			isUpdated = true;
			log.info("Contact updated !!!");
		}
		return isUpdated;
	}
	
	public void deleteById(int id) {
		contactRepository.deleteById(id);
	}

	public Optional<Contact> findById(int id) {
		return contactRepository.findById(id);
	}

	public void saveContactDefault(Contact contact) {
		contactRepository.save(contact);
	}
}
