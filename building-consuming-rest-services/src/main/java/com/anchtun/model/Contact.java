package com.anchtun.model;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;
/**
 * By Default spring data jpa uses Hibernate as an implementation of JPA specification
 */

@Data
@Entity
@Table(name = "contact_msg")
// For bigger applications where they may have 1000s of queries scatted across the application, it would be better
// to group them in a single place for more readability and maintenance purpose
// using @NamedQueries and @NamedNativeQueries
// so spring data jpa try to fetch by name in the repository interface and we can remove @Query from the repository interface
@NamedQueries({
		@NamedQuery(name = "Contact.findByStatus", 
		            query = "select c from Contact c where c.status = :status order by createdAt desc"),
		@NamedQuery(name = "Contact.updateStatus", 
        		    query = "update Contact c set c.status = ?1, c.updatedBy = ?2, c.updatedAt = ?3 where c.contactId = ?4")
})
// for named queries there is problem when using pagination so need to implement like this
@SqlResultSetMappings({
    @SqlResultSetMapping(name = "SqlResultSetMapping.count", columns = @ColumnResult(name = "cnt"))
})
@NamedNativeQueries({
		@NamedNativeQuery(name = "Contact.findByStatusNative",
				          query = "select * from contact_msg c where c.status = ?1 order by c.created_at desc",
				          resultClass = Contact.class
				),
		// we need to fetch the count in order to use pagination: Pageable
		@NamedNativeQuery(name = "Contact.findByStatusNative.count",
				          query = "select count(*) as cnt from contact_msg c where c.status = ?1",
				          resultSetMapping = "SqlResultSetMapping.count")
})
public class Contact extends BaseEntity {

	@Id
	@Column(name = "contact_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int contactId;

	@NotBlank(message = "Name must not be blank")
	@Size(min = 3, message = "Name must have at least 3 characters")
	@Column(name = "name")
	private String fullName2;
	
	@NotBlank(message = "Mobile must not be blank")
	@Pattern(regexp = "^([+]\\d{2})?\\d{10}$", message = "Mobile should be like this: Ex: +966123456789 or 0123456789")
	@Column(name = "mobile_num")
	private String mobile2;
	
	@NotBlank(message = "Subject must not be blank")
	@Size(min = 7, message = "Subject must have at least 7 characters")
	@Column(name = "subject")
	private String subject2;
	
	@NotBlank(message = "Email must not be blank")
	@Email(message = "Please enter a valid email")
	@Column(name = "email")
	private String email2;
	
	// mean message open or close
	private String status;

	@Override
	public String toString() {
		return "Contact [fullName=" + fullName2 + ", email=" + email2 + ", mobile=" + mobile2 + ", subject=" + subject2 + "]";
	}
}
