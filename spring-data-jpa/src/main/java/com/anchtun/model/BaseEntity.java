package com.anchtun.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
// indicates to spring data jpa that all the entities that extends this class please treat those fields as columns
@MappedSuperclass
// this tell spring data jpa: treat this BaseEntity as an entity that supports auditing inside my web application.
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
	
	// insertable = false mean not be included in the insert statement 
    /*insert 
    into
        contact_msg
        (created_at, created_by, email, name, mobile_num, status, subject) 
    values
        (?, ?, ?, ?, ?, ?, ?)*/
	@CreatedDate
	@Column(updatable = false)
	private LocalDateTime createdAt;

	@CreatedBy
	@Column(updatable = false)
	private String createdBy;

   // updatable = false mean not be included in the update statement 
   /*update
       contact_msg 
   set
       updated_at=?,
       updated_by=?,
       email=?,
       name=?,
       mobile_num=?,
       status=?,
       subject=? 
   where
       contact_id=?*/
	@LastModifiedDate
	@Column(insertable = false)
	private LocalDateTime updatedAt;

	@LastModifiedBy
	@Column(insertable = false)
	private String updatedBy;

}
