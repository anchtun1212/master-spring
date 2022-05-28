package com.anchtun.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
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

	// Don't forgot to add @Transactional
	@Transactional
	@Modifying
	// we remove @Query because its defined in Contact class: @NamedQueries
	//@Query("update Contact c set c.status = ?1, c.updatedBy = ?2, c.updatedAt = ?3 where c.contactId = ?4")
	int updateStatus(String status, String updatedBy, LocalDateTime updatedAt, int contactId);
	
	// use pagination and dynamic sorting
	//Page<Contact> findByStatus(String status, Pageable pageable);
	
	// custom query
	// you can use native query by mention nativeQuery = true, but not recommended: use native
	// queries only for very complex queries otherwise keep it default mean NamedQyery that uses JPQL
	// we remove @Query because its defined in Contact class: @NamedQueries
	//@Query(nativeQuery = true, value = "select * from contact_msg c where c.status = ?1 order by c.created_at desc")
	Page<Contact> findByStatusNative(@Param("status") String sts, Pageable pageable);

	// we remove @Query because its defined in Contact class: @@NamedNativeQueries
	//@Query("select c from Contact c where c.status = :status order by createdAt desc")
	// you ca use alo this
	//@Query("select c from Contact c where c.status = ?1 order by createdAt desc")
	//Page<Contact> findByStatus(String status, Pageable pageable);
	// you can use this also if the attribute name in the method is different than the query param name
	Page<Contact> findByStatus(@Param("status") String sts, Pageable pageable);

}
