package com.anchtun.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.anchtun.model.Contact;

/**
 * @Repository: stereotype annotation is used to add a bean of this class type
 *              to the Spring context and indicate that given bean is used to
 *              perform DB related operations
 */
@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer> {

	List<Contact> findByStatus(String status);

	@Modifying
	@Query("update Contact c set c.status = ?1, c.updatedBy = ?2 where c.contactId = ?3")
	int updateStatus(String status, String updatedBy, int contactId);
	
	// use pagination and dynamic sorting
	Page<Contact> findByStatus(String status, Pageable pageable);

}
